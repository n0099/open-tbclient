package kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import kotlin.collections.CollectionsKt__CollectionsJVMKt;
import kotlin.collections.CollectionsKt__IterablesKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.SourceElement;
import kotlin.reflect.jvm.internal.impl.descriptors.impl.AbstractLazyTypeParameterDescriptor;
import kotlin.reflect.jvm.internal.impl.load.java.components.TypeUsage;
import kotlin.reflect.jvm.internal.impl.load.java.lazy.LazyJavaAnnotations;
import kotlin.reflect.jvm.internal.impl.load.java.lazy.LazyJavaResolverContext;
import kotlin.reflect.jvm.internal.impl.load.java.lazy.types.JavaTypeResolverKt;
import kotlin.reflect.jvm.internal.impl.load.java.structure.JavaClassifierType;
import kotlin.reflect.jvm.internal.impl.load.java.structure.JavaTypeParameter;
import kotlin.reflect.jvm.internal.impl.types.KotlinType;
import kotlin.reflect.jvm.internal.impl.types.KotlinTypeFactory;
import kotlin.reflect.jvm.internal.impl.types.SimpleType;
import kotlin.reflect.jvm.internal.impl.types.Variance;
/* loaded from: classes9.dex */
public final class LazyJavaTypeParameterDescriptor extends AbstractLazyTypeParameterDescriptor {
    public final LazyJavaAnnotations annotations;
    public final LazyJavaResolverContext c;
    public final JavaTypeParameter javaTypeParameter;

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.impl.AbstractTypeParameterDescriptor
    /* renamed from: reportSupertypeLoopError */
    public void mo2026reportSupertypeLoopError(KotlinType kotlinType) {
    }

    public LazyJavaTypeParameterDescriptor(LazyJavaResolverContext lazyJavaResolverContext, JavaTypeParameter javaTypeParameter, int i, DeclarationDescriptor declarationDescriptor) {
        super(lazyJavaResolverContext.getStorageManager(), declarationDescriptor, javaTypeParameter.getName(), Variance.INVARIANT, false, i, SourceElement.NO_SOURCE, lazyJavaResolverContext.getComponents().getSupertypeLoopChecker());
        this.c = lazyJavaResolverContext;
        this.javaTypeParameter = javaTypeParameter;
        this.annotations = new LazyJavaAnnotations(this.c, this.javaTypeParameter);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // kotlin.reflect.jvm.internal.impl.descriptors.annotations.AnnotatedImpl, kotlin.reflect.jvm.internal.impl.descriptors.annotations.Annotated
    public LazyJavaAnnotations getAnnotations() {
        return this.annotations;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.impl.AbstractTypeParameterDescriptor
    public List<KotlinType> resolveUpperBounds() {
        Collection<JavaClassifierType> upperBounds = this.javaTypeParameter.getUpperBounds();
        if (upperBounds.isEmpty()) {
            SimpleType anyType = this.c.getModule().getBuiltIns().getAnyType();
            Intrinsics.checkExpressionValueIsNotNull(anyType, "c.module.builtIns.anyType");
            SimpleType nullableAnyType = this.c.getModule().getBuiltIns().getNullableAnyType();
            Intrinsics.checkExpressionValueIsNotNull(nullableAnyType, "c.module.builtIns.nullableAnyType");
            return CollectionsKt__CollectionsJVMKt.listOf(KotlinTypeFactory.flexibleType(anyType, nullableAnyType));
        }
        ArrayList arrayList = new ArrayList(CollectionsKt__IterablesKt.collectionSizeOrDefault(upperBounds, 10));
        for (JavaClassifierType javaClassifierType : upperBounds) {
            arrayList.add(this.c.getTypeResolver().transformJavaType(javaClassifierType, JavaTypeResolverKt.toAttributes$default(TypeUsage.COMMON, false, this, 1, null)));
        }
        return arrayList;
    }
}
