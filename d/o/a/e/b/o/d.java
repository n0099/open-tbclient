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
    public static final String f66747e = "d";

    /* renamed from: f  reason: collision with root package name */
    public static volatile boolean f66748f = false;

    /* renamed from: g  reason: collision with root package name */
    public static long f66749g = -1;

    /* renamed from: h  reason: collision with root package name */
    public static volatile d f66750h;

    /* renamed from: a  reason: collision with root package name */
    public final m f66751a = m.a();

    /* renamed from: b  reason: collision with root package name */
    public final AtomicInteger f66752b = new AtomicInteger();

    /* renamed from: c  reason: collision with root package name */
    public final a f66753c = new a(d.o.a.e.b.k.e.a());

    /* renamed from: d  reason: collision with root package name */
    public long f66754d;

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
        if (f66750h == null) {
            synchronized (d.class) {
                if (f66750h == null) {
                    f66750h = new d();
                }
            }
        }
        return f66750h;
    }

    public static long d() {
        return TrafficStats.getTotalRxBytes() - TrafficStats.getMobileRxBytes();
    }

    public static void e() {
        f66748f = d.o.a.e.b.l.e.d0(d.o.a.e.b.g.d.l());
    }

    public void b() {
        try {
            String str = f66747e;
            d.o.a.e.b.c.a.h(str, "startSampling: mSamplingCounter = " + this.f66752b);
            if (this.f66752b.getAndIncrement() == 0) {
                this.f66753c.a();
                this.f66754d = SystemClock.uptimeMillis();
            }
        } catch (Throwable unused) {
        }
    }

    public void c() {
        try {
            String str = f66747e;
            d.o.a.e.b.c.a.h(str, "stopSampling: mSamplingCounter = " + this.f66752b);
            if (this.f66752b.decrementAndGet() == 0) {
                this.f66753c.b();
                g();
            }
        } catch (Throwable unused) {
        }
    }

    public void f() {
        long mobileRxBytes;
        try {
            e();
            if (f66748f) {
                mobileRxBytes = d();
            } else {
                mobileRxBytes = TrafficStats.getMobileRxBytes();
            }
            long j = mobileRxBytes - f66749g;
            if (f66749g >= 0) {
                synchronized (this) {
                    long uptimeMillis = SystemClock.uptimeMillis();
                    this.f66751a.c(j, uptimeMillis - this.f66754d);
                    this.f66754d = uptimeMillis;
                }
            }
            f66749g = mobileRxBytes;
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    public void g() {
        f();
        f66749g = -1L;
    }
}
