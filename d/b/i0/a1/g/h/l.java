package d.b.i0.a1.g.h;

import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.card.ThreadCardViewHolder;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.ThreadCardUtils;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.NEGFeedBack.NEGFeedBackView;
import com.baidu.tieba.R;
import d.b.i.d;
import d.b.i.k0;
import d.b.i.m0;
import d.b.i.u0.a;
/* loaded from: classes4.dex */
public class l extends d.b.i0.a1.a<d.b.i0.x.e0.k, ThreadCardViewHolder<d.b.i0.x.e0.k>> implements d.b.i0.m.f {
    public BdUniqueId n;
    public TbPageContext<?> o;
    public NEGFeedBackView.b p;
    public String q;
    public boolean r;
    public d.b.i0.x.b0<d.b.i0.x.e0.k> s;

    /* loaded from: classes4.dex */
    public class a extends d.b.i0.x.b0<d.b.i0.x.e0.k> {
        public a() {
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.b.i0.x.b0
        /* renamed from: d */
        public void a(View view, d.b.i0.x.e0.k kVar) {
            int i = 1;
            d.b.i0.x.t.b().d(true);
            d.b.i0.m.d.c().h("page_recommend", "show_");
            if (kVar == null || kVar.n() == null || d.b.c.e.p.k.isEmpty(kVar.n().w1())) {
                return;
            }
            int id = view.getId();
            if (id == R.id.thread_card_root) {
                TiebaStatic.log(kVar.K());
                d.b.i0.m.d.c().i("page_recommend", "clk_", kVar.K());
            } else if (id == R.id.thread_info_commont_container) {
                TiebaStatic.log(kVar.K());
                d.b.i0.m.d.c().i("page_recommend", "clk_", kVar.K());
                i = 5;
            } else {
                if (id == R.id.thread_card_voice) {
                    TiebaStatic.log(kVar.f0());
                    d.b.i0.m.d.c().i("page_recommend", "clk_", kVar.f0());
                } else {
                    if (id == R.id.user_avatar) {
                        TiebaStatic.log(kVar.e0());
                        d.b.i0.m.d.c().i("page_recommend", "clk_", kVar.e0());
                    } else if (id == R.id.user_name) {
                        TiebaStatic.log(kVar.e0());
                        d.b.i0.m.d.c().i("page_recommend", "clk_", kVar.e0());
                    } else if (id == R.id.forum_name_text) {
                        TiebaStatic.log(kVar.C());
                        d.b.i0.m.d.c().i("page_recommend", "clk_", kVar.C());
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
                            d.b.i0.m.d.c().i("page_recommend", "clk_", kVar.b0());
                        }
                    } else {
                        StatisticItem statisticItem4 = new StatisticItem("c10760");
                        statisticItem4.param("obj_locate", 1);
                        TiebaStatic.log(statisticItem4);
                    }
                    i = 2;
                }
                i = 0;
            }
            if (i != 0) {
                d.b.i0.a1.g.m.a.a(kVar.f63772e, l.this.n, kVar.E(), i);
            }
        }
    }

    /* loaded from: classes4.dex */
    public class b implements d.b {
        public b(l lVar) {
        }

        @Override // d.b.i.d.b
        public void a(d.b.h0.r.q.a aVar, View view) {
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
    public class c implements d.b.c.j.e.w {
        public c() {
        }

        @Override // d.b.c.j.e.w
        public void f(View view, d.b.c.j.e.n nVar, BdUniqueId bdUniqueId, ViewGroup viewGroup, int i, long j) {
            if ((nVar instanceof d.b.i0.x.e0.k) && (view.getTag() instanceof ThreadCardViewHolder)) {
                ThreadCardViewHolder threadCardViewHolder = (ThreadCardViewHolder) view.getTag();
                d.b.i0.x.e0.k kVar = (d.b.i0.x.e0.k) nVar;
                kVar.k = 1;
                if (l.this.s != null) {
                    l.this.s.a(threadCardViewHolder.a(), kVar);
                }
                ThreadCardUtils.jumpToPB((d.b.h0.r.q.a) kVar, view.getContext(), 2, false);
                threadCardViewHolder.b().o(new a.C1131a(1));
            }
        }
    }

    public l(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext.getPageActivity(), bdUniqueId);
        this.p = null;
        this.r = true;
        this.s = new a();
        this.o = tbPageContext;
        j0();
    }

