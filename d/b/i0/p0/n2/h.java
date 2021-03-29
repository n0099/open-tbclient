package d.b.i0.p0.n2;

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
import d.b.i0.p0.r;
import java.util.ArrayList;
/* loaded from: classes4.dex */
public class h extends d.b.b.a.d<BaseFragmentActivity> {

    /* renamed from: a  reason: collision with root package name */
    public FrsFragment f58177a;

    /* renamed from: b  reason: collision with root package name */
    public FrsHeaderViewContainer f58178b;

    /* renamed from: c  reason: collision with root package name */
    public d.b.i0.p0.q2.b f58179c;

    /* renamed from: d  reason: collision with root package name */
    public d.b.i0.p0.n1.e.a f58180d;

    /* renamed from: e  reason: collision with root package name */
    public boolean f58181e;

    /* renamed from: f  reason: collision with root package name */
    public BdUniqueId f58182f;

    /* renamed from: g  reason: collision with root package name */
    public int f58183g;

    /* renamed from: h  reason: collision with root package name */
    public String f58184h;
    public int i;
    public boolean j;
    public int k;
    public d.b.i0.f0.a l;
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
            r x0;
            if (h.this.f58177a != null && h.this.i == 0 && (x0 = h.this.f58177a.x0()) != null && x0.W() != null && !x0.W().o() && !x0.Y() && h.this.f58178b.isShown() && h.this.f58177a.isPrimary() && !h.this.j && h.this.f58177a.d2() && h.this.k == 1 && h.this.B() && h.this.f58179c != null && h.this.f58179c.q()) {
                TbadkSettings.getInst().saveBoolean("speed_icon_show" + TbadkCoreApplication.getCurrentAccount(), true);
                h.this.x0();
                h.this.f58177a.f15973g = true;
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
            if (h.this.f58177a != null && h.this.i == 0 && !h.this.f58177a.x0().Y() && h.this.f58178b.isShown() && h.this.f58177a.isPrimary()) {
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
            if (view instanceof d.b.b.f.a.i) {
                ((d.b.b.f.a.i) view).refresh();
            }
            if (view instanceof ViewGroup) {
                ViewGroup viewGroup = (ViewGroup) view;
                int childCount = viewGroup.getChildCount();
                for (int i = 0; i < childCount; i++) {
                    a(viewGroup.getChildAt(i));
                }
            }
        }

        @Override // java.lang.Runnable
        public void run() {
            if (h.this.f58178b != null) {
                int childCount = h.this.f58178b.getChildCount();
                for (int i = 0; i < childCount; i++) {
                    a(h.this.f58178b.getChildAt(i));
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
            if (h.this.f58177a == null) {
                return;
            }
            FrsViewData S = h.this.f58177a.S();
            if (S != null && S.getForum() != null && h.this.f58179c != null && (view == h.this.f58179c.e() || view == h.this.f58179c.f() || view == h.this.f58179c.i())) {
                if (h.this.f58177a != null && S.getForum() != null) {
                    TiebaStatic.log(new StatisticItem("c12046").param("fid", S.getForum().getId()).param("obj_locate", h.this.f58177a.L2() ? 1 : 2));
                }
                ArrayList<String> arrayList = new ArrayList<>();
                if (S.getEntelechyTabInfo() != null && S.getEntelechyTabInfo().tab != null) {
                    for (int i = 0; i < S.getEntelechyTabInfo().tab.size(); i++) {
                        arrayList.add(S.getEntelechyTabInfo().tab.get(i).tab_name);
                    }
                }
                ForumDetailActivityConfig forumDetailActivityConfig = new ForumDetailActivityConfig(h.this.getPageContext().getPageActivity(), S.getForum().getId(), ForumDetailActivityConfig.FromType.FRS);
                forumDetailActivityConfig.setForumTabs(arrayList);
                MessageManager.getInstance().sendMessage(new CustomMessage(2002001, forumDetailActivityConfig));
            }
            int id = view.getId();
            if (id == R.id.tv_love) {
                if (h.this.f58177a.u2()) {
                    return;
                }
                if (!d.b.b.e.p.j.z()) {
                    h.this.f58177a.showToast(R.string.neterror);
                } else if (!ViewHelper.checkUpIsLogin(h.this.mContext.getPageActivity())) {
                    TiebaStatic.log(new StatisticItem("c10517").param("obj_locate", 1).param("fid", h.this.f58177a.h()));
                } else {
                    h.this.z0(true);
                    if (d.b.b.e.p.k.isEmpty(TbadkCoreApplication.getInst().getTaskId())) {
                        return;
                    }
                    StatisticItem statisticItem = new StatisticItem("c10048");
                    statisticItem.param("fid", h.this.f58177a.h());
                    statisticItem.param("obj_source", TbadkCoreApplication.getInst().getTaskId());
                    TiebaStatic.log(statisticItem);
                }
            } else if (id == R.id.tv_sign) {
                if (h.this.f58177a.u2()) {
                    return;
                }
                if (!d.b.b.e.p.j.z()) {
                    h.this.f58177a.showToast(R.string.neterror);
                } else if (ViewHelper.checkUpIsLogin(h.this.mContext.getPageActivity())) {
                    if (!h.this.x()) {
                        h.this.A0();
                        StatisticItem.make("c13560").param("obj_type", 2).eventStat();
                    } else if (TbadkCoreApplication.getInst().getUseNewResign() == 1) {
                        MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new SupplementSignActivityConfig(h.this.f58177a.getPageContext().getPageActivity(), d.b.b.e.m.b.d(h.this.f58177a.h(), 0), 24002)));
                    }
                }
            } else if (id == R.id.frs_header_games) {
                if (!ViewHelper.checkUpIsLogin(h.this.mContext.getPageActivity()) || S == null || S.getGameUrl() == null) {
                    return;
                }
                UrlManager.getInstance().dealOneLink((TbPageContext) h.this.getPageContext(), new String[]{S.getGameUrl()}, true);
            } else if (id == R.id.frs_bawu_center) {
                if (S == null || S.getUserData() == null || !S.getUserData().isBawu()) {
                    return;
                }
                String bawuCenterUrl = S.getBawuCenterUrl();
                if (d.b.b.e.p.k.isEmpty(bawuCenterUrl)) {
                    return;
                }
                d.b.h0.l.a.l(h.this.getPageContext().getPageActivity(), bawuCenterUrl);
                if (S.getForum() != null) {
                    TiebaStatic.log(new StatisticItem("c10502").param("fid", S.getForum().getId()).param("uid", S.getUserData().getUserId()));
                }
            } else if (id == R.id.level_container) {
                if (h.this.f58177a.u2() || h.this.i != 0 || !h.this.B() || h.this.f58179c == null) {
                    return;
                }
                h.this.f58179c.M(view, false);
            } else if (id == R.id.frs_hot_rank_entry) {
                if (S == null || S.getForum() == null || TextUtils.isEmpty(S.getForum().getId())) {
                    return;
                }
                HotUserRankActivityConfig hotUserRankActivityConfig = new HotUserRankActivityConfig(h.this.getPageContext().getPageActivity());
                hotUserRankActivityConfig.setForumId(Long.valueOf(d.b.b.e.m.b.f(S.getForum().getId(), 0L)));
                MessageManager.getInstance().sendMessage(new CustomMessage(2002001, hotUserRankActivityConfig));
                StatisticItem statisticItem2 = new StatisticItem("c13666");
                statisticItem2.param("fid", S.getForum().getId());
                TiebaStatic.log(statisticItem2);
            } else if (id == R.id.frs_manager_info_layout) {
                if (S == null || S.getForum() == null || TextUtils.isEmpty(S.getForum().getId())) {
                    return;
                }
                MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new ForumMemberActivityConfig(h.this.getPageContext().getPageActivity(), String.valueOf(S.getForum().getId()), S.getForum().getName())));
            } else if (id == R.id.frs_manager_application_layout && ViewHelper.checkUpIsLogin(h.this.mContext.getPageActivity()) && S != null && S.getForum() != null && !TextUtils.isEmpty(S.getForum().getId())) {
                UrlManager urlManager = UrlManager.getInstance();
                TbPageContext<?> q = h.this.f58177a.q();
                urlManager.dealOneLink(q, new String[]{TbConfig.URL_FORUM_MANAGER_APPLY + S.getForum().getId()});
            }
        }
    }

    public h(FrsFragment frsFragment, d.b.i0.p0.n1.e.a aVar, FrsHeaderViewContainer frsHeaderViewContainer) {
        super(frsFragment.getPageContext());
        this.f58181e = false;
        this.f58183g = 0;
        this.f58184h = "normal_page";
        this.i = 0;
        this.j = false;
        this.p = new a();
        this.q = new b();
        this.r = new c();
        this.s = new d();
        this.f58177a = frsFragment;
        this.f58180d = aVar;
        this.f58178b = frsHeaderViewContainer;
        BdUniqueId gen = BdUniqueId.gen();
        this.f58182f = gen;
        this.n = new g(this.f58177a, gen);
        this.o = new f(this.f58177a);
        this.l = new d.b.i0.f0.a();
    }

    public static boolean G(FrsViewData frsViewData) {
        return (frsViewData == null || frsViewData.getBookInfo() == null || StringUtils.isNull(frsViewData.getBookInfo().a(), true) || frsViewData.getBookInfo().a().equals("0")) ? false : true;
    }

    public static boolean I(FrsViewData frsViewData) {
        if (frsViewData != null) {
            return ((frsViewData.getStar() == null || frsViewData.getStar().b() != 1) && frsViewData.getHeadSdkData() == null && (frsViewData.getActivityHeadData() == null || ListUtils.isEmpty(frsViewData.getActivityHeadData().a())) && ((frsViewData.getForum() == null || frsViewData.getForum().getFrsBannerData() == null || frsViewData.getForum().getFrsBannerData().d() != 2) && (frsViewData.getHeadlineImgInfoData() == null || StringUtils.isNull(frsViewData.getHeadlineImgInfoData().a(), true)))) ? false : true;
        }
        return false;
    }

    public void A() {
        d.b.i0.p0.q2.b bVar = this.f58179c;
        if (bVar != null) {
            bVar.m();
        }
    }

    public void A0() {
        g gVar = this.n;
        if (gVar != null) {
            d.b.i0.p0.q2.b bVar = this.f58179c;
            if (bVar != null) {
                gVar.v(bVar.p(), this.f58179c.d());
            } else {
                gVar.v(false, "");
            }
            d.b.i0.p0.q2.b bVar2 = this.f58179c;
            if (bVar2 != null) {
                this.n.u(bVar2.j());
            }
        }
    }

    public final boolean B() {
        return "frs_page".equals(this.f58184h) || "normal_page".equals(this.f58184h) || "book_page".equals(this.f58184h) || "brand_page".equals(this.f58184h);
    }

    public void B0() {
        f fVar = this.o;
        if (fVar != null) {
            fVar.s();
        }
    }

    public void C0(int i, int i2, int i3) {
        g gVar = this.n;
        if (gVar != null) {
            gVar.w(i, i2, i3);
        }
    }

    public boolean E() {
        return true;
    }

    public boolean F() {
        d.b.i0.p0.q2.b bVar;
        if (!B() || (bVar = this.f58179c) == null) {
            return false;
        }
        return bVar.o();
    }

    public void J(Bundle bundle) {
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

    public void K() {
        d.b.i0.p0.q2.b bVar = this.f58179c;
        if (bVar != null) {
            bVar.r();
        }
        f fVar = this.o;
        if (fVar != null) {
            fVar.n();
        }
        if (this.p != null) {
            d.b.b.e.m.e.a().removeCallbacks(this.p);
        }
        if (this.q != null) {
            d.b.b.e.m.e.a().removeCallbacks(this.q);
        }
    }

    public void L() {
        d.b.i0.p0.q2.b bVar = this.f58179c;
        if (bVar != null) {
            bVar.t();
        }
        FrsHeaderViewContainer frsHeaderViewContainer = this.f58178b;
        if (frsHeaderViewContainer != null) {
            frsHeaderViewContainer.removeCallbacks(this.r);
        }
    }

    public boolean M(int i) {
        this.f58183g = i;
        d.b.i0.p0.q2.b bVar = this.f58179c;
        if (bVar != null) {
            bVar.c(i);
            return true;
        }
        return true;
    }

    public void O(boolean z) {
        d.b.i0.p0.q2.b bVar = this.f58179c;
        if (bVar != null) {
            bVar.s(z);
        }
    }

    public void P(MotionEvent motionEvent) {
        d.b.i0.f0.a aVar = this.l;
        if (aVar != null) {
            aVar.c(motionEvent);
        }
    }

    public void Q(Integer num) {
        p0(num.intValue());
        if (B()) {
            V();
        }
    }

    public void R() {
        this.f58179c.w();
    }

    public void S(ForumData forumData, FrsViewData frsViewData) {
        if (forumData == null || frsViewData == null) {
            return;
        }
        float y = y(forumData);
        d.b.i0.p0.q2.b bVar = this.f58179c;
        if (bVar == null) {
            return;
        }
        bVar.B(forumData, frsViewData);
        this.f58179c.E(forumData.isLike(), forumData.getLevelName(), forumData.getUser_level(), y, false);
        this.f58179c.G(forumData.getSignData());
    }

    public void T(FrsViewData frsViewData) {
        if (frsViewData != null && B()) {
            S(frsViewData.getForum(), frsViewData);
            if ("brand_page".equals(this.f58184h)) {
                this.f58179c.b();
            }
        }
    }

    public void U(int i) {
        if (B()) {
            h0(i);
        }
    }

    public void V() {
        d.b.i0.p0.q2.b bVar = this.f58179c;
        if (bVar != null) {
            bVar.S();
        }
    }

    public void W() {
        FrsHeaderViewContainer frsHeaderViewContainer = this.f58178b;
        if (frsHeaderViewContainer != null) {
            frsHeaderViewContainer.removeCallbacks(this.r);
            this.f58178b.postDelayed(this.r, 100L);
        }
    }

    public void X(FrsViewData frsViewData) {
        if (frsViewData == null || this.f58179c == null || !B()) {
            return;
        }
        this.f58179c.u(y(frsViewData.getForum()));
    }

    public void Y() {
        d.b.i0.p0.q2.b bVar = this.f58179c;
        if (bVar != null) {
            bVar.x();
        }
    }

    public void b0(String str) {
        if (this.f58177a.M() == null || this.f58177a.M().P() == null) {
            return;
        }
        int x = this.f58177a.M().P().x();
        int u = this.f58177a.M().P().u();
        int t = this.f58177a.M().P().t();
        d.b.i0.c3.e i = d.b.i0.c3.e.i();
        d.b.i0.c3.e.i().n(i.g("1~" + str, x, u, t), false);
    }

    public final void c0() {
        d.b.i0.p0.q2.b bVar = this.f58179c;
        if (bVar != null) {
            this.f58178b.d(bVar.k());
            this.f58178b.d(this.f58179c.g());
            d0();
        }
        this.f58181e = false;
    }

    public final void d0() {
        FrsFragment frsFragment;
        if (this.m == null || (frsFragment = this.f58177a) == null || frsFragment.v2() == null) {
            return;
        }
        this.f58177a.v2().removeHeaderView(this.m.E());
    }

    public void f0(boolean z) {
        if (z) {
            d.b.i0.p0.q2.b bVar = this.f58179c;
            if (bVar != null) {
                this.f58178b.d(bVar.g());
                this.f58181e = false;
                return;
            }
            return;
        }
        d.b.i0.p0.q2.b bVar2 = this.f58179c;
        if (bVar2 == null || bVar2.g() == null || this.f58181e) {
            return;
        }
        this.f58178b.b(this.f58179c.g(), this.f58178b.getHeaderViewsCount());
        this.f58181e = true;
    }

    public void g0(int i) {
        d.b.i0.p0.q2.b bVar = this.f58179c;
        if (bVar == null || bVar.g() == null) {
            return;
        }
        View findViewById = this.f58179c.g().findViewById(R.id.divider_bottom);
        if (findViewById != null) {
            findViewById.setVisibility(i);
        }
        this.f58179c.m();
    }

    public void h0(int i) {
        d.b.i0.p0.q2.b bVar = this.f58179c;
        if (bVar != null) {
            bVar.D(i);
        }
    }

    public void i0(int i, ForumData forumData, FrsViewData frsViewData, boolean z) {
        d.b.i0.p0.q2.b bVar = this.f58179c;
        if (bVar == null) {
            return;
        }
        bVar.B(forumData, frsViewData);
        if (forumData == null) {
            return;
        }
        this.f58179c.E(i, forumData.getLevelName(), forumData.getUser_level(), y(forumData), z);
        if (forumData.getSignData() == null || forumData.getSignData().forum_rank != -2) {
            return;
        }
        this.f58179c.a(false);
    }

    public void j0(FrsViewData frsViewData, boolean z) {
        if (frsViewData != null && B()) {
            i0(1, frsViewData.getForum(), frsViewData, z);
        }
    }

    public void m0(int i) {
        d.b.i0.p0.q2.b bVar;
        if (!B() || (bVar = this.f58179c) == null) {
            return;
        }
        bVar.F(i);
    }

    public void n0(FrsViewData frsViewData) {
        g gVar;
        if (!B() || (gVar = this.n) == null) {
            return;
        }
        gVar.t(this.f58179c, frsViewData);
    }

    public void o0() {
        if (B()) {
            h0(0);
        }
    }

    public void p0(int i) {
        d.b.i0.p0.q2.b bVar = this.f58179c;
        if (bVar != null) {
            bVar.J(i);
        }
    }

    public void r0(int i) {
        if (i > 1) {
            d.b.i0.p0.q2.b bVar = this.f58179c;
            if (bVar != null) {
                bVar.H(false);
                return;
            }
            return;
        }
        d.b.i0.p0.q2.b bVar2 = this.f58179c;
        if (bVar2 != null) {
            bVar2.H(true);
        }
    }

    public void s() {
        d.b.i0.p0.q2.b bVar;
        if (this.f58181e || (bVar = this.f58179c) == null) {
            return;
        }
        this.f58178b.a(bVar.g());
        this.f58181e = true;
    }

    public void s0(int i) {
        this.i = i;
    }

    public void t0(FrsTabViewController frsTabViewController) {
        this.m = frsTabViewController;
    }

    public final void u(String str, int i, int i2) {
        boolean z = !TextUtils.equals(this.f58184h, str);
        this.k = i2;
        this.f58184h = str;
        c0();
        if (this.f58179c == null || z) {
            d.b.i0.p0.q2.b e2 = this.f58180d.e(str, this.f58177a, i);
            this.f58179c = e2;
            e2.c(this.f58183g);
            this.f58179c.A(this.s);
        }
        g gVar = this.n;
        if (gVar != null) {
            this.f58179c.K(gVar);
        }
        f fVar = this.o;
        if (fVar != null) {
            this.f58179c.I(fVar);
        }
        this.f58178b.a(this.f58179c.k());
        v(str);
        y0();
        v0();
    }

    public void u0() {
        d.b.i0.p0.q2.b bVar = this.f58179c;
        if (bVar != null) {
            bVar.N();
        }
    }

    public final void v(String str) {
        FrsFragment frsFragment;
        RelativeLayout E;
        if (this.m == null || (frsFragment = this.f58177a) == null || frsFragment.v2() == null || (E = this.m.E()) == null) {
            return;
        }
        if ("brand_page".equals(str)) {
            this.f58177a.v2().removeHeaderView(E);
            return;
        }
        this.f58177a.v2().removeHeaderView(E);
        this.f58177a.v2().t(E, 0);
    }

    public void v0() {
        d.b.b.e.m.e.a().postDelayed(this.q, 500L);
    }

    public boolean w() {
        d.b.i0.p0.q2.b bVar;
        if (!B() || (bVar = this.f58179c) == null) {
            return false;
        }
        return bVar.l();
    }

    public void w0(String str, FrsViewData frsViewData) {
        if (frsViewData == null || frsViewData.getUserData() == null || frsViewData.getForum() == null) {
            return;
        }
        u(str, frsViewData.getUserData().getIsMem(), frsViewData.getForum().isLike());
    }

    public boolean x() {
        d.b.i0.p0.q2.b bVar;
        if (!B() || (bVar = this.f58179c) == null) {
            return false;
        }
        return bVar.h();
    }

    public final void x0() {
        d.b.i0.p0.q2.b bVar;
        if (!B() || (bVar = this.f58179c) == null) {
            return;
        }
        bVar.O();
    }

    public final float y(ForumData forumData) {
        g gVar;
        if (forumData == null || (gVar = this.n) == null) {
            return 0.0f;
        }
        return gVar.k(forumData);
    }

    public final void y0() {
        d.b.b.e.m.e.a().postDelayed(this.p, PluginCenter.PLUGIN_RETRY_MIN_TIME_INTERVAL);
    }

    public f z() {
        return this.o;
    }

    public void z0(boolean z) {
        f fVar = this.o;
        if (fVar != null) {
            fVar.r(z);
        }
    }
}
