package kotlin.time;

import com.meizu.cloud.pushsdk.notification.model.NotificationStyle;
import java.util.concurrent.TimeUnit;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.time.DurationUnitKt;
@Metadata(d1 = {"\u0000 \n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\f\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\u001a\u001c\u0010\u0000\u001a\u00060\u0001j\u0002`\u00022\u0006\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0001\u001a\u0014\u0010\u0007\u001a\u00060\u0001j\u0002`\u00022\u0006\u0010\b\u001a\u00020\tH\u0001\u001a\u0010\u0010\b\u001a\u00020\t*\u00060\u0001j\u0002`\u0002H\u0001¨\u0006\n"}, d2 = {"durationUnitByIsoChar", "Ljava/util/concurrent/TimeUnit;", "Lkotlin/time/DurationUnit;", "isoChar", "", "isTimeComponent", "", "durationUnitByShortName", "shortName", "", "kotlin-stdlib"}, k = 5, mv = {1, 5, 1}, xi = 1, xs = "kotlin/time/DurationUnitKt")
/* loaded from: classes8.dex */
public class DurationUnitKt__DurationUnitKt extends DurationUnitKt__DurationUnitJvmKt {
    public static final TimeUnit durationUnitByIsoChar(char c, boolean z) {
        if (!z) {
            if (c == 'D') {
                return TimeUnit.DAYS;
            }
            throw new IllegalArgumentException("Invalid or unsupported duration ISO non-time unit: " + c);
        } else if (c != 'H') {
            if (c != 'M') {
                if (c == 'S') {
                    return TimeUnit.SECONDS;
                }
                throw new IllegalArgumentException("Invalid duration ISO time unit: " + c);
            }
            return TimeUnit.MINUTES;
        } else {
            return TimeUnit.HOURS;
        }
    }

    public static final TimeUnit durationUnitByShortName(String shortName) {
        Intrinsics.checkNotNullParameter(shortName, "shortName");
        int hashCode = shortName.hashCode();
        if (hashCode != 100) {
            if (hashCode != 104) {
                if (hashCode != 109) {
                    if (hashCode != 115) {
                        if (hashCode != 3494) {
                            if (hashCode != 3525) {
                                if (hashCode == 3742 && shortName.equals("us")) {
                                    return TimeUnit.MICROSECONDS;
                                }
                            } else if (shortName.equals(NotificationStyle.NOTIFICATION_STYLE)) {
                                return TimeUnit.NANOSECONDS;
                            }
                        } else if (shortName.equals("ms")) {
                            return TimeUnit.MILLISECONDS;
                        }
                    } else if (shortName.equals("s")) {
                        return TimeUnit.SECONDS;
                    }
                } else if (shortName.equals("m")) {
                    return TimeUnit.MINUTES;
                }
            } else if (shortName.equals("h")) {
                return TimeUnit.HOURS;
            }
        } else if (shortName.equals("d")) {
            return TimeUnit.DAYS;
        }
        throw new IllegalArgumentException("Unknown duration unit short name: " + shortName);
    }

    public static final String shortName(TimeUnit shortName) {
        Intrinsics.checkNotNullParameter(shortName, "$this$shortName");
        switch (DurationUnitKt.WhenMappings.$EnumSwitchMapping$0[shortName.ordinal()]) {
            case 1:
                return NotificationStyle.NOTIFICATION_STYLE;
            case 2:
                return "us";
            case 3:
                return "ms";
            case 4:
                return "s";
            case 5:
                return "m";
            case 6:
                return "h";
            case 7:
                return "d";
            default:
                throw new IllegalStateException(("Unknown unit: " + shortName).toString());
        }
    }
}
