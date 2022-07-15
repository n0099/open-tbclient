package com.repackage;

import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.card.Align;
import com.baidu.card.ThreadCardViewHolder;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.ThreadData;
import com.baidu.tbadk.core.util.ThreadCardUtils;
import com.baidu.tieba.NEGFeedBack.NEGFeedBackView;
import com.baidu.tieba.card.data.BaseCardInfo;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.repackage.cy;
import com.repackage.ny;
/* loaded from: classes7.dex */
public class um7 extends tm7<ThreadData, ThreadCardViewHolder<ThreadData>> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public BdUniqueId k;
    public TbPageContext<?> l;
    public NEGFeedBackView.b m;
    public tn n;
    public jy5<ThreadData> o;

    /* loaded from: classes7.dex */
    public class a extends jy5<ThreadData> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ um7 b;

        public a(um7 um7Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {um7Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = um7Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.repackage.jy5
        /* renamed from: d */
        public void a(View view2, ThreadData threadData) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, view2, threadData) == null) {
                cy5.b().d(true);
                ak5.c().h("page_recommend", "show_");
                if (view2 == null || threadData == null || threadData.getThreadData() == null || StringUtils.isNull(threadData.getThreadData().getTid())) {
                    return;
                }
                this.b.h0(view2, threadData);
            }
        }
    }

    /* loaded from: classes7.dex */
    public class b implements xn {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ um7 a;

        public b(um7 um7Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {um7Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = um7Var;
        }

        @Override // com.repackage.xn
        public void b(View view2, nn nnVar, BdUniqueId bdUniqueId, ViewGroup viewGroup, int i, long j) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{view2, nnVar, bdUniqueId, viewGroup, Integer.valueOf(i), Long.valueOf(j)}) == null) {
                this.a.e0(view2, nnVar);
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public um7(TbPageContext tbPageContext, BdUniqueId bdUniqueId, BdUniqueId bdUniqueId2) {
        super(tbPageContext, bdUniqueId);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {tbPageContext, bdUniqueId, bdUniqueId2};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((TbPageContext) objArr2[0], (BdUniqueId) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.o = new a(this);
        this.l = tbPageContext;
        this.k = bdUniqueId2;
    }

    public final void e0(View view2, nn nnVar) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, view2, nnVar) == null) && (nnVar instanceof qy5) && (view2.getTag() instanceof ThreadCardViewHolder)) {
            ThreadCardViewHolder threadCardViewHolder = (ThreadCardViewHolder) view2.getTag();
            qy5 qy5Var = (qy5) nnVar;
            qy5Var.f = 1;
            ThreadCardUtils.jumpToPB(qy5Var, view2.getContext(), 17, false, this.j.getOrignalPage().C1(), Z() ? "3" : "2");
            threadCardViewHolder.c().o(new ny.a(1));
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.repackage.an
    /* renamed from: f0 */
    public ThreadCardViewHolder<ThreadData> M(ViewGroup viewGroup) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, viewGroup)) == null) {
            cy.b bVar = new cy.b(this.l.getPageActivity());
            tw twVar = new tw(this.l.getPageActivity());
            twVar.u(this.k);
            twVar.w(this.l);
            bVar.o(twVar);
            bVar.n(new rw(this.l.getPageActivity()));
            bVar.h(new ax(this.l.getPageActivity()));
            ey eyVar = new ey(this.l.getPageActivity());
            tn4 tn4Var = new tn4();
            tn4Var.b = 1;
            tn4Var.h = 1;
            eyVar.x(false);
            eyVar.w(tn4Var);
            eyVar.y(1);
            eyVar.D(3);
            eyVar.z(17);
            bVar.m(eyVar);
            cy k = bVar.k(BaseCardInfo.SupportType.FULL, viewGroup, this.n);
            k.r(17);
            ThreadCardViewHolder<ThreadData> threadCardViewHolder = new ThreadCardViewHolder<>(k);
            threadCardViewHolder.k(this.k);
            V(new b(this));
            return threadCardViewHolder;
        }
        return (ThreadCardViewHolder) invokeL.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.repackage.an
    /* renamed from: g0 */
    public View S(int i, View view2, ViewGroup viewGroup, ThreadData threadData, ThreadCardViewHolder<ThreadData> threadCardViewHolder) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048580, this, new Object[]{Integer.valueOf(i), view2, viewGroup, threadData, threadCardViewHolder})) == null) {
            if (threadData == null || threadCardViewHolder == null || threadCardViewHolder.b() == null) {
                return null;
            }
            threadData.statFloor = B(i) + 1;
            threadCardViewHolder.c().q(i);
            threadCardViewHolder.q(true).u(this.m);
            threadCardViewHolder.u(true, Align.ALIGN_RIGHT_BOTTOM);
            threadCardViewHolder.g(threadData);
            threadCardViewHolder.c().p(this.o);
            threadCardViewHolder.c().onChangeSkinType(this.l, TbadkCoreApplication.getInst().getSkinType());
            qm7.c(this, threadData);
            return threadCardViewHolder.b();
        }
        return (View) invokeCommon.objValue;
    }

    public final void h0(View view2, ThreadData threadData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048581, this, view2, threadData) == null) {
            qm7.b(this, threadData);
        }
    }

    public void i0(tn tnVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, tnVar) == null) {
            this.n = tnVar;
        }
    }
}
