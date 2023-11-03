package kotlin.reflect.jvm.internal.impl.types.checker;

import java.util.ArrayList;
import java.util.Collection;
import kotlin.NoWhenBranchMatchedException;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.CollectionsKt__IterablesKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.resolve.OverridingUtil;
import kotlin.reflect.jvm.internal.impl.resolve.calls.inference.CapturedTypeConstructorImpl;
import kotlin.reflect.jvm.internal.impl.resolve.constants.IntegerValueTypeConstructor;
import kotlin.reflect.jvm.internal.impl.types.AbstractTypeChecker;
import kotlin.reflect.jvm.internal.impl.types.FlexibleType;
import kotlin.reflect.jvm.internal.impl.types.IntersectionTypeConstructor;
import kotlin.reflect.jvm.internal.impl.types.KotlinType;
import kotlin.reflect.jvm.internal.impl.types.KotlinTypeFactory;
import kotlin.reflect.jvm.internal.impl.types.SimpleType;
import kotlin.reflect.jvm.internal.impl.types.TypeConstructor;
import kotlin.reflect.jvm.internal.impl.types.TypeProjection;
import kotlin.reflect.jvm.internal.impl.types.TypeUtils;
import kotlin.reflect.jvm.internal.impl.types.TypeWithEnhancementKt;
import kotlin.reflect.jvm.internal.impl.types.UnwrappedType;
import kotlin.reflect.jvm.internal.impl.types.Variance;
import kotlin.reflect.jvm.internal.impl.types.model.CaptureStatus;
import kotlin.reflect.jvm.internal.impl.types.typeUtil.TypeUtilsKt;
/* loaded from: classes2.dex */
public final class NewKotlinTypeCheckerImpl implements NewKotlinTypeChecker {
    public final KotlinTypeRefiner kotlinTypeRefiner;
    public final OverridingUtil overridingUtil;

