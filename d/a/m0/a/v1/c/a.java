package d.a.m0.a.v1.c;

import android.os.Handler;
import android.os.Looper;
import android.util.Log;
import androidx.annotation.NonNull;
import com.baidu.searchbox.process.ipc.util.ProcessUtils;
import com.baidu.swan.apps.process.SwanAppProcessInfo;
import d.a.m0.a.k;
import d.a.m0.a.v1.c.f.d;
/* loaded from: classes3.dex */
public final class a {

    /* renamed from: b  reason: collision with root package name */
    public static final boolean f49080b = k.f46983a;

    /* renamed from: a  reason: collision with root package name */
    public c f49081a;

    /* renamed from: d.a.m0.a.v1.c.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public class RunnableC0937a implements Runnable {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ d.a.m0.a.v1.c.c f49082e;

        public RunnableC0937a(d.a.m0.a.v1.c.c cVar) {
            this.f49082e = cVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            a.this.g(this.f49082e);
        }
    }

    /* loaded from: classes3.dex */
    public static class b {

        /* renamed from: a  reason: collision with root package name */
        public static a f49084a = new a();
    }

    /* loaded from: classes3.dex */
    public interface c {
        void a();

        void b(@NonNull d.a.m0.a.v1.c.c cVar);

        void c(String str);

        void d(String str);
    }

    public static a e() {
        return b.f49084a;
    }

    public static void f(String str) {
        if (f49080b) {
            Log.i("SwanAppMessenger", str);
        }
    }

    public void b(String str) {
        c cVar = this.f49081a;
        if (cVar != null) {
            cVar.d(str);
        }
    }

    public void c() {
        c cVar = this.f49081a;
        if (cVar != null) {
            cVar.a();
        }
    }

    public void d(String str) {
        c cVar = this.f49081a;
        if (cVar != null) {
            cVar.c(str);
        }
    }

    public final void g(@NonNull d.a.m0.a.v1.c.c cVar) {
        boolean isMainProcess = ProcessUtils.isMainProcess();
        if (!isMainProcess && !SwanAppProcessInfo.isInited()) {
            f("send: return by process check");
            return;
        }
        if (this.f49081a == null) {
            this.f49081a = isMainProcess ? new d() : new d.a.m0.a.v1.c.e.b();
        }
        f("send: sender=" + this.f49081a);
        this.f49081a.a();
        this.f49081a.b(cVar);
        this.f49081a.a();
    }

    public void h(@NonNull d.a.m0.a.v1.c.c cVar) {
        long i2 = cVar.i();
        int i3 = (i2 > 0L ? 1 : (i2 == 0L ? 0 : -1));
        if (i3 <= 0 && Looper.getMainLooper() == Looper.myLooper()) {
            g(cVar);
            return;
        }
        Handler i4 = d.a.m0.a.a2.d.i();
        RunnableC0937a runnableC0937a = new RunnableC0937a(cVar);
        if (i3 < 0) {
            i2 = 0;
        }
        i4.postDelayed(runnableC0937a, i2);
    }
}
