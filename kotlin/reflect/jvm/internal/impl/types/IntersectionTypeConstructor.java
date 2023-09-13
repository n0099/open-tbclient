package kotlin.reflect.jvm.internal.impl.types;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.LinkedHashSet;
import java.util.List;
import kotlin._Assertions;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.CollectionsKt__IterablesKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.comparisons.ComparisonsKt__ComparisonsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.builtins.KotlinBuiltIns;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassifierDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.TypeParameterDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.Annotations;
import kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScope;
import kotlin.reflect.jvm.internal.impl.resolve.scopes.TypeIntersectionScope;
import kotlin.reflect.jvm.internal.impl.types.checker.KotlinTypeRefiner;
/* loaded from: classes2.dex */
public final class IntersectionTypeConstructor implements TypeConstructor {
    public final int hashCode;
    public final LinkedHashSet<KotlinType> intersectedTypes;

    @Override // kotlin.reflect.jvm.internal.impl.types.TypeConstructor
    /* renamed from: getDeclarationDescriptor */
    public ClassifierDescriptor mo2105getDeclarationDescriptor() {
        return null;
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.TypeConstructor
    public boolean isDenotable() {
        return false;
    }

    public IntersectionTypeConstructor(Collection<? extends KotlinType> collection) {
        boolean z = !collection.isEmpty();
        if (_Assertions.ENABLED && !z) {
            throw new AssertionError("Attempt to create an empty intersection");
        }
        LinkedHashSet<KotlinType> linkedHashSet = new LinkedHashSet<>(collection);
        this.intersectedTypes = linkedHashSet;
        this.hashCode = linkedHashSet.hashCode();
    }

    private final String makeDebugNameForIntersectionType(Iterable<? extends KotlinType> iterable) {
        return CollectionsKt___CollectionsKt.joinToString$default(CollectionsKt___CollectionsKt.sortedWith(iterable, new Comparator<T>() { // from class: kotlin.reflect.jvm.internal.impl.types.IntersectionTypeConstructor$makeDebugNameForIntersectionType$$inlined$sortedBy$1
            @Override // java.util.Comparator
            public final int compare(T t, T t2) {
                return ComparisonsKt__ComparisonsKt.compareValues(((KotlinType) t).toString(), ((KotlinType) t2).toString());
            }
        }), " & ", "{", "}", 0, null, null, 56, null);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof IntersectionTypeConstructor)) {
            return false;
        }
        return Intrinsics.areEqual(this.intersectedTypes, ((IntersectionTypeConstructor) obj).intersectedTypes);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // kotlin.reflect.jvm.internal.impl.types.TypeConstructor
    public IntersectionTypeConstructor refine(KotlinTypeRefiner kotlinTypeRefiner) {
        LinkedHashSet<KotlinType> linkedHashSet = this.intersectedTypes;
        ArrayList arrayList = new ArrayList(CollectionsKt__IterablesKt.collectionSizeOrDefault(linkedHashSet, 10));
        for (KotlinType kotlinType : linkedHashSet) {
            arrayList.add(kotlinType.refine(kotlinTypeRefiner));
        }
        return new IntersectionTypeConstructor(arrayList);
    }

    public final MemberScope createScopeForKotlinType() {
        TypeIntersectionScope.Companion companion = TypeIntersectionScope.Companion;
        return companion.create("member scope for intersection type " + this, this.intersectedTypes);
    }

    public final SimpleType createType() {
        return KotlinTypeFactory.simpleTypeWithNonTrivialMemberScope(Annotations.Companion.getEMPTY(), this, CollectionsKt__CollectionsKt.emptyList(), false, createScopeForKotlinType(), new Function1<KotlinTypeRefiner, SimpleType>() { // from class: kotlin.reflect.jvm.internal.impl.types.IntersectionTypeConstructor$createType$1
            {
                super(1);
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // kotlin.jvm.functions.Function1
            public final SimpleType invoke(KotlinTypeRefiner kotlinTypeRefiner) {
                return IntersectionTypeConstructor.this.refine(kotlinTypeRefiner).createType();
            }
        });
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.TypeConstructor
    public KotlinBuiltIns getBuiltIns() {
        KotlinBuiltIns builtIns = this.intersectedTypes.iterator().next().getConstructor().getBuiltIns();
        Intrinsics.checkExpressionValueIsNotNull(builtIns, "intersectedTypes.iterato…xt().constructor.builtIns");
        return builtIns;
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.TypeConstructor
    public List<TypeParameterDescriptor> getParameters() {
        return CollectionsKt__CollectionsKt.emptyList();
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.TypeConstructor
    /* renamed from: getSupertypes */
    public Collection<KotlinType> mo2106getSupertypes() {
        return this.intersectedTypes;
    }

    public int hashCode() {
        return this.hashCode;
    }

    public String toString() {
        return makeDebugNameForIntersectionType(this.intersectedTypes);
    }
}
