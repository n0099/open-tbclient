package kotlin.reflect.jvm.internal.impl.types;

import kotlin._Assertions;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.descriptors.TypeParameterDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.Annotations;
import kotlin.reflect.jvm.internal.impl.types.checker.NewTypeVariableConstructor;
import kotlin.reflect.jvm.internal.impl.types.checker.NullabilityChecker;
import kotlin.reflect.jvm.internal.impl.types.model.DefinitelyNotNullTypeMarker;
import kotlin.reflect.jvm.internal.impl.types.typeUtil.TypeUtilsKt;
/* loaded from: classes9.dex */
public final class DefinitelyNotNullType extends DelegatingSimpleType implements CustomTypeVariable, DefinitelyNotNullTypeMarker {
    public static final Companion Companion = new Companion(null);
    public final SimpleType original;

    @Override // kotlin.reflect.jvm.internal.impl.types.DelegatingSimpleType, kotlin.reflect.jvm.internal.impl.types.KotlinType
    public boolean isMarkedNullable() {
        return false;
    }

    /* loaded from: classes9.dex */
    public static final class Companion {
        public Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private final boolean makesSenseToBeDefinitelyNotNull(UnwrappedType unwrappedType) {
            if (TypeUtilsKt.canHaveUndefinedNullability(unwrappedType) && !NullabilityChecker.INSTANCE.isSubtypeOfAny(unwrappedType)) {
                return true;
            }
            return false;
        }

        public final DefinitelyNotNullType makeDefinitelyNotNull$descriptors(UnwrappedType unwrappedType) {
            if (unwrappedType instanceof DefinitelyNotNullType) {
                return (DefinitelyNotNullType) unwrappedType;
            }
            if (!makesSenseToBeDefinitelyNotNull(unwrappedType)) {
                return null;
            }
            if (unwrappedType instanceof FlexibleType) {
                FlexibleType flexibleType = (FlexibleType) unwrappedType;
                boolean areEqual = Intrinsics.areEqual(flexibleType.getLowerBound().getConstructor(), flexibleType.getUpperBound().getConstructor());
                if (_Assertions.ENABLED && !areEqual) {
                    throw new AssertionError("DefinitelyNotNullType for flexible type (" + unwrappedType + ") can be created only from type variable with the same constructor for bounds");
                }
            }
            return new DefinitelyNotNullType(FlexibleTypesKt.lowerIfFlexible(unwrappedType), null);
        }
    }

    public DefinitelyNotNullType(SimpleType simpleType) {
        this.original = simpleType;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // kotlin.reflect.jvm.internal.impl.types.UnwrappedType
    public SimpleType makeNullableAsSpecified(boolean z) {
        if (z) {
            return getDelegate().makeNullableAsSpecified(z);
        }
        return this;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // kotlin.reflect.jvm.internal.impl.types.UnwrappedType
    public DefinitelyNotNullType replaceAnnotations(Annotations annotations) {
        return new DefinitelyNotNullType(getDelegate().replaceAnnotations(annotations));
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // kotlin.reflect.jvm.internal.impl.types.DelegatingSimpleType
    public DefinitelyNotNullType replaceDelegate(SimpleType simpleType) {
        return new DefinitelyNotNullType(simpleType);
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.CustomTypeVariable
    public KotlinType substitutionResult(KotlinType kotlinType) {
        return SpecialTypesKt.makeDefinitelyNotNullOrNotNull(kotlinType.unwrap());
    }

    public /* synthetic */ DefinitelyNotNullType(SimpleType simpleType, DefaultConstructorMarker defaultConstructorMarker) {
        this(simpleType);
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.DelegatingSimpleType
    public SimpleType getDelegate() {
        return this.original;
    }

    public final SimpleType getOriginal() {
        return this.original;
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.CustomTypeVariable
    public boolean isTypeVariable() {
        if (!(getDelegate().getConstructor() instanceof NewTypeVariableConstructor) && !(getDelegate().getConstructor().mo2023getDeclarationDescriptor() instanceof TypeParameterDescriptor)) {
            return false;
        }
        return true;
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.SimpleType
    public String toString() {
        return getDelegate() + "!!";
    }
}
