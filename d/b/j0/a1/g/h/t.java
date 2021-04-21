package d.b.j0.a1.g.h;

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
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.NEGFeedBack.NEGFeedBackView;
import com.baidu.tieba.R;
import com.baidu.tieba.card.data.BaseCardInfo;
import d.b.i.a;
import d.b.i.d;
import d.b.i.f0;
import d.b.i.k0;
import d.b.i.m0;
import d.b.i.n0;
import d.b.i.u0.a;
/* loaded from: classes4.dex */
public class t extends d.b.j0.a1.a<d.b.j0.x.e0.k, ThreadCardViewHolder<d.b.j0.x.e0.k>> implements d.b.j0.m.f {
    public BdUniqueId n;
    public TbPageContext<?> o;
    public NEGFeedBackView.b p;
    public String q;
    public d.b.c.j.e.s r;
    public d.b.j0.x.b0<d.b.j0.x.e0.k> s;

    /* loaded from: classes4.dex */
    public class a extends d.b.j0.x.b0<d.b.j0.x.e0.k> {
        public a() {
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.b.j0.x.b0
        /* renamed from: d */
        public void a(View view, d.b.j0.x.e0.k kVar) {
            int i = 1;
            d.b.j0.x.t.b().d(true);
            d.b.j0.m.d.c().h("page_recommend", "show_");
            if (view == null || kVar == null || kVar.n() == null || StringUtils.isNull(kVar.n().w1())) {
                return;
            }
            int id = view.getId();
            if (id != R.id.thread_card_root && id != R.id.thread_info_commont_container) {
                if (id == R.id.thread_card_voice) {
                    TiebaStatic.log(kVar.f0());
                    d.b.j0.m.d.c().i("page_recommend", "clk_", kVar.f0());
                } else {
                    if (id == R.id.user_avatar) {
                        TiebaStatic.log(kVar.e0());
                        d.b.j0.m.d.c().i("page_recommend", "clk_", kVar.e0());
                    } else if (id == R.id.user_name) {
                        TiebaStatic.log(kVar.e0());
                        d.b.j0.m.d.c().i("page_recommend", "clk_", kVar.e0());
                    } else if (id == R.id.forum_name_text) {
                        TiebaStatic.log(kVar.C());
                        d.b.j0.m.d.c().i("page_recommend", "clk_", kVar.C());
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
                            d.b.j0.m.d.c().i("page_recommend", "clk_", kVar.b0());
                        }
                    } else {
                        StatisticItem statisticItem4 = new StatisticItem("c10760");
                        statisticItem4.param("obj_locate", 1);
                        TiebaStatic.log(statisticItem4);
                    }
                    i = 2;
                }
                i = 0;
            } else {
                TiebaStatic.log(kVar.c0("c12642"));
                d.b.j0.m.d.c().i("page_recommend", "clk_", kVar.K());
            }
            if (i != 0) {
                d.b.j0.a1.g.m.a.a(kVar.f64193e, t.this.n, kVar.E(), i);
            }
        }
    }

    /* loaded from: classes4.dex */
    public class b implements d.b {
        public b(t tVar) {
        }

        @Override // d.b.i.d.b
        public void a(d.b.i0.r.q.a aVar, View view) {
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
    public class c implements a.InterfaceC1070a {
        public c() {
        }

        @Override // d.b.i.a.InterfaceC1070a
        public void a(d.b.i0.r.q.a aVar) {
            if (aVar == null || aVar.n() == null || aVar.n().r1 == null) {
                return;
            }
            ThreadCardUtils.jumpToPB(aVar.n().r1, t.this.f43095e, 2);
        }
    }

    /* loaded from: classes4.dex */
    public class d implements a.InterfaceC1070a {
        public d() {
        }

        @Override // d.b.i.a.InterfaceC1070a
        public void a(d.b.i0.r.q.a aVar) {
            if (aVar == null || aVar.n() == null || aVar.n().r1 == null) {
                return;
            }
            ThreadCardUtils.jumpToPB(aVar.n().r1, t.this.f43095e, 2);
            boolean z = aVar.n().r1.o;
        }
    }

    /* loaded from: classes4.dex */
    public class e implements d.b.c.j.e.w {
        public e() {
        }

        @Override // d.b.c.j.e.w
        public void f(View view, d.b.c.j.e.n nVar, BdUniqueId bdUniqueId, ViewGroup viewGroup, int i, long j) {
            if ((nVar instanceof d.b.j0.x.e0.k) && (view.getTag() instanceof ThreadCardViewHolder)) {
                ThreadCardViewHolder threadCardViewHolder = (ThreadCardViewHolder) view.getTag();
                d.b.j0.x.e0.k kVar = (d.b.j0.x.e0.k) nVar;
                kVar.k = 1;
                if (t.this.s != null) {
                    t.this.s.a(threadCardViewHolder.a(), kVar);
                }
                ThreadCardUtils.jumpToPB((d.b.i0.r.q.a) kVar, view.getContext(), 2, false);
                threadCardViewHolder.b().o(new a.C1072a(1));
            }
        }
    }

    public t(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext.getPageActivity(), bdUniqueId);
        this.p = null;
        this.s = new a();
        this.o = tbPageContext;
        m0();
    }

