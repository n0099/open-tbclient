package kotlin.reflect.jvm.internal.impl.types;
/* loaded from: classes10.dex */
public interface SubtypingRepresentatives {
    KotlinType getSubTypeRepresentative();

    KotlinType getSuperTypeRepresentative();

    boolean sameTypeConstructor(KotlinType kotlinType);
}
