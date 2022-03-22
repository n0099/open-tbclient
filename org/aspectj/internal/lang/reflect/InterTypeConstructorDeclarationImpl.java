package org.aspectj.internal.lang.reflect;

import com.baidu.android.common.others.lang.StringUtil;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.data.SmallTailInfo;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.lang.reflect.Type;
import org.aspectj.lang.reflect.AjType;
import org.aspectj.lang.reflect.AjTypeSystem;
import org.aspectj.lang.reflect.InterTypeConstructorDeclaration;
/* loaded from: classes8.dex */
public class InterTypeConstructorDeclarationImpl extends InterTypeDeclarationImpl implements InterTypeConstructorDeclaration {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public Method baseMethod;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public InterTypeConstructorDeclarationImpl(AjType<?> ajType, String str, int i, Method method) {
        super(ajType, str, i);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {ajType, str, Integer.valueOf(i), method};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((AjType) objArr2[0], (String) objArr2[1], ((Integer) objArr2[2]).intValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.baseMethod = method;
    }

    @Override // org.aspectj.lang.reflect.InterTypeConstructorDeclaration
    public AjType<?>[] getExceptionTypes() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            Class<?>[] exceptionTypes = this.baseMethod.getExceptionTypes();
            AjType<?>[] ajTypeArr = new AjType[exceptionTypes.length];
            for (int i = 0; i < exceptionTypes.length; i++) {
                ajTypeArr[i] = AjTypeSystem.getAjType(exceptionTypes[i]);
            }
            return ajTypeArr;
        }
        return (AjType[]) invokeV.objValue;
    }

    /* JADX DEBUG: Multi-variable search result rejected for r1v4, resolved type: org.aspectj.lang.reflect.AjType[] */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // org.aspectj.lang.reflect.InterTypeConstructorDeclaration
    public Type[] getGenericParameterTypes() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            Type[] genericParameterTypes = this.baseMethod.getGenericParameterTypes();
            AjType[] ajTypeArr = new AjType[genericParameterTypes.length - 1];
            for (int i = 1; i < genericParameterTypes.length; i++) {
                if (genericParameterTypes[i] instanceof Class) {
                    ajTypeArr[i - 1] = AjTypeSystem.getAjType((Class) genericParameterTypes[i]);
                } else {
                    ajTypeArr[i - 1] = genericParameterTypes[i];
                }
            }
            return ajTypeArr;
        }
        return (Type[]) invokeV.objValue;
    }

    @Override // org.aspectj.lang.reflect.InterTypeConstructorDeclaration
    public AjType<?>[] getParameterTypes() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            Class<?>[] parameterTypes = this.baseMethod.getParameterTypes();
            AjType<?>[] ajTypeArr = new AjType[parameterTypes.length - 1];
            for (int i = 1; i < parameterTypes.length; i++) {
                ajTypeArr[i - 1] = AjTypeSystem.getAjType(parameterTypes[i]);
            }
            return ajTypeArr;
        }
        return (AjType[]) invokeV.objValue;
    }

    public String toString() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            StringBuffer stringBuffer = new StringBuffer();
            stringBuffer.append(Modifier.toString(getModifiers()));
            stringBuffer.append(" ");
            stringBuffer.append(this.targetTypeName);
            stringBuffer.append(".new");
            stringBuffer.append("(");
            AjType<?>[] parameterTypes = getParameterTypes();
            for (int i = 0; i < parameterTypes.length - 1; i++) {
                stringBuffer.append(parameterTypes[i].toString());
                stringBuffer.append(StringUtil.ARRAY_ELEMENT_SEPARATOR);
            }
            if (parameterTypes.length > 0) {
                stringBuffer.append(parameterTypes[parameterTypes.length - 1].toString());
            }
            stringBuffer.append(SmallTailInfo.EMOTION_SUFFIX);
            return stringBuffer.toString();
        }
        return (String) invokeV.objValue;
    }
}
