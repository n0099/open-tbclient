package com.repackage;

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
/* loaded from: classes7.dex */
public class qu7 extends vu7<qo4, PbBjhRecommendViewHolder> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public bs7 o;
    public int p;
    public boolean q;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public qu7(gz7 gz7Var, BdUniqueId bdUniqueId) {
        super(gz7Var, bdUniqueId);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {gz7Var, bdUniqueId};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((gz7) objArr2[0], (BdUniqueId) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
    }

    public final void b0(PbBjhRecommendViewHolder pbBjhRecommendViewHolder) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, pbBjhRecommendViewHolder) == null) || pbBjhRecommendViewHolder == null) {
            return;
        }
        int skinType = TbadkCoreApplication.getInst().getSkinType();
        if (pbBjhRecommendViewHolder.a != skinType) {
            SkinManager.setBackgroundColor(pbBjhRecommendViewHolder.i, R.color.CAM_X0204, skinType);
            SkinManager.setBackgroundColor(pbBjhRecommendViewHolder.x, R.color.CAM_X0203, skinType);
            SkinManager.setBackgroundColor(pbBjhRecommendViewHolder.s, R.color.CAM_X0204, skinType);
            SkinManager.setViewTextColor(pbBjhRecommendViewHolder.u, R.color.CAM_X0302, 1, skinType);
            SkinManager.setViewTextColor(pbBjhRecommendViewHolder.n, R.color.CAM_X0105, 1, skinType);
            pbBjhRecommendViewHolder.p.setImageDrawable(SvgManager.getInstance().getPureDrawable(R.drawable.ic_icon_pure_video_play12_svg, R.color.CAM_X0101, null));
            SkinManager.setViewTextColor(pbBjhRecommendViewHolder.q, R.color.CAM_X0101, 1, skinType);
            SkinManager.setViewTextColor(pbBjhRecommendViewHolder.v, R.color.CAM_X0109, 1, skinType);
            SkinManager.setViewTextColor(pbBjhRecommendViewHolder.w, R.color.CAM_X0109, 1, skinType);
            SkinManager.setBackgroundSelector(pbBjhRecommendViewHolder.h, R.color.CAM_X0302, R.color.CAM_X0204, skinType);
            gs4.d(pbBjhRecommendViewHolder.h).i(R.color.CAM_X0205, R.color.CAM_X0204);
            TBSelector.makeDrawableSelector().setShape(0).gradientLinear(R.color.cp_bg_line_d_alpha0, R.color.CAM_X0105).cornerRadius(mi.f(this.i.w(), R.dimen.tbds10)).into(pbBjhRecommendViewHolder.m);
        }
        pbBjhRecommendViewHolder.a = skinType;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.repackage.eo
    /* renamed from: c0 */
    public PbBjhRecommendViewHolder M(ViewGroup viewGroup) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, viewGroup)) == null) {
            PbBjhRecommendViewHolder pbBjhRecommendViewHolder = new PbBjhRecommendViewHolder(LayoutInflater.from(this.a).inflate(R.layout.obfuscated_res_0x7f0d015c, (ViewGroup) null), this.i.w());
            b0(pbBjhRecommendViewHolder);
            return pbBjhRecommendViewHolder;
        }
        return (PbBjhRecommendViewHolder) invokeL.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.repackage.vu7, com.repackage.eo
    /* renamed from: d0 */
    public View S(int i, View view2, ViewGroup viewGroup, qo4 qo4Var, PbBjhRecommendViewHolder pbBjhRecommendViewHolder) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048580, this, new Object[]{Integer.valueOf(i), view2, viewGroup, qo4Var, pbBjhRecommendViewHolder})) == null) {
            super.S(i, view2, viewGroup, qo4Var, pbBjhRecommendViewHolder);
            if (qo4Var == null) {
                return null;
            }
            b0(pbBjhRecommendViewHolder);
            pbBjhRecommendViewHolder.i(qo4Var);
            pbBjhRecommendViewHolder.j(this.p);
            pbBjhRecommendViewHolder.n(this.q);
            bs7 bs7Var = this.o;
            if (bs7Var != null) {
                pbBjhRecommendViewHolder.m(bs7Var.Q());
                pbBjhRecommendViewHolder.l(this.o.r0());
                if (this.o.O() != null && this.o.O().getBaijiahaoData() != null) {
                    pbBjhRecommendViewHolder.k(this.o.O().getBaijiahaoData().oriUgcNid);
                }
                int i2 = this.p;
                int i3 = 3;
                if (i2 == 2) {
                    i3 = 1;
                } else if (i2 == 1) {
                    i3 = 2;
                } else if (i2 != 3) {
                    i3 = 4;
                }
                if (qo4Var.threadType == 40) {
                    StatisticItem.make("c13536").param("tid", qo4Var.getTid()).param("fid", qo4Var.getFid()).param("obj_source", i3).param("obj_locate", qo4Var.e()).param("obj_id", this.o.Q()).param("obj_type", qo4Var.isBjhDynamicThread() ? 1 : 0).eventStat();
                } else {
                    StatisticItem.make("c13533").param("tid", qo4Var.getTid()).param("fid", qo4Var.getFid()).param("obj_source", i3).param("obj_locate", qo4Var.e()).param("obj_id", this.o.Q()).eventStat();
                }
                if (this.o.r0()) {
                    StatisticItem statisticItem = new StatisticItem("c13588");
                    if (qo4Var.getForumData() != null) {
                        statisticItem.param("fid", qo4Var.getForumData().b());
                    }
                    statisticItem.param("tid", qo4Var.getTid());
                    statisticItem.param("obj_param1", qo4Var.mRecomWeight);
                    statisticItem.param("obj_source", qo4Var.mRecomSource);
                    statisticItem.param("obj_locate", qo4Var.e());
                    statisticItem.param(TiebaStatic.Params.OBJ_PARAM3, System.currentTimeMillis());
                    statisticItem.param("obj_id", this.o.Q());
                    statisticItem.param("uid", TbadkCoreApplication.getCurrentAccount());
                    if (qo4Var.getThreadData().getBaijiahaoData() != null) {
                        statisticItem.param(TiebaStatic.Params.OBJ_PARAM4, qo4Var.getThreadData().getBaijiahaoData().oriUgcNid);
                        statisticItem.param(TiebaStatic.Params.OBJ_PARAM5, qo4Var.getThreadData().getBaijiahaoData().oriUgcVid);
                    }
                    statisticItem.param(TiebaStatic.Params.OBJ_PARAM6, qo4Var.getVideoRecStaticticType());
                    statisticItem.param("ab_tag", qo4Var.mRecomAbTag);
                    statisticItem.param("extra", qo4Var.mRecomExtra);
                    TiebaStatic.log(statisticItem);
                }
            }
            return view2;
        }
        return (View) invokeCommon.objValue;
    }

    public void e0(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048581, this, i) == null) {
            this.p = i;
        }
    }

    public void f0(bs7 bs7Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, bs7Var) == null) {
            this.o = bs7Var;
        }
    }

    public void g0(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048583, this, z) == null) {
            this.q = z;
        }
    }
}
