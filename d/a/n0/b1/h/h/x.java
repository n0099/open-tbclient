package d.a.n0.b1.h.h;

import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.card.ThreadCardViewHolder;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.VideoPlayActivityConfig;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.ThreadCardUtils;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.NEGFeedBack.NEGFeedBackView;
import com.baidu.tieba.R;
import com.baidu.tieba.card.data.BaseCardInfo;
import d.a.i.a;
import d.a.i.d;
import d.a.i.g0;
import d.a.i.l0;
import d.a.i.n0;
import d.a.i.p0;
import d.a.i.s0;
import d.a.i.v0.a;
/* loaded from: classes4.dex */
public class x extends d.a.n0.b1.a<d.a.n0.z.e0.k, ThreadCardViewHolder<d.a.n0.z.e0.k>> implements d.a.n0.o.f {
    public BdUniqueId n;
    public TbPageContext<?> o;
    public NEGFeedBackView.b p;
    public String q;
    public d.a.c.k.e.s r;
    public d.a.n0.z.b0<d.a.n0.z.e0.k> s;

    /* loaded from: classes4.dex */
    public class a extends d.a.n0.z.b0<d.a.n0.z.e0.k> {
        public a() {
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.a.n0.z.b0
        /* renamed from: d */
        public void a(View view, d.a.n0.z.e0.k kVar) {
            int i2 = 1;
            d.a.n0.z.t.b().d(true);
            d.a.n0.o.d.c().h("page_recommend", "show_");
            if (view == null || kVar == null || kVar.i() == null || StringUtils.isNull(kVar.i().z1())) {
                return;
            }
            int id = view.getId();
            if (id != R.id.thread_card_root && id != R.id.thread_info_commont_container) {
                if (id == R.id.thread_card_voice) {
                    TiebaStatic.log(kVar.f0());
                    d.a.n0.o.d.c().i("page_recommend", "clk_", kVar.f0());
                } else {
                    if (id == R.id.user_avatar) {
                        TiebaStatic.log(kVar.e0());
                        d.a.n0.o.d.c().i("page_recommend", "clk_", kVar.e0());
                    } else if (id == R.id.user_name) {
                        TiebaStatic.log(kVar.e0());
                        d.a.n0.o.d.c().i("page_recommend", "clk_", kVar.e0());
                    } else if (id == R.id.forum_name_text) {
                        TiebaStatic.log(kVar.C());
                        d.a.n0.o.d.c().i("page_recommend", "clk_", kVar.C());
                    } else if (id == R.id.god_reply_voice_btn) {
                        StatisticItem statisticItem = new StatisticItem("c10760");
                        statisticItem.param("obj_locate", 4);
                        TiebaStatic.log(statisticItem);
                    } else if (id == R.id.god_reply_content) {
                        StatisticItem statisticItem2 = new StatisticItem("c10760");
                        statisticItem2.param("obj_locate", 2);
                        TiebaStatic.log(statisticItem2);
                    } else if (id != R.id.god_reply_user_pendant_header && id != R.id.god_reply_username_text) {
                        if (view instanceof TbImageView) {
                            if (view.getTag(R.id.god_reply_image_layout) instanceof Integer) {
                                StatisticItem statisticItem3 = new StatisticItem("c10760");
                                statisticItem3.param("obj_locate", 3);
                                TiebaStatic.log(statisticItem3);
                            }
                            TiebaStatic.log(kVar.b0());
                            d.a.n0.o.d.c().i("page_recommend", "clk_", kVar.b0());
                        }
                    } else {
                        StatisticItem statisticItem4 = new StatisticItem("c10760");
                        statisticItem4.param("obj_locate", 1);
                        TiebaStatic.log(statisticItem4);
                    }
                    i2 = 2;
                }
                i2 = 0;
            } else {
                TiebaStatic.log(kVar.c0("c12642"));
                d.a.n0.o.d.c().i("page_recommend", "clk_", kVar.K());
            }
            if (i2 != 0) {
                d.a.n0.b1.h.m.a.a(kVar.f67177e, x.this.n, kVar.E(), i2);
            }
        }
    }

