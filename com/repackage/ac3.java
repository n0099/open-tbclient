package com.repackage;

import android.app.Activity;
import android.content.Context;
import android.os.Build;
import android.os.Looper;
import android.text.TextUtils;
import android.text.format.Formatter;
import android.util.Log;
import androidx.annotation.NonNull;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.common.others.lang.StringUtil;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.searchbox.unitedscheme.SchemeCollecter;
import com.baidu.swan.apps.extcore.model.ExtensionCore;
import com.baidu.swan.apps.runtime.config.SwanAppConfigData;
import com.baidu.swan.apps.swancore.model.SwanCoreVersion;
import com.baidu.swan.pms.model.PMSAppInfo;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.webkit.sdk.WebView;
import com.repackage.ek2;
import com.repackage.hx1;
import java.util.List;
/* loaded from: classes5.dex */
public class ac3 {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean a;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-755861632, "Lcom/repackage/ac3;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-755861632, "Lcom/repackage/ac3;");
                return;
            }
        }
        a = rf1.a;
    }

    public static String a(int i, boolean z) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65537, null, new Object[]{Integer.valueOf(i), Boolean.valueOf(z)})) == null) {
            if (a) {
                return gv2.p() ? ub3.d(i, SchemeCollecter.CLASSIFY_SWAN_V8) : "";
            } else if (z) {
                return ub3.d(i, SchemeCollecter.CLASSIFY_SWAN_V8);
            } else {
                return ub3.d(i, SchemeCollecter.CLASSIFY_SWAN_WEBVIEW);
            }
        }
        return (String) invokeCommon.objValue;
    }

    public static String b() {
        InterceptResult invokeV;
        String str;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) {
            StringBuilder sb = new StringBuilder();
            SwanCoreVersion M = uk2.U().M();
            String str2 = "";
            if (M != null) {
                String str3 = M.swanCoreVersionName;
                str2 = SwanCoreVersion.getTypeString(M.swanCoreType);
                str = str3;
            } else {
                str = "";
            }
            sb.append("swanjs: ");
            sb.append(str2);
            sb.append("/");
            sb.append(str);
            return sb.toString();
        }
        return (String) invokeV.objValue;
    }

    public static String c(Context context) {
        InterceptResult invokeL;
        nl1 n3;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65539, null, context)) == null) {
            hz2 a0 = hz2.a0();
            if (context == null || a0 == null || a0.l() != 0) {
                return "";
            }
            StringBuilder sb = new StringBuilder();
            ek2.a V = a0.V();
            String formatFileSize = Formatter.formatFileSize(AppRuntime.getAppContext(), V.i1());
            sb.append("size: ");
            if (TextUtils.isEmpty(formatFileSize)) {
                formatFileSize = "";
            }
            sb.append(formatFileSize);
            sb.append("\n");
            sb.append("version: ");
            sb.append(TextUtils.isEmpty(V.w1()) ? "" : V.w1());
            sb.append(StringUtil.ARRAY_ELEMENT_SEPARATOR);
            sb.append("code: ");
            sb.append(TextUtils.isEmpty(V.v1()) ? "" : V.v1());
            sb.append("\n");
            sb.append("is opt pkg: ");
            sb.append(mp2.g().h(V.f0()));
            sb.append("\n");
            sb.append("swan native: ");
            sb.append(bj3.getContext() != null ? bj3.getContext().b() : "");
            sb.append("\n");
            sb.append(b());
            sb.append(StringUtil.ARRAY_ELEMENT_SEPARATOR);
            sb.append(e(0));
            sb.append("\n");
            sb.append("is v8 master: ");
            sb.append(b62.U().r0());
            sb.append("\n");
            String a2 = a(0, b62.U().r0());
            sb.append("is native desc: ");
            sb.append(!TextUtils.isEmpty(a2));
            sb.append("\n");
            boolean m = x92.m();
            sb.append("debugDynamicLibEnable: ");
            sb.append(m);
            sb.append('\n');
            if (m) {
                List<String> o = x92.o();
                sb.append("debugDynamicLibList: {");
                if (!o.isEmpty()) {
                    sb.append('\n');
                    for (String str : o) {
                        sb.append(str);
                        sb.append('\n');
                    }
                }
                sb.append("}\n");
            }
            py1 H = uk2.U().H();
            if (H != null && (n3 = H.n3()) != null) {
                int T = n3.T();
                sb.append("top fragment na-slave: ");
                sb.append(T == 1 ? "NA" : WebView.LOGTAG);
                sb.append("\n");
            }
            return sb.toString();
        }
        return (String) invokeL.objValue;
    }

    public static String d(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, context)) == null) {
            return "model: " + Build.MODEL + "\nandroid: " + Build.VERSION.RELEASE + StringUtil.ARRAY_ELEMENT_SEPARATOR + "api level: " + Build.VERSION.SDK_INT + "\ncuid: " + oi2.h0().i(oi2.c()) + "\n";
        }
        return (String) invokeL.objValue;
    }

    public static String e(int i) {
        InterceptResult invokeI;
        String str;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(65541, null, i)) == null) {
            String str2 = "";
            if (i != 0) {
                return "";
            }
            StringBuilder sb = new StringBuilder();
            ExtensionCore T = b62.U().T();
            if (T != null) {
                String str3 = T.extensionCoreVersionName;
                String typeString = SwanCoreVersion.getTypeString(T.extensionCoreType);
                str = str3;
                str2 = typeString;
            } else {
                str = "";
            }
            sb.append("extensionjs: ");
            sb.append(str2);
            sb.append("/");
            sb.append(str);
            return sb.toString();
        }
        return (String) invokeI.objValue;
    }

    public static String f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65542, null)) == null) {
            StringBuilder sb = new StringBuilder();
            SwanCoreVersion M = uk2.U().M();
            sb.append("game-core version : ");
            sb.append(m83.i(M, 1));
            return sb.toString();
        }
        return (String) invokeV.objValue;
    }

    public static String g(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65543, null, context)) == null) {
            hz2 a0 = hz2.a0();
            if (context == null || a0 == null || a0.l() != 1) {
                return "";
            }
            StringBuilder sb = new StringBuilder();
            ek2.a V = a0.V();
            sb.append(f());
            sb.append("\n");
            sb.append("host version : ");
            sb.append(bd3.u(AppRuntime.getAppContext(), AppRuntime.getAppContext().getPackageName()));
            sb.append("\n");
            sb.append("enable V8: ");
            sb.append(b62.U().r0());
            sb.append("\n");
            sb.append("aps version: ");
            sb.append(TextUtils.isEmpty(V.v1()) ? "" : V.v1());
            sb.append("\n");
            String formatFileSize = Formatter.formatFileSize(AppRuntime.getAppContext(), V.i1());
            sb.append("app bundle size: ");
            if (TextUtils.isEmpty(formatFileSize)) {
                formatFileSize = "";
            }
            sb.append(formatFileSize);
            sb.append("\n");
            sb.append("app bundle version: ");
            sb.append(TextUtils.isEmpty(V.w1()) ? "" : V.w1());
            sb.append("\n");
            sb.append("app is opt pkg: ");
            sb.append(mp2.g().h(V.f0()));
            sb.append("\n");
            String b = pi2.h().b();
            if (!TextUtils.isEmpty(b)) {
                sb.append("app sconsole version: ");
                sb.append(b);
                sb.append("\n");
            }
            sb.append("game engine version: ");
            sb.append("1.3.6.1");
            sb.append("\n");
            sb.append("so version: ");
            sb.append(v73.a().getLong("swan_so_installed_version_code_zeus", 0L));
            sb.append("\n");
            return sb.toString();
        }
        return (String) invokeL.objValue;
    }

    public static String h(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65544, null, context)) == null) {
            zi3 context2 = bj3.getContext();
            StringBuilder sb = new StringBuilder();
            sb.append("name: ");
            sb.append(oi2.n().a());
            sb.append(StringUtil.ARRAY_ELEMENT_SEPARATOR);
            sb.append("version: ");
            sb.append(context2 != null ? context2.h() : "");
            sb.append("\n");
            return sb.toString();
        }
        return (String) invokeL.objValue;
    }

    public static void i(Context context, ae3<String> ae3Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65545, null, context, ae3Var) == null) {
            jz1.e(ae3Var);
        }
    }

    public static String j(@NonNull hz2 hz2Var) {
        InterceptResult invokeL;
        String str;
        SwanAppConfigData.h hVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65546, null, hz2Var)) == null) {
            PMSAppInfo f0 = hz2Var.V().f0();
            if (f0 == null) {
                return "no info";
            }
            StringBuilder sb = new StringBuilder();
            boolean i = mp2.g().i(f0);
            boolean j0 = b62.U().j0();
            boolean z = false;
            SwanAppConfigData P = hz2Var.P();
            if (P == null || (hVar = P.t) == null) {
                str = "";
            } else {
                z = hVar.a;
                str = hVar.b;
            }
            sb.append("is server on: ");
            sb.append(i);
            sb.append("\n");
            sb.append("app.json info: ");
            sb.append("enabled/");
            sb.append(z);
            sb.append(", trigger/");
            sb.append(str);
            sb.append("\n");
            sb.append("is hit: ");
            sb.append(j0);
            sb.append("\n");
            return sb.toString();
        }
        return (String) invokeL.objValue;
    }

    public static String k() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65547, null)) == null) {
            long nanoTime = a ? System.nanoTime() : 0L;
            hx1.d g = hx1.c().g();
            if (a) {
                Log.d("SwanAppEnvironmentUtils", "获取内存信息耗时: " + ((System.nanoTime() - nanoTime) / 1000000) + " ms");
            }
            return "设备总内存：" + g.c + " M，设备剩余内存：" + g.d + " M，小程序启动占用内存：" + g.a + " M，宿主APP占用内存：" + g.b + " M\n";
        }
        return (String) invokeV.objValue;
    }

    public static String l(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65548, null, context)) == null) {
            long nanoTime = a ? System.nanoTime() : 0L;
            hz2 a0 = hz2.a0();
            if (a0 == null || context == null) {
                return "";
            }
            String str = "=========================\n= " + a0.V().K() + "\n=========================\n===== 小程序信息 =====\n" + c(context) + "\n===== 设备信息 =====\n" + d(context) + "\n===== 宿主信息 =====\n" + h(context) + "\n===== 内存信息 =====\n" + k() + "\n===== onPrefetch信息 =====\n" + j(a0) + "\n";
            if (a) {
                StringBuilder sb = new StringBuilder();
                sb.append("获取启动时信息耗时：");
                sb.append((System.nanoTime() - nanoTime) / 1000000);
                sb.append(" ms 是否主线程：");
                sb.append(Looper.getMainLooper() == Looper.myLooper());
                Log.d("SwanAppEnvironmentUtils", sb.toString());
            }
            hw1.k("SwanAppEnvironmentUtils", str);
            return str;
        }
        return (String) invokeL.objValue;
    }

    public static void m(Activity activity) {
        String str;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(65549, null, activity) == null) || activity == null) {
            return;
        }
        try {
            str = l(activity);
        } catch (Exception e) {
            if (!a) {
                hw1.l("SwanAppEnvironmentUtils", "getExtraInfo error", e);
                str = "";
            } else {
                throw e;
            }
        }
        hw1.k("SwanAppEnvironmentUtils", "recordExtraInfoToLogSystem\n--------------------ExtraInfo list----------------------\n" + str + "--------------------ExtraInfo end-----------------------");
        String k = oi2.g0().k();
        hw1.k("SwanAppEnvironmentUtils", "sid = " + k);
        h32.k();
    }
}
