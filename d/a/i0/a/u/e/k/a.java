package d.a.i0.a.u.e.k;

import android.util.Log;
import android.util.Pair;
import androidx.annotation.NonNull;
import com.baidu.swan.apps.performance.UbcFlowEvent;
import d.a.i0.a.a2.e;
import d.a.i0.a.g1.f;
import d.a.i0.a.h0.g.g;
import d.a.i0.a.j2.h;
import d.a.i0.a.r1.i;
import d.a.i0.a.v2.q0;
import io.flutter.embedding.android.FlutterActivityLaunchConfigs;
import java.util.UUID;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class a extends d.a.i0.a.u.c.d {

    /* renamed from: d.a.i0.a.u.e.k.a$a  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public class RunnableC0844a implements Runnable {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ int f44899e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ g f44900f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ g.b f44901g;

        public RunnableC0844a(int i2, g gVar, g.b bVar) {
            this.f44899e = i2;
            this.f44900f = gVar;
            this.f44901g = bVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (this.f44899e > 1) {
                d.a.i0.a.v2.g.b(this.f44900f, a.this.i(), 1);
            }
            this.f44901g.a();
        }
    }

    public a(@NonNull d.a.i0.a.u.c.b bVar) {
        super(bVar);
    }

    public d.a.i0.a.u.h.b s(String str) {
        if (d.a.i0.a.u.c.d.f44636c) {
            Log.d("Api-NavigateBack", "handle: " + str);
        }
        e Q = e.Q();
        if (Q != null) {
            Q.B().e(Q.getAppId());
        }
        String uuid = UUID.randomUUID().toString();
        i.b(uuid);
        Pair<d.a.i0.a.u.h.b, JSONObject> b2 = d.a.i0.a.u.i.b.b("Api-NavigateBack", str);
        d.a.i0.a.u.h.b bVar = (d.a.i0.a.u.h.b) b2.first;
        if (!bVar.a()) {
            if (d.a.i0.a.u.c.d.f44636c) {
                d.a.i0.a.e0.d.b("Api-NavigateBack", "parse fail");
            }
            return bVar;
        }
        int optInt = ((JSONObject) b2.second).optInt("delta", 1);
        g W = f.V().W();
        if (W == null) {
            d.a.i0.a.e0.d.b("Api-NavigateBack", "manager is null");
            return new d.a.i0.a.u.h.b(1001, "manager is null");
        }
        if (d.a.i0.a.u.c.d.f44636c) {
            Log.d("Api-NavigateBack", "back delta: " + optInt);
        }
        int k = W.k();
        if (d.a.i0.a.u.c.d.f44636c) {
            Log.d("Api-NavigateBack", "fragment count " + k);
        }
        if (k == 1) {
            d.a.i0.a.e0.d.b("Api-NavigateBack", "navigateBack api can only work when slave's count greater than 1");
            return new d.a.i0.a.u.h.b(1001, "navigateBack api can only work when slave's count greater than 1");
        }
        if (optInt >= k) {
            optInt = k - 1;
        }
        if (d.a.i0.a.u.c.d.f44636c) {
            Log.d("Api-NavigateBack", "real back delta: " + optInt);
        }
        d.a.i0.a.h0.g.d j = W.j((k - optInt) - 1);
        h.f((j == null || j.K1() == null) ? "" : j.K1().g(), "1");
        i.c(1, uuid);
        g.b i2 = W.i("navigateBack");
        i2.n(g.f41904i, g.f41903h);
        i2.h(optInt);
        q0.X(new RunnableC0844a(k, W, i2));
        d.a.i0.a.h0.g.f o = W.o();
        d.a.i0.a.l1.b Z2 = o == null ? null : o.Z2();
        d.a.i0.a.r1.h.q(FlutterActivityLaunchConfigs.EXTRA_INITIAL_ROUTE, uuid).C(new UbcFlowEvent("na_push_page_end"));
        i.a(uuid, Z2);
        if (!(W.m() instanceof d.a.i0.a.h0.g.f)) {
            d.a.i0.a.e0.d.b("Api-NavigateBack", "top fragment error");
            return new d.a.i0.a.u.h.b(1001, "top fragment error");
        }
        d.a.i0.a.h0.g.f fVar = (d.a.i0.a.h0.g.f) W.m();
        return new d.a.i0.a.u.h.b(0, d.a.i0.a.c2.f.p0.a.c(fVar != null ? fVar.g3() : ""));
    }
}
