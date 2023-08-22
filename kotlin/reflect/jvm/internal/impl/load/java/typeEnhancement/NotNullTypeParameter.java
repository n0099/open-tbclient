package kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement;

import kotlin.reflect.jvm.internal.impl.descriptors.annotations.Annotations;
import kotlin.reflect.jvm.internal.impl.types.DelegatingSimpleType;
import kotlin.reflect.jvm.internal.impl.types.FlexibleType;
import kotlin.reflect.jvm.internal.impl.types.KotlinType;
import kotlin.reflect.jvm.internal.impl.types.KotlinTypeFactory;
import kotlin.reflect.jvm.internal.impl.types.NotNullTypeVariable;
import kotlin.reflect.jvm.internal.impl.types.SimpleType;
import kotlin.reflect.jvm.internal.impl.types.TypeUtils;
import kotlin.reflect.jvm.internal.impl.types.TypeWithEnhancementKt;
import kotlin.reflect.jvm.internal.impl.types.UnwrappedType;
import kotlin.reflect.jvm.internal.impl.types.typeUtil.TypeUtilsKt;
/* loaded from: classes2.dex */
public final class NotNullTypeParameter extends DelegatingSimpleType implements NotNullTypeVariable {
    public final SimpleType delegate;

    @Override // kotlin.reflect.jvm.internal.impl.types.DelegatingSimpleType, kotlin.reflect.jvm.internal.impl.types.KotlinType
    public boolean isMarkedNullable() {
        return false;
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.CustomTypeVariable
    public boolean isTypeVariable() {
        return true;
    }

    public NotNullTypeParameter(SimpleType simpleType) {
        this.delegate = simpleType;
    }

    private final SimpleType prepareReplacement(SimpleType simpleType) {
        SimpleType makeNullableAsSpecified = simpleType.makeNullableAsSpecified(false);
        if (!TypeUtilsKt.isTypeParameter(simpleType)) {
            return makeNullableAsSpecified;
        }
        return new NotNullTypeParameter(makeNullableAsSpecified);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // kotlin.reflect.jvm.internal.impl.types.UnwrappedType
    public SimpleType makeNullableAsSpecified(boolean z) {
        if (z) {
            return getDelegate().makeNullableAsSpecified(true);
        }
        return this;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // kotlin.reflect.jvm.internal.impl.types.UnwrappedType
    public NotNullTypeParameter replaceAnnotations(Annotations annotations) {
        return new NotNullTypeParameter(getDelegate().replaceAnnotations(annotations));
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // kotlin.reflect.jvm.internal.impl.types.DelegatingSimpleType
    public NotNullTypeParameter replaceDelegate(SimpleType simpleType) {
        return new NotNullTypeParameter(simpleType);
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.DelegatingSimpleType
    public SimpleType getDelegate() {
        return this.delegate;
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.CustomTypeVariable
    public KotlinType substitutionResult(KotlinType kotlinType) {
        UnwrappedType unwrap = kotlinType.unwrap();
        if (!TypeUtils.isNullableType(unwrap) && !TypeUtilsKt.isTypeParameter(unwrap)) {
            return unwrap;
        }
        if (unwrap instanceof SimpleType) {
            return prepareReplacement((SimpleType) unwrap);
        }
        if (unwrap instanceof FlexibleType) {
            FlexibleType flexibleType = (FlexibleType) unwrap;
            return TypeWithEnhancementKt.wrapEnhancement(KotlinTypeFactory.flexibleType(prepareReplacement(flexibleType.getLowerBound()), prepareReplacement(flexibleType.getUpperBound())), TypeWithEnhancementKt.getEnhancement(unwrap));
        }
        throw new IllegalStateException(("Incorrect type: " + unwrap).toString());
    }
}
