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
import com.baidu.tbadk.TbSingleton;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.ThreadCardUtils;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tieba.R;
import com.baidu.tieba.card.data.BaseCardInfo;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.repackage.by;
import com.repackage.my;
/* loaded from: classes7.dex */
public class xw6 extends an<yx5, ThreadCardViewHolder<yx5>> implements zi5 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public BdUniqueId i;
    public TbPageContext<?> j;
    public ly6 k;
    public String l;
    public tn m;
    public mx5<yx5> n;

    /* loaded from: classes7.dex */
    public class a extends mx5<yx5> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ xw6 b;

        public a(xw6 xw6Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {xw6Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = xw6Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.repackage.mx5
        /* renamed from: d */
        public void a(View view2, yx5 yx5Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, view2, yx5Var) == null) {
                fx5.b().d(true);
                xi5.c().h("page_recommend", "show_");
                if (view2 == null || this.b.k == null || yx5Var == null || yx5Var.getThreadData() == null || StringUtils.isNull(yx5Var.getThreadData().getTid())) {
                    return;
                }
                if ((view2.getTag() instanceof String) && !ow6.b(ng.g(yx5Var.getThreadData().getTid(), 0L))) {
                    ow6.a(ng.g(yx5Var.getThreadData().getTid(), 0L));
                    this.b.k.e(ng.g(yx5Var.getThreadData().getTid(), 0L), yx5Var.D(), yx5Var.r(), yx5Var.n(), yx5Var.c(), ng.e((String) view2.getTag(), 1), "homepage", yx5Var.getThreadData().getBaijiahaoData());
                }
                this.b.f0(view2, yx5Var);
            }
        }
    }

    /* loaded from: classes7.dex */
    public class b implements xn {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ xw6 a;

        public b(xw6 xw6Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {xw6Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = xw6Var;
        }

        @Override // com.repackage.xn
        public void b(View view2, nn nnVar, BdUniqueId bdUniqueId, ViewGroup viewGroup, int i, long j) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{view2, nnVar, bdUniqueId, viewGroup, Integer.valueOf(i), Long.valueOf(j)}) == null) && (nnVar instanceof yx5) && (view2.getTag() instanceof ThreadCardViewHolder)) {
                ThreadCardViewHolder threadCardViewHolder = (ThreadCardViewHolder) view2.getTag();
                yx5 yx5Var = (yx5) nnVar;
                yx5Var.f = 1;
                if (this.a.n != null) {
                    this.a.n.a(threadCardViewHolder.b(), yx5Var);
                }
                ThreadCardUtils.jumpToPB((ym4) yx5Var, view2.getContext(), 2, false);
                threadCardViewHolder.c().o(new my.a(1));
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public xw6(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId) {
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
        this.n = new a(this);
        this.j = tbPageContext;
        c0();
    }

    public final void c0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            yx5.R = "c10705";
            yx5.S = "c10730";
            yx5.T = "c10731";
            yx5.U = "c10704";
            yx5.V = "c10755";
            yx5.W = "c10710";
            yx5.X = "c10736";
            yx5.Y = "c10737";
            yx5.Z = "c10711";
            yx5.g0 = "c10758";
            yx5.h0 = "c10757";
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.repackage.an
    /* renamed from: d0 */
    public ThreadCardViewHolder M(ViewGroup viewGroup) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, viewGroup)) == null) {
            by.b bVar = new by.b(this.j.getPageActivity(), false);
            ax axVar = new ax(this.j.getPageActivity());
            axVar.t();
            bVar.h(axVar);
            by k = bVar.k(BaseCardInfo.SupportType.EXTEND, viewGroup, this.m);
            k.r(2);
            ThreadCardViewHolder threadCardViewHolder = new ThreadCardViewHolder(k);
            threadCardViewHolder.k(this.i);
            V(new b(this));
            return threadCardViewHolder;
        }
        return (ThreadCardViewHolder) invokeL.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.repackage.an
    /* renamed from: e0 */
    public View S(int i, View view2, ViewGroup viewGroup, yx5 yx5Var, ThreadCardViewHolder<yx5> threadCardViewHolder) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048580, this, new Object[]{Integer.valueOf(i), view2, viewGroup, yx5Var, threadCardViewHolder})) == null) {
            if (yx5Var == null || threadCardViewHolder == null || threadCardViewHolder.b() == null || yx5Var.a == null) {
                return null;
            }
            yx5Var.I(yx5Var.position + 1);
            yx5Var.a.statFloor = yx5Var.n();
            threadCardViewHolder.c().q(i);
            threadCardViewHolder.c().b(this.l);
            threadCardViewHolder.g(yx5Var);
            threadCardViewHolder.c().onChangeSkinType(this.j, TbadkCoreApplication.getInst().getSkinType());
            threadCardViewHolder.c().p(this.n);
            fx5.b().a(yx5Var.B());
            xi5.c().a(yx5Var.B());
            sy6.h(yx5Var.a, this.i, yx5Var.n());
            return threadCardViewHolder.b();
        }
        return (View) invokeCommon.objValue;
    }

    public final void f0(View view2, yx5 yx5Var) {
        StatisticItem A;
        int i;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048581, this, view2, yx5Var) == null) {
            int id = view2.getId();
            if (yx5Var == null) {
                return;
            }
            if (view2.getId() == R.id.obfuscated_res_0x7f091f85 || id == R.id.obfuscated_res_0x7f091f99) {
                if (yx5Var.isVideoThreadType()) {
                    A = yx5Var.C();
                } else {
                    A = yx5Var.A();
                }
                TbSingleton.getInstance().setCurrentClickTime(TiebaStatic.logWithBackTime(A));
                xi5.c().i("page_recommend", "clk_", A);
                i = 1;
                sy6.b(yx5Var.a, yx5Var.r(), yx5Var.n());
            } else if (id == R.id.obfuscated_res_0x7f090a38 || id == R.id.obfuscated_res_0x7f090a10) {
                TiebaStatic.log(yx5Var.j());
                xi5.c().i("page_recommend", "clk_", yx5Var.j());
                i = 9;
            } else {
                i = 0;
            }
            if (i != 0) {
                sy6.d(yx5Var.a, this.i, yx5Var.n(), i);
            }
        }
    }

    @Override // com.repackage.zi5
    public void g(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, str) == null) {
            this.l = str;
        }
    }

    public void g0(ly6 ly6Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, ly6Var) == null) {
            this.k = ly6Var;
        }
    }

    public void h0(tn tnVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, tnVar) == null) {
            this.m = tnVar;
        }
    }
}
