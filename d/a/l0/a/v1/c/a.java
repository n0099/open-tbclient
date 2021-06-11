package d.a.l0.a.v1.c;

import android.os.Handler;
import android.os.Looper;
import android.util.Log;
import androidx.annotation.NonNull;
import com.baidu.searchbox.process.ipc.util.ProcessUtils;
import com.baidu.swan.apps.process.SwanAppProcessInfo;
import d.a.l0.a.k;
import d.a.l0.a.v1.c.f.d;
/* loaded from: classes3.dex */
public final class a {

    /* renamed from: b  reason: collision with root package name */
    public static final boolean f48972b = k.f46875a;

    /* renamed from: a  reason: collision with root package name */
    public c f48973a;

    /* renamed from: d.a.l0.a.v1.c.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public class RunnableC0934a implements Runnable {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ d.a.l0.a.v1.c.c f48974e;

        public RunnableC0934a(d.a.l0.a.v1.c.c cVar) {
            this.f48974e = cVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            a.this.g(this.f48974e);
        }
    }

    /* loaded from: classes3.dex */
    public static class b {

        /* renamed from: a  reason: collision with root package name */
        public static a f48976a = new a();
    }

    /* loaded from: classes3.dex */
    public interface c {
        void a();

        void b(@NonNull d.a.l0.a.v1.c.c cVar);

        void c(String str);

        void d(String str);
    }

    public static a e() {
        return b.f48976a;
    }

    public static void f(String str) {
        if (f48972b) {
            Log.i("SwanAppMessenger", str);
        }
    }

    public void b(String str) {
        c cVar = this.f48973a;
        if (cVar != null) {
            cVar.d(str);
        }
    }

    public void c() {
        c cVar = this.f48973a;
        if (cVar != null) {
            cVar.a();
        }
    }

    public void d(String str) {
        c cVar = this.f48973a;
        if (cVar != null) {
            cVar.c(str);
        }
    }

    public final void g(@NonNull d.a.l0.a.v1.c.c cVar) {
        boolean isMainProcess = ProcessUtils.isMainProcess();
        if (!isMainProcess && !SwanAppProcessInfo.isInited()) {
            f("send: return by process check");
            return;
        }
        if (this.f48973a == null) {
            this.f48973a = isMainProcess ? new d() : new d.a.l0.a.v1.c.e.b();
        }
        f("send: sender=" + this.f48973a);
        this.f48973a.a();
        this.f48973a.b(cVar);
        this.f48973a.a();
    }

    public void h(@NonNull d.a.l0.a.v1.c.c cVar) {
        long i2 = cVar.i();
        int i3 = (i2 > 0L ? 1 : (i2 == 0L ? 0 : -1));
        if (i3 <= 0 && Looper.getMainLooper() == Looper.myLooper()) {
            g(cVar);
            return;
        }
        Handler i4 = d.a.l0.a.a2.d.i();
        RunnableC0934a runnableC0934a = new RunnableC0934a(cVar);
        if (i3 < 0) {
            i2 = 0;
        }
        i4.postDelayed(runnableC0934a, i2);
    }
}
