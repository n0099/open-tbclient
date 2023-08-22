package kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement;

import java.util.Set;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.collections.SetsKt___SetsKt;
import kotlin.jvm.internal.Intrinsics;
/* loaded from: classes2.dex */
public final class SignatureEnhancementKt {
    public static final JavaTypeQualifiers createJavaTypeQualifiers(NullabilityQualifier nullabilityQualifier, MutabilityQualifier mutabilityQualifier, boolean z, boolean z2) {
        if (z2 && nullabilityQualifier == NullabilityQualifier.NOT_NULL) {
            return new JavaTypeQualifiers(nullabilityQualifier, mutabilityQualifier, true, z);
        }
        return new JavaTypeQualifiers(nullabilityQualifier, mutabilityQualifier, false, z);
    }

    public static final <T> T select(Set<? extends T> set, T t, T t2, T t3, boolean z) {
        Set<? extends T> set2;
        T t4;
        if (z) {
            if (set.contains(t)) {
                t4 = t;
            } else if (set.contains(t2)) {
                t4 = t2;
            } else {
                t4 = null;
            }
            if (Intrinsics.areEqual(t4, t) && Intrinsics.areEqual(t3, t2)) {
                return null;
            }
            if (t3 == null) {
                return t4;
            }
            return t3;
        }
        if (t3 != null && (set2 = CollectionsKt___CollectionsKt.toSet(SetsKt___SetsKt.plus(set, t3))) != null) {
            set = set2;
        }
        return (T) CollectionsKt___CollectionsKt.singleOrNull(set);
    }

    public static final NullabilityQualifier select(Set<? extends NullabilityQualifier> set, NullabilityQualifier nullabilityQualifier, boolean z) {
        NullabilityQualifier nullabilityQualifier2 = NullabilityQualifier.FORCE_FLEXIBILITY;
        if (nullabilityQualifier != nullabilityQualifier2) {
            return (NullabilityQualifier) select(set, NullabilityQualifier.NOT_NULL, NullabilityQualifier.NULLABLE, nullabilityQualifier, z);
        }
        return nullabilityQualifier2;
    }
}
