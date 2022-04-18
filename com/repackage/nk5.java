package com.repackage;

import android.text.TextUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.List;
import tbclient.GetAddressList.DataRes;
import tbclient.GetAddressList.listData;
import tbclient.GetAddressList.robotsList;
/* loaded from: classes6.dex */
public class nk5 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public List<rk5> a;
    public List<rk5> b;

    public nk5() {
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

    public List<rk5> a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            if (this.a == null) {
                this.a = new ArrayList();
            }
            return this.a;
        }
        return (List) invokeV.objValue;
    }

    public final boolean b(List<rk5> list, iy4 iy4Var) {
        InterceptResult invokeLL;
        List<iy4> a;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, list, iy4Var)) == null) {
            if (list != null && iy4Var != null) {
                for (rk5 rk5Var : list) {
                    if (rk5Var != null && (a = rk5Var.a()) != null) {
                        for (iy4 iy4Var2 : a) {
                            if (iy4Var2 != null && iy4Var2.e() == iy4Var.e()) {
                                return true;
                            }
                        }
                        continue;
                    }
                }
            }
            return false;
        }
        return invokeLL.booleanValue;
    }

    public boolean c(DataRes dataRes) {
        InterceptResult invokeL;
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, dataRes)) == null) {
            if (dataRes == null || dataRes.robots_list == null) {
                z = false;
            } else {
                this.b = new ArrayList();
                z = false;
                for (robotsList robotslist : dataRes.robots_list) {
                    if (TextUtils.isEmpty(robotslist.key)) {
                        z = true;
                    } else {
                        rk5 rk5Var = new rk5();
                        rk5Var.d(robotslist);
                        this.b.add(rk5Var);
                    }
                }
            }
            if (dataRes != null && dataRes.address_list != null) {
                this.a = new ArrayList();
                for (listData listdata : dataRes.address_list) {
                    if (TextUtils.isEmpty(listdata.key)) {
                        z = true;
                    } else {
                        rk5 rk5Var2 = new rk5();
                        rk5Var2.c(listdata);
                        if (rk5Var2.a() != null) {
                            for (iy4 iy4Var : rk5Var2.a()) {
                                if (b(this.b, iy4Var)) {
                                    iy4Var.r(1);
                                } else {
                                    iy4Var.r(0);
                                }
                            }
                        }
                        this.a.add(rk5Var2);
                    }
                }
            }
            return z;
        }
        return invokeL.booleanValue;
    }
}
