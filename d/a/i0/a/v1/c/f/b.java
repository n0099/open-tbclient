package d.a.i0.a.v1.c.f;

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
import d.a.i0.a.h0.u.g;
import d.a.i0.a.k;
import d.a.i0.a.p.d.m;
import d.a.i0.a.r1.h;
import io.flutter.embedding.android.FlutterActivityLaunchConfigs;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public final class b {

    /* renamed from: b  reason: collision with root package name */
    public static String f45144b;

    /* renamed from: a  reason: collision with root package name */
    public static final boolean f45143a = k.f43025a;

    /* renamed from: c  reason: collision with root package name */
    public static boolean f45145c = false;

    /* loaded from: classes3.dex */
    public static class a implements d.a.i0.a.h0.s.c {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ Context f45146a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ d.a.i0.a.v1.c.f.c f45147b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ Bundle f45148c;

        public a(Context context, d.a.i0.a.v1.c.f.c cVar, Bundle bundle) {
            this.f45146a = context;
            this.f45147b = cVar;
            this.f45148c = bundle;
        }

        @Override // d.a.i0.a.h0.s.c
        public void onFail() {
            if (b.f45143a) {
                Log.d("SwanAppPreloadHelper", "SwanSailor：updateFail");
            }
        }

        @Override // d.a.i0.a.h0.s.c
        public void onSuccess() {
            if (b.f45143a) {
                Log.d("SwanAppPreloadHelper", "SwanSailor updateSuccess");
            }
            b.i(this.f45146a, this.f45147b, this.f45148c);
        }
    }

    /* renamed from: d.a.i0.a.v1.c.f.b$b  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public static class C0870b implements d.a.i0.a.h0.f.d.b {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ Context f45149a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ d.a.i0.a.v1.c.f.c f45150b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ Bundle f45151c;

        public C0870b(Context context, d.a.i0.a.v1.c.f.c cVar, Bundle bundle) {
            this.f45149a = context;
            this.f45150b = cVar;
            this.f45151c = bundle;
        }

        @Override // d.a.i0.a.h0.f.d.b
        public void a() {
            boolean unused = b.f45145c = true;
            b.h(this.f45149a, this.f45150b, this.f45151c);
        }
    }

    /* loaded from: classes3.dex */
    public static class c implements d.a.i0.a.v2.e1.b<Exception> {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ Context f45152e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ d.a.i0.a.v1.c.f.c f45153f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ Bundle f45154g;

        public c(Context context, d.a.i0.a.v1.c.f.c cVar, Bundle bundle) {
            this.f45152e = context;
            this.f45153f = cVar;
            this.f45154g = bundle;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.a.i0.a.v2.e1.b
        /* renamed from: a */
        public void onCallback(Exception exc) {
            b.g(this.f45152e, this.f45153f, this.f45154g);
        }
    }

    public static String f() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("master", g.N().b0());
            jSONObject.put("slave", g.N().d0());
        } catch (JSONException e2) {
            if (f45143a) {
                throw new RuntimeException(e2);
            }
        }
        String jSONObject2 = jSONObject.toString();
        if (f45143a) {
            Log.d("SwanAppPreloadHelper", "createPreloadStatus -- preloadStatus : " + jSONObject2);
        }
        return TextUtils.isEmpty(jSONObject2) ? "" : jSONObject2;
    }

    public static void g(Context context, d.a.i0.a.v1.c.f.c cVar, Bundle bundle) {
        boolean w = d.a.i0.a.c1.a.Z() != null ? d.a.i0.a.c1.a.Z().w() : false;
        boolean isMainProcess = ProcessUtils.isMainProcess();
        String str = isMainProcess ? FlutterActivityLaunchConfigs.DEFAULT_DART_ENTRYPOINT : "aiapp";
        long currentTimeMillis = System.currentTimeMillis();
        if (w) {
            if (isMainProcess && TextUtils.isEmpty(f45144b)) {
                try {
                    f45144b = new WebView(context).getSettings().getUserAgentString();
                } catch (Exception e2) {
                    f45144b = "exception::" + e2.toString();
                    if (f45143a) {
                        e2.printStackTrace();
                    }
                }
            }
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("time", currentTimeMillis);
                jSONObject.put("process", cVar.f45155f.index);
                jSONObject.put("ua", f45144b);
            } catch (JSONException e3) {
                if (f45143a) {
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
                jSONObject2.put("process", cVar.f45155f.index);
                jSONObject2.put("cost", currentTimeMillis2 - currentTimeMillis);
            } catch (JSONException e4) {
                if (f45143a) {
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
        if (d.a.i0.a.m2.b.j()) {
            d.a.i0.a.m2.d.a.e();
        }
        bundle.putParcelable("bundle_key_swan_core", d.a.i0.a.m2.b.e(0));
        bundle.putParcelable("bundle_key_extension_core", d.a.i0.a.p0.b.c(0));
        bundle.putInt("bundle_key_preload_switch", d.a.i0.a.c1.a.f().a());
        bundle.putLong("bundle_key_preload_launch_time", currentTimeMillis);
        bundle.putBoolean("bundle_key_v8_ab", d.a.i0.a.c1.a.Z().A());
        bundle.putLong("bundle_key_preload_swan_updated_time", currentTimeMillis2);
        bundle.putString("bundle_key_preload_src", str);
        bundle.putInt("bundle_key_process", cVar.f45155f.index);
        bundle.setClassLoader(SwanCoreVersion.class.getClassLoader());
        cVar.b0(context, bundle);
    }

    public static void h(Context context, d.a.i0.a.v1.c.f.c cVar, Bundle bundle) {
        SwanLauncher.j().l(new c(context, cVar, bundle));
    }

    public static void i(Context context, d.a.i0.a.v1.c.f.c cVar, Bundle bundle) {
        if (d.a.i0.a.h0.s.e.a()) {
            h(context, cVar, bundle);
        } else if (f45145c) {
            h(context, cVar, bundle);
        } else {
            d.a.i0.a.p.e.j.c.a().b().a().b(new C0870b(context, cVar, bundle));
        }
    }

    public static void j(Bundle bundle) {
        bundle.putBoolean("bundle_key_v8_ab", d.a.i0.a.c1.a.Z().A());
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
            if (f45143a) {
                e2.printStackTrace();
            }
        }
    }

    public static void l(Context context, Bundle bundle) {
        m(context, e.k().f(), bundle);
    }

    public static void m(Context context, d.a.i0.a.v1.c.f.c cVar, Bundle bundle) {
        if (f45143a) {
            e k = e.k();
            k.u("b4 tryPreload client=" + cVar);
        }
        if (!ProcessUtils.isMainProcess() || cVar == null || !cVar.f45155f.isSwanAppProcess() || cVar.C()) {
            return;
        }
        String string = bundle == null ? "" : bundle.getString("bundle_key_preload_preload_scene");
        if (TextUtils.isEmpty(string)) {
            string = "0";
        }
        if (f45143a) {
            Log.d("SwanAppPreloadHelper", "SwanSailor：preloadScene:" + string);
        }
        if (d.a.i0.a.c1.a.n0().c()) {
            i(context, cVar, bundle);
            return;
        }
        d.a.i0.a.h0.s.e eVar = new d.a.i0.a.h0.s.e();
        eVar.f42397a = TextUtils.equals(string, "0") ? "by_host_launch" : "by_preload";
        d.a.i0.a.c1.a.n0().b(eVar, new a(context, cVar, bundle));
    }

    public static void n(Context context, Bundle bundle) {
        m Z = d.a.i0.a.c1.a.Z();
        if (!d.a.i0.a.u1.a.a.W()) {
            Z.getSwitch("swan_preload_keep_alive", true);
        }
        l(context, bundle);
    }
}
