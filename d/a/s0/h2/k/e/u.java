package d.a.s0.h2.k.e;

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
/* loaded from: classes9.dex */
public class u {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public d.a.r0.w.w.h f60739a;

    /* renamed from: b  reason: collision with root package name */
    public TbPageContext f60740b;

    /* renamed from: c  reason: collision with root package name */
    public RelativeLayout f60741c;

    /* renamed from: d  reason: collision with root package name */
    public PbFakeFloorModel f60742d;

    /* renamed from: e  reason: collision with root package name */
    public String f60743e;

    /* renamed from: f  reason: collision with root package name */
    public String f60744f;

    /* renamed from: g  reason: collision with root package name */
    public NewWriteModel.g f60745g;

    /* renamed from: h  reason: collision with root package name */
    public d.a.s0.h2.h.e f60746h;

    /* renamed from: i  reason: collision with root package name */
    public View.OnClickListener f60747i;

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
        this.f60740b = tbPageContext;
        this.f60741c = relativeLayout;
        this.f60742d = pbFakeFloorModel;
    }

    public final void a() {
        d.a.r0.w.w.h hVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || this.f60741c == null || (hVar = this.f60739a) == null || hVar.a() == null) {
            return;
        }
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -2);
        layoutParams.addRule(12);
        this.f60741c.addView(this.f60739a.a(), layoutParams);
        h(TbadkCoreApplication.getInst().getSkinType());
    }

    public d.a.r0.w.w.h b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.f60739a : (d.a.r0.w.w.h) invokeV.objValue;
    }

    public void c() {
        d.a.r0.w.w.h hVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) || (hVar = this.f60739a) == null) {
            return;
        }
        hVar.w();
        if (StringUtils.isNull(this.f60743e)) {
            this.f60739a.B();
        }
        this.f60739a.a().y();
    }

    public void d() {
        d.a.r0.w.w.h hVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048579, this) == null) || (hVar = this.f60739a) == null || hVar.a() == null) {
            return;
        }
        this.f60739a.a().q();
    }

    public final void e(String str, boolean z) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLZ(1048580, this, str, z) == null) && this.f60741c != null && this.f60739a == null) {
            d.a.r0.w.w.i iVar = new d.a.r0.w.w.i(z);
            iVar.i(str);
            d.a.r0.w.w.h hVar = (d.a.r0.w.w.h) iVar.a(this.f60740b.getPageActivity());
            this.f60739a = hVar;
            hVar.L(this.f60740b);
            this.f60739a.W(this.f60742d);
            this.f60739a.M(1);
            d.a.s0.h2.h.e eVar = this.f60746h;
            if (eVar != null) {
                this.f60739a.X(eVar.N());
            }
            this.f60739a.a().C(true);
            this.f60739a.a().setOnCancelClickListener(this.f60747i);
            this.f60739a.x(this.f60740b);
            a();
            this.f60739a.N(this.f60745g);
        }
    }

    public boolean f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            d.a.r0.w.w.h hVar = this.f60739a;
            if (hVar == null || hVar.a() == null) {
                return false;
            }
            return this.f60739a.a().u();
        }
        return invokeV.booleanValue;
    }

    public void g(int i2, int i3, Intent intent) {
        d.a.r0.w.w.h hVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeIIL(1048582, this, i2, i3, intent) == null) || (hVar = this.f60739a) == null) {
            return;
        }
        hVar.A(i2, i3, intent);
    }

    public void h(int i2) {
        d.a.r0.w.w.h hVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048583, this, i2) == null) || (hVar = this.f60739a) == null || hVar.a() == null) {
            return;
        }
        this.f60739a.a().w(i2);
    }

    public void i() {
        d.a.r0.w.w.h hVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) || (hVar = this.f60739a) == null) {
            return;
        }
        hVar.C();
    }

    public void j(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048585, this, str) == null) {
            this.f60744f = str;
        }
    }

    public void k(View.OnClickListener onClickListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048586, this, onClickListener) == null) {
            this.f60747i = onClickListener;
        }
    }

    public void l(d.a.s0.h2.h.e eVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048587, this, eVar) == null) {
            this.f60746h = eVar;
        }
    }

    public void m(NewWriteModel.g gVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048588, this, gVar) == null) {
            this.f60745g = gVar;
            d.a.r0.w.w.h hVar = this.f60739a;
            if (hVar != null) {
                hVar.N(gVar);
            }
        }
    }

    public void n(String str, String str2, String str3, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048589, this, new Object[]{str, str2, str3, Boolean.valueOf(z)}) == null) {
            this.f60743e = str2;
            d.a.r0.w.w.h hVar = this.f60739a;
            if (hVar == null) {
                e(str3, z);
            } else {
                hVar.W(this.f60742d);
                if (StringUtils.isNull(this.f60743e)) {
                    this.f60739a.x(this.f60740b);
                }
            }
            this.f60739a.S(str);
            this.f60739a.R(str2);
            this.f60739a.o(this.f60744f);
            if (this.f60739a.v()) {
                this.f60739a.t(null);
            }
        }
    }
}
