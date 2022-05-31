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
public class gw3 implements mg1 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public gw3() {
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

    @Override // com.repackage.mg1
    public List<e13> a(e03 e03Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, e03Var)) == null) {
            ArrayList arrayList = new ArrayList();
            arrayList.add(new wu3(e03Var));
            arrayList.add(new xu3(e03Var));
            return arrayList;
        }
        return (List) invokeL.objValue;
    }

    @Override // com.repackage.mg1
    public List<e13> b(e03 e03Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, e03Var)) == null) ? Arrays.asList(new jv3(e03Var), new yt3(e03Var), new hu3(e03Var), new uu3(e03Var)) : (List) invokeL.objValue;
    }

    @Override // com.repackage.mg1
    public List<e13> c(e03 e03Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, e03Var)) == null) {
            ArrayList arrayList = new ArrayList();
            arrayList.add(new pz3(e03Var));
            arrayList.add(new oz3(e03Var));
            return arrayList;
        }
        return (List) invokeL.objValue;
    }
}
