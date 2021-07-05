package com.yy.hiidostatis.config;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* loaded from: classes8.dex */
public final class ABNameDefine {
    public static final /* synthetic */ ABNameDefine[] $VALUES;
    public static /* synthetic */ Interceptable $ic;
    public static final ABNameDefine GSLB;
    public static final ABNameDefine NEW_PACKER_MODULE;
    public static final ABNameDefine NEW_SEND_MODULE;
    public static final ABNameDefine VERIFY_RETURN;
    public transient /* synthetic */ FieldHolder $fh;
    public int defaultValue;
    public String name;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1260368742, "Lcom/yy/hiidostatis/config/ABNameDefine;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-1260368742, "Lcom/yy/hiidostatis/config/ABNameDefine;");
                return;
            }
        }
        GSLB = new ABNameDefine("GSLB", 0, "gslb", 1);
        VERIFY_RETURN = new ABNameDefine("VERIFY_RETURN", 1, "verifyreturn", 1);
        NEW_SEND_MODULE = new ABNameDefine("NEW_SEND_MODULE", 2, "newsendmodule", 1);
        ABNameDefine aBNameDefine = new ABNameDefine("NEW_PACKER_MODULE", 3, "newpackermodule", 1);
        NEW_PACKER_MODULE = aBNameDefine;
        $VALUES = new ABNameDefine[]{GSLB, VERIFY_RETURN, NEW_SEND_MODULE, aBNameDefine};
    }

    public ABNameDefine(String str, int i2, String str2, int i3) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {str, Integer.valueOf(i2), str2, Integer.valueOf(i3)};
            interceptable.invokeUnInit(65537, newInitContext);
            int i4 = newInitContext.flag;
            if ((i4 & 1) != 0) {
                int i5 = i4 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                String str3 = (String) objArr2[0];
                ((Integer) objArr2[1]).intValue();
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.name = str2;
        this.defaultValue = i3;
    }

    public static ABNameDefine valueOf(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65538, null, str)) == null) ? (ABNameDefine) Enum.valueOf(ABNameDefine.class, str) : (ABNameDefine) invokeL.objValue;
    }

    public static ABNameDefine[] values() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) ? (ABNameDefine[]) $VALUES.clone() : (ABNameDefine[]) invokeV.objValue;
    }

    public int getDefaultValue() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.defaultValue : invokeV.intValue;
    }

    public String getName() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.name : (String) invokeV.objValue;
    }

    public void setDefaultValue(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(Constants.METHOD_SEND_USER_MSG, this, i2) == null) {
            this.defaultValue = i2;
        }
    }

    public void setName(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, str) == null) {
            this.name = str;
        }
    }
}
