package kotlin.reflect.jvm.internal.impl.load.java.components;

import java.util.ArrayList;
import java.util.EnumSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.TuplesKt;
import kotlin.collections.CollectionsKt__IterablesKt;
import kotlin.collections.CollectionsKt__MutableCollectionsKt;
import kotlin.collections.MapsKt__MapsKt;
import kotlin.collections.SetsKt__SetsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.builtins.KotlinBuiltIns;
import kotlin.reflect.jvm.internal.impl.descriptors.ModuleDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ValueParameterDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.KotlinRetention;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.KotlinTarget;
import kotlin.reflect.jvm.internal.impl.load.java.structure.JavaAnnotationArgument;
import kotlin.reflect.jvm.internal.impl.load.java.structure.JavaEnumValueAnnotationArgument;
import kotlin.reflect.jvm.internal.impl.name.ClassId;
import kotlin.reflect.jvm.internal.impl.name.Name;
import kotlin.reflect.jvm.internal.impl.resolve.constants.ArrayValue;
import kotlin.reflect.jvm.internal.impl.resolve.constants.ConstantValue;
import kotlin.reflect.jvm.internal.impl.resolve.constants.EnumValue;
import kotlin.reflect.jvm.internal.impl.types.ErrorUtils;
import kotlin.reflect.jvm.internal.impl.types.KotlinType;
import kotlin.reflect.jvm.internal.impl.types.SimpleType;
/* loaded from: classes9.dex */
public final class JavaAnnotationTargetMapper {
    public static final JavaAnnotationTargetMapper INSTANCE = new JavaAnnotationTargetMapper();
    public static final Map<String, EnumSet<KotlinTarget>> targetNameLists = MapsKt__MapsKt.mapOf(TuplesKt.to("PACKAGE", EnumSet.noneOf(KotlinTarget.class)), TuplesKt.to("TYPE", EnumSet.of(KotlinTarget.CLASS, KotlinTarget.FILE)), TuplesKt.to("ANNOTATION_TYPE", EnumSet.of(KotlinTarget.ANNOTATION_CLASS)), TuplesKt.to("TYPE_PARAMETER", EnumSet.of(KotlinTarget.TYPE_PARAMETER)), TuplesKt.to("FIELD", EnumSet.of(KotlinTarget.FIELD)), TuplesKt.to("LOCAL_VARIABLE", EnumSet.of(KotlinTarget.LOCAL_VARIABLE)), TuplesKt.to("PARAMETER", EnumSet.of(KotlinTarget.VALUE_PARAMETER)), TuplesKt.to("CONSTRUCTOR", EnumSet.of(KotlinTarget.CONSTRUCTOR)), TuplesKt.to("METHOD", EnumSet.of(KotlinTarget.FUNCTION, KotlinTarget.PROPERTY_GETTER, KotlinTarget.PROPERTY_SETTER)), TuplesKt.to("TYPE_USE", EnumSet.of(KotlinTarget.TYPE)));
    public static final Map<String, KotlinRetention> retentionNameList = MapsKt__MapsKt.mapOf(TuplesKt.to("RUNTIME", KotlinRetention.RUNTIME), TuplesKt.to("CLASS", KotlinRetention.BINARY), TuplesKt.to("SOURCE", KotlinRetention.SOURCE));

