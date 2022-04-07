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
    public List<g23> a(g13 g13Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, g13Var)) == null) {
            ArrayList arrayList = new ArrayList();
            arrayList.add(new yv3(g13Var));
            arrayList.add(new zv3(g13Var));
            return arrayList;
        }
        return (List) invokeL.objValue;
    }

    @Override // com.repackage.oh1
    public List<g23> b(g13 g13Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, g13Var)) == null) ? Arrays.asList(new lw3(g13Var), new av3(g13Var), new jv3(g13Var), new wv3(g13Var)) : (List) invokeL.objValue;
    }

    @Override // com.repackage.oh1
    public List<g23> c(g13 g13Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, g13Var)) == null) {
            ArrayList arrayList = new ArrayList();
            arrayList.add(new s04(g13Var));
            arrayList.add(new r04(g13Var));
            return arrayList;
        }
        return (List) invokeL.objValue;
    }
}
