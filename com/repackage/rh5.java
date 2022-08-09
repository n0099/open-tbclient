package com.repackage;

import android.app.Activity;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.util.CommonStatisticKey;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tieba.R;
import com.baidu.tieba.view.BdTopToast;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.List;
/* loaded from: classes7.dex */
public class rh5 extends qh5 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public TbPageContext c;
    public sh5 d;
    public int e;

    public rh5(TbPageContext tbPageContext, ih5 ih5Var) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {tbPageContext, ih5Var};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.b = ih5Var;
        this.c = tbPageContext;
        ih5Var.a(this);
    }

    @Override // com.repackage.ph5
    public boolean a(String str) {
        InterceptResult invokeL;
        ih5 ih5Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, str)) == null) {
            ih5 ih5Var2 = this.b;
            if (ih5Var2 != null) {
                ih5Var2.i(str);
            }
            th5 th5Var = this.a;
            if (th5Var == null || (ih5Var = this.b) == null) {
                return true;
            }
            th5Var.d(ih5Var.c());
            return true;
        }
        return invokeL.booleanValue;
    }

    @Override // com.repackage.ph5
    public void b(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i) == null) {
            this.e = i;
        }
    }

    @Override // com.repackage.ph5
    public boolean c(lh5 lh5Var) {
        InterceptResult invokeL;
        ih5 ih5Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, lh5Var)) == null) {
            ih5 ih5Var2 = this.b;
            if (ih5Var2 != null && ih5Var2.c() >= 30) {
                j(this.c.getPageActivity(), false, String.format(this.c.getString(R.string.obfuscated_res_0x7f0f02fc), 30));
                return false;
            }
            ih5 ih5Var3 = this.b;
            if (ih5Var3 != null) {
                ih5Var3.f(lh5Var);
            }
            th5 th5Var = this.a;
            if (th5Var != null && (ih5Var = this.b) != null) {
                th5Var.d(ih5Var.c());
            }
            return true;
        }
        return invokeL.booleanValue;
    }

    @Override // com.repackage.qh5, com.repackage.ph5
    public void dismiss() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            th5 th5Var = this.a;
            if (th5Var != null) {
                th5Var.a();
            }
            ih5 ih5Var = this.b;
            if (ih5Var == null || ih5Var.b() == null || this.b.b().g() == null) {
                return;
            }
            this.b.b().g().a();
        }
    }

    @Override // com.repackage.qh5
    public void e() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            dismiss();
        }
    }

    @Override // com.repackage.qh5
    public void f() {
        ih5 ih5Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048581, this) == null) || (ih5Var = this.b) == null || ih5Var.c() == 0) {
            return;
        }
        this.b.h("1");
        i();
        TiebaStatic.log(new StatisticItem(CommonStatisticKey.KEY_MULTI_DEL_BUTTON_CLICK).param("obj_type", "1").param("obj_source", this.e == 3 ? "3" : "2"));
    }

    @Override // com.repackage.qh5
    public void g() {
        ih5 ih5Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048582, this) == null) || (ih5Var = this.b) == null || ih5Var.c() == 0) {
            return;
        }
        this.b.h("2");
        i();
        TiebaStatic.log(new StatisticItem(CommonStatisticKey.KEY_MULTI_DEL_BUTTON_CLICK).param("obj_type", "2").param("obj_source", this.e == 3 ? "3" : "2"));
    }

    @Override // com.repackage.qh5
    public void h(nh5 nh5Var) {
        String str;
        oh5 oh5Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, nh5Var) == null) {
            List<String> list = null;
            int i = -1;
            if (nh5Var == null) {
                str = "";
            } else if (nh5Var.a && (oh5Var = nh5Var.c) != null) {
                list = oh5Var.a;
                i = oh5Var.c;
                str = oh5Var.d;
            } else {
                str = nh5Var.b;
            }
            sh5 sh5Var = this.d;
            if (sh5Var != null) {
                sh5Var.b();
            }
            j(this.c.getPageActivity(), i == 0, str);
            ih5 ih5Var = this.b;
            if (ih5Var != null && ih5Var.b() != null && this.b.b().g() != null) {
                this.b.b().g().b(list);
            }
            if (i == 0) {
                dismiss();
            } else if (!ListUtils.isEmpty(list)) {
                for (String str2 : list) {
                    a(str2);
                }
            }
        }
    }

    public final void i() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
            sh5 sh5Var = new sh5(this.c, this.b);
            this.d = sh5Var;
            sh5Var.c(this.e);
        }
    }

    public final void j(Activity activity, boolean z, String str) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(1048585, this, new Object[]{activity, Boolean.valueOf(z), str}) == null) || activity == null || TextUtils.isEmpty(str)) {
            return;
        }
        View findViewById = activity.findViewById(16908290);
        if (findViewById instanceof ViewGroup) {
            BdTopToast bdTopToast = new BdTopToast(activity, 3000);
            bdTopToast.h(z);
            bdTopToast.g(str);
            bdTopToast.i((ViewGroup) findViewById);
        }
    }

    @Override // com.repackage.ph5
    public void show() {
        th5 th5Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048586, this) == null) || (th5Var = this.a) == null) {
            return;
        }
        th5Var.e();
    }
}
