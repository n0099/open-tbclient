package com.ss.android.socialbase.downloader.i;

import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicReference;
/* loaded from: classes6.dex */
public class j {

    /* renamed from: a  reason: collision with root package name */
    private static final String f7845a = j.class.getSimpleName();
    private volatile boolean c;
    private final AtomicReference<k> d;
    private final ArrayList<b> f;
    private int g;
    private final c qhF;
    private AtomicReference<k> qhG;

    /* loaded from: classes6.dex */
    private static class a {
        public static final j qhH = new j();
    }

    /* loaded from: classes6.dex */
    public interface b {
        void a(k kVar);
    }

    public static j eIy() {
        return a.qhH;
    }

    private j() {
        this.qhF = new c(0.05d);
        this.c = false;
        this.d = new AtomicReference<>(k.UNKNOWN);
        this.f = new ArrayList<>();
    }

    public synchronized void a(long j, long j2) {
        double d = ((j * 1.0d) / j2) * 8.0d;
        if (j2 != 0 && d >= 3.0d) {
            try {
                this.qhF.a(d);
                k eIz = eIz();
                if (this.c) {
                    this.g++;
                    if (eIz != this.qhG.get()) {
                        this.c = false;
                        this.g = 1;
                    }
                    if (this.g >= 5.0d && c()) {
                        this.c = false;
                        this.g = 1;
                        this.d.set(this.qhG.get());
                        d();
                    }
                } else if (this.d.get() != eIz) {
                    this.c = true;
                    this.qhG = new AtomicReference<>(eIz);
                }
            } catch (Throwable th) {
            }
        }
    }

    private boolean c() {
        double d;
        double d2;
        if (this.qhF == null) {
            return false;
        }
        try {
            switch (this.d.get()) {
                case POOR:
                    d = 150.0d;
                    d2 = 0.0d;
                    break;
                case MODERATE:
                    d = 550.0d;
                    d2 = 150.0d;
                    break;
                case GOOD:
                    d = 2000.0d;
                    d2 = 550.0d;
                    break;
                case EXCELLENT:
                    d = 3.4028234663852886E38d;
                    d2 = 2000.0d;
                    break;
                default:
                    return true;
            }
            double a2 = this.qhF.a();
            if (a2 > d) {
                if (a2 > d * 1.25d) {
                    return true;
                }
            } else if (a2 < 0.8d * d2) {
                return true;
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
        return false;
    }

    public synchronized k eIz() {
        k L;
        if (this.qhF == null) {
            L = k.UNKNOWN;
        } else {
            L = L(this.qhF.a());
        }
        return L;
    }

    private k L(double d) {
        if (d < 0.0d) {
            return k.UNKNOWN;
        }
        if (d < 150.0d) {
            return k.POOR;
        }
        if (d < 550.0d) {
            return k.MODERATE;
        }
        if (d < 2000.0d) {
            return k.GOOD;
        }
        return k.EXCELLENT;
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
}
