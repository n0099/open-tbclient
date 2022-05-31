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
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.HashMap;
import java.util.List;
import java.util.concurrent.atomic.AtomicReference;
/* loaded from: classes6.dex */
public class q78 implements o78 {
    public static /* synthetic */ Interceptable $ic;
    public static final AtomicReference<o78> a;
    public static final o78 b;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-755427105, "Lcom/repackage/q78;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-755427105, "Lcom/repackage/q78;");
                return;
            }
        }
        a = new AtomicReference<>(null);
        b = new q78();
    }

    public q78() {
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

    public static o78 l() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) {
            o78 o78Var = a.get();
            return o78Var == null ? b : o78Var;
        }
        return (o78) invokeV.objValue;
    }

    @Override // com.repackage.o78
    public wm<?, ?> a(BaseFragmentActivity baseFragmentActivity, BdUniqueId bdUniqueId) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, baseFragmentActivity, bdUniqueId)) == null) {
            BdLog.e("recapp plugin install failed!");
            return null;
        }
        return (wm) invokeLL.objValue;
    }

    @Override // com.repackage.o78
    public j78 b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            BdLog.e("recapp plugin install failed!");
            return null;
        }
        return (j78) invokeV.objValue;
    }

    @Override // com.repackage.o78
    public e78 c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            BdLog.e("recapp plugin install failed!");
            return null;
        }
        return (e78) invokeV.objValue;
    }

    @Override // com.repackage.o78
    public wm<?, ?> d(n78 n78Var, BdUniqueId bdUniqueId) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048579, this, n78Var, bdUniqueId)) == null) {
            BdLog.e("recapp plugin install failed!");
            return null;
        }
        return (wm) invokeLL.objValue;
    }

    @Override // com.repackage.o78
    public void e() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            BdLog.e("recapp plugin install failed!");
        }
    }

    @Override // com.repackage.o78
    public List<AdvertAppInfo> f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            BdLog.e("recapp plugin install failed!");
            return null;
        }
        return (List) invokeV.objValue;
    }

    @Override // com.repackage.o78
    public wm<?, ?> g(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId, String str) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048582, this, tbPageContext, bdUniqueId, str)) == null) {
            BdLog.e("recapp plugin install failed!");
            return null;
        }
        return (wm) invokeLLL.objValue;
    }

    @Override // com.repackage.o78
    public IAdBaseAsyncController h(IAdBaseAsyncController.Type type, IAdBaseAsyncController.a aVar) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048583, this, type, aVar)) == null) {
            BdLog.e("recapp plugin install failed!");
            return null;
        }
        return (IAdBaseAsyncController) invokeLL.objValue;
    }

    @Override // com.repackage.o78
    public l78 i() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            BdLog.e("recapp plugin install failed!");
            return null;
        }
        return (l78) invokeV.objValue;
    }

    @Override // com.repackage.o78
    public void j(AdvertAppInfo advertAppInfo) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048585, this, advertAppInfo) == null) {
            BdLog.e("recapp plugin install failed!");
        }
    }

    @Override // com.repackage.o78
    public void k(HashMap<String, String> hashMap, Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048586, this, hashMap, context) == null) {
            BdLog.e("recapp plugin install failed!");
        }
    }
}
