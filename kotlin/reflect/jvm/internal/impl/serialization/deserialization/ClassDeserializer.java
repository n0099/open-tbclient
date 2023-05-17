package kotlin.reflect.jvm.internal.impl.serialization.deserialization;

import java.util.Iterator;
import java.util.Set;
import kotlin.collections.SetsKt__SetsJVMKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.builtins.KotlinBuiltIns;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.PackageFragmentDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.PackageFragmentProvider;
import kotlin.reflect.jvm.internal.impl.descriptors.SourceElement;
import kotlin.reflect.jvm.internal.impl.descriptors.deserialization.ClassDescriptorFactory;
import kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf;
import kotlin.reflect.jvm.internal.impl.metadata.deserialization.BinaryVersion;
import kotlin.reflect.jvm.internal.impl.metadata.deserialization.NameResolver;
import kotlin.reflect.jvm.internal.impl.metadata.deserialization.TypeTable;
import kotlin.reflect.jvm.internal.impl.metadata.deserialization.VersionRequirementTable;
import kotlin.reflect.jvm.internal.impl.name.ClassId;
import kotlin.reflect.jvm.internal.impl.name.FqName;
import kotlin.reflect.jvm.internal.impl.name.Name;
import kotlin.reflect.jvm.internal.impl.serialization.deserialization.ClassDeserializer;
import kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.DeserializedClassDescriptor;
/* loaded from: classes10.dex */
public final class ClassDeserializer {
    public final Function1<ClassKey, ClassDescriptor> classes;
    public final DeserializationComponents components;
    public static final Companion Companion = new Companion(null);
    public static final Set<ClassId> BLACK_LIST = SetsKt__SetsJVMKt.setOf(ClassId.topLevel(KotlinBuiltIns.FQ_NAMES.cloneable.toSafe()));

    /* loaded from: classes10.dex */
    public static final class ClassKey {
        public final ClassData classData;
        public final ClassId classId;

        public ClassKey(ClassId classId, ClassData classData) {
            this.classId = classId;
            this.classData = classData;
        }

        public boolean equals(Object obj) {
            if ((obj instanceof ClassKey) && Intrinsics.areEqual(this.classId, ((ClassKey) obj).classId)) {
                return true;
            }
            return false;
        }

        public final ClassData getClassData() {
            return this.classData;
        }

        public final ClassId getClassId() {
            return this.classId;
        }

        public int hashCode() {
            return this.classId.hashCode();
        }
    }

    /* loaded from: classes10.dex */
    public static final class Companion {
        public Companion() {
        }

