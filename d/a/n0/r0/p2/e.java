package d.a.n0.r0.p2;

import android.content.res.Configuration;
import android.os.Handler;
import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tieba.R;
import com.baidu.tieba.card.holder.CardViewHolder;
import d.a.d.j;
import d.a.m0.r.q.a2;
import d.a.n0.z.b0;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes4.dex */
public class e extends d.a.c.k.e.a<d.a.n0.r0.i1.g, CardViewHolder<d.a.n0.r0.p2.a>> {
    public boolean A;
    public d.a.n0.r0.p2.b B;
    public d.a.n0.k1.o.l.g C;
    public int D;
    public b0<d.a.n0.r0.i1.g> E;
    public TbPageContext m;
    public BdUniqueId n;
    public d.a.n0.r0.p2.a o;
    public boolean p;
    public List<d.a.n0.r0.p2.a> q;
    public Handler r;
    public d.a.n0.r0.i1.a s;
    public c t;
    public boolean u;
    public String v;
    public boolean w;
    public d.a.n0.r0.p2.j.a x;
    public String y;
    public d.a.n0.k1.o.l.f z;

    /* loaded from: classes4.dex */
    public class a extends b0<d.a.n0.r0.i1.g> {
        public a() {
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.a.n0.z.b0
        /* renamed from: d */
        public void a(View view, d.a.n0.r0.i1.g gVar) {
            if (view == null || gVar == null) {
                return;
            }
            String str = gVar.f62381f;
            if (str == null) {
                str = null;
            }
            a2 a2Var = new a2();
            a2Var.I3(str);
            a2Var.q4(str);
            a2Var.y3(d.a.c.e.m.b.f(gVar.f62380e, 0L));
            a2Var.v3(gVar.A);
            a2Var.p4(40);
            if ((view.getId() == R.id.video_container || view.getId() == R.id.video_agg_container || view.getId() == R.id.mobile_network_play) && view.getTag() != null && (view.getTag() instanceof d.a.n0.r0.p2.a)) {
                d.a.n0.r0.p2.a aVar = (d.a.n0.r0.p2.a) view.getTag();
                if (e.this.o != null && e.this.o != aVar && (view.getId() == R.id.video_container || view.getId() == R.id.mobile_network_play)) {
                    e.this.o.F0();
                }
                if (e.this.o != aVar) {
                    e.this.o = aVar;
                }
                if (e.this.o != null) {
                    e.this.o.w0(e.this.w);
                }
            }
            if (view.getId() == R.id.title) {
                StatisticItem statisticItem = new StatisticItem("c12411");
                statisticItem.param("fid", gVar.f62380e);
                if (TbadkCoreApplication.isLogin()) {
                    statisticItem.param("uid", TbadkCoreApplication.getCurrentAccount());
                }
                TiebaStatic.log(statisticItem);
                if (e.this.o == null || e.this.o.c0()) {
                    return;
                }
                StatisticItem d2 = d.a.n0.d3.a.d(a2Var, "a023", "common_click", 1, gVar.I, false, null, null);
                if ("14".equals(e.this.v)) {
                    d2.param("page_source", "newcategory");
                }
                d.a.n0.d3.c.g().c(e.this.n, d2);
            } else if (view.getId() == R.id.agree_view_container) {
                StatisticItem statisticItem2 = new StatisticItem("c12414");
                statisticItem2.param("fid", gVar.f62380e);
                if (TbadkCoreApplication.isLogin()) {
                    statisticItem2.param("uid", TbadkCoreApplication.getCurrentAccount());
                }
                TiebaStatic.log(statisticItem2);
            } else if (view.getId() != R.id.thread_info_commont_container && view.getId() != R.id.card_root_view) {
                if (view.getId() != R.id.user_icon && view.getId() != R.id.user_name) {
                    if (view.getId() == R.id.attention) {
                        StatisticItem statisticItem3 = new StatisticItem("c12413");
                        statisticItem3.param("fid", gVar.f62380e);
                        if (TbadkCoreApplication.isLogin()) {
                            statisticItem3.param("uid", TbadkCoreApplication.getCurrentAccount());
                        }
                        TiebaStatic.log(statisticItem3);
                        return;
                    } else if (view.getId() == R.id.mobile_network_play) {
                        StatisticItem statisticItem4 = new StatisticItem("c12416");
                        statisticItem4.param("fid", gVar.f62380e);
                        if (TbadkCoreApplication.isLogin()) {
                            statisticItem4.param("uid", TbadkCoreApplication.getCurrentAccount());
                        }
                        TiebaStatic.log(statisticItem4);
                        return;
                    } else {
                        return;
                    }
                }
                StatisticItem statisticItem5 = new StatisticItem("c12412");
                statisticItem5.param("fid", gVar.f62380e);
                if (TbadkCoreApplication.isLogin()) {
                    statisticItem5.param("uid", TbadkCoreApplication.getCurrentAccount());
                }
                TiebaStatic.log(statisticItem5);
                StatisticItem d3 = d.a.n0.d3.a.d(a2Var, "a023", "common_click", 2, gVar.I, false, null, null);
                if ("14".equals(e.this.v)) {
                    d3.param("page_source", "newcategory");
                }
                d.a.n0.d3.c.g().c(e.this.n, d3);
            } else {
                StatisticItem statisticItem6 = new StatisticItem("c12415");
                statisticItem6.param("fid", gVar.f62380e);
                if (TbadkCoreApplication.isLogin()) {
                    statisticItem6.param("uid", TbadkCoreApplication.getCurrentAccount());
                }
                TiebaStatic.log(statisticItem6);
                StatisticItem d4 = d.a.n0.d3.a.d(a2Var, "a023", "common_click", 5, gVar.I, false, null, null);
                if ("14".equals(e.this.v)) {
                    d4.param("page_source", "newcategory");
                }
                d.a.n0.d3.c.g().c(e.this.n, d4);
            }
        }
    }

