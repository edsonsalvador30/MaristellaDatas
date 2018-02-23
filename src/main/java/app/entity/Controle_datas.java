package app.entity;

import java.io.*;
import javax.persistence.*;
import java.util.*;
import javax.xml.bind.annotation.*;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonFilter;
import cronapi.rest.security.CronappSecurity;


/**
 * Classe que representa a tabela CONTROLE_DATAS
 * @generated
 */
@Entity
@Table(name = "\"CONTROLE_DATAS\"")
@XmlRootElement
@CronappSecurity
@JsonFilter("app.entity.Controle_datas")
public class Controle_datas implements Serializable {

  /**
   * UID da classe, necessário na serialização
   * @generated
   */
  private static final long serialVersionUID = 1L;

  /**
   * @generated
   */
  @Id
  @Column(name = "id", nullable = false, insertable=true, updatable=true)
  private java.lang.String id = UUID.randomUUID().toString().toUpperCase();

  /**
  * @generated
  */
  @Temporal(TemporalType.DATE)
  @Column(name = "inf_data", nullable = true, unique = false, insertable=true, updatable=true)
  
  private java.util.Date inf_data;

  /**
   * Construtor
   * @generated
   */
  public Controle_datas(){
  }


  /**
   * Obtém id
   * return id
   * @generated
   */
  
  public java.lang.String getId(){
    return this.id;
  }

  /**
   * Define id
   * @param id id
   * @generated
   */
  public Controle_datas setId(java.lang.String id){
    this.id = id;
    return this;
  }

  /**
   * Obtém inf_data
   * return inf_data
   * @generated
   */
  
  public java.util.Date getInf_data(){
    return this.inf_data;
  }

  /**
   * Define inf_data
   * @param inf_data inf_data
   * @generated
   */
  public Controle_datas setInf_data(java.util.Date inf_data){
    this.inf_data = inf_data;
    return this;
  }

  /**
   * @generated
   */
  @Override
  public boolean equals(Object obj) {
    if (this == obj) return true;
    if (obj == null || getClass() != obj.getClass()) return false;
    Controle_datas object = (Controle_datas)obj;
    if (id != null ? !id.equals(object.id) : object.id != null) return false;
    return true;
  }

  /**
   * @generated
   */
  @Override
  public int hashCode() {
    int result = 1;
    result = 31 * result + ((id == null) ? 0 : id.hashCode());
    return result;
  }

}
