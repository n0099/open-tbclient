package d.a.q0.h2.k.e;

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
    public d.a.p0.x.w.h f58080a;

    /* renamed from: b  reason: collision with root package name */
    public TbPageContext f58081b;

    /* renamed from: c  reason: collision with root package name */
    public RelativeLayout f58082c;

    /* renamed from: d  reason: collision with root package name */
    public PbFakeFloorModel f58083d;

    /* renamed from: e  reason: collision with root package name */
    public String f58084e;

    /* renamed from: f  reason: collision with root package name */
    public String f58085f;

    /* renamed from: g  reason: collision with root package name */
    public NewWriteModel.g f58086g;

    /* renamed from: h  reason: collision with root package name */
    public d.a.q0.h2.h.e f58087h;

    /* renamed from: i  reason: collision with root package name */
    public View.OnClickListener f58088i;

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
        this.f58081b = tbPageContext;
        this.f58082c = relativeLayout;
        this.f58083d = pbFakeFloorModel;
    }

    public final void a() {
        d.a.p0.x.w.h hVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || this.f58082c == null || (hVar = this.f58080a) == null || hVar.a() == null) {
            return;
        }
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -2);
        layoutParams.addRule(12);
        this.f58082c.addView(this.f58080a.a(), layoutParams);
        h(TbadkCoreApplication.getInst().getSkinType());
    }

    public d.a.p0.x.w.h b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.f58080a : (d.a.p0.x.w.h) invokeV.objValue;
    }

    public void c() {
        d.a.p0.x.w.h hVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) || (hVar = this.f58080a) == null) {
            return;
        }
        hVar.y();
        if (StringUtils.isNull(this.f58084e)) {
            this.f58080a.D();
        }
        this.f58080a.a().y();
    }

    public void d() {
        d.a.p0.x.w.h hVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048579, this) == null) || (hVar = this.f58080a) == null || hVar.a() == null) {
            return;
        }
        this.f58080a.a().q();
    }

    public final void e(String str, boolean z) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLZ(1048580, this, str, z) == null) && this.f58082c != null && this.f58080a == null) {
            d.a.p0.x.w.i iVar = new d.a.p0.x.w.i(z);
            iVar.i(str);
            d.a.p0.x.w.h hVar = (d.a.p0.x.w.h) iVar.a(this.f58081b.getPageActivity());
            this.f58080a = hVar;
            hVar.N(this.f58081b);
            this.f58080a.Z(this.f58083d);
            this.f58080a.O(1);
            d.a.q0.h2.h.e eVar = this.f58087h;
            if (eVar != null) {
                this.f58080a.a0(eVar.N());
            }
            this.f58080a.a().C(true);
            this.f58080a.a().setOnCancelClickListener(this.f58088i);
            this.f58080a.z(this.f58081b);
            a();
            this.f58080a.Q(this.f58086g);
        }
    }

    public boolean f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            d.a.p0.x.w.h hVar = this.f58080a;
            if (hVar == null || hVar.a() == null) {
                return false;
            }
            return this.f58080a.a().u();
        }
        return invokeV.booleanValue;
    }

    public void g(int i2, int i3, Intent intent) {
        d.a.p0.x.w.h hVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeIIL(1048582, this, i2, i3, intent) == null) || (hVar = this.f58080a) == null) {
            return;
        }
        hVar.C(i2, i3, intent);
    }

    public void h(int i2) {
        d.a.p0.x.w.h hVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048583, this, i2) == null) || (hVar = this.f58080a) == null || hVar.a() == null) {
            return;
        }
        this.f58080a.a().w(i2);
    }

    public void i() {
        d.a.p0.x.w.h hVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) || (hVar = this.f58080a) == null) {
            return;
        }
        hVar.E();
    }

    public void j(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048585, this, str) == null) {
            this.f58085f = str;
        }
    }

    public void k(View.OnClickListener onClickListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048586, this, onClickListener) == null) {
            this.f58088i = onClickListener;
        }
    }

    public void l(d.a.q0.h2.h.e eVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048587, this, eVar) == null) {
            this.f58087h = eVar;
        }
    }

    public void m(NewWriteModel.g gVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048588, this, gVar) == null) {
            this.f58086g = gVar;
            d.a.p0.x.w.h hVar = this.f58080a;
            if (hVar != null) {
                hVar.Q(gVar);
            }
        }
    }

    public void n(String str, String str2, String str3, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048589, this, new Object[]{str, str2, str3, Boolean.valueOf(z)}) == null) {
            this.f58084e = str2;
            d.a.p0.x.w.h hVar = this.f58080a;
            if (hVar == null) {
                e(str3, z);
            } else {
                hVar.Z(this.f58083d);
                if (StringUtils.isNull(this.f58084e)) {
                    this.f58080a.z(this.f58081b);
                }
            }
            this.f58080a.V(str);
            this.f58080a.U(str2);
            this.f58080a.p(this.f58085f);
            if (this.f58080a.x()) {
                this.f58080a.v(null);
            }
        }
    }
}
