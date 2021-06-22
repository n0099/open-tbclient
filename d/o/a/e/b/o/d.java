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
    public static final String f71366e = "d";

    /* renamed from: f  reason: collision with root package name */
    public static volatile boolean f71367f = false;

    /* renamed from: g  reason: collision with root package name */
    public static long f71368g = -1;

    /* renamed from: h  reason: collision with root package name */
    public static volatile d f71369h;

    /* renamed from: a  reason: collision with root package name */
    public final m f71370a = m.a();

    /* renamed from: b  reason: collision with root package name */
    public final AtomicInteger f71371b = new AtomicInteger();

    /* renamed from: c  reason: collision with root package name */
    public final a f71372c = new a(d.o.a.e.b.k.e.a());

    /* renamed from: d  reason: collision with root package name */
    public long f71373d;

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
        if (f71369h == null) {
            synchronized (d.class) {
                if (f71369h == null) {
                    f71369h = new d();
                }
            }
        }
        return f71369h;
    }

    public static long d() {
        return TrafficStats.getTotalRxBytes() - TrafficStats.getMobileRxBytes();
    }

    public static void e() {
        f71367f = d.o.a.e.b.l.e.d0(d.o.a.e.b.g.d.l());
    }

    public void b() {
        try {
            String str = f71366e;
            d.o.a.e.b.c.a.h(str, "startSampling: mSamplingCounter = " + this.f71371b);
            if (this.f71371b.getAndIncrement() == 0) {
                this.f71372c.a();
                this.f71373d = SystemClock.uptimeMillis();
            }
        } catch (Throwable unused) {
        }
    }

    public void c() {
        try {
            String str = f71366e;
            d.o.a.e.b.c.a.h(str, "stopSampling: mSamplingCounter = " + this.f71371b);
            if (this.f71371b.decrementAndGet() == 0) {
                this.f71372c.b();
                g();
            }
        } catch (Throwable unused) {
        }
    }

    public void f() {
        long mobileRxBytes;
        try {
            e();
            if (f71367f) {
                mobileRxBytes = d();
            } else {
                mobileRxBytes = TrafficStats.getMobileRxBytes();
            }
            long j = mobileRxBytes - f71368g;
            if (f71368g >= 0) {
                synchronized (this) {
                    long uptimeMillis = SystemClock.uptimeMillis();
                    this.f71370a.c(j, uptimeMillis - this.f71373d);
                    this.f71373d = uptimeMillis;
                }
            }
            f71368g = mobileRxBytes;
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    public void g() {
        f();
        f71368g = -1L;
    }
}
