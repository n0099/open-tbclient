package d.a.h0.g.f;

import android.app.Activity;
import android.content.Context;
import androidx.annotation.NonNull;
import com.baidu.searchbox.v8engine.JsObject;
import com.baidu.swan.apps.SwanAppActivity;
import d.a.h0.a.e0.j.c;
import d.a.h0.g.f.d;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class g {

    /* loaded from: classes3.dex */
    public class a implements c.b {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ boolean f46315a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ Context f46316b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ d.a.h0.g.e.d.c f46317c;

        public a(boolean z, Context context, d.a.h0.g.e.d.c cVar) {
            this.f46315a = z;
            this.f46316b = context;
            this.f46317c = cVar;
        }

        @Override // d.a.h0.a.e0.j.c.b
        public void a(boolean z, String str) {
            if (z) {
                if (this.f46315a) {
                    g.this.g(this.f46316b, this.f46317c);
                    return;
                }
                d.a.h0.a.c0.a.c(this.f46316b, false);
                g.this.e(this.f46317c, true, "setEnableDebug:ok");
                return;
            }
            d.a.h0.a.e0.j.c.b(this.f46316b, str);
            g gVar = g.this;
            gVar.e(this.f46317c, false, gVar.f(str));
        }
    }

    /* loaded from: classes3.dex */
    public class b implements d.e {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ Context f46319a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ d.a.h0.g.e.d.c f46320b;

        public b(Context context, d.a.h0.g.e.d.c cVar) {
            this.f46319a = context;
            this.f46320b = cVar;
        }

        @Override // d.a.h0.g.f.d.e
        public void a(boolean z) {
            if (z) {
                d.a.h0.a.c0.a.c(this.f46319a, true);
                g.this.e(this.f46320b, true, "setEnableDebug:ok");
                return;
            }
            d.m().p((Activity) this.f46319a, null);
            g.this.e(this.f46320b, false, "internet error");
        }
    }

    public g(d.a.h0.g.i.b bVar) {
    }

    public static void h(JSONObject jSONObject) {
        SwanAppActivity v;
        d.a.h0.g.i.a U0;
        d.a.h0.a.r1.e h2 = d.a.h0.a.r1.e.h();
        if (h2 == null || !h2.i0() || (v = h2.v()) == null) {
            return;
        }
        d.a.h0.a.o0.c frame = v.getFrame();
        if ((frame instanceof d.a.h0.g.m.b) && (U0 = ((d.a.h0.g.m.b) frame).U0()) != null) {
            U0.Q(d.a.h0.g.f.a.a(jSONObject));
        }
    }

    public final void d(@NonNull d.a.h0.a.r1.e eVar, @NonNull Context context, @NonNull d.a.h0.g.e.d.c cVar, boolean z) {
        d.a.h0.a.e0.j.c.a(eVar, context, new a(z, context, cVar));
    }

    public final void e(d.a.h0.g.e.d.c cVar, boolean z, String str) {
        d.a.h0.g.e.d.b bVar = new d.a.h0.g.e.d.b();
        bVar.errMsg = str;
        d.a.h0.g.i0.b.a(cVar, z, bVar);
    }

    public final String f(String str) {
        return String.format("setEnableDebug:fail %s", str);
    }

    public final void g(Context context, d.a.h0.g.e.d.c cVar) {
        d.m().o(new b(context, cVar));
    }

    public void i(JsObject jsObject) {
        d.a.h0.g.e.d.c F = d.a.h0.g.e.d.c.F(jsObject);
        if (F == null) {
            return;
        }
        boolean m = F.m("enableDebug");
        d.a.h0.a.r1.e h2 = d.a.h0.a.r1.e.h();
        if (h2 == null) {
            e(F, false, f("internal error"));
            return;
        }
        SwanAppActivity v = h2.v();
        if (v == null) {
            e(F, false, f("internal error"));
        } else if (m == d.a.h0.a.c0.a.a()) {
            e(F, true, "setEnableDebug:ok");
        } else {
            d(h2, v, F, m);
        }
    }
}
