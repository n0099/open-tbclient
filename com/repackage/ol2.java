package com.repackage;

import android.app.Activity;
import android.content.ComponentName;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.searchbox.performance.speed.task.LaunchTaskConstants;
import com.baidu.searchbox.process.ipc.delegate.provider.ProviderDelegation;
import com.baidu.searchbox.process.ipc.util.ProcessUtils;
import com.baidu.swan.apps.SwanAppActivity;
import com.baidu.swan.apps.SwanAppClearCacheErrorActivity;
import com.baidu.swan.apps.SwanAppErrorActivity;
import com.baidu.swan.apps.env.launch.SwanLauncher;
import com.baidu.swan.apps.network.SwanAppNetworkUtils;
import com.baidu.swan.apps.process.SwanAppProcessInfo;
import com.baidu.swan.apps.res.widget.dialog.BaseActivityDialog;
import com.baidu.swan.apps.scheme.actions.forbidden.ForbiddenInfo;
import com.baidu.swan.apps.view.SwanAppErrorDialog;
import com.baidu.swan.pms.model.PMSAppInfo;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.facebook.common.internal.Sets;
import java.io.File;
import java.util.Set;
import java.util.concurrent.TimeUnit;
/* loaded from: classes6.dex */
public class ol2 {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean a;
    public static boolean b;
    public static final long c;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes6.dex */
    public static class a implements rx2 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ int a;
        public final /* synthetic */ Set b;
        public final /* synthetic */ String c;
        public final /* synthetic */ String d;

        public a(int i, Set set, String str, String str2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {Integer.valueOf(i), set, str, str2};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = i;
            this.b = set;
            this.c = str;
            this.d = str2;
        }

