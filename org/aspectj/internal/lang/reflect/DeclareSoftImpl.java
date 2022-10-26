package org.aspectj.internal.lang.reflect;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.baidu.webkit.sdk.dumper.ZeusCrashHandler;
import org.aspectj.lang.reflect.AjType;
import org.aspectj.lang.reflect.AjTypeSystem;
import org.aspectj.lang.reflect.DeclareSoft;
import org.aspectj.lang.reflect.PointcutExpression;
/* loaded from: classes8.dex */
public class DeclareSoftImpl implements DeclareSoft {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public AjType declaringType;
    public AjType exceptionType;
    public String missingTypeName;
    public PointcutExpression pointcut;

    public DeclareSoftImpl(AjType ajType, String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {ajType, str, str2};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.declaringType = ajType;
        this.pointcut = new PointcutExpressionImpl(str);
        try {
            this.exceptionType = AjTypeSystem.getAjType(Class.forName(str2, false, ajType.getJavaClass().getClassLoader()));
        } catch (ClassNotFoundException unused) {
            this.missingTypeName = str2;
        }
    }

    @Override // org.aspectj.lang.reflect.DeclareSoft
    public AjType getDeclaringType() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            return this.declaringType;
        }
        return (AjType) invokeV.objValue;
    }

    @Override // org.aspectj.lang.reflect.DeclareSoft
    public PointcutExpression getPointcutExpression() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            return this.pointcut;
        }
        return (PointcutExpression) invokeV.objValue;
    }

    @Override // org.aspectj.lang.reflect.DeclareSoft
    public AjType getSoftenedExceptionType() throws ClassNotFoundException {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            if (this.missingTypeName == null) {
                return this.exceptionType;
            }
            throw new ClassNotFoundException(this.missingTypeName);
        }
        return (AjType) invokeV.objValue;
    }

    public String toString() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            StringBuffer stringBuffer = new StringBuffer();
            stringBuffer.append("declare soft : ");
            String str = this.missingTypeName;
            if (str != null) {
                stringBuffer.append(this.exceptionType.getName());
            } else {
                stringBuffer.append(str);
            }
            stringBuffer.append(ZeusCrashHandler.NAME_SEPERATOR);
            stringBuffer.append(getPointcutExpression().asString());
            return stringBuffer.toString();
        }
        return (String) invokeV.objValue;
    }
}
