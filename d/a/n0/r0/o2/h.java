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
    public FrsFragment f62957a;

    /* renamed from: b  reason: collision with root package name */
    public FrsHeaderViewContainer f62958b;

    /* renamed from: c  reason: collision with root package name */
    public d.a.n0.r0.r2.b f62959c;

    /* renamed from: d  reason: collision with root package name */
    public d.a.n0.r0.n1.e.a f62960d;

    /* renamed from: e  reason: collision with root package name */
    public boolean f62961e;

    /* renamed from: f  reason: collision with root package name */
    public BdUniqueId f62962f;

    /* renamed from: g  reason: collision with root package name */
    public int f62963g;

    /* renamed from: h  reason: collision with root package name */
    public String f62964h;

    /* renamed from: i  reason: collision with root package name */
    public int f62965i;
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
            r B0;
            if (h.this.f62957a != null && h.this.f62965i == 0 && (B0 = h.this.f62957a.B0()) != null && B0.W() != null && !B0.W().o() && !B0.Y() && h.this.f62958b.isShown() && h.this.f62957a.isPrimary() && !h.this.j && h.this.f62957a.f2() && h.this.k == 1 && h.this.z() && h.this.f62959c != null && h.this.f62959c.q()) {
                TbadkSettings.getInst().saveBoolean("speed_icon_show" + TbadkCoreApplication.getCurrentAccount(), true);
                h.this.x0();
                h.this.f62957a.f15082g = true;
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
            if (h.this.f62957a != null && h.this.f62965i == 0 && !h.this.f62957a.B0().Y() && h.this.f62958b.isShown() && h.this.f62957a.isPrimary()) {
                h.this.s0();
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
            if (h.this.f62958b != null) {
                int childCount = h.this.f62958b.getChildCount();
                for (int i2 = 0; i2 < childCount; i2++) {
                    a(h.this.f62958b.getChildAt(i2));
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
            if (h.this.f62957a == null) {
                return;
            }
            FrsViewData j0 = h.this.f62957a.j0();
            if (j0 != null && j0.getForum() != null && h.this.f62959c != null && (view == h.this.f62959c.e() || view == h.this.f62959c.f() || view == h.this.f62959c.i())) {
                if (h.this.f62957a != null && j0.getForum() != null) {
                    TiebaStatic.log(new StatisticItem("c12046").param("fid", j0.getForum().getId()).param("obj_locate", h.this.f62957a.N2() ? 1 : 2));
                }
                ArrayList<String> arrayList = new ArrayList<>();
                if (j0.getEntelechyTabInfo() != null && j0.getEntelechyTabInfo().tab != null) {
                    for (int i2 = 0; i2 < j0.getEntelechyTabInfo().tab.size(); i2++) {
                        arrayList.add(j0.getEntelechyTabInfo().tab.get(i2).tab_name);
                    }
                }
                ForumDetailActivityConfig forumDetailActivityConfig = new ForumDetailActivityConfig(h.this.getPageContext().getPageActivity(), j0.getForum().getId(), ForumDetailActivityConfig.FromType.FRS);
                forumDetailActivityConfig.setForumTabs(arrayList);
                MessageManager.getInstance().sendMessage(new CustomMessage(2002001, forumDetailActivityConfig));
            }
            int id = view.getId();
            if (id == R.id.tv_love) {
                if (h.this.f62957a.w2()) {
                    return;
                }
                if (!d.a.c.e.p.j.z()) {
                    h.this.f62957a.showToast(R.string.neterror);
                } else if (!ViewHelper.checkUpIsLogin(h.this.mContext.getPageActivity())) {
                    TiebaStatic.log(new StatisticItem("c10517").param("obj_locate", 1).param("fid", h.this.f62957a.i()));
                } else {
                    h.this.z0(true);
                    if (d.a.c.e.p.k.isEmpty(TbadkCoreApplication.getInst().getTaskId())) {
                        return;
                    }
                    StatisticItem statisticItem = new StatisticItem("c10048");
                    statisticItem.param("fid", h.this.f62957a.i());
                    statisticItem.param("obj_source", TbadkCoreApplication.getInst().getTaskId());
                    TiebaStatic.log(statisticItem);
                }
            } else if (id == R.id.tv_sign) {
                if (h.this.f62957a.w2()) {
                    return;
                }
                if (!d.a.c.e.p.j.z()) {
                    h.this.f62957a.showToast(R.string.neterror);
                } else if (ViewHelper.checkUpIsLogin(h.this.mContext.getPageActivity())) {
                    if (!h.this.v()) {
                        h.this.A0();
                        StatisticItem.make("c13560").param("obj_type", 2).eventStat();
                    } else if (TbadkCoreApplication.getInst().getUseNewResign() == 1) {
                        MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new SupplementSignActivityConfig(h.this.f62957a.getPageContext().getPageActivity(), d.a.c.e.m.b.d(h.this.f62957a.i(), 0), 24002)));
                    }
                }
            } else if (id == R.id.frs_header_games) {
                if (!ViewHelper.checkUpIsLogin(h.this.mContext.getPageActivity()) || j0 == null || j0.getGameUrl() == null) {
                    return;
                }
                UrlManager.getInstance().dealOneLink((TbPageContext) h.this.getPageContext(), new String[]{j0.getGameUrl()}, true);
            } else if (id == R.id.frs_bawu_center) {
                if (j0 == null || j0.getUserData() == null || !j0.getUserData().isBawu()) {
                    return;
                }
                String bawuCenterUrl = j0.getBawuCenterUrl();
                if (d.a.c.e.p.k.isEmpty(bawuCenterUrl)) {
                    return;
                }
                d.a.m0.l.a.l(h.this.getPageContext().getPageActivity(), bawuCenterUrl);
                if (j0.getForum() != null) {
                    TiebaStatic.log(new StatisticItem("c10502").param("fid", j0.getForum().getId()).param("uid", j0.getUserData().getUserId()));
                }
            } else if (id == R.id.level_container) {
                if (h.this.f62957a.w2() || h.this.f62965i != 0 || !h.this.z() || h.this.f62959c == null) {
                    return;
                }
                h.this.f62959c.M(view, false);
            } else if (id == R.id.frs_hot_rank_entry) {
                if (j0 == null || j0.getForum() == null || TextUtils.isEmpty(j0.getForum().getId())) {
                    return;
                }
                HotUserRankActivityConfig hotUserRankActivityConfig = new HotUserRankActivityConfig(h.this.getPageContext().getPageActivity());
                hotUserRankActivityConfig.setForumId(Long.valueOf(d.a.c.e.m.b.f(j0.getForum().getId(), 0L)));
                MessageManager.getInstance().sendMessage(new CustomMessage(2002001, hotUserRankActivityConfig));
                StatisticItem statisticItem2 = new StatisticItem("c13666");
                statisticItem2.param("fid", j0.getForum().getId());
                TiebaStatic.log(statisticItem2);
            } else if (id == R.id.frs_manager_info_layout) {
                if (j0 == null || j0.getForum() == null || TextUtils.isEmpty(j0.getForum().getId())) {
                    return;
                }
                MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new ForumMemberActivityConfig(h.this.getPageContext().getPageActivity(), String.valueOf(j0.getForum().getId()), j0.getForum().getName())));
            } else if (id == R.id.frs_manager_application_layout && ViewHelper.checkUpIsLogin(h.this.mContext.getPageActivity()) && j0 != null && j0.getForum() != null && !TextUtils.isEmpty(j0.getForum().getId())) {
                UrlManager urlManager = UrlManager.getInstance();
                TbPageContext<?> p = h.this.f62957a.p();
                urlManager.dealOneLink(p, new String[]{TbConfig.URL_FORUM_MANAGER_APPLY + j0.getForum().getId()});
            }
        }
    }

    public h(FrsFragment frsFragment, d.a.n0.r0.n1.e.a aVar, FrsHeaderViewContainer frsHeaderViewContainer) {
        super(frsFragment.getPageContext());
        this.f62961e = false;
        this.f62963g = 0;
        this.f62964h = "normal_page";
        this.f62965i = 0;
        this.j = false;
        this.p = new a();
        this.q = new b();
        this.r = new c();
        this.s = new d();
        this.f62957a = frsFragment;
        this.f62960d = aVar;
        this.f62958b = frsHeaderViewContainer;
        BdUniqueId gen = BdUniqueId.gen();
        this.f62962f = gen;
        this.n = new g(this.f62957a, gen);
        this.o = new f(this.f62957a);
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
            d.a.n0.r0.r2.b bVar = this.f62959c;
            if (bVar != null) {
                gVar.v(bVar.p(), this.f62959c.d());
            } else {
                gVar.v(false, "");
            }
            d.a.n0.r0.r2.b bVar2 = this.f62959c;
            if (bVar2 != null) {
                this.n.u(bVar2.j());
            }
        }
    }

    public boolean B() {
        d.a.n0.r0.r2.b bVar;
        if (!z() || (bVar = this.f62959c) == null) {
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
        d.a.n0.r0.r2.b bVar = this.f62959c;
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
        d.a.n0.r0.r2.b bVar = this.f62959c;
        if (bVar != null) {
            bVar.t();
        }
        FrsHeaderViewContainer frsHeaderViewContainer = this.f62958b;
        if (frsHeaderViewContainer != null) {
            frsHeaderViewContainer.removeCallbacks(this.r);
        }
    }

    public boolean K(int i2) {
        this.f62963g = i2;
        d.a.n0.r0.r2.b bVar = this.f62959c;
        if (bVar != null) {
            bVar.c(i2);
            return true;
        }
        return true;
    }

    public void L(boolean z) {
        d.a.n0.r0.r2.b bVar = this.f62959c;
        if (bVar != null) {
            bVar.s(z);
        }
    }

    public void M(MotionEvent motionEvent) {
        d.a.n0.g0.a aVar = this.l;
        if (aVar != null) {
            aVar.c(motionEvent);
        }
    }

    public void O(Integer num) {
        l0(num.intValue());
        if (z()) {
            T();
        }
    }

    public void P() {
        this.f62959c.w();
    }

    public void Q(ForumData forumData, FrsViewData frsViewData) {
        if (forumData == null || frsViewData == null) {
            return;
        }
        float w = w(forumData);
        d.a.n0.r0.r2.b bVar = this.f62959c;
        if (bVar == null) {
            return;
        }
        bVar.B(forumData, frsViewData);
        this.f62959c.E(forumData.isLike(), forumData.getLevelName(), forumData.getUser_level(), w, false);
        this.f62959c.G(forumData.getSignData());
    }

    public void R(FrsViewData frsViewData) {
        if (frsViewData != null && z()) {
            Q(frsViewData.getForum(), frsViewData);
            if ("brand_page".equals(this.f62964h)) {
                this.f62959c.b();
            }
        }
    }

    public void S(int i2) {
        if (z()) {
            e0(i2);
        }
    }

    public void T() {
        d.a.n0.r0.r2.b bVar = this.f62959c;
        if (bVar != null) {
            bVar.S();
        }
    }

    public void U() {
        FrsHeaderViewContainer frsHeaderViewContainer = this.f62958b;
        if (frsHeaderViewContainer != null) {
            frsHeaderViewContainer.removeCallbacks(this.r);
            this.f62958b.postDelayed(this.r, 100L);
        }
    }

    public void V(FrsViewData frsViewData) {
        if (frsViewData == null || this.f62959c == null || !z()) {
            return;
        }
        this.f62959c.u(w(frsViewData.getForum()));
    }

    public void Y() {
        d.a.n0.r0.r2.b bVar = this.f62959c;
        if (bVar != null) {
            bVar.x();
        }
    }

    public void Z(String str) {
        if (this.f62957a.e0() == null || this.f62957a.e0().T() == null) {
            return;
        }
        int B = this.f62957a.e0().T().B();
        int y = this.f62957a.e0().T().y();
        int x = this.f62957a.e0().T().x();
        d.a.n0.e3.e i2 = d.a.n0.e3.e.i();
        d.a.n0.e3.e.i().n(i2.g("1~" + str, B, y, x), false);
    }

    public final void a0() {
        d.a.n0.r0.r2.b bVar = this.f62959c;
        if (bVar != null) {
            this.f62958b.d(bVar.k());
            this.f62958b.d(this.f62959c.g());
            b0();
        }
        this.f62961e = false;
    }

    public final void b0() {
        FrsFragment frsFragment;
        if (this.m == null || (frsFragment = this.f62957a) == null || frsFragment.x2() == null) {
            return;
        }
        this.f62957a.x2().removeHeaderView(this.m.E());
    }

    public void c0(boolean z) {
        if (z) {
            d.a.n0.r0.r2.b bVar = this.f62959c;
            if (bVar != null) {
                this.f62958b.d(bVar.g());
                this.f62961e = false;
                return;
            }
            return;
        }
        d.a.n0.r0.r2.b bVar2 = this.f62959c;
        if (bVar2 == null || bVar2.g() == null || this.f62961e) {
            return;
        }
        this.f62958b.b(this.f62959c.g(), this.f62958b.getHeaderViewsCount());
        this.f62961e = true;
    }

    public void d0(int i2) {
        d.a.n0.r0.r2.b bVar = this.f62959c;
        if (bVar == null || bVar.g() == null) {
            return;
        }
        View findViewById = this.f62959c.g().findViewById(R.id.divider_bottom);
        if (findViewById != null) {
            findViewById.setVisibility(i2);
        }
        this.f62959c.m();
    }

    public void e0(int i2) {
        d.a.n0.r0.r2.b bVar = this.f62959c;
        if (bVar != null) {
            bVar.D(i2);
        }
    }

    public void g0(int i2, ForumData forumData, FrsViewData frsViewData, boolean z) {
        d.a.n0.r0.r2.b bVar = this.f62959c;
        if (bVar == null) {
            return;
        }
        bVar.B(forumData, frsViewData);
        if (forumData == null) {
            return;
        }
        this.f62959c.E(i2, forumData.getLevelName(), forumData.getUser_level(), w(forumData), z);
        if (forumData.getSignData() == null || forumData.getSignData().forum_rank != -2) {
            return;
        }
        this.f62959c.a(false);
    }

    public void h0(FrsViewData frsViewData, boolean z) {
        if (frsViewData != null && z()) {
            g0(1, frsViewData.getForum(), frsViewData, z);
        }
    }

    public void i0(int i2) {
        d.a.n0.r0.r2.b bVar;
        if (!z() || (bVar = this.f62959c) == null) {
            return;
        }
        bVar.F(i2);
    }

    public void j0(FrsViewData frsViewData) {
        g gVar;
        if (!z() || (gVar = this.n) == null) {
            return;
        }
        gVar.t(this.f62959c, frsViewData);
    }

    public void k0() {
        if (z()) {
            e0(0);
        }
    }

    public void l0(int i2) {
        d.a.n0.r0.r2.b bVar = this.f62959c;
        if (bVar != null) {
            bVar.J(i2);
        }
    }

    public void m0(int i2) {
        if (i2 > 1) {
            d.a.n0.r0.r2.b bVar = this.f62959c;
            if (bVar != null) {
                bVar.H(false);
                return;
            }
            return;
        }
        d.a.n0.r0.r2.b bVar2 = this.f62959c;
        if (bVar2 != null) {
            bVar2.H(true);
        }
    }

    public void p0(int i2) {
        this.f62965i = i2;
    }

    public void q0(FrsTabViewController frsTabViewController) {
        this.m = frsTabViewController;
    }

    public void r() {
        d.a.n0.r0.r2.b bVar;
        if (this.f62961e || (bVar = this.f62959c) == null) {
            return;
        }
        this.f62958b.a(bVar.g());
        this.f62961e = true;
    }

    public final void s(String str, int i2, int i3) {
        boolean z = !TextUtils.equals(this.f62964h, str);
        this.k = i3;
        this.f62964h = str;
        a0();
        if (this.f62959c == null || z) {
            d.a.n0.r0.r2.b e2 = this.f62960d.e(str, this.f62957a, i2);
            this.f62959c = e2;
            e2.c(this.f62963g);
            this.f62959c.A(this.s);
        }
        g gVar = this.n;
        if (gVar != null) {
            this.f62959c.K(gVar);
        }
        f fVar = this.o;
        if (fVar != null) {
            this.f62959c.I(fVar);
        }
        this.f62958b.a(this.f62959c.k());
        t(str);
        y0();
        t0();
    }

    public void s0() {
        d.a.n0.r0.r2.b bVar = this.f62959c;
        if (bVar != null) {
            bVar.N();
        }
    }

    public final void t(String str) {
        FrsFragment frsFragment;
        RelativeLayout E;
        if (this.m == null || (frsFragment = this.f62957a) == null || frsFragment.x2() == null || (E = this.m.E()) == null) {
            return;
        }
        if ("brand_page".equals(str)) {
            this.f62957a.x2().removeHeaderView(E);
            return;
        }
        this.f62957a.x2().removeHeaderView(E);
        this.f62957a.x2().t(E, 0);
    }

    public void t0() {
        d.a.c.e.m.e.a().postDelayed(this.q, 500L);
    }

    public boolean u() {
        d.a.n0.r0.r2.b bVar;
        if (!z() || (bVar = this.f62959c) == null) {
            return false;
        }
        return bVar.l();
    }

    public boolean v() {
        d.a.n0.r0.r2.b bVar;
        if (!z() || (bVar = this.f62959c) == null) {
            return false;
        }
        return bVar.h();
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
        if (!z() || (bVar = this.f62959c) == null) {
            return;
        }
        bVar.O();
    }

    public void y() {
        d.a.n0.r0.r2.b bVar = this.f62959c;
        if (bVar != null) {
            bVar.m();
        }
    }

    public final void y0() {
        d.a.c.e.m.e.a().postDelayed(this.p, PluginCenter.PLUGIN_RETRY_MIN_TIME_INTERVAL);
    }

    public final boolean z() {
        return "frs_page".equals(this.f62964h) || "normal_page".equals(this.f62964h) || "book_page".equals(this.f62964h) || "brand_page".equals(this.f62964h);
    }

    public void z0(boolean z) {
        f fVar = this.o;
        if (fVar != null) {
            fVar.r(z);
        }
    }
}
