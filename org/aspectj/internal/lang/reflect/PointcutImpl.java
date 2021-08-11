package org.aspectj.internal.lang.reflect;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.lang.reflect.Method;
import java.util.StringTokenizer;
import org.aspectj.lang.reflect.AjType;
import org.aspectj.lang.reflect.AjTypeSystem;
import org.aspectj.lang.reflect.Pointcut;
import org.aspectj.lang.reflect.PointcutExpression;
/* loaded from: classes2.dex */
public class PointcutImpl implements Pointcut {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final Method baseMethod;
    public final AjType declaringType;
    public final String name;
    public String[] parameterNames;
    public final PointcutExpression pc;

    public PointcutImpl(String str, String str2, Method method, AjType ajType, String str3) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {str, str2, method, ajType, str3};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.parameterNames = new String[0];
        this.name = str;
        this.pc = new PointcutExpressionImpl(str2);
        this.baseMethod = method;
        this.declaringType = ajType;
        this.parameterNames = splitOnComma(str3);
    }

    private String[] splitOnComma(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, this, str)) == null) {
            StringTokenizer stringTokenizer = new StringTokenizer(str, ",");
            int countTokens = stringTokenizer.countTokens();
            String[] strArr = new String[countTokens];
            for (int i2 = 0; i2 < countTokens; i2++) {
                strArr[i2] = stringTokenizer.nextToken().trim();
            }
            return strArr;
        }
        return (String[]) invokeL.objValue;
    }

    @Override // org.aspectj.lang.reflect.Pointcut
    public AjType getDeclaringType() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.declaringType : (AjType) invokeV.objValue;
    }

    @Override // org.aspectj.lang.reflect.Pointcut
    public int getModifiers() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.baseMethod.getModifiers() : invokeV.intValue;
    }

    @Override // org.aspectj.lang.reflect.Pointcut
    public String getName() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.name : (String) invokeV.objValue;
    }

    @Override // org.aspectj.lang.reflect.Pointcut
    public String[] getParameterNames() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.parameterNames : (String[]) invokeV.objValue;
    }

    @Override // org.aspectj.lang.reflect.Pointcut
    public AjType<?>[] getParameterTypes() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            Class<?>[] parameterTypes = this.baseMethod.getParameterTypes();
            int length = parameterTypes.length;
            AjType<?>[] ajTypeArr = new AjType[length];
            for (int i2 = 0; i2 < length; i2++) {
                ajTypeArr[i2] = AjTypeSystem.getAjType(parameterTypes[i2]);
            }
            return ajTypeArr;
        }
        return (AjType[]) invokeV.objValue;
    }

    @Override // org.aspectj.lang.reflect.Pointcut
    public PointcutExpression getPointcutExpression() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.pc : (PointcutExpression) invokeV.objValue;
    }

    public String toString() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            StringBuffer stringBuffer = new StringBuffer();
            stringBuffer.append(getName());
            stringBuffer.append("(");
            AjType<?>[] parameterTypes = getParameterTypes();
            int i2 = 0;
            while (i2 < parameterTypes.length) {
                stringBuffer.append(parameterTypes[i2].getName());
                String[] strArr = this.parameterNames;
                if (strArr != null && strArr[i2] != null) {
                    stringBuffer.append(" ");
                    stringBuffer.append(this.parameterNames[i2]);
                }
                i2++;
                if (i2 < parameterTypes.length) {
                    stringBuffer.append(",");
                }
            }
            stringBuffer.append(") : ");
            stringBuffer.append(getPointcutExpression().asString());
            return stringBuffer.toString();
        }
        return (String) invokeV.objValue;
    }
}
