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
public class tx3 implements zh1 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public tx3() {
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

    @Override // com.repackage.zh1
    public List<r23> a(r13 r13Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, r13Var)) == null) {
            ArrayList arrayList = new ArrayList();
            arrayList.add(new jw3(r13Var));
            arrayList.add(new kw3(r13Var));
            return arrayList;
        }
        return (List) invokeL.objValue;
    }

    @Override // com.repackage.zh1
    public List<r23> b(r13 r13Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, r13Var)) == null) ? Arrays.asList(new ww3(r13Var), new lv3(r13Var), new uv3(r13Var), new hw3(r13Var)) : (List) invokeL.objValue;
    }

    @Override // com.repackage.zh1
    public List<r23> c(r13 r13Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, r13Var)) == null) {
            ArrayList arrayList = new ArrayList();
            arrayList.add(new c14(r13Var));
            arrayList.add(new b14(r13Var));
            return arrayList;
        }
        return (List) invokeL.objValue;
    }
}
