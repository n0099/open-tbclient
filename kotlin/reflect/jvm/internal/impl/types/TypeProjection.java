package kotlin.reflect.jvm.internal.impl.types;

import kotlin.reflect.jvm.internal.impl.types.checker.KotlinTypeRefiner;
import kotlin.reflect.jvm.internal.impl.types.model.TypeArgumentMarker;
/* loaded from: classes2.dex */
public interface TypeProjection extends TypeArgumentMarker {
    Variance getProjectionKind();

    KotlinType getType();

    boolean isStarProjection();

    TypeProjection refine(KotlinTypeRefiner kotlinTypeRefiner);
}
