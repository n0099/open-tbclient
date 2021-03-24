package d.b.b.a.k;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import com.baidu.adp.lib.util.BdLog;
import d.b.b.a.k.a;
import java.io.File;
/* loaded from: classes.dex */
public abstract class d implements a {
    public a.InterfaceC0530a callback;
    public SQLiteDatabase database = null;
    public final String dbFileFullPath;
    public int mVersion;

    public d(String str, int i) {
        this.mVersion = 1;
        this.mVersion = i;
        this.dbFileFullPath = str;
    }

    private void exeCallback(SQLiteDatabase sQLiteDatabase) {
        a.InterfaceC0530a interfaceC0530a = this.callback;
        if (interfaceC0530a != null) {
            interfaceC0530a.a(sQLiteDatabase);
        }
    }

    private void onCreateDatabase(SQLiteDatabase sQLiteDatabase) {
        onCreate(sQLiteDatabase);
        exeCallback(sQLiteDatabase);
    }

    private void onUpdateDatabase(SQLiteDatabase sQLiteDatabase, int i, int i2) {
        if (i2 > i) {
            onUpgrade(sQLiteDatabase, i, i2);
        } else {
            onDowngrade(sQLiteDatabase, i, i2);
        }
        exeCallback(sQLiteDatabase);
    }

    public abstract void clearAllTables(SQLiteDatabase sQLiteDatabase);

    public abstract void createAllTables(SQLiteDatabase sQLiteDatabase);

    @Override // d.b.b.a.k.a
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

    @Override // d.b.b.a.k.a
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
                    int i = this.mVersion;
                    if (version != i) {
                        onUpdateDatabase(this.database, version, i);
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

    public void onDowngrade(SQLiteDatabase sQLiteDatabase, int i, int i2) {
        clearAllTables(sQLiteDatabase);
        createAllTables(sQLiteDatabase);
    }

    @Override // d.b.b.a.k.a
    public void setOnCreateCallback(a.InterfaceC0530a interfaceC0530a) {
        this.callback = interfaceC0530a;
    }
}
