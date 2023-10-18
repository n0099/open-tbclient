package kotlin.reflect.jvm.internal.impl.types;

import java.util.Collection;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.collections.CollectionsKt__CollectionsJVMKt;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.builtins.KotlinBuiltIns;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassifierDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.SupertypeLoopChecker;
import kotlin.reflect.jvm.internal.impl.descriptors.TypeParameterDescriptor;
import kotlin.reflect.jvm.internal.impl.storage.NotNullLazyValue;
import kotlin.reflect.jvm.internal.impl.storage.StorageManager;
import kotlin.reflect.jvm.internal.impl.types.AbstractTypeConstructor;
import kotlin.reflect.jvm.internal.impl.types.checker.KotlinTypeRefiner;
import kotlin.reflect.jvm.internal.impl.types.checker.KotlinTypeRefinerKt;
/* loaded from: classes2.dex */
public abstract class AbstractTypeConstructor implements TypeConstructor {
    public final NotNullLazyValue<Supertypes> supertypes;

    public abstract Collection<KotlinType> computeSupertypes();

    public KotlinType defaultSupertypeIfEmpty() {
        return null;
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.TypeConstructor
    /* renamed from: getDeclarationDescriptor */
    public abstract ClassifierDescriptor mo2106getDeclarationDescriptor();

    public abstract SupertypeLoopChecker getSupertypeLoopChecker();

    public void reportScopesLoopError(KotlinType kotlinType) {
    }

    public void reportSupertypeLoopError(KotlinType kotlinType) {
    }

    /* loaded from: classes2.dex */
    public final class ModuleViewTypeConstructor implements TypeConstructor {
        public final KotlinTypeRefiner kotlinTypeRefiner;
        public final Lazy refinedSupertypes$delegate = LazyKt__LazyJVMKt.lazy(LazyThreadSafetyMode.PUBLICATION, (Function0) new Function0<List<? extends KotlinType>>() { // from class: kotlin.reflect.jvm.internal.impl.types.AbstractTypeConstructor$ModuleViewTypeConstructor$refinedSupertypes$2
            {
                super(0);
            }

            /* JADX DEBUG: Method merged with bridge method */
            /* JADX DEBUG: Return type fixed from 'java.util.List<kotlin.reflect.jvm.internal.impl.types.KotlinType>' to match base method */
            @Override // kotlin.jvm.functions.Function0
            public final List<? extends KotlinType> invoke() {
                KotlinTypeRefiner kotlinTypeRefiner;
                kotlinTypeRefiner = AbstractTypeConstructor.ModuleViewTypeConstructor.this.kotlinTypeRefiner;
                return KotlinTypeRefinerKt.refineTypes(kotlinTypeRefiner, AbstractTypeConstructor.this.mo2107getSupertypes());
            }
        });

        private final List<KotlinType> getRefinedSupertypes() {
            return (List) this.refinedSupertypes$delegate.getValue();
        }

        public ModuleViewTypeConstructor(KotlinTypeRefiner kotlinTypeRefiner) {
            this.kotlinTypeRefiner = kotlinTypeRefiner;
        }

        public boolean equals(Object obj) {
            return AbstractTypeConstructor.this.equals(obj);
        }

        @Override // kotlin.reflect.jvm.internal.impl.types.TypeConstructor
        public TypeConstructor refine(KotlinTypeRefiner kotlinTypeRefiner) {
            return AbstractTypeConstructor.this.refine(kotlinTypeRefiner);
        }

        @Override // kotlin.reflect.jvm.internal.impl.types.TypeConstructor
        public KotlinBuiltIns getBuiltIns() {
            KotlinBuiltIns builtIns = AbstractTypeConstructor.this.getBuiltIns();
            Intrinsics.checkExpressionValueIsNotNull(builtIns, "this@AbstractTypeConstructor.builtIns");
            return builtIns;
        }

        @Override // kotlin.reflect.jvm.internal.impl.types.TypeConstructor
        /* renamed from: getDeclarationDescriptor */
        public ClassifierDescriptor mo2106getDeclarationDescriptor() {
            return AbstractTypeConstructor.this.mo2106getDeclarationDescriptor();
        }

        @Override // kotlin.reflect.jvm.internal.impl.types.TypeConstructor
        public List<TypeParameterDescriptor> getParameters() {
            List<TypeParameterDescriptor> parameters = AbstractTypeConstructor.this.getParameters();
            Intrinsics.checkExpressionValueIsNotNull(parameters, "this@AbstractTypeConstructor.parameters");
            return parameters;
        }

        public int hashCode() {
            return AbstractTypeConstructor.this.hashCode();
        }

        @Override // kotlin.reflect.jvm.internal.impl.types.TypeConstructor
        public boolean isDenotable() {
            return AbstractTypeConstructor.this.isDenotable();
        }

        public String toString() {
            return AbstractTypeConstructor.this.toString();
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // kotlin.reflect.jvm.internal.impl.types.TypeConstructor
        /* renamed from: getSupertypes */
        public List<KotlinType> mo2107getSupertypes() {
            return getRefinedSupertypes();
        }
    }

    /* loaded from: classes2.dex */
    public static final class Supertypes {
        public final Collection<KotlinType> allSupertypes;
        public List<? extends KotlinType> supertypesWithoutCycles = CollectionsKt__CollectionsJVMKt.listOf(ErrorUtils.ERROR_TYPE_FOR_LOOP_IN_SUPERTYPES);

        /* JADX DEBUG: Multi-variable search result rejected for r1v0, resolved type: java.util.Collection<? extends kotlin.reflect.jvm.internal.impl.types.KotlinType> */
        /* JADX WARN: Multi-variable type inference failed */
        public Supertypes(Collection<? extends KotlinType> collection) {
            this.allSupertypes = collection;
        }

        public final void setSupertypesWithoutCycles(List<? extends KotlinType> list) {
            this.supertypesWithoutCycles = list;
        }

        public final Collection<KotlinType> getAllSupertypes() {
            return this.allSupertypes;
        }

        /* JADX DEBUG: Type inference failed for r0v0. Raw type applied. Possible types: java.util.List<? extends kotlin.reflect.jvm.internal.impl.types.KotlinType>, java.util.List<kotlin.reflect.jvm.internal.impl.types.KotlinType> */
        public final List<KotlinType> getSupertypesWithoutCycles() {
            return this.supertypesWithoutCycles;
        }
    }

    public AbstractTypeConstructor(StorageManager storageManager) {
        this.supertypes = storageManager.createLazyValueWithPostCompute(new Function0<Supertypes>() { // from class: kotlin.reflect.jvm.internal.impl.types.AbstractTypeConstructor$supertypes$1
            {
                super(0);
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // kotlin.jvm.functions.Function0
            public final AbstractTypeConstructor.Supertypes invoke() {
                return new AbstractTypeConstructor.Supertypes(AbstractTypeConstructor.this.computeSupertypes());
            }
        }, new Function1<Boolean, Supertypes>() { // from class: kotlin.reflect.jvm.internal.impl.types.AbstractTypeConstructor$supertypes$2
            /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
            /* JADX DEBUG: Return type fixed from 'java.lang.Object' to match base method */
            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ AbstractTypeConstructor.Supertypes invoke(Boolean bool) {
                return invoke(bool.booleanValue());
            }

            public final AbstractTypeConstructor.Supertypes invoke(boolean z) {
                return new AbstractTypeConstructor.Supertypes(CollectionsKt__CollectionsJVMKt.listOf(ErrorUtils.ERROR_TYPE_FOR_LOOP_IN_SUPERTYPES));
            }
        }, new AbstractTypeConstructor$supertypes$3(this));
    }

    public Collection<KotlinType> getAdditionalNeighboursInSupertypeGraph(boolean z) {
        return CollectionsKt__CollectionsKt.emptyList();
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.TypeConstructor
    public TypeConstructor refine(KotlinTypeRefiner kotlinTypeRefiner) {
        return new ModuleViewTypeConstructor(kotlinTypeRefiner);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Collection<KotlinType> computeNeighbours(TypeConstructor typeConstructor, boolean z) {
        TypeConstructor typeConstructor2;
        List plus;
        if (!(typeConstructor instanceof AbstractTypeConstructor)) {
            typeConstructor2 = null;
        } else {
            typeConstructor2 = typeConstructor;
        }
        AbstractTypeConstructor abstractTypeConstructor = (AbstractTypeConstructor) typeConstructor2;
        if (abstractTypeConstructor == null || (plus = CollectionsKt___CollectionsKt.plus((Collection) abstractTypeConstructor.supertypes.invoke().getAllSupertypes(), (Iterable) abstractTypeConstructor.getAdditionalNeighboursInSupertypeGraph(z))) == null) {
            Collection<KotlinType> supertypes = typeConstructor.mo2107getSupertypes();
            Intrinsics.checkExpressionValueIsNotNull(supertypes, "supertypes");
            return supertypes;
        }
        return plus;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // kotlin.reflect.jvm.internal.impl.types.TypeConstructor
    /* renamed from: getSupertypes */
    public List<KotlinType> mo2107getSupertypes() {
        return this.supertypes.invoke().getSupertypesWithoutCycles();
    }
}
