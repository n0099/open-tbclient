package kotlin.reflect.jvm.internal;

import com.baidu.android.common.others.lang.StringUtil;
import com.baidu.searchbox.net.listener.DiaoqiJsonListener;
import com.baidu.tbadk.core.data.SmallTailInfo;
import com.baidu.webkit.sdk.LoadErrorCode;
import com.google.android.exoplayer2.text.webvtt.WebvttCueParser;
import com.tencent.open.SocialConstants;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.KParameter;
import kotlin.reflect.jvm.internal.impl.descriptors.CallableDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.FunctionDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.PropertyDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ReceiverParameterDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.TypeParameterDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ValueParameterDescriptor;
import kotlin.reflect.jvm.internal.impl.name.Name;
import kotlin.reflect.jvm.internal.impl.renderer.DescriptorRenderer;
import kotlin.reflect.jvm.internal.impl.types.KotlinType;
import kotlin.reflect.jvm.internal.impl.types.Variance;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000X\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\bÀ\u0002\u0018\u0000B\t\b\u0002¢\u0006\u0004\b'\u0010(J\u0017\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0002\u001a\u00020\u0001H\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\u0015\u0010\u0007\u001a\u00020\u00032\u0006\u0010\u0002\u001a\u00020\u0006¢\u0006\u0004\b\u0007\u0010\bJ\u0015\u0010\n\u001a\u00020\u00032\u0006\u0010\t\u001a\u00020\u0006¢\u0006\u0004\b\n\u0010\bJ\u0015\u0010\r\u001a\u00020\u00032\u0006\u0010\f\u001a\u00020\u000b¢\u0006\u0004\b\r\u0010\u000eJ\u0015\u0010\u0010\u001a\u00020\u00032\u0006\u0010\u0002\u001a\u00020\u000f¢\u0006\u0004\b\u0010\u0010\u0011J\u0015\u0010\u0014\u001a\u00020\u00032\u0006\u0010\u0013\u001a\u00020\u0012¢\u0006\u0004\b\u0014\u0010\u0015J\u0015\u0010\u0018\u001a\u00020\u00032\u0006\u0010\u0017\u001a\u00020\u0016¢\u0006\u0004\b\u0018\u0010\u0019J!\u0010\u001f\u001a\u00020\u001e*\u00060\u001aj\u0002`\u001b2\b\u0010\u001d\u001a\u0004\u0018\u00010\u001cH\u0002¢\u0006\u0004\b\u001f\u0010 J\u001f\u0010\"\u001a\u00020\u001e*\u00060\u001aj\u0002`\u001b2\u0006\u0010!\u001a\u00020\u0001H\u0002¢\u0006\u0004\b\"\u0010#R\u0016\u0010%\u001a\u00020$8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b%\u0010&¨\u0006)"}, d2 = {"Lkotlin/reflect/jvm/internal/ReflectionObjectRenderer;", "Lkotlin/reflect/jvm/internal/impl/descriptors/CallableDescriptor;", "descriptor", "", "renderCallable", "(Lkotlin/reflect/jvm/internal/impl/descriptors/CallableDescriptor;)Ljava/lang/String;", "Lkotlin/reflect/jvm/internal/impl/descriptors/FunctionDescriptor;", "renderFunction", "(Lkotlin/reflect/jvm/internal/impl/descriptors/FunctionDescriptor;)Ljava/lang/String;", DiaoqiJsonListener.SCHEME_FORBID_WHITE_LIST, "renderLambda", "Lkotlin/reflect/jvm/internal/KParameterImpl;", "parameter", "renderParameter", "(Lkotlin/reflect/jvm/internal/KParameterImpl;)Ljava/lang/String;", "Lkotlin/reflect/jvm/internal/impl/descriptors/PropertyDescriptor;", "renderProperty", "(Lkotlin/reflect/jvm/internal/impl/descriptors/PropertyDescriptor;)Ljava/lang/String;", "Lkotlin/reflect/jvm/internal/impl/types/KotlinType;", "type", "renderType", "(Lkotlin/reflect/jvm/internal/impl/types/KotlinType;)Ljava/lang/String;", "Lkotlin/reflect/jvm/internal/impl/descriptors/TypeParameterDescriptor;", "typeParameter", "renderTypeParameter", "(Lkotlin/reflect/jvm/internal/impl/descriptors/TypeParameterDescriptor;)Ljava/lang/String;", "Ljava/lang/StringBuilder;", "Lkotlin/text/StringBuilder;", "Lkotlin/reflect/jvm/internal/impl/descriptors/ReceiverParameterDescriptor;", SocialConstants.PARAM_RECEIVER, "", "appendReceiverType", "(Ljava/lang/StringBuilder;Lkotlin/reflect/jvm/internal/impl/descriptors/ReceiverParameterDescriptor;)V", "callable", "appendReceivers", "(Ljava/lang/StringBuilder;Lkotlin/reflect/jvm/internal/impl/descriptors/CallableDescriptor;)V", "Lkotlin/reflect/jvm/internal/impl/renderer/DescriptorRenderer;", "renderer", "Lkotlin/reflect/jvm/internal/impl/renderer/DescriptorRenderer;", "<init>", "()V", "kotlin-reflection"}, k = 1, mv = {1, 1, 15}, pn = "", xi = 0, xs = "")
/* loaded from: classes2.dex */
public final class ReflectionObjectRenderer {
    public static final ReflectionObjectRenderer INSTANCE = new ReflectionObjectRenderer();
    public static final DescriptorRenderer renderer = DescriptorRenderer.FQ_NAMES_IN_TYPES;

