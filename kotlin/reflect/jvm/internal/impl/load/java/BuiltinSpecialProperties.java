package kotlin.reflect.jvm.internal.impl.load.java;

import androidx.lifecycle.SavedStateHandle;
import com.baidu.searchbox.cloudcontrol.utils.CloudStabilityUBCUtils;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin._Assertions;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.CollectionsKt__IterablesKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.collections.MapsKt__MapsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.builtins.KotlinBuiltIns;
import kotlin.reflect.jvm.internal.impl.descriptors.CallableMemberDescriptor;
import kotlin.reflect.jvm.internal.impl.name.FqName;
import kotlin.reflect.jvm.internal.impl.name.FqNameUnsafe;
import kotlin.reflect.jvm.internal.impl.name.Name;
import kotlin.reflect.jvm.internal.impl.resolve.descriptorUtil.DescriptorUtilsKt;
/* loaded from: classes9.dex */
public final class BuiltinSpecialProperties {
    public static final Map<Name, List<Name>> GETTER_JVM_NAME_TO_PROPERTIES_SHORT_NAME_MAP;
    public static final BuiltinSpecialProperties INSTANCE = new BuiltinSpecialProperties();
    public static final Map<FqName, Name> PROPERTY_FQ_NAME_TO_JVM_GETTER_NAME_MAP;
    public static final Set<FqName> SPECIAL_FQ_NAMES;
    public static final Set<Name> SPECIAL_SHORT_NAMES;

    static {
        FqName childSafe;
        FqName childSafe2;
        FqName child;
        FqName child2;
        FqName childSafe3;
        FqName child3;
        FqName child4;
        FqName child5;
        FqNameUnsafe fqNameUnsafe = KotlinBuiltIns.FQ_NAMES._enum;
        Intrinsics.checkExpressionValueIsNotNull(fqNameUnsafe, "BUILTIN_NAMES._enum");
        childSafe = SpecialBuiltinMembers.childSafe(fqNameUnsafe, "name");
        FqNameUnsafe fqNameUnsafe2 = KotlinBuiltIns.FQ_NAMES._enum;
        Intrinsics.checkExpressionValueIsNotNull(fqNameUnsafe2, "BUILTIN_NAMES._enum");
        childSafe2 = SpecialBuiltinMembers.childSafe(fqNameUnsafe2, "ordinal");
        FqName fqName = KotlinBuiltIns.FQ_NAMES.collection;
        Intrinsics.checkExpressionValueIsNotNull(fqName, "BUILTIN_NAMES.collection");
        child = SpecialBuiltinMembers.child(fqName, "size");
        FqName fqName2 = KotlinBuiltIns.FQ_NAMES.map;
        Intrinsics.checkExpressionValueIsNotNull(fqName2, "BUILTIN_NAMES.map");
        child2 = SpecialBuiltinMembers.child(fqName2, "size");
        FqNameUnsafe fqNameUnsafe3 = KotlinBuiltIns.FQ_NAMES.charSequence;
        Intrinsics.checkExpressionValueIsNotNull(fqNameUnsafe3, "BUILTIN_NAMES.charSequence");
        childSafe3 = SpecialBuiltinMembers.childSafe(fqNameUnsafe3, CloudStabilityUBCUtils.KEY_LENGTH);
        FqName fqName3 = KotlinBuiltIns.FQ_NAMES.map;
        Intrinsics.checkExpressionValueIsNotNull(fqName3, "BUILTIN_NAMES.map");
        child3 = SpecialBuiltinMembers.child(fqName3, SavedStateHandle.KEYS);
        FqName fqName4 = KotlinBuiltIns.FQ_NAMES.map;
        Intrinsics.checkExpressionValueIsNotNull(fqName4, "BUILTIN_NAMES.map");
        child4 = SpecialBuiltinMembers.child(fqName4, SavedStateHandle.VALUES);
        FqName fqName5 = KotlinBuiltIns.FQ_NAMES.map;
        Intrinsics.checkExpressionValueIsNotNull(fqName5, "BUILTIN_NAMES.map");
        child5 = SpecialBuiltinMembers.child(fqName5, "entries");
        Map<FqName, Name> mapOf = MapsKt__MapsKt.mapOf(TuplesKt.to(childSafe, Name.identifier("name")), TuplesKt.to(childSafe2, Name.identifier("ordinal")), TuplesKt.to(child, Name.identifier("size")), TuplesKt.to(child2, Name.identifier("size")), TuplesKt.to(childSafe3, Name.identifier(CloudStabilityUBCUtils.KEY_LENGTH)), TuplesKt.to(child3, Name.identifier("keySet")), TuplesKt.to(child4, Name.identifier(SavedStateHandle.VALUES)), TuplesKt.to(child5, Name.identifier("entrySet")));
        PROPERTY_FQ_NAME_TO_JVM_GETTER_NAME_MAP = mapOf;
        Set<Map.Entry<FqName, Name>> entrySet = mapOf.entrySet();
        ArrayList<Pair> arrayList = new ArrayList(CollectionsKt__IterablesKt.collectionSizeOrDefault(entrySet, 10));
        Iterator<T> it = entrySet.iterator();
        while (it.hasNext()) {
            Map.Entry entry = (Map.Entry) it.next();
            arrayList.add(new Pair(((FqName) entry.getKey()).shortName(), entry.getValue()));
        }
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        for (Pair pair : arrayList) {
            Name name = (Name) pair.getSecond();
            Object obj = linkedHashMap.get(name);
            if (obj == null) {
                obj = new ArrayList();
                linkedHashMap.put(name, obj);
            }
            ((List) obj).add((Name) pair.getFirst());
        }
        GETTER_JVM_NAME_TO_PROPERTIES_SHORT_NAME_MAP = linkedHashMap;
        Set<FqName> keySet = PROPERTY_FQ_NAME_TO_JVM_GETTER_NAME_MAP.keySet();
        SPECIAL_FQ_NAMES = keySet;
        ArrayList arrayList2 = new ArrayList(CollectionsKt__IterablesKt.collectionSizeOrDefault(keySet, 10));
        for (FqName fqName6 : keySet) {
            arrayList2.add(fqName6.shortName());
        }
        SPECIAL_SHORT_NAMES = CollectionsKt___CollectionsKt.toSet(arrayList2);
    }

