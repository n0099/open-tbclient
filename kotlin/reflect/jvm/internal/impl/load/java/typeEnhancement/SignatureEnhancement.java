package kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.TypeCastException;
import kotlin.Unit;
import kotlin._Assertions;
import kotlin.collections.ArraysKt___ArraysKt;
import kotlin.collections.CollectionsKt__IterablesKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.builtins.jvm.JavaToKotlinClassMap;
import kotlin.reflect.jvm.internal.impl.descriptors.CallableDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.CallableMemberDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassifierDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.FunctionDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.PropertyDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ReceiverParameterDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ValueParameterDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.Annotated;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.AnnotationDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.Annotations;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.AnnotationsKt;
import kotlin.reflect.jvm.internal.impl.descriptors.impl.PropertyGetterDescriptorImpl;
import kotlin.reflect.jvm.internal.impl.load.java.AnnotationTypeQualifierResolver;
import kotlin.reflect.jvm.internal.impl.load.java.DeprecationCausedByFunctionN;
import kotlin.reflect.jvm.internal.impl.load.java.JvmAnnotationNamesKt;
import kotlin.reflect.jvm.internal.impl.load.java.UtilsKt;
import kotlin.reflect.jvm.internal.impl.load.java.descriptors.AnnotationDefaultValue;
import kotlin.reflect.jvm.internal.impl.load.java.descriptors.JavaCallableMemberDescriptor;
import kotlin.reflect.jvm.internal.impl.load.java.descriptors.JavaMethodDescriptor;
import kotlin.reflect.jvm.internal.impl.load.java.descriptors.JavaPropertyDescriptor;
import kotlin.reflect.jvm.internal.impl.load.java.descriptors.NullDefaultValue;
import kotlin.reflect.jvm.internal.impl.load.java.descriptors.PossiblyExternalAnnotationDescriptor;
import kotlin.reflect.jvm.internal.impl.load.java.descriptors.StringDefaultValue;
import kotlin.reflect.jvm.internal.impl.load.java.descriptors.UtilKt;
import kotlin.reflect.jvm.internal.impl.load.java.descriptors.ValueParameterData;
import kotlin.reflect.jvm.internal.impl.load.java.lazy.ContextKt;
import kotlin.reflect.jvm.internal.impl.load.java.lazy.JavaTypeQualifiersByElementType;
import kotlin.reflect.jvm.internal.impl.load.java.lazy.LazyJavaResolverContext;
import kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors.JavaDescriptorUtilKt;
import kotlin.reflect.jvm.internal.impl.load.kotlin.MethodSignatureMappingKt;
import kotlin.reflect.jvm.internal.impl.load.kotlin.SignatureBuildingComponents;
import kotlin.reflect.jvm.internal.impl.name.FqName;
import kotlin.reflect.jvm.internal.impl.resolve.constants.ConstantValue;
import kotlin.reflect.jvm.internal.impl.resolve.constants.EnumValue;
import kotlin.reflect.jvm.internal.impl.resolve.deprecation.DeprecationKt;
import kotlin.reflect.jvm.internal.impl.resolve.descriptorUtil.DescriptorUtilsKt;
import kotlin.reflect.jvm.internal.impl.types.FlexibleType;
import kotlin.reflect.jvm.internal.impl.types.FlexibleTypesKt;
import kotlin.reflect.jvm.internal.impl.types.KotlinType;
import kotlin.reflect.jvm.internal.impl.types.TypeProjection;
import kotlin.reflect.jvm.internal.impl.types.TypeUtils;
import kotlin.reflect.jvm.internal.impl.types.TypeWithEnhancementKt;
import kotlin.reflect.jvm.internal.impl.types.UnwrappedType;
import kotlin.reflect.jvm.internal.impl.types.checker.KotlinTypeChecker;
import kotlin.reflect.jvm.internal.impl.types.typeUtil.TypeUtilsKt;
import kotlin.reflect.jvm.internal.impl.utils.Jsr305State;
import kotlin.reflect.jvm.internal.impl.utils.ReportLevel;
/* loaded from: classes2.dex */
public final class SignatureEnhancement {
    public final AnnotationTypeQualifierResolver annotationTypeQualifierResolver;
    public final Jsr305State jsr305State;

    /* loaded from: classes2.dex */
    public static class PartEnhancementResult {
        public final boolean containsFunctionN;
        public final KotlinType type;
        public final boolean wereChanges;

        public PartEnhancementResult(KotlinType kotlinType, boolean z, boolean z2) {
            this.type = kotlinType;
            this.wereChanges = z;
            this.containsFunctionN = z2;
        }

        public final boolean getContainsFunctionN() {
            return this.containsFunctionN;
        }

        public final KotlinType getType() {
            return this.type;
        }

        public final boolean getWereChanges() {
            return this.wereChanges;
        }
    }

    /* loaded from: classes2.dex */
    public final class SignatureParts {
        public final AnnotationTypeQualifierResolver.QualifierApplicabilityType containerApplicabilityType;
        public final LazyJavaResolverContext containerContext;
        public final Collection<KotlinType> fromOverridden;
        public final KotlinType fromOverride;
        public final boolean isCovariant;
        public final Annotated typeContainer;

        /* JADX DEBUG: Multi-variable search result rejected for r4v0, resolved type: java.util.Collection<? extends kotlin.reflect.jvm.internal.impl.types.KotlinType> */
        /* JADX WARN: Multi-variable type inference failed */
        public SignatureParts(Annotated annotated, KotlinType kotlinType, Collection<? extends KotlinType> collection, boolean z, LazyJavaResolverContext lazyJavaResolverContext, AnnotationTypeQualifierResolver.QualifierApplicabilityType qualifierApplicabilityType) {
            this.typeContainer = annotated;
            this.fromOverride = kotlinType;
            this.fromOverridden = collection;
            this.isCovariant = z;
            this.containerContext = lazyJavaResolverContext;
            this.containerApplicabilityType = qualifierApplicabilityType;
        }

