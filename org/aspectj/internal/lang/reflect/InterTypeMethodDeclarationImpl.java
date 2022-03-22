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
import java.lang.reflect.TypeVariable;
import org.aspectj.lang.reflect.AjType;
import org.aspectj.lang.reflect.AjTypeSystem;
import org.aspectj.lang.reflect.InterTypeMethodDeclaration;
/* loaded from: classes8.dex */
public class InterTypeMethodDeclarationImpl extends InterTypeDeclarationImpl implements InterTypeMethodDeclaration {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public Method baseMethod;
    public AjType<?>[] exceptionTypes;
    public Type[] genericParameterTypes;
    public Type genericReturnType;
    public String name;
    public int parameterAdjustmentFactor;
    public AjType<?>[] parameterTypes;
    public AjType<?> returnType;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public InterTypeMethodDeclarationImpl(AjType<?> ajType, String str, int i, String str2, Method method) {
        super(ajType, str, i);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {ajType, str, Integer.valueOf(i), str2, method};
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
        this.parameterAdjustmentFactor = 1;
        this.name = str2;
        this.baseMethod = method;
    }

    @Override // org.aspectj.lang.reflect.InterTypeMethodDeclaration
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
    @Override // org.aspectj.lang.reflect.InterTypeMethodDeclaration
    public Type[] getGenericParameterTypes() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            Type[] genericParameterTypes = this.baseMethod.getGenericParameterTypes();
            int length = genericParameterTypes.length;
            int i = this.parameterAdjustmentFactor;
            AjType[] ajTypeArr = new AjType[length - i];
            while (i < genericParameterTypes.length) {
                if (genericParameterTypes[i] instanceof Class) {
                    ajTypeArr[i - this.parameterAdjustmentFactor] = AjTypeSystem.getAjType((Class) genericParameterTypes[i]);
                } else {
                    ajTypeArr[i - this.parameterAdjustmentFactor] = genericParameterTypes[i];
                }
                i++;
            }
            return ajTypeArr;
        }
        return (Type[]) invokeV.objValue;
    }

    @Override // org.aspectj.lang.reflect.InterTypeMethodDeclaration
    public Type getGenericReturnType() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            Type genericReturnType = this.baseMethod.getGenericReturnType();
            return genericReturnType instanceof Class ? AjTypeSystem.getAjType((Class) genericReturnType) : genericReturnType;
        }
        return (Type) invokeV.objValue;
    }

    @Override // org.aspectj.lang.reflect.InterTypeMethodDeclaration
    public String getName() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.name : (String) invokeV.objValue;
    }

    @Override // org.aspectj.lang.reflect.InterTypeMethodDeclaration
    public AjType<?>[] getParameterTypes() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            Class<?>[] parameterTypes = this.baseMethod.getParameterTypes();
            int length = parameterTypes.length;
            int i = this.parameterAdjustmentFactor;
            AjType<?>[] ajTypeArr = new AjType[length - i];
            while (i < parameterTypes.length) {
                ajTypeArr[i - this.parameterAdjustmentFactor] = AjTypeSystem.getAjType(parameterTypes[i]);
                i++;
            }
            return ajTypeArr;
        }
        return (AjType[]) invokeV.objValue;
    }

    @Override // org.aspectj.lang.reflect.InterTypeMethodDeclaration
    public AjType<?> getReturnType() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? AjTypeSystem.getAjType(this.baseMethod.getReturnType()) : (AjType) invokeV.objValue;
    }

    @Override // org.aspectj.lang.reflect.InterTypeMethodDeclaration
    public TypeVariable<Method>[] getTypeParameters() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? this.baseMethod.getTypeParameters() : (TypeVariable[]) invokeV.objValue;
    }

    public String toString() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            StringBuffer stringBuffer = new StringBuffer();
            stringBuffer.append(Modifier.toString(getModifiers()));
            stringBuffer.append(" ");
            stringBuffer.append(getReturnType().toString());
            stringBuffer.append(" ");
            stringBuffer.append(this.targetTypeName);
            stringBuffer.append(".");
            stringBuffer.append(getName());
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

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public InterTypeMethodDeclarationImpl(AjType<?> ajType, AjType<?> ajType2, Method method, int i) {
        super(ajType, ajType2, i);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {ajType, ajType2, method, Integer.valueOf(i)};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((AjType) objArr2[0], (AjType) objArr2[1], ((Integer) objArr2[2]).intValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.parameterAdjustmentFactor = 1;
        this.parameterAdjustmentFactor = 0;
        this.name = method.getName();
        this.baseMethod = method;
    }
}
