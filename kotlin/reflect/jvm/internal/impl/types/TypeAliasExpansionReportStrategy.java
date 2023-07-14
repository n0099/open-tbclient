package kotlin.reflect.jvm.internal.impl.types;

import kotlin.reflect.jvm.internal.impl.descriptors.TypeAliasDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.TypeParameterDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.AnnotationDescriptor;
/* loaded from: classes2.dex */
public interface TypeAliasExpansionReportStrategy {

    /* loaded from: classes2.dex */
    public static final class DO_NOTHING implements TypeAliasExpansionReportStrategy {
        public static final DO_NOTHING INSTANCE = new DO_NOTHING();

        @Override // kotlin.reflect.jvm.internal.impl.types.TypeAliasExpansionReportStrategy
        public void boundsViolationInSubstitution(KotlinType kotlinType, KotlinType kotlinType2, KotlinType kotlinType3, TypeParameterDescriptor typeParameterDescriptor) {
        }

        @Override // kotlin.reflect.jvm.internal.impl.types.TypeAliasExpansionReportStrategy
        public void conflictingProjection(TypeAliasDescriptor typeAliasDescriptor, TypeParameterDescriptor typeParameterDescriptor, KotlinType kotlinType) {
        }

        @Override // kotlin.reflect.jvm.internal.impl.types.TypeAliasExpansionReportStrategy
        public void recursiveTypeAlias(TypeAliasDescriptor typeAliasDescriptor) {
        }

        @Override // kotlin.reflect.jvm.internal.impl.types.TypeAliasExpansionReportStrategy
        public void repeatedAnnotation(AnnotationDescriptor annotationDescriptor) {
        }
    }

    void boundsViolationInSubstitution(KotlinType kotlinType, KotlinType kotlinType2, KotlinType kotlinType3, TypeParameterDescriptor typeParameterDescriptor);

    void conflictingProjection(TypeAliasDescriptor typeAliasDescriptor, TypeParameterDescriptor typeParameterDescriptor, KotlinType kotlinType);

    void recursiveTypeAlias(TypeAliasDescriptor typeAliasDescriptor);

    void repeatedAnnotation(AnnotationDescriptor annotationDescriptor);
}
