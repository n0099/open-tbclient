package d.a.k0.a1.g.h;

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
import com.baidu.tieba.R;
import com.baidu.tieba.card.data.BaseCardInfo;
import d.a.i.l0;
import d.a.i.v0.a;
/* loaded from: classes4.dex */
public class e extends d.a.c.j.e.a<d.a.k0.x.e0.k, ThreadCardViewHolder<d.a.k0.x.e0.k>> implements d.a.k0.m.f {
    public BdUniqueId m;
    public TbPageContext<?> n;
    public d.a.k0.a1.g.k.e o;
    public String p;
    public boolean q;
    public d.a.c.j.e.s r;
    public d.a.k0.x.b0<d.a.k0.x.e0.k> s;

    /* loaded from: classes4.dex */
    public class a extends d.a.k0.x.b0<d.a.k0.x.e0.k> {
        public a() {
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.a.k0.x.b0
        /* renamed from: d */
        public void a(View view, d.a.k0.x.e0.k kVar) {
            d.a.k0.x.t.b().d(true);
            d.a.k0.m.d.c().h("page_recommend", "show_");
            if (view == null || e.this.o == null || kVar == null || kVar.m() == null || StringUtils.isNull(kVar.m().x1())) {
                return;
            }
            if ((view.getTag() instanceof String) && !d.a.k0.a1.g.f.b(d.a.c.e.m.b.f(kVar.m().x1(), 0L))) {
                d.a.k0.a1.g.f.a(d.a.c.e.m.b.f(kVar.m().x1(), 0L));
                e.this.o.e(d.a.c.e.m.b.f(kVar.m().x1(), 0L), kVar.O(), kVar.F(), kVar.E(), kVar.z(), d.a.c.e.m.b.d((String) view.getTag(), 1), "homepage", kVar.m().V());
            }
            e.this.m0(view, kVar);
        }
    }

    /* loaded from: classes4.dex */
    public class b implements d.a.c.j.e.w {
        public b() {
        }

        @Override // d.a.c.j.e.w
        public void b(View view, d.a.c.j.e.n nVar, BdUniqueId bdUniqueId, ViewGroup viewGroup, int i2, long j) {
            if ((nVar instanceof d.a.k0.x.e0.k) && (view.getTag() instanceof ThreadCardViewHolder)) {
                ThreadCardViewHolder threadCardViewHolder = (ThreadCardViewHolder) view.getTag();
                d.a.k0.x.e0.k kVar = (d.a.k0.x.e0.k) nVar;
                kVar.k = 1;
                if (e.this.s != null) {
                    e.this.s.a(threadCardViewHolder.a(), kVar);
                }
                ThreadCardUtils.jumpToPB((d.a.j0.r.q.a) kVar, view.getContext(), 2, false);
                threadCardViewHolder.b().o(new a.C0549a(1));
            }
        }
    }

    public e(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext.getPageActivity(), bdUniqueId);
        this.q = true;
        this.s = new a();
        this.n = tbPageContext;
        h0();
    }

    @Override // d.a.k0.m.f
    public void g(String str) {
        this.p = str;
    }

    public final void h0() {
        d.a.k0.x.e0.k.V = "c10705";
        d.a.k0.x.e0.k.W = "c10730";
        d.a.k0.x.e0.k.X = "c10731";
        d.a.k0.x.e0.k.Y = "c10704";
        d.a.k0.x.e0.k.Z = "c10755";
        d.a.k0.x.e0.k.a0 = "c10710";
        d.a.k0.x.e0.k.b0 = "c10736";
        d.a.k0.x.e0.k.c0 = "c10737";
        d.a.k0.x.e0.k.d0 = "c10711";
        d.a.k0.x.e0.k.e0 = "c10758";
        d.a.k0.x.e0.k.f0 = "c10757";
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.a.c.j.e.a
    /* renamed from: i0 */
    public ThreadCardViewHolder P(ViewGroup viewGroup) {
        l0.b bVar = new l0.b(this.n.getPageActivity(), false);
        d.a.i.v vVar = new d.a.i.v(this.n.getPageActivity());
        vVar.r("index");
        vVar.s(this.q);
        bVar.n(vVar);
        l0 k = bVar.k(BaseCardInfo.SupportType.CONTENT, viewGroup, this.r);
        k.r(2);
        ThreadCardViewHolder threadCardViewHolder = new ThreadCardViewHolder(k);
        threadCardViewHolder.j(this.m);
        Z(new b());
        return threadCardViewHolder;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.a.c.j.e.a
    /* renamed from: j0 */
    public View W(int i2, View view, ViewGroup viewGroup, d.a.k0.x.e0.k kVar, ThreadCardViewHolder<d.a.k0.x.e0.k> threadCardViewHolder) {
        if (kVar == null || threadCardViewHolder == null || threadCardViewHolder.a() == null || kVar.f63179e == null) {
            return null;
        }
        kVar.U(kVar.position + 1);
        threadCardViewHolder.b().q(i2);
        threadCardViewHolder.b().setPage(this.p);
        threadCardViewHolder.f(kVar);
        threadCardViewHolder.b().onChangeSkinType(this.n, TbadkCoreApplication.getInst().getSkinType());
        threadCardViewHolder.b().p(this.s);
        d.a.k0.x.t.b().a(kVar.L());
        d.a.k0.m.d.c().a(kVar.L());
        d.a.k0.a1.g.m.a.c(kVar.f63179e, this.m, kVar.E());
        return threadCardViewHolder.a();
    }

    public final void m0(View view, d.a.k0.x.e0.k kVar) {
        int id = view.getId();
        int i2 = 3;
        if (view.getId() != R.id.thread_card_root && id != R.id.thread_info_commont_container) {
            if (id == R.id.user_avatar) {
                TiebaStatic.log(kVar.e0());
                d.a.k0.m.d.c().i("page_recommend", "clk_", kVar.e0());
            } else if (id == R.id.user_name) {
                TiebaStatic.log(kVar.e0());
                d.a.k0.m.d.c().i("page_recommend", "clk_", kVar.e0());
            } else if (id == R.id.forum_name_text) {
                TiebaStatic.log(kVar.C());
                d.a.k0.m.d.c().i("page_recommend", "clk_", kVar.C());
                i2 = 9;
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
                        d.a.k0.m.d.c().i("page_recommend", "clk_", kVar.b0());
                    } else {
                        i2 = 0;
                    }
                } else {
                    StatisticItem statisticItem3 = new StatisticItem("c10760");
                    statisticItem3.param("obj_locate", 1);
                    TiebaStatic.log(statisticItem3);
                }
                i2 = 5;
            }
            i2 = 2;
        } else {
            TiebaStatic.log(kVar.K());
            d.a.k0.m.d.c().i("page_recommend", "clk_", kVar.K());
            i2 = 1;
        }
        if (i2 != 0) {
            d.a.k0.a1.g.m.a.a(kVar.f63179e, this.m, kVar.E(), i2);
        }
    }

    public void n0(d.a.k0.a1.g.k.e eVar) {
        this.o = eVar;
    }

    public void p0(d.a.c.j.e.s sVar) {
        this.r = sVar;
    }
}
