package kotlin.reflect.jvm.internal.impl.types;

import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.jvm.functions.Function0;
import kotlin.reflect.jvm.internal.impl.descriptors.TypeParameterDescriptor;
import kotlin.reflect.jvm.internal.impl.types.checker.KotlinTypeRefiner;
/* loaded from: classes2.dex */
public final class StarProjectionImpl extends TypeProjectionBase {
    public final Lazy _type$delegate = LazyKt__LazyJVMKt.lazy(LazyThreadSafetyMode.PUBLICATION, (Function0) new Function0<KotlinType>() { // from class: kotlin.reflect.jvm.internal.impl.types.StarProjectionImpl$_type$2
        {
            super(0);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // kotlin.jvm.functions.Function0
        public final KotlinType invoke() {
            TypeParameterDescriptor typeParameterDescriptor;
            typeParameterDescriptor = StarProjectionImpl.this.typeParameter;
            return StarProjectionImplKt.starProjectionType(typeParameterDescriptor);
        }
    });
    public final TypeParameterDescriptor typeParameter;

    private final KotlinType get_type() {
        return (KotlinType) this._type$delegate.getValue();
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.TypeProjection
    public boolean isStarProjection() {
        return true;
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.TypeProjection
    public TypeProjection refine(KotlinTypeRefiner kotlinTypeRefiner) {
        return this;
    }

    public StarProjectionImpl(TypeParameterDescriptor typeParameterDescriptor) {
        this.typeParameter = typeParameterDescriptor;
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.TypeProjection
    public Variance getProjectionKind() {
        return Variance.OUT_VARIANCE;
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.TypeProjection
    public KotlinType getType() {
        return get_type();
    }
}
