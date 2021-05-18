package d.a.k0.a1.b.e;

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
import d.a.i.a;
import d.a.i.d;
import d.a.i.g0;
import d.a.i.l0;
import d.a.i.n0;
import d.a.i.o0;
import d.a.i.v0.a;
import d.a.j0.r.q.a2;
import d.a.k0.x.b0;
/* loaded from: classes4.dex */
public class e extends d.a.c.j.e.a<d.a.k0.x.e0.k, ThreadCardViewHolder<d.a.k0.x.e0.k>> implements d.a.k0.m.f {
    public BdUniqueId m;
    public TbPageContext<?> n;
    public String o;
    public d.a.c.j.e.s p;
    public b0<d.a.k0.x.e0.k> q;

    /* loaded from: classes4.dex */
    public class a extends b0<d.a.k0.x.e0.k> {
        public a(e eVar) {
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.a.k0.x.b0
        /* renamed from: d */
        public void a(View view, d.a.k0.x.e0.k kVar) {
            if (view == null || kVar == null || kVar.m() == null || StringUtils.isNull(kVar.m().x1())) {
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
                            a2 a2Var = kVar.f63179e;
                            if (a2Var != null && a2Var.A1() != null) {
                                statisticItem.param("pid", kVar.f63179e.A1().E());
                            }
                        }
                        TiebaStatic.log(statisticItem);
                        return;
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
                        return;
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
                            return;
                        } else if (id == R.id.forum_name_text) {
                            d.a.k0.a1.b.c.b(view, kVar, 7);
                            return;
                        } else if (id != R.id.thread_card_title && id != R.id.thread_card_abstract) {
                            if (view instanceof TbImageView) {
                                if (view.getTag(R.id.god_reply_image_layout) instanceof Integer) {
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
                                    return;
                                }
                                d.a.k0.a1.b.c.b(view, kVar, 6);
                                return;
                            }
                            return;
                        } else {
                            d.a.k0.a1.b.c.b(view, kVar, 2);
                            return;
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
                        return;
                    }
                }
                d.a.k0.a1.b.c.b(view, kVar, 1);
                return;
            }
            d.a.k0.a1.b.c.b(view, kVar, 2);
        }
    }

    /* loaded from: classes4.dex */
    public class b implements d.b {
        public b(e eVar) {
        }

        @Override // d.a.i.d.b
        public void a(d.a.j0.r.q.a aVar, View view) {
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
    public class c implements a.InterfaceC0547a {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ g0 f51162a;

        public c(g0 g0Var) {
            this.f51162a = g0Var;
        }

        @Override // d.a.i.a.InterfaceC0547a
        public void a(d.a.j0.r.q.a aVar) {
            if (aVar == null || aVar.m() == null || aVar.m().r1 == null) {
                return;
            }
            ThreadCardUtils.jumpToPB(aVar.m().r1, e.this.f39564e, 1);
            d.a.k0.a1.b.c.b(this.f51162a.g(), aVar, 6);
        }
    }

    /* loaded from: classes4.dex */
    public class d implements a.InterfaceC0547a {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ o0 f51164a;

        public d(o0 o0Var) {
            this.f51164a = o0Var;
        }

        @Override // d.a.i.a.InterfaceC0547a
        public void a(d.a.j0.r.q.a aVar) {
            if (aVar == null || aVar.m() == null || aVar.m().r1 == null) {
                return;
            }
            ThreadCardUtils.jumpToPB(aVar.m().r1, e.this.f39564e, 1);
            d.a.k0.a1.b.c.b(this.f51164a.g(), aVar, 6);
        }
    }

    /* renamed from: d.a.k0.a1.b.e.e$e  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public class C1171e implements d.a.c.j.e.w {
        public C1171e() {
        }

        @Override // d.a.c.j.e.w
        public void b(View view, d.a.c.j.e.n nVar, BdUniqueId bdUniqueId, ViewGroup viewGroup, int i2, long j) {
            if ((nVar instanceof d.a.k0.x.e0.k) && (view.getTag() instanceof ThreadCardViewHolder)) {
                ThreadCardViewHolder threadCardViewHolder = (ThreadCardViewHolder) view.getTag();
                d.a.k0.x.e0.k kVar = (d.a.k0.x.e0.k) nVar;
                kVar.k = 1;
                if (e.this.q != null) {
                    e.this.q.a(threadCardViewHolder.a(), kVar);
                }
                ThreadCardUtils.jumpToPB((d.a.j0.r.q.a) kVar, view.getContext(), 1, false);
                threadCardViewHolder.b().o(new a.C0549a(1));
            }
        }
    }

    public e(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext.getPageActivity(), bdUniqueId);
        this.q = new a(this);
        this.n = tbPageContext;
    }

    @Override // d.a.k0.m.f
    public void g(String str) {
        this.o = str;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.a.c.j.e.a
    /* renamed from: h0 */
    public ThreadCardViewHolder<d.a.k0.x.e0.k> P(ViewGroup viewGroup) {
        l0.b bVar = new l0.b(this.n.getPageActivity());
        d.a.i.d dVar = new d.a.i.d(this.n.getPageActivity());
        dVar.t(this.m);
        dVar.b(128);
        dVar.c(1024);
        dVar.s(new b(this));
        bVar.o(dVar);
        g0 g0Var = new g0(this.n);
        g0Var.n(Boolean.FALSE);
        g0Var.v(ImageViewerConfig.FROM_CONCERN);
        bVar.l().d(d.a.c.e.p.l.g(this.f39564e, R.dimen.tbds28));
        bVar.n(g0Var);
        g0 g0Var2 = new g0(this.n);
        g0Var2.n(Boolean.TRUE);
        g0Var2.v(ImageViewerConfig.FROM_CONCERN);
        g0Var2.y(d.a.j0.b.g.b.a(), UtilHelper.getDimenPixelSize(R.dimen.M_H_X004), d.a.j0.b.g.b.a(), UtilHelper.getDimenPixelSize(R.dimen.M_H_X004));
        g0Var2.w(new c(g0Var2));
        bVar.h(g0Var2);
        o0 o0Var = new o0(this.n.getPageActivity());
        o0Var.n(Boolean.TRUE);
        o0Var.u(new d(o0Var));
        bVar.h(o0Var);
        bVar.h(new d.a.i.k(this.n.getPageActivity()));
        n0 n0Var = new n0(this.n.getPageActivity());
        d.a.j0.r.q.e eVar = new d.a.j0.r.q.e();
        eVar.f49950b = 9;
        eVar.f49956h = 9;
        n0Var.v(eVar);
        n0Var.w(9);
        n0Var.A(4);
        n0Var.x(1);
        n0Var.b(32);
        bVar.m(n0Var);
        l0 k = bVar.k(BaseCardInfo.SupportType.FULL, viewGroup, this.p);
        k.r(1);
        ThreadCardViewHolder<d.a.k0.x.e0.k> threadCardViewHolder = new ThreadCardViewHolder<>(k);
        threadCardViewHolder.j(this.m);
        Z(new C1171e());
        return threadCardViewHolder;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.a.c.j.e.a
    /* renamed from: i0 */
    public View W(int i2, View view, ViewGroup viewGroup, d.a.k0.x.e0.k kVar, ThreadCardViewHolder<d.a.k0.x.e0.k> threadCardViewHolder) {
        if (kVar == null || threadCardViewHolder == null || threadCardViewHolder.a() == null || kVar.f63179e == null) {
            return null;
        }
        kVar.U(kVar.position + 1);
        threadCardViewHolder.b().q(i2);
        d.a.k0.x.t.b().a(kVar.A("c12351"));
        threadCardViewHolder.b().setPage(this.o);
        threadCardViewHolder.s(true, Align.ALIGN_RIGHT_TOP);
        threadCardViewHolder.k();
        threadCardViewHolder.f(kVar);
        threadCardViewHolder.b().onChangeSkinType(this.n, TbadkCoreApplication.getInst().getSkinType());
        threadCardViewHolder.b().p(this.q);
        return threadCardViewHolder.a();
    }

    public void j0(d.a.c.j.e.s sVar) {
        this.p = sVar;
    }
}
