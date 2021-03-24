package d.b.b.e.d;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import com.baidu.adp.base.BdDatabaseNewCreatedMessage;
import com.baidu.adp.framework.MessageManager;
/* loaded from: classes.dex */
public class i extends d.b.b.a.k.c {
    public i(Context context, String str) {
        super(context, str, 1);
    }

    public void a(SQLiteDatabase sQLiteDatabase) {
        executeDDLSqlIgnoreAnyErrors(sQLiteDatabase, "CREATE TABLE IF NOT EXISTS cache_meta_info(nameSpace VARCHAR(128) PRIMARY KEY, tableName varchar(64), maxSize int(11) default 0, cacheType varchar(32) not null, cacheVersion int(11) default 0, lastActiveTime bigint(21) default 0)");
    }

    @Override // d.b.b.a.k.c
    public void clearAllTables(SQLiteDatabase sQLiteDatabase) {
    }

    @Override // d.b.b.a.k.c
    public void createAllTables(SQLiteDatabase sQLiteDatabase) {
        a(sQLiteDatabase);
        MessageManager.getInstance().dispatchResponsedMessageToUI(new BdDatabaseNewCreatedMessage(sQLiteDatabase));
    }

    @Override // android.database.sqlite.SQLiteOpenHelper, d.b.b.a.k.a
    public void onUpgrade(SQLiteDatabase sQLiteDatabase, int i, int i2) {
        if (i < 1) {
            a(sQLiteDatabase);
        }
    }
}