    public final Set<Name> getSPECIAL_SHORT_NAMES$descriptors_jvm() {
        return SPECIAL_SHORT_NAMES;
    }

    private final boolean hasBuiltinSpecialPropertyFqNameImpl(CallableMemberDescriptor callableMemberDescriptor) {
        if (CollectionsKt___CollectionsKt.contains(SPECIAL_FQ_NAMES, DescriptorUtilsKt.fqNameOrNull(callableMemberDescriptor)) && callableMemberDescriptor.getValueParameters().isEmpty()) {
            return true;
        }
        if (!KotlinBuiltIns.isBuiltIn(callableMemberDescriptor)) {
            return false;
        }
        Collection<? extends CallableMemberDescriptor> overriddenDescriptors = callableMemberDescriptor.getOverriddenDescriptors();
        Intrinsics.checkExpressionValueIsNotNull(overriddenDescriptors, "overriddenDescriptors");
        if (!(overriddenDescriptors instanceof Collection) || !overriddenDescriptors.isEmpty()) {
            for (CallableMemberDescriptor it : overriddenDescriptors) {
                BuiltinSpecialProperties builtinSpecialProperties = INSTANCE;
                Intrinsics.checkExpressionValueIsNotNull(it, "it");
                if (builtinSpecialProperties.hasBuiltinSpecialPropertyFqName(it)) {
                    return true;
                }
            }
        }
        return false;
    }

    public final String getBuiltinSpecialPropertyGetterName(CallableMemberDescriptor callableMemberDescriptor) {
        Name name;
        boolean isBuiltIn = KotlinBuiltIns.isBuiltIn(callableMemberDescriptor);
        if (_Assertions.ENABLED && !isBuiltIn) {
            throw new AssertionError("This method is defined only for builtin members, but " + callableMemberDescriptor + " found");
        }
        CallableMemberDescriptor firstOverridden$default = DescriptorUtilsKt.firstOverridden$default(DescriptorUtilsKt.getPropertyIfAccessor(callableMemberDescriptor), false, new Function1<CallableMemberDescriptor, Boolean>() { // from class: kotlin.reflect.jvm.internal.impl.load.java.BuiltinSpecialProperties$getBuiltinSpecialPropertyGetterName$descriptor$1
            /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
            /* JADX DEBUG: Return type fixed from 'java.lang.Object' to match base method */
            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Boolean invoke(CallableMemberDescriptor callableMemberDescriptor2) {
                return Boolean.valueOf(invoke2(callableMemberDescriptor2));
            }

            /* renamed from: invoke  reason: avoid collision after fix types in other method */
            public final boolean invoke2(CallableMemberDescriptor callableMemberDescriptor2) {
                return BuiltinSpecialProperties.INSTANCE.hasBuiltinSpecialPropertyFqName(callableMemberDescriptor2);
            }
        }, 1, null);
        if (firstOverridden$default == null || (name = PROPERTY_FQ_NAME_TO_JVM_GETTER_NAME_MAP.get(DescriptorUtilsKt.getFqNameSafe(firstOverridden$default))) == null) {
            return null;
        }
        return name.asString();
    }

    public final List<Name> getPropertyNameCandidatesBySpecialGetterName(Name name) {
        List<Name> list = GETTER_JVM_NAME_TO_PROPERTIES_SHORT_NAME_MAP.get(name);
        if (list == null) {
            return CollectionsKt__CollectionsKt.emptyList();
        }
        return list;
    }

    public final boolean hasBuiltinSpecialPropertyFqName(CallableMemberDescriptor callableMemberDescriptor) {
        if (!SPECIAL_SHORT_NAMES.contains(callableMemberDescriptor.getName())) {
            return false;
        }
        return hasBuiltinSpecialPropertyFqNameImpl(callableMemberDescriptor);
    }
}
