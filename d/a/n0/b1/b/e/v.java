package d.a.n0.b1.b.e;

import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.card.Align;
import com.baidu.card.ThreadCardViewHolder;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.ImageViewerConfig;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.ThreadCardUtils;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
import d.a.i.d;
import d.a.i.l0;
import d.a.i.n0;
import d.a.i.p0;
import d.a.i.q0;
import d.a.i.v0.a;
import d.a.m0.r.q.a2;
import d.a.n0.z.b0;
/* loaded from: classes4.dex */
public class v extends d.a.c.j.e.a<d.a.n0.z.e0.k, ThreadCardViewHolder<d.a.n0.z.e0.k>> implements d.a.n0.o.f {
    public BdUniqueId m;
    public TbPageContext<?> n;
    public String o;
    public boolean p;
    public b0<d.a.n0.z.e0.k> q;

    /* loaded from: classes4.dex */
    public class a extends b0<d.a.n0.z.e0.k> {
        public a(v vVar) {
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.a.n0.z.b0
        /* renamed from: d */
        public void a(View view, d.a.n0.z.e0.k kVar) {
            if (view == null || kVar == null || kVar.m() == null || StringUtils.isNull(kVar.m().y1())) {
                return;
            }
            int id = view.getId();
            if (id != R.id.thread_card_root && id != R.id.thread_info_commont_container) {
                if (id == R.id.thread_card_voice) {
                    d.a.n0.b1.b.c.b(view, kVar, 6);
                    return;
                } else if (id != R.id.user_avatar && id != R.id.user_name) {
                    if (id == R.id.god_reply_voice_btn) {
                        StatisticItem statisticItem = new StatisticItem("c13423");
                        statisticItem.param("obj_locate", 4);
                        if (kVar != null) {
                            statisticItem.param("tid", kVar.l);
                            a2 a2Var = kVar.f63459e;
                            if (a2Var != null && a2Var.B1() != null) {
                                statisticItem.param("pid", kVar.f63459e.B1().E());
                            }
                        }
                        TiebaStatic.log(statisticItem);
                        return;
                    } else if (id == R.id.god_reply_content) {
                        StatisticItem statisticItem2 = new StatisticItem("c13423");
                        statisticItem2.param("obj_locate", 2);
                        if (kVar != null) {
                            statisticItem2.param("tid", kVar.l);
                            a2 a2Var2 = kVar.f63459e;
                            if (a2Var2 != null && a2Var2.B1() != null) {
                                statisticItem2.param("pid", kVar.f63459e.B1().E());
                            }
                        }
                        TiebaStatic.log(statisticItem2);
                        return;
                    } else if (id != R.id.god_reply_user_pendant_header && id != R.id.god_reply_username_text) {
                        if (id == R.id.god_reply_agree_view) {
                            StatisticItem statisticItem3 = new StatisticItem("c13423");
                            statisticItem3.param("obj_locate", 5);
                            if (kVar != null) {
                                statisticItem3.param("tid", kVar.l);
                                a2 a2Var3 = kVar.f63459e;
                                if (a2Var3 != null && a2Var3.B1() != null) {
                                    statisticItem3.param("pid", kVar.f63459e.B1().E());
                                }
                            }
                            TiebaStatic.log(statisticItem3);
                            return;
                        } else if (view.getId() == R.id.forum_name_text) {
                            d.a.n0.b1.b.c.b(view, kVar, 7);
                            return;
                        } else if (view instanceof TbImageView) {
                            if (view.getTag(R.id.god_reply_image_layout) instanceof Integer) {
                                StatisticItem statisticItem4 = new StatisticItem("c13423");
                                statisticItem4.param("obj_locate", 3);
                                if (kVar != null) {
                                    statisticItem4.param("tid", kVar.l);
                                    a2 a2Var4 = kVar.f63459e;
                                    if (a2Var4 != null && a2Var4.B1() != null) {
                                        statisticItem4.param("pid", kVar.f63459e.B1().E());
                                    }
                                }
                                TiebaStatic.log(statisticItem4);
                                return;
                            }
                            d.a.n0.b1.b.c.b(view, kVar, 6);
                            return;
                        } else {
                            return;
                        }
                    } else {
                        StatisticItem statisticItem5 = new StatisticItem("c13423");
                        statisticItem5.param("obj_locate", 1);
                        if (kVar != null) {
                            statisticItem5.param("tid", kVar.l);
                            a2 a2Var5 = kVar.f63459e;
                            if (a2Var5 != null && a2Var5.B1() != null) {
                                statisticItem5.param("pid", kVar.f63459e.B1().E());
                            }
                        }
                        TiebaStatic.log(statisticItem5);
                        return;
                    }
                } else {
                    d.a.n0.b1.b.c.b(view, kVar, 1);
                    return;
                }
            }
            d.a.n0.b1.b.c.b(view, kVar, 2);
        }
    }

