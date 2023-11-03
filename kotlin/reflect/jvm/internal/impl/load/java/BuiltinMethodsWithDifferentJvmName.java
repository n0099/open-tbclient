package kotlin.reflect.jvm.internal.impl.load.java;

import com.baidu.searchbox.wordscommand.util.CommandUBCHelper;
import com.google.android.exoplayer2.source.dash.manifest.UrlTemplate;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.TypeCastException;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.CollectionsKt__IterablesKt;
import kotlin.collections.MapsKt__MapsJVMKt;
import kotlin.collections.MapsKt__MapsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.builtins.KotlinBuiltIns;
import kotlin.reflect.jvm.internal.impl.descriptors.CallableMemberDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.SimpleFunctionDescriptor;
import kotlin.reflect.jvm.internal.impl.load.kotlin.MethodSignatureMappingKt;
import kotlin.reflect.jvm.internal.impl.load.kotlin.SignatureBuildingComponents;
import kotlin.reflect.jvm.internal.impl.name.Name;
import kotlin.reflect.jvm.internal.impl.resolve.descriptorUtil.DescriptorUtilsKt;
import kotlin.reflect.jvm.internal.impl.resolve.jvm.JvmPrimitiveType;
/* loaded from: classes2.dex */
public final class BuiltinMethodsWithDifferentJvmName {
    public static final BuiltinMethodsWithDifferentJvmName INSTANCE = new BuiltinMethodsWithDifferentJvmName();
    public static final Map<Name, List<Name>> JVM_SHORT_NAME_TO_BUILTIN_SHORT_NAMES_MAP;
    public static final Map<NameAndSignature, Name> NAME_AND_SIGNATURE_TO_JVM_REPRESENTATION_NAME_MAP;
    public static final List<Name> ORIGINAL_SHORT_NAMES;
    public static final NameAndSignature REMOVE_AT_NAME_AND_SIGNATURE;
    public static final Map<String, Name> SIGNATURE_TO_JVM_REPRESENTATION_NAME;

