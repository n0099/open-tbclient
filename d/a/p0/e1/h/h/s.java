package d.a.p0.e1.h.h;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.card.Align;
import com.baidu.card.ThreadCardViewHolder;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.PbActivityConfig;
import com.baidu.tbadk.core.frameworkData.IntentConfig;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.ThreadCardUtils;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.view.ThreadCommentAndPraiseInfoLayout;
import com.baidu.tieba.NEGFeedBack.NEGFeedBackView;
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
/* loaded from: classes8.dex */
public class s extends d.a.c.k.e.a<d.a.p0.a0.e0.k, ThreadCardViewHolder<d.a.p0.a0.e0.k>> implements d.a.p0.o.f {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public BdUniqueId m;
    public TbPageContext<?> n;
    public d.a.p0.e1.h.k.e o;
    public String p;
    public d.a.c.k.e.s q;
    public NEGFeedBackView.b r;
    public d.a.p0.a0.b0<d.a.p0.a0.e0.k> s;

    /* loaded from: classes8.dex */
    public class a extends d.a.p0.a0.b0<d.a.p0.a0.e0.k> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ s f55592b;

        public a(s sVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {sVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f55592b = sVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.a.p0.a0.b0
        /* renamed from: d */
        public void a(View view, d.a.p0.a0.e0.k kVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, view, kVar) == null) {
                d.a.p0.a0.t.b().d(true);
                d.a.p0.o.d.c().h("page_recommend", "show_");
                if (view == null || this.f55592b.o == null || kVar == null || kVar.getThreadData() == null || StringUtils.isNull(kVar.getThreadData().n1())) {
                    return;
                }
                if ((view.getTag() instanceof String) && !d.a.p0.e1.h.f.b(d.a.c.e.m.b.f(kVar.getThreadData().n1(), 0L))) {
                    d.a.p0.e1.h.f.a(d.a.c.e.m.b.f(kVar.getThreadData().n1(), 0L));
                    this.f55592b.o.e(d.a.c.e.m.b.f(kVar.getThreadData().n1(), 0L), kVar.C(), kVar.p(), kVar.o(), kVar.c(), d.a.c.e.m.b.d((String) view.getTag(), 1), "homepage", kVar.getThreadData().J());
                }
                this.f55592b.l0(view, kVar);
            }
        }
    }

    /* loaded from: classes8.dex */
    public class b implements d.a.c.k.e.w {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ s f55593e;

        public b(s sVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {sVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f55593e = sVar;
        }

        @Override // d.a.c.k.e.w
        public void b(View view, d.a.c.k.e.n nVar, BdUniqueId bdUniqueId, ViewGroup viewGroup, int i2, long j) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{view, nVar, bdUniqueId, viewGroup, Integer.valueOf(i2), Long.valueOf(j)}) == null) && (nVar instanceof d.a.p0.a0.e0.k) && (view.getTag() instanceof ThreadCardViewHolder)) {
                ThreadCardViewHolder threadCardViewHolder = (ThreadCardViewHolder) view.getTag();
                d.a.p0.a0.e0.k kVar = (d.a.p0.a0.e0.k) nVar;
                kVar.k = 1;
                if (this.f55593e.s != null) {
                    this.f55593e.s.a(threadCardViewHolder.a(), kVar);
                }
                ThreadCardUtils.jumpToPB((d.a.o0.r.q.a) kVar, view.getContext(), 2, false, d.a.j.e.a((d.a.c.k.e.s) viewGroup, view, i2));
                threadCardViewHolder.b().o(new a.C0611a(1));
            }
        }
    }

    /* loaded from: classes8.dex */
    public class c implements ThreadCommentAndPraiseInfoLayout.i {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ ViewGroup f55594a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ View f55595b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ int f55596c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ d.a.p0.a0.e0.k f55597d;

        public c(s sVar, ViewGroup viewGroup, View view, int i2, d.a.p0.a0.e0.k kVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {sVar, viewGroup, view, Integer.valueOf(i2), kVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f55594a = viewGroup;
            this.f55595b = view;
            this.f55596c = i2;
            this.f55597d = kVar;
        }

        @Override // com.baidu.tbadk.core.view.ThreadCommentAndPraiseInfoLayout.i
        public void a(IntentConfig intentConfig) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, intentConfig) == null) && (intentConfig instanceof PbActivityConfig)) {
                ((PbActivityConfig) intentConfig).setVideoOriginArea(d.a.j.e.a((d.a.c.k.e.s) this.f55594a, this.f55595b, this.f55596c));
                if (this.f55597d.getThreadData() == null || this.f55597d.getThreadData().Z0() == null) {
                    return;
                }
                StatisticItem q = this.f55597d.q(d.a.p0.a0.e0.k.n0);
                q.param("obj_type", this.f55597d.getThreadData().Z0().id);
                q.param("obj_name", this.f55597d.getThreadData().Z0().name);
                TiebaStatic.log(q);
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public s(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId) {
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
        i0();
    }

    @Override // d.a.p0.o.f
    public void g(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str) == null) {
            this.p = str;
        }
    }

    public final void i0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            d.a.p0.a0.e0.k.X = "c10730";
            d.a.p0.a0.e0.k.Y = "c10731";
            d.a.p0.a0.e0.k.Z = "c10704";
            d.a.p0.a0.e0.k.a0 = "c10755";
            d.a.p0.a0.e0.k.b0 = "c10710";
            d.a.p0.a0.e0.k.c0 = "c10736";
            d.a.p0.a0.e0.k.i0 = "c10737";
            d.a.p0.a0.e0.k.j0 = "c10711";
            d.a.p0.a0.e0.k.k0 = "c10758";
            d.a.p0.a0.e0.k.l0 = "c10757";
            d.a.p0.a0.e0.k.o0 = "c10734";
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.a.c.k.e.a
    /* renamed from: j0 */
    public ThreadCardViewHolder Q(ViewGroup viewGroup) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, viewGroup)) == null) {
            l0.b bVar = new l0.b(this.n.getPageActivity(), false);
            n0 n0Var = new n0(this.n.getPageActivity());
            d.a.o0.r.q.f fVar = new d.a.o0.r.q.f();
            fVar.f52647b = 1;
            fVar.f52653h = 1;
            n0Var.v(fVar);
            n0Var.w(1);
            n0Var.B("personalize_page");
            n0Var.A(3);
            n0Var.x(2);
            n0Var.b(32);
            bVar.m(n0Var);
            l0 k = bVar.k(BaseCardInfo.SupportType.BOTTOM, viewGroup, this.q);
            k.r(2);
            ThreadCardViewHolder threadCardViewHolder = new ThreadCardViewHolder(k);
            threadCardViewHolder.j(this.m);
            a0(new b(this));
            return threadCardViewHolder;
        }
        return (ThreadCardViewHolder) invokeL.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.a.c.k.e.a
    /* renamed from: k0 */
    public View X(int i2, View view, ViewGroup viewGroup, d.a.p0.a0.e0.k kVar, ThreadCardViewHolder threadCardViewHolder) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048581, this, new Object[]{Integer.valueOf(i2), view, viewGroup, kVar, threadCardViewHolder})) == null) {
            if (kVar == null || threadCardViewHolder == null || threadCardViewHolder.a() == null || kVar.f53795e == null) {
                return null;
            }
            kVar.I(kVar.position + 1);
            threadCardViewHolder.b().q(i2);
            threadCardViewHolder.b().setPage(this.p);
            if (threadCardViewHolder.b().e() instanceof n0) {
                ((n0) threadCardViewHolder.b().e()).z(new c(this, viewGroup, view, i2, kVar));
            }
            threadCardViewHolder.p(false, Align.ALIGN_RIGHT_BOTTOM, this.r);
            threadCardViewHolder.f(kVar);
            threadCardViewHolder.b().onChangeSkinType(this.n, TbadkCoreApplication.getInst().getSkinType());
            threadCardViewHolder.b().p(this.s);
            d.a.p0.a0.t.b().a(kVar.z());
            d.a.p0.o.d.c().a(kVar.z());
            d.a.p0.e1.h.m.a.c(kVar.f53795e, this.m, kVar.o());
            return threadCardViewHolder.a();
        }
        return (View) invokeCommon.objValue;
    }

    /* JADX WARN: Removed duplicated region for block: B:42:0x00db  */
    /* JADX WARN: Removed duplicated region for block: B:47:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void l0(View view, d.a.p0.a0.e0.k kVar) {
        StatisticItem y;
        Interceptable interceptable = $ic;
        if (interceptable != null && interceptable.invokeLL(1048582, this, view, kVar) != null) {
            return;
        }
        int id = view.getId();
        int i2 = 5;
        if (view.getId() != R.id.thread_card_root && id != R.id.thread_info_commont_container) {
            if (id == R.id.thread_card_voice) {
                TiebaStatic.log(kVar.T());
                d.a.p0.o.d.c().i("page_recommend", "clk_", kVar.T());
            } else {
                if (id == R.id.user_avatar) {
                    TiebaStatic.log(kVar.S());
                    d.a.p0.o.d.c().i("page_recommend", "clk_", kVar.S());
                } else if (id == R.id.user_name) {
                    TiebaStatic.log(kVar.S());
                    d.a.p0.o.d.c().i("page_recommend", "clk_", kVar.S());
                } else {
                    if (id == R.id.forum_name_text) {
                        TiebaStatic.log(kVar.h());
                        d.a.p0.o.d.c().i("page_recommend", "clk_", kVar.h());
                        i2 = 9;
                    } else if (id == R.id.god_reply_voice_btn) {
                        StatisticItem statisticItem = new StatisticItem("c10760");
                        statisticItem.param("obj_locate", 4);
                        TiebaStatic.log(statisticItem);
                    } else if (id == R.id.god_reply_content) {
                        StatisticItem statisticItem2 = new StatisticItem("c10760");
                        statisticItem2.param("obj_locate", 2);
                        TiebaStatic.log(statisticItem2);
                    } else if (id == R.id.god_reply_user_pendant_header || id == R.id.god_reply_username_text) {
                        StatisticItem statisticItem3 = new StatisticItem("c10760");
                        statisticItem3.param("obj_locate", 1);
                        TiebaStatic.log(statisticItem3);
                    } else {
                        i2 = 0;
                    }
                    if (i2 != 0) {
                        d.a.p0.e1.h.m.a.a(kVar.f53795e, this.m, kVar.o(), i2);
                        return;
                    }
                    return;
                }
                i2 = 2;
                if (i2 != 0) {
                }
            }
        } else {
            if (d.a.p0.a0.e0.l.R(kVar.f53795e)) {
                y = kVar.B();
                TiebaStatic.log(y);
            } else {
                y = kVar.y();
                TiebaStatic.log(y);
            }
            d.a.p0.o.d.c().i("page_recommend", "clk_", y);
        }
        i2 = 1;
        if (i2 != 0) {
        }
    }

    public void m0(NEGFeedBackView.b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, bVar) == null) {
            this.r = bVar;
        }
    }

    public void p0(d.a.p0.e1.h.k.e eVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, eVar) == null) {
            this.o = eVar;
        }
    }

    public void q0(d.a.c.k.e.s sVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048585, this, sVar) == null) {
            this.q = sVar;
        }
    }
}
