package com.ss.android.socialbase.downloader.i;

import android.net.TrafficStats;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import android.os.SystemClock;
import java.util.concurrent.atomic.AtomicInteger;
/* loaded from: classes6.dex */
public class b {

    /* renamed from: a  reason: collision with root package name */
    private static final String f7843a = b.class.getSimpleName();
    private static long f = -1;
    private static volatile b qhD = null;
    private long e;
    private final a qhC;
    private final j qhB = j.eIy();
    private final AtomicInteger c = new AtomicInteger();

    public static b eIx() {
        if (qhD == null) {
            synchronized (b.class) {
                if (qhD == null) {
                    qhD = new b();
                }
            }
        }
        return qhD;
    }

    private b() {
        HandlerThread handlerThread = new HandlerThread("ParseThread");
        handlerThread.start();
        this.qhC = new a(handlerThread.getLooper());
    }

    public void b() {
        try {
            if (this.c.getAndIncrement() == 0) {
                if (com.ss.android.socialbase.downloader.f.a.a()) {
                    com.ss.android.socialbase.downloader.f.a.b(f7843a, "startSampling");
                }
                this.qhC.a();
                this.e = SystemClock.uptimeMillis();
            }
        } catch (Throwable th) {
        }
    }

    public void c() {
        try {
            if (this.c.decrementAndGet() == 0) {
                if (com.ss.android.socialbase.downloader.f.a.a()) {
                    com.ss.android.socialbase.downloader.f.a.b(f7843a, "stopSampling");
                }
                this.qhC.b();
                f();
            }
        } catch (Throwable th) {
        }
    }

    public static long d() {
        return TrafficStats.getTotalRxBytes() - TrafficStats.getMobileRxBytes();
    }

    protected void e() {
        long mobileRxBytes;
        try {
            if (com.ss.android.socialbase.downloader.m.d.a(com.ss.android.socialbase.downloader.downloader.b.eGG())) {
                mobileRxBytes = d();
            } else {
                mobileRxBytes = TrafficStats.getMobileRxBytes();
            }
            long j = mobileRxBytes - f;
            if (f >= 0) {
                synchronized (this) {
                    long uptimeMillis = SystemClock.uptimeMillis();
                    this.qhB.a(j, uptimeMillis - this.e);
                    this.e = uptimeMillis;
                }
            }
            f = mobileRxBytes;
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    protected void f() {
        e();
        f = -1L;
    }

    /* loaded from: classes6.dex */
    private class a extends Handler {
        public a(Looper looper) {
            super(looper);
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            switch (message.what) {
                case 1:
                    b.this.e();
                    sendEmptyMessageDelayed(1, 1000L);
                    return;
                default:
                    return;
            }
        }

        public void a() {
            sendEmptyMessage(1);
        }

        public void b() {
            removeMessages(1);
        }
    }
}
