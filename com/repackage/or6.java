package com.repackage;

import com.baidu.adp.BdUniqueId;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.BaseFragmentActivity;
import com.baidu.tbadk.core.data.AdvertAppInfo;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes6.dex */
public class or6 implements hr6 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public or6() {
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

    @Override // com.repackage.hr6
    public eo<?, ?> a(BaseFragmentActivity baseFragmentActivity, BdUniqueId bdUniqueId) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, baseFragmentActivity, bdUniqueId)) == null) {
            if (baseFragmentActivity == null) {
                return null;
            }
            if (bdUniqueId == AdvertAppInfo.C) {
                qr6 qr6Var = new qr6(baseFragmentActivity, bdUniqueId);
                qr6Var.e0(kr6.e().d("pb_banner"));
                qr6Var.c0("pb");
                qr6Var.d0("pb_banner");
                return qr6Var;
            } else if (bdUniqueId == AdvertAppInfo.F) {
                qr6 qr6Var2 = new qr6(baseFragmentActivity, bdUniqueId);
                qr6Var2.e0("6051002523-210422477");
                qr6Var2.c0("pb");
                return qr6Var2;
            } else if (bdUniqueId == AdvertAppInfo.D) {
                return new pr6(baseFragmentActivity, bdUniqueId);
            } else {
                return null;
            }
        }
        return (eo) invokeLL.objValue;
    }

    @Override // com.repackage.hr6
    public eo<?, ?> b(BaseFragmentActivity baseFragmentActivity, BdUniqueId bdUniqueId) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, baseFragmentActivity, bdUniqueId)) == null) {
            if (baseFragmentActivity == null) {
                return null;
            }
            if (bdUniqueId == AdvertAppInfo.E) {
                qr6 qr6Var = new qr6(baseFragmentActivity, bdUniqueId);
                qr6Var.e0(kr6.e().d("frs_feed"));
                qr6Var.c0("frs");
                qr6Var.d0("frs_feed");
                return qr6Var;
            } else if (bdUniqueId == AdvertAppInfo.D) {
                return new pr6(baseFragmentActivity, bdUniqueId);
            } else {
                return null;
            }
        }
        return (eo) invokeLL.objValue;
    }

    @Override // com.repackage.hr6
    public eo<?, ?> c(BaseFragmentActivity baseFragmentActivity, BdUniqueId bdUniqueId) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, baseFragmentActivity, bdUniqueId)) == null) {
            if (baseFragmentActivity == null) {
                return null;
            }
            if (bdUniqueId == AdvertAppInfo.E) {
                qr6 qr6Var = new qr6(baseFragmentActivity, bdUniqueId);
                qr6Var.e0("6051001980-1210572494");
                qr6Var.c0("personalize");
                return qr6Var;
            } else if (bdUniqueId == AdvertAppInfo.D) {
                return new pr6(baseFragmentActivity, bdUniqueId);
            } else {
                return null;
            }
        }
        return (eo) invokeLL.objValue;
    }

    @Override // com.repackage.hr6
    public eo<?, ?> d(BaseFragmentActivity baseFragmentActivity, BdUniqueId bdUniqueId) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048579, this, baseFragmentActivity, bdUniqueId)) == null) {
            if (baseFragmentActivity == null) {
                return null;
            }
            if (bdUniqueId == AdvertAppInfo.E) {
                qr6 qr6Var = new qr6(baseFragmentActivity, bdUniqueId);
                qr6Var.e0(kr6.e().d("frs_feed"));
                qr6Var.c0("frs");
                qr6Var.d0("frs_feed");
                return qr6Var;
            } else if (bdUniqueId == AdvertAppInfo.D) {
                return new pr6(baseFragmentActivity, bdUniqueId);
            } else {
                return null;
            }
        }
        return (eo) invokeLL.objValue;
    }
}
