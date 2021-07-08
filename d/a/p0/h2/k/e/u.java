package d.a.p0.h2.k.e;

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
/* loaded from: classes8.dex */
public class u {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public d.a.o0.w.w.h f57495a;

    /* renamed from: b  reason: collision with root package name */
    public TbPageContext f57496b;

    /* renamed from: c  reason: collision with root package name */
    public RelativeLayout f57497c;

    /* renamed from: d  reason: collision with root package name */
    public PbFakeFloorModel f57498d;

    /* renamed from: e  reason: collision with root package name */
    public String f57499e;

    /* renamed from: f  reason: collision with root package name */
    public String f57500f;

    /* renamed from: g  reason: collision with root package name */
    public NewWriteModel.g f57501g;

    /* renamed from: h  reason: collision with root package name */
    public d.a.p0.h2.h.e f57502h;

    /* renamed from: i  reason: collision with root package name */
    public View.OnClickListener f57503i;

    public u(TbPageContext tbPageContext, PbFakeFloorModel pbFakeFloorModel, RelativeLayout relativeLayout) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {tbPageContext, pbFakeFloorModel, relativeLayout};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f57496b = tbPageContext;
        this.f57497c = relativeLayout;
        this.f57498d = pbFakeFloorModel;
    }

    public final void a() {
        d.a.o0.w.w.h hVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || this.f57497c == null || (hVar = this.f57495a) == null || hVar.a() == null) {
            return;
        }
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -2);
        layoutParams.addRule(12);
        this.f57497c.addView(this.f57495a.a(), layoutParams);
        h(TbadkCoreApplication.getInst().getSkinType());
    }

    public d.a.o0.w.w.h b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.f57495a : (d.a.o0.w.w.h) invokeV.objValue;
    }

    public void c() {
        d.a.o0.w.w.h hVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) || (hVar = this.f57495a) == null) {
            return;
        }
        hVar.w();
        if (StringUtils.isNull(this.f57499e)) {
            this.f57495a.B();
        }
        this.f57495a.a().y();
    }

    public void d() {
        d.a.o0.w.w.h hVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048579, this) == null) || (hVar = this.f57495a) == null || hVar.a() == null) {
            return;
        }
        this.f57495a.a().q();
    }

    public final void e(String str, boolean z) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLZ(1048580, this, str, z) == null) && this.f57497c != null && this.f57495a == null) {
            d.a.o0.w.w.i iVar = new d.a.o0.w.w.i(z);
            iVar.i(str);
            d.a.o0.w.w.h hVar = (d.a.o0.w.w.h) iVar.a(this.f57496b.getPageActivity());
            this.f57495a = hVar;
            hVar.L(this.f57496b);
            this.f57495a.W(this.f57498d);
            this.f57495a.M(1);
            d.a.p0.h2.h.e eVar = this.f57502h;
            if (eVar != null) {
                this.f57495a.X(eVar.N());
            }
            this.f57495a.a().C(true);
            this.f57495a.a().setOnCancelClickListener(this.f57503i);
            this.f57495a.x(this.f57496b);
            a();
            this.f57495a.N(this.f57501g);
        }
    }

    public boolean f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            d.a.o0.w.w.h hVar = this.f57495a;
            if (hVar == null || hVar.a() == null) {
                return false;
            }
            return this.f57495a.a().u();
        }
        return invokeV.booleanValue;
    }

    public void g(int i2, int i3, Intent intent) {
        d.a.o0.w.w.h hVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeIIL(1048582, this, i2, i3, intent) == null) || (hVar = this.f57495a) == null) {
            return;
        }
        hVar.A(i2, i3, intent);
    }

    public void h(int i2) {
        d.a.o0.w.w.h hVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048583, this, i2) == null) || (hVar = this.f57495a) == null || hVar.a() == null) {
            return;
        }
        this.f57495a.a().w(i2);
    }

    public void i() {
        d.a.o0.w.w.h hVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) || (hVar = this.f57495a) == null) {
            return;
        }
        hVar.C();
    }

    public void j(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048585, this, str) == null) {
            this.f57500f = str;
        }
    }

    public void k(View.OnClickListener onClickListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048586, this, onClickListener) == null) {
            this.f57503i = onClickListener;
        }
    }

    public void l(d.a.p0.h2.h.e eVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048587, this, eVar) == null) {
            this.f57502h = eVar;
        }
    }

    public void m(NewWriteModel.g gVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048588, this, gVar) == null) {
            this.f57501g = gVar;
            d.a.o0.w.w.h hVar = this.f57495a;
            if (hVar != null) {
                hVar.N(gVar);
            }
        }
    }

    public void n(String str, String str2, String str3, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048589, this, new Object[]{str, str2, str3, Boolean.valueOf(z)}) == null) {
            this.f57499e = str2;
            d.a.o0.w.w.h hVar = this.f57495a;
            if (hVar == null) {
                e(str3, z);
            } else {
                hVar.W(this.f57498d);
                if (StringUtils.isNull(this.f57499e)) {
                    this.f57495a.x(this.f57496b);
                }
            }
            this.f57495a.S(str);
            this.f57495a.R(str2);
            this.f57495a.o(this.f57500f);
            if (this.f57495a.v()) {
                this.f57495a.t(null);
            }
        }
    }
}
