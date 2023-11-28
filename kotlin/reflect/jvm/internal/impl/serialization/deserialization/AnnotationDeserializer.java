package kotlin.reflect.jvm.internal.impl.serialization.deserialization;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Pair;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.CollectionsKt__IterablesKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.collections.IntIterator;
import kotlin.collections.MapsKt__MapsJVMKt;
import kotlin.collections.MapsKt__MapsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.IntRange;
import kotlin.ranges.RangesKt___RangesKt;
import kotlin.reflect.jvm.internal.impl.builtins.KotlinBuiltIns;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassConstructorDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassifierDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.FindClassInModuleKt;
import kotlin.reflect.jvm.internal.impl.descriptors.ModuleDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.NotFoundClasses;
import kotlin.reflect.jvm.internal.impl.descriptors.SourceElement;
import kotlin.reflect.jvm.internal.impl.descriptors.ValueParameterDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.AnnotationDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.AnnotationDescriptorImpl;
import kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf;
import kotlin.reflect.jvm.internal.impl.metadata.deserialization.Flags;
import kotlin.reflect.jvm.internal.impl.metadata.deserialization.NameResolver;
import kotlin.reflect.jvm.internal.impl.name.ClassId;
import kotlin.reflect.jvm.internal.impl.name.Name;
import kotlin.reflect.jvm.internal.impl.resolve.DescriptorUtils;
import kotlin.reflect.jvm.internal.impl.resolve.constants.AnnotationValue;
import kotlin.reflect.jvm.internal.impl.resolve.constants.ArrayValue;
import kotlin.reflect.jvm.internal.impl.resolve.constants.BooleanValue;
import kotlin.reflect.jvm.internal.impl.resolve.constants.ByteValue;
import kotlin.reflect.jvm.internal.impl.resolve.constants.CharValue;
import kotlin.reflect.jvm.internal.impl.resolve.constants.ConstantValue;
import kotlin.reflect.jvm.internal.impl.resolve.constants.ConstantValueFactory;
import kotlin.reflect.jvm.internal.impl.resolve.constants.DoubleValue;
import kotlin.reflect.jvm.internal.impl.resolve.constants.EnumValue;
import kotlin.reflect.jvm.internal.impl.resolve.constants.ErrorValue;
import kotlin.reflect.jvm.internal.impl.resolve.constants.FloatValue;
import kotlin.reflect.jvm.internal.impl.resolve.constants.IntValue;
import kotlin.reflect.jvm.internal.impl.resolve.constants.KClassValue;
import kotlin.reflect.jvm.internal.impl.resolve.constants.LongValue;
import kotlin.reflect.jvm.internal.impl.resolve.constants.ShortValue;
import kotlin.reflect.jvm.internal.impl.resolve.constants.StringValue;
import kotlin.reflect.jvm.internal.impl.resolve.constants.UByteValue;
import kotlin.reflect.jvm.internal.impl.resolve.constants.UIntValue;
import kotlin.reflect.jvm.internal.impl.resolve.constants.ULongValue;
import kotlin.reflect.jvm.internal.impl.resolve.constants.UShortValue;
import kotlin.reflect.jvm.internal.impl.types.ErrorUtils;
import kotlin.reflect.jvm.internal.impl.types.KotlinType;
import kotlin.reflect.jvm.internal.impl.types.SimpleType;
/* loaded from: classes2.dex */
public final class AnnotationDeserializer {
    public final ModuleDescriptor module;
    public final NotFoundClasses notFoundClasses;

    /* loaded from: classes2.dex */
    public final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;
        public static final /* synthetic */ int[] $EnumSwitchMapping$1;

