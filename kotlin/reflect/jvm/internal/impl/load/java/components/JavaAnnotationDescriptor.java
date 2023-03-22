package kotlin.reflect.jvm.internal.impl.load.java.components;

import java.util.Collection;
import java.util.Map;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.collections.MapsKt__MapsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.PropertyReference1Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KProperty;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.SourceElement;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.AnnotationDescriptor;
import kotlin.reflect.jvm.internal.impl.load.java.descriptors.PossiblyExternalAnnotationDescriptor;
import kotlin.reflect.jvm.internal.impl.load.java.lazy.LazyJavaResolverContext;
import kotlin.reflect.jvm.internal.impl.load.java.structure.JavaAnnotation;
import kotlin.reflect.jvm.internal.impl.load.java.structure.JavaAnnotationArgument;
import kotlin.reflect.jvm.internal.impl.name.FqName;
import kotlin.reflect.jvm.internal.impl.name.Name;
import kotlin.reflect.jvm.internal.impl.resolve.constants.ConstantValue;
import kotlin.reflect.jvm.internal.impl.storage.NotNullLazyValue;
import kotlin.reflect.jvm.internal.impl.storage.StorageKt;
import kotlin.reflect.jvm.internal.impl.types.SimpleType;
/* loaded from: classes9.dex */
public class JavaAnnotationDescriptor implements AnnotationDescriptor, PossiblyExternalAnnotationDescriptor {
    public static final /* synthetic */ KProperty[] $$delegatedProperties = {Reflection.property1(new PropertyReference1Impl(Reflection.getOrCreateKotlinClass(JavaAnnotationDescriptor.class), "type", "getType()Lorg/jetbrains/kotlin/types/SimpleType;"))};
    public final JavaAnnotationArgument firstArgument;
    public final FqName fqName;
    public final boolean isIdeExternalAnnotation;
    public final SourceElement source;
    public final NotNullLazyValue type$delegate;

    /* JADX DEBUG: Method merged with bridge method */
    @Override // kotlin.reflect.jvm.internal.impl.descriptors.annotations.AnnotationDescriptor
    public SimpleType getType() {
        return (SimpleType) StorageKt.getValue(this.type$delegate, this, $$delegatedProperties[0]);
    }

    public JavaAnnotationDescriptor(final LazyJavaResolverContext lazyJavaResolverContext, JavaAnnotation javaAnnotation, FqName fqName) {
        SourceElement sourceElement;
        JavaAnnotationArgument javaAnnotationArgument;
        Collection<JavaAnnotationArgument> arguments;
        this.fqName = fqName;
        if (javaAnnotation == null || (sourceElement = lazyJavaResolverContext.getComponents().getSourceElementFactory().source(javaAnnotation)) == null) {
            sourceElement = SourceElement.NO_SOURCE;
            Intrinsics.checkExpressionValueIsNotNull(sourceElement, "SourceElement.NO_SOURCE");
        }
        this.source = sourceElement;
        this.type$delegate = lazyJavaResolverContext.getStorageManager().createLazyValue(new Function0<SimpleType>() { // from class: kotlin.reflect.jvm.internal.impl.load.java.components.JavaAnnotationDescriptor$type$2
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // kotlin.jvm.functions.Function0
            public final SimpleType invoke() {
                ClassDescriptor builtInClassByFqName = lazyJavaResolverContext.getModule().getBuiltIns().getBuiltInClassByFqName(JavaAnnotationDescriptor.this.getFqName());
                Intrinsics.checkExpressionValueIsNotNull(builtInClassByFqName, "c.module.builtIns.getBuiltInClassByFqName(fqName)");
                return builtInClassByFqName.getDefaultType();
            }
        });
        if (javaAnnotation != null && (arguments = javaAnnotation.getArguments()) != null) {
            javaAnnotationArgument = (JavaAnnotationArgument) CollectionsKt___CollectionsKt.firstOrNull(arguments);
        } else {
            javaAnnotationArgument = null;
        }
        this.firstArgument = javaAnnotationArgument;
        boolean z = true;
        this.isIdeExternalAnnotation = (javaAnnotation == null || !javaAnnotation.isIdeExternalAnnotation()) ? false : false;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.annotations.AnnotationDescriptor
    public Map<Name, ConstantValue<?>> getAllValueArguments() {
        return MapsKt__MapsKt.emptyMap();
    }

    public final JavaAnnotationArgument getFirstArgument() {
        return this.firstArgument;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.annotations.AnnotationDescriptor
    public FqName getFqName() {
        return this.fqName;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.annotations.AnnotationDescriptor
    public SourceElement getSource() {
        return this.source;
    }

    @Override // kotlin.reflect.jvm.internal.impl.load.java.descriptors.PossiblyExternalAnnotationDescriptor
    public boolean isIdeExternalAnnotation() {
        return this.isIdeExternalAnnotation;
    }
}
