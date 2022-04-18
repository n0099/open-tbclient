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
public class os6 implements hs6 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public os6() {
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

    @Override // com.repackage.hs6
    public ho<?, ?> a(BaseFragmentActivity baseFragmentActivity, BdUniqueId bdUniqueId) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, baseFragmentActivity, bdUniqueId)) == null) {
            if (baseFragmentActivity == null) {
                return null;
            }
            if (bdUniqueId == AdvertAppInfo.F) {
                qs6 qs6Var = new qs6(baseFragmentActivity, bdUniqueId);
                qs6Var.e0(ks6.e().d("pb_banner"));
                qs6Var.c0("pb");
                qs6Var.d0("pb_banner");
                return qs6Var;
            } else if (bdUniqueId == AdvertAppInfo.I) {
                qs6 qs6Var2 = new qs6(baseFragmentActivity, bdUniqueId);
                qs6Var2.e0("6051002523-210422477");
                qs6Var2.c0("pb");
                return qs6Var2;
            } else if (bdUniqueId == AdvertAppInfo.G) {
                return new ps6(baseFragmentActivity, bdUniqueId);
            } else {
                return null;
            }
        }
        return (ho) invokeLL.objValue;
    }

    @Override // com.repackage.hs6
    public ho<?, ?> b(BaseFragmentActivity baseFragmentActivity, BdUniqueId bdUniqueId) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, baseFragmentActivity, bdUniqueId)) == null) {
            if (baseFragmentActivity == null) {
                return null;
            }
            if (bdUniqueId == AdvertAppInfo.H) {
                qs6 qs6Var = new qs6(baseFragmentActivity, bdUniqueId);
                qs6Var.e0(ks6.e().d("frs_feed"));
                qs6Var.c0("frs");
                qs6Var.d0("frs_feed");
                return qs6Var;
            } else if (bdUniqueId == AdvertAppInfo.G) {
                return new ps6(baseFragmentActivity, bdUniqueId);
            } else {
                return null;
            }
        }
        return (ho) invokeLL.objValue;
    }

    @Override // com.repackage.hs6
    public ho<?, ?> c(BaseFragmentActivity baseFragmentActivity, BdUniqueId bdUniqueId) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, baseFragmentActivity, bdUniqueId)) == null) {
            if (baseFragmentActivity == null) {
                return null;
            }
            if (bdUniqueId == AdvertAppInfo.H) {
                qs6 qs6Var = new qs6(baseFragmentActivity, bdUniqueId);
                qs6Var.e0("6051001980-1210572494");
                qs6Var.c0("personalize");
                return qs6Var;
            } else if (bdUniqueId == AdvertAppInfo.G) {
                return new ps6(baseFragmentActivity, bdUniqueId);
            } else {
                return null;
            }
        }
        return (ho) invokeLL.objValue;
    }

    @Override // com.repackage.hs6
    public ho<?, ?> d(BaseFragmentActivity baseFragmentActivity, BdUniqueId bdUniqueId) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048579, this, baseFragmentActivity, bdUniqueId)) == null) {
            if (baseFragmentActivity == null) {
                return null;
            }
            if (bdUniqueId == AdvertAppInfo.H) {
                qs6 qs6Var = new qs6(baseFragmentActivity, bdUniqueId);
                qs6Var.e0(ks6.e().d("frs_feed"));
                qs6Var.c0("frs");
                qs6Var.d0("frs_feed");
                return qs6Var;
            } else if (bdUniqueId == AdvertAppInfo.G) {
                return new ps6(baseFragmentActivity, bdUniqueId);
            } else {
                return null;
            }
        }
        return (ho) invokeLL.objValue;
    }
}
