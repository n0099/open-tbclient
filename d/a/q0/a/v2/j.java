package d.a.q0.a.v2;

import android.text.TextUtils;
import android.util.Log;
import com.baidu.mobads.container.util.AdIconUtil;
import com.baidu.searchbox.unitedscheme.SchemeCollecter;
import com.baidu.searchbox.v8engine.V8Engine;
import com.baidu.tbadk.core.util.StringHelper;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes8.dex */
public class j {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: a  reason: collision with root package name */
    public static final boolean f51339a;

    /* renamed from: b  reason: collision with root package name */
    public static List<String> f51340b;

    /* renamed from: c  reason: collision with root package name */
    public static List<String> f51341c;

    /* renamed from: d  reason: collision with root package name */
    public static final Object f51342d;

    /* renamed from: e  reason: collision with root package name */
    public static int f51343e;

    /* renamed from: f  reason: collision with root package name */
    public static int f51344f;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes8.dex */
    public static abstract class a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final boolean f51345a;

        public a(boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {Boolean.valueOf(z)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f51345a = z;
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(129924011, "Ld/a/q0/a/v2/j;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(129924011, "Ld/a/q0/a/v2/j;");
                return;
            }
        }
        f51339a = d.a.q0.a.k.f49133a;
        f51340b = new ArrayList();
        f51341c = new ArrayList();
        f51342d = new Object();
        f51343e = 0;
        f51344f = 0;
    }

    public static boolean a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65537, null)) == null) {
            if (f51343e == 2) {
                if (f51339a) {
                    Log.d("SwanAppCompat", "has used ab description");
                }
                return true;
            } else if (!l0.f("3.230.0")) {
                return d.a.q0.a.c1.a.Z().m() && !d.a.q0.a.k2.g.h.a().getBoolean("swan_app_js_native_ab_update_key", false);
            } else {
                if (f51339a) {
                    Log.w("SwanAppCompat", "disable chrome net, swan js version lower than 3.230.0");
                }
                return false;
            }
        }
        return invokeV.booleanValue;
    }

    public static String b(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, str)) == null) {
            d.a.q0.a.e0.d.b("JsNative", f51344f + "-true");
            return f51344f + "-true-" + str + "-" + c();
        }
        return (String) invokeL.objValue;
    }

    public static String c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) {
            StringBuilder sb = new StringBuilder();
            synchronized (f51342d) {
                if (f51340b != null) {
                    sb.append("v8list:{");
                    for (String str : f51340b) {
                        if (!TextUtils.isEmpty(str)) {
                            if (str.length() > 100) {
                                sb.append(str.substring(0, 99));
                                sb.append(StringHelper.STRING_MORE);
                            } else {
                                sb.append(str);
                            }
                            sb.append(";");
                        }
                    }
                    sb.append("},");
                }
                if (f51341c != null) {
                    sb.append("weblist:{");
                    for (String str2 : f51341c) {
                        if (!TextUtils.isEmpty(str2)) {
                            if (str2.length() > 100) {
                                sb.append(str2.substring(0, 99));
                                sb.append(StringHelper.STRING_MORE);
                            } else {
                                sb.append(str2);
                            }
                            sb.append(";");
                        }
                    }
                    sb.append("}");
                }
            }
            return sb.toString();
        }
        return (String) invokeV.objValue;
    }

    public static String d(int i2, boolean z) {
        InterceptResult invokeCommon;
        List<String> list;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65540, null, new Object[]{Integer.valueOf(i2), Boolean.valueOf(z)})) == null) {
            f51344f = 0;
            String str = z ? SchemeCollecter.CLASSIFY_SWAN_V8 : SchemeCollecter.CLASSIFY_SWAN_WEBVIEW;
            if (f51343e == 1) {
                if (f51339a) {
                    Log.d("SwanAppCompat", "type support default");
                }
                f51344f = 1;
                return SchemeCollecter.getSchemesDes(str, i2);
            }
            if (d.a.q0.a.u.e.j.d.b()) {
                synchronized (f51342d) {
                    if (z) {
                        list = f51340b;
                    } else {
                        list = f51341c;
                    }
                    if (list != null && list.size() > 0) {
                        if (f51339a) {
                            Log.d("SwanAppCompat", "support ab js native descriptions");
                        }
                        f51343e = 2;
                        f51344f = 2;
                        return list.get(i2);
                    } else if (list != null) {
                        f51344f = 3;
                    } else {
                        f51344f = 4;
                    }
                }
            }
            if (f51339a) {
                Log.d("SwanAppCompat", "use default descriptions");
            }
            f51343e = 1;
            return SchemeCollecter.getSchemesDes(str, i2);
        }
        return (String) invokeCommon.objValue;
    }

    public static boolean e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(AdIconUtil.AD_TEXT_ID, null)) == null) ? !l0.f("3.120.2") : invokeV.booleanValue;
    }

    public static void f() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(AdIconUtil.BAIDU_LOGO_ID, null) == null) {
            if (f51339a) {
                Log.d("SwanAppCompat", "on App upgrade");
            }
            if (d.a.q0.n.c.b() != null && d.a.q0.n.j.i.m.b()) {
                d.a.q0.n.c.b().j().putString("key_online_description_fix_version", "0");
            }
            d.a.q0.a.k2.g.h.a().putBoolean("swan_app_js_native_ab_update_key", true);
            d.a.q0.a.u.e.j.d.f(false);
        }
    }

    public static void g() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(65543, null) == null) && f51339a) {
            Log.e("JsNative", f51344f + "-true");
        }
    }

    public static void h() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65544, null) == null) {
            if (f51339a) {
                Log.d("SwanAppCompat", "start release descriptions");
            }
            synchronized (f51342d) {
                f51343e = 0;
                f51340b = new ArrayList();
                f51341c = new ArrayList();
            }
        }
    }

    public static void i() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65545, null) == null) {
            if (f51339a) {
                Log.d("SwanAppCompat", "start prepare ab description");
            }
            synchronized (f51342d) {
                j(true);
                j(false);
            }
            if (f51339a) {
                Log.d("SwanAppCompat", "end prepare ab description");
            }
        }
    }

    public static void j(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(65546, null, z) == null) {
            if (f51339a) {
                StringBuilder sb = new StringBuilder();
                sb.append("start prepare ab description :");
                sb.append(z ? V8Engine.TYPE_V8 : "webview");
                Log.d("SwanAppCompat", sb.toString());
            }
            d.a.q0.a.v2.b1.b.a aVar = new d.a.q0.a.v2.b1.b.a(z);
            if (d.a.q0.a.k2.g.h.a().getBoolean("swan_app_js_native_ab_update_key", false)) {
                if (!aVar.a(3)) {
                    return;
                }
                d.a.q0.a.k2.g.h.a().putBoolean("swan_app_js_native_ab_update_key", false);
            }
            List<String> d2 = aVar.d();
            if (d2 != null) {
                k(d2, z);
            }
        }
    }

    public static void k(List<String> list, boolean z) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLZ(65547, null, list, z) == null) && list != null && f51343e == 0) {
            if (z) {
                f51340b = list;
            } else {
                f51341c = list;
            }
            if (f51339a) {
                StringBuilder sb = new StringBuilder();
                sb.append("has update descriptions, list :");
                sb.append(list.toString());
                sb.append(" type :");
                sb.append(z ? V8Engine.TYPE_V8 : "webview");
                Log.d("SwanAppCompat", sb.toString());
            }
        }
    }
}
