package kotlin.reflect.jvm.internal.impl.types.typeUtil;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.NoWhenBranchMatchedException;
import kotlin._Assertions;
import kotlin.collections.CollectionsKt__IterablesKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.builtins.KotlinBuiltIns;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassKind;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassifierDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.TypeAliasDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.TypeParameterDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.Annotations;
import kotlin.reflect.jvm.internal.impl.types.FlexibleType;
import kotlin.reflect.jvm.internal.impl.types.KotlinType;
import kotlin.reflect.jvm.internal.impl.types.KotlinTypeFactory;
import kotlin.reflect.jvm.internal.impl.types.SimpleType;
import kotlin.reflect.jvm.internal.impl.types.StarProjectionImpl;
import kotlin.reflect.jvm.internal.impl.types.TypeProjection;
import kotlin.reflect.jvm.internal.impl.types.TypeProjectionImpl;
import kotlin.reflect.jvm.internal.impl.types.TypeSubstitutionKt;
import kotlin.reflect.jvm.internal.impl.types.TypeUtils;
import kotlin.reflect.jvm.internal.impl.types.TypeWithEnhancementKt;
import kotlin.reflect.jvm.internal.impl.types.UnwrappedType;
import kotlin.reflect.jvm.internal.impl.types.Variance;
import kotlin.reflect.jvm.internal.impl.types.checker.KotlinTypeChecker;
import kotlin.reflect.jvm.internal.impl.types.checker.NewCapturedType;
import kotlin.reflect.jvm.internal.impl.types.checker.NewTypeVariableConstructor;
/* loaded from: classes2.dex */
public final class TypeUtilsKt {
    public static final TypeProjection asTypeProjection(KotlinType kotlinType) {
        return new TypeProjectionImpl(kotlinType);
    }

    public static final boolean canHaveUndefinedNullability(UnwrappedType unwrappedType) {
        if (!(unwrappedType.getConstructor() instanceof NewTypeVariableConstructor) && !(unwrappedType.getConstructor().mo2105getDeclarationDescriptor() instanceof TypeParameterDescriptor) && !(unwrappedType instanceof NewCapturedType)) {
            return false;
        }
        return true;
    }

    public static final boolean containsTypeAliasParameters(KotlinType kotlinType) {
        return contains(kotlinType, new Function1<UnwrappedType, Boolean>() { // from class: kotlin.reflect.jvm.internal.impl.types.typeUtil.TypeUtilsKt$containsTypeAliasParameters$1
            /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
            /* JADX DEBUG: Return type fixed from 'java.lang.Object' to match base method */
            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Boolean invoke(UnwrappedType unwrappedType) {
                return Boolean.valueOf(invoke2(unwrappedType));
            }

            /* renamed from: invoke  reason: avoid collision after fix types in other method */
            public final boolean invoke2(UnwrappedType unwrappedType) {
                ClassifierDescriptor mo2105getDeclarationDescriptor = unwrappedType.getConstructor().mo2105getDeclarationDescriptor();
                if (mo2105getDeclarationDescriptor != null) {
                    return TypeUtilsKt.isTypeAliasParameter(mo2105getDeclarationDescriptor);
                }
                return false;
            }
        });
    }

    public static final KotlinBuiltIns getBuiltIns(KotlinType kotlinType) {
        KotlinBuiltIns builtIns = kotlinType.getConstructor().getBuiltIns();
        Intrinsics.checkExpressionValueIsNotNull(builtIns, "constructor.builtIns");
        return builtIns;
    }

    public static final boolean isTypeAliasParameter(ClassifierDescriptor classifierDescriptor) {
        if ((classifierDescriptor instanceof TypeParameterDescriptor) && (((TypeParameterDescriptor) classifierDescriptor).getContainingDeclaration() instanceof TypeAliasDescriptor)) {
            return true;
        }
        return false;
    }

    public static final boolean isTypeParameter(KotlinType kotlinType) {
        return TypeUtils.isTypeParameter(kotlinType);
    }

    public static final KotlinType makeNotNullable(KotlinType kotlinType) {
        KotlinType makeNotNullable = TypeUtils.makeNotNullable(kotlinType);
        Intrinsics.checkExpressionValueIsNotNull(makeNotNullable, "TypeUtils.makeNotNullable(this)");
        return makeNotNullable;
    }

