import DataBase.DBHandler;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public abstract class Record {
    public String type;
    public int id;

    @Override
    public String toString() {

       return String.format("id:%d; Type :%s", id,type);
    }

    public void askData(){
        type = InputUtils.askString("Put Type");
    };
    public boolean contains(String substr) {
        String strID = String.valueOf(id);

        return  strID.contains(substr)
                || type.toLowerCase().contains(substr);
    }
}
