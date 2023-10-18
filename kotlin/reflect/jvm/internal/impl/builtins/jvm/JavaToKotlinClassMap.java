package kotlin.reflect.jvm.internal.impl.builtins.jvm;

import com.baidu.tbadk.core.data.SmallTailInfo;
import com.huawei.hms.common.internal.TransactionIdCreater;
import java.lang.annotation.Annotation;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.Map;
import java.util.Set;
import kotlin.TypeCastException;
import kotlin._Assertions;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.SetsKt__SetsJVMKt;
import kotlin.collections.SetsKt__SetsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.builtins.CompanionObjectMapping;
import kotlin.reflect.jvm.internal.impl.builtins.KotlinBuiltIns;
import kotlin.reflect.jvm.internal.impl.builtins.functions.FunctionClassDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor;
import kotlin.reflect.jvm.internal.impl.name.ClassId;
import kotlin.reflect.jvm.internal.impl.name.FqName;
import kotlin.reflect.jvm.internal.impl.name.FqNameUnsafe;
import kotlin.reflect.jvm.internal.impl.name.FqNamesUtilKt;
import kotlin.reflect.jvm.internal.impl.name.Name;
import kotlin.reflect.jvm.internal.impl.name.SpecialNames;
import kotlin.reflect.jvm.internal.impl.resolve.DescriptorUtils;
import kotlin.reflect.jvm.internal.impl.resolve.descriptorUtil.DescriptorUtilsKt;
import kotlin.reflect.jvm.internal.impl.resolve.jvm.JvmPrimitiveType;
import kotlin.reflect.jvm.internal.impl.types.KotlinType;
import kotlin.reflect.jvm.internal.impl.types.TypeUtils;
import kotlin.text.StringsKt__StringNumberConversionsKt;
import kotlin.text.StringsKt__StringsKt;
/* loaded from: classes10.dex */
public final class JavaToKotlinClassMap {
    public static final ClassId FUNCTION_N_CLASS_ID;
    public static final FqName FUNCTION_N_FQ_NAME;
    public static final JavaToKotlinClassMap INSTANCE;
    public static final ClassId K_FUNCTION_CLASS_ID;
    public static final String NUMBERED_FUNCTION_PREFIX;
    public static final String NUMBERED_K_FUNCTION_PREFIX;
    public static final String NUMBERED_K_SUSPEND_FUNCTION_PREFIX;
    public static final String NUMBERED_SUSPEND_FUNCTION_PREFIX;
    public static final HashMap<FqNameUnsafe, ClassId> javaToKotlin;
    public static final HashMap<FqNameUnsafe, ClassId> kotlinToJava;
    public static final List<PlatformMutabilityMapping> mutabilityMappings;
    public static final HashMap<FqNameUnsafe, FqName> mutableToReadOnly;
    public static final HashMap<FqNameUnsafe, FqName> readOnlyToMutable;

    /* loaded from: classes10.dex */
    public static final class PlatformMutabilityMapping {
        public final ClassId javaClass;
        public final ClassId kotlinMutable;
        public final ClassId kotlinReadOnly;

        public final ClassId component1() {
            return this.javaClass;
        }

        public final ClassId component2() {
            return this.kotlinReadOnly;
        }

        public final ClassId component3() {
            return this.kotlinMutable;
        }

        public boolean equals(Object obj) {
            if (this != obj) {
                if (obj instanceof PlatformMutabilityMapping) {
                    PlatformMutabilityMapping platformMutabilityMapping = (PlatformMutabilityMapping) obj;
                    return Intrinsics.areEqual(this.javaClass, platformMutabilityMapping.javaClass) && Intrinsics.areEqual(this.kotlinReadOnly, platformMutabilityMapping.kotlinReadOnly) && Intrinsics.areEqual(this.kotlinMutable, platformMutabilityMapping.kotlinMutable);
                }
                return false;
            }
            return true;
        }

