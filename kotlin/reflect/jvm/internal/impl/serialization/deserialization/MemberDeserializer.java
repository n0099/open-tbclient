package kotlin.reflect.jvm.internal.impl.serialization.deserialization;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import kotlin.Pair;
import kotlin.TypeCastException;
import kotlin.collections.CollectionsKt__CollectionsJVMKt;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.CollectionsKt__IterablesKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.collections.MapsKt__MapsKt;
import kotlin.comparisons.ComparisonsKt___ComparisonsJvmKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.builtins.FunctionTypesKt;
import kotlin.reflect.jvm.internal.impl.descriptors.CallableDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.CallableMemberDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassConstructorDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.Modality;
import kotlin.reflect.jvm.internal.impl.descriptors.PackageFragmentDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.PropertyDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ReceiverParameterDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.SimpleFunctionDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.SourceElement;
import kotlin.reflect.jvm.internal.impl.descriptors.TypeAliasDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.TypeParameterDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ValueParameterDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.Visibility;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.AnnotationDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.Annotations;
import kotlin.reflect.jvm.internal.impl.descriptors.impl.FieldDescriptorImpl;
import kotlin.reflect.jvm.internal.impl.descriptors.impl.PropertyGetterDescriptorImpl;
import kotlin.reflect.jvm.internal.impl.descriptors.impl.PropertySetterDescriptorImpl;
import kotlin.reflect.jvm.internal.impl.descriptors.impl.ValueParameterDescriptorImpl;
import kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf;
import kotlin.reflect.jvm.internal.impl.metadata.deserialization.Flags;
import kotlin.reflect.jvm.internal.impl.metadata.deserialization.ProtoTypeTableUtilKt;
import kotlin.reflect.jvm.internal.impl.metadata.deserialization.VersionRequirement;
import kotlin.reflect.jvm.internal.impl.metadata.deserialization.VersionRequirementTable;
import kotlin.reflect.jvm.internal.impl.name.Name;
import kotlin.reflect.jvm.internal.impl.protobuf.MessageLite;
import kotlin.reflect.jvm.internal.impl.resolve.DescriptorFactory;
import kotlin.reflect.jvm.internal.impl.resolve.constants.ConstantValue;
import kotlin.reflect.jvm.internal.impl.resolve.descriptorUtil.DescriptorUtilsKt;
import kotlin.reflect.jvm.internal.impl.serialization.deserialization.ProtoContainer;
import kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.DeserializedAnnotations;
import kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.DeserializedCallableMemberDescriptor;
import kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.DeserializedClassConstructorDescriptor;
import kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.DeserializedClassDescriptor;
import kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.DeserializedMemberDescriptor;
import kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.DeserializedPropertyDescriptor;
import kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.DeserializedSimpleFunctionDescriptor;
import kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.DeserializedTypeAliasDescriptor;
import kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.NonEmptyDeserializedAnnotations;
import kotlin.reflect.jvm.internal.impl.types.KotlinType;
import kotlin.reflect.jvm.internal.impl.types.TypeProjection;
import kotlin.reflect.jvm.internal.impl.types.typeUtil.TypeUtilsKt;
/* loaded from: classes2.dex */
public final class MemberDeserializer {
    public final AnnotationDeserializer annotationDeserializer;
    public final DeserializationContext c;

    private final int loadOldFlags(int i) {
        return (i & 63) + ((i >> 8) << 6);
    }

