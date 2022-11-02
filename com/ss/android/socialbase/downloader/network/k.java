package com.ss.android.socialbase.downloader.network;

import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicReference;
/* loaded from: classes8.dex */
public class k {
    public static final String a = "k";
    public final d b;
    public volatile boolean c;
    public final AtomicReference<l> d;
    public AtomicReference<l> e;
    public final ArrayList<b> f;
    public int g;

    /* loaded from: classes8.dex */
    public static class a {
        public static final k a = new k(null);
    }

    /* loaded from: classes8.dex */
    public interface b {
        void a(l lVar);
    }

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

    public k() {
        this.b = new d(0.05d);
        this.c = false;
        this.d = new AtomicReference<>(l.UNKNOWN);
        this.f = new ArrayList<>();
    }

    public static k a() {
        return a.a;
    }

    private void d() {
        try {
            int size = this.f.size();
            for (int i = 0; i < size; i++) {
                this.f.get(i).a(this.d.get());
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public synchronized l b() {
        if (this.b == null) {
            return l.UNKNOWN;
        }
        return a(this.b.a());
    }

    public /* synthetic */ k(AnonymousClass1 anonymousClass1) {
        this();
    }

    private l a(double d) {
        if (d < 0.0d) {
            return l.UNKNOWN;
        }
        if (d < 150.0d) {
            return l.POOR;
        }
        if (d < 550.0d) {
            return l.MODERATE;
        }
        if (d < 2000.0d) {
            return l.GOOD;
        }
        return l.EXCELLENT;
    }

    private boolean c() {
        if (this.b == null) {
            return false;
        }
        try {
            int i = AnonymousClass1.a[this.d.get().ordinal()];
            double d = 2000.0d;
            double d2 = 550.0d;
            if (i != 1) {
                if (i != 2) {
                    if (i != 3) {
                        if (i != 4) {
                            return true;
                        }
                        d = 3.4028234663852886E38d;
                        d2 = 2000.0d;
                    }
                } else {
                    d = 550.0d;
                    d2 = 150.0d;
                }
            } else {
                d2 = 0.0d;
                d = 150.0d;
            }
            double a2 = this.b.a();
            if (a2 > d) {
                if (a2 > d * 1.25d) {
                    return true;
                }
            } else if (a2 < d2 * 0.8d) {
                return true;
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
        return false;
    }

    public synchronized void a(long j, long j2) {
        l b2;
        double d = ((j * 1.0d) / j2) * 8.0d;
        if (j2 != 0 && d >= 3.0d) {
            try {
                this.b.a(d);
                b2 = b();
            } catch (Throwable unused) {
            }
            if (this.c) {
                this.g++;
                if (b2 != this.e.get()) {
                    this.c = false;
                    this.g = 1;
                }
                if (this.g >= 5.0d && c()) {
                    this.c = false;
                    this.g = 1;
                    this.d.set(this.e.get());
                    d();
                }
                return;
            }
            if (this.d.get() != b2) {
                this.c = true;
                this.e = new AtomicReference<>(b2);
            }
        }
    }
}
