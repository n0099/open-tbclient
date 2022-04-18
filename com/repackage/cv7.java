package com.repackage;

import android.content.Intent;
import android.view.View;
import android.widget.RelativeLayout;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.pb.pb.main.view.PbFakeFloorModel;
import com.baidu.tieba.tbadkCore.writeModel.NewWriteModel;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes5.dex */
public class cv7 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public p25 a;
    public TbPageContext b;
    public RelativeLayout c;
    public PbFakeFloorModel d;
    public String e;
    public String f;
    public NewWriteModel.g g;
    public bs7 h;
    public View.OnClickListener i;

    public cv7(TbPageContext tbPageContext, PbFakeFloorModel pbFakeFloorModel, RelativeLayout relativeLayout) {
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
        p25 p25Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || this.c == null || (p25Var = this.a) == null || p25Var.a() == null) {
            return;
        }
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -2);
        layoutParams.addRule(12);
        this.c.addView(this.a.a(), layoutParams);
        h(TbadkCoreApplication.getInst().getSkinType());
    }

    public p25 b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.a : (p25) invokeV.objValue;
    }

    public void c() {
        p25 p25Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) || (p25Var = this.a) == null) {
            return;
        }
        p25Var.y();
        if (StringUtils.isNull(this.e)) {
            this.a.D();
        }
        this.a.a().y();
    }

    public void d() {
        p25 p25Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048579, this) == null) || (p25Var = this.a) == null || p25Var.a() == null) {
            return;
        }
        this.a.a().q();
    }

    public final void e(String str, boolean z) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLZ(1048580, this, str, z) == null) && this.c != null && this.a == null) {
            q25 q25Var = new q25(z);
            q25Var.i(str);
            p25 p25Var = (p25) q25Var.a(this.b.getPageActivity());
            this.a = p25Var;
            p25Var.N(this.b);
            this.a.a0(this.d);
            this.a.O(1);
            bs7 bs7Var = this.h;
            if (bs7Var != null) {
                this.a.c0(bs7Var.O());
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
            p25 p25Var = this.a;
            if (p25Var == null || p25Var.a() == null) {
                return false;
            }
            return this.a.a().u();
        }
        return invokeV.booleanValue;
    }

    public void g(int i, int i2, Intent intent) {
        p25 p25Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeIIL(1048582, this, i, i2, intent) == null) || (p25Var = this.a) == null) {
            return;
        }
        p25Var.C(i, i2, intent);
    }

    public void h(int i) {
        p25 p25Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048583, this, i) == null) || (p25Var = this.a) == null || p25Var.a() == null) {
            return;
        }
        this.a.a().w(i);
    }

    public void i() {
        p25 p25Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) || (p25Var = this.a) == null) {
            return;
        }
        p25Var.E();
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
        p25 p25Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048587, this, i) == null) || (p25Var = this.a) == null) {
            return;
        }
        p25Var.P(i);
    }

    public void m(bs7 bs7Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048588, this, bs7Var) == null) {
            this.h = bs7Var;
        }
    }

    public void n(NewWriteModel.g gVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048589, this, gVar) == null) {
            this.g = gVar;
            p25 p25Var = this.a;
            if (p25Var != null) {
                p25Var.Q(gVar);
            }
        }
    }

    public void o(String str, String str2, String str3, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048590, this, new Object[]{str, str2, str3, Boolean.valueOf(z)}) == null) {
            this.e = str2;
            p25 p25Var = this.a;
            if (p25Var == null) {
                e(str3, z);
            } else {
                p25Var.a0(this.d);
                if (StringUtils.isNull(this.e)) {
                    this.a.z(this.b);
                }
            }
            this.a.W(str);
            this.a.V(str2, "");
            this.a.p(this.f);
            if (this.a.x()) {
                this.a.v(null);
            }
        }
    }
}
