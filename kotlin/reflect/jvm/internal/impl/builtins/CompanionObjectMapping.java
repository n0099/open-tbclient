package kotlin.reflect.jvm.internal.impl.builtins;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import kotlin.collections.CollectionsKt__IterablesKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor;
import kotlin.reflect.jvm.internal.impl.name.ClassId;
import kotlin.reflect.jvm.internal.impl.name.FqName;
import kotlin.reflect.jvm.internal.impl.resolve.DescriptorUtils;
import kotlin.reflect.jvm.internal.impl.resolve.descriptorUtil.DescriptorUtilsKt;
/* loaded from: classes10.dex */
public final class CompanionObjectMapping {
    public static final CompanionObjectMapping INSTANCE = new CompanionObjectMapping();
    public static final LinkedHashSet<ClassId> classIds;

    static {
        Set<PrimitiveType> set = PrimitiveType.NUMBER_TYPES;
        Intrinsics.checkExpressionValueIsNotNull(set, "PrimitiveType.NUMBER_TYPES");
        ArrayList arrayList = new ArrayList(CollectionsKt__IterablesKt.collectionSizeOrDefault(set, 10));
        for (PrimitiveType primitiveType : set) {
            arrayList.add(KotlinBuiltIns.getPrimitiveFqName(primitiveType));
        }
        List<FqName> plus = CollectionsKt___CollectionsKt.plus((Collection<? extends FqName>) CollectionsKt___CollectionsKt.plus((Collection<? extends FqName>) CollectionsKt___CollectionsKt.plus((Collection<? extends FqName>) arrayList, KotlinBuiltIns.FQ_NAMES.string.toSafe()), KotlinBuiltIns.FQ_NAMES._boolean.toSafe()), KotlinBuiltIns.FQ_NAMES._enum.toSafe());
        LinkedHashSet<ClassId> linkedHashSet = new LinkedHashSet<>();
        for (FqName fqName : plus) {
            linkedHashSet.add(ClassId.topLevel(fqName));
        }
        classIds = linkedHashSet;
    }

    public final Set<ClassId> allClassesWithIntrinsicCompanions() {
        Set<ClassId> unmodifiableSet = Collections.unmodifiableSet(classIds);
        Intrinsics.checkExpressionValueIsNotNull(unmodifiableSet, "Collections.unmodifiableSet(classIds)");
        return unmodifiableSet;
    }

    public final boolean isMappedIntrinsicCompanionObject(ClassDescriptor classDescriptor) {
        ClassId classId;
        if (DescriptorUtils.isCompanionObject(classDescriptor)) {
            LinkedHashSet<ClassId> linkedHashSet = classIds;
            ClassId classId2 = DescriptorUtilsKt.getClassId(classDescriptor);
            if (classId2 != null) {
                classId = classId2.getOuterClassId();
            } else {
                classId = null;
            }
            if (CollectionsKt___CollectionsKt.contains(linkedHashSet, classId)) {
                return true;
            }
        }
        return false;
    }
}
