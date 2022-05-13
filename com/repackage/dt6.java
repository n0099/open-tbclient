package com.repackage;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.AlaInfoData;
import com.baidu.tbadk.core.data.ThreadData;
import com.baidu.tbadk.core.util.CommonStatisticKey;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.TiebaStaticHelper;
import com.baidu.tbadk.core.util.YYLiveUtil;
import com.baidu.tbadk.pageExtra.TbPageExtraHelper;
import com.baidu.tieba.card.holder.CardViewHolder;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes5.dex */
public class dt6 extends eo<fy5, CardViewHolder<dx5>> implements ij5 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public BdUniqueId i;
    public TbPageContext<?> j;
    public dx5 k;
    public String l;
    public ux5 m;

    /* loaded from: classes5.dex */
    public class a extends ux5<fy5> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ dt6 b;

        public a(dt6 dt6Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {dt6Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = dt6Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.repackage.ux5
        /* renamed from: d */
        public void a(View view2, fy5 fy5Var) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, view2, fy5Var) == null) || view2 == null || this.b.k == null || this.b.k.k() == null || fy5Var == null || fy5Var.getThreadData() == null || StringUtils.isNull(fy5Var.getThreadData().getTid())) {
                return;
            }
            at6.b(view2, fy5Var, view2 == this.b.k.M() ? 1 : 2);
            if (view2 != this.b.k.l.getCommentContainer() && view2 != this.b.k.m.getCommentContainer()) {
                if (this.b.k.M() == null || view2.getId() != this.b.k.M().getId() || fy5Var.getThreadData() == null || fy5Var.getThreadData().getThreadAlaInfo() == null || !fy5Var.getThreadData().getThreadAlaInfo().isLegalYYLiveData()) {
                    return;
                }
                ThreadData threadData = fy5Var.getThreadData();
                AlaInfoData threadAlaInfo = threadData.getThreadAlaInfo();
                int calculateLiveType = YYLiveUtil.calculateLiveType(fy5Var.getThreadData().getThreadAlaInfo());
                String str = StringUtils.isNull(fy5Var.getThreadData().getThreadAlaInfo().appId) ? null : fy5Var.getThreadData().getThreadAlaInfo().appId;
                if (fy5Var.getThreadData().getThreadAlaInfo().mYyExtData != null) {
                    str = TiebaStatic.YYValues.YY_LIVE;
                }
                StatisticItem statisticItem = new StatisticItem(CommonStatisticKey.KEY_CONCERN_YY_LIVE_AVATER_CLICK);
                statisticItem.param("fid", threadData.getFid());
                statisticItem.param("fname", threadData.getForum_name());
                statisticItem.param("uid", TbadkCoreApplication.getCurrentAccountId());
                statisticItem.param("tid", threadData.getTid());
                statisticItem.param("obj_type", threadData.getYYStaticticType());
                statisticItem.param("obj_param1", calculateLiveType);
                statisticItem.param(TiebaStatic.Params.OBJ_PARAM2, str);
                TiebaStaticHelper.addYYParam(statisticItem, threadAlaInfo.mYyExtData);
                TiebaStatic.log(statisticItem);
                return;
            }
            StatisticItem statisticItem2 = new StatisticItem("c12942");
            statisticItem2.param("obj_locate", 7);
            statisticItem2.param("obj_type", 5);
            statisticItem2.param("tid", fy5Var.getThreadData().getTid());
            statisticItem2.param("nid", fy5Var.getThreadData().getNid());
            g85 findPageExtraByView = TbPageExtraHelper.findPageExtraByView(view2);
            if (findPageExtraByView != null) {
                statisticItem2.param(TiebaStatic.Params.OBJ_CUR_PAGE, findPageExtraByView.a());
            }
            if (TbPageExtraHelper.getPrePageKey() != null) {
                statisticItem2.param(TiebaStatic.Params.OBJ_PRE_PAGE, TbPageExtraHelper.getPrePageKey());
            }
            TiebaStatic.log(statisticItem2);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public dt6(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext.getPageActivity(), bdUniqueId);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {tbPageContext, bdUniqueId};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((Context) objArr2[0], (BdUniqueId) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.m = new a(this);
        this.j = tbPageContext;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.repackage.eo
    /* renamed from: a0 */
    public CardViewHolder<dx5> M(ViewGroup viewGroup) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, viewGroup)) == null) {
            dx5 dx5Var = new dx5(this.j, this.i);
            this.k = dx5Var;
            dx5Var.Z(true);
            BdUniqueId bdUniqueId = this.i;
            if (bdUniqueId != null) {
                this.k.Y(bdUniqueId);
            }
            return new CardViewHolder<>(this.k);
        }
        return (CardViewHolder) invokeL.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.repackage.eo
    /* renamed from: b0 */
    public View S(int i, View view2, ViewGroup viewGroup, fy5 fy5Var, CardViewHolder<dx5> cardViewHolder) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048579, this, new Object[]{Integer.valueOf(i), view2, viewGroup, fy5Var, cardViewHolder})) == null) {
            if (fy5Var == null || cardViewHolder == null || cardViewHolder.c() == null) {
                return null;
            }
            fy5Var.I(i + 1);
            int i2 = 0;
            StatisticItem Z = fy5Var.Z("c12351");
            if (fy5Var.getThreadData() != null && fy5Var.getThreadData().getThreadAlaInfo() != null) {
                i2 = YYLiveUtil.calculateLiveType(fy5Var.getThreadData().getThreadAlaInfo());
                if (fy5Var.getThreadData().getThreadAlaInfo().mYyExtData != null) {
                    TiebaStaticHelper.addYYParam(Z, fy5Var.getThreadData().getThreadAlaInfo().mYyExtData);
                }
                Z.param(TiebaStatic.Params.OBJ_PARAM3, i2);
            }
            nx5.b().a(Z);
            if (cardViewHolder.c() instanceof hj5) {
                cardViewHolder.c().b(this.l);
            }
            cardViewHolder.c().l(fy5Var);
            cardViewHolder.c().n(this.m);
            if (fy5Var.getThreadData() != null) {
                StatisticItem statisticItem = new StatisticItem(CommonStatisticKey.KEY_CONCERN_YY_LIVE_AVATER_SHOW);
                statisticItem.param("fid", fy5Var.getThreadData().getFid());
                statisticItem.param("fname", fy5Var.getThreadData().getForum_name());
                statisticItem.param("uid", TbadkCoreApplication.getCurrentAccountId());
                statisticItem.param("tid", fy5Var.getThreadData().getTid());
                if (fy5Var.getThreadData().getThreadAlaInfo() != null) {
                    String str = StringUtils.isNull(fy5Var.getThreadData().getThreadAlaInfo().appId) ? null : fy5Var.getThreadData().getThreadAlaInfo().appId;
                    if (fy5Var.getThreadData().getThreadAlaInfo().mYyExtData != null) {
                        str = TiebaStatic.YYValues.YY_LIVE;
                    }
                    statisticItem.param("obj_param1", i2);
                    statisticItem.param(TiebaStatic.Params.OBJ_PARAM2, str);
                    TiebaStaticHelper.addYYParam(statisticItem, fy5Var.getThreadData().getThreadAlaInfo().mYyExtData);
                }
                TiebaStatic.log(statisticItem);
            }
            return cardViewHolder.b();
        }
        return (View) invokeCommon.objValue;
    }

    @Override // com.repackage.ij5
    public void g(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, str) == null) {
            this.l = str;
        }
    }
}
