package d.b.i0.z0.g.h;

import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.card.Align;
import com.baidu.card.ThreadCardViewHolder;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.ThreadCardUtils;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.NEGFeedBack.NEGFeedBackView;
import com.baidu.tieba.R;
import com.baidu.tieba.card.data.BaseCardInfo;
import d.b.i.d;
import d.b.i.k0;
import d.b.i.u0.a;
/* loaded from: classes4.dex */
public class x extends d.b.i0.z0.a<d.b.i0.x.e0.k, ThreadCardViewHolder<d.b.i0.x.e0.k>> implements d.b.i0.m.f {
    public BdUniqueId n;
    public TbPageContext<?> o;
    public d.b.i0.z0.g.k.e p;
    public String q;
    public d.b.b.j.e.s r;
    public NEGFeedBackView.b s;
    public d.b.i0.x.b0<d.b.i0.x.e0.k> t;

    /* loaded from: classes4.dex */
    public class a extends d.b.i0.x.b0<d.b.i0.x.e0.k> {
        public a() {
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.b.i0.x.b0
        /* renamed from: d */
        public void a(View view, d.b.i0.x.e0.k kVar) {
            d.b.i0.x.t.b().d(true);
            d.b.i0.m.d.c().h("page_recommend", "show_");
            if (view == null || x.this.p == null || kVar == null || kVar.n() == null || StringUtils.isNull(kVar.n().w1())) {
                return;
            }
            if ((view.getTag() instanceof String) && !d.b.i0.z0.g.f.b(d.b.b.e.m.b.f(kVar.n().w1(), 0L))) {
                d.b.i0.z0.g.f.a(d.b.b.e.m.b.f(kVar.n().w1(), 0L));
                x.this.p.e(d.b.b.e.m.b.f(kVar.n().w1(), 0L), kVar.O(), kVar.F(), kVar.E(), kVar.z(), d.b.b.e.m.b.d((String) view.getTag(), 1), "homepage", kVar.n().V());
            }
            x.this.p0(view, kVar);
        }
    }

    /* loaded from: classes4.dex */
    public class b implements d.b {
        public b(x xVar) {
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
    public class c implements d.b.b.j.e.w {
        public c() {
        }

        @Override // d.b.b.j.e.w
        public void f(View view, d.b.b.j.e.n nVar, BdUniqueId bdUniqueId, ViewGroup viewGroup, int i, long j) {
            if ((nVar instanceof d.b.i0.x.e0.k) && (view.getTag() instanceof ThreadCardViewHolder)) {
                ThreadCardViewHolder threadCardViewHolder = (ThreadCardViewHolder) view.getTag();
                d.b.i0.x.e0.k kVar = (d.b.i0.x.e0.k) nVar;
                kVar.k = 1;
                if (x.this.t != null) {
                    x.this.t.a(threadCardViewHolder.a(), kVar);
                }
                ThreadCardUtils.jumpToPB((d.b.h0.r.q.a) kVar, view.getContext(), 2, false, d.b.i.e.a((d.b.b.j.e.s) viewGroup, view, i));
                threadCardViewHolder.b().o(new a.C1117a(1));
            }
        }
    }

    public x(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext.getPageActivity(), bdUniqueId);
        this.t = new a();
        this.o = tbPageContext;
        m0();
    }

