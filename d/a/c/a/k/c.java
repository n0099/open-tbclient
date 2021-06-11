package d.a.c.a.k;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import com.baidu.adp.lib.util.BdLog;
import d.a.c.a.k.a;
/* loaded from: classes.dex */
public abstract class c extends SQLiteOpenHelper implements a {
    public a.InterfaceC0534a callback;
    public final String databaseName;

    public c(Context context, String str, int i2) {
        super(context, str, (SQLiteDatabase.CursorFactory) null, i2);
        this.databaseName = str;
    }

    private void exeCallback(SQLiteDatabase sQLiteDatabase) {
        a.InterfaceC0534a interfaceC0534a = this.callback;
        if (interfaceC0534a != null) {
            interfaceC0534a.a(sQLiteDatabase);
        }
    }

    public abstract void clearAllTables(SQLiteDatabase sQLiteDatabase);

    public abstract void createAllTables(SQLiteDatabase sQLiteDatabase);

    @Override // d.a.c.a.k.a
    public boolean dropDatabase(Context context) {
        return context.deleteDatabase(this.databaseName);
    }

    public boolean executeDDLSqlIgnoreAnyErrors(SQLiteDatabase sQLiteDatabase, String str) {
        try {
            sQLiteDatabase.execSQL(str);
            return true;
        } catch (Throwable th) {
            BdLog.e(str + ":" + th.getMessage());
            return false;
        }
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public void onCreate(SQLiteDatabase sQLiteDatabase) {
        createAllTables(sQLiteDatabase);
        exeCallback(sQLiteDatabase);
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public void onDowngrade(SQLiteDatabase sQLiteDatabase, int i2, int i3) {
        clearAllTables(sQLiteDatabase);
        createAllTables(sQLiteDatabase);
    }

    @Override // d.a.c.a.k.a
    public void setOnCreateCallback(a.InterfaceC0534a interfaceC0534a) {
        this.callback = interfaceC0534a;
    }
}
