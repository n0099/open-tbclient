package kotlin.time;

import androidx.exifinterface.media.ExifInterface;
import com.baidu.tbadk.core.data.SmallTailInfo;
import kotlin.Metadata;
import kotlin.SinceKotlin;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
@SinceKotlin(version = "1.3")
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\t\b\u0087\b\u0018\u0000*\u0004\b\u0000\u0010\u0001B\u001a\u0012\u0006\u0010\u0007\u001a\u00028\u0000\u0012\u0006\u0010\b\u001a\u00020\u0004ø\u0001\u0000¢\u0006\u0004\b\u001b\u0010\u001cJ\u0010\u0010\u0002\u001a\u00028\u0000HÆ\u0003¢\u0006\u0004\b\u0002\u0010\u0003J\u0013\u0010\u0005\u001a\u00020\u0004HÆ\u0003ø\u0001\u0000¢\u0006\u0004\b\u0005\u0010\u0006J-\u0010\u000b\u001a\b\u0012\u0004\u0012\u00028\u00000\u00002\b\b\u0002\u0010\u0007\u001a\u00028\u00002\b\b\u0002\u0010\b\u001a\u00020\u0004HÆ\u0001ø\u0001\u0000¢\u0006\u0004\b\t\u0010\nJ\u001a\u0010\u000f\u001a\u00020\u000e2\b\u0010\r\u001a\u0004\u0018\u00010\fHÖ\u0003¢\u0006\u0004\b\u000f\u0010\u0010J\u0010\u0010\u0012\u001a\u00020\u0011HÖ\u0001¢\u0006\u0004\b\u0012\u0010\u0013J\u0010\u0010\u0015\u001a\u00020\u0014HÖ\u0001¢\u0006\u0004\b\u0015\u0010\u0016R\u001c\u0010\b\u001a\u00020\u00048\u0006@\u0006ø\u0001\u0000¢\u0006\f\n\u0004\b\b\u0010\u0017\u001a\u0004\b\u0018\u0010\u0006R\u0019\u0010\u0007\u001a\u00028\u00008\u0006@\u0006¢\u0006\f\n\u0004\b\u0007\u0010\u0019\u001a\u0004\b\u001a\u0010\u0003\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006\u001d"}, d2 = {"Lkotlin/time/TimedValue;", ExifInterface.GPS_DIRECTION_TRUE, "component1", "()Ljava/lang/Object;", "Lkotlin/time/Duration;", "component2", "()D", "value", "duration", "copy-RFiDyg4", "(Ljava/lang/Object;D)Lkotlin/time/TimedValue;", "copy", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "", "hashCode", "()I", "", "toString", "()Ljava/lang/String;", "D", "getDuration", "Ljava/lang/Object;", "getValue", "<init>", "(Ljava/lang/Object;DLkotlin/jvm/internal/DefaultConstructorMarker;)V", "kotlin-stdlib"}, k = 1, mv = {1, 1, 15}, pn = "", xi = 0, xs = "")
@ExperimentalTime
/* loaded from: classes7.dex */
public final class TimedValue<T> {
    public final double duration;
    public final T value;

    public TimedValue(T t, double d2) {
        this.value = t;
        this.duration = d2;
    }

    /* JADX DEBUG: Multi-variable search result rejected for r0v0, resolved type: kotlin.time.TimedValue */
    /* JADX WARN: Multi-variable type inference failed */
    /* renamed from: copy-RFiDyg4$default  reason: not valid java name */
    public static /* synthetic */ TimedValue m1602copyRFiDyg4$default(TimedValue timedValue, Object obj, double d2, int i, Object obj2) {
        if ((i & 1) != 0) {
            obj = timedValue.value;
        }
        if ((i & 2) != 0) {
            d2 = timedValue.duration;
        }
        return timedValue.m1603copyRFiDyg4(obj, d2);
    }

    public final T component1() {
        return this.value;
    }

    public final double component2() {
        return this.duration;
    }

    /* renamed from: copy-RFiDyg4  reason: not valid java name */
    public final TimedValue<T> m1603copyRFiDyg4(T t, double d2) {
        return new TimedValue<>(t, d2);
    }

    public boolean equals(Object obj) {
        if (this != obj) {
            if (obj instanceof TimedValue) {
                TimedValue timedValue = (TimedValue) obj;
                return Intrinsics.areEqual(this.value, timedValue.value) && Double.compare(this.duration, timedValue.duration) == 0;
            }
            return false;
        }
        return true;
    }

    public final double getDuration() {
        return this.duration;
    }

    public final T getValue() {
        return this.value;
    }

    public int hashCode() {
        T t = this.value;
        int hashCode = t != null ? t.hashCode() : 0;
        long doubleToLongBits = Double.doubleToLongBits(this.duration);
        return (hashCode * 31) + ((int) (doubleToLongBits ^ (doubleToLongBits >>> 32)));
    }

    public String toString() {
        return "TimedValue(value=" + this.value + ", duration=" + Duration.m1592toStringimpl(this.duration) + SmallTailInfo.EMOTION_SUFFIX;
    }

    public /* synthetic */ TimedValue(Object obj, double d2, DefaultConstructorMarker defaultConstructorMarker) {
        this(obj, d2);
    }
}
