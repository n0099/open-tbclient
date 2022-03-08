package com.ss.android.socialbase.downloader.network;

import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicReference;
/* loaded from: classes8.dex */
public class k {
    public static final String a = "k";

    /* renamed from: b  reason: collision with root package name */
    public final d f58836b;

    /* renamed from: c  reason: collision with root package name */
    public volatile boolean f58837c;

    /* renamed from: d  reason: collision with root package name */
    public final AtomicReference<l> f58838d;

    /* renamed from: e  reason: collision with root package name */
    public AtomicReference<l> f58839e;

    /* renamed from: f  reason: collision with root package name */
    public final ArrayList<b> f58840f;

    /* renamed from: g  reason: collision with root package name */
    public int f58841g;

    /* renamed from: com.ss.android.socialbase.downloader.network.k$1  reason: invalid class name */
    /* loaded from: classes8.dex */
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

    /* loaded from: classes8.dex */
    public static class a {
        public static final k a = new k(null);
    }

    /* loaded from: classes8.dex */
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
        if (this.f58836b == null) {
            return false;
        }
        try {
            int i2 = AnonymousClass1.a[this.f58838d.get().ordinal()];
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
            double a2 = this.f58836b.a();
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
            int size = this.f58840f.size();
            for (int i2 = 0; i2 < size; i2++) {
                this.f58840f.get(i2).a(this.f58838d.get());
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public synchronized l b() {
        if (this.f58836b == null) {
            return l.UNKNOWN;
        }
        return a(this.f58836b.a());
    }

    public k() {
        this.f58836b = new d(0.05d);
        this.f58837c = false;
        this.f58838d = new AtomicReference<>(l.UNKNOWN);
        this.f58840f = new ArrayList<>();
    }

    public synchronized void a(long j2, long j3) {
        l b2;
        double d2 = ((j2 * 1.0d) / j3) * 8.0d;
        if (j3 == 0 || d2 < 3.0d) {
            return;
        }
        try {
            this.f58836b.a(d2);
            b2 = b();
        } catch (Throwable unused) {
        }
        if (this.f58837c) {
            this.f58841g++;
            if (b2 != this.f58839e.get()) {
                this.f58837c = false;
                this.f58841g = 1;
            }
            if (this.f58841g >= 5.0d && c()) {
                this.f58837c = false;
                this.f58841g = 1;
                this.f58838d.set(this.f58839e.get());
                d();
            }
            return;
        }
        if (this.f58838d.get() != b2) {
            this.f58837c = true;
            this.f58839e = new AtomicReference<>(b2);
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
