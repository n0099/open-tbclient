package d.b.o0;

import android.content.Context;
import android.os.Looper;
import android.util.Log;
import d.b.o0.e.e;
/* loaded from: classes5.dex */
public class c {

    /* renamed from: b  reason: collision with root package name */
    public static String f64897b = "UnionIDHelper";

    /* renamed from: c  reason: collision with root package name */
    public static boolean f64898c = false;

    /* renamed from: d  reason: collision with root package name */
    public static c f64899d;

    /* renamed from: a  reason: collision with root package name */
    public Context f64900a;

    /* loaded from: classes5.dex */
    public class a implements d.b.o0.e.f.b {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ b f64901a;

        public a(c cVar, b bVar) {
            this.f64901a = bVar;
        }

        @Override // d.b.o0.e.f.b
        public void a(d.b.o0.e.f.c cVar) {
            if (c.f64898c) {
                String str = c.f64897b;
                Log.d(str, "异步回调 结果:" + cVar);
                String str2 = c.f64897b;
                StringBuilder sb = new StringBuilder();
                sb.append("异步回调 (listener != null):");
                sb.append(this.f64901a != null);
                Log.d(str2, sb.toString());
            }
            b bVar = this.f64901a;
            if (bVar != null) {
                bVar.a(0, cVar == null ? null : new d.b.o0.a(cVar.b(), cVar.h(), cVar.getOAID(), cVar.getAAID(), cVar.getVAID(), cVar.getStatusCode()));
            }
        }
    }

    public c(Context context) {
        this.f64900a = context.getApplicationContext();
    }

    public static c c(Context context) {
        if (f64899d == null) {
            synchronized (c.class) {
                if (f64899d == null) {
                    f64899d = new c(context);
                    d.b.o0.e.a.c(context);
                }
            }
        }
        return f64899d;
    }

    public void d(d dVar, b bVar, Looper looper) {
        e.o().i(this.f64900a, looper, new a(this, bVar));
    }

    public void e(b bVar) {
        d dVar = new d();
        dVar.b(1);
        dVar.a(false);
        d(dVar, bVar, Looper.getMainLooper());
    }
}
