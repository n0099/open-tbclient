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
/* loaded from: classes7.dex */
public class up6 implements np6 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public up6() {
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

    @Override // com.repackage.np6
    public wm<?, ?> a(BaseFragmentActivity baseFragmentActivity, BdUniqueId bdUniqueId) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, baseFragmentActivity, bdUniqueId)) == null) {
            if (baseFragmentActivity == null) {
                return null;
            }
            if (bdUniqueId == AdvertAppInfo.C) {
                wp6 wp6Var = new wp6(baseFragmentActivity, bdUniqueId);
                wp6Var.e0(qp6.e().d("pb_banner"));
                wp6Var.c0("pb");
                wp6Var.d0("pb_banner");
                return wp6Var;
            } else if (bdUniqueId == AdvertAppInfo.F) {
                wp6 wp6Var2 = new wp6(baseFragmentActivity, bdUniqueId);
                wp6Var2.e0("6051002523-210422477");
                wp6Var2.c0("pb");
                return wp6Var2;
            } else if (bdUniqueId == AdvertAppInfo.D) {
                return new vp6(baseFragmentActivity, bdUniqueId);
            } else {
                return null;
            }
        }
        return (wm) invokeLL.objValue;
    }

    @Override // com.repackage.np6
    public wm<?, ?> b(BaseFragmentActivity baseFragmentActivity, BdUniqueId bdUniqueId) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, baseFragmentActivity, bdUniqueId)) == null) {
            if (baseFragmentActivity == null) {
                return null;
            }
            if (bdUniqueId == AdvertAppInfo.E) {
                wp6 wp6Var = new wp6(baseFragmentActivity, bdUniqueId);
                wp6Var.e0(qp6.e().d("frs_feed"));
                wp6Var.c0("frs");
                wp6Var.d0("frs_feed");
                return wp6Var;
            } else if (bdUniqueId == AdvertAppInfo.D) {
                return new vp6(baseFragmentActivity, bdUniqueId);
            } else {
                return null;
            }
        }
        return (wm) invokeLL.objValue;
    }

    @Override // com.repackage.np6
    public wm<?, ?> c(BaseFragmentActivity baseFragmentActivity, BdUniqueId bdUniqueId) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, baseFragmentActivity, bdUniqueId)) == null) {
            if (baseFragmentActivity == null) {
                return null;
            }
            if (bdUniqueId == AdvertAppInfo.E) {
                wp6 wp6Var = new wp6(baseFragmentActivity, bdUniqueId);
                wp6Var.e0("6051001980-1210572494");
                wp6Var.c0("personalize");
                return wp6Var;
            } else if (bdUniqueId == AdvertAppInfo.D) {
                return new vp6(baseFragmentActivity, bdUniqueId);
            } else {
                return null;
            }
        }
        return (wm) invokeLL.objValue;
    }

    @Override // com.repackage.np6
    public wm<?, ?> d(BaseFragmentActivity baseFragmentActivity, BdUniqueId bdUniqueId) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048579, this, baseFragmentActivity, bdUniqueId)) == null) {
            if (baseFragmentActivity == null) {
                return null;
            }
            if (bdUniqueId == AdvertAppInfo.E) {
                wp6 wp6Var = new wp6(baseFragmentActivity, bdUniqueId);
                wp6Var.e0(qp6.e().d("frs_feed"));
                wp6Var.c0("frs");
                wp6Var.d0("frs_feed");
                return wp6Var;
            } else if (bdUniqueId == AdvertAppInfo.D) {
                return new vp6(baseFragmentActivity, bdUniqueId);
            } else {
                return null;
            }
        }
        return (wm) invokeLL.objValue;
    }
}
