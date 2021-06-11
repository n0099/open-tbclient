package e.a;

import android.os.SystemClock;
import java.util.Locale;
import java.util.concurrent.TimeUnit;
/* loaded from: classes7.dex */
public class d {

    /* renamed from: a  reason: collision with root package name */
    public final TimeUnit f71500a;

    /* renamed from: b  reason: collision with root package name */
    public long f71501b = SystemClock.elapsedRealtime();

    /* renamed from: c  reason: collision with root package name */
    public long f71502c = 0;

    public d(TimeUnit timeUnit) {
        this.f71500a = timeUnit;
    }

    /* JADX WARN: Removed duplicated region for block: B:22:0x0047 A[Catch: Exception -> 0x0063, TryCatch #0 {Exception -> 0x0063, blocks: (B:7:0x0019, B:9:0x001f, B:22:0x0047, B:23:0x004c, B:10:0x0021, B:12:0x0029, B:13:0x002c, B:15:0x0034, B:16:0x0036, B:17:0x0038, B:19:0x003e, B:25:0x005e), top: B:30:0x000f }] */
    /* JADX WARN: Removed duplicated region for block: B:23:0x004c A[Catch: Exception -> 0x0063, TryCatch #0 {Exception -> 0x0063, blocks: (B:7:0x0019, B:9:0x001f, B:22:0x0047, B:23:0x004c, B:10:0x0021, B:12:0x0029, B:13:0x002c, B:15:0x0034, B:16:0x0036, B:17:0x0038, B:19:0x003e, B:25:0x005e), top: B:30:0x000f }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public String a() {
        float f2;
        float f3;
        long elapsedRealtime = (SystemClock.elapsedRealtime() - this.f71501b) + this.f71502c;
        try {
            if (elapsedRealtime >= 0 && elapsedRealtime <= 86400000) {
                if (this.f71500a != TimeUnit.MILLISECONDS) {
                    if (this.f71500a == TimeUnit.SECONDS) {
                        f3 = ((float) elapsedRealtime) / 1000.0f;
                    } else {
                        if (this.f71500a == TimeUnit.MINUTES) {
                            f2 = ((float) elapsedRealtime) / 1000.0f;
                        } else if (this.f71500a == TimeUnit.HOURS) {
                            f2 = (((float) elapsedRealtime) / 1000.0f) / 60.0f;
                        }
                        f3 = f2 / 60.0f;
                    }
                    return f3 >= 0.0f ? String.valueOf(0) : String.format(Locale.CHINA, "%.3f", Float.valueOf(f3));
                }
                f3 = (float) elapsedRealtime;
                if (f3 >= 0.0f) {
                }
            } else {
                return String.valueOf(0);
            }
        } catch (Exception e2) {
            e2.printStackTrace();
            return String.valueOf(0);
        }
    }

    public long b() {
        return this.f71502c;
    }

    public long c() {
        return this.f71501b;
    }

    public void d(long j) {
        this.f71502c = j;
    }

    public void e(long j) {
        this.f71501b = j;
    }
}
