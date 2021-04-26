package d.a.j0.a1.b.e;

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
import d.a.i.f0;
import d.a.i.k0;
import d.a.i.m0;
import d.a.i.o0;
import d.a.i.r0;
import d.a.i.u0.a;
import d.a.i0.r.q.a2;
import d.a.j0.x.b0;
/* loaded from: classes4.dex */
public class q extends d.a.c.j.e.a<d.a.j0.x.e0.k, ThreadCardViewHolder<d.a.j0.x.e0.k>> implements d.a.j0.m.f {
    public BdUniqueId m;
    public TbPageContext<?> n;
    public String o;
    public d.a.c.j.e.s p;
    public b0<d.a.j0.x.e0.k> q;

    /* loaded from: classes4.dex */
    public class a extends b0<d.a.j0.x.e0.k> {
        public a(q qVar) {
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.a.j0.x.b0
        /* renamed from: d */
        public void a(View view, d.a.j0.x.e0.k kVar) {
            if (view == null || kVar == null || kVar.m() == null || StringUtils.isNull(kVar.m().w1())) {
                return;
            }
            int id = view.getId();
            if (id != R.id.thread_card_root && id != R.id.thread_info_commont_container) {
                if (id == R.id.thread_card_voice) {
                    d.a.j0.a1.b.c.b(view, kVar, 6);
                    return;
                } else if (id != R.id.user_avatar && id != R.id.user_name) {
                    if (id == R.id.god_reply_voice_btn) {
                        StatisticItem statisticItem = new StatisticItem("c13423");
                        statisticItem.param("obj_locate", 4);
                        if (kVar != null) {
                            statisticItem.param("tid", kVar.l);
                            a2 a2Var = kVar.f62455e;
                            if (a2Var != null && a2Var.z1() != null) {
                                statisticItem.param("pid", kVar.f62455e.z1().E());
                            }
                        }
                        TiebaStatic.log(statisticItem);
                        return;
                    } else if (id == R.id.god_reply_content) {
                        StatisticItem statisticItem2 = new StatisticItem("c13423");
                        statisticItem2.param("obj_locate", 2);
                        if (kVar != null) {
                            statisticItem2.param("tid", kVar.l);
                            a2 a2Var2 = kVar.f62455e;
                            if (a2Var2 != null && a2Var2.z1() != null) {
                                statisticItem2.param("pid", kVar.f62455e.z1().E());
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
                                a2 a2Var3 = kVar.f62455e;
                                if (a2Var3 != null && a2Var3.z1() != null) {
                                    statisticItem3.param("pid", kVar.f62455e.z1().E());
                                }
                            }
                            TiebaStatic.log(statisticItem3);
                            return;
                        } else if (view.getId() == R.id.forum_name_text) {
                            d.a.j0.a1.b.c.b(view, kVar, 7);
                            return;
                        } else if (view instanceof TbImageView) {
                            if (view.getTag(R.id.god_reply_image_layout) instanceof Integer) {
                                StatisticItem statisticItem4 = new StatisticItem("c13423");
                                statisticItem4.param("obj_locate", 3);
                                if (kVar != null) {
                                    statisticItem4.param("tid", kVar.l);
                                    a2 a2Var4 = kVar.f62455e;
                                    if (a2Var4 != null && a2Var4.z1() != null) {
                                        statisticItem4.param("pid", kVar.f62455e.z1().E());
                                    }
                                }
                                TiebaStatic.log(statisticItem4);
                                return;
                            }
                            d.a.j0.a1.b.c.b(view, kVar, 6);
                            return;
                        } else {
                            return;
                        }
                    } else {
                        StatisticItem statisticItem5 = new StatisticItem("c13423");
                        statisticItem5.param("obj_locate", 1);
                        if (kVar != null) {
                            statisticItem5.param("tid", kVar.l);
                            a2 a2Var5 = kVar.f62455e;
                            if (a2Var5 != null && a2Var5.z1() != null) {
                                statisticItem5.param("pid", kVar.f62455e.z1().E());
                            }
                        }
                        TiebaStatic.log(statisticItem5);
                        return;
                    }
                } else {
                    d.a.j0.a1.b.c.b(view, kVar, 1);
                    return;
                }
            }
            d.a.j0.a1.b.c.b(view, kVar, 2);
        }
    }

