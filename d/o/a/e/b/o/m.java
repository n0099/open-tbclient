package d.o.a.e.b.o;

import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicReference;
/* loaded from: classes6.dex */
public class m {

    /* renamed from: a  reason: collision with root package name */
    public final f f68249a;

    /* renamed from: b  reason: collision with root package name */
    public volatile boolean f68250b;

    /* renamed from: c  reason: collision with root package name */
    public final AtomicReference<com.ss.android.socialbase.downloader.network.l> f68251c;

    /* renamed from: d  reason: collision with root package name */
    public AtomicReference<com.ss.android.socialbase.downloader.network.l> f68252d;

    /* renamed from: e  reason: collision with root package name */
    public final ArrayList<c> f68253e;

    /* renamed from: f  reason: collision with root package name */
    public int f68254f;

    /* loaded from: classes6.dex */
    public static /* synthetic */ class a {

        /* renamed from: a  reason: collision with root package name */
        public static final /* synthetic */ int[] f68255a;

        static {
            int[] iArr = new int[com.ss.android.socialbase.downloader.network.l.values().length];
            f68255a = iArr;
            try {
                iArr[com.ss.android.socialbase.downloader.network.l.POOR.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f68255a[com.ss.android.socialbase.downloader.network.l.MODERATE.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f68255a[com.ss.android.socialbase.downloader.network.l.GOOD.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f68255a[com.ss.android.socialbase.downloader.network.l.EXCELLENT.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
        }
    }

    /* loaded from: classes6.dex */
    public static class b {

        /* renamed from: a  reason: collision with root package name */
        public static final m f68256a = new m(null);
    }

    /* loaded from: classes6.dex */
    public interface c {
        void a(com.ss.android.socialbase.downloader.network.l lVar);
    }

    public /* synthetic */ m(a aVar) {
        this();
    }

    public static m a() {
        return b.f68256a;
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
            this.f68249a.b(d3);
            d2 = d();
        } catch (Throwable unused) {
        }
        if (this.f68250b) {
            this.f68254f++;
            if (d2 != this.f68252d.get()) {
                this.f68250b = false;
                this.f68254f = 1;
            }
            if (this.f68254f >= 5.0d && e()) {
                this.f68250b = false;
                this.f68254f = 1;
                this.f68251c.set(this.f68252d.get());
                f();
            }
            return;
        }
        if (this.f68251c.get() != d2) {
            this.f68250b = true;
            this.f68252d = new AtomicReference<>(d2);
        }
    }

    public synchronized com.ss.android.socialbase.downloader.network.l d() {
        if (this.f68249a == null) {
            return com.ss.android.socialbase.downloader.network.l.UNKNOWN;
        }
        return b(this.f68249a.a());
    }

    public final boolean e() {
        if (this.f68249a == null) {
            return false;
        }
        try {
            int i = a.f68255a[this.f68251c.get().ordinal()];
            double d2 = 2000.0d;
            double d3 = 550.0d;
            if (i == 1) {
                d3 = 0.0d;
                d2 = 150.0d;
            } else if (i == 2) {
                d2 = 550.0d;
                d3 = 150.0d;
            } else if (i != 3) {
                if (i != 4) {
                    return true;
                }
                d2 = 3.4028234663852886E38d;
                d3 = 2000.0d;
            }
            double a2 = this.f68249a.a();
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
            int size = this.f68253e.size();
            for (int i = 0; i < size; i++) {
                this.f68253e.get(i).a(this.f68251c.get());
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public m() {
        this.f68249a = new f(0.05d);
        this.f68250b = false;
        this.f68251c = new AtomicReference<>(com.ss.android.socialbase.downloader.network.l.UNKNOWN);
        this.f68253e = new ArrayList<>();
    }
}
