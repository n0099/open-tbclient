package d.a.j0.t.d.c.h;

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
import d.a.j0.t.d.c.e.h;
import d.a.j0.t.d.c.e.i;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes4.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    public TbPageContext f60601a;

    /* renamed from: b  reason: collision with root package name */
    public Context f60602b;

    /* renamed from: c  reason: collision with root package name */
    public ViewGroup f60603c;

    /* renamed from: d  reason: collision with root package name */
    public ViewGroup f60604d;

    /* renamed from: e  reason: collision with root package name */
    public AppBarLayout f60605e;

    /* renamed from: f  reason: collision with root package name */
    public LinearLayout f60606f;

    /* renamed from: g  reason: collision with root package name */
    public FrameLayout f60607g;

    /* renamed from: h  reason: collision with root package name */
    public d.a.j0.t.d.c.h.d f60608h;

    /* renamed from: i  reason: collision with root package name */
    public ScrollHorizontalTabView f60609i;
    public NestedNoScrollViewPager j;
    public f k;
    public boolean m;
    public int n;
    public FragmentManager o;
    public List<LiveTabBaseSubFragment> r;
    public boolean l = false;
    public int p = -1;
    public boolean q = false;
    public SparseArray<String> s = new SparseArray<>();
    public CustomMessageListener t = new C1562a(2921442);
    public ScrollHorizontalTabView.OnTabClickListener u = new b();
    public CustomMessageListener v = new e(2921414);

    /* renamed from: d.a.j0.t.d.c.h.a$a  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public class C1562a extends CustomMessageListener {
        public C1562a(int i2) {
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
    public class b implements ScrollHorizontalTabView.OnTabClickListener {
        public b() {
        }

        @Override // com.baidu.ala.view.ScrollHorizontalTabView.OnTabClickListener
        public void onClick(int i2) {
            if (a.this.s.size() != 0) {
                int keyAt = a.this.s.keyAt(i2);
                StatisticItem statisticItem = new StatisticItem(CommonStatisticKey.KEY_LIVE_SECOND_TAB_CLICK);
                statisticItem.param("obj_type", keyAt - 3);
                TiebaStaticHelper.addYYParam(statisticItem);
                TiebaStatic.log(statisticItem);
            }
        }
    }

    /* loaded from: classes4.dex */
    public class c implements AppBarLayout.OnOffsetChangedListener {
        public c() {
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
    public class d implements ScrollHorizontalTabView.ScrollTabPageListener {
        public d(a aVar) {
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
    public class e extends CustomMessageListener {

        /* renamed from: d.a.j0.t.d.c.h.a$e$a  reason: collision with other inner class name */
        /* loaded from: classes4.dex */
        public class RunnableC1563a implements Runnable {
            public RunnableC1563a() {
            }

            @Override // java.lang.Runnable
            public void run() {
                if (a.this.k != null) {
                    a.this.k.d();
                }
            }
        }

        public e(int i2) {
            super(i2);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            d.a.c.e.m.e.a().postDelayed(new RunnableC1563a(), 500L);
        }
    }

    /* loaded from: classes4.dex */
    public class f extends FragmentPagerAdapter {

        /* renamed from: a  reason: collision with root package name */
        public List<LiveTabBaseSubFragment> f60615a;

        public f(a aVar, FragmentManager fragmentManager, List<LiveTabBaseSubFragment> list) {
            super(fragmentManager);
            this.f60615a = list;
        }

        public final LiveTabBaseSubFragment b(int i2) {
            if (i2 < this.f60615a.size()) {
                return this.f60615a.get(i2);
            }
            return null;
        }

        public void c() {
            if (ListUtils.isEmpty(this.f60615a)) {
                return;
            }
            for (int i2 = 0; i2 < this.f60615a.size(); i2++) {
                LiveTabBaseSubFragment liveTabBaseSubFragment = this.f60615a.get(i2);
                if (liveTabBaseSubFragment != null) {
                    liveTabBaseSubFragment.loadData();
                }
            }
        }

        public void d() {
            if (ListUtils.isEmpty(this.f60615a)) {
                return;
            }
            for (int i2 = 0; i2 < this.f60615a.size(); i2++) {
                LiveTabBaseSubFragment liveTabBaseSubFragment = this.f60615a.get(i2);
                if (liveTabBaseSubFragment != null) {
                    liveTabBaseSubFragment.H0();
                }
            }
        }

        public void e(int i2) {
            if (i2 < 0 || i2 >= this.f60615a.size()) {
                return;
            }
            this.f60615a.get(i2).p();
        }

        @Override // androidx.viewpager.widget.PagerAdapter
        public int getCount() {
            List<LiveTabBaseSubFragment> list = this.f60615a;
            if (list != null) {
                return list.size();
            }
            return 0;
        }

        @Override // androidx.fragment.app.FragmentPagerAdapter
        public Fragment getItem(int i2) {
            return b(i2);
        }
    }

    public a(TbPageContext tbPageContext, FragmentManager fragmentManager, boolean z) {
        this.f60601a = tbPageContext;
        this.m = z;
        this.f60602b = tbPageContext.getPageActivity();
        this.o = fragmentManager;
        n();
    }

    public void g(boolean z, boolean z2) {
        if (ListUtils.isEmpty(this.r) || z != this.q) {
            this.q = z;
            if (!z) {
                l();
            } else {
                o();
            }
            if (z2) {
                p();
            }
        }
    }

    public void h() {
        MessageManager.getInstance().unRegisterListener(this.v);
        MessageManager.getInstance().unRegisterListener(this.t);
    }

    public final List<TabData> i(boolean z) {
        ArrayList arrayList = new ArrayList();
        TabData tabData = new TabData();
        tabData.tabId = 100;
        tabData.tabName = this.f60602b.getResources().getString(R.string.special_recommend_tab_title);
        arrayList.add(tabData);
        TabData tabData2 = new TabData();
        tabData2.tabId = 200;
        tabData2.tabName = this.f60602b.getResources().getString(R.string.special_yanzhi_tab_title);
        arrayList.add(tabData2);
        if (z) {
            TabData tabData3 = new TabData();
            tabData3.tabId = 400;
            tabData3.tabName = this.f60602b.getResources().getString(R.string.special_friend_tab_title);
            arrayList.add(tabData3);
        }
        return arrayList;
    }

    public ViewGroup j() {
        return this.f60603c;
    }

    public void k() {
        this.v.setTag(this.f60601a.getUniqueId());
        MessageManager.getInstance().registerListener(this.v);
        MessageManager.getInstance().registerListener(this.t);
    }

    public void l() {
        v();
        this.s.clear();
        boolean z = d.a.i0.r.d0.b.j().k("key_show_ala_friend_tab", 0) == 1;
        this.j.setOffscreenPageLimit(z ? 2 : 1);
        this.r.add(LiveTabRecomSubFragment.R0(this.m, 1));
        this.r.add(LiveTabYanzhiSubFragment.S0(this.m));
        if (z) {
            this.r.add(LiveTabFriendSubFragment.W0(this.m));
        }
        f fVar = new f(this, this.o, this.r);
        this.k = fVar;
        this.j.setAdapter(fVar);
        TbPageContext tbPageContext = this.f60601a;
        if (tbPageContext != null && tbPageContext.getPageActivity() != null && this.f60601a.getPageActivity().getIntent() != null) {
            int intExtra = this.f60601a.getPageActivity().getIntent().getIntExtra("locate_type", 0);
            if (intExtra == 17) {
                this.p = 0;
            } else if (intExtra == 18) {
                this.p = 1;
            }
        }
        this.f60609i.setViewPager(this.j);
        this.f60609i.setScrollTabPageListener(new d(this));
        this.f60609i.setData(i(z));
    }

    public final void m() {
        if (this.s.size() == 0) {
            this.s.put(4, this.f60602b.getResources().getString(R.string.special_recommend_tab_title));
            this.s.put(5, this.f60602b.getResources().getString(R.string.special_music_tab_title));
            this.s.put(6, this.f60602b.getResources().getString(R.string.special_talk_tab_title));
            this.s.put(7, this.f60602b.getResources().getString(R.string.special_game_tab_title));
            this.s.put(8, this.f60602b.getResources().getString(R.string.special_other_tab_title));
        }
    }

    public final void n() {
        ViewGroup viewGroup = (ViewGroup) LayoutInflater.from(this.f60602b).inflate(R.layout.ala_live_tab_layout, (ViewGroup) null);
        this.f60603c = viewGroup;
        AppBarLayout appBarLayout = (AppBarLayout) viewGroup.findViewById(R.id.live_tab_appbar_layout);
        this.f60605e = appBarLayout;
        appBarLayout.addOnOffsetChangedListener((AppBarLayout.OnOffsetChangedListener) new c());
        this.f60604d = (ViewGroup) this.f60603c.findViewById(R.id.live_tab_root_container);
        this.f60606f = (LinearLayout) this.f60603c.findViewById(R.id.live_tab_base_container);
        this.f60607g = (FrameLayout) this.f60603c.findViewById(R.id.super_entrance_container);
        ScrollHorizontalTabView scrollHorizontalTabView = (ScrollHorizontalTabView) this.f60603c.findViewById(R.id.live_tab_top_tab_layout);
        this.f60609i = scrollHorizontalTabView;
        scrollHorizontalTabView.setOnTabClickListener(this.u);
        this.f60608h = new d.a.j0.t.d.c.h.d(this.f60601a);
        this.j = (NestedNoScrollViewPager) this.f60603c.findViewById(R.id.live_tab_view_pager);
        g(d.a.j0.t.d.c.c.e(), false);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, this.f60602b.getResources().getDimensionPixelSize(R.dimen.tbds256));
        if (this.f60608h.l() != null && this.f60608h.l().getParent() == null) {
            this.f60607g.addView(this.f60608h.l(), layoutParams);
            this.f60606f.setVisibility(8);
        }
        ((FrameLayout.LayoutParams) this.f60604d.getLayoutParams()).bottomMargin = TbadkCoreApplication.getInst().getMainTabBottomBarHeight();
        s();
    }

    public final void o() {
        m();
        v();
        ArrayList arrayList = new ArrayList();
        this.r.add(LiveTabRecomSubFragment.R0(this.m, this.s.keyAt(0)));
        TabData tabData = new TabData();
        tabData.tabId = this.s.keyAt(0);
        tabData.tabName = this.s.valueAt(0);
        arrayList.add(tabData);
        q(this.s.keyAt(0));
        for (int i2 = 1; i2 < this.s.size(); i2++) {
            int keyAt = this.s.keyAt(i2);
            this.r.add(LiveTabYYSubFragment.W0(this.m, keyAt));
            TabData tabData2 = new TabData();
            tabData2.tabId = keyAt;
            tabData2.tabName = this.s.valueAt(i2);
            arrayList.add(tabData2);
            q(keyAt);
        }
        f fVar = new f(this, this.o, this.r);
        this.k = fVar;
        fVar.notifyDataSetChanged();
        this.j.setAdapter(this.k);
        this.j.setOffscreenPageLimit(arrayList.size());
        this.p = 0;
        this.f60609i.setViewPager(this.j);
        this.f60609i.setData(arrayList);
    }

    public void p() {
        this.k.c();
    }

    public final void q(int i2) {
        StatisticItem statisticItem = new StatisticItem(CommonStatisticKey.KEY_LIVE_SECOND_TAB_SHOW);
        statisticItem.param("obj_type", i2 - 3);
        TiebaStaticHelper.addYYParam(statisticItem);
        TiebaStatic.log(statisticItem);
    }

    public void r(boolean z) {
        d.a.j0.t.d.c.h.d dVar = this.f60608h;
        if (dVar != null) {
            dVar.v(z);
        }
    }

    public void s() {
        int skinType = TbadkCoreApplication.getInst().getSkinType();
        this.f60608h.n(this.f60601a, skinType);
        this.f60609i.onChangeSkinType(skinType);
        SkinManager.setBackgroundColor(this.f60603c, R.color.CAM_X0202);
        SkinManager.setBackgroundColor(this.f60609i, R.color.CAM_X0202);
    }

    public void t(boolean z) {
        int i2;
        if (!z || (i2 = this.p) == -1) {
            return;
        }
        x(i2);
        this.p = -1;
    }

    public void u() {
        this.k.e(this.j.getCurrentItem());
    }

    public final void v() {
        FragmentManager fragmentManager;
        if (!ListUtils.isEmpty(this.r) && (fragmentManager = this.o) != null) {
            try {
                FragmentTransaction beginTransaction = fragmentManager.beginTransaction();
                int size = this.r.size();
                for (int i2 = 0; i2 < size; i2++) {
                    if (this.r.get(i2) != null) {
                        beginTransaction.remove(this.r.get(i2));
                    }
                }
                beginTransaction.commit();
                this.o.executePendingTransactions();
            } catch (Throwable th) {
                BdLog.e(th.getMessage());
            }
        } else if (this.r == null) {
            this.r = new ArrayList();
        }
        this.r.clear();
        f fVar = this.k;
        if (fVar != null) {
            fVar.notifyDataSetChanged();
        }
    }

    public void w(boolean z) {
        this.f60604d.setVisibility(z ? 0 : 8);
    }

    public void x(int i2) {
        int i3 = 0;
        if (i2 <= 0) {
            i2 = 0;
        }
        f fVar = this.k;
        if (fVar == null || i2 < fVar.getCount()) {
            i3 = i2;
        }
        NestedNoScrollViewPager nestedNoScrollViewPager = this.j;
        if (nestedNoScrollViewPager != null) {
            nestedNoScrollViewPager.setCurrentItem(i3);
        }
    }

    public void y(h hVar) {
        i iVar = new i();
        iVar.f60502e = hVar;
        this.f60608h.m(iVar);
        this.f60606f.setVisibility(0);
    }
}
