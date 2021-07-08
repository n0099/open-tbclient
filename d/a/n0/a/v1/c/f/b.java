package d.a.n0.a.v1.c.f;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.webkit.WebView;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.mobads.container.util.AdIconUtil;
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
import d.a.n0.a.h0.u.g;
import d.a.n0.a.k;
import d.a.n0.a.p.d.m;
import d.a.n0.a.r1.h;
import io.flutter.embedding.android.FlutterActivityLaunchConfigs;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes7.dex */
public final class b {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: a  reason: collision with root package name */
    public static final boolean f47945a;

    /* renamed from: b  reason: collision with root package name */
    public static String f47946b;

    /* renamed from: c  reason: collision with root package name */
    public static boolean f47947c;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes7.dex */
    public static class a implements d.a.n0.a.h0.s.c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ Context f47948a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ d.a.n0.a.v1.c.f.c f47949b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ Bundle f47950c;

        public a(Context context, d.a.n0.a.v1.c.f.c cVar, Bundle bundle) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {context, cVar, bundle};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f47948a = context;
            this.f47949b = cVar;
            this.f47950c = bundle;
        }

        @Override // d.a.n0.a.h0.s.c
        public void onFail() {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeV(1048576, this) == null) && b.f47945a) {
                Log.d("SwanAppPreloadHelper", "SwanSailor：updateFail");
            }
        }

        @Override // d.a.n0.a.h0.s.c
        public void onSuccess() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                if (b.f47945a) {
                    Log.d("SwanAppPreloadHelper", "SwanSailor updateSuccess");
                }
                b.i(this.f47948a, this.f47949b, this.f47950c);
            }
        }
    }

    /* renamed from: d.a.n0.a.v1.c.f.b$b  reason: collision with other inner class name */
    /* loaded from: classes7.dex */
    public static class C0949b implements d.a.n0.a.h0.f.d.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ Context f47951a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ d.a.n0.a.v1.c.f.c f47952b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ Bundle f47953c;

        public C0949b(Context context, d.a.n0.a.v1.c.f.c cVar, Bundle bundle) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {context, cVar, bundle};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f47951a = context;
            this.f47952b = cVar;
            this.f47953c = bundle;
        }

        @Override // d.a.n0.a.h0.f.d.b
        public void a() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                boolean unused = b.f47947c = true;
                b.h(this.f47951a, this.f47952b, this.f47953c);
            }
        }
    }

    /* loaded from: classes7.dex */
    public static class c implements d.a.n0.a.v2.e1.b<Exception> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ Context f47954e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ d.a.n0.a.v1.c.f.c f47955f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ Bundle f47956g;

        public c(Context context, d.a.n0.a.v1.c.f.c cVar, Bundle bundle) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {context, cVar, bundle};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f47954e = context;
            this.f47955f = cVar;
            this.f47956g = bundle;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.a.n0.a.v2.e1.b
        /* renamed from: a */
        public void onCallback(Exception exc) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, exc) == null) {
                b.g(this.f47954e, this.f47955f, this.f47956g);
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1383319444, "Ld/a/n0/a/v1/c/f/b;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-1383319444, "Ld/a/n0/a/v1/c/f/b;");
                return;
            }
        }
        f47945a = k.f45831a;
        f47947c = false;
    }

    public static String f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(AdIconUtil.BAIDU_LOGO_ID, null)) == null) {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("master", g.N().b0());
                jSONObject.put("slave", g.N().d0());
            } catch (JSONException e2) {
                if (f47945a) {
                    throw new RuntimeException(e2);
                }
            }
            String jSONObject2 = jSONObject.toString();
            if (f47945a) {
                Log.d("SwanAppPreloadHelper", "createPreloadStatus -- preloadStatus : " + jSONObject2);
            }
            return TextUtils.isEmpty(jSONObject2) ? "" : jSONObject2;
        }
        return (String) invokeV.objValue;
    }

    public static void g(Context context, d.a.n0.a.v1.c.f.c cVar, Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(65543, null, context, cVar, bundle) == null) {
            boolean w = d.a.n0.a.c1.a.Z() != null ? d.a.n0.a.c1.a.Z().w() : false;
            boolean isMainProcess = ProcessUtils.isMainProcess();
            String str = isMainProcess ? FlutterActivityLaunchConfigs.DEFAULT_DART_ENTRYPOINT : "aiapp";
            long currentTimeMillis = System.currentTimeMillis();
            if (w) {
                if (isMainProcess && TextUtils.isEmpty(f47946b)) {
                    try {
                        f47946b = new WebView(context).getSettings().getUserAgentString();
                    } catch (Exception e2) {
                        f47946b = "exception::" + e2.toString();
                        if (f47945a) {
                            e2.printStackTrace();
                        }
                    }
                }
                JSONObject jSONObject = new JSONObject();
                try {
                    jSONObject.put("time", currentTimeMillis);
                    jSONObject.put("process", cVar.f47957f.index);
                    jSONObject.put("ua", f47946b);
                } catch (JSONException e3) {
                    if (f47945a) {
                        e3.printStackTrace();
                    }
                }
                h.d dVar = new h.d("812");
                dVar.g("swan");
                dVar.i("launch");
                dVar.h(str);
                dVar.e(jSONObject);
                h.onEvent(dVar);
            }
            long currentTimeMillis2 = System.currentTimeMillis();
            if (w) {
                JSONObject jSONObject2 = new JSONObject();
                try {
                    jSONObject2.put("time", currentTimeMillis2);
                    jSONObject2.put("process", cVar.f47957f.index);
                    jSONObject2.put("cost", currentTimeMillis2 - currentTimeMillis);
                } catch (JSONException e4) {
                    if (f47945a) {
                        e4.printStackTrace();
                    }
                }
                h.d dVar2 = new h.d("812");
                dVar2.g("swan");
                dVar2.i("swan_updated");
                dVar2.h(str);
                dVar2.e(jSONObject2);
                h.onEvent(dVar2);
            }
            if (bundle == null) {
                bundle = new Bundle();
            }
            if (d.a.n0.a.m2.b.j()) {
                d.a.n0.a.m2.d.a.e();
            }
            bundle.putParcelable("bundle_key_swan_core", d.a.n0.a.m2.b.e(0));
            bundle.putParcelable("bundle_key_extension_core", d.a.n0.a.p0.b.c(0));
            bundle.putInt("bundle_key_preload_switch", d.a.n0.a.c1.a.f().a());
            bundle.putLong("bundle_key_preload_launch_time", currentTimeMillis);
            bundle.putBoolean("bundle_key_v8_ab", d.a.n0.a.c1.a.Z().A());
            bundle.putLong("bundle_key_preload_swan_updated_time", currentTimeMillis2);
            bundle.putString("bundle_key_preload_src", str);
            bundle.putInt("bundle_key_process", cVar.f47957f.index);
            bundle.setClassLoader(SwanCoreVersion.class.getClassLoader());
            cVar.b0(context, bundle);
        }
    }

    public static void h(Context context, d.a.n0.a.v1.c.f.c cVar, Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(65544, null, context, cVar, bundle) == null) {
            SwanLauncher.j().l(new c(context, cVar, bundle));
        }
    }

    public static void i(Context context, d.a.n0.a.v1.c.f.c cVar, Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(65545, null, context, cVar, bundle) == null) {
            if (d.a.n0.a.h0.s.e.a()) {
                h(context, cVar, bundle);
            } else if (f47947c) {
                h(context, cVar, bundle);
            } else {
                d.a.n0.a.p.e.j.c.a().b().a().b(new C0949b(context, cVar, bundle));
            }
        }
    }

    public static void j(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65546, null, bundle) == null) {
            bundle.putBoolean("bundle_key_v8_ab", d.a.n0.a.c1.a.Z().A());
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
            } catch (Exception e2) {
                if (f47945a) {
                    e2.printStackTrace();
                }
            }
        }
    }

    public static void l(Context context, Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65548, null, context, bundle) == null) {
            m(context, e.k().f(), bundle);
        }
    }

    public static void m(Context context, d.a.n0.a.v1.c.f.c cVar, Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(65549, null, context, cVar, bundle) == null) {
            if (f47945a) {
                e k = e.k();
                k.u("b4 tryPreload client=" + cVar);
            }
            if (!ProcessUtils.isMainProcess() || cVar == null || !cVar.f47957f.isSwanAppProcess() || cVar.C()) {
                return;
            }
            String string = bundle == null ? "" : bundle.getString("bundle_key_preload_preload_scene");
            if (TextUtils.isEmpty(string)) {
                string = "0";
            }
            if (f47945a) {
                Log.d("SwanAppPreloadHelper", "SwanSailor：preloadScene:" + string);
            }
            if (d.a.n0.a.c1.a.n0().c()) {
                i(context, cVar, bundle);
                return;
            }
            d.a.n0.a.h0.s.e eVar = new d.a.n0.a.h0.s.e();
            eVar.f45203a = TextUtils.equals(string, "0") ? "by_host_launch" : "by_preload";
            d.a.n0.a.c1.a.n0().b(eVar, new a(context, cVar, bundle));
        }
    }

    public static void n(Context context, Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65550, null, context, bundle) == null) {
            m Z = d.a.n0.a.c1.a.Z();
            if (!d.a.n0.a.u1.a.a.W()) {
                Z.getSwitch("swan_preload_keep_alive", true);
            }
            l(context, bundle);
        }
    }
}
