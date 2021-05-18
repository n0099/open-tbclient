package d.a.i0.a.e0.h;

import android.content.Context;
import com.baidu.searchbox.elasticthread.ExecutorUtilsExt;
import d.a.i0.a.e0.f.f.d;
import d.a.i0.a.k2.g.h;
/* loaded from: classes2.dex */
public class a {

    /* renamed from: d  reason: collision with root package name */
    public static int f41333d;

    /* renamed from: a  reason: collision with root package name */
    public Context f41334a;

    /* renamed from: b  reason: collision with root package name */
    public b f41335b;

    /* renamed from: c  reason: collision with root package name */
    public c f41336c;

    /* renamed from: d.a.i0.a.e0.h.a$a  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public class RunnableC0593a implements Runnable {
        public RunnableC0593a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            if (d.a.i0.a.e0.f.b.e() || a.e() != 0) {
                a.this.f41336c = new d.a.i0.a.e0.h.c.c(String.format("v8in%s_devtools_remote", a.this.f41334a.getPackageName()), a.this.f41335b);
            } else if (d.a.i0.a.e0.f.b.f()) {
                a.this.f41336c = new d.a.i0.a.e0.h.c.b(d.e(), a.this.f41335b);
            } else {
                d.a.i0.a.e0.d.b("V8Inspector", "Unknown inspect mode");
                return;
            }
            a.this.f41336c.start();
        }
    }

    /* loaded from: classes2.dex */
    public interface b {
        void onConnected();
    }

    /* loaded from: classes2.dex */
    public interface c {
        void start();

        void stop();
    }

    static {
        f41333d = h.a().getBoolean("Inspector", false) ? 2 : 0;
    }

    public a(Context context) {
        this.f41334a = context;
    }

    public static int e() {
        return f41333d;
    }

    public static void g(int i2) {
        h.a().putBoolean("Inspector", i2 == 2);
        f41333d = i2;
    }

    public void f(b bVar) {
        this.f41335b = bVar;
    }

    public void h() {
        ExecutorUtilsExt.postOnSerial(new RunnableC0593a(), "V8Inspector");
    }

    public void i() {
        c cVar = this.f41336c;
        if (cVar != null) {
            cVar.stop();
            this.f41336c = null;
        }
    }
}
