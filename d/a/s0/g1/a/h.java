package d.a.s0.g1.a;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.view.ThreadCommentAndPraiseInfoLayout;
import com.baidu.tieba.card.OriginalThreadCardView;
import com.baidu.tieba.card.holder.CardViewHolder;
import com.baidu.tieba.hottopic.controller.HotTopicActivity;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import d.a.r0.r.q.b2;
import d.a.r0.r.q.c2;
import d.a.s0.a0.b0;
import d.a.s0.a0.v;
import d.a.s0.g1.c.n;
/* loaded from: classes9.dex */
public class h extends d.a.c.k.e.a<d.a.s0.a0.e0.k, CardViewHolder<v>> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public TbPageContext<HotTopicActivity> m;
    public BdUniqueId n;
    public d.a.s0.a0.e0.k o;
    public v p;
    public b0<c2> q;

    /* loaded from: classes9.dex */
    public class a extends b0<c2> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ h f59580b;

        public a(h hVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {hVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f59580b = hVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.a.s0.a0.b0
        /* renamed from: d */
        public void a(View view, c2 c2Var) {
            d.a.s0.a0.e0.k kVar;
            b2 b2Var;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, view, c2Var) == null) || (kVar = this.f59580b.o) == null || (b2Var = kVar.f57050e) == null || StringUtils.isNull(b2Var.n1())) {
                return;
            }
            int i2 = 1;
            if ((this.f59580b.p.x() == null || view.getId() != this.f59580b.p.x().getId()) && (this.f59580b.p.y() == null || view.getId() != this.f59580b.p.y().getId())) {
                i2 = (this.f59580b.p.q == null || view.getId() != this.f59580b.p.q.getId()) ? 2 : 3;
            }
            String topicName = ((HotTopicActivity) this.f59580b.m.getOrignalPage()).getTopicName();
            String hotTopicId = ((HotTopicActivity) this.f59580b.m.getOrignalPage()).getHotTopicId();
            b2 threadData = kVar.getThreadData();
            TiebaStatic.log(new StatisticItem("c12941").param("obj_type", i2).param("tid", threadData.c0()));
            if ("c10814".equals(kVar.A())) {
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2004011));
                TiebaStatic.log(new StatisticItem("c10814").param("tid", threadData.c0()).param("obj_name", topicName).param("topic_id", hotTopicId));
            } else if ("c10816".equals(kVar.A())) {
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2004011));
                TiebaStatic.log(new StatisticItem("c10816").param("post_id", threadData.n1()).param("obj_name", topicName).param("topic_id", hotTopicId));
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public h(TbPageContext<HotTopicActivity> tbPageContext, BdUniqueId bdUniqueId) {
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
        this.q = new a(this);
        this.m = tbPageContext;
        this.n = tbPageContext.getUniqueId();
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.a.c.k.e.a
    /* renamed from: i0 */
    public CardViewHolder<v> Q(ViewGroup viewGroup) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, viewGroup)) == null) {
            v vVar = new v(this.m);
            this.p = vVar;
            vVar.H(this.n);
            this.p.J(false);
            v vVar2 = this.p;
            vVar2.l = 0;
            ThreadCommentAndPraiseInfoLayout threadCommentAndPraiseInfoLayout = vVar2.r;
            if (threadCommentAndPraiseInfoLayout != null) {
                threadCommentAndPraiseInfoLayout.R = 0;
            }
            OriginalThreadCardView originalThreadCardView = this.p.q;
            if (originalThreadCardView != null) {
                originalThreadCardView.q = 0;
            }
            return new CardViewHolder<>(this.p);
        }
        return (CardViewHolder) invokeL.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.a.c.k.e.a
    /* renamed from: j0 */
    public View X(int i2, View view, ViewGroup viewGroup, d.a.s0.a0.e0.k kVar, CardViewHolder<v> cardViewHolder) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048579, this, new Object[]{Integer.valueOf(i2), view, viewGroup, kVar, cardViewHolder})) == null) {
            if (kVar == null || cardViewHolder == null || cardViewHolder.b() == null) {
                return null;
            }
            this.o = kVar;
            cardViewHolder.b().m(new c2(kVar.getThreadData()));
            cardViewHolder.b().o(this.q);
            ((v) ((CardViewHolder) this.k).b()).I(!(z(i2 + 1) instanceof n));
            return cardViewHolder.a();
        }
        return (View) invokeCommon.objValue;
    }
}
