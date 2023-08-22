package kotlin.reflect.jvm.internal.impl.load.java;

import java.util.Map;
import java.util.Set;
import kotlin.TuplesKt;
import kotlin.collections.CollectionsKt__CollectionsJVMKt;
import kotlin.collections.MapsKt__MapsKt;
import kotlin.collections.SetsKt__SetsKt;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor;
import kotlin.reflect.jvm.internal.impl.load.java.AnnotationTypeQualifierResolver;
import kotlin.reflect.jvm.internal.impl.load.java.lazy.NullabilityQualifierWithApplicability;
import kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.NullabilityQualifier;
import kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.NullabilityQualifierWithMigrationStatus;
import kotlin.reflect.jvm.internal.impl.name.FqName;
import kotlin.reflect.jvm.internal.impl.resolve.descriptorUtil.DescriptorUtilsKt;
/* loaded from: classes2.dex */
public final class AnnotationTypeQualifierResolverKt {
    public static final FqName TYPE_QUALIFIER_NICKNAME_FQNAME = new FqName("javax.annotation.meta.TypeQualifierNickname");
    public static final FqName TYPE_QUALIFIER_FQNAME = new FqName("javax.annotation.meta.TypeQualifier");
    public static final FqName TYPE_QUALIFIER_DEFAULT_FQNAME = new FqName("javax.annotation.meta.TypeQualifierDefault");
    public static final FqName MIGRATION_ANNOTATION_FQNAME = new FqName("kotlin.annotations.jvm.UnderMigration");
    public static final Map<FqName, NullabilityQualifierWithApplicability> BUILT_IN_TYPE_QUALIFIER_DEFAULT_ANNOTATIONS = MapsKt__MapsKt.mapOf(TuplesKt.to(new FqName("javax.annotation.ParametersAreNullableByDefault"), new NullabilityQualifierWithApplicability(new NullabilityQualifierWithMigrationStatus(NullabilityQualifier.NULLABLE, false, 2, null), CollectionsKt__CollectionsJVMKt.listOf(AnnotationTypeQualifierResolver.QualifierApplicabilityType.VALUE_PARAMETER))), TuplesKt.to(new FqName("javax.annotation.ParametersAreNonnullByDefault"), new NullabilityQualifierWithApplicability(new NullabilityQualifierWithMigrationStatus(NullabilityQualifier.NOT_NULL, false, 2, null), CollectionsKt__CollectionsJVMKt.listOf(AnnotationTypeQualifierResolver.QualifierApplicabilityType.VALUE_PARAMETER))));
    public static final Set<FqName> BUILT_IN_TYPE_QUALIFIER_FQ_NAMES = SetsKt__SetsKt.setOf((Object[]) new FqName[]{JvmAnnotationNamesKt.getJAVAX_NONNULL_ANNOTATION(), JvmAnnotationNamesKt.getJAVAX_CHECKFORNULL_ANNOTATION()});

    public static final boolean isAnnotatedWithTypeQualifier(ClassDescriptor classDescriptor) {
        if (!BUILT_IN_TYPE_QUALIFIER_FQ_NAMES.contains(DescriptorUtilsKt.getFqNameSafe(classDescriptor)) && !classDescriptor.getAnnotations().hasAnnotation(TYPE_QUALIFIER_FQNAME)) {
            return false;
        }
        return true;
    }

    public static final Map<FqName, NullabilityQualifierWithApplicability> getBUILT_IN_TYPE_QUALIFIER_DEFAULT_ANNOTATIONS() {
        return BUILT_IN_TYPE_QUALIFIER_DEFAULT_ANNOTATIONS;
    }

    public static final FqName getMIGRATION_ANNOTATION_FQNAME() {
        return MIGRATION_ANNOTATION_FQNAME;
    }

    public static final FqName getTYPE_QUALIFIER_DEFAULT_FQNAME() {
        return TYPE_QUALIFIER_DEFAULT_FQNAME;
    }

    public static final FqName getTYPE_QUALIFIER_NICKNAME_FQNAME() {
        return TYPE_QUALIFIER_NICKNAME_FQNAME;
    }
}
