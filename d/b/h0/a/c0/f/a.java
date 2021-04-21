package d.b.h0.a.c0.f;

import android.content.Context;
import com.baidu.searchbox.elasticthread.ExecutorUtilsExt;
import d.b.h0.a.a2.g.h;
import d.b.h0.a.c0.d.e.d;
/* loaded from: classes2.dex */
public class a {

    /* renamed from: d  reason: collision with root package name */
    public static int f44394d;

    /* renamed from: a  reason: collision with root package name */
    public Context f44395a;

    /* renamed from: b  reason: collision with root package name */
    public b f44396b;

    /* renamed from: c  reason: collision with root package name */
    public c f44397c;

    /* renamed from: d.b.h0.a.c0.f.a$a  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public class RunnableC0656a implements Runnable {
        public RunnableC0656a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            if (d.b.h0.a.c0.d.b.e() || a.e() != 0) {
                a.this.f44397c = new d.b.h0.a.c0.f.c.c(String.format("v8in%s_devtools_remote", a.this.f44395a.getPackageName()), a.this.f44396b);
            } else if (d.b.h0.a.c0.d.b.f()) {
                a.this.f44397c = new d.b.h0.a.c0.f.c.b(d.e(), a.this.f44396b);
            } else {
                d.b.h0.a.c0.c.b("V8Inspector", "Unknown inspect mode");
                return;
            }
            a.this.f44397c.start();
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
        f44394d = h.a().getBoolean("Inspector", false) ? 2 : 0;
    }

    public a(Context context) {
        this.f44395a = context;
    }

    public static int e() {
        return f44394d;
    }

    public static void g(int i) {
        h.a().putBoolean("Inspector", i == 2);
        f44394d = i;
    }

    public void f(b bVar) {
        this.f44396b = bVar;
    }

    public void h() {
        ExecutorUtilsExt.postOnSerial(new RunnableC0656a(), "V8Inspector");
    }

    public void i() {
        c cVar = this.f44397c;
        if (cVar != null) {
            cVar.stop();
            this.f44397c = null;
        }
    }
}
