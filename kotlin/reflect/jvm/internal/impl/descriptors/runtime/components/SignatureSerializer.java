package kotlin.reflect.jvm.internal.impl.descriptors.runtime.components;

import com.baidu.tbadk.core.data.SmallTailInfo;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.descriptors.runtime.structure.ReflectClassUtilKt;
/* loaded from: classes2.dex */
public final class SignatureSerializer {
    public static final SignatureSerializer INSTANCE = new SignatureSerializer();

    public final String constructorDesc(Constructor<?> constructor) {
        Class<?>[] parameterTypes;
        StringBuilder sb = new StringBuilder();
        sb.append("(");
        for (Class<?> parameterType : constructor.getParameterTypes()) {
            Intrinsics.checkExpressionValueIsNotNull(parameterType, "parameterType");
            sb.append(ReflectClassUtilKt.getDesc(parameterType));
        }
        sb.append(")V");
        String sb2 = sb.toString();
        Intrinsics.checkExpressionValueIsNotNull(sb2, "sb.toString()");
        return sb2;
    }

    public final String fieldDesc(Field field) {
        Class<?> type = field.getType();
        Intrinsics.checkExpressionValueIsNotNull(type, "field.type");
        return ReflectClassUtilKt.getDesc(type);
    }

    public final String methodDesc(Method method) {
        Class<?>[] parameterTypes;
        StringBuilder sb = new StringBuilder();
        sb.append("(");
        for (Class<?> parameterType : method.getParameterTypes()) {
            Intrinsics.checkExpressionValueIsNotNull(parameterType, "parameterType");
            sb.append(ReflectClassUtilKt.getDesc(parameterType));
        }
        sb.append(SmallTailInfo.EMOTION_SUFFIX);
        Class<?> returnType = method.getReturnType();
        Intrinsics.checkExpressionValueIsNotNull(returnType, "method.returnType");
        sb.append(ReflectClassUtilKt.getDesc(returnType));
        String sb2 = sb.toString();
        Intrinsics.checkExpressionValueIsNotNull(sb2, "sb.toString()");
        return sb2;
    }
}
