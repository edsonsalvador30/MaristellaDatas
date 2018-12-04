package blockly;

import cronapi.*;
import cronapi.rest.security.CronappSecurity;
import java.util.concurrent.Callable;

@CronapiMetaData(type = "blockly")
@CronappSecurity
public class BlocoData {

	public static final int TIMEOUT = 300;

	/**
	 *
	 * @param ValorCampo
	 * @return Var
	 */
	// BlocoData
	public static Var ExecData(Var ValorCampo) throws Exception {
		return new Callable<Var>() {

			private Var item = Var.VAR_NULL;
			private Var dataBanc = Var.VAR_NULL;
			private Var Basemudada = Var.VAR_NULL;

			public Var call() throws Exception {
				item = cronapi.conversion.Operations.stringToDate(cronapi.conversion.Operations.toString(ValorCampo),
						Var.valueOf("dd/MM/yyyy"));
				dataBanc = cronapi.database.Operations.query(Var.valueOf("app.entity.Controle_datas"),
						Var.valueOf("select c.inf_data from Controle_datas c"));
				Basemudada = cronapi.conversion.Operations.stringToDate(
						cronapi.conversion.Operations.toString(cronapi.list.Operations.getFirst(dataBanc)),
						Var.valueOf("dd/MM/yyyy"));
				System.out.println(item.getObjectAsString());
				System.out.println(Basemudada.getObjectAsString());
				if (Var.valueOf(item.compareTo(Basemudada) >= 0).getObjectAsBoolean()) {
					cronapi.util.Operations.callClientFunction(Var.valueOf("cronapi.screen.notify"),
							Var.valueOf("warning"),
							Var.valueOf("Data informada está acima da Data Limitada pelo Sistema"));
				} else {
					cronapi.util.Operations.callClientFunction(Var.valueOf("cronapi.screen.notify"),
							Var.valueOf("success"), Var.valueOf("Data Liberada pelo Sistema"));
				}
				return Var.VAR_NULL;
			}
		}.call();
	}

}
