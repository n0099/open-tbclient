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
public class lz7 extends kz7 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public uv7 n;
    public kv7 o;
    public lv7 p;
    public lw7 q;
    public PbReplyLoadMoreAdapter r;
    public tz7 s;
    public sz7 t;
    public mv7 u;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public lz7(DetailInfoAndReplyFragment detailInfoAndReplyFragment, BdTypeRecyclerView bdTypeRecyclerView) {
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

    @Override // com.repackage.kz7
    public void A(View.OnClickListener onClickListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, onClickListener) == null) {
            this.o.d0(onClickListener);
        }
    }

    @Override // com.repackage.kz7
    public void B(View.OnClickListener onClickListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, onClickListener) == null) {
            this.p.d0(onClickListener);
        }
    }

    @Override // com.repackage.kz7
    public void C(bs7 bs7Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, bs7Var) == null) {
        }
    }

    @Override // com.repackage.kz7
    public void D(dt7 dt7Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, dt7Var) == null) {
            super.D(dt7Var);
            this.q.Q0(dt7Var);
        }
    }

    @Override // com.repackage.kz7
    public void E(bs7 bs7Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, bs7Var) == null) {
            this.s.p0(bs7Var);
        }
    }

    @Override // com.repackage.kz7
    public void F(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, str) == null) {
            this.s.q(str);
        }
    }

    public final void H() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            this.s = new tz7(this.b.s(), PostData.w0);
            this.o = new kv7(this.b.s(), hs7.c, this.b.getUniqueId());
            this.p = new lv7(this.b.s(), is7.a);
            this.n = new uv7(this.b.s(), ls7.L0);
            lw7 lw7Var = new lw7(this.b.s(), PostData.x0);
            this.q = lw7Var;
            lw7Var.R0(this.b.s());
            this.q.N0(this.b.s().V2());
            this.r = new PbReplyLoadMoreAdapter(this.b.s(), PostData.D0);
            this.t = new sz7(this.b.getContext(), vs7.b, this.b.s());
            this.u = new mv7(this.b.s(), js7.c);
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

    @Override // com.repackage.kz7
    public yv7 e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            return null;
        }
        return (yv7) invokeV.objValue;
    }

    @Override // com.repackage.kz7
    public tu7 f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            return null;
        }
        return (tu7) invokeV.objValue;
    }

    @Override // com.repackage.kz7
    public PbFirstFloorCommentAndPraiseAdapter g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) {
            return null;
        }
        return (PbFirstFloorCommentAndPraiseAdapter) invokeV.objValue;
    }

    @Override // com.repackage.kz7
    public void l() {
        BdTypeRecyclerView bdTypeRecyclerView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048586, this) == null) || (bdTypeRecyclerView = this.c) == null || bdTypeRecyclerView.getAdapter() == null) {
            return;
        }
        this.c.getListAdapter().notifyDataSetChanged();
    }

    @Override // com.repackage.kz7
    public void m() {
        tz7 tz7Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048587, this) == null) || (tz7Var = this.s) == null) {
            return;
        }
        tz7Var.H();
    }

    @Override // com.repackage.kz7
    public void n() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048588, this) == null) {
        }
    }

    @Override // com.repackage.kz7
    public void p(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048589, this, z) == null) {
        }
    }

    @Override // com.repackage.kz7
    public void q(bs7 bs7Var, boolean z, String str, boolean z2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048590, this, new Object[]{bs7Var, Boolean.valueOf(z), str, Boolean.valueOf(z2)}) == null) {
            this.q.t(bs7Var);
            this.q.setFromCDN(z);
            this.q.q(str);
            this.q.c(z2);
            this.q.P0(0.5f);
        }
    }

    @Override // com.repackage.kz7
    public void v(View.OnClickListener onClickListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048591, this, onClickListener) == null) {
            super.v(onClickListener);
            this.q.l(onClickListener);
        }
    }

    @Override // com.repackage.kz7
    public void w(TbRichTextView.y yVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048592, this, yVar) == null) {
            super.w(yVar);
            this.q.o(yVar);
        }
    }

    @Override // com.repackage.kz7
    public void x(View.OnLongClickListener onLongClickListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048593, this, onLongClickListener) == null) {
            super.x(onLongClickListener);
            this.q.d(onLongClickListener);
        }
    }

    @Override // com.repackage.kz7
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
