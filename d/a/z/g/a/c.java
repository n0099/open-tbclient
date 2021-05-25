package d.a.z.g.a;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import com.baidu.searchbox.pms.db.PackageTable;
import com.baidu.spswitch.emotion.resource.EmotionResourceInfo;
import com.tencent.open.SocialOperation;
/* loaded from: classes2.dex */
public class c extends SQLiteOpenHelper {
    public c(Context context) {
        super(context, "nps.db", (SQLiteDatabase.CursorFactory) null, 3);
    }

    public final void a(SQLiteDatabase sQLiteDatabase) {
        try {
            sQLiteDatabase.execSQL("ALTER TABLE bundleinfo ADD silence INTEGER DEFAULT 1");
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    public final void b(SQLiteDatabase sQLiteDatabase) {
        StringBuilder sb = new StringBuilder();
        sb.append("ALTER TABLE ");
        sb.append("bundleinfo");
        sb.append(" ADD COLUMN ");
        sb.append("silence_update");
        sb.append(" INTEGER DEFAULT ");
        sb.append(1);
        sb.append(";");
        try {
            sQLiteDatabase.execSQL(sb.toString());
        } catch (Exception e2) {
            e2.printStackTrace();
        }
        sb.delete(0, sb.length());
        sb.append("ALTER TABLE ");
        sb.append("bundleinfo");
        sb.append(" ADD COLUMN ");
        sb.append("wifionly");
        sb.append(" INTEGER DEFAULT ");
        sb.append(1);
        sb.append(";");
        try {
            sQLiteDatabase.execSQL(sb.toString());
        } catch (Exception e3) {
            e3.printStackTrace();
        }
    }

    public final void c(SQLiteDatabase sQLiteDatabase) {
        sQLiteDatabase.execSQL(d());
    }

    public final String d() {
        return "CREATE TABLE bundleinfo (_id INTEGER PRIMARY KEY," + EmotionResourceInfo.JSON_KEY_PKG_NAME + " TEXT NOT NULL,version_code INTEGER,path TEXT,min_version INTEGER,update_v LONG,type INTEGER DEFAULT 0,broken INTEGER DEFAULT 0,force_update INTEGER DEFAULT 0,forbidden INTEGER DEFAULT 0," + PackageTable.MD5 + " TEXT," + SocialOperation.GAME_SIGNATURE + " TEXT,name TEXT,description TEXT,download_url TEXT,icon_url TEXT,dependence TEXT,visible INTEGER DEFAULT 0,removalbe INTEGER DEFAULT 0,size TEXT,need_remove INTEGER DEFAULT 0,abi INTEGER DEFAULT -1,ext TEXT,silence INTEGER DEFAULT 1,silence_update INTEGER DEFAULT 1,wifionly INTEGER DEFAULT 1 );";
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public void onCreate(SQLiteDatabase sQLiteDatabase) {
        c(sQLiteDatabase);
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public void onDowngrade(SQLiteDatabase sQLiteDatabase, int i2, int i3) {
        sQLiteDatabase.execSQL("DROP TABLE IF EXISTS bundleinfo");
        onCreate(sQLiteDatabase);
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public void onUpgrade(SQLiteDatabase sQLiteDatabase, int i2, int i3) {
        if (i2 == 1) {
            a(sQLiteDatabase);
            b(sQLiteDatabase);
        } else if (i2 != 2) {
        } else {
            b(sQLiteDatabase);
        }
    }
}
