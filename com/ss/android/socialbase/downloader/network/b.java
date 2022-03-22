package com.ss.android.socialbase.downloader.network;

import android.net.TrafficStats;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.os.SystemClock;
import java.util.concurrent.atomic.AtomicInteger;
/* loaded from: classes7.dex */
public class b {
    public static volatile boolean a = false;

    /* renamed from: b  reason: collision with root package name */
    public static final String f43508b = "b";

    /* renamed from: g  reason: collision with root package name */
    public static long f43509g = -1;

    /* renamed from: h  reason: collision with root package name */
    public static volatile b f43510h;

    /* renamed from: c  reason: collision with root package name */
    public final k f43511c = k.a();

    /* renamed from: d  reason: collision with root package name */
    public final AtomicInteger f43512d = new AtomicInteger();

    /* renamed from: e  reason: collision with root package name */
    public final a f43513e = new a(com.ss.android.socialbase.downloader.h.e.a());

    /* renamed from: f  reason: collision with root package name */
    public long f43514f;

    /* loaded from: classes7.dex */
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
            if (message.what != 1) {
                return;
            }
            b.this.f();
            sendEmptyMessageDelayed(1, 1000L);
        }
    }

    public static b a() {
        if (f43510h == null) {
            synchronized (b.class) {
                if (f43510h == null) {
                    f43510h = new b();
                }
            }
        }
        return f43510h;
    }

    public static long d() {
        return TrafficStats.getTotalRxBytes() - TrafficStats.getMobileRxBytes();
    }

    public static void e() {
        a = com.ss.android.socialbase.downloader.i.f.b(com.ss.android.socialbase.downloader.downloader.c.N());
    }

    public void b() {
        try {
            String str = f43508b;
            com.ss.android.socialbase.downloader.c.a.c(str, "startSampling: mSamplingCounter = " + this.f43512d);
            if (this.f43512d.getAndIncrement() == 0) {
                this.f43513e.a();
                this.f43514f = SystemClock.uptimeMillis();
            }
        } catch (Throwable unused) {
        }
    }

    public void c() {
        try {
            String str = f43508b;
            com.ss.android.socialbase.downloader.c.a.c(str, "stopSampling: mSamplingCounter = " + this.f43512d);
            if (this.f43512d.decrementAndGet() == 0) {
                this.f43513e.b();
                g();
            }
        } catch (Throwable unused) {
        }
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
            long j = mobileRxBytes - f43509g;
            if (f43509g >= 0) {
                synchronized (this) {
                    long uptimeMillis = SystemClock.uptimeMillis();
                    this.f43511c.a(j, uptimeMillis - this.f43514f);
                    this.f43514f = uptimeMillis;
                }
            }
            f43509g = mobileRxBytes;
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    public void g() {
        f();
        f43509g = -1L;
    }
}
