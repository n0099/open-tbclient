package kotlin.reflect.jvm.internal.impl.types.checker;

import kotlin.reflect.jvm.internal.impl.types.KotlinType;
import kotlin.reflect.jvm.internal.impl.types.TypeConstructor;
/* loaded from: classes2.dex */
public interface KotlinTypeChecker {
    public static final KotlinTypeChecker DEFAULT = NewKotlinTypeChecker.Companion.getDefault();

    /* loaded from: classes2.dex */
    public interface TypeConstructorEquality {
        boolean equals(TypeConstructor typeConstructor, TypeConstructor typeConstructor2);
    }

    boolean equalTypes(KotlinType kotlinType, KotlinType kotlinType2);

    boolean isSubtypeOf(KotlinType kotlinType, KotlinType kotlinType2);
}
