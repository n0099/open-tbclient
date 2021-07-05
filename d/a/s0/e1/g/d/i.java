package d.a.s0.e1.g.d;

import android.content.Context;
import android.graphics.Rect;
import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.card.AutoVideoCardViewHolder;
import com.baidu.card.ThreadCardViewHolder;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.ThreadCardUtils;
import com.baidu.tieba.card.data.BaseCardInfo;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import d.a.c.k.e.n;
import d.a.c.k.e.s;
import d.a.c.k.e.w;
import d.a.j.a;
import d.a.j.l0;
import d.a.j.t0;
import d.a.j.v0.a;
import d.a.r0.r.q.a2;
import d.a.r0.r.q.b2;
import d.a.s0.a0.b0;
import d.a.s0.n2.o;
/* loaded from: classes9.dex */
public class i extends d.a.s0.e1.g.d.a<a2, AutoVideoCardViewHolder<b2>> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public t0 q;
    public b0<b2> r;

    /* loaded from: classes9.dex */
    public class a extends b0<b2> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ i f58686b;

        public a(i iVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {iVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f58686b = iVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.a.s0.a0.b0
        /* renamed from: d */
        public void a(View view, b2 b2Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, view, b2Var) == null) {
                this.f58686b.f0(view, b2Var);
            }
        }
    }

    /* loaded from: classes9.dex */
    public class b implements a.InterfaceC0643a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ t0 f58687a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ i f58688b;

        public b(i iVar, t0 t0Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {iVar, t0Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f58688b = iVar;
            this.f58687a = t0Var;
        }

        @Override // d.a.j.a.InterfaceC0643a
        public void a(d.a.r0.r.q.a aVar) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, aVar) == null) || aVar == null) {
                return;
            }
            Rect computeViewArea = ThreadCardUtils.computeViewArea(this.f58687a.getVideoContainer());
            if (!(aVar instanceof b2)) {
                ThreadCardUtils.jumpToPB(aVar, this.f58688b.f44821e, 0, false, computeViewArea);
                return;
            }
            aVar.objType = 5;
            ThreadCardUtils.jumpToPB(aVar, this.f58688b.f44821e, 0, false, computeViewArea);
        }
    }

    /* loaded from: classes9.dex */
    public class c implements w {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ i f58689e;

        public c(i iVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {iVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f58689e = iVar;
        }

        @Override // d.a.c.k.e.w
        public void b(View view, n nVar, BdUniqueId bdUniqueId, ViewGroup viewGroup, int i2, long j) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{view, nVar, bdUniqueId, viewGroup, Integer.valueOf(i2), Long.valueOf(j)}) == null) && (nVar instanceof a2) && (view.getTag() instanceof ThreadCardViewHolder)) {
                AutoVideoCardViewHolder autoVideoCardViewHolder = (AutoVideoCardViewHolder) view.getTag();
                b2 b2Var = ((a2) nVar).w;
                b2Var.objType = 1;
                if (this.f58689e.r != null) {
                    this.f58689e.r.a(autoVideoCardViewHolder.a(), b2Var);
                }
                ThreadCardUtils.jumpToPB((d.a.r0.r.q.a) b2Var, view.getContext(), 0, false, d.a.j.e.a((s) viewGroup, view, i2));
                autoVideoCardViewHolder.b().o(new a.C0645a(1));
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public i(TbPageContext<?> tbPageContext) {
        super(tbPageContext.getPageActivity(), b2.l3);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {tbPageContext};
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
    }

    public final o p0(b2 b2Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, b2Var)) == null) {
            if (b2Var != null) {
                o oVar = new o();
                oVar.f64043a = "20";
                oVar.f64045c = b2Var.A;
                oVar.f64048f = b2Var.T0;
                oVar.f64049g = b2Var.V0;
                oVar.f64050h = b2Var.U0;
                oVar.f64051i = "14";
                oVar.q = String.valueOf(b2Var.P1);
                if (b2Var.k1() != null) {
                    oVar.k = String.valueOf(b2Var.k1().f55980a);
                }
                b2Var.getThreadData();
                if (b2Var != null) {
                    b2Var.getThreadData();
                    oVar.f64046d = String.valueOf(b2Var.Q());
                    b2Var.getThreadData();
                    oVar.v = b2Var.A0();
                    b2Var.getThreadData();
                    if (b2Var.l1() != null) {
                        b2Var.getThreadData();
                        oVar.m = b2Var.l1().video_md5;
                        b2Var.getThreadData();
                        oVar.p = String.valueOf(b2Var.l1().is_vertical);
                    }
                }
                oVar.f64047e = TbadkCoreApplication.getCurrentAccount();
                b2Var.getThreadData();
                if (b2Var != null) {
                    b2Var.getThreadData();
                    if (b2Var.J() != null) {
                        b2Var.getThreadData();
                        oVar.t = b2Var.J().oriUgcNid;
                        b2Var.getThreadData();
                        oVar.u = b2Var.J().oriUgcVid;
                        return oVar;
                    }
                    return oVar;
                }
                return oVar;
            }
            return null;
        }
        return (o) invokeL.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.a.c.k.e.a
    /* renamed from: q0 */
    public AutoVideoCardViewHolder<b2> Q(ViewGroup viewGroup) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, viewGroup)) == null) {
            l0.b bVar = new l0.b(this.n.getPageActivity(), false);
            d.a.j.g gVar = new d.a.j.g(this.n.getPageActivity());
            gVar.v(new b(this, gVar));
            this.q = gVar;
            gVar.x(this.f44825i);
            this.q.u("14");
            this.q.y("2001");
            bVar.n(this.q);
            l0 k = bVar.k(BaseCardInfo.SupportType.CONTENT, viewGroup, this.o);
            AutoVideoCardViewHolder<b2> autoVideoCardViewHolder = new AutoVideoCardViewHolder<>(k);
            autoVideoCardViewHolder.k(this.f44825i);
            k.p(this.r);
            k.r(0);
            a0(new c(this));
            return autoVideoCardViewHolder;
        }
        return (AutoVideoCardViewHolder) invokeL.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.a.s0.e1.g.d.a, d.a.c.k.e.a
    /* renamed from: s0 */
    public View X(int i2, View view, ViewGroup viewGroup, a2 a2Var, AutoVideoCardViewHolder<b2> autoVideoCardViewHolder) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048580, this, new Object[]{Integer.valueOf(i2), view, viewGroup, a2Var, autoVideoCardViewHolder})) == null) {
            if (a2Var == null) {
                return autoVideoCardViewHolder.a();
            }
            if (autoVideoCardViewHolder == null) {
                return null;
            }
            a2Var.w.P1 = F(i2) + 1;
            autoVideoCardViewHolder.b().q(i2);
            autoVideoCardViewHolder.v(p0(a2Var.w));
            autoVideoCardViewHolder.f(a2Var.w);
            autoVideoCardViewHolder.b().onChangeSkinType(this.n, TbadkCoreApplication.getInst().getSkinType());
            autoVideoCardViewHolder.b().p(this.r);
            j0(autoVideoCardViewHolder.a(), a2Var.w, i2, i2);
            return autoVideoCardViewHolder.a();
        }
        return (View) invokeCommon.objValue;
    }
}
