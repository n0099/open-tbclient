package com.repackage;

import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.swan.apps.model.SwanAppBearInfo;
import com.baidu.swan.game.guide.GameGuideConfigInfo;
import com.baidu.swan.pms.PMSConstants;
import com.baidu.swan.pms.model.PMSAppInfo;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes7.dex */
public class r84 implements q84<PMSAppInfo> {
    public static /* synthetic */ Interceptable $ic;
    public static final kd4 a;
    public static final int b;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-755396477, "Lcom/repackage/r84;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-755396477, "Lcom/repackage/r84;");
                return;
            }
        }
        a = kd4.c();
        b = PMSConstants.PayProtected.NO_PAY_PROTECTED.type;
    }

    public r84() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
            }
        }
    }

    @Override // com.repackage.q84
    public void a(SQLiteDatabase sQLiteDatabase) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, sQLiteDatabase) == null) {
            sQLiteDatabase.execSQL(c());
        }
    }

    /* JADX DEBUG: Another duplicated slice has different insns count: {[IF]}, finally: {[IF, INVOKE, IF, INVOKE] complete} */
    /* JADX WARN: Code restructure failed: missing block: B:21:0x004d, code lost:
        if (r0.isClosed() == false) goto L15;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final boolean b(SQLiteDatabase sQLiteDatabase, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, sQLiteDatabase, str)) == null) {
            Cursor cursor = null;
            boolean z = false;
            try {
                try {
                    cursor = sQLiteDatabase.rawQuery("SELECT * FROM " + d() + " LIMIT 0", null);
                    if (cursor != null) {
                        if (cursor.getColumnIndex(str) != -1) {
                            z = true;
                        }
                    }
                } catch (Exception e) {
                    a.g("PMSDBHelperAppInfo", "#checkColumnExist error", e);
                    if (cursor != null) {
                    }
                }
                return z;
            } finally {
                if (cursor != null && !cursor.isClosed()) {
                    cursor.close();
                }
            }
        }
        return invokeLL.booleanValue;
    }

    public final String c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            return "CREATE TABLE " + d() + "(_id INTEGER PRIMARY KEY AUTOINCREMENT,app_id TEXT UNIQUE," + GameGuideConfigInfo.KEY_APP_KEY + " TEXT NOT NULL,app_sign LONG DEFAULT 0,version_code INTEGER DEFAULT 0,version_name TEXT,description TEXT,app_status INTEGER,status_detail TEXT,status_desc TEXT,resume_date TEXT,icon_url TEXT,app_name TEXT NOT NULL,service_category TEXT,subject_info TEXT,type INTEGER,pkg_size LONG,pending_err_code INTEGER,app_category INTEGER,orientation INTEGER,max_age LONG,create_time LONG,webview_domains TEXT,web_action TEXT,domains TEXT," + SwanAppBearInfo.BEAR_INFO + " TEXT,server_ext TEXT,pay_protected INTEGER,customer_service INTEGER,global_notice INTEGER,global_private INTEGER,pa_number TEXT,brand TEXT,last_launch_time LONG DEFAULT 0,launch_count INTEGER DEFAULT 0,install_src INTEGER DEFAULT 0,web_url TEXT,quick_app_key TEXT,cs_protocol_version INTEGER DEFAULT 0,web_permit INTEGER DEFAULT 0,user_action_apis TEXT,rank INTEGER DEFAULT 0);";
        }
        return (String) invokeV.objValue;
    }

    public String d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? "swan_app" : (String) invokeV.objValue;
    }

    public final void e(SQLiteDatabase sQLiteDatabase) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, sQLiteDatabase) == null) {
            try {
                sQLiteDatabase.execSQL("ALTER TABLE " + d() + " ADD customer_service INTEGER default " + PMSConstants.PayProtected.NO_PAY_PROTECTED.type + ";");
                sQLiteDatabase.execSQL("ALTER TABLE " + d() + " ADD global_notice INTEGER default " + PMSConstants.CloudSwitch.NO_DISPLAY.value + ";");
                sQLiteDatabase.execSQL("ALTER TABLE " + d() + " ADD global_private INTEGER default " + PMSConstants.CloudSwitch.NO_DISPLAY.value + ";");
                StringBuilder sb = new StringBuilder();
                sb.append("ALTER TABLE ");
                sb.append(d());
                sb.append(" ADD ");
                sb.append("pa_number");
                sb.append(" TEXT;");
                sQLiteDatabase.execSQL(sb.toString());
            } catch (SQLException e) {
                a.g("PMSDBHelperAppInfo", "#updateSwanAppTableV1115 error", e);
            }
        }
    }

    public final void f(SQLiteDatabase sQLiteDatabase) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, sQLiteDatabase) == null) {
            try {
                sQLiteDatabase.execSQL("ALTER TABLE " + d() + " ADD brand TEXT;");
            } catch (SQLException e) {
                a.g("PMSDBHelperAppInfo", "#updateSwanAppTableV1117 error", e);
            }
        }
    }

    public final void g(SQLiteDatabase sQLiteDatabase) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, sQLiteDatabase) == null) {
            try {
                String d = d();
                sQLiteDatabase.execSQL("ALTER TABLE " + d + " ADD last_launch_time LONG DEFAULT 0;");
                sQLiteDatabase.execSQL("ALTER TABLE " + d + " ADD launch_count INTEGER DEFAULT 0;");
                sQLiteDatabase.execSQL("ALTER TABLE " + d + " ADD install_src INTEGER DEFAULT 0;");
            } catch (SQLException e) {
                a.g("PMSDBHelperAppInfo", "#updateSwanAppTableV1122 error", e);
            }
        }
    }

    public final void h(SQLiteDatabase sQLiteDatabase) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, sQLiteDatabase) == null) {
            try {
                sQLiteDatabase.execSQL("ALTER TABLE " + d() + " ADD web_url TEXT;");
                sQLiteDatabase.execSQL("ALTER TABLE " + d() + " ADD quick_app_key TEXT;");
            } catch (SQLException e) {
                a.g("PMSDBHelperAppInfo", "#updateSwanAppTableV1124 error", e);
            }
        }
    }

    public final void i(SQLiteDatabase sQLiteDatabase) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, sQLiteDatabase) == null) {
            try {
                sQLiteDatabase.execSQL("ALTER TABLE " + d() + " ADD cs_protocol_version INTEGER DEFAULT 0;");
            } catch (SQLException e) {
                a.g("PMSDBHelperAppInfo", "#updateSwanAppTableV1125 error", e);
            }
        }
    }

    public final void j(SQLiteDatabase sQLiteDatabase) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048585, this, sQLiteDatabase) == null) {
            try {
                sQLiteDatabase.execSQL("ALTER TABLE " + d() + " ADD pay_protected INTEGER default " + b + ";");
            } catch (SQLException e) {
                a.g("PMSDBHelperAppInfo", "#updateSwanAppTableV1180 error", e);
            }
        }
    }

    public final void k(SQLiteDatabase sQLiteDatabase) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048586, this, sQLiteDatabase) == null) {
            try {
                sQLiteDatabase.execSQL("ALTER TABLE " + d() + " ADD web_permit INTEGER DEFAULT 0;");
            } catch (SQLException e) {
                a.g("PMSDBHelperAppInfo", "#updateSwanAppTableV1215 error", e);
            }
        }
    }

    public final void l(SQLiteDatabase sQLiteDatabase) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048587, this, sQLiteDatabase) == null) {
            try {
                if (!b(sQLiteDatabase, "rank")) {
                    sQLiteDatabase.execSQL("ALTER TABLE " + d() + " ADD rank INTEGER DEFAULT 0;");
                }
                if (!b(sQLiteDatabase, "web_permit")) {
                    sQLiteDatabase.execSQL("ALTER TABLE " + d() + " ADD web_permit INTEGER DEFAULT 0;");
                }
                if (b(sQLiteDatabase, "user_action_apis")) {
                    return;
                }
                sQLiteDatabase.execSQL("ALTER TABLE " + d() + " ADD user_action_apis TEXT;");
            } catch (SQLException e) {
                a.g("PMSDBHelperAppInfo", "#updateSwanAppTableV1217 error", e);
            }
        }
    }

    @Override // com.repackage.q84
    public void onUpgrade(SQLiteDatabase sQLiteDatabase, int i, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLII(1048588, this, sQLiteDatabase, i, i2) == null) {
            while (i < i2) {
                if (i == 1) {
                    j(sQLiteDatabase);
                } else if (i != 4) {
                    switch (i) {
                        case 6:
                            f(sQLiteDatabase);
                            continue;
                        case 7:
                            g(sQLiteDatabase);
                            continue;
                        case 8:
                            h(sQLiteDatabase);
                            continue;
                        case 9:
                            i(sQLiteDatabase);
                            continue;
                        case 10:
                            k(sQLiteDatabase);
                            continue;
                        case 11:
                            l(sQLiteDatabase);
                            continue;
                    }
                } else {
                    e(sQLiteDatabase);
                }
                i++;
            }
        }
    }
}