        public final Set<ClassId> getBLACK_LIST() {
            return ClassDeserializer.BLACK_LIST;
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public ClassDeserializer(DeserializationComponents deserializationComponents) {
        this.components = deserializationComponents;
        this.classes = deserializationComponents.getStorageManager().createMemoizedFunctionWithNullableValues(new Function1<ClassKey, ClassDescriptor>() { // from class: kotlin.reflect.jvm.internal.impl.serialization.deserialization.ClassDeserializer$classes$1
            {
                super(1);
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // kotlin.jvm.functions.Function1
            public final ClassDescriptor invoke(ClassDeserializer.ClassKey classKey) {
                ClassDescriptor createClass;
                createClass = ClassDeserializer.this.createClass(classKey);
                return createClass;
            }
        });
    }

    public final ClassDescriptor deserializeClass(ClassId classId, ClassData classData) {
        return this.classes.invoke(new ClassKey(classId, classData));
    }

    /* JADX WARN: Removed duplicated region for block: B:104:0x00b9 A[EDGE_INSN: B:104:0x00b9->B:96:0x00b9 ?: BREAK  , SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final ClassDescriptor createClass(ClassKey classKey) {
        Object obj;
        DeserializationContext createContext;
        boolean z;
        ClassId classId = classKey.getClassId();
        for (ClassDescriptorFactory classDescriptorFactory : this.components.getFictitiousClassDescriptorFactories()) {
            ClassDescriptor createClass = classDescriptorFactory.createClass(classId);
            if (createClass != null) {
                return createClass;
            }
        }
        if (BLACK_LIST.contains(classId)) {
            return null;
        }
        ClassData classData = classKey.getClassData();
        if (classData == null) {
            classData = this.components.getClassDataFinder().findClassData(classId);
        }
        if (classData != null) {
            NameResolver component1 = classData.component1();
            ProtoBuf.Class component2 = classData.component2();
            BinaryVersion component3 = classData.component3();
            SourceElement component4 = classData.component4();
            ClassId outerClassId = classId.getOuterClassId();
            if (outerClassId != null) {
                ClassDescriptor deserializeClass$default = deserializeClass$default(this, outerClassId, null, 2, null);
                if (!(deserializeClass$default instanceof DeserializedClassDescriptor)) {
                    deserializeClass$default = null;
                }
                DeserializedClassDescriptor deserializedClassDescriptor = (DeserializedClassDescriptor) deserializeClass$default;
                if (deserializedClassDescriptor == null) {
                    return null;
                }
                Name shortClassName = classId.getShortClassName();
                Intrinsics.checkExpressionValueIsNotNull(shortClassName, "classId.shortClassName");
                if (!deserializedClassDescriptor.hasNestedClass$deserialization(shortClassName)) {
                    return null;
                }
                createContext = deserializedClassDescriptor.getC();
            } else {
                PackageFragmentProvider packageFragmentProvider = this.components.getPackageFragmentProvider();
                FqName packageFqName = classId.getPackageFqName();
                Intrinsics.checkExpressionValueIsNotNull(packageFqName, "classId.packageFqName");
                Iterator<T> it = packageFragmentProvider.getPackageFragments(packageFqName).iterator();
                while (true) {
                    if (it.hasNext()) {
                        obj = it.next();
                        PackageFragmentDescriptor packageFragmentDescriptor = (PackageFragmentDescriptor) obj;
                        if (packageFragmentDescriptor instanceof DeserializedPackageFragment) {
                            Name shortClassName2 = classId.getShortClassName();
                            Intrinsics.checkExpressionValueIsNotNull(shortClassName2, "classId.shortClassName");
                            if (!((DeserializedPackageFragment) packageFragmentDescriptor).hasTopLevelClass(shortClassName2)) {
                                z = false;
                                continue;
                                if (z) {
                                    break;
                                }
                            }
                        }
                        z = true;
                        continue;
                        if (z) {
                        }
                    } else {
                        obj = null;
                        break;
                    }
                }
                PackageFragmentDescriptor packageFragmentDescriptor2 = (PackageFragmentDescriptor) obj;
                if (packageFragmentDescriptor2 != null) {
                    DeserializationComponents deserializationComponents = this.components;
                    ProtoBuf.TypeTable typeTable = component2.getTypeTable();
                    Intrinsics.checkExpressionValueIsNotNull(typeTable, "classProto.typeTable");
                    TypeTable typeTable2 = new TypeTable(typeTable);
                    VersionRequirementTable.Companion companion = VersionRequirementTable.Companion;
                    ProtoBuf.VersionRequirementTable versionRequirementTable = component2.getVersionRequirementTable();
                    Intrinsics.checkExpressionValueIsNotNull(versionRequirementTable, "classProto.versionRequirementTable");
                    createContext = deserializationComponents.createContext(packageFragmentDescriptor2, component1, typeTable2, companion.create(versionRequirementTable), component3, null);
                }
            }
            return new DeserializedClassDescriptor(createContext, component2, component1, component3, component4);
        }
        return null;
    }

    public static /* synthetic */ ClassDescriptor deserializeClass$default(ClassDeserializer classDeserializer, ClassId classId, ClassData classData, int i, Object obj) {
        if ((i & 2) != 0) {
            classData = null;
        }
        return classDeserializer.deserializeClass(classId, classData);
    }
}
