package d.b.i0.a1.b.e;

import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.card.ThreadCardViewHolder;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.ImageViewerConfig;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.ThreadCardUtils;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
import com.baidu.tieba.card.data.BaseCardInfo;
import d.b.h0.r.q.a2;
import d.b.i.k0;
import d.b.i.u0.a;
import d.b.i0.x.b0;
/* loaded from: classes4.dex */
public class m extends d.b.c.j.e.a<d.b.i0.x.e0.k, ThreadCardViewHolder<d.b.i0.x.e0.k>> implements d.b.i0.m.f {
    public BdUniqueId m;
    public TbPageContext<?> n;
    public String o;
    public boolean p;
    public d.b.c.j.e.s q;
    public b0<d.b.i0.x.e0.k> r;

    /* loaded from: classes4.dex */
    public class a extends b0<d.b.i0.x.e0.k> {
        public a() {
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.b.i0.x.b0
        /* renamed from: d */
        public void a(View view, d.b.i0.x.e0.k kVar) {
            if (view == null || kVar == null || kVar.n() == null || StringUtils.isNull(kVar.n().w1())) {
                return;
            }
            m.this.m0(view, kVar);
        }
    }

    /* loaded from: classes4.dex */
    public class b implements d.b.c.j.e.w {
        public b() {
        }

        @Override // d.b.c.j.e.w
        public void f(View view, d.b.c.j.e.n nVar, BdUniqueId bdUniqueId, ViewGroup viewGroup, int i, long j) {
            if ((nVar instanceof d.b.i0.x.e0.k) && (view.getTag() instanceof ThreadCardViewHolder)) {
                ThreadCardViewHolder threadCardViewHolder = (ThreadCardViewHolder) view.getTag();
                d.b.i0.x.e0.k kVar = (d.b.i0.x.e0.k) nVar;
                kVar.k = 1;
                if (m.this.r != null) {
                    m.this.r.a(threadCardViewHolder.a(), kVar);
                }
                ThreadCardUtils.jumpToPB((d.b.h0.r.q.a) kVar, view.getContext(), 1, false);
                threadCardViewHolder.b().o(new a.C1131a(1));
            }
        }
    }

    public m(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext.getPageActivity(), bdUniqueId);
        this.p = true;
        this.r = new a();
        this.n = tbPageContext;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.b.c.j.e.a
    /* renamed from: j0 */
    public ThreadCardViewHolder R(ViewGroup viewGroup) {
        k0.b bVar = new k0.b(this.n.getPageActivity(), false);
        d.b.i.n nVar = new d.b.i.n(this.n.getPageActivity());
        nVar.x(this.p);
        nVar.w(ImageViewerConfig.FROM_CONCERN);
        bVar.h(nVar);
        k0 k = bVar.k(BaseCardInfo.SupportType.EXTEND, viewGroup, this.q);
        k.r(1);
        ThreadCardViewHolder threadCardViewHolder = new ThreadCardViewHolder(k);
        threadCardViewHolder.k(this.m);
        c0(new b());
        return threadCardViewHolder;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.b.c.j.e.a
    /* renamed from: l0 */
    public View X(int i, View view, ViewGroup viewGroup, d.b.i0.x.e0.k kVar, ThreadCardViewHolder<d.b.i0.x.e0.k> threadCardViewHolder) {
        if (kVar == null || threadCardViewHolder == null || threadCardViewHolder.a() == null || kVar.f63772e == null) {
            return null;
        }
        kVar.U(kVar.position + 1);
        d.b.i0.x.t.b().a(new StatisticItem("c13424"));
        threadCardViewHolder.b().q(i);
        if (threadCardViewHolder.b() instanceof d.b.i0.m.e) {
            threadCardViewHolder.b().setPage(this.o);
        }
        threadCardViewHolder.f(kVar);
        threadCardViewHolder.b().onChangeSkinType(this.n, TbadkCoreApplication.getInst().getSkinType());
        threadCardViewHolder.b().p(this.r);
        return threadCardViewHolder.a();
    }

    public final void m0(View view, d.b.i0.x.e0.k kVar) {
        int id = view.getId();
        if (view.getId() == R.id.thread_card_root) {
            d.b.i0.a1.b.c.b(view, kVar, 2);
        } else if (id == R.id.god_reply_voice_btn) {
            StatisticItem statisticItem = new StatisticItem("c13423");
            statisticItem.param("obj_locate", 4);
            if (kVar != null) {
                statisticItem.param("tid", kVar.l);
                a2 a2Var = kVar.f63772e;
                if (a2Var != null && a2Var.z1() != null) {
                    statisticItem.param("pid", kVar.f63772e.z1().E());
                }
            }
            TiebaStatic.log(statisticItem);
        } else if (id == R.id.god_reply_content) {
            StatisticItem statisticItem2 = new StatisticItem("c13423");
            statisticItem2.param("obj_locate", 2);
            if (kVar != null) {
                statisticItem2.param("tid", kVar.l);
                a2 a2Var2 = kVar.f63772e;
                if (a2Var2 != null && a2Var2.z1() != null) {
                    statisticItem2.param("pid", kVar.f63772e.z1().E());
                }
            }
            TiebaStatic.log(statisticItem2);
        } else if (id != R.id.god_reply_user_pendant_header && id != R.id.god_reply_username_text) {
            if (id == R.id.god_reply_agree_view) {
                StatisticItem statisticItem3 = new StatisticItem("c13423");
                statisticItem3.param("obj_locate", 5);
                if (kVar != null) {
                    statisticItem3.param("tid", kVar.l);
                    a2 a2Var3 = kVar.f63772e;
                    if (a2Var3 != null && a2Var3.z1() != null) {
                        statisticItem3.param("pid", kVar.f63772e.z1().E());
                    }
                }
                TiebaStatic.log(statisticItem3);
            } else if ((view instanceof TbImageView) && (view.getTag(R.id.god_reply_image_layout) instanceof Integer)) {
                StatisticItem statisticItem4 = new StatisticItem("c13423");
                statisticItem4.param("obj_locate", 3);
                if (kVar != null) {
                    statisticItem4.param("tid", kVar.l);
                    a2 a2Var4 = kVar.f63772e;
                    if (a2Var4 != null && a2Var4.z1() != null) {
                        statisticItem4.param("pid", kVar.f63772e.z1().E());
                    }
                }
                TiebaStatic.log(statisticItem4);
            }
        } else {
            StatisticItem statisticItem5 = new StatisticItem("c13423");
            statisticItem5.param("obj_locate", 1);
            if (kVar != null) {
                statisticItem5.param("tid", kVar.l);
                a2 a2Var5 = kVar.f63772e;
                if (a2Var5 != null && a2Var5.z1() != null) {
                    statisticItem5.param("pid", kVar.f63772e.z1().E());
                }
            }
            TiebaStatic.log(statisticItem5);
        }
    }

    public void n0(d.b.c.j.e.s sVar) {
        this.q = sVar;
    }

    @Override // d.b.i0.m.f
    public void o(String str) {
        this.o = str;
    }
}
