package d.b.g0.a.n1.c;

import android.os.Handler;
import android.os.Looper;
import android.util.Log;
import androidx.annotation.NonNull;
import com.baidu.searchbox.process.ipc.util.ProcessUtils;
import com.baidu.swan.apps.process.SwanAppProcessInfo;
import d.b.g0.a.k;
import d.b.g0.a.n1.c.f.d;
/* loaded from: classes2.dex */
public final class a {

    /* renamed from: b  reason: collision with root package name */
    public static final boolean f45754b = k.f45443a;

    /* renamed from: a  reason: collision with root package name */
    public c f45755a;

    /* renamed from: d.b.g0.a.n1.c.a$a  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public class RunnableC0756a implements Runnable {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ d.b.g0.a.n1.c.c f45756e;

        public RunnableC0756a(d.b.g0.a.n1.c.c cVar) {
            this.f45756e = cVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            a.this.g(this.f45756e);
        }
    }

    /* loaded from: classes2.dex */
    public static class b {

        /* renamed from: a  reason: collision with root package name */
        public static a f45758a = new a();
    }

    /* loaded from: classes2.dex */
    public interface c {
        void a();

        void b(@NonNull d.b.g0.a.n1.c.c cVar);

        void c(String str);

        void d(String str);
    }

    public static a e() {
        return b.f45758a;
    }

    public static void f(String str) {
        if (f45754b) {
            Log.i("SwanAppMessenger", str);
        }
    }

    public void b(String str) {
        c cVar = this.f45755a;
        if (cVar != null) {
            cVar.d(str);
        }
    }

    public void c() {
        c cVar = this.f45755a;
        if (cVar != null) {
            cVar.a();
        }
    }

    public void d(String str) {
        c cVar = this.f45755a;
        if (cVar != null) {
            cVar.c(str);
        }
    }

    public final void g(@NonNull d.b.g0.a.n1.c.c cVar) {
        boolean isMainProcess = ProcessUtils.isMainProcess();
        if (!isMainProcess && !SwanAppProcessInfo.isInited()) {
            f("send: return by process check");
            return;
        }
        if (this.f45755a == null) {
            this.f45755a = isMainProcess ? new d() : new d.b.g0.a.n1.c.e.b();
        }
        f("send: sender=" + this.f45755a);
        this.f45755a.a();
        this.f45755a.b(cVar);
        this.f45755a.a();
    }

    public void h(@NonNull d.b.g0.a.n1.c.c cVar) {
        long i = cVar.i();
        int i2 = (i > 0L ? 1 : (i == 0L ? 0 : -1));
        if (i2 <= 0 && Looper.getMainLooper() == Looper.myLooper()) {
            g(cVar);
            return;
        }
        Handler g2 = d.b.g0.a.r1.d.g();
        RunnableC0756a runnableC0756a = new RunnableC0756a(cVar);
        if (i2 < 0) {
            i = 0;
        }
        g2.postDelayed(runnableC0756a, i);
    }
}
