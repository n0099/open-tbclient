package d.g.c.a;

import com.meizu.cloud.pushsdk.notification.model.NotificationStyle;
import java.util.concurrent.TimeUnit;
/* loaded from: classes6.dex */
public final class p {

    /* renamed from: a  reason: collision with root package name */
    public final t f66950a = t.b();

    /* renamed from: b  reason: collision with root package name */
    public boolean f66951b;

    /* renamed from: c  reason: collision with root package name */
    public long f66952c;

    /* renamed from: d  reason: collision with root package name */
    public long f66953d;

    /* loaded from: classes6.dex */
    public static /* synthetic */ class a {

        /* renamed from: a  reason: collision with root package name */
        public static final /* synthetic */ int[] f66954a;

        static {
            int[] iArr = new int[TimeUnit.values().length];
            f66954a = iArr;
            try {
                iArr[TimeUnit.NANOSECONDS.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f66954a[TimeUnit.MICROSECONDS.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f66954a[TimeUnit.MILLISECONDS.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f66954a[TimeUnit.SECONDS.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f66954a[TimeUnit.MINUTES.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                f66954a[TimeUnit.HOURS.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                f66954a[TimeUnit.DAYS.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
        }
    }

    public static String a(TimeUnit timeUnit) {
        switch (a.f66954a[timeUnit.ordinal()]) {
            case 1:
                return NotificationStyle.NOTIFICATION_STYLE;
            case 2:
                return "μs";
            case 3:
                return "ms";
            case 4:
                return "s";
            case 5:
                return "min";
            case 6:
                return "h";
            case 7:
                return "d";
            default:
                throw new AssertionError();
        }
    }

    public static TimeUnit b(long j) {
        if (TimeUnit.DAYS.convert(j, TimeUnit.NANOSECONDS) > 0) {
            return TimeUnit.DAYS;
        }
        if (TimeUnit.HOURS.convert(j, TimeUnit.NANOSECONDS) > 0) {
            return TimeUnit.HOURS;
        }
        if (TimeUnit.MINUTES.convert(j, TimeUnit.NANOSECONDS) > 0) {
            return TimeUnit.MINUTES;
        }
        if (TimeUnit.SECONDS.convert(j, TimeUnit.NANOSECONDS) > 0) {
            return TimeUnit.SECONDS;
        }
        if (TimeUnit.MILLISECONDS.convert(j, TimeUnit.NANOSECONDS) > 0) {
            return TimeUnit.MILLISECONDS;
        }
        if (TimeUnit.MICROSECONDS.convert(j, TimeUnit.NANOSECONDS) > 0) {
            return TimeUnit.MICROSECONDS;
        }
        return TimeUnit.NANOSECONDS;
    }

    public static p c() {
        p pVar = new p();
        pVar.g();
        return pVar;
    }

    public static p d() {
        return new p();
    }

    public long e(TimeUnit timeUnit) {
        return timeUnit.convert(f(), TimeUnit.NANOSECONDS);
    }

    public final long f() {
        return this.f66951b ? (this.f66950a.a() - this.f66953d) + this.f66952c : this.f66952c;
    }

    public p g() {
        n.x(!this.f66951b, "This stopwatch is already running.");
        this.f66951b = true;
        this.f66953d = this.f66950a.a();
        return this;
    }

    public p h() {
        long a2 = this.f66950a.a();
        n.x(this.f66951b, "This stopwatch is already stopped.");
        this.f66951b = false;
        this.f66952c += a2 - this.f66953d;
        return this;
    }

    public String toString() {
        long f2 = f();
        TimeUnit b2 = b(f2);
        double convert = f2 / TimeUnit.NANOSECONDS.convert(1L, b2);
        return m.b(convert) + " " + a(b2);
    }
}
