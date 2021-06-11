package d.a.t0;

import android.content.Context;
import android.os.Looper;
import android.util.Log;
import d.a.t0.e.e;
/* loaded from: classes5.dex */
public class c {

    /* renamed from: b  reason: collision with root package name */
    public static String f68369b = "UnionIDHelper";

    /* renamed from: c  reason: collision with root package name */
    public static boolean f68370c = false;

    /* renamed from: d  reason: collision with root package name */
    public static c f68371d;

    /* renamed from: a  reason: collision with root package name */
    public Context f68372a;

    /* loaded from: classes5.dex */
    public class a implements d.a.t0.e.f.b {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ b f68373a;

        public a(c cVar, b bVar) {
            this.f68373a = bVar;
        }

        @Override // d.a.t0.e.f.b
        public void a(d.a.t0.e.f.c cVar) {
            if (c.f68370c) {
                String str = c.f68369b;
                Log.d(str, "异步回调 结果:" + cVar);
                String str2 = c.f68369b;
                StringBuilder sb = new StringBuilder();
                sb.append("异步回调 (listener != null):");
                sb.append(this.f68373a != null);
                Log.d(str2, sb.toString());
            }
            b bVar = this.f68373a;
            if (bVar != null) {
                bVar.a(0, cVar == null ? null : new d.a.t0.a(cVar.c(), cVar.h(), cVar.getOAID(), cVar.getAAID(), cVar.getVAID(), cVar.getStatusCode()));
            }
        }
    }

    public c(Context context) {
        this.f68372a = context.getApplicationContext();
    }

    public static c c(Context context) {
        if (f68371d == null) {
            synchronized (c.class) {
                if (f68371d == null) {
                    f68371d = new c(context);
                    d.a.t0.e.a.c(context);
                }
            }
        }
        return f68371d;
    }

    public void d(d dVar, b bVar, Looper looper) {
        e.o().i(this.f68372a, looper, new a(this, bVar));
    }

    public void e(b bVar) {
        d dVar = new d();
        dVar.b(1);
        dVar.a(false);
        d(dVar, bVar, Looper.getMainLooper());
    }
}
