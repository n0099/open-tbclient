package org.aspectj.internal.lang.reflect;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.lang.reflect.Method;
import java.lang.reflect.Type;
import org.aspectj.lang.annotation.AdviceName;
import org.aspectj.lang.reflect.Advice;
import org.aspectj.lang.reflect.AdviceKind;
import org.aspectj.lang.reflect.AjType;
import org.aspectj.lang.reflect.AjTypeSystem;
import org.aspectj.lang.reflect.PointcutExpression;
/* loaded from: classes2.dex */
public class AdviceImpl implements Advice {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String AJC_INTERNAL = "org.aspectj.runtime.internal";
    public transient /* synthetic */ FieldHolder $fh;
    public final Method adviceMethod;
    public AjType[] exceptionTypes;
    public Type[] genericParameterTypes;
    public boolean hasExtraParam;
    public final AdviceKind kind;
    public AjType[] parameterTypes;
    public PointcutExpression pointcutExpression;

    /* renamed from: org.aspectj.internal.lang.reflect.AdviceImpl$1  reason: invalid class name */
    /* loaded from: classes2.dex */
    public static /* synthetic */ class AnonymousClass1 {
        public static final /* synthetic */ int[] $SwitchMap$org$aspectj$lang$reflect$AdviceKind;
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(44733281, "Lorg/aspectj/internal/lang/reflect/AdviceImpl$1;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(44733281, "Lorg/aspectj/internal/lang/reflect/AdviceImpl$1;");
                    return;
                }
            }
            int[] iArr = new int[AdviceKind.values().length];
            $SwitchMap$org$aspectj$lang$reflect$AdviceKind = iArr;
            try {
                iArr[AdviceKind.AFTER.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$org$aspectj$lang$reflect$AdviceKind[AdviceKind.AFTER_RETURNING.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$org$aspectj$lang$reflect$AdviceKind[AdviceKind.AFTER_THROWING.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                $SwitchMap$org$aspectj$lang$reflect$AdviceKind[AdviceKind.AROUND.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                $SwitchMap$org$aspectj$lang$reflect$AdviceKind[AdviceKind.BEFORE.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
        }
    }

    public AdviceImpl(Method method, String str, AdviceKind adviceKind) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {method, str, adviceKind};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.hasExtraParam = false;
        this.kind = adviceKind;
        this.adviceMethod = method;
        this.pointcutExpression = new PointcutExpressionImpl(str);
    }

    @Override // org.aspectj.lang.reflect.Advice
    public AjType getDeclaringType() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? AjTypeSystem.getAjType(this.adviceMethod.getDeclaringClass()) : (AjType) invokeV.objValue;
    }

    @Override // org.aspectj.lang.reflect.Advice
    public AjType<?>[] getExceptionTypes() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            if (this.exceptionTypes == null) {
                Class<?>[] exceptionTypes = this.adviceMethod.getExceptionTypes();
                this.exceptionTypes = new AjType[exceptionTypes.length];
                for (int i2 = 0; i2 < exceptionTypes.length; i2++) {
                    this.exceptionTypes[i2] = AjTypeSystem.getAjType(exceptionTypes[i2]);
                }
            }
            return this.exceptionTypes;
        }
        return (AjType[]) invokeV.objValue;
    }

