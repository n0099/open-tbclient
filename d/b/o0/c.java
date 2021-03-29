package d.b.o0;

import android.content.Context;
import android.os.Looper;
import android.util.Log;
import d.b.o0.e.e;
/* loaded from: classes5.dex */
public class c {

    /* renamed from: b  reason: collision with root package name */
    public static String f64184b = "UnionIDHelper";

    /* renamed from: c  reason: collision with root package name */
    public static boolean f64185c = false;

    /* renamed from: d  reason: collision with root package name */
    public static c f64186d;

    /* renamed from: a  reason: collision with root package name */
    public Context f64187a;

    /* loaded from: classes5.dex */
    public class a implements d.b.o0.e.f.b {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ b f64188a;

        public a(c cVar, b bVar) {
            this.f64188a = bVar;
        }

        @Override // d.b.o0.e.f.b
        public void a(d.b.o0.e.f.c cVar) {
            if (c.f64185c) {
                String str = c.f64184b;
                Log.d(str, "异步回调 结果:" + cVar);
                String str2 = c.f64184b;
                StringBuilder sb = new StringBuilder();
                sb.append("异步回调 (listener != null):");
                sb.append(this.f64188a != null);
                Log.d(str2, sb.toString());
            }
            b bVar = this.f64188a;
            if (bVar != null) {
                bVar.a(0, cVar == null ? null : new d.b.o0.a(cVar.b(), cVar.h(), cVar.getOAID(), cVar.getAAID(), cVar.getVAID(), cVar.getStatusCode()));
            }
        }
    }

    public c(Context context) {
        this.f64187a = context.getApplicationContext();
    }

    public static c c(Context context) {
        if (f64186d == null) {
            synchronized (c.class) {
                if (f64186d == null) {
                    f64186d = new c(context);
                    d.b.o0.e.a.c(context);
                }
            }
        }
        return f64186d;
    }

    public void d(d dVar, b bVar, Looper looper) {
        e.o().i(this.f64187a, looper, new a(this, bVar));
    }

    public void e(b bVar) {
        d dVar = new d();
        dVar.b(1);
        dVar.a(false);
        d(dVar, bVar, Looper.getMainLooper());
    }
}
