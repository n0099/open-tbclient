package d.b.g0.l.j.b;

import android.database.sqlite.SQLiteDatabase;
import com.baidu.mobads.container.bridge.BaiduAppJsBridgeHandler;
import com.baidu.searchbox.pms.db.PackageTable;
import com.xiaomi.mipush.sdk.Constants;
/* loaded from: classes3.dex */
public class a implements d.b.g0.l.i.d.a<d.b.g0.l.j.a> {
    @Override // d.b.g0.l.i.d.a
    public void a(SQLiteDatabase sQLiteDatabase) {
        sQLiteDatabase.execSQL(b());
    }

    public final String b() {
        return "CREATE TABLE " + c() + "(_id INTEGER PRIMARY KEY AUTOINCREMENT," + Constants.APP_ID + " TEXT NOT NULL,bundle_id TEXT NOT NULL,version_name TEXT NOT NULL,version_code INT DEFAULT 0,size LONG DEFAULT 0," + PackageTable.MD5 + " TEXT NOT NULL,sign TEXT NOT NULL," + BaiduAppJsBridgeHandler.INPUT_PARAM_DOWNLOAD_URL + " TEXT NOT NULL, UNIQUE (app_id,bundle_id));";
    }

    public String c() {
        return "swan_mini_pkg";
    }

    @Override // d.b.g0.l.i.d.a
    public void onUpgrade(SQLiteDatabase sQLiteDatabase, int i, int i2) {
        while (i < i2) {
            if (i == 4) {
                sQLiteDatabase.execSQL(b());
            }
            i++;
        }
    }
}
