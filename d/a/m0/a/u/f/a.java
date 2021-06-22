package d.a.m0.a.u.f;

import android.util.Log;
import com.baidu.swan.apps.api.pending.queue.operation.BasePendingOperation;
import d.a.m0.a.k;
import d.a.m0.a.v2.q;
import java.util.concurrent.TimeUnit;
/* loaded from: classes2.dex */
public class a {

    /* renamed from: d  reason: collision with root package name */
    public static final boolean f48994d = k.f46983a;

    /* renamed from: a  reason: collision with root package name */
    public d.a.m0.a.u.f.b.g.b f48995a;

    /* renamed from: b  reason: collision with root package name */
    public boolean f48996b;

    /* renamed from: c  reason: collision with root package name */
    public h.k f48997c;

    /* renamed from: d.a.m0.a.u.f.a$a  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public class RunnableC0929a implements Runnable {
        public RunnableC0929a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            if (a.f48994d) {
                Log.d("PendingOperationManager", "=============== FMP end, begin loop pending operation ==============");
            }
            a.this.j();
        }
    }

    /* loaded from: classes2.dex */
    public class b implements Runnable {
        public b() {
        }

        @Override // java.lang.Runnable
        public void run() {
            if (a.f48994d) {
                Log.d("PendingOperationManager", "=============== FCP end, begin loop pending operation ==============");
            }
            a.this.j();
        }
    }

    /* loaded from: classes2.dex */
    public static class c {

        /* renamed from: a  reason: collision with root package name */
        public static final a f49000a = new a(null);
    }

    public /* synthetic */ a(RunnableC0929a runnableC0929a) {
        this();
    }

    public static a d() {
        return c.f49000a;
    }

    public void c(BasePendingOperation basePendingOperation) {
        if (basePendingOperation == null) {
            if (f48994d) {
                throw new IllegalStateException("The operation can't be null!");
            }
        } else if (!e() && basePendingOperation.a()) {
            this.f48995a.a(basePendingOperation);
        } else {
            if (f48994d) {
                Log.d("PendingOperationManager", "=============== Execute module:" + e() + " " + basePendingOperation.b() + " params:" + basePendingOperation.c());
            }
            basePendingOperation.run();
        }
    }

    public final boolean e() {
        return this.f48996b;
    }

    public void f() {
        if (f48994d) {
            Log.d("PendingOperationManager", String.format("=============== FCP end, delay  %d ms to loop ==============", 6000));
        }
        this.f48997c = q.c(new b(), "pending_operation", 6000L, TimeUnit.MILLISECONDS);
    }

    public void g() {
        if (this.f48997c != null) {
            if (f48994d) {
                Log.d("PendingOperationManager", "=============== FMP end, cancel fcp loop operation ==============");
            }
            this.f48997c.unsubscribe();
            this.f48997c = null;
        }
        if (e()) {
            return;
        }
        q.i(new RunnableC0929a(), "pending_operation");
    }

    public void h() {
        if (f48994d) {
            Log.d("PendingOperationManager", "=============== release PendingQueue & reset fmp flag ==============");
        }
        i();
        this.f48995a.b();
    }

    public void i() {
        this.f48996b = false;
    }

    public final void j() {
        this.f48996b = true;
        this.f48995a.d();
    }

    public a() {
        this.f48996b = false;
        this.f48995a = new d.a.m0.a.u.f.b.g.b();
    }
}
