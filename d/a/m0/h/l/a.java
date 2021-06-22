package d.a.m0.h.l;

import android.util.Log;
import com.baidu.searchbox.v8engine.JsObject;
import d.a.m0.a.a2.e;
import d.a.m0.a.e2.c.f;
import d.a.m0.a.k;
import d.a.m0.a.v2.e1.b;
import d.a.m0.h.m0.c;
/* loaded from: classes3.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    public static final boolean f51221a = k.f46983a;

    /* renamed from: d.a.m0.h.l.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public static class C1088a implements b<f> {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ d.a.m0.a.y.b.a f51222e;

        public C1088a(d.a.m0.a.y.b.a aVar) {
            this.f51222e = aVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.a.m0.a.v2.e1.b
        /* renamed from: a */
        public void onCallback(f fVar) {
            if (fVar == null || fVar.f45481d || fVar.j != 1) {
                a.c(this.f51222e, false, "system deny");
            } else {
                a.c(this.f51222e, true, "authorize:ok");
            }
        }
    }

    public static void b(JsObject jsObject) {
        d.a.m0.a.y.b.a G = d.a.m0.a.y.b.a.G(jsObject);
        if (G == null) {
            return;
        }
        e Q = e.Q();
        if (Q == null) {
            c(G, false, "authorize:fail internal error");
        } else {
            Q.T().e("mapp_enable_eval", new C1088a(G));
        }
    }

    public static void c(d.a.m0.a.y.b.a aVar, boolean z, String str) {
        if (f51221a) {
            Log.i("AuthorizeEvalApi", "callAsyncCallback: " + str);
        }
        d.a.m0.h.d.c.b bVar = new d.a.m0.h.d.c.b();
        bVar.errMsg = str;
        c.a(aVar, z, bVar);
    }
}
