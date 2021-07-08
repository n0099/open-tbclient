package d.a.p0.e1.c.e;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.card.Align;
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
import d.a.j.l0;
import d.a.j.n0;
import d.a.j.v0.a;
import d.a.p0.a0.b0;
/* loaded from: classes7.dex */
public class d extends d.a.c.k.e.a<d.a.p0.a0.e0.e, ThreadCardViewHolder<d.a.p0.a0.e0.e>> implements d.a.p0.o.f {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public BdUniqueId m;
    public TbPageContext<?> n;
    public String o;
    public d.a.c.k.e.s p;
    public b0<d.a.p0.a0.e0.e> q;

    /* loaded from: classes7.dex */
    public class a extends b0<d.a.p0.a0.e0.e> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ d f55142b;

        public a(d dVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {dVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f55142b = dVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.a.p0.a0.b0
        /* renamed from: d */
        public void a(View view, d.a.p0.a0.e0.e eVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, view, eVar) == null) {
                d.a.p0.a0.t.b().d(true);
                d.a.p0.o.d.c().h("page_recommend", "show_");
                if (view == null || eVar == null || eVar.getThreadData() == null || StringUtils.isNull(eVar.getThreadData().n1())) {
                    return;
                }
                this.f55142b.k0(view, eVar);
            }
        }
    }

    /* loaded from: classes7.dex */
    public class b implements d.a.c.k.e.w {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ d f55143e;

        public b(d dVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {dVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f55143e = dVar;
        }

        @Override // d.a.c.k.e.w
        public void b(View view, d.a.c.k.e.n nVar, BdUniqueId bdUniqueId, ViewGroup viewGroup, int i2, long j) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{view, nVar, bdUniqueId, viewGroup, Integer.valueOf(i2), Long.valueOf(j)}) == null) {
                this.f55143e.h0(view, nVar);
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public d(TbPageContext tbPageContext, BdUniqueId bdUniqueId) {
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
        this.q = new a(this);
        this.n = tbPageContext;
    }

    @Override // d.a.p0.o.f
    public void g(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str) == null) {
            this.o = str;
        }
    }

    public final void h0(View view, d.a.c.k.e.n nVar) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(1048579, this, view, nVar) == null) && (nVar instanceof d.a.p0.a0.e0.e) && (view.getTag() instanceof ThreadCardViewHolder)) {
            d.a.p0.a0.e0.e eVar = (d.a.p0.a0.e0.e) nVar;
            eVar.k = 1;
            ThreadCardUtils.jumpToPB((d.a.o0.r.q.a) eVar, view.getContext(), 1, false);
            ((ThreadCardViewHolder) view.getTag()).b().o(new a.C0611a(1));
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.a.c.k.e.a
    /* renamed from: i0 */
    public ThreadCardViewHolder<d.a.p0.a0.e0.e> Q(ViewGroup viewGroup) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, viewGroup)) == null) {
            l0.b bVar = new l0.b(this.n.getPageActivity());
            d.a.j.d dVar = new d.a.j.d(this.n.getPageActivity());
            dVar.t(this.m);
            dVar.v(this.n);
            bVar.o(dVar);
            bVar.n(new d.a.j.b(this.n.getPageActivity()));
            bVar.h(new d.a.j.k(this.n.getPageActivity()));
            n0 n0Var = new n0(this.n.getPageActivity());
            d.a.o0.r.q.f fVar = new d.a.o0.r.q.f();
            fVar.f52647b = 1;
            fVar.f52653h = 1;
            n0Var.v(fVar);
            n0Var.w(9);
            n0Var.A(4);
            n0Var.x(1);
            bVar.m(n0Var);
            bVar.l().g(d.a.c.e.p.l.g(TbadkCoreApplication.getInst(), R.dimen.tbds35));
            l0 k = bVar.k(BaseCardInfo.SupportType.FULL, viewGroup, this.p);
            k.r(1);
            ThreadCardViewHolder<d.a.p0.a0.e0.e> threadCardViewHolder = new ThreadCardViewHolder<>(k);
            threadCardViewHolder.j(this.m);
            a0(new b(this));
            return threadCardViewHolder;
        }
        return (ThreadCardViewHolder) invokeL.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.a.c.k.e.a
    /* renamed from: j0 */
    public View X(int i2, View view, ViewGroup viewGroup, d.a.p0.a0.e0.e eVar, ThreadCardViewHolder<d.a.p0.a0.e0.e> threadCardViewHolder) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048581, this, new Object[]{Integer.valueOf(i2), view, viewGroup, eVar, threadCardViewHolder})) == null) {
            if (eVar == null || threadCardViewHolder == null || threadCardViewHolder.a() == null) {
                return null;
            }
            eVar.I(eVar.position + 1);
            threadCardViewHolder.b().q(i2);
            threadCardViewHolder.b().setPage(this.o);
            threadCardViewHolder.s(true, Align.ALIGN_RIGHT_TOP);
            threadCardViewHolder.k();
            threadCardViewHolder.f(eVar);
            d.a.p0.a0.t.b().a(eVar.d("c12351"));
            threadCardViewHolder.b().p(this.q);
            threadCardViewHolder.b().onChangeSkinType(this.n, TbadkCoreApplication.getInst().getSkinType());
            return threadCardViewHolder.a();
        }
        return (View) invokeCommon.objValue;
    }

    public final void k0(View view, d.a.p0.a0.e0.e eVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048582, this, view, eVar) == null) {
            int id = view.getId();
            if (id == R.id.thread_card_root) {
                d.a.p0.e1.c.c.b(view, eVar, 2);
            } else if (id != R.id.user_avatar && id != R.id.user_name) {
                if (id == R.id.cover_img || id == R.id.bottom_mask) {
                    d.a.p0.e1.c.c.b(view, eVar, 3);
                }
            } else {
                d.a.p0.e1.c.c.b(view, eVar, 1);
            }
        }
    }

    public void l0(d.a.c.k.e.s sVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, sVar) == null) {
            this.p = sVar;
        }
    }
}
