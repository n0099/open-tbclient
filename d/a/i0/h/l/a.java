package d.a.i0.h.l;

import android.util.Log;
import com.baidu.searchbox.v8engine.JsObject;
import d.a.i0.a.a2.e;
import d.a.i0.a.e2.c.f;
import d.a.i0.a.k;
import d.a.i0.a.v2.e1.b;
import d.a.i0.h.m0.c;
/* loaded from: classes3.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    public static final boolean f47263a = k.f43025a;

    /* renamed from: d.a.i0.h.l.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public static class C1018a implements b<f> {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ d.a.i0.a.y.b.a f47264e;

        public C1018a(d.a.i0.a.y.b.a aVar) {
            this.f47264e = aVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.a.i0.a.v2.e1.b
        /* renamed from: a */
        public void onCallback(f fVar) {
            if (fVar == null || fVar.f41523d || fVar.j != 1) {
                a.c(this.f47264e, false, "system deny");
            } else {
                a.c(this.f47264e, true, "authorize:ok");
            }
        }
    }

    public static void b(JsObject jsObject) {
        d.a.i0.a.y.b.a G = d.a.i0.a.y.b.a.G(jsObject);
        if (G == null) {
            return;
        }
        e Q = e.Q();
        if (Q == null) {
            c(G, false, "authorize:fail internal error");
        } else {
            Q.T().e("mapp_enable_eval", new C1018a(G));
        }
    }

    public static void c(d.a.i0.a.y.b.a aVar, boolean z, String str) {
        if (f47263a) {
            Log.i("AuthorizeEvalApi", "callAsyncCallback: " + str);
        }
        d.a.i0.h.d.c.b bVar = new d.a.i0.h.d.c.b();
        bVar.errMsg = str;
        c.a(aVar, z, bVar);
    }
}
