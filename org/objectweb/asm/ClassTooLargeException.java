package org.objectweb.asm;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes8.dex */
public final class ClassTooLargeException extends IndexOutOfBoundsException {
    public static /* synthetic */ Interceptable $ic = null;
    public static final long serialVersionUID = 160715609518896765L;
    public transient /* synthetic */ FieldHolder $fh;
    public final String className;
    public final int constantPoolCount;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ClassTooLargeException(String str, int i) {
        super("Class too large: " + str);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {str, Integer.valueOf(i)};
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
        this.constantPoolCount = i;
    }

    public String getClassName() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.className : (String) invokeV.objValue;
    }

    public int getConstantPoolCount() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.constantPoolCount : invokeV.intValue;
    }
}