        public int hashCode() {
            ClassId classId = this.javaClass;
            int hashCode = (classId != null ? classId.hashCode() : 0) * 31;
            ClassId classId2 = this.kotlinReadOnly;
            int hashCode2 = (hashCode + (classId2 != null ? classId2.hashCode() : 0)) * 31;
            ClassId classId3 = this.kotlinMutable;
            return hashCode2 + (classId3 != null ? classId3.hashCode() : 0);
        }

        public String toString() {
            return "PlatformMutabilityMapping(javaClass=" + this.javaClass + ", kotlinReadOnly=" + this.kotlinReadOnly + ", kotlinMutable=" + this.kotlinMutable + SmallTailInfo.EMOTION_SUFFIX;
        }

        public PlatformMutabilityMapping(ClassId classId, ClassId classId2, ClassId classId3) {
            this.javaClass = classId;
            this.kotlinReadOnly = classId2;
            this.kotlinMutable = classId3;
        }

        public final ClassId getJavaClass() {
            return this.javaClass;
        }
    }

    static {
        JvmPrimitiveType[] values;
        JavaToKotlinClassMap javaToKotlinClassMap = new JavaToKotlinClassMap();
        INSTANCE = javaToKotlinClassMap;
        NUMBERED_FUNCTION_PREFIX = FunctionClassDescriptor.Kind.Function.getPackageFqName().toString() + "." + FunctionClassDescriptor.Kind.Function.getClassNamePrefix();
        NUMBERED_K_FUNCTION_PREFIX = FunctionClassDescriptor.Kind.KFunction.getPackageFqName().toString() + "." + FunctionClassDescriptor.Kind.KFunction.getClassNamePrefix();
        NUMBERED_SUSPEND_FUNCTION_PREFIX = FunctionClassDescriptor.Kind.SuspendFunction.getPackageFqName().toString() + "." + FunctionClassDescriptor.Kind.SuspendFunction.getClassNamePrefix();
        NUMBERED_K_SUSPEND_FUNCTION_PREFIX = FunctionClassDescriptor.Kind.KSuspendFunction.getPackageFqName().toString() + "." + FunctionClassDescriptor.Kind.KSuspendFunction.getClassNamePrefix();
        ClassId classId = ClassId.topLevel(new FqName("kotlin.jvm.functions.FunctionN"));
        Intrinsics.checkExpressionValueIsNotNull(classId, "ClassId.topLevel(FqName(…vm.functions.FunctionN\"))");
        FUNCTION_N_CLASS_ID = classId;
        FqName asSingleFqName = classId.asSingleFqName();
        Intrinsics.checkExpressionValueIsNotNull(asSingleFqName, "FUNCTION_N_CLASS_ID.asSingleFqName()");
        FUNCTION_N_FQ_NAME = asSingleFqName;
        ClassId classId2 = ClassId.topLevel(new FqName("kotlin.reflect.KFunction"));
        Intrinsics.checkExpressionValueIsNotNull(classId2, "ClassId.topLevel(FqName(…tlin.reflect.KFunction\"))");
        K_FUNCTION_CLASS_ID = classId2;
        javaToKotlin = new HashMap<>();
        kotlinToJava = new HashMap<>();
        mutableToReadOnly = new HashMap<>();
        readOnlyToMutable = new HashMap<>();
        ClassId classId3 = ClassId.topLevel(KotlinBuiltIns.FQ_NAMES.iterable);
        Intrinsics.checkExpressionValueIsNotNull(classId3, "ClassId.topLevel(FQ_NAMES.iterable)");
        FqName fqName = KotlinBuiltIns.FQ_NAMES.mutableIterable;
        Intrinsics.checkExpressionValueIsNotNull(fqName, "FQ_NAMES.mutableIterable");
        FqName packageFqName = classId3.getPackageFqName();
        FqName packageFqName2 = classId3.getPackageFqName();
        Intrinsics.checkExpressionValueIsNotNull(packageFqName2, "kotlinReadOnly.packageFqName");
        FqName tail = FqNamesUtilKt.tail(fqName, packageFqName2);
        ClassId classId4 = new ClassId(packageFqName, tail, false);
        ClassId classId5 = ClassId.topLevel(KotlinBuiltIns.FQ_NAMES.iterator);
        Intrinsics.checkExpressionValueIsNotNull(classId5, "ClassId.topLevel(FQ_NAMES.iterator)");
        FqName fqName2 = KotlinBuiltIns.FQ_NAMES.mutableIterator;
        Intrinsics.checkExpressionValueIsNotNull(fqName2, "FQ_NAMES.mutableIterator");
        FqName packageFqName3 = classId5.getPackageFqName();
        FqName packageFqName4 = classId5.getPackageFqName();
        Intrinsics.checkExpressionValueIsNotNull(packageFqName4, "kotlinReadOnly.packageFqName");
        ClassId classId6 = new ClassId(packageFqName3, FqNamesUtilKt.tail(fqName2, packageFqName4), false);
        ClassId classId7 = ClassId.topLevel(KotlinBuiltIns.FQ_NAMES.collection);
        Intrinsics.checkExpressionValueIsNotNull(classId7, "ClassId.topLevel(FQ_NAMES.collection)");
        FqName fqName3 = KotlinBuiltIns.FQ_NAMES.mutableCollection;
        Intrinsics.checkExpressionValueIsNotNull(fqName3, "FQ_NAMES.mutableCollection");
        FqName packageFqName5 = classId7.getPackageFqName();
        FqName packageFqName6 = classId7.getPackageFqName();
        Intrinsics.checkExpressionValueIsNotNull(packageFqName6, "kotlinReadOnly.packageFqName");
        ClassId classId8 = new ClassId(packageFqName5, FqNamesUtilKt.tail(fqName3, packageFqName6), false);
        ClassId classId9 = ClassId.topLevel(KotlinBuiltIns.FQ_NAMES.list);
        Intrinsics.checkExpressionValueIsNotNull(classId9, "ClassId.topLevel(FQ_NAMES.list)");
        FqName fqName4 = KotlinBuiltIns.FQ_NAMES.mutableList;
        Intrinsics.checkExpressionValueIsNotNull(fqName4, "FQ_NAMES.mutableList");
        FqName packageFqName7 = classId9.getPackageFqName();
        FqName packageFqName8 = classId9.getPackageFqName();
        Intrinsics.checkExpressionValueIsNotNull(packageFqName8, "kotlinReadOnly.packageFqName");
        ClassId classId10 = new ClassId(packageFqName7, FqNamesUtilKt.tail(fqName4, packageFqName8), false);
        ClassId classId11 = ClassId.topLevel(KotlinBuiltIns.FQ_NAMES.set);
        Intrinsics.checkExpressionValueIsNotNull(classId11, "ClassId.topLevel(FQ_NAMES.set)");
        FqName fqName5 = KotlinBuiltIns.FQ_NAMES.mutableSet;
        Intrinsics.checkExpressionValueIsNotNull(fqName5, "FQ_NAMES.mutableSet");
        FqName packageFqName9 = classId11.getPackageFqName();
        FqName packageFqName10 = classId11.getPackageFqName();
        Intrinsics.checkExpressionValueIsNotNull(packageFqName10, "kotlinReadOnly.packageFqName");
        ClassId classId12 = new ClassId(packageFqName9, FqNamesUtilKt.tail(fqName5, packageFqName10), false);
        ClassId classId13 = ClassId.topLevel(KotlinBuiltIns.FQ_NAMES.listIterator);
        Intrinsics.checkExpressionValueIsNotNull(classId13, "ClassId.topLevel(FQ_NAMES.listIterator)");
        FqName fqName6 = KotlinBuiltIns.FQ_NAMES.mutableListIterator;
        Intrinsics.checkExpressionValueIsNotNull(fqName6, "FQ_NAMES.mutableListIterator");
        FqName packageFqName11 = classId13.getPackageFqName();
        FqName packageFqName12 = classId13.getPackageFqName();
        Intrinsics.checkExpressionValueIsNotNull(packageFqName12, "kotlinReadOnly.packageFqName");
        ClassId classId14 = new ClassId(packageFqName11, FqNamesUtilKt.tail(fqName6, packageFqName12), false);
        ClassId classId15 = ClassId.topLevel(KotlinBuiltIns.FQ_NAMES.map);
        Intrinsics.checkExpressionValueIsNotNull(classId15, "ClassId.topLevel(FQ_NAMES.map)");
        FqName fqName7 = KotlinBuiltIns.FQ_NAMES.mutableMap;
        Intrinsics.checkExpressionValueIsNotNull(fqName7, "FQ_NAMES.mutableMap");
        FqName packageFqName13 = classId15.getPackageFqName();
        FqName packageFqName14 = classId15.getPackageFqName();
        Intrinsics.checkExpressionValueIsNotNull(packageFqName14, "kotlinReadOnly.packageFqName");
        ClassId classId16 = new ClassId(packageFqName13, FqNamesUtilKt.tail(fqName7, packageFqName14), false);
        ClassId createNestedClassId = ClassId.topLevel(KotlinBuiltIns.FQ_NAMES.map).createNestedClassId(KotlinBuiltIns.FQ_NAMES.mapEntry.shortName());
        Intrinsics.checkExpressionValueIsNotNull(createNestedClassId, "ClassId.topLevel(FQ_NAME…MES.mapEntry.shortName())");
        FqName fqName8 = KotlinBuiltIns.FQ_NAMES.mutableMapEntry;
        Intrinsics.checkExpressionValueIsNotNull(fqName8, "FQ_NAMES.mutableMapEntry");
        FqName packageFqName15 = createNestedClassId.getPackageFqName();
        FqName packageFqName16 = createNestedClassId.getPackageFqName();
        Intrinsics.checkExpressionValueIsNotNull(packageFqName16, "kotlinReadOnly.packageFqName");
        mutabilityMappings = CollectionsKt__CollectionsKt.listOf((Object[]) new PlatformMutabilityMapping[]{new PlatformMutabilityMapping(javaToKotlinClassMap.classId(Iterable.class), classId3, classId4), new PlatformMutabilityMapping(javaToKotlinClassMap.classId(Iterator.class), classId5, classId6), new PlatformMutabilityMapping(javaToKotlinClassMap.classId(Collection.class), classId7, classId8), new PlatformMutabilityMapping(javaToKotlinClassMap.classId(List.class), classId9, classId10), new PlatformMutabilityMapping(javaToKotlinClassMap.classId(Set.class), classId11, classId12), new PlatformMutabilityMapping(javaToKotlinClassMap.classId(ListIterator.class), classId13, classId14), new PlatformMutabilityMapping(javaToKotlinClassMap.classId(Map.class), classId15, classId16), new PlatformMutabilityMapping(javaToKotlinClassMap.classId(Map.Entry.class), createNestedClassId, new ClassId(packageFqName15, FqNamesUtilKt.tail(fqName8, packageFqName16), false))});
        FqNameUnsafe fqNameUnsafe = KotlinBuiltIns.FQ_NAMES.any;
        Intrinsics.checkExpressionValueIsNotNull(fqNameUnsafe, "FQ_NAMES.any");
        javaToKotlinClassMap.addTopLevel(Object.class, fqNameUnsafe);
        FqNameUnsafe fqNameUnsafe2 = KotlinBuiltIns.FQ_NAMES.string;
        Intrinsics.checkExpressionValueIsNotNull(fqNameUnsafe2, "FQ_NAMES.string");
        javaToKotlinClassMap.addTopLevel(String.class, fqNameUnsafe2);
        FqNameUnsafe fqNameUnsafe3 = KotlinBuiltIns.FQ_NAMES.charSequence;
        Intrinsics.checkExpressionValueIsNotNull(fqNameUnsafe3, "FQ_NAMES.charSequence");
        javaToKotlinClassMap.addTopLevel(CharSequence.class, fqNameUnsafe3);
        FqName fqName9 = KotlinBuiltIns.FQ_NAMES.throwable;
        Intrinsics.checkExpressionValueIsNotNull(fqName9, "FQ_NAMES.throwable");
        javaToKotlinClassMap.addTopLevel(Throwable.class, fqName9);
        FqNameUnsafe fqNameUnsafe4 = KotlinBuiltIns.FQ_NAMES.cloneable;
        Intrinsics.checkExpressionValueIsNotNull(fqNameUnsafe4, "FQ_NAMES.cloneable");
        javaToKotlinClassMap.addTopLevel(Cloneable.class, fqNameUnsafe4);
        FqNameUnsafe fqNameUnsafe5 = KotlinBuiltIns.FQ_NAMES.number;
        Intrinsics.checkExpressionValueIsNotNull(fqNameUnsafe5, "FQ_NAMES.number");
        javaToKotlinClassMap.addTopLevel(Number.class, fqNameUnsafe5);
        FqName fqName10 = KotlinBuiltIns.FQ_NAMES.comparable;
        Intrinsics.checkExpressionValueIsNotNull(fqName10, "FQ_NAMES.comparable");
        javaToKotlinClassMap.addTopLevel(Comparable.class, fqName10);
        FqNameUnsafe fqNameUnsafe6 = KotlinBuiltIns.FQ_NAMES._enum;
        Intrinsics.checkExpressionValueIsNotNull(fqNameUnsafe6, "FQ_NAMES._enum");
        javaToKotlinClassMap.addTopLevel(Enum.class, fqNameUnsafe6);
        FqName fqName11 = KotlinBuiltIns.FQ_NAMES.annotation;
        Intrinsics.checkExpressionValueIsNotNull(fqName11, "FQ_NAMES.annotation");
        javaToKotlinClassMap.addTopLevel(Annotation.class, fqName11);
        for (PlatformMutabilityMapping platformMutabilityMapping : mutabilityMappings) {
            javaToKotlinClassMap.addMapping(platformMutabilityMapping);
        }
        for (JvmPrimitiveType jvmPrimitiveType : JvmPrimitiveType.values()) {
            ClassId classId17 = ClassId.topLevel(jvmPrimitiveType.getWrapperFqName());
            Intrinsics.checkExpressionValueIsNotNull(classId17, "ClassId.topLevel(jvmType.wrapperFqName)");
            ClassId classId18 = ClassId.topLevel(KotlinBuiltIns.getPrimitiveFqName(jvmPrimitiveType.getPrimitiveType()));
            Intrinsics.checkExpressionValueIsNotNull(classId18, "ClassId.topLevel(KotlinB…e(jvmType.primitiveType))");
            javaToKotlinClassMap.add(classId17, classId18);
        }
        for (ClassId classId19 : CompanionObjectMapping.INSTANCE.allClassesWithIntrinsicCompanions()) {
            ClassId classId20 = ClassId.topLevel(new FqName("kotlin.jvm.internal." + classId19.getShortClassName().asString() + "CompanionObject"));
            Intrinsics.checkExpressionValueIsNotNull(classId20, "ClassId.topLevel(FqName(…g() + \"CompanionObject\"))");
            ClassId createNestedClassId2 = classId19.createNestedClassId(SpecialNames.DEFAULT_NAME_FOR_COMPANION_OBJECT);
            Intrinsics.checkExpressionValueIsNotNull(createNestedClassId2, "classId.createNestedClas…AME_FOR_COMPANION_OBJECT)");
            javaToKotlinClassMap.add(classId20, createNestedClassId2);
        }
        for (int i = 0; i < 23; i++) {
            ClassId classId21 = ClassId.topLevel(new FqName("kotlin.jvm.functions.Function" + i));
            Intrinsics.checkExpressionValueIsNotNull(classId21, "ClassId.topLevel(FqName(…m.functions.Function$i\"))");
            ClassId functionClassId = KotlinBuiltIns.getFunctionClassId(i);
            Intrinsics.checkExpressionValueIsNotNull(functionClassId, "KotlinBuiltIns.getFunctionClassId(i)");
            javaToKotlinClassMap.add(classId21, functionClassId);
            javaToKotlinClassMap.addKotlinToJava(new FqName(NUMBERED_K_FUNCTION_PREFIX + i), K_FUNCTION_CLASS_ID);
        }
        for (int i2 = 0; i2 < 22; i2++) {
            FunctionClassDescriptor.Kind kind = FunctionClassDescriptor.Kind.KSuspendFunction;
            javaToKotlinClassMap.addKotlinToJava(new FqName((kind.getPackageFqName().toString() + "." + kind.getClassNamePrefix()) + i2), K_FUNCTION_CLASS_ID);
        }
        FqName safe = KotlinBuiltIns.FQ_NAMES.nothing.toSafe();
        Intrinsics.checkExpressionValueIsNotNull(safe, "FQ_NAMES.nothing.toSafe()");
        javaToKotlinClassMap.addKotlinToJava(safe, javaToKotlinClassMap.classId(Void.class));
    }

