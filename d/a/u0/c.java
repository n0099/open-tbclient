package d.a.u0;

import android.content.Context;
import android.os.Looper;
import android.util.Log;
import d.a.u0.e.e;
/* loaded from: classes5.dex */
public class c {

    /* renamed from: b  reason: collision with root package name */
    public static String f68473b = "UnionIDHelper";

    /* renamed from: c  reason: collision with root package name */
    public static boolean f68474c = false;

    /* renamed from: d  reason: collision with root package name */
    public static c f68475d;

    /* renamed from: a  reason: collision with root package name */
    public Context f68476a;

    /* loaded from: classes5.dex */
    public class a implements d.a.u0.e.f.b {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ b f68477a;

        public a(c cVar, b bVar) {
            this.f68477a = bVar;
        }

        @Override // d.a.u0.e.f.b
        public void a(d.a.u0.e.f.c cVar) {
            if (c.f68474c) {
                String str = c.f68473b;
                Log.d(str, "异步回调 结果:" + cVar);
                String str2 = c.f68473b;
                StringBuilder sb = new StringBuilder();
                sb.append("异步回调 (listener != null):");
                sb.append(this.f68477a != null);
                Log.d(str2, sb.toString());
            }
            b bVar = this.f68477a;
            if (bVar != null) {
                bVar.a(0, cVar == null ? null : new d.a.u0.a(cVar.c(), cVar.h(), cVar.getOAID(), cVar.getAAID(), cVar.getVAID(), cVar.getStatusCode()));
            }
        }
    }

    public c(Context context) {
        this.f68476a = context.getApplicationContext();
    }

    public static c c(Context context) {
        if (f68475d == null) {
            synchronized (c.class) {
                if (f68475d == null) {
                    f68475d = new c(context);
                    d.a.u0.e.a.c(context);
                }
            }
        }
        return f68475d;
    }

    public void d(d dVar, b bVar, Looper looper) {
        e.o().i(this.f68476a, looper, new a(this, bVar));
    }

    public void e(b bVar) {
        d dVar = new d();
        dVar.b(1);
        dVar.a(false);
        d(dVar, bVar, Looper.getMainLooper());
    }
}
