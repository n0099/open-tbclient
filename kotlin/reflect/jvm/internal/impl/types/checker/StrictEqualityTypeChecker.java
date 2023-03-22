package kotlin.reflect.jvm.internal.impl.types.checker;

import kotlin.reflect.jvm.internal.impl.types.AbstractStrictEqualityTypeChecker;
import kotlin.reflect.jvm.internal.impl.types.UnwrappedType;
/* loaded from: classes9.dex */
public final class StrictEqualityTypeChecker {
    public static final StrictEqualityTypeChecker INSTANCE = new StrictEqualityTypeChecker();

    public final boolean strictEqualTypes(UnwrappedType unwrappedType, UnwrappedType unwrappedType2) {
        return AbstractStrictEqualityTypeChecker.INSTANCE.strictEqualTypes(SimpleClassicTypeSystemContext.INSTANCE, unwrappedType, unwrappedType2);
    }
}
