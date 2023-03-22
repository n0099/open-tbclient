package kotlin.reflect.jvm.internal.impl.types.checker;

import kotlin.reflect.jvm.internal.impl.types.AbstractNullabilityChecker;
import kotlin.reflect.jvm.internal.impl.types.AbstractTypeCheckerContext;
import kotlin.reflect.jvm.internal.impl.types.FlexibleTypesKt;
import kotlin.reflect.jvm.internal.impl.types.UnwrappedType;
/* loaded from: classes9.dex */
public final class NullabilityChecker {
    public static final NullabilityChecker INSTANCE = new NullabilityChecker();

    public final boolean isSubtypeOfAny(UnwrappedType unwrappedType) {
        return AbstractNullabilityChecker.INSTANCE.hasNotNullSupertype(SimpleClassicTypeSystemContext.INSTANCE.newBaseTypeCheckerContext(false, true), FlexibleTypesKt.lowerIfFlexible(unwrappedType), AbstractTypeCheckerContext.SupertypesPolicy.LowerIfFlexible.INSTANCE);
    }
}