        /* JADX WARN: Removed duplicated region for block: B:23:0x0062  */
        /* JADX WARN: Removed duplicated region for block: B:24:0x0064  */
        /* JADX WARN: Removed duplicated region for block: B:27:0x006d  */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        private final Function1<Integer, JavaTypeQualifiers> computeIndexedQualifiersForOverride() {
            boolean z;
            int size;
            int i;
            boolean z2;
            boolean z3;
            KotlinType kotlinType;
            boolean z4;
            Collection<KotlinType> collection = this.fromOverridden;
            ArrayList<List> arrayList = new ArrayList(CollectionsKt__IterablesKt.collectionSizeOrDefault(collection, 10));
            for (KotlinType kotlinType2 : collection) {
                arrayList.add(toIndexed(kotlinType2));
            }
            List<TypeAndDefaultQualifiers> indexed = toIndexed(this.fromOverride);
            if (this.isCovariant) {
                Collection<KotlinType> collection2 = this.fromOverridden;
                if (!(collection2 instanceof Collection) || !collection2.isEmpty()) {
                    for (KotlinType kotlinType3 : collection2) {
                        if (!KotlinTypeChecker.DEFAULT.equalTypes(kotlinType3, this.fromOverride)) {
                            z4 = true;
                            break;
                        }
                    }
                }
                z4 = false;
                if (z4) {
                    z = true;
                    if (!z) {
                        size = 1;
                    } else {
                        size = indexed.size();
                    }
                    final JavaTypeQualifiers[] javaTypeQualifiersArr = new JavaTypeQualifiers[size];
                    for (i = 0; i < size; i++) {
                        if (i == 0) {
                            z2 = true;
                        } else {
                            z2 = false;
                        }
                        if (!z2 && z) {
                            z3 = false;
                        } else {
                            z3 = true;
                        }
                        if (_Assertions.ENABLED && !z3) {
                            throw new AssertionError("Only head type constructors should be computed");
                        }
                        TypeAndDefaultQualifiers typeAndDefaultQualifiers = indexed.get(i);
                        KotlinType component1 = typeAndDefaultQualifiers.component1();
                        JavaTypeQualifiers component2 = typeAndDefaultQualifiers.component2();
                        ArrayList arrayList2 = new ArrayList();
                        for (List list : arrayList) {
                            TypeAndDefaultQualifiers typeAndDefaultQualifiers2 = (TypeAndDefaultQualifiers) CollectionsKt___CollectionsKt.getOrNull(list, i);
                            if (typeAndDefaultQualifiers2 != null) {
                                kotlinType = typeAndDefaultQualifiers2.getType();
                            } else {
                                kotlinType = null;
                            }
                            if (kotlinType != null) {
                                arrayList2.add(kotlinType);
                            }
                        }
                        javaTypeQualifiersArr[i] = computeQualifiersForOverride(component1, arrayList2, component2, z2);
                    }
                    return new Function1<Integer, JavaTypeQualifiers>() { // from class: kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.SignatureEnhancement$SignatureParts$computeIndexedQualifiersForOverride$1
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        {
                            super(1);
                        }

                        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
                        /* JADX DEBUG: Return type fixed from 'java.lang.Object' to match base method */
                        @Override // kotlin.jvm.functions.Function1
                        public /* bridge */ /* synthetic */ JavaTypeQualifiers invoke(Integer num) {
                            return invoke(num.intValue());
                        }

                        public final JavaTypeQualifiers invoke(int i2) {
                            JavaTypeQualifiers[] javaTypeQualifiersArr2 = javaTypeQualifiersArr;
                            if (i2 >= 0 && i2 <= ArraysKt___ArraysKt.getLastIndex(javaTypeQualifiersArr2)) {
                                return javaTypeQualifiersArr2[i2];
                            }
                            return JavaTypeQualifiers.Companion.getNONE();
                        }
                    };
                }
            }
            z = false;
            if (!z) {
            }
            final JavaTypeQualifiers[] javaTypeQualifiersArr2 = new JavaTypeQualifiers[size];
            while (i < size) {
            }
            return new Function1<Integer, JavaTypeQualifiers>() { // from class: kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.SignatureEnhancement$SignatureParts$computeIndexedQualifiersForOverride$1
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(1);
                }

                /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
                /* JADX DEBUG: Return type fixed from 'java.lang.Object' to match base method */
                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ JavaTypeQualifiers invoke(Integer num) {
                    return invoke(num.intValue());
                }

                public final JavaTypeQualifiers invoke(int i2) {
                    JavaTypeQualifiers[] javaTypeQualifiersArr22 = javaTypeQualifiersArr2;
                    if (i2 >= 0 && i2 <= ArraysKt___ArraysKt.getLastIndex(javaTypeQualifiersArr22)) {
                        return javaTypeQualifiersArr22[i2];
                    }
                    return JavaTypeQualifiers.Companion.getNONE();
                }
            };
        }

        /* JADX WARN: Removed duplicated region for block: B:75:0x0128  */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        private final JavaTypeQualifiers computeQualifiersForOverride(KotlinType kotlinType, Collection<? extends KotlinType> collection, JavaTypeQualifiers javaTypeQualifiers, boolean z) {
            JavaTypeQualifiers javaTypeQualifiers2;
            NullabilityQualifier nullabilityQualifier;
            boolean z2;
            boolean z3;
            boolean z4;
            boolean z5;
            boolean z6;
            ArrayList<JavaTypeQualifiers> arrayList = new ArrayList(CollectionsKt__IterablesKt.collectionSizeOrDefault(collection, 10));
            for (KotlinType kotlinType2 : collection) {
                arrayList.add(extractQualifiers(kotlinType2));
            }
            ArrayList arrayList2 = new ArrayList();
            for (JavaTypeQualifiers javaTypeQualifiers3 : arrayList) {
                MutabilityQualifier mutability = javaTypeQualifiers3.getMutability();
                if (mutability != null) {
                    arrayList2.add(mutability);
                }
            }
            Set set = CollectionsKt___CollectionsKt.toSet(arrayList2);
            ArrayList arrayList3 = new ArrayList();
            for (JavaTypeQualifiers javaTypeQualifiers4 : arrayList) {
                NullabilityQualifier nullability = javaTypeQualifiers4.getNullability();
                if (nullability != null) {
                    arrayList3.add(nullability);
                }
            }
            Set set2 = CollectionsKt___CollectionsKt.toSet(arrayList3);
            ArrayList arrayList4 = new ArrayList();
            for (KotlinType kotlinType3 : collection) {
                NullabilityQualifier nullability2 = extractQualifiers(TypeWithEnhancementKt.unwrapEnhancement(kotlinType3)).getNullability();
                if (nullability2 != null) {
                    arrayList4.add(nullability2);
                }
            }
            Set set3 = CollectionsKt___CollectionsKt.toSet(arrayList4);
            JavaTypeQualifiers extractQualifiersFromAnnotations = extractQualifiersFromAnnotations(kotlinType, z, javaTypeQualifiers);
            boolean z7 = true;
            NullabilityQualifier nullabilityQualifier2 = null;
            if (!extractQualifiersFromAnnotations.isNullabilityQualifierForWarning()) {
                javaTypeQualifiers2 = extractQualifiersFromAnnotations;
            } else {
                javaTypeQualifiers2 = null;
            }
            if (javaTypeQualifiers2 != null) {
                nullabilityQualifier = javaTypeQualifiers2.getNullability();
            } else {
                nullabilityQualifier = null;
            }
            NullabilityQualifier nullability3 = extractQualifiersFromAnnotations.getNullability();
            if (this.isCovariant && z) {
                z2 = true;
            } else {
                z2 = false;
            }
            NullabilityQualifier select = SignatureEnhancementKt.select(set2, nullabilityQualifier, z2);
            if (select != null) {
                if (isForVarargParameter() && z && select == NullabilityQualifier.NULLABLE) {
                    z6 = true;
                } else {
                    z6 = false;
                }
                if (!z6) {
                    nullabilityQualifier2 = select;
                }
            }
            MutabilityQualifier mutabilityQualifier = (MutabilityQualifier) SignatureEnhancementKt.select(set, MutabilityQualifier.MUTABLE, MutabilityQualifier.READ_ONLY, extractQualifiersFromAnnotations.getMutability(), z2);
            if (nullability3 == nullabilityQualifier && !(!Intrinsics.areEqual(set3, set2))) {
                z3 = false;
            } else {
                z3 = true;
            }
            if (!extractQualifiersFromAnnotations.isNotNullTypeParameter()) {
                if (!arrayList.isEmpty()) {
                    for (JavaTypeQualifiers javaTypeQualifiers5 : arrayList) {
                        if (javaTypeQualifiers5.isNotNullTypeParameter()) {
                            z5 = true;
                            break;
                        }
                    }
                }
                z5 = false;
                if (!z5) {
                    z4 = false;
                    if (nullabilityQualifier2 != null && z3) {
                        return SignatureEnhancementKt.createJavaTypeQualifiers(SignatureEnhancementKt.select(set3, nullability3, z2), mutabilityQualifier, true, z4);
                    }
                    if (nullabilityQualifier2 != null) {
                        z7 = false;
                    }
                    return SignatureEnhancementKt.createJavaTypeQualifiers(nullabilityQualifier2, mutabilityQualifier, z7, z4);
                }
            }
            z4 = true;
            if (nullabilityQualifier2 != null) {
            }
            if (nullabilityQualifier2 != null) {
            }
            return SignatureEnhancementKt.createJavaTypeQualifiers(nullabilityQualifier2, mutabilityQualifier, z7, z4);
        }