    static {
        NameAndSignature method;
        NameAndSignature method2;
        NameAndSignature method3;
        NameAndSignature method4;
        NameAndSignature method5;
        NameAndSignature method6;
        NameAndSignature method7;
        NameAndSignature method8;
        String desc = JvmPrimitiveType.INT.getDesc();
        Intrinsics.checkExpressionValueIsNotNull(desc, "JvmPrimitiveType.INT.desc");
        method = SpecialBuiltinMembers.method("java/util/List", "removeAt", desc, "Ljava/lang/Object;");
        REMOVE_AT_NAME_AND_SIGNATURE = method;
        SignatureBuildingComponents signatureBuildingComponents = SignatureBuildingComponents.INSTANCE;
        String javaLang = signatureBuildingComponents.javaLang(UrlTemplate.NUMBER);
        String desc2 = JvmPrimitiveType.BYTE.getDesc();
        Intrinsics.checkExpressionValueIsNotNull(desc2, "JvmPrimitiveType.BYTE.desc");
        method2 = SpecialBuiltinMembers.method(javaLang, "toByte", "", desc2);
        String javaLang2 = signatureBuildingComponents.javaLang(UrlTemplate.NUMBER);
        String desc3 = JvmPrimitiveType.SHORT.getDesc();
        Intrinsics.checkExpressionValueIsNotNull(desc3, "JvmPrimitiveType.SHORT.desc");
        method3 = SpecialBuiltinMembers.method(javaLang2, "toShort", "", desc3);
        String javaLang3 = signatureBuildingComponents.javaLang(UrlTemplate.NUMBER);
        String desc4 = JvmPrimitiveType.INT.getDesc();
        Intrinsics.checkExpressionValueIsNotNull(desc4, "JvmPrimitiveType.INT.desc");
        method4 = SpecialBuiltinMembers.method(javaLang3, "toInt", "", desc4);
        String javaLang4 = signatureBuildingComponents.javaLang(UrlTemplate.NUMBER);
        String desc5 = JvmPrimitiveType.LONG.getDesc();
        Intrinsics.checkExpressionValueIsNotNull(desc5, "JvmPrimitiveType.LONG.desc");
        method5 = SpecialBuiltinMembers.method(javaLang4, "toLong", "", desc5);
        String javaLang5 = signatureBuildingComponents.javaLang(UrlTemplate.NUMBER);
        String desc6 = JvmPrimitiveType.FLOAT.getDesc();
        Intrinsics.checkExpressionValueIsNotNull(desc6, "JvmPrimitiveType.FLOAT.desc");
        method6 = SpecialBuiltinMembers.method(javaLang5, "toFloat", "", desc6);
        String javaLang6 = signatureBuildingComponents.javaLang(UrlTemplate.NUMBER);
        String desc7 = JvmPrimitiveType.DOUBLE.getDesc();
        Intrinsics.checkExpressionValueIsNotNull(desc7, "JvmPrimitiveType.DOUBLE.desc");
        method7 = SpecialBuiltinMembers.method(javaLang6, "toDouble", "", desc7);
        String javaLang7 = signatureBuildingComponents.javaLang("CharSequence");
        String desc8 = JvmPrimitiveType.INT.getDesc();
        Intrinsics.checkExpressionValueIsNotNull(desc8, "JvmPrimitiveType.INT.desc");
        String desc9 = JvmPrimitiveType.CHAR.getDesc();
        Intrinsics.checkExpressionValueIsNotNull(desc9, "JvmPrimitiveType.CHAR.desc");
        method8 = SpecialBuiltinMembers.method(javaLang7, CommandUBCHelper.COMMAND_UBC_SOURCE_RECEIVE, desc8, desc9);
        Map<NameAndSignature, Name> mapOf = MapsKt__MapsKt.mapOf(TuplesKt.to(method2, Name.identifier("byteValue")), TuplesKt.to(method3, Name.identifier("shortValue")), TuplesKt.to(method4, Name.identifier("intValue")), TuplesKt.to(method5, Name.identifier("longValue")), TuplesKt.to(method6, Name.identifier("floatValue")), TuplesKt.to(method7, Name.identifier("doubleValue")), TuplesKt.to(REMOVE_AT_NAME_AND_SIGNATURE, Name.identifier("remove")), TuplesKt.to(method8, Name.identifier("charAt")));
        NAME_AND_SIGNATURE_TO_JVM_REPRESENTATION_NAME_MAP = mapOf;
        LinkedHashMap linkedHashMap = new LinkedHashMap(MapsKt__MapsJVMKt.mapCapacity(mapOf.size()));
        Iterator<T> it = mapOf.entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry entry = (Map.Entry) it.next();
            linkedHashMap.put(((NameAndSignature) entry.getKey()).getSignature(), entry.getValue());
        }
        SIGNATURE_TO_JVM_REPRESENTATION_NAME = linkedHashMap;
        Set<NameAndSignature> keySet = NAME_AND_SIGNATURE_TO_JVM_REPRESENTATION_NAME_MAP.keySet();
        ArrayList arrayList = new ArrayList(CollectionsKt__IterablesKt.collectionSizeOrDefault(keySet, 10));
        for (NameAndSignature nameAndSignature : keySet) {
            arrayList.add(nameAndSignature.getName());
        }
        ORIGINAL_SHORT_NAMES = arrayList;
        Set<Map.Entry<NameAndSignature, Name>> entrySet = NAME_AND_SIGNATURE_TO_JVM_REPRESENTATION_NAME_MAP.entrySet();
        ArrayList<Pair> arrayList2 = new ArrayList(CollectionsKt__IterablesKt.collectionSizeOrDefault(entrySet, 10));
        Iterator<T> it2 = entrySet.iterator();
        while (it2.hasNext()) {
            Map.Entry entry2 = (Map.Entry) it2.next();
            arrayList2.add(new Pair(((NameAndSignature) entry2.getKey()).getName(), entry2.getValue()));
        }
        LinkedHashMap linkedHashMap2 = new LinkedHashMap();
        for (Pair pair : arrayList2) {
            Name name = (Name) pair.getSecond();
            Object obj = linkedHashMap2.get(name);
            if (obj == null) {
                obj = new ArrayList();
                linkedHashMap2.put(name, obj);
            }
            ((List) obj).add((Name) pair.getFirst());
        }
        JVM_SHORT_NAME_TO_BUILTIN_SHORT_NAMES_MAP = linkedHashMap2;
    }

    public final List<Name> getORIGINAL_SHORT_NAMES() {
        return ORIGINAL_SHORT_NAMES;
    }

    public final List<Name> getBuiltinFunctionNamesByJvmName(Name name) {
        List<Name> list = JVM_SHORT_NAME_TO_BUILTIN_SHORT_NAMES_MAP.get(name);
        if (list == null) {
            return CollectionsKt__CollectionsKt.emptyList();
        }
        return list;
    }

    public final Name getJvmName(SimpleFunctionDescriptor simpleFunctionDescriptor) {
        Map<String, Name> map = SIGNATURE_TO_JVM_REPRESENTATION_NAME;
        String computeJvmSignature = MethodSignatureMappingKt.computeJvmSignature(simpleFunctionDescriptor);
        if (computeJvmSignature != null) {
            return map.get(computeJvmSignature);
        }
        return null;
    }

    public final boolean getSameAsRenamedInJvmBuiltin(Name name) {
        return ORIGINAL_SHORT_NAMES.contains(name);
    }

    public final boolean isBuiltinFunctionWithDifferentNameInJvm(final SimpleFunctionDescriptor simpleFunctionDescriptor) {
        if (KotlinBuiltIns.isBuiltIn(simpleFunctionDescriptor) && DescriptorUtilsKt.firstOverridden$default(simpleFunctionDescriptor, false, new Function1<CallableMemberDescriptor, Boolean>() { // from class: kotlin.reflect.jvm.internal.impl.load.java.BuiltinMethodsWithDifferentJvmName$isBuiltinFunctionWithDifferentNameInJvm$1
            {
                super(1);
            }

            /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
            /* JADX DEBUG: Return type fixed from 'java.lang.Object' to match base method */
            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Boolean invoke(CallableMemberDescriptor callableMemberDescriptor) {
                return Boolean.valueOf(invoke2(callableMemberDescriptor));
            }

            /* renamed from: invoke  reason: avoid collision after fix types in other method */
            public final boolean invoke2(CallableMemberDescriptor callableMemberDescriptor) {
                Map map;
                BuiltinMethodsWithDifferentJvmName builtinMethodsWithDifferentJvmName = BuiltinMethodsWithDifferentJvmName.INSTANCE;
                map = BuiltinMethodsWithDifferentJvmName.SIGNATURE_TO_JVM_REPRESENTATION_NAME;
                String computeJvmSignature = MethodSignatureMappingKt.computeJvmSignature(SimpleFunctionDescriptor.this);
                if (map != null) {
                    return map.containsKey(computeJvmSignature);
                }
                throw new TypeCastException("null cannot be cast to non-null type kotlin.collections.Map<K, *>");
            }
        }, 1, null) != null) {
            return true;
        }
        return false;
    }

    public final boolean isRemoveAtByIndex(SimpleFunctionDescriptor simpleFunctionDescriptor) {
        if (Intrinsics.areEqual(simpleFunctionDescriptor.getName().asString(), "removeAt") && Intrinsics.areEqual(MethodSignatureMappingKt.computeJvmSignature(simpleFunctionDescriptor), REMOVE_AT_NAME_AND_SIGNATURE.getSignature())) {
            return true;
        }
        return false;
    }
}
