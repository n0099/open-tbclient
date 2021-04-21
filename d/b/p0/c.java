package d.b.p0;

import android.content.Context;
import android.os.Looper;
import android.util.Log;
import d.b.p0.e.e;
/* loaded from: classes5.dex */
public class c {

    /* renamed from: b  reason: collision with root package name */
    public static String f65161b = "UnionIDHelper";

    /* renamed from: c  reason: collision with root package name */
    public static boolean f65162c = false;

    /* renamed from: d  reason: collision with root package name */
    public static c f65163d;

    /* renamed from: a  reason: collision with root package name */
    public Context f65164a;

    /* loaded from: classes5.dex */
    public class a implements d.b.p0.e.f.b {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ b f65165a;

        public a(c cVar, b bVar) {
            this.f65165a = bVar;
        }

        @Override // d.b.p0.e.f.b
        public void a(d.b.p0.e.f.c cVar) {
            if (c.f65162c) {
                String str = c.f65161b;
                Log.d(str, "异步回调 结果:" + cVar);
                String str2 = c.f65161b;
                StringBuilder sb = new StringBuilder();
                sb.append("异步回调 (listener != null):");
                sb.append(this.f65165a != null);
                Log.d(str2, sb.toString());
            }
            b bVar = this.f65165a;
            if (bVar != null) {
                bVar.a(0, cVar == null ? null : new d.b.p0.a(cVar.b(), cVar.h(), cVar.getOAID(), cVar.getAAID(), cVar.getVAID(), cVar.getStatusCode()));
            }
        }
    }

    public c(Context context) {
        this.f65164a = context.getApplicationContext();
    }

    public static c c(Context context) {
        if (f65163d == null) {
            synchronized (c.class) {
                if (f65163d == null) {
                    f65163d = new c(context);
                    d.b.p0.e.a.c(context);
                }
            }
        }
        return f65163d;
    }

    public void d(d dVar, b bVar, Looper looper) {
        e.o().i(this.f65164a, looper, new a(this, bVar));
    }

    public void e(b bVar) {
        d dVar = new d();
        dVar.b(1);
        dVar.a(false);
        d(dVar, bVar, Looper.getMainLooper());
    }
}
