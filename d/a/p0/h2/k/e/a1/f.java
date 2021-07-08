package d.a.p0.h2.k.e.a1;

import android.content.res.Configuration;
import android.view.View;
import android.widget.AbsListView;
import android.widget.FrameLayout;
import android.widget.TextView;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.widget.ListView.BdTypeListView;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tieba.pb.pb.main.PbFragment;
import com.baidu.tieba.pb.pb.main.PbLandscapeListView;
import com.baidu.tieba.tbadkCore.data.PostData;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import d.a.o0.r.q.b2;
/* loaded from: classes8.dex */
public class f {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public PbFragment f57097a;

    /* renamed from: b  reason: collision with root package name */
    public d.a.p0.h2.n.g f57098b;

    /* renamed from: c  reason: collision with root package name */
    public d.a.p0.h2.n.f f57099c;

    /* renamed from: d  reason: collision with root package name */
    public boolean f57100d;

    public f(PbFragment pbFragment) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {pbFragment};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f57100d = false;
        this.f57097a = pbFragment;
    }

    public void a() {
        d.a.p0.h2.n.g gVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || (gVar = this.f57098b) == null) {
            return;
        }
        gVar.O();
    }

    public void b() {
        d.a.p0.h2.n.g gVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) || (gVar = this.f57098b) == null) {
            return;
        }
        gVar.f0();
    }

    public View c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            d.a.p0.h2.n.g gVar = this.f57098b;
            if (gVar != null) {
                return gVar.P();
            }
            return null;
        }
        return (View) invokeV.objValue;
    }

    public int d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            View c2 = c();
            if (c2 != null) {
                return c2.getHeight();
            }
            return 0;
        }
        return invokeV.intValue;
    }

    public int e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            d.a.p0.h2.n.g gVar = this.f57098b;
            if (gVar != null) {
                return gVar.Q();
            }
            return 0;
        }
        return invokeV.intValue;
    }

    public boolean f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            d.a.p0.h2.n.g gVar = this.f57098b;
            return gVar != null && gVar.X();
        }
        return invokeV.booleanValue;
    }

    public boolean g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            d.a.p0.h2.n.g gVar = this.f57098b;
            if (gVar != null) {
                return gVar.Z();
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public void h(int i2) {
        d.a.p0.h2.n.f fVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048583, this, i2) == null) || (fVar = this.f57099c) == null) {
            return;
        }
        fVar.c(i2);
    }

    public void i(int i2) {
        d.a.p0.h2.n.g gVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(InputDeviceCompat.SOURCE_TOUCHPAD, this, i2) == null) || (gVar = this.f57098b) == null) {
            return;
        }
        gVar.c0(i2);
    }

    public void j(Configuration configuration) {
        d.a.p0.h2.n.g gVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048585, this, configuration) == null) || (gVar = this.f57098b) == null) {
            return;
        }
        gVar.d0(configuration);
    }

    public boolean k(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048586, this, i2)) == null) {
            d.a.p0.h2.n.g gVar = this.f57098b;
            if (gVar != null) {
                return gVar.e0(i2);
            }
            return false;
        }
        return invokeI.booleanValue;
    }

    public void l() {
        d.a.p0.h2.n.g gVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048587, this) == null) || (gVar = this.f57098b) == null) {
            return;
        }
        gVar.f0();
    }

    public void m() {
        d.a.p0.h2.n.g gVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048588, this) == null) || (gVar = this.f57098b) == null) {
            return;
        }
        gVar.g0();
    }

    public void n(AbsListView absListView, int i2, int i3, int i4) {
        d.a.p0.h2.n.g gVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLIII(1048589, this, absListView, i2, i3, i4) == null) || (gVar = this.f57098b) == null) {
            return;
        }
        gVar.h0(absListView, i2);
    }

    public void o(AbsListView absListView, int i2) {
        d.a.p0.h2.n.g gVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLI(1048590, this, absListView, i2) == null) || (gVar = this.f57098b) == null) {
            return;
        }
        gVar.i0(absListView, i2);
    }

    public void p(BdTypeListView bdTypeListView) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048591, this, bdTypeListView) == null) || bdTypeListView == null) {
            return;
        }
        d.a.p0.h2.n.g gVar = this.f57098b;
        if (gVar != null) {
            bdTypeListView.removeHeaderView(gVar.R());
        }
        d.a.p0.h2.n.f fVar = this.f57099c;
        if (fVar != null) {
            fVar.e(bdTypeListView);
        }
    }

    public void q(PbLandscapeListView pbLandscapeListView, TextView textView, int i2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLLI(1048592, this, pbLandscapeListView, textView, i2) == null) || pbLandscapeListView == null) {
            return;
        }
        d.a.p0.h2.n.g gVar = this.f57098b;
        if (gVar == null || gVar.P() == null) {
            d.a.p0.h2.n.g gVar2 = this.f57098b;
            if (gVar2 != null) {
                pbLandscapeListView.removeHeaderView(gVar2.R());
            }
            if (textView != null) {
                pbLandscapeListView.removeHeaderView(textView);
                pbLandscapeListView.x(textView, 0);
                return;
            }
            return;
        }
        if (textView != null) {
            pbLandscapeListView.removeHeaderView(textView);
            pbLandscapeListView.setTextViewAdded(false);
        }
        if (i2 != 1) {
            pbLandscapeListView.removeHeaderView(this.f57098b.R());
            pbLandscapeListView.x(this.f57098b.R(), 0);
        }
    }

    public void r(boolean z) {
        d.a.p0.h2.n.g gVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(1048593, this, z) == null) || (gVar = this.f57098b) == null) {
            return;
        }
        gVar.o0(z);
    }

    public void s(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048594, this, z) == null) {
            this.f57100d = z;
        }
    }

    public void t(View.OnClickListener onClickListener) {
        d.a.p0.h2.n.g gVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048595, this, onClickListener) == null) || (gVar = this.f57098b) == null) {
            return;
        }
        gVar.s0(onClickListener);
    }

    public void u() {
        d.a.p0.h2.n.g gVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048596, this) == null) || (gVar = this.f57098b) == null) {
            return;
        }
        gVar.t0();
    }

    public void v(BdTypeListView bdTypeListView) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048597, this, bdTypeListView) == null) || this.f57098b == null) {
            return;
        }
        TiebaStatic.log(new StatisticItem("c11997").param("obj_type", 1));
        this.f57098b.t0();
        bdTypeListView.smoothScrollToPosition(0);
    }

    public void w(d.a.p0.h2.h.e eVar, PostData postData, BdTypeListView bdTypeListView, e eVar2, FrameLayout frameLayout, d.a.p0.h2.k.e.g1.c cVar, String str, long j) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeCommon(1048598, this, new Object[]{eVar, postData, bdTypeListView, eVar2, frameLayout, cVar, str, Long.valueOf(j)}) == null) && eVar != null && eVar.l0()) {
            d.a.p0.h2.n.g gVar = this.f57098b;
            if (gVar == null) {
                d.a.p0.h2.n.g gVar2 = new d.a.p0.h2.n.g(this.f57097a, cVar, eVar.N().l1(), j);
                this.f57098b = gVar2;
                gVar2.U(eVar.N().l1(), eVar.N(), eVar.n());
                this.f57098b.w0();
            } else if (this.f57100d) {
                gVar.U(eVar.N().l1(), eVar.N(), eVar.n());
                this.f57098b.w0();
            } else {
                gVar.x0(eVar.n());
            }
            d.a.p0.h2.m.a.d(this.f57097a.getUniqueId(), eVar, postData, 1, 1);
            if (eVar.J() != null && eVar.J().size() >= 1) {
                b2 b2Var = eVar.J().get(0);
                this.f57098b.q0(b2Var);
                this.f57098b.r0(b2Var.getTitle());
            }
            this.f57098b.k0(postData, eVar.N(), eVar.R());
            this.f57100d = false;
            bdTypeListView.removeHeaderView(this.f57098b.R());
            bdTypeListView.x(this.f57098b.R(), 0);
            if (this.f57098b.P() != null && this.f57098b.P().getParent() == null) {
                frameLayout.addView(this.f57098b.P());
            }
            if (this.f57099c == null) {
                this.f57099c = new d.a.p0.h2.n.f(this.f57097a.getBaseFragmentActivity());
            }
            this.f57099c.d(eVar, str);
            bdTypeListView.removeHeaderView(this.f57099c.b());
            bdTypeListView.x(this.f57099c.b(), 1);
            eVar2.s(bdTypeListView);
            eVar2.h(bdTypeListView, 2);
            if (this.f57098b != null) {
                cVar.y(false);
                this.f57098b.c0(TbadkCoreApplication.getInst().getSkinType());
            }
        }
    }
}
