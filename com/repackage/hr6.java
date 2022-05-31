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
/* loaded from: classes6.dex */
public class hr6 extends wm<yw5, CardViewHolder<wv5>> implements ci5 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public BdUniqueId i;
    public TbPageContext<?> j;
    public wv5 k;
    public String l;
    public nw5 m;

    /* loaded from: classes6.dex */
    public class a extends nw5<yw5> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ hr6 b;

        public a(hr6 hr6Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {hr6Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = hr6Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.repackage.nw5
        /* renamed from: d */
        public void a(View view2, yw5 yw5Var) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, view2, yw5Var) == null) || view2 == null || this.b.k == null || this.b.k.k() == null || yw5Var == null || yw5Var.getThreadData() == null || StringUtils.isNull(yw5Var.getThreadData().getTid())) {
                return;
            }
            er6.b(view2, yw5Var, view2 == this.b.k.M() ? 1 : 2);
            if (view2 != this.b.k.l.getCommentContainer() && view2 != this.b.k.m.getCommentContainer()) {
                if (this.b.k.M() == null || view2.getId() != this.b.k.M().getId() || yw5Var.getThreadData() == null || yw5Var.getThreadData().getThreadAlaInfo() == null || !yw5Var.getThreadData().getThreadAlaInfo().isLegalYYLiveData()) {
                    return;
                }
                ThreadData threadData = yw5Var.getThreadData();
                AlaInfoData threadAlaInfo = threadData.getThreadAlaInfo();
                int calculateLiveType = YYLiveUtil.calculateLiveType(yw5Var.getThreadData().getThreadAlaInfo());
                String str = StringUtils.isNull(yw5Var.getThreadData().getThreadAlaInfo().appId) ? null : yw5Var.getThreadData().getThreadAlaInfo().appId;
                if (yw5Var.getThreadData().getThreadAlaInfo().mYyExtData != null) {
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
            statisticItem2.param("tid", yw5Var.getThreadData().getTid());
            statisticItem2.param("nid", yw5Var.getThreadData().getNid());
            z65 findPageExtraByView = TbPageExtraHelper.findPageExtraByView(view2);
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
    public hr6(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId) {
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
    @Override // com.repackage.wm
    /* renamed from: a0 */
    public CardViewHolder<wv5> M(ViewGroup viewGroup) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, viewGroup)) == null) {
            wv5 wv5Var = new wv5(this.j, this.i);
            this.k = wv5Var;
            wv5Var.Z(true);
            BdUniqueId bdUniqueId = this.i;
            if (bdUniqueId != null) {
                this.k.Y(bdUniqueId);
            }
            return new CardViewHolder<>(this.k);
        }
        return (CardViewHolder) invokeL.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.repackage.wm
    /* renamed from: b0 */
    public View S(int i, View view2, ViewGroup viewGroup, yw5 yw5Var, CardViewHolder<wv5> cardViewHolder) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048579, this, new Object[]{Integer.valueOf(i), view2, viewGroup, yw5Var, cardViewHolder})) == null) {
            if (yw5Var == null || cardViewHolder == null || cardViewHolder.c() == null) {
                return null;
            }
            yw5Var.I(i + 1);
            int i2 = 0;
            StatisticItem Z = yw5Var.Z("c12351");
            if (yw5Var.getThreadData() != null && yw5Var.getThreadData().getThreadAlaInfo() != null) {
                i2 = YYLiveUtil.calculateLiveType(yw5Var.getThreadData().getThreadAlaInfo());
                if (yw5Var.getThreadData().getThreadAlaInfo().mYyExtData != null) {
                    TiebaStaticHelper.addYYParam(Z, yw5Var.getThreadData().getThreadAlaInfo().mYyExtData);
                }
                Z.param(TiebaStatic.Params.OBJ_PARAM3, i2);
            }
            gw5.b().a(Z);
            if (cardViewHolder.c() instanceof bi5) {
                cardViewHolder.c().b(this.l);
            }
            cardViewHolder.c().l(yw5Var);
            cardViewHolder.c().n(this.m);
            if (yw5Var.getThreadData() != null) {
                StatisticItem statisticItem = new StatisticItem(CommonStatisticKey.KEY_CONCERN_YY_LIVE_AVATER_SHOW);
                statisticItem.param("fid", yw5Var.getThreadData().getFid());
                statisticItem.param("fname", yw5Var.getThreadData().getForum_name());
                statisticItem.param("uid", TbadkCoreApplication.getCurrentAccountId());
                statisticItem.param("tid", yw5Var.getThreadData().getTid());
                if (yw5Var.getThreadData().getThreadAlaInfo() != null) {
                    String str = StringUtils.isNull(yw5Var.getThreadData().getThreadAlaInfo().appId) ? null : yw5Var.getThreadData().getThreadAlaInfo().appId;
                    if (yw5Var.getThreadData().getThreadAlaInfo().mYyExtData != null) {
                        str = TiebaStatic.YYValues.YY_LIVE;
                    }
                    statisticItem.param("obj_param1", i2);
                    statisticItem.param(TiebaStatic.Params.OBJ_PARAM2, str);
                    TiebaStaticHelper.addYYParam(statisticItem, yw5Var.getThreadData().getThreadAlaInfo().mYyExtData);
                }
                TiebaStatic.log(statisticItem);
            }
            return cardViewHolder.b();
        }
        return (View) invokeCommon.objValue;
    }

    @Override // com.repackage.ci5
    public void g(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, str) == null) {
            this.l = str;
        }
    }
}
