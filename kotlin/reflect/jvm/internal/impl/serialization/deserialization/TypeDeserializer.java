package kotlin.reflect.jvm.internal.impl.serialization.deserialization;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.CollectionsKt__IterablesKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.collections.MapsKt__MapsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.builtins.FunctionTypesKt;
import kotlin.reflect.jvm.internal.impl.builtins.KotlinBuiltIns;
import kotlin.reflect.jvm.internal.impl.builtins.SuspendFunctionTypesKt;
import kotlin.reflect.jvm.internal.impl.descriptors.CallableDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassifierDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.FindClassInModuleKt;
import kotlin.reflect.jvm.internal.impl.descriptors.TypeParameterDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.AnnotationDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.Annotations;
import kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf;
import kotlin.reflect.jvm.internal.impl.metadata.deserialization.Flags;
import kotlin.reflect.jvm.internal.impl.metadata.deserialization.ProtoTypeTableUtilKt;
import kotlin.reflect.jvm.internal.impl.name.ClassId;
import kotlin.reflect.jvm.internal.impl.name.FqName;
import kotlin.reflect.jvm.internal.impl.resolve.constants.ConstantValue;
import kotlin.reflect.jvm.internal.impl.resolve.descriptorUtil.DescriptorUtilsKt;
import kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.DeserializedAnnotations;
import kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.DeserializedTypeParameterDescriptor;
import kotlin.reflect.jvm.internal.impl.types.ErrorUtils;
import kotlin.reflect.jvm.internal.impl.types.KotlinType;
import kotlin.reflect.jvm.internal.impl.types.KotlinTypeFactory;
import kotlin.reflect.jvm.internal.impl.types.SimpleType;
import kotlin.reflect.jvm.internal.impl.types.SpecialTypesKt;
import kotlin.reflect.jvm.internal.impl.types.StarProjectionForAbsentTypeParameter;
import kotlin.reflect.jvm.internal.impl.types.StarProjectionImpl;
import kotlin.reflect.jvm.internal.impl.types.TypeConstructor;
import kotlin.reflect.jvm.internal.impl.types.TypeProjection;
import kotlin.reflect.jvm.internal.impl.types.TypeProjectionImpl;
import kotlin.reflect.jvm.internal.impl.types.Variance;
import kotlin.reflect.jvm.internal.impl.types.typeUtil.TypeUtilsKt;
import kotlin.text.Typography;
/* loaded from: classes2.dex */
public final class TypeDeserializer {
    public final DeserializationContext c;
    public final Function1<Integer, ClassDescriptor> classDescriptors;
    public final String containerPresentableName;
    public final String debugName;
    public boolean experimentalSuspendFunctionTypeEncountered;
    public final TypeDeserializer parent;
    public final Function1<Integer, ClassifierDescriptor> typeAliasDescriptors;
    public final Map<Integer, TypeParameterDescriptor> typeParameterDescriptors;

