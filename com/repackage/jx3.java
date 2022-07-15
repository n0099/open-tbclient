package com.repackage;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.pyramid.annotation.Service;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.net.MalformedURLException;
@Service
/* loaded from: classes6.dex */
public class jx3 implements oh1 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public jx3() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
            }
        }
    }

    @Override // com.repackage.oh1
    public String a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? cu3.g() : (String) invokeV.objValue;
    }

    @Override // com.repackage.oh1
    public boolean b() {
        InterceptResult invokeV;
        nz1 m;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            if (h03.M() == null || !h03.M().w0()) {
                return false;
            }
            qz1 V = ul2.U().V();
            if (V == null || (m = V.m()) == null || !(m instanceof dw3)) {
                return true;
            }
            return ((dw3) m).D3();
        }
        return invokeV.booleanValue;
    }

    @Override // com.repackage.oh1
    public String c(String str) throws MalformedURLException {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str)) == null) ? cu3.d(str) : (String) invokeL.objValue;
    }
}
