package d.a.q0.e1.h.h;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.card.ThreadCardViewHolder;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.TopicDetailActivityConfig;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tieba.NEGFeedBack.NEGFeedBackView;
import com.baidu.tieba.card.data.BaseCardInfo;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import d.a.k.l0;
/* loaded from: classes8.dex */
public class t extends d.a.d.k.e.a<d.a.q0.e1.k.b.c.a, ThreadCardViewHolder<d.a.q0.e1.k.b.c.a>> implements d.a.q0.o.f {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public BdUniqueId m;
    public TbPageContext<?> n;
    public String o;
    public NEGFeedBackView.b p;

    /* loaded from: classes8.dex */
    public class a implements d.a.d.k.e.w {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ t f56142e;

        public a(t tVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {tVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f56142e = tVar;
        }

        @Override // d.a.d.k.e.w
        public void b(View view, d.a.d.k.e.n nVar, BdUniqueId bdUniqueId, ViewGroup viewGroup, int i2, long j) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{view, nVar, bdUniqueId, viewGroup, Integer.valueOf(i2), Long.valueOf(j)}) == null) && (nVar instanceof d.a.q0.e1.k.b.c.a) && (view.getTag() instanceof ThreadCardViewHolder)) {
                d.a.q0.e1.k.b.c.a aVar = (d.a.q0.e1.k.b.c.a) nVar;
                if (aVar != null && aVar.c0 != 1) {
                    TiebaStatic.log(new StatisticItem("c13351").param("topic_id", aVar.V).param("obj_locate", aVar.U));
                }
                if (aVar != null && aVar.c0 == 1) {
                    TiebaStatic.log(new StatisticItem("c13449").param("topic_id", aVar.V));
                }
                MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new TopicDetailActivityConfig(this.f56142e.f42341e, aVar.V)));
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public t(TbPageContext tbPageContext, BdUniqueId bdUniqueId) {
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
        this.n = tbPageContext;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.a.d.k.e.a
    /* renamed from: f0 */
    public ThreadCardViewHolder<d.a.q0.e1.k.b.c.a> Q(ViewGroup viewGroup) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, viewGroup)) == null) {
            l0.b bVar = new l0.b(this.n.getPageActivity(), false);
            d.a.q0.e1.h.n.d dVar = new d.a.q0.e1.h.n.d(this.f42341e, this.n);
            dVar.p(this.f42345i);
            bVar.n(dVar);
            bVar.l().c(0);
            bVar.l().e(0);
            bVar.l().f(0);
            bVar.l().h(0);
            bVar.l().g(0);
            l0 j = bVar.j(BaseCardInfo.SupportType.FULL, viewGroup);
            j.r(2);
            ThreadCardViewHolder<d.a.q0.e1.k.b.c.a> threadCardViewHolder = new ThreadCardViewHolder<>(j);
            threadCardViewHolder.j(this.m);
            a0(new a(this));
            return threadCardViewHolder;
        }
        return (ThreadCardViewHolder) invokeL.objValue;
    }

    @Override // d.a.q0.o.f
    public void g(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, str) == null) {
            this.o = str;
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.a.d.k.e.a
    /* renamed from: g0 */
    public View X(int i2, View view, ViewGroup viewGroup, d.a.q0.e1.k.b.c.a aVar, ThreadCardViewHolder<d.a.q0.e1.k.b.c.a> threadCardViewHolder) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048580, this, new Object[]{Integer.valueOf(i2), view, viewGroup, aVar, threadCardViewHolder})) == null) {
            if (aVar == null || threadCardViewHolder == null || threadCardViewHolder.a() == null) {
                return null;
            }
            TiebaStatic.log(new StatisticItem("c13448").param("topic_id", aVar.V));
            threadCardViewHolder.b().q(i2);
            threadCardViewHolder.b().setPage(this.o);
            threadCardViewHolder.o(false).u(this.p);
            threadCardViewHolder.f(aVar);
            threadCardViewHolder.b().onChangeSkinType(this.n, TbadkCoreApplication.getInst().getSkinType());
            return threadCardViewHolder.a();
        }
        return (View) invokeCommon.objValue;
    }

    public void i0(NEGFeedBackView.b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, bVar) == null) {
            this.p = bVar;
        }
    }
}
