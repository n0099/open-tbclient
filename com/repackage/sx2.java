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
import com.repackage.zt2;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes7.dex */
public final class sx2 {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean a;
    public static String b;
    public static boolean c;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes7.dex */
    public static class a implements w62 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ Context a;
        public final /* synthetic */ tx2 b;
        public final /* synthetic */ Bundle c;

        public a(Context context, tx2 tx2Var, Bundle bundle) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {context, tx2Var, bundle};
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
            this.b = tx2Var;
            this.c = bundle;
        }

        @Override // com.repackage.w62
        public void onFail() {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeV(1048576, this) == null) && sx2.a) {
                Log.d("SwanAppPreloadHelper", "SwanSailor：updateFail");
            }
        }

        @Override // com.repackage.w62
        public void onSuccess() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                if (sx2.a) {
                    Log.d("SwanAppPreloadHelper", "SwanSailor updateSuccess");
                }
                sx2.i(this.a, this.b, this.c);
            }
        }
    }

    /* loaded from: classes7.dex */
    public static class b implements wz1 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ Context a;
        public final /* synthetic */ tx2 b;
        public final /* synthetic */ Bundle c;

        public b(Context context, tx2 tx2Var, Bundle bundle) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {context, tx2Var, bundle};
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
            this.b = tx2Var;
            this.c = bundle;
        }

        @Override // com.repackage.wz1
        public void a() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                boolean unused = sx2.c = true;
                sx2.h(this.a, this.b, this.c);
            }
        }
    }

    /* loaded from: classes7.dex */
    public static class c implements nf3<Exception> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ Context a;
        public final /* synthetic */ tx2 b;
        public final /* synthetic */ Bundle c;

        public c(Context context, tx2 tx2Var, Bundle bundle) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {context, tx2Var, bundle};
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
            this.b = tx2Var;
            this.c = bundle;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.repackage.nf3
        /* renamed from: a */
        public void onCallback(Exception exc) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, exc) == null) {
                sx2.g(this.a, this.b, this.c);
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-755305244, "Lcom/repackage/sx2;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-755305244, "Lcom/repackage/sx2;");
                return;
            }
        }
        a = eh1.a;
        c = false;
    }

    @SuppressLint({"BDThrowableCheck"})
    public static String f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65542, null)) == null) {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("master", o72.U().k0());
                jSONObject.put("slave", o72.U().n0());
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

    public static void g(Context context, tx2 tx2Var, Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(65543, null, context, tx2Var, bundle) == null) {
            boolean u = bk2.g0() != null ? bk2.g0().u() : false;
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
                    jSONObject.put("process", tx2Var.b.index);
                    jSONObject.put("ua", b);
                } catch (JSONException e2) {
                    if (a) {
                        e2.printStackTrace();
                    }
                }
                zt2.d dVar = new zt2.d("812");
                dVar.g("swan");
                dVar.i("launch");
                dVar.h(str);
                dVar.e(jSONObject);
                zt2.onEvent(dVar);
            }
            long currentTimeMillis2 = System.currentTimeMillis();
            if (u) {
                JSONObject jSONObject2 = new JSONObject();
                try {
                    jSONObject2.put("time", currentTimeMillis2);
                    jSONObject2.put("process", tx2Var.b.index);
                    jSONObject2.put("cost", currentTimeMillis2 - currentTimeMillis);
                } catch (JSONException e3) {
                    if (a) {
                        e3.printStackTrace();
                    }
                }
                zt2.d dVar2 = new zt2.d("812");
                dVar2.g("swan");
                dVar2.i("swan_updated");
                dVar2.h(str);
                dVar2.e(jSONObject2);
                zt2.onEvent(dVar2);
            }
            if (bundle == null) {
                bundle = new Bundle();
            }
            if (z93.j()) {
                ba3.e();
            }
            bundle.putParcelable("bundle_key_swan_core", z93.e(0));
            bundle.putParcelable("bundle_key_extension_core", db2.c(0));
            bundle.putInt("bundle_key_preload_switch", bk2.g().a());
            bundle.putLong("bundle_key_preload_launch_time", currentTimeMillis);
            bundle.putBoolean("bundle_key_v8_ab", bk2.g0().y());
            bundle.putLong("bundle_key_preload_swan_updated_time", currentTimeMillis2);
            bundle.putString("bundle_key_preload_src", str);
            bundle.putInt("bundle_key_process", tx2Var.b.index);
            bundle.setClassLoader(SwanCoreVersion.class.getClassLoader());
            tx2Var.m0(context, bundle);
        }
    }

    public static void h(Context context, tx2 tx2Var, Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(65544, null, context, tx2Var, bundle) == null) {
            SwanLauncher.j().l(new c(context, tx2Var, bundle));
        }
    }

    public static void i(Context context, tx2 tx2Var, Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(65545, null, context, tx2Var, bundle) == null) {
            if (y62.a()) {
                h(context, tx2Var, bundle);
            } else if (c) {
                h(context, tx2Var, bundle);
            } else {
                kn1.a().b().a().b(new b(context, tx2Var, bundle));
            }
        }
    }

    public static void j(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65546, null, bundle) == null) {
            bundle.putBoolean("bundle_key_v8_ab", bk2.g0().y());
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
            m(context, vx2.k().f(), bundle);
        }
    }

    public static void m(Context context, tx2 tx2Var, Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(65549, null, context, tx2Var, bundle) == null) {
            if (a) {
                vx2 k = vx2.k();
                k.u("b4 tryPreload client=" + tx2Var);
            }
            if (!ProcessUtils.isMainProcess() || tx2Var == null || !tx2Var.b.isSwanAppProcess() || tx2Var.D()) {
                return;
            }
            String string = bundle == null ? "" : bundle.getString("bundle_key_preload_preload_scene");
            if (TextUtils.isEmpty(string)) {
                string = "0";
            }
            if (a) {
                Log.d("SwanAppPreloadHelper", "SwanSailor：preloadScene:" + string);
            }
            if (bk2.w0().c()) {
                i(context, tx2Var, bundle);
                return;
            }
            y62 y62Var = new y62();
            y62Var.a = TextUtils.equals(string, "0") ? "by_host_launch" : "by_preload";
            bk2.w0().b(y62Var, new a(context, tx2Var, bundle));
        }
    }

    public static void n(Context context, Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65550, null, context, bundle) == null) {
            qk1 g0 = bk2.g0();
            if (!tw2.Y()) {
                g0.getSwitch("swan_preload_keep_alive", true);
            }
            l(context, bundle);
        }
    }
}