    /* loaded from: classes4.dex */
    public class b implements Runnable {
        public b() {
        }

        @Override // java.lang.Runnable
        public void run() {
            if (e.this.p) {
                e.this.p = false;
            }
        }
    }

    public e(TbPageContext<?> tbPageContext, d.a.n0.r0.i1.a aVar, c cVar, boolean z, String str, String str2, d.a.n0.k1.o.l.f fVar, BdUniqueId bdUniqueId, d.a.n0.r0.p2.b bVar, d.a.n0.k1.o.l.g gVar) {
        super(tbPageContext.getPageActivity().getBaseContext(), d.a.n0.r0.i1.g.K);
        this.q = new ArrayList();
        this.r = new Handler();
        this.w = true;
        this.D = 1;
        this.E = new a();
        this.m = tbPageContext;
        this.n = bdUniqueId;
        this.s = aVar;
        this.u = z;
        this.t = cVar;
        this.v = str;
        this.x = new d.a.n0.r0.p2.j.a();
        this.y = str2;
        this.z = fVar;
        this.B = bVar;
        this.C = gVar;
    }

    public void A0() {
        d.a.n0.r0.p2.a aVar = this.o;
        if (aVar == null) {
            return;
        }
        aVar.F0();
    }

    public boolean m0() {
        d.a.n0.r0.p2.a aVar = this.o;
        if (aVar != null) {
            return aVar.isPlaying();
        }
        return false;
    }

    public void onDestroy() {
        d.a.n0.r0.p2.j.a aVar = this.x;
        if (aVar != null) {
            aVar.d();
        }
        for (d.a.n0.r0.p2.a aVar2 : this.q) {
            if (aVar2 != null) {
                aVar2.onDestroy();
            }
        }
    }

    public boolean p0() {
        d.a.n0.r0.p2.a aVar = this.o;
        if (aVar != null) {
            return aVar.e0();
        }
        return false;
    }

    public void q0(Configuration configuration) {
        int i2 = configuration.orientation;
        if (i2 == this.D) {
            return;
        }
        this.D = i2;
        d.a.n0.r0.p2.a aVar = this.o;
        if (aVar != null) {
            this.p = true;
            aVar.j0(configuration);
            if (configuration.orientation == 1) {
                this.r.postDelayed(new b(), 500L);
            }
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.a.c.k.e.a
    /* renamed from: s0 */
    public CardViewHolder<d.a.n0.r0.p2.a> Q(ViewGroup viewGroup) {
        d.a.n0.r0.p2.a aVar = new d.a.n0.r0.p2.a(this.m, this.u, this.v, this.y, this.B);
        aVar.p(this.E);
        aVar.x0(this.C);
        this.q.add(aVar);
        return new CardViewHolder<>(aVar);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.a.c.k.e.a
    /* renamed from: t0 */
    public View X(int i2, View view, ViewGroup viewGroup, d.a.n0.r0.i1.g gVar, CardViewHolder<d.a.n0.r0.p2.a> cardViewHolder) {
        if (gVar == null || cardViewHolder == null) {
            return null;
        }
        if (gVar.g() != null) {
            gVar.g().keyFromHomePage = this.v;
        }
        if (!this.A) {
            if (!this.p) {
                cardViewHolder.b().i0(gVar, i2, this.s);
                j trigger = gVar.getTrigger();
                if (trigger != null) {
                    trigger.a();
                }
                cardViewHolder.b().I = i2;
                cardViewHolder.b().setOnVideoContainerForegroundClickListener(this.t);
            } else {
                cardViewHolder.b().g0(gVar, i2, this.s);
            }
        }
        if (cardViewHolder.b() instanceof d.a.n0.k1.o.l.h) {
            cardViewHolder.b().setCurrentPlayCallBack(this.z);
        }
        String c2 = d.a.n0.d3.a.c(gVar.f62381f, "", "", gVar.A);
        a2 a2Var = new a2();
        a2Var.I3(gVar.f62381f);
        a2Var.q4(gVar.f62381f);
        a2Var.v3(gVar.A);
        a2Var.y3(d.a.c.e.m.b.f(gVar.f62380e, 0L));
        a2Var.p4(40);
        d.a.n0.d3.c.g().d(this.n, c2, d.a.n0.d3.a.f(a2Var, "a023", "common_exp", i2 + 1, false, null, null));
        return cardViewHolder.a();
    }

    public boolean v0(int i2) {
        d.a.n0.r0.p2.a aVar = this.o;
        if (aVar == null) {
            return false;
        }
        return aVar.k0(i2);
    }

    public void w0() {
        d.a.n0.r0.p2.a aVar = this.o;
        if (aVar == null) {
            return;
        }
        aVar.l0();
    }

    public void x0() {
        d.a.n0.r0.p2.a aVar = this.o;
        if (aVar == null) {
            return;
        }
        aVar.t0();
    }

    public void y0(boolean z) {
        this.A = z;
    }

    public void z0() {
        d.a.n0.r0.p2.a aVar = this.o;
        if (aVar == null) {
            return;
        }
        aVar.E0();
    }
}
