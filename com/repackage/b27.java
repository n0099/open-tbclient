package com.repackage;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
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
import com.repackage.kz;
import com.repackage.vz;
/* loaded from: classes5.dex */
public class b27 extends eo<gy5, ThreadCardViewHolder<gy5>> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public BdUniqueId i;
    public TbPageContext<?> j;
    public zy6 k;
    public xo l;
    public ux5<gy5> m;

    /* loaded from: classes5.dex */
    public class a extends ux5<gy5> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ b27 b;

        public a(b27 b27Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {b27Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = b27Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.repackage.ux5
        /* renamed from: d */
        public void a(View view2, gy5 gy5Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, view2, gy5Var) == null) {
                nx5.b().d(true);
                if (view2 == null || this.b.k == null || gy5Var == null || gy5Var.getThreadData() == null || StringUtils.isNull(gy5Var.getThreadData().getTid())) {
                    return;
                }
                if ((view2.getTag() instanceof String) && !cx6.b(kg.g(gy5Var.getThreadData().getTid(), 0L))) {
                    cx6.a(kg.g(gy5Var.getThreadData().getTid(), 0L));
                    this.b.k.e(kg.g(gy5Var.getThreadData().getTid(), 0L), gy5Var.D(), gy5Var.r(), gy5Var.q(), gy5Var.e(), kg.e((String) view2.getTag(), 1), "video_tab", gy5Var.getThreadData().getBaijiahaoData());
                }
                this.b.e0(view2, gy5Var);
            }
        }
    }

    /* loaded from: classes5.dex */
    public class b implements bp {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ b27 a;

        public b(b27 b27Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {b27Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = b27Var;
        }

        @Override // com.repackage.bp
        public void b(View view2, ro roVar, BdUniqueId bdUniqueId, ViewGroup viewGroup, int i, long j) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{view2, roVar, bdUniqueId, viewGroup, Integer.valueOf(i), Long.valueOf(j)}) == null) && (roVar instanceof gy5) && (view2.getTag() instanceof ThreadCardViewHolder)) {
                ThreadCardViewHolder threadCardViewHolder = (ThreadCardViewHolder) view2.getTag();
                gy5 gy5Var = (gy5) roVar;
                gy5Var.f = 1;
                if (this.a.m != null) {
                    this.a.m.a(threadCardViewHolder.b(), gy5Var);
                }
                ThreadCardUtils.jumpToPB((zn4) gy5Var, view2.getContext(), 19, false);
                threadCardViewHolder.c().o(new vz.a(1));
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public b27(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId) {
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
        this.j = tbPageContext;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.repackage.eo
    /* renamed from: c0 */
    public ThreadCardViewHolder M(ViewGroup viewGroup) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, viewGroup)) == null) {
            kz.b bVar = new kz.b(this.j.getPageActivity(), false);
            jy jyVar = new jy(this.j.getPageActivity());
            jyVar.t();
            bVar.h(jyVar);
            kz k = bVar.k(BaseCardInfo.SupportType.EXTEND, viewGroup, this.l);
            k.r(19);
            ThreadCardViewHolder threadCardViewHolder = new ThreadCardViewHolder(k);
            threadCardViewHolder.k(this.i);
            V(new b(this));
            return threadCardViewHolder;
        }
        return (ThreadCardViewHolder) invokeL.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.repackage.eo
    /* renamed from: d0 */
    public View S(int i, View view2, ViewGroup viewGroup, gy5 gy5Var, ThreadCardViewHolder<gy5> threadCardViewHolder) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048579, this, new Object[]{Integer.valueOf(i), view2, viewGroup, gy5Var, threadCardViewHolder})) == null) {
            if (gy5Var == null || threadCardViewHolder == null || threadCardViewHolder.b() == null || gy5Var.a == null) {
                return null;
            }
            gy5Var.I(gy5Var.position + 1);
            threadCardViewHolder.c().q(i);
            threadCardViewHolder.g(gy5Var);
            threadCardViewHolder.c().onChangeSkinType(this.j, TbadkCoreApplication.getInst().getSkinType());
            threadCardViewHolder.c().p(this.m);
            nx5.b().a(gy5Var.B());
            gj5.c().a(gy5Var.B());
            fz6.h(gy5Var.a, this.i, gy5Var.q());
            return threadCardViewHolder.b();
        }
        return (View) invokeCommon.objValue;
    }

    public final void e0(View view2, gy5 gy5Var) {
        StatisticItem A;
        int i;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048580, this, view2, gy5Var) == null) {
            int id = view2.getId();
            if (gy5Var == null) {
                return;
            }
            if (view2.getId() == R.id.obfuscated_res_0x7f091fe0 || id == R.id.obfuscated_res_0x7f091ff4) {
                if (gy5Var.isVideoThreadType()) {
                    A = gy5Var.C();
                } else {
                    A = gy5Var.A();
                }
                TbSingleton.getInstance().setCurrentClickTime(TiebaStatic.logWithBackTime(A));
                i = 1;
            } else if (id == R.id.obfuscated_res_0x7f090a5f || id == R.id.obfuscated_res_0x7f090a37) {
                TiebaStatic.log(gy5Var.k());
                i = 9;
            } else {
                i = 0;
            }
            if (i != 0) {
                fz6.d(gy5Var.a, this.i, gy5Var.q(), i);
            }
        }
    }

    public void f0(BdUniqueId bdUniqueId) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, bdUniqueId) == null) {
            this.i = bdUniqueId;
        }
    }

    public void g0(zy6 zy6Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, zy6Var) == null) {
            this.k = zy6Var;
        }
    }

    public void h0(xo xoVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, xoVar) == null) {
            this.l = xoVar;
        }
    }
}
