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
import com.repackage.iy;
import com.repackage.xx;
/* loaded from: classes6.dex */
public class kv6 extends xq6<uw5, ThreadCardViewHolder<uw5>> implements ci5 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public BdUniqueId j;
    public TbPageContext<?> k;
    public String l;
    public NEGFeedBackView.b m;
    public pn n;
    public nw5<uw5> o;

    /* loaded from: classes6.dex */
    public class a extends nw5<uw5> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ kv6 b;

        public a(kv6 kv6Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {kv6Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = kv6Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.repackage.nw5
        /* renamed from: d */
        public void a(View view2, uw5 uw5Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, view2, uw5Var) == null) {
                gw5.b().d(true);
                ai5.c().h("page_recommend", "show_");
                if (view2 == null || uw5Var == null || uw5Var.getThreadData() == null || StringUtils.isNull(uw5Var.getThreadData().getTid())) {
                    return;
                }
                this.b.f0(view2, uw5Var);
            }
        }
    }

    /* loaded from: classes6.dex */
    public class b implements tn {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ kv6 a;

        public b(kv6 kv6Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {kv6Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = kv6Var;
        }

        @Override // com.repackage.tn
        public void b(View view2, jn jnVar, BdUniqueId bdUniqueId, ViewGroup viewGroup, int i, long j) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{view2, jnVar, bdUniqueId, viewGroup, Integer.valueOf(i), Long.valueOf(j)}) == null) {
                this.a.c0(view2, jnVar);
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public kv6(TbPageContext tbPageContext, BdUniqueId bdUniqueId) {
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

    public final void c0(View view2, jn jnVar) {
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
    /* renamed from: d0 */
    public ThreadCardViewHolder<uw5> M(ViewGroup viewGroup) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, viewGroup)) == null) {
            xx.b bVar = new xx.b(this.k.getPageActivity());
            pw pwVar = new pw(this.k.getPageActivity());
            pwVar.t(this.j);
            pwVar.v(this.k);
            bVar.o(pwVar);
            bVar.n(new nw(this.k.getPageActivity()));
            bVar.h(new ww(this.k.getPageActivity()));
            zx zxVar = new zx(this.k.getPageActivity());
            um4 um4Var = new um4();
            um4Var.b = 1;
            um4Var.h = 1;
            zxVar.v(um4Var);
            zxVar.x(1);
            zxVar.C(3);
            zxVar.y(2);
            zxVar.w(false);
            bVar.m(zxVar);
            bVar.l().h(li.f(TbadkCoreApplication.getInst(), R.dimen.tbds35));
            xx k = bVar.k(BaseCardInfo.SupportType.FULL, viewGroup, this.n);
            k.r(2);
            ThreadCardViewHolder<uw5> threadCardViewHolder = new ThreadCardViewHolder<>(k);
            threadCardViewHolder.k(this.j);
            V(new b(this));
            return threadCardViewHolder;
        }
        return (ThreadCardViewHolder) invokeL.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.repackage.wm
    /* renamed from: e0 */
    public View S(int i, View view2, ViewGroup viewGroup, uw5 uw5Var, ThreadCardViewHolder<uw5> threadCardViewHolder) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048580, this, new Object[]{Integer.valueOf(i), view2, viewGroup, uw5Var, threadCardViewHolder})) == null) {
            if (uw5Var == null || threadCardViewHolder == null || threadCardViewHolder.b() == null) {
                return null;
            }
            uw5Var.I(uw5Var.position + 1);
            uw5Var.a.statFloor = uw5Var.q();
            threadCardViewHolder.c().q(i);
            threadCardViewHolder.c().b(this.l);
            threadCardViewHolder.r(true).u(this.m);
            threadCardViewHolder.m(uw5Var.showFollowBtn(), this.i);
            threadCardViewHolder.g(uw5Var);
            threadCardViewHolder.c().p(this.o);
            threadCardViewHolder.c().onChangeSkinType(this.k, TbadkCoreApplication.getInst().getSkinType());
            gw5.b().a(uw5Var.B());
            return threadCardViewHolder.b();
        }
        return (View) invokeCommon.objValue;
    }

    /* JADX WARN: Removed duplicated region for block: B:15:0x0025  */
    /* JADX WARN: Removed duplicated region for block: B:20:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void f0(View view2, uw5 uw5Var) {
        int i;
        Interceptable interceptable = $ic;
        if (interceptable != null && interceptable.invokeLL(1048581, this, view2, uw5Var) != null) {
            return;
        }
        int id = view2.getId();
        if (id == R.id.obfuscated_res_0x7f091f85) {
            TiebaStatic.log(uw5Var.A());
        } else if (id == R.id.obfuscated_res_0x7f092278 || id == R.id.obfuscated_res_0x7f092298) {
            i = 2;
            if (i == 0) {
                jx6.d(uw5Var.a, this.j, uw5Var.q(), i);
                return;
            }
            return;
        }
        i = 0;
        if (i == 0) {
        }
    }

    @Override // com.repackage.ci5
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

    public void h0(pn pnVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, pnVar) == null) {
            this.n = pnVar;
        }
    }
}
