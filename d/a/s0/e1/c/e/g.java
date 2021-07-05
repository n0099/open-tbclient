package d.a.s0.e1.c.e;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.card.ThreadCardViewHolder;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.ImageViewerConfig;
import com.baidu.tbadk.core.util.ThreadCardUtils;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
import com.baidu.tieba.card.data.BaseCardInfo;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import d.a.j.l0;
import d.a.j.v0.a;
import d.a.s0.a0.b0;
/* loaded from: classes9.dex */
public class g extends d.a.c.k.e.a<d.a.s0.a0.e0.k, ThreadCardViewHolder<d.a.s0.a0.e0.k>> implements d.a.s0.o.f {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public BdUniqueId m;
    public TbPageContext<?> n;
    public String o;
    public boolean p;
    public d.a.c.k.e.s q;
    public b0<d.a.s0.a0.e0.k> r;

    /* loaded from: classes9.dex */
    public class a extends b0<d.a.s0.a0.e0.k> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ g f58408b;

        public a(g gVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {gVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f58408b = gVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.a.s0.a0.b0
        /* renamed from: d */
        public void a(View view, d.a.s0.a0.e0.k kVar) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, view, kVar) == null) || view == null || kVar == null || kVar.getThreadData() == null || StringUtils.isNull(kVar.getThreadData().n1())) {
                return;
            }
            this.f58408b.j0(view, kVar);
        }
    }

    /* loaded from: classes9.dex */
    public class b implements d.a.c.k.e.w {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ g f58409e;

        public b(g gVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {gVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f58409e = gVar;
        }

        @Override // d.a.c.k.e.w
        public void b(View view, d.a.c.k.e.n nVar, BdUniqueId bdUniqueId, ViewGroup viewGroup, int i2, long j) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{view, nVar, bdUniqueId, viewGroup, Integer.valueOf(i2), Long.valueOf(j)}) == null) && (nVar instanceof d.a.s0.a0.e0.k) && (view.getTag() instanceof ThreadCardViewHolder)) {
                ThreadCardViewHolder threadCardViewHolder = (ThreadCardViewHolder) view.getTag();
                d.a.s0.a0.e0.k kVar = (d.a.s0.a0.e0.k) nVar;
                kVar.k = 1;
                if (this.f58409e.r != null) {
                    this.f58409e.r.a(threadCardViewHolder.a(), kVar);
                }
                ThreadCardUtils.jumpToPB((d.a.r0.r.q.a) kVar, view.getContext(), 1, false);
                threadCardViewHolder.b().o(new a.C0645a(1));
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public g(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId) {
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
        this.p = true;
        this.r = new a(this);
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
            d.a.j.v vVar = new d.a.j.v(this.n.getPageActivity());
            vVar.r(ImageViewerConfig.FROM_CONCERN);
            vVar.s(this.p);
            bVar.n(vVar);
            l0 k = bVar.k(BaseCardInfo.SupportType.CONTENT, viewGroup, this.q);
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
    public View X(int i2, View view, ViewGroup viewGroup, d.a.s0.a0.e0.k kVar, ThreadCardViewHolder<d.a.s0.a0.e0.k> threadCardViewHolder) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048580, this, new Object[]{Integer.valueOf(i2), view, viewGroup, kVar, threadCardViewHolder})) == null) {
            if (kVar == null || threadCardViewHolder == null || threadCardViewHolder.a() == null || kVar.f57050e == null) {
                return null;
            }
            kVar.I(kVar.position + 1);
            d.a.s0.a0.t.b().a(kVar.d("c12351"));
            threadCardViewHolder.b().q(i2);
            if (threadCardViewHolder.b() instanceof d.a.s0.o.e) {
                threadCardViewHolder.b().setPage(this.o);
            }
            threadCardViewHolder.f(kVar);
            threadCardViewHolder.b().onChangeSkinType(this.n, TbadkCoreApplication.getInst().getSkinType());
            threadCardViewHolder.b().p(this.r);
            return threadCardViewHolder.a();
        }
        return (View) invokeCommon.objValue;
    }

    public final void j0(View view, d.a.s0.a0.e0.k kVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048581, this, view, kVar) == null) {
            if (view.getId() == R.id.thread_card_root) {
                d.a.s0.e1.c.c.b(view, kVar, 2);
            } else if (view instanceof TbImageView) {
                d.a.s0.e1.c.c.b(view, kVar, 3);
            } else if (view.getId() == R.id.thread_card_title || view.getId() == R.id.thread_card_abstract) {
                d.a.s0.e1.c.c.b(view, kVar, 2);
            }
        }
    }

    public void k0(d.a.c.k.e.s sVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, sVar) == null) {
            this.q = sVar;
        }
    }
}
