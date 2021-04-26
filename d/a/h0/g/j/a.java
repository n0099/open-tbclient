package d.a.h0.g.j;

import android.util.Log;
import com.baidu.searchbox.v8engine.JsObject;
import d.a.h0.a.i2.u0.b;
import d.a.h0.a.k;
import d.a.h0.a.v1.c.e;
import d.a.h0.g.e.d.c;
/* loaded from: classes3.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    public static final boolean f46430a = k.f43101a;

    /* renamed from: d.a.h0.g.j.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public static class C0939a implements b<e> {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ c f46431e;

        public C0939a(c cVar) {
            this.f46431e = cVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.a.h0.a.i2.u0.b
        /* renamed from: a */
        public void onCallback(e eVar) {
            if (eVar == null || eVar.f44913d || eVar.j != 1) {
                a.c(this.f46431e, false, "system deny");
            } else {
                a.c(this.f46431e, true, "authorize:ok");
            }
        }
    }

    public static void b(JsObject jsObject) {
        c F = c.F(jsObject);
        if (F == null) {
            return;
        }
        d.a.h0.a.r1.e O = d.a.h0.a.r1.e.O();
        if (O == null) {
            c(F, false, "authorize:fail internal error");
        } else {
            O.R().e("mapp_enable_eval", new C0939a(F));
        }
    }

    public static void c(c cVar, boolean z, String str) {
        if (f46430a) {
            Log.i("AuthorizeEvalApi", "callAsyncCallback: " + str);
        }
        d.a.h0.g.e.d.b bVar = new d.a.h0.g.e.d.b();
        bVar.errMsg = str;
        d.a.h0.g.i0.b.a(cVar, z, bVar);
    }
}
