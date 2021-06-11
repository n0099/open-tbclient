package d.o.a.e.b.o;

import android.net.TrafficStats;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.os.SystemClock;
import java.util.concurrent.atomic.AtomicInteger;
/* loaded from: classes7.dex */
public class d {

    /* renamed from: e  reason: collision with root package name */
    public static final String f71262e = "d";

    /* renamed from: f  reason: collision with root package name */
    public static volatile boolean f71263f = false;

    /* renamed from: g  reason: collision with root package name */
    public static long f71264g = -1;

    /* renamed from: h  reason: collision with root package name */
    public static volatile d f71265h;

    /* renamed from: a  reason: collision with root package name */
    public final m f71266a = m.a();

    /* renamed from: b  reason: collision with root package name */
    public final AtomicInteger f71267b = new AtomicInteger();

    /* renamed from: c  reason: collision with root package name */
    public final a f71268c = new a(d.o.a.e.b.k.e.a());

    /* renamed from: d  reason: collision with root package name */
    public long f71269d;

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
            d.this.f();
            sendEmptyMessageDelayed(1, 1000L);
        }
    }

    public static d a() {
        if (f71265h == null) {
            synchronized (d.class) {
                if (f71265h == null) {
                    f71265h = new d();
                }
            }
        }
        return f71265h;
    }

    public static long d() {
        return TrafficStats.getTotalRxBytes() - TrafficStats.getMobileRxBytes();
    }

    public static void e() {
        f71263f = d.o.a.e.b.l.e.d0(d.o.a.e.b.g.d.l());
    }

    public void b() {
        try {
            String str = f71262e;
            d.o.a.e.b.c.a.h(str, "startSampling: mSamplingCounter = " + this.f71267b);
            if (this.f71267b.getAndIncrement() == 0) {
                this.f71268c.a();
                this.f71269d = SystemClock.uptimeMillis();
            }
        } catch (Throwable unused) {
        }
    }

    public void c() {
        try {
            String str = f71262e;
            d.o.a.e.b.c.a.h(str, "stopSampling: mSamplingCounter = " + this.f71267b);
            if (this.f71267b.decrementAndGet() == 0) {
                this.f71268c.b();
                g();
            }
        } catch (Throwable unused) {
        }
    }

    public void f() {
        long mobileRxBytes;
        try {
            e();
            if (f71263f) {
                mobileRxBytes = d();
            } else {
                mobileRxBytes = TrafficStats.getMobileRxBytes();
            }
            long j = mobileRxBytes - f71264g;
            if (f71264g >= 0) {
                synchronized (this) {
                    long uptimeMillis = SystemClock.uptimeMillis();
                    this.f71266a.c(j, uptimeMillis - this.f71269d);
                    this.f71269d = uptimeMillis;
                }
            }
            f71264g = mobileRxBytes;
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    public void g() {
        f();
        f71264g = -1L;
    }
}
