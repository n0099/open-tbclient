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
/* loaded from: classes6.dex */
public class hz7 extends gz7 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public ov7 n;
    public ev7 o;
    public fv7 p;
    public fw7 q;
    public PbReplyLoadMoreAdapter r;
    public pz7 s;
    public oz7 t;
    public gv7 u;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public hz7(DetailInfoAndReplyFragment detailInfoAndReplyFragment, BdTypeRecyclerView bdTypeRecyclerView) {
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
        H();
    }

    @Override // com.repackage.gz7
    public void A(View.OnClickListener onClickListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, onClickListener) == null) {
            this.o.d0(onClickListener);
        }
    }

    @Override // com.repackage.gz7
    public void B(View.OnClickListener onClickListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, onClickListener) == null) {
            this.p.d0(onClickListener);
        }
    }

    @Override // com.repackage.gz7
    public void C(yr7 yr7Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, yr7Var) == null) {
        }
    }

    @Override // com.repackage.gz7
    public void D(ws7 ws7Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, ws7Var) == null) {
            super.D(ws7Var);
            this.q.Q0(ws7Var);
        }
    }

    @Override // com.repackage.gz7
    public void E(yr7 yr7Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, yr7Var) == null) {
            this.s.p0(yr7Var);
        }
    }

    @Override // com.repackage.gz7
    public void F(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, str) == null) {
            this.s.p(str);
        }
    }

    public final void H() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            this.s = new pz7(this.b.t(), PostData.w0);
            this.o = new ev7(this.b.t(), es7.c, this.b.getUniqueId());
            this.p = new fv7(this.b.t(), fs7.a);
            this.n = new ov7(this.b.t(), is7.L0);
            fw7 fw7Var = new fw7(this.b.t(), PostData.x0);
            this.q = fw7Var;
            fw7Var.R0(this.b.t());
            this.q.N0(this.b.t().U2());
            this.r = new PbReplyLoadMoreAdapter(this.b.t(), PostData.D0);
            this.t = new oz7(this.b.getContext(), ss7.b, this.b.t());
            this.u = new gv7(this.b.t(), gs7.c);
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

    @Override // com.repackage.gz7
    public sv7 e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            return null;
        }
        return (sv7) invokeV.objValue;
    }

    @Override // com.repackage.gz7
    public nu7 f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            return null;
        }
        return (nu7) invokeV.objValue;
    }

    @Override // com.repackage.gz7
    public PbFirstFloorCommentAndPraiseAdapter g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) {
            return null;
        }
        return (PbFirstFloorCommentAndPraiseAdapter) invokeV.objValue;
    }

    @Override // com.repackage.gz7
    public void l() {
        BdTypeRecyclerView bdTypeRecyclerView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048586, this) == null) || (bdTypeRecyclerView = this.c) == null || bdTypeRecyclerView.getAdapter() == null) {
            return;
        }
        this.c.getListAdapter().notifyDataSetChanged();
    }

    @Override // com.repackage.gz7
    public void m() {
        pz7 pz7Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048587, this) == null) || (pz7Var = this.s) == null) {
            return;
        }
        pz7Var.H();
    }

    @Override // com.repackage.gz7
    public void n() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048588, this) == null) {
        }
    }

    @Override // com.repackage.gz7
    public void p(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048589, this, z) == null) {
        }
    }

    @Override // com.repackage.gz7
    public void q(yr7 yr7Var, boolean z, String str, boolean z2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048590, this, new Object[]{yr7Var, Boolean.valueOf(z), str, Boolean.valueOf(z2)}) == null) {
            this.q.t(yr7Var);
            this.q.setFromCDN(z);
            this.q.p(str);
            this.q.c(z2);
            this.q.P0(0.5f);
        }
    }

    @Override // com.repackage.gz7
    public void v(View.OnClickListener onClickListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048591, this, onClickListener) == null) {
            super.v(onClickListener);
            this.q.l(onClickListener);
        }
    }

    @Override // com.repackage.gz7
    public void w(TbRichTextView.y yVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048592, this, yVar) == null) {
            super.w(yVar);
            this.q.o(yVar);
        }
    }

    @Override // com.repackage.gz7
    public void x(View.OnLongClickListener onLongClickListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048593, this, onLongClickListener) == null) {
            super.x(onLongClickListener);
            this.q.d(onLongClickListener);
        }
    }

    @Override // com.repackage.gz7
    public void z(View.OnClickListener onClickListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048594, this, onClickListener) == null) {
            super.z(onClickListener);
            this.q.e(onClickListener);
            this.r.d0(onClickListener);
            this.u.e(onClickListener);
        }
    }
}
