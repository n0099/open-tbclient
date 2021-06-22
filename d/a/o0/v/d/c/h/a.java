package d.a.o0.v.d.c.h;

import android.content.Context;
import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.fragment.app.FragmentTransaction;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.ala.data.TabData;
import com.baidu.ala.view.ScrollHorizontalTabView;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.TbSingleton;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.CommonStatisticKey;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.TiebaStaticHelper;
import com.baidu.tbadk.widget.NestedNoScrollViewPager;
import com.baidu.tieba.R;
import com.baidu.tieba.ala.alasquare.live_tab.fragment.LiveTabBaseSubFragment;
import com.baidu.tieba.ala.alasquare.live_tab.fragment.LiveTabFriendSubFragment;
import com.baidu.tieba.ala.alasquare.live_tab.fragment.LiveTabRecomSubFragment;
import com.baidu.tieba.ala.alasquare.live_tab.fragment.LiveTabYYSubFragment;
import com.baidu.tieba.ala.alasquare.live_tab.fragment.LiveTabYanzhiSubFragment;
import com.google.android.material.appbar.AppBarLayout;
import d.a.o0.v.d.c.e.h;
import d.a.o0.v.d.c.e.i;
import d.a.o0.y3.a;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes4.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    public TbPageContext f65451a;

    /* renamed from: b  reason: collision with root package name */
    public Context f65452b;

    /* renamed from: c  reason: collision with root package name */
    public ViewGroup f65453c;

    /* renamed from: d  reason: collision with root package name */
    public ViewGroup f65454d;

    /* renamed from: e  reason: collision with root package name */
    public AppBarLayout f65455e;

    /* renamed from: f  reason: collision with root package name */
    public LinearLayout f65456f;

    /* renamed from: g  reason: collision with root package name */
    public FrameLayout f65457g;

    /* renamed from: h  reason: collision with root package name */
    public d.a.o0.v.d.c.h.d f65458h;

    /* renamed from: i  reason: collision with root package name */
    public ScrollHorizontalTabView f65459i;
    public NestedNoScrollViewPager j;
    public g k;
    public boolean m;
    public int n;
    public FragmentManager o;
    public List<LiveTabBaseSubFragment> x;
    public boolean l = false;
    public int p = -1;
    public boolean q = false;
    public int r = 3;
    public int s = 4;
    public int t = 5;
    public int u = 6;
    public int v = 7;
    public int w = 8;
    public SparseArray<String> y = new SparseArray<>();
    public boolean z = false;
    public CustomMessageListener A = new C1708a(2921442);
    public CustomMessageListener B = new b(2001371);
    public ScrollHorizontalTabView.OnTabClickListener C = new c();
    public CustomMessageListener D = new f(2921414);

    /* renamed from: d.a.o0.v.d.c.h.a$a  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public class C1708a extends CustomMessageListener {
        public C1708a(int i2) {
            super(i2);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Boolean bool = (Boolean) customResponsedMessage.getData();
            if (bool != null && bool.booleanValue()) {
                a.this.l = false;
            }
        }
    }

    /* loaded from: classes4.dex */
    public class b extends CustomMessageListener {
        public b(int i2) {
            super(i2);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (TbSingleton.getInstance().getYYLiveTabConfig() == null || ListUtils.isEmpty(TbSingleton.getInstance().getYYLiveTabConfig().a()) || a.this.z) {
                return;
            }
            a.this.z = true;
            a.this.j(d.a.o0.v.d.c.c.e(), false, true);
        }
    }

    /* loaded from: classes4.dex */
    public class c implements ScrollHorizontalTabView.OnTabClickListener {
        public c() {
        }

        @Override // com.baidu.ala.view.ScrollHorizontalTabView.OnTabClickListener
        public void onClick(int i2) {
            if (a.this.y.size() != 0) {
                int keyAt = a.this.y.keyAt(i2);
                StatisticItem statisticItem = new StatisticItem(CommonStatisticKey.KEY_LIVE_SECOND_TAB_CLICK);
                statisticItem.param("obj_type", keyAt - a.this.r);
                TiebaStaticHelper.addYYParam(statisticItem);
                TiebaStatic.log(statisticItem);
            }
        }
    }

    /* loaded from: classes4.dex */
    public class d implements AppBarLayout.OnOffsetChangedListener {
        public d() {
        }

        @Override // com.google.android.material.appbar.AppBarLayout.OnOffsetChangedListener, com.google.android.material.appbar.AppBarLayout.BaseOnOffsetChangedListener
        public void onOffsetChanged(AppBarLayout appBarLayout, int i2) {
            if (i2 == 0 || i2 == a.this.n) {
                return;
            }
            if (i2 - a.this.n <= -4 && !a.this.l) {
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921441, Boolean.FALSE));
                a.this.l = true;
            }
            a.this.n = i2;
        }
    }

    /* loaded from: classes4.dex */
    public class e implements ScrollHorizontalTabView.ScrollTabPageListener {
        public e(a aVar) {
        }

        @Override // com.baidu.ala.view.ScrollHorizontalTabView.ScrollTabPageListener
        public void onPageScrolled(int i2, float f2, int i3) {
        }

        @Override // com.baidu.ala.view.ScrollHorizontalTabView.ScrollTabPageListener
        public void onPageSelected(int i2, TabData tabData) {
        }

        @Override // com.baidu.ala.view.ScrollHorizontalTabView.ScrollTabPageListener
        public boolean onPrePageSelect(int i2, TabData tabData) {
            return true;
        }
    }

    /* loaded from: classes4.dex */
    public class f extends CustomMessageListener {

        /* renamed from: d.a.o0.v.d.c.h.a$f$a  reason: collision with other inner class name */
        /* loaded from: classes4.dex */
        public class RunnableC1709a implements Runnable {
            public RunnableC1709a() {
            }

            @Override // java.lang.Runnable
            public void run() {
                if (a.this.k != null) {
                    a.this.k.k();
                }
            }
        }

        public f(int i2) {
            super(i2);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            d.a.c.e.m.e.a().postDelayed(new RunnableC1709a(), 500L);
        }
    }

    /* loaded from: classes4.dex */
    public class g extends FragmentPagerAdapter {

        /* renamed from: a  reason: collision with root package name */
        public List<LiveTabBaseSubFragment> f65466a;

        public g(a aVar, FragmentManager fragmentManager, List<LiveTabBaseSubFragment> list) {
            super(fragmentManager);
            this.f65466a = list;
        }

        @Override // androidx.viewpager.widget.PagerAdapter
        public int getCount() {
            List<LiveTabBaseSubFragment> list = this.f65466a;
            if (list != null) {
                return list.size();
            }
            return 0;
        }

        @Override // androidx.fragment.app.FragmentPagerAdapter
        public Fragment getItem(int i2) {
            return i(i2);
        }

        public final LiveTabBaseSubFragment i(int i2) {
            if (i2 < this.f65466a.size()) {
                return this.f65466a.get(i2);
            }
            return null;
        }

        public void j() {
            if (ListUtils.isEmpty(this.f65466a)) {
                return;
            }
            for (int i2 = 0; i2 < this.f65466a.size(); i2++) {
                LiveTabBaseSubFragment liveTabBaseSubFragment = this.f65466a.get(i2);
                if (liveTabBaseSubFragment != null) {
                    liveTabBaseSubFragment.loadData();
                }
            }
        }

        public void k() {
            if (ListUtils.isEmpty(this.f65466a)) {
                return;
            }
            for (int i2 = 0; i2 < this.f65466a.size(); i2++) {
                LiveTabBaseSubFragment liveTabBaseSubFragment = this.f65466a.get(i2);
                if (liveTabBaseSubFragment != null) {
                    liveTabBaseSubFragment.J0();
                }
            }
        }

        public void l(int i2) {
            if (i2 < 0 || i2 >= this.f65466a.size()) {
                return;
            }
            this.f65466a.get(i2).r();
        }
    }

    public a(TbPageContext tbPageContext, FragmentManager fragmentManager, boolean z) {
        this.f65451a = tbPageContext;
        this.m = z;
        this.f65452b = tbPageContext.getPageActivity();
        this.o = fragmentManager;
        q();
    }

    public void A(int i2) {
        int i3 = 0;
        if (i2 <= 0) {
            i2 = 0;
        }
        g gVar = this.k;
        if (gVar == null || i2 < gVar.getCount()) {
            i3 = i2;
        }
        NestedNoScrollViewPager nestedNoScrollViewPager = this.j;
        if (nestedNoScrollViewPager != null) {
            nestedNoScrollViewPager.setCurrentItem(i3);
        }
    }

    public void B(h hVar) {
        i iVar = new i();
        iVar.f65352e = hVar;
        this.f65458h.n(iVar);
        this.f65456f.setVisibility(0);
    }

    public void j(boolean z, boolean z2, boolean z3) {
        if (ListUtils.isEmpty(this.x) || z != this.q || z3) {
            this.q = z;
            if (!z) {
                o();
            } else {
                r(z3);
            }
            if (z2) {
                s();
            }
        }
    }

    public void k() {
        MessageManager.getInstance().unRegisterListener(this.D);
        MessageManager.getInstance().unRegisterListener(this.A);
        MessageManager.getInstance().unRegisterListener(this.B);
    }

    public final List<TabData> l(boolean z) {
        ArrayList arrayList = new ArrayList();
        TabData tabData = new TabData();
        tabData.tabId = 100;
        tabData.tabName = this.f65452b.getResources().getString(R.string.special_recommend_tab_title);
        arrayList.add(tabData);
        TabData tabData2 = new TabData();
        tabData2.tabId = 200;
        tabData2.tabName = this.f65452b.getResources().getString(R.string.special_yanzhi_tab_title);
        arrayList.add(tabData2);
        if (z) {
            TabData tabData3 = new TabData();
            tabData3.tabId = 400;
            tabData3.tabName = this.f65452b.getResources().getString(R.string.special_friend_tab_title);
            arrayList.add(tabData3);
        }
        return arrayList;
    }

    public ViewGroup m() {
        return this.f65453c;
    }

    public void n() {
        this.D.setTag(this.f65451a.getUniqueId());
        MessageManager.getInstance().registerListener(this.D);
        MessageManager.getInstance().registerListener(this.A);
        MessageManager.getInstance().registerListener(this.B);
    }

    public void o() {
        y();
        this.y.clear();
        boolean z = d.a.n0.r.d0.b.j().k("key_show_ala_friend_tab", 0) == 1;
        this.j.setOffscreenPageLimit(z ? 2 : 1);
        this.x.add(LiveTabRecomSubFragment.T0(this.m, 1));
        this.x.add(LiveTabYanzhiSubFragment.U0(this.m));
        if (z) {
            this.x.add(LiveTabFriendSubFragment.Y0(this.m));
        }
        g gVar = new g(this, this.o, this.x);
        this.k = gVar;
        this.j.setAdapter(gVar);
        TbPageContext tbPageContext = this.f65451a;
        if (tbPageContext != null && tbPageContext.getPageActivity() != null && this.f65451a.getPageActivity().getIntent() != null) {
            int intExtra = this.f65451a.getPageActivity().getIntent().getIntExtra("locate_type", 0);
            if (intExtra == 17) {
                this.p = 0;
            } else if (intExtra == 18) {
                this.p = 1;
            }
        }
        this.f65459i.setViewPager(this.j);
        this.f65459i.setScrollTabPageListener(new e(this));
        this.f65459i.setData(l(z));
    }

    public final void p(boolean z) {
        if (z) {
            if (TbSingleton.getInstance().getYYLiveTabConfig() == null || ListUtils.isEmpty(TbSingleton.getInstance().getYYLiveTabConfig().a())) {
                return;
            }
            List<a.C1813a> a2 = TbSingleton.getInstance().getYYLiveTabConfig().a();
            this.y.clear();
            this.y.put(this.s, this.f65452b.getResources().getString(R.string.special_recommend_tab_title));
            for (int i2 = 0; i2 < a2.size(); i2++) {
                this.y.put(a2.get(i2).f67281a, a2.get(i2).f67282b);
            }
        } else if (this.y.size() == 0) {
            this.y.put(this.s, this.f65452b.getResources().getString(R.string.special_recommend_tab_title));
            this.y.put(this.t, this.f65452b.getResources().getString(R.string.special_music_tab_title));
            this.y.put(this.u, this.f65452b.getResources().getString(R.string.special_talk_tab_title));
            this.y.put(this.v, this.f65452b.getResources().getString(R.string.special_game_tab_title));
            this.y.put(this.w, this.f65452b.getResources().getString(R.string.special_other_tab_title));
        }
    }

    public final void q() {
        ViewGroup viewGroup = (ViewGroup) LayoutInflater.from(this.f65452b).inflate(R.layout.ala_live_tab_layout, (ViewGroup) null);
        this.f65453c = viewGroup;
        AppBarLayout appBarLayout = (AppBarLayout) viewGroup.findViewById(R.id.live_tab_appbar_layout);
        this.f65455e = appBarLayout;
        appBarLayout.addOnOffsetChangedListener((AppBarLayout.OnOffsetChangedListener) new d());
        this.f65454d = (ViewGroup) this.f65453c.findViewById(R.id.live_tab_root_container);
        this.f65456f = (LinearLayout) this.f65453c.findViewById(R.id.live_tab_base_container);
        this.f65457g = (FrameLayout) this.f65453c.findViewById(R.id.super_entrance_container);
        ScrollHorizontalTabView scrollHorizontalTabView = (ScrollHorizontalTabView) this.f65453c.findViewById(R.id.live_tab_top_tab_layout);
        this.f65459i = scrollHorizontalTabView;
        scrollHorizontalTabView.setOnTabClickListener(this.C);
        this.f65458h = new d.a.o0.v.d.c.h.d(this.f65451a);
        this.j = (NestedNoScrollViewPager) this.f65453c.findViewById(R.id.live_tab_view_pager);
        j(d.a.o0.v.d.c.c.e(), false, false);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, this.f65452b.getResources().getDimensionPixelSize(R.dimen.tbds256));
        if (this.f65458h.m() != null && this.f65458h.m().getParent() == null) {
            this.f65457g.addView(this.f65458h.m(), layoutParams);
            this.f65456f.setVisibility(8);
        }
        ((FrameLayout.LayoutParams) this.f65454d.getLayoutParams()).bottomMargin = TbadkCoreApplication.getInst().getMainTabBottomBarHeight();
        v();
    }

    public final void r(boolean z) {
        p(z);
        y();
        ArrayList arrayList = new ArrayList();
        this.x.add(LiveTabRecomSubFragment.T0(this.m, this.y.keyAt(0)));
        TabData tabData = new TabData();
        tabData.tabId = this.y.keyAt(0);
        tabData.tabName = this.y.valueAt(0);
        arrayList.add(tabData);
        t(this.y.keyAt(0));
        for (int i2 = 1; i2 < this.y.size(); i2++) {
            int keyAt = this.y.keyAt(i2);
            this.x.add(LiveTabYYSubFragment.Z0(this.m, keyAt));
            TabData tabData2 = new TabData();
            tabData2.tabId = keyAt;
            tabData2.tabName = this.y.valueAt(i2);
            arrayList.add(tabData2);
            t(keyAt);
        }
        g gVar = new g(this, this.o, this.x);
        this.k = gVar;
        gVar.notifyDataSetChanged();
        this.j.setAdapter(this.k);
        this.j.setOffscreenPageLimit(arrayList.size());
        this.p = 0;
        this.f65459i.setViewPager(this.j);
        this.f65459i.setData(arrayList);
    }

    public void s() {
        this.k.j();
    }

    public final void t(int i2) {
        StatisticItem statisticItem = new StatisticItem(CommonStatisticKey.KEY_LIVE_SECOND_TAB_SHOW);
        statisticItem.param("obj_type", i2 - this.r);
        TiebaStaticHelper.addYYParam(statisticItem);
        TiebaStatic.log(statisticItem);
    }

    public void u(boolean z) {
        d.a.o0.v.d.c.h.d dVar = this.f65458h;
        if (dVar != null) {
            dVar.w(z);
        }
    }

    public void v() {
        int skinType = TbadkCoreApplication.getInst().getSkinType();
        this.f65458h.o(this.f65451a, skinType);
        this.f65459i.onChangeSkinType(skinType);
        SkinManager.setBackgroundColor(this.f65453c, R.color.CAM_X0202);
        SkinManager.setBackgroundColor(this.f65459i, R.color.CAM_X0202);
    }

    public void w(boolean z) {
        int i2;
        if (!z || (i2 = this.p) == -1) {
            return;
        }
        A(i2);
        this.p = -1;
    }

    public void x() {
        this.k.l(this.j.getCurrentItem());
    }

    public final void y() {
        FragmentManager fragmentManager;
        if (!ListUtils.isEmpty(this.x) && (fragmentManager = this.o) != null) {
            try {
                FragmentTransaction beginTransaction = fragmentManager.beginTransaction();
                int size = this.x.size();
                for (int i2 = 0; i2 < size; i2++) {
                    if (this.x.get(i2) != null) {
                        beginTransaction.remove(this.x.get(i2));
                    }
                }
                beginTransaction.commit();
                this.o.executePendingTransactions();
            } catch (Throwable th) {
                BdLog.e(th.getMessage());
            }
        } else if (this.x == null) {
            this.x = new ArrayList();
        }
        this.x.clear();
        g gVar = this.k;
        if (gVar != null) {
            gVar.notifyDataSetChanged();
        }
    }

    public void z(boolean z) {
        this.f65454d.setVisibility(z ? 0 : 8);
    }
}
