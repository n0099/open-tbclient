package com.repackage;

import android.content.Intent;
import android.view.View;
import android.widget.RelativeLayout;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.CommonStatisticKey;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tieba.pb.pb.main.view.PbFakeFloorModel;
import com.baidu.tieba.tbadkCore.writeModel.NewWriteModel;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes6.dex */
public class ju7 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public r35 a;
    public TbPageContext b;
    public RelativeLayout c;
    public PbFakeFloorModel d;
    public String e;
    public String f;
    public NewWriteModel.e g;
    public jr7 h;
    public View.OnClickListener i;

    public ju7(TbPageContext tbPageContext, PbFakeFloorModel pbFakeFloorModel, RelativeLayout relativeLayout) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {tbPageContext, pbFakeFloorModel, relativeLayout};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.b = tbPageContext;
        this.c = relativeLayout;
        this.d = pbFakeFloorModel;
    }

    public final void a() {
        r35 r35Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || this.c == null || (r35Var = this.a) == null || r35Var.a() == null) {
            return;
        }
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -2);
        layoutParams.addRule(12);
        this.c.addView(this.a.a(), layoutParams);
        h(TbadkCoreApplication.getInst().getSkinType());
    }

    public r35 b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.a : (r35) invokeV.objValue;
    }

    public void c() {
        r35 r35Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) || (r35Var = this.a) == null) {
            return;
        }
        r35Var.y();
        if (StringUtils.isNull(this.e)) {
            this.a.D();
        }
        this.a.a().y();
    }

    public void d() {
        r35 r35Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048579, this) == null) || (r35Var = this.a) == null || r35Var.a() == null) {
            return;
        }
        this.a.a().q();
    }

    public final void e(String str, boolean z) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLZ(1048580, this, str, z) == null) && this.c != null && this.a == null) {
            s35 s35Var = new s35(z);
            s35Var.i(str);
            r35 r35Var = (r35) s35Var.a(this.b.getPageActivity());
            this.a = r35Var;
            r35Var.N(this.b);
            this.a.a0(this.d);
            this.a.O(1);
            jr7 jr7Var = this.h;
            if (jr7Var != null) {
                this.a.c0(jr7Var.O());
            }
            this.a.a().C(true);
            this.a.a().setOnCancelClickListener(this.i);
            this.a.z(this.b);
            a();
            this.a.Q(this.g);
        }
    }

    public boolean f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            r35 r35Var = this.a;
            if (r35Var == null || r35Var.a() == null) {
                return false;
            }
            return this.a.a().u();
        }
        return invokeV.booleanValue;
    }

    public void g(int i, int i2, Intent intent) {
        r35 r35Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeIIL(1048582, this, i, i2, intent) == null) || (r35Var = this.a) == null) {
            return;
        }
        r35Var.C(i, i2, intent);
    }

    public void h(int i) {
        r35 r35Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048583, this, i) == null) || (r35Var = this.a) == null || r35Var.a() == null) {
            return;
        }
        this.a.a().w(i);
    }

    public void i() {
        r35 r35Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) || (r35Var = this.a) == null) {
            return;
        }
        r35Var.E();
    }

    public void j(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048585, this, str) == null) {
            this.f = str;
        }
    }

    public void k(View.OnClickListener onClickListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048586, this, onClickListener) == null) {
            this.i = onClickListener;
        }
    }

    public void l(int i) {
        r35 r35Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048587, this, i) == null) || (r35Var = this.a) == null) {
            return;
        }
        r35Var.P(i);
    }

    public void m(jr7 jr7Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048588, this, jr7Var) == null) {
            this.h = jr7Var;
        }
    }

    public void n(NewWriteModel.e eVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048589, this, eVar) == null) {
            this.g = eVar;
            r35 r35Var = this.a;
            if (r35Var != null) {
                r35Var.Q(eVar);
            }
        }
    }

    public void o(String str, String str2, String str3, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048590, this, new Object[]{str, str2, str3, Boolean.valueOf(z)}) == null) {
            this.e = str2;
            r35 r35Var = this.a;
            if (r35Var == null) {
                e(str3, z);
            } else {
                r35Var.a0(this.d);
                if (StringUtils.isNull(this.e)) {
                    this.a.z(this.b);
                }
            }
            this.a.W(str);
            this.a.V(str2, "");
            this.a.p(this.f);
            if (this.a.x()) {
                TiebaStatic.log(new StatisticItem(CommonStatisticKey.KEY_RD_USE).param("obj_param1", 3).param("obj_locate", 10).param("obj_type", 2).param("obj_source", UtilHelper.getCurrentPageName(TbadkCoreApplication.getInst().getCurrentActivity())));
                this.a.v(null);
                return;
            }
            TiebaStatic.log(new StatisticItem(CommonStatisticKey.KEY_RD_USE).param("obj_param1", 3).param("obj_locate", 9).param("obj_type", 2).param("obj_source", UtilHelper.getCurrentPageName(TbadkCoreApplication.getInst().getCurrentActivity())));
        }
    }
}
