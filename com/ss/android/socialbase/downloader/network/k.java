package com.ss.android.socialbase.downloader.network;

import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicReference;
/* loaded from: classes4.dex */
public class k {
    public static final String a = "k";

    /* renamed from: b  reason: collision with root package name */
    public final d f60486b;

    /* renamed from: c  reason: collision with root package name */
    public volatile boolean f60487c;

    /* renamed from: d  reason: collision with root package name */
    public final AtomicReference<l> f60488d;

    /* renamed from: e  reason: collision with root package name */
    public AtomicReference<l> f60489e;

    /* renamed from: f  reason: collision with root package name */
    public final ArrayList<b> f60490f;

    /* renamed from: g  reason: collision with root package name */
    public int f60491g;

    /* renamed from: com.ss.android.socialbase.downloader.network.k$1  reason: invalid class name */
    /* loaded from: classes4.dex */
    public static /* synthetic */ class AnonymousClass1 {
        public static final /* synthetic */ int[] a;

        static {
            int[] iArr = new int[l.values().length];
            a = iArr;
            try {
                iArr[l.POOR.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                a[l.MODERATE.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                a[l.GOOD.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                a[l.EXCELLENT.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
        }
    }

    /* loaded from: classes4.dex */
    public static class a {
        public static final k a = new k(null);
    }

    /* loaded from: classes4.dex */
    public interface b {
        void a(l lVar);
    }

    public /* synthetic */ k(AnonymousClass1 anonymousClass1) {
        this();
    }

    public static k a() {
        return a.a;
    }

    private boolean c() {
        if (this.f60486b == null) {
            return false;
        }
        try {
            int i2 = AnonymousClass1.a[this.f60488d.get().ordinal()];
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
            double a2 = this.f60486b.a();
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

    private void d() {
        try {
            int size = this.f60490f.size();
            for (int i2 = 0; i2 < size; i2++) {
                this.f60490f.get(i2).a(this.f60488d.get());
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public synchronized l b() {
        if (this.f60486b == null) {
            return l.UNKNOWN;
        }
        return a(this.f60486b.a());
    }

    public k() {
        this.f60486b = new d(0.05d);
        this.f60487c = false;
        this.f60488d = new AtomicReference<>(l.UNKNOWN);
        this.f60490f = new ArrayList<>();
    }

    public synchronized void a(long j2, long j3) {
        l b2;
        double d2 = ((j2 * 1.0d) / j3) * 8.0d;
        if (j3 == 0 || d2 < 3.0d) {
            return;
        }
        try {
            this.f60486b.a(d2);
            b2 = b();
        } catch (Throwable unused) {
        }
        if (this.f60487c) {
            this.f60491g++;
            if (b2 != this.f60489e.get()) {
                this.f60487c = false;
                this.f60491g = 1;
            }
            if (this.f60491g >= 5.0d && c()) {
                this.f60487c = false;
                this.f60491g = 1;
                this.f60488d.set(this.f60489e.get());
                d();
            }
            return;
        }
        if (this.f60488d.get() != b2) {
            this.f60487c = true;
            this.f60489e = new AtomicReference<>(b2);
        }
    }

    private l a(double d2) {
        if (d2 < 0.0d) {
            return l.UNKNOWN;
        }
        if (d2 < 150.0d) {
            return l.POOR;
        }
        if (d2 < 550.0d) {
            return l.MODERATE;
        }
        if (d2 < 2000.0d) {
            return l.GOOD;
        }
        return l.EXCELLENT;
    }
}