    /* loaded from: classes4.dex */
    public class b implements d.b {
        public b(q qVar) {
        }

        @Override // d.a.i.d.b
        public void a(d.a.i0.r.q.a aVar, View view) {
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
    public class c implements a.InterfaceC1009a {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ f0 f50495a;

        public c(f0 f0Var) {
            this.f50495a = f0Var;
        }

        @Override // d.a.i.a.InterfaceC1009a
        public void a(d.a.i0.r.q.a aVar) {
            if (aVar == null || aVar.m() == null || aVar.m().r1 == null) {
                return;
            }
            d.a.i0.z0.t.e(1, q.this.f40319e, aVar.m(), 0, null, VideoPlayActivityConfig.FROM_NANI_VIDEO, "concern_page", null, "concern_tab", "");
            d.a.j0.a1.b.c.b(this.f50495a.g(), aVar, 6);
        }
    }

    /* loaded from: classes4.dex */
    public class d implements a.InterfaceC1009a {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ r0 f50497a;

        public d(r0 r0Var) {
            this.f50497a = r0Var;
        }

        @Override // d.a.i.a.InterfaceC1009a
        public void a(d.a.i0.r.q.a aVar) {
            if (aVar == null || aVar.m() == null || aVar.m().r1 == null) {
                return;
            }
            d.a.i0.z0.t.e(1, q.this.f40319e, aVar.m(), 0, null, VideoPlayActivityConfig.FROM_NANI_VIDEO, "concern_page", null, "concern_tab", "");
            d.a.j0.a1.b.c.b(this.f50497a.g(), aVar, 6);
        }
    }

    /* loaded from: classes4.dex */
    public class e implements d.a.i.v0.a {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ r0 f50499a;

        public e(r0 r0Var) {
            this.f50499a = r0Var;
        }

        @Override // d.a.i.v0.a
        public void a(d.a.i0.r.q.a aVar) {
            boolean z;
            if (aVar == null || aVar.m() == null || aVar.m().r1 == null) {
                return;
            }
            if (aVar.m().r1.r != null) {
                z = aVar.m().r1.r.is_vertical.intValue() == 1;
            } else {
                z = false;
            }
            d.a.i0.z0.t.d(1, z, q.this.f40319e, aVar.m(), 0, null, VideoPlayActivityConfig.FROM_NANI_VIDEO, "concern_page", null, "concern_tab", "");
            d.a.j0.a1.b.c.b(this.f50499a.g(), aVar, 6);
        }
    }

    /* loaded from: classes4.dex */
    public class f implements d.a.c.j.e.w {
        public f() {
        }

        @Override // d.a.c.j.e.w
        public void b(View view, d.a.c.j.e.n nVar, BdUniqueId bdUniqueId, ViewGroup viewGroup, int i2, long j) {
            if ((nVar instanceof d.a.j0.x.e0.k) && (view.getTag() instanceof ThreadCardViewHolder)) {
                ThreadCardViewHolder threadCardViewHolder = (ThreadCardViewHolder) view.getTag();
                d.a.j0.x.e0.k kVar = (d.a.j0.x.e0.k) nVar;
                kVar.k = 1;
                if (q.this.q != null) {
                    q.this.q.a(threadCardViewHolder.a(), kVar);
                }
                ThreadCardUtils.jumpToPB((d.a.i0.r.q.a) kVar, view.getContext(), 1, false, d.a.i.e.a((d.a.c.j.e.s) viewGroup, view, i2));
                threadCardViewHolder.b().o(new a.C1011a(1));
            }
        }
    }

    /* loaded from: classes4.dex */
    public class g implements ThreadCommentAndPraiseInfoLayout.i {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ ViewGroup f50502a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ View f50503b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ int f50504c;

        public g(q qVar, ViewGroup viewGroup, View view, int i2) {
            this.f50502a = viewGroup;
            this.f50503b = view;
            this.f50504c = i2;
        }

        @Override // com.baidu.tbadk.core.view.ThreadCommentAndPraiseInfoLayout.i
        public void a(IntentConfig intentConfig) {
            if (intentConfig instanceof PbActivityConfig) {
                ((PbActivityConfig) intentConfig).setVideoOriginArea(d.a.i.e.a((d.a.c.j.e.s) this.f50502a, this.f50503b, this.f50504c));
            }
        }
    }

    public q(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext.getPageActivity(), bdUniqueId);
        this.q = new a(this);
        this.n = tbPageContext;
    }

