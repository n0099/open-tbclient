package d.a.q0.w0;

import com.baidu.adp.BdUniqueId;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.BaseFragmentActivity;
import com.baidu.tbadk.core.data.AdvertAppInfo;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes8.dex */
public class d implements d.a.q0.v0.c {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public d() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
            }
        }
    }

    @Override // d.a.q0.v0.c
    public d.a.d.k.e.a<?, ?> a(BaseFragmentActivity baseFragmentActivity, BdUniqueId bdUniqueId) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, baseFragmentActivity, bdUniqueId)) == null) {
            if (baseFragmentActivity == null) {
                return null;
            }
            if (bdUniqueId == AdvertAppInfo.u4) {
                d.a.q0.w0.e.b bVar = new d.a.q0.w0.e.b(baseFragmentActivity, bdUniqueId);
                bVar.j0(d.a.q0.v0.d.c.e().d("pb_banner"));
                bVar.g0("pb");
                bVar.i0("pb_banner");
                return bVar;
            } else if (bdUniqueId == AdvertAppInfo.v4) {
                return new d.a.q0.w0.e.a(baseFragmentActivity, bdUniqueId);
            } else {
                return null;
            }
        }
        return (d.a.d.k.e.a) invokeLL.objValue;
    }

    @Override // d.a.q0.v0.c
    public d.a.d.k.e.a<?, ?> b(BaseFragmentActivity baseFragmentActivity, BdUniqueId bdUniqueId) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, baseFragmentActivity, bdUniqueId)) == null) {
            if (baseFragmentActivity == null) {
                return null;
            }
            if (bdUniqueId == AdvertAppInfo.w4) {
                d.a.q0.w0.e.b bVar = new d.a.q0.w0.e.b(baseFragmentActivity, bdUniqueId);
                bVar.j0(d.a.q0.v0.d.c.e().d("frs_feed"));
                bVar.g0("frs");
                bVar.i0("frs_feed");
                return bVar;
            } else if (bdUniqueId == AdvertAppInfo.v4) {
                return new d.a.q0.w0.e.a(baseFragmentActivity, bdUniqueId);
            } else {
                return null;
            }
        }
        return (d.a.d.k.e.a) invokeLL.objValue;
    }

    @Override // d.a.q0.v0.c
    public d.a.d.k.e.a<?, ?> c(BaseFragmentActivity baseFragmentActivity, BdUniqueId bdUniqueId) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, baseFragmentActivity, bdUniqueId)) == null) {
            if (baseFragmentActivity == null) {
                return null;
            }
            if (bdUniqueId == AdvertAppInfo.w4) {
                d.a.q0.w0.e.b bVar = new d.a.q0.w0.e.b(baseFragmentActivity, bdUniqueId);
                bVar.j0("6051001980-1210572494");
                bVar.g0("personalize");
                return bVar;
            } else if (bdUniqueId == AdvertAppInfo.v4) {
                return new d.a.q0.w0.e.a(baseFragmentActivity, bdUniqueId);
            } else {
                return null;
            }
        }
        return (d.a.d.k.e.a) invokeLL.objValue;
    }

    @Override // d.a.q0.v0.c
    public d.a.d.k.e.a<?, ?> d(BaseFragmentActivity baseFragmentActivity, BdUniqueId bdUniqueId) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048579, this, baseFragmentActivity, bdUniqueId)) == null) {
            if (baseFragmentActivity == null) {
                return null;
            }
            if (bdUniqueId == AdvertAppInfo.w4) {
                d.a.q0.w0.e.b bVar = new d.a.q0.w0.e.b(baseFragmentActivity, bdUniqueId);
                bVar.j0(d.a.q0.v0.d.c.e().d("frs_feed"));
                bVar.g0("frs");
                bVar.i0("frs_feed");
                return bVar;
            } else if (bdUniqueId == AdvertAppInfo.v4) {
                return new d.a.q0.w0.e.a(baseFragmentActivity, bdUniqueId);
            } else {
                return null;
            }
        }
        return (d.a.d.k.e.a) invokeLL.objValue;
    }
}
