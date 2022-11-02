package org.objectweb.asm;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes9.dex */
public final class MethodTooLargeException extends IndexOutOfBoundsException {
    public static /* synthetic */ Interceptable $ic = null;
    public static final long serialVersionUID = 6807380416709738314L;
    public transient /* synthetic */ FieldHolder $fh;
    public final String className;
    public final int codeSize;
    public final String descriptor;
    public final String methodName;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public MethodTooLargeException(String str, String str2, String str3, int i) {
        super("Method too large: " + str + "." + str2 + " " + str3);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {str, str2, str3, Integer.valueOf(i)};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                super((String) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.className = str;
        this.methodName = str2;
        this.descriptor = str3;
        this.codeSize = i;
    }

    public String getClassName() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            return this.className;
        }
        return (String) invokeV.objValue;
    }

    public int getCodeSize() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            return this.codeSize;
        }
        return invokeV.intValue;
    }

    public String getDescriptor() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            return this.descriptor;
        }
        return (String) invokeV.objValue;
    }

    public String getMethodName() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            return this.methodName;
        }
        return (String) invokeV.objValue;
    }
}
