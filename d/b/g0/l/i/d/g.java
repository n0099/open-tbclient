package d.b.g0.l.i.d;

import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import com.baidu.cyberplayer.sdk.statistics.DpStatConstants;
import com.baidu.searchbox.pms.db.PackageTable;
/* loaded from: classes3.dex */
public class g implements a<d.b.g0.l.k.h> {
    @Override // d.b.g0.l.i.d.a
    public void a(SQLiteDatabase sQLiteDatabase) {
        sQLiteDatabase.execSQL(b());
    }

    public final String b() {
        return "CREATE TABLE " + c() + "(_id INTEGER PRIMARY KEY AUTOINCREMENT,bundle_id TEXT NOT NULL,category INT NOT NULL,version_name TEXT NOT NULL,version_code INT DEFAULT 0,size LONG DEFAULT 0," + PackageTable.MD5 + " TEXT NOT NULL,sign TEXT NOT NULL,downloadUrl TEXT NOT NULL," + PackageTable.FILE_PATH + " TEXT," + PackageTable.CURRENT_SIZE + " LONG DEFAULT 0,create_time LONG DEFAULT 0,update_time LONG DEFAULT 0,state INT DEFAULT 0,max_age LONG DEFAULT 0,token TEXT,domains TEXT," + com.alipay.sdk.cons.b.f1858h + " TEXT," + DpStatConstants.KEY_APP_NAME + " TEXT, UNIQUE (bundle_id,version_name));";
    }

    public String c() {
        return "swan_plugin";
    }

    public final void d(SQLiteDatabase sQLiteDatabase) {
        try {
            sQLiteDatabase.execSQL("ALTER TABLE " + c() + " ADD COLUMN " + com.alipay.sdk.cons.b.f1858h + " TEXT");
            sQLiteDatabase.execSQL("ALTER TABLE " + c() + " ADD COLUMN " + DpStatConstants.KEY_APP_NAME + " TEXT");
        } catch (SQLException unused) {
        }
    }

    public final void e(SQLiteDatabase sQLiteDatabase) {
        try {
            sQLiteDatabase.execSQL("ALTER TABLE " + c() + " ADD COLUMN token TEXT");
            sQLiteDatabase.execSQL("ALTER TABLE " + c() + " ADD COLUMN domains TEXT");
        } catch (SQLException unused) {
        }
    }

    @Override // d.b.g0.l.i.d.a
    public void onUpgrade(SQLiteDatabase sQLiteDatabase, int i, int i2) {
        while (i < i2) {
            if (i == 2) {
                sQLiteDatabase.execSQL(b());
            } else if (i == 3) {
                e(sQLiteDatabase);
            } else if (i == 5) {
                d(sQLiteDatabase);
            }
            i++;
        }
    }
}