    @Override // d.a.j0.m.f
    public void g(String str) {
        this.o = str;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.a.c.j.e.a
    /* renamed from: i0 */
    public ThreadCardViewHolder P(ViewGroup viewGroup) {
        k0.b bVar = new k0.b(this.n.getPageActivity());
        d.a.i.d dVar = new d.a.i.d(this.n.getPageActivity());
        dVar.t(this.m);
        dVar.b(128);
        dVar.c(1024);
        dVar.s(new b(this));
        bVar.o(dVar);
        f0 f0Var = new f0(this.n);
        f0Var.n(Boolean.FALSE);
        f0Var.v(ImageViewerConfig.FROM_CONCERN);
        bVar.l().d(d.a.c.e.p.l.g(this.f40319e, R.dimen.tbds28));
        bVar.n(f0Var);
        f0 f0Var2 = new f0(this.n);
        f0Var2.n(Boolean.TRUE);
        f0Var2.v(ImageViewerConfig.FROM_CONCERN);
        f0Var2.y(UtilHelper.getDimenPixelSize(R.dimen.M_W_X005), UtilHelper.getDimenPixelSize(R.dimen.M_H_X004), UtilHelper.getDimenPixelSize(R.dimen.M_W_X005), UtilHelper.getDimenPixelSize(R.dimen.M_H_X003));
        f0Var2.w(new c(f0Var2));
        bVar.h(f0Var2);
        r0 r0Var = new r0(this.n.getPageActivity());
        r0Var.n(Boolean.TRUE);
        r0Var.v(ImageViewerConfig.FROM_CONCERN);
        r0Var.w(new d(r0Var));
        r0Var.x(new e(r0Var));
        bVar.h(r0Var);
        bVar.h(new o0(this.n.getPageActivity()));
        bVar.h(new d.a.i.k(this.n.getPageActivity()));
        m0 m0Var = new m0(this.n.getPageActivity());
        d.a.i0.r.q.e eVar = new d.a.i0.r.q.e();
        eVar.f49131b = 9;
        eVar.f49137h = 9;
        m0Var.v(eVar);
        m0Var.w(9);
        m0Var.A(4);
        m0Var.x(1);
        m0Var.b(32);
        bVar.m(m0Var);
        k0 k = bVar.k(BaseCardInfo.SupportType.FULL, viewGroup, this.p);
        k.r(1);
        ThreadCardViewHolder threadCardViewHolder = new ThreadCardViewHolder(k);
        threadCardViewHolder.j(this.m);
        Z(new f());
        return threadCardViewHolder;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.a.c.j.e.a
    /* renamed from: j0 */
    public View W(int i2, View view, ViewGroup viewGroup, d.a.j0.x.e0.k kVar, ThreadCardViewHolder threadCardViewHolder) {
        if (kVar == null || threadCardViewHolder == null || threadCardViewHolder.a() == null || kVar.f62455e == null) {
            return null;
        }
        kVar.U(kVar.position + 1);
        threadCardViewHolder.b().q(i2);
        if (threadCardViewHolder.b().e() instanceof m0) {
            ((m0) threadCardViewHolder.b().e()).z(new g(this, viewGroup, view, i2));
        }
        d.a.j0.x.t.b().a(kVar.A("c12351"));
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
