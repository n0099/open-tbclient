package d.b.i0.a1.b.e;

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
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
import com.baidu.tieba.card.data.BaseCardInfo;
import d.b.h0.r.q.a2;
import d.b.i.a;
import d.b.i.d;
import d.b.i.f0;
import d.b.i.k0;
import d.b.i.m0;
import d.b.i.n0;
import d.b.i.u0.a;
import d.b.i0.x.b0;
/* loaded from: classes4.dex */
public class e extends d.b.c.j.e.a<d.b.i0.x.e0.k, ThreadCardViewHolder<d.b.i0.x.e0.k>> implements d.b.i0.m.f {
    public BdUniqueId m;
    public TbPageContext<?> n;
    public String o;
    public d.b.c.j.e.s p;
    public b0<d.b.i0.x.e0.k> q;

    /* loaded from: classes4.dex */
    public class a extends b0<d.b.i0.x.e0.k> {
        public a(e eVar) {
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.b.i0.x.b0
        /* renamed from: d */
        public void a(View view, d.b.i0.x.e0.k kVar) {
            if (view == null || kVar == null || kVar.n() == null || StringUtils.isNull(kVar.n().w1())) {
                return;
            }
            int id = view.getId();
            if (id != R.id.thread_card_root && id != R.id.thread_info_commont_container) {
                if (id != R.id.user_avatar && id != R.id.user_name) {
                    if (id == R.id.god_reply_voice_btn) {
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
                        return;
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
                        return;
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
                            return;
                        } else if (id == R.id.forum_name_text) {
                            d.b.i0.a1.b.c.b(view, kVar, 7);
                            return;
                        } else if (id != R.id.thread_card_title && id != R.id.thread_card_abstract) {
                            if (view instanceof TbImageView) {
                                if (view.getTag(R.id.god_reply_image_layout) instanceof Integer) {
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
                                    return;
                                }
                                d.b.i0.a1.b.c.b(view, kVar, 6);
                                return;
                            }
                            return;
                        } else {
                            d.b.i0.a1.b.c.b(view, kVar, 2);
                            return;
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
                        return;
                    }
                }
                d.b.i0.a1.b.c.b(view, kVar, 1);
                return;
            }
            d.b.i0.a1.b.c.b(view, kVar, 2);
        }
    }

