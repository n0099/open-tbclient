package kotlin.time;

import com.meizu.cloud.pushsdk.notification.model.NotificationStyle;
import java.util.concurrent.TimeUnit;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.SinceKotlin;
import kotlin.time.DurationUnitKt;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\u001a\u0017\u0010\u0003\u001a\u00020\u0002*\u00060\u0000j\u0002`\u0001H\u0001¢\u0006\u0004\b\u0003\u0010\u0004¨\u0006\u0005"}, d2 = {"Ljava/util/concurrent/TimeUnit;", "Lkotlin/time/DurationUnit;", "", "shortName", "(Ljava/util/concurrent/TimeUnit;)Ljava/lang/String;", "kotlin-stdlib"}, k = 5, mv = {1, 1, 15}, pn = "", xi = 0, xs = "kotlin/time/DurationUnitKt")
/* loaded from: classes7.dex */
public class DurationUnitKt__DurationUnitKt extends DurationUnitKt__DurationUnitJvmKt {
    @SinceKotlin(version = "1.3")
    @ExperimentalTime
    public static final String shortName(TimeUnit timeUnit) {
        switch (DurationUnitKt.WhenMappings.$EnumSwitchMapping$0[timeUnit.ordinal()]) {
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
                throw new NoWhenBranchMatchedException();
        }
    }
}
