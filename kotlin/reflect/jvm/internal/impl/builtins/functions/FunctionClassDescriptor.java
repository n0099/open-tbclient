package kotlin.reflect.jvm.internal.impl.builtins.functions;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__CollectionsJVMKt;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.CollectionsKt__IterablesKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.collections.IntIterator;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.IntRange;
import kotlin.reflect.jvm.internal.impl.builtins.KotlinBuiltIns;
import kotlin.reflect.jvm.internal.impl.builtins.ReflectionTypesKt;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassConstructorDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassKind;
import kotlin.reflect.jvm.internal.impl.descriptors.FindClassInModuleKt;
import kotlin.reflect.jvm.internal.impl.descriptors.Modality;
import kotlin.reflect.jvm.internal.impl.descriptors.ModuleDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.PackageFragmentDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.SourceElement;
import kotlin.reflect.jvm.internal.impl.descriptors.SupertypeLoopChecker;
import kotlin.reflect.jvm.internal.impl.descriptors.TypeParameterDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.Visibilities;
import kotlin.reflect.jvm.internal.impl.descriptors.Visibility;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.Annotations;
import kotlin.reflect.jvm.internal.impl.descriptors.impl.AbstractClassDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.impl.TypeParameterDescriptorImpl;
import kotlin.reflect.jvm.internal.impl.name.ClassId;
import kotlin.reflect.jvm.internal.impl.name.FqName;
import kotlin.reflect.jvm.internal.impl.name.Name;
import kotlin.reflect.jvm.internal.impl.resolve.DescriptorUtils;
import kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScope;
import kotlin.reflect.jvm.internal.impl.storage.StorageManager;
import kotlin.reflect.jvm.internal.impl.types.AbstractClassTypeConstructor;
import kotlin.reflect.jvm.internal.impl.types.KotlinType;
import kotlin.reflect.jvm.internal.impl.types.KotlinTypeFactory;
import kotlin.reflect.jvm.internal.impl.types.TypeConstructor;
import kotlin.reflect.jvm.internal.impl.types.TypeProjectionImpl;
import kotlin.reflect.jvm.internal.impl.types.Variance;
import kotlin.reflect.jvm.internal.impl.types.checker.KotlinTypeRefiner;
import kotlin.text.StringsKt__StringsJVMKt;
/* loaded from: classes10.dex */
public final class FunctionClassDescriptor extends AbstractClassDescriptor {
    public static final Companion Companion = new Companion(null);
    public static final ClassId functionClassId = new ClassId(KotlinBuiltIns.BUILT_INS_PACKAGE_FQ_NAME, Name.identifier("Function"));
    public static final ClassId kFunctionClassId = new ClassId(ReflectionTypesKt.getKOTLIN_REFLECT_FQ_NAME(), Name.identifier(ReflectionTypesKt.K_FUNCTION_PREFIX));
    public final int arity;
    public final PackageFragmentDescriptor containingDeclaration;
    public final Kind functionKind;
    public final FunctionClassScope memberScope;
    public final List<TypeParameterDescriptor> parameters;
    public final StorageManager storageManager;
    public final FunctionTypeConstructor typeConstructor;

    /* JADX DEBUG: Possible override for method kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor.getCompanionObjectDescriptor()Lkotlin/reflect/jvm/internal/impl/descriptors/ClassDescriptor; */
    public Void getCompanionObjectDescriptor() {
        return null;
    }

