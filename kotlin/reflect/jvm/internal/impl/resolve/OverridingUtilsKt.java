package kotlin.reflect.jvm.internal.impl.resolve;

import java.util.Collection;
import java.util.LinkedList;
import java.util.List;
import kotlin.Unit;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.descriptors.CallableDescriptor;
import kotlin.reflect.jvm.internal.impl.utils.SmartSet;
/* loaded from: classes9.dex */
public final class OverridingUtilsKt {
    public static final <D extends CallableDescriptor> void retainMostSpecificInEachOverridableGroup(Collection<D> collection) {
        Collection<?> selectMostSpecificInEachOverridableGroup = selectMostSpecificInEachOverridableGroup(collection, new Function1<D, D>() { // from class: kotlin.reflect.jvm.internal.impl.resolve.OverridingUtilsKt$retainMostSpecificInEachOverridableGroup$newResult$1
            /* JADX DEBUG: Method merged with bridge method */
            /* JADX WARN: Incorrect return type in method signature: (TD;)TD; */
            @Override // kotlin.jvm.functions.Function1
            public final CallableDescriptor invoke(CallableDescriptor callableDescriptor) {
                return callableDescriptor;
            }
        });
        if (collection.size() == selectMostSpecificInEachOverridableGroup.size()) {
            return;
        }
        collection.retainAll(selectMostSpecificInEachOverridableGroup);
    }

    /* JADX DEBUG: Multi-variable search result rejected for r8v0, resolved type: java.util.Collection<? extends H> */
    /* JADX WARN: Multi-variable type inference failed */
    public static final <H> Collection<H> selectMostSpecificInEachOverridableGroup(Collection<? extends H> collection, Function1<? super H, ? extends CallableDescriptor> function1) {
        if (collection.size() <= 1) {
            return collection;
        }
        LinkedList linkedList = new LinkedList(collection);
        SmartSet create = SmartSet.Companion.create();
        while (!linkedList.isEmpty()) {
            Object first = CollectionsKt___CollectionsKt.first((List<? extends Object>) linkedList);
            final SmartSet create2 = SmartSet.Companion.create();
            Collection<? super H> extractMembersOverridableInBothWays = OverridingUtil.extractMembersOverridableInBothWays(first, linkedList, function1, new Function1<H, Unit>() { // from class: kotlin.reflect.jvm.internal.impl.resolve.OverridingUtilsKt$selectMostSpecificInEachOverridableGroup$overridableGroup$1
                {
                    super(1);
                }

                /* JADX DEBUG: Multi-variable search result rejected for r1v0, resolved type: java.lang.Object */
                /* JADX DEBUG: Return type fixed from 'java.lang.Object' to match base method */
                /* JADX WARN: Multi-variable type inference failed */
                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(Object obj) {
                    invoke2((OverridingUtilsKt$selectMostSpecificInEachOverridableGroup$overridableGroup$1<H>) obj);
                    return Unit.INSTANCE;
                }

                /* JADX DEBUG: Possible override for method kotlin.jvm.functions.Function1.invoke(Ljava/lang/Object;)Ljava/lang/Object; */
                /* renamed from: invoke  reason: avoid collision after fix types in other method */
                public final void invoke2(H it) {
                    SmartSet smartSet = SmartSet.this;
                    Intrinsics.checkExpressionValueIsNotNull(it, "it");
                    smartSet.add(it);
                }
            });
            Intrinsics.checkExpressionValueIsNotNull(extractMembersOverridableInBothWays, "OverridingUtil.extractMe…nflictedHandles.add(it) }");
            if (extractMembersOverridableInBothWays.size() == 1 && create2.isEmpty()) {
                Object single = CollectionsKt___CollectionsKt.single(extractMembersOverridableInBothWays);
                Intrinsics.checkExpressionValueIsNotNull(single, "overridableGroup.single()");
                create.add(single);
            } else {
                Object obj = (Object) OverridingUtil.selectMostSpecificMember(extractMembersOverridableInBothWays, function1);
                Intrinsics.checkExpressionValueIsNotNull(obj, "OverridingUtil.selectMos…roup, descriptorByHandle)");
                CallableDescriptor invoke = function1.invoke(obj);
                for (Object it : extractMembersOverridableInBothWays) {
                    Intrinsics.checkExpressionValueIsNotNull(it, "it");
                    if (!OverridingUtil.isMoreSpecific(invoke, function1.invoke(it))) {
                        create2.add(it);
                    }
                }
                if (!create2.isEmpty()) {
                    create.addAll(create2);
                }
                create.add(obj);
            }
        }
        return create;
    }
}
