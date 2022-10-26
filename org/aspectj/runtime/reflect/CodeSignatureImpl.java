package org.aspectj.runtime.reflect;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import org.aspectj.lang.reflect.CodeSignature;
/* loaded from: classes8.dex */
public abstract class CodeSignatureImpl extends MemberSignatureImpl implements CodeSignature {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public Class[] exceptionTypes;
    public String[] parameterNames;
    public Class[] parameterTypes;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public CodeSignatureImpl(int i, String str, Class cls, Class[] clsArr, String[] strArr, Class[] clsArr2) {
        super(i, str, cls);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {Integer.valueOf(i), str, cls, clsArr, strArr, clsArr2};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super(((Integer) objArr2[0]).intValue(), (String) objArr2[1], (Class) objArr2[2]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.parameterTypes = clsArr;
        this.parameterNames = strArr;
        this.exceptionTypes = clsArr2;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public CodeSignatureImpl(String str) {
        super(str);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {str};
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                super((String) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
    }

    @Override // org.aspectj.lang.reflect.CodeSignature
    public Class[] getExceptionTypes() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            if (this.exceptionTypes == null) {
                this.exceptionTypes = extractTypes(5);
            }
            return this.exceptionTypes;
        }
        return (Class[]) invokeV.objValue;
    }

    @Override // org.aspectj.lang.reflect.CodeSignature
    public String[] getParameterNames() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            if (this.parameterNames == null) {
                this.parameterNames = extractStrings(4);
            }
            return this.parameterNames;
        }
        return (String[]) invokeV.objValue;
    }

    @Override // org.aspectj.lang.reflect.CodeSignature
    public Class[] getParameterTypes() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            if (this.parameterTypes == null) {
                this.parameterTypes = extractTypes(3);
            }
            return this.parameterTypes;
        }
        return (Class[]) invokeV.objValue;
    }
}
