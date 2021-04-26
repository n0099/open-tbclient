package d.a.h0.a.c0.f;

import android.content.Context;
import com.baidu.searchbox.elasticthread.ExecutorUtilsExt;
import d.a.h0.a.a2.g.h;
import d.a.h0.a.c0.d.e.d;
/* loaded from: classes2.dex */
public class a {

    /* renamed from: d  reason: collision with root package name */
    public static int f41682d;

    /* renamed from: a  reason: collision with root package name */
    public Context f41683a;

    /* renamed from: b  reason: collision with root package name */
    public b f41684b;

    /* renamed from: c  reason: collision with root package name */
    public c f41685c;

    /* renamed from: d.a.h0.a.c0.f.a$a  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public class RunnableC0595a implements Runnable {
        public RunnableC0595a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            if (d.a.h0.a.c0.d.b.e() || a.e() != 0) {
                a.this.f41685c = new d.a.h0.a.c0.f.c.c(String.format("v8in%s_devtools_remote", a.this.f41683a.getPackageName()), a.this.f41684b);
            } else if (d.a.h0.a.c0.d.b.f()) {
                a.this.f41685c = new d.a.h0.a.c0.f.c.b(d.e(), a.this.f41684b);
            } else {
                d.a.h0.a.c0.c.b("V8Inspector", "Unknown inspect mode");
                return;
            }
            a.this.f41685c.start();
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
        f41682d = h.a().getBoolean("Inspector", false) ? 2 : 0;
    }

    public a(Context context) {
        this.f41683a = context;
    }

    public static int e() {
        return f41682d;
    }

    public static void g(int i2) {
        h.a().putBoolean("Inspector", i2 == 2);
        f41682d = i2;
    }

    public void f(b bVar) {
        this.f41684b = bVar;
    }

    public void h() {
        ExecutorUtilsExt.postOnSerial(new RunnableC0595a(), "V8Inspector");
    }

    public void i() {
        c cVar = this.f41685c;
        if (cVar != null) {
            cVar.stop();
            this.f41685c = null;
        }
    }
}
