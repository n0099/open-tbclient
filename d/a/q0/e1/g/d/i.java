package d.a.q0.e1.g.d;

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
import d.a.d.k.e.n;
import d.a.d.k.e.s;
import d.a.d.k.e.w;
import d.a.k.a;
import d.a.k.l0;
import d.a.k.t0;
import d.a.k.v0.a;
import d.a.p0.s.q.a2;
import d.a.p0.s.q.b2;
import d.a.q0.a0.b0;
import d.a.q0.n2.o;
/* loaded from: classes8.dex */
public class i extends d.a.q0.e1.g.d.a<a2, AutoVideoCardViewHolder<b2>> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public t0 q;
    public b0<b2> r;

    /* loaded from: classes8.dex */
    public class a extends b0<b2> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ i f55975b;

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
            this.f55975b = iVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.a.q0.a0.b0
        /* renamed from: d */
        public void a(View view, b2 b2Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, view, b2Var) == null) {
                this.f55975b.e0(view, b2Var);
            }
        }
    }

    /* loaded from: classes8.dex */
    public class b implements a.InterfaceC0618a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ t0 f55976a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ i f55977b;

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
            this.f55977b = iVar;
            this.f55976a = t0Var;
        }

        @Override // d.a.k.a.InterfaceC0618a
        public void a(d.a.p0.s.q.a aVar) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, aVar) == null) || aVar == null) {
                return;
            }
            Rect computeViewArea = ThreadCardUtils.computeViewArea(this.f55976a.getVideoContainer());
            if (!(aVar instanceof b2)) {
                ThreadCardUtils.jumpToPB(aVar, this.f55977b.f42341e, 0, false, computeViewArea);
                return;
            }
            aVar.objType = 5;
            ThreadCardUtils.jumpToPB(aVar, this.f55977b.f42341e, 0, false, computeViewArea);
        }
    }

    /* loaded from: classes8.dex */
    public class c implements w {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ i f55978e;

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
            this.f55978e = iVar;
        }

        @Override // d.a.d.k.e.w
        public void b(View view, n nVar, BdUniqueId bdUniqueId, ViewGroup viewGroup, int i2, long j) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{view, nVar, bdUniqueId, viewGroup, Integer.valueOf(i2), Long.valueOf(j)}) == null) && (nVar instanceof a2) && (view.getTag() instanceof ThreadCardViewHolder)) {
                AutoVideoCardViewHolder autoVideoCardViewHolder = (AutoVideoCardViewHolder) view.getTag();
                b2 b2Var = ((a2) nVar).w;
                b2Var.objType = 1;
                if (this.f55978e.r != null) {
                    this.f55978e.r.a(autoVideoCardViewHolder.a(), b2Var);
                }
                ThreadCardUtils.jumpToPB((d.a.p0.s.q.a) b2Var, view.getContext(), 0, false, d.a.k.e.a((s) viewGroup, view, i2));
                autoVideoCardViewHolder.b().o(new a.C0620a(1));
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public i(TbPageContext<?> tbPageContext) {
        super(tbPageContext.getPageActivity(), b2.r3);
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

    public final o n0(b2 b2Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, b2Var)) == null) {
            if (b2Var != null) {
                o oVar = new o();
                oVar.f61423a = "20";
                oVar.f61425c = b2Var.A;
                oVar.f61428f = b2Var.T0;
                oVar.f61429g = b2Var.V0;
                oVar.f61430h = b2Var.U0;
                oVar.f61431i = "14";
                oVar.q = String.valueOf(b2Var.P1);
                if (b2Var.l1() != null) {
                    oVar.k = String.valueOf(b2Var.l1().f53359a);
                }
                b2Var.getThreadData();
                if (b2Var != null) {
                    b2Var.getThreadData();
                    oVar.f61426d = String.valueOf(b2Var.R());
                    b2Var.getThreadData();
                    oVar.v = b2Var.B0();
                    b2Var.getThreadData();
                    if (b2Var.m1() != null) {
                        b2Var.getThreadData();
                        oVar.m = b2Var.m1().video_md5;
                        b2Var.getThreadData();
                        oVar.p = String.valueOf(b2Var.m1().is_vertical);
                    }
                }
                oVar.f61427e = TbadkCoreApplication.getCurrentAccount();
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
    @Override // d.a.d.k.e.a
    /* renamed from: o0 */
    public AutoVideoCardViewHolder<b2> Q(ViewGroup viewGroup) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, viewGroup)) == null) {
            l0.b bVar = new l0.b(this.n.getPageActivity(), false);
            d.a.k.g gVar = new d.a.k.g(this.n.getPageActivity());
            gVar.v(new b(this, gVar));
            this.q = gVar;
            gVar.x(this.f42345i);
            this.q.u("14");
            this.q.y("2001");
            bVar.n(this.q);
            l0 k = bVar.k(BaseCardInfo.SupportType.CONTENT, viewGroup, this.o);
            AutoVideoCardViewHolder<b2> autoVideoCardViewHolder = new AutoVideoCardViewHolder<>(k);
            autoVideoCardViewHolder.j(this.f42345i);
            k.p(this.r);
            k.r(0);
            a0(new c(this));
            return autoVideoCardViewHolder;
        }
        return (AutoVideoCardViewHolder) invokeL.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.a.q0.e1.g.d.a, d.a.d.k.e.a
    /* renamed from: p0 */
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
            autoVideoCardViewHolder.u(n0(a2Var.w));
            autoVideoCardViewHolder.f(a2Var.w);
            autoVideoCardViewHolder.b().onChangeSkinType(this.n, TbadkCoreApplication.getInst().getSkinType());
            autoVideoCardViewHolder.b().p(this.r);
            j0(autoVideoCardViewHolder.a(), a2Var.w, i2, i2);
            return autoVideoCardViewHolder.a();
        }
        return (View) invokeCommon.objValue;
    }
}