    public final FqName getFUNCTION_N_FQ_NAME() {
        return FUNCTION_N_FQ_NAME;
    }

    public final List<PlatformMutabilityMapping> getMutabilityMappings() {
        return mutabilityMappings;
    }

    private final void add(ClassId classId, ClassId classId2) {
        addJavaToKotlin(classId, classId2);
        FqName asSingleFqName = classId2.asSingleFqName();
        Intrinsics.checkExpressionValueIsNotNull(asSingleFqName, "kotlinClassId.asSingleFqName()");
        addKotlinToJava(asSingleFqName, classId);
    }

    private final void addJavaToKotlin(ClassId classId, ClassId classId2) {
        HashMap<FqNameUnsafe, ClassId> hashMap = javaToKotlin;
        FqNameUnsafe unsafe = classId.asSingleFqName().toUnsafe();
        Intrinsics.checkExpressionValueIsNotNull(unsafe, "javaClassId.asSingleFqName().toUnsafe()");
        hashMap.put(unsafe, classId2);
    }

    private final void addKotlinToJava(FqName fqName, ClassId classId) {
        HashMap<FqNameUnsafe, ClassId> hashMap = kotlinToJava;
        FqNameUnsafe unsafe = fqName.toUnsafe();
        Intrinsics.checkExpressionValueIsNotNull(unsafe, "kotlinFqNameUnsafe.toUnsafe()");
        hashMap.put(unsafe, classId);
    }

