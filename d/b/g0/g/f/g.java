package d.b.g0.g.f;

import android.app.Activity;
import android.content.Context;
import androidx.annotation.NonNull;
import com.baidu.searchbox.v8engine.JsObject;
import com.baidu.swan.apps.SwanAppActivity;
import d.b.g0.a.e0.j.c;
import d.b.g0.g.f.d;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class g {

    /* loaded from: classes3.dex */
    public class a implements c.b {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ boolean f48515a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ Context f48516b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ d.b.g0.g.e.d.c f48517c;

        public a(boolean z, Context context, d.b.g0.g.e.d.c cVar) {
            this.f48515a = z;
            this.f48516b = context;
            this.f48517c = cVar;
        }

        @Override // d.b.g0.a.e0.j.c.b
        public void a(boolean z, String str) {
            if (z) {
                if (this.f48515a) {
                    g.this.g(this.f48516b, this.f48517c);
                    return;
                }
                d.b.g0.a.c0.a.c(this.f48516b, false);
                g.this.e(this.f48517c, true, "setEnableDebug:ok");
                return;
            }
            d.b.g0.a.e0.j.c.b(this.f48516b, str);
            g gVar = g.this;
            gVar.e(this.f48517c, false, gVar.f(str));
        }
    }

    /* loaded from: classes3.dex */
    public class b implements d.e {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ Context f48519a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ d.b.g0.g.e.d.c f48520b;

        public b(Context context, d.b.g0.g.e.d.c cVar) {
            this.f48519a = context;
            this.f48520b = cVar;
        }

        @Override // d.b.g0.g.f.d.e
        public void a(boolean z) {
            if (z) {
                d.b.g0.a.c0.a.c(this.f48519a, true);
                g.this.e(this.f48520b, true, "setEnableDebug:ok");
                return;
            }
            d.m().p((Activity) this.f48519a, null);
            g.this.e(this.f48520b, false, "internet error");
        }
    }

    public g(d.b.g0.g.i.b bVar) {
    }

    public static void h(JSONObject jSONObject) {
        SwanAppActivity n;
        d.b.g0.g.i.a U0;
        d.b.g0.a.r1.e y = d.b.g0.a.r1.e.y();
        if (y == null || !y.i0() || (n = y.n()) == null) {
            return;
        }
        d.b.g0.a.o0.c frame = n.getFrame();
        if ((frame instanceof d.b.g0.g.m.b) && (U0 = ((d.b.g0.g.m.b) frame).U0()) != null) {
            U0.d0(d.b.g0.g.f.a.a(jSONObject));
        }
    }

    public final void d(@NonNull d.b.g0.a.r1.e eVar, @NonNull Context context, @NonNull d.b.g0.g.e.d.c cVar, boolean z) {
        d.b.g0.a.e0.j.c.a(eVar, context, new a(z, context, cVar));
    }

    public final void e(d.b.g0.g.e.d.c cVar, boolean z, String str) {
        d.b.g0.g.e.d.b bVar = new d.b.g0.g.e.d.b();
        bVar.errMsg = str;
        d.b.g0.g.i0.b.a(cVar, z, bVar);
    }

    public final String f(String str) {
        return String.format("setEnableDebug:fail %s", str);
    }

    public final void g(Context context, d.b.g0.g.e.d.c cVar) {
        d.m().o(new b(context, cVar));
    }

    public void i(JsObject jsObject) {
        d.b.g0.g.e.d.c F = d.b.g0.g.e.d.c.F(jsObject);
        if (F == null) {
            return;
        }
        boolean m = F.m("enableDebug");
        d.b.g0.a.r1.e y = d.b.g0.a.r1.e.y();
        if (y == null) {
            e(F, false, f("internal error"));
            return;
        }
        SwanAppActivity n = y.n();
        if (n == null) {
            e(F, false, f("internal error"));
        } else if (m == d.b.g0.a.c0.a.a()) {
            e(F, true, "setEnableDebug:ok");
        } else {
            d(y, n, F, m);
        }
    }
}
