package com.repackage;

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
/* loaded from: classes7.dex */
public class x08 extends w08 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public yw7 n;
    public pw7 o;
    public qw7 p;
    public tx7 q;
    public PbReplyLoadMoreAdapter r;
    public f18 s;
    public e18 t;
    public rw7 u;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public x08(DetailInfoAndReplyFragment detailInfoAndReplyFragment, BdTypeRecyclerView bdTypeRecyclerView) {
        super(detailInfoAndReplyFragment, bdTypeRecyclerView);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {detailInfoAndReplyFragment, bdTypeRecyclerView};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((DetailInfoAndReplyFragment) objArr2[0], (BdTypeRecyclerView) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        I();
    }

    @Override // com.repackage.w08
    public void A(View.OnClickListener onClickListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, onClickListener) == null) {
            super.A(onClickListener);
            this.q.e(onClickListener);
            this.r.w(onClickListener);
            this.u.e(onClickListener);
        }
    }

    @Override // com.repackage.w08
    public void B(View.OnClickListener onClickListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, onClickListener) == null) {
            this.o.w(onClickListener);
        }
    }

    @Override // com.repackage.w08
    public void C(View.OnClickListener onClickListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, onClickListener) == null) {
            this.p.w(onClickListener);
        }
    }

    @Override // com.repackage.w08
    public void D(et7 et7Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, et7Var) == null) {
        }
    }

    @Override // com.repackage.w08
    public void E(gu7 gu7Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, gu7Var) == null) {
            super.E(gu7Var);
            this.q.o0(gu7Var);
        }
    }

    @Override // com.repackage.w08
    public void F(et7 et7Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, et7Var) == null) {
            this.s.M(et7Var);
        }
    }

    @Override // com.repackage.w08
    public void G(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, str) == null) {
            this.s.o(str);
        }
    }

    public final void I() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            this.s = new f18(this.b.B(), PostData.J0);
            this.o = new pw7(this.b.B(), kt7.c, this.b.getUniqueId());
            this.p = new qw7(this.b.B(), lt7.a);
            this.n = new yw7(this.b.B(), ot7.Z0);
            tx7 tx7Var = new tx7(this.b.B(), PostData.K0);
            this.q = tx7Var;
            tx7Var.p0(this.b.B());
            this.q.k0(this.b.B().N3());
            this.r = new PbReplyLoadMoreAdapter(this.b.B(), PostData.R0);
            this.t = new e18(this.b.getContext(), yt7.b, this.b.B());
            this.u = new rw7(this.b.B(), mt7.c);
            this.e.add(this.s);
            this.e.add(this.t);
            this.e.add(this.n);
            this.e.add(this.o);
            this.e.add(this.p);
            this.e.add(this.q);
            this.e.add(this.r);
            this.e.add(this.u);
            this.c.a(this.e);
        }
    }

    @Override // com.repackage.w08
    public cx7 e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            return null;
        }
        return (cx7) invokeV.objValue;
    }

    @Override // com.repackage.w08
    public yv7 f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) {
            return null;
        }
        return (yv7) invokeV.objValue;
    }

    @Override // com.repackage.w08
    public PbFirstFloorCommentAndPraiseAdapter g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) {
            return null;
        }
        return (PbFirstFloorCommentAndPraiseAdapter) invokeV.objValue;
    }

    @Override // com.repackage.w08
    public void l() {
        BdTypeRecyclerView bdTypeRecyclerView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048587, this) == null) || (bdTypeRecyclerView = this.c) == null || bdTypeRecyclerView.getAdapter() == null) {
            return;
        }
        this.c.getListAdapter().notifyDataSetChanged();
    }

    @Override // com.repackage.w08
    public void m() {
        f18 f18Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048588, this) == null) || (f18Var = this.s) == null) {
            return;
        }
        f18Var.notifyDataSetChanged();
    }

    @Override // com.repackage.w08
    public void n() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048589, this) == null) {
        }
    }

    @Override // com.repackage.w08
    public void p(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048590, this, z) == null) {
        }
    }

    @Override // com.repackage.w08
    public void q(et7 et7Var, boolean z, String str, boolean z2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048591, this, new Object[]{et7Var, Boolean.valueOf(z), str, Boolean.valueOf(z2)}) == null) {
            this.q.r(et7Var);
            this.q.setFromCDN(z);
            this.q.o(str);
            this.q.c(z2);
            this.q.m0(0.5f);
        }
    }

    @Override // com.repackage.w08
    public void v(View.OnClickListener onClickListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048592, this, onClickListener) == null) {
            super.v(onClickListener);
            this.q.k(onClickListener);
        }
    }

    @Override // com.repackage.w08
    public void w(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048593, this, z) == null) {
            tx7 tx7Var = this.q;
            if (tx7Var != null) {
                tx7Var.n0(z);
            }
            e18 e18Var = this.t;
            if (e18Var != null) {
                e18Var.v(z);
            }
            f18 f18Var = this.s;
            if (f18Var != null) {
                f18Var.L(z);
            }
        }
    }

    @Override // com.repackage.w08
    public void x(TbRichTextView.y yVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048594, this, yVar) == null) {
            super.x(yVar);
            this.q.n(yVar);
        }
    }

    @Override // com.repackage.w08
    public void y(View.OnLongClickListener onLongClickListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048595, this, onLongClickListener) == null) {
            super.y(onLongClickListener);
            this.q.d(onLongClickListener);
        }
    }
}
