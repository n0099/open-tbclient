package d.a.n0.a.v2;

import android.text.TextUtils;
import android.util.Log;
import androidx.core.view.InputDeviceCompat;
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
/* loaded from: classes7.dex */
public class j {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: a  reason: collision with root package name */
    public static final boolean f48037a;

    /* renamed from: b  reason: collision with root package name */
    public static List<String> f48038b;

    /* renamed from: c  reason: collision with root package name */
    public static List<String> f48039c;

    /* renamed from: d  reason: collision with root package name */
    public static final Object f48040d;

    /* renamed from: e  reason: collision with root package name */
    public static int f48041e;

    /* renamed from: f  reason: collision with root package name */
    public static int f48042f;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes7.dex */
    public static abstract class a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final boolean f48043a;

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
            this.f48043a = z;
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(719464526, "Ld/a/n0/a/v2/j;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(719464526, "Ld/a/n0/a/v2/j;");
                return;
            }
        }
        f48037a = d.a.n0.a.k.f45831a;
        f48038b = new ArrayList();
        f48039c = new ArrayList();
        f48040d = new Object();
        f48041e = 0;
        f48042f = 0;
    }

    public static boolean a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65537, null)) == null) {
            if (f48041e == 2) {
                if (f48037a) {
                    Log.d("SwanAppCompat", "has used ab description");
                }
                return true;
            } else if (!l0.f("3.230.0")) {
                return d.a.n0.a.c1.a.Z().m() && !d.a.n0.a.k2.g.h.a().getBoolean("swan_app_js_native_ab_update_key", false);
            } else {
                if (f48037a) {
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
            d.a.n0.a.e0.d.b("JsNative", f48042f + "-true");
            return f48042f + "-true-" + str + "-" + c();
        }
        return (String) invokeL.objValue;
    }

    public static String c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) {
            StringBuilder sb = new StringBuilder();
            synchronized (f48040d) {
                if (f48038b != null) {
                    sb.append("v8list:{");
                    for (String str : f48038b) {
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
                if (f48039c != null) {
                    sb.append("weblist:{");
                    for (String str2 : f48039c) {
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
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(InputDeviceCompat.SOURCE_TRACKBALL, null, new Object[]{Integer.valueOf(i2), Boolean.valueOf(z)})) == null) {
            f48042f = 0;
            String str = z ? SchemeCollecter.CLASSIFY_SWAN_V8 : SchemeCollecter.CLASSIFY_SWAN_WEBVIEW;
            if (f48041e == 1) {
                if (f48037a) {
                    Log.d("SwanAppCompat", "type support default");
                }
                f48042f = 1;
                return SchemeCollecter.getSchemesDes(str, i2);
            }
            if (d.a.n0.a.u.e.j.d.b()) {
                synchronized (f48040d) {
                    if (z) {
                        list = f48038b;
                    } else {
                        list = f48039c;
                    }
                    if (list != null && list.size() > 0) {
                        if (f48037a) {
                            Log.d("SwanAppCompat", "support ab js native descriptions");
                        }
                        f48041e = 2;
                        f48042f = 2;
                        return list.get(i2);
                    } else if (list != null) {
                        f48042f = 3;
                    } else {
                        f48042f = 4;
                    }
                }
            }
            if (f48037a) {
                Log.d("SwanAppCompat", "use default descriptions");
            }
            f48041e = 1;
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
            if (f48037a) {
                Log.d("SwanAppCompat", "on App upgrade");
            }
            if (d.a.n0.n.c.b() != null && d.a.n0.n.j.i.m.b()) {
                d.a.n0.n.c.b().j().putString("key_online_description_fix_version", "0");
            }
            d.a.n0.a.k2.g.h.a().putBoolean("swan_app_js_native_ab_update_key", true);
            d.a.n0.a.u.e.j.d.f(false);
        }
    }

    public static void g() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(65543, null) == null) && f48037a) {
            Log.e("JsNative", f48042f + "-true");
        }
    }

    public static void h() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65544, null) == null) {
            if (f48037a) {
                Log.d("SwanAppCompat", "start release descriptions");
            }
            synchronized (f48040d) {
                f48041e = 0;
                f48038b = new ArrayList();
                f48039c = new ArrayList();
            }
        }
    }

    public static void i() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65545, null) == null) {
            if (f48037a) {
                Log.d("SwanAppCompat", "start prepare ab description");
            }
            synchronized (f48040d) {
                j(true);
                j(false);
            }
            if (f48037a) {
                Log.d("SwanAppCompat", "end prepare ab description");
            }
        }
    }

    public static void j(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(65546, null, z) == null) {
            if (f48037a) {
                StringBuilder sb = new StringBuilder();
                sb.append("start prepare ab description :");
                sb.append(z ? V8Engine.TYPE_V8 : "webview");
                Log.d("SwanAppCompat", sb.toString());
            }
            d.a.n0.a.v2.b1.b.a aVar = new d.a.n0.a.v2.b1.b.a(z);
            if (d.a.n0.a.k2.g.h.a().getBoolean("swan_app_js_native_ab_update_key", false)) {
                if (!aVar.a(3)) {
                    return;
                }
                d.a.n0.a.k2.g.h.a().putBoolean("swan_app_js_native_ab_update_key", false);
            }
            List<String> d2 = aVar.d();
            if (d2 != null) {
                k(d2, z);
            }
        }
    }

    public static void k(List<String> list, boolean z) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLZ(65547, null, list, z) == null) && list != null && f48041e == 0) {
            if (z) {
                f48038b = list;
            } else {
                f48039c = list;
            }
            if (f48037a) {
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
