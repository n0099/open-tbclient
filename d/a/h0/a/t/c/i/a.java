package d.a.h0.a.t.c.i;

import android.util.Log;
import android.util.Pair;
import androidx.annotation.NonNull;
import com.baidu.swan.apps.performance.UbcFlowEvent;
import d.a.h0.a.e0.l.e;
import d.a.h0.a.e0.l.f;
import d.a.h0.a.i2.k0;
import d.a.h0.a.j1.i;
import d.a.h0.a.j1.j;
import io.flutter.embedding.android.FlutterActivityLaunchConfigs;
import java.util.UUID;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class a extends d.a.h0.a.t.b.d {

    /* renamed from: d.a.h0.a.t.c.i.a$a  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public class RunnableC0789a implements Runnable {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ int f44212e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ f f44213f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ f.b f44214g;

        public RunnableC0789a(int i2, f fVar, f.b bVar) {
            this.f44212e = i2;
            this.f44213f = fVar;
            this.f44214g = bVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (this.f44212e > 1) {
                d.a.h0.a.i2.f.b(this.f44213f, a.this.h(), 1);
            }
            this.f44214g.a();
        }
    }

    public a(@NonNull d.a.h0.a.t.b.b bVar) {
        super(bVar);
    }

    public d.a.h0.a.t.e.b r(String str) {
        if (d.a.h0.a.t.b.d.f44021c) {
            Log.d("Api-NavigateBack", "handle: " + str);
        }
        String uuid = UUID.randomUUID().toString();
        j.b(uuid);
        Pair<d.a.h0.a.t.e.b, JSONObject> a2 = d.a.h0.a.t.f.b.a("Api-NavigateBack", str);
        d.a.h0.a.t.e.b bVar = (d.a.h0.a.t.e.b) a2.first;
        if (!bVar.a()) {
            if (d.a.h0.a.t.b.d.f44021c) {
                d.a.h0.a.c0.c.b("Api-NavigateBack", "parse fail");
            }
            return bVar;
        }
        int optInt = ((JSONObject) a2.second).optInt("delta", 1);
        f W = d.a.h0.a.z0.f.V().W();
        if (W == null) {
            d.a.h0.a.c0.c.b("Api-NavigateBack", "manager is null");
            return new d.a.h0.a.t.e.b(1001, "manager is null");
        }
        if (d.a.h0.a.t.b.d.f44021c) {
            Log.d("Api-NavigateBack", "back delta: " + optInt);
        }
        int k = W.k();
        if (d.a.h0.a.t.b.d.f44021c) {
            Log.d("Api-NavigateBack", "fragment count " + k);
        }
        if (k == 1) {
            d.a.h0.a.c0.c.b("Api-NavigateBack", "navigateBack api can only work when slave's count greater than 1");
            return new d.a.h0.a.t.e.b(1001, "navigateBack api can only work when slave's count greater than 1");
        }
        if (optInt >= k) {
            optInt = k - 1;
        }
        if (d.a.h0.a.t.b.d.f44021c) {
            Log.d("Api-NavigateBack", "real back delta: " + optInt);
        }
        f.b i2 = W.i("navigateBack");
        i2.n(f.f42033i, f.f42032h);
        i2.h(optInt);
        k0.T(new RunnableC0789a(k, W, i2));
        i.p(FlutterActivityLaunchConfigs.EXTRA_INITIAL_ROUTE, uuid).A(new UbcFlowEvent("na_push_page_end"));
        j.c(1, uuid);
        j.a(uuid);
        if (!(W.m() instanceof e)) {
            d.a.h0.a.c0.c.b("Api-NavigateBack", "top fragment error");
            return new d.a.h0.a.t.e.b(1001, "top fragment error");
        }
        e eVar = (e) W.m();
        return new d.a.h0.a.t.e.b(0, d.a.h0.a.t1.k.p0.a.b(eVar != null ? eVar.W2() : ""));
    }
}
