package d.f.b.a;

import android.os.Debug;
import android.os.SystemClock;
import android.util.Printer;
/* loaded from: classes6.dex */
public class g implements Printer {

    /* renamed from: a  reason: collision with root package name */
    public long f66108a;

    /* renamed from: b  reason: collision with root package name */
    public long f66109b = 0;

    /* renamed from: c  reason: collision with root package name */
    public long f66110c = 0;

    /* renamed from: d  reason: collision with root package name */
    public b f66111d;

    /* renamed from: e  reason: collision with root package name */
    public final boolean f66112e;

    /* loaded from: classes6.dex */
    public class a implements Runnable {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ long f66113e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ long f66114f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ long f66115g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ long f66116h;

        public a(long j, long j2, long j3, long j4) {
            this.f66113e = j;
            this.f66114f = j2;
            this.f66115g = j3;
            this.f66116h = j4;
        }

        @Override // java.lang.Runnable
        public void run() {
            g.this.f66111d.a(this.f66113e, this.f66114f, this.f66115g, this.f66116h);
        }
    }

    /* loaded from: classes6.dex */
    public interface b {
        void a(long j, long j2, long j3, long j4);
    }

    public g(b bVar, long j, boolean z) {
        this.f66108a = 3000L;
        this.f66111d = null;
        if (bVar != null) {
            this.f66111d = bVar;
            this.f66108a = j;
            this.f66112e = z;
            return;
        }
        throw new IllegalArgumentException("blockListener should not be null.");
    }

    public final boolean b(long j) {
        return j - this.f66109b > this.f66108a;
    }

    public final void c(long j) {
        e.b().post(new a(this.f66109b, j, this.f66110c, SystemClock.currentThreadTimeMillis()));
    }

    public final void d() {
        if (c.f().f66097b != null) {
            c.f().f66097b.c();
        }
        if (c.f().f66098c != null) {
            c.f().f66098c.c();
        }
    }

    public final void e() {
        if (c.f().f66097b != null) {
            c.f().f66097b.d();
        }
        if (c.f().f66098c != null) {
            c.f().f66098c.d();
        }
    }

    @Override // android.util.Printer
    public void println(String str) {
        if (this.f66112e && Debug.isDebuggerConnected()) {
            return;
        }
        if (str.charAt(0) == '>') {
            this.f66109b = System.currentTimeMillis();
            this.f66110c = SystemClock.currentThreadTimeMillis();
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
