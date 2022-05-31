package com.repackage;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.widget.ListView.TypeAdapter;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tieba.R;
import com.baidu.tieba.pb.pb.main.PbFragment;
import com.baidu.tieba.pb.pb.main.PbReplyTitleViewHolder;
import com.baidu.tieba.view.SortSwitchButton;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes6.dex */
public class ht7 extends es7<xp7, PbReplyTitleViewHolder> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public View.OnClickListener o;
    public SortSwitchButton.f p;
    public BdUniqueId q;
    public BdUniqueId r;
    public boolean s;
    public kp7 t;
    public View u;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ht7(pw7 pw7Var, BdUniqueId bdUniqueId) {
        super(pw7Var, bdUniqueId);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {pw7Var, bdUniqueId};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((pw7) objArr2[0], (BdUniqueId) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.s = false;
        this.q = BdUniqueId.gen();
        this.r = BdUniqueId.gen();
    }

    @Override // com.repackage.es7, com.repackage.wm
    public /* bridge */ /* synthetic */ View S(int i, View view2, ViewGroup viewGroup, Object obj, TypeAdapter.ViewHolder viewHolder) {
        e0(i, view2, viewGroup, (xp7) obj, (PbReplyTitleViewHolder) viewHolder);
        return view2;
    }

    public final void b0() {
        kp7 kp7Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) || (kp7Var = this.t) == null || kp7Var.O() == null || this.t.h() == null) {
            return;
        }
        kp7 kp7Var2 = this.t;
        if (kp7Var2.i && !this.s) {
            this.s = true;
            boolean isLike = kp7Var2.h().getIsLike();
            TiebaStatic.log(new StatisticItem("common_exp").param("page_type", "a005").param(TiebaStatic.Params.OBJ_ISAD, 1).param(TiebaStatic.Params.OBJ_FLOOR, 1).param(TiebaStatic.Params.OBJ_AD_LOCATE, 9).param("obj_id", this.t.h().b()).param("thread_type", this.t.O().getThreadType()).param("tid", this.t.O().getId()));
            if (isLike) {
                return;
            }
            TiebaStatic.log(new StatisticItem("common_exp").param("page_type", "a005").param(TiebaStatic.Params.OBJ_ISAD, 1).param(TiebaStatic.Params.OBJ_FLOOR, 1).param(TiebaStatic.Params.OBJ_AD_LOCATE, 10).param("obj_id", this.t.h().b()).param("thread_type", this.t.O().getThreadType()).param("tid", this.t.O().getId()));
        }
    }

    public View c0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.u : (View) invokeV.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.repackage.wm
    /* renamed from: d0 */
    public PbReplyTitleViewHolder M(ViewGroup viewGroup) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, viewGroup)) == null) {
            View inflate = LayoutInflater.from(this.a).inflate(R.layout.obfuscated_res_0x7f0d0685, viewGroup, false);
            this.u = inflate;
            PbReplyTitleViewHolder pbReplyTitleViewHolder = new PbReplyTitleViewHolder(this.i.getPageContext(), inflate);
            PbFragment pbFragment = this.j;
            if (pbFragment != null) {
                pbReplyTitleViewHolder.s(pbFragment.k0);
            }
            pbReplyTitleViewHolder.u = false;
            pbReplyTitleViewHolder.r(this.o);
            pbReplyTitleViewHolder.q(this.p);
            if (getType() == xp7.h) {
                pbReplyTitleViewHolder.o(this.q);
            } else if (getType() == xp7.i) {
                pbReplyTitleViewHolder.n(this.r);
            }
            return pbReplyTitleViewHolder;
        }
        return (PbReplyTitleViewHolder) invokeL.objValue;
    }

    public void e(View.OnClickListener onClickListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, onClickListener) == null) {
            this.o = onClickListener;
        }
    }

    public View e0(int i, View view2, ViewGroup viewGroup, xp7 xp7Var, PbReplyTitleViewHolder pbReplyTitleViewHolder) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048582, this, new Object[]{Integer.valueOf(i), view2, viewGroup, xp7Var, pbReplyTitleViewHolder})) == null) {
            super.S(i, view2, viewGroup, xp7Var, pbReplyTitleViewHolder);
            if (pbReplyTitleViewHolder != null) {
                b0();
                xp7Var.g = this.t.f;
                pbReplyTitleViewHolder.i(xp7Var);
            }
            return view2;
        }
        return (View) invokeCommon.objValue;
    }

    public void f0(SortSwitchButton.f fVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, fVar) == null) {
            this.p = fVar;
        }
    }

    public void onDestroy() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
            this.s = false;
            MessageManager.getInstance().unRegisterListener(this.q);
            MessageManager.getInstance().unRegisterListener(this.r);
        }
    }

    public void t(kp7 kp7Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048585, this, kp7Var) == null) {
            this.t = kp7Var;
        }
    }
}