    @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 1, 16}, pn = "", xi = 0, xs = "")
    /* loaded from: classes2.dex */
    public final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;
        public static final /* synthetic */ int[] $EnumSwitchMapping$1;

        static {
            int[] iArr = new int[KParameter.Kind.values().length];
            $EnumSwitchMapping$0 = iArr;
            iArr[KParameter.Kind.EXTENSION_RECEIVER.ordinal()] = 1;
            $EnumSwitchMapping$0[KParameter.Kind.INSTANCE.ordinal()] = 2;
            $EnumSwitchMapping$0[KParameter.Kind.VALUE.ordinal()] = 3;
            int[] iArr2 = new int[Variance.values().length];
            $EnumSwitchMapping$1 = iArr2;
            iArr2[Variance.INVARIANT.ordinal()] = 1;
            $EnumSwitchMapping$1[Variance.IN_VARIANCE.ordinal()] = 2;
            $EnumSwitchMapping$1[Variance.OUT_VARIANCE.ordinal()] = 3;
        }
    }

    private final void appendReceiverType(StringBuilder sb, ReceiverParameterDescriptor receiverParameterDescriptor) {
        if (receiverParameterDescriptor != null) {
            KotlinType type = receiverParameterDescriptor.getType();
            Intrinsics.checkExpressionValueIsNotNull(type, "receiver.type");
            sb.append(renderType(type));
            sb.append(".");
        }
    }

    private final void appendReceivers(StringBuilder sb, CallableDescriptor callableDescriptor) {
        boolean z;
        ReceiverParameterDescriptor instanceReceiverParameter = UtilKt.getInstanceReceiverParameter(callableDescriptor);
        ReceiverParameterDescriptor extensionReceiverParameter = callableDescriptor.getExtensionReceiverParameter();
        appendReceiverType(sb, instanceReceiverParameter);
        if (instanceReceiverParameter != null && extensionReceiverParameter != null) {
            z = true;
        } else {
            z = false;
        }
        if (z) {
            sb.append("(");
        }
        appendReceiverType(sb, extensionReceiverParameter);
        if (z) {
            sb.append(SmallTailInfo.EMOTION_SUFFIX);
        }
    }

    private final String renderCallable(CallableDescriptor callableDescriptor) {
        if (callableDescriptor instanceof PropertyDescriptor) {
            return renderProperty((PropertyDescriptor) callableDescriptor);
        }
        if (callableDescriptor instanceof FunctionDescriptor) {
            return renderFunction((FunctionDescriptor) callableDescriptor);
        }
        throw new IllegalStateException(("Illegal callable: " + callableDescriptor).toString());
    }

    public final String renderType(KotlinType kotlinType) {
        return renderer.renderType(kotlinType);
    }

    public final String renderFunction(FunctionDescriptor functionDescriptor) {
        StringBuilder sb = new StringBuilder();
        sb.append("fun ");
        INSTANCE.appendReceivers(sb, functionDescriptor);
        DescriptorRenderer descriptorRenderer = renderer;
        Name name = functionDescriptor.getName();
        Intrinsics.checkExpressionValueIsNotNull(name, "descriptor.name");
        sb.append(descriptorRenderer.renderName(name, true));
        List<ValueParameterDescriptor> valueParameters = functionDescriptor.getValueParameters();
        Intrinsics.checkExpressionValueIsNotNull(valueParameters, "descriptor.valueParameters");
        CollectionsKt___CollectionsKt.joinTo$default(valueParameters, sb, StringUtil.ARRAY_ELEMENT_SEPARATOR, "(", SmallTailInfo.EMOTION_SUFFIX, 0, null, new Function1<ValueParameterDescriptor, String>() { // from class: kotlin.reflect.jvm.internal.ReflectionObjectRenderer$renderFunction$1$1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // kotlin.jvm.functions.Function1
            public final String invoke(ValueParameterDescriptor it) {
                ReflectionObjectRenderer reflectionObjectRenderer = ReflectionObjectRenderer.INSTANCE;
                Intrinsics.checkExpressionValueIsNotNull(it, "it");
                KotlinType type = it.getType();
                Intrinsics.checkExpressionValueIsNotNull(type, "it.type");
                return reflectionObjectRenderer.renderType(type);
            }
        }, 48, null);
        sb.append(": ");
        ReflectionObjectRenderer reflectionObjectRenderer = INSTANCE;
        KotlinType returnType = functionDescriptor.getReturnType();
        if (returnType == null) {
            Intrinsics.throwNpe();
        }
        Intrinsics.checkExpressionValueIsNotNull(returnType, "descriptor.returnType!!");
        sb.append(reflectionObjectRenderer.renderType(returnType));
        String sb2 = sb.toString();
        Intrinsics.checkExpressionValueIsNotNull(sb2, "StringBuilder().apply(builderAction).toString()");
        return sb2;
    }

    public final String renderLambda(FunctionDescriptor functionDescriptor) {
        StringBuilder sb = new StringBuilder();
        INSTANCE.appendReceivers(sb, functionDescriptor);
        List<ValueParameterDescriptor> valueParameters = functionDescriptor.getValueParameters();
        Intrinsics.checkExpressionValueIsNotNull(valueParameters, "invoke.valueParameters");
        CollectionsKt___CollectionsKt.joinTo$default(valueParameters, sb, StringUtil.ARRAY_ELEMENT_SEPARATOR, "(", SmallTailInfo.EMOTION_SUFFIX, 0, null, new Function1<ValueParameterDescriptor, String>() { // from class: kotlin.reflect.jvm.internal.ReflectionObjectRenderer$renderLambda$1$1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // kotlin.jvm.functions.Function1
            public final String invoke(ValueParameterDescriptor it) {
                ReflectionObjectRenderer reflectionObjectRenderer = ReflectionObjectRenderer.INSTANCE;
                Intrinsics.checkExpressionValueIsNotNull(it, "it");
                KotlinType type = it.getType();
                Intrinsics.checkExpressionValueIsNotNull(type, "it.type");
                return reflectionObjectRenderer.renderType(type);
            }
        }, 48, null);
        sb.append(LoadErrorCode.TOKEN_NEXT);
        ReflectionObjectRenderer reflectionObjectRenderer = INSTANCE;
        KotlinType returnType = functionDescriptor.getReturnType();
        if (returnType == null) {
            Intrinsics.throwNpe();
        }
        Intrinsics.checkExpressionValueIsNotNull(returnType, "invoke.returnType!!");
        sb.append(reflectionObjectRenderer.renderType(returnType));
        String sb2 = sb.toString();
        Intrinsics.checkExpressionValueIsNotNull(sb2, "StringBuilder().apply(builderAction).toString()");
        return sb2;
    }

    public final String renderProperty(PropertyDescriptor propertyDescriptor) {
        String str;
        StringBuilder sb = new StringBuilder();
        if (propertyDescriptor.isVar()) {
            str = "var ";
        } else {
            str = "val ";
        }
        sb.append(str);
        INSTANCE.appendReceivers(sb, propertyDescriptor);
        DescriptorRenderer descriptorRenderer = renderer;
        Name name = propertyDescriptor.getName();
        Intrinsics.checkExpressionValueIsNotNull(name, "descriptor.name");
        sb.append(descriptorRenderer.renderName(name, true));
        sb.append(": ");
        ReflectionObjectRenderer reflectionObjectRenderer = INSTANCE;
        KotlinType type = propertyDescriptor.getType();
        Intrinsics.checkExpressionValueIsNotNull(type, "descriptor.type");
        sb.append(reflectionObjectRenderer.renderType(type));
        String sb2 = sb.toString();
        Intrinsics.checkExpressionValueIsNotNull(sb2, "StringBuilder().apply(builderAction).toString()");
        return sb2;
    }

    public final String renderParameter(KParameterImpl kParameterImpl) {
        StringBuilder sb = new StringBuilder();
        int i = WhenMappings.$EnumSwitchMapping$0[kParameterImpl.getKind().ordinal()];
        if (i != 1) {
            if (i != 2) {
                if (i == 3) {
                    sb.append("parameter #" + kParameterImpl.getIndex() + WebvttCueParser.CHAR_SPACE + kParameterImpl.getName());
                }
            } else {
                sb.append("instance parameter");
            }
        } else {
            sb.append("extension receiver parameter");
        }
        sb.append(" of ");
        sb.append(INSTANCE.renderCallable(kParameterImpl.getCallable().getDescriptor()));
        String sb2 = sb.toString();
        Intrinsics.checkExpressionValueIsNotNull(sb2, "StringBuilder().apply(builderAction).toString()");
        return sb2;
    }

    public final String renderTypeParameter(TypeParameterDescriptor typeParameterDescriptor) {
        StringBuilder sb = new StringBuilder();
        int i = WhenMappings.$EnumSwitchMapping$1[typeParameterDescriptor.getVariance().ordinal()];
        if (i != 2) {
            if (i == 3) {
                sb.append("out ");
            }
        } else {
            sb.append("in ");
        }
        sb.append(typeParameterDescriptor.getName());
        String sb2 = sb.toString();
        Intrinsics.checkExpressionValueIsNotNull(sb2, "StringBuilder().apply(builderAction).toString()");
        return sb2;
    }
}