    private final void addTopLevel(Class<?> cls, FqName fqName) {
        ClassId classId = classId(cls);
        ClassId classId2 = ClassId.topLevel(fqName);
        Intrinsics.checkExpressionValueIsNotNull(classId2, "ClassId.topLevel(kotlinFqName)");
        add(classId, classId2);
    }

    private final void addMapping(PlatformMutabilityMapping platformMutabilityMapping) {
        ClassId component1 = platformMutabilityMapping.component1();
        ClassId component2 = platformMutabilityMapping.component2();
        ClassId component3 = platformMutabilityMapping.component3();
        add(component1, component2);
        FqName asSingleFqName = component3.asSingleFqName();
        Intrinsics.checkExpressionValueIsNotNull(asSingleFqName, "mutableClassId.asSingleFqName()");
        addKotlinToJava(asSingleFqName, component1);
        FqName asSingleFqName2 = component2.asSingleFqName();
        Intrinsics.checkExpressionValueIsNotNull(asSingleFqName2, "readOnlyClassId.asSingleFqName()");
        FqName asSingleFqName3 = component3.asSingleFqName();
        Intrinsics.checkExpressionValueIsNotNull(asSingleFqName3, "mutableClassId.asSingleFqName()");
        HashMap<FqNameUnsafe, FqName> hashMap = mutableToReadOnly;
        FqNameUnsafe unsafe = component3.asSingleFqName().toUnsafe();
        Intrinsics.checkExpressionValueIsNotNull(unsafe, "mutableClassId.asSingleFqName().toUnsafe()");
        hashMap.put(unsafe, asSingleFqName2);
        HashMap<FqNameUnsafe, FqName> hashMap2 = readOnlyToMutable;
        FqNameUnsafe unsafe2 = asSingleFqName2.toUnsafe();
        Intrinsics.checkExpressionValueIsNotNull(unsafe2, "readOnlyFqName.toUnsafe()");
        hashMap2.put(unsafe2, asSingleFqName3);
    }

