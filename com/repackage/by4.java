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
public class by4 {
    public static /* synthetic */ Interceptable $ic;
    public static by4 c;
    public transient /* synthetic */ FieldHolder $fh;
    public wx4 a;
    public String b;

    public by4() {
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

    public static by4 c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65537, null)) == null) {
            if (c == null) {
                synchronized (by4.class) {
                    if (c == null) {
                        c = new by4();
                    }
                }
            }
            return c;
        }
        return (by4) invokeV.objValue;
    }

    public void a(TbPageContext tbPageContext, ViewGroup viewGroup) {
        wx4 wx4Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048576, this, tbPageContext, viewGroup) == null) || (wx4Var = this.a) == null) {
            return;
        }
        wx4Var.f(tbPageContext, viewGroup);
    }

    public final wx4 b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            CustomResponsedMessage runTask = MessageManager.getInstance().runTask(2156675, wx4.class);
            if (runTask != null) {
                return (wx4) runTask.getData();
            }
            return null;
        }
        return (wx4) invokeV.objValue;
    }

    public int d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            wx4 wx4Var = this.a;
            if (wx4Var != null) {
                return wx4Var.h();
            }
            return 0;
        }
        return invokeV.intValue;
    }

    public int e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            wx4 wx4Var = this.a;
            if (wx4Var != null) {
                return wx4Var.b();
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
            wx4 wx4Var = this.a;
            if (wx4Var != null) {
                return wx4Var.a();
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public void h(boolean z) {
        wx4 wx4Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(1048582, this, z) == null) || (wx4Var = this.a) == null) {
            return;
        }
        wx4Var.i(z);
    }

    public void i(int i, int i2) {
        wx4 wx4Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeII(1048583, this, i, i2) == null) || (wx4Var = this.a) == null) {
            return;
        }
        wx4Var.g(i, i2);
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
            wx4 wx4Var = this.a;
            if (wx4Var != null) {
                return wx4Var.e(activity, viewGroup);
            }
            return null;
        }
        return (NavigationBarCoverTip) invokeLL.objValue;
    }

    public Dialog l(TbPageContext tbPageContext, xf5 xf5Var) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048586, this, tbPageContext, xf5Var)) == null) {
            wx4 wx4Var = this.a;
            if (wx4Var != null) {
                return wx4Var.d(tbPageContext, xf5Var);
            }
            return null;
        }
        return (Dialog) invokeLL.objValue;
    }

    public void m() {
        wx4 wx4Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048587, this) == null) || (wx4Var = this.a) == null) {
            return;
        }
        wx4Var.c();
    }
}