    public static final KotlinType makeNullable(KotlinType kotlinType) {
        KotlinType makeNullable = TypeUtils.makeNullable(kotlinType);
        Intrinsics.checkExpressionValueIsNotNull(makeNullable, "TypeUtils.makeNullable(this)");
        return makeNullable;
    }

    public static final boolean requiresTypeAliasExpansion(KotlinType kotlinType) {
        return contains(kotlinType, new Function1<UnwrappedType, Boolean>() { // from class: kotlin.reflect.jvm.internal.impl.types.typeUtil.TypeUtilsKt$requiresTypeAliasExpansion$1
            /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
            /* JADX DEBUG: Return type fixed from 'java.lang.Object' to match base method */
            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Boolean invoke(UnwrappedType unwrappedType) {
                return Boolean.valueOf(invoke2(unwrappedType));
            }

            /* renamed from: invoke  reason: avoid collision after fix types in other method */
            public final boolean invoke2(UnwrappedType unwrappedType) {
                ClassifierDescriptor mo2105getDeclarationDescriptor = unwrappedType.getConstructor().mo2105getDeclarationDescriptor();
                if (mo2105getDeclarationDescriptor == null) {
                    return false;
                }
                if (!(mo2105getDeclarationDescriptor instanceof TypeAliasDescriptor) && !(mo2105getDeclarationDescriptor instanceof TypeParameterDescriptor)) {
                    return false;
                }
                return true;
            }
        });
    }

    public static final boolean contains(KotlinType kotlinType, Function1<? super UnwrappedType, Boolean> function1) {
        return TypeUtils.contains(kotlinType, function1);
    }

    public static final boolean isSubtypeOf(KotlinType kotlinType, KotlinType kotlinType2) {
        return KotlinTypeChecker.DEFAULT.isSubtypeOf(kotlinType, kotlinType2);
    }

    public static final KotlinType replaceAnnotations(KotlinType kotlinType, Annotations annotations) {
        if (kotlinType.getAnnotations().isEmpty() && annotations.isEmpty()) {
            return kotlinType;
        }
        return kotlinType.unwrap().replaceAnnotations(annotations);
    }

    public static final TypeProjection createProjection(KotlinType kotlinType, Variance variance, TypeParameterDescriptor typeParameterDescriptor) {
        Variance variance2;
        if (typeParameterDescriptor != null) {
            variance2 = typeParameterDescriptor.getVariance();
        } else {
            variance2 = null;
        }
        if (variance2 == variance) {
            variance = Variance.INVARIANT;
        }
        return new TypeProjectionImpl(variance, kotlinType);
    }

