package com.repackage;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
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
import com.repackage.iy;
import com.repackage.xx;
/* loaded from: classes6.dex */
public class n46 extends wm<ThreadData, ThreadCardViewHolder<ThreadData>> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public BdUniqueId i;
    public String j;
    public TbPageContext<?> k;
    public NEGFeedBackView.b l;
    public pn m;
    public nw5<ThreadData> n;

    /* loaded from: classes6.dex */
    public class a extends nw5<ThreadData> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ n46 b;

        public a(n46 n46Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {n46Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = n46Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.repackage.nw5
        /* renamed from: d */
        public void a(View view2, ThreadData threadData) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, view2, threadData) == null) {
                gw5.b().d(true);
                t26.a(view2, threadData, this.b.j);
            }
        }
    }

    /* loaded from: classes6.dex */
    public class b implements tn {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ n46 a;

        public b(n46 n46Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {n46Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = n46Var;
        }

        @Override // com.repackage.tn
        public void b(View view2, jn jnVar, BdUniqueId bdUniqueId, ViewGroup viewGroup, int i, long j) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{view2, jnVar, bdUniqueId, viewGroup, Integer.valueOf(i), Long.valueOf(j)}) == null) {
                this.a.b0(view2, jnVar);
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public n46(TbPageContext tbPageContext, BdUniqueId bdUniqueId, BdUniqueId bdUniqueId2, String str) {
        super(tbPageContext.getPageActivity(), bdUniqueId);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {tbPageContext, bdUniqueId, bdUniqueId2, str};
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
        this.n = new a(this);
        this.k = tbPageContext;
        this.i = bdUniqueId2;
        this.j = str;
    }

    public final void b0(View view2, jn jnVar) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, view2, jnVar) == null) && (jnVar instanceof uw5) && (view2.getTag() instanceof ThreadCardViewHolder)) {
            uw5 uw5Var = (uw5) jnVar;
            uw5Var.f = 1;
            ThreadCardUtils.jumpToPB((om4) uw5Var, view2.getContext(), 2, false);
            ((ThreadCardViewHolder) view2.getTag()).c().o(new iy.a(1));
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.repackage.wm
    /* renamed from: c0 */
    public ThreadCardViewHolder<ThreadData> M(ViewGroup viewGroup) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, viewGroup)) == null) {
            xx.b bVar = new xx.b(this.k.getPageActivity());
            pw pwVar = new pw(this.k.getPageActivity());
            pwVar.t(this.i);
            pwVar.v(this.k);
            bVar.o(pwVar);
            bVar.n(new nw(this.k.getPageActivity()));
            bVar.h(new ww(this.k.getPageActivity()));
            zx zxVar = new zx(this.k.getPageActivity());
            um4 um4Var = new um4();
            um4Var.b = 1;
            um4Var.h = 1;
            zxVar.w(false);
            zxVar.v(um4Var);
            zxVar.x(1);
            zxVar.C(3);
            zxVar.y(2);
            bVar.m(zxVar);
            xx k = bVar.k(BaseCardInfo.SupportType.FULL, viewGroup, this.m);
            k.r(2);
            ThreadCardViewHolder<ThreadData> threadCardViewHolder = new ThreadCardViewHolder<>(k);
            threadCardViewHolder.k(this.i);
            V(new b(this));
            return threadCardViewHolder;
        }
        return (ThreadCardViewHolder) invokeL.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.repackage.wm
    /* renamed from: d0 */
    public View S(int i, View view2, ViewGroup viewGroup, ThreadData threadData, ThreadCardViewHolder<ThreadData> threadCardViewHolder) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048580, this, new Object[]{Integer.valueOf(i), view2, viewGroup, threadData, threadCardViewHolder})) == null) {
            if (threadData == null || threadCardViewHolder == null || threadCardViewHolder.b() == null) {
                return null;
            }
            threadData.statFloor = C(i) + 1;
            threadCardViewHolder.c().q(i);
            threadCardViewHolder.r(true).u(this.l);
            threadCardViewHolder.v(true, Align.ALIGN_RIGHT_BOTTOM);
            threadCardViewHolder.g(threadData);
            threadCardViewHolder.c().p(this.n);
            threadCardViewHolder.c().onChangeSkinType(this.k, TbadkCoreApplication.getInst().getSkinType());
            t26.b(threadData, this.j);
            return threadCardViewHolder.b();
        }
        return (View) invokeCommon.objValue;
    }

    public void e0(pn pnVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, pnVar) == null) {
            this.m = pnVar;
        }
    }
}
