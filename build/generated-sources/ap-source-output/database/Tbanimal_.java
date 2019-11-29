package database;

import database.Tbtipo;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2019-11-28T18:25:12")
@StaticMetamodel(Tbanimal.class)
public class Tbanimal_ { 

    public static volatile SingularAttribute<Tbanimal, String> descripcion;
    public static volatile SingularAttribute<Tbanimal, String> imagen;
    public static volatile SingularAttribute<Tbanimal, Tbtipo> idTipo;
    public static volatile SingularAttribute<Tbanimal, Integer> id;
    public static volatile SingularAttribute<Tbanimal, String> nombre;

}