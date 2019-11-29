package database;

import database.Tbanimal;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2019-11-28T18:25:12")
@StaticMetamodel(Tbtipo.class)
public class Tbtipo_ { 

    public static volatile SingularAttribute<Tbtipo, String> descripcion;
    public static volatile SingularAttribute<Tbtipo, String> imagen;
    public static volatile CollectionAttribute<Tbtipo, Tbanimal> tbanimalCollection;
    public static volatile SingularAttribute<Tbtipo, Integer> id;
    public static volatile SingularAttribute<Tbtipo, String> nombre;

}