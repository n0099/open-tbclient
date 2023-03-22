package kotlin.reflect.jvm.internal.impl.load.java.components;

import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;
import java.util.Map;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt__MapsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.builtins.KotlinBuiltIns;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.AnnotationDescriptor;
import kotlin.reflect.jvm.internal.impl.load.java.lazy.LazyJavaResolverContext;
import kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors.LazyJavaAnnotationDescriptor;
import kotlin.reflect.jvm.internal.impl.load.java.structure.JavaAnnotation;
import kotlin.reflect.jvm.internal.impl.load.java.structure.JavaAnnotationOwner;
import kotlin.reflect.jvm.internal.impl.name.ClassId;
import kotlin.reflect.jvm.internal.impl.name.FqName;
import kotlin.reflect.jvm.internal.impl.name.Name;
/* loaded from: classes9.dex */
public final class JavaAnnotationMapper {
    public static final Name DEPRECATED_ANNOTATION_MESSAGE;
    public static final Name RETENTION_ANNOTATION_VALUE;
    public static final Name TARGET_ANNOTATION_ALLOWED_TARGETS;
    public static final Map<FqName, FqName> javaToKotlinNameMap;
    public static final Map<FqName, FqName> kotlinToJavaNameMap;
    public static final JavaAnnotationMapper INSTANCE = new JavaAnnotationMapper();
    public static final FqName JAVA_TARGET_FQ_NAME = new FqName(Target.class.getCanonicalName());
    public static final FqName JAVA_RETENTION_FQ_NAME = new FqName(Retention.class.getCanonicalName());
    public static final FqName JAVA_DEPRECATED_FQ_NAME = new FqName(Deprecated.class.getCanonicalName());
    public static final FqName JAVA_DOCUMENTED_FQ_NAME = new FqName(Documented.class.getCanonicalName());
    public static final FqName JAVA_REPEATABLE_FQ_NAME = new FqName("java.lang.annotation.Repeatable");

    static {
        Name identifier = Name.identifier("message");
        Intrinsics.checkExpressionValueIsNotNull(identifier, "Name.identifier(\"message\")");
        DEPRECATED_ANNOTATION_MESSAGE = identifier;
        Name identifier2 = Name.identifier("allowedTargets");
        Intrinsics.checkExpressionValueIsNotNull(identifier2, "Name.identifier(\"allowedTargets\")");
        TARGET_ANNOTATION_ALLOWED_TARGETS = identifier2;
        Name identifier3 = Name.identifier("value");
        Intrinsics.checkExpressionValueIsNotNull(identifier3, "Name.identifier(\"value\")");
        RETENTION_ANNOTATION_VALUE = identifier3;
        kotlinToJavaNameMap = MapsKt__MapsKt.mapOf(TuplesKt.to(KotlinBuiltIns.FQ_NAMES.target, JAVA_TARGET_FQ_NAME), TuplesKt.to(KotlinBuiltIns.FQ_NAMES.retention, JAVA_RETENTION_FQ_NAME), TuplesKt.to(KotlinBuiltIns.FQ_NAMES.repeatable, JAVA_REPEATABLE_FQ_NAME), TuplesKt.to(KotlinBuiltIns.FQ_NAMES.mustBeDocumented, JAVA_DOCUMENTED_FQ_NAME));
        javaToKotlinNameMap = MapsKt__MapsKt.mapOf(TuplesKt.to(JAVA_TARGET_FQ_NAME, KotlinBuiltIns.FQ_NAMES.target), TuplesKt.to(JAVA_RETENTION_FQ_NAME, KotlinBuiltIns.FQ_NAMES.retention), TuplesKt.to(JAVA_DEPRECATED_FQ_NAME, KotlinBuiltIns.FQ_NAMES.deprecated), TuplesKt.to(JAVA_REPEATABLE_FQ_NAME, KotlinBuiltIns.FQ_NAMES.repeatable), TuplesKt.to(JAVA_DOCUMENTED_FQ_NAME, KotlinBuiltIns.FQ_NAMES.mustBeDocumented));
    }

    public final Name getDEPRECATED_ANNOTATION_MESSAGE$descriptors_jvm() {
        return DEPRECATED_ANNOTATION_MESSAGE;
    }

    public final Name getRETENTION_ANNOTATION_VALUE$descriptors_jvm() {
        return RETENTION_ANNOTATION_VALUE;
    }

    public final Name getTARGET_ANNOTATION_ALLOWED_TARGETS$descriptors_jvm() {
        return TARGET_ANNOTATION_ALLOWED_TARGETS;
    }

    public final AnnotationDescriptor findMappedJavaAnnotation(FqName fqName, JavaAnnotationOwner javaAnnotationOwner, LazyJavaResolverContext lazyJavaResolverContext) {
        JavaAnnotation findAnnotation;
        JavaAnnotation findAnnotation2;
        if (Intrinsics.areEqual(fqName, KotlinBuiltIns.FQ_NAMES.deprecated) && ((findAnnotation2 = javaAnnotationOwner.findAnnotation(JAVA_DEPRECATED_FQ_NAME)) != null || javaAnnotationOwner.isDeprecatedInJavaDoc())) {
            return new JavaDeprecatedAnnotationDescriptor(findAnnotation2, lazyJavaResolverContext);
        }
        FqName fqName2 = kotlinToJavaNameMap.get(fqName);
        if (fqName2 == null || (findAnnotation = javaAnnotationOwner.findAnnotation(fqName2)) == null) {
            return null;
        }
        return INSTANCE.mapOrResolveJavaAnnotation(findAnnotation, lazyJavaResolverContext);
    }

    public final AnnotationDescriptor mapOrResolveJavaAnnotation(JavaAnnotation javaAnnotation, LazyJavaResolverContext lazyJavaResolverContext) {
        ClassId classId = javaAnnotation.getClassId();
        if (Intrinsics.areEqual(classId, ClassId.topLevel(JAVA_TARGET_FQ_NAME))) {
            return new JavaTargetAnnotationDescriptor(javaAnnotation, lazyJavaResolverContext);
        }
        if (Intrinsics.areEqual(classId, ClassId.topLevel(JAVA_RETENTION_FQ_NAME))) {
            return new JavaRetentionAnnotationDescriptor(javaAnnotation, lazyJavaResolverContext);
        }
        if (Intrinsics.areEqual(classId, ClassId.topLevel(JAVA_REPEATABLE_FQ_NAME))) {
            FqName fqName = KotlinBuiltIns.FQ_NAMES.repeatable;
            Intrinsics.checkExpressionValueIsNotNull(fqName, "KotlinBuiltIns.FQ_NAMES.repeatable");
            return new JavaAnnotationDescriptor(lazyJavaResolverContext, javaAnnotation, fqName);
        } else if (Intrinsics.areEqual(classId, ClassId.topLevel(JAVA_DOCUMENTED_FQ_NAME))) {
            FqName fqName2 = KotlinBuiltIns.FQ_NAMES.mustBeDocumented;
            Intrinsics.checkExpressionValueIsNotNull(fqName2, "KotlinBuiltIns.FQ_NAMES.mustBeDocumented");
            return new JavaAnnotationDescriptor(lazyJavaResolverContext, javaAnnotation, fqName2);
        } else if (Intrinsics.areEqual(classId, ClassId.topLevel(JAVA_DEPRECATED_FQ_NAME))) {
            return null;
        } else {
            return new LazyJavaAnnotationDescriptor(lazyJavaResolverContext, javaAnnotation);
        }
    }
}
