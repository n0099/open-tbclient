package kotlin.reflect.jvm.internal.impl.builtins;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashSet;
import java.util.Set;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassifierDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.PackageFragmentDescriptor;
import kotlin.reflect.jvm.internal.impl.name.ClassId;
import kotlin.reflect.jvm.internal.impl.name.Name;
import kotlin.reflect.jvm.internal.impl.types.KotlinType;
import kotlin.reflect.jvm.internal.impl.types.TypeUtils;
/* loaded from: classes2.dex */
public final class UnsignedTypes {
    public static final UnsignedTypes INSTANCE = new UnsignedTypes();
    public static final HashMap<ClassId, ClassId> arrayClassIdToUnsignedClassId;
    public static final Set<Name> arrayClassesShortNames;
    public static final HashMap<ClassId, ClassId> unsignedClassIdToArrayClassId;
    public static final Set<Name> unsignedTypeNames;

    static {
        UnsignedType[] values;
        UnsignedType[] values2 = UnsignedType.values();
        ArrayList arrayList = new ArrayList(values2.length);
        for (UnsignedType unsignedType : values2) {
            arrayList.add(unsignedType.getTypeName());
        }
        unsignedTypeNames = CollectionsKt___CollectionsKt.toSet(arrayList);
        arrayClassIdToUnsignedClassId = new HashMap<>();
        unsignedClassIdToArrayClassId = new HashMap<>();
        UnsignedType[] values3 = UnsignedType.values();
        LinkedHashSet linkedHashSet = new LinkedHashSet();
        for (UnsignedType unsignedType2 : values3) {
            linkedHashSet.add(unsignedType2.getArrayClassId().getShortClassName());
        }
        arrayClassesShortNames = linkedHashSet;
        for (UnsignedType unsignedType3 : UnsignedType.values()) {
            arrayClassIdToUnsignedClassId.put(unsignedType3.getArrayClassId(), unsignedType3.getClassId());
            unsignedClassIdToArrayClassId.put(unsignedType3.getClassId(), unsignedType3.getArrayClassId());
        }
    }

    public final ClassId getUnsignedClassIdByArrayClassId(ClassId classId) {
        return arrayClassIdToUnsignedClassId.get(classId);
    }

    public final boolean isShortNameOfUnsignedArray(Name name) {
        return arrayClassesShortNames.contains(name);
    }

    public final boolean isUnsignedClass(DeclarationDescriptor declarationDescriptor) {
        DeclarationDescriptor containingDeclaration = declarationDescriptor.getContainingDeclaration();
        if ((containingDeclaration instanceof PackageFragmentDescriptor) && Intrinsics.areEqual(((PackageFragmentDescriptor) containingDeclaration).getFqName(), KotlinBuiltIns.BUILT_INS_PACKAGE_FQ_NAME) && unsignedTypeNames.contains(declarationDescriptor.getName())) {
            return true;
        }
        return false;
    }

    public final boolean isUnsignedType(KotlinType kotlinType) {
        ClassifierDescriptor mo2110getDeclarationDescriptor;
        if (TypeUtils.noExpectedType(kotlinType) || (mo2110getDeclarationDescriptor = kotlinType.getConstructor().mo2110getDeclarationDescriptor()) == null) {
            return false;
        }
        Intrinsics.checkExpressionValueIsNotNull(mo2110getDeclarationDescriptor, "type.constructor.declara…escriptor ?: return false");
        return isUnsignedClass(mo2110getDeclarationDescriptor);
    }
}
