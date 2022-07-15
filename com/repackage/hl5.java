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
public class hl5 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public List<ll5> a;
    public List<ll5> b;

    public hl5() {
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

    public List<ll5> a() {
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

    public final boolean b(List<ll5> list, az4 az4Var) {
        InterceptResult invokeLL;
        List<az4> a;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, list, az4Var)) == null) {
            if (list != null && az4Var != null) {
                for (ll5 ll5Var : list) {
                    if (ll5Var != null && (a = ll5Var.a()) != null) {
                        for (az4 az4Var2 : a) {
                            if (az4Var2 != null && az4Var2.d() == az4Var.d()) {
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
                        ll5 ll5Var = new ll5();
                        ll5Var.d(robotslist);
                        this.b.add(ll5Var);
                    }
                }
            }
            if (dataRes != null && dataRes.address_list != null) {
                this.a = new ArrayList();
                for (listData listdata : dataRes.address_list) {
                    if (TextUtils.isEmpty(listdata.key)) {
                        z = true;
                    } else {
                        ll5 ll5Var2 = new ll5();
                        ll5Var2.c(listdata);
                        if (ll5Var2.a() != null) {
                            for (az4 az4Var : ll5Var2.a()) {
                                if (b(this.b, az4Var)) {
                                    az4Var.q(1);
                                } else {
                                    az4Var.q(0);
                                }
                            }
                        }
                        this.a.add(ll5Var2);
                    }
                }
            }
            return z;
        }
        return invokeL.booleanValue;
    }
}