    public MemberDeserializer(DeserializationContext deserializationContext) {
        this.c = deserializationContext;
        this.annotationDeserializer = new AnnotationDeserializer(deserializationContext.getComponents().getModuleDescriptor(), this.c.getComponents().getNotFoundClasses());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final ProtoContainer asProtoContainer(DeclarationDescriptor declarationDescriptor) {
        if (declarationDescriptor instanceof PackageFragmentDescriptor) {
            return new ProtoContainer.Package(((PackageFragmentDescriptor) declarationDescriptor).getFqName(), this.c.getNameResolver(), this.c.getTypeTable(), this.c.getContainerSource());
        }
        if (declarationDescriptor instanceof DeserializedClassDescriptor) {
            return ((DeserializedClassDescriptor) declarationDescriptor).getThisAsProtoContainer$deserialization();
        }
        return null;
    }

    private final boolean containsSuspendFunctionType(KotlinType kotlinType) {
        return TypeUtilsKt.contains(kotlinType, MemberDeserializer$containsSuspendFunctionType$1.INSTANCE);
    }

    private final void forceUpperBoundsComputation(TypeDeserializer typeDeserializer) {
        for (TypeParameterDescriptor typeParameterDescriptor : typeDeserializer.getOwnTypeParameters()) {
            typeParameterDescriptor.getUpperBounds();
        }
    }

    private final DeserializedMemberDescriptor.CoroutinesCompatibilityMode checkExperimentalCoroutine(DeserializedMemberDescriptor deserializedMemberDescriptor, TypeDeserializer typeDeserializer) {
        if (!versionAndReleaseCoroutinesMismatch(deserializedMemberDescriptor)) {
            return DeserializedMemberDescriptor.CoroutinesCompatibilityMode.COMPATIBLE;
        }
        forceUpperBoundsComputation(typeDeserializer);
        if (typeDeserializer.getExperimentalSuspendFunctionTypeEncountered()) {
            return DeserializedMemberDescriptor.CoroutinesCompatibilityMode.INCOMPATIBLE;
        }
        return DeserializedMemberDescriptor.CoroutinesCompatibilityMode.COMPATIBLE;
    }

    private final Annotations getPropertyFieldAnnotations(final ProtoBuf.Property property, final boolean z) {
        if (!Flags.HAS_ANNOTATIONS.get(property.getFlags()).booleanValue()) {
            return Annotations.Companion.getEMPTY();
        }
        return new NonEmptyDeserializedAnnotations(this.c.getStorageManager(), new Function0<List<? extends AnnotationDescriptor>>() { // from class: kotlin.reflect.jvm.internal.impl.serialization.deserialization.MemberDeserializer$getPropertyFieldAnnotations$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            /* JADX DEBUG: Method merged with bridge method */
            /* JADX DEBUG: Return type fixed from 'java.util.List<kotlin.reflect.jvm.internal.impl.descriptors.annotations.AnnotationDescriptor>' to match base method */
            @Override // kotlin.jvm.functions.Function0
            public final List<? extends AnnotationDescriptor> invoke() {
                DeserializationContext deserializationContext;
                ProtoContainer asProtoContainer;
                List<? extends AnnotationDescriptor> list;
                DeserializationContext deserializationContext2;
                DeserializationContext deserializationContext3;
                MemberDeserializer memberDeserializer = MemberDeserializer.this;
                deserializationContext = memberDeserializer.c;
                asProtoContainer = memberDeserializer.asProtoContainer(deserializationContext.getContainingDeclaration());
                if (asProtoContainer != null) {
                    if (z) {
                        deserializationContext3 = MemberDeserializer.this.c;
                        list = CollectionsKt___CollectionsKt.toList(deserializationContext3.getComponents().getAnnotationAndConstantLoader().loadPropertyDelegateFieldAnnotations(asProtoContainer, property));
                    } else {
                        deserializationContext2 = MemberDeserializer.this.c;
                        list = CollectionsKt___CollectionsKt.toList(deserializationContext2.getComponents().getAnnotationAndConstantLoader().loadPropertyBackingFieldAnnotations(asProtoContainer, property));
                    }
                } else {
                    list = null;
                }
                if (list == null) {
                    return CollectionsKt__CollectionsKt.emptyList();
                }
                return list;
            }
        });
    }

    private final Annotations getReceiverParameterAnnotations(final MessageLite messageLite, final AnnotatedCallableKind annotatedCallableKind) {
        return new DeserializedAnnotations(this.c.getStorageManager(), new Function0<List<? extends AnnotationDescriptor>>() { // from class: kotlin.reflect.jvm.internal.impl.serialization.deserialization.MemberDeserializer$getReceiverParameterAnnotations$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            /* JADX DEBUG: Method merged with bridge method */
            /* JADX DEBUG: Return type fixed from 'java.util.List<kotlin.reflect.jvm.internal.impl.descriptors.annotations.AnnotationDescriptor>' to match base method */
            @Override // kotlin.jvm.functions.Function0
            public final List<? extends AnnotationDescriptor> invoke() {
                DeserializationContext deserializationContext;
                ProtoContainer asProtoContainer;
                List<AnnotationDescriptor> list;
                DeserializationContext deserializationContext2;
                MemberDeserializer memberDeserializer = MemberDeserializer.this;
                deserializationContext = memberDeserializer.c;
                asProtoContainer = memberDeserializer.asProtoContainer(deserializationContext.getContainingDeclaration());
                if (asProtoContainer != null) {
                    deserializationContext2 = MemberDeserializer.this.c;
                    list = deserializationContext2.getComponents().getAnnotationAndConstantLoader().loadExtensionReceiverParameterAnnotations(asProtoContainer, messageLite, annotatedCallableKind);
                } else {
                    list = null;
                }
                if (list == null) {
                    return CollectionsKt__CollectionsKt.emptyList();
                }
                return list;
            }
        });
    }

    private final DeserializedMemberDescriptor.CoroutinesCompatibilityMode computeExperimentalityModeForFunctions(DeserializedCallableMemberDescriptor deserializedCallableMemberDescriptor, ReceiverParameterDescriptor receiverParameterDescriptor, Collection<? extends ValueParameterDescriptor> collection, Collection<? extends TypeParameterDescriptor> collection2, KotlinType kotlinType, boolean z) {
        KotlinType kotlinType2;
        boolean z2;
        boolean z3;
        DeserializedMemberDescriptor.CoroutinesCompatibilityMode coroutinesCompatibilityMode;
        DeserializedMemberDescriptor.CoroutinesCompatibilityMode coroutinesCompatibilityMode2;
        boolean z4;
        if (!versionAndReleaseCoroutinesMismatch(deserializedCallableMemberDescriptor)) {
            return DeserializedMemberDescriptor.CoroutinesCompatibilityMode.COMPATIBLE;
        }
        if (Intrinsics.areEqual(DescriptorUtilsKt.fqNameOrNull(deserializedCallableMemberDescriptor), SuspendFunctionTypeUtilKt.KOTLIN_SUSPEND_BUILT_IN_FUNCTION_FQ_NAME)) {
            return DeserializedMemberDescriptor.CoroutinesCompatibilityMode.COMPATIBLE;
        }
        ArrayList arrayList = new ArrayList(CollectionsKt__IterablesKt.collectionSizeOrDefault(collection, 10));
        for (ValueParameterDescriptor valueParameterDescriptor : collection) {
            arrayList.add(valueParameterDescriptor.getType());
        }
        if (receiverParameterDescriptor != null) {
            kotlinType2 = receiverParameterDescriptor.getType();
        } else {
            kotlinType2 = null;
        }
        List<KotlinType> plus = CollectionsKt___CollectionsKt.plus((Collection) arrayList, (Iterable) CollectionsKt__CollectionsKt.listOfNotNull(kotlinType2));
        if (kotlinType != null && containsSuspendFunctionType(kotlinType)) {
            return DeserializedMemberDescriptor.CoroutinesCompatibilityMode.INCOMPATIBLE;
        }
        if (!(collection2 instanceof Collection) || !collection2.isEmpty()) {
            for (TypeParameterDescriptor typeParameterDescriptor : collection2) {
                List<KotlinType> upperBounds = typeParameterDescriptor.getUpperBounds();
                Intrinsics.checkExpressionValueIsNotNull(upperBounds, "typeParameter.upperBounds");
                if (!(upperBounds instanceof Collection) || !upperBounds.isEmpty()) {
                    for (KotlinType it : upperBounds) {
                        Intrinsics.checkExpressionValueIsNotNull(it, "it");
                        if (containsSuspendFunctionType(it)) {
                            z2 = true;
                            continue;
                            break;
                        }
                    }
                }
                z2 = false;
                continue;
                if (z2) {
                    z3 = true;
                    break;
                }
            }
        }
        z3 = false;
        if (z3) {
            return DeserializedMemberDescriptor.CoroutinesCompatibilityMode.INCOMPATIBLE;
        }
        ArrayList arrayList2 = new ArrayList(CollectionsKt__IterablesKt.collectionSizeOrDefault(plus, 10));
        for (KotlinType type : plus) {
            Intrinsics.checkExpressionValueIsNotNull(type, "type");
            if (FunctionTypesKt.isSuspendFunctionType(type) && type.getArguments().size() <= 3) {
                List<TypeProjection> arguments = type.getArguments();
                if (!(arguments instanceof Collection) || !arguments.isEmpty()) {
                    for (TypeProjection typeProjection : arguments) {
                        KotlinType type2 = typeProjection.getType();
                        Intrinsics.checkExpressionValueIsNotNull(type2, "it.type");
                        if (containsSuspendFunctionType(type2)) {
                            z4 = true;
                            break;
                        }
                    }
                }
                z4 = false;
                if (z4) {
                    coroutinesCompatibilityMode2 = DeserializedMemberDescriptor.CoroutinesCompatibilityMode.INCOMPATIBLE;
                } else {
                    coroutinesCompatibilityMode2 = DeserializedMemberDescriptor.CoroutinesCompatibilityMode.NEEDS_WRAPPER;
                }
            } else if (containsSuspendFunctionType(type)) {
                coroutinesCompatibilityMode2 = DeserializedMemberDescriptor.CoroutinesCompatibilityMode.INCOMPATIBLE;
            } else {
                coroutinesCompatibilityMode2 = DeserializedMemberDescriptor.CoroutinesCompatibilityMode.COMPATIBLE;
            }
            arrayList2.add(coroutinesCompatibilityMode2);
        }
        DeserializedMemberDescriptor.CoroutinesCompatibilityMode coroutinesCompatibilityMode3 = (DeserializedMemberDescriptor.CoroutinesCompatibilityMode) CollectionsKt___CollectionsKt.max((Iterable) arrayList2);
        if (coroutinesCompatibilityMode3 == null) {
            coroutinesCompatibilityMode3 = DeserializedMemberDescriptor.CoroutinesCompatibilityMode.COMPATIBLE;
        }
        if (z) {
            coroutinesCompatibilityMode = DeserializedMemberDescriptor.CoroutinesCompatibilityMode.NEEDS_WRAPPER;
        } else {
            coroutinesCompatibilityMode = DeserializedMemberDescriptor.CoroutinesCompatibilityMode.COMPATIBLE;
        }
        return (DeserializedMemberDescriptor.CoroutinesCompatibilityMode) ComparisonsKt___ComparisonsJvmKt.maxOf(coroutinesCompatibilityMode, coroutinesCompatibilityMode3);
    }

    private final Annotations getAnnotations(final MessageLite messageLite, int i, final AnnotatedCallableKind annotatedCallableKind) {
        if (!Flags.HAS_ANNOTATIONS.get(i).booleanValue()) {
            return Annotations.Companion.getEMPTY();
        }
        return new NonEmptyDeserializedAnnotations(this.c.getStorageManager(), new Function0<List<? extends AnnotationDescriptor>>() { // from class: kotlin.reflect.jvm.internal.impl.serialization.deserialization.MemberDeserializer$getAnnotations$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            /* JADX DEBUG: Method merged with bridge method */
            /* JADX DEBUG: Return type fixed from 'java.util.List<kotlin.reflect.jvm.internal.impl.descriptors.annotations.AnnotationDescriptor>' to match base method */
            @Override // kotlin.jvm.functions.Function0
            public final List<? extends AnnotationDescriptor> invoke() {
                DeserializationContext deserializationContext;
                ProtoContainer asProtoContainer;
                List<? extends AnnotationDescriptor> list;
                DeserializationContext deserializationContext2;
                MemberDeserializer memberDeserializer = MemberDeserializer.this;
                deserializationContext = memberDeserializer.c;
                asProtoContainer = memberDeserializer.asProtoContainer(deserializationContext.getContainingDeclaration());
                if (asProtoContainer != null) {
                    deserializationContext2 = MemberDeserializer.this.c;
                    list = CollectionsKt___CollectionsKt.toList(deserializationContext2.getComponents().getAnnotationAndConstantLoader().loadCallableAnnotations(asProtoContainer, messageLite, annotatedCallableKind));
                } else {
                    list = null;
                }
                if (list == null) {
                    return CollectionsKt__CollectionsKt.emptyList();
                }
                return list;
            }
        });
    }

    private final ReceiverParameterDescriptor getDispatchReceiverParameter() {
        DeclarationDescriptor containingDeclaration = this.c.getContainingDeclaration();
        if (!(containingDeclaration instanceof ClassDescriptor)) {
            containingDeclaration = null;
        }
        ClassDescriptor classDescriptor = (ClassDescriptor) containingDeclaration;
        if (classDescriptor == null) {
            return null;
        }
        return classDescriptor.getThisAsReceiverParameter();
    }

    private final void initializeWithCoroutinesExperimentalityStatus(DeserializedSimpleFunctionDescriptor deserializedSimpleFunctionDescriptor, ReceiverParameterDescriptor receiverParameterDescriptor, ReceiverParameterDescriptor receiverParameterDescriptor2, List<? extends TypeParameterDescriptor> list, List<? extends ValueParameterDescriptor> list2, KotlinType kotlinType, Modality modality, Visibility visibility, Map<? extends CallableDescriptor.UserDataKey<?>, ?> map, boolean z) {
        deserializedSimpleFunctionDescriptor.initialize(receiverParameterDescriptor, receiverParameterDescriptor2, list, list2, kotlinType, modality, visibility, map, computeExperimentalityModeForFunctions(deserializedSimpleFunctionDescriptor, receiverParameterDescriptor, list2, list, kotlinType, z));
    }

    /* JADX WARN: Removed duplicated region for block: B:21:0x00e5  */
    /* JADX WARN: Removed duplicated region for block: B:22:0x00f0  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private final List<ValueParameterDescriptor> valueParameters(List<ProtoBuf.ValueParameter> list, final MessageLite messageLite, final AnnotatedCallableKind annotatedCallableKind) {
        int i;
        NonEmptyDeserializedAnnotations empty;
        ProtoBuf.Type varargElementType;
        KotlinType kotlinType;
        DeclarationDescriptor containingDeclaration = this.c.getContainingDeclaration();
        if (containingDeclaration != null) {
            final CallableDescriptor callableDescriptor = (CallableDescriptor) containingDeclaration;
            DeclarationDescriptor containingDeclaration2 = callableDescriptor.getContainingDeclaration();
            Intrinsics.checkExpressionValueIsNotNull(containingDeclaration2, "callableDescriptor.containingDeclaration");
            final ProtoContainer asProtoContainer = asProtoContainer(containingDeclaration2);
            ArrayList arrayList = new ArrayList(CollectionsKt__IterablesKt.collectionSizeOrDefault(list, 10));
            int i2 = 0;
            for (Object obj : list) {
                int i3 = i2 + 1;
                if (i2 < 0) {
                    CollectionsKt__CollectionsKt.throwIndexOverflow();
                }
                final ProtoBuf.ValueParameter valueParameter = (ProtoBuf.ValueParameter) obj;
                if (valueParameter.hasFlags()) {
                    i = valueParameter.getFlags();
                } else {
                    i = 0;
                }
                if (asProtoContainer != null) {
                    Boolean bool = Flags.HAS_ANNOTATIONS.get(i);
                    Intrinsics.checkExpressionValueIsNotNull(bool, "Flags.HAS_ANNOTATIONS.get(flags)");
                    if (bool.booleanValue()) {
                        final int i4 = i2;
                        empty = new NonEmptyDeserializedAnnotations(this.c.getStorageManager(), new Function0<List<? extends AnnotationDescriptor>>() { // from class: kotlin.reflect.jvm.internal.impl.serialization.deserialization.MemberDeserializer$valueParameters$$inlined$mapIndexed$lambda$1
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            {
                                super(0);
                            }

                            /* JADX DEBUG: Method merged with bridge method */
                            /* JADX DEBUG: Return type fixed from 'java.util.List<kotlin.reflect.jvm.internal.impl.descriptors.annotations.AnnotationDescriptor>' to match base method */
                            @Override // kotlin.jvm.functions.Function0
                            public final List<? extends AnnotationDescriptor> invoke() {
                                DeserializationContext deserializationContext;
                                deserializationContext = this.c;
                                return CollectionsKt___CollectionsKt.toList(deserializationContext.getComponents().getAnnotationAndConstantLoader().loadValueParameterAnnotations(asProtoContainer, messageLite, annotatedCallableKind, i4, valueParameter));
                            }
                        });
                        Name name = NameResolverUtilKt.getName(this.c.getNameResolver(), valueParameter.getName());
                        KotlinType type = this.c.getTypeDeserializer().type(ProtoTypeTableUtilKt.type(valueParameter, this.c.getTypeTable()));
                        Boolean bool2 = Flags.DECLARES_DEFAULT_VALUE.get(i);
                        Intrinsics.checkExpressionValueIsNotNull(bool2, "Flags.DECLARES_DEFAULT_VALUE.get(flags)");
                        boolean booleanValue = bool2.booleanValue();
                        Boolean bool3 = Flags.IS_CROSSINLINE.get(i);
                        Intrinsics.checkExpressionValueIsNotNull(bool3, "Flags.IS_CROSSINLINE.get(flags)");
                        boolean booleanValue2 = bool3.booleanValue();
                        Boolean bool4 = Flags.IS_NOINLINE.get(i);
                        Intrinsics.checkExpressionValueIsNotNull(bool4, "Flags.IS_NOINLINE.get(flags)");
                        boolean booleanValue3 = bool4.booleanValue();
                        varargElementType = ProtoTypeTableUtilKt.varargElementType(valueParameter, this.c.getTypeTable());
                        if (varargElementType == null) {
                            kotlinType = this.c.getTypeDeserializer().type(varargElementType);
                        } else {
                            kotlinType = null;
                        }
                        KotlinType kotlinType2 = kotlinType;
                        SourceElement sourceElement = SourceElement.NO_SOURCE;
                        Intrinsics.checkExpressionValueIsNotNull(sourceElement, "SourceElement.NO_SOURCE");
                        ArrayList arrayList2 = arrayList;
                        arrayList2.add(new ValueParameterDescriptorImpl(callableDescriptor, null, i2, empty, name, type, booleanValue, booleanValue2, booleanValue3, kotlinType2, sourceElement));
                        arrayList = arrayList2;
                        i2 = i3;
                    }
                }
                empty = Annotations.Companion.getEMPTY();
                Name name2 = NameResolverUtilKt.getName(this.c.getNameResolver(), valueParameter.getName());
                KotlinType type2 = this.c.getTypeDeserializer().type(ProtoTypeTableUtilKt.type(valueParameter, this.c.getTypeTable()));
                Boolean bool22 = Flags.DECLARES_DEFAULT_VALUE.get(i);
                Intrinsics.checkExpressionValueIsNotNull(bool22, "Flags.DECLARES_DEFAULT_VALUE.get(flags)");
                boolean booleanValue4 = bool22.booleanValue();
                Boolean bool32 = Flags.IS_CROSSINLINE.get(i);
                Intrinsics.checkExpressionValueIsNotNull(bool32, "Flags.IS_CROSSINLINE.get(flags)");
                boolean booleanValue22 = bool32.booleanValue();
                Boolean bool42 = Flags.IS_NOINLINE.get(i);
                Intrinsics.checkExpressionValueIsNotNull(bool42, "Flags.IS_NOINLINE.get(flags)");
                boolean booleanValue32 = bool42.booleanValue();
                varargElementType = ProtoTypeTableUtilKt.varargElementType(valueParameter, this.c.getTypeTable());
                if (varargElementType == null) {
                }
                KotlinType kotlinType22 = kotlinType;
                SourceElement sourceElement2 = SourceElement.NO_SOURCE;
                Intrinsics.checkExpressionValueIsNotNull(sourceElement2, "SourceElement.NO_SOURCE");
                ArrayList arrayList22 = arrayList;
                arrayList22.add(new ValueParameterDescriptorImpl(callableDescriptor, null, i2, empty, name2, type2, booleanValue4, booleanValue22, booleanValue32, kotlinType22, sourceElement2));
                arrayList = arrayList22;
                i2 = i3;
            }
            return CollectionsKt___CollectionsKt.toList(arrayList);
        }
        throw new TypeCastException("null cannot be cast to non-null type org.jetbrains.kotlin.descriptors.CallableDescriptor");
    }

    private final boolean versionAndReleaseCoroutinesMismatch(DeserializedMemberDescriptor deserializedMemberDescriptor) {
        boolean z;
        boolean z2;
        if (!this.c.getComponents().getConfiguration().getReleaseCoroutines()) {
            return false;
        }
        List<VersionRequirement> versionRequirements = deserializedMemberDescriptor.getVersionRequirements();
        if (!(versionRequirements instanceof Collection) || !versionRequirements.isEmpty()) {
            for (VersionRequirement versionRequirement : versionRequirements) {
                if (Intrinsics.areEqual(versionRequirement.getVersion(), new VersionRequirement.Version(1, 3, 0, 4, null)) && versionRequirement.getKind() == ProtoBuf.VersionRequirement.VersionKind.LANGUAGE_VERSION) {
                    z = true;
                    continue;
                } else {
                    z = false;
                    continue;
                }
                if (z) {
                    z2 = false;
                    break;
                }
            }
        }
        z2 = true;
        if (!z2) {
            return false;
        }
        return true;
    }

    public final ClassConstructorDescriptor loadConstructor(ProtoBuf.Constructor constructor, boolean z) {
        DeserializedClassConstructorDescriptor deserializedClassConstructorDescriptor;
        DeserializedMemberDescriptor.CoroutinesCompatibilityMode computeExperimentalityModeForFunctions;
        DeserializationContext c;
        TypeDeserializer typeDeserializer;
        DeclarationDescriptor containingDeclaration = this.c.getContainingDeclaration();
        if (containingDeclaration != null) {
            ClassDescriptor classDescriptor = (ClassDescriptor) containingDeclaration;
            DeserializedClassConstructorDescriptor deserializedClassConstructorDescriptor2 = new DeserializedClassConstructorDescriptor(classDescriptor, null, getAnnotations(constructor, constructor.getFlags(), AnnotatedCallableKind.FUNCTION), z, CallableMemberDescriptor.Kind.DECLARATION, constructor, this.c.getNameResolver(), this.c.getTypeTable(), this.c.getVersionRequirementTable(), this.c.getContainerSource(), null, 1024, null);
            MemberDeserializer memberDeserializer = DeserializationContext.childContext$default(this.c, deserializedClassConstructorDescriptor2, CollectionsKt__CollectionsKt.emptyList(), null, null, null, null, 60, null).getMemberDeserializer();
            List<ProtoBuf.ValueParameter> valueParameterList = constructor.getValueParameterList();
            Intrinsics.checkExpressionValueIsNotNull(valueParameterList, "proto.valueParameterList");
            deserializedClassConstructorDescriptor2.initialize(memberDeserializer.valueParameters(valueParameterList, constructor, AnnotatedCallableKind.FUNCTION), ProtoEnumFlags.INSTANCE.visibility(Flags.VISIBILITY.get(constructor.getFlags())));
            deserializedClassConstructorDescriptor2.setReturnType(classDescriptor.getDefaultType());
            DeclarationDescriptor containingDeclaration2 = this.c.getContainingDeclaration();
            if (!(containingDeclaration2 instanceof DeserializedClassDescriptor)) {
                containingDeclaration2 = null;
            }
            DeserializedClassDescriptor deserializedClassDescriptor = (DeserializedClassDescriptor) containingDeclaration2;
            boolean z2 = true;
            if ((deserializedClassDescriptor == null || (c = deserializedClassDescriptor.getC()) == null || (typeDeserializer = c.getTypeDeserializer()) == null || !typeDeserializer.getExperimentalSuspendFunctionTypeEncountered() || !versionAndReleaseCoroutinesMismatch(deserializedClassConstructorDescriptor2)) ? false : false) {
                computeExperimentalityModeForFunctions = DeserializedMemberDescriptor.CoroutinesCompatibilityMode.INCOMPATIBLE;
                deserializedClassConstructorDescriptor = deserializedClassConstructorDescriptor2;
            } else {
                Collection<? extends ValueParameterDescriptor> valueParameters = deserializedClassConstructorDescriptor2.getValueParameters();
                Intrinsics.checkExpressionValueIsNotNull(valueParameters, "descriptor.valueParameters");
                Collection<? extends TypeParameterDescriptor> typeParameters = deserializedClassConstructorDescriptor2.getTypeParameters();
                Intrinsics.checkExpressionValueIsNotNull(typeParameters, "descriptor.typeParameters");
                deserializedClassConstructorDescriptor = deserializedClassConstructorDescriptor2;
                computeExperimentalityModeForFunctions = computeExperimentalityModeForFunctions(deserializedClassConstructorDescriptor2, null, valueParameters, typeParameters, deserializedClassConstructorDescriptor2.getReturnType(), false);
            }
            deserializedClassConstructorDescriptor.setCoroutinesExperimentalCompatibilityMode$deserialization(computeExperimentalityModeForFunctions);
            return deserializedClassConstructorDescriptor;
        }
        throw new TypeCastException("null cannot be cast to non-null type org.jetbrains.kotlin.descriptors.ClassDescriptor");
    }

    public final SimpleFunctionDescriptor loadFunction(ProtoBuf.Function function) {
        int loadOldFlags;
        Annotations empty;
        VersionRequirementTable versionRequirementTable;
        ReceiverParameterDescriptor receiverParameterDescriptor;
        KotlinType type;
        if (function.hasFlags()) {
            loadOldFlags = function.getFlags();
        } else {
            loadOldFlags = loadOldFlags(function.getOldFlags());
        }
        int i = loadOldFlags;
        Annotations annotations = getAnnotations(function, i, AnnotatedCallableKind.FUNCTION);
        if (ProtoTypeTableUtilKt.hasReceiver(function)) {
            empty = getReceiverParameterAnnotations(function, AnnotatedCallableKind.FUNCTION);
        } else {
            empty = Annotations.Companion.getEMPTY();
        }
        if (Intrinsics.areEqual(DescriptorUtilsKt.getFqNameSafe(this.c.getContainingDeclaration()).child(NameResolverUtilKt.getName(this.c.getNameResolver(), function.getName())), SuspendFunctionTypeUtilKt.KOTLIN_SUSPEND_BUILT_IN_FUNCTION_FQ_NAME)) {
            versionRequirementTable = VersionRequirementTable.Companion.getEMPTY();
        } else {
            versionRequirementTable = this.c.getVersionRequirementTable();
        }
        DeserializedSimpleFunctionDescriptor deserializedSimpleFunctionDescriptor = new DeserializedSimpleFunctionDescriptor(this.c.getContainingDeclaration(), null, annotations, NameResolverUtilKt.getName(this.c.getNameResolver(), function.getName()), ProtoEnumFlags.INSTANCE.memberKind(Flags.MEMBER_KIND.get(i)), function, this.c.getNameResolver(), this.c.getTypeTable(), versionRequirementTable, this.c.getContainerSource(), null, 1024, null);
        DeserializationContext deserializationContext = this.c;
        List<ProtoBuf.TypeParameter> typeParameterList = function.getTypeParameterList();
        Intrinsics.checkExpressionValueIsNotNull(typeParameterList, "proto.typeParameterList");
        DeserializationContext childContext$default = DeserializationContext.childContext$default(deserializationContext, deserializedSimpleFunctionDescriptor, typeParameterList, null, null, null, null, 60, null);
        ProtoBuf.Type receiverType = ProtoTypeTableUtilKt.receiverType(function, this.c.getTypeTable());
        if (receiverType != null && (type = childContext$default.getTypeDeserializer().type(receiverType)) != null) {
            receiverParameterDescriptor = DescriptorFactory.createExtensionReceiverParameterForCallable(deserializedSimpleFunctionDescriptor, type, empty);
        } else {
            receiverParameterDescriptor = null;
        }
        ReceiverParameterDescriptor receiverParameterDescriptor2 = receiverParameterDescriptor;
        ReceiverParameterDescriptor dispatchReceiverParameter = getDispatchReceiverParameter();
        List<TypeParameterDescriptor> ownTypeParameters = childContext$default.getTypeDeserializer().getOwnTypeParameters();
        MemberDeserializer memberDeserializer = childContext$default.getMemberDeserializer();
        List<ProtoBuf.ValueParameter> valueParameterList = function.getValueParameterList();
        Intrinsics.checkExpressionValueIsNotNull(valueParameterList, "proto.valueParameterList");
        List<ValueParameterDescriptor> valueParameters = memberDeserializer.valueParameters(valueParameterList, function, AnnotatedCallableKind.FUNCTION);
        KotlinType type2 = childContext$default.getTypeDeserializer().type(ProtoTypeTableUtilKt.returnType(function, this.c.getTypeTable()));
        Modality modality = ProtoEnumFlags.INSTANCE.modality(Flags.MODALITY.get(i));
        Visibility visibility = ProtoEnumFlags.INSTANCE.visibility(Flags.VISIBILITY.get(i));
        Map<? extends CallableDescriptor.UserDataKey<?>, ?> emptyMap = MapsKt__MapsKt.emptyMap();
        Boolean bool = Flags.IS_SUSPEND.get(i);
        Intrinsics.checkExpressionValueIsNotNull(bool, "Flags.IS_SUSPEND.get(flags)");
        initializeWithCoroutinesExperimentalityStatus(deserializedSimpleFunctionDescriptor, receiverParameterDescriptor2, dispatchReceiverParameter, ownTypeParameters, valueParameters, type2, modality, visibility, emptyMap, bool.booleanValue());
        Boolean bool2 = Flags.IS_OPERATOR.get(i);
        Intrinsics.checkExpressionValueIsNotNull(bool2, "Flags.IS_OPERATOR.get(flags)");
        deserializedSimpleFunctionDescriptor.setOperator(bool2.booleanValue());
        Boolean bool3 = Flags.IS_INFIX.get(i);
        Intrinsics.checkExpressionValueIsNotNull(bool3, "Flags.IS_INFIX.get(flags)");
        deserializedSimpleFunctionDescriptor.setInfix(bool3.booleanValue());
        Boolean bool4 = Flags.IS_EXTERNAL_FUNCTION.get(i);
        Intrinsics.checkExpressionValueIsNotNull(bool4, "Flags.IS_EXTERNAL_FUNCTION.get(flags)");
        deserializedSimpleFunctionDescriptor.setExternal(bool4.booleanValue());
        Boolean bool5 = Flags.IS_INLINE.get(i);
        Intrinsics.checkExpressionValueIsNotNull(bool5, "Flags.IS_INLINE.get(flags)");
        deserializedSimpleFunctionDescriptor.setInline(bool5.booleanValue());
        Boolean bool6 = Flags.IS_TAILREC.get(i);
        Intrinsics.checkExpressionValueIsNotNull(bool6, "Flags.IS_TAILREC.get(flags)");
        deserializedSimpleFunctionDescriptor.setTailrec(bool6.booleanValue());
        Boolean bool7 = Flags.IS_SUSPEND.get(i);
        Intrinsics.checkExpressionValueIsNotNull(bool7, "Flags.IS_SUSPEND.get(flags)");
        deserializedSimpleFunctionDescriptor.setSuspend(bool7.booleanValue());
        Boolean bool8 = Flags.IS_EXPECT_FUNCTION.get(i);
        Intrinsics.checkExpressionValueIsNotNull(bool8, "Flags.IS_EXPECT_FUNCTION.get(flags)");
        deserializedSimpleFunctionDescriptor.setExpect(bool8.booleanValue());
        Pair<CallableDescriptor.UserDataKey<?>, Object> deserializeContractFromFunction = this.c.getComponents().getContractDeserializer().deserializeContractFromFunction(function, deserializedSimpleFunctionDescriptor, this.c.getTypeTable(), this.c.getTypeDeserializer());
        if (deserializeContractFromFunction != null) {
            deserializedSimpleFunctionDescriptor.putInUserDataMap(deserializeContractFromFunction.getFirst(), deserializeContractFromFunction.getSecond());
        }
        return deserializedSimpleFunctionDescriptor;
    }

    public final PropertyDescriptor loadProperty(ProtoBuf.Property property) {
        int loadOldFlags;
        ProtoBuf.Property property2;
        Annotations empty;
        DeserializedPropertyDescriptor deserializedPropertyDescriptor;
        ReceiverParameterDescriptor receiverParameterDescriptor;
        PropertyGetterDescriptorImpl propertyGetterDescriptorImpl;
        final DeserializedPropertyDescriptor deserializedPropertyDescriptor2;
        final ProtoBuf.Property property3;
        int i;
        boolean z;
        PropertySetterDescriptorImpl propertySetterDescriptorImpl;
        int i2;
        PropertyGetterDescriptorImpl createDefaultGetter;
        KotlinType type;
        if (property.hasFlags()) {
            loadOldFlags = property.getFlags();
        } else {
            loadOldFlags = loadOldFlags(property.getOldFlags());
        }
        int i3 = loadOldFlags;
        DeclarationDescriptor containingDeclaration = this.c.getContainingDeclaration();
        Annotations annotations = getAnnotations(property, i3, AnnotatedCallableKind.PROPERTY);
        Modality modality = ProtoEnumFlags.INSTANCE.modality(Flags.MODALITY.get(i3));
        Visibility visibility = ProtoEnumFlags.INSTANCE.visibility(Flags.VISIBILITY.get(i3));
        Boolean bool = Flags.IS_VAR.get(i3);
        Intrinsics.checkExpressionValueIsNotNull(bool, "Flags.IS_VAR.get(flags)");
        boolean booleanValue = bool.booleanValue();
        Name name = NameResolverUtilKt.getName(this.c.getNameResolver(), property.getName());
        CallableMemberDescriptor.Kind memberKind = ProtoEnumFlags.INSTANCE.memberKind(Flags.MEMBER_KIND.get(i3));
        Boolean bool2 = Flags.IS_LATEINIT.get(i3);
        Intrinsics.checkExpressionValueIsNotNull(bool2, "Flags.IS_LATEINIT.get(flags)");
        boolean booleanValue2 = bool2.booleanValue();
        Boolean bool3 = Flags.IS_CONST.get(i3);
        Intrinsics.checkExpressionValueIsNotNull(bool3, "Flags.IS_CONST.get(flags)");
        boolean booleanValue3 = bool3.booleanValue();
        Boolean bool4 = Flags.IS_EXTERNAL_PROPERTY.get(i3);
        Intrinsics.checkExpressionValueIsNotNull(bool4, "Flags.IS_EXTERNAL_PROPERTY.get(flags)");
        boolean booleanValue4 = bool4.booleanValue();
        Boolean bool5 = Flags.IS_DELEGATED.get(i3);
        Intrinsics.checkExpressionValueIsNotNull(bool5, "Flags.IS_DELEGATED.get(flags)");
        boolean booleanValue5 = bool5.booleanValue();
        Boolean bool6 = Flags.IS_EXPECT_PROPERTY.get(i3);
        Intrinsics.checkExpressionValueIsNotNull(bool6, "Flags.IS_EXPECT_PROPERTY.get(flags)");
        DeserializedPropertyDescriptor deserializedPropertyDescriptor3 = new DeserializedPropertyDescriptor(containingDeclaration, null, annotations, modality, visibility, booleanValue, name, memberKind, booleanValue2, booleanValue3, booleanValue4, booleanValue5, bool6.booleanValue(), property, this.c.getNameResolver(), this.c.getTypeTable(), this.c.getVersionRequirementTable(), this.c.getContainerSource());
        DeserializationContext deserializationContext = this.c;
        List<ProtoBuf.TypeParameter> typeParameterList = property.getTypeParameterList();
        Intrinsics.checkExpressionValueIsNotNull(typeParameterList, "proto.typeParameterList");
        DeserializationContext childContext$default = DeserializationContext.childContext$default(deserializationContext, deserializedPropertyDescriptor3, typeParameterList, null, null, null, null, 60, null);
        Boolean bool7 = Flags.HAS_GETTER.get(i3);
        Intrinsics.checkExpressionValueIsNotNull(bool7, "Flags.HAS_GETTER.get(flags)");
        boolean booleanValue6 = bool7.booleanValue();
        if (booleanValue6 && ProtoTypeTableUtilKt.hasReceiver(property)) {
            property2 = property;
            empty = getReceiverParameterAnnotations(property2, AnnotatedCallableKind.PROPERTY_GETTER);
        } else {
            property2 = property;
            empty = Annotations.Companion.getEMPTY();
        }
        KotlinType type2 = childContext$default.getTypeDeserializer().type(ProtoTypeTableUtilKt.returnType(property2, this.c.getTypeTable()));
        List<TypeParameterDescriptor> ownTypeParameters = childContext$default.getTypeDeserializer().getOwnTypeParameters();
        ReceiverParameterDescriptor dispatchReceiverParameter = getDispatchReceiverParameter();
        ProtoBuf.Type receiverType = ProtoTypeTableUtilKt.receiverType(property2, this.c.getTypeTable());
        if (receiverType != null && (type = childContext$default.getTypeDeserializer().type(receiverType)) != null) {
            deserializedPropertyDescriptor = deserializedPropertyDescriptor3;
            receiverParameterDescriptor = DescriptorFactory.createExtensionReceiverParameterForCallable(deserializedPropertyDescriptor, type, empty);
        } else {
            deserializedPropertyDescriptor = deserializedPropertyDescriptor3;
            receiverParameterDescriptor = null;
        }
        deserializedPropertyDescriptor.setType(type2, ownTypeParameters, dispatchReceiverParameter, receiverParameterDescriptor);
        Boolean bool8 = Flags.HAS_ANNOTATIONS.get(i3);
        Intrinsics.checkExpressionValueIsNotNull(bool8, "Flags.HAS_ANNOTATIONS.get(flags)");
        int accessorFlags = Flags.getAccessorFlags(bool8.booleanValue(), Flags.VISIBILITY.get(i3), Flags.MODALITY.get(i3), false, false, false);
        if (booleanValue6) {
            if (property.hasGetterFlags()) {
                i2 = property.getGetterFlags();
            } else {
                i2 = accessorFlags;
            }
            Boolean bool9 = Flags.IS_NOT_DEFAULT.get(i2);
            Intrinsics.checkExpressionValueIsNotNull(bool9, "Flags.IS_NOT_DEFAULT.get(getterFlags)");
            boolean booleanValue7 = bool9.booleanValue();
            Boolean bool10 = Flags.IS_EXTERNAL_ACCESSOR.get(i2);
            Intrinsics.checkExpressionValueIsNotNull(bool10, "Flags.IS_EXTERNAL_ACCESSOR.get(getterFlags)");
            boolean booleanValue8 = bool10.booleanValue();
            Boolean bool11 = Flags.IS_INLINE_ACCESSOR.get(i2);
            Intrinsics.checkExpressionValueIsNotNull(bool11, "Flags.IS_INLINE_ACCESSOR.get(getterFlags)");
            boolean booleanValue9 = bool11.booleanValue();
            Annotations annotations2 = getAnnotations(property2, i2, AnnotatedCallableKind.PROPERTY_GETTER);
            if (booleanValue7) {
                createDefaultGetter = new PropertyGetterDescriptorImpl(deserializedPropertyDescriptor, annotations2, ProtoEnumFlags.INSTANCE.modality(Flags.MODALITY.get(i2)), ProtoEnumFlags.INSTANCE.visibility(Flags.VISIBILITY.get(i2)), !booleanValue7, booleanValue8, booleanValue9, deserializedPropertyDescriptor.getKind(), null, SourceElement.NO_SOURCE);
            } else {
                createDefaultGetter = DescriptorFactory.createDefaultGetter(deserializedPropertyDescriptor, annotations2);
                Intrinsics.checkExpressionValueIsNotNull(createDefaultGetter, "DescriptorFactory.create…er(property, annotations)");
            }
            createDefaultGetter.initialize(deserializedPropertyDescriptor.getReturnType());
            propertyGetterDescriptorImpl = createDefaultGetter;
        } else {
            propertyGetterDescriptorImpl = null;
        }
        Boolean bool12 = Flags.HAS_SETTER.get(i3);
        Intrinsics.checkExpressionValueIsNotNull(bool12, "Flags.HAS_SETTER.get(flags)");
        if (bool12.booleanValue()) {
            if (property.hasSetterFlags()) {
                accessorFlags = property.getSetterFlags();
            }
            int i4 = accessorFlags;
            Boolean bool13 = Flags.IS_NOT_DEFAULT.get(i4);
            Intrinsics.checkExpressionValueIsNotNull(bool13, "Flags.IS_NOT_DEFAULT.get(setterFlags)");
            boolean booleanValue10 = bool13.booleanValue();
            Boolean bool14 = Flags.IS_EXTERNAL_ACCESSOR.get(i4);
            Intrinsics.checkExpressionValueIsNotNull(bool14, "Flags.IS_EXTERNAL_ACCESSOR.get(setterFlags)");
            boolean booleanValue11 = bool14.booleanValue();
            Boolean bool15 = Flags.IS_INLINE_ACCESSOR.get(i4);
            Intrinsics.checkExpressionValueIsNotNull(bool15, "Flags.IS_INLINE_ACCESSOR.get(setterFlags)");
            boolean booleanValue12 = bool15.booleanValue();
            Annotations annotations3 = getAnnotations(property2, i4, AnnotatedCallableKind.PROPERTY_SETTER);
            if (booleanValue10) {
                PropertySetterDescriptorImpl propertySetterDescriptorImpl2 = new PropertySetterDescriptorImpl(deserializedPropertyDescriptor, annotations3, ProtoEnumFlags.INSTANCE.modality(Flags.MODALITY.get(i4)), ProtoEnumFlags.INSTANCE.visibility(Flags.VISIBILITY.get(i4)), !booleanValue10, booleanValue11, booleanValue12, deserializedPropertyDescriptor.getKind(), null, SourceElement.NO_SOURCE);
                z = true;
                deserializedPropertyDescriptor2 = deserializedPropertyDescriptor;
                property3 = property2;
                i = i3;
                propertySetterDescriptorImpl2.initialize((ValueParameterDescriptor) CollectionsKt___CollectionsKt.single((List<? extends Object>) DeserializationContext.childContext$default(childContext$default, propertySetterDescriptorImpl2, CollectionsKt__CollectionsKt.emptyList(), null, null, null, null, 60, null).getMemberDeserializer().valueParameters(CollectionsKt__CollectionsJVMKt.listOf(property.getSetterValueParameter()), property3, AnnotatedCallableKind.PROPERTY_SETTER)));
                propertySetterDescriptorImpl = propertySetterDescriptorImpl2;
            } else {
                deserializedPropertyDescriptor2 = deserializedPropertyDescriptor;
                property3 = property2;
                i = i3;
                z = true;
                propertySetterDescriptorImpl = DescriptorFactory.createDefaultSetter(deserializedPropertyDescriptor2, annotations3, Annotations.Companion.getEMPTY());
                Intrinsics.checkExpressionValueIsNotNull(propertySetterDescriptorImpl, "DescriptorFactory.create…ptor */\n                )");
            }
        } else {
            deserializedPropertyDescriptor2 = deserializedPropertyDescriptor;
            property3 = property2;
            i = i3;
            z = true;
            propertySetterDescriptorImpl = null;
        }
        Boolean bool16 = Flags.HAS_CONSTANT.get(i);
        Intrinsics.checkExpressionValueIsNotNull(bool16, "Flags.HAS_CONSTANT.get(flags)");
        if (bool16.booleanValue()) {
            deserializedPropertyDescriptor2.setCompileTimeInitializer(this.c.getStorageManager().createNullableLazyValue(new Function0<ConstantValue<?>>() { // from class: kotlin.reflect.jvm.internal.impl.serialization.deserialization.MemberDeserializer$loadProperty$3
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(0);
                }

                /* JADX DEBUG: Method merged with bridge method */
                @Override // kotlin.jvm.functions.Function0
                public final ConstantValue<?> invoke() {
                    DeserializationContext deserializationContext2;
                    ProtoContainer asProtoContainer;
                    DeserializationContext deserializationContext3;
                    MemberDeserializer memberDeserializer = MemberDeserializer.this;
                    deserializationContext2 = memberDeserializer.c;
                    asProtoContainer = memberDeserializer.asProtoContainer(deserializationContext2.getContainingDeclaration());
                    if (asProtoContainer == null) {
                        Intrinsics.throwNpe();
                    }
                    deserializationContext3 = MemberDeserializer.this.c;
                    AnnotationAndConstantLoader<AnnotationDescriptor, ConstantValue<?>> annotationAndConstantLoader = deserializationContext3.getComponents().getAnnotationAndConstantLoader();
                    ProtoBuf.Property property4 = property3;
                    KotlinType returnType = deserializedPropertyDescriptor2.getReturnType();
                    Intrinsics.checkExpressionValueIsNotNull(returnType, "property.returnType");
                    return annotationAndConstantLoader.loadPropertyConstant(asProtoContainer, property4, returnType);
                }
            }));
        }
        deserializedPropertyDescriptor2.initialize(propertyGetterDescriptorImpl, propertySetterDescriptorImpl, new FieldDescriptorImpl(getPropertyFieldAnnotations(property3, false), deserializedPropertyDescriptor2), new FieldDescriptorImpl(getPropertyFieldAnnotations(property3, z), deserializedPropertyDescriptor2), checkExperimentalCoroutine(deserializedPropertyDescriptor2, childContext$default.getTypeDeserializer()));
        return deserializedPropertyDescriptor2;
    }

    public final TypeAliasDescriptor loadTypeAlias(ProtoBuf.TypeAlias typeAlias) {
        Annotations.Companion companion = Annotations.Companion;
        List<ProtoBuf.Annotation> annotationList = typeAlias.getAnnotationList();
        Intrinsics.checkExpressionValueIsNotNull(annotationList, "proto.annotationList");
        ArrayList arrayList = new ArrayList(CollectionsKt__IterablesKt.collectionSizeOrDefault(annotationList, 10));
        for (ProtoBuf.Annotation it : annotationList) {
            AnnotationDeserializer annotationDeserializer = this.annotationDeserializer;
            Intrinsics.checkExpressionValueIsNotNull(it, "it");
            arrayList.add(annotationDeserializer.deserializeAnnotation(it, this.c.getNameResolver()));
        }
        DeserializedTypeAliasDescriptor deserializedTypeAliasDescriptor = new DeserializedTypeAliasDescriptor(this.c.getStorageManager(), this.c.getContainingDeclaration(), companion.create(arrayList), NameResolverUtilKt.getName(this.c.getNameResolver(), typeAlias.getName()), ProtoEnumFlags.INSTANCE.visibility(Flags.VISIBILITY.get(typeAlias.getFlags())), typeAlias, this.c.getNameResolver(), this.c.getTypeTable(), this.c.getVersionRequirementTable(), this.c.getContainerSource());
        DeserializationContext deserializationContext = this.c;
        List<ProtoBuf.TypeParameter> typeParameterList = typeAlias.getTypeParameterList();
        Intrinsics.checkExpressionValueIsNotNull(typeParameterList, "proto.typeParameterList");
        DeserializationContext childContext$default = DeserializationContext.childContext$default(deserializationContext, deserializedTypeAliasDescriptor, typeParameterList, null, null, null, null, 60, null);
        deserializedTypeAliasDescriptor.initialize(childContext$default.getTypeDeserializer().getOwnTypeParameters(), childContext$default.getTypeDeserializer().simpleType(ProtoTypeTableUtilKt.underlyingType(typeAlias, this.c.getTypeTable())), childContext$default.getTypeDeserializer().simpleType(ProtoTypeTableUtilKt.expandedType(typeAlias, this.c.getTypeTable())), checkExperimentalCoroutine(deserializedTypeAliasDescriptor, childContext$default.getTypeDeserializer()));
        return deserializedTypeAliasDescriptor;
    }
}
