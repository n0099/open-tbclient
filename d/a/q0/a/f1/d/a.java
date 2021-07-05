package d.a.q0.a.f1.d;

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
import com.alibaba.fastjson.asm.Label;
import com.android.internal.http.multipart.Part;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.mobads.container.util.AdIconUtil;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.searchbox.process.ipc.delegate.provider.ProviderDelegation;
import com.baidu.searchbox.process.ipc.util.ProcessUtils;
import com.baidu.swan.apps.SwanAppActivity;
import com.baidu.swan.apps.SwanAppErrorActivity;
import com.baidu.swan.apps.network.SwanAppNetworkUtils;
import com.baidu.swan.apps.process.SwanAppProcessInfo;
import com.baidu.swan.apps.res.widget.dialog.BaseActivityDialog;
import com.baidu.swan.apps.scheme.actions.forbidden.ForbiddenInfo;
import com.baidu.swan.apps.view.SwanAppErrorDialog;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.facebook.common.internal.Sets;
import d.a.q0.a.e0.d;
import d.a.q0.a.g1.f;
import d.a.q0.a.k;
import d.a.q0.a.r1.h;
import d.a.q0.a.v1.c.f.e;
import d.a.q0.a.v2.l;
import d.a.q0.a.v2.q0;
import d.a.q0.a.v2.r;
import d.a.q0.a.v2.z;
import java.io.File;
import java.util.Set;
import java.util.concurrent.TimeUnit;
/* loaded from: classes8.dex */
public class a {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: a  reason: collision with root package name */
    public static final boolean f47762a;

    /* renamed from: b  reason: collision with root package name */
    public static boolean f47763b;

    /* renamed from: c  reason: collision with root package name */
    public static final long f47764c;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: d.a.q0.a.f1.d.a$a  reason: collision with other inner class name */
    /* loaded from: classes8.dex */
    public static class C0749a implements d.a.q0.a.v1.c.f.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ int f47765a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ Set f47766b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ String f47767c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ String f47768d;

