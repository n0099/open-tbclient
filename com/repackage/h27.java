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
import com.baidu.tieba.NEGFeedBack.NEGFeedBackView;
import com.baidu.tieba.R;
import com.baidu.tieba.card.data.BaseCardInfo;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.repackage.cy;
import com.repackage.ny;
import com.repackage.tw;
/* loaded from: classes6.dex */
public class h27 extends an<vy5, ThreadCardViewHolder<vy5>> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public TbPageContext i;
    public BdUniqueId j;
    public tn k;
    public NEGFeedBackView.b l;
    public jy5<vy5> m;

    /* loaded from: classes6.dex */
    public class a extends jy5<vy5> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public a(h27 h27Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {h27Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.repackage.jy5
        /* renamed from: d */
        public void a(View view2, vy5 vy5Var) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, view2, vy5Var) == null) || view2 == null || vy5Var == null || vy5Var.getThreadData() == null) {
                return;
            }
            int id = view2.getId();
            if (id == R.id.obfuscated_res_0x7f09202a || id == R.id.obfuscated_res_0x7f09203e) {
                k27.f(vy5Var);
            } else if (id == R.id.obfuscated_res_0x7f09230c) {
                k27.e(vy5Var);
            } else if (id == R.id.obfuscated_res_0x7f09232d) {
                k27.e(vy5Var);
            }
        }
    }

    /* loaded from: classes6.dex */
    public class b implements tw.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public b(h27 h27Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {h27Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        @Override // com.repackage.tw.b
        public void a(nn4 nn4Var, View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(1048576, this, nn4Var, view2) == null) {
            }
        }
    }

    /* loaded from: classes6.dex */
    public class c implements xn {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ h27 a;

        public c(h27 h27Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {h27Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = h27Var;
        }

        @Override // com.repackage.xn
        public void b(View view2, nn nnVar, BdUniqueId bdUniqueId, ViewGroup viewGroup, int i, long j) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{view2, nnVar, bdUniqueId, viewGroup, Integer.valueOf(i), Long.valueOf(j)}) == null) && (nnVar instanceof vy5) && (view2.getTag() instanceof ThreadCardViewHolder)) {
                ThreadCardViewHolder threadCardViewHolder = (ThreadCardViewHolder) view2.getTag();
                vy5 vy5Var = (vy5) nnVar;
                vy5Var.f = 1;
                if (this.a.m != null) {
                    this.a.m.a(threadCardViewHolder.b(), vy5Var);
                }
                k27.c(vy5Var, view2.getContext(), 19, false, uw.a((tn) viewGroup, view2, i));
                threadCardViewHolder.c().o(new ny.a(1));
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public h27(TbPageContext tbPageContext, BdUniqueId bdUniqueId) {
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
        this.i = tbPageContext;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.repackage.an
    /* renamed from: a0 */
    public ThreadCardViewHolder<vy5> M(ViewGroup viewGroup) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, viewGroup)) == null) {
            cy.b bVar = new cy.b(this.i.getPageActivity());
            tw twVar = new tw(this.i.getPageActivity());
            twVar.u(this.j);
            twVar.d(1024);
            twVar.t(new b(this));
            twVar.w(this.i);
            bVar.o(twVar);
            cy k = bVar.k(BaseCardInfo.SupportType.TOP, viewGroup, this.k);
            k.r(19);
            ThreadCardViewHolder<vy5> threadCardViewHolder = new ThreadCardViewHolder<>(k);
            threadCardViewHolder.k(this.j);
            V(new c(this));
            return threadCardViewHolder;
        }
        return (ThreadCardViewHolder) invokeL.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.repackage.an
    /* renamed from: b0 */
    public View S(int i, View view2, ViewGroup viewGroup, vy5 vy5Var, ThreadCardViewHolder<vy5> threadCardViewHolder) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048579, this, new Object[]{Integer.valueOf(i), view2, viewGroup, vy5Var, threadCardViewHolder})) == null) {
            if (vy5Var == null || threadCardViewHolder == null || threadCardViewHolder.b() == null || vy5Var.a == null) {
                return null;
            }
            vy5Var.I(vy5Var.position + 1);
            threadCardViewHolder.c().q(i);
            threadCardViewHolder.m(vy5Var.a.showFollowBtn(), null);
            threadCardViewHolder.r(true, Align.ALIGN_RIGHT_TOP, this.l);
            threadCardViewHolder.g(vy5Var);
            threadCardViewHolder.c().onChangeSkinType(this.i, TbadkCoreApplication.getInst().getSkinType());
            threadCardViewHolder.c().p(this.m);
            return threadCardViewHolder.b();
        }
        return (View) invokeCommon.objValue;
    }

    public void c0(NEGFeedBackView.b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, bVar) == null) {
            this.l = bVar;
        }
    }

    public void d0(BdUniqueId bdUniqueId) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, bdUniqueId) == null) {
            this.j = bdUniqueId;
        }
    }

    public void e0(tn tnVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, tnVar) == null) {
            this.k = tnVar;
        }
    }
}
