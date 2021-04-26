package d.g.c.a;

import com.meizu.cloud.pushsdk.notification.model.NotificationStyle;
import java.util.concurrent.TimeUnit;
/* loaded from: classes6.dex */
public final class p {

    /* renamed from: a  reason: collision with root package name */
    public final t f65512a = t.b();

    /* renamed from: b  reason: collision with root package name */
    public boolean f65513b;

    /* renamed from: c  reason: collision with root package name */
    public long f65514c;

    /* renamed from: d  reason: collision with root package name */
    public long f65515d;

    /* loaded from: classes6.dex */
    public static /* synthetic */ class a {

        /* renamed from: a  reason: collision with root package name */
        public static final /* synthetic */ int[] f65516a;

        static {
            int[] iArr = new int[TimeUnit.values().length];
            f65516a = iArr;
            try {
                iArr[TimeUnit.NANOSECONDS.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f65516a[TimeUnit.MICROSECONDS.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f65516a[TimeUnit.MILLISECONDS.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f65516a[TimeUnit.SECONDS.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f65516a[TimeUnit.MINUTES.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                f65516a[TimeUnit.HOURS.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                f65516a[TimeUnit.DAYS.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
        }
    }

    public static String a(TimeUnit timeUnit) {
        switch (a.f65516a[timeUnit.ordinal()]) {
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
        return this.f65513b ? (this.f65512a.a() - this.f65515d) + this.f65514c : this.f65514c;
    }

    public p g() {
        n.x(!this.f65513b, "This stopwatch is already running.");
        this.f65513b = true;
        this.f65515d = this.f65512a.a();
        return this;
    }

    public p h() {
        long a2 = this.f65512a.a();
        n.x(this.f65513b, "This stopwatch is already stopped.");
        this.f65513b = false;
        this.f65514c += a2 - this.f65515d;
        return this;
    }

    public String toString() {
        long f2 = f();
        TimeUnit b2 = b(f2);
        double convert = f2 / TimeUnit.NANOSECONDS.convert(1L, b2);
        return m.b(convert) + " " + a(b2);
    }
}