    public NewKotlinTypeCheckerImpl(KotlinTypeRefiner kotlinTypeRefiner) {
        this.kotlinTypeRefiner = kotlinTypeRefiner;
        OverridingUtil createWithTypeRefiner = OverridingUtil.createWithTypeRefiner(getKotlinTypeRefiner());
        Intrinsics.checkExpressionValueIsNotNull(createWithTypeRefiner, "OverridingUtil.createWit…efiner(kotlinTypeRefiner)");
        this.overridingUtil = createWithTypeRefiner;
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.checker.KotlinTypeChecker
    public boolean equalTypes(KotlinType kotlinType, KotlinType kotlinType2) {
        return equalTypes(new ClassicTypeCheckerContext(false, false, false, getKotlinTypeRefiner(), 6, null), kotlinType.unwrap(), kotlinType2.unwrap());
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.checker.KotlinTypeChecker
    public boolean isSubtypeOf(KotlinType kotlinType, KotlinType kotlinType2) {
        return isSubtypeOf(new ClassicTypeCheckerContext(true, false, false, getKotlinTypeRefiner(), 6, null), kotlinType.unwrap(), kotlinType2.unwrap());
    }

    public final boolean equalTypes(ClassicTypeCheckerContext classicTypeCheckerContext, UnwrappedType unwrappedType, UnwrappedType unwrappedType2) {
        return AbstractTypeChecker.INSTANCE.equalTypes(classicTypeCheckerContext, unwrappedType, unwrappedType2);
    }

    public final boolean isSubtypeOf(ClassicTypeCheckerContext classicTypeCheckerContext, UnwrappedType unwrappedType, UnwrappedType unwrappedType2) {
        return AbstractTypeChecker.INSTANCE.isSubtypeOf(classicTypeCheckerContext, unwrappedType, unwrappedType2);
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.checker.NewKotlinTypeChecker
    public KotlinTypeRefiner getKotlinTypeRefiner() {
        return this.kotlinTypeRefiner;
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.checker.NewKotlinTypeChecker
    public OverridingUtil getOverridingUtil() {
        return this.overridingUtil;
    }

    public final SimpleType transformToNewType(SimpleType simpleType) {
        KotlinType type;
        TypeConstructor constructor = simpleType.getConstructor();
        boolean z = true;
        IntersectionTypeConstructor intersectionTypeConstructor = null;
        r3 = null;
        UnwrappedType unwrappedType = null;
        boolean z2 = false;
        if (constructor instanceof CapturedTypeConstructorImpl) {
            CapturedTypeConstructorImpl capturedTypeConstructorImpl = (CapturedTypeConstructorImpl) constructor;
            TypeProjection projection = capturedTypeConstructorImpl.getProjection();
            if (projection.getProjectionKind() != Variance.IN_VARIANCE) {
                z = false;
            }
            if (!z) {
                projection = null;
            }
            if (projection != null && (type = projection.getType()) != null) {
                unwrappedType = type.unwrap();
            }
            UnwrappedType unwrappedType2 = unwrappedType;
            if (capturedTypeConstructorImpl.getNewTypeConstructor() == null) {
                TypeProjection projection2 = capturedTypeConstructorImpl.getProjection();
                Collection<KotlinType> mo2111getSupertypes = capturedTypeConstructorImpl.mo2111getSupertypes();
                ArrayList arrayList = new ArrayList(CollectionsKt__IterablesKt.collectionSizeOrDefault(mo2111getSupertypes, 10));
                for (KotlinType kotlinType : mo2111getSupertypes) {
                    arrayList.add(kotlinType.unwrap());
                }
                capturedTypeConstructorImpl.setNewTypeConstructor(new NewCapturedTypeConstructor(projection2, arrayList, null, 4, null));
            }
            CaptureStatus captureStatus = CaptureStatus.FOR_SUBTYPING;
            NewCapturedTypeConstructor newTypeConstructor = capturedTypeConstructorImpl.getNewTypeConstructor();
            if (newTypeConstructor == null) {
                Intrinsics.throwNpe();
            }
            return new NewCapturedType(captureStatus, newTypeConstructor, unwrappedType2, simpleType.getAnnotations(), simpleType.isMarkedNullable());
        } else if (constructor instanceof IntegerValueTypeConstructor) {
            Collection<KotlinType> mo2111getSupertypes2 = ((IntegerValueTypeConstructor) constructor).mo2111getSupertypes();
            ArrayList arrayList2 = new ArrayList(CollectionsKt__IterablesKt.collectionSizeOrDefault(mo2111getSupertypes2, 10));
            for (KotlinType kotlinType2 : mo2111getSupertypes2) {
                arrayList2.add(TypeUtils.makeNullableAsSpecified(kotlinType2, simpleType.isMarkedNullable()));
            }
            return KotlinTypeFactory.simpleTypeWithNonTrivialMemberScope(simpleType.getAnnotations(), new IntersectionTypeConstructor(arrayList2), CollectionsKt__CollectionsKt.emptyList(), false, simpleType.getMemberScope());
        } else if ((constructor instanceof IntersectionTypeConstructor) && simpleType.isMarkedNullable()) {
            IntersectionTypeConstructor intersectionTypeConstructor2 = (IntersectionTypeConstructor) constructor;
            Collection<KotlinType> mo2111getSupertypes3 = intersectionTypeConstructor2.mo2111getSupertypes();
            ArrayList arrayList3 = new ArrayList(CollectionsKt__IterablesKt.collectionSizeOrDefault(mo2111getSupertypes3, 10));
            for (KotlinType kotlinType3 : mo2111getSupertypes3) {
                arrayList3.add(TypeUtilsKt.makeNullable(kotlinType3));
                z2 = true;
            }
            if (z2) {
                intersectionTypeConstructor = new IntersectionTypeConstructor(arrayList3);
            }
            if (intersectionTypeConstructor != null) {
                intersectionTypeConstructor2 = intersectionTypeConstructor;
            }
            return intersectionTypeConstructor2.createType();
        } else {
            return simpleType;
        }
    }

    public UnwrappedType transformToNewType(UnwrappedType unwrappedType) {
        UnwrappedType flexibleType;
        if (unwrappedType instanceof SimpleType) {
            flexibleType = transformToNewType((SimpleType) unwrappedType);
        } else if (unwrappedType instanceof FlexibleType) {
            FlexibleType flexibleType2 = (FlexibleType) unwrappedType;
            SimpleType transformToNewType = transformToNewType(flexibleType2.getLowerBound());
            SimpleType transformToNewType2 = transformToNewType(flexibleType2.getUpperBound());
            if (transformToNewType == flexibleType2.getLowerBound() && transformToNewType2 == flexibleType2.getUpperBound()) {
                flexibleType = unwrappedType;
            } else {
                flexibleType = KotlinTypeFactory.flexibleType(transformToNewType, transformToNewType2);
            }
        } else {
            throw new NoWhenBranchMatchedException();
        }
        return TypeWithEnhancementKt.inheritEnhancement(flexibleType, unwrappedType);
    }
}
