package d.g.b.a;

import android.os.Debug;
import android.os.SystemClock;
import android.util.Printer;
/* loaded from: classes6.dex */
public class g implements Printer {

    /* renamed from: a  reason: collision with root package name */
    public long f67009a;

    /* renamed from: b  reason: collision with root package name */
    public long f67010b = 0;

    /* renamed from: c  reason: collision with root package name */
    public long f67011c = 0;

    /* renamed from: d  reason: collision with root package name */
    public b f67012d;

    /* renamed from: e  reason: collision with root package name */
    public final boolean f67013e;

    /* loaded from: classes6.dex */
    public class a implements Runnable {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ long f67014e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ long f67015f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ long f67016g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ long f67017h;

        public a(long j, long j2, long j3, long j4) {
            this.f67014e = j;
            this.f67015f = j2;
            this.f67016g = j3;
            this.f67017h = j4;
        }

        @Override // java.lang.Runnable
        public void run() {
            g.this.f67012d.a(this.f67014e, this.f67015f, this.f67016g, this.f67017h);
        }
    }

    /* loaded from: classes6.dex */
    public interface b {
        void a(long j, long j2, long j3, long j4);
    }

    public g(b bVar, long j, boolean z) {
        this.f67009a = 3000L;
        this.f67012d = null;
        if (bVar != null) {
            this.f67012d = bVar;
            this.f67009a = j;
            this.f67013e = z;
            return;
        }
        throw new IllegalArgumentException("blockListener should not be null.");
    }

    public final boolean b(long j) {
        return j - this.f67010b > this.f67009a;
    }

    public final void c(long j) {
        e.b().post(new a(this.f67010b, j, this.f67011c, SystemClock.currentThreadTimeMillis()));
    }

    public final void d() {
        if (c.f().f66998b != null) {
            c.f().f66998b.c();
        }
        if (c.f().f66999c != null) {
            c.f().f66999c.c();
        }
    }

    public final void e() {
        if (c.f().f66998b != null) {
            c.f().f66998b.d();
        }
        if (c.f().f66999c != null) {
            c.f().f66999c.d();
        }
    }

    @Override // android.util.Printer
    public void println(String str) {
        if (this.f67013e && Debug.isDebuggerConnected()) {
            return;
        }
        if (str.charAt(0) == '>') {
            this.f67010b = System.currentTimeMillis();
            this.f67011c = SystemClock.currentThreadTimeMillis();
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
