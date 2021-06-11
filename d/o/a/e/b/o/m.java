package d.o.a.e.b.o;

import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicReference;
/* loaded from: classes7.dex */
public class m {

    /* renamed from: a  reason: collision with root package name */
    public final f f71288a;

    /* renamed from: b  reason: collision with root package name */
    public volatile boolean f71289b;

    /* renamed from: c  reason: collision with root package name */
    public final AtomicReference<com.ss.android.socialbase.downloader.network.l> f71290c;

    /* renamed from: d  reason: collision with root package name */
    public AtomicReference<com.ss.android.socialbase.downloader.network.l> f71291d;

    /* renamed from: e  reason: collision with root package name */
    public final ArrayList<c> f71292e;

    /* renamed from: f  reason: collision with root package name */
    public int f71293f;

    /* loaded from: classes7.dex */
    public static /* synthetic */ class a {

        /* renamed from: a  reason: collision with root package name */
        public static final /* synthetic */ int[] f71294a;

        static {
            int[] iArr = new int[com.ss.android.socialbase.downloader.network.l.values().length];
            f71294a = iArr;
            try {
                iArr[com.ss.android.socialbase.downloader.network.l.POOR.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f71294a[com.ss.android.socialbase.downloader.network.l.MODERATE.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f71294a[com.ss.android.socialbase.downloader.network.l.GOOD.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f71294a[com.ss.android.socialbase.downloader.network.l.EXCELLENT.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
        }
    }

    /* loaded from: classes7.dex */
    public static class b {

        /* renamed from: a  reason: collision with root package name */
        public static final m f71295a = new m(null);
    }

    /* loaded from: classes7.dex */
    public interface c {
        void a(com.ss.android.socialbase.downloader.network.l lVar);
    }

    public /* synthetic */ m(a aVar) {
        this();
    }

    public static m a() {
        return b.f71295a;
    }

    public final com.ss.android.socialbase.downloader.network.l b(double d2) {
        if (d2 < 0.0d) {
            return com.ss.android.socialbase.downloader.network.l.UNKNOWN;
        }
        if (d2 < 150.0d) {
            return com.ss.android.socialbase.downloader.network.l.POOR;
        }
        if (d2 < 550.0d) {
            return com.ss.android.socialbase.downloader.network.l.MODERATE;
        }
        if (d2 < 2000.0d) {
            return com.ss.android.socialbase.downloader.network.l.GOOD;
        }
        return com.ss.android.socialbase.downloader.network.l.EXCELLENT;
    }

    public synchronized void c(long j, long j2) {
        com.ss.android.socialbase.downloader.network.l d2;
        double d3 = ((j * 1.0d) / j2) * 8.0d;
        if (j2 == 0 || d3 < 3.0d) {
            return;
        }
        try {
            this.f71288a.b(d3);
            d2 = d();
        } catch (Throwable unused) {
        }
        if (this.f71289b) {
            this.f71293f++;
            if (d2 != this.f71291d.get()) {
                this.f71289b = false;
                this.f71293f = 1;
            }
            if (this.f71293f >= 5.0d && e()) {
                this.f71289b = false;
                this.f71293f = 1;
                this.f71290c.set(this.f71291d.get());
                f();
            }
            return;
        }
        if (this.f71290c.get() != d2) {
            this.f71289b = true;
            this.f71291d = new AtomicReference<>(d2);
        }
    }

    public synchronized com.ss.android.socialbase.downloader.network.l d() {
        if (this.f71288a == null) {
            return com.ss.android.socialbase.downloader.network.l.UNKNOWN;
        }
        return b(this.f71288a.a());
    }

    public final boolean e() {
        if (this.f71288a == null) {
            return false;
        }
        try {
            int i2 = a.f71294a[this.f71290c.get().ordinal()];
            double d2 = 2000.0d;
            double d3 = 550.0d;
            if (i2 == 1) {
                d3 = 0.0d;
                d2 = 150.0d;
            } else if (i2 == 2) {
                d2 = 550.0d;
                d3 = 150.0d;
            } else if (i2 != 3) {
                if (i2 != 4) {
                    return true;
                }
                d2 = 3.4028234663852886E38d;
                d3 = 2000.0d;
            }
            double a2 = this.f71288a.a();
            if (a2 > d2) {
                if (a2 > d2 * 1.25d) {
                    return true;
                }
            } else if (a2 < d3 * 0.8d) {
                return true;
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
        return false;
    }

    public final void f() {
        try {
            int size = this.f71292e.size();
            for (int i2 = 0; i2 < size; i2++) {
                this.f71292e.get(i2).a(this.f71290c.get());
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public m() {
        this.f71288a = new f(0.05d);
        this.f71289b = false;
        this.f71290c = new AtomicReference<>(com.ss.android.socialbase.downloader.network.l.UNKNOWN);
        this.f71292e = new ArrayList<>();
    }
}
