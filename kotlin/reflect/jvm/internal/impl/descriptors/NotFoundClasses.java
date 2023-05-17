package kotlin.reflect.jvm.internal.impl.descriptors;

import com.baidu.tbadk.core.data.SmallTailInfo;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.CollectionsKt__IterablesKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.collections.IntIterator;
import kotlin.collections.SetsKt__SetsJVMKt;
import kotlin.collections.SetsKt__SetsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.IntRange;
import kotlin.ranges.RangesKt___RangesKt;
import kotlin.reflect.jvm.internal.impl.descriptors.NotFoundClasses;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.Annotations;
import kotlin.reflect.jvm.internal.impl.descriptors.impl.ClassDescriptorBase;
import kotlin.reflect.jvm.internal.impl.descriptors.impl.EmptyPackageFragmentDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.impl.TypeParameterDescriptorImpl;
import kotlin.reflect.jvm.internal.impl.name.ClassId;
import kotlin.reflect.jvm.internal.impl.name.FqName;
import kotlin.reflect.jvm.internal.impl.name.Name;
import kotlin.reflect.jvm.internal.impl.resolve.descriptorUtil.DescriptorUtilsKt;
import kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScope;
import kotlin.reflect.jvm.internal.impl.storage.MemoizedFunctionToNotNull;
import kotlin.reflect.jvm.internal.impl.storage.StorageManager;
import kotlin.reflect.jvm.internal.impl.types.ClassTypeConstructorImpl;
import kotlin.reflect.jvm.internal.impl.types.Variance;
import kotlin.reflect.jvm.internal.impl.types.checker.KotlinTypeRefiner;
/* loaded from: classes10.dex */
public final class NotFoundClasses {
    public final MemoizedFunctionToNotNull<ClassRequest, ClassDescriptor> classes;
    public final ModuleDescriptor module;
    public final MemoizedFunctionToNotNull<FqName, PackageFragmentDescriptor> packageFragments;
    public final StorageManager storageManager;

    /* loaded from: classes10.dex */
    public static final class ClassRequest {
        public final ClassId classId;
        public final List<Integer> typeParametersCount;

        public final ClassId component1() {
            return this.classId;
        }

        public final List<Integer> component2() {
            return this.typeParametersCount;
        }

        public boolean equals(Object obj) {
            if (this != obj) {
                if (obj instanceof ClassRequest) {
                    ClassRequest classRequest = (ClassRequest) obj;
                    return Intrinsics.areEqual(this.classId, classRequest.classId) && Intrinsics.areEqual(this.typeParametersCount, classRequest.typeParametersCount);
                }
                return false;
            }
            return true;
        }

        public int hashCode() {
            ClassId classId = this.classId;
            int hashCode = (classId != null ? classId.hashCode() : 0) * 31;
            List<Integer> list = this.typeParametersCount;
            return hashCode + (list != null ? list.hashCode() : 0);
        }

        public String toString() {
            return "ClassRequest(classId=" + this.classId + ", typeParametersCount=" + this.typeParametersCount + SmallTailInfo.EMOTION_SUFFIX;
        }

        public ClassRequest(ClassId classId, List<Integer> list) {
            this.classId = classId;
            this.typeParametersCount = list;
        }
    }

    /* loaded from: classes10.dex */
    public static final class MockClassDescriptor extends ClassDescriptorBase {
        public final boolean isInner;
        public final ClassTypeConstructorImpl typeConstructor;
        public final List<TypeParameterDescriptor> typeParameters;

        @Override // kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor
        /* renamed from: getCompanionObjectDescriptor */
        public ClassDescriptor mo2037getCompanionObjectDescriptor() {
            return null;
        }

        @Override // kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor
        /* renamed from: getUnsubstitutedPrimaryConstructor */
        public ClassConstructorDescriptor mo2038getUnsubstitutedPrimaryConstructor() {
            return null;
        }

