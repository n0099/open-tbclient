package d.a.h0.a.n1.c;

import android.os.Handler;
import android.os.Looper;
import android.util.Log;
import androidx.annotation.NonNull;
import com.baidu.searchbox.process.ipc.util.ProcessUtils;
import com.baidu.swan.apps.process.SwanAppProcessInfo;
import d.a.h0.a.k;
import d.a.h0.a.n1.c.f.d;
/* loaded from: classes3.dex */
public final class a {

    /* renamed from: b  reason: collision with root package name */
    public static final boolean f43427b = k.f43101a;

    /* renamed from: a  reason: collision with root package name */
    public c f43428a;

    /* renamed from: d.a.h0.a.n1.c.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public class RunnableC0715a implements Runnable {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ d.a.h0.a.n1.c.c f43429e;

        public RunnableC0715a(d.a.h0.a.n1.c.c cVar) {
            this.f43429e = cVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            a.this.g(this.f43429e);
        }
    }

    /* loaded from: classes3.dex */
    public static class b {

        /* renamed from: a  reason: collision with root package name */
        public static a f43431a = new a();
    }

    /* loaded from: classes3.dex */
    public interface c {
        void a();

        void b(@NonNull d.a.h0.a.n1.c.c cVar);

        void c(String str);

        void d(String str);
    }

    public static a e() {
        return b.f43431a;
    }

    public static void f(String str) {
        if (f43427b) {
            Log.i("SwanAppMessenger", str);
        }
    }

    public void b(String str) {
        c cVar = this.f43428a;
        if (cVar != null) {
            cVar.d(str);
        }
    }

    public void c() {
        c cVar = this.f43428a;
        if (cVar != null) {
            cVar.a();
        }
    }

    public void d(String str) {
        c cVar = this.f43428a;
        if (cVar != null) {
            cVar.c(str);
        }
    }

    public final void g(@NonNull d.a.h0.a.n1.c.c cVar) {
        boolean isMainProcess = ProcessUtils.isMainProcess();
        if (!isMainProcess && !SwanAppProcessInfo.isInited()) {
            f("send: return by process check");
            return;
        }
        if (this.f43428a == null) {
            this.f43428a = isMainProcess ? new d() : new d.a.h0.a.n1.c.e.b();
        }
        f("send: sender=" + this.f43428a);
        this.f43428a.a();
        this.f43428a.b(cVar);
        this.f43428a.a();
    }

    public void h(@NonNull d.a.h0.a.n1.c.c cVar) {
        long i2 = cVar.i();
        int i3 = (i2 > 0L ? 1 : (i2 == 0L ? 0 : -1));
        if (i3 <= 0 && Looper.getMainLooper() == Looper.myLooper()) {
            g(cVar);
            return;
        }
        Handler g2 = d.a.h0.a.r1.d.g();
        RunnableC0715a runnableC0715a = new RunnableC0715a(cVar);
        if (i3 < 0) {
            i2 = 0;
        }
        g2.postDelayed(runnableC0715a, i2);
    }
}
