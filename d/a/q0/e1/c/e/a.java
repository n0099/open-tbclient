package d.a.q0.e1.c.e;

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
import d.a.q0.a0.b0;
/* loaded from: classes8.dex */
public class a extends d.a.d.k.e.a<d.a.q0.a0.e0.j, CardViewHolder<d.a.q0.a0.j>> implements d.a.q0.o.f {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public BdUniqueId m;
    public TbPageContext<?> n;
    public d.a.q0.a0.j o;
    public String p;
    public b0 q;

    /* renamed from: d.a.q0.e1.c.e.a$a  reason: collision with other inner class name */
    /* loaded from: classes8.dex */
    public class C1335a extends b0<d.a.q0.a0.e0.j> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ a f55674b;

        public C1335a(a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f55674b = aVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.a.q0.a0.b0
        /* renamed from: d */
        public void a(View view, d.a.q0.a0.e0.j jVar) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, view, jVar) == null) || view == null || this.f55674b.o == null || this.f55674b.o.k() == null || jVar == null || jVar.getThreadData() == null || StringUtils.isNull(jVar.getThreadData().o1())) {
                return;
            }
            d.a.q0.e1.c.c.b(view, jVar, view == this.f55674b.o.K() ? 1 : 2);
            if (view == this.f55674b.o.p.getCommentContainer() || view == this.f55674b.o.q.getCommentContainer()) {
                StatisticItem statisticItem = new StatisticItem("c12942");
                statisticItem.param("obj_locate", 7);
                statisticItem.param("obj_type", 5);
                statisticItem.param("tid", jVar.getThreadData().o1());
                statisticItem.param("nid", jVar.getThreadData().B0());
                d.a.p0.k0.c f2 = TbPageExtraHelper.f(view);
                if (f2 != null) {
                    statisticItem.param(TiebaStatic.Params.OBJ_CUR_PAGE, f2.a());
                }
                if (TbPageExtraHelper.m() != null) {
                    statisticItem.param(TiebaStatic.Params.OBJ_PRE_PAGE, TbPageExtraHelper.m());
                }
                TiebaStatic.log(statisticItem);
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public a(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext.getPageActivity(), bdUniqueId);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {tbPageContext, bdUniqueId};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((Context) objArr2[0], (BdUniqueId) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.q = new C1335a(this);
        this.n = tbPageContext;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.a.d.k.e.a
    /* renamed from: f0 */
    public CardViewHolder<d.a.q0.a0.j> Q(ViewGroup viewGroup) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, viewGroup)) == null) {
            d.a.q0.a0.j jVar = new d.a.q0.a0.j(this.n, this.m);
            this.o = jVar;
            jVar.S(true);
            BdUniqueId bdUniqueId = this.m;
            if (bdUniqueId != null) {
                this.o.R(bdUniqueId);
            }
            return new CardViewHolder<>(this.o);
        }
        return (CardViewHolder) invokeL.objValue;
    }

    @Override // d.a.q0.o.f
    public void g(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, str) == null) {
            this.p = str;
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.a.d.k.e.a
    /* renamed from: g0 */
    public View X(int i2, View view, ViewGroup viewGroup, d.a.q0.a0.e0.j jVar, CardViewHolder<d.a.q0.a0.j> cardViewHolder) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048580, this, new Object[]{Integer.valueOf(i2), view, viewGroup, jVar, cardViewHolder})) == null) {
            if (jVar == null || cardViewHolder == null || cardViewHolder.b() == null) {
                return null;
            }
            jVar.I(i2 + 1);
            StatisticItem Z = jVar.Z("c12351");
            if (jVar.getThreadData() != null && jVar.getThreadData().h1() != null) {
                int calculateLiveType = YYLiveUtil.calculateLiveType(jVar.getThreadData().h1());
                if (jVar.getThreadData().h1().mYyExtData != null) {
                    TiebaStaticHelper.addYYParam(Z, jVar.getThreadData().h1().mYyExtData);
                }
                Z.param(TiebaStatic.Params.OBJ_PARAM3, calculateLiveType);
            }
            d.a.q0.a0.t.b().a(Z);
            if (cardViewHolder.b() instanceof d.a.q0.o.e) {
                cardViewHolder.b().setPage(this.p);
            }
            cardViewHolder.b().l(jVar);
            cardViewHolder.b().n(this.q);
            if (jVar.getThreadData() != null && jVar.getThreadData().h1() != null) {
                StatisticItem statisticItem = new StatisticItem(CommonStatisticKey.ALA_FRIEND_ROOM_CARD_SHOW);
                statisticItem.param("obj_locate", 2);
                statisticItem.param("obj_param1", jVar.getThreadData().h1().live_id);
                statisticItem.param("uid", TbadkCoreApplication.getCurrentAccountId());
                TiebaStatic.log(statisticItem);
            }
            return cardViewHolder.a();
        }
        return (View) invokeCommon.objValue;
    }
}
