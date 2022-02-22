package com.ss.android.socialbase.downloader.network;

import android.net.TrafficStats;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.os.SystemClock;
import java.util.concurrent.atomic.AtomicInteger;
/* loaded from: classes4.dex */
public class b {
    public static volatile boolean a = false;

    /* renamed from: b  reason: collision with root package name */
    public static final String f60467b = "b";

    /* renamed from: g  reason: collision with root package name */
    public static long f60468g = -1;

    /* renamed from: h  reason: collision with root package name */
    public static volatile b f60469h;

    /* renamed from: c  reason: collision with root package name */
    public final k f60470c = k.a();

    /* renamed from: d  reason: collision with root package name */
    public final AtomicInteger f60471d = new AtomicInteger();

    /* renamed from: e  reason: collision with root package name */
    public final a f60472e = new a(com.ss.android.socialbase.downloader.h.e.a());

    /* renamed from: f  reason: collision with root package name */
    public long f60473f;

    /* loaded from: classes4.dex */
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
        if (f60469h == null) {
            synchronized (b.class) {
                if (f60469h == null) {
                    f60469h = new b();
                }
            }
        }
        return f60469h;
    }

    public static long d() {
        return TrafficStats.getTotalRxBytes() - TrafficStats.getMobileRxBytes();
    }

    public static void e() {
        a = com.ss.android.socialbase.downloader.i.f.b(com.ss.android.socialbase.downloader.downloader.c.N());
    }

    public void b() {
        try {
            String str = f60467b;
            com.ss.android.socialbase.downloader.c.a.c(str, "startSampling: mSamplingCounter = " + this.f60471d);
            if (this.f60471d.getAndIncrement() == 0) {
                this.f60472e.a();
                this.f60473f = SystemClock.uptimeMillis();
            }
        } catch (Throwable unused) {
        }
    }

    public void c() {
        try {
            String str = f60467b;
            com.ss.android.socialbase.downloader.c.a.c(str, "stopSampling: mSamplingCounter = " + this.f60471d);
            if (this.f60471d.decrementAndGet() == 0) {
                this.f60472e.b();
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
            long j2 = mobileRxBytes - f60468g;
            if (f60468g >= 0) {
                synchronized (this) {
                    long uptimeMillis = SystemClock.uptimeMillis();
                    this.f60470c.a(j2, uptimeMillis - this.f60473f);
                    this.f60473f = uptimeMillis;
                }
            }
            f60468g = mobileRxBytes;
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    public void g() {
        f();
        f60468g = -1L;
    }
}
