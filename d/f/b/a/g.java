package d.f.b.a;

import android.os.Debug;
import android.os.SystemClock;
import android.util.Printer;
/* loaded from: classes6.dex */
public class g implements Printer {

    /* renamed from: a  reason: collision with root package name */
    public long f66016a;

    /* renamed from: b  reason: collision with root package name */
    public long f66017b = 0;

    /* renamed from: c  reason: collision with root package name */
    public long f66018c = 0;

    /* renamed from: d  reason: collision with root package name */
    public b f66019d;

    /* renamed from: e  reason: collision with root package name */
    public final boolean f66020e;

    /* loaded from: classes6.dex */
    public class a implements Runnable {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ long f66021e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ long f66022f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ long f66023g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ long f66024h;

        public a(long j, long j2, long j3, long j4) {
            this.f66021e = j;
            this.f66022f = j2;
            this.f66023g = j3;
            this.f66024h = j4;
        }

        @Override // java.lang.Runnable
        public void run() {
            g.this.f66019d.a(this.f66021e, this.f66022f, this.f66023g, this.f66024h);
        }
    }

    /* loaded from: classes6.dex */
    public interface b {
        void a(long j, long j2, long j3, long j4);
    }

    public g(b bVar, long j, boolean z) {
        this.f66016a = 3000L;
        this.f66019d = null;
        if (bVar != null) {
            this.f66019d = bVar;
            this.f66016a = j;
            this.f66020e = z;
            return;
        }
        throw new IllegalArgumentException("blockListener should not be null.");
    }

    public final boolean b(long j) {
        return j - this.f66017b > this.f66016a;
    }

    public final void c(long j) {
        e.b().post(new a(this.f66017b, j, this.f66018c, SystemClock.currentThreadTimeMillis()));
    }

    public final void d() {
        if (c.f().f66005b != null) {
            c.f().f66005b.c();
        }
        if (c.f().f66006c != null) {
            c.f().f66006c.c();
        }
    }

    public final void e() {
        if (c.f().f66005b != null) {
            c.f().f66005b.d();
        }
        if (c.f().f66006c != null) {
            c.f().f66006c.d();
        }
    }

    @Override // android.util.Printer
    public void println(String str) {
        if (this.f66020e && Debug.isDebuggerConnected()) {
            return;
        }
        if (str.charAt(0) == '>') {
            this.f66017b = System.currentTimeMillis();
            this.f66018c = SystemClock.currentThreadTimeMillis();
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
