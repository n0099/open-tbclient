package com.repackage;

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
import com.repackage.al8;
import java.util.HashMap;
import java.util.List;
import java.util.concurrent.atomic.AtomicReference;
import tbclient.App;
/* loaded from: classes6.dex */
public class fa8 implements ca8 {
    public static /* synthetic */ Interceptable $ic;
    public static final AtomicReference<ca8> a;
    public static final ca8 b;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-755714444, "Lcom/repackage/fa8;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-755714444, "Lcom/repackage/fa8;");
                return;
            }
        }
        a = new AtomicReference<>(null);
        b = new fa8();
    }

    public fa8() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
            }
        }
    }

    public static ca8 q() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) {
            ca8 ca8Var = a.get();
            return ca8Var == null ? b : ca8Var;
        }
        return (ca8) invokeV.objValue;
    }

    @Override // com.repackage.ca8
    public ho<?, ?> a(BaseFragmentActivity baseFragmentActivity, BdUniqueId bdUniqueId) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, baseFragmentActivity, bdUniqueId)) == null) {
            BdLog.e("recapp plugin install failed!");
            return null;
        }
        return (ho) invokeLL.objValue;
    }

    @Override // com.repackage.ca8
    public x98 b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            BdLog.e("recapp plugin install failed!");
            return null;
        }
        return (x98) invokeV.objValue;
    }

    @Override // com.repackage.ca8
    public App c(App app, Cmatch cmatch) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, app, cmatch)) == null) {
            BdLog.e("recapp plugin install failed!");
            return null;
        }
        return (App) invokeLL.objValue;
    }

    @Override // com.repackage.ca8
    public void d(boolean z, String str, String str2, String str3, String str4, List<al8.c> list, String str5) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048579, this, new Object[]{Boolean.valueOf(z), str, str2, str3, str4, list, str5}) == null) {
            BdLog.e("recapp plugin install failed!");
        }
    }

    @Override // com.repackage.ca8
    public r98 e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            BdLog.e("recapp plugin install failed!");
            return null;
        }
        return (r98) invokeV.objValue;
    }

    @Override // com.repackage.ca8
    public ho<?, ?> f(ba8 ba8Var, BdUniqueId bdUniqueId) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048581, this, ba8Var, bdUniqueId)) == null) {
            BdLog.e("recapp plugin install failed!");
            return null;
        }
        return (ho) invokeLL.objValue;
    }

    @Override // com.repackage.ca8
    public void g() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            BdLog.e("recapp plugin install failed!");
        }
    }

    @Override // com.repackage.ca8
    public List<AdvertAppInfo> h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            BdLog.e("recapp plugin install failed!");
            return null;
        }
        return (List) invokeV.objValue;
    }

    @Override // com.repackage.ca8
    public void i(AdvertAppInfo advertAppInfo, Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(InputDeviceCompat.SOURCE_TOUCHPAD, this, advertAppInfo, context) == null) {
            BdLog.e("recapp plugin install failed!");
        }
    }

    @Override // com.repackage.ca8
    public ho<?, ?> j(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId, String str) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048585, this, tbPageContext, bdUniqueId, str)) == null) {
            BdLog.e("recapp plugin install failed!");
            return null;
        }
        return (ho) invokeLLL.objValue;
    }

    @Override // com.repackage.ca8
    public IAdBaseAsyncController k(IAdBaseAsyncController.Type type, IAdBaseAsyncController.a aVar) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048586, this, type, aVar)) == null) {
            BdLog.e("recapp plugin install failed!");
            return null;
        }
        return (IAdBaseAsyncController) invokeLL.objValue;
    }

    @Override // com.repackage.ca8
    public ti8 l() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) {
            BdLog.e("recapp plugin install failed!");
            return null;
        }
        return (ti8) invokeV.objValue;
    }

    @Override // com.repackage.ca8
    public void m(boolean z, String str, String str2, String str3, List<al8.c> list, String str4) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048588, this, new Object[]{Boolean.valueOf(z), str, str2, str3, list, str4}) == null) {
            BdLog.e("recapp plugin install failed!");
        }
    }

    @Override // com.repackage.ca8
    public z98 n() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) {
            BdLog.e("recapp plugin install failed!");
            return null;
        }
        return (z98) invokeV.objValue;
    }

    @Override // com.repackage.ca8
    public void o(AdvertAppInfo advertAppInfo) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048590, this, advertAppInfo) == null) {
            BdLog.e("recapp plugin install failed!");
        }
    }

    @Override // com.repackage.ca8
    public void p(HashMap<String, String> hashMap, Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048591, this, hashMap, context) == null) {
            BdLog.e("recapp plugin install failed!");
        }
    }
}
