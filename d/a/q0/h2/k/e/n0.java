package d.a.q0.h2.k.e;

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
/* loaded from: classes8.dex */
public class n0 extends o<d.a.q0.h2.h.o, PbReplyTitleViewHolder> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public View.OnClickListener s;
    public SortSwitchButton.f t;
    public BdUniqueId u;
    public BdUniqueId v;
    public boolean w;
    public d.a.q0.h2.h.e x;
    public View y;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public n0(d.a.q0.h2.o.b bVar, BdUniqueId bdUniqueId) {
        super(bVar, bdUniqueId);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {bVar, bdUniqueId};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((d.a.q0.h2.o.b) objArr2[0], (BdUniqueId) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.w = false;
        this.u = BdUniqueId.gen();
        this.v = BdUniqueId.gen();
    }

    @Override // d.a.q0.h2.k.e.o, d.a.d.k.e.a
    public /* bridge */ /* synthetic */ View X(int i2, View view, ViewGroup viewGroup, Object obj, TypeAdapter.ViewHolder viewHolder) {
        k0(i2, view, viewGroup, (d.a.q0.h2.h.o) obj, (PbReplyTitleViewHolder) viewHolder);
        return view;
    }

    public void e(View.OnClickListener onClickListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, onClickListener) == null) {
            this.s = onClickListener;
        }
    }

    public final void g0() {
        d.a.q0.h2.h.e eVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048579, this) == null) || (eVar = this.x) == null || eVar.N() == null || this.x.h() == null) {
            return;
        }
        d.a.q0.h2.h.e eVar2 = this.x;
        if (eVar2.f57445i && !this.w) {
            this.w = true;
            boolean isLike = eVar2.h().getIsLike();
            TiebaStatic.log(new StatisticItem("common_exp").param("page_type", "a005").param(TiebaStatic.Params.OBJ_ISAD, 1).param(TiebaStatic.Params.OBJ_FLOOR, 1).param(TiebaStatic.Params.OBJ_AD_LOCATE, 9).param("obj_id", this.x.h().h()).param("thread_type", this.x.N().k1()).param("tid", this.x.N().d0()));
            if (isLike) {
                return;
            }
            TiebaStatic.log(new StatisticItem("common_exp").param("page_type", "a005").param(TiebaStatic.Params.OBJ_ISAD, 1).param(TiebaStatic.Params.OBJ_FLOOR, 1).param(TiebaStatic.Params.OBJ_AD_LOCATE, 10).param("obj_id", this.x.h().h()).param("thread_type", this.x.N().k1()).param("tid", this.x.N().d0()));
        }
    }

    public View i0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.y : (View) invokeV.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.a.d.k.e.a
    /* renamed from: j0 */
    public PbReplyTitleViewHolder Q(ViewGroup viewGroup) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, viewGroup)) == null) {
            View inflate = LayoutInflater.from(this.f42341e).inflate(R.layout.pb_reply_title_layout, viewGroup, false);
            this.y = inflate;
            PbReplyTitleViewHolder pbReplyTitleViewHolder = new PbReplyTitleViewHolder(this.m.getPageContext(), inflate);
            PbFragment pbFragment = this.n;
            if (pbFragment != null) {
                pbReplyTitleViewHolder.q(pbFragment.l0);
            }
            pbReplyTitleViewHolder.u = false;
            pbReplyTitleViewHolder.p(this.s);
            pbReplyTitleViewHolder.o(this.t);
            if (H() == d.a.q0.h2.h.o.l) {
                pbReplyTitleViewHolder.n(this.u);
            } else if (H() == d.a.q0.h2.h.o.m) {
                pbReplyTitleViewHolder.m(this.v);
            }
            return pbReplyTitleViewHolder;
        }
        return (PbReplyTitleViewHolder) invokeL.objValue;
    }

    public View k0(int i2, View view, ViewGroup viewGroup, d.a.q0.h2.h.o oVar, PbReplyTitleViewHolder pbReplyTitleViewHolder) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048582, this, new Object[]{Integer.valueOf(i2), view, viewGroup, oVar, pbReplyTitleViewHolder})) == null) {
            super.X(i2, view, viewGroup, oVar, pbReplyTitleViewHolder);
            if (pbReplyTitleViewHolder != null) {
                g0();
                oVar.k = this.x.f57442f;
                pbReplyTitleViewHolder.h(oVar);
            }
            return view;
        }
        return (View) invokeCommon.objValue;
    }

    public void l0(SortSwitchButton.f fVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, fVar) == null) {
            this.t = fVar;
        }
    }

    public void onDestroy() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
            this.w = false;
            MessageManager.getInstance().unRegisterListener(this.u);
            MessageManager.getInstance().unRegisterListener(this.v);
        }
    }

    public void t(d.a.q0.h2.h.e eVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048585, this, eVar) == null) {
            this.x = eVar;
        }
    }
}
