package d.b.g0.l.i.d;

import android.database.sqlite.SQLiteDatabase;
import com.baidu.mobads.container.bridge.BaiduAppJsBridgeHandler;
import com.baidu.searchbox.pms.db.PackageTable;
/* loaded from: classes3.dex */
public class d implements a<d.b.g0.l.k.d> {
    @Override // d.b.g0.l.i.d.a
    public void a(SQLiteDatabase sQLiteDatabase) {
        sQLiteDatabase.execSQL(b());
    }

    public final String b() {
        return "CREATE TABLE " + c() + "(_id INTEGER PRIMARY KEY AUTOINCREMENT,bundle_id TEXT UNIQUE,category INT NOT NULL,version_name TEXT NOT NULL,version_code INT DEFAULT 0,size LONG DEFAULT 0," + PackageTable.MD5 + " TEXT NOT NULL,sign TEXT NOT NULL," + BaiduAppJsBridgeHandler.INPUT_PARAM_DOWNLOAD_URL + " TEXT NOT NULL," + PackageTable.FILE_PATH + " TEXT," + PackageTable.CURRENT_SIZE + " LONG DEFAULT 0,create_time LONG DEFAULT 0,update_time LONG DEFAULT 0,state INT DEFAULT 0);";
    }

    public String c() {
        return "framework";
    }

    @Override // d.b.g0.l.i.d.a
    public void onUpgrade(SQLiteDatabase sQLiteDatabase, int i, int i2) {
    }
}