    public TypeDeserializer(DeserializationContext deserializationContext, TypeDeserializer typeDeserializer, List<ProtoBuf.TypeParameter> list, String str, String str2, boolean z) {
        Map<Integer, TypeParameterDescriptor> linkedHashMap;
        this.c = deserializationContext;
        this.parent = typeDeserializer;
        this.debugName = str;
        this.containerPresentableName = str2;
        this.experimentalSuspendFunctionTypeEncountered = z;
        this.classDescriptors = deserializationContext.getStorageManager().createMemoizedFunctionWithNullableValues(new Function1<Integer, ClassDescriptor>() { // from class: kotlin.reflect.jvm.internal.impl.serialization.deserialization.TypeDeserializer$classDescriptors$1
            {
                super(1);
            }

            /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
            /* JADX DEBUG: Return type fixed from 'java.lang.Object' to match base method */
            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ ClassDescriptor invoke(Integer num) {
                return invoke(num.intValue());
            }

            public final ClassDescriptor invoke(int i) {
                ClassDescriptor computeClassDescriptor;
                computeClassDescriptor = TypeDeserializer.this.computeClassDescriptor(i);
                return computeClassDescriptor;
            }
        });
        this.typeAliasDescriptors = this.c.getStorageManager().createMemoizedFunctionWithNullableValues(new Function1<Integer, ClassifierDescriptor>() { // from class: kotlin.reflect.jvm.internal.impl.serialization.deserialization.TypeDeserializer$typeAliasDescriptors$1
            {
                super(1);
            }

            /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
            /* JADX DEBUG: Return type fixed from 'java.lang.Object' to match base method */
            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ ClassifierDescriptor invoke(Integer num) {
                return invoke(num.intValue());
            }

            public final ClassifierDescriptor invoke(int i) {
                ClassifierDescriptor computeTypeAliasDescriptor;
                computeTypeAliasDescriptor = TypeDeserializer.this.computeTypeAliasDescriptor(i);
                return computeTypeAliasDescriptor;
            }
        });
        if (list.isEmpty()) {
            linkedHashMap = MapsKt__MapsKt.emptyMap();
        } else {
            linkedHashMap = new LinkedHashMap<>();
            int i = 0;
            for (ProtoBuf.TypeParameter typeParameter : list) {
                linkedHashMap.put(Integer.valueOf(typeParameter.getId()), new DeserializedTypeParameterDescriptor(this.c, typeParameter, i));
                i++;
            }
        }
        this.typeParameterDescriptors = linkedHashMap;
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public /* synthetic */ TypeDeserializer(DeserializationContext deserializationContext, TypeDeserializer typeDeserializer, List list, String str, String str2, boolean z, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(deserializationContext, typeDeserializer, list, str, str2, r6);
        boolean z2;
        if ((i & 32) != 0) {
            z2 = false;
        } else {
            z2 = z;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final ClassDescriptor computeClassDescriptor(int i) {
        ClassId classId = NameResolverUtilKt.getClassId(this.c.getNameResolver(), i);
        if (classId.isLocal()) {
            return this.c.getComponents().deserializeClass(classId);
        }
        return FindClassInModuleKt.findClassAcrossModuleDependencies(this.c.getComponents().getModuleDescriptor(), classId);
    }

    private final SimpleType computeLocalClassifierReplacementType(int i) {
        if (NameResolverUtilKt.getClassId(this.c.getNameResolver(), i).isLocal()) {
            return this.c.getComponents().getLocalClassifierTypeSettings().getReplacementTypeForLocalClassifiers();
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final ClassifierDescriptor computeTypeAliasDescriptor(int i) {
        ClassId classId = NameResolverUtilKt.getClassId(this.c.getNameResolver(), i);
        if (classId.isLocal()) {
            return null;
        }
        return FindClassInModuleKt.findTypeAliasAcrossModuleDependencies(this.c.getComponents().getModuleDescriptor(), classId);
    }

    private final TypeConstructor typeParameterTypeConstructor(int i) {
        TypeConstructor typeConstructor;
        TypeParameterDescriptor typeParameterDescriptor = this.typeParameterDescriptors.get(Integer.valueOf(i));
        if (typeParameterDescriptor == null || (typeConstructor = typeParameterDescriptor.getTypeConstructor()) == null) {
            TypeDeserializer typeDeserializer = this.parent;
            if (typeDeserializer != null) {
                return typeDeserializer.typeParameterTypeConstructor(i);
            }
            return null;
        }
        return typeConstructor;
    }

    private final SimpleType createSimpleSuspendFunctionType(KotlinType kotlinType, KotlinType kotlinType2) {
        KotlinBuiltIns builtIns = TypeUtilsKt.getBuiltIns(kotlinType);
        Annotations annotations = kotlinType.getAnnotations();
        KotlinType receiverTypeFromFunctionType = FunctionTypesKt.getReceiverTypeFromFunctionType(kotlinType);
        List<TypeProjection> dropLast = CollectionsKt___CollectionsKt.dropLast(FunctionTypesKt.getValueParameterTypesFromFunctionType(kotlinType), 1);
        ArrayList arrayList = new ArrayList(CollectionsKt__IterablesKt.collectionSizeOrDefault(dropLast, 10));
        for (TypeProjection typeProjection : dropLast) {
            arrayList.add(typeProjection.getType());
        }
        return FunctionTypesKt.createFunctionType(builtIns, annotations, receiverTypeFromFunctionType, arrayList, null, kotlinType2, true).makeNullableAsSpecified(kotlinType.isMarkedNullable());
    }

    private final TypeProjection typeArgument(TypeParameterDescriptor typeParameterDescriptor, ProtoBuf.Type.Argument argument) {
        if (argument.getProjection() == ProtoBuf.Type.Argument.Projection.STAR) {
            if (typeParameterDescriptor == null) {
                return new StarProjectionForAbsentTypeParameter(this.c.getComponents().getModuleDescriptor().getBuiltIns());
            }
            return new StarProjectionImpl(typeParameterDescriptor);
        }
        ProtoEnumFlags protoEnumFlags = ProtoEnumFlags.INSTANCE;
        ProtoBuf.Type.Argument.Projection projection = argument.getProjection();
        Intrinsics.checkExpressionValueIsNotNull(projection, "typeArgumentProto.projection");
        Variance variance = protoEnumFlags.variance(projection);
        ProtoBuf.Type type = ProtoTypeTableUtilKt.type(argument, this.c.getTypeTable());
        if (type != null) {
            return new TypeProjectionImpl(variance, type(type));
        }
        return new TypeProjectionImpl(ErrorUtils.createErrorType("No type recorded"));
    }

    private final SimpleType createSuspendFunctionType(Annotations annotations, TypeConstructor typeConstructor, List<? extends TypeProjection> list, boolean z) {
        int size;
        int size2 = typeConstructor.getParameters().size() - list.size();
        SimpleType simpleType = null;
        if (size2 != 0) {
            if (size2 == 1 && (size = list.size() - 1) >= 0) {
                ClassDescriptor suspendFunction = typeConstructor.getBuiltIns().getSuspendFunction(size);
                Intrinsics.checkExpressionValueIsNotNull(suspendFunction, "functionTypeConstructor.…getSuspendFunction(arity)");
                TypeConstructor typeConstructor2 = suspendFunction.getTypeConstructor();
                Intrinsics.checkExpressionValueIsNotNull(typeConstructor2, "functionTypeConstructor.…on(arity).typeConstructor");
                simpleType = KotlinTypeFactory.simpleType$default(annotations, typeConstructor2, list, z, null, 16, null);
            }
        } else {
            simpleType = createSuspendFunctionTypeForBasicCase(annotations, typeConstructor, list, z);
        }
        if (simpleType == null) {
            SimpleType createErrorTypeWithArguments = ErrorUtils.createErrorTypeWithArguments("Bad suspend function in metadata with constructor: " + typeConstructor, list);
            Intrinsics.checkExpressionValueIsNotNull(createErrorTypeWithArguments, "ErrorUtils.createErrorTy…      arguments\n        )");
            return createErrorTypeWithArguments;
        }
        return simpleType;
    }

    private final SimpleType createSuspendFunctionTypeForBasicCase(Annotations annotations, TypeConstructor typeConstructor, List<? extends TypeProjection> list, boolean z) {
        SimpleType simpleType$default = KotlinTypeFactory.simpleType$default(annotations, typeConstructor, list, z, null, 16, null);
        if (!FunctionTypesKt.isFunctionType(simpleType$default)) {
            return null;
        }
        return transformRuntimeFunctionTypeToSuspendFunction(simpleType$default);
    }

    private final SimpleType transformRuntimeFunctionTypeToSuspendFunction(KotlinType kotlinType) {
        KotlinType type;
        FqName fqName;
        boolean releaseCoroutines = this.c.getComponents().getConfiguration().getReleaseCoroutines();
        TypeProjection typeProjection = (TypeProjection) CollectionsKt___CollectionsKt.lastOrNull((List<? extends Object>) FunctionTypesKt.getValueParameterTypesFromFunctionType(kotlinType));
        FqName fqName2 = null;
        if (typeProjection == null || (type = typeProjection.getType()) == null) {
            return null;
        }
        Intrinsics.checkExpressionValueIsNotNull(type, "funType.getValueParamete…ll()?.type ?: return null");
        ClassifierDescriptor mo2101getDeclarationDescriptor = type.getConstructor().mo2101getDeclarationDescriptor();
        if (mo2101getDeclarationDescriptor != null) {
            fqName = DescriptorUtilsKt.getFqNameSafe(mo2101getDeclarationDescriptor);
        } else {
            fqName = null;
        }
        boolean z = true;
        if (type.getArguments().size() == 1 && (SuspendFunctionTypesKt.isContinuation(fqName, true) || SuspendFunctionTypesKt.isContinuation(fqName, false))) {
            KotlinType type2 = ((TypeProjection) CollectionsKt___CollectionsKt.single((List<? extends Object>) type.getArguments())).getType();
            Intrinsics.checkExpressionValueIsNotNull(type2, "continuationArgumentType.arguments.single().type");
            DeclarationDescriptor containingDeclaration = this.c.getContainingDeclaration();
            if (!(containingDeclaration instanceof CallableDescriptor)) {
                containingDeclaration = null;
            }
            CallableDescriptor callableDescriptor = (CallableDescriptor) containingDeclaration;
            if (callableDescriptor != null) {
                fqName2 = DescriptorUtilsKt.fqNameOrNull(callableDescriptor);
            }
            if (Intrinsics.areEqual(fqName2, SuspendFunctionTypeUtilKt.KOTLIN_SUSPEND_BUILT_IN_FUNCTION_FQ_NAME)) {
                return createSimpleSuspendFunctionType(kotlinType, type2);
            }
            if (!this.experimentalSuspendFunctionTypeEncountered && (!releaseCoroutines || !SuspendFunctionTypesKt.isContinuation(fqName, !releaseCoroutines))) {
                z = false;
            }
            this.experimentalSuspendFunctionTypeEncountered = z;
            return createSimpleSuspendFunctionType(kotlinType, type2);
        }
        return (SimpleType) kotlinType;
    }

    private final TypeConstructor typeConstructor(ProtoBuf.Type type) {
        Object obj;
        TypeConstructor typeConstructor;
        TypeDeserializer$typeConstructor$1 typeDeserializer$typeConstructor$1 = new TypeDeserializer$typeConstructor$1(this, type);
        if (type.hasClassName()) {
            ClassDescriptor invoke = this.classDescriptors.invoke(Integer.valueOf(type.getClassName()));
            if (invoke == null) {
                invoke = typeDeserializer$typeConstructor$1.invoke(type.getClassName());
            }
            TypeConstructor typeConstructor2 = invoke.getTypeConstructor();
            Intrinsics.checkExpressionValueIsNotNull(typeConstructor2, "(classDescriptors(proto.…assName)).typeConstructor");
            return typeConstructor2;
        } else if (type.hasTypeParameter()) {
            TypeConstructor typeParameterTypeConstructor = typeParameterTypeConstructor(type.getTypeParameter());
            if (typeParameterTypeConstructor != null) {
                return typeParameterTypeConstructor;
            }
            TypeConstructor createErrorTypeConstructor = ErrorUtils.createErrorTypeConstructor("Unknown type parameter " + type.getTypeParameter() + ". Please try recompiling module containing \"" + this.containerPresentableName + Typography.quote);
            Intrinsics.checkExpressionValueIsNotNull(createErrorTypeConstructor, "ErrorUtils.createErrorTy…\\\"\"\n                    )");
            return createErrorTypeConstructor;
        } else if (type.hasTypeParameterName()) {
            DeclarationDescriptor containingDeclaration = this.c.getContainingDeclaration();
            String string = this.c.getNameResolver().getString(type.getTypeParameterName());
            Iterator<T> it = getOwnTypeParameters().iterator();
            while (true) {
                if (it.hasNext()) {
                    obj = it.next();
                    if (Intrinsics.areEqual(((TypeParameterDescriptor) obj).getName().asString(), string)) {
                        break;
                    }
                } else {
                    obj = null;
                    break;
                }
            }
            TypeParameterDescriptor typeParameterDescriptor = (TypeParameterDescriptor) obj;
            if (typeParameterDescriptor != null && (typeConstructor = typeParameterDescriptor.getTypeConstructor()) != null) {
                return typeConstructor;
            }
            TypeConstructor createErrorTypeConstructor2 = ErrorUtils.createErrorTypeConstructor("Deserialized type parameter " + string + " in " + containingDeclaration);
            Intrinsics.checkExpressionValueIsNotNull(createErrorTypeConstructor2, "ErrorUtils.createErrorTy…ter $name in $container\")");
            return createErrorTypeConstructor2;
        } else if (type.hasTypeAliasName()) {
            ClassifierDescriptor invoke2 = this.typeAliasDescriptors.invoke(Integer.valueOf(type.getTypeAliasName()));
            if (invoke2 == null) {
                invoke2 = typeDeserializer$typeConstructor$1.invoke(type.getTypeAliasName());
            }
            TypeConstructor typeConstructor3 = invoke2.getTypeConstructor();
            Intrinsics.checkExpressionValueIsNotNull(typeConstructor3, "(typeAliasDescriptors(pr…iasName)).typeConstructor");
            return typeConstructor3;
        } else {
            TypeConstructor createErrorTypeConstructor3 = ErrorUtils.createErrorTypeConstructor("Unknown type");
            Intrinsics.checkExpressionValueIsNotNull(createErrorTypeConstructor3, "ErrorUtils.createErrorTy…nstructor(\"Unknown type\")");
            return createErrorTypeConstructor3;
        }
    }

    public final SimpleType simpleType(final ProtoBuf.Type type) {
        SimpleType simpleType;
        SimpleType simpleType$default;
        if (type.hasClassName()) {
            simpleType = computeLocalClassifierReplacementType(type.getClassName());
        } else if (type.hasTypeAliasName()) {
            simpleType = computeLocalClassifierReplacementType(type.getTypeAliasName());
        } else {
            simpleType = null;
        }
        if (simpleType != null) {
            return simpleType;
        }
        TypeConstructor typeConstructor = typeConstructor(type);
        if (ErrorUtils.isError(typeConstructor.mo2101getDeclarationDescriptor())) {
            SimpleType createErrorTypeWithCustomConstructor = ErrorUtils.createErrorTypeWithCustomConstructor(typeConstructor.toString(), typeConstructor);
            Intrinsics.checkExpressionValueIsNotNull(createErrorTypeWithCustomConstructor, "ErrorUtils.createErrorTy….toString(), constructor)");
            return createErrorTypeWithCustomConstructor;
        }
        DeserializedAnnotations deserializedAnnotations = new DeserializedAnnotations(this.c.getStorageManager(), new Function0<List<? extends AnnotationDescriptor>>() { // from class: kotlin.reflect.jvm.internal.impl.serialization.deserialization.TypeDeserializer$simpleType$annotations$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            /* JADX DEBUG: Method merged with bridge method */
            /* JADX DEBUG: Return type fixed from 'java.util.List<kotlin.reflect.jvm.internal.impl.descriptors.annotations.AnnotationDescriptor>' to match base method */
            @Override // kotlin.jvm.functions.Function0
            public final List<? extends AnnotationDescriptor> invoke() {
                DeserializationContext deserializationContext;
                DeserializationContext deserializationContext2;
                deserializationContext = TypeDeserializer.this.c;
                AnnotationAndConstantLoader<AnnotationDescriptor, ConstantValue<?>> annotationAndConstantLoader = deserializationContext.getComponents().getAnnotationAndConstantLoader();
                ProtoBuf.Type type2 = type;
                deserializationContext2 = TypeDeserializer.this.c;
                return annotationAndConstantLoader.loadTypeAnnotations(type2, deserializationContext2.getNameResolver());
            }
        });
        List<ProtoBuf.Type.Argument> invoke = new Function1<ProtoBuf.Type, List<? extends ProtoBuf.Type.Argument>>() { // from class: kotlin.reflect.jvm.internal.impl.serialization.deserialization.TypeDeserializer$simpleType$1
            {
                super(1);
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // kotlin.jvm.functions.Function1
            public final List<ProtoBuf.Type.Argument> invoke(ProtoBuf.Type type2) {
                DeserializationContext deserializationContext;
                List<ProtoBuf.Type.Argument> list;
                List<ProtoBuf.Type.Argument> argumentList = type2.getArgumentList();
                Intrinsics.checkExpressionValueIsNotNull(argumentList, "argumentList");
                deserializationContext = TypeDeserializer.this.c;
                ProtoBuf.Type outerType = ProtoTypeTableUtilKt.outerType(type2, deserializationContext.getTypeTable());
                if (outerType != null) {
                    list = invoke(outerType);
                } else {
                    list = null;
                }
                if (list == null) {
                    list = CollectionsKt__CollectionsKt.emptyList();
                }
                return CollectionsKt___CollectionsKt.plus((Collection) argumentList, (Iterable) list);
            }
        }.invoke(type);
        ArrayList arrayList = new ArrayList(CollectionsKt__IterablesKt.collectionSizeOrDefault(invoke, 10));
        int i = 0;
        for (Object obj : invoke) {
            int i2 = i + 1;
            if (i < 0) {
                CollectionsKt__CollectionsKt.throwIndexOverflow();
            }
            List<TypeParameterDescriptor> parameters = typeConstructor.getParameters();
            Intrinsics.checkExpressionValueIsNotNull(parameters, "constructor.parameters");
            arrayList.add(typeArgument((TypeParameterDescriptor) CollectionsKt___CollectionsKt.getOrNull(parameters, i), (ProtoBuf.Type.Argument) obj));
            i = i2;
        }
        List<? extends TypeProjection> list = CollectionsKt___CollectionsKt.toList(arrayList);
        Boolean bool = Flags.SUSPEND_TYPE.get(type.getFlags());
        Intrinsics.checkExpressionValueIsNotNull(bool, "Flags.SUSPEND_TYPE.get(proto.flags)");
        if (bool.booleanValue()) {
            simpleType$default = createSuspendFunctionType(deserializedAnnotations, typeConstructor, list, type.getNullable());
        } else {
            simpleType$default = KotlinTypeFactory.simpleType$default(deserializedAnnotations, typeConstructor, list, type.getNullable(), null, 16, null);
        }
        ProtoBuf.Type abbreviatedType = ProtoTypeTableUtilKt.abbreviatedType(type, this.c.getTypeTable());
        if (abbreviatedType != null) {
            return SpecialTypesKt.withAbbreviation(simpleType$default, simpleType(abbreviatedType));
        }
        return simpleType$default;
    }

    public final boolean getExperimentalSuspendFunctionTypeEncountered() {
        return this.experimentalSuspendFunctionTypeEncountered;
    }

    public final List<TypeParameterDescriptor> getOwnTypeParameters() {
        return CollectionsKt___CollectionsKt.toList(this.typeParameterDescriptors.values());
    }

    public String toString() {
        String str;
        StringBuilder sb = new StringBuilder();
        sb.append(this.debugName);
        if (this.parent == null) {
            str = "";
        } else {
            str = ". Child of " + this.parent.debugName;
        }
        sb.append(str);
        return sb.toString();
    }

    public final KotlinType type(ProtoBuf.Type type) {
        if (type.hasFlexibleTypeCapabilitiesId()) {
            String string = this.c.getNameResolver().getString(type.getFlexibleTypeCapabilitiesId());
            SimpleType simpleType = simpleType(type);
            ProtoBuf.Type flexibleUpperBound = ProtoTypeTableUtilKt.flexibleUpperBound(type, this.c.getTypeTable());
            if (flexibleUpperBound == null) {
                Intrinsics.throwNpe();
            }
            return this.c.getComponents().getFlexibleTypeDeserializer().create(type, string, simpleType, simpleType(flexibleUpperBound));
        }
        return simpleType(type);
    }
}
