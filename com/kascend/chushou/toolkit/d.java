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
    private final tv.chushou.zues.c mXt;
    private final a mXu;

    /* loaded from: classes5.dex */
    public interface a {
        void a();
    }

    public d(long j, a aVar, tv.chushou.zues.c cVar) {
        this.a = j;
        this.e = j;
        this.mXu = aVar;
        if (cVar == null) {
            this.mXt = new tv.chushou.zues.c(Looper.getMainLooper());
        } else {
            this.mXt = cVar;
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
        this.mXt.e(this.d, this.e);
        this.g = 1;
    }

    public void b() {
        if (this.g != 3) {
            this.mXt.P(this.d);
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
        this.mXt.P(this.d);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e() {
        this.mXt.P(this.d);
        this.e = this.a;
        this.g = 3;
        if (this.mXu != null) {
            this.mXu.a();
        }
    }
}
