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
    public static final String f67476e = "d";

    /* renamed from: f  reason: collision with root package name */
    public static volatile boolean f67477f = false;

    /* renamed from: g  reason: collision with root package name */
    public static long f67478g = -1;

    /* renamed from: h  reason: collision with root package name */
    public static volatile d f67479h;

    /* renamed from: a  reason: collision with root package name */
    public final m f67480a = m.a();

    /* renamed from: b  reason: collision with root package name */
    public final AtomicInteger f67481b = new AtomicInteger();

    /* renamed from: c  reason: collision with root package name */
    public final a f67482c = new a(d.o.a.e.b.k.e.a());

    /* renamed from: d  reason: collision with root package name */
    public long f67483d;

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
        if (f67479h == null) {
            synchronized (d.class) {
                if (f67479h == null) {
                    f67479h = new d();
                }
            }
        }
        return f67479h;
    }

    public static long d() {
        return TrafficStats.getTotalRxBytes() - TrafficStats.getMobileRxBytes();
    }

    public static void e() {
        f67477f = d.o.a.e.b.l.e.d0(d.o.a.e.b.g.d.l());
    }

    public void b() {
        try {
            String str = f67476e;
            d.o.a.e.b.c.a.h(str, "startSampling: mSamplingCounter = " + this.f67481b);
            if (this.f67481b.getAndIncrement() == 0) {
                this.f67482c.a();
                this.f67483d = SystemClock.uptimeMillis();
            }
        } catch (Throwable unused) {
        }
    }

    public void c() {
        try {
            String str = f67476e;
            d.o.a.e.b.c.a.h(str, "stopSampling: mSamplingCounter = " + this.f67481b);
            if (this.f67481b.decrementAndGet() == 0) {
                this.f67482c.b();
                g();
            }
        } catch (Throwable unused) {
        }
    }

    public void f() {
        long mobileRxBytes;
        try {
            e();
            if (f67477f) {
                mobileRxBytes = d();
            } else {
                mobileRxBytes = TrafficStats.getMobileRxBytes();
            }
            long j = mobileRxBytes - f67478g;
            if (f67478g >= 0) {
                synchronized (this) {
                    long uptimeMillis = SystemClock.uptimeMillis();
                    this.f67480a.c(j, uptimeMillis - this.f67483d);
                    this.f67483d = uptimeMillis;
                }
            }
            f67478g = mobileRxBytes;
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    public void g() {
        f();
        f67478g = -1L;
    }
}
