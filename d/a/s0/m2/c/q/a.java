package d.a.s0.m2.c.q;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.BdUniqueId;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.card.ThreadCardViewHolder;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.ThreadCardUtils;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import d.a.c.e.p.l;
import d.a.c.k.e.n;
import d.a.c.k.e.w;
import d.a.j.d;
import d.a.j.l0;
import d.a.j.n0;
import d.a.j.v0.a;
import d.a.s0.a0.b0;
import d.a.s0.a0.e0.k;
/* loaded from: classes9.dex */
public class a extends d.a.c.k.e.a<d.a.s0.a0.e0.e, ThreadCardViewHolder<d.a.s0.a0.e0.e>> implements d.a.s0.o.f {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public BdUniqueId m;
    public TbPageContext<?> n;
    public String o;
    public int p;
    public int q;
    public boolean r;
    public b0<d.a.s0.a0.e0.e> s;

    /* renamed from: d.a.s0.m2.c.q.a$a  reason: collision with other inner class name */
    /* loaded from: classes9.dex */
    public class C1581a extends b0<d.a.s0.a0.e0.e> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public C1581a(a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.a.s0.a0.b0
        /* renamed from: d */
        public void a(View view, d.a.s0.a0.e0.e eVar) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, view, eVar) == null) || view == null || eVar == null || eVar.getThreadData() == null) {
                return;
            }
            int id = view.getId();
            if (id != R.id.thread_card_root && id != R.id.bottom_mask) {
                if (id == R.id.forum_name_text) {
                    d.a.s0.m2.a.a(view, eVar, 7);
                    return;
                }
                return;
            }
            d.a.s0.m2.a.a(view, eVar, 2);
        }
    }

    /* loaded from: classes9.dex */
    public class b implements d.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ a f63364a;

        public b(a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f63364a = aVar;
        }

        @Override // d.a.j.d.b
        public void a(d.a.r0.r.q.a aVar, View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(1048576, this, aVar, view) == null) {
                this.f63364a.s0(view, aVar);
            }
        }
    }

    /* loaded from: classes9.dex */
    public class c extends b0<d.a.r0.r.q.a> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ a f63365b;

        public c(a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f63365b = aVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.a.s0.a0.b0
        /* renamed from: d */
        public void a(View view, d.a.r0.r.q.a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, view, aVar) == null) {
                this.f63365b.s0(view, aVar);
            }
        }
    }

    /* loaded from: classes9.dex */
    public class d implements w {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ a f63366e;

        public d(a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f63366e = aVar;
        }

        @Override // d.a.c.k.e.w
        public void b(View view, n nVar, BdUniqueId bdUniqueId, ViewGroup viewGroup, int i2, long j) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{view, nVar, bdUniqueId, viewGroup, Integer.valueOf(i2), Long.valueOf(j)}) == null) {
                this.f63366e.i0(view, nVar);
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public a(TbPageContext tbPageContext, BdUniqueId bdUniqueId) {
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
        this.p = 0;
        this.q = 0;
        this.s = new C1581a(this);
        this.n = tbPageContext;
        h0();
    }

    @Override // d.a.s0.o.f
    public void g(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str) == null) {
            this.o = str;
        }
    }

    public final void h0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            k.r0 = "c13542";
        }
    }

    public final void i0(View view, n nVar) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(1048580, this, view, nVar) == null) && (nVar instanceof d.a.s0.a0.e0.e) && (view.getTag() instanceof ThreadCardViewHolder)) {
            d.a.s0.a0.e0.e eVar = (d.a.s0.a0.e0.e) nVar;
            eVar.k = 1;
            ThreadCardUtils.jumpToPB((d.a.r0.r.q.a) eVar, view.getContext(), 4, false);
            ((ThreadCardViewHolder) view.getTag()).b().o(new a.C0645a(1));
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.a.c.k.e.a
    /* renamed from: j0 */
    public ThreadCardViewHolder<d.a.s0.a0.e0.e> Q(ViewGroup viewGroup) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, viewGroup)) == null) {
            l0.b bVar = new l0.b(this.n.getPageActivity());
            d.a.j.d dVar = new d.a.j.d(this.n.getPageActivity());
            dVar.t(this.m);
            dVar.v(this.n);
            dVar.c(32768);
            int i2 = this.p;
            if (i2 > 0) {
                dVar.b(i2);
            }
            dVar.r(false);
            dVar.w(false);
            dVar.s(new b(this));
            bVar.o(dVar);
            bVar.l().g(l.g(this.f44821e, R.dimen.tbds25));
            d.a.j.b bVar2 = new d.a.j.b(this.n.getPageActivity());
            bVar2.l(new c(this));
            bVar.n(bVar2);
            bVar.h(new d.a.j.k(this.n.getPageActivity()));
            n0 n0Var = new n0(this.n.getPageActivity());
            d.a.r0.r.q.f fVar = new d.a.r0.r.q.f();
            fVar.f55932b = 3;
            fVar.f55938h = 3;
            n0Var.v(fVar);
            n0Var.w(8);
            n0Var.A(6);
            n0Var.x(4);
            bVar.m(n0Var);
            l0 i3 = bVar.i();
            i3.r(4);
            ThreadCardViewHolder<d.a.s0.a0.e0.e> threadCardViewHolder = new ThreadCardViewHolder<>(i3);
            threadCardViewHolder.k(this.m);
            threadCardViewHolder.r(this.q);
            a0(new d(this));
            return threadCardViewHolder;
        }
        return (ThreadCardViewHolder) invokeL.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.a.c.k.e.a
    /* renamed from: k0 */
    public View X(int i2, View view, ViewGroup viewGroup, d.a.s0.a0.e0.e eVar, ThreadCardViewHolder<d.a.s0.a0.e0.e> threadCardViewHolder) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048582, this, new Object[]{Integer.valueOf(i2), view, viewGroup, eVar, threadCardViewHolder})) == null) {
            if (eVar == null || threadCardViewHolder == null || threadCardViewHolder.a() == null) {
                return null;
            }
            eVar.I(eVar.position + 1);
            threadCardViewHolder.b().setPage(this.o);
            if (!this.r) {
                threadCardViewHolder.s();
            }
            threadCardViewHolder.f(eVar);
            threadCardViewHolder.b().p(this.s);
            threadCardViewHolder.b().onChangeSkinType(this.n, TbadkCoreApplication.getInst().getSkinType());
            d.a.s0.m2.a.b(eVar);
            return threadCardViewHolder.a();
        }
        return (View) invokeCommon.objValue;
    }

    public void l0(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048583, this, z) == null) {
            this.r = z;
        }
    }

    public void m0(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(InputDeviceCompat.SOURCE_TOUCHPAD, this, i2) == null) {
            this.q = i2;
        }
    }

    public void p0(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048585, this, i2) == null) {
        }
    }

    public void q0(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048586, this, i2) == null) {
            this.p = i2;
        }
    }

    public final void s0(View view, d.a.r0.r.q.a aVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048587, this, view, aVar) == null) || view == null || aVar == null || view.getId() == -1) {
            return;
        }
        int id = view.getId();
        if (id != R.id.user_name && id != R.id.user_avatar) {
            if (id == R.id.cover_img || id == R.id.bottom_mask) {
                d.a.s0.m2.a.a(view, aVar, 3);
                return;
            }
            return;
        }
        d.a.s0.m2.a.a(view, aVar, 1);
    }
}
