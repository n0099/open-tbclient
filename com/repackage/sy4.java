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
/* loaded from: classes7.dex */
public class sy4 {
    public static /* synthetic */ Interceptable $ic;
    public static sy4 c;
    public transient /* synthetic */ FieldHolder $fh;
    public my4 a;
    public String b;

    public sy4() {
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

    public static sy4 c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65537, null)) == null) {
            if (c == null) {
                synchronized (sy4.class) {
                    if (c == null) {
                        c = new sy4();
                    }
                }
            }
            return c;
        }
        return (sy4) invokeV.objValue;
    }

    public void a(int i, TbPageContext tbPageContext, ViewGroup viewGroup) {
        my4 my4Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeILL(1048576, this, i, tbPageContext, viewGroup) == null) || (my4Var = this.a) == null) {
            return;
        }
        my4Var.c(i, tbPageContext, viewGroup);
    }

    public final my4 b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            CustomResponsedMessage runTask = MessageManager.getInstance().runTask(2156675, my4.class);
            if (runTask != null) {
                return (my4) runTask.getData();
            }
            return null;
        }
        return (my4) invokeV.objValue;
    }

    public int d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            my4 my4Var = this.a;
            if (my4Var != null) {
                return my4Var.g();
            }
            return 0;
        }
        return invokeV.intValue;
    }

    public int e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            my4 my4Var = this.a;
            if (my4Var != null) {
                return my4Var.b();
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
            my4 my4Var = this.a;
            if (my4Var != null) {
                return my4Var.a();
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public void h(boolean z) {
        my4 my4Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(1048582, this, z) == null) || (my4Var = this.a) == null) {
            return;
        }
        my4Var.h(z);
    }

    public void i(int i, int i2) {
        my4 my4Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeII(1048583, this, i, i2) == null) || (my4Var = this.a) == null) {
            return;
        }
        my4Var.f(i, i2);
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
            my4 my4Var = this.a;
            if (my4Var != null) {
                return my4Var.e(activity, viewGroup);
            }
            return null;
        }
        return (NavigationBarCoverTip) invokeLL.objValue;
    }

    public Dialog l(int i, TbPageContext tbPageContext, kh5 kh5Var) {
        InterceptResult invokeILL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeILL = interceptable.invokeILL(1048586, this, i, tbPageContext, kh5Var)) == null) {
            my4 my4Var = this.a;
            if (my4Var != null) {
                return my4Var.i(i, tbPageContext, kh5Var);
            }
            return null;
        }
        return (Dialog) invokeILL.objValue;
    }

    public void m() {
        my4 my4Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048587, this) == null) || (my4Var = this.a) == null) {
            return;
        }
        my4Var.d();
    }
}
