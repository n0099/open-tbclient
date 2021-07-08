package d.a.p0.u0.m1.d;

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
import d.a.j.a;
import d.a.j.l0;
import d.a.j.t0;
import d.a.j.v0.a;
import d.a.o0.r.q.a2;
import d.a.o0.r.q.b2;
/* loaded from: classes8.dex */
public class z extends d.a.p0.u0.k<a2, AutoVideoCardViewHolder<b2>> implements d.a.p0.a0.z, d.a.p0.u0.j2.d, d.a.p0.o.f, d.a.p0.a0.a0 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public int A;
    public d.a.p0.u0.j2.b B;
    public d.a.p0.a0.b0<b2> C;
    public TbPageContext<?> x;
    public String y;
    public String z;

    /* loaded from: classes8.dex */
    public class a extends d.a.p0.a0.b0<b2> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ z f63159b;

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
            this.f63159b = zVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.a.p0.a0.b0
        /* renamed from: d */
        public void a(View view, b2 b2Var) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, view, b2Var) == null) || view == null || b2Var == null) {
                return;
            }
            if (this.f63159b.u != null) {
                this.f63159b.u.b(view, b2Var, b2.l3);
            }
            if ("c13010".equals(this.f63159b.z)) {
                TiebaStatic.log(new StatisticItem("c13010").param("obj_type", 2).param("fid", b2Var.Q()).param("tid", b2Var.n1()));
            }
            if (view.getId() == R.id.thread_card_root && b2Var.q2()) {
                d.a.p0.u0.j2.c.j().g(this.f63159b.B, b2Var, 1);
                this.f63159b.O0(b2Var);
            } else if (view.getId() == R.id.card_home_page_normal_thread_user_icon) {
                TiebaStatic.log(new StatisticItem(CommonStatisticKey.USER_ICON_VISIT).param("obj_type", 3));
            } else if (view.getId() == R.id.user_name || view.getId() == R.id.user_avatar) {
                d.a.p0.u0.j2.c.j().g(this.f63159b.B, b2Var, 2);
            } else if (view.getId() == R.id.header_divider) {
                d.a.p0.u0.n2.l.a(this.f63159b.B, b2Var.getRecomReason());
            } else if (view.getId() == R.id.operable_video_container) {
                d.a.p0.u0.j2.c.j().g(this.f63159b.B, b2Var, 4);
                this.f63159b.O0(b2Var);
            } else if (view instanceof ThreadGodReplyLayout) {
                this.f63159b.O0(b2Var);
            }
            if (view.getId() == R.id.operable_video_container) {
                d.a.p0.u0.j2.a.c(b2Var, 4, this.f63159b.f41841i, this.f63159b.B, this.f63159b.g0());
            } else if (view.getId() == R.id.video_play) {
                d.a.p0.u0.j2.a.c(b2Var, 4, this.f63159b.f41841i, this.f63159b.B, this.f63159b.g0());
            } else if (view.getId() != R.id.user_name && view.getId() != R.id.user_avatar) {
                if (view.getId() == R.id.thread_info_commont_container) {
                    d.a.p0.u0.j2.a.c(b2Var, 5, this.f63159b.f41841i, this.f63159b.B, this.f63159b.g0());
                } else if (view instanceof ThreadGodReplyLayout) {
                    d.a.p0.u0.j2.a.c(b2Var, 15, this.f63159b.f41841i, this.f63159b.B, this.f63159b.g0());
                } else if (view.getId() == R.id.share_num_container) {
                    d.a.p0.u0.j2.a.c(b2Var, 14, this.f63159b.f41841i, this.f63159b.B, this.f63159b.g0());
                } else {
                    d.a.p0.u0.j2.a.c(b2Var, 1, this.f63159b.f41841i, this.f63159b.B, this.f63159b.g0());
                }
            } else {
                d.a.p0.u0.j2.a.c(b2Var, 2, this.f63159b.f41841i, this.f63159b.B, this.f63159b.g0());
            }
        }
    }

    /* loaded from: classes8.dex */
    public class b implements a.InterfaceC0609a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ t0 f63160a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ z f63161b;

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
            this.f63161b = zVar;
            this.f63160a = t0Var;
        }

        @Override // d.a.j.a.InterfaceC0609a
        public void a(d.a.o0.r.q.a aVar) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, aVar) == null) || aVar == null) {
                return;
            }
            Rect computeViewArea = ThreadCardUtils.computeViewArea(this.f63160a.getVideoContainer());
            if (!(aVar instanceof b2)) {
                ThreadCardUtils.jumpToPB(aVar, this.f63161b.f41837e, this.f63161b.A, false, computeViewArea);
                return;
            }
            aVar.objType = 5;
            ThreadCardUtils.jumpToPB(aVar, this.f63161b.f41837e, this.f63161b.A, false, computeViewArea);
        }
    }

    /* loaded from: classes8.dex */
    public class c implements d.a.c.k.e.w {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ z f63162e;

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
            this.f63162e = zVar;
        }

        @Override // d.a.c.k.e.w
        public void b(View view, d.a.c.k.e.n nVar, BdUniqueId bdUniqueId, ViewGroup viewGroup, int i2, long j) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{view, nVar, bdUniqueId, viewGroup, Integer.valueOf(i2), Long.valueOf(j)}) == null) && (nVar instanceof a2) && (view.getTag() instanceof ThreadCardViewHolder)) {
                ThreadCardViewHolder threadCardViewHolder = (ThreadCardViewHolder) view.getTag();
                b2 b2Var = ((a2) nVar).w;
                b2Var.objType = 1;
                if (this.f63162e.C != null) {
                    this.f63162e.C.a(threadCardViewHolder.a(), b2Var);
                }
                ThreadCardUtils.jumpToPB((d.a.o0.r.q.a) b2Var, view.getContext(), this.f63162e.A, false, d.a.j.e.a((d.a.c.k.e.s) viewGroup, view, i2));
                threadCardViewHolder.b().o(new a.C0611a(1));
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
        this.B = new d.a.p0.u0.j2.b();
        this.C = new a(this);
        this.x = tbPageContext;
    }

    public final d.a.p0.n2.o L0(b2 b2Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, b2Var)) == null) {
            if (b2Var == null) {
                return null;
            }
            d.a.p0.n2.o oVar = new d.a.p0.n2.o();
            oVar.f60809a = b2Var.N1() ? "3" : "2";
            if (this.B.f62959d == 501) {
                oVar.f60809a = "frs_tab";
            }
            oVar.f60812d = this.B.f62958c;
            oVar.f60811c = b2Var.n1();
            oVar.f60814f = b2Var.T0;
            oVar.f60815g = b2Var.X0;
            oVar.f60816h = b2Var.U0;
            oVar.l = b2Var.V0;
            if (b2Var.l1() != null) {
                oVar.m = b2Var.l1().video_md5;
            }
            return oVar;
        }
        return (d.a.p0.n2.o) invokeL.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.a.c.k.e.a
    /* renamed from: M0 */
    public AutoVideoCardViewHolder Q(ViewGroup viewGroup) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, viewGroup)) == null) {
            l0.b bVar = new l0.b(this.x.getPageActivity(), false);
            d.a.j.g gVar = new d.a.j.g(this.x.getPageActivity(), true);
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
            autoVideoCardViewHolder.j(this.f41841i);
            k.p(this.C);
            k.r(this.A);
            a0(new c(this));
            autoVideoCardViewHolder.n(false);
            return autoVideoCardViewHolder;
        }
        return (AutoVideoCardViewHolder) invokeL.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.a.p0.u0.k, d.a.c.k.e.a
    /* renamed from: N0 */
    public View X(int i2, View view, ViewGroup viewGroup, a2 a2Var, AutoVideoCardViewHolder<b2> autoVideoCardViewHolder) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(Constants.METHOD_SEND_USER_MSG, this, new Object[]{Integer.valueOf(i2), view, viewGroup, a2Var, autoVideoCardViewHolder})) == null) {
            if (autoVideoCardViewHolder == null) {
                return null;
            }
            if (a2Var == null) {
                return autoVideoCardViewHolder.a();
            }
            if (autoVideoCardViewHolder.b() instanceof d.a.p0.o.e) {
                autoVideoCardViewHolder.b().setPage(this.y);
            }
            super.X(i2, view, viewGroup, a2Var, autoVideoCardViewHolder);
            d.a.p0.u0.j.g(autoVideoCardViewHolder.b().e(), this.n);
            autoVideoCardViewHolder.u(L0(a2Var.w));
            autoVideoCardViewHolder.b().q(i2);
            FrsViewData frsViewData = this.n;
            if (frsViewData != null && frsViewData.getForum() != null && !StringUtils.isNull(this.n.getForum().getTopic_special_icon()) && !StringUtils.isNull(this.n.getForum().getTopic_special_icon_right())) {
                a2Var.w.a4(this.n.getForum().getTopic_special_icon(), this.n.getForum().getTopic_special_icon_right());
            }
            autoVideoCardViewHolder.f(a2Var.w);
            autoVideoCardViewHolder.b().onChangeSkinType(this.x, TbadkCoreApplication.getInst().getSkinType());
            autoVideoCardViewHolder.b().p(this.C);
            if (this.B != null) {
                FrsViewData frsViewData2 = this.n;
                a2Var.w.P1 = (a2Var.position + 1) - (frsViewData2 != null ? frsViewData2.getTopThreadSize() : 0);
            }
            d.a.p0.u0.j2.c.j().c(this.B, a2Var.w);
            d.a.p0.u0.j2.c.j().b(a2Var.w);
            d.a.p0.u0.j2.c.j().e(a2Var.w, h0());
            d.a.p0.u0.j2.a.j(a2Var.w, this.f41841i, this.B, g0());
            a2Var.w.q4();
            return autoVideoCardViewHolder.a();
        }
        return (View) invokeCommon.objValue;
    }

    public final void O0(b2 b2Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, b2Var) == null) {
            TiebaStatic.log(new StatisticItem("c12126").param("tid", b2Var.c0()).param("obj_locate", h0() ? 2 : 1).param("obj_id", b2Var.g1() == null ? -1L : b2Var.g1().live_id).param("obj_type", 1));
        }
    }

    @Override // d.a.p0.a0.z
    public void a(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, str) == null) {
        }
    }

    @Override // d.a.p0.o.f
    public void g(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, str) == null) {
            this.y = str;
        }
    }

    @Override // d.a.p0.u0.j2.d
    public d.a.p0.u0.j2.b j() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) ? this.B : (d.a.p0.u0.j2.b) invokeV.objValue;
    }

    @Override // d.a.p0.a0.a0
    public void l(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048585, this, z) == null) {
        }
    }

    @Override // d.a.p0.a0.z
    public void r(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048586, this, i2) == null) {
            this.A = i2;
        }
    }

    @Override // d.a.p0.u0.k, d.a.p0.a0.y
    public void setFrom(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048587, this, str) == null) {
            this.z = str;
        }
    }
}