    public final void m0() {
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
        d.b.i0.x.e0.k.h0 = "c10734";
        d.b.i0.x.e0.k.i0 = "c10708";
        d.b.i0.x.e0.k.j0 = "c10735";
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.b.b.j.e.a
    /* renamed from: n0 */
    public ThreadCardViewHolder R(ViewGroup viewGroup) {
        k0.b bVar = new k0.b(this.o.getPageActivity());
        d.b.i.d dVar = new d.b.i.d(this.o.getPageActivity());
        dVar.t(this.n);
        dVar.c(1024);
        dVar.s(new b(this));
        dVar.v(this.o);
        bVar.o(dVar);
        k0 k = bVar.k(BaseCardInfo.SupportType.TOP, viewGroup, this.r);
        k.r(2);
        ThreadCardViewHolder threadCardViewHolder = new ThreadCardViewHolder(k);
        threadCardViewHolder.k(this.n);
        c0(new c());
        return threadCardViewHolder;
    }

    @Override // d.b.i0.m.f
    public void o(String str) {
        this.q = str;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.b.b.j.e.a
    /* renamed from: o0 */
    public View X(int i, View view, ViewGroup viewGroup, d.b.i0.x.e0.k kVar, ThreadCardViewHolder<d.b.i0.x.e0.k> threadCardViewHolder) {
        if (kVar == null || threadCardViewHolder == null || threadCardViewHolder.a() == null || kVar.f62196e == null) {
            return null;
        }
        kVar.U(kVar.position + 1);
        threadCardViewHolder.b().q(i);
        threadCardViewHolder.b().setPage(this.q);
        threadCardViewHolder.q(true, Align.ALIGN_RIGHT_TOP, this.s);
        threadCardViewHolder.m(kVar.w(), this.m);
        threadCardViewHolder.f(kVar);
        threadCardViewHolder.b().onChangeSkinType(this.o, TbadkCoreApplication.getInst().getSkinType());
        threadCardViewHolder.b().p(this.t);
        d.b.i0.x.t.b().a(kVar.L());
        d.b.i0.m.d.c().a(kVar.L());
        d.b.i0.z0.g.m.a.c(kVar.f62196e, this.n, kVar.E());
        return threadCardViewHolder.a();
    }

    public final void p0(View view, d.b.i0.x.e0.k kVar) {
        int id = view.getId();
        int i = 3;
        if (view.getId() != R.id.thread_card_root && id != R.id.thread_info_commont_container) {
            if (id == R.id.user_avatar) {
                TiebaStatic.log(kVar.e0());
                d.b.i0.m.d.c().i("page_recommend", "clk_", kVar.e0());
            } else if (id == R.id.user_name) {
                TiebaStatic.log(kVar.e0());
                d.b.i0.m.d.c().i("page_recommend", "clk_", kVar.e0());
            } else if (id == R.id.forum_name_text) {
                TiebaStatic.log(kVar.C());
                d.b.i0.m.d.c().i("page_recommend", "clk_", kVar.C());
                i = 9;
            } else {
                if (id == R.id.god_reply_content) {
                    StatisticItem statisticItem = new StatisticItem("c10760");
                    statisticItem.param("obj_locate", 2);
                    TiebaStatic.log(statisticItem);
                } else if (id != R.id.god_reply_user_pendant_header && id != R.id.god_reply_username_text) {
                    if (view instanceof TbImageView) {
                        if (view.getTag(R.id.god_reply_image_layout) instanceof Integer) {
                            StatisticItem statisticItem2 = new StatisticItem("c10760");
                            statisticItem2.param("obj_locate", 3);
                            TiebaStatic.log(statisticItem2);
                        }
                        TiebaStatic.log(kVar.b0());
                        d.b.i0.m.d.c().i("page_recommend", "clk_", kVar.b0());
                    } else {
                        i = 0;
                    }
                } else {
                    StatisticItem statisticItem3 = new StatisticItem("c10760");
                    statisticItem3.param("obj_locate", 1);
                    TiebaStatic.log(statisticItem3);
                }
                i = 5;
            }
            i = 2;
        } else {
            if (d.b.i0.x.e0.l.d0(kVar.f62196e)) {
                TiebaStatic.log(kVar.N());
            } else {
                TiebaStatic.log(kVar.K());
            }
            d.b.i0.m.d.c().i("page_recommend", "clk_", kVar.K());
            i = 1;
        }
        if (i != 0) {
            d.b.i0.z0.g.m.a.a(kVar.f62196e, this.n, kVar.E(), i);
        }
    }

    public void q0(d.b.i0.z0.g.k.e eVar) {
        this.p = eVar;
    }

    public void r0(d.b.b.j.e.s sVar) {
        this.r = sVar;
    }
}
