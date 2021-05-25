package d.a.n0.r0.o2;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.plugin.PluginCenter;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.TbadkSettings;
import com.baidu.tbadk.core.BaseFragmentActivity;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.ForumDetailActivityConfig;
import com.baidu.tbadk.core.atomData.ForumMemberActivityConfig;
import com.baidu.tbadk.core.atomData.HotUserRankActivityConfig;
import com.baidu.tbadk.core.atomData.SupplementSignActivityConfig;
import com.baidu.tbadk.core.data.ForumData;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.UrlManager;
import com.baidu.tbadk.core.util.ViewHelper;
import com.baidu.tieba.R;
import com.baidu.tieba.frs.FrsFragment;
import com.baidu.tieba.frs.vc.FrsTabViewController;
import com.baidu.tieba.frs.view.FrsHeaderViewContainer;
import com.baidu.tieba.tbadkCore.FrsViewData;
import d.a.n0.r0.r;
import java.util.ArrayList;
/* loaded from: classes4.dex */
public class h extends d.a.c.a.d<BaseFragmentActivity> {

    /* renamed from: a  reason: collision with root package name */
    public FrsFragment f59266a;

    /* renamed from: b  reason: collision with root package name */
    public FrsHeaderViewContainer f59267b;

    /* renamed from: c  reason: collision with root package name */
    public d.a.n0.r0.r2.b f59268c;

    /* renamed from: d  reason: collision with root package name */
    public d.a.n0.r0.n1.e.a f59269d;

    /* renamed from: e  reason: collision with root package name */
    public boolean f59270e;

    /* renamed from: f  reason: collision with root package name */
    public BdUniqueId f59271f;

    /* renamed from: g  reason: collision with root package name */
    public int f59272g;

    /* renamed from: h  reason: collision with root package name */
    public String f59273h;

    /* renamed from: i  reason: collision with root package name */
    public int f59274i;
    public boolean j;
    public int k;
    public d.a.n0.g0.a l;
    public FrsTabViewController m;
    public g n;
    public f o;
    public final Runnable p;
    public final Runnable q;
    public Runnable r;
    public final View.OnClickListener s;

