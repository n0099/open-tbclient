package kotlin.reflect.jvm.internal.impl.descriptors.annotations;

import kotlin.TuplesKt;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.MapsKt__MapsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.builtins.KotlinBuiltIns;
import kotlin.reflect.jvm.internal.impl.descriptors.ModuleDescriptor;
import kotlin.reflect.jvm.internal.impl.name.ClassId;
import kotlin.reflect.jvm.internal.impl.name.FqName;
import kotlin.reflect.jvm.internal.impl.name.Name;
import kotlin.reflect.jvm.internal.impl.resolve.constants.AnnotationValue;
import kotlin.reflect.jvm.internal.impl.resolve.constants.ArrayValue;
import kotlin.reflect.jvm.internal.impl.resolve.constants.EnumValue;
import kotlin.reflect.jvm.internal.impl.resolve.constants.StringValue;
import kotlin.reflect.jvm.internal.impl.types.SimpleType;
import kotlin.reflect.jvm.internal.impl.types.Variance;
/* loaded from: classes9.dex */
public final class AnnotationUtilKt {
    public static final Name DEPRECATED_LEVEL_NAME;
    public static final Name DEPRECATED_MESSAGE_NAME;
    public static final Name DEPRECATED_REPLACE_WITH_NAME;
    public static final Name REPLACE_WITH_EXPRESSION_NAME;
    public static final Name REPLACE_WITH_IMPORTS_NAME;

    static {
        Name identifier = Name.identifier("message");
        Intrinsics.checkExpressionValueIsNotNull(identifier, "Name.identifier(\"message\")");
        DEPRECATED_MESSAGE_NAME = identifier;
        Name identifier2 = Name.identifier("replaceWith");
        Intrinsics.checkExpressionValueIsNotNull(identifier2, "Name.identifier(\"replaceWith\")");
        DEPRECATED_REPLACE_WITH_NAME = identifier2;
        Name identifier3 = Name.identifier("level");
        Intrinsics.checkExpressionValueIsNotNull(identifier3, "Name.identifier(\"level\")");
        DEPRECATED_LEVEL_NAME = identifier3;
        Name identifier4 = Name.identifier("expression");
        Intrinsics.checkExpressionValueIsNotNull(identifier4, "Name.identifier(\"expression\")");
        REPLACE_WITH_EXPRESSION_NAME = identifier4;
        Name identifier5 = Name.identifier("imports");
        Intrinsics.checkExpressionValueIsNotNull(identifier5, "Name.identifier(\"imports\")");
        REPLACE_WITH_IMPORTS_NAME = identifier5;
    }

    public static final AnnotationDescriptor createDeprecatedAnnotation(final KotlinBuiltIns kotlinBuiltIns, String str, String str2, String str3) {
        FqName fqName = KotlinBuiltIns.FQ_NAMES.replaceWith;
        Intrinsics.checkExpressionValueIsNotNull(fqName, "KotlinBuiltIns.FQ_NAMES.replaceWith");
        BuiltInAnnotationDescriptor builtInAnnotationDescriptor = new BuiltInAnnotationDescriptor(kotlinBuiltIns, fqName, MapsKt__MapsKt.mapOf(TuplesKt.to(REPLACE_WITH_EXPRESSION_NAME, new StringValue(str2)), TuplesKt.to(REPLACE_WITH_IMPORTS_NAME, new ArrayValue(CollectionsKt__CollectionsKt.emptyList(), new Function1<ModuleDescriptor, SimpleType>() { // from class: kotlin.reflect.jvm.internal.impl.descriptors.annotations.AnnotationUtilKt$createDeprecatedAnnotation$replaceWithAnnotation$1
            {
                super(1);
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // kotlin.jvm.functions.Function1
            public final SimpleType invoke(ModuleDescriptor moduleDescriptor) {
                SimpleType arrayType = moduleDescriptor.getBuiltIns().getArrayType(Variance.INVARIANT, KotlinBuiltIns.this.getStringType());
                Intrinsics.checkExpressionValueIsNotNull(arrayType, "module.builtIns.getArray…ce.INVARIANT, stringType)");
                return arrayType;
            }
        }))));
        FqName fqName2 = KotlinBuiltIns.FQ_NAMES.deprecated;
        Intrinsics.checkExpressionValueIsNotNull(fqName2, "KotlinBuiltIns.FQ_NAMES.deprecated");
        Name name = DEPRECATED_LEVEL_NAME;
        ClassId classId = ClassId.topLevel(KotlinBuiltIns.FQ_NAMES.deprecationLevel);
        Intrinsics.checkExpressionValueIsNotNull(classId, "ClassId.topLevel(KotlinB…Q_NAMES.deprecationLevel)");
        Name identifier = Name.identifier(str3);
        Intrinsics.checkExpressionValueIsNotNull(identifier, "Name.identifier(level)");
        return new BuiltInAnnotationDescriptor(kotlinBuiltIns, fqName2, MapsKt__MapsKt.mapOf(TuplesKt.to(DEPRECATED_MESSAGE_NAME, new StringValue(str)), TuplesKt.to(DEPRECATED_REPLACE_WITH_NAME, new AnnotationValue(builtInAnnotationDescriptor)), TuplesKt.to(name, new EnumValue(classId, identifier))));
    }

    public static /* synthetic */ AnnotationDescriptor createDeprecatedAnnotation$default(KotlinBuiltIns kotlinBuiltIns, String str, String str2, String str3, int i, Object obj) {
        if ((i & 2) != 0) {
            str2 = "";
        }
        if ((i & 4) != 0) {
            str3 = "WARNING";
        }
        return createDeprecatedAnnotation(kotlinBuiltIns, str, str2, str3);
    }
}
