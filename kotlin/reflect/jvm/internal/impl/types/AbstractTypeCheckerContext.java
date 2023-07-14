package kotlin.reflect.jvm.internal.impl.types;

import java.util.ArrayDeque;
import java.util.List;
import java.util.Set;
import kotlin._Assertions;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.types.model.CapturedTypeMarker;
import kotlin.reflect.jvm.internal.impl.types.model.KotlinTypeMarker;
import kotlin.reflect.jvm.internal.impl.types.model.SimpleTypeMarker;
import kotlin.reflect.jvm.internal.impl.types.model.TypeArgumentListMarker;
import kotlin.reflect.jvm.internal.impl.types.model.TypeArgumentMarker;
import kotlin.reflect.jvm.internal.impl.types.model.TypeConstructorMarker;
import kotlin.reflect.jvm.internal.impl.types.model.TypeSystemContext;
import kotlin.reflect.jvm.internal.impl.utils.SmartSet;
/* loaded from: classes2.dex */
public abstract class AbstractTypeCheckerContext implements TypeSystemContext {
    public int argumentsDepth;
    public ArrayDeque<SimpleTypeMarker> supertypesDeque;
    public boolean supertypesLocked;
    public Set<SimpleTypeMarker> supertypesSet;

    /* loaded from: classes2.dex */
    public enum LowerCapturedTypePolicy {
        CHECK_ONLY_LOWER,
        CHECK_SUBTYPE_AND_LOWER,
        SKIP_LOWER
    }

    public Boolean addSubtypeConstraint(KotlinTypeMarker kotlinTypeMarker, KotlinTypeMarker kotlinTypeMarker2) {
        return null;
    }

    public abstract boolean areEqualTypeConstructors(TypeConstructorMarker typeConstructorMarker, TypeConstructorMarker typeConstructorMarker2);

    public abstract boolean isAllowedTypeVariable(KotlinTypeMarker kotlinTypeMarker);

    public abstract boolean isErrorTypeEqualsToAnything();

    public abstract boolean isStubTypeEqualsToAnything();

    public KotlinTypeMarker prepareType(KotlinTypeMarker kotlinTypeMarker) {
        return kotlinTypeMarker;
    }

    public KotlinTypeMarker refineType(KotlinTypeMarker kotlinTypeMarker) {
        return kotlinTypeMarker;
    }

    public abstract SupertypesPolicy substitutionSupertypePolicy(SimpleTypeMarker simpleTypeMarker);

    /* loaded from: classes2.dex */
    public static abstract class SupertypesPolicy {
        /* renamed from: transformType */
        public abstract SimpleTypeMarker mo2105transformType(AbstractTypeCheckerContext abstractTypeCheckerContext, KotlinTypeMarker kotlinTypeMarker);

        /* loaded from: classes2.dex */
        public static abstract class DoCustomTransform extends SupertypesPolicy {
            public DoCustomTransform() {
                super(null);
            }
        }

        /* loaded from: classes2.dex */
        public static final class LowerIfFlexible extends SupertypesPolicy {
            public static final LowerIfFlexible INSTANCE = new LowerIfFlexible();

            public LowerIfFlexible() {
                super(null);
            }

            @Override // kotlin.reflect.jvm.internal.impl.types.AbstractTypeCheckerContext.SupertypesPolicy
            /* renamed from: transformType */
            public SimpleTypeMarker mo2105transformType(AbstractTypeCheckerContext abstractTypeCheckerContext, KotlinTypeMarker kotlinTypeMarker) {
                return abstractTypeCheckerContext.lowerBoundIfFlexible(kotlinTypeMarker);
            }
        }

        /* loaded from: classes2.dex */
        public static final class None extends SupertypesPolicy {
            public static final None INSTANCE = new None();

            public None() {
                super(null);
            }

            /* JADX DEBUG: Possible override for method kotlin.reflect.jvm.internal.impl.types.AbstractTypeCheckerContext.SupertypesPolicy.transformType(Lkotlin/reflect/jvm/internal/impl/types/AbstractTypeCheckerContext;Lkotlin/reflect/jvm/internal/impl/types/model/KotlinTypeMarker;)Lkotlin/reflect/jvm/internal/impl/types/model/SimpleTypeMarker; */
            public Void transformType(AbstractTypeCheckerContext abstractTypeCheckerContext, KotlinTypeMarker kotlinTypeMarker) {
                throw new UnsupportedOperationException("Should not be called");
            }

            @Override // kotlin.reflect.jvm.internal.impl.types.AbstractTypeCheckerContext.SupertypesPolicy
            /* renamed from: transformType  reason: collision with other method in class */
            public /* bridge */ /* synthetic */ SimpleTypeMarker mo2105transformType(AbstractTypeCheckerContext abstractTypeCheckerContext, KotlinTypeMarker kotlinTypeMarker) {
                return (SimpleTypeMarker) transformType(abstractTypeCheckerContext, kotlinTypeMarker);
            }
        }

        /* loaded from: classes2.dex */
        public static final class UpperIfFlexible extends SupertypesPolicy {
            public static final UpperIfFlexible INSTANCE = new UpperIfFlexible();

            public UpperIfFlexible() {
                super(null);
            }

