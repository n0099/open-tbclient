package kotlin.reflect.jvm.internal.impl.types.checker;

import java.util.ArrayList;
import java.util.List;
import kotlin.NoWhenBranchMatchedException;
import kotlin.collections.CollectionsKt__IterablesKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.types.DynamicTypesKt;
import kotlin.reflect.jvm.internal.impl.types.ErrorUtils;
import kotlin.reflect.jvm.internal.impl.types.FlexibleType;
import kotlin.reflect.jvm.internal.impl.types.FlexibleTypesKt;
import kotlin.reflect.jvm.internal.impl.types.KotlinTypeFactory;
import kotlin.reflect.jvm.internal.impl.types.KotlinTypeKt;
import kotlin.reflect.jvm.internal.impl.types.SimpleType;
import kotlin.reflect.jvm.internal.impl.types.UnwrappedType;
/* loaded from: classes2.dex */
public final class IntersectionTypeKt {
    public static final UnwrappedType intersectTypes(List<? extends UnwrappedType> list) {
        SimpleType lowerBound;
        int size = list.size();
        if (size != 0) {
            if (size != 1) {
                ArrayList arrayList = new ArrayList(CollectionsKt__IterablesKt.collectionSizeOrDefault(list, 10));
                boolean z = false;
                boolean z2 = false;
                for (UnwrappedType unwrappedType : list) {
                    if (!z && !KotlinTypeKt.isError(unwrappedType)) {
                        z = false;
                    } else {
                        z = true;
                    }
                    if (unwrappedType instanceof SimpleType) {
                        lowerBound = (SimpleType) unwrappedType;
                    } else if (unwrappedType instanceof FlexibleType) {
                        if (DynamicTypesKt.isDynamic(unwrappedType)) {
                            return unwrappedType;
                        }
                        lowerBound = ((FlexibleType) unwrappedType).getLowerBound();
                        z2 = true;
                    } else {
                        throw new NoWhenBranchMatchedException();
                    }
                    arrayList.add(lowerBound);
                }
                if (z) {
                    SimpleType createErrorType = ErrorUtils.createErrorType("Intersection of error types: " + list);
                    Intrinsics.checkExpressionValueIsNotNull(createErrorType, "ErrorUtils.createErrorTy… of error types: $types\")");
                    return createErrorType;
                } else if (!z2) {
                    return TypeIntersector.INSTANCE.intersectTypes$descriptors(arrayList);
                } else {
                    ArrayList arrayList2 = new ArrayList(CollectionsKt__IterablesKt.collectionSizeOrDefault(list, 10));
                    for (UnwrappedType unwrappedType2 : list) {
                        arrayList2.add(FlexibleTypesKt.upperIfFlexible(unwrappedType2));
                    }
                    return KotlinTypeFactory.flexibleType(TypeIntersector.INSTANCE.intersectTypes$descriptors(arrayList), TypeIntersector.INSTANCE.intersectTypes$descriptors(arrayList2));
                }
            }
            return (UnwrappedType) CollectionsKt___CollectionsKt.single((List<? extends Object>) list);
        }
        throw new IllegalStateException("Expected some types".toString());
    }
}
