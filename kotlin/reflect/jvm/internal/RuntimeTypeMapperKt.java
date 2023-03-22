package kotlin.reflect.jvm.internal;

import com.baidu.tbadk.core.data.SmallTailInfo;
import com.tencent.open.SocialOperation;
import java.lang.reflect.Method;
import kotlin.Metadata;
import kotlin.collections.ArraysKt___ArraysKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.descriptors.runtime.structure.ReflectClassUtilKt;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\"\u001a\u0010\u0004\u001a\u00020\u0001*\u00020\u00008B@\u0002X\u0082\u0004¢\u0006\u0006\u001a\u0004\b\u0002\u0010\u0003¨\u0006\u0005"}, d2 = {"Ljava/lang/reflect/Method;", "", "getSignature", "(Ljava/lang/reflect/Method;)Ljava/lang/String;", SocialOperation.GAME_SIGNATURE, "kotlin-reflection"}, k = 2, mv = {1, 1, 15}, pn = "", xi = 0, xs = "")
/* loaded from: classes9.dex */
public final class RuntimeTypeMapperKt {
    /* JADX DEBUG: Method not inlined, still used in: [kotlin.reflect.jvm.internal.JvmFunctionSignature.JavaMethod.asString():java.lang.String, kotlin.reflect.jvm.internal.JvmPropertySignature.JavaMethodProperty.asString():java.lang.String] */
    public static final /* synthetic */ String access$getSignature$p(Method method) {
        return getSignature(method);
    }

    public static final String getSignature(Method method) {
        StringBuilder sb = new StringBuilder();
        sb.append(method.getName());
        Class<?>[] parameterTypes = method.getParameterTypes();
        Intrinsics.checkExpressionValueIsNotNull(parameterTypes, "parameterTypes");
        sb.append(ArraysKt___ArraysKt.joinToString$default(parameterTypes, "", "(", SmallTailInfo.EMOTION_SUFFIX, 0, (CharSequence) null, new Function1<Class<?>, String>() { // from class: kotlin.reflect.jvm.internal.RuntimeTypeMapperKt$signature$1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // kotlin.jvm.functions.Function1
            public final String invoke(Class<?> it) {
                Intrinsics.checkExpressionValueIsNotNull(it, "it");
                return ReflectClassUtilKt.getDesc(it);
            }
        }, 24, (Object) null));
        Class<?> returnType = method.getReturnType();
        Intrinsics.checkExpressionValueIsNotNull(returnType, "returnType");
        sb.append(ReflectClassUtilKt.getDesc(returnType));
        return sb.toString();
    }
}
