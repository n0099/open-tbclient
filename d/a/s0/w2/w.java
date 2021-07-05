package d.a.s0.w2;

import android.content.Context;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.BaseFragmentActivity;
import com.baidu.tbadk.core.data.AdvertAppInfo;
import com.baidu.tieba.recapp.async.IAdBaseAsyncController;
import com.baidu.tieba.recapp.constants.Cmatch;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import d.a.s0.h3.j0.a;
import java.util.List;
import java.util.concurrent.atomic.AtomicReference;
import tbclient.App;
/* loaded from: classes9.dex */
public class w implements u {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: a  reason: collision with root package name */
    public static final AtomicReference<u> f69269a;

    /* renamed from: b  reason: collision with root package name */
    public static final u f69270b;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-623507733, "Ld/a/s0/w2/w;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-623507733, "Ld/a/s0/w2/w;");
                return;
            }
        }
        f69269a = new AtomicReference<>(null);
        f69270b = new w();
    }

    public w() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
            }
        }
    }

    public static u p() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) {
            u uVar = f69269a.get();
            return uVar == null ? f69270b : uVar;
        }
        return (u) invokeV.objValue;
    }

    @Override // d.a.s0.w2.u
    public d.a.c.k.e.a<?, ?> a(BaseFragmentActivity baseFragmentActivity, BdUniqueId bdUniqueId) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, baseFragmentActivity, bdUniqueId)) == null) {
            BdLog.e("recapp plugin install failed!");
            return null;
        }
        return (d.a.c.k.e.a) invokeLL.objValue;
    }

    @Override // d.a.s0.w2.u
    public p b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            BdLog.e("recapp plugin install failed!");
            return null;
        }
        return (p) invokeV.objValue;
    }

    @Override // d.a.s0.w2.u
    public App c(App app, Cmatch cmatch) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, app, cmatch)) == null) {
            BdLog.e("recapp plugin install failed!");
            return null;
        }
        return (App) invokeLL.objValue;
    }

    @Override // d.a.s0.w2.u
    public void d(boolean z, String str, String str2, String str3, String str4, List<a.c> list, String str5) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048579, this, new Object[]{Boolean.valueOf(z), str, str2, str3, str4, list, str5}) == null) {
            BdLog.e("recapp plugin install failed!");
        }
    }

    @Override // d.a.s0.w2.u
    public k e(TbPageContext<?> tbPageContext, AdvertAppInfo.ILegoAdvert iLegoAdvert, int i2, boolean z, String str, String str2) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048580, this, new Object[]{tbPageContext, iLegoAdvert, Integer.valueOf(i2), Boolean.valueOf(z), str, str2})) == null) {
            BdLog.e("recapp plugin install failed!");
            return null;
        }
        return (k) invokeCommon.objValue;
    }

    @Override // d.a.s0.w2.u
    public l f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            BdLog.e("recapp plugin install failed!");
            return null;
        }
        return (l) invokeV.objValue;
    }

    @Override // d.a.s0.w2.u
    public d.a.c.k.e.a<?, ?> g(t tVar, BdUniqueId bdUniqueId) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048582, this, tVar, bdUniqueId)) == null) {
            BdLog.e("recapp plugin install failed!");
            return null;
        }
        return (d.a.c.k.e.a) invokeLL.objValue;
    }

    @Override // d.a.s0.w2.u
    public void h() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            BdLog.e("recapp plugin install failed!");
        }
    }

    @Override // d.a.s0.w2.u
    public List<AdvertAppInfo> i() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            BdLog.e("recapp plugin install failed!");
            return null;
        }
        return (List) invokeV.objValue;
    }

    @Override // d.a.s0.w2.u
    public void j(AdvertAppInfo advertAppInfo, Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048585, this, advertAppInfo, context) == null) {
            BdLog.e("recapp plugin install failed!");
        }
    }

    @Override // d.a.s0.w2.u
    public d.a.c.k.e.a<?, ?> k(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId, String str) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048586, this, tbPageContext, bdUniqueId, str)) == null) {
            BdLog.e("recapp plugin install failed!");
            return null;
        }
        return (d.a.c.k.e.a) invokeLLL.objValue;
    }

    @Override // d.a.s0.w2.u
    public IAdBaseAsyncController l(IAdBaseAsyncController.Type type, IAdBaseAsyncController.a aVar) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048587, this, type, aVar)) == null) {
            BdLog.e("recapp plugin install failed!");
            return null;
        }
        return (IAdBaseAsyncController) invokeLL.objValue;
    }

    @Override // d.a.s0.w2.u
    public d.a.s0.f3.a m() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) {
            BdLog.e("recapp plugin install failed!");
            return null;
        }
        return (d.a.s0.f3.a) invokeV.objValue;
    }

    @Override // d.a.s0.w2.u
    public void n(boolean z, String str, String str2, String str3, List<a.c> list, String str4) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048589, this, new Object[]{Boolean.valueOf(z), str, str2, str3, list, str4}) == null) {
            BdLog.e("recapp plugin install failed!");
        }
    }

    @Override // d.a.s0.w2.u
    public r o() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048590, this)) == null) {
            BdLog.e("recapp plugin install failed!");
            return null;
        }
        return (r) invokeV.objValue;
    }
}
