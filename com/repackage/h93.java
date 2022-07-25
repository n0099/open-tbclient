package com.repackage;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.text.TextUtils;
import android.util.Log;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import org.apache.http.cookie.ClientCookie;
/* loaded from: classes6.dex */
public class h93 {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean c;
    public transient /* synthetic */ FieldHolder $fh;
    public g93 a;
    public boolean b;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-755693457, "Lcom/repackage/h93;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-755693457, "Lcom/repackage/h93;");
                return;
            }
        }
        c = sg1.a;
    }

    public h93() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.a = null;
    }

    public synchronized void a(d93 d93Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, d93Var) == null) {
            synchronized (this) {
                if (d93Var != null) {
                    if (!TextUtils.isEmpty(d93Var.a) && !TextUtils.isEmpty(d93Var.c) && !TextUtils.isEmpty(d93Var.b)) {
                        if (d93Var.e == -1) {
                            return;
                        }
                        SQLiteDatabase f = f();
                        if (f == null) {
                            return;
                        }
                        if (c) {
                            Log.d("SwanCookieDatabase", "addCookie cookie=" + d93Var.toString());
                        }
                        ContentValues contentValues = new ContentValues();
                        contentValues.put("domain", d93Var.a);
                        contentValues.put("path", d93Var.b);
                        contentValues.put("name", d93Var.c);
                        contentValues.put("value", d93Var.d);
                        contentValues.put("expires", Long.valueOf(d93Var.e));
                        contentValues.put(ClientCookie.SECURE_ATTR, Boolean.valueOf(d93Var.f));
                        f.insert("cookies", null, contentValues);
                    }
                }
            }
        }
    }

    public synchronized void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            synchronized (this) {
                SQLiteDatabase f = f();
                if (f == null) {
                    return;
                }
                if (c) {
                    Log.d("SwanCookieDatabase", "clearExpiredCookies");
                }
                f.delete("cookies", "expires <= ?", new String[]{Long.toString(System.currentTimeMillis())});
            }
        }
    }

    public synchronized void c() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            synchronized (this) {
                if (this.a == null) {
                    return;
                }
                try {
                    if (c) {
                        Log.d("SwanCookieDatabase", "close");
                    }
                    this.a.close();
                    this.a = null;
                    this.b = true;
                } catch (Exception e) {
                    ix1.k("SwanCookieDatabase", "close fail:" + Log.getStackTraceString(e));
                }
            }
        }
    }

    public synchronized void d(String str, String str2, String str3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048579, this, str, str2, str3) == null) {
            synchronized (this) {
                if (TextUtils.isEmpty(str)) {
                    return;
                }
                SQLiteDatabase f = f();
                if (f == null) {
                    return;
                }
                if (c) {
                    Log.d("SwanCookieDatabase", "deleteCookies domain=" + str + ";path=" + str2 + ";name=" + str3);
                }
                f.delete("cookies", "(domain == ?) AND (path == ?) AND (name == ?)", new String[]{str, str2, str3});
            }
        }
    }

    public synchronized ArrayList<d93> e(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, str)) == null) {
            synchronized (this) {
                if (c) {
                    Log.d("SwanCookieDatabase", "getCookiesForDomain baseDomain=" + str);
                }
                ArrayList<d93> arrayList = new ArrayList<>();
                if (TextUtils.isEmpty(str)) {
                    return arrayList;
                }
                SQLiteDatabase f = f();
                if (f == null) {
                    return arrayList;
                }
                Cursor query = f.query("cookies", new String[]{"_id", "domain", "path", "name", "value", "expires", ClientCookie.SECURE_ATTR}, "(domain GLOB '*' || ?)", new String[]{str}, null, null, null);
                if (query == null) {
                    return arrayList;
                }
                long currentTimeMillis = System.currentTimeMillis();
                if (query.moveToFirst()) {
                    int columnIndex = query.getColumnIndex("domain");
                    int columnIndex2 = query.getColumnIndex("path");
                    int columnIndex3 = query.getColumnIndex("name");
                    int columnIndex4 = query.getColumnIndex("value");
                    int columnIndex5 = query.getColumnIndex("expires");
                    int columnIndex6 = query.getColumnIndex(ClientCookie.SECURE_ATTR);
                    do {
                        d93 d93Var = new d93();
                        d93Var.a = query.getString(columnIndex);
                        d93Var.b = query.getString(columnIndex2);
                        d93Var.c = query.getString(columnIndex3);
                        d93Var.d = query.getString(columnIndex4);
                        if (query.isNull(columnIndex5)) {
                            d93Var.e = -1L;
                        } else {
                            d93Var.e = query.getLong(columnIndex5);
                        }
                        d93Var.f = query.getShort(columnIndex6) != 0;
                        d93Var.i = 1;
                        if (d93Var.e > currentTimeMillis) {
                            arrayList.add(d93Var);
                            if (c) {
                                Log.d("SwanCookieDatabase", "getCookiesForDomain cookie=" + d93Var.toString());
                            }
                        }
                    } while (query.moveToNext());
                    ko2.a(query);
                    return arrayList;
                }
                ko2.a(query);
                return arrayList;
            }
        }
        return (ArrayList) invokeL.objValue;
    }

    public final SQLiteDatabase f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            if (this.b) {
                return null;
            }
            g93 g93Var = this.a;
            if (g93Var != null) {
                return g93Var.getWritableDatabase();
            }
            String appId = h03.K().getAppId();
            if (!h03.K().E()) {
                ix1.k("SwanCookieDatabase", "getSQLiteDatabase currentAppId =" + appId);
                return null;
            }
            String t = q73.t(h03.K().q());
            ix1.k("SwanCookieDatabase", "initDbHelper name =" + t);
            g93 g93Var2 = new g93(pj2.c(), t);
            this.a = g93Var2;
            return g93Var2.getWritableDatabase();
        }
        return (SQLiteDatabase) invokeV.objValue;
    }

    public synchronized void g(Runnable runnable) {
        String str;
        String stackTraceString;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, runnable) == null) {
            synchronized (this) {
                SQLiteDatabase f = f();
                if (f == null) {
                    return;
                }
                try {
                    f.beginTransaction();
                    runnable.run();
                    f.setTransactionSuccessful();
                    try {
                        f.endTransaction();
                    } catch (Exception e) {
                        str = "SwanCookieDatabase";
                        stackTraceString = Log.getStackTraceString(e);
                        ix1.k(str, stackTraceString);
                    }
                } catch (Exception e2) {
                    ix1.k("SwanCookieDatabase", Log.getStackTraceString(e2));
                    try {
                        f.endTransaction();
                    } catch (Exception e3) {
                        str = "SwanCookieDatabase";
                        stackTraceString = Log.getStackTraceString(e3);
                        ix1.k(str, stackTraceString);
                    }
                }
            }
        }
    }

    public synchronized void h() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            synchronized (this) {
                f();
            }
        }
    }
}
