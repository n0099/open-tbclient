package kotlin.reflect.jvm.internal.impl.types;
/* loaded from: classes10.dex */
public final class KotlinTypeKt {
    public static final boolean isError(KotlinType kotlinType) {
        UnwrappedType unwrap = kotlinType.unwrap();
        if (!(unwrap instanceof ErrorType) && (!(unwrap instanceof FlexibleType) || !(((FlexibleType) unwrap).getDelegate() instanceof ErrorType))) {
            return false;
        }
        return true;
    }
}
