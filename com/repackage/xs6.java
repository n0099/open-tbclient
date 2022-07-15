package com.repackage;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
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
/* loaded from: classes7.dex */
public class xs6 extends an<uy5, CardViewHolder<rx5>> implements ck5 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public BdUniqueId i;
    public TbPageContext<?> j;
    public rx5 k;
    public String l;
    public jy5 m;

    /* loaded from: classes7.dex */
    public class a extends jy5<uy5> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ xs6 b;

        public a(xs6 xs6Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {xs6Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = xs6Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.repackage.jy5
        /* renamed from: d */
        public void a(View view2, uy5 uy5Var) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, view2, uy5Var) == null) || view2 == null || this.b.k == null || this.b.k.h() == null || uy5Var == null || uy5Var.getThreadData() == null || StringUtils.isNull(uy5Var.getThreadData().getTid())) {
                return;
            }
            vs6.b(view2, uy5Var, view2 == this.b.k.L() ? 1 : 2);
            if (view2 == this.b.k.l.getCommentContainer() || view2 == this.b.k.m.getCommentContainer()) {
                StatisticItem statisticItem = new StatisticItem("c12942");
                statisticItem.param("obj_locate", 7);
                statisticItem.param("obj_type", 5);
                statisticItem.param("tid", uy5Var.getThreadData().getTid());
                statisticItem.param("nid", uy5Var.getThreadData().getNid());
                p85 findPageExtraByView = TbPageExtraHelper.findPageExtraByView(view2);
                if (findPageExtraByView != null) {
                    statisticItem.param(TiebaStatic.Params.OBJ_CUR_PAGE, findPageExtraByView.a());
                }
                if (TbPageExtraHelper.getPrePageKey() != null) {
                    statisticItem.param(TiebaStatic.Params.OBJ_PRE_PAGE, TbPageExtraHelper.getPrePageKey());
                }
                TiebaStatic.log(statisticItem);
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public xs6(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId) {
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
    @Override // com.repackage.an
    /* renamed from: a0 */
    public CardViewHolder<rx5> M(ViewGroup viewGroup) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, viewGroup)) == null) {
            rx5 rx5Var = new rx5(this.j, this.i);
            this.k = rx5Var;
            rx5Var.T(true);
            BdUniqueId bdUniqueId = this.i;
            if (bdUniqueId != null) {
                this.k.S(bdUniqueId);
            }
            return new CardViewHolder<>(this.k);
        }
        return (CardViewHolder) invokeL.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.repackage.an
    /* renamed from: b0 */
    public View S(int i, View view2, ViewGroup viewGroup, uy5 uy5Var, CardViewHolder<rx5> cardViewHolder) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048579, this, new Object[]{Integer.valueOf(i), view2, viewGroup, uy5Var, cardViewHolder})) == null) {
            if (uy5Var == null || cardViewHolder == null || cardViewHolder.c() == null) {
                return null;
            }
            uy5Var.I(i + 1);
            StatisticItem Z = uy5Var.Z("c12351");
            if (uy5Var.getThreadData() != null && uy5Var.getThreadData().getThreadAlaInfo() != null) {
                int calculateLiveType = YYLiveUtil.calculateLiveType(uy5Var.getThreadData().getThreadAlaInfo());
                if (uy5Var.getThreadData().getThreadAlaInfo().mYyExtData != null) {
                    TiebaStaticHelper.addYYParam(Z, uy5Var.getThreadData().getThreadAlaInfo().mYyExtData);
                }
                Z.param(TiebaStatic.Params.OBJ_PARAM3, calculateLiveType);
            }
            cy5.b().a(Z);
            if (cardViewHolder.c() instanceof bk5) {
                cardViewHolder.c().b(this.l);
            }
            cardViewHolder.c().i(uy5Var);
            cardViewHolder.c().n(this.m);
            if (uy5Var.getThreadData() != null && uy5Var.getThreadData().getThreadAlaInfo() != null) {
                StatisticItem statisticItem = new StatisticItem(CommonStatisticKey.ALA_FRIEND_ROOM_CARD_SHOW);
                statisticItem.param("obj_locate", 2);
                statisticItem.param("obj_param1", uy5Var.getThreadData().getThreadAlaInfo().live_id);
                statisticItem.param("uid", TbadkCoreApplication.getCurrentAccountId());
                TiebaStatic.log(statisticItem);
            }
            return cardViewHolder.b();
        }
        return (View) invokeCommon.objValue;
    }

    @Override // com.repackage.ck5
    public void g(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, str) == null) {
            this.l = str;
        }
    }
}