    public final ClassId classId(Class<?> cls) {
        boolean z;
        if (!cls.isPrimitive() && !cls.isArray()) {
            z = true;
        } else {
            z = false;
        }
        if (_Assertions.ENABLED && !z) {
            throw new AssertionError("Invalid class: " + cls);
        }
        Class<?> declaringClass = cls.getDeclaringClass();
        if (declaringClass == null) {
            ClassId classId = ClassId.topLevel(new FqName(cls.getCanonicalName()));
            Intrinsics.checkExpressionValueIsNotNull(classId, "ClassId.topLevel(FqName(clazz.canonicalName))");
            return classId;
        }
        ClassId createNestedClassId = classId(declaringClass).createNestedClassId(Name.identifier(cls.getSimpleName()));
        Intrinsics.checkExpressionValueIsNotNull(createNestedClassId, "classId(outer).createNes…tifier(clazz.simpleName))");
        return createNestedClassId;
    }

    private final void addTopLevel(Class<?> cls, FqNameUnsafe fqNameUnsafe) {
        FqName safe = fqNameUnsafe.toSafe();
        Intrinsics.checkExpressionValueIsNotNull(safe, "kotlinFqName.toSafe()");
        addTopLevel(cls, safe);
    }

    private final ClassDescriptor convertToOppositeMutability(ClassDescriptor classDescriptor, Map<FqNameUnsafe, FqName> map, String str) {
        FqName fqName = map.get(DescriptorUtils.getFqName(classDescriptor));
        if (fqName != null) {
            ClassDescriptor builtInClassByFqName = DescriptorUtilsKt.getBuiltIns(classDescriptor).getBuiltInClassByFqName(fqName);
            Intrinsics.checkExpressionValueIsNotNull(builtInClassByFqName, "descriptor.builtIns.getB…Name(oppositeClassFqName)");
            return builtInClassByFqName;
        }
        throw new IllegalArgumentException("Given class " + classDescriptor + " is not a " + str + " collection");
    }

