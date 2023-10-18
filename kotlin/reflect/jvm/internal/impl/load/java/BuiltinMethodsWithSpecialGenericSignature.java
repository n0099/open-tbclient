package kotlin.reflect.jvm.internal.impl.load.java;

import com.baidu.searchbox.wordscommand.util.CommandUBCHelper;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.TuplesKt;
import kotlin.collections.CollectionsKt__IterablesKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.collections.MapsKt__MapsJVMKt;
import kotlin.collections.MapsKt__MapsKt;
import kotlin.collections.SetsKt__SetsKt;
import kotlin.collections.SetsKt___SetsKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.descriptors.CallableMemberDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.FunctionDescriptor;
import kotlin.reflect.jvm.internal.impl.load.kotlin.MethodSignatureMappingKt;
import kotlin.reflect.jvm.internal.impl.load.kotlin.SignatureBuildingComponents;
import kotlin.reflect.jvm.internal.impl.name.Name;
import kotlin.reflect.jvm.internal.impl.resolve.descriptorUtil.DescriptorUtilsKt;
import kotlin.reflect.jvm.internal.impl.resolve.jvm.JvmPrimitiveType;
/* loaded from: classes10.dex */
public final class BuiltinMethodsWithSpecialGenericSignature {
    public static final List<String> ERASED_COLLECTION_PARAMETER_NAMES;
    public static final List<NameAndSignature> ERASED_COLLECTION_PARAMETER_NAME_AND_SIGNATURES;
    public static final List<String> ERASED_COLLECTION_PARAMETER_SIGNATURES;
    public static final Set<Name> ERASED_VALUE_PARAMETERS_SHORT_NAMES;
    public static final Set<String> ERASED_VALUE_PARAMETERS_SIGNATURES;
    public static final Map<NameAndSignature, TypeSafeBarrierDescription> GENERIC_PARAMETERS_METHODS_TO_DEFAULT_VALUES_MAP;
    public static final BuiltinMethodsWithSpecialGenericSignature INSTANCE = new BuiltinMethodsWithSpecialGenericSignature();
    public static final Map<String, TypeSafeBarrierDescription> SIGNATURE_TO_DEFAULT_VALUES_MAP;

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* JADX WARN: Unknown enum class pattern. Please report as an issue! */
    /* loaded from: classes10.dex */
    public static final class TypeSafeBarrierDescription {
        public static final /* synthetic */ TypeSafeBarrierDescription[] $VALUES;
        public static final TypeSafeBarrierDescription FALSE;
        public static final TypeSafeBarrierDescription INDEX;
        public static final TypeSafeBarrierDescription MAP_GET_OR_DEFAULT;
        public static final TypeSafeBarrierDescription NULL;
        public final Object defaultValue;

        public static TypeSafeBarrierDescription valueOf(String str) {
            return (TypeSafeBarrierDescription) Enum.valueOf(TypeSafeBarrierDescription.class, str);
        }

        public static TypeSafeBarrierDescription[] values() {
            return (TypeSafeBarrierDescription[]) $VALUES.clone();
        }

        /* loaded from: classes10.dex */
        public static final class MAP_GET_OR_DEFAULT extends TypeSafeBarrierDescription {
            /* JADX DEBUG: Incorrect args count in method signature: ()V */
            public MAP_GET_OR_DEFAULT(String str, int i) {
                super(str, i, null, null);
            }
        }

        static {
            TypeSafeBarrierDescription typeSafeBarrierDescription = new TypeSafeBarrierDescription("NULL", 0, null);
            NULL = typeSafeBarrierDescription;
            TypeSafeBarrierDescription typeSafeBarrierDescription2 = new TypeSafeBarrierDescription("INDEX", 1, -1);
            INDEX = typeSafeBarrierDescription2;
            TypeSafeBarrierDescription typeSafeBarrierDescription3 = new TypeSafeBarrierDescription("FALSE", 2, Boolean.FALSE);
            FALSE = typeSafeBarrierDescription3;
            MAP_GET_OR_DEFAULT map_get_or_default = new MAP_GET_OR_DEFAULT("MAP_GET_OR_DEFAULT", 3);
            MAP_GET_OR_DEFAULT = map_get_or_default;
            $VALUES = new TypeSafeBarrierDescription[]{typeSafeBarrierDescription, typeSafeBarrierDescription2, typeSafeBarrierDescription3, map_get_or_default};
        }

        public TypeSafeBarrierDescription(String str, int i, Object obj) {
            this.defaultValue = obj;
        }