    /* loaded from: classes4.dex */
    public class b implements d.b {
        public b(v vVar) {
        }

        @Override // d.a.i.d.b
        public void a(d.a.m0.r.q.a aVar, View view) {
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
    public class c implements d.a.c.j.e.w {
        public c() {
        }

        @Override // d.a.c.j.e.w
        public void b(View view, d.a.c.j.e.n nVar, BdUniqueId bdUniqueId, ViewGroup viewGroup, int i2, long j) {
            if ((nVar instanceof d.a.n0.z.e0.k) && (view.getTag() instanceof ThreadCardViewHolder)) {
                ThreadCardViewHolder threadCardViewHolder = (ThreadCardViewHolder) view.getTag();
                d.a.n0.z.e0.k kVar = (d.a.n0.z.e0.k) nVar;
                kVar.k = 1;
                if (v.this.q != null) {
                    v.this.q.a(threadCardViewHolder.a(), kVar);
                }
                ThreadCardUtils.jumpToPB((d.a.m0.r.q.a) kVar, view.getContext(), 1, false);
                threadCardViewHolder.b().o(new a.C0544a(1));
            }
        }
    }

    public v(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext.getPageActivity(), bdUniqueId);
        this.p = true;
        this.q = new a(this);
        this.n = tbPageContext;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.a.c.j.e.a
    /* renamed from: f0 */
    public ThreadCardViewHolder<d.a.n0.z.e0.k> P(ViewGroup viewGroup) {
        l0.b bVar = new l0.b(this.n.getPageActivity());
        d.a.i.d dVar = new d.a.i.d(this.n.getPageActivity());
        dVar.t(this.m);
        dVar.b(128);
        dVar.c(1024);
        dVar.s(new b(this));
        bVar.o(dVar);
        q0 q0Var = new q0(this.n.getPageActivity());
        bVar.n(q0Var);
        q0Var.u(2);
        bVar.h(new p0(this.n.getPageActivity()));
        bVar.h(new d.a.i.k(this.n.getPageActivity()));
        d.a.i.n nVar = new d.a.i.n(this.n.getPageActivity());
        nVar.x(this.p);
        nVar.w(ImageViewerConfig.FROM_CONCERN);
        bVar.h(nVar);
        n0 n0Var = new n0(this.n.getPageActivity());
        d.a.m0.r.q.e eVar = new d.a.m0.r.q.e();
        eVar.f49994b = 9;
        eVar.f50000h = 9;
        n0Var.v(eVar);
        n0Var.w(9);
        n0Var.A(4);
        n0Var.x(1);
        bVar.m(n0Var);
        l0 i2 = bVar.i();
        i2.r(1);
        ThreadCardViewHolder<d.a.n0.z.e0.k> threadCardViewHolder = new ThreadCardViewHolder<>(i2);
        threadCardViewHolder.j(this.m);
        Z(new c());
        return threadCardViewHolder;
    }

    @Override // d.a.n0.o.f
    public void g(String str) {
        this.o = str;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.a.c.j.e.a
    /* renamed from: g0 */
    public View W(int i2, View view, ViewGroup viewGroup, d.a.n0.z.e0.k kVar, ThreadCardViewHolder<d.a.n0.z.e0.k> threadCardViewHolder) {
        if (kVar == null || threadCardViewHolder == null || threadCardViewHolder.a() == null || kVar.f63459e == null) {
            return null;
        }
        kVar.U(kVar.position + 1);
        d.a.n0.z.t.b().a(kVar.A("c12351"));
        threadCardViewHolder.b().setPage(this.o);
        threadCardViewHolder.s(true, Align.ALIGN_RIGHT_TOP);
        threadCardViewHolder.k();
        threadCardViewHolder.f(kVar);
        threadCardViewHolder.b().onChangeSkinType(this.n, TbadkCoreApplication.getInst().getSkinType());
        threadCardViewHolder.b().p(this.q);
        return threadCardViewHolder.a();
    }
}