    private final boolean isKotlinFunctionWithBigArity(FqNameUnsafe fqNameUnsafe, String str) {
        boolean z;
        Integer intOrNull;
        String asString = fqNameUnsafe.asString();
        Intrinsics.checkExpressionValueIsNotNull(asString, "kotlinFqName.asString()");
        String substringAfter = StringsKt__StringsKt.substringAfter(asString, str, "");
        if (substringAfter.length() > 0) {
            z = true;
        } else {
            z = false;
        }
        if (z && !StringsKt__StringsKt.startsWith$default((CharSequence) substringAfter, (char) TransactionIdCreater.FILL_BYTE, false, 2, (Object) null) && (intOrNull = StringsKt__StringNumberConversionsKt.toIntOrNull(substringAfter)) != null && intOrNull.intValue() >= 23) {
            return true;
        }
        return false;
    }

    public final Collection<ClassDescriptor> mapPlatformClass(FqName fqName, KotlinBuiltIns kotlinBuiltIns) {
        ClassDescriptor mapJavaToKotlin$default = mapJavaToKotlin$default(this, fqName, kotlinBuiltIns, null, 4, null);
        if (mapJavaToKotlin$default != null) {
            FqName fqName2 = readOnlyToMutable.get(DescriptorUtilsKt.getFqNameUnsafe(mapJavaToKotlin$default));
            if (fqName2 != null) {
                Intrinsics.checkExpressionValueIsNotNull(fqName2, "readOnlyToMutable[kotlin…eturn setOf(kotlinAnalog)");
                ClassDescriptor builtInClassByFqName = kotlinBuiltIns.getBuiltInClassByFqName(fqName2);
                Intrinsics.checkExpressionValueIsNotNull(builtInClassByFqName, "builtIns.getBuiltInClass…otlinMutableAnalogFqName)");
                return CollectionsKt__CollectionsKt.listOf((Object[]) new ClassDescriptor[]{mapJavaToKotlin$default, builtInClassByFqName});
            }
            return SetsKt__SetsJVMKt.setOf(mapJavaToKotlin$default);
        }
        return SetsKt__SetsKt.emptySet();
    }

