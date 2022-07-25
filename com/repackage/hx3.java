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
/* loaded from: classes6.dex */
public class hx3 implements nh1 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public hx3() {
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

    @Override // com.repackage.nh1
    public List<f23> a(f13 f13Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, f13Var)) == null) {
            ArrayList arrayList = new ArrayList();
            arrayList.add(new xv3(f13Var));
            arrayList.add(new yv3(f13Var));
            return arrayList;
        }
        return (List) invokeL.objValue;
    }

    @Override // com.repackage.nh1
    public List<f23> b(f13 f13Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, f13Var)) == null) ? Arrays.asList(new kw3(f13Var), new zu3(f13Var), new iv3(f13Var), new vv3(f13Var)) : (List) invokeL.objValue;
    }

    @Override // com.repackage.nh1
    public List<f23> c(f13 f13Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, f13Var)) == null) {
            ArrayList arrayList = new ArrayList();
            arrayList.add(new q04(f13Var));
            arrayList.add(new p04(f13Var));
            return arrayList;
        }
        return (List) invokeL.objValue;
    }
}
