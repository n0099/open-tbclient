package d.a.l0.a.v1.c.f;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.webkit.WebView;
import com.baidu.searchbox.process.ipc.util.ProcessUtils;
import com.baidu.swan.apps.env.launch.SwanLauncher;
import com.baidu.swan.apps.process.messaging.service.SwanAppMessengerService;
import com.baidu.swan.apps.swancore.model.SwanCoreVersion;
import d.a.l0.a.h0.u.g;
import d.a.l0.a.k;
import d.a.l0.a.p.d.m;
import d.a.l0.a.r1.h;
import io.flutter.embedding.android.FlutterActivityLaunchConfigs;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public final class b {

    /* renamed from: b  reason: collision with root package name */
    public static String f45320b;

    /* renamed from: a  reason: collision with root package name */
    public static final boolean f45319a = k.f43199a;

    /* renamed from: c  reason: collision with root package name */
    public static boolean f45321c = false;

    /* loaded from: classes3.dex */
    public static class a implements d.a.l0.a.h0.s.c {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ Context f45322a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ d.a.l0.a.v1.c.f.c f45323b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ Bundle f45324c;

        public a(Context context, d.a.l0.a.v1.c.f.c cVar, Bundle bundle) {
            this.f45322a = context;
            this.f45323b = cVar;
            this.f45324c = bundle;
        }

        @Override // d.a.l0.a.h0.s.c
        public void onFail() {
            if (b.f45319a) {
                Log.d("SwanAppPreloadHelper", "SwanSailor：updateFail");
            }
        }

        @Override // d.a.l0.a.h0.s.c
        public void onSuccess() {
            if (b.f45319a) {
                Log.d("SwanAppPreloadHelper", "SwanSailor updateSuccess");
            }
            b.i(this.f45322a, this.f45323b, this.f45324c);
        }
    }

    /* renamed from: d.a.l0.a.v1.c.f.b$b  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public static class C0881b implements d.a.l0.a.h0.f.d.b {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ Context f45325a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ d.a.l0.a.v1.c.f.c f45326b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ Bundle f45327c;

        public C0881b(Context context, d.a.l0.a.v1.c.f.c cVar, Bundle bundle) {
            this.f45325a = context;
            this.f45326b = cVar;
            this.f45327c = bundle;
        }

        @Override // d.a.l0.a.h0.f.d.b
        public void a() {
            boolean unused = b.f45321c = true;
            b.h(this.f45325a, this.f45326b, this.f45327c);
        }
    }

    /* loaded from: classes3.dex */
    public static class c implements d.a.l0.a.v2.e1.b<Exception> {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ Context f45328e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ d.a.l0.a.v1.c.f.c f45329f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ Bundle f45330g;

        public c(Context context, d.a.l0.a.v1.c.f.c cVar, Bundle bundle) {
            this.f45328e = context;
            this.f45329f = cVar;
            this.f45330g = bundle;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.a.l0.a.v2.e1.b
        /* renamed from: a */
        public void onCallback(Exception exc) {
            b.g(this.f45328e, this.f45329f, this.f45330g);
        }
    }

    public static String f() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("master", g.N().b0());
            jSONObject.put("slave", g.N().d0());
        } catch (JSONException e2) {
            if (f45319a) {
                throw new RuntimeException(e2);
            }
        }
        String jSONObject2 = jSONObject.toString();
        if (f45319a) {
            Log.d("SwanAppPreloadHelper", "createPreloadStatus -- preloadStatus : " + jSONObject2);
        }
        return TextUtils.isEmpty(jSONObject2) ? "" : jSONObject2;
    }

    public static void g(Context context, d.a.l0.a.v1.c.f.c cVar, Bundle bundle) {
        boolean w = d.a.l0.a.c1.a.Z() != null ? d.a.l0.a.c1.a.Z().w() : false;
        boolean isMainProcess = ProcessUtils.isMainProcess();
        String str = isMainProcess ? FlutterActivityLaunchConfigs.DEFAULT_DART_ENTRYPOINT : "aiapp";
        long currentTimeMillis = System.currentTimeMillis();
        if (w) {
            if (isMainProcess && TextUtils.isEmpty(f45320b)) {
                try {
                    f45320b = new WebView(context).getSettings().getUserAgentString();
                } catch (Exception e2) {
                    f45320b = "exception::" + e2.toString();
                    if (f45319a) {
                        e2.printStackTrace();
                    }
                }
            }
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("time", currentTimeMillis);
                jSONObject.put("process", cVar.f45331f.index);
                jSONObject.put("ua", f45320b);
            } catch (JSONException e3) {
                if (f45319a) {
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
                jSONObject2.put("process", cVar.f45331f.index);
                jSONObject2.put("cost", currentTimeMillis2 - currentTimeMillis);
            } catch (JSONException e4) {
                if (f45319a) {
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
        if (d.a.l0.a.m2.b.j()) {
            d.a.l0.a.m2.d.a.e();
        }
        bundle.putParcelable("bundle_key_swan_core", d.a.l0.a.m2.b.e(0));
        bundle.putParcelable("bundle_key_extension_core", d.a.l0.a.p0.b.c(0));
        bundle.putInt("bundle_key_preload_switch", d.a.l0.a.c1.a.f().a());
        bundle.putLong("bundle_key_preload_launch_time", currentTimeMillis);
        bundle.putBoolean("bundle_key_v8_ab", d.a.l0.a.c1.a.Z().A());
        bundle.putLong("bundle_key_preload_swan_updated_time", currentTimeMillis2);
        bundle.putString("bundle_key_preload_src", str);
        bundle.putInt("bundle_key_process", cVar.f45331f.index);
        bundle.setClassLoader(SwanCoreVersion.class.getClassLoader());
        cVar.b0(context, bundle);
    }

    public static void h(Context context, d.a.l0.a.v1.c.f.c cVar, Bundle bundle) {
        SwanLauncher.j().l(new c(context, cVar, bundle));
    }

    public static void i(Context context, d.a.l0.a.v1.c.f.c cVar, Bundle bundle) {
        if (d.a.l0.a.h0.s.e.a()) {
            h(context, cVar, bundle);
        } else if (f45321c) {
            h(context, cVar, bundle);
        } else {
            d.a.l0.a.p.e.j.c.a().b().a().b(new C0881b(context, cVar, bundle));
        }
    }

    public static void j(Bundle bundle) {
        bundle.putBoolean("bundle_key_v8_ab", d.a.l0.a.c1.a.Z().A());
    }

    public static void k(Context context, Bundle bundle) {
        Intent intent = new Intent(context, SwanAppMessengerService.class);
        intent.setAction(SwanAppMessengerService.ACTION_PRELOAD_NEXT);
        if (bundle != null) {
            intent.putExtras(bundle);
        }
        try {
            context.startService(intent);
        } catch (Exception e2) {
            if (f45319a) {
                e2.printStackTrace();
            }
        }
    }

    public static void l(Context context, Bundle bundle) {
        m(context, e.k().f(), bundle);
    }

    public static void m(Context context, d.a.l0.a.v1.c.f.c cVar, Bundle bundle) {
        if (f45319a) {
            e k = e.k();
            k.u("b4 tryPreload client=" + cVar);
        }
        if (!ProcessUtils.isMainProcess() || cVar == null || !cVar.f45331f.isSwanAppProcess() || cVar.C()) {
            return;
        }
        String string = bundle == null ? "" : bundle.getString("bundle_key_preload_preload_scene");
        if (TextUtils.isEmpty(string)) {
            string = "0";
        }
        if (f45319a) {
            Log.d("SwanAppPreloadHelper", "SwanSailor：preloadScene:" + string);
        }
        if (d.a.l0.a.c1.a.n0().c()) {
            i(context, cVar, bundle);
            return;
        }
        d.a.l0.a.h0.s.e eVar = new d.a.l0.a.h0.s.e();
        eVar.f42571a = TextUtils.equals(string, "0") ? "by_host_launch" : "by_preload";
        d.a.l0.a.c1.a.n0().b(eVar, new a(context, cVar, bundle));
    }

    public static void n(Context context, Bundle bundle) {
        m Z = d.a.l0.a.c1.a.Z();
        if (!d.a.l0.a.u1.a.a.W()) {
            Z.getSwitch("swan_preload_keep_alive", true);
        }
        l(context, bundle);
    }
}