    public static /* synthetic */ ClassDescriptor mapJavaToKotlin$default(JavaToKotlinClassMap javaToKotlinClassMap, FqName fqName, KotlinBuiltIns kotlinBuiltIns, Integer num, int i, Object obj) {
        if ((i & 4) != 0) {
            num = null;
        }
        return javaToKotlinClassMap.mapJavaToKotlin(fqName, kotlinBuiltIns, num);
    }

    public final ClassDescriptor convertMutableToReadOnly(ClassDescriptor classDescriptor) {
        return convertToOppositeMutability(classDescriptor, mutableToReadOnly, "mutable");
    }

    public final ClassDescriptor convertReadOnlyToMutable(ClassDescriptor classDescriptor) {
        return convertToOppositeMutability(classDescriptor, readOnlyToMutable, "read-only");
    }

    public final boolean isMutable(ClassDescriptor classDescriptor) {
        return isMutable(DescriptorUtils.getFqName(classDescriptor));
    }

    public final boolean isReadOnly(ClassDescriptor classDescriptor) {
        return isReadOnly(DescriptorUtils.getFqName(classDescriptor));
    }

    public final ClassId mapJavaToKotlin(FqName fqName) {
        return javaToKotlin.get(fqName.toUnsafe());
    }

    public final boolean isMutable(FqNameUnsafe fqNameUnsafe) {
        HashMap<FqNameUnsafe, FqName> hashMap = mutableToReadOnly;
        if (hashMap != null) {
            return hashMap.containsKey(fqNameUnsafe);
        }
        throw new TypeCastException("null cannot be cast to non-null type kotlin.collections.Map<K, *>");
    }

