package d.a.l0.a.u.f;

import android.util.Log;
import com.baidu.swan.apps.api.pending.queue.operation.BasePendingOperation;
import d.a.l0.a.k;
import d.a.l0.a.v2.q;
import java.util.concurrent.TimeUnit;
/* loaded from: classes2.dex */
public class a {

    /* renamed from: d  reason: collision with root package name */
    public static final boolean f48886d = k.f46875a;

    /* renamed from: a  reason: collision with root package name */
    public d.a.l0.a.u.f.b.g.b f48887a;

    /* renamed from: b  reason: collision with root package name */
    public boolean f48888b;

    /* renamed from: c  reason: collision with root package name */
    public h.k f48889c;

    /* renamed from: d.a.l0.a.u.f.a$a  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public class RunnableC0926a implements Runnable {
        public RunnableC0926a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            if (a.f48886d) {
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
            if (a.f48886d) {
                Log.d("PendingOperationManager", "=============== FCP end, begin loop pending operation ==============");
            }
            a.this.j();
        }
    }

    /* loaded from: classes2.dex */
    public static class c {

        /* renamed from: a  reason: collision with root package name */
        public static final a f48892a = new a(null);
    }

    public /* synthetic */ a(RunnableC0926a runnableC0926a) {
        this();
    }

    public static a d() {
        return c.f48892a;
    }

    public void c(BasePendingOperation basePendingOperation) {
        if (basePendingOperation == null) {
            if (f48886d) {
                throw new IllegalStateException("The operation can't be null!");
            }
        } else if (!e() && basePendingOperation.a()) {
            this.f48887a.a(basePendingOperation);
        } else {
            if (f48886d) {
                Log.d("PendingOperationManager", "=============== Execute module:" + e() + " " + basePendingOperation.b() + " params:" + basePendingOperation.c());
            }
            basePendingOperation.run();
        }
    }

    public final boolean e() {
        return this.f48888b;
    }

    public void f() {
        if (f48886d) {
            Log.d("PendingOperationManager", String.format("=============== FCP end, delay  %d ms to loop ==============", 6000));
        }
        this.f48889c = q.c(new b(), "pending_operation", 6000L, TimeUnit.MILLISECONDS);
    }

    public void g() {
        if (this.f48889c != null) {
            if (f48886d) {
                Log.d("PendingOperationManager", "=============== FMP end, cancel fcp loop operation ==============");
            }
            this.f48889c.unsubscribe();
            this.f48889c = null;
        }
        if (e()) {
            return;
        }
        q.i(new RunnableC0926a(), "pending_operation");
    }

    public void h() {
        if (f48886d) {
            Log.d("PendingOperationManager", "=============== release PendingQueue & reset fmp flag ==============");
        }
        i();
        this.f48887a.b();
    }

    public void i() {
        this.f48888b = false;
    }

    public final void j() {
        this.f48888b = true;
        this.f48887a.d();
    }

    public a() {
        this.f48888b = false;
        this.f48887a = new d.a.l0.a.u.f.b.g.b();
    }
}
