package kotlin.reflect.jvm.internal.impl.types;
/* loaded from: classes2.dex */
public final class NullableSimpleType extends DelegatingSimpleTypeImpl {
    @Override // kotlin.reflect.jvm.internal.impl.types.DelegatingSimpleType, kotlin.reflect.jvm.internal.impl.types.KotlinType
    public boolean isMarkedNullable() {
        return true;
    }

    public NullableSimpleType(SimpleType simpleType) {
        super(simpleType);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // kotlin.reflect.jvm.internal.impl.types.DelegatingSimpleType
    public NullableSimpleType replaceDelegate(SimpleType simpleType) {
        return new NullableSimpleType(simpleType);
    }
}
