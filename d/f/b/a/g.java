package d.f.b.a;

import android.os.Debug;
import android.os.SystemClock;
import android.util.Printer;
/* loaded from: classes6.dex */
public class g implements Printer {

    /* renamed from: a  reason: collision with root package name */
    public long f66151a;

    /* renamed from: b  reason: collision with root package name */
    public long f66152b = 0;

    /* renamed from: c  reason: collision with root package name */
    public long f66153c = 0;

    /* renamed from: d  reason: collision with root package name */
    public b f66154d;

    /* renamed from: e  reason: collision with root package name */
    public final boolean f66155e;

    /* loaded from: classes6.dex */
    public class a implements Runnable {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ long f66156e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ long f66157f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ long f66158g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ long f66159h;

        public a(long j, long j2, long j3, long j4) {
            this.f66156e = j;
            this.f66157f = j2;
            this.f66158g = j3;
            this.f66159h = j4;
        }

        @Override // java.lang.Runnable
        public void run() {
            g.this.f66154d.a(this.f66156e, this.f66157f, this.f66158g, this.f66159h);
        }
    }

    /* loaded from: classes6.dex */
    public interface b {
        void a(long j, long j2, long j3, long j4);
    }

    public g(b bVar, long j, boolean z) {
        this.f66151a = 3000L;
        this.f66154d = null;
        if (bVar != null) {
            this.f66154d = bVar;
            this.f66151a = j;
            this.f66155e = z;
            return;
        }
        throw new IllegalArgumentException("blockListener should not be null.");
    }

    public final boolean b(long j) {
        return j - this.f66152b > this.f66151a;
    }

    public final void c(long j) {
        e.b().post(new a(this.f66152b, j, this.f66153c, SystemClock.currentThreadTimeMillis()));
    }

    public final void d() {
        if (c.f().f66140b != null) {
            c.f().f66140b.c();
        }
        if (c.f().f66141c != null) {
            c.f().f66141c.c();
        }
    }

    public final void e() {
        if (c.f().f66140b != null) {
            c.f().f66140b.d();
        }
        if (c.f().f66141c != null) {
            c.f().f66141c.d();
        }
    }

    @Override // android.util.Printer
    public void println(String str) {
        if (this.f66155e && Debug.isDebuggerConnected()) {
            return;
        }
        if (str.charAt(0) == '>') {
            this.f66152b = System.currentTimeMillis();
            this.f66153c = SystemClock.currentThreadTimeMillis();
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
