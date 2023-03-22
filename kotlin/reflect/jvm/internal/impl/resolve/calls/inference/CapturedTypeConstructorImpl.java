package kotlin.reflect.jvm.internal.impl.resolve.calls.inference;

import java.util.Collection;
import java.util.List;
import kotlin._Assertions;
import kotlin.collections.CollectionsKt__CollectionsJVMKt;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.builtins.KotlinBuiltIns;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassifierDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.TypeParameterDescriptor;
import kotlin.reflect.jvm.internal.impl.types.KotlinType;
import kotlin.reflect.jvm.internal.impl.types.TypeProjection;
import kotlin.reflect.jvm.internal.impl.types.Variance;
import kotlin.reflect.jvm.internal.impl.types.checker.KotlinTypeRefiner;
import kotlin.reflect.jvm.internal.impl.types.checker.NewCapturedTypeConstructor;
/* loaded from: classes9.dex */
public final class CapturedTypeConstructorImpl implements CapturedTypeConstructor {
    public NewCapturedTypeConstructor newTypeConstructor;
    public final TypeProjection projection;

    /* JADX DEBUG: Possible override for method kotlin.reflect.jvm.internal.impl.types.TypeConstructor.getDeclarationDescriptor()Lkotlin/reflect/jvm/internal/impl/descriptors/ClassifierDescriptor; */
    public Void getDeclarationDescriptor() {
        return null;
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.TypeConstructor
    public boolean isDenotable() {
        return false;
    }

    public CapturedTypeConstructorImpl(TypeProjection typeProjection) {
        boolean z;
        this.projection = typeProjection;
        if (getProjection().getProjectionKind() != Variance.INVARIANT) {
            z = true;
        } else {
            z = false;
        }
        if (_Assertions.ENABLED && !z) {
            throw new AssertionError("Only nontrivial projections can be captured, not: " + getProjection());
        }
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.TypeConstructor
    public KotlinBuiltIns getBuiltIns() {
        KotlinBuiltIns builtIns = getProjection().getType().getConstructor().getBuiltIns();
        Intrinsics.checkExpressionValueIsNotNull(builtIns, "projection.type.constructor.builtIns");
        return builtIns;
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.TypeConstructor
    /* renamed from: getDeclarationDescriptor  reason: collision with other method in class */
    public /* bridge */ /* synthetic */ ClassifierDescriptor mo2023getDeclarationDescriptor() {
        return (ClassifierDescriptor) getDeclarationDescriptor();
    }

    public final NewCapturedTypeConstructor getNewTypeConstructor() {
        return this.newTypeConstructor;
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.TypeConstructor
    public List<TypeParameterDescriptor> getParameters() {
        return CollectionsKt__CollectionsKt.emptyList();
    }

    @Override // kotlin.reflect.jvm.internal.impl.resolve.calls.inference.CapturedTypeConstructor
    public TypeProjection getProjection() {
        return this.projection;
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.TypeConstructor
    /* renamed from: getSupertypes */
    public Collection<KotlinType> mo2024getSupertypes() {
        KotlinType nullableAnyType;
        if (getProjection().getProjectionKind() == Variance.OUT_VARIANCE) {
            nullableAnyType = getProjection().getType();
        } else {
            nullableAnyType = getBuiltIns().getNullableAnyType();
        }
        Intrinsics.checkExpressionValueIsNotNull(nullableAnyType, "if (projection.projectio… builtIns.nullableAnyType");
        return CollectionsKt__CollectionsJVMKt.listOf(nullableAnyType);
    }

    public String toString() {
        return "CapturedTypeConstructor(" + getProjection() + ')';
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // kotlin.reflect.jvm.internal.impl.types.TypeConstructor
    public CapturedTypeConstructorImpl refine(KotlinTypeRefiner kotlinTypeRefiner) {
        TypeProjection refine = getProjection().refine(kotlinTypeRefiner);
        Intrinsics.checkExpressionValueIsNotNull(refine, "projection.refine(kotlinTypeRefiner)");
        return new CapturedTypeConstructorImpl(refine);
    }

    public final void setNewTypeConstructor(NewCapturedTypeConstructor newCapturedTypeConstructor) {
        this.newTypeConstructor = newCapturedTypeConstructor;
    }
}