    /* loaded from: classes4.dex */
    public class b implements d.b {
        public b(x xVar) {
        }

        @Override // d.a.i.d.b
        public void a(d.a.m0.r.q.a aVar, View view) {
            if (aVar != null) {
                if (view.getId() == R.id.user_name) {
                    aVar.objType = 3;
                } else if (view.getId() == R.id.user_avatar) {
                    aVar.objType = 4;
                } else {
                    aVar.objType = 1;
                }
            }
        }
    }

    /* loaded from: classes4.dex */
    public class c implements a.InterfaceC0598a {
        public c() {
        }

        @Override // d.a.i.a.InterfaceC0598a
        public void a(d.a.m0.r.q.a aVar) {
            if (aVar == null || aVar.i() == null || aVar.i().t1 == null) {
                return;
            }
            d.a.m0.z0.t.e(1, x.this.f42909e, aVar.i(), 0, null, VideoPlayActivityConfig.FROM_NANI_VIDEO, "personalize_page", null, "index", "");
        }
    }

    /* loaded from: classes4.dex */
    public class d implements a.InterfaceC0598a {
        public d() {
        }

        @Override // d.a.i.a.InterfaceC0598a
        public void a(d.a.m0.r.q.a aVar) {
            if (aVar == null || aVar.i() == null || aVar.i().t1 == null) {
                return;
            }
            d.a.m0.z0.t.e(1, x.this.f42909e, aVar.i(), 0, null, VideoPlayActivityConfig.FROM_NANI_VIDEO, "personalize_page", null, "index", "");
        }
    }

    /* loaded from: classes4.dex */
    public class e implements d.a.i.w0.a {
        public e() {
        }

        @Override // d.a.i.w0.a
        public void a(d.a.m0.r.q.a aVar) {
            boolean z;
            if (aVar == null || aVar.i() == null || aVar.i().t1 == null) {
                return;
            }
            if (aVar.i().t1.r != null) {
                z = aVar.i().t1.r.is_vertical.intValue() == 1;
            } else {
                z = false;
            }
            d.a.m0.z0.t.d(1, z, x.this.f42909e, aVar.i(), 0, null, VideoPlayActivityConfig.FROM_NANI_VIDEO, "frs_page", null, "frs", "");
        }
    }

    /* loaded from: classes4.dex */
    public class f implements d.a.c.k.e.w {
        public f() {
        }

        @Override // d.a.c.k.e.w
        public void b(View view, d.a.c.k.e.n nVar, BdUniqueId bdUniqueId, ViewGroup viewGroup, int i2, long j) {
            if ((nVar instanceof d.a.n0.z.e0.k) && (view.getTag() instanceof ThreadCardViewHolder)) {
                ThreadCardViewHolder threadCardViewHolder = (ThreadCardViewHolder) view.getTag();
                d.a.n0.z.e0.k kVar = (d.a.n0.z.e0.k) nVar;
                kVar.k = 1;
                if (x.this.s != null) {
                    x.this.s.a(threadCardViewHolder.a(), kVar);
                }
                ThreadCardUtils.jumpToPB((d.a.m0.r.q.a) kVar, view.getContext(), 2, false);
                threadCardViewHolder.b().o(new a.C0600a(1));
            }
        }
    }

    public x(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext.getPageActivity(), bdUniqueId);
        this.p = null;
        this.s = new a();
        this.o = tbPageContext;
        k0();
    }

    @Override // d.a.n0.o.f
    public void g(String str) {
        this.q = str;
    }

