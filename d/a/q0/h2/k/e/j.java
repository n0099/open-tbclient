package d.a.q0.h2.k.e;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.SvgManager;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.tbselector.TBSelector;
import com.baidu.tieba.R;
import com.baidu.tieba.pb.pb.main.PbBjhRecommendViewHolder;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes8.dex */
public class j extends o<d.a.p0.s.q.q, PbBjhRecommendViewHolder> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public d.a.q0.h2.h.e s;
    public int t;
    public boolean u;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public j(d.a.q0.h2.o.b bVar, BdUniqueId bdUniqueId) {
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
    }

    public final void g0(PbBjhRecommendViewHolder pbBjhRecommendViewHolder) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, pbBjhRecommendViewHolder) == null) || pbBjhRecommendViewHolder == null) {
            return;
        }
        int skinType = TbadkCoreApplication.getInst().getSkinType();
        if (pbBjhRecommendViewHolder.f19272a != skinType) {
            SkinManager.setBackgroundColor(pbBjhRecommendViewHolder.j, R.color.CAM_X0204, skinType);
            SkinManager.setBackgroundColor(pbBjhRecommendViewHolder.y, R.color.CAM_X0203, skinType);
            SkinManager.setBackgroundColor(pbBjhRecommendViewHolder.t, R.color.CAM_X0204, skinType);
            SkinManager.setViewTextColor(pbBjhRecommendViewHolder.v, R.color.CAM_X0302, 1, skinType);
            SkinManager.setViewTextColor(pbBjhRecommendViewHolder.o, R.color.CAM_X0105, 1, skinType);
            pbBjhRecommendViewHolder.q.setImageDrawable(SvgManager.getInstance().getPureDrawable(R.drawable.ic_icon_pure_video_play12_svg, R.color.CAM_X0101, null));
            SkinManager.setViewTextColor(pbBjhRecommendViewHolder.r, R.color.CAM_X0101, 1, skinType);
            SkinManager.setViewTextColor(pbBjhRecommendViewHolder.w, R.color.CAM_X0109, 1, skinType);
            SkinManager.setViewTextColor(pbBjhRecommendViewHolder.x, R.color.CAM_X0109, 1, skinType);
            SkinManager.setBackgroundSelector(pbBjhRecommendViewHolder.f19280i, R.color.CAM_X0205, R.color.CAM_X0204, skinType);
            TBSelector.makeDrawableSelector().setShape(0).gradientLinear(R.color.cp_bg_line_d_alpha0, R.color.CAM_X0105).cornerRadius(d.a.d.e.p.l.g(this.m.z(), R.dimen.tbds10)).into(pbBjhRecommendViewHolder.n);
        }
        pbBjhRecommendViewHolder.f19272a = skinType;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.a.d.k.e.a
    /* renamed from: i0 */
    public PbBjhRecommendViewHolder Q(ViewGroup viewGroup) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, viewGroup)) == null) {
            PbBjhRecommendViewHolder pbBjhRecommendViewHolder = new PbBjhRecommendViewHolder(LayoutInflater.from(this.f42341e).inflate(R.layout.bjh_recommend_item, (ViewGroup) null), this.m.z());
            g0(pbBjhRecommendViewHolder);
            return pbBjhRecommendViewHolder;
        }
        return (PbBjhRecommendViewHolder) invokeL.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.a.q0.h2.k.e.o, d.a.d.k.e.a
    /* renamed from: j0 */
    public View X(int i2, View view, ViewGroup viewGroup, d.a.p0.s.q.q qVar, PbBjhRecommendViewHolder pbBjhRecommendViewHolder) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048580, this, new Object[]{Integer.valueOf(i2), view, viewGroup, qVar, pbBjhRecommendViewHolder})) == null) {
            super.X(i2, view, viewGroup, qVar, pbBjhRecommendViewHolder);
            if (qVar == null) {
                return null;
            }
            g0(pbBjhRecommendViewHolder);
            pbBjhRecommendViewHolder.i(qVar);
            pbBjhRecommendViewHolder.j(this.t);
            pbBjhRecommendViewHolder.n(this.u);
            d.a.q0.h2.h.e eVar = this.s;
            if (eVar != null) {
                pbBjhRecommendViewHolder.m(eVar.P());
                pbBjhRecommendViewHolder.l(this.s.l0());
                if (this.s.N() != null && this.s.N().J() != null) {
                    pbBjhRecommendViewHolder.k(this.s.N().J().oriUgcNid);
                }
                int i3 = this.t;
                int i4 = 3;
                if (i3 == 2) {
                    i4 = 1;
                } else if (i3 == 1) {
                    i4 = 2;
                } else if (i3 != 3) {
                    i4 = 4;
                }
                if (qVar.Z == 40) {
                    StatisticItem.make("c13536").param("tid", qVar.o1()).param("fid", qVar.R()).param("obj_source", i4).param("obj_locate", qVar.u4()).param("obj_id", this.s.P()).param("obj_type", qVar.K1() ? 1 : 0).eventStat();
                } else {
                    StatisticItem.make("c13533").param("tid", qVar.o1()).param("fid", qVar.R()).param("obj_source", i4).param("obj_locate", qVar.u4()).param("obj_id", this.s.P()).eventStat();
                }
                if (this.s.l0()) {
                    StatisticItem statisticItem = new StatisticItem("c13588");
                    if (qVar.W() != null) {
                        statisticItem.param("fid", qVar.W().h());
                    }
                    statisticItem.param("tid", qVar.o1());
                    statisticItem.param("obj_param1", qVar.U0);
                    statisticItem.param("obj_source", qVar.T0);
                    statisticItem.param("obj_locate", qVar.u4());
                    statisticItem.param(TiebaStatic.Params.OBJ_PARAM3, System.currentTimeMillis());
                    statisticItem.param("obj_id", this.s.P());
                    statisticItem.param("uid", TbadkCoreApplication.getCurrentAccount());
                    qVar.getThreadData();
                    if (qVar.J() != null) {
                        qVar.getThreadData();
                        statisticItem.param(TiebaStatic.Params.OBJ_PARAM4, qVar.J().oriUgcNid);
                        qVar.getThreadData();
                        statisticItem.param(TiebaStatic.Params.OBJ_PARAM5, qVar.J().oriUgcVid);
                    }
                    statisticItem.param(TiebaStatic.Params.OBJ_PARAM6, qVar.w1());
                    statisticItem.param("ab_tag", qVar.V0);
                    statisticItem.param("extra", qVar.W0);
                    TiebaStatic.log(statisticItem);
                }
            }
            return view;
        }
        return (View) invokeCommon.objValue;
    }

    public void k0(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048581, this, i2) == null) {
            this.t = i2;
        }
    }

    public void l0(d.a.q0.h2.h.e eVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, eVar) == null) {
            this.s = eVar;
        }
    }

    public void m0(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048583, this, z) == null) {
            this.u = z;
        }
    }
}
