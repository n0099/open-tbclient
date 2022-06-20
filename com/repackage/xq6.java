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
public class xq6 implements qq6 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public xq6() {
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

    @Override // com.repackage.qq6
    public an<?, ?> a(BaseFragmentActivity baseFragmentActivity, BdUniqueId bdUniqueId) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, baseFragmentActivity, bdUniqueId)) == null) {
            if (baseFragmentActivity == null) {
                return null;
            }
            if (bdUniqueId == AdvertAppInfo.C) {
                zq6 zq6Var = new zq6(baseFragmentActivity, bdUniqueId);
                zq6Var.e0(tq6.e().d("pb_banner"));
                zq6Var.c0("pb");
                zq6Var.d0("pb_banner");
                return zq6Var;
            } else if (bdUniqueId == AdvertAppInfo.F) {
                zq6 zq6Var2 = new zq6(baseFragmentActivity, bdUniqueId);
                zq6Var2.e0(nq6.f());
                zq6Var2.c0("pb");
                return zq6Var2;
            } else if (bdUniqueId == AdvertAppInfo.D) {
                return new yq6(baseFragmentActivity, bdUniqueId);
            } else {
                return null;
            }
        }
        return (an) invokeLL.objValue;
    }

    @Override // com.repackage.qq6
    public an<?, ?> b(BaseFragmentActivity baseFragmentActivity, BdUniqueId bdUniqueId) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, baseFragmentActivity, bdUniqueId)) == null) {
            if (baseFragmentActivity == null) {
                return null;
            }
            if (bdUniqueId == AdvertAppInfo.E) {
                zq6 zq6Var = new zq6(baseFragmentActivity, bdUniqueId);
                zq6Var.e0(tq6.e().d("frs_feed"));
                zq6Var.c0("frs");
                zq6Var.d0("frs_feed");
                return zq6Var;
            } else if (bdUniqueId == AdvertAppInfo.D) {
                return new yq6(baseFragmentActivity, bdUniqueId);
            } else {
                return null;
            }
        }
        return (an) invokeLL.objValue;
    }

    @Override // com.repackage.qq6
    public an<?, ?> c(BaseFragmentActivity baseFragmentActivity, BdUniqueId bdUniqueId) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, baseFragmentActivity, bdUniqueId)) == null) {
            if (baseFragmentActivity == null) {
                return null;
            }
            if (bdUniqueId == AdvertAppInfo.E) {
                zq6 zq6Var = new zq6(baseFragmentActivity, bdUniqueId);
                zq6Var.e0(nq6.g());
                zq6Var.c0("personalize");
                return zq6Var;
            } else if (bdUniqueId == AdvertAppInfo.D) {
                return new yq6(baseFragmentActivity, bdUniqueId);
            } else {
                return null;
            }
        }
        return (an) invokeLL.objValue;
    }

    @Override // com.repackage.qq6
    public an<?, ?> d(BaseFragmentActivity baseFragmentActivity, BdUniqueId bdUniqueId) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048579, this, baseFragmentActivity, bdUniqueId)) == null) {
            if (baseFragmentActivity == null) {
                return null;
            }
            if (bdUniqueId == AdvertAppInfo.E) {
                zq6 zq6Var = new zq6(baseFragmentActivity, bdUniqueId);
                zq6Var.e0(tq6.e().d("frs_feed"));
                zq6Var.c0("frs");
                zq6Var.d0("frs_feed");
                return zq6Var;
            } else if (bdUniqueId == AdvertAppInfo.D) {
                return new yq6(baseFragmentActivity, bdUniqueId);
            } else {
                return null;
            }
        }
        return (an) invokeLL.objValue;
    }
}
