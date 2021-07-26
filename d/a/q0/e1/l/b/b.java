package d.a.q0.e1.l.b;

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
import d.a.d.k.e.n;
import d.a.d.k.e.s;
import d.a.d.k.e.w;
import d.a.k.a;
import d.a.k.l0;
import d.a.k.t0;
import d.a.k.v0.a;
import d.a.q0.a0.b0;
import d.a.q0.a0.e0.l;
import d.a.q0.n2.o;
/* loaded from: classes8.dex */
public class b extends d.a.d.k.e.a<l, AutoVideoCardViewHolder<l>> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public TbPageContext m;
    public BdUniqueId n;
    public s o;
    public t0 p;
    public d.a.q0.e1.h.k.e q;
    public b0<l> r;

    /* loaded from: classes8.dex */
    public class a extends b0<l> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ b f56394b;

        public a(b bVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f56394b = bVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.a.q0.a0.b0
        /* renamed from: d */
        public void a(View view, l lVar) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, view, lVar) == null) || view == null || lVar == null || lVar.getThreadData() == null) {
                return;
            }
            this.f56394b.l0(view, lVar);
            if (this.f56394b.q == null || !(view.getTag() instanceof String) || d.a.q0.e1.h.f.b(d.a.d.e.m.b.f(lVar.getThreadData().o1(), 0L))) {
                return;
            }
            d.a.q0.e1.h.f.a(d.a.d.e.m.b.f(lVar.getThreadData().o1(), 0L));
            this.f56394b.q.e(d.a.d.e.m.b.f(lVar.getThreadData().o1(), 0L), lVar.C(), lVar.p(), lVar.o(), lVar.c(), d.a.d.e.m.b.d("3", 1), "video_tab", lVar.getThreadData().J());
        }
    }

    /* renamed from: d.a.q0.e1.l.b.b$b  reason: collision with other inner class name */
    /* loaded from: classes8.dex */
    public class C1365b implements a.InterfaceC0618a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ t0 f56395a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ b f56396b;

        public C1365b(b bVar, t0 t0Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bVar, t0Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f56396b = bVar;
            this.f56395a = t0Var;
        }

        @Override // d.a.k.a.InterfaceC0618a
        public void a(d.a.p0.s.q.a aVar) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, aVar) == null) || aVar == null) {
                return;
            }
            Rect computeViewArea = ThreadCardUtils.computeViewArea(this.f56395a.getVideoContainer());
            if (aVar instanceof l) {
                aVar.objType = 5;
                d.a.q0.e1.l.d.a.f((d.a.q0.a0.e0.b) aVar);
                d.a.q0.e1.l.d.a.c(aVar, this.f56396b.f42341e, 19, false, computeViewArea);
                return;
            }
            d.a.q0.e1.l.d.a.f((d.a.q0.a0.e0.b) aVar);
            d.a.q0.e1.l.d.a.c(aVar, this.f56396b.f42341e, 19, false, computeViewArea);
        }
    }

    /* loaded from: classes8.dex */
    public class c implements w {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ b f56397e;

        public c(b bVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f56397e = bVar;
        }

        @Override // d.a.d.k.e.w
        public void b(View view, n nVar, BdUniqueId bdUniqueId, ViewGroup viewGroup, int i2, long j) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{view, nVar, bdUniqueId, viewGroup, Integer.valueOf(i2), Long.valueOf(j)}) == null) && (nVar instanceof l) && (view.getTag() instanceof ThreadCardViewHolder)) {
                ThreadCardViewHolder threadCardViewHolder = (ThreadCardViewHolder) view.getTag();
                l lVar = (l) nVar;
                lVar.k = 1;
                if (this.f56397e.r != null) {
                    this.f56397e.r.a(threadCardViewHolder.a(), lVar);
                }
                d.a.q0.e1.l.d.a.c(lVar, view.getContext(), 19, false, d.a.k.e.a((s) viewGroup, view, i2));
                threadCardViewHolder.b().o(new a.C0620a(1));
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public b(TbPageContext tbPageContext, BdUniqueId bdUniqueId) {
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
        this.r = new a(this);
        this.m = tbPageContext;
    }

    public final o k0(l lVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, lVar)) == null) {
            if (lVar != null) {
                o oVar = new o();
                oVar.f61423a = com.tencent.connect.common.Constants.VIA_ACT_TYPE_NINETEEN;
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
        return (o) invokeL.objValue;
    }

    public final void l0(View view, l lVar) {
        t0 t0Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048579, this, view, lVar) == null) || (t0Var = this.p) == null || t0Var.p() == null || this.p.p().E() == null) {
            return;
        }
        if (view.getId() == this.p.p().E().getId()) {
            d.a.q0.e1.l.d.a.h(lVar);
        } else if (view.getId() == R.id.thread_card_root) {
            d.a.q0.e1.l.d.a.f(lVar);
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.a.d.k.e.a
    /* renamed from: m0 */
    public AutoVideoCardViewHolder<l> Q(ViewGroup viewGroup) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, viewGroup)) == null) {
            l0.b bVar = new l0.b(this.m.getPageActivity(), false);
            d.a.k.g gVar = new d.a.k.g(this.m.getPageActivity());
            gVar.v(new C1365b(this, gVar));
            this.p = gVar;
            gVar.x(this.n);
            this.p.u("video_tab");
            this.p.y("2001");
            bVar.n(this.p);
            l0 k = bVar.k(BaseCardInfo.SupportType.CONTENT, viewGroup, this.o);
            AutoVideoCardViewHolder<l> autoVideoCardViewHolder = new AutoVideoCardViewHolder<>(k);
            autoVideoCardViewHolder.j(this.n);
            k.p(this.r);
            k.r(19);
            a0(new c(this));
            return autoVideoCardViewHolder;
        }
        return (AutoVideoCardViewHolder) invokeL.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.a.d.k.e.a
    /* renamed from: n0 */
    public View X(int i2, View view, ViewGroup viewGroup, l lVar, AutoVideoCardViewHolder<l> autoVideoCardViewHolder) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048581, this, new Object[]{Integer.valueOf(i2), view, viewGroup, lVar, autoVideoCardViewHolder})) == null) {
            if (lVar == null) {
                return autoVideoCardViewHolder.a();
            }
            if (autoVideoCardViewHolder == null) {
                return null;
            }
            lVar.I(lVar.position + 1);
            autoVideoCardViewHolder.b().q(i2);
            autoVideoCardViewHolder.u(k0(lVar));
            d.a.q0.e1.l.d.a.d(lVar);
            autoVideoCardViewHolder.f(lVar);
            autoVideoCardViewHolder.b().onChangeSkinType(this.m, TbadkCoreApplication.getInst().getSkinType());
            autoVideoCardViewHolder.b().p(this.r);
            return autoVideoCardViewHolder.a();
        }
        return (View) invokeCommon.objValue;
    }

    public void o0(BdUniqueId bdUniqueId) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, bdUniqueId) == null) {
            this.n = bdUniqueId;
        }
    }

    public void onPause() {
        t0 t0Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048583, this) == null) || (t0Var = this.p) == null) {
            return;
        }
        t0Var.s();
    }

    public void p0(d.a.q0.e1.h.k.e eVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, eVar) == null) {
            this.q = eVar;
        }
    }

    public void r0(s sVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048585, this, sVar) == null) {
            this.o = sVar;
        }
    }
}