        @Override // kotlin.reflect.jvm.internal.impl.descriptors.MemberDescriptor
        public boolean isActual() {
            return false;
        }

        @Override // kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor
        public boolean isCompanionObject() {
            return false;
        }

        @Override // kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor
        public boolean isData() {
            return false;
        }

        @Override // kotlin.reflect.jvm.internal.impl.descriptors.MemberDescriptor
        public boolean isExpect() {
            return false;
        }

        @Override // kotlin.reflect.jvm.internal.impl.descriptors.impl.ClassDescriptorBase, kotlin.reflect.jvm.internal.impl.descriptors.MemberDescriptor
        public boolean isExternal() {
            return false;
        }

        @Override // kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor
        public boolean isInline() {
            return false;
        }

        /* JADX DEBUG: TODO: convert one arg to string using `String.valueOf()`, args: [('T' char), (r5v1 int)] */
        public MockClassDescriptor(StorageManager storageManager, DeclarationDescriptor declarationDescriptor, Name name, boolean z, int i) {
            super(storageManager, declarationDescriptor, name, SourceElement.NO_SOURCE, false);
            this.isInner = z;
            IntRange until = RangesKt___RangesKt.until(0, i);
            ArrayList arrayList = new ArrayList(CollectionsKt__IterablesKt.collectionSizeOrDefault(until, 10));
            Iterator<Integer> it = until.iterator();
            while (it.hasNext()) {
                int nextInt = ((IntIterator) it).nextInt();
                Annotations empty = Annotations.Companion.getEMPTY();
                Variance variance = Variance.INVARIANT;
                StringBuilder sb = new StringBuilder();
                sb.append('T');
                sb.append(nextInt);
                arrayList.add(TypeParameterDescriptorImpl.createWithDefaultBound(this, empty, false, variance, Name.identifier(sb.toString()), nextInt, storageManager));
            }
            this.typeParameters = arrayList;
            this.typeConstructor = new ClassTypeConstructorImpl(this, arrayList, SetsKt__SetsJVMKt.setOf(DescriptorUtilsKt.getModule(this).getBuiltIns().getAnyType()), storageManager);
        }

        @Override // kotlin.reflect.jvm.internal.impl.descriptors.annotations.Annotated
        public Annotations getAnnotations() {
            return Annotations.Companion.getEMPTY();
        }

        @Override // kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor
        public Collection<ClassConstructorDescriptor> getConstructors() {
            return SetsKt__SetsKt.emptySet();
        }

        @Override // kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor, kotlin.reflect.jvm.internal.impl.descriptors.ClassifierDescriptorWithTypeParameters
        public List<TypeParameterDescriptor> getDeclaredTypeParameters() {
            return this.typeParameters;
        }

        @Override // kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor
        public ClassKind getKind() {
            return ClassKind.CLASS;
        }

        @Override // kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor, kotlin.reflect.jvm.internal.impl.descriptors.MemberDescriptor
        public Modality getModality() {
            return Modality.FINAL;
        }

