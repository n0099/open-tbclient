package d.a.q0.e1.c.e;

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
import d.a.q0.a0.b0;
/* loaded from: classes8.dex */
public class x extends d.a.d.k.e.a<d.a.q0.a0.e0.l, AutoVideoCardViewHolder<d.a.q0.a0.e0.l>> implements d.a.q0.o.f {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public BdUniqueId m;
    public BdUniqueId n;
    public TbPageContext<?> o;
    public String p;
    public d.a.d.k.e.s q;
    public t0 r;
    public b0<d.a.q0.a0.e0.l> s;

    /* loaded from: classes8.dex */
    public class a extends b0<d.a.q0.a0.e0.l> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ x f55739b;

        public a(x xVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {xVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f55739b = xVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.a.q0.a0.b0
        /* renamed from: d */
        public void a(View view, d.a.q0.a0.e0.l lVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, view, lVar) == null) {
                d.a.q0.a0.t.b().d(true);
                d.a.q0.o.d.c().h("page_recommend", "show_");
                if (lVar == null || lVar.getThreadData() == null || StringUtils.isNull(lVar.getThreadData().o1())) {
                    return;
                }
                if (lVar.getThreadData().s1 <= 0) {
                    this.f55739b.k0(view, lVar);
                } else {
                    TiebaStatic.log(lVar.N(lVar.getThreadData()));
                }
            }
        }
    }

    /* loaded from: classes8.dex */
    public class b implements a.InterfaceC0618a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ t0 f55740a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ x f55741b;

        public b(x xVar, t0 t0Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {xVar, t0Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f55741b = xVar;
            this.f55740a = t0Var;
        }

        @Override // d.a.k.a.InterfaceC0618a
        public void a(d.a.p0.s.q.a aVar) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, aVar) == null) || aVar == null) {
                return;
            }
            Rect computeViewArea = ThreadCardUtils.computeViewArea(this.f55740a.getVideoContainer());
            if (!(aVar instanceof d.a.q0.a0.e0.l)) {
                ThreadCardUtils.jumpToPB(aVar, this.f55741b.f42341e, 1, false, computeViewArea);
                return;
            }
            aVar.objType = 5;
            ThreadCardUtils.jumpToPB(aVar, this.f55741b.f42341e, 1, false, computeViewArea);
        }
    }

    /* loaded from: classes8.dex */
    public class c implements d.a.d.k.e.w {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ x f55742e;

        public c(x xVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {xVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f55742e = xVar;
        }

        @Override // d.a.d.k.e.w
        public void b(View view, d.a.d.k.e.n nVar, BdUniqueId bdUniqueId, ViewGroup viewGroup, int i2, long j) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{view, nVar, bdUniqueId, viewGroup, Integer.valueOf(i2), Long.valueOf(j)}) == null) && (nVar instanceof d.a.d.k.e.g) && (view.getTag() instanceof ThreadCardViewHolder)) {
                d.a.d.k.e.g gVar = (d.a.d.k.e.g) nVar;
                if (gVar.c() instanceof d.a.q0.a0.e0.l) {
                    ThreadCardViewHolder threadCardViewHolder = (ThreadCardViewHolder) view.getTag();
                    d.a.q0.a0.e0.l lVar = (d.a.q0.a0.e0.l) gVar.c();
                    lVar.k = 1;
                    if (this.f55742e.s != null) {
                        this.f55742e.s.a(threadCardViewHolder.a(), lVar);
                    }
                    ThreadCardUtils.jumpToPB((d.a.p0.s.q.a) lVar, view.getContext(), 1, false, d.a.k.e.a((d.a.d.k.e.s) viewGroup, view, i2));
                    threadCardViewHolder.b().o(new a.C0620a(1));
                }
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public x(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId, BdUniqueId bdUniqueId2) {
        super(tbPageContext.getPageActivity(), bdUniqueId);
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
                super((Context) objArr2[0], (BdUniqueId) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.s = new a(this);
        this.o = tbPageContext;
        this.n = bdUniqueId2;
    }

    @Override // d.a.q0.o.f
    public void g(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, str) == null) {
            this.p = str;
        }
    }

    public final d.a.q0.n2.o j0(d.a.q0.a0.e0.l lVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, lVar)) == null) {
            if (lVar != null) {
                d.a.q0.n2.o oVar = new d.a.q0.n2.o();
                oVar.f61423a = "1";
                oVar.f61425c = lVar.l;
                if (lVar.getThreadData() != null) {
                    oVar.f61426d = String.valueOf(lVar.getThreadData().R());
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
                return oVar;
            }
            return null;
        }
        return (d.a.q0.n2.o) invokeL.objValue;
    }

    public final void k0(View view, d.a.q0.a0.e0.l lVar) {
        t0 t0Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048582, this, view, lVar) == null) || (t0Var = this.r) == null || t0Var.p() == null || this.r.p().E() == null) {
            return;
        }
        if (view.getId() == this.r.p().E().getId()) {
            d.a.q0.e1.c.c.b(view, lVar, 4);
        } else if (view.getId() == R.id.thread_card_root) {
            d.a.q0.e1.c.c.b(view, lVar, 2);
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.a.d.k.e.a
    /* renamed from: l0 */
    public AutoVideoCardViewHolder<d.a.q0.a0.e0.l> N(ViewGroup viewGroup, d.a.q0.a0.e0.l lVar) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048583, this, viewGroup, lVar)) == null) {
            l0.b bVar = new l0.b(this.o.getPageActivity(), false);
            d.a.q0.e1.h.n.b bVar2 = new d.a.q0.e1.h.n.b(this.o.getPageActivity());
            bVar2.x(this.m);
            bVar2.u("concern_tab");
            bVar2.v(new b(this, bVar2));
            this.r = bVar2;
            bVar.n(bVar2);
            t0 t0Var = this.r;
            if (t0Var != null) {
                t0Var.y("2001");
            }
            l0 k = bVar.k(BaseCardInfo.SupportType.CONTENT, viewGroup, this.q);
            AutoVideoCardViewHolder<d.a.q0.a0.e0.l> autoVideoCardViewHolder = new AutoVideoCardViewHolder<>(k);
            autoVideoCardViewHolder.j(this.m);
            k.p(this.s);
            k.r(1);
            a0(new c(this));
            return autoVideoCardViewHolder;
        }
        return (AutoVideoCardViewHolder) invokeLL.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.a.d.k.e.a
    /* renamed from: m0 */
    public AutoVideoCardViewHolder<d.a.q0.a0.e0.l> Q(ViewGroup viewGroup) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, viewGroup)) == null) {
            return null;
        }
        return (AutoVideoCardViewHolder) invokeL.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.a.d.k.e.a
    /* renamed from: n0 */
    public View T(int i2, View view, ViewGroup viewGroup, d.a.q0.a0.e0.l lVar, AutoVideoCardViewHolder<d.a.q0.a0.e0.l> autoVideoCardViewHolder) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048585, this, new Object[]{Integer.valueOf(i2), view, viewGroup, lVar, autoVideoCardViewHolder})) == null) {
            if (lVar == null) {
                return autoVideoCardViewHolder.a();
            }
            if (autoVideoCardViewHolder == null) {
                return null;
            }
            lVar.I(lVar.position + 1);
            d.a.q0.a0.t.b().a(lVar.d("c12351"));
            autoVideoCardViewHolder.b().q(i2);
            lVar.W = 0;
            autoVideoCardViewHolder.u(j0(lVar));
            if (autoVideoCardViewHolder.b() instanceof d.a.q0.o.e) {
                autoVideoCardViewHolder.b().setPage(this.p);
            }
            autoVideoCardViewHolder.f(lVar);
            autoVideoCardViewHolder.b().onChangeSkinType(this.o, TbadkCoreApplication.getInst().getSkinType());
            autoVideoCardViewHolder.b().p(this.s);
            return autoVideoCardViewHolder.a();
        }
        return (View) invokeCommon.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.a.d.k.e.a
    /* renamed from: o0 */
    public View X(int i2, View view, ViewGroup viewGroup, d.a.q0.a0.e0.l lVar, AutoVideoCardViewHolder<d.a.q0.a0.e0.l> autoVideoCardViewHolder) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048586, this, new Object[]{Integer.valueOf(i2), view, viewGroup, lVar, autoVideoCardViewHolder})) == null) {
            return null;
        }
        return (View) invokeCommon.objValue;
    }

    public void p0(d.a.d.k.e.s sVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048587, this, sVar) == null) {
            this.q = sVar;
        }
    }

    @Override // d.a.d.k.e.a
    public BdUniqueId v() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) ? d.a.q0.a0.e0.b.Q : (BdUniqueId) invokeV.objValue;
    }

    @Override // d.a.d.k.e.a
    public BdUniqueId w() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) ? d.a.q0.a0.e0.b.N : (BdUniqueId) invokeV.objValue;
    }

    @Override // d.a.d.k.e.a
    public BdUniqueId x() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048590, this)) == null) ? d.a.q0.a0.e0.b.P : (BdUniqueId) invokeV.objValue;
    }

    @Override // d.a.d.k.e.a
    public BdUniqueId y() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048591, this)) == null) {
            BdUniqueId bdUniqueId = this.n;
            return bdUniqueId != null ? bdUniqueId : d.a.q0.a0.e0.b.H;
        }
        return (BdUniqueId) invokeV.objValue;
    }
}