        public C0749a(int i2, Set set, String str, String str2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {Integer.valueOf(i2), set, str, str2};
                interceptable.invokeUnInit(65536, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f47765a = i2;
            this.f47766b = set;
            this.f47767c = str;
            this.f47768d = str2;
        }

        @Override // d.a.q0.a.v1.c.f.a
        public void a(String str, d.a.q0.a.v1.c.f.c cVar) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeLL(1048576, this, str, cVar) == null) && cVar.f51259f.index == this.f47765a && this.f47766b.contains(str)) {
                e.k().h(this);
                a.h(this.f47767c, this.f47768d);
            }
        }

        @Override // d.a.q0.a.v1.c.f.a
        public void timeout() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                a.h(this.f47767c, this.f47768d);
            }
        }
    }

    /* loaded from: classes8.dex */
    public static class b implements DialogInterface.OnDismissListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public b() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        @Override // android.content.DialogInterface.OnDismissListener
        public void onDismiss(DialogInterface dialogInterface) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, dialogInterface) == null) {
                boolean unused = a.f47763b = false;
            }
        }
    }

    /* loaded from: classes8.dex */
    public static class c extends ProviderDelegation {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: d.a.q0.a.f1.d.a$c$a  reason: collision with other inner class name */
        /* loaded from: classes8.dex */
        public class RunnableC0750a implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ Bundle f47769e;

            public RunnableC0750a(c cVar, Bundle bundle) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {cVar, bundle};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.f47769e = bundle;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    a.i(this.f47769e.getString("arg_title"), this.f47769e.getString("arg_message"), this.f47769e.getInt("arg_match_target_down", SwanAppProcessInfo.UNKNOWN.index));
                }
            }
        }

        public c() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
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
                    q0.b0(new RunnableC0750a(this, bundle));
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
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1041050384, "Ld/a/q0/a/f1/d/a;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-1041050384, "Ld/a/q0/a/f1/d/a;");
                return;
            }
        }
        f47762a = k.f49133a;
        f47763b = false;
        f47764c = TimeUnit.SECONDS.toMillis(1L);
    }

    public static void d(Context context, @NonNull d.a.q0.a.q2.a aVar, int i2, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLIL(65540, null, context, aVar, i2, str) == null) {
            e(context, aVar, i2, str, null);
        }
    }

    public static void e(Context context, @NonNull d.a.q0.a.q2.a aVar, int i2, String str, Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(AdIconUtil.AD_TEXT_ID, null, new Object[]{context, aVar, Integer.valueOf(i2), str, bundle}) == null) {
            h.k(aVar);
            f(context, aVar, i2, str, false, bundle);
        }
    }

    public static void f(Context context, @NonNull d.a.q0.a.q2.a aVar, int i2, String str, boolean z, Bundle bundle) {
        File a2;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(AdIconUtil.BAIDU_LOGO_ID, null, new Object[]{context, aVar, Integer.valueOf(i2), str, Boolean.valueOf(z), bundle}) == null) || context == null) {
            return;
        }
        if ((context instanceof SwanAppActivity) && ((SwanAppActivity) context).isDestroyed()) {
            d.h("LaunchError", "launch activity closed, ignore launch error");
            return;
        }
        d.h("LaunchError", "handleLaunchError errCode: " + aVar.toString());
        String i3 = d.a.q0.a.m2.b.i(f.V().N(), i2);
        long g2 = aVar.g();
        String q = aVar.q();
        boolean z2 = 1020 == g2 && !TextUtils.isEmpty(q);
        String a3 = z2 ? q : d.a.q0.n.j.i.f.b().a(g2);
        String format = String.format(context.getResources().getString(d.a.q0.a.h.aiapps_open_failed_detail_format), q0.D(), i3, String.valueOf(aVar.a()));
        if (!d.a.q0.a.c1.a.O().a(context, str, aVar)) {
            if (i2 == 0) {
                String str2 = g(context, str) ? SwanAppErrorActivity.TYPE_NETWORK_ERROR : SwanAppErrorActivity.TYPE_NORMAL;
                ForbiddenInfo forbiddenInfo = new ForbiddenInfo(d.a.q0.a.a2.d.g().r().L(), a3, format);
                forbiddenInfo.enableSlidingFlag = -1;
                k(context, str2, bundle, forbiddenInfo);
            } else if (i2 == 1) {
                l(context, str, a3, z2 ? q : d.a.q0.n.j.i.f.b().c(g2), format, (z ? SwanAppProcessInfo.current() : SwanAppProcessInfo.UNKNOWN).index);
            }
        }
        StringBuilder sb = new StringBuilder();
        String b2 = d.a.q0.a.v2.k.b(d.a.q0.a.v2.k.a(), "yyyy-MM-dd HH:mm:ss");
        if (!TextUtils.isEmpty(str)) {
            sb.append(b2);
            sb.append(": ");
            sb.append(str);
            sb.append(Part.CRLF);
        }
        sb.append(b2);
        sb.append(": ");
        sb.append(format);
        sb.append(Part.CRLF);
        r.c(sb.toString(), false);
        if (k.f49133a) {
            String y = q0.y();
            if (TextUtils.isEmpty(y) || (a2 = l.a()) == null) {
                return;
            }
            File file = new File(a2.getPath(), "error_dialog_info.txt");
            d.a.q0.t.d.i(file);
            StringBuilder sb2 = new StringBuilder();
            if (!TextUtils.isEmpty(format)) {
                sb2.append(format);
                sb2.append("\n");
            }
            sb2.append(y);
            sb2.append("\n");
            d.a.q0.t.d.M(sb2.toString(), file);
        }
    }

    public static boolean g(@NonNull Context context, @Nullable String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLL = interceptable.invokeLL(65543, null, context, str)) == null) ? (TextUtils.isEmpty(str) || SwanAppNetworkUtils.i(context) || d.a.q0.a.f1.h.a.d(str)) ? false : true : invokeLL.booleanValue;
    }

    public static void h(String str, String str2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(65544, null, str, str2) == null) || f47763b) {
            return;
        }
        BaseActivityDialog.e newBuilder = SwanAppErrorDialog.newBuilder();
        newBuilder.C(str);
        newBuilder.y(new b());
        newBuilder.v(str2);
        newBuilder.z(d.a.q0.a.h.aiapps_confirm_text, null);
        newBuilder.D();
        f47763b = true;
    }

    public static void i(String str, String str2, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLI(65545, null, str, str2, i2) == null) {
            if (TextUtils.isEmpty(str) && TextUtils.isEmpty(str2)) {
                return;
            }
            if (!ProcessUtils.isMainProcess()) {
                Bundle bundle = new Bundle();
                bundle.putString("arg_title", str);
                bundle.putString("arg_message", str2);
                bundle.putInt("arg_match_target_down", i2);
                d.a.q0.a.v1.b.d.b(c.class, bundle);
                return;
            }
            if (f47762a) {
                Log.d("LaunchError", "show normal err dialog, isShowing=" + f47763b);
            }
            if (!SwanAppProcessInfo.checkProcessId(i2)) {
                h(str, str2);
                return;
            }
            e.k().c(new C0749a(i2, Sets.newHashSet("event_puppet_unload_app", "event_puppet_offline"), str, str2), f47764c);
        }
    }

    public static void j(@NonNull Context context, @NonNull String str, @NonNull String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(65546, null, context, str, str2) == null) {
            String format = String.format(context.getResources().getString(d.a.q0.a.h.swanapp_launch_err_toast_format), str, str2);
            if (f47762a) {
                Log.d("LaunchError", "show normal err toast: " + format);
            }
            d.a.q0.a.z1.b.f.e g2 = d.a.q0.a.z1.b.f.e.g(AppRuntime.getAppContext(), format);
            g2.p(Integer.MAX_VALUE);
            g2.E();
        }
    }

    public static void k(Context context, String str, Bundle bundle, ForbiddenInfo forbiddenInfo) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(65547, null, context, str, bundle, forbiddenInfo) == null) {
            Intent intent = new Intent();
            if (bundle != null) {
                intent.putExtras(bundle);
            }
            int g2 = d.a.q0.a.k1.a.g();
            int h2 = d.a.q0.a.k1.a.h(context);
            intent.putExtra(SwanAppErrorActivity.KEY_SWAN_ERROR_TYPE, str);
            intent.putExtra(SwanAppErrorActivity.KEY_ERROR_FORBIDDEN_INFO, forbiddenInfo);
            intent.putExtra(SwanAppErrorActivity.KEY_ERROR_MENU_NOTICE_COUNT, g2);
            intent.putExtra(SwanAppErrorActivity.KEY_ERROR_MENU_PRIVACY_COUNT, h2);
            intent.setComponent(new ComponentName(context, SwanAppErrorActivity.class));
            if (!(context instanceof Activity)) {
                intent.addFlags(Label.FORWARD_REFERENCE_TYPE_SHORT);
            }
            context.startActivity(intent);
        }
    }

    public static void l(Context context, String str, String str2, String str3, String str4, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65548, null, new Object[]{context, str, str2, str3, str4, Integer.valueOf(i2)}) == null) {
            if (g(context, str)) {
                if (z.a(context)) {
                    d.a.q0.a.z1.b.f.e.f(AppRuntime.getAppContext(), d.a.q0.a.h.aiapps_net_error).F();
                    return;
                }
                if (f47762a) {
                    Log.w("LaunchError", "show network err toast: areNotificationsEnabled false");
                }
                i(str2, str4, i2);
            } else if (z.a(context)) {
                j(context, str3, str4);
            } else {
                if (f47762a) {
                    Log.w("LaunchError", "handleLaunchError: areNotificationsEnabled false");
                }
                i(str2, str4, i2);
            }
        }
    }
}