    public final void m0() {
        d.b.j0.x.e0.k.U = "c10705";
        d.b.j0.x.e0.k.V = "c10730";
        d.b.j0.x.e0.k.W = "c10731";
        d.b.j0.x.e0.k.X = "c10704";
        d.b.j0.x.e0.k.Y = "c10755";
        d.b.j0.x.e0.k.Z = "c10710";
        d.b.j0.x.e0.k.a0 = "c10736";
        d.b.j0.x.e0.k.b0 = "c10737";
        d.b.j0.x.e0.k.c0 = "c10711";
        d.b.j0.x.e0.k.d0 = "c10758";
        d.b.j0.x.e0.k.e0 = "c10757";
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.b.c.j.e.a
    /* renamed from: n0 */
    public ThreadCardViewHolder<d.b.j0.x.e0.k> R(ViewGroup viewGroup) {
        k0.b bVar = new k0.b(this.o.getPageActivity());
        d.b.i.d dVar = new d.b.i.d(this.o.getPageActivity());
        dVar.t(this.n);
        dVar.c(1024);
        dVar.s(new b(this));
        bVar.o(dVar);
        f0 f0Var = new f0(this.o);
        f0Var.n(Boolean.FALSE);
        f0Var.v("index");
        bVar.n(f0Var);
        f0 f0Var2 = new f0(this.o);
        f0Var2.n(Boolean.TRUE);
        f0Var2.r(d.b.c.e.p.l.g(this.f43095e, R.dimen.M_H_X003));
        f0Var2.v("index");
        f0Var2.y(d.b.i0.b.g.b.a(), UtilHelper.getDimenPixelSize(R.dimen.M_H_X004), d.b.i0.b.g.b.a(), UtilHelper.getDimenPixelSize(R.dimen.M_H_X004));
        bVar.h(f0Var2);
        f0Var2.w(new c());
        n0 n0Var = new n0(this.o.getPageActivity());
        n0Var.n(Boolean.TRUE);
        n0Var.u(new d());
        bVar.h(n0Var);
        bVar.h(new d.b.i.k(this.o.getPageActivity()));
        m0 m0Var = new m0(this.o.getPageActivity());
        d.b.i0.r.q.e eVar = new d.b.i0.r.q.e();
        eVar.f51506b = 1;
        eVar.f51512h = 1;
        m0Var.v(eVar);
        m0Var.w(1);
        m0Var.A(3);
        m0Var.x(2);
        bVar.m(m0Var);
        k0 k = bVar.k(BaseCardInfo.SupportType.FULL, viewGroup, this.r);
        k.r(2);
        ThreadCardViewHolder<d.b.j0.x.e0.k> threadCardViewHolder = new ThreadCardViewHolder<>(k);
        threadCardViewHolder.k(this.n);
        c0(new e());
        return threadCardViewHolder;
    }

    @Override // d.b.j0.m.f
    public void o(String str) {
        this.q = str;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.b.c.j.e.a
    /* renamed from: o0 */
    public View X(int i, View view, ViewGroup viewGroup, d.b.j0.x.e0.k kVar, ThreadCardViewHolder<d.b.j0.x.e0.k> threadCardViewHolder) {
        if (kVar == null || threadCardViewHolder == null || threadCardViewHolder.a() == null || kVar.f64193e == null) {
            return null;
        }
        kVar.U(kVar.position + 1);
        threadCardViewHolder.b().q(i);
        d.b.j0.x.t.b().a(kVar.d0("c12641"));
        d.b.j0.m.d.c().i("page_recommend", "show_", kVar.L());
        threadCardViewHolder.b().setPage(this.q);
        threadCardViewHolder.p(true).u(this.p);
        threadCardViewHolder.m(kVar.w(), this.m);
        threadCardViewHolder.f(kVar);
        threadCardViewHolder.b().onChangeSkinType(this.o, TbadkCoreApplication.getInst().getSkinType());
        threadCardViewHolder.b().p(this.s);
        d.b.j0.a1.g.m.a.c(kVar.f64193e, this.n, kVar.E());
        return threadCardViewHolder.a();
    }

    public void p0(NEGFeedBackView.b bVar) {
        this.p = bVar;
    }

    public void q0(d.b.c.j.e.s sVar) {
        this.r = sVar;
    }
}
