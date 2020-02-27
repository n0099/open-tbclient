package common.network.b;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import com.baidu.android.imsdk.db.TableDefine;
/* loaded from: classes.dex */
public class a extends SQLiteOpenHelper {
    public static final String nuu = String.format("CREATE TABLE %s(%s TEXT PRIMARY KEY NOT NULL, %s TEXT NOT NULL)", "dns_disaster_cache", "hostname", TableDefine.UserInfoColumns.COLUMN_IP);

    public a(Context context) {
        super(context, "network", (SQLiteDatabase.CursorFactory) null, 1);
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public void onCreate(SQLiteDatabase sQLiteDatabase) {
        sQLiteDatabase.execSQL(nuu);
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public void onUpgrade(SQLiteDatabase sQLiteDatabase, int i, int i2) {
    }
}