    /* loaded from: classes4.dex */
    public class a implements Runnable {
        public a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            r y0;
            if (h.this.f59266a != null && h.this.f59274i == 0 && (y0 = h.this.f59266a.y0()) != null && y0.W() != null && !y0.W().o() && !y0.Y() && h.this.f59267b.isShown() && h.this.f59266a.isPrimary() && !h.this.j && h.this.f59266a.c2() && h.this.k == 1 && h.this.z() && h.this.f59268c != null && h.this.f59268c.q()) {
                TbadkSettings.getInst().saveBoolean("speed_icon_show" + TbadkCoreApplication.getCurrentAccount(), true);
                h.this.x0();
                h.this.f59266a.f15025g = true;
                h.this.j = true;
            }
        }
    }

    /* loaded from: classes4.dex */
    public class b implements Runnable {
        public b() {
        }

        @Override // java.lang.Runnable
        public void run() {
            if (h.this.f59266a != null && h.this.f59274i == 0 && !h.this.f59266a.y0().Y() && h.this.f59267b.isShown() && h.this.f59266a.isPrimary()) {
                h.this.u0();
            }
        }
    }

    /* loaded from: classes4.dex */
    public class c implements Runnable {
        public c() {
        }

        public final void a(View view) {
            if (view == null) {
                return;
            }
            if (view instanceof d.a.c.f.a.i) {
                ((d.a.c.f.a.i) view).refresh();
            }
            if (view instanceof ViewGroup) {
                ViewGroup viewGroup = (ViewGroup) view;
                int childCount = viewGroup.getChildCount();
                for (int i2 = 0; i2 < childCount; i2++) {
                    a(viewGroup.getChildAt(i2));
                }
            }
        }

        @Override // java.lang.Runnable
        public void run() {
            if (h.this.f59267b != null) {
                int childCount = h.this.f59267b.getChildCount();
                for (int i2 = 0; i2 < childCount; i2++) {
                    a(h.this.f59267b.getChildAt(i2));
                }
            }
        }
    }

    /* loaded from: classes4.dex */
    public class d implements View.OnClickListener {
        public d() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (h.this.f59266a == null) {
                return;
            }
            FrsViewData g0 = h.this.f59266a.g0();
            if (g0 != null && g0.getForum() != null && h.this.f59268c != null && (view == h.this.f59268c.e() || view == h.this.f59268c.f() || view == h.this.f59268c.i())) {
                if (h.this.f59266a != null && g0.getForum() != null) {
                    TiebaStatic.log(new StatisticItem("c12046").param("fid", g0.getForum().getId()).param("obj_locate", h.this.f59266a.K2() ? 1 : 2));
                }
                ArrayList<String> arrayList = new ArrayList<>();
                if (g0.getEntelechyTabInfo() != null && g0.getEntelechyTabInfo().tab != null) {
                    for (int i2 = 0; i2 < g0.getEntelechyTabInfo().tab.size(); i2++) {
                        arrayList.add(g0.getEntelechyTabInfo().tab.get(i2).tab_name);
                    }
                }
                ForumDetailActivityConfig forumDetailActivityConfig = new ForumDetailActivityConfig(h.this.getPageContext().getPageActivity(), g0.getForum().getId(), ForumDetailActivityConfig.FromType.FRS);
                forumDetailActivityConfig.setForumTabs(arrayList);
                MessageManager.getInstance().sendMessage(new CustomMessage(2002001, forumDetailActivityConfig));
            }
            int id = view.getId();
            if (id == R.id.tv_love) {
                if (h.this.f59266a.t2()) {
                    return;
                }
                if (!d.a.c.e.p.j.z()) {
                    h.this.f59266a.showToast(R.string.neterror);
                } else if (!ViewHelper.checkUpIsLogin(h.this.mContext.getPageActivity())) {
                    TiebaStatic.log(new StatisticItem("c10517").param("obj_locate", 1).param("fid", h.this.f59266a.h()));
                } else {
                    h.this.z0(true);
                    if (d.a.c.e.p.k.isEmpty(TbadkCoreApplication.getInst().getTaskId())) {
                        return;
                    }
                    StatisticItem statisticItem = new StatisticItem("c10048");
                    statisticItem.param("fid", h.this.f59266a.h());
                    statisticItem.param("obj_source", TbadkCoreApplication.getInst().getTaskId());
                    TiebaStatic.log(statisticItem);
                }
            } else if (id == R.id.tv_sign) {
                if (h.this.f59266a.t2()) {
                    return;
                }
                if (!d.a.c.e.p.j.z()) {
                    h.this.f59266a.showToast(R.string.neterror);
                } else if (ViewHelper.checkUpIsLogin(h.this.mContext.getPageActivity())) {
                    if (!h.this.v()) {
                        h.this.A0();
                        StatisticItem.make("c13560").param("obj_type", 2).eventStat();
                    } else if (TbadkCoreApplication.getInst().getUseNewResign() == 1) {
                        MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new SupplementSignActivityConfig(h.this.f59266a.getPageContext().getPageActivity(), d.a.c.e.m.b.d(h.this.f59266a.h(), 0), 24002)));
                    }
                }
            } else if (id == R.id.frs_header_games) {
                if (!ViewHelper.checkUpIsLogin(h.this.mContext.getPageActivity()) || g0 == null || g0.getGameUrl() == null) {
                    return;
                }
                UrlManager.getInstance().dealOneLink((TbPageContext) h.this.getPageContext(), new String[]{g0.getGameUrl()}, true);
            } else if (id == R.id.frs_bawu_center) {
                if (g0 == null || g0.getUserData() == null || !g0.getUserData().isBawu()) {
                    return;
                }
                String bawuCenterUrl = g0.getBawuCenterUrl();
                if (d.a.c.e.p.k.isEmpty(bawuCenterUrl)) {
                    return;
                }
                d.a.m0.l.a.l(h.this.getPageContext().getPageActivity(), bawuCenterUrl);
                if (g0.getForum() != null) {
                    TiebaStatic.log(new StatisticItem("c10502").param("fid", g0.getForum().getId()).param("uid", g0.getUserData().getUserId()));
                }
            } else if (id == R.id.level_container) {
                if (h.this.f59266a.t2() || h.this.f59274i != 0 || !h.this.z() || h.this.f59268c == null) {
                    return;
                }
                h.this.f59268c.M(view, false);
            } else if (id == R.id.frs_hot_rank_entry) {
                if (g0 == null || g0.getForum() == null || TextUtils.isEmpty(g0.getForum().getId())) {
                    return;
                }
                HotUserRankActivityConfig hotUserRankActivityConfig = new HotUserRankActivityConfig(h.this.getPageContext().getPageActivity());
                hotUserRankActivityConfig.setForumId(Long.valueOf(d.a.c.e.m.b.f(g0.getForum().getId(), 0L)));
                MessageManager.getInstance().sendMessage(new CustomMessage(2002001, hotUserRankActivityConfig));
                StatisticItem statisticItem2 = new StatisticItem("c13666");
                statisticItem2.param("fid", g0.getForum().getId());
                TiebaStatic.log(statisticItem2);
            } else if (id == R.id.frs_manager_info_layout) {
                if (g0 == null || g0.getForum() == null || TextUtils.isEmpty(g0.getForum().getId())) {
                    return;
                }
                MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new ForumMemberActivityConfig(h.this.getPageContext().getPageActivity(), String.valueOf(g0.getForum().getId()), g0.getForum().getName())));
            } else if (id == R.id.frs_manager_application_layout && ViewHelper.checkUpIsLogin(h.this.mContext.getPageActivity()) && g0 != null && g0.getForum() != null && !TextUtils.isEmpty(g0.getForum().getId())) {
                UrlManager urlManager = UrlManager.getInstance();
                TbPageContext<?> o = h.this.f59266a.o();
                urlManager.dealOneLink(o, new String[]{TbConfig.URL_FORUM_MANAGER_APPLY + g0.getForum().getId()});
            }
        }
    }

    public h(FrsFragment frsFragment, d.a.n0.r0.n1.e.a aVar, FrsHeaderViewContainer frsHeaderViewContainer) {
        super(frsFragment.getPageContext());
        this.f59270e = false;
        this.f59272g = 0;
        this.f59273h = "normal_page";
        this.f59274i = 0;
        this.j = false;
        this.p = new a();
        this.q = new b();
        this.r = new c();
        this.s = new d();
        this.f59266a = frsFragment;
        this.f59269d = aVar;
        this.f59267b = frsHeaderViewContainer;
        BdUniqueId gen = BdUniqueId.gen();
        this.f59271f = gen;
        this.n = new g(this.f59266a, gen);
        this.o = new f(this.f59266a);
        this.l = new d.a.n0.g0.a();
    }

    public static boolean F(FrsViewData frsViewData) {
        return (frsViewData == null || frsViewData.getBookInfo() == null || StringUtils.isNull(frsViewData.getBookInfo().a(), true) || frsViewData.getBookInfo().a().equals("0")) ? false : true;
    }

    public static boolean G(FrsViewData frsViewData) {
        if (frsViewData != null) {
            return ((frsViewData.getStar() == null || frsViewData.getStar().b() != 1) && frsViewData.getHeadSdkData() == null && (frsViewData.getActivityHeadData() == null || ListUtils.isEmpty(frsViewData.getActivityHeadData().a())) && ((frsViewData.getForum() == null || frsViewData.getForum().getFrsBannerData() == null || frsViewData.getForum().getFrsBannerData().d() != 2) && (frsViewData.getHeadlineImgInfoData() == null || StringUtils.isNull(frsViewData.getHeadlineImgInfoData().a(), true)))) ? false : true;
        }
        return false;
    }

    public boolean A() {
        return true;
    }

    public void A0() {
        g gVar = this.n;
        if (gVar != null) {
            d.a.n0.r0.r2.b bVar = this.f59268c;
            if (bVar != null) {
                gVar.v(bVar.p(), this.f59268c.d());
            } else {
                gVar.v(false, "");
            }
            d.a.n0.r0.r2.b bVar2 = this.f59268c;
            if (bVar2 != null) {
                this.n.u(bVar2.j());
            }
        }
    }

    public boolean B() {
        d.a.n0.r0.r2.b bVar;
        if (!z() || (bVar = this.f59268c) == null) {
            return false;
        }
        return bVar.o();
    }

    public void B0() {
        f fVar = this.o;
        if (fVar != null) {
            fVar.s();
        }
    }

    public void C0(int i2, int i3, int i4) {
        g gVar = this.n;
        if (gVar != null) {
            gVar.w(i2, i3, i4);
        }
    }

    public void H(Bundle bundle) {
        g gVar = this.n;
        if (gVar != null) {
            gVar.n();
        }
        f fVar = this.o;
        if (fVar != null) {
            fVar.m();
        }
        this.j = TbadkSettings.getInst().loadBoolean("speed_icon_show" + TbadkCoreApplication.getCurrentAccount(), false);
    }

    public void I() {
        d.a.n0.r0.r2.b bVar = this.f59268c;
        if (bVar != null) {
            bVar.r();
        }
        f fVar = this.o;
        if (fVar != null) {
            fVar.n();
        }
        if (this.p != null) {
            d.a.c.e.m.e.a().removeCallbacks(this.p);
        }
        if (this.q != null) {
            d.a.c.e.m.e.a().removeCallbacks(this.q);
        }
    }

    public void J() {
        d.a.n0.r0.r2.b bVar = this.f59268c;
        if (bVar != null) {
            bVar.t();
        }
        FrsHeaderViewContainer frsHeaderViewContainer = this.f59267b;
        if (frsHeaderViewContainer != null) {
            frsHeaderViewContainer.removeCallbacks(this.r);
        }
    }

    public boolean K(int i2) {
        this.f59272g = i2;
        d.a.n0.r0.r2.b bVar = this.f59268c;
        if (bVar != null) {
            bVar.c(i2);
            return true;
        }
        return true;
    }

    public void L(boolean z) {
        d.a.n0.r0.r2.b bVar = this.f59268c;
        if (bVar != null) {
            bVar.s(z);
        }
    }

    public void N(MotionEvent motionEvent) {
        d.a.n0.g0.a aVar = this.l;
        if (aVar != null) {
            aVar.c(motionEvent);
        }
    }

    public void O(Integer num) {
        n0(num.intValue());
        if (z()) {
            T();
        }
    }

    public void P() {
        this.f59268c.w();
    }

    public void Q(ForumData forumData, FrsViewData frsViewData) {
        if (forumData == null || frsViewData == null) {
            return;
        }
        float w = w(forumData);
        d.a.n0.r0.r2.b bVar = this.f59268c;
        if (bVar == null) {
            return;
        }
        bVar.B(forumData, frsViewData);
        this.f59268c.E(forumData.isLike(), forumData.getLevelName(), forumData.getUser_level(), w, false);
        this.f59268c.G(forumData.getSignData());
    }

    public void R(FrsViewData frsViewData) {
        if (frsViewData != null && z()) {
            Q(frsViewData.getForum(), frsViewData);
            if ("brand_page".equals(this.f59273h)) {
                this.f59268c.b();
            }
        }
    }

    public void S(int i2) {
        if (z()) {
            f0(i2);
        }
    }

    public void T() {
        d.a.n0.r0.r2.b bVar = this.f59268c;
        if (bVar != null) {
            bVar.S();
        }
    }

    public void W() {
        FrsHeaderViewContainer frsHeaderViewContainer = this.f59267b;
        if (frsHeaderViewContainer != null) {
            frsHeaderViewContainer.removeCallbacks(this.r);
            this.f59267b.postDelayed(this.r, 100L);
        }
    }

    public void X(FrsViewData frsViewData) {
        if (frsViewData == null || this.f59268c == null || !z()) {
            return;
        }
        this.f59268c.u(w(frsViewData.getForum()));
    }

    public void Y() {
        d.a.n0.r0.r2.b bVar = this.f59268c;
        if (bVar != null) {
            bVar.x();
        }
    }

    public void Z(String str) {
        if (this.f59266a.b0() == null || this.f59266a.b0().P() == null) {
            return;
        }
        int x = this.f59266a.b0().P().x();
        int u = this.f59266a.b0().P().u();
        int t = this.f59266a.b0().P().t();
        d.a.n0.e3.e i2 = d.a.n0.e3.e.i();
        d.a.n0.e3.e.i().n(i2.g("1~" + str, x, u, t), false);
    }

    public final void a0() {
        d.a.n0.r0.r2.b bVar = this.f59268c;
        if (bVar != null) {
            this.f59267b.d(bVar.k());
            this.f59267b.d(this.f59268c.g());
            b0();
        }
        this.f59270e = false;
    }

    public final void b0() {
        FrsFragment frsFragment;
        if (this.m == null || (frsFragment = this.f59266a) == null || frsFragment.u2() == null) {
            return;
        }
        this.f59266a.u2().removeHeaderView(this.m.E());
    }

    public void d0(boolean z) {
        if (z) {
            d.a.n0.r0.r2.b bVar = this.f59268c;
            if (bVar != null) {
                this.f59267b.d(bVar.g());
                this.f59270e = false;
                return;
            }
            return;
        }
        d.a.n0.r0.r2.b bVar2 = this.f59268c;
        if (bVar2 == null || bVar2.g() == null || this.f59270e) {
            return;
        }
        this.f59267b.b(this.f59268c.g(), this.f59267b.getHeaderViewsCount());
        this.f59270e = true;
    }

    public void e0(int i2) {
        d.a.n0.r0.r2.b bVar = this.f59268c;
        if (bVar == null || bVar.g() == null) {
            return;
        }
        View findViewById = this.f59268c.g().findViewById(R.id.divider_bottom);
        if (findViewById != null) {
            findViewById.setVisibility(i2);
        }
        this.f59268c.m();
    }

    public void f0(int i2) {
        d.a.n0.r0.r2.b bVar = this.f59268c;
        if (bVar != null) {
            bVar.D(i2);
        }
    }

    public void g0(int i2, ForumData forumData, FrsViewData frsViewData, boolean z) {
        d.a.n0.r0.r2.b bVar = this.f59268c;
        if (bVar == null) {
            return;
        }
        bVar.B(forumData, frsViewData);
        if (forumData == null) {
            return;
        }
        this.f59268c.E(i2, forumData.getLevelName(), forumData.getUser_level(), w(forumData), z);
        if (forumData.getSignData() == null || forumData.getSignData().forum_rank != -2) {
            return;
        }
        this.f59268c.a(false);
    }

    public void h0(FrsViewData frsViewData, boolean z) {
        if (frsViewData != null && z()) {
            g0(1, frsViewData.getForum(), frsViewData, z);
        }
    }

    public void i0(int i2) {
        d.a.n0.r0.r2.b bVar;
        if (!z() || (bVar = this.f59268c) == null) {
            return;
        }
        bVar.F(i2);
    }

    public void j0(FrsViewData frsViewData) {
        g gVar;
        if (!z() || (gVar = this.n) == null) {
            return;
        }
        gVar.t(this.f59268c, frsViewData);
    }

    public void m0() {
        if (z()) {
            f0(0);
        }
    }

    public void n0(int i2) {
        d.a.n0.r0.r2.b bVar = this.f59268c;
        if (bVar != null) {
            bVar.J(i2);
        }
    }

    public void p0(int i2) {
        if (i2 > 1) {
            d.a.n0.r0.r2.b bVar = this.f59268c;
            if (bVar != null) {
                bVar.H(false);
                return;
            }
            return;
        }
        d.a.n0.r0.r2.b bVar2 = this.f59268c;
        if (bVar2 != null) {
            bVar2.H(true);
        }
    }

    public void q0(int i2) {
        this.f59274i = i2;
    }

    public void r() {
        d.a.n0.r0.r2.b bVar;
        if (this.f59270e || (bVar = this.f59268c) == null) {
            return;
        }
        this.f59267b.a(bVar.g());
        this.f59270e = true;
    }

    public final void s(String str, int i2, int i3) {
        boolean z = !TextUtils.equals(this.f59273h, str);
        this.k = i3;
        this.f59273h = str;
        a0();
        if (this.f59268c == null || z) {
            d.a.n0.r0.r2.b e2 = this.f59269d.e(str, this.f59266a, i2);
            this.f59268c = e2;
            e2.c(this.f59272g);
            this.f59268c.A(this.s);
        }
        g gVar = this.n;
        if (gVar != null) {
            this.f59268c.K(gVar);
        }
        f fVar = this.o;
        if (fVar != null) {
            this.f59268c.I(fVar);
        }
        this.f59267b.a(this.f59268c.k());
        t(str);
        y0();
        v0();
    }

    public final void t(String str) {
        FrsFragment frsFragment;
        RelativeLayout E;
        if (this.m == null || (frsFragment = this.f59266a) == null || frsFragment.u2() == null || (E = this.m.E()) == null) {
            return;
        }
        if ("brand_page".equals(str)) {
            this.f59266a.u2().removeHeaderView(E);
            return;
        }
        this.f59266a.u2().removeHeaderView(E);
        this.f59266a.u2().t(E, 0);
    }

    public void t0(FrsTabViewController frsTabViewController) {
        this.m = frsTabViewController;
    }

    public boolean u() {
        d.a.n0.r0.r2.b bVar;
        if (!z() || (bVar = this.f59268c) == null) {
            return false;
        }
        return bVar.l();
    }

    public void u0() {
        d.a.n0.r0.r2.b bVar = this.f59268c;
        if (bVar != null) {
            bVar.N();
        }
    }

    public boolean v() {
        d.a.n0.r0.r2.b bVar;
        if (!z() || (bVar = this.f59268c) == null) {
            return false;
        }
        return bVar.h();
    }

    public void v0() {
        d.a.c.e.m.e.a().postDelayed(this.q, 500L);
    }

    public final float w(ForumData forumData) {
        g gVar;
        if (forumData == null || (gVar = this.n) == null) {
            return 0.0f;
        }
        return gVar.k(forumData);
    }

    public void w0(String str, FrsViewData frsViewData) {
        if (frsViewData == null || frsViewData.getUserData() == null || frsViewData.getForum() == null) {
            return;
        }
        s(str, frsViewData.getUserData().getIsMem(), frsViewData.getForum().isLike());
    }

    public f x() {
        return this.o;
    }

    public final void x0() {
        d.a.n0.r0.r2.b bVar;
        if (!z() || (bVar = this.f59268c) == null) {
            return;
        }
        bVar.O();
    }

    public void y() {
        d.a.n0.r0.r2.b bVar = this.f59268c;
        if (bVar != null) {
            bVar.m();
        }
    }

    public final void y0() {
        d.a.c.e.m.e.a().postDelayed(this.p, PluginCenter.PLUGIN_RETRY_MIN_TIME_INTERVAL);
    }

    public final boolean z() {
        return "frs_page".equals(this.f59273h) || "normal_page".equals(this.f59273h) || "book_page".equals(this.f59273h) || "brand_page".equals(this.f59273h);
    }

    public void z0(boolean z) {
        f fVar = this.o;
        if (fVar != null) {
            fVar.r(z);
        }
    }
}
