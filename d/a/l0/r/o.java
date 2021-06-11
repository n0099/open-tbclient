package d.a.l0.r;

import android.content.Context;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import java.io.File;
/* loaded from: classes3.dex */
public class o extends SQLiteOpenHelper {

    /* renamed from: a  reason: collision with root package name */
    public Context f52128a;

    public o(Context context) {
        super(context.getApplicationContext(), "OpenStat.db", (SQLiteDatabase.CursorFactory) null, 5);
        this.f52128a = context.getApplicationContext();
    }

    public final void a(SQLiteDatabase sQLiteDatabase) {
        try {
            sQLiteDatabase.execSQL("ALTER TABLE event ADD COLUMN extend TEXT");
            sQLiteDatabase.execSQL("ALTER TABLE flow ADD COLUMN extend TEXT");
        } catch (SQLException e2) {
            e2.printStackTrace();
        }
    }

    public final void b(SQLiteDatabase sQLiteDatabase) {
        try {
            sQLiteDatabase.execSQL("ALTER TABLE config ADD COLUMN extend TEXT");
        } catch (SQLException e2) {
            e2.printStackTrace();
        }
    }

    public final void c(SQLiteDatabase sQLiteDatabase) {
        try {
            sQLiteDatabase.execSQL("ALTER TABLE config ADD COLUMN sample TEXT");
            sQLiteDatabase.execSQL("ALTER TABLE flow ADD COLUMN slot TEXT");
        } catch (SQLException e2) {
            e2.printStackTrace();
        }
    }

    public final void d(SQLiteDatabase sQLiteDatabase) {
        try {
            sQLiteDatabase.execSQL("CREATE TABLE file (filename TEXT PRIMARY KEY,state TEXT,reserve1 TEXT,reserve2 TEXT);");
        } catch (SQLException e2) {
            e2.printStackTrace();
        }
    }

    public long e() {
        return new File(this.f52128a.getDatabasePath("OpenStat.db").getPath() + "-journal").length();
    }

    public long f() {
        return new File(this.f52128a.getDatabasePath("OpenStat.db").getPath()).length();
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public synchronized SQLiteDatabase getReadableDatabase() {
        SQLiteDatabase sQLiteDatabase;
        try {
            sQLiteDatabase = super.getReadableDatabase();
        } catch (Exception unused) {
            new File(this.f52128a.getDatabasePath("OpenStat.db").getPath()).delete();
            sQLiteDatabase = null;
        }
        return sQLiteDatabase;
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public synchronized SQLiteDatabase getWritableDatabase() {
        SQLiteDatabase sQLiteDatabase;
        try {
            sQLiteDatabase = super.getWritableDatabase();
            try {
                sQLiteDatabase.enableWriteAheadLogging();
            } catch (Exception unused) {
                new File(this.f52128a.getDatabasePath("OpenStat.db").getPath()).delete();
                return sQLiteDatabase;
            }
        } catch (Exception unused2) {
            sQLiteDatabase = null;
        }
        return sQLiteDatabase;
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public void onCreate(SQLiteDatabase sQLiteDatabase) {
        sQLiteDatabase.execSQL("CREATE TABLE event (_id INTEGER PRIMARY KEY AUTOINCREMENT,flowhandle INTEGER,eventid TEXT,begintime LONG,content TEXT,reserve1 TEXT,reserve2 TEXT,extend TEXT );");
        sQLiteDatabase.execSQL("CREATE TABLE flow (_id INTEGER PRIMARY KEY AUTOINCREMENT,flowid TEXT,flowhandle INTEGER,state TEXT,begintime LONG,endtime LONG,content TEXT,option INTEGER,reserve1 TEXT,reserve2 TEXT,slot TEXT,extend TEXT );");
        sQLiteDatabase.execSQL("CREATE TABLE config (eventid TEXT PRIMARY KEY,type TEXT,recordrule TEXT,uploadrule TEXT,cycle INTEGER,switch TEXT,sample INTEGER,reserve1 TEXT,reserve2 TEXT,extend TEXT);");
        sQLiteDatabase.execSQL("CREATE TABLE file (filename TEXT PRIMARY KEY,state TEXT,reserve1 TEXT,reserve2 TEXT);");
        t.g().putString("ubc_version_md5", "0");
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public void onUpgrade(SQLiteDatabase sQLiteDatabase, int i2, int i3) {
        while (i2 < i3) {
            if (i2 == 1) {
                d(sQLiteDatabase);
            } else if (i2 == 2) {
                c(sQLiteDatabase);
            } else if (i2 == 3) {
                a(sQLiteDatabase);
            } else if (i2 == 4) {
                b(sQLiteDatabase);
            }
            i2++;
        }
    }
}
