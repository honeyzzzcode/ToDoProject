import DataBase.DBHandler;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public  class Record {
    public String status= "not complete";
public Record(){}
    public Record(int id,String text,String status  ) {
        this.status = status;
        this.text = text;
        this.id = id;
    }

    public   String text;
    public int id;


    @Override
    public String toString() {

       return String.format("id:%d , Text: %s,Status: %s", id,text,status);
    }

    public void askData(){text=InputUtils.askString("Put text:"); };
    public boolean contains(String substr) {
        String strID = String.valueOf(id);

        return  strID.contains(substr);

    }
}
