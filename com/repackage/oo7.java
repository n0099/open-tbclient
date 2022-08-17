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
import com.repackage.dy;
import com.repackage.oy;
/* loaded from: classes7.dex */
public class oo7 extends no7<ThreadData, ThreadCardViewHolder<ThreadData>> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public BdUniqueId c;
    public TbPageContext<?> d;
    public NEGFeedBackView.b e;
    public un f;
    public b06<ThreadData> g;

    /* loaded from: classes7.dex */
    public class a extends b06<ThreadData> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ oo7 b;

        public a(oo7 oo7Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {oo7Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = oo7Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.repackage.b06
        /* renamed from: d */
        public void a(View view2, ThreadData threadData) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, view2, threadData) == null) {
                uz5.b().d(true);
                nl5.c().h("page_recommend", "show_");
                if (view2 == null || threadData == null || threadData.getThreadData() == null || StringUtils.isNull(threadData.getThreadData().getTid())) {
                    return;
                }
                this.b.A(view2, threadData);
            }
        }
    }

    /* loaded from: classes7.dex */
    public class b implements yn {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ oo7 a;

        public b(oo7 oo7Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {oo7Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = oo7Var;
        }

        @Override // com.repackage.yn
        public void b(View view2, on onVar, BdUniqueId bdUniqueId, ViewGroup viewGroup, int i, long j) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{view2, onVar, bdUniqueId, viewGroup, Integer.valueOf(i), Long.valueOf(j)}) == null) {
                this.a.x(view2, onVar);
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public oo7(TbPageContext tbPageContext, BdUniqueId bdUniqueId, BdUniqueId bdUniqueId2) {
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
        this.g = new a(this);
        this.d = tbPageContext;
        this.c = bdUniqueId2;
    }

    public final void A(View view2, ThreadData threadData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048576, this, view2, threadData) == null) {
            ko7.b(this, threadData);
        }
    }

    public void B(un unVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, unVar) == null) {
            this.f = unVar;
        }
    }

    public final void x(View view2, on onVar) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(1048580, this, view2, onVar) == null) && (onVar instanceof i06) && (view2.getTag() instanceof ThreadCardViewHolder)) {
            ThreadCardViewHolder threadCardViewHolder = (ThreadCardViewHolder) view2.getTag();
            i06 i06Var = (i06) onVar;
            i06Var.f = 1;
            ThreadCardUtils.jumpToPB(i06Var, view2.getContext(), 17, false, this.b.getOrignalPage().B1(), s() ? "3" : "2");
            threadCardViewHolder.a().o(new oy.a(1));
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.repackage.bn
    /* renamed from: y */
    public ThreadCardViewHolder<ThreadData> onCreateViewHolder(ViewGroup viewGroup) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, viewGroup)) == null) {
            dy.b bVar = new dy.b(this.d.getPageActivity());
            uw uwVar = new uw(this.d.getPageActivity());
            uwVar.u(this.c);
            uwVar.w(this.d);
            bVar.o(uwVar);
            bVar.n(new sw(this.d.getPageActivity()));
            bVar.h(new bx(this.d.getPageActivity()));
            fy fyVar = new fy(this.d.getPageActivity());
            lo4 lo4Var = new lo4();
            lo4Var.b = 1;
            lo4Var.h = 1;
            fyVar.x(false);
            fyVar.w(lo4Var);
            fyVar.y(1);
            fyVar.D(3);
            fyVar.z(17);
            bVar.m(fyVar);
            dy k = bVar.k(BaseCardInfo.SupportType.FULL, viewGroup, this.f);
            k.r(17);
            ThreadCardViewHolder<ThreadData> threadCardViewHolder = new ThreadCardViewHolder<>(k);
            threadCardViewHolder.i(this.c);
            setOnAdapterItemClickListener(new b(this));
            return threadCardViewHolder;
        }
        return (ThreadCardViewHolder) invokeL.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.repackage.bn
    /* renamed from: z */
    public View onFillViewHolder(int i, View view2, ViewGroup viewGroup, ThreadData threadData, ThreadCardViewHolder<ThreadData> threadCardViewHolder) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048582, this, new Object[]{Integer.valueOf(i), view2, viewGroup, threadData, threadCardViewHolder})) == null) {
            if (threadData == null || threadCardViewHolder == null || threadCardViewHolder.getView() == null) {
                return null;
            }
            threadData.statFloor = getPositionByType(i) + 1;
            threadCardViewHolder.a().q(i);
            threadCardViewHolder.o(true).u(this.e);
            threadCardViewHolder.s(true, Align.ALIGN_RIGHT_BOTTOM);
            threadCardViewHolder.e(threadData);
            threadCardViewHolder.a().p(this.g);
            threadCardViewHolder.a().onChangeSkinType(this.d, TbadkCoreApplication.getInst().getSkinType());
            ko7.c(this, threadData);
            return threadCardViewHolder.getView();
        }
        return (View) invokeCommon.objValue;
    }
}
