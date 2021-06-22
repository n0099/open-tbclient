package d.f.b.a;

import android.os.Debug;
import android.os.SystemClock;
import android.util.Printer;
/* loaded from: classes6.dex */
public class g implements Printer {

    /* renamed from: a  reason: collision with root package name */
    public long f69986a;

    /* renamed from: b  reason: collision with root package name */
    public long f69987b = 0;

    /* renamed from: c  reason: collision with root package name */
    public long f69988c = 0;

    /* renamed from: d  reason: collision with root package name */
    public b f69989d;

    /* renamed from: e  reason: collision with root package name */
    public final boolean f69990e;

    /* loaded from: classes6.dex */
    public class a implements Runnable {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ long f69991e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ long f69992f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ long f69993g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ long f69994h;

        public a(long j, long j2, long j3, long j4) {
            this.f69991e = j;
            this.f69992f = j2;
            this.f69993g = j3;
            this.f69994h = j4;
        }

        @Override // java.lang.Runnable
        public void run() {
            g.this.f69989d.a(this.f69991e, this.f69992f, this.f69993g, this.f69994h);
        }
    }

    /* loaded from: classes6.dex */
    public interface b {
        void a(long j, long j2, long j3, long j4);
    }

    public g(b bVar, long j, boolean z) {
        this.f69986a = 3000L;
        this.f69989d = null;
        if (bVar != null) {
            this.f69989d = bVar;
            this.f69986a = j;
            this.f69990e = z;
            return;
        }
        throw new IllegalArgumentException("blockListener should not be null.");
    }

    public final boolean b(long j) {
        return j - this.f69987b > this.f69986a;
    }

    public final void c(long j) {
        e.b().post(new a(this.f69987b, j, this.f69988c, SystemClock.currentThreadTimeMillis()));
    }

    public final void d() {
        if (c.f().f69975b != null) {
            c.f().f69975b.c();
        }
        if (c.f().f69976c != null) {
            c.f().f69976c.c();
        }
    }

    public final void e() {
        if (c.f().f69975b != null) {
            c.f().f69975b.d();
        }
        if (c.f().f69976c != null) {
            c.f().f69976c.d();
        }
    }

    @Override // android.util.Printer
    public void println(String str) {
        if (this.f69990e && Debug.isDebuggerConnected()) {
            return;
        }
        if (str.charAt(0) == '>') {
            this.f69987b = System.currentTimeMillis();
            this.f69988c = SystemClock.currentThreadTimeMillis();
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
