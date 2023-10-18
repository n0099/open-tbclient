package kotlin.reflect.jvm.internal.impl.load.java.lazy;

import java.util.Iterator;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.builtins.KotlinBuiltIns;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.AnnotationDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.Annotations;
import kotlin.reflect.jvm.internal.impl.load.java.components.JavaAnnotationMapper;
import kotlin.reflect.jvm.internal.impl.load.java.structure.JavaAnnotation;
import kotlin.reflect.jvm.internal.impl.load.java.structure.JavaAnnotationOwner;
import kotlin.reflect.jvm.internal.impl.name.FqName;
import kotlin.reflect.jvm.internal.impl.storage.MemoizedFunctionToNullable;
import kotlin.sequences.Sequence;
import kotlin.sequences.SequencesKt___SequencesKt;
/* loaded from: classes10.dex */
public final class LazyJavaAnnotations implements Annotations {
    public final MemoizedFunctionToNullable<JavaAnnotation, AnnotationDescriptor> annotationDescriptors;
    public final JavaAnnotationOwner annotationOwner;
    public final LazyJavaResolverContext c;

    public LazyJavaAnnotations(LazyJavaResolverContext lazyJavaResolverContext, JavaAnnotationOwner javaAnnotationOwner) {
        this.c = lazyJavaResolverContext;
        this.annotationOwner = javaAnnotationOwner;
        this.annotationDescriptors = lazyJavaResolverContext.getComponents().getStorageManager().createMemoizedFunctionWithNullableValues(new Function1<JavaAnnotation, AnnotationDescriptor>() { // from class: kotlin.reflect.jvm.internal.impl.load.java.lazy.LazyJavaAnnotations$annotationDescriptors$1
            {
                super(1);
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // kotlin.jvm.functions.Function1
            public final AnnotationDescriptor invoke(JavaAnnotation javaAnnotation) {
                LazyJavaResolverContext lazyJavaResolverContext2;
                JavaAnnotationMapper javaAnnotationMapper = JavaAnnotationMapper.INSTANCE;
                lazyJavaResolverContext2 = LazyJavaAnnotations.this.c;
                return javaAnnotationMapper.mapOrResolveJavaAnnotation(javaAnnotation, lazyJavaResolverContext2);
            }
        });
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.annotations.Annotations
    /* renamed from: findAnnotation */
    public AnnotationDescriptor mo2101findAnnotation(FqName fqName) {
        AnnotationDescriptor invoke;
        JavaAnnotation findAnnotation = this.annotationOwner.findAnnotation(fqName);
        if (findAnnotation == null || (invoke = this.annotationDescriptors.invoke(findAnnotation)) == null) {
            return JavaAnnotationMapper.INSTANCE.findMappedJavaAnnotation(fqName, this.annotationOwner, this.c);
        }
        return invoke;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.annotations.Annotations
    public boolean hasAnnotation(FqName fqName) {
        return Annotations.DefaultImpls.hasAnnotation(this, fqName);
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.annotations.Annotations
    public boolean isEmpty() {
        if (this.annotationOwner.getAnnotations().isEmpty() && !this.annotationOwner.isDeprecatedInJavaDoc()) {
            return true;
        }
        return false;
    }

    @Override // java.lang.Iterable
    public Iterator<AnnotationDescriptor> iterator() {
        Sequence map = SequencesKt___SequencesKt.map(CollectionsKt___CollectionsKt.asSequence(this.annotationOwner.getAnnotations()), this.annotationDescriptors);
        JavaAnnotationMapper javaAnnotationMapper = JavaAnnotationMapper.INSTANCE;
        FqName fqName = KotlinBuiltIns.FQ_NAMES.deprecated;
        Intrinsics.checkExpressionValueIsNotNull(fqName, "KotlinBuiltIns.FQ_NAMES.deprecated");
        return SequencesKt___SequencesKt.filterNotNull(SequencesKt___SequencesKt.plus(map, javaAnnotationMapper.findMappedJavaAnnotation(fqName, this.annotationOwner, this.c))).iterator();
    }
}
