package kotlin.reflect.jvm.internal.impl.types;
/* loaded from: classes2.dex */
public final class NotNullSimpleType extends DelegatingSimpleTypeImpl {
    @Override // kotlin.reflect.jvm.internal.impl.types.DelegatingSimpleType, kotlin.reflect.jvm.internal.impl.types.KotlinType
    public boolean isMarkedNullable() {
        return false;
    }

    public NotNullSimpleType(SimpleType simpleType) {
        super(simpleType);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // kotlin.reflect.jvm.internal.impl.types.DelegatingSimpleType
    public NotNullSimpleType replaceDelegate(SimpleType simpleType) {
        return new NotNullSimpleType(simpleType);
    }
}
