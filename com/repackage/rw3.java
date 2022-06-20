package com.repackage;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.pyramid.annotation.Service;
import com.baidu.pyramid.annotation.Singleton;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
@Singleton
@Service
/* loaded from: classes7.dex */
public class rw3 implements xg1 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public rw3() {
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

    @Override // com.repackage.xg1
    public List<p13> a(p03 p03Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, p03Var)) == null) {
            ArrayList arrayList = new ArrayList();
            arrayList.add(new hv3(p03Var));
            arrayList.add(new iv3(p03Var));
            return arrayList;
        }
        return (List) invokeL.objValue;
    }

    @Override // com.repackage.xg1
    public List<p13> b(p03 p03Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, p03Var)) == null) ? Arrays.asList(new uv3(p03Var), new ju3(p03Var), new su3(p03Var), new fv3(p03Var)) : (List) invokeL.objValue;
    }

    @Override // com.repackage.xg1
    public List<p13> c(p03 p03Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, p03Var)) == null) {
            ArrayList arrayList = new ArrayList();
            arrayList.add(new a04(p03Var));
            arrayList.add(new zz3(p03Var));
            return arrayList;
        }
        return (List) invokeL.objValue;
    }
}
