package d.b.x.f.a;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import com.baidu.searchbox.pms.db.PackageTable;
import com.baidu.spswitch.emotion.resource.EmotionResourceInfo;
import com.tencent.open.SocialOperation;
/* loaded from: classes2.dex */
public class c extends SQLiteOpenHelper {
    public c(Context context) {
        super(context, "nps.db", (SQLiteDatabase.CursorFactory) null, 1);
    }

    public final void a(SQLiteDatabase sQLiteDatabase) {
        sQLiteDatabase.execSQL(b());
    }

    public final String b() {
        return "CREATE TABLE bundleinfo (_id INTEGER PRIMARY KEY," + EmotionResourceInfo.JSON_KEY_PKG_NAME + " TEXT NOT NULL,version_code INTEGER,path TEXT,min_version INTEGER,update_v LONG,type INTEGER DEFAULT 0,broken INTEGER DEFAULT 0,force_update INTEGER DEFAULT 0,forbidden INTEGER DEFAULT 0," + PackageTable.MD5 + " TEXT," + SocialOperation.GAME_SIGNATURE + " TEXT,name TEXT,description TEXT,download_url TEXT,icon_url TEXT,dependence TEXT,visible INTEGER DEFAULT 0,removalbe INTEGER DEFAULT 0,size TEXT,need_remove INTEGER DEFAULT 0,abi INTEGER DEFAULT -1,ext TEXT );";
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public void onCreate(SQLiteDatabase sQLiteDatabase) {
        a(sQLiteDatabase);
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public void onDowngrade(SQLiteDatabase sQLiteDatabase, int i, int i2) {
        sQLiteDatabase.execSQL("DROP TABLE IF EXISTS bundleinfo");
        onCreate(sQLiteDatabase);
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public void onUpgrade(SQLiteDatabase sQLiteDatabase, int i, int i2) {
    }
}