    /* JADX DEBUG: Possible override for method kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor.getUnsubstitutedPrimaryConstructor()Lkotlin/reflect/jvm/internal/impl/descriptors/ClassConstructorDescriptor; */
    public Void getUnsubstitutedPrimaryConstructor() {
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

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.MemberDescriptor
    public boolean isExternal() {
        return false;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor
    public boolean isInline() {
        return false;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.ClassifierDescriptorWithTypeParameters
    public boolean isInner() {
        return false;
    }

    /* JADX WARN: Enum visitor error
    jadx.core.utils.exceptions.JadxRuntimeException: Init of enum Function uses external variables
    	at jadx.core.dex.visitors.EnumVisitor.createEnumFieldByConstructor(EnumVisitor.java:444)
    	at jadx.core.dex.visitors.EnumVisitor.processEnumFieldByRegister(EnumVisitor.java:391)
    	at jadx.core.dex.visitors.EnumVisitor.extractEnumFieldsFromFilledArray(EnumVisitor.java:320)
    	at jadx.core.dex.visitors.EnumVisitor.extractEnumFieldsFromInsn(EnumVisitor.java:258)
    	at jadx.core.dex.visitors.EnumVisitor.convertToEnum(EnumVisitor.java:151)
    	at jadx.core.dex.visitors.EnumVisitor.visit(EnumVisitor.java:100)
     */
    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* loaded from: classes10.dex */
    public static final class Kind {
        public static final /* synthetic */ Kind[] $VALUES;
        public static final Companion Companion;
        public static final Kind Function;
        public static final Kind KFunction;
        public static final Kind KSuspendFunction;
        public static final Kind SuspendFunction;
        public final String classNamePrefix;
        public final FqName packageFqName;

        public static Kind valueOf(String str) {
            return (Kind) Enum.valueOf(Kind.class, str);
        }

        public static Kind[] values() {
            return (Kind[]) $VALUES.clone();
        }

        /* loaded from: classes10.dex */
        public static final class Companion {
            public Companion() {
            }

            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            public final Kind byClassNamePrefix(FqName fqName, String str) {
                Kind[] values;
                boolean z;
                for (Kind kind : Kind.values()) {
                    if (Intrinsics.areEqual(kind.getPackageFqName(), fqName) && StringsKt__StringsJVMKt.startsWith$default(str, kind.getClassNamePrefix(), false, 2, null)) {
                        z = true;
                    } else {
                        z = false;
                    }
                    if (z) {
                        return kind;
                    }
                }
                return null;
            }
        }

        static {
            FqName BUILT_INS_PACKAGE_FQ_NAME = KotlinBuiltIns.BUILT_INS_PACKAGE_FQ_NAME;
            Intrinsics.checkExpressionValueIsNotNull(BUILT_INS_PACKAGE_FQ_NAME, "BUILT_INS_PACKAGE_FQ_NAME");
            Kind kind = new Kind("Function", 0, BUILT_INS_PACKAGE_FQ_NAME, "Function");
            Function = kind;
            FqName COROUTINES_PACKAGE_FQ_NAME_RELEASE = DescriptorUtils.COROUTINES_PACKAGE_FQ_NAME_RELEASE;
            Intrinsics.checkExpressionValueIsNotNull(COROUTINES_PACKAGE_FQ_NAME_RELEASE, "COROUTINES_PACKAGE_FQ_NAME_RELEASE");
            Kind kind2 = new Kind("SuspendFunction", 1, COROUTINES_PACKAGE_FQ_NAME_RELEASE, "SuspendFunction");
            SuspendFunction = kind2;
            Kind kind3 = new Kind(ReflectionTypesKt.K_FUNCTION_PREFIX, 2, ReflectionTypesKt.getKOTLIN_REFLECT_FQ_NAME(), ReflectionTypesKt.K_FUNCTION_PREFIX);
            KFunction = kind3;
            Kind kind4 = new Kind(ReflectionTypesKt.K_SUSPEND_FUNCTION_PREFIX, 3, ReflectionTypesKt.getKOTLIN_REFLECT_FQ_NAME(), ReflectionTypesKt.K_SUSPEND_FUNCTION_PREFIX);
            KSuspendFunction = kind4;
            $VALUES = new Kind[]{kind, kind2, kind3, kind4};
            Companion = new Companion(null);
        }

        public Kind(String str, int i, FqName fqName, String str2) {
            this.packageFqName = fqName;
            this.classNamePrefix = str2;
        }

        public final String getClassNamePrefix() {
            return this.classNamePrefix;
        }

        public final FqName getPackageFqName() {
            return this.packageFqName;
        }

        public final Name numberedClassName(int i) {
            Name identifier = Name.identifier(this.classNamePrefix + i);
            Intrinsics.checkExpressionValueIsNotNull(identifier, "Name.identifier(\"$classNamePrefix$arity\")");
            return identifier;
        }
    }

    /* loaded from: classes10.dex */
    public static final class Companion {
        public Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* loaded from: classes10.dex */
    public final class FunctionTypeConstructor extends AbstractClassTypeConstructor {

        /* loaded from: classes10.dex */
        public final /* synthetic */ class WhenMappings {
            public static final /* synthetic */ int[] $EnumSwitchMapping$0;

            static {
                int[] iArr = new int[Kind.values().length];
                $EnumSwitchMapping$0 = iArr;
                iArr[Kind.Function.ordinal()] = 1;
                $EnumSwitchMapping$0[Kind.KFunction.ordinal()] = 2;
                $EnumSwitchMapping$0[Kind.SuspendFunction.ordinal()] = 3;
                $EnumSwitchMapping$0[Kind.KSuspendFunction.ordinal()] = 4;
            }
        }

        @Override // kotlin.reflect.jvm.internal.impl.types.TypeConstructor
        public boolean isDenotable() {
            return true;
        }

        /* JADX DEBUG: Incorrect args count in method signature: ()V */
        public FunctionTypeConstructor() {
            super(FunctionClassDescriptor.this.storageManager);
        }

        @Override // kotlin.reflect.jvm.internal.impl.types.AbstractTypeConstructor
        public Collection<KotlinType> computeSupertypes() {
            List<ClassId> listOf;
            int i = WhenMappings.$EnumSwitchMapping$0[FunctionClassDescriptor.this.getFunctionKind().ordinal()];
            if (i != 1) {
                if (i != 2) {
                    if (i != 3) {
                        if (i == 4) {
                            listOf = CollectionsKt__CollectionsKt.listOf((Object[]) new ClassId[]{FunctionClassDescriptor.kFunctionClassId, new ClassId(DescriptorUtils.COROUTINES_PACKAGE_FQ_NAME_RELEASE, Kind.SuspendFunction.numberedClassName(FunctionClassDescriptor.this.getArity()))});
                        } else {
                            throw new NoWhenBranchMatchedException();
                        }
                    } else {
                        listOf = CollectionsKt__CollectionsJVMKt.listOf(FunctionClassDescriptor.functionClassId);
                    }
                } else {
                    listOf = CollectionsKt__CollectionsKt.listOf((Object[]) new ClassId[]{FunctionClassDescriptor.kFunctionClassId, new ClassId(KotlinBuiltIns.BUILT_INS_PACKAGE_FQ_NAME, Kind.Function.numberedClassName(FunctionClassDescriptor.this.getArity()))});
                }
            } else {
                listOf = CollectionsKt__CollectionsJVMKt.listOf(FunctionClassDescriptor.functionClassId);
            }
            ModuleDescriptor containingDeclaration = FunctionClassDescriptor.this.containingDeclaration.getContainingDeclaration();
            ArrayList arrayList = new ArrayList(CollectionsKt__IterablesKt.collectionSizeOrDefault(listOf, 10));
            for (ClassId classId : listOf) {
                ClassDescriptor findClassAcrossModuleDependencies = FindClassInModuleKt.findClassAcrossModuleDependencies(containingDeclaration, classId);
                if (findClassAcrossModuleDependencies != null) {
                    List<TypeParameterDescriptor> parameters = getParameters();
                    TypeConstructor typeConstructor = findClassAcrossModuleDependencies.getTypeConstructor();
                    Intrinsics.checkExpressionValueIsNotNull(typeConstructor, "descriptor.typeConstructor");
                    List<TypeParameterDescriptor> takeLast = CollectionsKt___CollectionsKt.takeLast(parameters, typeConstructor.getParameters().size());
                    ArrayList arrayList2 = new ArrayList(CollectionsKt__IterablesKt.collectionSizeOrDefault(takeLast, 10));
                    for (TypeParameterDescriptor typeParameterDescriptor : takeLast) {
                        arrayList2.add(new TypeProjectionImpl(typeParameterDescriptor.getDefaultType()));
                    }
                    arrayList.add(KotlinTypeFactory.simpleNotNullType(Annotations.Companion.getEMPTY(), findClassAcrossModuleDependencies, arrayList2));
                } else {
                    throw new IllegalStateException(("Built-in class " + classId + " not found").toString());
                }
            }
            return CollectionsKt___CollectionsKt.toList(arrayList);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // kotlin.reflect.jvm.internal.impl.types.AbstractClassTypeConstructor, kotlin.reflect.jvm.internal.impl.types.AbstractTypeConstructor, kotlin.reflect.jvm.internal.impl.types.TypeConstructor
        /* renamed from: getDeclarationDescriptor */
        public FunctionClassDescriptor mo2106getDeclarationDescriptor() {
            return FunctionClassDescriptor.this;
        }

        @Override // kotlin.reflect.jvm.internal.impl.types.TypeConstructor
        public List<TypeParameterDescriptor> getParameters() {
            return FunctionClassDescriptor.this.parameters;
        }

        @Override // kotlin.reflect.jvm.internal.impl.types.AbstractTypeConstructor
        public SupertypeLoopChecker getSupertypeLoopChecker() {
            return SupertypeLoopChecker.EMPTY.INSTANCE;
        }

        public String toString() {
            return mo2106getDeclarationDescriptor().toString();
        }
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.annotations.Annotated
    public Annotations getAnnotations() {
        return Annotations.Companion.getEMPTY();
    }

    public final int getArity() {
        return this.arity;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor
    /* renamed from: getCompanionObjectDescriptor  reason: collision with other method in class */
    public /* bridge */ /* synthetic */ ClassDescriptor mo2099getCompanionObjectDescriptor() {
        return (ClassDescriptor) getCompanionObjectDescriptor();
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor, kotlin.reflect.jvm.internal.impl.descriptors.ClassifierDescriptorWithTypeParameters
    public List<TypeParameterDescriptor> getDeclaredTypeParameters() {
        return this.parameters;
    }

    public final Kind getFunctionKind() {
        return this.functionKind;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor
    public ClassKind getKind() {
        return ClassKind.INTERFACE;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor, kotlin.reflect.jvm.internal.impl.descriptors.MemberDescriptor
    public Modality getModality() {
        return Modality.ABSTRACT;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptorWithSource
    public SourceElement getSource() {
        SourceElement sourceElement = SourceElement.NO_SOURCE;
        Intrinsics.checkExpressionValueIsNotNull(sourceElement, "SourceElement.NO_SOURCE");
        return sourceElement;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor
    public MemberScope.Empty getStaticScope() {
        return MemberScope.Empty.INSTANCE;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.ClassifierDescriptor
    public TypeConstructor getTypeConstructor() {
        return this.typeConstructor;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor
    /* renamed from: getUnsubstitutedPrimaryConstructor  reason: collision with other method in class */
    public /* bridge */ /* synthetic */ ClassConstructorDescriptor mo2100getUnsubstitutedPrimaryConstructor() {
        return (ClassConstructorDescriptor) getUnsubstitutedPrimaryConstructor();
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor, kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptorWithVisibility, kotlin.reflect.jvm.internal.impl.descriptors.MemberDescriptor
    public Visibility getVisibility() {
        Visibility visibility = Visibilities.PUBLIC;
        Intrinsics.checkExpressionValueIsNotNull(visibility, "Visibilities.PUBLIC");
        return visibility;
    }

    public String toString() {
        String asString = getName().asString();
        Intrinsics.checkExpressionValueIsNotNull(asString, "name.asString()");
        return asString;
    }

    /* JADX DEBUG: TODO: convert one arg to string using `String.valueOf()`, args: [('P' char), (r0v7 int)] */
    public FunctionClassDescriptor(StorageManager storageManager, PackageFragmentDescriptor packageFragmentDescriptor, Kind kind, int i) {
        super(storageManager, kind.numberedClassName(i));
        this.storageManager = storageManager;
        this.containingDeclaration = packageFragmentDescriptor;
        this.functionKind = kind;
        this.arity = i;
        this.typeConstructor = new FunctionTypeConstructor();
        this.memberScope = new FunctionClassScope(this.storageManager, this);
        final ArrayList arrayList = new ArrayList();
        Function2<Variance, String, Unit> function2 = new Function2<Variance, String, Unit>() { // from class: kotlin.reflect.jvm.internal.impl.builtins.functions.FunctionClassDescriptor.1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(2);
            }

            /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, java.lang.Object] */
            /* JADX DEBUG: Return type fixed from 'java.lang.Object' to match base method */
            @Override // kotlin.jvm.functions.Function2
            public /* bridge */ /* synthetic */ Unit invoke(Variance variance, String str) {
                invoke2(variance, str);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke  reason: avoid collision after fix types in other method */
            public final void invoke2(Variance variance, String str) {
                arrayList.add(TypeParameterDescriptorImpl.createWithDefaultBound(FunctionClassDescriptor.this, Annotations.Companion.getEMPTY(), false, variance, Name.identifier(str), arrayList.size(), FunctionClassDescriptor.this.storageManager));
            }
        };
        IntRange intRange = new IntRange(1, this.arity);
        ArrayList arrayList2 = new ArrayList(CollectionsKt__IterablesKt.collectionSizeOrDefault(intRange, 10));
        Iterator<Integer> it = intRange.iterator();
        while (it.hasNext()) {
            int nextInt = ((IntIterator) it).nextInt();
            Variance variance = Variance.IN_VARIANCE;
            StringBuilder sb = new StringBuilder();
            sb.append('P');
            sb.append(nextInt);
            function2.invoke2(variance, sb.toString());
            arrayList2.add(Unit.INSTANCE);
        }
        function2.invoke2(Variance.OUT_VARIANCE, "R");
        this.parameters = CollectionsKt___CollectionsKt.toList(arrayList);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // kotlin.reflect.jvm.internal.impl.descriptors.impl.ModuleAwareClassDescriptor
    public FunctionClassScope getUnsubstitutedMemberScope(KotlinTypeRefiner kotlinTypeRefiner) {
        return this.memberScope;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor
    public List<ClassConstructorDescriptor> getConstructors() {
        return CollectionsKt__CollectionsKt.emptyList();
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor, kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptorNonRoot, kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor
    public PackageFragmentDescriptor getContainingDeclaration() {
        return this.containingDeclaration;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor
    public List<ClassDescriptor> getSealedSubclasses() {
        return CollectionsKt__CollectionsKt.emptyList();
    }
}