    public final boolean isReadOnly(FqNameUnsafe fqNameUnsafe) {
        HashMap<FqNameUnsafe, FqName> hashMap = readOnlyToMutable;
        if (hashMap != null) {
            return hashMap.containsKey(fqNameUnsafe);
        }
        throw new TypeCastException("null cannot be cast to non-null type kotlin.collections.Map<K, *>");
    }

    public final boolean isMutable(KotlinType kotlinType) {
        ClassDescriptor classDescriptor = TypeUtils.getClassDescriptor(kotlinType);
        if (classDescriptor != null && isMutable(classDescriptor)) {
            return true;
        }
        return false;
    }

    public final boolean isReadOnly(KotlinType kotlinType) {
        ClassDescriptor classDescriptor = TypeUtils.getClassDescriptor(kotlinType);
        if (classDescriptor != null && isReadOnly(classDescriptor)) {
            return true;
        }
        return false;
    }

    public final ClassDescriptor mapJavaToKotlin(FqName fqName, KotlinBuiltIns kotlinBuiltIns, Integer num) {
        ClassId mapJavaToKotlin;
        if (num != null && Intrinsics.areEqual(fqName, FUNCTION_N_FQ_NAME)) {
            mapJavaToKotlin = KotlinBuiltIns.getFunctionClassId(num.intValue());
        } else {
            mapJavaToKotlin = mapJavaToKotlin(fqName);
        }
        if (mapJavaToKotlin != null) {
            return kotlinBuiltIns.getBuiltInClassByFqName(mapJavaToKotlin.asSingleFqName());
        }
        return null;
    }

    public final ClassId mapKotlinToJava(FqNameUnsafe fqNameUnsafe) {
        if (isKotlinFunctionWithBigArity(fqNameUnsafe, NUMBERED_FUNCTION_PREFIX)) {
            return FUNCTION_N_CLASS_ID;
        }
        if (isKotlinFunctionWithBigArity(fqNameUnsafe, NUMBERED_SUSPEND_FUNCTION_PREFIX)) {
            return FUNCTION_N_CLASS_ID;
        }
        if (isKotlinFunctionWithBigArity(fqNameUnsafe, NUMBERED_K_FUNCTION_PREFIX)) {
            return K_FUNCTION_CLASS_ID;
        }
        if (isKotlinFunctionWithBigArity(fqNameUnsafe, NUMBERED_K_SUSPEND_FUNCTION_PREFIX)) {
            return K_FUNCTION_CLASS_ID;
        }
        return kotlinToJava.get(fqNameUnsafe);
    }
}
