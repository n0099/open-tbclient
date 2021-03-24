package d.b.i0.p0.a2;

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
import d.b.b.e.p.k;
import d.b.b.e.p.l;
import d.b.b.j.e.n;
import d.b.b.j.e.w;
import d.b.h0.r.q.a2;
import d.b.h0.r.q.f0;
import d.b.h0.r.q.l0;
import d.b.h0.r.q.z1;
import d.b.i0.p0.a0;
import d.b.i0.p0.t;
import d.b.i0.p0.u;
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
    public FrsGoodFragment f57324a;

    /* renamed from: d  reason: collision with root package name */
    public FrameLayout f57327d;

    /* renamed from: e  reason: collision with root package name */
    public TabLayout f57328e;

    /* renamed from: f  reason: collision with root package name */
    public TabLayout f57329f;

    /* renamed from: g  reason: collision with root package name */
    public PbListView f57330g;

    /* renamed from: h  reason: collision with root package name */
    public d.b.i0.p0.a2.b f57331h;
    public f0 j;
    public ThemeColorInfo k;
    public String l;
    public final int p;
    public int q;

    /* renamed from: b  reason: collision with root package name */
    public RelativeLayout f57325b = null;

    /* renamed from: c  reason: collision with root package name */
    public BdTypeRecyclerView f57326c = null;
    public BannerView i = null;
    public boolean m = false;
    public boolean n = false;
    public int o = 0;
    public View.OnClickListener r = new View$OnClickListenerC1375a();
    public BannerView.b s = new d();
    public CustomMessageListener t = new g(2016331);

    /* renamed from: d.b.i0.p0.a2.a$a  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public class View$OnClickListenerC1375a implements View.OnClickListener {
        public View$OnClickListenerC1375a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (a.this.f57324a != null) {
                a.this.f57324a.onScrollToBottom();
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
                    playVoiceBnt.l();
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
            if (!z || !a.this.i.i() || a.this.m || a.this.f57326c == null) {
                return;
            }
            a.this.m = true;
            a.this.f57326c.t(a.this.i, 1);
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
                    aVar.G(intValue, aVar.f57328e, true);
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
        public g(int i) {
            super(i);
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
            a.this.f57331h.t();
        }
    }

    /* loaded from: classes4.dex */
    public static /* synthetic */ class h {

        /* renamed from: a  reason: collision with root package name */
        public static final /* synthetic */ int[] f57338a;

        static {
            int[] iArr = new int[UtilHelper.NativePageType.values().length];
            f57338a = iArr;
            try {
                iArr[UtilHelper.NativePageType.FRS.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f57338a[UtilHelper.NativePageType.PB.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
        }
    }

    public a(FrsGoodFragment frsGoodFragment, View view, boolean z) {
        this.f57324a = null;
        this.f57324a = frsGoodFragment;
        u(view, z);
        this.p = l.g(this.f57324a.getPageContext().getPageActivity(), R.dimen.tbds75);
        this.q = l.g(this.f57324a.getPageContext().getPageActivity(), R.dimen.M_W_X006);
    }

    public void A() {
        d.b.i0.p0.a2.b bVar = this.f57331h;
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
        BannerView bannerView = this.i;
        if (bannerView != null) {
            this.m = false;
            this.f57326c.removeHeaderView(bannerView);
        }
    }

    public void D(String str) {
        if (this.f57324a.i1() != null) {
            this.f57324a.i1().E(str);
        }
    }

    public void E(String str) {
        if (StringUtils.isNull(str) || ListUtils.isEmpty(this.f57331h.l())) {
            return;
        }
        Iterator<n> it = this.f57331h.m().iterator();
        while (it.hasNext()) {
            n next = it.next();
            if (next instanceof d.b.i0.e.c) {
                d.b.i0.e.c cVar = (d.b.i0.e.c) next;
                if ((cVar.a() instanceof AdvertAppInfo) && str.equals(((AdvertAppInfo) cVar.a()).E3)) {
                    it.remove();
                }
            }
        }
    }

    public void F() {
        u uVar = new u();
        uVar.f58581a = 301;
        uVar.f58582b = false;
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921449, uVar));
    }

    public final void G(int i, TabLayout tabLayout, boolean z) {
        if (tabLayout == null) {
            return;
        }
        for (int i2 = 0; i2 < tabLayout.getTabCount(); i2++) {
            TabLayout.Tab tabAt = tabLayout.getTabAt(i2);
            if (tabAt != null && (tabAt.getTag() instanceof Integer)) {
                if (((Integer) tabAt.getTag()).intValue() == i) {
                    if (z) {
                        tabAt.select();
                    } else {
                        tabLayout.setScrollPosition(i2, 0.0f, true);
                        P(tabAt);
                    }
                } else if (!z) {
                    Q(tabAt);
                }
            }
        }
    }

    public void H() {
        this.f57331h.q();
    }

    public void I(boolean z) {
        if (z) {
            return;
        }
        u uVar = new u();
        uVar.f58581a = 301;
        uVar.f58582b = false;
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921449, uVar));
    }

    public void J(boolean z) {
        this.f57327d.setVisibility(z ? 0 : 8);
        V(z);
    }

    public void K(int i) {
        this.f57326c.setSelection(i);
    }

    public void L(w wVar) {
        this.f57331h.B(wVar);
    }

    public void M(RecyclerView.OnScrollListener onScrollListener) {
        this.f57326c.setOnScrollListener(onScrollListener);
    }

    public void N(boolean z) {
        a0 a0Var = new a0();
        a0Var.f57320a = 301;
        a0Var.f57322c = z;
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(9205410, a0Var));
    }

    public void O(FrsViewData frsViewData) {
        if (frsViewData == null || frsViewData.getForum() == null || frsViewData.getForum().getGood_classify() == null) {
            return;
        }
        ArrayList<l0> good_classify = frsViewData.getForum().getGood_classify();
        TabData tabData = new TabData();
        d.b.i0.p0.k2.d dVar = new d.b.i0.p0.k2.d();
        dVar.f57735b = 0;
        dVar.f57734a = this.f57324a.getPageContext().getResources().getString(R.string.all);
        tabData.add(dVar);
        for (l0 l0Var : good_classify) {
            if (l0Var != null && l0Var.a() > 0 && !TextUtils.isEmpty(l0Var.b()) && !TextUtils.isEmpty(l0Var.b().trim())) {
                d.b.i0.p0.k2.d dVar2 = new d.b.i0.p0.k2.d();
                dVar2.f57735b = l0Var.a();
                dVar2.f57734a = l0Var.b();
                tabData.add(dVar2);
            }
        }
        if (ListUtils.getCount(tabData) <= 1) {
            return;
        }
        t();
        this.n = true;
        R(tabData, this.f57328e);
        R(tabData, this.f57329f);
    }

    public final void P(TabLayout.Tab tab) {
        if (tab.getCustomView() != null) {
            d.b.h0.r.f0.m.c cVar = (d.b.h0.r.f0.m.c) ((TBSpecificationBtn) tab.getCustomView()).getStyleConfig();
            if (k.isEmpty(this.l)) {
                cVar.q(R.color.CAM_X0105);
            } else {
                cVar.p(d.b.i0.i1.o.k.b.b(this.l));
            }
        }
    }

    public final void Q(TabLayout.Tab tab) {
        if (tab == null || tab.getCustomView() == null) {
            return;
        }
        ((d.b.h0.r.f0.m.c) ((TBSpecificationBtn) tab.getCustomView()).getStyleConfig()).q(R.color.CAM_X0108);
    }

    public final void R(TabData tabData, TabLayout tabLayout) {
        int min = Math.min(tabData.size(), 9);
        if (tabLayout.getTabCount() > min) {
            int tabCount = tabLayout.getTabCount() - min;
            for (int i = 0; i < tabCount; i++) {
                tabLayout.removeTabAt(0);
            }
        }
        LinearLayout linearLayout = (LinearLayout) tabLayout.getChildAt(0);
        if (linearLayout == null) {
            return;
        }
        for (int i2 = 0; i2 < min; i2++) {
            TabLayout.Tab tabAt = tabLayout.getTabAt(i2);
            if (tabAt == null) {
                tabAt = tabLayout.newTab();
                tabLayout.addTab(tabAt, false);
                if (linearLayout.getChildAt(i2) != null) {
                    linearLayout.getChildAt(i2).setPadding(0, 0, 0, 0);
                }
            }
            if (!(tabAt.getCustomView() instanceof TBSpecificationBtn)) {
                TBSpecificationBtn tBSpecificationBtn = new TBSpecificationBtn(this.f57324a.getContext());
                d.b.h0.r.f0.m.c cVar = new d.b.h0.r.f0.m.c();
                cVar.q(R.color.CAM_X0108);
                tBSpecificationBtn.setConfig(cVar);
                LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, this.p);
                int i3 = this.q;
                layoutParams.setMargins(i3 / 2, 0, i3 / 2, 0);
                tBSpecificationBtn.setLayoutParams(layoutParams);
                tabAt.setCustomView(tBSpecificationBtn);
            }
            ((TBSpecificationBtn) tabAt.getCustomView()).setText(StringHelper.cutForumNameWithSuffix(tabData.get(i2).f57734a, 10, StringHelper.STRING_MORE));
            tabAt.setTag(Integer.valueOf(tabData.get(i2).f57735b));
            if (tabData.get(i2).f57735b == this.o) {
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

    public void T(ArrayList<n> arrayList, int i, FrsViewData frsViewData, int i2) {
        if (arrayList == null || arrayList.size() <= 0) {
            t tVar = new t();
            ArrayList<n> arrayList2 = new ArrayList<>();
            arrayList2.add(tVar);
            arrayList = arrayList2;
        }
        this.f57331h.w(arrayList, frsViewData);
        this.n = false;
    }

    public void U() {
        this.f57326c.setNextPage(this.f57330g);
        this.f57330g.J(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
        this.f57330g.z(this.r);
        this.f57330g.f();
        this.f57330g.A(this.f57324a.getResources().getString(R.string.list_click_load_more));
    }

    public final void V(boolean z) {
        if (z) {
            this.f57329f.setVisibility(8);
        } else if (this.f57329f.getTabCount() > 1) {
            this.f57329f.setVisibility(0);
        }
    }

    public void W() {
        this.f57326c.setVisibility(0);
    }

    public void X() {
        this.f57326c.setNextPage(this.f57330g);
        this.f57330g.J(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
        this.f57330g.z(null);
        this.f57330g.O();
    }

    public void Y() {
        this.f57326c.setNextPage(this.f57330g);
        this.f57330g.J(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
        this.f57330g.z(null);
        this.f57330g.f();
        this.f57330g.A(this.f57324a.getResources().getString(R.string.list_has_no_more));
    }

    public void Z() {
        u uVar = new u();
        uVar.f58581a = 301;
        uVar.f58582b = true;
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921449, uVar));
    }

    public void a0() {
        u uVar = new u();
        uVar.f58581a = 301;
        uVar.f58582b = false;
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921449, uVar));
    }

    public final void l() {
        f0 f0Var = this.j;
        if (f0Var == null) {
            return;
        }
        String e2 = f0Var.e();
        if (this.j.a() == 1) {
            MessageManager.getInstance().sendMessage(new CustomMessage(2902014, new FacePackageDetailActivityConfig(this.f57324a.getPageContext().getPageActivity(), e2, false, "frs_banner")));
        } else if (this.j.a() == 2) {
            if (e2.contains(TbPatternsCompat.TB_DOMAIN_NAME)) {
                Matcher matcher = u.matcher(e2);
                if (matcher.find()) {
                    try {
                        String group = matcher.group(2);
                        PbActivityConfig createNormalCfg = new PbActivityConfig(this.f57324a.getPageContext().getPageActivity()).createNormalCfg(group, null, "frs_banner");
                        createNormalCfg.setForumId(group);
                        createNormalCfg.setStartFrom(3);
                        this.f57324a.sendMessage(new CustomMessage(2004001, createNormalCfg));
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
                int i = h.f57338a[nativePageType.ordinal()];
                if (i == 1) {
                    this.f57324a.sendMessage(new CustomMessage(2003000, new FrsActivityConfig(this.f57324a.getPageContext().getPageActivity()).createNormalCfg(isNativeAddress.id, "frs_banner")));
                    return;
                } else if (i != 2) {
                    return;
                } else {
                    PbActivityConfig createNormalCfg2 = new PbActivityConfig(this.f57324a.getPageContext().getPageActivity()).createNormalCfg(isNativeAddress.id, null, "frs_banner");
                    createNormalCfg2.setForumId(isNativeAddress.id);
                    createNormalCfg2.setStartFrom(3);
                    this.f57324a.sendMessage(new CustomMessage(2004001, createNormalCfg2));
                    return;
                }
            }
            UrlManager.getInstance().dealOneLink(this.f57324a.getPageContext(), new String[]{e2});
            if (StringUtils.isNull(e2) || !e2.startsWith(UrlSchemaHelper.SCHEMA_TYPE_GAME_DETAIL)) {
                return;
            }
            TiebaStatic.eventStat(this.f57324a.getPageContext().getPageActivity(), "frs_banner", PrefetchEvent.STATE_CLICK, 1, "ref_id", "4000601", "ref_type", "603");
        } else if (this.j.a() == 4) {
            this.f57324a.sendMessage(new CustomMessage(2003000, new FrsActivityConfig(this.f57324a.getPageContext().getPageActivity()).createNormalCfg(e2, "frs_banner")));
        }
    }

    public d.b.i0.p0.a2.b m() {
        return this.f57331h;
    }

    public BdTypeRecyclerView n() {
        return this.f57326c;
    }

    public RelativeLayout o() {
        return this.f57325b;
    }

    @Override // com.google.android.material.tabs.TabLayout.BaseOnTabSelectedListener
    public void onTabReselected(TabLayout.Tab tab) {
        if (tab == null || tab.getCustomView() == null) {
            return;
        }
        if (!this.n && (tab.getTag() instanceof Integer)) {
            int intValue = ((Integer) tab.getTag()).intValue();
            this.o = intValue;
            this.f57324a.o1(intValue);
        }
        P(tab);
    }

    @Override // com.google.android.material.tabs.TabLayout.BaseOnTabSelectedListener
    public void onTabSelected(TabLayout.Tab tab) {
        if (tab != null) {
            if (tab.getTag() instanceof Integer) {
                int intValue = ((Integer) tab.getTag()).intValue();
                d.b.i0.p0.j2.d.J0.f57703e = intValue;
                if (!this.n) {
                    this.o = intValue;
                    G(intValue, this.f57329f, false);
                    this.f57324a.o1(this.o);
                    d.b.i0.x.t.b().e(false);
                    d.b.i0.b3.c.g().h(this.f57324a.getUniqueId(), false);
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
        this.f57326c.setNextPage(null);
    }

    public final void q(f0 f0Var) {
        if (this.i != null) {
            return;
        }
        this.i = new BannerView(this.f57324a.getPageContext().getPageActivity());
        this.i.setLayoutParams(new AbsListView.LayoutParams(-1, this.f57324a.getResources().getDimensionPixelSize(R.dimen.ds100)));
        this.i.setVisibility(8);
        this.i.setBannerViewClickListener(this.s);
        this.i.setBannerData(f0Var);
        this.i.setBannerViewEvent(new c());
    }

    public final void r(View view) {
        TabLayout tabLayout = (TabLayout) view.findViewById(R.id.frs_good_fake_tabview);
        this.f57329f = tabLayout;
        tabLayout.setPadding(UtilHelper.getDimenPixelSize(R.dimen.M_W_X004) - (this.q / 2), 0, UtilHelper.getDimenPixelSize(R.dimen.M_W_X004) - (this.q / 2), 0);
        this.f57329f.setOnTabSelectedListener(new e());
    }

    public final void s(TabLayout tabLayout) {
        if (tabLayout != null) {
            for (int i = 0; i < tabLayout.getTabCount(); i++) {
                TabLayout.Tab tabAt = tabLayout.getTabAt(i);
                if (tabAt != null && (tabAt.getCustomView() instanceof TBSpecificationBtn)) {
                    d.b.h0.r.f0.m.c cVar = (d.b.h0.r.f0.m.c) ((TBSpecificationBtn) tabAt.getCustomView()).getStyleConfig();
                    if (!tabAt.isSelected()) {
                        cVar.q(R.color.CAM_X0108);
                    } else if (k.isEmpty(this.l)) {
                        cVar.q(R.color.CAM_X0105);
                    } else {
                        cVar.p(d.b.i0.i1.o.k.b.b(this.l));
                    }
                }
            }
        }
    }

    public final void t() {
        if (this.f57328e == null) {
            TabLayout tabLayout = (TabLayout) LayoutInflater.from(this.f57324a.getContext()).inflate(R.layout.frs_good_second_layout, (ViewGroup) null);
            this.f57328e = tabLayout;
            tabLayout.setPadding(UtilHelper.getDimenPixelSize(R.dimen.M_W_X004) - (this.q / 2), 0, UtilHelper.getDimenPixelSize(R.dimen.M_W_X004) - (this.q / 2), 0);
            this.f57328e.setLayoutParams(new RecyclerView.LayoutParams(-1, l.g(this.f57324a.getContext(), R.dimen.tbds126)));
            this.f57328e.setOnTabSelectedListener(this);
            s(this.f57328e);
            this.f57326c.s(this.f57328e);
        }
    }

    public final void u(View view, boolean z) {
        this.f57325b = (RelativeLayout) view.findViewById(R.id.frs_good_container);
        r(view);
        BdTypeRecyclerView bdTypeRecyclerView = (BdTypeRecyclerView) view.findViewById(R.id.frs_good_lv_thread);
        this.f57326c = bdTypeRecyclerView;
        bdTypeRecyclerView.setLayoutManager(new LinearLayoutManager(bdTypeRecyclerView.getContext()));
        this.f57326c.setFadingEdgeLength(0);
        this.f57326c.setOverScrollMode(2);
        this.f57326c.setRecyclerListener(new b(this));
        int dimenPixelSize = UtilHelper.getDimenPixelSize(R.dimen.M_W_X004);
        BdTypeRecyclerView bdTypeRecyclerView2 = this.f57326c;
        bdTypeRecyclerView2.setPadding(dimenPixelSize, bdTypeRecyclerView2.getPaddingTop(), dimenPixelSize, this.f57326c.getPaddingBottom());
        PbListView pbListView = new PbListView(this.f57324a.getPageContext().getPageActivity());
        this.f57330g = pbListView;
        pbListView.a();
        this.f57330g.o(R.color.transparent);
        this.f57330g.r(l.g(this.f57324a.getActivity(), R.dimen.tbds182));
        this.f57330g.v();
        this.f57330g.E(R.dimen.tbfontsize33);
        this.f57330g.C(SkinManager.getColor(R.color.CAM_X0107));
        this.f57330g.y(R.color.CAM_X0110);
        this.f57326c.setOnSrollToBottomListener(this.f57324a);
        this.f57327d = (FrameLayout) view.findViewById(R.id.frs_list_content);
        this.f57331h = new d.b.i0.p0.a2.b(this.f57324a, this.f57326c);
        I(false);
        this.f57324a.registerListener(this.t);
    }

    public void v() {
        d.b.i0.p0.a2.b bVar = this.f57331h;
        if (bVar != null) {
            bVar.p();
        }
    }

    public void w(int i) {
        d.b.i0.p0.a2.b bVar = this.f57331h;
        if (bVar != null) {
            bVar.D();
            this.f57331h.p();
            this.f57331h.r(i);
        }
        FrsGoodFragment frsGoodFragment = this.f57324a;
        if (frsGoodFragment != null && frsGoodFragment.getBaseFragmentActivity() == null && this.f57324a.getBaseFragmentActivity().getLayoutMode() != null) {
            this.f57324a.getBaseFragmentActivity().getLayoutMode().k(i == 1);
            this.f57324a.getBaseFragmentActivity().getLayoutMode().j(this.f57325b);
        }
        BannerView bannerView = this.i;
        if (bannerView != null) {
            bannerView.j();
        }
        PbListView pbListView = this.f57330g;
        if (pbListView != null) {
            pbListView.C(SkinManager.getColor(R.color.CAM_X0107));
            this.f57330g.d(i);
        }
        s(this.f57328e);
        s(this.f57329f);
    }

    public void x() {
        this.f57331h.s();
        this.f57326c.setOnSrollToBottomListener(null);
        B(this.f57328e);
        B(this.f57329f);
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
        d.b.b.e.m.e.a().postDelayed(new f(), 500L);
    }

    public void z(ForumData forumData, UserData userData) {
        if (this.m || forumData == null || forumData.getFrsBannerData() == null || !forumData.getFrsBannerData().f()) {
            return;
        }
        f0 frsBannerData = forumData.getFrsBannerData();
        this.j = frsBannerData;
        q(frsBannerData);
        this.i.k();
        this.f57326c.removeHeaderView(this.i);
        if (this.j.d() != 1 || TextUtils.isEmpty(this.j.b())) {
            return;
        }
        this.i.setData(this.f57324a.getPageContext(), this.j.b());
        if (this.j.e().startsWith(UrlSchemaHelper.SCHEMA_TYPE_GAME_DETAIL)) {
            TiebaStatic.eventStat(this.f57324a.getPageContext().getPageActivity(), "game_show", "show", 1, "ref_id", "4000601", "ref_type", "603");
        }
    }
}
