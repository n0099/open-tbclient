package com.qq.e.comm.plugin.util;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.os.SystemClock;
/* loaded from: classes4.dex */
public abstract class ax {

    /* renamed from: a  reason: collision with root package name */
    private final long f12868a;

    /* renamed from: b  reason: collision with root package name */
    private final long f12869b;
    private long c;
    private long d;
    private boolean e = false;
    private boolean f = false;
    private Handler g = new Handler(Looper.getMainLooper()) { // from class: com.qq.e.comm.plugin.util.ax.1
        @Override // android.os.Handler
        public void handleMessage(Message message) {
            synchronized (ax.this) {
                if (ax.this.e || ax.this.f) {
                    return;
                }
                long elapsedRealtime = ax.this.c - SystemClock.elapsedRealtime();
                if (elapsedRealtime <= 0) {
                    ax.this.a();
                } else {
                    long elapsedRealtime2 = SystemClock.elapsedRealtime();
                    ax.this.a(elapsedRealtime);
                    long elapsedRealtime3 = (ax.this.f12869b + elapsedRealtime2) - SystemClock.elapsedRealtime();
                    while (elapsedRealtime3 < 0) {
                        elapsedRealtime3 += ax.this.f12869b;
                    }
                    sendMessageDelayed(obtainMessage(1), elapsedRealtime3);
                }
            }
        }
    };

    public ax(long j, long j2) {
        this.f12868a = j;
        this.f12869b = j2;
    }

    private ax b(long j) {
        synchronized (this) {
            this.e = false;
            if (j <= 0) {
                a();
            } else {
                this.c = SystemClock.elapsedRealtime() + j;
                this.g.sendMessage(this.g.obtainMessage(1));
            }
        }
        return this;
    }

    public abstract void a();

    public abstract void a(long j);

    public final void b() {
        synchronized (this) {
            b(this.f12868a);
        }
    }

    public final void c() {
        synchronized (this) {
            this.e = true;
            this.g.removeMessages(1);
        }
    }

    public final void d() {
        synchronized (this) {
            if (!this.e && !this.f) {
                this.f = true;
                this.d = this.c - SystemClock.elapsedRealtime();
                this.g.removeMessages(1);
            }
        }
    }

    public final void e() {
        synchronized (this) {
            if (!this.e && this.f) {
                this.f = false;
                b(this.d);
            }
        }
    }
}
