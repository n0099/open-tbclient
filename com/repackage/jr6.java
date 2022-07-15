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
public class jr6 implements cr6 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public jr6() {
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

    @Override // com.repackage.cr6
    public an<?, ?> a(BaseFragmentActivity baseFragmentActivity, BdUniqueId bdUniqueId) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, baseFragmentActivity, bdUniqueId)) == null) {
            if (baseFragmentActivity == null) {
                return null;
            }
            if (bdUniqueId == AdvertAppInfo.C) {
                lr6 lr6Var = new lr6(baseFragmentActivity, bdUniqueId);
                lr6Var.e0(fr6.e().d("pb_banner"));
                lr6Var.c0("pb");
                lr6Var.d0("pb_banner");
                return lr6Var;
            } else if (bdUniqueId == AdvertAppInfo.F) {
                lr6 lr6Var2 = new lr6(baseFragmentActivity, bdUniqueId);
                lr6Var2.e0(zq6.f());
                lr6Var2.c0("pb");
                return lr6Var2;
            } else if (bdUniqueId == AdvertAppInfo.D) {
                return new kr6(baseFragmentActivity, bdUniqueId);
            } else {
                return null;
            }
        }
        return (an) invokeLL.objValue;
    }

    @Override // com.repackage.cr6
    public an<?, ?> b(BaseFragmentActivity baseFragmentActivity, BdUniqueId bdUniqueId) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, baseFragmentActivity, bdUniqueId)) == null) {
            if (baseFragmentActivity == null) {
                return null;
            }
            if (bdUniqueId == AdvertAppInfo.E) {
                lr6 lr6Var = new lr6(baseFragmentActivity, bdUniqueId);
                lr6Var.e0(fr6.e().d("frs_feed"));
                lr6Var.c0("frs");
                lr6Var.d0("frs_feed");
                return lr6Var;
            } else if (bdUniqueId == AdvertAppInfo.D) {
                return new kr6(baseFragmentActivity, bdUniqueId);
            } else {
                return null;
            }
        }
        return (an) invokeLL.objValue;
    }

    @Override // com.repackage.cr6
    public an<?, ?> c(BaseFragmentActivity baseFragmentActivity, BdUniqueId bdUniqueId) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, baseFragmentActivity, bdUniqueId)) == null) {
            if (baseFragmentActivity == null) {
                return null;
            }
            if (bdUniqueId == AdvertAppInfo.E) {
                lr6 lr6Var = new lr6(baseFragmentActivity, bdUniqueId);
                lr6Var.e0(zq6.g());
                lr6Var.c0("personalize");
                return lr6Var;
            } else if (bdUniqueId == AdvertAppInfo.D) {
                return new kr6(baseFragmentActivity, bdUniqueId);
            } else {
                return null;
            }
        }
        return (an) invokeLL.objValue;
    }

    @Override // com.repackage.cr6
    public an<?, ?> d(BaseFragmentActivity baseFragmentActivity, BdUniqueId bdUniqueId) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048579, this, baseFragmentActivity, bdUniqueId)) == null) {
            if (baseFragmentActivity == null) {
                return null;
            }
            if (bdUniqueId == AdvertAppInfo.E) {
                lr6 lr6Var = new lr6(baseFragmentActivity, bdUniqueId);
                lr6Var.e0(fr6.e().d("frs_feed"));
                lr6Var.c0("frs");
                lr6Var.d0("frs_feed");
                return lr6Var;
            } else if (bdUniqueId == AdvertAppInfo.D) {
                return new kr6(baseFragmentActivity, bdUniqueId);
            } else {
                return null;
            }
        }
        return (an) invokeLL.objValue;
    }
}
