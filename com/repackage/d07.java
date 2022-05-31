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
import com.repackage.iy;
import com.repackage.mw;
import com.repackage.xx;
/* loaded from: classes5.dex */
public class d07 extends wm<ax5, AutoVideoCardViewHolder<ax5>> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public TbPageContext i;
    public BdUniqueId j;
    public pn k;
    public fy l;
    public dx6 m;
    public nw5<ax5> n;

    /* loaded from: classes5.dex */
    public class a extends nw5<ax5> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ d07 b;

        public a(d07 d07Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {d07Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = d07Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.repackage.nw5
        /* renamed from: d */
        public void a(View view2, ax5 ax5Var) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, view2, ax5Var) == null) || view2 == null || ax5Var == null || ax5Var.getThreadData() == null) {
                return;
            }
            this.b.f0(view2, ax5Var);
            if (this.b.m == null || !(view2.getTag() instanceof String) || gv6.b(jg.g(ax5Var.getThreadData().getTid(), 0L))) {
                return;
            }
            gv6.a(jg.g(ax5Var.getThreadData().getTid(), 0L));
            this.b.m.e(jg.g(ax5Var.getThreadData().getTid(), 0L), ax5Var.D(), ax5Var.r(), ax5Var.q(), ax5Var.e(), jg.e("3", 1), "video_tab", ax5Var.getThreadData().getBaijiahaoData());
        }
    }

    /* loaded from: classes5.dex */
    public class b implements mw.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ fy a;
        public final /* synthetic */ d07 b;

        public b(d07 d07Var, fy fyVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {d07Var, fyVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = d07Var;
            this.a = fyVar;
        }

        @Override // com.repackage.mw.a
        public void a(om4 om4Var) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, om4Var) == null) || om4Var == null) {
                return;
            }
            Rect computeViewArea = ThreadCardUtils.computeViewArea(this.a.getVideoContainer());
            if (om4Var instanceof ax5) {
                om4Var.objType = 5;
                l07.f((rw5) om4Var);
                l07.c(om4Var, this.b.a, 19, false, computeViewArea);
                return;
            }
            l07.f((rw5) om4Var);
            l07.c(om4Var, this.b.a, 19, false, computeViewArea);
        }
    }

    /* loaded from: classes5.dex */
    public class c implements tn {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ d07 a;

        public c(d07 d07Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {d07Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = d07Var;
        }

        @Override // com.repackage.tn
        public void b(View view2, jn jnVar, BdUniqueId bdUniqueId, ViewGroup viewGroup, int i, long j) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{view2, jnVar, bdUniqueId, viewGroup, Integer.valueOf(i), Long.valueOf(j)}) == null) && (jnVar instanceof ax5) && (view2.getTag() instanceof ThreadCardViewHolder)) {
                ThreadCardViewHolder threadCardViewHolder = (ThreadCardViewHolder) view2.getTag();
                ax5 ax5Var = (ax5) jnVar;
                ax5Var.f = 1;
                if (this.a.n != null) {
                    this.a.n.a(threadCardViewHolder.b(), ax5Var);
                }
                l07.c(ax5Var, view2.getContext(), 19, false, qw.a((pn) viewGroup, view2, i));
                threadCardViewHolder.c().o(new iy.a(1));
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public d07(TbPageContext tbPageContext, BdUniqueId bdUniqueId) {
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

    public final t48 e0(ax5 ax5Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, ax5Var)) == null) {
            if (ax5Var != null) {
                t48 t48Var = new t48();
                t48Var.a = "19";
                t48Var.c = ax5Var.g;
                if (ax5Var.getThreadData() != null) {
                    t48Var.d = String.valueOf(ax5Var.getThreadData().getFid());
                    t48Var.v = ax5Var.getThreadData().getNid();
                    if (ax5Var.getThreadData().getThreadVideoInfo() != null) {
                        t48Var.m = ax5Var.getThreadData().getThreadVideoInfo().video_md5;
                        t48Var.p = String.valueOf(ax5Var.getThreadData().getThreadVideoInfo().is_vertical);
                    }
                }
                t48Var.k = ax5Var.i();
                t48Var.f = ax5Var.r();
                t48Var.l = ax5Var.e();
                t48Var.h = ax5Var.D();
                t48Var.e = TbadkCoreApplication.getCurrentAccount();
                t48Var.q = String.valueOf(ax5Var.q());
                if (ax5Var.getThreadData() == null || ax5Var.getThreadData().getBaijiahaoData() == null) {
                    return t48Var;
                }
                t48Var.t = ax5Var.getThreadData().getBaijiahaoData().oriUgcNid;
                t48Var.u = ax5Var.getThreadData().getBaijiahaoData().oriUgcVid;
                return t48Var;
            }
            return null;
        }
        return (t48) invokeL.objValue;
    }

    public final void f0(View view2, ax5 ax5Var) {
        fy fyVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048579, this, view2, ax5Var) == null) || (fyVar = this.l) == null || fyVar.o() == null || this.l.o().getMainView() == null) {
            return;
        }
        if (view2.getId() == this.l.o().getMainView().getId()) {
            l07.h(ax5Var);
        } else if (view2.getId() == R.id.obfuscated_res_0x7f091f85) {
            l07.f(ax5Var);
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.repackage.wm
    /* renamed from: g0 */
    public AutoVideoCardViewHolder<ax5> M(ViewGroup viewGroup) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, viewGroup)) == null) {
            xx.b bVar = new xx.b(this.i.getPageActivity(), false);
            sw swVar = new sw(this.i.getPageActivity());
            swVar.u(new b(this, swVar));
            this.l = swVar;
            swVar.w(this.j);
            this.l.t("video_tab");
            this.l.x("2001");
            bVar.n(this.l);
            xx k = bVar.k(BaseCardInfo.SupportType.CONTENT, viewGroup, this.k);
            AutoVideoCardViewHolder<ax5> autoVideoCardViewHolder = new AutoVideoCardViewHolder<>(k);
            autoVideoCardViewHolder.k(this.j);
            k.p(this.n);
            k.r(19);
            V(new c(this));
            return autoVideoCardViewHolder;
        }
        return (AutoVideoCardViewHolder) invokeL.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.repackage.wm
    /* renamed from: h0 */
    public View S(int i, View view2, ViewGroup viewGroup, ax5 ax5Var, AutoVideoCardViewHolder<ax5> autoVideoCardViewHolder) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048581, this, new Object[]{Integer.valueOf(i), view2, viewGroup, ax5Var, autoVideoCardViewHolder})) == null) {
            if (ax5Var == null) {
                return autoVideoCardViewHolder.b();
            }
            if (autoVideoCardViewHolder == null) {
                return null;
            }
            ax5Var.I(ax5Var.position + 1);
            autoVideoCardViewHolder.c().q(i);
            autoVideoCardViewHolder.x(e0(ax5Var));
            l07.d(ax5Var);
            autoVideoCardViewHolder.g(ax5Var);
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

    public void j0(dx6 dx6Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, dx6Var) == null) {
            this.m = dx6Var;
        }
    }

    public void k0(pn pnVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, pnVar) == null) {
            this.k = pnVar;
        }
    }

    public void onPause() {
        fy fyVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048585, this) == null) || (fyVar = this.l) == null) {
            return;
        }
        fyVar.r();
    }
}
