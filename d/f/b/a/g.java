package d.f.b.a;

import android.os.Debug;
import android.os.SystemClock;
import android.util.Printer;
/* loaded from: classes6.dex */
public class g implements Printer {

    /* renamed from: a  reason: collision with root package name */
    public long f66017a;

    /* renamed from: b  reason: collision with root package name */
    public long f66018b = 0;

    /* renamed from: c  reason: collision with root package name */
    public long f66019c = 0;

    /* renamed from: d  reason: collision with root package name */
    public b f66020d;

    /* renamed from: e  reason: collision with root package name */
    public final boolean f66021e;

    /* loaded from: classes6.dex */
    public class a implements Runnable {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ long f66022e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ long f66023f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ long f66024g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ long f66025h;

        public a(long j, long j2, long j3, long j4) {
            this.f66022e = j;
            this.f66023f = j2;
            this.f66024g = j3;
            this.f66025h = j4;
        }

        @Override // java.lang.Runnable
        public void run() {
            g.this.f66020d.a(this.f66022e, this.f66023f, this.f66024g, this.f66025h);
        }
    }

    /* loaded from: classes6.dex */
    public interface b {
        void a(long j, long j2, long j3, long j4);
    }

    public g(b bVar, long j, boolean z) {
        this.f66017a = 3000L;
        this.f66020d = null;
        if (bVar != null) {
            this.f66020d = bVar;
            this.f66017a = j;
            this.f66021e = z;
            return;
        }
        throw new IllegalArgumentException("blockListener should not be null.");
    }

    public final boolean b(long j) {
        return j - this.f66018b > this.f66017a;
    }

    public final void c(long j) {
        e.b().post(new a(this.f66018b, j, this.f66019c, SystemClock.currentThreadTimeMillis()));
    }

    public final void d() {
        if (c.f().f66006b != null) {
            c.f().f66006b.c();
        }
        if (c.f().f66007c != null) {
            c.f().f66007c.c();
        }
    }

    public final void e() {
        if (c.f().f66006b != null) {
            c.f().f66006b.d();
        }
        if (c.f().f66007c != null) {
            c.f().f66007c.d();
        }
    }

    @Override // android.util.Printer
    public void println(String str) {
        if (this.f66021e && Debug.isDebuggerConnected()) {
            return;
        }
        if (str.charAt(0) == '>') {
            this.f66018b = System.currentTimeMillis();
            this.f66019c = SystemClock.currentThreadTimeMillis();
            d();
            return;
        }
        long currentTimeMillis = System.currentTimeMillis();
        if (b(currentTimeMillis)) {
            c(currentTimeMillis);
        }
        e();
    }
}
