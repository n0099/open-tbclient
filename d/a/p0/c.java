package d.a.p0;

import android.content.Context;
import android.os.Looper;
import android.util.Log;
import d.a.p0.e.e;
/* loaded from: classes5.dex */
public class c {

    /* renamed from: b  reason: collision with root package name */
    public static String f63475b = "UnionIDHelper";

    /* renamed from: c  reason: collision with root package name */
    public static boolean f63476c = false;

    /* renamed from: d  reason: collision with root package name */
    public static c f63477d;

    /* renamed from: a  reason: collision with root package name */
    public Context f63478a;

    /* loaded from: classes5.dex */
    public class a implements d.a.p0.e.f.b {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ b f63479a;

        public a(c cVar, b bVar) {
            this.f63479a = bVar;
        }

        @Override // d.a.p0.e.f.b
        public void a(d.a.p0.e.f.c cVar) {
            if (c.f63476c) {
                String str = c.f63475b;
                Log.d(str, "异步回调 结果:" + cVar);
                String str2 = c.f63475b;
                StringBuilder sb = new StringBuilder();
                sb.append("异步回调 (listener != null):");
                sb.append(this.f63479a != null);
                Log.d(str2, sb.toString());
            }
            b bVar = this.f63479a;
            if (bVar != null) {
                bVar.a(0, cVar == null ? null : new d.a.p0.a(cVar.c(), cVar.h(), cVar.getOAID(), cVar.getAAID(), cVar.getVAID(), cVar.getStatusCode()));
            }
        }
    }

    public c(Context context) {
        this.f63478a = context.getApplicationContext();
    }

    public static c c(Context context) {
        if (f63477d == null) {
            synchronized (c.class) {
                if (f63477d == null) {
                    f63477d = new c(context);
                    d.a.p0.e.a.c(context);
                }
            }
        }
        return f63477d;
    }

    public void d(d dVar, b bVar, Looper looper) {
        e.o().i(this.f63478a, looper, new a(this, bVar));
    }

    public void e(b bVar) {
        d dVar = new d();
        dVar.b(1);
        dVar.a(false);
        d(dVar, bVar, Looper.getMainLooper());
    }
}
