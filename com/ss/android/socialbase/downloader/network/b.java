package com.ss.android.socialbase.downloader.network;

import android.net.TrafficStats;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.os.SystemClock;
import java.util.concurrent.atomic.AtomicInteger;
/* loaded from: classes3.dex */
public class b {
    public static volatile boolean a = false;

    /* renamed from: b  reason: collision with root package name */
    public static final String f62618b = "b";

    /* renamed from: g  reason: collision with root package name */
    public static long f62619g = -1;

    /* renamed from: h  reason: collision with root package name */
    public static volatile b f62620h;

    /* renamed from: c  reason: collision with root package name */
    public final k f62621c = k.a();

    /* renamed from: d  reason: collision with root package name */
    public final AtomicInteger f62622d = new AtomicInteger();

    /* renamed from: e  reason: collision with root package name */
    public final a f62623e = new a(com.ss.android.socialbase.downloader.h.e.a());

    /* renamed from: f  reason: collision with root package name */
    public long f62624f;

    /* loaded from: classes3.dex */
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
        if (f62620h == null) {
            synchronized (b.class) {
                if (f62620h == null) {
                    f62620h = new b();
                }
            }
        }
        return f62620h;
    }

    public static long d() {
        return TrafficStats.getTotalRxBytes() - TrafficStats.getMobileRxBytes();
    }

    public static void e() {
        a = com.ss.android.socialbase.downloader.i.f.b(com.ss.android.socialbase.downloader.downloader.c.N());
    }

    public void b() {
        try {
            String str = f62618b;
            com.ss.android.socialbase.downloader.c.a.c(str, "startSampling: mSamplingCounter = " + this.f62622d);
            if (this.f62622d.getAndIncrement() == 0) {
                this.f62623e.a();
                this.f62624f = SystemClock.uptimeMillis();
            }
        } catch (Throwable unused) {
        }
    }

    public void c() {
        try {
            String str = f62618b;
            com.ss.android.socialbase.downloader.c.a.c(str, "stopSampling: mSamplingCounter = " + this.f62622d);
            if (this.f62622d.decrementAndGet() == 0) {
                this.f62623e.b();
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
            long j2 = mobileRxBytes - f62619g;
            if (f62619g >= 0) {
                synchronized (this) {
                    long uptimeMillis = SystemClock.uptimeMillis();
                    this.f62621c.a(j2, uptimeMillis - this.f62624f);
                    this.f62624f = uptimeMillis;
                }
            }
            f62619g = mobileRxBytes;
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    public void g() {
        f();
        f62619g = -1L;
    }
}
