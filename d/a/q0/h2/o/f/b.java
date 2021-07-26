package d.a.q0.h2.o.f;

import android.view.View;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.widget.ListView.BdTypeRecyclerView;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.widget.richText.TbRichTextView;
import com.baidu.tieba.pb.pb.adapter.PbReplyLoadMoreAdapter;
import com.baidu.tieba.pb.pb.main.adapter.PbFirstFloorCommentAndPraiseAdapter;
import com.baidu.tieba.pb.videopb.fragment.DetailInfoAndReplyFragment;
import com.baidu.tieba.tbadkCore.data.PostData;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import d.a.q0.h2.h.l;
import d.a.q0.h2.h.v;
import d.a.q0.h2.k.e.b0;
import d.a.q0.h2.k.e.j0;
import d.a.q0.h2.k.e.m;
import d.a.q0.h2.k.e.n0;
import d.a.q0.h2.k.e.z0;
/* loaded from: classes8.dex */
public class b extends a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public j0 m;
    public b0 n;
    public z0 o;
    public PbReplyLoadMoreAdapter p;
    public j q;
    public i r;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public b(DetailInfoAndReplyFragment detailInfoAndReplyFragment, BdTypeRecyclerView bdTypeRecyclerView) {
        super(detailInfoAndReplyFragment, bdTypeRecyclerView);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {detailInfoAndReplyFragment, bdTypeRecyclerView};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((DetailInfoAndReplyFragment) objArr2[0], (BdTypeRecyclerView) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        F();
    }

    @Override // d.a.q0.h2.o.f.a
    public void A(d.a.q0.h2.h.e eVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, eVar) == null) {
        }
    }

    @Override // d.a.q0.h2.o.f.a
    public void B(d.a.q0.h2.i.c cVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, cVar) == null) {
            super.B(cVar);
            this.o.Z0(cVar);
        }
    }

    @Override // d.a.q0.h2.o.f.a
    public void C(d.a.q0.h2.h.e eVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, eVar) == null) {
            this.q.z0(eVar);
        }
    }

    @Override // d.a.q0.h2.o.f.a
    public void D(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, str) == null) {
            this.q.q(str);
        }
    }

    public final void F() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            this.q = new j(this.f58330b.v(), PostData.t0);
            this.n = new b0(this.f58330b.v(), d.a.q0.h2.h.j.f57456g, this.f58330b.getUniqueId());
            this.m = new j0(this.f58330b.v(), l.I0);
            z0 z0Var = new z0(this.f58330b.v(), PostData.u0);
            this.o = z0Var;
            z0Var.a1(this.f58330b.v());
            this.o.W0(this.f58330b.v().d3());
            this.p = new PbReplyLoadMoreAdapter(this.f58330b.v(), PostData.A0);
            this.r = new i(this.f58330b.getContext(), v.f57504f, this.f58330b.v());
            this.f58333e.add(this.q);
            this.f58333e.add(this.r);
            this.f58333e.add(this.m);
            this.f58333e.add(this.n);
            this.f58333e.add(this.o);
            this.f58333e.add(this.p);
            this.f58331c.a(this.f58333e);
        }
    }

    @Override // d.a.q0.h2.o.f.a
    public n0 e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            return null;
        }
        return (n0) invokeV.objValue;
    }

    @Override // d.a.q0.h2.o.f.a
    public m f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            return null;
        }
        return (m) invokeV.objValue;
    }

    @Override // d.a.q0.h2.o.f.a
    public PbFirstFloorCommentAndPraiseAdapter g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            return null;
        }
        return (PbFirstFloorCommentAndPraiseAdapter) invokeV.objValue;
    }

    @Override // d.a.q0.h2.o.f.a
    public void k() {
        BdTypeRecyclerView bdTypeRecyclerView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) || (bdTypeRecyclerView = this.f58331c) == null || bdTypeRecyclerView.getAdapter() == null) {
            return;
        }
        this.f58331c.getListAdapter().notifyDataSetChanged();
    }

    @Override // d.a.q0.h2.o.f.a
    public void l() {
        j jVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048585, this) == null) || (jVar = this.q) == null) {
            return;
        }
        jVar.L();
    }

    @Override // d.a.q0.h2.o.f.a
    public void m() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048586, this) == null) {
        }
    }

    @Override // d.a.q0.h2.o.f.a
    public void o(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048587, this, z) == null) {
        }
    }

    @Override // d.a.q0.h2.o.f.a
    public void p(d.a.q0.h2.h.e eVar, boolean z, String str, boolean z2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048588, this, new Object[]{eVar, Boolean.valueOf(z), str, Boolean.valueOf(z2)}) == null) {
            this.o.t(eVar);
            this.o.setFromCDN(z);
            this.o.q(str);
            this.o.c(z2);
            this.o.Y0(0.5f);
        }
    }

    @Override // d.a.q0.h2.o.f.a
    public void u(View.OnClickListener onClickListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048589, this, onClickListener) == null) {
            super.u(onClickListener);
            this.o.m(onClickListener);
        }
    }

    @Override // d.a.q0.h2.o.f.a
    public void v(TbRichTextView.z zVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048590, this, zVar) == null) {
            super.v(zVar);
            this.o.p(zVar);
        }
    }

    @Override // d.a.q0.h2.o.f.a
    public void w(View.OnLongClickListener onLongClickListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048591, this, onLongClickListener) == null) {
            super.w(onLongClickListener);
            this.o.d(onLongClickListener);
        }
    }

    @Override // d.a.q0.h2.o.f.a
    public void y(View.OnClickListener onClickListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048592, this, onClickListener) == null) {
            super.y(onClickListener);
            this.o.e(onClickListener);
            this.p.j0(onClickListener);
        }
    }

    @Override // d.a.q0.h2.o.f.a
    public void z(View.OnClickListener onClickListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048593, this, onClickListener) == null) {
            this.n.j0(onClickListener);
        }
    }
}