    /*  JADX ERROR: IF instruction can be used only in fallback mode
        jadx.core.utils.exceptions.CodegenException: IF instruction can be used only in fallback mode
        	at jadx.core.codegen.InsnGen.fallbackOnlyInsn(InsnGen.java:686)
        	at jadx.core.codegen.InsnGen.makeInsnBody(InsnGen.java:544)
        	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:302)
        	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:272)
        	at jadx.core.codegen.RegionGen.makeSimpleBlock(RegionGen.java:91)
        	at jadx.core.dex.nodes.IBlock.generate(IBlock.java:15)
        	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:63)
        	at jadx.core.dex.regions.Region.generate(Region.java:35)
        	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:63)
        	at jadx.core.codegen.RegionGen.makeRegionIndent(RegionGen.java:80)
        	at jadx.core.codegen.RegionGen.makeLoop(RegionGen.java:175)
        	at jadx.core.dex.regions.loops.LoopRegion.generate(LoopRegion.java:171)
        	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:63)
        	at jadx.core.dex.regions.Region.generate(Region.java:35)
        	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:63)
        	at jadx.core.dex.regions.Region.generate(Region.java:35)
        	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:63)
        	at jadx.core.dex.regions.Region.generate(Region.java:35)
        	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:63)
        	at jadx.core.codegen.MethodGen.addRegionInsns(MethodGen.java:296)
        	at jadx.core.codegen.MethodGen.addInstructions(MethodGen.java:275)
        	at jadx.core.codegen.ClassGen.addMethodCode(ClassGen.java:377)
        	at jadx.core.codegen.ClassGen.addMethod(ClassGen.java:306)
        	at jadx.core.codegen.ClassGen.lambda$addInnerClsAndMethods$2(ClassGen.java:272)
        	at java.base/java.util.stream.ForEachOps$ForEachOp$OfRef.accept(ForEachOps.java:184)
        	at java.base/java.util.ArrayList.forEach(ArrayList.java:1596)
        	at java.base/java.util.stream.SortedOps$RefSortingSink.end(SortedOps.java:395)
        	at java.base/java.util.stream.Sink$ChainedReference.end(Sink.java:261)
        */
    /* JADX WARN: Code restructure failed: missing block: B:23:0x006c, code lost:
        r4 = r3;
     */
    /* JADX WARN: Removed duplicated region for block: B:11:0x003f  */
    /* JADX WARN: Removed duplicated region for block: B:30:0x006d A[EDGE_INSN: B:30:0x006d->B:24:0x006d ?: BREAK  , SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final kotlin.reflect.jvm.internal.impl.types.KotlinType getRepresentativeUpperBound(kotlin.reflect.jvm.internal.impl.descriptors.TypeParameterDescriptor r8) {
        /*
            java.util.List r0 = r8.getUpperBounds()
            java.lang.String r1 = "upperBounds"
            kotlin.jvm.internal.Intrinsics.checkExpressionValueIsNotNull(r0, r1)
            boolean r0 = r0.isEmpty()
            r2 = 1
            r0 = r0 ^ r2
            boolean r3 = kotlin._Assertions.ENABLED
            if (r3 == 0) goto L2d
            if (r0 == 0) goto L16
            goto L2d
        L16:
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            java.lang.String r1 = "Upper bounds should not be empty: "
            r0.append(r1)
            r0.append(r8)
            java.lang.String r8 = r0.toString()
            java.lang.AssertionError r0 = new java.lang.AssertionError
            r0.<init>(r8)
            throw r0
        L2d:
            java.util.List r0 = r8.getUpperBounds()
            kotlin.jvm.internal.Intrinsics.checkExpressionValueIsNotNull(r0, r1)
            java.util.Iterator r0 = r0.iterator()
        L38:
            boolean r3 = r0.hasNext()
            r4 = 0
            if (r3 == 0) goto L6d
            java.lang.Object r3 = r0.next()
            r5 = r3
            kotlin.reflect.jvm.internal.impl.types.KotlinType r5 = (kotlin.reflect.jvm.internal.impl.types.KotlinType) r5
            kotlin.reflect.jvm.internal.impl.types.TypeConstructor r5 = r5.getConstructor()
            kotlin.reflect.jvm.internal.impl.descriptors.ClassifierDescriptor r5 = r5.mo2105getDeclarationDescriptor()
            boolean r6 = r5 instanceof kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor
            if (r6 != 0) goto L53
            goto L54
        L53:
            r4 = r5
        L54:
            kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor r4 = (kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor) r4
            r5 = 0
            if (r4 == 0) goto L6a
            kotlin.reflect.jvm.internal.impl.descriptors.ClassKind r6 = r4.getKind()
            kotlin.reflect.jvm.internal.impl.descriptors.ClassKind r7 = kotlin.reflect.jvm.internal.impl.descriptors.ClassKind.INTERFACE
            if (r6 == r7) goto L6a
            kotlin.reflect.jvm.internal.impl.descriptors.ClassKind r4 = r4.getKind()
            kotlin.reflect.jvm.internal.impl.descriptors.ClassKind r6 = kotlin.reflect.jvm.internal.impl.descriptors.ClassKind.ANNOTATION_CLASS
            if (r4 == r6) goto L6a
            r5 = 1
        L6a:
            if (r5 == 0) goto L38
            r4 = r3
        L6d:
            kotlin.reflect.jvm.internal.impl.types.KotlinType r4 = (kotlin.reflect.jvm.internal.impl.types.KotlinType) r4
            if (r4 == 0) goto L72
            goto L85
        L72:
            java.util.List r8 = r8.getUpperBounds()
            kotlin.jvm.internal.Intrinsics.checkExpressionValueIsNotNull(r8, r1)
            java.lang.Object r8 = kotlin.collections.CollectionsKt___CollectionsKt.first(r8)
            java.lang.String r0 = "upperBounds.first()"
            kotlin.jvm.internal.Intrinsics.checkExpressionValueIsNotNull(r8, r0)
            r4 = r8
            kotlin.reflect.jvm.internal.impl.types.KotlinType r4 = (kotlin.reflect.jvm.internal.impl.types.KotlinType) r4
        L85:
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlin.reflect.jvm.internal.impl.types.typeUtil.TypeUtilsKt.getRepresentativeUpperBound(kotlin.reflect.jvm.internal.impl.descriptors.TypeParameterDescriptor):kotlin.reflect.jvm.internal.impl.types.KotlinType");
    }

    /* JADX DEBUG: Type inference failed for r2v2. Raw type applied. Possible types: java.util.Iterator<T>, java.util.Iterator */
    /* JADX DEBUG: Type inference failed for r2v4. Raw type applied. Possible types: java.util.Iterator<T>, java.util.Iterator */
    /* JADX DEBUG: Type inference failed for r6v18. Raw type applied. Possible types: java.util.Iterator<T>, java.util.Iterator */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v10, types: [kotlin.reflect.jvm.internal.impl.types.UnwrappedType] */
    public static final KotlinType replaceArgumentsWithStarProjections(KotlinType kotlinType) {
        SimpleType simpleType;
        UnwrappedType unwrap = kotlinType.unwrap();
        if (unwrap instanceof FlexibleType) {
            FlexibleType flexibleType = (FlexibleType) unwrap;
            SimpleType lowerBound = flexibleType.getLowerBound();
            if (!lowerBound.getConstructor().getParameters().isEmpty() && lowerBound.getConstructor().mo2105getDeclarationDescriptor() != null) {
                List<TypeParameterDescriptor> parameters = lowerBound.getConstructor().getParameters();
                Intrinsics.checkExpressionValueIsNotNull(parameters, "constructor.parameters");
                ArrayList arrayList = new ArrayList(CollectionsKt__IterablesKt.collectionSizeOrDefault(parameters, 10));
                for (TypeParameterDescriptor typeParameterDescriptor : parameters) {
                    arrayList.add(new StarProjectionImpl(typeParameterDescriptor));
                }
                lowerBound = TypeSubstitutionKt.replace$default(lowerBound, (List) arrayList, (Annotations) null, 2, (Object) null);
            }
            SimpleType upperBound = flexibleType.getUpperBound();
            if (!upperBound.getConstructor().getParameters().isEmpty() && upperBound.getConstructor().mo2105getDeclarationDescriptor() != null) {
                List<TypeParameterDescriptor> parameters2 = upperBound.getConstructor().getParameters();
                Intrinsics.checkExpressionValueIsNotNull(parameters2, "constructor.parameters");
                ArrayList arrayList2 = new ArrayList(CollectionsKt__IterablesKt.collectionSizeOrDefault(parameters2, 10));
                for (TypeParameterDescriptor typeParameterDescriptor2 : parameters2) {
                    arrayList2.add(new StarProjectionImpl(typeParameterDescriptor2));
                }
                upperBound = TypeSubstitutionKt.replace$default(upperBound, (List) arrayList2, (Annotations) null, 2, (Object) null);
            }
            simpleType = KotlinTypeFactory.flexibleType(lowerBound, upperBound);
        } else if (unwrap instanceof SimpleType) {
            SimpleType simpleType2 = (SimpleType) unwrap;
            boolean isEmpty = simpleType2.getConstructor().getParameters().isEmpty();
            simpleType = simpleType2;
            if (!isEmpty) {
                ClassifierDescriptor mo2105getDeclarationDescriptor = simpleType2.getConstructor().mo2105getDeclarationDescriptor();
                simpleType = simpleType2;
                if (mo2105getDeclarationDescriptor != null) {
                    List<TypeParameterDescriptor> parameters3 = simpleType2.getConstructor().getParameters();
                    Intrinsics.checkExpressionValueIsNotNull(parameters3, "constructor.parameters");
                    ArrayList arrayList3 = new ArrayList(CollectionsKt__IterablesKt.collectionSizeOrDefault(parameters3, 10));
                    for (TypeParameterDescriptor typeParameterDescriptor3 : parameters3) {
                        arrayList3.add(new StarProjectionImpl(typeParameterDescriptor3));
                    }
                    simpleType = TypeSubstitutionKt.replace$default(simpleType2, (List) arrayList3, (Annotations) null, 2, (Object) null);
                }
            }
        } else {
            throw new NoWhenBranchMatchedException();
        }
        return TypeWithEnhancementKt.inheritEnhancement(simpleType, unwrap);
    }
}
