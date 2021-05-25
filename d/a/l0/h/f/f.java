package d.a.l0.h.f;

import android.app.Activity;
import android.content.Context;
import androidx.annotation.NonNull;
import com.baidu.searchbox.v8engine.JsObject;
import com.baidu.swan.apps.SwanAppActivity;
import d.a.l0.a.h0.e.c;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class f {

    /* loaded from: classes3.dex */
    public class a implements c.b {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ boolean f47350a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ Context f47351b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ d.a.l0.a.y.b.a f47352c;

        public a(boolean z, Context context, d.a.l0.a.y.b.a aVar) {
            this.f47350a = z;
            this.f47351b = context;
            this.f47352c = aVar;
        }

        @Override // d.a.l0.a.h0.e.c.b
        public void a(boolean z, String str) {
            if (z) {
                if (this.f47350a) {
                    f.this.g(this.f47351b, this.f47352c);
                    return;
                }
                d.a.l0.a.e0.a.c(this.f47351b, false);
                f.this.e(this.f47352c, true, "setEnableDebug:ok");
                return;
            }
            d.a.l0.a.h0.e.c.c(this.f47351b, str);
            f fVar = f.this;
            fVar.e(this.f47352c, false, fVar.f(str));
        }
    }

    /* loaded from: classes3.dex */
    public class b implements d.a.l0.a.v2.e1.b<Boolean> {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ Context f47354e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ d.a.l0.a.y.b.a f47355f;

        public b(Context context, d.a.l0.a.y.b.a aVar) {
            this.f47354e = context;
            this.f47355f = aVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.a.l0.a.v2.e1.b
        /* renamed from: a */
        public void onCallback(Boolean bool) {
            if (bool.booleanValue()) {
                d.a.l0.a.e0.a.c(this.f47354e, true);
                f.this.e(this.f47355f, true, "setEnableDebug:ok");
                return;
            }
            d.m().p((Activity) this.f47354e, null);
            f.this.e(this.f47355f, false, "internet error");
        }
    }

    public f(d.a.l0.a.l0.c cVar) {
    }

    public static void h(JSONObject jSONObject) {
        SwanAppActivity x;
        d.a.l0.a.l0.a X0;
        d.a.l0.a.a2.e i2 = d.a.l0.a.a2.e.i();
        if (i2 == null || !i2.m0() || (x = i2.x()) == null) {
            return;
        }
        d.a.l0.a.t0.c frame = x.getFrame();
        if ((frame instanceof d.a.l0.h.o.d) && (X0 = ((d.a.l0.h.o.d) frame).X0()) != null) {
            X0.F(d.a.l0.h.f.a.a(jSONObject));
        }
    }

    public final void d(@NonNull d.a.l0.a.a2.e eVar, @NonNull Context context, @NonNull d.a.l0.a.y.b.a aVar, boolean z) {
        d.a.l0.a.h0.e.c.a(eVar, context, new a(z, context, aVar));
    }

    public final void e(d.a.l0.a.y.b.a aVar, boolean z, String str) {
        d.a.l0.h.d.c.b bVar = new d.a.l0.h.d.c.b();
        bVar.errMsg = str;
        d.a.l0.h.m0.c.a(aVar, z, bVar);
    }

    public final String f(String str) {
        return String.format("setEnableDebug:fail %s", str);
    }

    public final void g(Context context, d.a.l0.a.y.b.a aVar) {
        d.m().o(new b(context, aVar));
    }

    public void i(JsObject jsObject) {
        d.a.l0.a.y.b.a G = d.a.l0.a.y.b.a.G(jsObject);
        if (G == null) {
            return;
        }
        boolean m = G.m("enableDebug");
        d.a.l0.a.a2.e i2 = d.a.l0.a.a2.e.i();
        if (i2 == null) {
            e(G, false, f("internal error"));
            return;
        }
        SwanAppActivity x = i2.x();
        if (x == null) {
            e(G, false, f("internal error"));
        } else if (m == d.a.l0.a.e0.a.a()) {
            e(G, true, "setEnableDebug:ok");
        } else {
            d(i2, x, G, m);
        }
    }
}
