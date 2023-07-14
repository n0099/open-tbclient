package kotlin.reflect.jvm.internal.impl.types;
/* loaded from: classes2.dex */
public final class DynamicTypesKt {
    public static final boolean isDynamic(KotlinType kotlinType) {
        return kotlinType.unwrap() instanceof DynamicType;
    }
}
