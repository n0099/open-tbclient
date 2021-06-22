package d.a.o0.b1.c.e;

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
import d.a.n0.r.q.a2;
import d.a.o0.z.b0;
/* loaded from: classes4.dex */
public class m extends d.a.c.k.e.a<d.a.o0.z.e0.k, ThreadCardViewHolder<d.a.o0.z.e0.k>> implements d.a.o0.o.f {
    public BdUniqueId m;
    public TbPageContext<?> n;
    public String o;
    public boolean p;
    public d.a.c.k.e.s q;
    public b0<d.a.o0.z.e0.k> r;

    /* loaded from: classes4.dex */
    public class a extends b0<d.a.o0.z.e0.k> {
        public a() {
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.a.o0.z.b0
        /* renamed from: d */
        public void a(View view, d.a.o0.z.e0.k kVar) {
            if (view == null || kVar == null || kVar.i() == null || StringUtils.isNull(kVar.i().z1())) {
                return;
            }
            m.this.j0(view, kVar);
        }
    }

    /* loaded from: classes4.dex */
    public class b implements d.a.c.k.e.w {
        public b() {
        }

        @Override // d.a.c.k.e.w
        public void b(View view, d.a.c.k.e.n nVar, BdUniqueId bdUniqueId, ViewGroup viewGroup, int i2, long j) {
            if ((nVar instanceof d.a.o0.z.e0.k) && (view.getTag() instanceof ThreadCardViewHolder)) {
                ThreadCardViewHolder threadCardViewHolder = (ThreadCardViewHolder) view.getTag();
                d.a.o0.z.e0.k kVar = (d.a.o0.z.e0.k) nVar;
                kVar.k = 1;
                if (m.this.r != null) {
                    m.this.r.a(threadCardViewHolder.a(), kVar);
                }
                ThreadCardUtils.jumpToPB((d.a.n0.r.q.a) kVar, view.getContext(), 1, false);
                threadCardViewHolder.b().o(new a.C0602a(1));
            }
        }
    }

    public m(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext.getPageActivity(), bdUniqueId);
        this.p = true;
        this.r = new a();
        this.n = tbPageContext;
    }

    @Override // d.a.o0.o.f
    public void g(String str) {
        this.o = str;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.a.c.k.e.a
    /* renamed from: h0 */
    public ThreadCardViewHolder Q(ViewGroup viewGroup) {
        l0.b bVar = new l0.b(this.n.getPageActivity(), false);
        d.a.i.n nVar = new d.a.i.n(this.n.getPageActivity());
        nVar.x(this.p);
        nVar.w(ImageViewerConfig.FROM_CONCERN);
        bVar.h(nVar);
        l0 k = bVar.k(BaseCardInfo.SupportType.EXTEND, viewGroup, this.q);
        k.r(1);
        ThreadCardViewHolder threadCardViewHolder = new ThreadCardViewHolder(k);
        threadCardViewHolder.k(this.m);
        a0(new b());
        return threadCardViewHolder;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.a.c.k.e.a
    /* renamed from: i0 */
    public View X(int i2, View view, ViewGroup viewGroup, d.a.o0.z.e0.k kVar, ThreadCardViewHolder<d.a.o0.z.e0.k> threadCardViewHolder) {
        if (kVar == null || threadCardViewHolder == null || threadCardViewHolder.a() == null || kVar.f67302e == null) {
            return null;
        }
        kVar.U(kVar.position + 1);
        d.a.o0.z.t.b().a(new StatisticItem("c13424"));
        threadCardViewHolder.b().q(i2);
        if (threadCardViewHolder.b() instanceof d.a.o0.o.e) {
            threadCardViewHolder.b().setPage(this.o);
        }
        threadCardViewHolder.f(kVar);
        threadCardViewHolder.b().onChangeSkinType(this.n, TbadkCoreApplication.getInst().getSkinType());
        threadCardViewHolder.b().p(this.r);
        return threadCardViewHolder.a();
    }

    public final void j0(View view, d.a.o0.z.e0.k kVar) {
        int id = view.getId();
        if (view.getId() == R.id.thread_card_root) {
            d.a.o0.b1.c.c.b(view, kVar, 2);
        } else if (id == R.id.god_reply_voice_btn) {
            StatisticItem statisticItem = new StatisticItem("c13423");
            statisticItem.param("obj_locate", 4);
            if (kVar != null) {
                statisticItem.param("tid", kVar.l);
                a2 a2Var = kVar.f67302e;
                if (a2Var != null && a2Var.C1() != null) {
                    statisticItem.param("pid", kVar.f67302e.C1().E());
                }
            }
            TiebaStatic.log(statisticItem);
        } else if (id == R.id.god_reply_content) {
            StatisticItem statisticItem2 = new StatisticItem("c13423");
            statisticItem2.param("obj_locate", 2);
            if (kVar != null) {
                statisticItem2.param("tid", kVar.l);
                a2 a2Var2 = kVar.f67302e;
                if (a2Var2 != null && a2Var2.C1() != null) {
                    statisticItem2.param("pid", kVar.f67302e.C1().E());
                }
            }
            TiebaStatic.log(statisticItem2);
        } else if (id != R.id.god_reply_user_pendant_header && id != R.id.god_reply_username_text) {
            if (id == R.id.god_reply_agree_view) {
                StatisticItem statisticItem3 = new StatisticItem("c13423");
                statisticItem3.param("obj_locate", 5);
                if (kVar != null) {
                    statisticItem3.param("tid", kVar.l);
                    a2 a2Var3 = kVar.f67302e;
                    if (a2Var3 != null && a2Var3.C1() != null) {
                        statisticItem3.param("pid", kVar.f67302e.C1().E());
                    }
                }
                TiebaStatic.log(statisticItem3);
            } else if ((view instanceof TbImageView) && (view.getTag(R.id.god_reply_image_layout) instanceof Integer)) {
                StatisticItem statisticItem4 = new StatisticItem("c13423");
                statisticItem4.param("obj_locate", 3);
                if (kVar != null) {
                    statisticItem4.param("tid", kVar.l);
                    a2 a2Var4 = kVar.f67302e;
                    if (a2Var4 != null && a2Var4.C1() != null) {
                        statisticItem4.param("pid", kVar.f67302e.C1().E());
                    }
                }
                TiebaStatic.log(statisticItem4);
            }
        } else {
            StatisticItem statisticItem5 = new StatisticItem("c13423");
            statisticItem5.param("obj_locate", 1);
            if (kVar != null) {
                statisticItem5.param("tid", kVar.l);
                a2 a2Var5 = kVar.f67302e;
                if (a2Var5 != null && a2Var5.C1() != null) {
                    statisticItem5.param("pid", kVar.f67302e.C1().E());
                }
            }
            TiebaStatic.log(statisticItem5);
        }
    }

    public void k0(d.a.c.k.e.s sVar) {
        this.q = sVar;
    }
}
