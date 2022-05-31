package com.repackage;

import android.content.Context;
import android.graphics.Rect;
import android.view.View;
import android.view.ViewGroup;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.card.AutoVideoCardViewHolder;
import com.baidu.card.ThreadCardViewHolder;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.TbSingleton;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.ThreadCardUtils;
import com.baidu.tbadk.core.util.TiebaStatic;
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
/* loaded from: classes6.dex */
public class hw6 extends wm<ax5, AutoVideoCardViewHolder<ax5>> implements ci5 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public BdUniqueId i;
    public TbPageContext<?> j;
    public dx6 k;
    public String l;
    public pn m;
    public fy n;
    public nw5<ax5> o;

    /* loaded from: classes6.dex */
    public class a extends nw5<ax5> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ hw6 b;

        public a(hw6 hw6Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {hw6Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = hw6Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.repackage.nw5
        /* renamed from: d */
        public void a(View view2, ax5 ax5Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, view2, ax5Var) == null) {
                gw5.b().d(true);
                ai5.c().h("page_recommend", "show_");
                if (this.b.k == null || ax5Var == null || ax5Var.getThreadData() == null || StringUtils.isNull(ax5Var.getThreadData().getTid())) {
                    return;
                }
                if (ax5Var.getThreadData().middle_page_num > 0) {
                    TbSingleton.getInstance().setCurrentClickTime(TiebaStatic.logWithBackTime(ax5Var.N(ax5Var.getThreadData())));
                    return;
                }
                if ((view2.getTag() instanceof String) && !gv6.b(jg.g(ax5Var.getThreadData().getTid(), 0L))) {
                    gv6.a(jg.g(ax5Var.getThreadData().getTid(), 0L));
                    this.b.k.e(jg.g(ax5Var.getThreadData().getTid(), 0L), ax5Var.D(), ax5Var.r(), ax5Var.q(), ax5Var.e(), jg.e((String) view2.getTag(), 1), "homepage", ax5Var.getThreadData().getBaijiahaoData());
                }
                this.b.f0(view2, ax5Var);
                TbSingleton.getInstance().saveHomeRecommendItemClickTime();
            }
        }
    }

    /* loaded from: classes6.dex */
    public class b implements mw.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ fy a;
        public final /* synthetic */ hw6 b;

        public b(hw6 hw6Var, fy fyVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {hw6Var, fyVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = hw6Var;
            this.a = fyVar;
        }

        @Override // com.repackage.mw.a
        public void a(om4 om4Var) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, om4Var) == null) || om4Var == null) {
                return;
            }
            Rect computeViewArea = ThreadCardUtils.computeViewArea(this.a.getVideoContainer());
            if (!(om4Var instanceof ax5)) {
                ThreadCardUtils.jumpToPB(om4Var, this.b.a, 2, false, computeViewArea);
                return;
            }
            om4Var.objType = 5;
            ThreadCardUtils.jumpToPB(om4Var, this.b.a, 2, false, computeViewArea);
        }
    }

    /* loaded from: classes6.dex */
    public class c implements tn {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ hw6 a;

        public c(hw6 hw6Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {hw6Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = hw6Var;
        }

        @Override // com.repackage.tn
        public void b(View view2, jn jnVar, BdUniqueId bdUniqueId, ViewGroup viewGroup, int i, long j) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{view2, jnVar, bdUniqueId, viewGroup, Integer.valueOf(i), Long.valueOf(j)}) == null) && (jnVar instanceof ax5) && (view2.getTag() instanceof ThreadCardViewHolder)) {
                AutoVideoCardViewHolder autoVideoCardViewHolder = (AutoVideoCardViewHolder) view2.getTag();
                ax5 ax5Var = (ax5) jnVar;
                ax5Var.f = 1;
                if (this.a.o != null) {
                    this.a.o.a(autoVideoCardViewHolder.b(), ax5Var);
                }
                ThreadCardUtils.jumpToPB((om4) ax5Var, view2.getContext(), 2, false, qw.a((pn) viewGroup, view2, i));
                autoVideoCardViewHolder.c().o(new iy.a(1));
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public hw6(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId) {
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
        this.j = tbPageContext;
        g0();
    }

    public final t48 e0(ax5 ax5Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, ax5Var)) == null) {
            if (ax5Var != null) {
                t48 t48Var = new t48();
                t48Var.a = "1";
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
        if (!(interceptable == null || interceptable.invokeLL(1048579, this, view2, ax5Var) == null) || (fyVar = this.n) == null || fyVar.o() == null || this.n.o().getMainView() == null) {
            return;
        }
        if (view2.getId() == this.n.o().getMainView().getId()) {
            jx6.d(ax5Var.a, this.i, ax5Var.q(), 4);
            TbSingleton.getInstance().setCurrentClickTime(TiebaStatic.logWithBackTime(ax5Var.P()));
            jx6.c(ax5Var.a, ax5Var.r(), ax5Var.q(), 2);
        } else if (view2.getId() == R.id.obfuscated_res_0x7f091f85) {
            TbSingleton.getInstance().setCurrentClickTime(TiebaStatic.logWithBackTime(ax5Var.N(ax5Var.a)));
            jx6.c(ax5Var.a, ax5Var.r(), ax5Var.q(), 1);
        }
    }

    @Override // com.repackage.ci5
    public void g(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, str) == null) {
            this.l = str;
        }
    }

    public final void g0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            ax5.V = "c10708";
            ax5.W = "c10735";
            ax5.X = "c10709";
            ax5.Y = "c10734";
            ax5.Z = "c11929";
            ax5.g0 = "c11928";
            ax5.h0 = "c10756";
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.repackage.wm
    /* renamed from: h0 */
    public AutoVideoCardViewHolder<ax5> M(ViewGroup viewGroup) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048582, this, viewGroup)) == null) {
            xx.b bVar = new xx.b(this.j.getPageActivity(), false);
            ox6 ox6Var = new ox6(this.j.getPageActivity());
            ox6Var.u(new b(this, ox6Var));
            this.n = ox6Var;
            ox6Var.w(this.i);
            this.n.t("index");
            this.n.x("2001");
            bVar.n(this.n);
            xx k = bVar.k(BaseCardInfo.SupportType.CONTENT, viewGroup, this.m);
            AutoVideoCardViewHolder<ax5> autoVideoCardViewHolder = new AutoVideoCardViewHolder<>(k);
            autoVideoCardViewHolder.k(this.i);
            k.p(this.o);
            k.r(2);
            V(new c(this));
            return autoVideoCardViewHolder;
        }
        return (AutoVideoCardViewHolder) invokeL.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.repackage.wm
    /* renamed from: i0 */
    public View S(int i, View view2, ViewGroup viewGroup, ax5 ax5Var, AutoVideoCardViewHolder<ax5> autoVideoCardViewHolder) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048583, this, new Object[]{Integer.valueOf(i), view2, viewGroup, ax5Var, autoVideoCardViewHolder})) == null) {
            if (ax5Var == null) {
                return autoVideoCardViewHolder.b();
            }
            if (autoVideoCardViewHolder == null) {
                return null;
            }
            ax5Var.I(ax5Var.position + 1);
            ax5Var.a.statFloor = ax5Var.q();
            autoVideoCardViewHolder.c().q(i);
            ax5Var.T = 0;
            gw5.b().a(ax5Var.B());
            autoVideoCardViewHolder.x(e0(ax5Var));
            if (autoVideoCardViewHolder.c() != null) {
                autoVideoCardViewHolder.c().b(this.l);
            }
            autoVideoCardViewHolder.g(ax5Var);
            autoVideoCardViewHolder.c().onChangeSkinType(this.j, TbadkCoreApplication.getInst().getSkinType());
            autoVideoCardViewHolder.c().p(this.o);
            jx6.h(ax5Var.a, this.i, ax5Var.q());
            jx6.g(ax5Var.a, ax5Var.r(), ax5Var.q());
            return autoVideoCardViewHolder.b();
        }
        return (View) invokeCommon.objValue;
    }

    public void j0(dx6 dx6Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, dx6Var) == null) {
            this.k = dx6Var;
        }
    }

    public void k0(pn pnVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048585, this, pnVar) == null) {
            this.m = pnVar;
        }
    }

    public void onPause() {
        fy fyVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048586, this) == null) || (fyVar = this.n) == null) {
            return;
        }
        fyVar.r();
    }

    public void onResume() {
        fy fyVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048587, this) == null) || (fyVar = this.n) == null) {
            return;
        }
        fyVar.s();
    }
}
