package d.o.a.e.b.o;

import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicReference;
/* loaded from: classes6.dex */
public class m {

    /* renamed from: a  reason: collision with root package name */
    public final f f66773a;

    /* renamed from: b  reason: collision with root package name */
    public volatile boolean f66774b;

    /* renamed from: c  reason: collision with root package name */
    public final AtomicReference<com.ss.android.socialbase.downloader.network.l> f66775c;

    /* renamed from: d  reason: collision with root package name */
    public AtomicReference<com.ss.android.socialbase.downloader.network.l> f66776d;

    /* renamed from: e  reason: collision with root package name */
    public final ArrayList<c> f66777e;

    /* renamed from: f  reason: collision with root package name */
    public int f66778f;

    /* loaded from: classes6.dex */
    public static /* synthetic */ class a {

        /* renamed from: a  reason: collision with root package name */
        public static final /* synthetic */ int[] f66779a;

        static {
            int[] iArr = new int[com.ss.android.socialbase.downloader.network.l.values().length];
            f66779a = iArr;
            try {
                iArr[com.ss.android.socialbase.downloader.network.l.POOR.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f66779a[com.ss.android.socialbase.downloader.network.l.MODERATE.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f66779a[com.ss.android.socialbase.downloader.network.l.GOOD.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f66779a[com.ss.android.socialbase.downloader.network.l.EXCELLENT.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
        }
    }

    /* loaded from: classes6.dex */
    public static class b {

        /* renamed from: a  reason: collision with root package name */
        public static final m f66780a = new m(null);
    }

    /* loaded from: classes6.dex */
    public interface c {
        void a(com.ss.android.socialbase.downloader.network.l lVar);
    }

    public /* synthetic */ m(a aVar) {
        this();
    }

    public static m a() {
        return b.f66780a;
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
            this.f66773a.b(d3);
            d2 = d();
        } catch (Throwable unused) {
        }
        if (this.f66774b) {
            this.f66778f++;
            if (d2 != this.f66776d.get()) {
                this.f66774b = false;
                this.f66778f = 1;
            }
            if (this.f66778f >= 5.0d && e()) {
                this.f66774b = false;
                this.f66778f = 1;
                this.f66775c.set(this.f66776d.get());
                f();
            }
            return;
        }
        if (this.f66775c.get() != d2) {
            this.f66774b = true;
            this.f66776d = new AtomicReference<>(d2);
        }
    }

    public synchronized com.ss.android.socialbase.downloader.network.l d() {
        if (this.f66773a == null) {
            return com.ss.android.socialbase.downloader.network.l.UNKNOWN;
        }
        return b(this.f66773a.a());
    }

    public final boolean e() {
        if (this.f66773a == null) {
            return false;
        }
        try {
            int i2 = a.f66779a[this.f66775c.get().ordinal()];
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
            double a2 = this.f66773a.a();
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
            int size = this.f66777e.size();
            for (int i2 = 0; i2 < size; i2++) {
                this.f66777e.get(i2).a(this.f66775c.get());
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public m() {
        this.f66773a = new f(0.05d);
        this.f66774b = false;
        this.f66775c = new AtomicReference<>(com.ss.android.socialbase.downloader.network.l.UNKNOWN);
        this.f66777e = new ArrayList<>();
    }
}
