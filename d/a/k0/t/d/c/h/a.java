package d.a.k0.t.d.c.h;

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
import d.a.k0.t.d.c.e.h;
import d.a.k0.t.d.c.e.i;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes4.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    public TbPageContext f61325a;

    /* renamed from: b  reason: collision with root package name */
    public Context f61326b;

    /* renamed from: c  reason: collision with root package name */
    public ViewGroup f61327c;

    /* renamed from: d  reason: collision with root package name */
    public ViewGroup f61328d;

    /* renamed from: e  reason: collision with root package name */
    public AppBarLayout f61329e;

    /* renamed from: f  reason: collision with root package name */
    public LinearLayout f61330f;

    /* renamed from: g  reason: collision with root package name */
    public FrameLayout f61331g;

    /* renamed from: h  reason: collision with root package name */
    public d.a.k0.t.d.c.h.d f61332h;

    /* renamed from: i  reason: collision with root package name */
    public ScrollHorizontalTabView f61333i;
    public NestedNoScrollViewPager j;
    public f k;
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
    public CustomMessageListener z = new C1627a(2921442);
    public ScrollHorizontalTabView.OnTabClickListener A = new b();
    public CustomMessageListener B = new e(2921414);

    /* renamed from: d.a.k0.t.d.c.h.a$a  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public class C1627a extends CustomMessageListener {
        public C1627a(int i2) {
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

        /* renamed from: d.a.k0.t.d.c.h.a$e$a  reason: collision with other inner class name */
        /* loaded from: classes4.dex */
        public class RunnableC1628a implements Runnable {
            public RunnableC1628a() {
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
            d.a.c.e.m.e.a().postDelayed(new RunnableC1628a(), 500L);
        }
    }

    /* loaded from: classes4.dex */
    public class f extends FragmentPagerAdapter {

        /* renamed from: a  reason: collision with root package name */
        public List<LiveTabBaseSubFragment> f61339a;

        public f(a aVar, FragmentManager fragmentManager, List<LiveTabBaseSubFragment> list) {
            super(fragmentManager);
            this.f61339a = list;
        }

        public final LiveTabBaseSubFragment b(int i2) {
            if (i2 < this.f61339a.size()) {
                return this.f61339a.get(i2);
            }
            return null;
        }

        public void c() {
            if (ListUtils.isEmpty(this.f61339a)) {
                return;
            }
            for (int i2 = 0; i2 < this.f61339a.size(); i2++) {
                LiveTabBaseSubFragment liveTabBaseSubFragment = this.f61339a.get(i2);
                if (liveTabBaseSubFragment != null) {
                    liveTabBaseSubFragment.loadData();
                }
            }
        }

        public void d() {
            if (ListUtils.isEmpty(this.f61339a)) {
                return;
            }
            for (int i2 = 0; i2 < this.f61339a.size(); i2++) {
                LiveTabBaseSubFragment liveTabBaseSubFragment = this.f61339a.get(i2);
                if (liveTabBaseSubFragment != null) {
                    liveTabBaseSubFragment.G0();
                }
            }
        }

        public void e(int i2) {
            if (i2 < 0 || i2 >= this.f61339a.size()) {
                return;
            }
            this.f61339a.get(i2).p();
        }

        @Override // androidx.viewpager.widget.PagerAdapter
        public int getCount() {
            List<LiveTabBaseSubFragment> list = this.f61339a;
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
        this.f61325a = tbPageContext;
        this.m = z;
        this.f61326b = tbPageContext.getPageActivity();
        this.o = fragmentManager;
        o();
    }

    public void h(boolean z, boolean z2) {
        if (ListUtils.isEmpty(this.x) || z != this.q) {
            this.q = z;
            if (!z) {
                m();
            } else {
                p();
            }
            if (z2) {
                q();
            }
        }
    }

    public void i() {
        MessageManager.getInstance().unRegisterListener(this.B);
        MessageManager.getInstance().unRegisterListener(this.z);
    }

    public final List<TabData> j(boolean z) {
        ArrayList arrayList = new ArrayList();
        TabData tabData = new TabData();
        tabData.tabId = 100;
        tabData.tabName = this.f61326b.getResources().getString(R.string.special_recommend_tab_title);
        arrayList.add(tabData);
        TabData tabData2 = new TabData();
        tabData2.tabId = 200;
        tabData2.tabName = this.f61326b.getResources().getString(R.string.special_yanzhi_tab_title);
        arrayList.add(tabData2);
        if (z) {
            TabData tabData3 = new TabData();
            tabData3.tabId = 400;
            tabData3.tabName = this.f61326b.getResources().getString(R.string.special_friend_tab_title);
            arrayList.add(tabData3);
        }
        return arrayList;
    }

    public ViewGroup k() {
        return this.f61327c;
    }

    public void l() {
        this.B.setTag(this.f61325a.getUniqueId());
        MessageManager.getInstance().registerListener(this.B);
        MessageManager.getInstance().registerListener(this.z);
    }

    public void m() {
        w();
        this.y.clear();
        boolean z = d.a.j0.r.d0.b.j().k("key_show_ala_friend_tab", 0) == 1;
        this.j.setOffscreenPageLimit(z ? 2 : 1);
        this.x.add(LiveTabRecomSubFragment.Q0(this.m, 1));
        this.x.add(LiveTabYanzhiSubFragment.R0(this.m));
        if (z) {
            this.x.add(LiveTabFriendSubFragment.V0(this.m));
        }
        f fVar = new f(this, this.o, this.x);
        this.k = fVar;
        this.j.setAdapter(fVar);
        TbPageContext tbPageContext = this.f61325a;
        if (tbPageContext != null && tbPageContext.getPageActivity() != null && this.f61325a.getPageActivity().getIntent() != null) {
            int intExtra = this.f61325a.getPageActivity().getIntent().getIntExtra("locate_type", 0);
            if (intExtra == 17) {
                this.p = 0;
            } else if (intExtra == 18) {
                this.p = 1;
            }
        }
        this.f61333i.setViewPager(this.j);
        this.f61333i.setScrollTabPageListener(new d(this));
        this.f61333i.setData(j(z));
    }

    public final void n() {
        if (this.y.size() == 0) {
            this.y.put(this.s, this.f61326b.getResources().getString(R.string.special_recommend_tab_title));
            this.y.put(this.t, this.f61326b.getResources().getString(R.string.special_music_tab_title));
            this.y.put(this.u, this.f61326b.getResources().getString(R.string.special_talk_tab_title));
            this.y.put(this.v, this.f61326b.getResources().getString(R.string.special_game_tab_title));
            this.y.put(this.w, this.f61326b.getResources().getString(R.string.special_other_tab_title));
        }
    }

    public final void o() {
        ViewGroup viewGroup = (ViewGroup) LayoutInflater.from(this.f61326b).inflate(R.layout.ala_live_tab_layout, (ViewGroup) null);
        this.f61327c = viewGroup;
        AppBarLayout appBarLayout = (AppBarLayout) viewGroup.findViewById(R.id.live_tab_appbar_layout);
        this.f61329e = appBarLayout;
        appBarLayout.addOnOffsetChangedListener((AppBarLayout.OnOffsetChangedListener) new c());
        this.f61328d = (ViewGroup) this.f61327c.findViewById(R.id.live_tab_root_container);
        this.f61330f = (LinearLayout) this.f61327c.findViewById(R.id.live_tab_base_container);
        this.f61331g = (FrameLayout) this.f61327c.findViewById(R.id.super_entrance_container);
        ScrollHorizontalTabView scrollHorizontalTabView = (ScrollHorizontalTabView) this.f61327c.findViewById(R.id.live_tab_top_tab_layout);
        this.f61333i = scrollHorizontalTabView;
        scrollHorizontalTabView.setOnTabClickListener(this.A);
        this.f61332h = new d.a.k0.t.d.c.h.d(this.f61325a);
        this.j = (NestedNoScrollViewPager) this.f61327c.findViewById(R.id.live_tab_view_pager);
        h(d.a.k0.t.d.c.c.e(), false);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, this.f61326b.getResources().getDimensionPixelSize(R.dimen.tbds256));
        if (this.f61332h.l() != null && this.f61332h.l().getParent() == null) {
            this.f61331g.addView(this.f61332h.l(), layoutParams);
            this.f61330f.setVisibility(8);
        }
        ((FrameLayout.LayoutParams) this.f61328d.getLayoutParams()).bottomMargin = TbadkCoreApplication.getInst().getMainTabBottomBarHeight();
        t();
    }

    public final void p() {
        n();
        w();
        ArrayList arrayList = new ArrayList();
        this.x.add(LiveTabRecomSubFragment.Q0(this.m, this.y.keyAt(0)));
        TabData tabData = new TabData();
        tabData.tabId = this.y.keyAt(0);
        tabData.tabName = this.y.valueAt(0);
        arrayList.add(tabData);
        r(this.y.keyAt(0));
        for (int i2 = 1; i2 < this.y.size(); i2++) {
            int keyAt = this.y.keyAt(i2);
            this.x.add(LiveTabYYSubFragment.W0(this.m, keyAt));
            TabData tabData2 = new TabData();
            tabData2.tabId = keyAt;
            tabData2.tabName = this.y.valueAt(i2);
            arrayList.add(tabData2);
            r(keyAt);
        }
        f fVar = new f(this, this.o, this.x);
        this.k = fVar;
        fVar.notifyDataSetChanged();
        this.j.setAdapter(this.k);
        this.j.setOffscreenPageLimit(arrayList.size());
        this.p = 0;
        this.f61333i.setViewPager(this.j);
        this.f61333i.setData(arrayList);
    }

    public void q() {
        this.k.c();
    }

    public final void r(int i2) {
        StatisticItem statisticItem = new StatisticItem(CommonStatisticKey.KEY_LIVE_SECOND_TAB_SHOW);
        statisticItem.param("obj_type", i2 - this.r);
        TiebaStaticHelper.addYYParam(statisticItem);
        TiebaStatic.log(statisticItem);
    }

    public void s(boolean z) {
        d.a.k0.t.d.c.h.d dVar = this.f61332h;
        if (dVar != null) {
            dVar.v(z);
        }
    }

    public void t() {
        int skinType = TbadkCoreApplication.getInst().getSkinType();
        this.f61332h.n(this.f61325a, skinType);
        this.f61333i.onChangeSkinType(skinType);
        SkinManager.setBackgroundColor(this.f61327c, R.color.CAM_X0202);
        SkinManager.setBackgroundColor(this.f61333i, R.color.CAM_X0202);
    }

    public void u(boolean z) {
        int i2;
        if (!z || (i2 = this.p) == -1) {
            return;
        }
        y(i2);
        this.p = -1;
    }

    public void v() {
        this.k.e(this.j.getCurrentItem());
    }

    public final void w() {
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
        f fVar = this.k;
        if (fVar != null) {
            fVar.notifyDataSetChanged();
        }
    }

    public void x(boolean z) {
        this.f61328d.setVisibility(z ? 0 : 8);
    }

    public void y(int i2) {
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

    public void z(h hVar) {
        i iVar = new i();
        iVar.f61226e = hVar;
        this.f61332h.m(iVar);
        this.f61330f.setVisibility(0);
    }
}
