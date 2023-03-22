package kotlin.reflect.jvm.internal.impl.types;

import com.baidu.android.common.others.lang.StringUtil;
import com.baidu.pass.main.facesdk.utils.PreferencesUtil;
import java.util.Iterator;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.AnnotationDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.Annotations;
import kotlin.reflect.jvm.internal.impl.renderer.DescriptorRenderer;
import kotlin.reflect.jvm.internal.impl.types.model.SimpleTypeMarker;
import kotlin.reflect.jvm.internal.impl.types.model.TypeArgumentListMarker;
import kotlin.text.StringsKt__StringBuilderKt;
/* loaded from: classes9.dex */
public abstract class SimpleType extends UnwrappedType implements SimpleTypeMarker, TypeArgumentListMarker {
    @Override // kotlin.reflect.jvm.internal.impl.types.UnwrappedType
    public abstract SimpleType makeNullableAsSpecified(boolean z);

    @Override // kotlin.reflect.jvm.internal.impl.types.UnwrappedType
    public abstract SimpleType replaceAnnotations(Annotations annotations);

    public SimpleType() {
        super(null);
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        Iterator<AnnotationDescriptor> it = getAnnotations().iterator();
        while (it.hasNext()) {
            StringsKt__StringBuilderKt.append(sb, PreferencesUtil.LEFT_MOUNT, DescriptorRenderer.renderAnnotation$default(DescriptorRenderer.DEBUG_TEXT, it.next(), null, 2, null), "] ");
        }
        sb.append(getConstructor());
        if (!getArguments().isEmpty()) {
            CollectionsKt___CollectionsKt.joinTo$default(getArguments(), sb, StringUtil.ARRAY_ELEMENT_SEPARATOR, "<", ">", 0, null, null, 112, null);
        }
        if (isMarkedNullable()) {
            sb.append("?");
        }
        String sb2 = sb.toString();
        Intrinsics.checkExpressionValueIsNotNull(sb2, "StringBuilder().apply(builderAction).toString()");
        return sb2;
    }
}
