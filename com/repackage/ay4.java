package com.repackage;

import android.app.Activity;
import android.app.Dialog;
import android.view.ViewGroup;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tieba.view.NavigationBarCoverTip;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes5.dex */
public class ay4 {
    public static /* synthetic */ Interceptable $ic;
    public static ay4 c;
    public transient /* synthetic */ FieldHolder $fh;
    public vx4 a;
    public String b;

    public ay4() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = b();
    }

    public static ay4 c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65537, null)) == null) {
            if (c == null) {
                synchronized (ay4.class) {
                    if (c == null) {
                        c = new ay4();
                    }
                }
            }
            return c;
        }
        return (ay4) invokeV.objValue;
    }

    public void a(TbPageContext tbPageContext, ViewGroup viewGroup) {
        vx4 vx4Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048576, this, tbPageContext, viewGroup) == null) || (vx4Var = this.a) == null) {
            return;
        }
        vx4Var.f(tbPageContext, viewGroup);
    }

    public final vx4 b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            CustomResponsedMessage runTask = MessageManager.getInstance().runTask(2156675, vx4.class);
            if (runTask != null) {
                return (vx4) runTask.getData();
            }
            return null;
        }
        return (vx4) invokeV.objValue;
    }

    public int d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            vx4 vx4Var = this.a;
            if (vx4Var != null) {
                return vx4Var.h();
            }
            return 0;
        }
        return invokeV.intValue;
    }

    public int e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            vx4 vx4Var = this.a;
            if (vx4Var != null) {
                return vx4Var.b();
            }
            return 0;
        }
        return invokeV.intValue;
    }

    public String f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.b : (String) invokeV.objValue;
    }

    public boolean g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            vx4 vx4Var = this.a;
            if (vx4Var != null) {
                return vx4Var.a();
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public void h(boolean z) {
        vx4 vx4Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(1048582, this, z) == null) || (vx4Var = this.a) == null) {
            return;
        }
        vx4Var.i(z);
    }

    public void i(int i, int i2) {
        vx4 vx4Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeII(1048583, this, i, i2) == null) || (vx4Var = this.a) == null) {
            return;
        }
        vx4Var.g(i, i2);
    }

    public void j(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, str) == null) {
            this.b = str;
        }
    }

    public NavigationBarCoverTip k(Activity activity, ViewGroup viewGroup) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048585, this, activity, viewGroup)) == null) {
            vx4 vx4Var = this.a;
            if (vx4Var != null) {
                return vx4Var.e(activity, viewGroup);
            }
            return null;
        }
        return (NavigationBarCoverTip) invokeLL.objValue;
    }

    public Dialog l(TbPageContext tbPageContext, xf5 xf5Var) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048586, this, tbPageContext, xf5Var)) == null) {
            vx4 vx4Var = this.a;
            if (vx4Var != null) {
                return vx4Var.d(tbPageContext, xf5Var);
            }
            return null;
        }
        return (Dialog) invokeLL.objValue;
    }

    public void m() {
        vx4 vx4Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048587, this) == null) || (vx4Var = this.a) == null) {
            return;
        }
        vx4Var.c();
    }
}
