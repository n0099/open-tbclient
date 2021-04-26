package d.a.j0.q0.a2;

import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.widget.ListView.BdTypeRecyclerView;
import com.baidu.swan.apps.core.prefetch.PrefetchEvent;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.FacePackageDetailActivityConfig;
import com.baidu.tbadk.core.atomData.FrsActivityConfig;
import com.baidu.tbadk.core.atomData.PbActivityConfig;
import com.baidu.tbadk.core.data.AdvertAppInfo;
import com.baidu.tbadk.core.data.ForumData;
import com.baidu.tbadk.core.data.UserData;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.StringHelper;
import com.baidu.tbadk.core.util.TbPatternsCompat;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.UrlManager;
import com.baidu.tbadk.core.util.UrlSchemaHelper;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.view.PbListView;
import com.baidu.tbadk.core.view.UserPhotoLayout;
import com.baidu.tbadk.core.view.commonBtn.TBSpecificationBtn;
import com.baidu.tbadk.coreExtra.view.BannerView;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
import com.baidu.tieba.frs.good.FrsGoodFragment;
import com.baidu.tieba.frs.tab.TabData;
import com.baidu.tieba.tbadkCore.FrsCommonImageLayout;
import com.baidu.tieba.tbadkCore.FrsViewData;
import com.baidu.tieba.tbadkCore.voice.PlayVoiceBnt;
import com.google.android.material.tabs.TabLayout;
import d.a.c.e.p.k;
import d.a.c.e.p.l;
import d.a.c.j.e.n;
import d.a.c.j.e.w;
import d.a.i0.r.q.a2;
import d.a.i0.r.q.f0;
import d.a.i0.r.q.l0;
import d.a.i0.r.q.z1;
import d.a.j0.q0.a0;
import d.a.j0.q0.t;
import d.a.j0.q0.u;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import tbclient.ThemeColorInfo;
import tbclient.ThemeElement;
/* loaded from: classes4.dex */
public class a implements TabLayout.OnTabSelectedListener {
    public static final Pattern u = Pattern.compile("(/p/){1}(\\d+)");

    /* renamed from: a  reason: collision with root package name */
    public FrsGoodFragment f57484a;

    /* renamed from: d  reason: collision with root package name */
    public FrameLayout f57487d;

    /* renamed from: e  reason: collision with root package name */
    public TabLayout f57488e;

    /* renamed from: f  reason: collision with root package name */
    public TabLayout f57489f;

    /* renamed from: g  reason: collision with root package name */
    public PbListView f57490g;

    /* renamed from: h  reason: collision with root package name */
    public d.a.j0.q0.a2.b f57491h;
    public f0 j;
    public ThemeColorInfo k;
    public String l;
    public final int p;
    public int q;

    /* renamed from: b  reason: collision with root package name */
    public RelativeLayout f57485b = null;

    /* renamed from: c  reason: collision with root package name */
    public BdTypeRecyclerView f57486c = null;

    /* renamed from: i  reason: collision with root package name */
    public BannerView f57492i = null;
    public boolean m = false;
    public boolean n = false;
    public int o = 0;
    public View.OnClickListener r = new View$OnClickListenerC1400a();
    public BannerView.b s = new d();
    public CustomMessageListener t = new g(2016331);

    /* renamed from: d.a.j0.q0.a2.a$a  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public class View$OnClickListenerC1400a implements View.OnClickListener {
        public View$OnClickListenerC1400a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (a.this.f57484a != null) {
                a.this.f57484a.onScrollToBottom();
            }
        }
    }

    /* loaded from: classes4.dex */
    public class b implements RecyclerView.RecyclerListener {
        public b(a aVar) {
        }

        @Override // androidx.recyclerview.widget.RecyclerView.RecyclerListener
        public void onViewRecycled(RecyclerView.ViewHolder viewHolder) {
            View view = viewHolder.itemView;
            if (view != null) {
                PlayVoiceBnt playVoiceBnt = (PlayVoiceBnt) view.findViewById(R.id.abstract_voice);
                if (playVoiceBnt != null) {
                    playVoiceBnt.h();
                }
                FrsCommonImageLayout frsCommonImageLayout = (FrsCommonImageLayout) view.findViewById(R.id.abstract_img_layout);
                if (frsCommonImageLayout != null) {
                    frsCommonImageLayout.p();
                }
                if (view instanceof UserPhotoLayout) {
                    ((UserPhotoLayout) view).reset();
                }
            }
        }
    }

