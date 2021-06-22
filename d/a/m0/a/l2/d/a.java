package d.a.m0.a.l2.d;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;
import androidx.annotation.NonNull;
import com.baidu.tbadk.mutiprocess.mission.MissionEvent;
import d.a.m0.a.a1.e;
import d.a.m0.a.e0.d;
import d.a.m0.a.k;
import java.io.File;
/* loaded from: classes3.dex */
public class a extends SQLiteOpenHelper {

    /* renamed from: b  reason: collision with root package name */
    public static final boolean f47186b = k.f46983a;

    /* renamed from: a  reason: collision with root package name */
    public final String f47187a;

    public a(@NonNull Context context, String str) {
        super(context.getApplicationContext(), b(str), (SQLiteDatabase.CursorFactory) null, 1);
        this.f47187a = str;
    }

    public static String a() {
        return "CREATE TABLE cookies (_id INTEGER PRIMARY KEY AUTOINCREMENT,name TEXT,value TEXT,domain TEXT,path TEXT,expires INTEGER,secure INTEGER,ext TEXT);";
    }

    public static String b(String str) {
        String o = e.o(str);
        File file = new File(o);
        if (!file.exists() && !file.mkdirs()) {
            d.h("SwanCookieDBHelper", "mkdirs fail: " + o);
        }
        return o + File.separator + "smCookie.db";
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public synchronized SQLiteDatabase getReadableDatabase() {
        SQLiteDatabase sQLiteDatabase;
        Exception e2;
        try {
            sQLiteDatabase = super.getReadableDatabase();
            try {
                String databaseName = getDatabaseName();
                if (!new File(databaseName).exists()) {
                    d.h("SwanCookieDBHelper", "getReadableDatabase file is not exit: " + databaseName);
                    return null;
                }
            } catch (Exception e3) {
                e2 = e3;
                d.h("SwanCookieDBHelper", "getRead fail mAppId =" + this.f47187a + ";" + Log.getStackTraceString(e2));
                if (f47186b) {
                    throw new RuntimeException(e2);
                }
                return sQLiteDatabase;
            }
        } catch (Exception e4) {
            sQLiteDatabase = null;
            e2 = e4;
        }
        return sQLiteDatabase;
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public synchronized SQLiteDatabase getWritableDatabase() {
        SQLiteDatabase sQLiteDatabase;
        Exception e2;
        try {
            sQLiteDatabase = super.getWritableDatabase();
            try {
                String databaseName = getDatabaseName();
                if (!new File(databaseName).exists()) {
                    d.h("SwanCookieDBHelper", "getWritableDatabase file is not exit: " + databaseName);
                    return null;
                }
            } catch (Exception e3) {
                e2 = e3;
                d.h("SwanCookieDBHelper", "getWrite fail mAppId =" + this.f47187a + ";" + Log.getStackTraceString(e2));
                if (f47186b) {
                    throw new RuntimeException(e2);
                }
                return sQLiteDatabase;
            }
        } catch (Exception e4) {
            sQLiteDatabase = null;
            e2 = e4;
        }
        return sQLiteDatabase;
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public void onCreate(SQLiteDatabase sQLiteDatabase) {
        if (f47186b) {
            Log.d("SwanCookieDBHelper", MissionEvent.MESSAGE_CREATE);
        }
        try {
            sQLiteDatabase.execSQL(a());
        } catch (Exception e2) {
            d.h("SwanCookieDBHelper", "createTableSql fail:" + Log.getStackTraceString(e2));
        }
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public void onUpgrade(SQLiteDatabase sQLiteDatabase, int i2, int i3) {
        if (f47186b) {
            Log.d("SwanCookieDBHelper", "oldVersion = " + i2 + ";newVersion=" + i3);
        }
    }
}
