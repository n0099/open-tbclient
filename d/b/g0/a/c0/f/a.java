package d.b.g0.a.c0.f;

import android.content.Context;
import com.baidu.searchbox.elasticthread.ExecutorUtilsExt;
import d.b.g0.a.a2.g.h;
import d.b.g0.a.c0.d.e.d;
/* loaded from: classes3.dex */
public class a {

    /* renamed from: d  reason: collision with root package name */
    public static int f43672d;

    /* renamed from: a  reason: collision with root package name */
    public Context f43673a;

    /* renamed from: b  reason: collision with root package name */
    public b f43674b;

    /* renamed from: c  reason: collision with root package name */
    public c f43675c;

    /* renamed from: d.b.g0.a.c0.f.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public class RunnableC0623a implements Runnable {
        public RunnableC0623a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            if (d.b.g0.a.c0.d.b.e() || a.e() != 0) {
                a.this.f43675c = new d.b.g0.a.c0.f.c.c(String.format("v8in%s_devtools_remote", a.this.f43673a.getPackageName()), a.this.f43674b);
            } else if (d.b.g0.a.c0.d.b.f()) {
                a.this.f43675c = new d.b.g0.a.c0.f.c.b(d.e(), a.this.f43674b);
            } else {
                d.b.g0.a.c0.c.b("V8Inspector", "Unknown inspect mode");
                return;
            }
            a.this.f43675c.start();
        }
    }

    /* loaded from: classes3.dex */
    public interface b {
        void onConnected();
    }

    /* loaded from: classes3.dex */
    public interface c {
        void start();

        void stop();
    }

    static {
        f43672d = h.a().getBoolean("Inspector", false) ? 2 : 0;
    }

    public a(Context context) {
        this.f43673a = context;
    }

    public static int e() {
        return f43672d;
    }

    public static void g(int i) {
        h.a().putBoolean("Inspector", i == 2);
        f43672d = i;
    }

    public void f(b bVar) {
        this.f43674b = bVar;
    }

    public void h() {
        ExecutorUtilsExt.postOnSerial(new RunnableC0623a(), "V8Inspector");
    }

    public void i() {
        c cVar = this.f43675c;
        if (cVar != null) {
            cVar.stop();
            this.f43675c = null;
        }
    }
}
