package kotlin.coroutines.jvm.internal;

import kotlin.Metadata;
import kotlin.PublishedApi;
import kotlin.SinceKotlin;
import kotlin.jvm.JvmName;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000b\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\f\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\n\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a\u0017\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000H\u0001¢\u0006\u0004\b\u0003\u0010\u0004\u001a\u0017\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0001\u001a\u00020\u0005H\u0001¢\u0006\u0004\b\u0007\u0010\b\u001a\u0017\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0001\u001a\u00020\tH\u0001¢\u0006\u0004\b\u000b\u0010\f\u001a\u0017\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u0001\u001a\u00020\rH\u0001¢\u0006\u0004\b\u000f\u0010\u0010\u001a\u0017\u0010\u0013\u001a\u00020\u00122\u0006\u0010\u0001\u001a\u00020\u0011H\u0001¢\u0006\u0004\b\u0013\u0010\u0014\u001a\u0017\u0010\u0017\u001a\u00020\u00162\u0006\u0010\u0001\u001a\u00020\u0015H\u0001¢\u0006\u0004\b\u0017\u0010\u0018\u001a\u0017\u0010\u001b\u001a\u00020\u001a2\u0006\u0010\u0001\u001a\u00020\u0019H\u0001¢\u0006\u0004\b\u001b\u0010\u001c\u001a\u0017\u0010\u001f\u001a\u00020\u001e2\u0006\u0010\u0001\u001a\u00020\u001dH\u0001¢\u0006\u0004\b\u001f\u0010 ¨\u0006!"}, d2 = {"", "primitive", "Ljava/lang/Boolean;", "boxBoolean", "(Z)Ljava/lang/Boolean;", "", "Ljava/lang/Byte;", "boxByte", "(B)Ljava/lang/Byte;", "", "Ljava/lang/Character;", "boxChar", "(C)Ljava/lang/Character;", "", "Ljava/lang/Double;", "boxDouble", "(D)Ljava/lang/Double;", "", "Ljava/lang/Float;", "boxFloat", "(F)Ljava/lang/Float;", "", "Ljava/lang/Integer;", "boxInt", "(I)Ljava/lang/Integer;", "", "Ljava/lang/Long;", "boxLong", "(J)Ljava/lang/Long;", "", "Ljava/lang/Short;", "boxShort", "(S)Ljava/lang/Short;", "kotlin-stdlib"}, k = 2, mv = {1, 1, 15}, pn = "", xi = 0, xs = "")
@JvmName(name = "Boxing")
/* loaded from: classes2.dex */
public final class Boxing {
    @SinceKotlin(version = "1.3")
    @PublishedApi
    public static final Boolean boxBoolean(boolean z) {
        return Boolean.valueOf(z);
    }

    @SinceKotlin(version = "1.3")
    @PublishedApi
    public static final Byte boxByte(byte b2) {
        return Byte.valueOf(b2);
    }

    @SinceKotlin(version = "1.3")
    @PublishedApi
    public static final Character boxChar(char c2) {
        return new Character(c2);
    }

    @SinceKotlin(version = "1.3")
    @PublishedApi
    public static final Double boxDouble(double d2) {
        return new Double(d2);
    }

    @SinceKotlin(version = "1.3")
    @PublishedApi
    public static final Float boxFloat(float f2) {
        return new Float(f2);
    }

    @SinceKotlin(version = "1.3")
    @PublishedApi
    public static final Integer boxInt(int i2) {
        return new Integer(i2);
    }

    @SinceKotlin(version = "1.3")
    @PublishedApi
    public static final Long boxLong(long j2) {
        return new Long(j2);
    }

    @SinceKotlin(version = "1.3")
    @PublishedApi
    public static final Short boxShort(short s) {
        return new Short(s);
    }
}
