package d.b.j0.q0.i1;

import android.content.res.Configuration;
import android.os.Handler;
import android.view.View;
import android.view.ViewGroup;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tieba.R;
import com.baidu.tieba.card.holder.CardViewHolder;
import d.b.j0.x.b0;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes4.dex */
public class e extends d.b.c.j.e.a<g, CardViewHolder<d.b.j0.q0.i1.b>> {
    public TbPageContext m;
    public d.b.j0.q0.i1.b n;
    public boolean o;
    public List<d.b.j0.q0.i1.b> p;
    public Handler q;
    public d.b.j0.q0.i1.a r;
    public boolean s;
    public b0<g> t;

    /* loaded from: classes4.dex */
    public class a extends b0<g> {
        public a() {
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.b.j0.x.b0
        /* renamed from: d */
        public void a(View view, g gVar) {
            if (view == null || gVar == null) {
                return;
            }
            if ((view.getId() == R.id.video_container || view.getId() == R.id.video_agg_container || view.getId() == R.id.mobile_network_play) && view.getTag() != null && (view.getTag() instanceof d.b.j0.q0.i1.b)) {
                d.b.j0.q0.i1.b bVar = (d.b.j0.q0.i1.b) view.getTag();
                if (e.this.n != null && e.this.n != bVar && (view.getId() == R.id.video_container || view.getId() == R.id.mobile_network_play)) {
                    e.this.n.U();
                }
                if (e.this.n != bVar) {
                    e.this.n = bVar;
                }
            }
            if (view.getId() == R.id.title) {
                StatisticItem statisticItem = new StatisticItem("c12411");
                statisticItem.param("fid", gVar.f59739e);
                if (TbadkCoreApplication.isLogin()) {
                    statisticItem.param("uid", TbadkCoreApplication.getCurrentAccount());
                }
                TiebaStatic.log(statisticItem);
            } else if (view.getId() == R.id.agree_view_container) {
                StatisticItem statisticItem2 = new StatisticItem("c12414");
                statisticItem2.param("fid", gVar.f59739e);
                if (TbadkCoreApplication.isLogin()) {
                    statisticItem2.param("uid", TbadkCoreApplication.getCurrentAccount());
                }
                TiebaStatic.log(statisticItem2);
            } else if (view.getId() != R.id.thread_info_commont_container && view.getId() != R.id.card_root_view) {
                if (view.getId() != R.id.user_icon && view.getId() != R.id.user_name) {
                    if (view.getId() == R.id.attention) {
                        StatisticItem statisticItem3 = new StatisticItem("c12413");
                        statisticItem3.param("fid", gVar.f59739e);
                        if (TbadkCoreApplication.isLogin()) {
                            statisticItem3.param("uid", TbadkCoreApplication.getCurrentAccount());
                        }
                        TiebaStatic.log(statisticItem3);
                        return;
                    } else if (view.getId() == R.id.mobile_network_play) {
                        StatisticItem statisticItem4 = new StatisticItem("c12416");
                        statisticItem4.param("fid", gVar.f59739e);
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
                statisticItem5.param("fid", gVar.f59739e);
                if (TbadkCoreApplication.isLogin()) {
                    statisticItem5.param("uid", TbadkCoreApplication.getCurrentAccount());
                }
                TiebaStatic.log(statisticItem5);
            } else {
                StatisticItem statisticItem6 = new StatisticItem("c12415");
                statisticItem6.param("fid", gVar.f59739e);
                if (TbadkCoreApplication.isLogin()) {
                    statisticItem6.param("uid", TbadkCoreApplication.getCurrentAccount());
                }
                TiebaStatic.log(statisticItem6);
            }
        }
    }

    /* loaded from: classes4.dex */
    public class b implements Runnable {
        public b() {
        }

        @Override // java.lang.Runnable
        public void run() {
            if (e.this.o) {
                e.this.o = false;
            }
        }
    }

    public e(TbPageContext<?> tbPageContext, d.b.j0.q0.i1.a aVar, boolean z) {
        super(tbPageContext.getPageActivity().getBaseContext(), g.K);
        this.p = new ArrayList();
        this.q = new Handler();
        this.t = new a();
        this.m = tbPageContext;
        this.r = aVar;
        this.s = z;
    }

    public boolean m0() {
        d.b.j0.q0.i1.b bVar = this.n;
        if (bVar != null) {
            return bVar.isPlaying();
        }
        return false;
    }

    public void n0(Configuration configuration) {
        d.b.j0.q0.i1.b bVar = this.n;
        if (bVar != null) {
            this.o = true;
            bVar.K(configuration);
            if (configuration.orientation == 1) {
                this.q.postDelayed(new b(), 500L);
            }
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.b.c.j.e.a
    /* renamed from: o0 */
    public CardViewHolder<d.b.j0.q0.i1.b> R(ViewGroup viewGroup) {
        d.b.j0.q0.i1.b bVar = new d.b.j0.q0.i1.b(this.m, this.s);
        bVar.q(this.t);
        this.p.add(bVar);
        return new CardViewHolder<>(bVar);
    }

    public void onDestroy() {
        for (d.b.j0.q0.i1.b bVar : this.p) {
            if (bVar != null) {
                bVar.onDestroy();
            }
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.b.c.j.e.a
    /* renamed from: p0 */
    public View X(int i, View view, ViewGroup viewGroup, g gVar, CardViewHolder<d.b.j0.q0.i1.b> cardViewHolder) {
        if (gVar == null || cardViewHolder == null) {
            return null;
        }
        if (!this.o) {
            cardViewHolder.b().J(gVar, i, this.r);
            cardViewHolder.b().J = i;
        }
        return cardViewHolder.a();
    }

    public boolean q0(int i) {
        d.b.j0.q0.i1.b bVar = this.n;
        if (bVar == null) {
            return false;
        }
        return bVar.L(i);
    }

    public void r0() {
        d.b.j0.q0.i1.b bVar = this.n;
        if (bVar == null) {
            return;
        }
        bVar.M();
    }

    public void s0() {
        d.b.j0.q0.i1.b bVar = this.n;
        if (bVar == null) {
            return;
        }
        bVar.U();
    }
}