    /* loaded from: classes4.dex */
    public class b implements d.b {
        public b(e eVar) {
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
    public class c implements a.InterfaceC1129a {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ f0 f52350a;

        public c(f0 f0Var) {
            this.f52350a = f0Var;
        }

        @Override // d.b.i.a.InterfaceC1129a
        public void a(d.b.h0.r.q.a aVar) {
            if (aVar == null || aVar.n() == null || aVar.n().r1 == null) {
                return;
            }
            ThreadCardUtils.jumpToPB(aVar.n().r1, e.this.f42855e, 1);
            d.b.i0.a1.b.c.b(this.f52350a.g(), aVar, 6);
        }
    }

    /* loaded from: classes4.dex */
    public class d implements a.InterfaceC1129a {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ n0 f52352a;

        public d(n0 n0Var) {
            this.f52352a = n0Var;
        }

        @Override // d.b.i.a.InterfaceC1129a
        public void a(d.b.h0.r.q.a aVar) {
            if (aVar == null || aVar.n() == null || aVar.n().r1 == null) {
                return;
            }
            ThreadCardUtils.jumpToPB(aVar.n().r1, e.this.f42855e, 1);
            d.b.i0.a1.b.c.b(this.f52352a.g(), aVar, 6);
        }
    }

    /* renamed from: d.b.i0.a1.b.e.e$e  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public class C1137e implements d.b.c.j.e.w {
        public C1137e() {
        }

        @Override // d.b.c.j.e.w
        public void f(View view, d.b.c.j.e.n nVar, BdUniqueId bdUniqueId, ViewGroup viewGroup, int i, long j) {
            if ((nVar instanceof d.b.i0.x.e0.k) && (view.getTag() instanceof ThreadCardViewHolder)) {
                ThreadCardViewHolder threadCardViewHolder = (ThreadCardViewHolder) view.getTag();
                d.b.i0.x.e0.k kVar = (d.b.i0.x.e0.k) nVar;
                kVar.k = 1;
                if (e.this.q != null) {
                    e.this.q.a(threadCardViewHolder.a(), kVar);
                }
                ThreadCardUtils.jumpToPB((d.b.h0.r.q.a) kVar, view.getContext(), 1, false);
                threadCardViewHolder.b().o(new a.C1131a(1));
            }
        }
    }

    public e(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext.getPageActivity(), bdUniqueId);
        this.q = new a(this);
        this.n = tbPageContext;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.b.c.j.e.a
    /* renamed from: l0 */
    public ThreadCardViewHolder<d.b.i0.x.e0.k> R(ViewGroup viewGroup) {
        k0.b bVar = new k0.b(this.n.getPageActivity());
        d.b.i.d dVar = new d.b.i.d(this.n.getPageActivity());
        dVar.t(this.m);
        dVar.b(128);
        dVar.c(1024);
        dVar.s(new b(this));
        bVar.o(dVar);
        f0 f0Var = new f0(this.n);
        f0Var.n(Boolean.FALSE);
        f0Var.v(ImageViewerConfig.FROM_CONCERN);
        bVar.l().d(d.b.c.e.p.l.g(this.f42855e, R.dimen.tbds28));
        bVar.n(f0Var);
        f0 f0Var2 = new f0(this.n);
        f0Var2.n(Boolean.TRUE);
        f0Var2.v(ImageViewerConfig.FROM_CONCERN);
        f0Var2.y(d.b.h0.b.g.b.a(), UtilHelper.getDimenPixelSize(R.dimen.M_H_X004), d.b.h0.b.g.b.a(), UtilHelper.getDimenPixelSize(R.dimen.M_H_X004));
        f0Var2.w(new c(f0Var2));
        bVar.h(f0Var2);
        n0 n0Var = new n0(this.n.getPageActivity());
        n0Var.n(Boolean.TRUE);
        n0Var.u(new d(n0Var));
        bVar.h(n0Var);
        bVar.h(new d.b.i.k(this.n.getPageActivity()));
        m0 m0Var = new m0(this.n.getPageActivity());
        d.b.h0.r.q.e eVar = new d.b.h0.r.q.e();
        eVar.f51170b = 9;
        eVar.f51176h = 9;
        m0Var.v(eVar);
        m0Var.w(9);
        m0Var.A(4);
        m0Var.x(1);
        m0Var.b(32);
        bVar.m(m0Var);
        k0 k = bVar.k(BaseCardInfo.SupportType.FULL, viewGroup, this.p);
        k.r(1);
        ThreadCardViewHolder<d.b.i0.x.e0.k> threadCardViewHolder = new ThreadCardViewHolder<>(k);
        threadCardViewHolder.k(this.m);
        c0(new C1137e());
        return threadCardViewHolder;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.b.c.j.e.a
    /* renamed from: m0 */
    public View X(int i, View view, ViewGroup viewGroup, d.b.i0.x.e0.k kVar, ThreadCardViewHolder<d.b.i0.x.e0.k> threadCardViewHolder) {
        if (kVar == null || threadCardViewHolder == null || threadCardViewHolder.a() == null || kVar.f63772e == null) {
            return null;
        }
        kVar.U(kVar.position + 1);
        threadCardViewHolder.b().q(i);
        d.b.i0.x.t.b().a(kVar.A("c12351"));
        threadCardViewHolder.b().setPage(this.o);
        threadCardViewHolder.u(true, Align.ALIGN_RIGHT_TOP);
        threadCardViewHolder.l();
        threadCardViewHolder.f(kVar);
        threadCardViewHolder.b().onChangeSkinType(this.n, TbadkCoreApplication.getInst().getSkinType());
        threadCardViewHolder.b().p(this.q);
        return threadCardViewHolder.a();
    }

    public void n0(d.b.c.j.e.s sVar) {
        this.p = sVar;
    }

    @Override // d.b.i0.m.f
    public void o(String str) {
        this.o = str;
    }
}
