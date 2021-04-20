package d.f.b.a;

import android.os.Debug;
import android.os.SystemClock;
import android.util.Printer;
/* loaded from: classes6.dex */
public class g implements Printer {

    /* renamed from: a  reason: collision with root package name */
    public long f66862a;

    /* renamed from: b  reason: collision with root package name */
    public long f66863b = 0;

    /* renamed from: c  reason: collision with root package name */
    public long f66864c = 0;

    /* renamed from: d  reason: collision with root package name */
    public b f66865d;

    /* renamed from: e  reason: collision with root package name */
    public final boolean f66866e;

    /* loaded from: classes6.dex */
    public class a implements Runnable {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ long f66867e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ long f66868f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ long f66869g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ long f66870h;

        public a(long j, long j2, long j3, long j4) {
            this.f66867e = j;
            this.f66868f = j2;
            this.f66869g = j3;
            this.f66870h = j4;
        }

        @Override // java.lang.Runnable
        public void run() {
            g.this.f66865d.a(this.f66867e, this.f66868f, this.f66869g, this.f66870h);
        }
    }

    /* loaded from: classes6.dex */
    public interface b {
        void a(long j, long j2, long j3, long j4);
    }

    public g(b bVar, long j, boolean z) {
        this.f66862a = 3000L;
        this.f66865d = null;
        if (bVar != null) {
            this.f66865d = bVar;
            this.f66862a = j;
            this.f66866e = z;
            return;
        }
        throw new IllegalArgumentException("blockListener should not be null.");
    }

    public final boolean b(long j) {
        return j - this.f66863b > this.f66862a;
    }

    public final void c(long j) {
        e.b().post(new a(this.f66863b, j, this.f66864c, SystemClock.currentThreadTimeMillis()));
    }

    public final void d() {
        if (c.f().f66851b != null) {
            c.f().f66851b.c();
        }
        if (c.f().f66852c != null) {
            c.f().f66852c.c();
        }
    }

    public final void e() {
        if (c.f().f66851b != null) {
            c.f().f66851b.d();
        }
        if (c.f().f66852c != null) {
            c.f().f66852c.d();
        }
    }

    @Override // android.util.Printer
    public void println(String str) {
        if (this.f66866e && Debug.isDebuggerConnected()) {
            return;
        }
        if (str.charAt(0) == '>') {
            this.f66863b = System.currentTimeMillis();
            this.f66864c = SystemClock.currentThreadTimeMillis();
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