    @Override // org.aspectj.lang.reflect.Advice
    public Type[] getGenericParameterTypes() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            if (this.genericParameterTypes == null) {
                Type[] genericParameterTypes = this.adviceMethod.getGenericParameterTypes();
                int i2 = 0;
                int i3 = 0;
                for (Type type : genericParameterTypes) {
                    if ((type instanceof Class) && ((Class) type).getPackage().getName().equals(AJC_INTERNAL)) {
                        i3++;
                    }
                }
                this.genericParameterTypes = new Type[genericParameterTypes.length - i3];
                while (true) {
                    Type[] typeArr = this.genericParameterTypes;
                    if (i2 >= typeArr.length) {
                        break;
                    }
                    if (genericParameterTypes[i2] instanceof Class) {
                        typeArr[i2] = AjTypeSystem.getAjType((Class) genericParameterTypes[i2]);
                    } else {
                        typeArr[i2] = genericParameterTypes[i2];
                    }
                    i2++;
                }
            }
            return this.genericParameterTypes;
        }
        return (Type[]) invokeV.objValue;
    }

    @Override // org.aspectj.lang.reflect.Advice
    public AdviceKind getKind() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.kind : (AdviceKind) invokeV.objValue;
    }

    @Override // org.aspectj.lang.reflect.Advice
    public String getName() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            String name = this.adviceMethod.getName();
            if (name.startsWith(AjTypeImpl.ajcMagic)) {
                AdviceName adviceName = (AdviceName) this.adviceMethod.getAnnotation(AdviceName.class);
                return adviceName != null ? adviceName.value() : "";
            }
            return name;
        }
        return (String) invokeV.objValue;
    }

    @Override // org.aspectj.lang.reflect.Advice
    public AjType<?>[] getParameterTypes() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            if (this.parameterTypes == null) {
                Class<?>[] parameterTypes = this.adviceMethod.getParameterTypes();
                int i2 = 0;
                int i3 = 0;
                for (Class<?> cls : parameterTypes) {
                    if (cls.getPackage().getName().equals(AJC_INTERNAL)) {
                        i3++;
                    }
                }
                this.parameterTypes = new AjType[parameterTypes.length - i3];
                while (true) {
                    AjType[] ajTypeArr = this.parameterTypes;
                    if (i2 >= ajTypeArr.length) {
                        break;
                    }
                    ajTypeArr[i2] = AjTypeSystem.getAjType(parameterTypes[i2]);
                    i2++;
                }
            }
            return this.parameterTypes;
        }
        return (AjType[]) invokeV.objValue;
    }

    @Override // org.aspectj.lang.reflect.Advice
    public PointcutExpression getPointcutExpression() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? this.pointcutExpression : (PointcutExpression) invokeV.objValue;
    }

    /* JADX WARN: Code restructure failed: missing block: B:35:0x00aa, code lost:
        if (r10 != 3) goto L38;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public String toString() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            StringBuffer stringBuffer = new StringBuffer();
            if (getName().length() > 0) {
                stringBuffer.append("@AdviceName(\"");
                stringBuffer.append(getName());
                stringBuffer.append("\") ");
            }
            if (getKind() == AdviceKind.AROUND) {
                stringBuffer.append(this.adviceMethod.getGenericReturnType().toString());
                stringBuffer.append(" ");
            }
            int i2 = AnonymousClass1.$SwitchMap$org$aspectj$lang$reflect$AdviceKind[getKind().ordinal()];
            if (i2 == 1) {
                stringBuffer.append("after(");
            } else if (i2 == 2) {
                stringBuffer.append("after(");
            } else if (i2 == 3) {
                stringBuffer.append("after(");
            } else if (i2 == 4) {
                stringBuffer.append("around(");
            } else if (i2 == 5) {
                stringBuffer.append("before(");
            }
            AjType<?>[] parameterTypes = getParameterTypes();
            int length = parameterTypes.length;
            if (this.hasExtraParam) {
                length--;
            }
            int i3 = 0;
            int i4 = 0;
            while (i4 < length) {
                stringBuffer.append(parameterTypes[i4].getName());
                i4++;
                if (i4 < length) {
                    stringBuffer.append(",");
                }
            }
            stringBuffer.append(") ");
            int i5 = AnonymousClass1.$SwitchMap$org$aspectj$lang$reflect$AdviceKind[getKind().ordinal()];
            if (i5 == 2) {
                stringBuffer.append("returning");
                if (this.hasExtraParam) {
                    stringBuffer.append("(");
                    stringBuffer.append(parameterTypes[length - 1].getName());
                    stringBuffer.append(") ");
                }
            }
            stringBuffer.append("throwing");
            if (this.hasExtraParam) {
                stringBuffer.append("(");
                stringBuffer.append(parameterTypes[length - 1].getName());
                stringBuffer.append(") ");
            }
            AjType<?>[] exceptionTypes = getExceptionTypes();
            if (exceptionTypes.length > 0) {
                stringBuffer.append("throws ");
                while (i3 < exceptionTypes.length) {
                    stringBuffer.append(exceptionTypes[i3].getName());
                    i3++;
                    if (i3 < exceptionTypes.length) {
                        stringBuffer.append(",");
                    }
                }
                stringBuffer.append(" ");
            }
            stringBuffer.append(": ");
            stringBuffer.append(getPointcutExpression().asString());
            return stringBuffer.toString();
        }
        return (String) invokeV.objValue;
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public AdviceImpl(Method method, String str, AdviceKind adviceKind, String str2) {
        this(method, str, adviceKind);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {method, str, adviceKind, str2};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                this((Method) objArr2[0], (String) objArr2[1], (AdviceKind) objArr2[2]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.hasExtraParam = true;
    }
}
