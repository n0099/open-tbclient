package d.f.b.a;

import android.os.Debug;
import android.os.SystemClock;
import android.util.Printer;
/* loaded from: classes6.dex */
public class g implements Printer {

    /* renamed from: a  reason: collision with root package name */
    public long f69882a;

    /* renamed from: b  reason: collision with root package name */
    public long f69883b = 0;

    /* renamed from: c  reason: collision with root package name */
    public long f69884c = 0;

    /* renamed from: d  reason: collision with root package name */
    public b f69885d;

    /* renamed from: e  reason: collision with root package name */
    public final boolean f69886e;

    /* loaded from: classes6.dex */
    public class a implements Runnable {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ long f69887e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ long f69888f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ long f69889g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ long f69890h;

        public a(long j, long j2, long j3, long j4) {
            this.f69887e = j;
            this.f69888f = j2;
            this.f69889g = j3;
            this.f69890h = j4;
        }

        @Override // java.lang.Runnable
        public void run() {
            g.this.f69885d.a(this.f69887e, this.f69888f, this.f69889g, this.f69890h);
        }
    }

    /* loaded from: classes6.dex */
    public interface b {
        void a(long j, long j2, long j3, long j4);
    }

    public g(b bVar, long j, boolean z) {
        this.f69882a = 3000L;
        this.f69885d = null;
        if (bVar != null) {
            this.f69885d = bVar;
            this.f69882a = j;
            this.f69886e = z;
            return;
        }
        throw new IllegalArgumentException("blockListener should not be null.");
    }

    public final boolean b(long j) {
        return j - this.f69883b > this.f69882a;
    }

    public final void c(long j) {
        e.b().post(new a(this.f69883b, j, this.f69884c, SystemClock.currentThreadTimeMillis()));
    }

    public final void d() {
        if (c.f().f69871b != null) {
            c.f().f69871b.c();
        }
        if (c.f().f69872c != null) {
            c.f().f69872c.c();
        }
    }

    public final void e() {
        if (c.f().f69871b != null) {
            c.f().f69871b.d();
        }
        if (c.f().f69872c != null) {
            c.f().f69872c.d();
        }
    }

    @Override // android.util.Printer
    public void println(String str) {
        if (this.f69886e && Debug.isDebuggerConnected()) {
            return;
        }
        if (str.charAt(0) == '>') {
            this.f69883b = System.currentTimeMillis();
            this.f69884c = SystemClock.currentThreadTimeMillis();
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