    public final void j0() {
        d.b.i0.x.e0.k.U = "c10705";
        d.b.i0.x.e0.k.V = "c10730";
        d.b.i0.x.e0.k.W = "c10731";
        d.b.i0.x.e0.k.X = "c10704";
        d.b.i0.x.e0.k.Y = "c10755";
        d.b.i0.x.e0.k.Z = "c10710";
        d.b.i0.x.e0.k.a0 = "c10736";
        d.b.i0.x.e0.k.b0 = "c10737";
        d.b.i0.x.e0.k.c0 = "c10711";
        d.b.i0.x.e0.k.d0 = "c10758";
        d.b.i0.x.e0.k.e0 = "c10757";
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.b.c.j.e.a
    /* renamed from: l0 */
    public ThreadCardViewHolder<d.b.i0.x.e0.k> R(ViewGroup viewGroup) {
        k0.b bVar = new k0.b(this.o.getPageActivity());
        d.b.i.d dVar = new d.b.i.d(this.o.getPageActivity());
        dVar.t(this.n);
        dVar.c(1024);
        dVar.s(new b(this));
        bVar.o(dVar);
        bVar.n(new d.b.i.t(this.o.getPageActivity()));
        bVar.h(new d.b.i.k(this.o.getPageActivity()));
        d.b.i.n nVar = new d.b.i.n(this.o.getPageActivity());
        nVar.x(this.r);
        nVar.w("index");
        nVar.y(new StatisticItem("c13342"));
        bVar.h(nVar);
        m0 m0Var = new m0(this.o.getPageActivity());
        d.b.h0.r.q.e eVar = new d.b.h0.r.q.e();
        eVar.f51170b = 1;
        eVar.f51176h = 1;
        m0Var.v(eVar);
        m0Var.w(1);
        m0Var.A(3);
        m0Var.x(2);
        bVar.m(m0Var);
        k0 i = bVar.i();
        i.r(2);
        ThreadCardViewHolder<d.b.i0.x.e0.k> threadCardViewHolder = new ThreadCardViewHolder<>(i);
        threadCardViewHolder.k(this.n);
        c0(new c());
        return threadCardViewHolder;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.b.c.j.e.a
    /* renamed from: m0 */
    public View X(int i, View view, ViewGroup viewGroup, d.b.i0.x.e0.k kVar, ThreadCardViewHolder<d.b.i0.x.e0.k> threadCardViewHolder) {
        if (kVar == null || threadCardViewHolder == null || threadCardViewHolder.b() == null) {
            return null;
        }
        kVar.U(kVar.position + 1);
        d.b.i0.x.t.b().a(kVar.a0("c12190"));
        if (threadCardViewHolder.b() instanceof d.b.i0.m.e) {
            threadCardViewHolder.b().setPage(this.q);
        }
        d.b.i.b0 p = threadCardViewHolder.p(true);
        p.u(this.p);
        threadCardViewHolder.m(kVar.w(), this.m);
        p.a(kVar.g());
        threadCardViewHolder.f(kVar);
        threadCardViewHolder.j(this.s);
        threadCardViewHolder.b().onChangeSkinType(this.o, TbadkCoreApplication.getInst().getSkinType());
        d.b.i0.a1.g.m.a.c(kVar.f63772e, this.n, kVar.E());
        return threadCardViewHolder.a();
    }

    public void n0(NEGFeedBackView.b bVar) {
        this.p = bVar;
    }

    @Override // d.b.i0.m.f
    public void o(String str) {
        this.q = str;
    }

    public void setFromCDN(boolean z) {
        this.r = z;
    }
}
