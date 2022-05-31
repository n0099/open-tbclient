package com.repackage;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.data.ThreadData;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes7.dex */
public class xy6 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final List<ThreadData> a;

    public xy6() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = new ArrayList();
    }

    public wy6 a(boolean z, uy6 uy6Var) {
        InterceptResult invokeZL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeZL = interceptable.invokeZL(1048576, this, z, uy6Var)) == null) {
            wy6 wy6Var = new wy6();
            wy6Var.c = uy6Var.i();
            wy6Var.e = uy6Var.a();
            wy6Var.f = uy6Var.c();
            ArrayList<ThreadData> h = uy6Var.h();
            if (z) {
                if (!ListUtils.isEmpty(h)) {
                    this.a.clear();
                    this.a.addAll(h);
                }
            } else if (!ListUtils.isEmpty(h)) {
                this.a.addAll(h);
            }
            ArrayList arrayList = new ArrayList();
            arrayList.addAll(this.a);
            tx6.e(true, arrayList, uy6Var.e());
            tx6.e(true, arrayList, uy6Var.f());
            tx6.e(true, arrayList, uy6Var.d());
            tx6.e(true, arrayList, uy6Var.g());
            wy6Var.a = tx6.c(arrayList);
            return wy6Var;
        }
        return (wy6) invokeZL.objValue;
    }

    public List<ThreadData> b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.a : (List) invokeV.objValue;
    }

    public boolean c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            List<ThreadData> list = this.a;
            if (list == null) {
                return false;
            }
            return !ListUtils.isEmpty(list);
        }
        return invokeV.booleanValue;
    }
}