        public static /* synthetic */ PartEnhancementResult enhance$default(SignatureParts signatureParts, TypeEnhancementInfo typeEnhancementInfo, int i, Object obj) {
            if ((i & 1) != 0) {
                typeEnhancementInfo = null;
            }
            return signatureParts.enhance(typeEnhancementInfo);
        }

        private final NullabilityQualifierWithMigrationStatus extractNullability(Annotations annotations) {
            SignatureEnhancement signatureEnhancement = SignatureEnhancement.this;
            Iterator<AnnotationDescriptor> it = annotations.iterator();
            while (it.hasNext()) {
                NullabilityQualifierWithMigrationStatus extractNullability = signatureEnhancement.extractNullability(it.next());
                if (extractNullability != null) {
                    return extractNullability;
                }
            }
            return null;
        }

        private final List<TypeAndDefaultQualifiers> toIndexed(KotlinType kotlinType) {
            final ArrayList arrayList = new ArrayList(1);
            new Function2<KotlinType, LazyJavaResolverContext, Unit>() { // from class: kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.SignatureEnhancement$SignatureParts$toIndexed$1
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(2);
                }

                /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, java.lang.Object] */
                /* JADX DEBUG: Return type fixed from 'java.lang.Object' to match base method */
                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Unit invoke(KotlinType kotlinType2, LazyJavaResolverContext lazyJavaResolverContext) {
                    invoke2(kotlinType2, lazyJavaResolverContext);
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke  reason: avoid collision after fix types in other method */
                public final void invoke2(KotlinType kotlinType2, LazyJavaResolverContext lazyJavaResolverContext) {
                    JavaTypeQualifiers javaTypeQualifiers;
                    LazyJavaResolverContext copyWithNewDefaultTypeQualifiers = ContextKt.copyWithNewDefaultTypeQualifiers(lazyJavaResolverContext, kotlinType2.getAnnotations());
                    ArrayList arrayList2 = arrayList;
                    JavaTypeQualifiersByElementType defaultTypeQualifiers = copyWithNewDefaultTypeQualifiers.getDefaultTypeQualifiers();
                    if (defaultTypeQualifiers != null) {
                        javaTypeQualifiers = defaultTypeQualifiers.get(AnnotationTypeQualifierResolver.QualifierApplicabilityType.TYPE_USE);
                    } else {
                        javaTypeQualifiers = null;
                    }
                    arrayList2.add(new TypeAndDefaultQualifiers(kotlinType2, javaTypeQualifiers));
                    for (TypeProjection typeProjection : kotlinType2.getArguments()) {
                        if (typeProjection.isStarProjection()) {
                            ArrayList arrayList3 = arrayList;
                            KotlinType type = typeProjection.getType();
                            Intrinsics.checkExpressionValueIsNotNull(type, "arg.type");
                            arrayList3.add(new TypeAndDefaultQualifiers(type, null));
                        } else {
                            KotlinType type2 = typeProjection.getType();
                            Intrinsics.checkExpressionValueIsNotNull(type2, "arg.type");
                            invoke2(type2, copyWithNewDefaultTypeQualifiers);
                        }
                    }
                }
            }.invoke2(kotlinType, this.containerContext);
            return arrayList;
        }

        public final PartEnhancementResult enhance(final TypeEnhancementInfo typeEnhancementInfo) {
            Function1<Integer, JavaTypeQualifiers> function1;
            final Function1<Integer, JavaTypeQualifiers> computeIndexedQualifiersForOverride = computeIndexedQualifiersForOverride();
            if (typeEnhancementInfo != null) {
                function1 = new Function1<Integer, JavaTypeQualifiers>() { // from class: kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.SignatureEnhancement$SignatureParts$enhance$$inlined$let$lambda$1
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(1);
                    }

                    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
                    /* JADX DEBUG: Return type fixed from 'java.lang.Object' to match base method */
                    @Override // kotlin.jvm.functions.Function1
                    public /* bridge */ /* synthetic */ JavaTypeQualifiers invoke(Integer num) {
                        return invoke(num.intValue());
                    }

                    public final JavaTypeQualifiers invoke(int i) {
                        JavaTypeQualifiers javaTypeQualifiers = TypeEnhancementInfo.this.getMap().get(Integer.valueOf(i));
                        if (javaTypeQualifiers == null) {
                            return (JavaTypeQualifiers) computeIndexedQualifiersForOverride.invoke(Integer.valueOf(i));
                        }
                        return javaTypeQualifiers;
                    }
                };
            } else {
                function1 = null;
            }
            boolean contains = TypeUtils.contains(this.fromOverride, new Function1<UnwrappedType, Boolean>() { // from class: kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.SignatureEnhancement$SignatureParts$enhance$containsFunctionN$1
                /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
                /* JADX DEBUG: Return type fixed from 'java.lang.Object' to match base method */
                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Boolean invoke(UnwrappedType unwrappedType) {
                    return Boolean.valueOf(invoke2(unwrappedType));
                }

                /* renamed from: invoke  reason: avoid collision after fix types in other method */
                public final boolean invoke2(UnwrappedType unwrappedType) {
                    ClassifierDescriptor mo2104getDeclarationDescriptor = unwrappedType.getConstructor().mo2104getDeclarationDescriptor();
                    if (mo2104getDeclarationDescriptor == null) {
                        return false;
                    }
                    Intrinsics.checkExpressionValueIsNotNull(mo2104getDeclarationDescriptor, "it.constructor.declarati… ?: return@contains false");
                    if (!Intrinsics.areEqual(mo2104getDeclarationDescriptor.getName(), JavaToKotlinClassMap.INSTANCE.getFUNCTION_N_FQ_NAME().shortName()) || !Intrinsics.areEqual(DescriptorUtilsKt.fqNameOrNull(mo2104getDeclarationDescriptor), JavaToKotlinClassMap.INSTANCE.getFUNCTION_N_FQ_NAME())) {
                        return false;
                    }
                    return true;
                }
            });
            KotlinType kotlinType = this.fromOverride;
            if (function1 != null) {
                computeIndexedQualifiersForOverride = function1;
            }
            KotlinType enhance = TypeEnhancementKt.enhance(kotlinType, computeIndexedQualifiersForOverride);
            if (enhance != null) {
                return new PartEnhancementResult(enhance, true, contains);
            }
            return new PartEnhancementResult(this.fromOverride, false, contains);
        }

        /* JADX WARN: Removed duplicated region for block: B:16:0x0048  */
        /* JADX WARN: Removed duplicated region for block: B:17:0x004b  */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        private final JavaTypeQualifiers extractQualifiers(KotlinType kotlinType) {
            Pair pair;
            NullabilityQualifier nullabilityQualifier;
            NullabilityQualifier nullabilityQualifier2;
            MutabilityQualifier mutabilityQualifier;
            if (FlexibleTypesKt.isFlexible(kotlinType)) {
                FlexibleType asFlexibleType = FlexibleTypesKt.asFlexibleType(kotlinType);
                pair = new Pair(asFlexibleType.getLowerBound(), asFlexibleType.getUpperBound());
            } else {
                pair = new Pair(kotlinType, kotlinType);
            }
            KotlinType kotlinType2 = (KotlinType) pair.component1();
            KotlinType kotlinType3 = (KotlinType) pair.component2();
            JavaToKotlinClassMap javaToKotlinClassMap = JavaToKotlinClassMap.INSTANCE;
            if (kotlinType2.isMarkedNullable()) {
                nullabilityQualifier2 = NullabilityQualifier.NULLABLE;
            } else if (!kotlinType3.isMarkedNullable()) {
                nullabilityQualifier2 = NullabilityQualifier.NOT_NULL;
            } else {
                nullabilityQualifier = null;
                if (!javaToKotlinClassMap.isReadOnly(kotlinType2)) {
                    mutabilityQualifier = MutabilityQualifier.READ_ONLY;
                } else if (javaToKotlinClassMap.isMutable(kotlinType3)) {
                    mutabilityQualifier = MutabilityQualifier.MUTABLE;
                } else {
                    mutabilityQualifier = null;
                }
                return new JavaTypeQualifiers(nullabilityQualifier, mutabilityQualifier, kotlinType.unwrap() instanceof NotNullTypeParameter, false, 8, null);
            }
            nullabilityQualifier = nullabilityQualifier2;
            if (!javaToKotlinClassMap.isReadOnly(kotlinType2)) {
            }
            return new JavaTypeQualifiers(nullabilityQualifier, mutabilityQualifier, kotlinType.unwrap() instanceof NotNullTypeParameter, false, 8, null);
        }

        private final JavaTypeQualifiers extractQualifiersFromAnnotations(KotlinType kotlinType, boolean z, JavaTypeQualifiers javaTypeQualifiers) {
            final Annotations annotations;
            NullabilityQualifier nullabilityQualifier;
            boolean z2;
            Annotated annotated;
            if (z && (annotated = this.typeContainer) != null) {
                annotations = AnnotationsKt.composeAnnotations(annotated.getAnnotations(), kotlinType.getAnnotations());
            } else {
                annotations = kotlinType.getAnnotations();
            }
            Function2<List<? extends FqName>, T, T> function2 = new Function2<List<? extends FqName>, T, T>() { // from class: kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.SignatureEnhancement$SignatureParts$extractQualifiersFromAnnotations$1
                {
                    super(2);
                }

                /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, java.lang.Object] */
                /* JADX DEBUG: Multi-variable search result rejected for r2v0, resolved type: java.lang.Object */
                /* JADX WARN: Multi-variable type inference failed */
                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Object invoke(List<? extends FqName> list, Object obj) {
                    return invoke2((List<FqName>) list, (List<? extends FqName>) obj);
                }

                /* renamed from: invoke  reason: avoid collision after fix types in other method */
                public final <T> T invoke2(List<FqName> list, T t) {
                    boolean z3;
                    boolean z4 = true;
                    if (!(list instanceof Collection) || !list.isEmpty()) {
                        for (FqName fqName : list) {
                            if (Annotations.this.mo2099findAnnotation(fqName) != null) {
                                z3 = true;
                                continue;
                            } else {
                                z3 = false;
                                continue;
                            }
                            if (z3) {
                                break;
                            }
                        }
                    }
                    z4 = false;
                    if (!z4) {
                        return null;
                    }
                    return t;
                }
            };
            SignatureEnhancement$SignatureParts$extractQualifiersFromAnnotations$2 signatureEnhancement$SignatureParts$extractQualifiersFromAnnotations$2 = SignatureEnhancement$SignatureParts$extractQualifiersFromAnnotations$2.INSTANCE;
            NullabilityQualifier nullabilityQualifier2 = null;
            if (z) {
                JavaTypeQualifiersByElementType defaultTypeQualifiers = this.containerContext.getDefaultTypeQualifiers();
                if (defaultTypeQualifiers != null) {
                    javaTypeQualifiers = defaultTypeQualifiers.get(this.containerApplicabilityType);
                } else {
                    javaTypeQualifiers = null;
                }
            }
            NullabilityQualifierWithMigrationStatus extractNullability = extractNullability(annotations);
            if (extractNullability == null) {
                if (javaTypeQualifiers != null && javaTypeQualifiers.getNullability() != null) {
                    extractNullability = new NullabilityQualifierWithMigrationStatus(javaTypeQualifiers.getNullability(), javaTypeQualifiers.isNullabilityQualifierForWarning());
                } else {
                    extractNullability = null;
                }
            }
            if (extractNullability != null) {
                nullabilityQualifier = extractNullability.getQualifier();
            } else {
                nullabilityQualifier = null;
            }
            MutabilityQualifier mutabilityQualifier = (MutabilityQualifier) signatureEnhancement$SignatureParts$extractQualifiersFromAnnotations$2.invoke(function2.invoke2(JvmAnnotationNamesKt.getREAD_ONLY_ANNOTATIONS(), (List<FqName>) MutabilityQualifier.READ_ONLY), function2.invoke2(JvmAnnotationNamesKt.getMUTABLE_ANNOTATIONS(), (List<FqName>) MutabilityQualifier.MUTABLE));
            if (extractNullability != null) {
                nullabilityQualifier2 = extractNullability.getQualifier();
            }
            boolean z3 = false;
            if (nullabilityQualifier2 == NullabilityQualifier.NOT_NULL && TypeUtilsKt.isTypeParameter(kotlinType)) {
                z2 = true;
            } else {
                z2 = false;
            }
            if (extractNullability != null && extractNullability.isForWarningOnly()) {
                z3 = true;
            }
            return new JavaTypeQualifiers(nullabilityQualifier, mutabilityQualifier, z2, z3);
        }

        private final boolean isForVarargParameter() {
            Annotated annotated = this.typeContainer;
            KotlinType kotlinType = null;
            if (!(annotated instanceof ValueParameterDescriptor)) {
                annotated = null;
            }
            ValueParameterDescriptor valueParameterDescriptor = (ValueParameterDescriptor) annotated;
            if (valueParameterDescriptor != null) {
                kotlinType = valueParameterDescriptor.getVarargElementType();
            }
            if (kotlinType != null) {
                return true;
            }
            return false;
        }
    }

    /* loaded from: classes2.dex */
    public static final class ValueParameterEnhancementResult extends PartEnhancementResult {
        public final boolean hasDefaultValue;

        public ValueParameterEnhancementResult(KotlinType kotlinType, boolean z, boolean z2, boolean z3) {
            super(kotlinType, z2, z3);
            this.hasDefaultValue = z;
        }

        public final boolean getHasDefaultValue() {
            return this.hasDefaultValue;
        }
    }

    public SignatureEnhancement(AnnotationTypeQualifierResolver annotationTypeQualifierResolver, Jsr305State jsr305State) {
        this.annotationTypeQualifierResolver = annotationTypeQualifierResolver;
        this.jsr305State = jsr305State;
    }

    /* JADX DEBUG: Multi-variable search result rejected for r2v0, resolved type: kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.SignatureEnhancement */
    /* JADX WARN: Multi-variable type inference failed */
    public final <D extends CallableMemberDescriptor> Collection<D> enhanceSignatures(LazyJavaResolverContext lazyJavaResolverContext, Collection<? extends D> collection) {
        ArrayList arrayList = new ArrayList(CollectionsKt__IterablesKt.collectionSizeOrDefault(collection, 10));
        Iterator<T> it = collection.iterator();
        while (it.hasNext()) {
            arrayList.add(enhanceSignature((CallableMemberDescriptor) it.next(), lazyJavaResolverContext));
        }
        return arrayList;
    }

    /* JADX WARN: Removed duplicated region for block: B:102:0x01df  */
    /* JADX WARN: Removed duplicated region for block: B:110:0x01f9  */
    /* JADX WARN: Removed duplicated region for block: B:113:0x01fe  */
    /* JADX WARN: Removed duplicated region for block: B:120:0x0212  */
    /* JADX WARN: Removed duplicated region for block: B:126:0x022a A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:130:0x0230  */
    /* JADX WARN: Removed duplicated region for block: B:131:0x023e  */
    /* JADX WARN: Removed duplicated region for block: B:133:0x0241  */
    /* JADX WARN: Removed duplicated region for block: B:134:0x0246  */
    /* JADX WARN: Removed duplicated region for block: B:138:0x025a A[LOOP:1: B:136:0x0254->B:138:0x025a, LOOP_END] */
    /* JADX WARN: Removed duplicated region for block: B:141:0x027b A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:142:0x027c  */
    /* JADX WARN: Removed duplicated region for block: B:48:0x00b8  */
    /* JADX WARN: Removed duplicated region for block: B:61:0x012e  */
    /* JADX WARN: Removed duplicated region for block: B:81:0x019e  */
    /* JADX WARN: Removed duplicated region for block: B:82:0x01a0  */
    /* JADX WARN: Removed duplicated region for block: B:91:0x01bf  */
    /* JADX WARN: Removed duplicated region for block: B:92:0x01c4  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private final <D extends CallableMemberDescriptor> D enhanceSignature(D d, LazyJavaResolverContext lazyJavaResolverContext) {
        PropertyGetterDescriptorImpl propertyGetterDescriptorImpl;
        PartEnhancementResult partEnhancementResult;
        D d2;
        PredefinedFunctionEnhancementInfo predefinedFunctionEnhancementInfo;
        ArrayList<ValueParameterEnhancementResult> arrayList;
        D d3;
        PropertyDescriptor propertyDescriptor;
        AnnotationTypeQualifierResolver.QualifierApplicabilityType qualifierApplicabilityType;
        TypeEnhancementInfo typeEnhancementInfo;
        boolean z;
        boolean z2;
        Pair<CallableDescriptor.UserDataKey<?>, ?> pair;
        KotlinType kotlinType;
        JavaCallableMemberDescriptor enhance;
        TypeEnhancementInfo typeEnhancementInfo2;
        KotlinType type;
        boolean z3;
        List<TypeEnhancementInfo> parametersInfo;
        boolean z4;
        D d4;
        ValueParameterDescriptor valueParameterDescriptor;
        JavaPropertyDescriptor javaPropertyDescriptor;
        PropertyGetterDescriptorImpl getter;
        if (!(d instanceof JavaCallableMemberDescriptor)) {
            return d;
        }
        JavaCallableMemberDescriptor javaCallableMemberDescriptor = (JavaCallableMemberDescriptor) d;
        boolean z5 = true;
        if (javaCallableMemberDescriptor.getKind() == CallableMemberDescriptor.Kind.FAKE_OVERRIDE) {
            CallableMemberDescriptor original = javaCallableMemberDescriptor.getOriginal();
            Intrinsics.checkExpressionValueIsNotNull(original, "original");
            if (original.getOverriddenDescriptors().size() == 1) {
                return d;
            }
        }
        LazyJavaResolverContext copyWithNewDefaultTypeQualifiers = ContextKt.copyWithNewDefaultTypeQualifiers(lazyJavaResolverContext, d.getAnnotations());
        if ((d instanceof JavaPropertyDescriptor) && (getter = (javaPropertyDescriptor = (JavaPropertyDescriptor) d).getGetter()) != null && !getter.isDefault()) {
            PropertyGetterDescriptorImpl getter2 = javaPropertyDescriptor.getGetter();
            if (getter2 == null) {
                Intrinsics.throwNpe();
            }
            Intrinsics.checkExpressionValueIsNotNull(getter2, "getter!!");
            propertyGetterDescriptorImpl = getter2;
        } else {
            propertyGetterDescriptorImpl = d;
        }
        TypeEnhancementInfo typeEnhancementInfo3 = null;
        if (javaCallableMemberDescriptor.getExtensionReceiverParameter() != null) {
            if (!(propertyGetterDescriptorImpl instanceof FunctionDescriptor)) {
                d4 = null;
            } else {
                d4 = propertyGetterDescriptorImpl;
            }
            FunctionDescriptor functionDescriptor = (FunctionDescriptor) d4;
            if (functionDescriptor != null) {
                valueParameterDescriptor = (ValueParameterDescriptor) functionDescriptor.getUserData(JavaMethodDescriptor.ORIGINAL_VALUE_PARAMETER_FOR_EXTENSION_RECEIVER);
            } else {
                valueParameterDescriptor = null;
            }
            partEnhancementResult = SignatureParts.enhance$default(partsForValueParameter(d, valueParameterDescriptor, copyWithNewDefaultTypeQualifiers, new Function1<CallableMemberDescriptor, KotlinType>() { // from class: kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.SignatureEnhancement$enhanceSignature$receiverTypeEnhancement$1
                /* JADX DEBUG: Method merged with bridge method */
                @Override // kotlin.jvm.functions.Function1
                public final KotlinType invoke(CallableMemberDescriptor callableMemberDescriptor) {
                    ReceiverParameterDescriptor extensionReceiverParameter = callableMemberDescriptor.getExtensionReceiverParameter();
                    if (extensionReceiverParameter == null) {
                        Intrinsics.throwNpe();
                    }
                    Intrinsics.checkExpressionValueIsNotNull(extensionReceiverParameter, "it.extensionReceiverParameter!!");
                    KotlinType type2 = extensionReceiverParameter.getType();
                    Intrinsics.checkExpressionValueIsNotNull(type2, "it.extensionReceiverParameter!!.type");
                    return type2;
                }
            }), null, 1, null);
        } else {
            partEnhancementResult = null;
        }
        if (!(d instanceof JavaMethodDescriptor)) {
            d2 = null;
        } else {
            d2 = d;
        }
        JavaMethodDescriptor javaMethodDescriptor = (JavaMethodDescriptor) d2;
        if (javaMethodDescriptor != null) {
            SignatureBuildingComponents signatureBuildingComponents = SignatureBuildingComponents.INSTANCE;
            DeclarationDescriptor containingDeclaration = javaMethodDescriptor.getContainingDeclaration();
            if (containingDeclaration != null) {
                String signature = signatureBuildingComponents.signature((ClassDescriptor) containingDeclaration, MethodSignatureMappingKt.computeJvmDescriptor$default(javaMethodDescriptor, false, false, 3, null));
                if (signature != null) {
                    predefinedFunctionEnhancementInfo = PredefinedEnhancementInfoKt.getPREDEFINED_FUNCTION_ENHANCEMENT_INFO_BY_SIGNATURE().get(signature);
                    if (predefinedFunctionEnhancementInfo != null) {
                        if (predefinedFunctionEnhancementInfo.getParametersInfo().size() == javaCallableMemberDescriptor.getValueParameters().size()) {
                            z4 = true;
                        } else {
                            z4 = false;
                        }
                        if (_Assertions.ENABLED && !z4) {
                            throw new AssertionError("Predefined enhancement info for " + d + " has " + predefinedFunctionEnhancementInfo.getParametersInfo().size() + ", but " + javaCallableMemberDescriptor.getValueParameters().size() + " expected");
                        }
                    }
                    List<ValueParameterDescriptor> valueParameters = propertyGetterDescriptorImpl.getValueParameters();
                    Intrinsics.checkExpressionValueIsNotNull(valueParameters, "annotationOwnerForMember.valueParameters");
                    arrayList = new ArrayList(CollectionsKt__IterablesKt.collectionSizeOrDefault(valueParameters, 10));
                    for (final ValueParameterDescriptor p : valueParameters) {
                        SignatureParts partsForValueParameter = partsForValueParameter(d, p, copyWithNewDefaultTypeQualifiers, new Function1<CallableMemberDescriptor, KotlinType>() { // from class: kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.SignatureEnhancement$enhanceSignature$valueParameterEnhancements$1$enhancementResult$1
                            {
                                super(1);
                            }

                            /* JADX DEBUG: Method merged with bridge method */
                            @Override // kotlin.jvm.functions.Function1
                            public final KotlinType invoke(CallableMemberDescriptor callableMemberDescriptor) {
                                ValueParameterDescriptor valueParameterDescriptor2 = callableMemberDescriptor.getValueParameters().get(ValueParameterDescriptor.this.getIndex());
                                Intrinsics.checkExpressionValueIsNotNull(valueParameterDescriptor2, "it.valueParameters[p.index]");
                                KotlinType type2 = valueParameterDescriptor2.getType();
                                Intrinsics.checkExpressionValueIsNotNull(type2, "it.valueParameters[p.index].type");
                                return type2;
                            }
                        });
                        if (predefinedFunctionEnhancementInfo != null && (parametersInfo = predefinedFunctionEnhancementInfo.getParametersInfo()) != null) {
                            typeEnhancementInfo2 = (TypeEnhancementInfo) CollectionsKt___CollectionsKt.getOrNull(parametersInfo, p.getIndex());
                        } else {
                            typeEnhancementInfo2 = typeEnhancementInfo3;
                        }
                        PartEnhancementResult enhance2 = partsForValueParameter.enhance(typeEnhancementInfo2);
                        if (enhance2.getWereChanges()) {
                            type = enhance2.getType();
                        } else {
                            Intrinsics.checkExpressionValueIsNotNull(p, "p");
                            type = p.getType();
                            Intrinsics.checkExpressionValueIsNotNull(type, "p.type");
                        }
                        Intrinsics.checkExpressionValueIsNotNull(p, "p");
                        boolean hasDefaultValueInAnnotation = hasDefaultValueInAnnotation(p, type);
                        if (!enhance2.getWereChanges() && hasDefaultValueInAnnotation == p.declaresDefaultValue()) {
                            z3 = false;
                        } else {
                            z3 = true;
                        }
                        arrayList.add(new ValueParameterEnhancementResult(enhance2.getType(), hasDefaultValueInAnnotation, z3, enhance2.getContainsFunctionN()));
                        typeEnhancementInfo3 = null;
                    }
                    if (d instanceof PropertyDescriptor) {
                        d3 = null;
                    } else {
                        d3 = d;
                    }
                    propertyDescriptor = (PropertyDescriptor) d3;
                    if (propertyDescriptor == null && JavaDescriptorUtilKt.isJavaField(propertyDescriptor)) {
                        qualifierApplicabilityType = AnnotationTypeQualifierResolver.QualifierApplicabilityType.FIELD;
                    } else {
                        qualifierApplicabilityType = AnnotationTypeQualifierResolver.QualifierApplicabilityType.METHOD_RETURN_TYPE;
                    }
                    SignatureParts parts = parts(d, propertyGetterDescriptorImpl, true, copyWithNewDefaultTypeQualifiers, qualifierApplicabilityType, new Function1<CallableMemberDescriptor, KotlinType>() { // from class: kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.SignatureEnhancement$enhanceSignature$returnTypeEnhancement$1
                        /* JADX DEBUG: Method merged with bridge method */
                        @Override // kotlin.jvm.functions.Function1
                        public final KotlinType invoke(CallableMemberDescriptor callableMemberDescriptor) {
                            KotlinType returnType = callableMemberDescriptor.getReturnType();
                            if (returnType == null) {
                                Intrinsics.throwNpe();
                            }
                            return returnType;
                        }
                    });
                    if (predefinedFunctionEnhancementInfo == null) {
                        typeEnhancementInfo = predefinedFunctionEnhancementInfo.getReturnTypeInfo();
                    } else {
                        typeEnhancementInfo = null;
                    }
                    PartEnhancementResult enhance3 = parts.enhance(typeEnhancementInfo);
                    if ((partEnhancementResult != null || !partEnhancementResult.getContainsFunctionN()) && !enhance3.getContainsFunctionN()) {
                        if (!arrayList.isEmpty()) {
                            for (ValueParameterEnhancementResult valueParameterEnhancementResult : arrayList) {
                                if (valueParameterEnhancementResult.getContainsFunctionN()) {
                                    z = true;
                                    break;
                                }
                            }
                        }
                        z = false;
                        if (!z) {
                            z2 = false;
                            if ((partEnhancementResult != null || !partEnhancementResult.getWereChanges()) && !enhance3.getWereChanges()) {
                                if (!arrayList.isEmpty()) {
                                    for (ValueParameterEnhancementResult valueParameterEnhancementResult2 : arrayList) {
                                        if (valueParameterEnhancementResult2.getWereChanges()) {
                                            break;
                                        }
                                    }
                                }
                                z5 = false;
                                if (!z5 && !z2) {
                                    return d;
                                }
                            }
                            if (z2) {
                                pair = TuplesKt.to(DeprecationKt.getDEPRECATED_FUNCTION_KEY(), new DeprecationCausedByFunctionN(d));
                            } else {
                                pair = null;
                            }
                            if (partEnhancementResult != null) {
                                kotlinType = partEnhancementResult.getType();
                            } else {
                                kotlinType = null;
                            }
                            ArrayList arrayList2 = new ArrayList(CollectionsKt__IterablesKt.collectionSizeOrDefault(arrayList, 10));
                            for (ValueParameterEnhancementResult valueParameterEnhancementResult3 : arrayList) {
                                arrayList2.add(new ValueParameterData(valueParameterEnhancementResult3.getType(), valueParameterEnhancementResult3.getHasDefaultValue()));
                            }
                            enhance = javaCallableMemberDescriptor.enhance(kotlinType, arrayList2, enhance3.getType(), pair);
                            if (enhance != null) {
                                return enhance;
                            }
                            throw new TypeCastException("null cannot be cast to non-null type D");
                        }
                    }
                    z2 = true;
                    if (partEnhancementResult != null) {
                    }
                    if (!arrayList.isEmpty()) {
                    }
                    z5 = false;
                    if (!z5) {
                        return d;
                    }
                    if (z2) {
                    }
                    if (partEnhancementResult != null) {
                    }
                    ArrayList arrayList22 = new ArrayList(CollectionsKt__IterablesKt.collectionSizeOrDefault(arrayList, 10));
                    while (r4.hasNext()) {
                    }
                    enhance = javaCallableMemberDescriptor.enhance(kotlinType, arrayList22, enhance3.getType(), pair);
                    if (enhance != null) {
                    }
                }
            } else {
                throw new TypeCastException("null cannot be cast to non-null type org.jetbrains.kotlin.descriptors.ClassDescriptor");
            }
        }
        predefinedFunctionEnhancementInfo = null;
        if (predefinedFunctionEnhancementInfo != null) {
        }
        List<ValueParameterDescriptor> valueParameters2 = propertyGetterDescriptorImpl.getValueParameters();
        Intrinsics.checkExpressionValueIsNotNull(valueParameters2, "annotationOwnerForMember.valueParameters");
        arrayList = new ArrayList(CollectionsKt__IterablesKt.collectionSizeOrDefault(valueParameters2, 10));
        while (r0.hasNext()) {
        }
        if (d instanceof PropertyDescriptor) {
        }
        propertyDescriptor = (PropertyDescriptor) d3;
        if (propertyDescriptor == null) {
        }
        qualifierApplicabilityType = AnnotationTypeQualifierResolver.QualifierApplicabilityType.METHOD_RETURN_TYPE;
        SignatureParts parts2 = parts(d, propertyGetterDescriptorImpl, true, copyWithNewDefaultTypeQualifiers, qualifierApplicabilityType, new Function1<CallableMemberDescriptor, KotlinType>() { // from class: kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.SignatureEnhancement$enhanceSignature$returnTypeEnhancement$1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // kotlin.jvm.functions.Function1
            public final KotlinType invoke(CallableMemberDescriptor callableMemberDescriptor) {
                KotlinType returnType = callableMemberDescriptor.getReturnType();
                if (returnType == null) {
                    Intrinsics.throwNpe();
                }
                return returnType;
            }
        });
        if (predefinedFunctionEnhancementInfo == null) {
        }
        PartEnhancementResult enhance32 = parts2.enhance(typeEnhancementInfo);
        if (partEnhancementResult != null) {
        }
        if (!arrayList.isEmpty()) {
        }
        z = false;
        if (!z) {
        }
        z2 = true;
        if (partEnhancementResult != null) {
        }
        if (!arrayList.isEmpty()) {
        }
        z5 = false;
        if (!z5) {
        }
        if (z2) {
        }
        if (partEnhancementResult != null) {
        }
        ArrayList arrayList222 = new ArrayList(CollectionsKt__IterablesKt.collectionSizeOrDefault(arrayList, 10));
        while (r4.hasNext()) {
        }
        enhance = javaCallableMemberDescriptor.enhance(kotlinType, arrayList222, enhance32.getType(), pair);
        if (enhance != null) {
        }
    }

    private final NullabilityQualifierWithMigrationStatus extractNullabilityFromKnownAnnotations(AnnotationDescriptor annotationDescriptor) {
        NullabilityQualifierWithMigrationStatus nullabilityQualifierWithMigrationStatus;
        FqName fqName = annotationDescriptor.getFqName();
        if (fqName == null) {
            return null;
        }
        if (JvmAnnotationNamesKt.getNULLABLE_ANNOTATIONS().contains(fqName)) {
            nullabilityQualifierWithMigrationStatus = new NullabilityQualifierWithMigrationStatus(NullabilityQualifier.NULLABLE, false, 2, null);
        } else if (JvmAnnotationNamesKt.getNOT_NULL_ANNOTATIONS().contains(fqName)) {
            nullabilityQualifierWithMigrationStatus = new NullabilityQualifierWithMigrationStatus(NullabilityQualifier.NOT_NULL, false, 2, null);
        } else if (Intrinsics.areEqual(fqName, JvmAnnotationNamesKt.getJAVAX_NONNULL_ANNOTATION())) {
            nullabilityQualifierWithMigrationStatus = extractNullabilityTypeFromArgument(annotationDescriptor);
        } else if (Intrinsics.areEqual(fqName, JvmAnnotationNamesKt.getCOMPATQUAL_NULLABLE_ANNOTATION()) && this.jsr305State.getEnableCompatqualCheckerFrameworkAnnotations()) {
            nullabilityQualifierWithMigrationStatus = new NullabilityQualifierWithMigrationStatus(NullabilityQualifier.NULLABLE, false, 2, null);
        } else if (Intrinsics.areEqual(fqName, JvmAnnotationNamesKt.getCOMPATQUAL_NONNULL_ANNOTATION()) && this.jsr305State.getEnableCompatqualCheckerFrameworkAnnotations()) {
            nullabilityQualifierWithMigrationStatus = new NullabilityQualifierWithMigrationStatus(NullabilityQualifier.NOT_NULL, false, 2, null);
        } else if (Intrinsics.areEqual(fqName, JvmAnnotationNamesKt.getANDROIDX_RECENTLY_NON_NULL_ANNOTATION())) {
            nullabilityQualifierWithMigrationStatus = new NullabilityQualifierWithMigrationStatus(NullabilityQualifier.NOT_NULL, true);
        } else if (Intrinsics.areEqual(fqName, JvmAnnotationNamesKt.getANDROIDX_RECENTLY_NULLABLE_ANNOTATION())) {
            nullabilityQualifierWithMigrationStatus = new NullabilityQualifierWithMigrationStatus(NullabilityQualifier.NULLABLE, true);
        } else {
            nullabilityQualifierWithMigrationStatus = null;
        }
        if (nullabilityQualifierWithMigrationStatus == null) {
            return null;
        }
        if (!nullabilityQualifierWithMigrationStatus.isForWarningOnly() && (annotationDescriptor instanceof PossiblyExternalAnnotationDescriptor) && ((PossiblyExternalAnnotationDescriptor) annotationDescriptor).isIdeExternalAnnotation()) {
            return NullabilityQualifierWithMigrationStatus.copy$default(nullabilityQualifierWithMigrationStatus, null, true, 1, null);
        }
        return nullabilityQualifierWithMigrationStatus;
    }

    private final NullabilityQualifierWithMigrationStatus extractNullabilityTypeFromArgument(AnnotationDescriptor annotationDescriptor) {
        NullabilityQualifierWithMigrationStatus nullabilityQualifierWithMigrationStatus;
        ConstantValue<?> firstArgument = DescriptorUtilsKt.firstArgument(annotationDescriptor);
        if (!(firstArgument instanceof EnumValue)) {
            firstArgument = null;
        }
        EnumValue enumValue = (EnumValue) firstArgument;
        if (enumValue != null) {
            String asString = enumValue.getEnumEntryName().asString();
            switch (asString.hashCode()) {
                case 73135176:
                    if (!asString.equals("MAYBE")) {
                        return null;
                    }
                    nullabilityQualifierWithMigrationStatus = new NullabilityQualifierWithMigrationStatus(NullabilityQualifier.NULLABLE, false, 2, null);
                    break;
                case 74175084:
                    if (!asString.equals("NEVER")) {
                        return null;
                    }
                    nullabilityQualifierWithMigrationStatus = new NullabilityQualifierWithMigrationStatus(NullabilityQualifier.NULLABLE, false, 2, null);
                    break;
                case 433141802:
                    if (!asString.equals("UNKNOWN")) {
                        return null;
                    }
                    nullabilityQualifierWithMigrationStatus = new NullabilityQualifierWithMigrationStatus(NullabilityQualifier.FORCE_FLEXIBILITY, false, 2, null);
                    break;
                case 1933739535:
                    if (!asString.equals("ALWAYS")) {
                        return null;
                    }
                    nullabilityQualifierWithMigrationStatus = new NullabilityQualifierWithMigrationStatus(NullabilityQualifier.NOT_NULL, false, 2, null);
                    break;
                default:
                    return null;
            }
            return nullabilityQualifierWithMigrationStatus;
        }
        return new NullabilityQualifierWithMigrationStatus(NullabilityQualifier.NOT_NULL, false, 2, null);
    }

    private final boolean hasDefaultValueInAnnotation(ValueParameterDescriptor valueParameterDescriptor, KotlinType kotlinType) {
        boolean declaresDefaultValue;
        AnnotationDefaultValue defaultValueFromAnnotation = UtilKt.getDefaultValueFromAnnotation(valueParameterDescriptor);
        if (defaultValueFromAnnotation instanceof StringDefaultValue) {
            if (UtilsKt.lexicalCastFrom(kotlinType, ((StringDefaultValue) defaultValueFromAnnotation).getValue()) != null) {
                declaresDefaultValue = true;
            } else {
                declaresDefaultValue = false;
            }
        } else if (Intrinsics.areEqual(defaultValueFromAnnotation, NullDefaultValue.INSTANCE)) {
            declaresDefaultValue = TypeUtils.acceptsNullable(kotlinType);
        } else if (defaultValueFromAnnotation == null) {
            declaresDefaultValue = valueParameterDescriptor.declaresDefaultValue();
        } else {
            throw new NoWhenBranchMatchedException();
        }
        if (declaresDefaultValue && valueParameterDescriptor.getOverriddenDescriptors().isEmpty()) {
            return true;
        }
        return false;
    }

    private final SignatureParts parts(CallableMemberDescriptor callableMemberDescriptor, Annotated annotated, boolean z, LazyJavaResolverContext lazyJavaResolverContext, AnnotationTypeQualifierResolver.QualifierApplicabilityType qualifierApplicabilityType, Function1<? super CallableMemberDescriptor, ? extends KotlinType> function1) {
        KotlinType invoke = function1.invoke(callableMemberDescriptor);
        Collection<? extends CallableMemberDescriptor> overriddenDescriptors = callableMemberDescriptor.getOverriddenDescriptors();
        Intrinsics.checkExpressionValueIsNotNull(overriddenDescriptors, "this.overriddenDescriptors");
        ArrayList arrayList = new ArrayList(CollectionsKt__IterablesKt.collectionSizeOrDefault(overriddenDescriptors, 10));
        for (CallableMemberDescriptor it : overriddenDescriptors) {
            Intrinsics.checkExpressionValueIsNotNull(it, "it");
            arrayList.add(function1.invoke(it));
        }
        return new SignatureParts(annotated, invoke, arrayList, z, ContextKt.copyWithNewDefaultTypeQualifiers(lazyJavaResolverContext, function1.invoke(callableMemberDescriptor).getAnnotations()), qualifierApplicabilityType);
    }

    private final SignatureParts partsForValueParameter(CallableMemberDescriptor callableMemberDescriptor, ValueParameterDescriptor valueParameterDescriptor, LazyJavaResolverContext lazyJavaResolverContext, Function1<? super CallableMemberDescriptor, ? extends KotlinType> function1) {
        LazyJavaResolverContext lazyJavaResolverContext2;
        LazyJavaResolverContext copyWithNewDefaultTypeQualifiers;
        if (valueParameterDescriptor != null && (copyWithNewDefaultTypeQualifiers = ContextKt.copyWithNewDefaultTypeQualifiers(lazyJavaResolverContext, valueParameterDescriptor.getAnnotations())) != null) {
            lazyJavaResolverContext2 = copyWithNewDefaultTypeQualifiers;
        } else {
            lazyJavaResolverContext2 = lazyJavaResolverContext;
        }
        return parts(callableMemberDescriptor, valueParameterDescriptor, false, lazyJavaResolverContext2, AnnotationTypeQualifierResolver.QualifierApplicabilityType.VALUE_PARAMETER, function1);
    }

    public final NullabilityQualifierWithMigrationStatus extractNullability(AnnotationDescriptor annotationDescriptor) {
        NullabilityQualifierWithMigrationStatus extractNullabilityFromKnownAnnotations;
        NullabilityQualifierWithMigrationStatus extractNullabilityFromKnownAnnotations2 = extractNullabilityFromKnownAnnotations(annotationDescriptor);
        if (extractNullabilityFromKnownAnnotations2 != null) {
            return extractNullabilityFromKnownAnnotations2;
        }
        AnnotationDescriptor resolveTypeQualifierAnnotation = this.annotationTypeQualifierResolver.resolveTypeQualifierAnnotation(annotationDescriptor);
        if (resolveTypeQualifierAnnotation == null) {
            return null;
        }
        ReportLevel resolveJsr305AnnotationState = this.annotationTypeQualifierResolver.resolveJsr305AnnotationState(annotationDescriptor);
        if (resolveJsr305AnnotationState.isIgnore() || (extractNullabilityFromKnownAnnotations = extractNullabilityFromKnownAnnotations(resolveTypeQualifierAnnotation)) == null) {
            return null;
        }
        return NullabilityQualifierWithMigrationStatus.copy$default(extractNullabilityFromKnownAnnotations, null, resolveJsr305AnnotationState.isWarning(), 1, null);
    }
}
