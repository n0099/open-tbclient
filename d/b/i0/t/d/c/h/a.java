package d.b.i0.t.d.c.h;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.ala.data.TabData;
import com.baidu.ala.view.ScrollHorizontalTabView;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.widget.NestedNoScrollViewPager;
import com.baidu.tieba.R;
import com.baidu.tieba.ala.alasquare.live_tab.fragment.LiveTabBaseSubFragment;
import com.baidu.tieba.ala.alasquare.live_tab.fragment.LiveTabFriendSubFragment;
import com.baidu.tieba.ala.alasquare.live_tab.fragment.LiveTabGameSubFragment;
import com.baidu.tieba.ala.alasquare.live_tab.fragment.LiveTabRecomSubFragment;
import com.baidu.tieba.ala.alasquare.live_tab.fragment.LiveTabYanzhiSubFragment;
import com.google.android.material.appbar.AppBarLayout;
import d.b.i0.t.d.c.e.i;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes4.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    public TbPageContext f60432a;

    /* renamed from: b  reason: collision with root package name */
    public Context f60433b;

    /* renamed from: c  reason: collision with root package name */
    public ViewGroup f60434c;

    /* renamed from: d  reason: collision with root package name */
    public ViewGroup f60435d;

    /* renamed from: e  reason: collision with root package name */
    public AppBarLayout f60436e;

    /* renamed from: f  reason: collision with root package name */
    public LinearLayout f60437f;

    /* renamed from: g  reason: collision with root package name */
    public FrameLayout f60438g;

    /* renamed from: h  reason: collision with root package name */
    public d.b.i0.t.d.c.h.d f60439h;
    public ScrollHorizontalTabView i;
    public NestedNoScrollViewPager j;
    public e k;
    public boolean m;
    public int n;
    public FragmentManager o;
    public boolean l = false;
    public int p = -1;
    public CustomMessageListener q = new C1545a(2921442);
    public CustomMessageListener r = new d(2921414);

    /* renamed from: d.b.i0.t.d.c.h.a$a  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public class C1545a extends CustomMessageListener {
        public C1545a(int i) {
            super(i);
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
    public class b implements AppBarLayout.OnOffsetChangedListener {
        public b() {
        }

        @Override // com.google.android.material.appbar.AppBarLayout.OnOffsetChangedListener, com.google.android.material.appbar.AppBarLayout.BaseOnOffsetChangedListener
        public void onOffsetChanged(AppBarLayout appBarLayout, int i) {
            if (i == 0 || i == a.this.n) {
                return;
            }
            if (i - a.this.n <= -4 && !a.this.l) {
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921441, Boolean.FALSE));
                a.this.l = true;
            }
            a.this.n = i;
        }
    }

    /* loaded from: classes4.dex */
    public class c implements ScrollHorizontalTabView.ScrollTabPageListener {
        public c(a aVar) {
        }

        @Override // com.baidu.ala.view.ScrollHorizontalTabView.ScrollTabPageListener
        public void onPageScrolled(int i, float f2, int i2) {
        }

        @Override // com.baidu.ala.view.ScrollHorizontalTabView.ScrollTabPageListener
        public void onPageSelected(int i, TabData tabData) {
        }

        @Override // com.baidu.ala.view.ScrollHorizontalTabView.ScrollTabPageListener
        public boolean onPrePageSelect(int i, TabData tabData) {
            return true;
        }
    }

    /* loaded from: classes4.dex */
    public class d extends CustomMessageListener {

        /* renamed from: d.b.i0.t.d.c.h.a$d$a  reason: collision with other inner class name */
        /* loaded from: classes4.dex */
        public class RunnableC1546a implements Runnable {
            public RunnableC1546a() {
            }

            @Override // java.lang.Runnable
            public void run() {
                if (a.this.k != null) {
                    a.this.k.k();
                }
            }
        }

        public d(int i) {
            super(i);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            d.b.b.e.m.e.a().postDelayed(new RunnableC1546a(), 500L);
        }
    }

    /* loaded from: classes4.dex */
    public class e extends FragmentPagerAdapter {

        /* renamed from: a  reason: collision with root package name */
        public List<LiveTabBaseSubFragment> f60444a;

        public e(a aVar, FragmentManager fragmentManager, boolean z, boolean z2) {
            super(fragmentManager);
            ArrayList arrayList = new ArrayList();
            this.f60444a = arrayList;
            arrayList.add(LiveTabRecomSubFragment.R0(aVar.m));
            this.f60444a.add(LiveTabYanzhiSubFragment.S0(aVar.m));
            if (z2) {
                this.f60444a.add(LiveTabFriendSubFragment.W0(aVar.m));
            }
            if (z) {
                this.f60444a.add(LiveTabGameSubFragment.S0(aVar.m));
            }
        }

        @Override // androidx.viewpager.widget.PagerAdapter
        public int getCount() {
            List<LiveTabBaseSubFragment> list = this.f60444a;
            if (list != null) {
                return list.size();
            }
            return 0;
        }

        @Override // androidx.fragment.app.FragmentPagerAdapter
        public Fragment getItem(int i) {
            return i(i);
        }

        public final LiveTabBaseSubFragment i(int i) {
            if (i < this.f60444a.size()) {
                return this.f60444a.get(i);
            }
            return null;
        }

        public void j() {
            if (ListUtils.isEmpty(this.f60444a)) {
                return;
            }
            for (int i = 0; i < this.f60444a.size(); i++) {
                LiveTabBaseSubFragment liveTabBaseSubFragment = this.f60444a.get(i);
                if (liveTabBaseSubFragment != null) {
                    liveTabBaseSubFragment.loadData();
                }
            }
        }

        public void k() {
            if (ListUtils.isEmpty(this.f60444a)) {
                return;
            }
            for (int i = 0; i < this.f60444a.size(); i++) {
                LiveTabBaseSubFragment liveTabBaseSubFragment = this.f60444a.get(i);
                if (liveTabBaseSubFragment != null) {
                    liveTabBaseSubFragment.H0();
                }
            }
        }

        public void l(int i) {
            if (i < 0 || i >= this.f60444a.size()) {
                return;
            }
            this.f60444a.get(i).w();
        }
    }

    public a(TbPageContext tbPageContext, FragmentManager fragmentManager, boolean z) {
        this.f60432a = tbPageContext;
        this.m = z;
        this.f60433b = tbPageContext.getPageActivity();
        this.o = fragmentManager;
        l();
    }

    public void g() {
        MessageManager.getInstance().unRegisterListener(this.r);
        MessageManager.getInstance().unRegisterListener(this.q);
    }

    public final List<TabData> h(boolean z, boolean z2) {
        ArrayList arrayList = new ArrayList();
        TabData tabData = new TabData();
        tabData.tabId = 100;
        tabData.tabName = this.f60433b.getResources().getString(R.string.special_recommend_tab_title);
        arrayList.add(tabData);
        TabData tabData2 = new TabData();
        tabData2.tabId = 200;
        tabData2.tabName = this.f60433b.getResources().getString(R.string.special_yanzhi_tab_title);
        arrayList.add(tabData2);
        if (z2) {
            TabData tabData3 = new TabData();
            tabData3.tabId = 400;
            tabData3.tabName = this.f60433b.getResources().getString(R.string.special_friend_tab_title);
            arrayList.add(tabData3);
        }
        if (z) {
            TabData tabData4 = new TabData();
            tabData4.tabId = 300;
            tabData4.tabName = this.f60433b.getResources().getString(R.string.special_game_tab_title);
            arrayList.add(tabData4);
        }
        return arrayList;
    }

    public ViewGroup i() {
        return this.f60434c;
    }

    public void j() {
        this.r.setTag(this.f60432a.getUniqueId());
        MessageManager.getInstance().registerListener(this.r);
        MessageManager.getInstance().registerListener(this.q);
    }

    public void k(boolean z) {
        boolean z2 = d.b.h0.r.d0.b.i().j("key_show_ala_friend_tab", 0) == 1;
        int i = z ? 2 : 1;
        if (z2) {
            i++;
        }
        this.j.setOffscreenPageLimit(i);
        e eVar = new e(this, this.o, z, z2);
        this.k = eVar;
        this.j.setAdapter(eVar);
        TbPageContext tbPageContext = this.f60432a;
        if (tbPageContext != null && tbPageContext.getPageActivity() != null && this.f60432a.getPageActivity().getIntent() != null) {
            int intExtra = this.f60432a.getPageActivity().getIntent().getIntExtra("locate_type", 0);
            if (intExtra == 17) {
                this.p = 0;
            } else if (intExtra == 19) {
                this.p = 2;
            } else if (intExtra == 18) {
                this.p = 1;
            }
        }
        this.i.setViewPager(this.j);
        this.i.setScrollTabPageListener(new c(this));
        this.i.setData(h(z, z2));
    }

    public final void l() {
        ViewGroup viewGroup = (ViewGroup) LayoutInflater.from(this.f60433b).inflate(R.layout.ala_live_tab_layout, (ViewGroup) null);
        this.f60434c = viewGroup;
        AppBarLayout appBarLayout = (AppBarLayout) viewGroup.findViewById(R.id.live_tab_appbar_layout);
        this.f60436e = appBarLayout;
        appBarLayout.addOnOffsetChangedListener((AppBarLayout.OnOffsetChangedListener) new b());
        this.f60435d = (ViewGroup) this.f60434c.findViewById(R.id.live_tab_root_container);
        this.f60437f = (LinearLayout) this.f60434c.findViewById(R.id.live_tab_base_container);
        this.f60438g = (FrameLayout) this.f60434c.findViewById(R.id.super_entrance_container);
        this.i = (ScrollHorizontalTabView) this.f60434c.findViewById(R.id.live_tab_top_tab_layout);
        this.f60439h = new d.b.i0.t.d.c.h.d(this.f60432a);
        this.j = (NestedNoScrollViewPager) this.f60434c.findViewById(R.id.live_tab_view_pager);
        k(d.b.h0.r.d0.b.i().j("chushou_game_tab", 1) == 1);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, this.f60433b.getResources().getDimensionPixelSize(R.dimen.tbds256));
        if (this.f60439h.m() != null && this.f60439h.m().getParent() == null) {
            this.f60438g.addView(this.f60439h.m(), layoutParams);
            this.f60437f.setVisibility(8);
        }
        ((FrameLayout.LayoutParams) this.f60435d.getLayoutParams()).bottomMargin = TbadkCoreApplication.getInst().getMainTabBottomBarHeight();
        o();
    }

    public void m() {
        this.k.j();
    }

    public void n(boolean z) {
        d.b.i0.t.d.c.h.d dVar = this.f60439h;
        if (dVar != null) {
            dVar.x(z);
        }
    }

    public void o() {
        int skinType = TbadkCoreApplication.getInst().getSkinType();
        this.f60439h.o(this.f60432a, skinType);
        this.i.onChangeSkinType(skinType);
        SkinManager.setBackgroundColor(this.f60434c, R.color.CAM_X0201);
        SkinManager.setBackgroundColor(this.i, R.color.CAM_X0201);
    }

    public void p(boolean z) {
        int i;
        if (!z || (i = this.p) == -1) {
            return;
        }
        s(i);
        this.p = -1;
    }

    public void q() {
        this.k.l(this.j.getCurrentItem());
    }

    public void r(boolean z) {
        this.f60435d.setVisibility(z ? 0 : 8);
    }

    public void s(int i) {
        int i2 = 0;
        if (i <= 0) {
            i = 0;
        }
        e eVar = this.k;
        if (eVar == null || i < eVar.getCount()) {
            i2 = i;
        }
        NestedNoScrollViewPager nestedNoScrollViewPager = this.j;
        if (nestedNoScrollViewPager != null) {
            nestedNoScrollViewPager.setCurrentItem(i2);
        }
    }

    public void t(d.b.i0.t.d.c.e.h hVar) {
        i iVar = new i();
        iVar.f60338e = hVar;
        this.f60439h.n(iVar);
        this.f60437f.setVisibility(0);
    }
}
