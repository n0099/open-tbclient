package d.a.q0.u0.m1.d;

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
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.CommonStatisticKey;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.ThreadCardUtils;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.view.ThreadGodReplyLayout;
import com.baidu.tieba.R;
import com.baidu.tieba.card.data.BaseCardInfo;
import com.baidu.tieba.tbadkCore.FrsViewData;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import d.a.k.a;
import d.a.k.l0;
import d.a.k.t0;
import d.a.k.v0.a;
import d.a.p0.s.q.a2;
import d.a.p0.s.q.b2;
/* loaded from: classes8.dex */
public class z extends d.a.q0.u0.k<a2, AutoVideoCardViewHolder<b2>> implements d.a.q0.a0.z, d.a.q0.u0.j2.d, d.a.q0.o.f, d.a.q0.a0.a0 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public int A;
    public d.a.q0.u0.j2.b B;
    public d.a.q0.a0.b0<b2> C;
    public TbPageContext<?> x;
    public String y;
    public String z;

    /* loaded from: classes8.dex */
    public class a extends d.a.q0.a0.b0<b2> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ z f63802b;

        public a(z zVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {zVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f63802b = zVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.a.q0.a0.b0
        /* renamed from: d */
        public void a(View view, b2 b2Var) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, view, b2Var) == null) || view == null || b2Var == null) {
                return;
            }
            if (this.f63802b.u != null) {
                this.f63802b.u.b(view, b2Var, b2.r3);
            }
            if ("c13010".equals(this.f63802b.z)) {
                TiebaStatic.log(new StatisticItem("c13010").param("obj_type", 2).param("fid", b2Var.R()).param("tid", b2Var.o1()));
            }
            if (view.getId() == R.id.thread_card_root && b2Var.s2()) {
                d.a.q0.u0.j2.c.j().g(this.f63802b.B, b2Var, 1);
                this.f63802b.T0(b2Var);
            } else if (view.getId() == R.id.card_home_page_normal_thread_user_icon) {
                TiebaStatic.log(new StatisticItem(CommonStatisticKey.USER_ICON_VISIT).param("obj_type", 3));
            } else if (view.getId() == R.id.user_name || view.getId() == R.id.user_avatar) {
                d.a.q0.u0.j2.c.j().g(this.f63802b.B, b2Var, 2);
            } else if (view.getId() == R.id.header_divider) {
                d.a.q0.u0.n2.l.a(this.f63802b.B, b2Var.getRecomReason());
            } else if (view.getId() == R.id.operable_video_container) {
                d.a.q0.u0.j2.c.j().g(this.f63802b.B, b2Var, 4);
                this.f63802b.T0(b2Var);
            } else if (view instanceof ThreadGodReplyLayout) {
                this.f63802b.T0(b2Var);
            }
            if (view.getId() == R.id.operable_video_container) {
                d.a.q0.u0.j2.a.e(b2Var, 4, this.f63802b.f42345i, this.f63802b.B, this.f63802b.f0());
                d.a.q0.u0.n2.l.g(b2Var, this.f63802b.n, 2);
            } else if (view.getId() == R.id.video_play) {
                d.a.q0.u0.j2.a.e(b2Var, 4, this.f63802b.f42345i, this.f63802b.B, this.f63802b.f0());
                d.a.q0.u0.n2.l.g(b2Var, this.f63802b.n, 1);
            } else if (view.getId() != R.id.user_name && view.getId() != R.id.user_avatar) {
                if (view.getId() == R.id.thread_info_commont_container) {
                    d.a.q0.u0.j2.a.e(b2Var, 5, this.f63802b.f42345i, this.f63802b.B, this.f63802b.f0());
                    d.a.q0.u0.n2.l.g(b2Var, this.f63802b.n, 1);
                } else if (view instanceof ThreadGodReplyLayout) {
                    d.a.q0.u0.j2.a.e(b2Var, 15, this.f63802b.f42345i, this.f63802b.B, this.f63802b.f0());
                    d.a.q0.u0.n2.l.g(b2Var, this.f63802b.n, 1);
                } else if (view.getId() != R.id.share_num_container) {
                    d.a.q0.u0.n2.l.g(b2Var, this.f63802b.n, 1);
                    d.a.q0.u0.j2.a.e(b2Var, 1, this.f63802b.f42345i, this.f63802b.B, this.f63802b.f0());
                } else {
                    d.a.q0.u0.j2.a.e(b2Var, 14, this.f63802b.f42345i, this.f63802b.B, this.f63802b.f0());
                }
            } else {
                d.a.q0.u0.j2.a.e(b2Var, 2, this.f63802b.f42345i, this.f63802b.B, this.f63802b.f0());
            }
        }
    }

    /* loaded from: classes8.dex */
    public class b implements a.InterfaceC0618a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ t0 f63803a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ z f63804b;

        public b(z zVar, t0 t0Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {zVar, t0Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f63804b = zVar;
            this.f63803a = t0Var;
        }

        @Override // d.a.k.a.InterfaceC0618a
        public void a(d.a.p0.s.q.a aVar) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, aVar) == null) || aVar == null) {
                return;
            }
            Rect computeViewArea = ThreadCardUtils.computeViewArea(this.f63803a.getVideoContainer());
            if (!(aVar instanceof b2)) {
                ThreadCardUtils.jumpToPB(aVar, this.f63804b.f42341e, this.f63804b.A, false, computeViewArea);
                return;
            }
            aVar.objType = 5;
            ThreadCardUtils.jumpToPB(aVar, this.f63804b.f42341e, this.f63804b.A, false, computeViewArea);
        }
    }

    /* loaded from: classes8.dex */
    public class c implements d.a.d.k.e.w {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ z f63805e;

        public c(z zVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {zVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f63805e = zVar;
        }

        @Override // d.a.d.k.e.w
        public void b(View view, d.a.d.k.e.n nVar, BdUniqueId bdUniqueId, ViewGroup viewGroup, int i2, long j) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{view, nVar, bdUniqueId, viewGroup, Integer.valueOf(i2), Long.valueOf(j)}) == null) && (nVar instanceof a2) && (view.getTag() instanceof ThreadCardViewHolder)) {
                ThreadCardViewHolder threadCardViewHolder = (ThreadCardViewHolder) view.getTag();
                b2 b2Var = ((a2) nVar).w;
                b2Var.objType = 1;
                if (this.f63805e.C != null) {
                    this.f63805e.C.a(threadCardViewHolder.a(), b2Var);
                }
                ThreadCardUtils.jumpToPB((d.a.p0.s.q.a) b2Var, view.getContext(), this.f63805e.A, false, d.a.k.e.a((d.a.d.k.e.s) viewGroup, view, i2));
                threadCardViewHolder.b().o(new a.C0620a(1));
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public z(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId, BdUniqueId bdUniqueId2) {
        super(tbPageContext, bdUniqueId, bdUniqueId2);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {tbPageContext, bdUniqueId, bdUniqueId2};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((TbPageContext) objArr2[0], (BdUniqueId) objArr2[1], (BdUniqueId) objArr2[2]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.A = 3;
        this.B = new d.a.q0.u0.j2.b();
        this.C = new a(this);
        this.x = tbPageContext;
    }

    public final d.a.q0.n2.o Q0(b2 b2Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, b2Var)) == null) {
            if (b2Var == null) {
                return null;
            }
            d.a.q0.n2.o oVar = new d.a.q0.n2.o();
            oVar.f61423a = b2Var.O1() ? "3" : "2";
            if (this.B.f63602d == 501) {
                oVar.f61423a = "frs_tab";
            }
            oVar.f61426d = this.B.f63601c;
            oVar.f61425c = b2Var.o1();
            oVar.f61428f = b2Var.T0;
            oVar.f61429g = b2Var.X0;
            oVar.f61430h = b2Var.U0;
            oVar.l = b2Var.V0;
            if (b2Var.m1() != null) {
                oVar.m = b2Var.m1().video_md5;
            }
            return oVar;
        }
        return (d.a.q0.n2.o) invokeL.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.a.d.k.e.a
    /* renamed from: R0 */
    public AutoVideoCardViewHolder Q(ViewGroup viewGroup) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, viewGroup)) == null) {
            l0.b bVar = new l0.b(this.x.getPageActivity(), false);
            d.a.k.g gVar = new d.a.k.g(this.x.getPageActivity(), true);
            gVar.u("frs");
            gVar.y("2003");
            gVar.v(new b(this, gVar));
            if (this.A == 502) {
                gVar.w(false);
            } else {
                gVar.w(true);
            }
            bVar.n(gVar);
            l0 k = bVar.k(BaseCardInfo.SupportType.CONTENT, viewGroup, this.q);
            AutoVideoCardViewHolder autoVideoCardViewHolder = new AutoVideoCardViewHolder(k);
            autoVideoCardViewHolder.j(this.f42345i);
            k.p(this.C);
            k.r(this.A);
            a0(new c(this));
            autoVideoCardViewHolder.n(false);
            return autoVideoCardViewHolder;
        }
        return (AutoVideoCardViewHolder) invokeL.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.a.q0.u0.k, d.a.d.k.e.a
    /* renamed from: S0 */
    public View X(int i2, View view, ViewGroup viewGroup, a2 a2Var, AutoVideoCardViewHolder<b2> autoVideoCardViewHolder) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048579, this, new Object[]{Integer.valueOf(i2), view, viewGroup, a2Var, autoVideoCardViewHolder})) == null) {
            if (autoVideoCardViewHolder == null) {
                return null;
            }
            if (a2Var == null) {
                return autoVideoCardViewHolder.a();
            }
            if (autoVideoCardViewHolder.b() instanceof d.a.q0.o.e) {
                autoVideoCardViewHolder.b().setPage(this.y);
            }
            super.X(i2, view, viewGroup, a2Var, autoVideoCardViewHolder);
            d.a.q0.u0.j.g(autoVideoCardViewHolder.b().e(), this.n);
            autoVideoCardViewHolder.u(Q0(a2Var.w));
            autoVideoCardViewHolder.b().q(i2);
            FrsViewData frsViewData = this.n;
            if (frsViewData != null && frsViewData.getForum() != null && !StringUtils.isNull(this.n.getForum().getTopic_special_icon()) && !StringUtils.isNull(this.n.getForum().getTopic_special_icon_right())) {
                a2Var.w.d4(this.n.getForum().getTopic_special_icon(), this.n.getForum().getTopic_special_icon_right());
            }
            autoVideoCardViewHolder.f(a2Var.w);
            autoVideoCardViewHolder.b().onChangeSkinType(this.x, TbadkCoreApplication.getInst().getSkinType());
            autoVideoCardViewHolder.b().p(this.C);
            if (this.B != null) {
                FrsViewData frsViewData2 = this.n;
                a2Var.w.P1 = (a2Var.position + 1) - (frsViewData2 != null ? frsViewData2.getTopThreadSize() : 0);
            }
            d.a.q0.u0.j2.c.j().c(this.B, a2Var.w);
            d.a.q0.u0.j2.c.j().b(a2Var.w);
            d.a.q0.u0.j2.c.j().e(a2Var.w, g0());
            d.a.q0.u0.j2.a.m(a2Var.w, this.f42345i, this.B, f0());
            FrsViewData frsViewData3 = this.n;
            if (frsViewData3 != null && frsViewData3.getForum() != null) {
                d.a.q0.u0.j2.a.l(a2Var.w, this.n.getForum().getId());
            }
            a2Var.w.t4();
            return autoVideoCardViewHolder.a();
        }
        return (View) invokeCommon.objValue;
    }

    public final void T0(b2 b2Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, b2Var) == null) {
            TiebaStatic.log(new StatisticItem("c12126").param("tid", b2Var.d0()).param("obj_locate", g0() ? 2 : 1).param("obj_id", b2Var.h1() == null ? -1L : b2Var.h1().live_id).param("obj_type", 1));
        }
    }

    @Override // d.a.q0.a0.z
    public void a(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, str) == null) {
        }
    }

    @Override // d.a.q0.o.f
    public void g(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, str) == null) {
            this.y = str;
        }
    }

    @Override // d.a.q0.u0.j2.d
    public d.a.q0.u0.j2.b j() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) ? this.B : (d.a.q0.u0.j2.b) invokeV.objValue;
    }

    @Override // d.a.q0.a0.a0
    public void l(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048585, this, z) == null) {
        }
    }

    @Override // d.a.q0.a0.z
    public void r(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048586, this, i2) == null) {
            this.A = i2;
        }
    }

    @Override // d.a.q0.u0.k, d.a.q0.a0.y
    public void setFrom(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048587, this, str) == null) {
            this.z = str;
        }
    }
}
