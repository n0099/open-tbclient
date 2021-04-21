package d.b.h0.g.f;

import android.app.Activity;
import android.content.Context;
import androidx.annotation.NonNull;
import com.baidu.searchbox.v8engine.JsObject;
import com.baidu.swan.apps.SwanAppActivity;
import d.b.h0.a.e0.j.c;
import d.b.h0.g.f.d;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class g {

    /* loaded from: classes3.dex */
    public class a implements c.b {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ boolean f48844a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ Context f48845b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ d.b.h0.g.e.d.c f48846c;

        public a(boolean z, Context context, d.b.h0.g.e.d.c cVar) {
            this.f48844a = z;
            this.f48845b = context;
            this.f48846c = cVar;
        }

        @Override // d.b.h0.a.e0.j.c.b
        public void a(boolean z, String str) {
            if (z) {
                if (this.f48844a) {
                    g.this.g(this.f48845b, this.f48846c);
                    return;
                }
                d.b.h0.a.c0.a.c(this.f48845b, false);
                g.this.e(this.f48846c, true, "setEnableDebug:ok");
                return;
            }
            d.b.h0.a.e0.j.c.b(this.f48845b, str);
            g gVar = g.this;
            gVar.e(this.f48846c, false, gVar.f(str));
        }
    }

    /* loaded from: classes3.dex */
    public class b implements d.e {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ Context f48848a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ d.b.h0.g.e.d.c f48849b;

        public b(Context context, d.b.h0.g.e.d.c cVar) {
            this.f48848a = context;
            this.f48849b = cVar;
        }

        @Override // d.b.h0.g.f.d.e
        public void a(boolean z) {
            if (z) {
                d.b.h0.a.c0.a.c(this.f48848a, true);
                g.this.e(this.f48849b, true, "setEnableDebug:ok");
                return;
            }
            d.m().p((Activity) this.f48848a, null);
            g.this.e(this.f48849b, false, "internet error");
        }
    }

    public g(d.b.h0.g.i.b bVar) {
    }

    public static void h(JSONObject jSONObject) {
        SwanAppActivity n;
        d.b.h0.g.i.a U0;
        d.b.h0.a.r1.e y = d.b.h0.a.r1.e.y();
        if (y == null || !y.i0() || (n = y.n()) == null) {
            return;
        }
        d.b.h0.a.o0.c frame = n.getFrame();
        if ((frame instanceof d.b.h0.g.m.b) && (U0 = ((d.b.h0.g.m.b) frame).U0()) != null) {
            U0.d0(d.b.h0.g.f.a.a(jSONObject));
        }
    }

    public final void d(@NonNull d.b.h0.a.r1.e eVar, @NonNull Context context, @NonNull d.b.h0.g.e.d.c cVar, boolean z) {
        d.b.h0.a.e0.j.c.a(eVar, context, new a(z, context, cVar));
    }

    public final void e(d.b.h0.g.e.d.c cVar, boolean z, String str) {
        d.b.h0.g.e.d.b bVar = new d.b.h0.g.e.d.b();
        bVar.errMsg = str;
        d.b.h0.g.i0.b.a(cVar, z, bVar);
    }

    public final String f(String str) {
        return String.format("setEnableDebug:fail %s", str);
    }

    public final void g(Context context, d.b.h0.g.e.d.c cVar) {
        d.m().o(new b(context, cVar));
    }

    public void i(JsObject jsObject) {
        d.b.h0.g.e.d.c F = d.b.h0.g.e.d.c.F(jsObject);
        if (F == null) {
            return;
        }
        boolean m = F.m("enableDebug");
        d.b.h0.a.r1.e y = d.b.h0.a.r1.e.y();
        if (y == null) {
            e(F, false, f("internal error"));
            return;
        }
        SwanAppActivity n = y.n();
        if (n == null) {
            e(F, false, f("internal error"));
        } else if (m == d.b.h0.a.c0.a.a()) {
            e(F, true, "setEnableDebug:ok");
        } else {
            d(y, n, F, m);
        }
    }
}