        static {
            int[] iArr = new int[ProtoBuf.Annotation.Argument.Value.Type.values().length];
            $EnumSwitchMapping$0 = iArr;
            iArr[ProtoBuf.Annotation.Argument.Value.Type.BYTE.ordinal()] = 1;
            $EnumSwitchMapping$0[ProtoBuf.Annotation.Argument.Value.Type.CHAR.ordinal()] = 2;
            $EnumSwitchMapping$0[ProtoBuf.Annotation.Argument.Value.Type.SHORT.ordinal()] = 3;
            $EnumSwitchMapping$0[ProtoBuf.Annotation.Argument.Value.Type.INT.ordinal()] = 4;
            $EnumSwitchMapping$0[ProtoBuf.Annotation.Argument.Value.Type.LONG.ordinal()] = 5;
            $EnumSwitchMapping$0[ProtoBuf.Annotation.Argument.Value.Type.FLOAT.ordinal()] = 6;
            $EnumSwitchMapping$0[ProtoBuf.Annotation.Argument.Value.Type.DOUBLE.ordinal()] = 7;
            $EnumSwitchMapping$0[ProtoBuf.Annotation.Argument.Value.Type.BOOLEAN.ordinal()] = 8;
            $EnumSwitchMapping$0[ProtoBuf.Annotation.Argument.Value.Type.STRING.ordinal()] = 9;
            $EnumSwitchMapping$0[ProtoBuf.Annotation.Argument.Value.Type.CLASS.ordinal()] = 10;
            $EnumSwitchMapping$0[ProtoBuf.Annotation.Argument.Value.Type.ENUM.ordinal()] = 11;
            $EnumSwitchMapping$0[ProtoBuf.Annotation.Argument.Value.Type.ANNOTATION.ordinal()] = 12;
            $EnumSwitchMapping$0[ProtoBuf.Annotation.Argument.Value.Type.ARRAY.ordinal()] = 13;
            int[] iArr2 = new int[ProtoBuf.Annotation.Argument.Value.Type.values().length];
            $EnumSwitchMapping$1 = iArr2;
            iArr2[ProtoBuf.Annotation.Argument.Value.Type.CLASS.ordinal()] = 1;
            $EnumSwitchMapping$1[ProtoBuf.Annotation.Argument.Value.Type.ARRAY.ordinal()] = 2;
        }
    }

    public AnnotationDeserializer(ModuleDescriptor moduleDescriptor, NotFoundClasses notFoundClasses) {
        this.module = moduleDescriptor;
        this.notFoundClasses = notFoundClasses;
    }

    private final boolean doesValueConformToExpectedType(ConstantValue<?> constantValue, KotlinType kotlinType, ProtoBuf.Annotation.Argument.Value value) {
        boolean z;
        ProtoBuf.Annotation.Argument.Value.Type type = value.getType();
        if (type != null) {
            int i = WhenMappings.$EnumSwitchMapping$1[type.ordinal()];
            if (i != 1) {
                if (i == 2) {
                    if ((constantValue instanceof ArrayValue) && ((ArrayValue) constantValue).getValue().size() == value.getArrayElementList().size()) {
                        z = true;
                    } else {
                        z = false;
                    }
                    if (z) {
                        KotlinType arrayElementType = getBuiltIns().getArrayElementType(kotlinType);
                        Intrinsics.checkExpressionValueIsNotNull(arrayElementType, "builtIns.getArrayElementType(expectedType)");
                        ArrayValue arrayValue = (ArrayValue) constantValue;
                        IntRange indices = CollectionsKt__CollectionsKt.getIndices(arrayValue.getValue());
                        if (!(indices instanceof Collection) || !((Collection) indices).isEmpty()) {
                            Iterator<Integer> it = indices.iterator();
                            while (it.hasNext()) {
                                int nextInt = ((IntIterator) it).nextInt();
                                ProtoBuf.Annotation.Argument.Value arrayElement = value.getArrayElement(nextInt);
                                Intrinsics.checkExpressionValueIsNotNull(arrayElement, "value.getArrayElement(i)");
                                if (!doesValueConformToExpectedType(arrayValue.getValue().get(nextInt), arrayElementType, arrayElement)) {
                                    return false;
                                }
                            }
                        }
                    } else {
                        throw new IllegalStateException(("Deserialized ArrayValue should have the same number of elements as the original array value: " + constantValue).toString());
                    }
                }
            } else {
                ClassifierDescriptor mo2114getDeclarationDescriptor = kotlinType.getConstructor().mo2114getDeclarationDescriptor();
                if (!(mo2114getDeclarationDescriptor instanceof ClassDescriptor)) {
                    mo2114getDeclarationDescriptor = null;
                }
                ClassDescriptor classDescriptor = (ClassDescriptor) mo2114getDeclarationDescriptor;
                if (classDescriptor != null && !KotlinBuiltIns.isKClass(classDescriptor)) {
                    return false;
                }
            }
            return true;
        }
        return Intrinsics.areEqual(constantValue.getType(this.module), kotlinType);
    }

    private final KotlinBuiltIns getBuiltIns() {
        return this.module.getBuiltIns();
    }

    private final Pair<Name, ConstantValue<?>> resolveArgument(ProtoBuf.Annotation.Argument argument, Map<Name, ? extends ValueParameterDescriptor> map, NameResolver nameResolver) {
        ValueParameterDescriptor valueParameterDescriptor = map.get(NameResolverUtilKt.getName(nameResolver, argument.getNameId()));
        if (valueParameterDescriptor != null) {
            Name name = NameResolverUtilKt.getName(nameResolver, argument.getNameId());
            KotlinType type = valueParameterDescriptor.getType();
            Intrinsics.checkExpressionValueIsNotNull(type, "parameter.type");
            ProtoBuf.Annotation.Argument.Value value = argument.getValue();
            Intrinsics.checkExpressionValueIsNotNull(value, "proto.value");
            return new Pair<>(name, resolveValueAndCheckExpectedType(type, value, nameResolver));
        }
        return null;
    }

    private final ConstantValue<?> resolveValueAndCheckExpectedType(KotlinType kotlinType, ProtoBuf.Annotation.Argument.Value value, NameResolver nameResolver) {
        ConstantValue<?> resolveValue = resolveValue(kotlinType, value, nameResolver);
        if (!doesValueConformToExpectedType(resolveValue, kotlinType, value)) {
            resolveValue = null;
        }
        if (resolveValue == null) {
            ErrorValue.Companion companion = ErrorValue.Companion;
            return companion.create("Unexpected argument value: actual type " + value.getType() + " != expected type " + kotlinType);
        }
        return resolveValue;
    }

    private final ClassDescriptor resolveClass(ClassId classId) {
        return FindClassInModuleKt.findNonGenericClassAcrossDependencies(this.module, classId, this.notFoundClasses);
    }

    public final AnnotationDescriptor deserializeAnnotation(ProtoBuf.Annotation annotation, NameResolver nameResolver) {
        ClassDescriptor resolveClass = resolveClass(NameResolverUtilKt.getClassId(nameResolver, annotation.getId()));
        Map emptyMap = MapsKt__MapsKt.emptyMap();
        if (annotation.getArgumentCount() != 0 && !ErrorUtils.isError(resolveClass) && DescriptorUtils.isAnnotationClass(resolveClass)) {
            Collection<ClassConstructorDescriptor> constructors = resolveClass.getConstructors();
            Intrinsics.checkExpressionValueIsNotNull(constructors, "annotationClass.constructors");
            ClassConstructorDescriptor classConstructorDescriptor = (ClassConstructorDescriptor) CollectionsKt___CollectionsKt.singleOrNull(constructors);
            if (classConstructorDescriptor != null) {
                List<ValueParameterDescriptor> valueParameters = classConstructorDescriptor.getValueParameters();
                Intrinsics.checkExpressionValueIsNotNull(valueParameters, "constructor.valueParameters");
                LinkedHashMap linkedHashMap = new LinkedHashMap(RangesKt___RangesKt.coerceAtLeast(MapsKt__MapsJVMKt.mapCapacity(CollectionsKt__IterablesKt.collectionSizeOrDefault(valueParameters, 10)), 16));
                for (Object obj : valueParameters) {
                    ValueParameterDescriptor it = (ValueParameterDescriptor) obj;
                    Intrinsics.checkExpressionValueIsNotNull(it, "it");
                    linkedHashMap.put(it.getName(), obj);
                }
                List<ProtoBuf.Annotation.Argument> argumentList = annotation.getArgumentList();
                Intrinsics.checkExpressionValueIsNotNull(argumentList, "proto.argumentList");
                ArrayList arrayList = new ArrayList();
                for (ProtoBuf.Annotation.Argument it2 : argumentList) {
                    Intrinsics.checkExpressionValueIsNotNull(it2, "it");
                    Pair<Name, ConstantValue<?>> resolveArgument = resolveArgument(it2, linkedHashMap, nameResolver);
                    if (resolveArgument != null) {
                        arrayList.add(resolveArgument);
                    }
                }
                emptyMap = MapsKt__MapsKt.toMap(arrayList);
            }
        }
        return new AnnotationDescriptorImpl(resolveClass.getDefaultType(), emptyMap, SourceElement.NO_SOURCE);
    }

    public final ConstantValue<?> resolveValue(KotlinType kotlinType, ProtoBuf.Annotation.Argument.Value value, NameResolver nameResolver) {
        ConstantValue<?> byteValue;
        ConstantValue<?> longValue;
        boolean z;
        Boolean bool = Flags.IS_UNSIGNED.get(value.getFlags());
        Intrinsics.checkExpressionValueIsNotNull(bool, "Flags.IS_UNSIGNED.get(value.flags)");
        boolean booleanValue = bool.booleanValue();
        ProtoBuf.Annotation.Argument.Value.Type type = value.getType();
        if (type != null) {
            switch (WhenMappings.$EnumSwitchMapping$0[type.ordinal()]) {
                case 1:
                    byte intValue = (byte) value.getIntValue();
                    if (booleanValue) {
                        byteValue = new UByteValue(intValue);
                    } else {
                        byteValue = new ByteValue(intValue);
                    }
                    return byteValue;
                case 2:
                    return new CharValue((char) value.getIntValue());
                case 3:
                    short intValue2 = (short) value.getIntValue();
                    if (booleanValue) {
                        byteValue = new UShortValue(intValue2);
                    } else {
                        byteValue = new ShortValue(intValue2);
                    }
                    return byteValue;
                case 4:
                    int intValue3 = (int) value.getIntValue();
                    if (booleanValue) {
                        return new UIntValue(intValue3);
                    }
                    return new IntValue(intValue3);
                case 5:
                    long intValue4 = value.getIntValue();
                    if (booleanValue) {
                        longValue = new ULongValue(intValue4);
                    } else {
                        longValue = new LongValue(intValue4);
                    }
                    return longValue;
                case 6:
                    return new FloatValue(value.getFloatValue());
                case 7:
                    return new DoubleValue(value.getDoubleValue());
                case 8:
                    if (value.getIntValue() != 0) {
                        z = true;
                    } else {
                        z = false;
                    }
                    return new BooleanValue(z);
                case 9:
                    return new StringValue(nameResolver.getString(value.getStringValue()));
                case 10:
                    return new KClassValue(NameResolverUtilKt.getClassId(nameResolver, value.getClassId()), value.getArrayDimensionCount());
                case 11:
                    return new EnumValue(NameResolverUtilKt.getClassId(nameResolver, value.getClassId()), NameResolverUtilKt.getName(nameResolver, value.getEnumValueId()));
                case 12:
                    ProtoBuf.Annotation annotation = value.getAnnotation();
                    Intrinsics.checkExpressionValueIsNotNull(annotation, "value.annotation");
                    return new AnnotationValue(deserializeAnnotation(annotation, nameResolver));
                case 13:
                    ConstantValueFactory constantValueFactory = ConstantValueFactory.INSTANCE;
                    List<ProtoBuf.Annotation.Argument.Value> arrayElementList = value.getArrayElementList();
                    Intrinsics.checkExpressionValueIsNotNull(arrayElementList, "value.arrayElementList");
                    ArrayList arrayList = new ArrayList(CollectionsKt__IterablesKt.collectionSizeOrDefault(arrayElementList, 10));
                    for (ProtoBuf.Annotation.Argument.Value it : arrayElementList) {
                        SimpleType anyType = getBuiltIns().getAnyType();
                        Intrinsics.checkExpressionValueIsNotNull(anyType, "builtIns.anyType");
                        Intrinsics.checkExpressionValueIsNotNull(it, "it");
                        arrayList.add(resolveValue(anyType, it, nameResolver));
                    }
                    return constantValueFactory.createArrayValue(arrayList, kotlinType);
            }
        }
        throw new IllegalStateException(("Unsupported annotation argument type: " + value.getType() + " (expected " + kotlinType + ')').toString());
    }
}
