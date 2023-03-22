package kotlin.reflect.jvm.internal.impl.types;

import com.baidu.android.common.others.IStringUtil;
import kotlin.NoWhenBranchMatchedException;
import kotlin.TypeCastException;
import kotlin._Assertions;
import kotlin.jvm.JvmField;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.descriptors.TypeParameterDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.Annotations;
import kotlin.reflect.jvm.internal.impl.renderer.DescriptorRenderer;
import kotlin.reflect.jvm.internal.impl.renderer.DescriptorRendererOptions;
import kotlin.reflect.jvm.internal.impl.types.checker.KotlinTypeChecker;
import kotlin.reflect.jvm.internal.impl.types.checker.KotlinTypeRefiner;
import kotlin.reflect.jvm.internal.impl.types.typeUtil.TypeUtilsKt;
/* loaded from: classes9.dex */
public final class FlexibleTypeImpl extends FlexibleType implements CustomTypeVariable {
    public static final Companion Companion = new Companion(null);
    @JvmField
    public static boolean RUN_SLOW_ASSERTIONS;
    public boolean assertionsDone;

    /* loaded from: classes9.dex */
    public static final class Companion {
        public Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public FlexibleTypeImpl(SimpleType simpleType, SimpleType simpleType2) {
        super(simpleType, simpleType2);
    }

    private final void runAssertions() {
        if (RUN_SLOW_ASSERTIONS && !this.assertionsDone) {
            this.assertionsDone = true;
            boolean z = !FlexibleTypesKt.isFlexible(getLowerBound());
            if (_Assertions.ENABLED && !z) {
                throw new AssertionError("Lower bound of a flexible type can not be flexible: " + getLowerBound());
            }
            boolean z2 = !FlexibleTypesKt.isFlexible(getUpperBound());
            if (_Assertions.ENABLED && !z2) {
                throw new AssertionError("Upper bound of a flexible type can not be flexible: " + getUpperBound());
            }
            boolean areEqual = true ^ Intrinsics.areEqual(getLowerBound(), getUpperBound());
            if (_Assertions.ENABLED && !areEqual) {
                throw new AssertionError("Lower and upper bounds are equal: " + getLowerBound() + " == " + getUpperBound());
            }
            boolean isSubtypeOf = KotlinTypeChecker.DEFAULT.isSubtypeOf(getLowerBound(), getUpperBound());
            if (_Assertions.ENABLED && !isSubtypeOf) {
                throw new AssertionError("Lower bound " + getLowerBound() + " of a flexible type must be a subtype of the upper bound " + getUpperBound());
            }
        }
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.FlexibleType
    public SimpleType getDelegate() {
        runAssertions();
        return getLowerBound();
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.CustomTypeVariable
    public boolean isTypeVariable() {
        if ((getLowerBound().getConstructor().mo2023getDeclarationDescriptor() instanceof TypeParameterDescriptor) && Intrinsics.areEqual(getLowerBound().getConstructor(), getUpperBound().getConstructor())) {
            return true;
        }
        return false;
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.UnwrappedType
    public UnwrappedType makeNullableAsSpecified(boolean z) {
        return KotlinTypeFactory.flexibleType(getLowerBound().makeNullableAsSpecified(z), getUpperBound().makeNullableAsSpecified(z));
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // kotlin.reflect.jvm.internal.impl.types.UnwrappedType, kotlin.reflect.jvm.internal.impl.types.KotlinType
    public FlexibleType refine(KotlinTypeRefiner kotlinTypeRefiner) {
        KotlinType refineType = kotlinTypeRefiner.refineType(getLowerBound());
        if (refineType != null) {
            SimpleType simpleType = (SimpleType) refineType;
            KotlinType refineType2 = kotlinTypeRefiner.refineType(getUpperBound());
            if (refineType2 != null) {
                return new FlexibleTypeImpl(simpleType, (SimpleType) refineType2);
            }
            throw new TypeCastException("null cannot be cast to non-null type org.jetbrains.kotlin.types.SimpleType");
        }
        throw new TypeCastException("null cannot be cast to non-null type org.jetbrains.kotlin.types.SimpleType");
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.UnwrappedType
    public UnwrappedType replaceAnnotations(Annotations annotations) {
        return KotlinTypeFactory.flexibleType(getLowerBound().replaceAnnotations(annotations), getUpperBound().replaceAnnotations(annotations));
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.CustomTypeVariable
    public KotlinType substitutionResult(KotlinType kotlinType) {
        UnwrappedType flexibleType;
        UnwrappedType unwrap = kotlinType.unwrap();
        if (unwrap instanceof FlexibleType) {
            flexibleType = unwrap;
        } else if (unwrap instanceof SimpleType) {
            SimpleType simpleType = (SimpleType) unwrap;
            flexibleType = KotlinTypeFactory.flexibleType(simpleType, simpleType.makeNullableAsSpecified(true));
        } else {
            throw new NoWhenBranchMatchedException();
        }
        return TypeWithEnhancementKt.inheritEnhancement(flexibleType, unwrap);
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.FlexibleType
    public String render(DescriptorRenderer descriptorRenderer, DescriptorRendererOptions descriptorRendererOptions) {
        if (descriptorRendererOptions.getDebugMode()) {
            return '(' + descriptorRenderer.renderType(getLowerBound()) + IStringUtil.TOP_PATH + descriptorRenderer.renderType(getUpperBound()) + ')';
        }
        return descriptorRenderer.renderFlexibleType(descriptorRenderer.renderType(getLowerBound()), descriptorRenderer.renderType(getUpperBound()), TypeUtilsKt.getBuiltIns(this));
    }
}
