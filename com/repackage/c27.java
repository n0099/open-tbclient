package com.repackage;

import android.content.Context;
import android.graphics.Rect;
import android.view.View;
import android.view.ViewGroup;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.BdUniqueId;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.card.AutoVideoCardViewHolder;
import com.baidu.card.ThreadCardViewHolder;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.ThreadCardUtils;
import com.baidu.tieba.R;
import com.baidu.tieba.card.data.BaseCardInfo;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.repackage.cy;
import com.repackage.ny;
import com.repackage.qw;
/* loaded from: classes5.dex */
public class c27 extends an<wy5, AutoVideoCardViewHolder<wy5>> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public TbPageContext i;
    public BdUniqueId j;
    public tn k;
    public ky l;
    public bz6 m;
    public jy5<wy5> n;

    /* loaded from: classes5.dex */
    public class a extends jy5<wy5> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ c27 b;

        public a(c27 c27Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {c27Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = c27Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.repackage.jy5
        /* renamed from: d */
        public void a(View view2, wy5 wy5Var) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, view2, wy5Var) == null) || view2 == null || wy5Var == null || wy5Var.getThreadData() == null) {
                return;
            }
            this.b.f0(view2, wy5Var);
            if (this.b.m == null || !(view2.getTag() instanceof String) || ex6.b(ng.g(wy5Var.getThreadData().getTid(), 0L))) {
                return;
            }
            ex6.a(ng.g(wy5Var.getThreadData().getTid(), 0L));
            this.b.m.e(ng.g(wy5Var.getThreadData().getTid(), 0L), wy5Var.D(), wy5Var.o(), wy5Var.m(), wy5Var.c(), ng.e("3", 1), "video_tab", wy5Var.getThreadData().getBaijiahaoData());
        }
    }

    /* loaded from: classes5.dex */
    public class b implements qw.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ky a;
        public final /* synthetic */ c27 b;

        public b(c27 c27Var, ky kyVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {c27Var, kyVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = c27Var;
            this.a = kyVar;
        }

        @Override // com.repackage.qw.a
        public void a(nn4 nn4Var) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, nn4Var) == null) || nn4Var == null) {
                return;
            }
            Rect computeViewArea = ThreadCardUtils.computeViewArea(this.a.getVideoContainer());
            if (nn4Var instanceof wy5) {
                nn4Var.objType = 5;
                k27.f((ny5) nn4Var);
                k27.c(nn4Var, this.b.a, 19, false, computeViewArea);
                return;
            }
            k27.f((ny5) nn4Var);
            k27.c(nn4Var, this.b.a, 19, false, computeViewArea);
        }
    }

    /* loaded from: classes5.dex */
    public class c implements xn {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ c27 a;

        public c(c27 c27Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {c27Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = c27Var;
        }

        @Override // com.repackage.xn
        public void b(View view2, nn nnVar, BdUniqueId bdUniqueId, ViewGroup viewGroup, int i, long j) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{view2, nnVar, bdUniqueId, viewGroup, Integer.valueOf(i), Long.valueOf(j)}) == null) && (nnVar instanceof wy5) && (view2.getTag() instanceof ThreadCardViewHolder)) {
                ThreadCardViewHolder threadCardViewHolder = (ThreadCardViewHolder) view2.getTag();
                wy5 wy5Var = (wy5) nnVar;
                wy5Var.f = 1;
                if (this.a.n != null) {
                    this.a.n.a(threadCardViewHolder.b(), wy5Var);
                }
                k27.c(wy5Var, view2.getContext(), 19, false, uw.a((tn) viewGroup, view2, i));
                threadCardViewHolder.c().o(new ny.a(1));
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public c27(TbPageContext tbPageContext, BdUniqueId bdUniqueId) {
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
        this.i = tbPageContext;
    }

    public final s68 e0(wy5 wy5Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, wy5Var)) == null) {
            if (wy5Var != null) {
                s68 s68Var = new s68();
                s68Var.a = "19";
                s68Var.c = wy5Var.g;
                if (wy5Var.getThreadData() != null) {
                    s68Var.d = String.valueOf(wy5Var.getThreadData().getFid());
                    s68Var.v = wy5Var.getThreadData().getNid();
                    if (wy5Var.getThreadData().getThreadVideoInfo() != null) {
                        s68Var.m = wy5Var.getThreadData().getThreadVideoInfo().video_md5;
                        s68Var.p = String.valueOf(wy5Var.getThreadData().getThreadVideoInfo().is_vertical);
                    }
                }
                s68Var.k = wy5Var.g();
                s68Var.f = wy5Var.o();
                s68Var.l = wy5Var.c();
                s68Var.h = wy5Var.D();
                s68Var.e = TbadkCoreApplication.getCurrentAccount();
                s68Var.q = String.valueOf(wy5Var.m());
                if (wy5Var.getThreadData() == null || wy5Var.getThreadData().getBaijiahaoData() == null) {
                    return s68Var;
                }
                s68Var.t = wy5Var.getThreadData().getBaijiahaoData().oriUgcNid;
                s68Var.u = wy5Var.getThreadData().getBaijiahaoData().oriUgcVid;
                return s68Var;
            }
            return null;
        }
        return (s68) invokeL.objValue;
    }

    public final void f0(View view2, wy5 wy5Var) {
        ky kyVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048579, this, view2, wy5Var) == null) || (kyVar = this.l) == null || kyVar.p() == null || this.l.p().getMainView() == null) {
            return;
        }
        if (view2.getId() == this.l.p().getMainView().getId()) {
            k27.h(wy5Var);
        } else if (view2.getId() == R.id.obfuscated_res_0x7f09202a) {
            k27.f(wy5Var);
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.repackage.an
    /* renamed from: g0 */
    public AutoVideoCardViewHolder<wy5> M(ViewGroup viewGroup) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, viewGroup)) == null) {
            cy.b bVar = new cy.b(this.i.getPageActivity(), false);
            ww wwVar = new ww(this.i.getPageActivity());
            wwVar.v(new b(this, wwVar));
            this.l = wwVar;
            wwVar.x(this.j);
            this.l.u("video_tab");
            this.l.y("2001");
            bVar.n(this.l);
            cy k = bVar.k(BaseCardInfo.SupportType.CONTENT, viewGroup, this.k);
            AutoVideoCardViewHolder<wy5> autoVideoCardViewHolder = new AutoVideoCardViewHolder<>(k);
            autoVideoCardViewHolder.k(this.j);
            k.p(this.n);
            k.r(19);
            V(new c(this));
            return autoVideoCardViewHolder;
        }
        return (AutoVideoCardViewHolder) invokeL.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.repackage.an
    /* renamed from: h0 */
    public View S(int i, View view2, ViewGroup viewGroup, wy5 wy5Var, AutoVideoCardViewHolder<wy5> autoVideoCardViewHolder) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048581, this, new Object[]{Integer.valueOf(i), view2, viewGroup, wy5Var, autoVideoCardViewHolder})) == null) {
            if (wy5Var == null) {
                return autoVideoCardViewHolder.b();
            }
            if (autoVideoCardViewHolder == null) {
                return null;
            }
            wy5Var.I(wy5Var.position + 1);
            autoVideoCardViewHolder.c().q(i);
            autoVideoCardViewHolder.w(e0(wy5Var));
            k27.d(wy5Var);
            autoVideoCardViewHolder.g(wy5Var);
            autoVideoCardViewHolder.c().onChangeSkinType(this.i, TbadkCoreApplication.getInst().getSkinType());
            autoVideoCardViewHolder.c().p(this.n);
            return autoVideoCardViewHolder.b();
        }
        return (View) invokeCommon.objValue;
    }

    public void i0(BdUniqueId bdUniqueId) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, bdUniqueId) == null) {
            this.j = bdUniqueId;
        }
    }

    public void j0(bz6 bz6Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, bz6Var) == null) {
            this.m = bz6Var;
        }
    }

    public void k0(tn tnVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, tnVar) == null) {
            this.k = tnVar;
        }
    }

    public void onPause() {
        ky kyVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048585, this) == null) || (kyVar = this.l) == null) {
            return;
        }
        kyVar.s();
    }
}
