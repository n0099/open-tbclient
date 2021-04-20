package d.b.g0.a.t.c.i;

import android.util.Log;
import android.util.Pair;
import androidx.annotation.NonNull;
import com.baidu.swan.apps.performance.UbcFlowEvent;
import d.b.g0.a.e0.l.e;
import d.b.g0.a.e0.l.f;
import d.b.g0.a.i2.k0;
import d.b.g0.a.j1.i;
import d.b.g0.a.j1.j;
import io.flutter.embedding.android.FlutterActivityLaunchConfigs;
import java.util.UUID;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class a extends d.b.g0.a.t.b.d {

    /* renamed from: d.b.g0.a.t.c.i.a$a  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public class RunnableC0830a implements Runnable {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ int f46500e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ f f46501f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ f.b f46502g;

        public RunnableC0830a(int i, f fVar, f.b bVar) {
            this.f46500e = i;
            this.f46501f = fVar;
            this.f46502g = bVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (this.f46500e > 1) {
                d.b.g0.a.i2.f.b(this.f46501f, a.this.h(), 1);
            }
            this.f46502g.a();
        }
    }

    public a(@NonNull d.b.g0.a.t.b.b bVar) {
        super(bVar);
    }

    public d.b.g0.a.t.e.b r(String str) {
        if (d.b.g0.a.t.b.d.f46321c) {
            Log.d("Api-NavigateBack", "handle: " + str);
        }
        String uuid = UUID.randomUUID().toString();
        j.b(uuid);
        Pair<d.b.g0.a.t.e.b, JSONObject> a2 = d.b.g0.a.t.f.b.a("Api-NavigateBack", str);
        d.b.g0.a.t.e.b bVar = (d.b.g0.a.t.e.b) a2.first;
        if (!bVar.b()) {
            if (d.b.g0.a.t.b.d.f46321c) {
                d.b.g0.a.c0.c.b("Api-NavigateBack", "parse fail");
            }
            return bVar;
        }
        int optInt = ((JSONObject) a2.second).optInt("delta", 1);
        f W = d.b.g0.a.z0.f.V().W();
        if (W == null) {
            d.b.g0.a.c0.c.b("Api-NavigateBack", "manager is null");
            return new d.b.g0.a.t.e.b(1001, "manager is null");
        }
        if (d.b.g0.a.t.b.d.f46321c) {
            Log.d("Api-NavigateBack", "back delta: " + optInt);
        }
        int k = W.k();
        if (d.b.g0.a.t.b.d.f46321c) {
            Log.d("Api-NavigateBack", "fragment count " + k);
        }
        if (k == 1) {
            d.b.g0.a.c0.c.b("Api-NavigateBack", "navigateBack api can only work when slave's count greater than 1");
            return new d.b.g0.a.t.e.b(1001, "navigateBack api can only work when slave's count greater than 1");
        }
        if (optInt >= k) {
            optInt = k - 1;
        }
        if (d.b.g0.a.t.b.d.f46321c) {
            Log.d("Api-NavigateBack", "real back delta: " + optInt);
        }
        f.b i = W.i("navigateBack");
        i.n(f.i, f.f44406h);
        i.h(optInt);
        k0.T(new RunnableC0830a(k, W, i));
        i.p(FlutterActivityLaunchConfigs.EXTRA_INITIAL_ROUTE, uuid).A(new UbcFlowEvent("na_push_page_end"));
        j.c(1, uuid);
        j.a(uuid);
        if (!(W.m() instanceof e)) {
            d.b.g0.a.c0.c.b("Api-NavigateBack", "top fragment error");
            return new d.b.g0.a.t.e.b(1001, "top fragment error");
        }
        e eVar = (e) W.m();
        return new d.b.g0.a.t.e.b(0, d.b.g0.a.t1.k.p0.a.b(eVar != null ? eVar.X2() : ""));
    }
}
