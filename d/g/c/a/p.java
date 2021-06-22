package d.g.c.a;

import com.meizu.cloud.pushsdk.notification.model.NotificationStyle;
import java.util.concurrent.TimeUnit;
/* loaded from: classes6.dex */
public final class p {

    /* renamed from: a  reason: collision with root package name */
    public final t f70076a = t.b();

    /* renamed from: b  reason: collision with root package name */
    public boolean f70077b;

    /* renamed from: c  reason: collision with root package name */
    public long f70078c;

    /* renamed from: d  reason: collision with root package name */
    public long f70079d;

    /* loaded from: classes6.dex */
    public static /* synthetic */ class a {

        /* renamed from: a  reason: collision with root package name */
        public static final /* synthetic */ int[] f70080a;

        static {
            int[] iArr = new int[TimeUnit.values().length];
            f70080a = iArr;
            try {
                iArr[TimeUnit.NANOSECONDS.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f70080a[TimeUnit.MICROSECONDS.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f70080a[TimeUnit.MILLISECONDS.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f70080a[TimeUnit.SECONDS.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f70080a[TimeUnit.MINUTES.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                f70080a[TimeUnit.HOURS.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                f70080a[TimeUnit.DAYS.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
        }
    }

    public static String a(TimeUnit timeUnit) {
        switch (a.f70080a[timeUnit.ordinal()]) {
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
        return this.f70077b ? (this.f70076a.a() - this.f70079d) + this.f70078c : this.f70078c;
    }

    public p g() {
        n.x(!this.f70077b, "This stopwatch is already running.");
        this.f70077b = true;
        this.f70079d = this.f70076a.a();
        return this;
    }

    public p h() {
        long a2 = this.f70076a.a();
        n.x(this.f70077b, "This stopwatch is already stopped.");
        this.f70077b = false;
        this.f70078c += a2 - this.f70079d;
        return this;
    }

    public String toString() {
        long f2 = f();
        TimeUnit b2 = b(f2);
        double convert = f2 / TimeUnit.NANOSECONDS.convert(1L, b2);
        return m.b(convert) + " " + a(b2);
    }
}
