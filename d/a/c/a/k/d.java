package d.a.c.a.k;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import com.baidu.adp.lib.util.BdLog;
import d.a.c.a.k.a;
import java.io.File;
/* loaded from: classes.dex */
public abstract class d implements a {
    public a.InterfaceC0494a callback;
    public SQLiteDatabase database = null;
    public final String dbFileFullPath;
    public int mVersion;

    public d(String str, int i2) {
        this.mVersion = 1;
        this.mVersion = i2;
        this.dbFileFullPath = str;
    }

    private void exeCallback(SQLiteDatabase sQLiteDatabase) {
        a.InterfaceC0494a interfaceC0494a = this.callback;
        if (interfaceC0494a != null) {
            interfaceC0494a.a(sQLiteDatabase);
        }
    }

    private void onCreateDatabase(SQLiteDatabase sQLiteDatabase) {
        onCreate(sQLiteDatabase);
        exeCallback(sQLiteDatabase);
    }

    private void onUpdateDatabase(SQLiteDatabase sQLiteDatabase, int i2, int i3) {
        if (i3 > i2) {
            onUpgrade(sQLiteDatabase, i2, i3);
        } else {
            onDowngrade(sQLiteDatabase, i2, i3);
        }
        exeCallback(sQLiteDatabase);
    }

    public abstract void clearAllTables(SQLiteDatabase sQLiteDatabase);

    public abstract void createAllTables(SQLiteDatabase sQLiteDatabase);

    @Override // d.a.c.a.k.a
    public boolean dropDatabase(Context context) {
        File file = new File(this.dbFileFullPath);
        if (file.exists()) {
            return file.delete();
        }
        return false;
    }

    public boolean executeDDLSqlIgnoreAnyErrors(SQLiteDatabase sQLiteDatabase, String str) {
        try {
            sQLiteDatabase.execSQL(str);
            return true;
        } catch (Throwable th) {
            BdLog.e(str + ":" + th);
            return false;
        }
    }

    @Override // d.a.c.a.k.a
    public SQLiteDatabase getWritableDatabase() {
        File file = new File(this.dbFileFullPath);
        if (file.getParentFile() != null && (file.getParentFile().exists() || file.getParentFile().mkdirs())) {
            boolean exists = file.exists();
            SQLiteDatabase openOrCreateDatabase = SQLiteDatabase.openOrCreateDatabase(this.dbFileFullPath, (SQLiteDatabase.CursorFactory) null);
            this.database = openOrCreateDatabase;
            if (openOrCreateDatabase != null) {
                if (!exists) {
                    onCreateDatabase(openOrCreateDatabase);
                    this.database.setVersion(this.mVersion);
                } else {
                    int version = openOrCreateDatabase.getVersion();
                    int i2 = this.mVersion;
                    if (version != i2) {
                        onUpdateDatabase(this.database, version, i2);
                        this.database.setVersion(this.mVersion);
                    }
                }
            }
        }
        return this.database;
    }

    public void onCreate(SQLiteDatabase sQLiteDatabase) {
        createAllTables(sQLiteDatabase);
    }

    public void onDowngrade(SQLiteDatabase sQLiteDatabase, int i2, int i3) {
        clearAllTables(sQLiteDatabase);
        createAllTables(sQLiteDatabase);
    }

    @Override // d.a.c.a.k.a
    public void setOnCreateCallback(a.InterfaceC0494a interfaceC0494a) {
        this.callback = interfaceC0494a;
    }
}
