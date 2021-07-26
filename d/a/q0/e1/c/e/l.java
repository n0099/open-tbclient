package d.a.q0.e1.c.e;

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
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.ThreadCardUtils;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tieba.NEGFeedBack.NEGFeedBackView;
import com.baidu.tieba.R;
import com.baidu.tieba.card.data.BaseCardInfo;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import d.a.k.l0;
import d.a.k.v0.a;
import d.a.q0.a0.b0;
/* loaded from: classes8.dex */
public class l extends d.a.d.k.e.a<d.a.q0.a0.e0.k, ThreadCardViewHolder<d.a.q0.a0.e0.k>> implements d.a.q0.o.f {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public BdUniqueId m;
    public TbPageContext<?> n;
    public String o;
    public d.a.d.k.e.s p;
    public NEGFeedBackView.b q;
    public b0<d.a.q0.a0.e0.k> r;

    /* loaded from: classes8.dex */
    public class a extends b0<d.a.q0.a0.e0.k> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ l f55707b;

        public a(l lVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {lVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f55707b = lVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.a.q0.a0.b0
        /* renamed from: d */
        public void a(View view, d.a.q0.a0.e0.k kVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, view, kVar) == null) {
                d.a.q0.a0.t.b().d(true);
                if (view == null || kVar == null || kVar.getThreadData() == null || StringUtils.isNull(kVar.getThreadData().o1())) {
                    return;
                }
                this.f55707b.k0(view, kVar);
            }
        }
    }

    /* loaded from: classes8.dex */
    public class b implements d.a.d.k.e.w {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ l f55708e;

        public b(l lVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {lVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f55708e = lVar;
        }

        @Override // d.a.d.k.e.w
        public void b(View view, d.a.d.k.e.n nVar, BdUniqueId bdUniqueId, ViewGroup viewGroup, int i2, long j) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{view, nVar, bdUniqueId, viewGroup, Integer.valueOf(i2), Long.valueOf(j)}) == null) && (nVar instanceof d.a.q0.a0.e0.k) && (view.getTag() instanceof ThreadCardViewHolder)) {
                ThreadCardViewHolder threadCardViewHolder = (ThreadCardViewHolder) view.getTag();
                d.a.q0.a0.e0.k kVar = (d.a.q0.a0.e0.k) nVar;
                kVar.k = 1;
                if (this.f55708e.r != null) {
                    this.f55708e.r.a(threadCardViewHolder.a(), kVar);
                }
                ThreadCardUtils.jumpToPB((d.a.p0.s.q.a) kVar, view.getContext(), 2, false, d.a.k.e.a((d.a.d.k.e.s) viewGroup, view, i2));
                threadCardViewHolder.b().o(new a.C0620a(1));
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public l(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId) {
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
        this.n = tbPageContext;
        g0();
    }

    @Override // d.a.q0.o.f
    public void g(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str) == null) {
            this.o = str;
        }
    }

    public final void g0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            d.a.q0.a0.e0.k.W = "c10705";
            d.a.q0.a0.e0.k.X = "c10730";
            d.a.q0.a0.e0.k.Y = "c10731";
            d.a.q0.a0.e0.k.Z = "c10704";
            d.a.q0.a0.e0.k.a0 = "c10755";
            d.a.q0.a0.e0.k.b0 = "c10710";
            d.a.q0.a0.e0.k.c0 = "c10736";
            d.a.q0.a0.e0.k.i0 = "c10737";
            d.a.q0.a0.e0.k.j0 = "c10711";
            d.a.q0.a0.e0.k.k0 = "c10758";
            d.a.q0.a0.e0.k.l0 = "c10757";
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.a.d.k.e.a
    /* renamed from: i0 */
    public ThreadCardViewHolder Q(ViewGroup viewGroup) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, viewGroup)) == null) {
            l0.b bVar = new l0.b(this.n.getPageActivity());
            bVar.o(new d.a.k.m(this.n.getPageActivity()));
            l0 k = bVar.k(BaseCardInfo.SupportType.TOP, viewGroup, this.p);
            k.r(1);
            ThreadCardViewHolder threadCardViewHolder = new ThreadCardViewHolder(k);
            threadCardViewHolder.j(this.m);
            a0(new b(this));
            return threadCardViewHolder;
        }
        return (ThreadCardViewHolder) invokeL.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.a.d.k.e.a
    /* renamed from: j0 */
    public View X(int i2, View view, ViewGroup viewGroup, d.a.q0.a0.e0.k kVar, ThreadCardViewHolder<d.a.q0.a0.e0.k> threadCardViewHolder) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048581, this, new Object[]{Integer.valueOf(i2), view, viewGroup, kVar, threadCardViewHolder})) == null) {
            if (kVar == null || threadCardViewHolder == null || threadCardViewHolder.a() == null || kVar.f54338e == null) {
                return null;
            }
            kVar.I(kVar.position + 1);
            threadCardViewHolder.b().q(i2);
            threadCardViewHolder.b().setPage(this.o);
            threadCardViewHolder.p(false, Align.ALIGN_RIGHT_TOP, this.q);
            threadCardViewHolder.f(kVar);
            threadCardViewHolder.b().onChangeSkinType(this.n, TbadkCoreApplication.getInst().getSkinType());
            threadCardViewHolder.b().p(this.r);
            d.a.q0.a0.t.b().a(kVar.z());
            d.a.q0.o.d.c().a(kVar.z());
            d.a.q0.e1.h.m.a.f(kVar.f54338e, this.m, kVar.o());
            return threadCardViewHolder.a();
        }
        return (View) invokeCommon.objValue;
    }

    public final void k0(View view, d.a.q0.a0.e0.k kVar) {
        int i2;
        StatisticItem y;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048582, this, view, kVar) == null) {
            int id = view.getId();
            if (kVar == null) {
                return;
            }
            if (id != R.id.forum_head_image && id != R.id.forum_head_barname && id != R.id.forum_head_info_attention && id != R.id.forum_head_info_thread) {
                if (kVar.E()) {
                    y = kVar.B();
                } else {
                    y = kVar.y();
                }
                TiebaStatic.log(y);
                d.a.q0.o.d.c().i("page_concern", "clk_", y);
                i2 = 1;
            } else {
                TiebaStatic.log(kVar.h());
                d.a.q0.o.d.c().i("page_concern", "clk_", kVar.h());
                i2 = 9;
            }
            if (i2 != 0) {
                d.a.q0.e1.h.m.a.c(kVar.f54338e, this.m, kVar.o(), i2);
            }
        }
    }

    public void l0(d.a.d.k.e.s sVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, sVar) == null) {
            this.p = sVar;
        }
    }
}
