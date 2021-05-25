package d.a.l0.a.e0.h;

import android.content.Context;
import com.baidu.searchbox.elasticthread.ExecutorUtilsExt;
import d.a.l0.a.e0.f.f.d;
import d.a.l0.a.k2.g.h;
/* loaded from: classes2.dex */
public class a {

    /* renamed from: d  reason: collision with root package name */
    public static int f41507d;

    /* renamed from: a  reason: collision with root package name */
    public Context f41508a;

    /* renamed from: b  reason: collision with root package name */
    public b f41509b;

    /* renamed from: c  reason: collision with root package name */
    public c f41510c;

    /* renamed from: d.a.l0.a.e0.h.a$a  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public class RunnableC0604a implements Runnable {
        public RunnableC0604a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            if (d.a.l0.a.e0.f.b.e() || a.e() != 0) {
                a.this.f41510c = new d.a.l0.a.e0.h.c.c(String.format("v8in%s_devtools_remote", a.this.f41508a.getPackageName()), a.this.f41509b);
            } else if (d.a.l0.a.e0.f.b.f()) {
                a.this.f41510c = new d.a.l0.a.e0.h.c.b(d.e(), a.this.f41509b);
            } else {
                d.a.l0.a.e0.d.b("V8Inspector", "Unknown inspect mode");
                return;
            }
            a.this.f41510c.start();
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
        f41507d = h.a().getBoolean("Inspector", false) ? 2 : 0;
    }

    public a(Context context) {
        this.f41508a = context;
    }

    public static int e() {
        return f41507d;
    }

    public static void g(int i2) {
        h.a().putBoolean("Inspector", i2 == 2);
        f41507d = i2;
    }

    public void f(b bVar) {
        this.f41509b = bVar;
    }

    public void h() {
        ExecutorUtilsExt.postOnSerial(new RunnableC0604a(), "V8Inspector");
    }

    public void i() {
        c cVar = this.f41510c;
        if (cVar != null) {
            cVar.stop();
            this.f41510c = null;
        }
    }
}
