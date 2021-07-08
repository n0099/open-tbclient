package kotlin.random;

import kotlin.Metadata;
import kotlin.SinceKotlin;
import kotlin.internal.InlineOnly;
import kotlin.internal.PlatformImplementationsKt;
import kotlin.jvm.internal.Intrinsics;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0006\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\u001a\u0010\u0010\u0001\u001a\u00020\u0000H\u0081\b¢\u0006\u0004\b\u0001\u0010\u0002\u001a\u001f\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u0003H\u0000¢\u0006\u0004\b\u0007\u0010\b\u001a\u0013\u0010\n\u001a\u00020\t*\u00020\u0000H\u0007¢\u0006\u0004\b\n\u0010\u000b\u001a\u0013\u0010\f\u001a\u00020\u0000*\u00020\tH\u0007¢\u0006\u0004\b\f\u0010\r¨\u0006\u000e"}, d2 = {"Lkotlin/random/Random;", "defaultPlatformRandom", "()Lkotlin/random/Random;", "", "hi26", "low27", "", "doubleFromParts", "(II)D", "Ljava/util/Random;", "asJavaRandom", "(Lkotlin/random/Random;)Ljava/util/Random;", "asKotlinRandom", "(Ljava/util/Random;)Lkotlin/random/Random;", "kotlin-stdlib"}, k = 2, mv = {1, 1, 15}, pn = "", xi = 0, xs = "")
/* loaded from: classes9.dex */
public final class PlatformRandomKt {
    @SinceKotlin(version = "1.3")
    public static final java.util.Random asJavaRandom(Random asJavaRandom) {
        java.util.Random impl;
        Intrinsics.checkNotNullParameter(asJavaRandom, "$this$asJavaRandom");
        AbstractPlatformRandom abstractPlatformRandom = (AbstractPlatformRandom) (!(asJavaRandom instanceof AbstractPlatformRandom) ? null : asJavaRandom);
        return (abstractPlatformRandom == null || (impl = abstractPlatformRandom.getImpl()) == null) ? new KotlinRandom(asJavaRandom) : impl;
    }

    @SinceKotlin(version = "1.3")
    public static final Random asKotlinRandom(java.util.Random asKotlinRandom) {
        Random impl;
        Intrinsics.checkNotNullParameter(asKotlinRandom, "$this$asKotlinRandom");
        KotlinRandom kotlinRandom = (KotlinRandom) (!(asKotlinRandom instanceof KotlinRandom) ? null : asKotlinRandom);
        return (kotlinRandom == null || (impl = kotlinRandom.getImpl()) == null) ? new PlatformRandom(asKotlinRandom) : impl;
    }

    @InlineOnly
    public static final Random defaultPlatformRandom() {
        return PlatformImplementationsKt.IMPLEMENTATIONS.defaultPlatformRandom();
    }

    public static final double doubleFromParts(int i2, int i3) {
        return ((i2 << 27) + i3) / 9007199254740992L;
    }
}
