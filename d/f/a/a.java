package d.f.a;

import android.os.Debug;
import android.os.Handler;
import android.os.Looper;
import android.util.Log;
import com.github.anrwatchdog.ANRError;
/* loaded from: classes6.dex */
public class a extends Thread {
    public static final f p = new C1806a();
    public static final e q = new b();
    public static final g r = new c();
    public final int i;

    /* renamed from: e  reason: collision with root package name */
    public f f65994e = p;

    /* renamed from: f  reason: collision with root package name */
    public e f65995f = q;

    /* renamed from: g  reason: collision with root package name */
    public g f65996g = r;

    /* renamed from: h  reason: collision with root package name */
    public final Handler f65997h = new Handler(Looper.getMainLooper());
    public String j = "";
    public boolean k = false;
    public boolean l = true;
    public volatile long m = 0;
    public volatile boolean n = false;
    public final Runnable o = new d();

    /* renamed from: d.f.a.a$a  reason: collision with other inner class name */
    /* loaded from: classes6.dex */
    public static class C1806a implements f {
        @Override // d.f.a.a.f
        public void onAppNotResponding(ANRError aNRError) {
            throw aNRError;
        }
    }

    /* loaded from: classes6.dex */
    public static class b implements e {
        @Override // d.f.a.a.e
        public long a(long j) {
            return 0L;
        }
    }

    /* loaded from: classes6.dex */
    public static class c implements g {
        @Override // d.f.a.a.g
        public void a(InterruptedException interruptedException) {
            Log.w("ANRWatchdog", "Interrupted: " + interruptedException.getMessage());
        }
    }

    /* loaded from: classes6.dex */
    public class d implements Runnable {
        public d() {
        }

        @Override // java.lang.Runnable
        public void run() {
            a.this.m = 0L;
            a.this.n = false;
        }
    }

    /* loaded from: classes6.dex */
    public interface e {
        long a(long j);
    }

    /* loaded from: classes6.dex */
    public interface f {
        void onAppNotResponding(ANRError aNRError);
    }

    /* loaded from: classes6.dex */
    public interface g {
        void a(InterruptedException interruptedException);
    }

    public a(int i) {
        this.i = i;
    }

    public a c(f fVar) {
        if (fVar == null) {
            this.f65994e = p;
        } else {
            this.f65994e = fVar;
        }
        return this;
    }

    public a d() {
        this.j = null;
        return this;
    }

    @Override // java.lang.Thread, java.lang.Runnable
    public void run() {
        ANRError NewMainOnly;
        setName("|ANR-WatchDog|");
        long j = this.i;
        while (!isInterrupted()) {
            boolean z = this.m == 0;
            this.m += j;
            if (z) {
                this.f65997h.post(this.o);
            }
            try {
                Thread.sleep(j);
                if (this.m != 0 && !this.n) {
                    if (!this.l && (Debug.isDebuggerConnected() || Debug.waitingForDebugger())) {
                        Log.w("ANRWatchdog", "An ANR was detected but ignored because the debugger is connected (you can prevent this with setIgnoreDebugger(true))");
                        this.n = true;
                    } else {
                        j = this.f65995f.a(this.m);
                        if (j <= 0) {
                            if (this.j != null) {
                                NewMainOnly = ANRError.New(this.m, this.j, this.k);
                            } else {
                                NewMainOnly = ANRError.NewMainOnly(this.m);
                            }
                            this.f65994e.onAppNotResponding(NewMainOnly);
                            j = this.i;
                            this.n = true;
                        }
                    }
                }
            } catch (InterruptedException e2) {
                this.f65996g.a(e2);
                return;
            }
        }
    }
}
