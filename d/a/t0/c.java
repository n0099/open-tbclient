package d.a.t0;

import android.content.Context;
import android.os.Looper;
import android.util.Log;
import d.a.t0.e.e;
/* loaded from: classes5.dex */
public class c {

    /* renamed from: b  reason: collision with root package name */
    public static String f64651b = "UnionIDHelper";

    /* renamed from: c  reason: collision with root package name */
    public static boolean f64652c = false;

    /* renamed from: d  reason: collision with root package name */
    public static c f64653d;

    /* renamed from: a  reason: collision with root package name */
    public Context f64654a;

    /* loaded from: classes5.dex */
    public class a implements d.a.t0.e.f.b {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ b f64655a;

        public a(c cVar, b bVar) {
            this.f64655a = bVar;
        }

        @Override // d.a.t0.e.f.b
        public void a(d.a.t0.e.f.c cVar) {
            if (c.f64652c) {
                String str = c.f64651b;
                Log.d(str, "异步回调 结果:" + cVar);
                String str2 = c.f64651b;
                StringBuilder sb = new StringBuilder();
                sb.append("异步回调 (listener != null):");
                sb.append(this.f64655a != null);
                Log.d(str2, sb.toString());
            }
            b bVar = this.f64655a;
            if (bVar != null) {
                bVar.a(0, cVar == null ? null : new d.a.t0.a(cVar.c(), cVar.h(), cVar.getOAID(), cVar.getAAID(), cVar.getVAID(), cVar.getStatusCode()));
            }
        }
    }

    public c(Context context) {
        this.f64654a = context.getApplicationContext();
    }

    public static c c(Context context) {
        if (f64653d == null) {
            synchronized (c.class) {
                if (f64653d == null) {
                    f64653d = new c(context);
                    d.a.t0.e.a.c(context);
                }
            }
        }
        return f64653d;
    }

    public void d(d dVar, b bVar, Looper looper) {
        e.o().i(this.f64654a, looper, new a(this, bVar));
    }

    public void e(b bVar) {
        d dVar = new d();
        dVar.b(1);
        dVar.a(false);
        d(dVar, bVar, Looper.getMainLooper());
    }
}
