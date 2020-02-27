package com.kascend.chushou.toolkit;

import android.os.Looper;
import android.os.SystemClock;
/* loaded from: classes5.dex */
public class d {
    private final long a;
    private final Runnable d;
    private long e;
    private long f;
    private int g;
    private final tv.chushou.zues.c neI;
    private final a neJ;

    /* loaded from: classes5.dex */
    public interface a {
        void a();
    }

    public d(long j, a aVar, tv.chushou.zues.c cVar) {
        this.a = j;
        this.e = j;
        this.neJ = aVar;
        if (cVar == null) {
            this.neI = new tv.chushou.zues.c(Looper.getMainLooper());
        } else {
            this.neI = cVar;
        }
        this.d = new Runnable() { // from class: com.kascend.chushou.toolkit.d.1
            @Override // java.lang.Runnable
            public void run() {
                d.this.e();
            }
        };
        this.g = 0;
    }

    public void a() {
        this.f = SystemClock.uptimeMillis();
        this.neI.d(this.d, this.e);
        this.g = 1;
    }

    public void b() {
        if (this.g != 3) {
            this.neI.removeCallbacks(this.d);
            this.e -= SystemClock.uptimeMillis() - this.f;
            this.f = 0L;
            this.g = 2;
            if (this.e <= 0) {
                e();
            }
        }
    }

    public boolean c() {
        return this.g == 3;
    }

    public void d() {
        this.neI.removeCallbacks(this.d);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e() {
        this.neI.removeCallbacks(this.d);
        this.e = this.a;
        this.g = 3;
        if (this.neJ != null) {
            this.neJ.a();
        }
    }
}
