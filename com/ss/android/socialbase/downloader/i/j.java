package com.ss.android.socialbase.downloader.i;

import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicReference;
/* loaded from: classes4.dex */
public class j {

    /* renamed from: a  reason: collision with root package name */
    private static final String f13474a = j.class.getSimpleName();
    private volatile boolean c;
    private final AtomicReference<k> d;
    private AtomicReference<k> e;
    private final ArrayList<b> f;
    private int g;
    private final c qaM;

    /* loaded from: classes4.dex */
    private static class a {
        public static final j qaN = new j();
    }

    /* loaded from: classes4.dex */
    public interface b {
        void a(k kVar);
    }

    public static j eJN() {
        return a.qaN;
    }

    private j() {
        this.qaM = new c(0.05d);
        this.c = false;
        this.d = new AtomicReference<>(k.UNKNOWN);
        this.f = new ArrayList<>();
    }

    public synchronized void a(long j, long j2) {
        double d = ((j * 1.0d) / j2) * 8.0d;
        if (j2 != 0 && d >= 3.0d) {
            try {
                this.qaM.a(d);
                k eJO = eJO();
                if (this.c) {
                    this.g++;
                    if (eJO != this.e.get()) {
                        this.c = false;
                        this.g = 1;
                    }
                    if (this.g >= 5.0d && c()) {
                        this.c = false;
                        this.g = 1;
                        this.d.set(this.e.get());
                        d();
                    }
                } else if (this.d.get() != eJO) {
                    this.c = true;
                    this.e = new AtomicReference<>(eJO);
                }
            } catch (Throwable th) {
            }
        }
    }

    private boolean c() {
        double d;
        double d2;
        if (this.qaM == null) {
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
            double a2 = this.qaM.a();
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

    public synchronized k eJO() {
        k R;
        if (this.qaM == null) {
            R = k.UNKNOWN;
        } else {
            R = R(this.qaM.a());
        }
        return R;
    }

    private k R(double d) {
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
