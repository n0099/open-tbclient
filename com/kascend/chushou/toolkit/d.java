package com.kascend.chushou.toolkit;

import android.os.Looper;
import android.os.SystemClock;
/* loaded from: classes6.dex */
public class d {

    /* renamed from: a  reason: collision with root package name */
    private final long f4218a;
    private final Runnable d;
    private long e;
    private long f;
    private int g;
    private final tv.chushou.zues.c pxo;
    private final a pxp;

    /* loaded from: classes6.dex */
    public interface a {
        void a();
    }

    public d(long j, a aVar, tv.chushou.zues.c cVar) {
        this.f4218a = j;
        this.e = j;
        this.pxp = aVar;
        if (cVar == null) {
            this.pxo = new tv.chushou.zues.c(Looper.getMainLooper());
        } else {
            this.pxo = cVar;
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
        this.pxo.f(this.d, this.e);
        this.g = 1;
    }

    public void b() {
        if (this.g != 3) {
            this.pxo.N(this.d);
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
        this.pxo.N(this.d);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e() {
        this.pxo.N(this.d);
        this.e = this.f4218a;
        this.g = 3;
        if (this.pxp != null) {
            this.pxp.a();
        }
    }
}
