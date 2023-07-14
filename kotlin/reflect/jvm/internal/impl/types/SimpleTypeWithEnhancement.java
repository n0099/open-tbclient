package kotlin.reflect.jvm.internal.impl.types;

import kotlin.TypeCastException;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.Annotations;
import kotlin.reflect.jvm.internal.impl.types.checker.KotlinTypeRefiner;
/* loaded from: classes2.dex */
public final class SimpleTypeWithEnhancement extends DelegatingSimpleType implements TypeWithEnhancement {
    public final SimpleType delegate;
    public final KotlinType enhancement;

    public SimpleTypeWithEnhancement(SimpleType simpleType, KotlinType kotlinType) {
        this.delegate = simpleType;
        this.enhancement = kotlinType;
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.DelegatingSimpleType
    public SimpleType getDelegate() {
        return this.delegate;
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.TypeWithEnhancement
    public KotlinType getEnhancement() {
        return this.enhancement;
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.TypeWithEnhancement
    public UnwrappedType getOrigin() {
        return getDelegate();
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // kotlin.reflect.jvm.internal.impl.types.UnwrappedType
    public SimpleType makeNullableAsSpecified(boolean z) {
        UnwrappedType wrapEnhancement = TypeWithEnhancementKt.wrapEnhancement(getOrigin().makeNullableAsSpecified(z), getEnhancement().unwrap().makeNullableAsSpecified(z));
        if (wrapEnhancement != null) {
            return (SimpleType) wrapEnhancement;
        }
        throw new TypeCastException("null cannot be cast to non-null type org.jetbrains.kotlin.types.SimpleType");
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // kotlin.reflect.jvm.internal.impl.types.UnwrappedType
    public SimpleType replaceAnnotations(Annotations annotations) {
        UnwrappedType wrapEnhancement = TypeWithEnhancementKt.wrapEnhancement(getOrigin().replaceAnnotations(annotations), getEnhancement());
        if (wrapEnhancement != null) {
            return (SimpleType) wrapEnhancement;
        }
        throw new TypeCastException("null cannot be cast to non-null type org.jetbrains.kotlin.types.SimpleType");
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // kotlin.reflect.jvm.internal.impl.types.DelegatingSimpleType
    public SimpleTypeWithEnhancement replaceDelegate(SimpleType simpleType) {
        return new SimpleTypeWithEnhancement(simpleType, getEnhancement());
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // kotlin.reflect.jvm.internal.impl.types.DelegatingSimpleType, kotlin.reflect.jvm.internal.impl.types.UnwrappedType, kotlin.reflect.jvm.internal.impl.types.KotlinType
    public SimpleTypeWithEnhancement refine(KotlinTypeRefiner kotlinTypeRefiner) {
        KotlinType refineType = kotlinTypeRefiner.refineType(getDelegate());
        if (refineType != null) {
            return new SimpleTypeWithEnhancement((SimpleType) refineType, kotlinTypeRefiner.refineType(getEnhancement()));
        }
        throw new TypeCastException("null cannot be cast to non-null type org.jetbrains.kotlin.types.SimpleType");
    }
}
