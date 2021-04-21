package d.p.a.e.b.o;

import android.net.TrafficStats;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.os.SystemClock;
import java.util.concurrent.atomic.AtomicInteger;
/* loaded from: classes6.dex */
public class d {

    /* renamed from: e  reason: collision with root package name */
    public static final String f68370e = "d";

    /* renamed from: f  reason: collision with root package name */
    public static volatile boolean f68371f = false;

    /* renamed from: g  reason: collision with root package name */
    public static long f68372g = -1;

    /* renamed from: h  reason: collision with root package name */
    public static volatile d f68373h;

    /* renamed from: a  reason: collision with root package name */
    public final m f68374a = m.a();

    /* renamed from: b  reason: collision with root package name */
    public final AtomicInteger f68375b = new AtomicInteger();

    /* renamed from: c  reason: collision with root package name */
    public final a f68376c = new a(d.p.a.e.b.k.e.a());

    /* renamed from: d  reason: collision with root package name */
    public long f68377d;

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
        if (f68373h == null) {
            synchronized (d.class) {
                if (f68373h == null) {
                    f68373h = new d();
                }
            }
        }
        return f68373h;
    }

    public static long d() {
        return TrafficStats.getTotalRxBytes() - TrafficStats.getMobileRxBytes();
    }

    public static void e() {
        f68371f = d.p.a.e.b.l.e.d0(d.p.a.e.b.g.d.l());
    }

    public void b() {
        try {
            String str = f68370e;
            d.p.a.e.b.c.a.h(str, "startSampling: mSamplingCounter = " + this.f68375b);
            if (this.f68375b.getAndIncrement() == 0) {
                this.f68376c.a();
                this.f68377d = SystemClock.uptimeMillis();
            }
        } catch (Throwable unused) {
        }
    }

    public void c() {
        try {
            String str = f68370e;
            d.p.a.e.b.c.a.h(str, "stopSampling: mSamplingCounter = " + this.f68375b);
            if (this.f68375b.decrementAndGet() == 0) {
                this.f68376c.b();
                g();
            }
        } catch (Throwable unused) {
        }
    }

    public void f() {
        long mobileRxBytes;
        try {
            e();
            if (f68371f) {
                mobileRxBytes = d();
            } else {
                mobileRxBytes = TrafficStats.getMobileRxBytes();
            }
            long j = mobileRxBytes - f68372g;
            if (f68372g >= 0) {
                synchronized (this) {
                    long uptimeMillis = SystemClock.uptimeMillis();
                    this.f68374a.c(j, uptimeMillis - this.f68377d);
                    this.f68377d = uptimeMillis;
                }
            }
            f68372g = mobileRxBytes;
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    public void g() {
        f();
        f68372g = -1L;
    }
}
