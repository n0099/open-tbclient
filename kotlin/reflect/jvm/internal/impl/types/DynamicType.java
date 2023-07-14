package kotlin.reflect.jvm.internal.impl.types;

import com.baidu.searchbox.ui.animview.util.PraiseUBCHelper;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.builtins.KotlinBuiltIns;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.Annotations;
import kotlin.reflect.jvm.internal.impl.renderer.DescriptorRenderer;
import kotlin.reflect.jvm.internal.impl.renderer.DescriptorRendererOptions;
import kotlin.reflect.jvm.internal.impl.types.checker.KotlinTypeRefiner;
import kotlin.reflect.jvm.internal.impl.types.model.DynamicTypeMarker;
import kotlin.reflect.jvm.internal.impl.types.typeUtil.TypeUtilsKt;
/* loaded from: classes2.dex */
public final class DynamicType extends FlexibleType implements DynamicTypeMarker {
    public final Annotations annotations;

    @Override // kotlin.reflect.jvm.internal.impl.types.FlexibleType, kotlin.reflect.jvm.internal.impl.types.KotlinType
    public boolean isMarkedNullable() {
        return false;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // kotlin.reflect.jvm.internal.impl.types.UnwrappedType
    public DynamicType makeNullableAsSpecified(boolean z) {
        return this;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // kotlin.reflect.jvm.internal.impl.types.UnwrappedType, kotlin.reflect.jvm.internal.impl.types.KotlinType
    public DynamicType refine(KotlinTypeRefiner kotlinTypeRefiner) {
        return this;
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.FlexibleType
    public String render(DescriptorRenderer descriptorRenderer, DescriptorRendererOptions descriptorRendererOptions) {
        return PraiseUBCHelper.SOURCE_DYNAMIC;
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public DynamicType(KotlinBuiltIns kotlinBuiltIns, Annotations annotations) {
        super(r0, r3);
        SimpleType nothingType = kotlinBuiltIns.getNothingType();
        Intrinsics.checkExpressionValueIsNotNull(nothingType, "builtIns.nothingType");
        SimpleType nullableAnyType = kotlinBuiltIns.getNullableAnyType();
        Intrinsics.checkExpressionValueIsNotNull(nullableAnyType, "builtIns.nullableAnyType");
        this.annotations = annotations;
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.FlexibleType, kotlin.reflect.jvm.internal.impl.descriptors.annotations.Annotated
    public Annotations getAnnotations() {
        return this.annotations;
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.FlexibleType
    public SimpleType getDelegate() {
        return getUpperBound();
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // kotlin.reflect.jvm.internal.impl.types.UnwrappedType
    public DynamicType replaceAnnotations(Annotations annotations) {
        return new DynamicType(TypeUtilsKt.getBuiltIns(getDelegate()), annotations);
    }
}
