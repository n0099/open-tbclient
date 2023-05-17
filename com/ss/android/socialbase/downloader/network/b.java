package com.ss.android.socialbase.downloader.network;

import android.net.TrafficStats;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.os.SystemClock;
import java.util.concurrent.atomic.AtomicInteger;
/* loaded from: classes10.dex */
public class b {
    public static volatile boolean a = false;
    public static final String b = "b";
    public static long g = -1;
    public static volatile b h;
    public final k c = k.a();
    public final AtomicInteger d = new AtomicInteger();
    public final a e = new a(com.ss.android.socialbase.downloader.h.e.a());
    public long f;

    /* loaded from: classes10.dex */
    public class a extends Handler {
        public a(Looper looper) {
            super(looper);
        }

        public void a() {
            sendEmptyMessage(1);
        }

        public void b() {
            removeMessages(1);
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            if (message.what == 1) {
                b.this.f();
                sendEmptyMessageDelayed(1, 1000L);
            }
        }
    }

    public static b a() {
        if (h == null) {
            synchronized (b.class) {
                if (h == null) {
                    h = new b();
                }
            }
        }
        return h;
    }

    public static long d() {
        return TrafficStats.getTotalRxBytes() - TrafficStats.getMobileRxBytes();
    }

    public static void e() {
        a = com.ss.android.socialbase.downloader.i.f.b(com.ss.android.socialbase.downloader.downloader.c.N());
    }

    public void b() {
        try {
            String str = b;
            com.ss.android.socialbase.downloader.c.a.c(str, "startSampling: mSamplingCounter = " + this.d);
            if (this.d.getAndIncrement() == 0) {
                this.e.a();
                this.f = SystemClock.uptimeMillis();
            }
        } catch (Throwable unused) {
        }
    }

    public void c() {
        try {
            String str = b;
            com.ss.android.socialbase.downloader.c.a.c(str, "stopSampling: mSamplingCounter = " + this.d);
            if (this.d.decrementAndGet() == 0) {
                this.e.b();
                g();
            }
        } catch (Throwable unused) {
        }
    }

    public void g() {
        f();
        g = -1L;
    }

    public void f() {
        long mobileRxBytes;
        try {
            e();
            if (a) {
                mobileRxBytes = d();
            } else {
                mobileRxBytes = TrafficStats.getMobileRxBytes();
            }
            long j = mobileRxBytes - g;
            if (g >= 0) {
                synchronized (this) {
                    long uptimeMillis = SystemClock.uptimeMillis();
                    this.c.a(j, uptimeMillis - this.f);
                    this.f = uptimeMillis;
                }
            }
            g = mobileRxBytes;
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