        @Override // kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor
        public Collection<ClassDescriptor> getSealedSubclasses() {
            return CollectionsKt__CollectionsKt.emptyList();
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor
        public MemberScope.Empty getStaticScope() {
            return MemberScope.Empty.INSTANCE;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // kotlin.reflect.jvm.internal.impl.descriptors.ClassifierDescriptor
        public ClassTypeConstructorImpl getTypeConstructor() {
            return this.typeConstructor;
        }

        @Override // kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor, kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptorWithVisibility, kotlin.reflect.jvm.internal.impl.descriptors.MemberDescriptor
        public Visibility getVisibility() {
            Visibility visibility = Visibilities.PUBLIC;
            Intrinsics.checkExpressionValueIsNotNull(visibility, "Visibilities.PUBLIC");
            return visibility;
        }

        @Override // kotlin.reflect.jvm.internal.impl.descriptors.ClassifierDescriptorWithTypeParameters
        public boolean isInner() {
            return this.isInner;
        }

        public String toString() {
            return "class " + getName() + " (not found)";
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // kotlin.reflect.jvm.internal.impl.descriptors.impl.ModuleAwareClassDescriptor
        public MemberScope.Empty getUnsubstitutedMemberScope(KotlinTypeRefiner kotlinTypeRefiner) {
            return MemberScope.Empty.INSTANCE;
        }
    }

    public NotFoundClasses(StorageManager storageManager, ModuleDescriptor moduleDescriptor) {
        this.storageManager = storageManager;
        this.module = moduleDescriptor;
        this.packageFragments = storageManager.createMemoizedFunction(new Function1<FqName, EmptyPackageFragmentDescriptor>() { // from class: kotlin.reflect.jvm.internal.impl.descriptors.NotFoundClasses$packageFragments$1
            {
                super(1);
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // kotlin.jvm.functions.Function1
            public final EmptyPackageFragmentDescriptor invoke(FqName fqName) {
                ModuleDescriptor moduleDescriptor2;
                moduleDescriptor2 = NotFoundClasses.this.module;
                return new EmptyPackageFragmentDescriptor(moduleDescriptor2, fqName);
            }
        });
        this.classes = this.storageManager.createMemoizedFunction(new Function1<ClassRequest, MockClassDescriptor>() { // from class: kotlin.reflect.jvm.internal.impl.descriptors.NotFoundClasses$classes$1
            {
                super(1);
            }

            /* JADX DEBUG: Method merged with bridge method */
            /* JADX WARN: Code restructure failed: missing block: B:7:0x0024, code lost:
                if (r1 != null) goto L7;
             */
            @Override // kotlin.jvm.functions.Function1
            /*
                Code decompiled incorrectly, please refer to instructions dump.
            */
            public final NotFoundClasses.MockClassDescriptor invoke(NotFoundClasses.ClassRequest classRequest) {
                MemoizedFunctionToNotNull memoizedFunctionToNotNull;
                DeclarationDescriptor declarationDescriptor;
                StorageManager storageManager2;
                int i;
                ClassId component1 = classRequest.component1();
                List<Integer> component2 = classRequest.component2();
                if (!component1.isLocal()) {
                    ClassId outerClassId = component1.getOuterClassId();
                    if (outerClassId != null) {
                        NotFoundClasses notFoundClasses = NotFoundClasses.this;
                        Intrinsics.checkExpressionValueIsNotNull(outerClassId, "outerClassId");
                        declarationDescriptor = notFoundClasses.getClass(outerClassId, CollectionsKt___CollectionsKt.drop(component2, 1));
                    }
                    memoizedFunctionToNotNull = NotFoundClasses.this.packageFragments;
                    FqName packageFqName = component1.getPackageFqName();
                    Intrinsics.checkExpressionValueIsNotNull(packageFqName, "classId.packageFqName");
                    declarationDescriptor = (ClassOrPackageFragmentDescriptor) memoizedFunctionToNotNull.invoke(packageFqName);
                    DeclarationDescriptor declarationDescriptor2 = declarationDescriptor;
                    boolean isNestedClass = component1.isNestedClass();
                    storageManager2 = NotFoundClasses.this.storageManager;
                    Name shortClassName = component1.getShortClassName();
                    Intrinsics.checkExpressionValueIsNotNull(shortClassName, "classId.shortClassName");
                    Integer num = (Integer) CollectionsKt___CollectionsKt.firstOrNull((List<? extends Object>) component2);
                    if (num != null) {
                        i = num.intValue();
                    } else {
                        i = 0;
                    }
                    return new NotFoundClasses.MockClassDescriptor(storageManager2, declarationDescriptor2, shortClassName, isNestedClass, i);
                }
                throw new UnsupportedOperationException("Unresolved local class: " + component1);
            }
        });
    }

    public final ClassDescriptor getClass(ClassId classId, List<Integer> list) {
        return this.classes.invoke(new ClassRequest(classId, list));
    }
}