        @Override // com.repackage.rx2
        public void a(String str, tx2 tx2Var) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeLL(1048576, this, str, tx2Var) == null) && tx2Var.b.index == this.a && this.b.contains(str)) {
                vx2.k().h(this);
                ol2.i(this.c, this.d);
            }
        }

        @Override // com.repackage.rx2
        public void timeout() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                ol2.i(this.c, this.d);
            }
        }
    }

    /* loaded from: classes6.dex */
    public static class b implements DialogInterface.OnDismissListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public b() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        @Override // android.content.DialogInterface.OnDismissListener
        public void onDismiss(DialogInterface dialogInterface) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, dialogInterface) == null) {
                boolean unused = ol2.b = false;
            }
        }
    }

    /* loaded from: classes6.dex */
    public static class c extends ProviderDelegation {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* loaded from: classes6.dex */
        public class a implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ Bundle a;

            public a(c cVar, Bundle bundle) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {cVar, bundle};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.a = bundle;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    ol2.j(this.a.getString("arg_title"), this.a.getString("arg_message"), this.a.getInt("arg_match_target_down", SwanAppProcessInfo.UNKNOWN.index));
                }
            }
        }

        public c() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        @Override // com.baidu.searchbox.process.ipc.delegate.provider.ProviderDelegation
        public Bundle execCall(Bundle bundle) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, bundle)) == null) {
                if (bundle != null) {
                    oe3.e0(new a(this, bundle));
                    return null;
                }
                return null;
            }
            return (Bundle) invokeL.objValue;
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-755435940, "Lcom/repackage/ol2;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-755435940, "Lcom/repackage/ol2;");
                return;
            }
        }
        a = eh1.a;
        b = false;
        c = TimeUnit.SECONDS.toMillis(1L);
    }

    public static String d(@NonNull Context context, String str, long j) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeCommon = interceptable.invokeCommon(InputDeviceCompat.SOURCE_TRACKBALL, null, new Object[]{context, str, Long.valueOf(j)})) == null) ? h(context, str) ? SwanAppErrorActivity.TYPE_NETWORK_ERROR : j == 2205 ? SwanAppErrorActivity.TYPE_DISK_LACK : j == 49 ? SwanAppErrorActivity.TYPE_MEMORY_LACK : SwanAppErrorActivity.TYPE_NORMAL : (String) invokeCommon.objValue;
    }

    public static void e(Context context, @NonNull nc3 nc3Var, int i, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLIL(65541, null, context, nc3Var, i, str) == null) {
            f(context, nc3Var, i, str, null);
        }
    }

    public static void f(Context context, @NonNull nc3 nc3Var, int i, String str, Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65542, null, new Object[]{context, nc3Var, Integer.valueOf(i), str, bundle}) == null) {
            zt2.k(nc3Var);
            g(context, nc3Var, i, str, false, bundle);
        }
    }

    public static void g(Context context, @NonNull nc3 nc3Var, int i, String str, boolean z, Bundle bundle) {
        File a2;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(65543, null, new Object[]{context, nc3Var, Integer.valueOf(i), str, Boolean.valueOf(z), bundle}) == null) || context == null) {
            return;
        }
        if ((context instanceof SwanAppActivity) && ((SwanAppActivity) context).isDestroyed()) {
            ux1.k("LaunchError", "launch activity closed, ignore launch error");
            return;
        }
        SwanLauncher.p("LaunchError", "处理调起错误 errorCode=" + nc3Var);
        String i2 = z93.i(hm2.U().M(), i);
        long h = nc3Var.h();
        String r = nc3Var.r();
        boolean z2 = 1020 == h && !TextUtils.isEmpty(r);
        String a3 = z2 ? r : qc4.b().a(h);
        String format = String.format(context.getResources().getString(R.string.obfuscated_res_0x7f0f019d), oe3.D(), i2, String.valueOf(nc3Var.a()));
        if (!bk2.T().a(context, str, nc3Var)) {
            if (i == 0) {
                String d = d(context, str, h);
                ForbiddenInfo forbiddenInfo = new ForbiddenInfo(t03.J().r().V(), a3, format);
                forbiddenInfo.enableSlidingFlag = -1;
                mg3.c().n(nc3Var);
                l(context, d, nc3Var, forbiddenInfo, bundle);
            } else if (i == 1) {
                m(context, str, a3, z2 ? r : qc4.b().c(h), format, (z ? SwanAppProcessInfo.current() : SwanAppProcessInfo.UNKNOWN).index);
            }
        }
        StringBuilder sb = new StringBuilder();
        String b2 = id3.b(id3.a(), "yyyy-MM-dd HH:mm:ss");
        if (!TextUtils.isEmpty(str)) {
            sb.append(b2);
            sb.append(": ");
            sb.append(str);
            sb.append("\r\n");
        }
        sb.append(b2);
        sb.append(": ");
        sb.append(format);
        sb.append("\r\n");
        pd3.c(sb.toString(), false);
        if (eh1.a) {
            String y = oe3.y();
            if (TextUtils.isEmpty(y) || (a2 = jd3.a()) == null) {
                return;
            }
            File file = new File(a2.getPath(), "error_dialog_info.txt");
            xg4.j(file);
            StringBuilder sb2 = new StringBuilder();
            if (!TextUtils.isEmpty(format)) {
                sb2.append(format);
                sb2.append("\n");
            }
            sb2.append(y);
            sb2.append("\n");
            xg4.N(sb2.toString(), file);
        }
    }

    public static boolean h(@NonNull Context context, @Nullable String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLL = interceptable.invokeLL(65544, null, context, str)) == null) ? (TextUtils.isEmpty(str) || SwanAppNetworkUtils.i(context) || bm2.d(str)) ? false : true : invokeLL.booleanValue;
    }

    public static void i(String str, String str2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(65545, null, str, str2) == null) || b) {
            return;
        }
        BaseActivityDialog.e newBuilder = SwanAppErrorDialog.newBuilder();
        newBuilder.C(str);
        newBuilder.y(new b());
        newBuilder.v(str2);
        newBuilder.z(R.string.obfuscated_res_0x7f0f0114, null);
        newBuilder.D();
        b = true;
    }

    public static void j(String str, String str2, int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLI(65546, null, str, str2, i) == null) {
            if (TextUtils.isEmpty(str) && TextUtils.isEmpty(str2)) {
                return;
            }
            if (!ProcessUtils.isMainProcess()) {
                Bundle bundle = new Bundle();
                bundle.putString("arg_title", str);
                bundle.putString("arg_message", str2);
                bundle.putInt("arg_match_target_down", i);
                hx2.c(c.class, bundle);
                return;
            }
            if (a) {
                Log.d("LaunchError", "show normal err dialog, isShowing=" + b);
            }
            if (!SwanAppProcessInfo.checkProcessId(i)) {
                i(str, str2);
                return;
            }
            vx2.k().c(new a(i, Sets.newHashSet("event_puppet_unload_app", "event_puppet_offline"), str, str2), c);
        }
    }

    public static void k(@NonNull Context context, @NonNull String str, @NonNull String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(65547, null, context, str, str2) == null) {
            String format = String.format(context.getResources().getString(R.string.obfuscated_res_0x7f0f12bc), str, str2);
            if (a) {
                Log.d("LaunchError", "show normal err toast: " + format);
            }
            m03 g = m03.g(AppRuntime.getAppContext(), format);
            g.q(Integer.MAX_VALUE);
            g.F();
        }
    }

    public static void l(Context context, String str, nc3 nc3Var, ForbiddenInfo forbiddenInfo, Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLLL(65548, null, context, str, nc3Var, forbiddenInfo, bundle) == null) {
            Intent intent = new Intent();
            if (bundle != null) {
                intent.putExtras(bundle);
            }
            int g = sq2.g();
            int h = oe3.O() ? 0 : sq2.h(context);
            intent.putExtra(SwanAppErrorActivity.KEY_SWAN_ERROR_TYPE, str);
            intent.putExtra(SwanAppErrorActivity.KEY_SWAN_ERROR_CODE, String.valueOf(nc3Var.a()));
            intent.putExtra(SwanAppErrorActivity.KEY_ERROR_FORBIDDEN_INFO, forbiddenInfo);
            intent.putExtra(SwanAppErrorActivity.KEY_ERROR_MENU_NOTICE_COUNT, g);
            intent.putExtra(SwanAppErrorActivity.KEY_ERROR_MENU_PRIVACY_COUNT, h);
            PMSAppInfo f0 = t03.J().r().V().f0();
            if (f0 != null) {
                mg3.c().n(nc3Var);
                intent.putExtra("webUrl", f0.webUrl);
                intent.putExtra(SwanAppErrorActivity.KEY_SWAN_WEB_PERMIT, f0.webPermit);
            }
            if (TextUtils.equals(str, SwanAppErrorActivity.TYPE_DISK_LACK) && oe3.G()) {
                intent.setComponent(new ComponentName(context, SwanAppClearCacheErrorActivity.class));
            } else {
                intent.setComponent(new ComponentName(context, SwanAppErrorActivity.class));
            }
            if (!(context instanceof Activity)) {
                intent.addFlags(LaunchTaskConstants.OTHER_PROCESS);
            }
            context.startActivity(intent);
        }
    }

    public static void m(Context context, String str, String str2, String str3, String str4, int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65549, null, new Object[]{context, str, str2, str3, str4, Integer.valueOf(i)}) == null) {
            if (h(context, str)) {
                if (xd3.a(context)) {
                    m03.f(AppRuntime.getAppContext(), R.string.obfuscated_res_0x7f0f0198).G();
                    return;
                }
                if (a) {
                    Log.w("LaunchError", "show network err toast: areNotificationsEnabled false");
                }
                j(str2, str4, i);
            } else if (xd3.a(context)) {
                k(context, str3, str4);
            } else {
                if (a) {
                    Log.w("LaunchError", "handleLaunchError: areNotificationsEnabled false");
                }
                j(str2, str4, i);
            }
        }
    }
}
