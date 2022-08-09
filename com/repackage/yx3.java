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
public class yx3 implements ei1 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public yx3() {
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

    @Override // com.repackage.ei1
    public List<w23> a(w13 w13Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, w13Var)) == null) {
            ArrayList arrayList = new ArrayList();
            arrayList.add(new ow3(w13Var));
            arrayList.add(new pw3(w13Var));
            return arrayList;
        }
        return (List) invokeL.objValue;
    }

    @Override // com.repackage.ei1
    public List<w23> b(w13 w13Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, w13Var)) == null) ? Arrays.asList(new bx3(w13Var), new qv3(w13Var), new zv3(w13Var), new mw3(w13Var)) : (List) invokeL.objValue;
    }

    @Override // com.repackage.ei1
    public List<w23> c(w13 w13Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, w13Var)) == null) {
            ArrayList arrayList = new ArrayList();
            arrayList.add(new h14(w13Var));
            arrayList.add(new g14(w13Var));
            return arrayList;
        }
        return (List) invokeL.objValue;
    }
}
