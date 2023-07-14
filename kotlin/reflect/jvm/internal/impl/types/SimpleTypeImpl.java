package kotlin.reflect.jvm.internal.impl.types;

import java.util.List;
import kotlin.jvm.functions.Function1;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.Annotations;
import kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScope;
import kotlin.reflect.jvm.internal.impl.types.ErrorUtils;
import kotlin.reflect.jvm.internal.impl.types.checker.KotlinTypeRefiner;
/* loaded from: classes2.dex */
public final class SimpleTypeImpl extends SimpleType {
    public final List<TypeProjection> arguments;
    public final TypeConstructor constructor;
    public final boolean isMarkedNullable;
    public final MemberScope memberScope;
    public final Function1<KotlinTypeRefiner, SimpleType> refinedTypeFactory;

    /* JADX DEBUG: Multi-variable search result rejected for r2v0, resolved type: java.util.List<? extends kotlin.reflect.jvm.internal.impl.types.TypeProjection> */
    /* JADX DEBUG: Multi-variable search result rejected for r5v0, resolved type: kotlin.jvm.functions.Function1<? super kotlin.reflect.jvm.internal.impl.types.checker.KotlinTypeRefiner, ? extends kotlin.reflect.jvm.internal.impl.types.SimpleType> */
    /* JADX WARN: Multi-variable type inference failed */
    public SimpleTypeImpl(TypeConstructor typeConstructor, List<? extends TypeProjection> list, boolean z, MemberScope memberScope, Function1<? super KotlinTypeRefiner, ? extends SimpleType> function1) {
        this.constructor = typeConstructor;
        this.arguments = list;
        this.isMarkedNullable = z;
        this.memberScope = memberScope;
        this.refinedTypeFactory = function1;
        if (!(getMemberScope() instanceof ErrorUtils.ErrorScope)) {
            return;
        }
        throw new IllegalStateException("SimpleTypeImpl should not be created for error type: " + getMemberScope() + '\n' + getConstructor());
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.annotations.Annotated
    public Annotations getAnnotations() {
        return Annotations.Companion.getEMPTY();
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.KotlinType
    public List<TypeProjection> getArguments() {
        return this.arguments;
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.KotlinType
    public TypeConstructor getConstructor() {
        return this.constructor;
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.KotlinType
    public MemberScope getMemberScope() {
        return this.memberScope;
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.KotlinType
    public boolean isMarkedNullable() {
        return this.isMarkedNullable;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // kotlin.reflect.jvm.internal.impl.types.UnwrappedType
    public SimpleType makeNullableAsSpecified(boolean z) {
        if (z == isMarkedNullable()) {
            return this;
        }
        if (z) {
            return new NullableSimpleType(this);
        }
        return new NotNullSimpleType(this);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // kotlin.reflect.jvm.internal.impl.types.UnwrappedType
    public SimpleType replaceAnnotations(Annotations annotations) {
        if (annotations.isEmpty()) {
            return this;
        }
        return new AnnotatedSimpleType(this, annotations);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // kotlin.reflect.jvm.internal.impl.types.UnwrappedType, kotlin.reflect.jvm.internal.impl.types.KotlinType
    public SimpleType refine(KotlinTypeRefiner kotlinTypeRefiner) {
        SimpleType invoke = this.refinedTypeFactory.invoke(kotlinTypeRefiner);
        if (invoke == null) {
            return this;
        }
        return invoke;
    }
}
