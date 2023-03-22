package kotlin.reflect.jvm.internal.impl.types;

import java.util.Collection;
import java.util.List;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__CollectionsJVMKt;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;
import kotlin.reflect.jvm.internal.impl.types.AbstractTypeConstructor;
/* loaded from: classes9.dex */
public final class AbstractTypeConstructor$supertypes$3 extends Lambda implements Function1<AbstractTypeConstructor.Supertypes, Unit> {
    public final /* synthetic */ AbstractTypeConstructor this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AbstractTypeConstructor$supertypes$3(AbstractTypeConstructor abstractTypeConstructor) {
        super(1);
        this.this$0 = abstractTypeConstructor;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    /* JADX DEBUG: Return type fixed from 'java.lang.Object' to match base method */
    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(AbstractTypeConstructor.Supertypes supertypes) {
        invoke2(supertypes);
        return Unit.INSTANCE;
    }

    /* renamed from: invoke  reason: avoid collision after fix types in other method */
    public final void invoke2(AbstractTypeConstructor.Supertypes supertypes) {
        Collection findLoopsInSupertypesAndDisconnect = this.this$0.getSupertypeLoopChecker().findLoopsInSupertypesAndDisconnect(this.this$0, supertypes.getAllSupertypes(), new Function1<TypeConstructor, Collection<? extends KotlinType>>() { // from class: kotlin.reflect.jvm.internal.impl.types.AbstractTypeConstructor$supertypes$3$resultWithoutCycles$1
            {
                super(1);
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // kotlin.jvm.functions.Function1
            public final Collection<KotlinType> invoke(TypeConstructor typeConstructor) {
                Collection<KotlinType> computeNeighbours;
                computeNeighbours = AbstractTypeConstructor$supertypes$3.this.this$0.computeNeighbours(typeConstructor, false);
                return computeNeighbours;
            }
        }, new Function1<KotlinType, Unit>() { // from class: kotlin.reflect.jvm.internal.impl.types.AbstractTypeConstructor$supertypes$3$resultWithoutCycles$2
            {
                super(1);
            }

            /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
            /* JADX DEBUG: Return type fixed from 'java.lang.Object' to match base method */
            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(KotlinType kotlinType) {
                invoke2(kotlinType);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke  reason: avoid collision after fix types in other method */
            public final void invoke2(KotlinType kotlinType) {
                AbstractTypeConstructor$supertypes$3.this.this$0.reportSupertypeLoopError(kotlinType);
            }
        });
        Collection collection = null;
        if (findLoopsInSupertypesAndDisconnect.isEmpty()) {
            KotlinType defaultSupertypeIfEmpty = this.this$0.defaultSupertypeIfEmpty();
            if (defaultSupertypeIfEmpty != null) {
                findLoopsInSupertypesAndDisconnect = CollectionsKt__CollectionsJVMKt.listOf(defaultSupertypeIfEmpty);
            } else {
                findLoopsInSupertypesAndDisconnect = null;
            }
            if (findLoopsInSupertypesAndDisconnect == null) {
                findLoopsInSupertypesAndDisconnect = CollectionsKt__CollectionsKt.emptyList();
            }
        }
        this.this$0.getSupertypeLoopChecker().findLoopsInSupertypesAndDisconnect(this.this$0, findLoopsInSupertypesAndDisconnect, new Function1<TypeConstructor, Collection<? extends KotlinType>>() { // from class: kotlin.reflect.jvm.internal.impl.types.AbstractTypeConstructor$supertypes$3.2
            {
                super(1);
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // kotlin.jvm.functions.Function1
            public final Collection<KotlinType> invoke(TypeConstructor typeConstructor) {
                Collection<KotlinType> computeNeighbours;
                computeNeighbours = AbstractTypeConstructor$supertypes$3.this.this$0.computeNeighbours(typeConstructor, true);
                return computeNeighbours;
            }
        }, new Function1<KotlinType, Unit>() { // from class: kotlin.reflect.jvm.internal.impl.types.AbstractTypeConstructor$supertypes$3.3
            {
                super(1);
            }

            /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
            /* JADX DEBUG: Return type fixed from 'java.lang.Object' to match base method */
            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(KotlinType kotlinType) {
                invoke2(kotlinType);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke  reason: avoid collision after fix types in other method */
            public final void invoke2(KotlinType kotlinType) {
                AbstractTypeConstructor$supertypes$3.this.this$0.reportScopesLoopError(kotlinType);
            }
        });
        if (findLoopsInSupertypesAndDisconnect instanceof List) {
            collection = findLoopsInSupertypesAndDisconnect;
        }
        List<? extends KotlinType> list = (List) collection;
        if (list == null) {
            list = CollectionsKt___CollectionsKt.toList(findLoopsInSupertypesAndDisconnect);
        }
        supertypes.setSupertypesWithoutCycles(list);
    }
}
