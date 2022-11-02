package kotlin.random;

import kotlin.Metadata;
import kotlin.SinceKotlin;
import kotlin.internal.InlineOnly;
import kotlin.internal.PlatformImplementationsKt;
import kotlin.jvm.internal.Intrinsics;
@Metadata(d1 = {"\u0000\u001e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0006\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a\t\u0010\u0000\u001a\u00020\u0001H\u0081\b\u001a\u0018\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0005H\u0000\u001a\f\u0010\u0007\u001a\u00020\b*\u00020\u0001H\u0007\u001a\f\u0010\t\u001a\u00020\u0001*\u00020\bH\u0007¨\u0006\n"}, d2 = {"defaultPlatformRandom", "Lkotlin/random/Random;", "doubleFromParts", "", "hi26", "", "low27", "asJavaRandom", "Ljava/util/Random;", "asKotlinRandom", "kotlin-stdlib"}, k = 2, mv = {1, 5, 1})
/* loaded from: classes8.dex */
public final class PlatformRandomKt {
    public static final double doubleFromParts(int i, int i2) {
        return ((i << 27) + i2) / 9007199254740992L;
    }

    @SinceKotlin(version = "1.3")
    public static final java.util.Random asJavaRandom(Random asJavaRandom) {
        Random random;
        java.util.Random impl;
        Intrinsics.checkNotNullParameter(asJavaRandom, "$this$asJavaRandom");
        if (!(asJavaRandom instanceof AbstractPlatformRandom)) {
            random = null;
        } else {
            random = asJavaRandom;
        }
        AbstractPlatformRandom abstractPlatformRandom = (AbstractPlatformRandom) random;
        if (abstractPlatformRandom == null || (impl = abstractPlatformRandom.getImpl()) == null) {
            return new KotlinRandom(asJavaRandom);
        }
        return impl;
    }

    @SinceKotlin(version = "1.3")
    public static final Random asKotlinRandom(java.util.Random asKotlinRandom) {
        java.util.Random random;
        Random impl;
        Intrinsics.checkNotNullParameter(asKotlinRandom, "$this$asKotlinRandom");
        if (!(asKotlinRandom instanceof KotlinRandom)) {
            random = null;
        } else {
            random = asKotlinRandom;
        }
        KotlinRandom kotlinRandom = (KotlinRandom) random;
        if (kotlinRandom == null || (impl = kotlinRandom.getImpl()) == null) {
            return new PlatformRandom(asKotlinRandom);
        }
        return impl;
    }

    @InlineOnly
    public static final Random defaultPlatformRandom() {
        return PlatformImplementationsKt.IMPLEMENTATIONS.defaultPlatformRandom();
    }
}
