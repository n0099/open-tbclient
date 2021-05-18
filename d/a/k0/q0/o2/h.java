package d.a.k0.q0.o2;

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
import d.a.k0.q0.r;
import java.util.ArrayList;
/* loaded from: classes4.dex */
public class h extends d.a.c.a.d<BaseFragmentActivity> {

    /* renamed from: a  reason: collision with root package name */
    public FrsFragment f59125a;

    /* renamed from: b  reason: collision with root package name */
    public FrsHeaderViewContainer f59126b;

    /* renamed from: c  reason: collision with root package name */
    public d.a.k0.q0.r2.b f59127c;

    /* renamed from: d  reason: collision with root package name */
    public d.a.k0.q0.n1.e.a f59128d;

    /* renamed from: e  reason: collision with root package name */
    public boolean f59129e;

    /* renamed from: f  reason: collision with root package name */
    public BdUniqueId f59130f;

    /* renamed from: g  reason: collision with root package name */
    public int f59131g;

    /* renamed from: h  reason: collision with root package name */
    public String f59132h;

    /* renamed from: i  reason: collision with root package name */
    public int f59133i;
    public boolean j;
    public int k;
    public d.a.k0.f0.a l;
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
            if (h.this.f59125a != null && h.this.f59133i == 0 && (y0 = h.this.f59125a.y0()) != null && y0.W() != null && !y0.W().o() && !y0.Y() && h.this.f59126b.isShown() && h.this.f59125a.isPrimary() && !h.this.j && h.this.f59125a.c2() && h.this.k == 1 && h.this.z() && h.this.f59127c != null && h.this.f59127c.q()) {
                TbadkSettings.getInst().saveBoolean("speed_icon_show" + TbadkCoreApplication.getCurrentAccount(), true);
                h.this.x0();
                h.this.f59125a.f15122g = true;
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
            if (h.this.f59125a != null && h.this.f59133i == 0 && !h.this.f59125a.y0().Y() && h.this.f59126b.isShown() && h.this.f59125a.isPrimary()) {
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
            if (h.this.f59126b != null) {
                int childCount = h.this.f59126b.getChildCount();
                for (int i2 = 0; i2 < childCount; i2++) {
                    a(h.this.f59126b.getChildAt(i2));
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
            if (h.this.f59125a == null) {
                return;
            }
            FrsViewData g0 = h.this.f59125a.g0();
            if (g0 != null && g0.getForum() != null && h.this.f59127c != null && (view == h.this.f59127c.e() || view == h.this.f59127c.f() || view == h.this.f59127c.i())) {
                if (h.this.f59125a != null && g0.getForum() != null) {
                    TiebaStatic.log(new StatisticItem("c12046").param("fid", g0.getForum().getId()).param("obj_locate", h.this.f59125a.K2() ? 1 : 2));
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
                if (h.this.f59125a.t2()) {
                    return;
                }
                if (!d.a.c.e.p.j.z()) {
                    h.this.f59125a.showToast(R.string.neterror);
                } else if (!ViewHelper.checkUpIsLogin(h.this.mContext.getPageActivity())) {
                    TiebaStatic.log(new StatisticItem("c10517").param("obj_locate", 1).param("fid", h.this.f59125a.h()));
                } else {
                    h.this.z0(true);
                    if (d.a.c.e.p.k.isEmpty(TbadkCoreApplication.getInst().getTaskId())) {
                        return;
                    }
                    StatisticItem statisticItem = new StatisticItem("c10048");
                    statisticItem.param("fid", h.this.f59125a.h());
                    statisticItem.param("obj_source", TbadkCoreApplication.getInst().getTaskId());
                    TiebaStatic.log(statisticItem);
                }
            } else if (id == R.id.tv_sign) {
                if (h.this.f59125a.t2()) {
                    return;
                }
                if (!d.a.c.e.p.j.z()) {
                    h.this.f59125a.showToast(R.string.neterror);
                } else if (ViewHelper.checkUpIsLogin(h.this.mContext.getPageActivity())) {
                    if (!h.this.v()) {
                        h.this.A0();
                        StatisticItem.make("c13560").param("obj_type", 2).eventStat();
                    } else if (TbadkCoreApplication.getInst().getUseNewResign() == 1) {
                        MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new SupplementSignActivityConfig(h.this.f59125a.getPageContext().getPageActivity(), d.a.c.e.m.b.d(h.this.f59125a.h(), 0), 24002)));
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
                d.a.j0.l.a.l(h.this.getPageContext().getPageActivity(), bawuCenterUrl);
                if (g0.getForum() != null) {
                    TiebaStatic.log(new StatisticItem("c10502").param("fid", g0.getForum().getId()).param("uid", g0.getUserData().getUserId()));
                }
            } else if (id == R.id.level_container) {
                if (h.this.f59125a.t2() || h.this.f59133i != 0 || !h.this.z() || h.this.f59127c == null) {
                    return;
                }
                h.this.f59127c.M(view, false);
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
                TbPageContext<?> o = h.this.f59125a.o();
                urlManager.dealOneLink(o, new String[]{TbConfig.URL_FORUM_MANAGER_APPLY + g0.getForum().getId()});
            }
        }
    }

    public h(FrsFragment frsFragment, d.a.k0.q0.n1.e.a aVar, FrsHeaderViewContainer frsHeaderViewContainer) {
        super(frsFragment.getPageContext());
        this.f59129e = false;
        this.f59131g = 0;
        this.f59132h = "normal_page";
        this.f59133i = 0;
        this.j = false;
        this.p = new a();
        this.q = new b();
        this.r = new c();
        this.s = new d();
        this.f59125a = frsFragment;
        this.f59128d = aVar;
        this.f59126b = frsHeaderViewContainer;
        BdUniqueId gen = BdUniqueId.gen();
        this.f59130f = gen;
        this.n = new g(this.f59125a, gen);
        this.o = new f(this.f59125a);
        this.l = new d.a.k0.f0.a();
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
            d.a.k0.q0.r2.b bVar = this.f59127c;
            if (bVar != null) {
                gVar.v(bVar.p(), this.f59127c.d());
            } else {
                gVar.v(false, "");
            }
            d.a.k0.q0.r2.b bVar2 = this.f59127c;
            if (bVar2 != null) {
                this.n.u(bVar2.j());
            }
        }
    }

    public boolean B() {
        d.a.k0.q0.r2.b bVar;
        if (!z() || (bVar = this.f59127c) == null) {
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
        d.a.k0.q0.r2.b bVar = this.f59127c;
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
        d.a.k0.q0.r2.b bVar = this.f59127c;
        if (bVar != null) {
            bVar.t();
        }
        FrsHeaderViewContainer frsHeaderViewContainer = this.f59126b;
        if (frsHeaderViewContainer != null) {
            frsHeaderViewContainer.removeCallbacks(this.r);
        }
    }

    public boolean K(int i2) {
        this.f59131g = i2;
        d.a.k0.q0.r2.b bVar = this.f59127c;
        if (bVar != null) {
            bVar.c(i2);
            return true;
        }
        return true;
    }

    public void L(boolean z) {
        d.a.k0.q0.r2.b bVar = this.f59127c;
        if (bVar != null) {
            bVar.s(z);
        }
    }

    public void N(MotionEvent motionEvent) {
        d.a.k0.f0.a aVar = this.l;
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
        this.f59127c.w();
    }

    public void Q(ForumData forumData, FrsViewData frsViewData) {
        if (forumData == null || frsViewData == null) {
            return;
        }
        float w = w(forumData);
        d.a.k0.q0.r2.b bVar = this.f59127c;
        if (bVar == null) {
            return;
        }
        bVar.B(forumData, frsViewData);
        this.f59127c.E(forumData.isLike(), forumData.getLevelName(), forumData.getUser_level(), w, false);
        this.f59127c.G(forumData.getSignData());
    }

    public void R(FrsViewData frsViewData) {
        if (frsViewData != null && z()) {
            Q(frsViewData.getForum(), frsViewData);
            if ("brand_page".equals(this.f59132h)) {
                this.f59127c.b();
            }
        }
    }

    public void S(int i2) {
        if (z()) {
            f0(i2);
        }
    }

    public void T() {
        d.a.k0.q0.r2.b bVar = this.f59127c;
        if (bVar != null) {
            bVar.S();
        }
    }

    public void W() {
        FrsHeaderViewContainer frsHeaderViewContainer = this.f59126b;
        if (frsHeaderViewContainer != null) {
            frsHeaderViewContainer.removeCallbacks(this.r);
            this.f59126b.postDelayed(this.r, 100L);
        }
    }

    public void X(FrsViewData frsViewData) {
        if (frsViewData == null || this.f59127c == null || !z()) {
            return;
        }
        this.f59127c.u(w(frsViewData.getForum()));
    }

    public void Y() {
        d.a.k0.q0.r2.b bVar = this.f59127c;
        if (bVar != null) {
            bVar.x();
        }
    }

    public void Z(String str) {
        if (this.f59125a.b0() == null || this.f59125a.b0().P() == null) {
            return;
        }
        int x = this.f59125a.b0().P().x();
        int u = this.f59125a.b0().P().u();
        int t = this.f59125a.b0().P().t();
        d.a.k0.d3.e i2 = d.a.k0.d3.e.i();
        d.a.k0.d3.e.i().n(i2.g("1~" + str, x, u, t), false);
    }

    public final void a0() {
        d.a.k0.q0.r2.b bVar = this.f59127c;
        if (bVar != null) {
            this.f59126b.d(bVar.k());
            this.f59126b.d(this.f59127c.g());
            b0();
        }
        this.f59129e = false;
    }

    public final void b0() {
        FrsFragment frsFragment;
        if (this.m == null || (frsFragment = this.f59125a) == null || frsFragment.u2() == null) {
            return;
        }
        this.f59125a.u2().removeHeaderView(this.m.E());
    }

    public void d0(boolean z) {
        if (z) {
            d.a.k0.q0.r2.b bVar = this.f59127c;
            if (bVar != null) {
                this.f59126b.d(bVar.g());
                this.f59129e = false;
                return;
            }
            return;
        }
        d.a.k0.q0.r2.b bVar2 = this.f59127c;
        if (bVar2 == null || bVar2.g() == null || this.f59129e) {
            return;
        }
        this.f59126b.b(this.f59127c.g(), this.f59126b.getHeaderViewsCount());
        this.f59129e = true;
    }

    public void e0(int i2) {
        d.a.k0.q0.r2.b bVar = this.f59127c;
        if (bVar == null || bVar.g() == null) {
            return;
        }
        View findViewById = this.f59127c.g().findViewById(R.id.divider_bottom);
        if (findViewById != null) {
            findViewById.setVisibility(i2);
        }
        this.f59127c.m();
    }

    public void f0(int i2) {
        d.a.k0.q0.r2.b bVar = this.f59127c;
        if (bVar != null) {
            bVar.D(i2);
        }
    }

    public void g0(int i2, ForumData forumData, FrsViewData frsViewData, boolean z) {
        d.a.k0.q0.r2.b bVar = this.f59127c;
        if (bVar == null) {
            return;
        }
        bVar.B(forumData, frsViewData);
        if (forumData == null) {
            return;
        }
        this.f59127c.E(i2, forumData.getLevelName(), forumData.getUser_level(), w(forumData), z);
        if (forumData.getSignData() == null || forumData.getSignData().forum_rank != -2) {
            return;
        }
        this.f59127c.a(false);
    }

    public void h0(FrsViewData frsViewData, boolean z) {
        if (frsViewData != null && z()) {
            g0(1, frsViewData.getForum(), frsViewData, z);
        }
    }

    public void i0(int i2) {
        d.a.k0.q0.r2.b bVar;
        if (!z() || (bVar = this.f59127c) == null) {
            return;
        }
        bVar.F(i2);
    }

    public void j0(FrsViewData frsViewData) {
        g gVar;
        if (!z() || (gVar = this.n) == null) {
            return;
        }
        gVar.t(this.f59127c, frsViewData);
    }

    public void m0() {
        if (z()) {
            f0(0);
        }
    }

    public void n0(int i2) {
        d.a.k0.q0.r2.b bVar = this.f59127c;
        if (bVar != null) {
            bVar.J(i2);
        }
    }

    public void p0(int i2) {
        if (i2 > 1) {
            d.a.k0.q0.r2.b bVar = this.f59127c;
            if (bVar != null) {
                bVar.H(false);
                return;
            }
            return;
        }
        d.a.k0.q0.r2.b bVar2 = this.f59127c;
        if (bVar2 != null) {
            bVar2.H(true);
        }
    }

    public void q0(int i2) {
        this.f59133i = i2;
    }

    public void r() {
        d.a.k0.q0.r2.b bVar;
        if (this.f59129e || (bVar = this.f59127c) == null) {
            return;
        }
        this.f59126b.a(bVar.g());
        this.f59129e = true;
    }

    public final void s(String str, int i2, int i3) {
        boolean z = !TextUtils.equals(this.f59132h, str);
        this.k = i3;
        this.f59132h = str;
        a0();
        if (this.f59127c == null || z) {
            d.a.k0.q0.r2.b e2 = this.f59128d.e(str, this.f59125a, i2);
            this.f59127c = e2;
            e2.c(this.f59131g);
            this.f59127c.A(this.s);
        }
        g gVar = this.n;
        if (gVar != null) {
            this.f59127c.K(gVar);
        }
        f fVar = this.o;
        if (fVar != null) {
            this.f59127c.I(fVar);
        }
        this.f59126b.a(this.f59127c.k());
        t(str);
        y0();
        v0();
    }

    public final void t(String str) {
        FrsFragment frsFragment;
        RelativeLayout E;
        if (this.m == null || (frsFragment = this.f59125a) == null || frsFragment.u2() == null || (E = this.m.E()) == null) {
            return;
        }
        if ("brand_page".equals(str)) {
            this.f59125a.u2().removeHeaderView(E);
            return;
        }
        this.f59125a.u2().removeHeaderView(E);
        this.f59125a.u2().t(E, 0);
    }

    public void t0(FrsTabViewController frsTabViewController) {
        this.m = frsTabViewController;
    }

    public boolean u() {
        d.a.k0.q0.r2.b bVar;
        if (!z() || (bVar = this.f59127c) == null) {
            return false;
        }
        return bVar.l();
    }

    public void u0() {
        d.a.k0.q0.r2.b bVar = this.f59127c;
        if (bVar != null) {
            bVar.N();
        }
    }

    public boolean v() {
        d.a.k0.q0.r2.b bVar;
        if (!z() || (bVar = this.f59127c) == null) {
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
        d.a.k0.q0.r2.b bVar;
        if (!z() || (bVar = this.f59127c) == null) {
            return;
        }
        bVar.O();
    }

    public void y() {
        d.a.k0.q0.r2.b bVar = this.f59127c;
        if (bVar != null) {
            bVar.m();
        }
    }

    public final void y0() {
        d.a.c.e.m.e.a().postDelayed(this.p, PluginCenter.PLUGIN_RETRY_MIN_TIME_INTERVAL);
    }

    public final boolean z() {
        return "frs_page".equals(this.f59132h) || "normal_page".equals(this.f59132h) || "book_page".equals(this.f59132h) || "brand_page".equals(this.f59132h);
    }

    public void z0(boolean z) {
        f fVar = this.o;
        if (fVar != null) {
            fVar.r(z);
        }
    }
}
