package d.a.q0.e1.h.h;

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
import d.a.k.a;
import d.a.k.l0;
import d.a.k.t0;
import d.a.k.v0.a;
/* loaded from: classes8.dex */
public class z extends d.a.d.k.e.a<d.a.q0.a0.e0.l, AutoVideoCardViewHolder<d.a.q0.a0.e0.l>> implements d.a.q0.o.f {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public BdUniqueId m;
    public TbPageContext<?> n;
    public d.a.q0.e1.h.k.e o;
    public String p;
    public d.a.d.k.e.s q;
    public t0 r;
    public d.a.q0.a0.b0<d.a.q0.a0.e0.l> s;

    /* loaded from: classes8.dex */
    public class a extends d.a.q0.a0.b0<d.a.q0.a0.e0.l> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ z f56161b;

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
            this.f56161b = zVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.a.q0.a0.b0
        /* renamed from: d */
        public void a(View view, d.a.q0.a0.e0.l lVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, view, lVar) == null) {
                d.a.q0.a0.t.b().d(true);
                d.a.q0.o.d.c().h("page_recommend", "show_");
                if (this.f56161b.o == null || lVar == null || lVar.getThreadData() == null || StringUtils.isNull(lVar.getThreadData().o1())) {
                    return;
                }
                if (lVar.getThreadData().s1 > 0) {
                    TiebaStatic.log(lVar.N(lVar.getThreadData()));
                    return;
                }
                if ((view.getTag() instanceof String) && !d.a.q0.e1.h.f.b(d.a.d.e.m.b.f(lVar.getThreadData().o1(), 0L))) {
                    d.a.q0.e1.h.f.a(d.a.d.e.m.b.f(lVar.getThreadData().o1(), 0L));
                    this.f56161b.o.e(d.a.d.e.m.b.f(lVar.getThreadData().o1(), 0L), lVar.C(), lVar.p(), lVar.o(), lVar.c(), d.a.d.e.m.b.d((String) view.getTag(), 1), "homepage", lVar.getThreadData().J());
                }
                this.f56161b.l0(view, lVar);
                TbSingleton.getInstance().saveHomeRecommendItemClickTime();
            }
        }
    }

    /* loaded from: classes8.dex */
    public class b implements a.InterfaceC0618a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ t0 f56162a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ z f56163b;

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
            this.f56163b = zVar;
            this.f56162a = t0Var;
        }

        @Override // d.a.k.a.InterfaceC0618a
        public void a(d.a.p0.s.q.a aVar) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, aVar) == null) || aVar == null) {
                return;
            }
            Rect computeViewArea = ThreadCardUtils.computeViewArea(this.f56162a.getVideoContainer());
            if (!(aVar instanceof d.a.q0.a0.e0.l)) {
                ThreadCardUtils.jumpToPB(aVar, this.f56163b.f42341e, 2, false, computeViewArea);
                return;
            }
            aVar.objType = 5;
            ThreadCardUtils.jumpToPB(aVar, this.f56163b.f42341e, 2, false, computeViewArea);
        }
    }

    /* loaded from: classes8.dex */
    public class c implements d.a.d.k.e.w {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ z f56164e;

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
            this.f56164e = zVar;
        }

        @Override // d.a.d.k.e.w
        public void b(View view, d.a.d.k.e.n nVar, BdUniqueId bdUniqueId, ViewGroup viewGroup, int i2, long j) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{view, nVar, bdUniqueId, viewGroup, Integer.valueOf(i2), Long.valueOf(j)}) == null) && (nVar instanceof d.a.q0.a0.e0.l) && (view.getTag() instanceof ThreadCardViewHolder)) {
                AutoVideoCardViewHolder autoVideoCardViewHolder = (AutoVideoCardViewHolder) view.getTag();
                d.a.q0.a0.e0.l lVar = (d.a.q0.a0.e0.l) nVar;
                lVar.k = 1;
                if (this.f56164e.s != null) {
                    this.f56164e.s.a(autoVideoCardViewHolder.a(), lVar);
                }
                ThreadCardUtils.jumpToPB((d.a.p0.s.q.a) lVar, view.getContext(), 2, false, d.a.k.e.a((d.a.d.k.e.s) viewGroup, view, i2));
                autoVideoCardViewHolder.b().o(new a.C0620a(1));
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public z(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext.getPageActivity(), bdUniqueId);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {tbPageContext, bdUniqueId};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((Context) objArr2[0], (BdUniqueId) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.s = new a(this);
        this.n = tbPageContext;
        m0();
    }

    @Override // d.a.q0.o.f
    public void g(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str) == null) {
            this.p = str;
        }
    }

    public final d.a.q0.n2.o k0(d.a.q0.a0.e0.l lVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, lVar)) == null) {
            if (lVar != null) {
                d.a.q0.n2.o oVar = new d.a.q0.n2.o();
                oVar.f61423a = "1";
                oVar.f61425c = lVar.l;
                if (lVar.getThreadData() != null) {
                    oVar.f61426d = String.valueOf(lVar.getThreadData().R());
                    oVar.v = lVar.getThreadData().B0();
                    if (lVar.getThreadData().m1() != null) {
                        oVar.m = lVar.getThreadData().m1().video_md5;
                        oVar.p = String.valueOf(lVar.getThreadData().m1().is_vertical);
                    }
                }
                oVar.k = lVar.e();
                oVar.f61428f = lVar.p();
                oVar.l = lVar.c();
                oVar.f61430h = lVar.C();
                oVar.f61427e = TbadkCoreApplication.getCurrentAccount();
                oVar.q = String.valueOf(lVar.o());
                if (lVar.getThreadData() == null || lVar.getThreadData().J() == null) {
                    return oVar;
                }
                oVar.t = lVar.getThreadData().J().oriUgcNid;
                oVar.u = lVar.getThreadData().J().oriUgcVid;
                return oVar;
            }
            return null;
        }
        return (d.a.q0.n2.o) invokeL.objValue;
    }

    public final void l0(View view, d.a.q0.a0.e0.l lVar) {
        t0 t0Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048580, this, view, lVar) == null) || (t0Var = this.r) == null || t0Var.p() == null || this.r.p().E() == null) {
            return;
        }
        if (view.getId() == this.r.p().E().getId()) {
            d.a.q0.e1.h.m.a.c(lVar.f54338e, this.m, lVar.o(), 4);
            TiebaStatic.log(lVar.P());
            d.a.q0.e1.h.m.a.b(lVar.f54338e, lVar.o(), 2);
        } else if (view.getId() == R.id.thread_card_root) {
            TiebaStatic.log(lVar.N(lVar.f54338e));
            d.a.q0.e1.h.m.a.b(lVar.f54338e, lVar.o(), 1);
        }
    }

    public final void m0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            d.a.q0.a0.e0.l.Y = "c10708";
            d.a.q0.a0.e0.l.Z = "c10735";
            d.a.q0.a0.e0.l.a0 = "c10709";
            d.a.q0.a0.e0.l.b0 = "c10734";
            d.a.q0.a0.e0.l.c0 = "c11929";
            d.a.q0.a0.e0.l.i0 = "c11928";
            d.a.q0.a0.e0.l.j0 = "c10756";
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.a.d.k.e.a
    /* renamed from: n0 */
    public AutoVideoCardViewHolder<d.a.q0.a0.e0.l> Q(ViewGroup viewGroup) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048582, this, viewGroup)) == null) {
            l0.b bVar = new l0.b(this.n.getPageActivity(), false);
            d.a.q0.e1.h.n.b bVar2 = new d.a.q0.e1.h.n.b(this.n.getPageActivity());
            bVar2.v(new b(this, bVar2));
            this.r = bVar2;
            bVar2.x(this.m);
            this.r.u("index");
            this.r.y("2001");
            bVar.n(this.r);
            l0 k = bVar.k(BaseCardInfo.SupportType.CONTENT, viewGroup, this.q);
            AutoVideoCardViewHolder<d.a.q0.a0.e0.l> autoVideoCardViewHolder = new AutoVideoCardViewHolder<>(k);
            autoVideoCardViewHolder.j(this.m);
            k.p(this.s);
            k.r(2);
            a0(new c(this));
            return autoVideoCardViewHolder;
        }
        return (AutoVideoCardViewHolder) invokeL.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.a.d.k.e.a
    /* renamed from: o0 */
    public View X(int i2, View view, ViewGroup viewGroup, d.a.q0.a0.e0.l lVar, AutoVideoCardViewHolder<d.a.q0.a0.e0.l> autoVideoCardViewHolder) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048583, this, new Object[]{Integer.valueOf(i2), view, viewGroup, lVar, autoVideoCardViewHolder})) == null) {
            if (lVar == null) {
                return autoVideoCardViewHolder.a();
            }
            if (autoVideoCardViewHolder == null) {
                return null;
            }
            lVar.I(lVar.position + 1);
            lVar.f54338e.P1 = lVar.o();
            autoVideoCardViewHolder.b().q(i2);
            lVar.W = 0;
            d.a.q0.a0.t.b().a(lVar.z());
            autoVideoCardViewHolder.u(k0(lVar));
            if (autoVideoCardViewHolder.b() != null) {
                autoVideoCardViewHolder.b().setPage(this.p);
            }
            autoVideoCardViewHolder.f(lVar);
            autoVideoCardViewHolder.b().onChangeSkinType(this.n, TbadkCoreApplication.getInst().getSkinType());
            autoVideoCardViewHolder.b().p(this.s);
            d.a.q0.e1.h.m.a.f(lVar.f54338e, this.m, lVar.o());
            d.a.q0.e1.h.m.a.e(lVar.f54338e, lVar.o());
            return autoVideoCardViewHolder.a();
        }
        return (View) invokeCommon.objValue;
    }

    public void onPause() {
        t0 t0Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) || (t0Var = this.r) == null) {
            return;
        }
        t0Var.s();
    }

    public void onResume() {
        t0 t0Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048585, this) == null) || (t0Var = this.r) == null) {
            return;
        }
        t0Var.t();
    }

    public void p0(d.a.q0.e1.h.k.e eVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048586, this, eVar) == null) {
            this.o = eVar;
        }
    }

    public void r0(d.a.d.k.e.s sVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048587, this, sVar) == null) {
            this.q = sVar;
        }
    }
}