    /* loaded from: classes4.dex */
    public class c implements TbImageView.f {
        public c() {
        }

        @Override // com.baidu.tbadk.widget.TbImageView.f
        public void a(String str, boolean z) {
            if (!z || !a.this.f57492i.i() || a.this.m || a.this.f57486c == null) {
                return;
            }
            a.this.m = true;
            a.this.f57486c.t(a.this.f57492i, 1);
        }

        @Override // com.baidu.tbadk.widget.TbImageView.f
        public void onCancel() {
        }
    }

    /* loaded from: classes4.dex */
    public class d implements BannerView.b {
        public d() {
        }

        @Override // com.baidu.tbadk.coreExtra.view.BannerView.b
        public void a() {
            a.this.C();
        }

        @Override // com.baidu.tbadk.coreExtra.view.BannerView.b
        public void b() {
            a.this.l();
        }
    }

    /* loaded from: classes4.dex */
    public class e implements TabLayout.OnTabSelectedListener {
        public e() {
        }

        @Override // com.google.android.material.tabs.TabLayout.BaseOnTabSelectedListener
        public void onTabReselected(TabLayout.Tab tab) {
        }

        @Override // com.google.android.material.tabs.TabLayout.BaseOnTabSelectedListener
        public void onTabSelected(TabLayout.Tab tab) {
            if (tab != null) {
                if (tab.getTag() instanceof Integer) {
                    int intValue = ((Integer) tab.getTag()).intValue();
                    a aVar = a.this;
                    aVar.G(intValue, aVar.f57488e, true);
                }
                a.this.P(tab);
            }
        }

        @Override // com.google.android.material.tabs.TabLayout.BaseOnTabSelectedListener
        public void onTabUnselected(TabLayout.Tab tab) {
            a.this.a0();
            a.this.Q(tab);
        }
    }

    /* loaded from: classes4.dex */
    public class f implements Runnable {
        public f() {
        }

        @Override // java.lang.Runnable
        public void run() {
            a.this.m().p();
        }
    }

