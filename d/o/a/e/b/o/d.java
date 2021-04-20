package d.o.a.e.b.o;

import android.net.TrafficStats;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.os.SystemClock;
import java.util.concurrent.atomic.AtomicInteger;
/* loaded from: classes6.dex */
public class d {

    /* renamed from: e  reason: collision with root package name */
    public static final String f68223e = "d";

    /* renamed from: f  reason: collision with root package name */
    public static volatile boolean f68224f = false;

    /* renamed from: g  reason: collision with root package name */
    public static long f68225g = -1;

    /* renamed from: h  reason: collision with root package name */
    public static volatile d f68226h;

    /* renamed from: a  reason: collision with root package name */
    public final m f68227a = m.a();

    /* renamed from: b  reason: collision with root package name */
    public final AtomicInteger f68228b = new AtomicInteger();

    /* renamed from: c  reason: collision with root package name */
    public final a f68229c = new a(d.o.a.e.b.k.e.a());

    /* renamed from: d  reason: collision with root package name */
    public long f68230d;

    /* loaded from: classes6.dex */
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
            d.this.f();
            sendEmptyMessageDelayed(1, 1000L);
        }
    }

    public static d a() {
        if (f68226h == null) {
            synchronized (d.class) {
                if (f68226h == null) {
                    f68226h = new d();
                }
            }
        }
        return f68226h;
    }

    public static long d() {
        return TrafficStats.getTotalRxBytes() - TrafficStats.getMobileRxBytes();
    }

    public static void e() {
        f68224f = d.o.a.e.b.l.e.d0(d.o.a.e.b.g.d.l());
    }

    public void b() {
        try {
            String str = f68223e;
            d.o.a.e.b.c.a.h(str, "startSampling: mSamplingCounter = " + this.f68228b);
            if (this.f68228b.getAndIncrement() == 0) {
                this.f68229c.a();
                this.f68230d = SystemClock.uptimeMillis();
            }
        } catch (Throwable unused) {
        }
    }

    public void c() {
        try {
            String str = f68223e;
            d.o.a.e.b.c.a.h(str, "stopSampling: mSamplingCounter = " + this.f68228b);
            if (this.f68228b.decrementAndGet() == 0) {
                this.f68229c.b();
                g();
            }
        } catch (Throwable unused) {
        }
    }

    public void f() {
        long mobileRxBytes;
        try {
            e();
            if (f68224f) {
                mobileRxBytes = d();
            } else {
                mobileRxBytes = TrafficStats.getMobileRxBytes();
            }
            long j = mobileRxBytes - f68225g;
            if (f68225g >= 0) {
                synchronized (this) {
                    long uptimeMillis = SystemClock.uptimeMillis();
                    this.f68227a.c(j, uptimeMillis - this.f68230d);
                    this.f68230d = uptimeMillis;
                }
            }
            f68225g = mobileRxBytes;
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    public void g() {
        f();
        f68225g = -1L;
    }
}
