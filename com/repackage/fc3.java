package com.repackage;

import android.text.TextUtils;
import android.util.Log;
import androidx.core.view.InputDeviceCompat;
import com.baidu.searchbox.unitedscheme.SchemeCollecter;
import com.baidu.searchbox.v8engine.V8Engine;
import com.baidu.tbadk.core.atomData.AlbumActivityConfig;
import com.baidu.tbadk.core.util.StringHelper;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.yy.hiidostatis.defs.obj.ParamableElem;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes6.dex */
public class fc3 {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean a;
    public static List<String> b;
    public static List<String> c;
    public static final Object d;
    public static int e;
    public static int f;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes6.dex */
    public static abstract class a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final boolean a;

        public a(boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {Boolean.valueOf(z)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = z;
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-755712677, "Lcom/repackage/fc3;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-755712677, "Lcom/repackage/fc3;");
                return;
            }
        }
        a = cg1.a;
        b = new ArrayList();
        c = new ArrayList();
        d = new Object();
        e = 0;
        f = 0;
    }

    public static boolean a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65537, null)) == null) {
            if (e()) {
                if (a) {
                    Log.d("SwanAppCompat", "has used ab description");
                }
                return true;
            }
            return !g83.a().getBoolean("swan_app_js_native_ab_update_key", false);
        }
        return invokeV.booleanValue;
    }

    public static String b(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, str)) == null) {
            sw1.c("JsNative", f + "-true");
            return f + "-true-" + str + "-" + c();
        }
        return (String) invokeL.objValue;
    }

    public static String c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) {
            StringBuilder sb = new StringBuilder();
            synchronized (d) {
                if (b != null) {
                    sb.append("v8list:{");
                    for (String str : b) {
                        if (!TextUtils.isEmpty(str)) {
                            if (str.length() > 100) {
                                sb.append(str.substring(0, 99));
                                sb.append(StringHelper.STRING_MORE);
                            } else {
                                sb.append(str);
                            }
                            sb.append(ParamableElem.DIVIDE_PARAM);
                        }
                    }
                    sb.append("},");
                }
                if (c != null) {
                    sb.append("weblist:{");
                    for (String str2 : c) {
                        if (!TextUtils.isEmpty(str2)) {
                            if (str2.length() > 100) {
                                sb.append(str2.substring(0, 99));
                                sb.append(StringHelper.STRING_MORE);
                            } else {
                                sb.append(str2);
                            }
                            sb.append(ParamableElem.DIVIDE_PARAM);
                        }
                    }
                    sb.append("}");
                }
            }
            return sb.toString();
        }
        return (String) invokeV.objValue;
    }

    public static String d(int i, String str) {
        InterceptResult invokeIL;
        List<String> list;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeIL = interceptable.invokeIL(InputDeviceCompat.SOURCE_TRACKBALL, null, i, str)) == null) {
            f = 0;
            if (e == 1) {
                sw1.i("SwanAppCompat", "type support default");
                f = 1;
                return SchemeCollecter.getSchemesDes(str, i);
            } else if (TextUtils.equals(str, "swan/web")) {
                return SchemeCollecter.getSchemesDes(str, i);
            } else {
                if (a() && !gk2.b().isEmpty()) {
                    synchronized (d) {
                        if (TextUtils.equals(str, SchemeCollecter.CLASSIFY_SWAN_V8)) {
                            list = b;
                        } else {
                            list = c;
                        }
                        if (list != null && list.size() > 0) {
                            if (a) {
                                Log.d("SwanAppCompat", "support ab js native descriptions");
                            }
                            e = 2;
                            f = 2;
                            return list.get(i);
                        } else if (list != null) {
                            f = 3;
                        } else {
                            f = 4;
                        }
                    }
                }
                if (a) {
                    Log.d("SwanAppCompat", "use default descriptions");
                }
                e = 1;
                return SchemeCollecter.getSchemesDes(str, i);
            }
        }
        return (String) invokeIL.objValue;
    }

    public static boolean e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65541, null)) == null) ? e == 2 : invokeV.booleanValue;
    }

    public static boolean f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65542, null)) == null) ? !hd3.f("3.320.0") : invokeV.booleanValue;
    }

    public static boolean g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65543, null)) == null) ? !hd3.f("3.120.2") : invokeV.booleanValue;
    }

    public static void h() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65544, null) == null) {
            if (a) {
                Log.d("SwanAppCompat", "on App upgrade");
            }
            if (b74.b() != null && xb4.b()) {
                b74.b().i().putString("key_online_description_fix_version", "0");
            }
            g83.a().putBoolean("swan_app_js_native_ab_update_key", true);
        }
    }

    public static void i() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(65545, null) == null) && a) {
            Log.e("JsNative", f + "-true");
        }
    }

    public static void j() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65546, null) == null) {
            if (a) {
                Log.d("SwanAppCompat", "start release descriptions");
            }
            synchronized (d) {
                e = 0;
                b = new ArrayList();
                c = new ArrayList();
            }
        }
    }

    public static void k() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65547, null) == null) {
            if (a) {
                Log.d("SwanAppCompat", "start prepare ab description");
            }
            synchronized (d) {
                l(true);
                l(false);
            }
            if (a) {
                Log.d("SwanAppCompat", "end prepare ab description");
            }
        }
    }

    public static void l(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(65548, null, z) == null) {
            if (a) {
                StringBuilder sb = new StringBuilder();
                sb.append("start prepare ab description :");
                sb.append(z ? V8Engine.TYPE_V8 : AlbumActivityConfig.FROM_WEB_VIEW);
                Log.d("SwanAppCompat", sb.toString());
            }
            de3 de3Var = new de3(z);
            String a2 = gk2.a();
            String string = g83.a().getString("swan_app_js_native_ab_sign", null);
            if (!TextUtils.equals(a2, string)) {
                if (a) {
                    Log.w("SwanAppCompat", "js desc sign change: old=" + string + ", new=" + a2);
                }
                if (!de3Var.a(3)) {
                    return;
                }
                g83.a().putString("swan_app_js_native_ab_sign", a2);
            } else if (g83.a().getBoolean("swan_app_js_native_ab_update_key", false)) {
                if (!de3Var.a(3)) {
                    return;
                }
                g83.a().putBoolean("swan_app_js_native_ab_update_key", false);
            }
            List<String> d2 = de3Var.d();
            if (d2 != null) {
                m(d2, z);
            }
        }
    }

    public static void m(List<String> list, boolean z) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLZ(65549, null, list, z) == null) && list != null && e == 0) {
            if (z) {
                b = list;
            } else {
                c = list;
            }
            if (a) {
                StringBuilder sb = new StringBuilder();
                sb.append("has update descriptions, list :");
                sb.append(list.toString());
                sb.append(" type :");
                sb.append(z ? V8Engine.TYPE_V8 : AlbumActivityConfig.FROM_WEB_VIEW);
                Log.d("SwanAppCompat", sb.toString());
            }
        }
    }
}
