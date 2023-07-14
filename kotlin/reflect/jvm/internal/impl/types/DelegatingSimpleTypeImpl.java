package kotlin.reflect.jvm.internal.impl.types;

import kotlin.reflect.jvm.internal.impl.descriptors.annotations.Annotations;
/* loaded from: classes2.dex */
public abstract class DelegatingSimpleTypeImpl extends DelegatingSimpleType {
    public final SimpleType delegate;

    public DelegatingSimpleTypeImpl(SimpleType simpleType) {
        this.delegate = simpleType;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // kotlin.reflect.jvm.internal.impl.types.UnwrappedType
    public SimpleType makeNullableAsSpecified(boolean z) {
        if (z == isMarkedNullable()) {
            return this;
        }
        return getDelegate().makeNullableAsSpecified(z).replaceAnnotations(getAnnotations());
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // kotlin.reflect.jvm.internal.impl.types.UnwrappedType
    public DelegatingSimpleTypeImpl replaceAnnotations(Annotations annotations) {
        if (annotations != getAnnotations()) {
            return new AnnotatedSimpleType(this, annotations);
        }
        return this;
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.DelegatingSimpleType
    public SimpleType getDelegate() {
        return this.delegate;
    }
}
