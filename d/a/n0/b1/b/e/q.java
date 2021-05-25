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
import com.baidu.tbadk.core.atomData.PbActivityConfig;
import com.baidu.tbadk.core.atomData.VideoPlayActivityConfig;
import com.baidu.tbadk.core.frameworkData.IntentConfig;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.ThreadCardUtils;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.view.ThreadCommentAndPraiseInfoLayout;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
import com.baidu.tieba.card.data.BaseCardInfo;
import d.a.i.a;
import d.a.i.d;
import d.a.i.g0;
import d.a.i.l0;
import d.a.i.n0;
import d.a.i.p0;
import d.a.i.s0;
import d.a.i.v0.a;
import d.a.m0.r.q.a2;
import d.a.n0.z.b0;
/* loaded from: classes4.dex */
public class q extends d.a.c.j.e.a<d.a.n0.z.e0.k, ThreadCardViewHolder<d.a.n0.z.e0.k>> implements d.a.n0.o.f {
    public BdUniqueId m;
    public TbPageContext<?> n;
    public String o;
    public d.a.c.j.e.s p;
    public b0<d.a.n0.z.e0.k> q;

    /* loaded from: classes4.dex */
    public class a extends b0<d.a.n0.z.e0.k> {
        public a(q qVar) {
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
        public b(q qVar) {
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
    public class c implements a.InterfaceC0542a {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ g0 f51357a;

        public c(g0 g0Var) {
            this.f51357a = g0Var;
        }

        @Override // d.a.i.a.InterfaceC0542a
        public void a(d.a.m0.r.q.a aVar) {
            if (aVar == null || aVar.m() == null || aVar.m().s1 == null) {
                return;
            }
            d.a.m0.z0.t.e(1, q.this.f39228e, aVar.m(), 0, null, VideoPlayActivityConfig.FROM_NANI_VIDEO, "concern_page", null, "concern_tab", "");
            d.a.n0.b1.b.c.b(this.f51357a.g(), aVar, 6);
        }
    }

    /* loaded from: classes4.dex */
    public class d implements a.InterfaceC0542a {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ s0 f51359a;

        public d(s0 s0Var) {
            this.f51359a = s0Var;
        }

        @Override // d.a.i.a.InterfaceC0542a
        public void a(d.a.m0.r.q.a aVar) {
            if (aVar == null || aVar.m() == null || aVar.m().s1 == null) {
                return;
            }
            d.a.m0.z0.t.e(1, q.this.f39228e, aVar.m(), 0, null, VideoPlayActivityConfig.FROM_NANI_VIDEO, "concern_page", null, "concern_tab", "");
            d.a.n0.b1.b.c.b(this.f51359a.g(), aVar, 6);
        }
    }

    /* loaded from: classes4.dex */
    public class e implements d.a.i.w0.a {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ s0 f51361a;

        public e(s0 s0Var) {
            this.f51361a = s0Var;
        }

        @Override // d.a.i.w0.a
        public void a(d.a.m0.r.q.a aVar) {
            boolean z;
            if (aVar == null || aVar.m() == null || aVar.m().s1 == null) {
                return;
            }
            if (aVar.m().s1.r != null) {
                z = aVar.m().s1.r.is_vertical.intValue() == 1;
            } else {
                z = false;
            }
            d.a.m0.z0.t.d(1, z, q.this.f39228e, aVar.m(), 0, null, VideoPlayActivityConfig.FROM_NANI_VIDEO, "concern_page", null, "concern_tab", "");
            d.a.n0.b1.b.c.b(this.f51361a.g(), aVar, 6);
        }
    }

    /* loaded from: classes4.dex */
    public class f implements d.a.c.j.e.w {
        public f() {
        }

        @Override // d.a.c.j.e.w
        public void b(View view, d.a.c.j.e.n nVar, BdUniqueId bdUniqueId, ViewGroup viewGroup, int i2, long j) {
            if ((nVar instanceof d.a.n0.z.e0.k) && (view.getTag() instanceof ThreadCardViewHolder)) {
                ThreadCardViewHolder threadCardViewHolder = (ThreadCardViewHolder) view.getTag();
                d.a.n0.z.e0.k kVar = (d.a.n0.z.e0.k) nVar;
                kVar.k = 1;
                if (q.this.q != null) {
                    q.this.q.a(threadCardViewHolder.a(), kVar);
                }
                ThreadCardUtils.jumpToPB((d.a.m0.r.q.a) kVar, view.getContext(), 1, false, d.a.i.e.a((d.a.c.j.e.s) viewGroup, view, i2));
                threadCardViewHolder.b().o(new a.C0544a(1));
            }
        }
    }

    /* loaded from: classes4.dex */
    public class g implements ThreadCommentAndPraiseInfoLayout.i {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ ViewGroup f51364a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ View f51365b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ int f51366c;

        public g(q qVar, ViewGroup viewGroup, View view, int i2) {
            this.f51364a = viewGroup;
            this.f51365b = view;
            this.f51366c = i2;
        }

        @Override // com.baidu.tbadk.core.view.ThreadCommentAndPraiseInfoLayout.i
        public void a(IntentConfig intentConfig) {
            if (intentConfig instanceof PbActivityConfig) {
                ((PbActivityConfig) intentConfig).setVideoOriginArea(d.a.i.e.a((d.a.c.j.e.s) this.f51364a, this.f51365b, this.f51366c));
            }
        }
    }

    public q(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext.getPageActivity(), bdUniqueId);
        this.q = new a(this);
        this.n = tbPageContext;
    }

    @Override // d.a.n0.o.f
    public void g(String str) {
        this.o = str;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.a.c.j.e.a
    /* renamed from: i0 */
    public ThreadCardViewHolder P(ViewGroup viewGroup) {
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
        bVar.l().d(d.a.c.e.p.l.g(this.f39228e, R.dimen.tbds28));
        bVar.n(g0Var);
        g0 g0Var2 = new g0(this.n);
        g0Var2.n(Boolean.TRUE);
        g0Var2.v(ImageViewerConfig.FROM_CONCERN);
        g0Var2.y(UtilHelper.getDimenPixelSize(R.dimen.M_W_X005), UtilHelper.getDimenPixelSize(R.dimen.M_H_X004), UtilHelper.getDimenPixelSize(R.dimen.M_W_X005), UtilHelper.getDimenPixelSize(R.dimen.M_H_X003));
        g0Var2.w(new c(g0Var2));
        bVar.h(g0Var2);
        s0 s0Var = new s0(this.n.getPageActivity());
        s0Var.n(Boolean.TRUE);
        s0Var.v(ImageViewerConfig.FROM_CONCERN);
        s0Var.w(new d(s0Var));
        s0Var.x(new e(s0Var));
        bVar.h(s0Var);
        bVar.h(new p0(this.n.getPageActivity()));
        bVar.h(new d.a.i.k(this.n.getPageActivity()));
        n0 n0Var = new n0(this.n.getPageActivity());
        d.a.m0.r.q.e eVar = new d.a.m0.r.q.e();
        eVar.f49994b = 9;
        eVar.f50000h = 9;
        n0Var.v(eVar);
        n0Var.w(9);
        n0Var.A(4);
        n0Var.x(1);
        n0Var.b(32);
        bVar.m(n0Var);
        l0 k = bVar.k(BaseCardInfo.SupportType.FULL, viewGroup, this.p);
        k.r(1);
        ThreadCardViewHolder threadCardViewHolder = new ThreadCardViewHolder(k);
        threadCardViewHolder.j(this.m);
        Z(new f());
        return threadCardViewHolder;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.a.c.j.e.a
    /* renamed from: j0 */
    public View W(int i2, View view, ViewGroup viewGroup, d.a.n0.z.e0.k kVar, ThreadCardViewHolder threadCardViewHolder) {
        if (kVar == null || threadCardViewHolder == null || threadCardViewHolder.a() == null || kVar.f63459e == null) {
            return null;
        }
        kVar.U(kVar.position + 1);
        threadCardViewHolder.b().q(i2);
        if (threadCardViewHolder.b().e() instanceof n0) {
            ((n0) threadCardViewHolder.b().e()).z(new g(this, viewGroup, view, i2));
        }
        d.a.n0.z.t.b().a(kVar.A("c12351"));
        threadCardViewHolder.b().setPage(this.o);
        threadCardViewHolder.s(true, Align.ALIGN_RIGHT_TOP);
        threadCardViewHolder.k();
        threadCardViewHolder.f(kVar);
        threadCardViewHolder.b().onChangeSkinType(this.n, TbadkCoreApplication.getInst().getSkinType());
        threadCardViewHolder.b().p(this.q);
        return threadCardViewHolder.a();
    }

    public void m0(d.a.c.j.e.s sVar) {
        this.p = sVar;
    }
}
