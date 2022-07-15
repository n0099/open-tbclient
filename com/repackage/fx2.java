package com.repackage;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.webkit.WebView;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.process.ipc.util.ProcessUtils;
import com.baidu.swan.apps.env.launch.SwanLauncher;
import com.baidu.swan.apps.process.messaging.service.SwanAppMessengerService;
import com.baidu.swan.apps.swancore.model.SwanCoreVersion;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.repackage.mt2;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes6.dex */
public final class fx2 {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean a;
    public static String b;
    public static boolean c;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes6.dex */
    public static class a implements j62 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ Context a;
        public final /* synthetic */ gx2 b;
        public final /* synthetic */ Bundle c;

        public a(Context context, gx2 gx2Var, Bundle bundle) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {context, gx2Var, bundle};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = context;
            this.b = gx2Var;
            this.c = bundle;
        }

        @Override // com.repackage.j62
        public void onFail() {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeV(1048576, this) == null) && fx2.a) {
                Log.d("SwanAppPreloadHelper", "SwanSailor：updateFail");
            }
        }

        @Override // com.repackage.j62
        public void onSuccess() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                if (fx2.a) {
                    Log.d("SwanAppPreloadHelper", "SwanSailor updateSuccess");
                }
                fx2.i(this.a, this.b, this.c);
            }
        }
    }

    /* loaded from: classes6.dex */
    public static class b implements jz1 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ Context a;
        public final /* synthetic */ gx2 b;
        public final /* synthetic */ Bundle c;

        public b(Context context, gx2 gx2Var, Bundle bundle) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {context, gx2Var, bundle};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = context;
            this.b = gx2Var;
            this.c = bundle;
        }

        @Override // com.repackage.jz1
        public void a() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                boolean unused = fx2.c = true;
                fx2.h(this.a, this.b, this.c);
            }
        }
    }

    /* loaded from: classes6.dex */
    public static class c implements af3<Exception> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ Context a;
        public final /* synthetic */ gx2 b;
        public final /* synthetic */ Bundle c;

        public c(Context context, gx2 gx2Var, Bundle bundle) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {context, gx2Var, bundle};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = context;
            this.b = gx2Var;
            this.c = bundle;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.repackage.af3
        /* renamed from: b */
        public void a(Exception exc) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, exc) == null) {
                fx2.g(this.a, this.b, this.c);
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-755692527, "Lcom/repackage/fx2;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-755692527, "Lcom/repackage/fx2;");
                return;
            }
        }
        a = rg1.a;
        c = false;
    }

    @SuppressLint({"BDThrowableCheck"})
    public static String f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65542, null)) == null) {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("master", b72.U().k0());
                jSONObject.put("slave", b72.U().n0());
            } catch (JSONException e) {
                if (a) {
                    throw new RuntimeException(e);
                }
            }
            String jSONObject2 = jSONObject.toString();
            if (a) {
                Log.d("SwanAppPreloadHelper", "createPreloadStatus -- preloadStatus : " + jSONObject2);
            }
            return TextUtils.isEmpty(jSONObject2) ? "" : jSONObject2;
        }
        return (String) invokeV.objValue;
    }

    public static void g(Context context, gx2 gx2Var, Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(65543, null, context, gx2Var, bundle) == null) {
            boolean u = oj2.g0() != null ? oj2.g0().u() : false;
            boolean isMainProcess = ProcessUtils.isMainProcess();
            String str = isMainProcess ? "main" : "aiapp";
            long currentTimeMillis = System.currentTimeMillis();
            if (u) {
                if (isMainProcess && TextUtils.isEmpty(b)) {
                    try {
                        b = new WebView(context).getSettings().getUserAgentString();
                    } catch (Exception e) {
                        b = "exception::" + e.toString();
                        if (a) {
                            e.printStackTrace();
                        }
                    }
                }
                JSONObject jSONObject = new JSONObject();
                try {
                    jSONObject.put("time", currentTimeMillis);
                    jSONObject.put("process", gx2Var.b.index);
                    jSONObject.put("ua", b);
                } catch (JSONException e2) {
                    if (a) {
                        e2.printStackTrace();
                    }
                }
                mt2.d dVar = new mt2.d("812");
                dVar.g("swan");
                dVar.i("launch");
                dVar.h(str);
                dVar.e(jSONObject);
                mt2.onEvent(dVar);
            }
            long currentTimeMillis2 = System.currentTimeMillis();
            if (u) {
                JSONObject jSONObject2 = new JSONObject();
                try {
                    jSONObject2.put("time", currentTimeMillis2);
                    jSONObject2.put("process", gx2Var.b.index);
                    jSONObject2.put("cost", currentTimeMillis2 - currentTimeMillis);
                } catch (JSONException e3) {
                    if (a) {
                        e3.printStackTrace();
                    }
                }
                mt2.d dVar2 = new mt2.d("812");
                dVar2.g("swan");
                dVar2.i("swan_updated");
                dVar2.h(str);
                dVar2.e(jSONObject2);
                mt2.onEvent(dVar2);
            }
            if (bundle == null) {
                bundle = new Bundle();
            }
            if (m93.j()) {
                o93.e();
            }
            bundle.putParcelable("bundle_key_swan_core", m93.e(0));
            bundle.putParcelable("bundle_key_extension_core", qa2.c(0));
            bundle.putInt("bundle_key_preload_switch", oj2.g().a());
            bundle.putLong("bundle_key_preload_launch_time", currentTimeMillis);
            bundle.putBoolean("bundle_key_v8_ab", oj2.g0().y());
            bundle.putLong("bundle_key_preload_swan_updated_time", currentTimeMillis2);
            bundle.putString("bundle_key_preload_src", str);
            bundle.putInt("bundle_key_process", gx2Var.b.index);
            bundle.setClassLoader(SwanCoreVersion.class.getClassLoader());
            gx2Var.n0(context, bundle);
        }
    }

    public static void h(Context context, gx2 gx2Var, Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(65544, null, context, gx2Var, bundle) == null) {
            SwanLauncher.j().l(new c(context, gx2Var, bundle));
        }
    }

    public static void i(Context context, gx2 gx2Var, Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(65545, null, context, gx2Var, bundle) == null) {
            if (l62.a()) {
                h(context, gx2Var, bundle);
            } else if (c) {
                h(context, gx2Var, bundle);
            } else {
                xm1.a().b().a().b(new b(context, gx2Var, bundle));
            }
        }
    }

    public static void j(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65546, null, bundle) == null) {
            bundle.putBoolean("bundle_key_v8_ab", oj2.g0().y());
        }
    }

    public static void k(Context context, Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65547, null, context, bundle) == null) {
            Intent intent = new Intent(context, SwanAppMessengerService.class);
            intent.setAction(SwanAppMessengerService.ACTION_PRELOAD_NEXT);
            if (bundle != null) {
                intent.putExtras(bundle);
            }
            try {
                context.startService(intent);
            } catch (Exception e) {
                if (a) {
                    e.printStackTrace();
                }
            }
        }
    }

    public static void l(Context context, Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65548, null, context, bundle) == null) {
            m(context, ix2.k().f(), bundle);
        }
    }

    public static void m(Context context, gx2 gx2Var, Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(65549, null, context, gx2Var, bundle) == null) {
            if (a) {
                ix2 k = ix2.k();
                k.u("b4 tryPreload client=" + gx2Var);
            }
            if (!ProcessUtils.isMainProcess() || gx2Var == null || !gx2Var.b.isSwanAppProcess() || gx2Var.E()) {
                return;
            }
            String string = bundle == null ? "" : bundle.getString("bundle_key_preload_preload_scene");
            if (TextUtils.isEmpty(string)) {
                string = "0";
            }
            if (a) {
                Log.d("SwanAppPreloadHelper", "SwanSailor：preloadScene:" + string);
            }
            if (oj2.w0().c()) {
                i(context, gx2Var, bundle);
                return;
            }
            l62 l62Var = new l62();
            l62Var.a = TextUtils.equals(string, "0") ? "by_host_launch" : "by_preload";
            oj2.w0().b(l62Var, new a(context, gx2Var, bundle));
        }
    }

    public static void n(Context context, Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65550, null, context, bundle) == null) {
            dk1 g0 = oj2.g0();
            if (!gw2.Y()) {
                g0.getSwitch("swan_preload_keep_alive", true);
            }
            l(context, bundle);
        }
    }
}