    /* loaded from: classes4.dex */
    public class g extends CustomMessageListener {
        public g(int i2) {
            super(i2);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage == null || !(customResponsedMessage.getData() instanceof String)) {
                return;
            }
            String str = (String) customResponsedMessage.getData();
            a.this.E(str);
            a.this.D(str);
            a.this.f57491h.t();
        }
    }

    /* loaded from: classes4.dex */
    public static /* synthetic */ class h {

        /* renamed from: a  reason: collision with root package name */
        public static final /* synthetic */ int[] f57499a;

        static {
            int[] iArr = new int[UtilHelper.NativePageType.values().length];
            f57499a = iArr;
            try {
                iArr[UtilHelper.NativePageType.FRS.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f57499a[UtilHelper.NativePageType.PB.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
        }
    }

    public a(FrsGoodFragment frsGoodFragment, View view, boolean z) {
        this.f57484a = null;
        this.f57484a = frsGoodFragment;
        u(view, z);
        this.p = l.g(this.f57484a.getPageContext().getPageActivity(), R.dimen.tbds75);
        this.q = l.g(this.f57484a.getPageContext().getPageActivity(), R.dimen.M_W_X006);
    }

    public void A() {
        d.a.j0.q0.a2.b bVar = this.f57491h;
        if (bVar != null) {
            bVar.p();
        }
    }

    public final void B(TabLayout tabLayout) {
        if (tabLayout != null) {
            tabLayout.removeAllTabs();
        }
    }

    public void C() {
        BannerView bannerView = this.f57492i;
        if (bannerView != null) {
            this.m = false;
            this.f57486c.removeHeaderView(bannerView);
        }
    }

    public void D(String str) {
        if (this.f57484a.i1() != null) {
            this.f57484a.i1().E(str);
        }
    }

    public void E(String str) {
        if (StringUtils.isNull(str) || ListUtils.isEmpty(this.f57491h.l())) {
            return;
        }
        Iterator<n> it = this.f57491h.m().iterator();
        while (it.hasNext()) {
            n next = it.next();
            if (next instanceof d.a.j0.e.c) {
                d.a.j0.e.c cVar = (d.a.j0.e.c) next;
                if ((cVar.c() instanceof AdvertAppInfo) && str.equals(((AdvertAppInfo) cVar.c()).E3)) {
                    it.remove();
                }
            }
        }
    }

    public void F() {
        u uVar = new u();
        uVar.f58778a = 301;
        uVar.f58779b = false;
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921449, uVar));
    }

    public final void G(int i2, TabLayout tabLayout, boolean z) {
        if (tabLayout == null) {
            return;
        }
        for (int i3 = 0; i3 < tabLayout.getTabCount(); i3++) {
            TabLayout.Tab tabAt = tabLayout.getTabAt(i3);
            if (tabAt != null && (tabAt.getTag() instanceof Integer)) {
                if (((Integer) tabAt.getTag()).intValue() == i2) {
                    if (z) {
                        tabAt.select();
                    } else {
                        tabLayout.setScrollPosition(i3, 0.0f, true);
                        P(tabAt);
                    }
                } else if (!z) {
                    Q(tabAt);
                }
            }
        }
    }

    public void H() {
        this.f57491h.q();
    }

    public void I(boolean z) {
        if (z) {
            return;
        }
        u uVar = new u();
        uVar.f58778a = 301;
        uVar.f58779b = false;
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921449, uVar));
    }

    public void J(boolean z) {
        this.f57487d.setVisibility(z ? 0 : 8);
        V(z);
    }

    public void K(int i2) {
        this.f57486c.setSelection(i2);
    }

    public void L(w wVar) {
        this.f57491h.B(wVar);
    }

    public void M(RecyclerView.OnScrollListener onScrollListener) {
        this.f57486c.setOnScrollListener(onScrollListener);
    }

    public void N(boolean z) {
        a0 a0Var = new a0();
        a0Var.f57480a = 301;
        a0Var.f57482c = z;
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(9205410, a0Var));
    }

    public void O(FrsViewData frsViewData) {
        if (frsViewData == null || frsViewData.getForum() == null || frsViewData.getForum().getGood_classify() == null) {
            return;
        }
        ArrayList<l0> good_classify = frsViewData.getForum().getGood_classify();
        TabData tabData = new TabData();
        d.a.j0.q0.k2.d dVar = new d.a.j0.q0.k2.d();
        dVar.f57927b = 0;
        dVar.f57926a = this.f57484a.getPageContext().getResources().getString(R.string.all);
        tabData.add(dVar);
        for (l0 l0Var : good_classify) {
            if (l0Var != null && l0Var.a() > 0 && !TextUtils.isEmpty(l0Var.b()) && !TextUtils.isEmpty(l0Var.b().trim())) {
                d.a.j0.q0.k2.d dVar2 = new d.a.j0.q0.k2.d();
                dVar2.f57927b = l0Var.a();
                dVar2.f57926a = l0Var.b();
                tabData.add(dVar2);
            }
        }
        if (ListUtils.getCount(tabData) <= 1) {
            return;
        }
        t();
        this.n = true;
        R(tabData, this.f57488e);
        R(tabData, this.f57489f);
    }

    public final void P(TabLayout.Tab tab) {
        if (tab.getCustomView() != null) {
            d.a.i0.r.f0.m.c cVar = (d.a.i0.r.f0.m.c) ((TBSpecificationBtn) tab.getCustomView()).getStyleConfig();
            if (k.isEmpty(this.l)) {
                cVar.q(R.color.CAM_X0105);
            } else {
                cVar.p(d.a.j0.j1.o.k.b.b(this.l));
            }
        }
    }

    public final void Q(TabLayout.Tab tab) {
        if (tab == null || tab.getCustomView() == null) {
            return;
        }
        ((d.a.i0.r.f0.m.c) ((TBSpecificationBtn) tab.getCustomView()).getStyleConfig()).q(R.color.CAM_X0108);
    }

    public final void R(TabData tabData, TabLayout tabLayout) {
        int min = Math.min(tabData.size(), 9);
        if (tabLayout.getTabCount() > min) {
            int tabCount = tabLayout.getTabCount() - min;
            for (int i2 = 0; i2 < tabCount; i2++) {
                tabLayout.removeTabAt(0);
            }
        }
        LinearLayout linearLayout = (LinearLayout) tabLayout.getChildAt(0);
        if (linearLayout == null) {
            return;
        }
        for (int i3 = 0; i3 < min; i3++) {
            TabLayout.Tab tabAt = tabLayout.getTabAt(i3);
            if (tabAt == null) {
                tabAt = tabLayout.newTab();
                tabLayout.addTab(tabAt, false);
                if (linearLayout.getChildAt(i3) != null) {
                    linearLayout.getChildAt(i3).setPadding(0, 0, 0, 0);
                }
            }
            if (!(tabAt.getCustomView() instanceof TBSpecificationBtn)) {
                TBSpecificationBtn tBSpecificationBtn = new TBSpecificationBtn(this.f57484a.getContext());
                d.a.i0.r.f0.m.c cVar = new d.a.i0.r.f0.m.c();
                cVar.q(R.color.CAM_X0108);
                tBSpecificationBtn.setConfig(cVar);
                LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, this.p);
                int i4 = this.q;
                layoutParams.setMargins(i4 / 2, 0, i4 / 2, 0);
                tBSpecificationBtn.setLayoutParams(layoutParams);
                tabAt.setCustomView(tBSpecificationBtn);
            }
            ((TBSpecificationBtn) tabAt.getCustomView()).setText(StringHelper.cutForumNameWithSuffix(tabData.get(i3).f57926a, 10, StringHelper.STRING_MORE));
            tabAt.setTag(Integer.valueOf(tabData.get(i3).f57927b));
            if (tabData.get(i3).f57927b == this.o) {
                tabAt.select();
            }
        }
    }

    public void S(ThemeColorInfo themeColorInfo) {
        ThemeElement themeElement;
        if (themeColorInfo == null || themeColorInfo.day == null || themeColorInfo.night == null || themeColorInfo.dark == null) {
            return;
        }
        this.k = themeColorInfo;
        int skinType = TbadkCoreApplication.getInst().getSkinType();
        if (skinType == 4) {
            themeElement = this.k.dark;
        } else if (skinType == 1) {
            themeElement = this.k.night;
        } else {
            themeElement = this.k.day;
        }
        if (k.isEmpty(themeElement.font_color)) {
            return;
        }
        this.l = themeElement.font_color;
    }

    public void T(ArrayList<n> arrayList, int i2, FrsViewData frsViewData, int i3) {
        if (arrayList == null || arrayList.size() <= 0) {
            t tVar = new t();
            ArrayList<n> arrayList2 = new ArrayList<>();
            arrayList2.add(tVar);
            arrayList = arrayList2;
        }
        this.f57491h.w(arrayList, frsViewData);
        this.n = false;
    }

    public void U() {
        this.f57486c.setNextPage(this.f57490g);
        this.f57490g.J(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
        this.f57490g.z(this.r);
        this.f57490g.f();
        this.f57490g.A(this.f57484a.getResources().getString(R.string.list_click_load_more));
    }

    public final void V(boolean z) {
        if (z) {
            this.f57489f.setVisibility(8);
        } else if (this.f57489f.getTabCount() > 1) {
            this.f57489f.setVisibility(0);
        }
    }

    public void W() {
        this.f57486c.setVisibility(0);
    }

    public void X() {
        this.f57486c.setNextPage(this.f57490g);
        this.f57490g.J(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
        this.f57490g.z(null);
        this.f57490g.O();
    }

    public void Y() {
        this.f57486c.setNextPage(this.f57490g);
        this.f57490g.J(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
        this.f57490g.z(null);
        this.f57490g.f();
        this.f57490g.A(this.f57484a.getResources().getString(R.string.list_has_no_more));
    }

    public void Z() {
        u uVar = new u();
        uVar.f58778a = 301;
        uVar.f58779b = true;
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921449, uVar));
    }

    public void a0() {
        u uVar = new u();
        uVar.f58778a = 301;
        uVar.f58779b = false;
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921449, uVar));
    }

    public final void l() {
        f0 f0Var = this.j;
        if (f0Var == null) {
            return;
        }
        String e2 = f0Var.e();
        if (this.j.a() == 1) {
            MessageManager.getInstance().sendMessage(new CustomMessage(2902014, new FacePackageDetailActivityConfig(this.f57484a.getPageContext().getPageActivity(), e2, false, "frs_banner")));
        } else if (this.j.a() == 2) {
            if (e2.contains(TbPatternsCompat.TB_DOMAIN_NAME)) {
                Matcher matcher = u.matcher(e2);
                if (matcher.find()) {
                    try {
                        String group = matcher.group(2);
                        PbActivityConfig createNormalCfg = new PbActivityConfig(this.f57484a.getPageContext().getPageActivity()).createNormalCfg(group, null, "frs_banner");
                        createNormalCfg.setForumId(group);
                        createNormalCfg.setStartFrom(3);
                        this.f57484a.sendMessage(new CustomMessage(2004001, createNormalCfg));
                    } catch (Exception e3) {
                        BdLog.e(e3.toString());
                    }
                }
            }
        } else if (this.j.a() == 3) {
            new UtilHelper.NativePage();
            UtilHelper.NativePage isNativeAddress = UtilHelper.isNativeAddress(e2);
            UtilHelper.NativePageType nativePageType = isNativeAddress.type;
            if (nativePageType != UtilHelper.NativePageType.NONE) {
                int i2 = h.f57499a[nativePageType.ordinal()];
                if (i2 == 1) {
                    this.f57484a.sendMessage(new CustomMessage(2003000, new FrsActivityConfig(this.f57484a.getPageContext().getPageActivity()).createNormalCfg(isNativeAddress.id, "frs_banner")));
                    return;
                } else if (i2 != 2) {
                    return;
                } else {
                    PbActivityConfig createNormalCfg2 = new PbActivityConfig(this.f57484a.getPageContext().getPageActivity()).createNormalCfg(isNativeAddress.id, null, "frs_banner");
                    createNormalCfg2.setForumId(isNativeAddress.id);
                    createNormalCfg2.setStartFrom(3);
                    this.f57484a.sendMessage(new CustomMessage(2004001, createNormalCfg2));
                    return;
                }
            }
            UrlManager.getInstance().dealOneLink(this.f57484a.getPageContext(), new String[]{e2});
            if (StringUtils.isNull(e2) || !e2.startsWith(UrlSchemaHelper.SCHEMA_TYPE_GAME_DETAIL)) {
                return;
            }
            TiebaStatic.eventStat(this.f57484a.getPageContext().getPageActivity(), "frs_banner", PrefetchEvent.STATE_CLICK, 1, "ref_id", "4000601", "ref_type", "603");
        } else if (this.j.a() == 4) {
            this.f57484a.sendMessage(new CustomMessage(2003000, new FrsActivityConfig(this.f57484a.getPageContext().getPageActivity()).createNormalCfg(e2, "frs_banner")));
        }
    }

    public d.a.j0.q0.a2.b m() {
        return this.f57491h;
    }

    public BdTypeRecyclerView n() {
        return this.f57486c;
    }

    public RelativeLayout o() {
        return this.f57485b;
    }

    @Override // com.google.android.material.tabs.TabLayout.BaseOnTabSelectedListener
    public void onTabReselected(TabLayout.Tab tab) {
        if (tab == null || tab.getCustomView() == null) {
            return;
        }
        if (!this.n && (tab.getTag() instanceof Integer)) {
            int intValue = ((Integer) tab.getTag()).intValue();
            this.o = intValue;
            this.f57484a.o1(intValue);
        }
        P(tab);
    }

    @Override // com.google.android.material.tabs.TabLayout.BaseOnTabSelectedListener
    public void onTabSelected(TabLayout.Tab tab) {
        if (tab != null) {
            if (tab.getTag() instanceof Integer) {
                int intValue = ((Integer) tab.getTag()).intValue();
                d.a.j0.q0.j2.d.J0.f57895e = intValue;
                if (!this.n) {
                    this.o = intValue;
                    G(intValue, this.f57489f, false);
                    this.f57484a.o1(this.o);
                    d.a.j0.x.t.b().e(false);
                    d.a.j0.c3.c.g().h(this.f57484a.getUniqueId(), false);
                }
            }
            P(tab);
        }
    }

    @Override // com.google.android.material.tabs.TabLayout.BaseOnTabSelectedListener
    public void onTabUnselected(TabLayout.Tab tab) {
        a0();
        Q(tab);
    }

    public void p() {
        this.f57486c.setNextPage(null);
    }

    public final void q(f0 f0Var) {
        if (this.f57492i != null) {
            return;
        }
        this.f57492i = new BannerView(this.f57484a.getPageContext().getPageActivity());
        this.f57492i.setLayoutParams(new AbsListView.LayoutParams(-1, this.f57484a.getResources().getDimensionPixelSize(R.dimen.ds100)));
        this.f57492i.setVisibility(8);
        this.f57492i.setBannerViewClickListener(this.s);
        this.f57492i.setBannerData(f0Var);
        this.f57492i.setBannerViewEvent(new c());
    }

    public final void r(View view) {
        TabLayout tabLayout = (TabLayout) view.findViewById(R.id.frs_good_fake_tabview);
        this.f57489f = tabLayout;
        tabLayout.setPadding(UtilHelper.getDimenPixelSize(R.dimen.M_W_X004) - (this.q / 2), 0, UtilHelper.getDimenPixelSize(R.dimen.M_W_X004) - (this.q / 2), 0);
        this.f57489f.setOnTabSelectedListener((TabLayout.OnTabSelectedListener) new e());
    }

    public final void s(TabLayout tabLayout) {
        if (tabLayout != null) {
            for (int i2 = 0; i2 < tabLayout.getTabCount(); i2++) {
                TabLayout.Tab tabAt = tabLayout.getTabAt(i2);
                if (tabAt != null && (tabAt.getCustomView() instanceof TBSpecificationBtn)) {
                    d.a.i0.r.f0.m.c cVar = (d.a.i0.r.f0.m.c) ((TBSpecificationBtn) tabAt.getCustomView()).getStyleConfig();
                    if (!tabAt.isSelected()) {
                        cVar.q(R.color.CAM_X0108);
                    } else if (k.isEmpty(this.l)) {
                        cVar.q(R.color.CAM_X0105);
                    } else {
                        cVar.p(d.a.j0.j1.o.k.b.b(this.l));
                    }
                }
            }
        }
    }

    public final void t() {
        if (this.f57488e == null) {
            TabLayout tabLayout = (TabLayout) LayoutInflater.from(this.f57484a.getContext()).inflate(R.layout.frs_good_second_layout, (ViewGroup) null);
            this.f57488e = tabLayout;
            tabLayout.setPadding(UtilHelper.getDimenPixelSize(R.dimen.M_W_X004) - (this.q / 2), 0, UtilHelper.getDimenPixelSize(R.dimen.M_W_X004) - (this.q / 2), 0);
            this.f57488e.setLayoutParams(new RecyclerView.LayoutParams(-1, l.g(this.f57484a.getContext(), R.dimen.tbds126)));
            this.f57488e.setOnTabSelectedListener((TabLayout.OnTabSelectedListener) this);
            s(this.f57488e);
            this.f57486c.s(this.f57488e);
        }
    }

    public final void u(View view, boolean z) {
        this.f57485b = (RelativeLayout) view.findViewById(R.id.frs_good_container);
        r(view);
        BdTypeRecyclerView bdTypeRecyclerView = (BdTypeRecyclerView) view.findViewById(R.id.frs_good_lv_thread);
        this.f57486c = bdTypeRecyclerView;
        bdTypeRecyclerView.setLayoutManager(new LinearLayoutManager(bdTypeRecyclerView.getContext()));
        this.f57486c.setFadingEdgeLength(0);
        this.f57486c.setOverScrollMode(2);
        this.f57486c.setRecyclerListener(new b(this));
        int dimenPixelSize = UtilHelper.getDimenPixelSize(R.dimen.M_W_X004);
        BdTypeRecyclerView bdTypeRecyclerView2 = this.f57486c;
        bdTypeRecyclerView2.setPadding(dimenPixelSize, bdTypeRecyclerView2.getPaddingTop(), dimenPixelSize, this.f57486c.getPaddingBottom());
        PbListView pbListView = new PbListView(this.f57484a.getPageContext().getPageActivity());
        this.f57490g = pbListView;
        pbListView.a();
        this.f57490g.o(R.color.transparent);
        this.f57490g.r(l.g(this.f57484a.getActivity(), R.dimen.tbds182));
        this.f57490g.v();
        this.f57490g.E(R.dimen.tbfontsize33);
        this.f57490g.C(SkinManager.getColor(R.color.CAM_X0107));
        this.f57490g.y(R.color.CAM_X0110);
        this.f57486c.setOnSrollToBottomListener(this.f57484a);
        this.f57487d = (FrameLayout) view.findViewById(R.id.frs_list_content);
        this.f57491h = new d.a.j0.q0.a2.b(this.f57484a, this.f57486c);
        I(false);
        this.f57484a.registerListener(this.t);
    }

    public void v() {
        d.a.j0.q0.a2.b bVar = this.f57491h;
        if (bVar != null) {
            bVar.p();
        }
    }

    public void w(int i2) {
        d.a.j0.q0.a2.b bVar = this.f57491h;
        if (bVar != null) {
            bVar.D();
            this.f57491h.p();
            this.f57491h.r(i2);
        }
        FrsGoodFragment frsGoodFragment = this.f57484a;
        if (frsGoodFragment != null && frsGoodFragment.getBaseFragmentActivity() == null && this.f57484a.getBaseFragmentActivity().getLayoutMode() != null) {
            this.f57484a.getBaseFragmentActivity().getLayoutMode().k(i2 == 1);
            this.f57484a.getBaseFragmentActivity().getLayoutMode().j(this.f57485b);
        }
        BannerView bannerView = this.f57492i;
        if (bannerView != null) {
            bannerView.j();
        }
        PbListView pbListView = this.f57490g;
        if (pbListView != null) {
            pbListView.C(SkinManager.getColor(R.color.CAM_X0107));
            this.f57490g.d(i2);
        }
        s(this.f57488e);
        s(this.f57489f);
    }

    public void x() {
        this.f57491h.s();
        this.f57486c.setOnSrollToBottomListener(null);
        B(this.f57488e);
        B(this.f57489f);
    }

    public void y() {
        a2 a2Var;
        if (m() == null) {
            return;
        }
        List<n> l = m().l();
        if (ListUtils.isEmpty(l)) {
            return;
        }
        for (n nVar : l) {
            if (nVar instanceof z1) {
                z1 z1Var = (z1) nVar;
                if (z1Var.x != 0 && (a2Var = z1Var.w) != null) {
                    int[] p0 = a2Var.p0();
                    z1Var.x = p0[0];
                    z1Var.y = p0[1];
                }
            }
        }
        d.a.c.e.m.e.a().postDelayed(new f(), 500L);
    }

    public void z(ForumData forumData, UserData userData) {
        if (this.m || forumData == null || forumData.getFrsBannerData() == null || !forumData.getFrsBannerData().f()) {
            return;
        }
        f0 frsBannerData = forumData.getFrsBannerData();
        this.j = frsBannerData;
        q(frsBannerData);
        this.f57492i.k();
        this.f57486c.removeHeaderView(this.f57492i);
        if (this.j.d() != 1 || TextUtils.isEmpty(this.j.b())) {
            return;
        }
        this.f57492i.setData(this.f57484a.getPageContext(), this.j.b());
        if (this.j.e().startsWith(UrlSchemaHelper.SCHEMA_TYPE_GAME_DETAIL)) {
            TiebaStatic.eventStat(this.f57484a.getPageContext().getPageActivity(), "game_show", "show", 1, "ref_id", "4000601", "ref_type", "603");
        }
    }
}
