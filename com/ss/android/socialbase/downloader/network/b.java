package com.ss.android.socialbase.downloader.network;

import android.net.TrafficStats;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.os.SystemClock;
import java.util.concurrent.atomic.AtomicInteger;
/* loaded from: classes8.dex */
public class b {
    public static volatile boolean a = false;

    /* renamed from: b  reason: collision with root package name */
    public static final String f58817b = "b";

    /* renamed from: g  reason: collision with root package name */
    public static long f58818g = -1;

    /* renamed from: h  reason: collision with root package name */
    public static volatile b f58819h;

    /* renamed from: c  reason: collision with root package name */
    public final k f58820c = k.a();

    /* renamed from: d  reason: collision with root package name */
    public final AtomicInteger f58821d = new AtomicInteger();

    /* renamed from: e  reason: collision with root package name */
    public final a f58822e = new a(com.ss.android.socialbase.downloader.h.e.a());

    /* renamed from: f  reason: collision with root package name */
    public long f58823f;

    /* loaded from: classes8.dex */
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
        if (f58819h == null) {
            synchronized (b.class) {
                if (f58819h == null) {
                    f58819h = new b();
                }
            }
        }
        return f58819h;
    }

    public static long d() {
        return TrafficStats.getTotalRxBytes() - TrafficStats.getMobileRxBytes();
    }

    public static void e() {
        a = com.ss.android.socialbase.downloader.i.f.b(com.ss.android.socialbase.downloader.downloader.c.N());
    }

    public void b() {
        try {
            String str = f58817b;
            com.ss.android.socialbase.downloader.c.a.c(str, "startSampling: mSamplingCounter = " + this.f58821d);
            if (this.f58821d.getAndIncrement() == 0) {
                this.f58822e.a();
                this.f58823f = SystemClock.uptimeMillis();
            }
        } catch (Throwable unused) {
        }
    }

    public void c() {
        try {
            String str = f58817b;
            com.ss.android.socialbase.downloader.c.a.c(str, "stopSampling: mSamplingCounter = " + this.f58821d);
            if (this.f58821d.decrementAndGet() == 0) {
                this.f58822e.b();
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
            long j2 = mobileRxBytes - f58818g;
            if (f58818g >= 0) {
                synchronized (this) {
                    long uptimeMillis = SystemClock.uptimeMillis();
                    this.f58820c.a(j2, uptimeMillis - this.f58823f);
                    this.f58823f = uptimeMillis;
                }
            }
            f58818g = mobileRxBytes;
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    public void g() {
        f();
        f58818g = -1L;
    }
}
