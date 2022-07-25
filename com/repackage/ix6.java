package com.repackage;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.card.ThreadCardViewHolder;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.ThreadCardUtils;
import com.baidu.tbadk.core.util.TiebaStatic;
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
/* loaded from: classes6.dex */
public class ix6 extends os6<qy5, ThreadCardViewHolder<qy5>> implements ck5 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public BdUniqueId j;
    public TbPageContext<?> k;
    public String l;
    public NEGFeedBackView.b m;
    public tn n;
    public jy5<qy5> o;

    /* loaded from: classes6.dex */
    public class a extends jy5<qy5> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ix6 b;

        public a(ix6 ix6Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ix6Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = ix6Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.repackage.jy5
        /* renamed from: d */
        public void a(View view2, qy5 qy5Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, view2, qy5Var) == null) {
                cy5.b().d(true);
                ak5.c().h("page_recommend", "show_");
                if (view2 == null || qy5Var == null || qy5Var.getThreadData() == null || StringUtils.isNull(qy5Var.getThreadData().getTid())) {
                    return;
                }
                this.b.f0(view2, qy5Var);
            }
        }
    }

    /* loaded from: classes6.dex */
    public class b implements xn {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ix6 a;

        public b(ix6 ix6Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ix6Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = ix6Var;
        }

        @Override // com.repackage.xn
        public void b(View view2, nn nnVar, BdUniqueId bdUniqueId, ViewGroup viewGroup, int i, long j) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{view2, nnVar, bdUniqueId, viewGroup, Integer.valueOf(i), Long.valueOf(j)}) == null) {
                this.a.c0(view2, nnVar);
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ix6(TbPageContext tbPageContext, BdUniqueId bdUniqueId) {
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
        this.o = new a(this);
        this.k = tbPageContext;
    }

    public final void c0(View view2, nn nnVar) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, view2, nnVar) == null) && (nnVar instanceof qy5) && (view2.getTag() instanceof ThreadCardViewHolder)) {
            qy5 qy5Var = (qy5) nnVar;
            qy5Var.f = 1;
            ThreadCardUtils.jumpToPB((on4) qy5Var, view2.getContext(), 2, false);
            ((ThreadCardViewHolder) view2.getTag()).b().o(new ny.a(1));
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.repackage.an
    /* renamed from: d0 */
    public ThreadCardViewHolder<qy5> M(ViewGroup viewGroup) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, viewGroup)) == null) {
            cy.b bVar = new cy.b(this.k.getPageActivity());
            tw twVar = new tw(this.k.getPageActivity());
            twVar.u(this.j);
            twVar.w(this.k);
            bVar.o(twVar);
            bVar.n(new rw(this.k.getPageActivity()));
            bVar.h(new ax(this.k.getPageActivity()));
            ey eyVar = new ey(this.k.getPageActivity());
            un4 un4Var = new un4();
            un4Var.b = 1;
            un4Var.h = 1;
            eyVar.w(un4Var);
            eyVar.y(1);
            eyVar.D(3);
            eyVar.z(2);
            eyVar.x(false);
            bVar.m(eyVar);
            bVar.l().h(pi.f(TbadkCoreApplication.getInst(), R.dimen.tbds35));
            cy k = bVar.k(BaseCardInfo.SupportType.FULL, viewGroup, this.n);
            k.r(2);
            ThreadCardViewHolder<qy5> threadCardViewHolder = new ThreadCardViewHolder<>(k);
            threadCardViewHolder.j(this.j);
            V(new b(this));
            return threadCardViewHolder;
        }
        return (ThreadCardViewHolder) invokeL.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.repackage.an
    /* renamed from: e0 */
    public View S(int i, View view2, ViewGroup viewGroup, qy5 qy5Var, ThreadCardViewHolder<qy5> threadCardViewHolder) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048580, this, new Object[]{Integer.valueOf(i), view2, viewGroup, qy5Var, threadCardViewHolder})) == null) {
            if (qy5Var == null || threadCardViewHolder == null || threadCardViewHolder.a() == null) {
                return null;
            }
            qy5Var.I(qy5Var.position + 1);
            qy5Var.a.statFloor = qy5Var.m();
            threadCardViewHolder.b().q(i);
            threadCardViewHolder.b().b(this.l);
            threadCardViewHolder.p(true).u(this.m);
            threadCardViewHolder.l(qy5Var.showFollowBtn(), this.i);
            threadCardViewHolder.f(qy5Var);
            threadCardViewHolder.b().p(this.o);
            threadCardViewHolder.b().onChangeSkinType(this.k, TbadkCoreApplication.getInst().getSkinType());
            cy5.b().a(qy5Var.B());
            return threadCardViewHolder.a();
        }
        return (View) invokeCommon.objValue;
    }

    /* JADX WARN: Removed duplicated region for block: B:15:0x0025  */
    /* JADX WARN: Removed duplicated region for block: B:20:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void f0(View view2, qy5 qy5Var) {
        int i;
        Interceptable interceptable = $ic;
        if (interceptable != null && interceptable.invokeLL(1048581, this, view2, qy5Var) != null) {
            return;
        }
        int id = view2.getId();
        if (id == R.id.obfuscated_res_0x7f09202e) {
            TiebaStatic.log(qy5Var.A());
        } else if (id == R.id.obfuscated_res_0x7f09230e || id == R.id.obfuscated_res_0x7f09232f) {
            i = 2;
            if (i == 0) {
                iz6.d(qy5Var.a, this.j, qy5Var.m(), i);
                return;
            }
            return;
        }
        i = 0;
        if (i == 0) {
        }
    }

    @Override // com.repackage.ck5
    public void g(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, str) == null) {
            this.l = str;
        }
    }

    public void g0(NEGFeedBackView.b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, bVar) == null) {
            this.m = bVar;
        }
    }

    public void h0(tn tnVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, tnVar) == null) {
            this.n = tnVar;
        }
    }
}