    public final ConstantValue<?> mapJavaRetentionArgument$descriptors_jvm(JavaAnnotationArgument javaAnnotationArgument) {
        String str;
        if (!(javaAnnotationArgument instanceof JavaEnumValueAnnotationArgument)) {
            javaAnnotationArgument = null;
        }
        JavaEnumValueAnnotationArgument javaEnumValueAnnotationArgument = (JavaEnumValueAnnotationArgument) javaAnnotationArgument;
        if (javaEnumValueAnnotationArgument == null) {
            return null;
        }
        Map<String, KotlinRetention> map = retentionNameList;
        Name entryName = javaEnumValueAnnotationArgument.getEntryName();
        if (entryName != null) {
            str = entryName.asString();
        } else {
            str = null;
        }
        KotlinRetention kotlinRetention = map.get(str);
        if (kotlinRetention == null) {
            return null;
        }
        ClassId classId = ClassId.topLevel(KotlinBuiltIns.FQ_NAMES.annotationRetention);
        Intrinsics.checkExpressionValueIsNotNull(classId, "ClassId.topLevel(KotlinB…AMES.annotationRetention)");
        Name identifier = Name.identifier(kotlinRetention.name());
        Intrinsics.checkExpressionValueIsNotNull(identifier, "Name.identifier(retention.name)");
        return new EnumValue(classId, identifier);
    }

    public final Set<KotlinTarget> mapJavaTargetArgumentByName(String str) {
        EnumSet<KotlinTarget> enumSet = targetNameLists.get(str);
        if (enumSet == null) {
            return SetsKt__SetsKt.emptySet();
        }
        return enumSet;
    }

    public final ConstantValue<?> mapJavaTargetArguments$descriptors_jvm(List<? extends JavaAnnotationArgument> list) {
        String str;
        ArrayList<JavaEnumValueAnnotationArgument> arrayList = new ArrayList();
        for (Object obj : list) {
            if (obj instanceof JavaEnumValueAnnotationArgument) {
                arrayList.add(obj);
            }
        }
        ArrayList<KotlinTarget> arrayList2 = new ArrayList();
        for (JavaEnumValueAnnotationArgument javaEnumValueAnnotationArgument : arrayList) {
            JavaAnnotationTargetMapper javaAnnotationTargetMapper = INSTANCE;
            Name entryName = javaEnumValueAnnotationArgument.getEntryName();
            if (entryName != null) {
                str = entryName.asString();
            } else {
                str = null;
            }
            CollectionsKt__MutableCollectionsKt.addAll(arrayList2, javaAnnotationTargetMapper.mapJavaTargetArgumentByName(str));
        }
        ArrayList arrayList3 = new ArrayList(CollectionsKt__IterablesKt.collectionSizeOrDefault(arrayList2, 10));
        for (KotlinTarget kotlinTarget : arrayList2) {
            ClassId classId = ClassId.topLevel(KotlinBuiltIns.FQ_NAMES.annotationTarget);
            Intrinsics.checkExpressionValueIsNotNull(classId, "ClassId.topLevel(KotlinB…Q_NAMES.annotationTarget)");
            Name identifier = Name.identifier(kotlinTarget.name());
            Intrinsics.checkExpressionValueIsNotNull(identifier, "Name.identifier(kotlinTarget.name)");
            arrayList3.add(new EnumValue(classId, identifier));
        }
        return new ArrayValue(arrayList3, new Function1<ModuleDescriptor, KotlinType>() { // from class: kotlin.reflect.jvm.internal.impl.load.java.components.JavaAnnotationTargetMapper$mapJavaTargetArguments$1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // kotlin.jvm.functions.Function1
            public final KotlinType invoke(ModuleDescriptor moduleDescriptor) {
                KotlinType type;
                ValueParameterDescriptor annotationParameterByName = DescriptorResolverUtils.getAnnotationParameterByName(JavaAnnotationMapper.INSTANCE.getTARGET_ANNOTATION_ALLOWED_TARGETS$descriptors_jvm(), moduleDescriptor.getBuiltIns().getBuiltInClassByFqName(KotlinBuiltIns.FQ_NAMES.target));
                if (annotationParameterByName == null || (type = annotationParameterByName.getType()) == null) {
                    SimpleType createErrorType = ErrorUtils.createErrorType("Error: AnnotationTarget[]");
                    Intrinsics.checkExpressionValueIsNotNull(createErrorType, "ErrorUtils.createErrorTy…ror: AnnotationTarget[]\")");
                    return createErrorType;
                }
                return type;
            }
        });
    }
}
