package com.kascend.chushou.toolkit;

import android.os.Looper;
import android.os.SystemClock;
/* loaded from: classes6.dex */
public class d {

    /* renamed from: a  reason: collision with root package name */
    private final long f4216a;
    private final Runnable d;
    private long e;
    private long f;
    private int g;
    private final tv.chushou.zues.c pnP;
    private final a pnQ;

    /* loaded from: classes6.dex */
    public interface a {
        void a();
    }

    public d(long j, a aVar, tv.chushou.zues.c cVar) {
        this.f4216a = j;
        this.e = j;
        this.pnQ = aVar;
        if (cVar == null) {
            this.pnP = new tv.chushou.zues.c(Looper.getMainLooper());
        } else {
            this.pnP = cVar;
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
        this.pnP.f(this.d, this.e);
        this.g = 1;
    }

    public void b() {
        if (this.g != 3) {
            this.pnP.N(this.d);
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
        this.pnP.N(this.d);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e() {
        this.pnP.N(this.d);
        this.e = this.f4216a;
        this.g = 3;
        if (this.pnQ != null) {
            this.pnQ.a();
        }
    }
}
