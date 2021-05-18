package d.a.i0.a.u.f;

import android.util.Log;
import com.baidu.swan.apps.api.pending.queue.operation.BasePendingOperation;
import d.a.i0.a.k;
import d.a.i0.a.v2.q;
import java.util.concurrent.TimeUnit;
/* loaded from: classes2.dex */
public class a {

    /* renamed from: d  reason: collision with root package name */
    public static final boolean f45036d = k.f43025a;

    /* renamed from: a  reason: collision with root package name */
    public d.a.i0.a.u.f.b.g.b f45037a;

    /* renamed from: b  reason: collision with root package name */
    public boolean f45038b;

    /* renamed from: c  reason: collision with root package name */
    public h.k f45039c;

    /* renamed from: d.a.i0.a.u.f.a$a  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public class RunnableC0859a implements Runnable {
        public RunnableC0859a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            if (a.f45036d) {
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
            if (a.f45036d) {
                Log.d("PendingOperationManager", "=============== FCP end, begin loop pending operation ==============");
            }
            a.this.j();
        }
    }

    /* loaded from: classes2.dex */
    public static class c {

        /* renamed from: a  reason: collision with root package name */
        public static final a f45042a = new a(null);
    }

    public /* synthetic */ a(RunnableC0859a runnableC0859a) {
        this();
    }

    public static a d() {
        return c.f45042a;
    }

    public void c(BasePendingOperation basePendingOperation) {
        if (basePendingOperation == null) {
            if (f45036d) {
                throw new IllegalStateException("The operation can't be null!");
            }
        } else if (!e() && basePendingOperation.a()) {
            this.f45037a.a(basePendingOperation);
        } else {
            if (f45036d) {
                Log.d("PendingOperationManager", "=============== Execute module:" + e() + " " + basePendingOperation.b() + " params:" + basePendingOperation.c());
            }
            basePendingOperation.run();
        }
    }

    public final boolean e() {
        return this.f45038b;
    }

    public void f() {
        if (f45036d) {
            Log.d("PendingOperationManager", String.format("=============== FCP end, delay  %d ms to loop ==============", 6000));
        }
        this.f45039c = q.c(new b(), "pending_operation", 6000L, TimeUnit.MILLISECONDS);
    }

    public void g() {
        if (this.f45039c != null) {
            if (f45036d) {
                Log.d("PendingOperationManager", "=============== FMP end, cancel fcp loop operation ==============");
            }
            this.f45039c.unsubscribe();
            this.f45039c = null;
        }
        if (e()) {
            return;
        }
        q.i(new RunnableC0859a(), "pending_operation");
    }

    public void h() {
        if (f45036d) {
            Log.d("PendingOperationManager", "=============== release PendingQueue & reset fmp flag ==============");
        }
        i();
        this.f45037a.b();
    }

    public void i() {
        this.f45038b = false;
    }

    public final void j() {
        this.f45038b = true;
        this.f45037a.d();
    }

    public a() {
        this.f45038b = false;
        this.f45037a = new d.a.i0.a.u.f.b.g.b();
    }
}
