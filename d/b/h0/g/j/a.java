package d.b.h0.g.j;

import android.util.Log;
import com.baidu.searchbox.v8engine.JsObject;
import d.b.h0.a.i2.u0.b;
import d.b.h0.a.k;
import d.b.h0.a.v1.c.e;
import d.b.h0.g.e.d.c;
/* loaded from: classes3.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    public static final boolean f48955a = k.f45772a;

    /* renamed from: d.b.h0.g.j.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public static class C1000a implements b<e> {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ c f48956e;

        public C1000a(c cVar) {
            this.f48956e = cVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.b.h0.a.i2.u0.b
        /* renamed from: a */
        public void onCallback(e eVar) {
            if (eVar == null || eVar.f47492d || eVar.j != 1) {
                a.c(this.f48956e, false, "system deny");
            } else {
                a.c(this.f48956e, true, "authorize:ok");
            }
        }
    }

    public static void b(JsObject jsObject) {
        c F = c.F(jsObject);
        if (F == null) {
            return;
        }
        d.b.h0.a.r1.e O = d.b.h0.a.r1.e.O();
        if (O == null) {
            c(F, false, "authorize:fail internal error");
        } else {
            O.R().e("mapp_enable_eval", new C1000a(F));
        }
    }

    public static void c(c cVar, boolean z, String str) {
        if (f48955a) {
            Log.i("AuthorizeEvalApi", "callAsyncCallback: " + str);
        }
        d.b.h0.g.e.d.b bVar = new d.b.h0.g.e.d.b();
        bVar.errMsg = str;
        d.b.h0.g.i0.b.a(cVar, z, bVar);
    }
}
