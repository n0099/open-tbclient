package kotlin.reflect.jvm.internal.impl.types;

import java.util.List;
import kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScope;
import kotlin.reflect.jvm.internal.impl.types.checker.KotlinTypeRefiner;
/* loaded from: classes2.dex */
public final class UnresolvedType extends ErrorType {
    public final String presentableName;

    /* JADX DEBUG: Method merged with bridge method */
    @Override // kotlin.reflect.jvm.internal.impl.types.ErrorType, kotlin.reflect.jvm.internal.impl.types.UnwrappedType, kotlin.reflect.jvm.internal.impl.types.KotlinType
    public UnresolvedType refine(KotlinTypeRefiner kotlinTypeRefiner) {
        return this;
    }

    public UnresolvedType(String str, TypeConstructor typeConstructor, MemberScope memberScope, List<? extends TypeProjection> list, boolean z) {
        super(typeConstructor, memberScope, list, z, null, 16, null);
        this.presentableName = str;
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.ErrorType
    public String getPresentableName() {
        return this.presentableName;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // kotlin.reflect.jvm.internal.impl.types.ErrorType, kotlin.reflect.jvm.internal.impl.types.UnwrappedType
    public SimpleType makeNullableAsSpecified(boolean z) {
        return new UnresolvedType(getPresentableName(), getConstructor(), getMemberScope(), getArguments(), z);
    }
}
