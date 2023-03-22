package kotlin.reflect.jvm.internal.impl.types;

import kotlin.reflect.jvm.internal.impl.descriptors.annotations.Annotations;
/* loaded from: classes9.dex */
public final class AnnotatedSimpleType extends DelegatingSimpleTypeImpl {
    public final Annotations annotations;

    public AnnotatedSimpleType(SimpleType simpleType, Annotations annotations) {
        super(simpleType);
        this.annotations = annotations;
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.DelegatingSimpleType, kotlin.reflect.jvm.internal.impl.descriptors.annotations.Annotated
    public Annotations getAnnotations() {
        return this.annotations;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // kotlin.reflect.jvm.internal.impl.types.DelegatingSimpleType
    public AnnotatedSimpleType replaceDelegate(SimpleType simpleType) {
        return new AnnotatedSimpleType(simpleType, getAnnotations());
    }
}