        public /* synthetic */ TypeSafeBarrierDescription(String str, int i, Object obj, DefaultConstructorMarker defaultConstructorMarker) {
            this(str, i, obj);
        }
    }

    static {
        NameAndSignature method;
        NameAndSignature method2;
        NameAndSignature method3;
        NameAndSignature method4;
        NameAndSignature method5;
        NameAndSignature method6;
        NameAndSignature method7;
        NameAndSignature method8;
        NameAndSignature method9;
        NameAndSignature method10;
        NameAndSignature method11;
        Set<String> of = SetsKt__SetsKt.setOf((Object[]) new String[]{"containsAll", "removeAll", "retainAll"});
        ArrayList<NameAndSignature> arrayList = new ArrayList(CollectionsKt__IterablesKt.collectionSizeOrDefault(of, 10));
        for (String str : of) {
            String desc = JvmPrimitiveType.BOOLEAN.getDesc();
            Intrinsics.checkExpressionValueIsNotNull(desc, "JvmPrimitiveType.BOOLEAN.desc");
            method11 = SpecialBuiltinMembers.method("java/util/Collection", str, "Ljava/util/Collection;", desc);
            arrayList.add(method11);
        }
        ERASED_COLLECTION_PARAMETER_NAME_AND_SIGNATURES = arrayList;
        ArrayList arrayList2 = new ArrayList(CollectionsKt__IterablesKt.collectionSizeOrDefault(arrayList, 10));
        for (NameAndSignature nameAndSignature : arrayList) {
            arrayList2.add(nameAndSignature.getSignature());
        }
        ERASED_COLLECTION_PARAMETER_SIGNATURES = arrayList2;
        List<NameAndSignature> list = ERASED_COLLECTION_PARAMETER_NAME_AND_SIGNATURES;
        ArrayList arrayList3 = new ArrayList(CollectionsKt__IterablesKt.collectionSizeOrDefault(list, 10));
        for (NameAndSignature nameAndSignature2 : list) {
            arrayList3.add(nameAndSignature2.getName().asString());
        }
        ERASED_COLLECTION_PARAMETER_NAMES = arrayList3;
        SignatureBuildingComponents signatureBuildingComponents = SignatureBuildingComponents.INSTANCE;
        String javaUtil = signatureBuildingComponents.javaUtil("Collection");
        String desc2 = JvmPrimitiveType.BOOLEAN.getDesc();
        Intrinsics.checkExpressionValueIsNotNull(desc2, "JvmPrimitiveType.BOOLEAN.desc");
        method = SpecialBuiltinMembers.method(javaUtil, "contains", "Ljava/lang/Object;", desc2);
        String javaUtil2 = signatureBuildingComponents.javaUtil("Collection");
        String desc3 = JvmPrimitiveType.BOOLEAN.getDesc();
        Intrinsics.checkExpressionValueIsNotNull(desc3, "JvmPrimitiveType.BOOLEAN.desc");
        method2 = SpecialBuiltinMembers.method(javaUtil2, "remove", "Ljava/lang/Object;", desc3);
        String javaUtil3 = signatureBuildingComponents.javaUtil("Map");
        String desc4 = JvmPrimitiveType.BOOLEAN.getDesc();
        Intrinsics.checkExpressionValueIsNotNull(desc4, "JvmPrimitiveType.BOOLEAN.desc");
        method3 = SpecialBuiltinMembers.method(javaUtil3, "containsKey", "Ljava/lang/Object;", desc4);
        String javaUtil4 = signatureBuildingComponents.javaUtil("Map");
        String desc5 = JvmPrimitiveType.BOOLEAN.getDesc();
        Intrinsics.checkExpressionValueIsNotNull(desc5, "JvmPrimitiveType.BOOLEAN.desc");
        method4 = SpecialBuiltinMembers.method(javaUtil4, "containsValue", "Ljava/lang/Object;", desc5);
        String javaUtil5 = signatureBuildingComponents.javaUtil("Map");
        String desc6 = JvmPrimitiveType.BOOLEAN.getDesc();
        Intrinsics.checkExpressionValueIsNotNull(desc6, "JvmPrimitiveType.BOOLEAN.desc");
        method5 = SpecialBuiltinMembers.method(javaUtil5, "remove", "Ljava/lang/Object;Ljava/lang/Object;", desc6);
        method6 = SpecialBuiltinMembers.method(signatureBuildingComponents.javaUtil("Map"), "getOrDefault", "Ljava/lang/Object;Ljava/lang/Object;", "Ljava/lang/Object;");
        method7 = SpecialBuiltinMembers.method(signatureBuildingComponents.javaUtil("Map"), CommandUBCHelper.COMMAND_UBC_SOURCE_RECEIVE, "Ljava/lang/Object;", "Ljava/lang/Object;");
        method8 = SpecialBuiltinMembers.method(signatureBuildingComponents.javaUtil("Map"), "remove", "Ljava/lang/Object;", "Ljava/lang/Object;");
        String javaUtil6 = signatureBuildingComponents.javaUtil("List");
        String desc7 = JvmPrimitiveType.INT.getDesc();
        Intrinsics.checkExpressionValueIsNotNull(desc7, "JvmPrimitiveType.INT.desc");
        method9 = SpecialBuiltinMembers.method(javaUtil6, "indexOf", "Ljava/lang/Object;", desc7);
        String javaUtil7 = signatureBuildingComponents.javaUtil("List");
        String desc8 = JvmPrimitiveType.INT.getDesc();
        Intrinsics.checkExpressionValueIsNotNull(desc8, "JvmPrimitiveType.INT.desc");
        method10 = SpecialBuiltinMembers.method(javaUtil7, "lastIndexOf", "Ljava/lang/Object;", desc8);
        Map<NameAndSignature, TypeSafeBarrierDescription> mapOf = MapsKt__MapsKt.mapOf(TuplesKt.to(method, TypeSafeBarrierDescription.FALSE), TuplesKt.to(method2, TypeSafeBarrierDescription.FALSE), TuplesKt.to(method3, TypeSafeBarrierDescription.FALSE), TuplesKt.to(method4, TypeSafeBarrierDescription.FALSE), TuplesKt.to(method5, TypeSafeBarrierDescription.FALSE), TuplesKt.to(method6, TypeSafeBarrierDescription.MAP_GET_OR_DEFAULT), TuplesKt.to(method7, TypeSafeBarrierDescription.NULL), TuplesKt.to(method8, TypeSafeBarrierDescription.NULL), TuplesKt.to(method9, TypeSafeBarrierDescription.INDEX), TuplesKt.to(method10, TypeSafeBarrierDescription.INDEX));
        GENERIC_PARAMETERS_METHODS_TO_DEFAULT_VALUES_MAP = mapOf;
        LinkedHashMap linkedHashMap = new LinkedHashMap(MapsKt__MapsJVMKt.mapCapacity(mapOf.size()));
        Iterator<T> it = mapOf.entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry entry = (Map.Entry) it.next();
            linkedHashMap.put(((NameAndSignature) entry.getKey()).getSignature(), entry.getValue());
        }
        SIGNATURE_TO_DEFAULT_VALUES_MAP = linkedHashMap;
        Set<NameAndSignature> plus = SetsKt___SetsKt.plus((Set) GENERIC_PARAMETERS_METHODS_TO_DEFAULT_VALUES_MAP.keySet(), (Iterable) ERASED_COLLECTION_PARAMETER_NAME_AND_SIGNATURES);
        ArrayList arrayList4 = new ArrayList(CollectionsKt__IterablesKt.collectionSizeOrDefault(plus, 10));
        for (NameAndSignature nameAndSignature3 : plus) {
            arrayList4.add(nameAndSignature3.getName());
        }
        ERASED_VALUE_PARAMETERS_SHORT_NAMES = CollectionsKt___CollectionsKt.toSet(arrayList4);
        ArrayList arrayList5 = new ArrayList(CollectionsKt__IterablesKt.collectionSizeOrDefault(plus, 10));
        for (NameAndSignature nameAndSignature4 : plus) {
            arrayList5.add(nameAndSignature4.getSignature());
        }
        ERASED_VALUE_PARAMETERS_SIGNATURES = CollectionsKt___CollectionsKt.toSet(arrayList5);
    }

    /* loaded from: classes10.dex */
    public enum SpecialSignatureInfo {
        ONE_COLLECTION_PARAMETER("Ljava/util/Collection<+Ljava/lang/Object;>;", false),
        OBJECT_PARAMETER_NON_GENERIC(null, true),
        OBJECT_PARAMETER_GENERIC("Ljava/lang/Object;", true);
        
        public final boolean isObjectReplacedWithTypeParameter;
        public final String valueParametersSignature;

        SpecialSignatureInfo(String str, boolean z) {
            this.valueParametersSignature = str;
            this.isObjectReplacedWithTypeParameter = z;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final boolean getHasErasedValueParametersInJava(CallableMemberDescriptor callableMemberDescriptor) {
        return CollectionsKt___CollectionsKt.contains(ERASED_VALUE_PARAMETERS_SIGNATURES, MethodSignatureMappingKt.computeJvmSignature(callableMemberDescriptor));
    }

    @JvmStatic
    public static final FunctionDescriptor getOverriddenBuiltinFunctionWithErasedValueParametersInJava(FunctionDescriptor functionDescriptor) {
        BuiltinMethodsWithSpecialGenericSignature builtinMethodsWithSpecialGenericSignature = INSTANCE;
        Name name = functionDescriptor.getName();
        Intrinsics.checkExpressionValueIsNotNull(name, "functionDescriptor.name");
        if (!builtinMethodsWithSpecialGenericSignature.getSameAsBuiltinMethodWithErasedValueParameters(name)) {
            return null;
        }
        return (FunctionDescriptor) DescriptorUtilsKt.firstOverridden$default(functionDescriptor, false, new Function1<CallableMemberDescriptor, Boolean>() { // from class: kotlin.reflect.jvm.internal.impl.load.java.BuiltinMethodsWithSpecialGenericSignature$getOverriddenBuiltinFunctionWithErasedValueParametersInJava$1
            /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
            /* JADX DEBUG: Return type fixed from 'java.lang.Object' to match base method */
            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Boolean invoke(CallableMemberDescriptor callableMemberDescriptor) {
                return Boolean.valueOf(invoke2(callableMemberDescriptor));
            }

            /* renamed from: invoke  reason: avoid collision after fix types in other method */
            public final boolean invoke2(CallableMemberDescriptor callableMemberDescriptor) {
                boolean hasErasedValueParametersInJava;
                hasErasedValueParametersInJava = BuiltinMethodsWithSpecialGenericSignature.INSTANCE.getHasErasedValueParametersInJava(callableMemberDescriptor);
                return hasErasedValueParametersInJava;
            }
        }, 1, null);
    }

    public final boolean getSameAsBuiltinMethodWithErasedValueParameters(Name name) {
        return ERASED_VALUE_PARAMETERS_SHORT_NAMES.contains(name);
    }

    @JvmStatic
    public static final SpecialSignatureInfo getSpecialSignatureInfo(CallableMemberDescriptor callableMemberDescriptor) {
        CallableMemberDescriptor firstOverridden$default;
        String computeJvmSignature;
        if (!ERASED_VALUE_PARAMETERS_SHORT_NAMES.contains(callableMemberDescriptor.getName()) || (firstOverridden$default = DescriptorUtilsKt.firstOverridden$default(callableMemberDescriptor, false, new Function1<CallableMemberDescriptor, Boolean>() { // from class: kotlin.reflect.jvm.internal.impl.load.java.BuiltinMethodsWithSpecialGenericSignature$getSpecialSignatureInfo$builtinSignature$1
            /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
            /* JADX DEBUG: Return type fixed from 'java.lang.Object' to match base method */
            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Boolean invoke(CallableMemberDescriptor callableMemberDescriptor2) {
                return Boolean.valueOf(invoke2(callableMemberDescriptor2));
            }

            /* renamed from: invoke  reason: avoid collision after fix types in other method */
            public final boolean invoke2(CallableMemberDescriptor callableMemberDescriptor2) {
                boolean hasErasedValueParametersInJava;
                if (callableMemberDescriptor2 instanceof FunctionDescriptor) {
                    hasErasedValueParametersInJava = BuiltinMethodsWithSpecialGenericSignature.INSTANCE.getHasErasedValueParametersInJava(callableMemberDescriptor2);
                    if (hasErasedValueParametersInJava) {
                        return true;
                    }
                }
                return false;
            }
        }, 1, null)) == null || (computeJvmSignature = MethodSignatureMappingKt.computeJvmSignature(firstOverridden$default)) == null) {
            return null;
        }
        if (ERASED_COLLECTION_PARAMETER_SIGNATURES.contains(computeJvmSignature)) {
            return SpecialSignatureInfo.ONE_COLLECTION_PARAMETER;
        }
        if (((TypeSafeBarrierDescription) MapsKt__MapsKt.getValue(SIGNATURE_TO_DEFAULT_VALUES_MAP, computeJvmSignature)) == TypeSafeBarrierDescription.NULL) {
            return SpecialSignatureInfo.OBJECT_PARAMETER_GENERIC;
        }
        return SpecialSignatureInfo.OBJECT_PARAMETER_NON_GENERIC;
    }
}
