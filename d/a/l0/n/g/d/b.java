package d.a.l0.n.g.d;

import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import com.baidu.swan.apps.model.SwanAppBearInfo;
import com.baidu.swan.pms.PMSConstants;
import com.baidu.swan.pms.model.PMSAppInfo;
import com.xiaomi.mipush.sdk.Constants;
/* loaded from: classes3.dex */
public class b implements a<PMSAppInfo> {

    /* renamed from: a  reason: collision with root package name */
    public static final int f51663a = PMSConstants.PayProtected.NO_PAY_PROTECTED.type;

    @Override // d.a.l0.n.g.d.a
    public void a(SQLiteDatabase sQLiteDatabase) {
        sQLiteDatabase.execSQL(b());
    }

    public final String b() {
        return "CREATE TABLE " + c() + "(_id INTEGER PRIMARY KEY AUTOINCREMENT," + Constants.APP_ID + " TEXT UNIQUE,app_key TEXT NOT NULL,app_sign LONG DEFAULT 0,version_code INTEGER DEFAULT 0,version_name TEXT,description TEXT,app_status INTEGER,status_detail TEXT,status_desc TEXT,resume_date TEXT,icon_url TEXT,app_name TEXT NOT NULL,service_category TEXT,subject_info TEXT,type INTEGER,pkg_size LONG,pending_err_code INTEGER,app_category INTEGER,orientation INTEGER,max_age LONG,create_time LONG,webview_domains TEXT,web_action TEXT,domains TEXT," + SwanAppBearInfo.BEAR_INFO + " TEXT,server_ext TEXT,pay_protected INTEGER,customer_service INTEGER,global_notice INTEGER,global_private INTEGER,pa_number TEXT,brand TEXT,last_launch_time LONG DEFAULT 0,launch_count INTEGER DEFAULT 0,install_src INTEGER DEFAULT 0,web_url TEXT,quick_app_key TEXT,cs_protocol_version INTEGER DEFAULT 0);";
    }

    public String c() {
        return "swan_app";
    }

    public final void d(SQLiteDatabase sQLiteDatabase) {
        try {
            sQLiteDatabase.execSQL("ALTER TABLE " + c() + " ADD customer_service INTEGER default " + PMSConstants.PayProtected.NO_PAY_PROTECTED.type + ";");
            sQLiteDatabase.execSQL("ALTER TABLE " + c() + " ADD global_notice INTEGER default " + PMSConstants.CloudSwitch.NO_DISPLAY.value + ";");
            sQLiteDatabase.execSQL("ALTER TABLE " + c() + " ADD global_private INTEGER default " + PMSConstants.CloudSwitch.NO_DISPLAY.value + ";");
            StringBuilder sb = new StringBuilder();
            sb.append("ALTER TABLE ");
            sb.append(c());
            sb.append(" ADD ");
            sb.append("pa_number");
            sb.append(" TEXT;");
            sQLiteDatabase.execSQL(sb.toString());
        } catch (SQLException unused) {
        }
    }

    public final void e(SQLiteDatabase sQLiteDatabase) {
        try {
            sQLiteDatabase.execSQL("ALTER TABLE " + c() + " ADD brand TEXT;");
        } catch (SQLException unused) {
        }
    }

    public final void f(SQLiteDatabase sQLiteDatabase) {
        try {
            String c2 = c();
            sQLiteDatabase.execSQL("ALTER TABLE " + c2 + " ADD last_launch_time LONG DEFAULT 0;");
            sQLiteDatabase.execSQL("ALTER TABLE " + c2 + " ADD launch_count INTEGER DEFAULT 0;");
            sQLiteDatabase.execSQL("ALTER TABLE " + c2 + " ADD install_src INTEGER DEFAULT 0;");
        } catch (SQLException unused) {
        }
    }

    public final void g(SQLiteDatabase sQLiteDatabase) {
        try {
            sQLiteDatabase.execSQL("ALTER TABLE " + c() + " ADD web_url TEXT;");
            sQLiteDatabase.execSQL("ALTER TABLE " + c() + " ADD quick_app_key TEXT;");
        } catch (SQLException unused) {
        }
    }

    public final void h(SQLiteDatabase sQLiteDatabase) {
        try {
            sQLiteDatabase.execSQL("ALTER TABLE " + c() + " ADD cs_protocol_version INTEGER DEFAULT 0;");
        } catch (SQLException unused) {
        }
    }

    public final void i(SQLiteDatabase sQLiteDatabase) {
        try {
            sQLiteDatabase.execSQL("ALTER TABLE " + c() + " ADD pay_protected INTEGER default " + f51663a + ";");
        } catch (SQLException unused) {
        }
    }

    @Override // d.a.l0.n.g.d.a
    public void onUpgrade(SQLiteDatabase sQLiteDatabase, int i2, int i3) {
        while (i2 < i3) {
            if (i2 == 1) {
                i(sQLiteDatabase);
            } else if (i2 != 4) {
                switch (i2) {
                    case 6:
                        e(sQLiteDatabase);
                        continue;
                    case 7:
                        f(sQLiteDatabase);
                        continue;
                    case 8:
                        g(sQLiteDatabase);
                        continue;
                    case 9:
                        h(sQLiteDatabase);
                        continue;
                }
            } else {
                d(sQLiteDatabase);
            }
            i2++;
        }
    }
}
