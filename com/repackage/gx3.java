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
public class gx3 implements mh1 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public gx3() {
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

    @Override // com.repackage.mh1
    public List<e23> a(e13 e13Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, e13Var)) == null) {
            ArrayList arrayList = new ArrayList();
            arrayList.add(new wv3(e13Var));
            arrayList.add(new xv3(e13Var));
            return arrayList;
        }
        return (List) invokeL.objValue;
    }

    @Override // com.repackage.mh1
    public List<e23> b(e13 e13Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, e13Var)) == null) ? Arrays.asList(new jw3(e13Var), new yu3(e13Var), new hv3(e13Var), new uv3(e13Var)) : (List) invokeL.objValue;
    }

    @Override // com.repackage.mh1
    public List<e23> c(e13 e13Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, e13Var)) == null) {
            ArrayList arrayList = new ArrayList();
            arrayList.add(new p04(e13Var));
            arrayList.add(new o04(e13Var));
            return arrayList;
        }
        return (List) invokeL.objValue;
    }
}
