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
/* loaded from: classes5.dex */
public class ds6 extends wm<ax5, AutoVideoCardViewHolder<ax5>> implements ci5 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public BdUniqueId i;
    public BdUniqueId j;
    public TbPageContext<?> k;
    public String l;
    public pn m;
    public fy n;
    public nw5<ax5> o;

    /* loaded from: classes5.dex */
    public class a extends nw5<ax5> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ds6 b;

        public a(ds6 ds6Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ds6Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = ds6Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.repackage.nw5
        /* renamed from: d */
        public void a(View view2, ax5 ax5Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, view2, ax5Var) == null) {
                gw5.b().d(true);
                ai5.c().h("page_recommend", "show_");
                if (ax5Var == null || ax5Var.getThreadData() == null || StringUtils.isNull(ax5Var.getThreadData().getTid())) {
                    return;
                }
                if (ax5Var.getThreadData().middle_page_num <= 0) {
                    this.b.e0(view2, ax5Var);
                    return;
                }
                TbSingleton.getInstance().setCurrentClickTime(TiebaStatic.logWithBackTime(ax5Var.N(ax5Var.getThreadData())));
            }
        }
    }

    /* loaded from: classes5.dex */
    public class b implements mw.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ fy a;
        public final /* synthetic */ ds6 b;

        public b(ds6 ds6Var, fy fyVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ds6Var, fyVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = ds6Var;
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
                ThreadCardUtils.jumpToPB(om4Var, this.b.a, 1, false, computeViewArea);
                return;
            }
            om4Var.objType = 5;
            ThreadCardUtils.jumpToPB(om4Var, this.b.a, 1, false, computeViewArea);
        }
    }

    /* loaded from: classes5.dex */
    public class c implements tn {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ds6 a;

        public c(ds6 ds6Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ds6Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = ds6Var;
        }

        @Override // com.repackage.tn
        public void b(View view2, jn jnVar, BdUniqueId bdUniqueId, ViewGroup viewGroup, int i, long j) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{view2, jnVar, bdUniqueId, viewGroup, Integer.valueOf(i), Long.valueOf(j)}) == null) && (jnVar instanceof cn) && (view2.getTag() instanceof ThreadCardViewHolder)) {
                cn cnVar = (cn) jnVar;
                if (cnVar.e() instanceof ax5) {
                    ThreadCardViewHolder threadCardViewHolder = (ThreadCardViewHolder) view2.getTag();
                    ax5 ax5Var = (ax5) cnVar.e();
                    ax5Var.f = 1;
                    if (this.a.o != null) {
                        this.a.o.a(threadCardViewHolder.b(), ax5Var);
                    }
                    ThreadCardUtils.jumpToPB((om4) ax5Var, view2.getContext(), 1, false, qw.a((pn) viewGroup, view2, i));
                    threadCardViewHolder.c().o(new iy.a(1));
                }
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ds6(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId, BdUniqueId bdUniqueId2) {
        super(tbPageContext.getPageActivity(), bdUniqueId);
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
                super((Context) objArr2[0], (BdUniqueId) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.o = new a(this);
        this.k = tbPageContext;
        this.j = bdUniqueId2;
    }

    public final t48 d0(ax5 ax5Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, ax5Var)) == null) {
            if (ax5Var != null) {
                t48 t48Var = new t48();
                t48Var.a = "7";
                t48Var.c = ax5Var.g;
                if (ax5Var.getThreadData() != null) {
                    t48Var.d = String.valueOf(ax5Var.getThreadData().getFid());
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
                return t48Var;
            }
            return null;
        }
        return (t48) invokeL.objValue;
    }

    public final void e0(View view2, ax5 ax5Var) {
        fy fyVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048581, this, view2, ax5Var) == null) || (fyVar = this.n) == null || fyVar.o() == null || this.n.o().getMainView() == null) {
            return;
        }
        if (view2.getId() == this.n.o().getMainView().getId()) {
            er6.b(view2, ax5Var, 4);
        } else if (view2.getId() == R.id.obfuscated_res_0x7f091f85) {
            er6.b(view2, ax5Var, 2);
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.repackage.wm
    /* renamed from: f0 */
    public AutoVideoCardViewHolder<ax5> J(ViewGroup viewGroup, ax5 ax5Var) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048582, this, viewGroup, ax5Var)) == null) {
            xx.b bVar = new xx.b(this.k.getPageActivity(), false);
            ox6 ox6Var = new ox6(this.k.getPageActivity());
            ox6Var.w(this.i);
            ox6Var.t("concern_tab");
            ox6Var.u(new b(this, ox6Var));
            this.n = ox6Var;
            bVar.n(ox6Var);
            fy fyVar = this.n;
            if (fyVar != null) {
                fyVar.x("2001");
            }
            xx k = bVar.k(BaseCardInfo.SupportType.CONTENT, viewGroup, this.m);
            AutoVideoCardViewHolder<ax5> autoVideoCardViewHolder = new AutoVideoCardViewHolder<>(k);
            autoVideoCardViewHolder.k(this.i);
            k.p(this.o);
            k.r(1);
            V(new c(this));
            return autoVideoCardViewHolder;
        }
        return (AutoVideoCardViewHolder) invokeLL.objValue;
    }

    @Override // com.repackage.ci5
    public void g(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, str) == null) {
            this.l = str;
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.repackage.wm
    /* renamed from: g0 */
    public AutoVideoCardViewHolder<ax5> M(ViewGroup viewGroup) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, viewGroup)) == null) {
            return null;
        }
        return (AutoVideoCardViewHolder) invokeL.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.repackage.wm
    /* renamed from: h0 */
    public View P(int i, View view2, ViewGroup viewGroup, ax5 ax5Var, AutoVideoCardViewHolder<ax5> autoVideoCardViewHolder) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048585, this, new Object[]{Integer.valueOf(i), view2, viewGroup, ax5Var, autoVideoCardViewHolder})) == null) {
            if (ax5Var == null) {
                return autoVideoCardViewHolder.b();
            }
            if (autoVideoCardViewHolder == null) {
                return null;
            }
            ax5Var.I(ax5Var.position + 1);
            gw5.b().a(ax5Var.g("c12351"));
            autoVideoCardViewHolder.c().q(i);
            ax5Var.T = 0;
            autoVideoCardViewHolder.x(d0(ax5Var));
            if (autoVideoCardViewHolder.c() instanceof bi5) {
                autoVideoCardViewHolder.c().b(this.l);
            }
            autoVideoCardViewHolder.g(ax5Var);
            autoVideoCardViewHolder.c().onChangeSkinType(this.k, TbadkCoreApplication.getInst().getSkinType());
            autoVideoCardViewHolder.c().p(this.o);
            return autoVideoCardViewHolder.b();
        }
        return (View) invokeCommon.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.repackage.wm
    /* renamed from: i0 */
    public View S(int i, View view2, ViewGroup viewGroup, ax5 ax5Var, AutoVideoCardViewHolder<ax5> autoVideoCardViewHolder) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048586, this, new Object[]{Integer.valueOf(i), view2, viewGroup, ax5Var, autoVideoCardViewHolder})) == null) {
            return null;
        }
        return (View) invokeCommon.objValue;
    }

    public void j0(pn pnVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048587, this, pnVar) == null) {
            this.m = pnVar;
        }
    }

    @Override // com.repackage.wm
    public BdUniqueId v() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) ? rw5.M : (BdUniqueId) invokeV.objValue;
    }

    @Override // com.repackage.wm
    public BdUniqueId w() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) ? rw5.J : (BdUniqueId) invokeV.objValue;
    }

    @Override // com.repackage.wm
    public BdUniqueId x() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048590, this)) == null) ? rw5.L : (BdUniqueId) invokeV.objValue;
    }

    @Override // com.repackage.wm
    public BdUniqueId y() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048591, this)) == null) {
            BdUniqueId bdUniqueId = this.j;
            return bdUniqueId != null ? bdUniqueId : rw5.D;
        }
        return (BdUniqueId) invokeV.objValue;
    }
}
