package d.a.k0.a1.b.e;

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
import d.a.i.l0;
import d.a.i.v0.a;
import d.a.j0.r.q.a2;
import d.a.k0.x.b0;
/* loaded from: classes4.dex */
public class m extends d.a.c.j.e.a<d.a.k0.x.e0.k, ThreadCardViewHolder<d.a.k0.x.e0.k>> implements d.a.k0.m.f {
    public BdUniqueId m;
    public TbPageContext<?> n;
    public String o;
    public boolean p;
    public d.a.c.j.e.s q;
    public b0<d.a.k0.x.e0.k> r;

    /* loaded from: classes4.dex */
    public class a extends b0<d.a.k0.x.e0.k> {
        public a() {
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.a.k0.x.b0
        /* renamed from: d */
        public void a(View view, d.a.k0.x.e0.k kVar) {
            if (view == null || kVar == null || kVar.m() == null || StringUtils.isNull(kVar.m().x1())) {
                return;
            }
            m.this.i0(view, kVar);
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
                if (m.this.r != null) {
                    m.this.r.a(threadCardViewHolder.a(), kVar);
                }
                ThreadCardUtils.jumpToPB((d.a.j0.r.q.a) kVar, view.getContext(), 1, false);
                threadCardViewHolder.b().o(new a.C0549a(1));
            }
        }
    }

    public m(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext.getPageActivity(), bdUniqueId);
        this.p = true;
        this.r = new a();
        this.n = tbPageContext;
    }

    @Override // d.a.k0.m.f
    public void g(String str) {
        this.o = str;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.a.c.j.e.a
    /* renamed from: g0 */
    public ThreadCardViewHolder P(ViewGroup viewGroup) {
        l0.b bVar = new l0.b(this.n.getPageActivity(), false);
        d.a.i.n nVar = new d.a.i.n(this.n.getPageActivity());
        nVar.x(this.p);
        nVar.w(ImageViewerConfig.FROM_CONCERN);
        bVar.h(nVar);
        l0 k = bVar.k(BaseCardInfo.SupportType.EXTEND, viewGroup, this.q);
        k.r(1);
        ThreadCardViewHolder threadCardViewHolder = new ThreadCardViewHolder(k);
        threadCardViewHolder.j(this.m);
        Z(new b());
        return threadCardViewHolder;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.a.c.j.e.a
    /* renamed from: h0 */
    public View W(int i2, View view, ViewGroup viewGroup, d.a.k0.x.e0.k kVar, ThreadCardViewHolder<d.a.k0.x.e0.k> threadCardViewHolder) {
        if (kVar == null || threadCardViewHolder == null || threadCardViewHolder.a() == null || kVar.f63179e == null) {
            return null;
        }
        kVar.U(kVar.position + 1);
        d.a.k0.x.t.b().a(new StatisticItem("c13424"));
        threadCardViewHolder.b().q(i2);
        if (threadCardViewHolder.b() instanceof d.a.k0.m.e) {
            threadCardViewHolder.b().setPage(this.o);
        }
        threadCardViewHolder.f(kVar);
        threadCardViewHolder.b().onChangeSkinType(this.n, TbadkCoreApplication.getInst().getSkinType());
        threadCardViewHolder.b().p(this.r);
        return threadCardViewHolder.a();
    }

    public final void i0(View view, d.a.k0.x.e0.k kVar) {
        int id = view.getId();
        if (view.getId() == R.id.thread_card_root) {
            d.a.k0.a1.b.c.b(view, kVar, 2);
        } else if (id == R.id.god_reply_voice_btn) {
            StatisticItem statisticItem = new StatisticItem("c13423");
            statisticItem.param("obj_locate", 4);
            if (kVar != null) {
                statisticItem.param("tid", kVar.l);
                a2 a2Var = kVar.f63179e;
                if (a2Var != null && a2Var.A1() != null) {
                    statisticItem.param("pid", kVar.f63179e.A1().E());
                }
            }
            TiebaStatic.log(statisticItem);
        } else if (id == R.id.god_reply_content) {
            StatisticItem statisticItem2 = new StatisticItem("c13423");
            statisticItem2.param("obj_locate", 2);
            if (kVar != null) {
                statisticItem2.param("tid", kVar.l);
                a2 a2Var2 = kVar.f63179e;
                if (a2Var2 != null && a2Var2.A1() != null) {
                    statisticItem2.param("pid", kVar.f63179e.A1().E());
                }
            }
            TiebaStatic.log(statisticItem2);
        } else if (id != R.id.god_reply_user_pendant_header && id != R.id.god_reply_username_text) {
            if (id == R.id.god_reply_agree_view) {
                StatisticItem statisticItem3 = new StatisticItem("c13423");
                statisticItem3.param("obj_locate", 5);
                if (kVar != null) {
                    statisticItem3.param("tid", kVar.l);
                    a2 a2Var3 = kVar.f63179e;
                    if (a2Var3 != null && a2Var3.A1() != null) {
                        statisticItem3.param("pid", kVar.f63179e.A1().E());
                    }
                }
                TiebaStatic.log(statisticItem3);
            } else if ((view instanceof TbImageView) && (view.getTag(R.id.god_reply_image_layout) instanceof Integer)) {
                StatisticItem statisticItem4 = new StatisticItem("c13423");
                statisticItem4.param("obj_locate", 3);
                if (kVar != null) {
                    statisticItem4.param("tid", kVar.l);
                    a2 a2Var4 = kVar.f63179e;
                    if (a2Var4 != null && a2Var4.A1() != null) {
                        statisticItem4.param("pid", kVar.f63179e.A1().E());
                    }
                }
                TiebaStatic.log(statisticItem4);
            }
        } else {
            StatisticItem statisticItem5 = new StatisticItem("c13423");
            statisticItem5.param("obj_locate", 1);
            if (kVar != null) {
                statisticItem5.param("tid", kVar.l);
                a2 a2Var5 = kVar.f63179e;
                if (a2Var5 != null && a2Var5.A1() != null) {
                    statisticItem5.param("pid", kVar.f63179e.A1().E());
                }
            }
            TiebaStatic.log(statisticItem5);
        }
    }

    public void j0(d.a.c.j.e.s sVar) {
        this.q = sVar;
    }
}
