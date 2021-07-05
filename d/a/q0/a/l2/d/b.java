package d.a.q0.a.l2.d;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.text.TextUtils;
import android.util.Log;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.frameworkData.IntentConfig;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import d.a.q0.a.e0.d;
import d.a.q0.a.k;
import java.util.ArrayList;
import org.apache.http.cookie.ClientCookie;
/* loaded from: classes8.dex */
public class b {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: c  reason: collision with root package name */
    public static final boolean f49338c;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public a f49339a;

    /* renamed from: b  reason: collision with root package name */
    public boolean f49340b;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(17633588, "Ld/a/q0/a/l2/d/b;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(17633588, "Ld/a/q0/a/l2/d/b;");
                return;
            }
        }
        f49338c = k.f49133a;
    }

    public b() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.f49339a = null;
    }

    public synchronized void a(d.a.q0.a.l2.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, aVar) == null) {
            synchronized (this) {
                if (aVar != null) {
                    if (!TextUtils.isEmpty(aVar.f49313a) && !TextUtils.isEmpty(aVar.f49315c) && !TextUtils.isEmpty(aVar.f49314b)) {
                        if (aVar.f49317e == -1) {
                            return;
                        }
                        SQLiteDatabase f2 = f();
                        if (f2 == null) {
                            return;
                        }
                        if (f49338c) {
                            Log.d("SwanCookieDatabase", "addCookie cookie=" + aVar.toString());
                        }
                        ContentValues contentValues = new ContentValues();
                        contentValues.put("domain", aVar.f49313a);
                        contentValues.put("path", aVar.f49314b);
                        contentValues.put("name", aVar.f49315c);
                        contentValues.put("value", aVar.f49316d);
                        contentValues.put("expires", Long.valueOf(aVar.f49317e));
                        contentValues.put(ClientCookie.SECURE_ATTR, Boolean.valueOf(aVar.f49318f));
                        f2.insert("cookies", null, contentValues);
                    }
                }
            }
        }
    }

    public synchronized void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            synchronized (this) {
                SQLiteDatabase f2 = f();
                if (f2 == null) {
                    return;
                }
                if (f49338c) {
                    Log.d("SwanCookieDatabase", "clearExpiredCookies");
                }
                f2.delete("cookies", "expires <= ?", new String[]{Long.toString(System.currentTimeMillis())});
            }
        }
    }

    public synchronized void c() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            synchronized (this) {
                if (this.f49339a == null) {
                    return;
                }
                try {
                    if (f49338c) {
                        Log.d("SwanCookieDatabase", IntentConfig.CLOSE);
                    }
                    this.f49339a.close();
                    this.f49339a = null;
                    this.f49340b = true;
                } catch (Exception e2) {
                    d.h("SwanCookieDatabase", "close fail:" + Log.getStackTraceString(e2));
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
                SQLiteDatabase f2 = f();
                if (f2 == null) {
                    return;
                }
                if (f49338c) {
                    Log.d("SwanCookieDatabase", "deleteCookies domain=" + str + ";path=" + str2 + ";name=" + str3);
                }
                f2.delete("cookies", "(domain == ?) AND (path == ?) AND (name == ?)", new String[]{str, str2, str3});
            }
        }
    }

    public synchronized ArrayList<d.a.q0.a.l2.a> e(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, str)) == null) {
            synchronized (this) {
                if (f49338c) {
                    Log.d("SwanCookieDatabase", "getCookiesForDomain baseDomain=" + str);
                }
                ArrayList<d.a.q0.a.l2.a> arrayList = new ArrayList<>();
                if (TextUtils.isEmpty(str)) {
                    return arrayList;
                }
                SQLiteDatabase f2 = f();
                if (f2 == null) {
                    return arrayList;
                }
                Cursor query = f2.query("cookies", new String[]{"_id", "domain", "path", "name", "value", "expires", ClientCookie.SECURE_ATTR}, "(domain GLOB '*' || ?)", new String[]{str}, null, null, null);
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
                        d.a.q0.a.l2.a aVar = new d.a.q0.a.l2.a();
                        aVar.f49313a = query.getString(columnIndex);
                        aVar.f49314b = query.getString(columnIndex2);
                        aVar.f49315c = query.getString(columnIndex3);
                        aVar.f49316d = query.getString(columnIndex4);
                        if (query.isNull(columnIndex5)) {
                            aVar.f49317e = -1L;
                        } else {
                            aVar.f49317e = query.getLong(columnIndex5);
                        }
                        aVar.f49318f = query.getShort(columnIndex6) != 0;
                        aVar.f49321i = 1;
                        if (aVar.f49317e > currentTimeMillis) {
                            arrayList.add(aVar);
                            if (f49338c) {
                                Log.d("SwanCookieDatabase", "getCookiesForDomain cookie=" + aVar.toString());
                            }
                        }
                    } while (query.moveToNext());
                    d.a.q0.a.i1.e.a.a(query);
                    return arrayList;
                }
                d.a.q0.a.i1.e.a.a(query);
                return arrayList;
            }
        }
        return (ArrayList) invokeL.objValue;
    }

    public final SQLiteDatabase f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            if (this.f49340b) {
                return null;
            }
            a aVar = this.f49339a;
            if (aVar != null) {
                return aVar.getWritableDatabase();
            }
            String appId = d.a.q0.a.a2.d.g().getAppId();
            if (!d.a.q0.a.a2.d.g().C()) {
                d.h("SwanCookieDatabase", "getSQLiteDatabase currentAppId =" + appId);
                return null;
            }
            String t = d.a.q0.a.k2.b.t(d.a.q0.a.a2.d.g().r());
            d.h("SwanCookieDatabase", "initDbHelper name =" + t);
            a aVar2 = new a(d.a.q0.a.c1.a.b(), t);
            this.f49339a = aVar2;
            return aVar2.getWritableDatabase();
        }
        return (SQLiteDatabase) invokeV.objValue;
    }

    public synchronized void g(Runnable runnable) {
        String str;
        String stackTraceString;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, runnable) == null) {
            synchronized (this) {
                SQLiteDatabase f2 = f();
                if (f2 == null) {
                    return;
                }
                try {
                    f2.beginTransaction();
                    runnable.run();
                    f2.setTransactionSuccessful();
                    try {
                        f2.endTransaction();
                    } catch (Exception e2) {
                        str = "SwanCookieDatabase";
                        stackTraceString = Log.getStackTraceString(e2);
                        d.h(str, stackTraceString);
                    }
                } catch (Exception e3) {
                    d.h("SwanCookieDatabase", Log.getStackTraceString(e3));
                    try {
                        f2.endTransaction();
                    } catch (Exception e4) {
                        str = "SwanCookieDatabase";
                        stackTraceString = Log.getStackTraceString(e4);
                        d.h(str, stackTraceString);
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
