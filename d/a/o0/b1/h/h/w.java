package d.a.o0.b1.h.h;

import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.card.ThreadCardViewHolder;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.ThreadCardUtils;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.NEGFeedBack.NEGFeedBackView;
import com.baidu.tieba.R;
import d.a.i.d;
import d.a.i.l0;
import d.a.i.n0;
import d.a.i.p0;
import d.a.i.q0;
import d.a.i.v0.a;
/* loaded from: classes4.dex */
public class w extends d.a.o0.b1.a<d.a.o0.z.e0.k, ThreadCardViewHolder<d.a.o0.z.e0.k>> implements d.a.o0.o.f {
    public BdUniqueId n;
    public TbPageContext<?> o;
    public NEGFeedBackView.b p;
    public String q;
    public boolean r;
    public d.a.o0.z.b0<d.a.o0.z.e0.k> s;

    /* loaded from: classes4.dex */
    public class a extends d.a.o0.z.b0<d.a.o0.z.e0.k> {
        public a() {
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.a.o0.z.b0
        /* renamed from: d */
        public void a(View view, d.a.o0.z.e0.k kVar) {
            int i2 = 1;
            d.a.o0.z.t.b().d(true);
            d.a.o0.o.d.c().h("page_recommend", "show_");
            if (view == null || kVar == null || kVar.i() == null || StringUtils.isNull(kVar.i().z1())) {
                return;
            }
            int id = view.getId();
            if (id != R.id.thread_card_root && id != R.id.thread_info_commont_container) {
                if (id == R.id.thread_card_voice) {
                    TiebaStatic.log(kVar.f0());
                    d.a.o0.o.d.c().i("page_recommend", "clk_", kVar.f0());
                } else {
                    if (id == R.id.user_avatar) {
                        TiebaStatic.log(kVar.e0());
                        d.a.o0.o.d.c().i("page_recommend", "clk_", kVar.e0());
                    } else if (id == R.id.user_name) {
                        TiebaStatic.log(kVar.e0());
                        d.a.o0.o.d.c().i("page_recommend", "clk_", kVar.e0());
                    } else if (id == R.id.forum_name_text) {
                        TiebaStatic.log(kVar.C());
                        d.a.o0.o.d.c().i("page_recommend", "clk_", kVar.C());
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
                            d.a.o0.o.d.c().i("page_recommend", "clk_", kVar.b0());
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
                d.a.o0.o.d.c().i("page_recommend", "clk_", kVar.K());
            }
            if (i2 != 0) {
                d.a.o0.b1.h.m.a.a(kVar.f67302e, w.this.n, kVar.E(), i2);
            }
        }
    }

    /* loaded from: classes4.dex */
    public class b implements d.b {
        public b(w wVar) {
        }

        @Override // d.a.i.d.b
        public void a(d.a.n0.r.q.a aVar, View view) {
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
    public class c implements d.a.c.k.e.w {
        public c() {
        }

        @Override // d.a.c.k.e.w
        public void b(View view, d.a.c.k.e.n nVar, BdUniqueId bdUniqueId, ViewGroup viewGroup, int i2, long j) {
            if ((nVar instanceof d.a.o0.z.e0.k) && (view.getTag() instanceof ThreadCardViewHolder)) {
                ThreadCardViewHolder threadCardViewHolder = (ThreadCardViewHolder) view.getTag();
                d.a.o0.z.e0.k kVar = (d.a.o0.z.e0.k) nVar;
                kVar.k = 1;
                if (w.this.s != null) {
                    w.this.s.a(threadCardViewHolder.a(), kVar);
                }
                ThreadCardUtils.jumpToPB((d.a.n0.r.q.a) kVar, view.getContext(), 2, false);
                threadCardViewHolder.b().o(new a.C0602a(1));
            }
        }
    }

    public w(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext.getPageActivity(), bdUniqueId);
        this.p = null;
        this.r = true;
        this.s = new a();
        this.o = tbPageContext;
        h0();
    }

    @Override // d.a.o0.o.f
    public void g(String str) {
        this.q = str;
    }

    public final void h0() {
        d.a.o0.z.e0.k.V = "c10705";
        d.a.o0.z.e0.k.W = "c10730";
        d.a.o0.z.e0.k.X = "c10731";
        d.a.o0.z.e0.k.Y = "c10704";
        d.a.o0.z.e0.k.Z = "c10755";
        d.a.o0.z.e0.k.a0 = "c10710";
        d.a.o0.z.e0.k.b0 = "c10736";
        d.a.o0.z.e0.k.c0 = "c10737";
        d.a.o0.z.e0.k.i0 = "c10711";
        d.a.o0.z.e0.k.j0 = "c10758";
        d.a.o0.z.e0.k.k0 = "c10757";
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.a.c.k.e.a
    /* renamed from: i0 */
    public ThreadCardViewHolder<d.a.o0.z.e0.k> Q(ViewGroup viewGroup) {
        l0.b bVar = new l0.b(this.o.getPageActivity());
        d.a.i.d dVar = new d.a.i.d(this.o.getPageActivity());
        dVar.t(this.n);
        dVar.c(1024);
        dVar.s(new b(this));
        bVar.o(dVar);
        q0 q0Var = new q0(this.o.getPageActivity());
        bVar.n(q0Var);
        q0Var.u(2);
        bVar.h(new p0(this.o.getPageActivity()));
        bVar.h(new d.a.i.k(this.o.getPageActivity()));
        d.a.i.n nVar = new d.a.i.n(this.o.getPageActivity());
        nVar.x(this.r);
        nVar.w("index");
        bVar.h(nVar);
        n0 n0Var = new n0(this.o.getPageActivity());
        d.a.n0.r.q.e eVar = new d.a.n0.r.q.e();
        eVar.f53777b = 1;
        eVar.f53783h = 1;
        n0Var.v(eVar);
        n0Var.w(1);
        n0Var.A(3);
        n0Var.x(2);
        bVar.m(n0Var);
        l0 i2 = bVar.i();
        i2.r(2);
        ThreadCardViewHolder<d.a.o0.z.e0.k> threadCardViewHolder = new ThreadCardViewHolder<>(i2);
        threadCardViewHolder.k(this.n);
        a0(new c());
        return threadCardViewHolder;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.a.c.k.e.a
    /* renamed from: j0 */
    public View X(int i2, View view, ViewGroup viewGroup, d.a.o0.z.e0.k kVar, ThreadCardViewHolder<d.a.o0.z.e0.k> threadCardViewHolder) {
        if (kVar == null || threadCardViewHolder == null || threadCardViewHolder.a() == null || kVar.f67302e == null) {
            return null;
        }
        kVar.U(kVar.position + 1);
        d.a.o0.z.t.b().a(kVar.d0("c12641"));
        d.a.o0.o.d.c().i("page_recommend", "show_", kVar.L());
        threadCardViewHolder.b().setPage(this.q);
        threadCardViewHolder.p(true).u(this.p);
        threadCardViewHolder.m(kVar.w(), this.m);
        threadCardViewHolder.f(kVar);
        threadCardViewHolder.b().onChangeSkinType(this.o, TbadkCoreApplication.getInst().getSkinType());
        threadCardViewHolder.b().p(this.s);
        d.a.o0.b1.h.m.a.c(kVar.f67302e, this.n, kVar.E());
        return threadCardViewHolder.a();
    }

    public void k0(NEGFeedBackView.b bVar) {
        this.p = bVar;
    }

    public void setFromCDN(boolean z) {
        this.r = z;
    }
}
