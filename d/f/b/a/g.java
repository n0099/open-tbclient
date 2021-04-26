package d.f.b.a;

import android.os.Debug;
import android.os.SystemClock;
import android.util.Printer;
/* loaded from: classes6.dex */
public class g implements Printer {

    /* renamed from: a  reason: collision with root package name */
    public long f65422a;

    /* renamed from: b  reason: collision with root package name */
    public long f65423b = 0;

    /* renamed from: c  reason: collision with root package name */
    public long f65424c = 0;

    /* renamed from: d  reason: collision with root package name */
    public b f65425d;

    /* renamed from: e  reason: collision with root package name */
    public final boolean f65426e;

    /* loaded from: classes6.dex */
    public class a implements Runnable {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ long f65427e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ long f65428f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ long f65429g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ long f65430h;

        public a(long j, long j2, long j3, long j4) {
            this.f65427e = j;
            this.f65428f = j2;
            this.f65429g = j3;
            this.f65430h = j4;
        }

        @Override // java.lang.Runnable
        public void run() {
            g.this.f65425d.a(this.f65427e, this.f65428f, this.f65429g, this.f65430h);
        }
    }

    /* loaded from: classes6.dex */
    public interface b {
        void a(long j, long j2, long j3, long j4);
    }

    public g(b bVar, long j, boolean z) {
        this.f65422a = 3000L;
        this.f65425d = null;
        if (bVar != null) {
            this.f65425d = bVar;
            this.f65422a = j;
            this.f65426e = z;
            return;
        }
        throw new IllegalArgumentException("blockListener should not be null.");
    }

    public final boolean b(long j) {
        return j - this.f65423b > this.f65422a;
    }

    public final void c(long j) {
        e.b().post(new a(this.f65423b, j, this.f65424c, SystemClock.currentThreadTimeMillis()));
    }

    public final void d() {
        if (c.f().f65411b != null) {
            c.f().f65411b.c();
        }
        if (c.f().f65412c != null) {
            c.f().f65412c.c();
        }
    }

    public final void e() {
        if (c.f().f65411b != null) {
            c.f().f65411b.d();
        }
        if (c.f().f65412c != null) {
            c.f().f65412c.d();
        }
    }

    @Override // android.util.Printer
    public void println(String str) {
        if (this.f65426e && Debug.isDebuggerConnected()) {
            return;
        }
        if (str.charAt(0) == '>') {
            this.f65423b = System.currentTimeMillis();
            this.f65424c = SystemClock.currentThreadTimeMillis();
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