            @Override // kotlin.reflect.jvm.internal.impl.types.AbstractTypeCheckerContext.SupertypesPolicy
            /* renamed from: transformType */
            public SimpleTypeMarker mo2105transformType(AbstractTypeCheckerContext abstractTypeCheckerContext, KotlinTypeMarker kotlinTypeMarker) {
                return abstractTypeCheckerContext.upperBoundIfFlexible(kotlinTypeMarker);
            }
        }

        public SupertypesPolicy() {
        }

        public /* synthetic */ SupertypesPolicy(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public final void clear() {
        ArrayDeque<SimpleTypeMarker> arrayDeque = this.supertypesDeque;
        if (arrayDeque == null) {
            Intrinsics.throwNpe();
        }
        arrayDeque.clear();
        Set<SimpleTypeMarker> set = this.supertypesSet;
        if (set == null) {
            Intrinsics.throwNpe();
        }
        set.clear();
        this.supertypesLocked = false;
    }

    public final ArrayDeque<SimpleTypeMarker> getSupertypesDeque() {
        return this.supertypesDeque;
    }

    public final Set<SimpleTypeMarker> getSupertypesSet() {
        return this.supertypesSet;
    }

    public final void initialize() {
        boolean z = !this.supertypesLocked;
        if (_Assertions.ENABLED && !z) {
            throw new AssertionError("Assertion failed");
        }
        this.supertypesLocked = true;
        if (this.supertypesDeque == null) {
            this.supertypesDeque = new ArrayDeque<>(4);
        }
        if (this.supertypesSet == null) {
            this.supertypesSet = SmartSet.Companion.create();
        }
    }

    public boolean hasFlexibleNullability(KotlinTypeMarker kotlinTypeMarker) {
        return TypeSystemContext.DefaultImpls.hasFlexibleNullability(this, kotlinTypeMarker);
    }

    public boolean isClassType(SimpleTypeMarker simpleTypeMarker) {
        return TypeSystemContext.DefaultImpls.isClassType(this, simpleTypeMarker);
    }

    public boolean isDefinitelyNotNullType(KotlinTypeMarker kotlinTypeMarker) {
        return TypeSystemContext.DefaultImpls.isDefinitelyNotNullType(this, kotlinTypeMarker);
    }

    public boolean isDynamic(KotlinTypeMarker kotlinTypeMarker) {
        return TypeSystemContext.DefaultImpls.isDynamic(this, kotlinTypeMarker);
    }

    public boolean isIntegerLiteralType(SimpleTypeMarker simpleTypeMarker) {
        return TypeSystemContext.DefaultImpls.isIntegerLiteralType(this, simpleTypeMarker);
    }

    public boolean isNothing(KotlinTypeMarker kotlinTypeMarker) {
        return TypeSystemContext.DefaultImpls.isNothing(this, kotlinTypeMarker);
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.model.TypeSystemContext
    public SimpleTypeMarker lowerBoundIfFlexible(KotlinTypeMarker kotlinTypeMarker) {
        return TypeSystemContext.DefaultImpls.lowerBoundIfFlexible(this, kotlinTypeMarker);
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.model.TypeSystemContext
    public int size(TypeArgumentListMarker typeArgumentListMarker) {
        return TypeSystemContext.DefaultImpls.size(this, typeArgumentListMarker);
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.model.TypeSystemContext
    public TypeConstructorMarker typeConstructor(KotlinTypeMarker kotlinTypeMarker) {
        return TypeSystemContext.DefaultImpls.typeConstructor(this, kotlinTypeMarker);
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.model.TypeSystemContext
    public SimpleTypeMarker upperBoundIfFlexible(KotlinTypeMarker kotlinTypeMarker) {
        return TypeSystemContext.DefaultImpls.upperBoundIfFlexible(this, kotlinTypeMarker);
    }

    public List<SimpleTypeMarker> fastCorrespondingSupertypes(SimpleTypeMarker simpleTypeMarker, TypeConstructorMarker typeConstructorMarker) {
        return TypeSystemContext.DefaultImpls.fastCorrespondingSupertypes(this, simpleTypeMarker, typeConstructorMarker);
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.model.TypeSystemContext
    public TypeArgumentMarker get(TypeArgumentListMarker typeArgumentListMarker, int i) {
        return TypeSystemContext.DefaultImpls.get(this, typeArgumentListMarker, i);
    }

    public TypeArgumentMarker getArgumentOrNull(SimpleTypeMarker simpleTypeMarker, int i) {
        return TypeSystemContext.DefaultImpls.getArgumentOrNull(this, simpleTypeMarker, i);
    }

    public LowerCapturedTypePolicy getLowerCapturedTypePolicy(SimpleTypeMarker simpleTypeMarker, CapturedTypeMarker capturedTypeMarker) {
        return LowerCapturedTypePolicy.CHECK_SUBTYPE_AND_LOWER;
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.model.TypeSystemOptimizationContext
    public boolean identicalArguments(SimpleTypeMarker simpleTypeMarker, SimpleTypeMarker simpleTypeMarker2) {
        return TypeSystemContext.DefaultImpls.identicalArguments(this, simpleTypeMarker, simpleTypeMarker2);
    }
}