    public final void k0() {
        d.a.n0.z.e0.k.V = "c10705";
        d.a.n0.z.e0.k.W = "c10730";
        d.a.n0.z.e0.k.X = "c10731";
        d.a.n0.z.e0.k.Y = "c10704";
        d.a.n0.z.e0.k.Z = "c10755";
        d.a.n0.z.e0.k.a0 = "c10710";
        d.a.n0.z.e0.k.b0 = "c10736";
        d.a.n0.z.e0.k.c0 = "c10737";
        d.a.n0.z.e0.k.d0 = "c10711";
        d.a.n0.z.e0.k.e0 = "c10758";
        d.a.n0.z.e0.k.f0 = "c10757";
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.a.c.k.e.a
    /* renamed from: l0 */
    public ThreadCardViewHolder<d.a.n0.z.e0.k> Q(ViewGroup viewGroup) {
        l0.b bVar = new l0.b(this.o.getPageActivity());
        d.a.i.d dVar = new d.a.i.d(this.o.getPageActivity());
        dVar.t(this.n);
        dVar.c(1024);
        dVar.s(new b(this));
        bVar.o(dVar);
        g0 g0Var = new g0(this.o);
        g0Var.n(Boolean.FALSE);
        g0Var.v("index");
        bVar.n(g0Var);
        g0 g0Var2 = new g0(this.o);
        g0Var2.n(Boolean.TRUE);
        g0Var2.v("index");
        g0Var2.y(UtilHelper.getDimenPixelSize(R.dimen.M_W_X005), UtilHelper.getDimenPixelSize(R.dimen.M_H_X004), UtilHelper.getDimenPixelSize(R.dimen.M_W_X005), UtilHelper.getDimenPixelSize(R.dimen.M_H_X003));
        g0Var2.w(new c());
        bVar.h(g0Var2);
        s0 s0Var = new s0(this.o.getPageActivity());
        s0Var.n(Boolean.TRUE);
        s0Var.v("index");
        s0Var.w(new d());
        s0Var.x(new e());
        bVar.h(s0Var);
        bVar.h(new p0(this.o.getPageActivity()));
        bVar.h(new d.a.i.k(this.o.getPageActivity()));
        n0 n0Var = new n0(this.o.getPageActivity());
        d.a.m0.r.q.e eVar = new d.a.m0.r.q.e();
        eVar.f53670b = 1;
        eVar.f53676h = 1;
        n0Var.v(eVar);
        n0Var.w(1);
        n0Var.A(3);
        n0Var.x(2);
        bVar.m(n0Var);
        l0 k = bVar.k(BaseCardInfo.SupportType.FULL, viewGroup, this.r);
        k.r(2);
        ThreadCardViewHolder<d.a.n0.z.e0.k> threadCardViewHolder = new ThreadCardViewHolder<>(k);
        threadCardViewHolder.k(this.n);
        a0(new f());
        return threadCardViewHolder;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.a.c.k.e.a
    /* renamed from: m0 */
    public View X(int i2, View view, ViewGroup viewGroup, d.a.n0.z.e0.k kVar, ThreadCardViewHolder<d.a.n0.z.e0.k> threadCardViewHolder) {
        if (kVar == null || threadCardViewHolder == null || threadCardViewHolder.a() == null || kVar.f67177e == null) {
            return null;
        }
        kVar.U(kVar.position + 1);
        threadCardViewHolder.b().q(i2);
        d.a.n0.z.t.b().a(kVar.d0("c12641"));
        d.a.n0.o.d.c().i("page_recommend", "show_", kVar.L());
        threadCardViewHolder.b().setPage(this.q);
        threadCardViewHolder.p(true).u(this.p);
        threadCardViewHolder.m(kVar.w(), this.m);
        threadCardViewHolder.f(kVar);
        threadCardViewHolder.b().onChangeSkinType(this.o, TbadkCoreApplication.getInst().getSkinType());
        threadCardViewHolder.b().p(this.s);
        d.a.n0.b1.h.m.a.c(kVar.f67177e, this.n, kVar.E());
        return threadCardViewHolder.a();
    }

    public void p0(NEGFeedBackView.b bVar) {
        this.p = bVar;
    }
}
