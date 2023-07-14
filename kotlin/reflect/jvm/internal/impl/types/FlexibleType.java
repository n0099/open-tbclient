package kotlin.reflect.jvm.internal.impl.types;

import java.util.List;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.Annotations;
import kotlin.reflect.jvm.internal.impl.renderer.DescriptorRenderer;
import kotlin.reflect.jvm.internal.impl.renderer.DescriptorRendererOptions;
import kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScope;
import kotlin.reflect.jvm.internal.impl.types.model.FlexibleTypeMarker;
/* loaded from: classes2.dex */
public abstract class FlexibleType extends UnwrappedType implements SubtypingRepresentatives, FlexibleTypeMarker {
    public final SimpleType lowerBound;
    public final SimpleType upperBound;

    public abstract SimpleType getDelegate();

    public abstract String render(DescriptorRenderer descriptorRenderer, DescriptorRendererOptions descriptorRendererOptions);

    @Override // kotlin.reflect.jvm.internal.impl.types.SubtypingRepresentatives
    public boolean sameTypeConstructor(KotlinType kotlinType) {
        return false;
    }

    public FlexibleType(SimpleType simpleType, SimpleType simpleType2) {
        super(null);
        this.lowerBound = simpleType;
        this.upperBound = simpleType2;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.annotations.Annotated
    public Annotations getAnnotations() {
        return getDelegate().getAnnotations();
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.KotlinType
    public List<TypeProjection> getArguments() {
        return getDelegate().getArguments();
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.KotlinType
    public TypeConstructor getConstructor() {
        return getDelegate().getConstructor();
    }

    public final SimpleType getLowerBound() {
        return this.lowerBound;
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.KotlinType
    public MemberScope getMemberScope() {
        return getDelegate().getMemberScope();
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.SubtypingRepresentatives
    public KotlinType getSubTypeRepresentative() {
        return this.lowerBound;
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.SubtypingRepresentatives
    public KotlinType getSuperTypeRepresentative() {
        return this.upperBound;
    }

    public final SimpleType getUpperBound() {
        return this.upperBound;
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.KotlinType
    public boolean isMarkedNullable() {
        return getDelegate().isMarkedNullable();
    }

    public String toString() {
        return DescriptorRenderer.DEBUG_TEXT.renderType(this);
    }
}
