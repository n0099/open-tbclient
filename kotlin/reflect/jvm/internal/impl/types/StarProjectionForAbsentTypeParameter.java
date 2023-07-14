package kotlin.reflect.jvm.internal.impl.types;

import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.builtins.KotlinBuiltIns;
import kotlin.reflect.jvm.internal.impl.types.checker.KotlinTypeRefiner;
/* loaded from: classes2.dex */
public final class StarProjectionForAbsentTypeParameter extends TypeProjectionBase {
    public final KotlinType nullableAnyType;

    @Override // kotlin.reflect.jvm.internal.impl.types.TypeProjection
    public boolean isStarProjection() {
        return true;
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.TypeProjection
    public TypeProjection refine(KotlinTypeRefiner kotlinTypeRefiner) {
        return this;
    }

    public StarProjectionForAbsentTypeParameter(KotlinBuiltIns kotlinBuiltIns) {
        SimpleType nullableAnyType = kotlinBuiltIns.getNullableAnyType();
        Intrinsics.checkExpressionValueIsNotNull(nullableAnyType, "kotlinBuiltIns.nullableAnyType");
        this.nullableAnyType = nullableAnyType;
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.TypeProjection
    public Variance getProjectionKind() {
        return Variance.OUT_VARIANCE;
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.TypeProjection
    public KotlinType getType() {
        return this.nullableAnyType;
    }
}
