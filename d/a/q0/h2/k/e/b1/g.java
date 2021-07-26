package d.a.q0.h2.k.e.b1;

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
import d.a.p0.s.q.b2;
/* loaded from: classes8.dex */
public class g {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public PbFragment f57681a;

    /* renamed from: b  reason: collision with root package name */
    public d.a.q0.h2.n.g f57682b;

    /* renamed from: c  reason: collision with root package name */
    public d.a.q0.h2.n.f f57683c;

    /* renamed from: d  reason: collision with root package name */
    public boolean f57684d;

    public g(PbFragment pbFragment) {
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
        this.f57684d = false;
        this.f57681a = pbFragment;
    }

    public void a() {
        d.a.q0.h2.n.g gVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || (gVar = this.f57682b) == null) {
            return;
        }
        gVar.O();
    }

    public void b() {
        d.a.q0.h2.n.g gVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) || (gVar = this.f57682b) == null) {
            return;
        }
        gVar.f0();
    }

    public View c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            d.a.q0.h2.n.g gVar = this.f57682b;
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
            d.a.q0.h2.n.g gVar = this.f57682b;
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
            d.a.q0.h2.n.g gVar = this.f57682b;
            return gVar != null && gVar.X();
        }
        return invokeV.booleanValue;
    }

    public boolean g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            d.a.q0.h2.n.g gVar = this.f57682b;
            if (gVar != null) {
                return gVar.Z();
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public void h(int i2) {
        d.a.q0.h2.n.f fVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048583, this, i2) == null) || (fVar = this.f57683c) == null) {
            return;
        }
        fVar.c(i2);
    }

    public void i(int i2) {
        d.a.q0.h2.n.g gVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(InputDeviceCompat.SOURCE_TOUCHPAD, this, i2) == null) || (gVar = this.f57682b) == null) {
            return;
        }
        gVar.c0(i2);
    }

    public void j(Configuration configuration) {
        d.a.q0.h2.n.g gVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048585, this, configuration) == null) || (gVar = this.f57682b) == null) {
            return;
        }
        gVar.d0(configuration);
    }

    public boolean k(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048586, this, i2)) == null) {
            d.a.q0.h2.n.g gVar = this.f57682b;
            if (gVar != null) {
                return gVar.e0(i2);
            }
            return false;
        }
        return invokeI.booleanValue;
    }

    public void l() {
        d.a.q0.h2.n.g gVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048587, this) == null) || (gVar = this.f57682b) == null) {
            return;
        }
        gVar.f0();
    }

    public void m() {
        d.a.q0.h2.n.g gVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048588, this) == null) || (gVar = this.f57682b) == null) {
            return;
        }
        gVar.g0();
    }

    public void n(AbsListView absListView, int i2, int i3, int i4) {
        d.a.q0.h2.n.g gVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLIII(1048589, this, absListView, i2, i3, i4) == null) || (gVar = this.f57682b) == null) {
            return;
        }
        gVar.h0(absListView, i2);
    }

    public void o(AbsListView absListView, int i2) {
        d.a.q0.h2.n.g gVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLI(1048590, this, absListView, i2) == null) || (gVar = this.f57682b) == null) {
            return;
        }
        gVar.i0(absListView, i2);
    }

    public void p(BdTypeListView bdTypeListView) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048591, this, bdTypeListView) == null) || bdTypeListView == null) {
            return;
        }
        d.a.q0.h2.n.g gVar = this.f57682b;
        if (gVar != null) {
            bdTypeListView.removeHeaderView(gVar.R());
        }
        d.a.q0.h2.n.f fVar = this.f57683c;
        if (fVar != null) {
            fVar.e(bdTypeListView);
        }
    }

    public void q(PbLandscapeListView pbLandscapeListView, TextView textView, int i2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLLI(1048592, this, pbLandscapeListView, textView, i2) == null) || pbLandscapeListView == null) {
            return;
        }
        d.a.q0.h2.n.g gVar = this.f57682b;
        if (gVar == null || gVar.P() == null) {
            d.a.q0.h2.n.g gVar2 = this.f57682b;
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
            pbLandscapeListView.removeHeaderView(this.f57682b.R());
            pbLandscapeListView.x(this.f57682b.R(), 0);
        }
    }

    public void r(boolean z) {
        d.a.q0.h2.n.g gVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(1048593, this, z) == null) || (gVar = this.f57682b) == null) {
            return;
        }
        gVar.o0(z);
    }

    public void s(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048594, this, z) == null) {
            this.f57684d = z;
        }
    }

    public void t(View.OnClickListener onClickListener) {
        d.a.q0.h2.n.g gVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048595, this, onClickListener) == null) || (gVar = this.f57682b) == null) {
            return;
        }
        gVar.s0(onClickListener);
    }

    public void u() {
        d.a.q0.h2.n.g gVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048596, this) == null) || (gVar = this.f57682b) == null) {
            return;
        }
        gVar.t0();
    }

    public void v(BdTypeListView bdTypeListView) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048597, this, bdTypeListView) == null) || this.f57682b == null) {
            return;
        }
        TiebaStatic.log(new StatisticItem("c11997").param("obj_type", 1));
        this.f57682b.t0();
        bdTypeListView.smoothScrollToPosition(0);
    }

    public void w(d.a.q0.h2.h.e eVar, PostData postData, BdTypeListView bdTypeListView, f fVar, FrameLayout frameLayout, d.a.q0.h2.k.e.h1.c cVar, String str, long j) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeCommon(1048598, this, new Object[]{eVar, postData, bdTypeListView, fVar, frameLayout, cVar, str, Long.valueOf(j)}) == null) && eVar != null && eVar.l0()) {
            d.a.q0.h2.n.g gVar = this.f57682b;
            if (gVar == null) {
                d.a.q0.h2.n.g gVar2 = new d.a.q0.h2.n.g(this.f57681a, cVar, eVar.N().m1(), j);
                this.f57682b = gVar2;
                gVar2.U(eVar.N().m1(), eVar.N(), eVar.n());
                this.f57682b.w0();
            } else if (this.f57684d) {
                gVar.U(eVar.N().m1(), eVar.N(), eVar.n());
                this.f57682b.w0();
            } else {
                gVar.x0(eVar.n());
            }
            d.a.q0.h2.m.a.d(this.f57681a.getUniqueId(), eVar, postData, 1, 1);
            if (eVar.J() != null && eVar.J().size() >= 1) {
                b2 b2Var = eVar.J().get(0);
                this.f57682b.q0(b2Var);
                this.f57682b.r0(b2Var.getTitle());
            }
            this.f57682b.k0(postData, eVar.N(), eVar.R());
            this.f57684d = false;
            bdTypeListView.removeHeaderView(this.f57682b.R());
            bdTypeListView.x(this.f57682b.R(), 0);
            if (this.f57682b.P() != null && this.f57682b.P().getParent() == null) {
                frameLayout.addView(this.f57682b.P());
            }
            if (this.f57683c == null) {
                this.f57683c = new d.a.q0.h2.n.f(this.f57681a.getBaseFragmentActivity());
            }
            this.f57683c.d(eVar, str);
            bdTypeListView.removeHeaderView(this.f57683c.b());
            bdTypeListView.x(this.f57683c.b(), 1);
            fVar.t(bdTypeListView);
            fVar.i(bdTypeListView, 2);
            if (this.f57682b != null) {
                cVar.H(false);
                this.f57682b.c0(TbadkCoreApplication.getInst().getSkinType());
            }
        }
    }
}
