package d.o.a.e.b.o;

import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicReference;
/* loaded from: classes7.dex */
public class m {

    /* renamed from: a  reason: collision with root package name */
    public final f f67502a;

    /* renamed from: b  reason: collision with root package name */
    public volatile boolean f67503b;

    /* renamed from: c  reason: collision with root package name */
    public final AtomicReference<com.ss.android.socialbase.downloader.network.l> f67504c;

    /* renamed from: d  reason: collision with root package name */
    public AtomicReference<com.ss.android.socialbase.downloader.network.l> f67505d;

    /* renamed from: e  reason: collision with root package name */
    public final ArrayList<c> f67506e;

    /* renamed from: f  reason: collision with root package name */
    public int f67507f;

    /* loaded from: classes7.dex */
    public static /* synthetic */ class a {

        /* renamed from: a  reason: collision with root package name */
        public static final /* synthetic */ int[] f67508a;

        static {
            int[] iArr = new int[com.ss.android.socialbase.downloader.network.l.values().length];
            f67508a = iArr;
            try {
                iArr[com.ss.android.socialbase.downloader.network.l.POOR.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f67508a[com.ss.android.socialbase.downloader.network.l.MODERATE.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f67508a[com.ss.android.socialbase.downloader.network.l.GOOD.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f67508a[com.ss.android.socialbase.downloader.network.l.EXCELLENT.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
        }
    }

    /* loaded from: classes7.dex */
    public static class b {

        /* renamed from: a  reason: collision with root package name */
        public static final m f67509a = new m(null);
    }

    /* loaded from: classes7.dex */
    public interface c {
        void a(com.ss.android.socialbase.downloader.network.l lVar);
    }

    public /* synthetic */ m(a aVar) {
        this();
    }

    public static m a() {
        return b.f67509a;
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
            this.f67502a.b(d3);
            d2 = d();
        } catch (Throwable unused) {
        }
        if (this.f67503b) {
            this.f67507f++;
            if (d2 != this.f67505d.get()) {
                this.f67503b = false;
                this.f67507f = 1;
            }
            if (this.f67507f >= 5.0d && e()) {
                this.f67503b = false;
                this.f67507f = 1;
                this.f67504c.set(this.f67505d.get());
                f();
            }
            return;
        }
        if (this.f67504c.get() != d2) {
            this.f67503b = true;
            this.f67505d = new AtomicReference<>(d2);
        }
    }

    public synchronized com.ss.android.socialbase.downloader.network.l d() {
        if (this.f67502a == null) {
            return com.ss.android.socialbase.downloader.network.l.UNKNOWN;
        }
        return b(this.f67502a.a());
    }

    public final boolean e() {
        if (this.f67502a == null) {
            return false;
        }
        try {
            int i2 = a.f67508a[this.f67504c.get().ordinal()];
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
            double a2 = this.f67502a.a();
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
            int size = this.f67506e.size();
            for (int i2 = 0; i2 < size; i2++) {
                this.f67506e.get(i2).a(this.f67504c.get());
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public m() {
        this.f67502a = new f(0.05d);
        this.f67503b = false;
        this.f67504c = new AtomicReference<>(com.ss.android.socialbase.downloader.network.l.UNKNOWN);
        this.f67506e = new ArrayList<>();
    }
}
