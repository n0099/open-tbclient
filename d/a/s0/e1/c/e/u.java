package d.a.s0.e1.c.e;

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
import com.baidu.tbadk.core.atomData.PbActivityConfig;
import com.baidu.tbadk.core.frameworkData.IntentConfig;
import com.baidu.tbadk.core.util.ThreadCardUtils;
import com.baidu.tbadk.core.view.ThreadCommentAndPraiseInfoLayout;
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
import d.a.s0.a0.b0;
/* loaded from: classes9.dex */
public class u extends d.a.c.k.e.a<d.a.s0.a0.e0.k, ThreadCardViewHolder<d.a.s0.a0.e0.k>> implements d.a.s0.o.f {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public BdUniqueId m;
    public TbPageContext<?> n;
    public String o;
    public d.a.c.k.e.s p;
    public b0<d.a.s0.a0.e0.k> q;

    /* loaded from: classes9.dex */
    public class a extends b0<d.a.s0.a0.e0.k> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ u f58442b;

        public a(u uVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {uVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f58442b = uVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.a.s0.a0.b0
        /* renamed from: d */
        public void a(View view, d.a.s0.a0.e0.k kVar) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, view, kVar) == null) || view == null || kVar == null || kVar.getThreadData() == null || StringUtils.isNull(kVar.getThreadData().n1())) {
                return;
            }
            this.f58442b.j0(view, kVar);
        }
    }

    /* loaded from: classes9.dex */
    public class b implements d.a.c.k.e.w {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ u f58443e;

        public b(u uVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {uVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f58443e = uVar;
        }

        @Override // d.a.c.k.e.w
        public void b(View view, d.a.c.k.e.n nVar, BdUniqueId bdUniqueId, ViewGroup viewGroup, int i2, long j) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{view, nVar, bdUniqueId, viewGroup, Integer.valueOf(i2), Long.valueOf(j)}) == null) && (nVar instanceof d.a.s0.a0.e0.k) && (view.getTag() instanceof ThreadCardViewHolder)) {
                ThreadCardViewHolder threadCardViewHolder = (ThreadCardViewHolder) view.getTag();
                d.a.s0.a0.e0.k kVar = (d.a.s0.a0.e0.k) nVar;
                kVar.k = 1;
                if (this.f58443e.q != null) {
                    this.f58443e.q.a(threadCardViewHolder.a(), kVar);
                }
                ThreadCardUtils.jumpToPB((d.a.r0.r.q.a) kVar, view.getContext(), 1, false, d.a.j.e.a((d.a.c.k.e.s) viewGroup, view, i2));
                threadCardViewHolder.b().o(new a.C0645a(1));
            }
        }
    }

    /* loaded from: classes9.dex */
    public class c implements ThreadCommentAndPraiseInfoLayout.i {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ ViewGroup f58444a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ View f58445b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ int f58446c;

        public c(u uVar, ViewGroup viewGroup, View view, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {uVar, viewGroup, view, Integer.valueOf(i2)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f58444a = viewGroup;
            this.f58445b = view;
            this.f58446c = i2;
        }

        @Override // com.baidu.tbadk.core.view.ThreadCommentAndPraiseInfoLayout.i
        public void a(IntentConfig intentConfig) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, intentConfig) == null) && (intentConfig instanceof PbActivityConfig)) {
                ((PbActivityConfig) intentConfig).setVideoOriginArea(d.a.j.e.a((d.a.c.k.e.s) this.f58444a, this.f58445b, this.f58446c));
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public u(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId) {
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

    @Override // d.a.s0.o.f
    public void g(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str) == null) {
            this.o = str;
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.a.c.k.e.a
    /* renamed from: h0 */
    public ThreadCardViewHolder Q(ViewGroup viewGroup) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, viewGroup)) == null) {
            l0.b bVar = new l0.b(this.n.getPageActivity(), false);
            n0 n0Var = new n0(this.n.getPageActivity());
            d.a.r0.r.q.f fVar = new d.a.r0.r.q.f();
            fVar.f55932b = 9;
            fVar.f55938h = 9;
            n0Var.v(fVar);
            n0Var.w(4);
            n0Var.B("personalize_page");
            n0Var.A(4);
            n0Var.x(1);
            n0Var.b(32);
            bVar.m(n0Var);
            l0 k = bVar.k(BaseCardInfo.SupportType.BOTTOM, viewGroup, this.p);
            k.r(1);
            ThreadCardViewHolder threadCardViewHolder = new ThreadCardViewHolder(k);
            threadCardViewHolder.k(this.m);
            a0(new b(this));
            return threadCardViewHolder;
        }
        return (ThreadCardViewHolder) invokeL.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.a.c.k.e.a
    /* renamed from: i0 */
    public View X(int i2, View view, ViewGroup viewGroup, d.a.s0.a0.e0.k kVar, ThreadCardViewHolder threadCardViewHolder) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048580, this, new Object[]{Integer.valueOf(i2), view, viewGroup, kVar, threadCardViewHolder})) == null) {
            if (kVar == null || threadCardViewHolder == null || threadCardViewHolder.a() == null || kVar.f57050e == null) {
                return null;
            }
            kVar.I(kVar.position + 1);
            threadCardViewHolder.b().q(i2);
            if (threadCardViewHolder.b().e() instanceof n0) {
                ((n0) threadCardViewHolder.b().e()).z(new c(this, viewGroup, view, i2));
            }
            if (threadCardViewHolder.b() instanceof d.a.s0.o.e) {
                threadCardViewHolder.b().setPage(this.o);
            }
            threadCardViewHolder.t(false, Align.ALIGN_RIGHT_BOTTOM);
            threadCardViewHolder.f(kVar);
            threadCardViewHolder.b().onChangeSkinType(this.n, TbadkCoreApplication.getInst().getSkinType());
            threadCardViewHolder.b().p(this.q);
            return threadCardViewHolder.a();
        }
        return (View) invokeCommon.objValue;
    }

    public final void j0(View view, d.a.s0.a0.e0.k kVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048581, this, view, kVar) == null) {
            if (view.getId() == R.id.thread_card_root || view.getId() == R.id.thread_info_commont_container) {
                d.a.s0.e1.c.c.b(view, kVar, 2);
            }
        }
    }

    public void k0(d.a.c.k.e.s sVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, sVar) == null) {
            this.p = sVar;
        }
    }
}
