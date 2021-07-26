package d.a.q0.e1.h.h;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.card.ThreadCardViewHolder;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.ThreadCardUtils;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.NEGFeedBack.NEGFeedBackView;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import d.a.k.d;
import d.a.k.l0;
import d.a.k.n0;
import d.a.k.v0.a;
/* loaded from: classes8.dex */
public class l extends d.a.q0.e1.a<d.a.q0.a0.e0.k, ThreadCardViewHolder<d.a.q0.a0.e0.k>> implements d.a.q0.o.f {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public BdUniqueId n;
    public TbPageContext<?> o;
    public NEGFeedBackView.b p;
    public String q;
    public boolean r;
    public d.a.q0.a0.b0<d.a.q0.a0.e0.k> s;

    /* loaded from: classes8.dex */
    public class a extends d.a.q0.a0.b0<d.a.q0.a0.e0.k> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ l f56119b;

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
            this.f56119b = lVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.a.q0.a0.b0
        /* renamed from: d */
        public void a(View view, d.a.q0.a0.e0.k kVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, view, kVar) == null) {
                int i2 = 1;
                d.a.q0.a0.t.b().d(true);
                d.a.q0.o.d.c().h("page_recommend", "show_");
                if (kVar == null || kVar.getThreadData() == null || d.a.d.e.p.k.isEmpty(kVar.getThreadData().o1())) {
                    return;
                }
                int id = view.getId();
                if (id == R.id.thread_card_root) {
                    TiebaStatic.log(kVar.y());
                    d.a.q0.o.d.c().i("page_recommend", "clk_", kVar.y());
                    d.a.q0.e1.h.m.a.b(kVar.f54338e, kVar.o(), 1);
                } else if (id == R.id.thread_info_commont_container) {
                    TiebaStatic.log(kVar.y());
                    d.a.q0.o.d.c().i("page_recommend", "clk_", kVar.y());
                    d.a.q0.e1.h.m.a.b(kVar.f54338e, kVar.o(), 1);
                    i2 = 5;
                } else {
                    if (id == R.id.thread_card_voice) {
                        TiebaStatic.log(kVar.T());
                        d.a.q0.o.d.c().i("page_recommend", "clk_", kVar.T());
                    } else {
                        if (id == R.id.user_avatar) {
                            TiebaStatic.log(kVar.S());
                            d.a.q0.o.d.c().i("page_recommend", "clk_", kVar.S());
                        } else if (id == R.id.user_name) {
                            TiebaStatic.log(kVar.S());
                            d.a.q0.o.d.c().i("page_recommend", "clk_", kVar.S());
                        } else if (id == R.id.forum_name_text) {
                            TiebaStatic.log(kVar.h());
                            d.a.q0.o.d.c().i("page_recommend", "clk_", kVar.h());
                        } else if (id == R.id.god_reply_voice_btn) {
                            StatisticItem statisticItem = new StatisticItem("c10760");
                            statisticItem.param("obj_locate", 4);
                            TiebaStatic.log(statisticItem);
                        } else if (id == R.id.god_reply_content) {
                            StatisticItem statisticItem2 = new StatisticItem("c10760");
                            statisticItem2.param("obj_locate", 2);
                            TiebaStatic.log(statisticItem2);
                            d.a.q0.e1.h.m.a.b(kVar.f54338e, kVar.o(), 1);
                        } else if (id != R.id.god_reply_user_pendant_header && id != R.id.god_reply_username_text) {
                            if (view instanceof TbImageView) {
                                if (view.getTag(R.id.god_reply_image_layout) instanceof Integer) {
                                    StatisticItem statisticItem3 = new StatisticItem("c10760");
                                    statisticItem3.param("obj_locate", 3);
                                    TiebaStatic.log(statisticItem3);
                                }
                                TiebaStatic.log(kVar.P());
                                d.a.q0.o.d.c().i("page_recommend", "clk_", kVar.P());
                                d.a.q0.e1.h.m.a.b(kVar.f54338e, kVar.o(), 2);
                            }
                        } else {
                            StatisticItem statisticItem4 = new StatisticItem("c10760");
                            statisticItem4.param("obj_locate", 1);
                            TiebaStatic.log(statisticItem4);
                        }
                        i2 = 2;
                    }
                    i2 = 0;
                }
                if (i2 != 0) {
                    d.a.q0.e1.h.m.a.c(kVar.f54338e, this.f56119b.n, kVar.o(), i2);
                }
            }
        }
    }

    /* loaded from: classes8.dex */
    public class b implements d.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

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
                }
            }
        }

        @Override // d.a.k.d.b
        public void a(d.a.p0.s.q.a aVar, View view) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeLL(1048576, this, aVar, view) == null) || aVar == null) {
                return;
            }
            if (view.getId() == R.id.user_name) {
                aVar.objType = 3;
            } else if (view.getId() == R.id.user_avatar) {
                aVar.objType = 4;
            } else {
                aVar.objType = 1;
            }
        }
    }

    /* loaded from: classes8.dex */
    public class c implements d.a.d.k.e.w {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ l f56120e;

        public c(l lVar) {
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
            this.f56120e = lVar;
        }

        @Override // d.a.d.k.e.w
        public void b(View view, d.a.d.k.e.n nVar, BdUniqueId bdUniqueId, ViewGroup viewGroup, int i2, long j) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{view, nVar, bdUniqueId, viewGroup, Integer.valueOf(i2), Long.valueOf(j)}) == null) && (nVar instanceof d.a.q0.a0.e0.k) && (view.getTag() instanceof ThreadCardViewHolder)) {
                ThreadCardViewHolder threadCardViewHolder = (ThreadCardViewHolder) view.getTag();
                d.a.q0.a0.e0.k kVar = (d.a.q0.a0.e0.k) nVar;
                kVar.k = 1;
                if (this.f56120e.s != null) {
                    this.f56120e.s.a(threadCardViewHolder.a(), kVar);
                }
                ThreadCardUtils.jumpToPB((d.a.p0.s.q.a) kVar, view.getContext(), 2, false);
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
        this.p = null;
        this.r = true;
        this.s = new a(this);
        this.o = tbPageContext;
        g0();
    }

    @Override // d.a.q0.o.f
    public void g(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str) == null) {
            this.q = str;
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
    public ThreadCardViewHolder<d.a.q0.a0.e0.k> Q(ViewGroup viewGroup) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, viewGroup)) == null) {
            l0.b bVar = new l0.b(this.o.getPageActivity());
            d.a.k.d dVar = new d.a.k.d(this.o.getPageActivity());
            dVar.t(this.n);
            dVar.c(1024);
            dVar.s(new b(this));
            bVar.o(dVar);
            bVar.n(new d.a.k.t(this.o.getPageActivity()));
            bVar.h(new d.a.k.k(this.o.getPageActivity()));
            d.a.k.n nVar = new d.a.k.n(this.o.getPageActivity());
            nVar.x(this.r);
            nVar.w("index");
            nVar.y(new StatisticItem("c13342"));
            bVar.h(nVar);
            n0 n0Var = new n0(this.o.getPageActivity());
            d.a.p0.s.q.f fVar = new d.a.p0.s.q.f();
            fVar.f53311b = 1;
            fVar.f53317h = 1;
            n0Var.v(fVar);
            n0Var.w(1);
            n0Var.A(3);
            n0Var.x(2);
            bVar.m(n0Var);
            l0 i2 = bVar.i();
            i2.r(2);
            ThreadCardViewHolder<d.a.q0.a0.e0.k> threadCardViewHolder = new ThreadCardViewHolder<>(i2);
            threadCardViewHolder.j(this.n);
            a0(new c(this));
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
            if (kVar == null || threadCardViewHolder == null || threadCardViewHolder.b() == null) {
                return null;
            }
            kVar.I(kVar.position + 1);
            kVar.f54338e.P1 = kVar.o();
            d.a.q0.a0.t.b().a(kVar.O("c12190"));
            if (threadCardViewHolder.b() instanceof d.a.q0.o.e) {
                threadCardViewHolder.b().setPage(this.q);
            }
            d.a.k.b0 o = threadCardViewHolder.o(true);
            o.u(this.p);
            threadCardViewHolder.l(kVar.showFollowBtn(), this.m);
            o.a(kVar.getNegFeedBackData());
            threadCardViewHolder.f(kVar);
            threadCardViewHolder.i(this.s);
            threadCardViewHolder.b().onChangeSkinType(this.o, TbadkCoreApplication.getInst().getSkinType());
            d.a.q0.e1.h.m.a.f(kVar.f54338e, this.n, kVar.o());
            d.a.q0.e1.h.m.a.e(kVar.f54338e, kVar.o());
            return threadCardViewHolder.a();
        }
        return (View) invokeCommon.objValue;
    }

    public void k0(NEGFeedBackView.b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, bVar) == null) {
            this.p = bVar;
        }
    }

    public void setFromCDN(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048583, this, z) == null) {
            this.r = z;
        }
    }
}
