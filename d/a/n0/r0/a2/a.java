package d.a.n0.r0.a2;

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
import d.a.m0.r.q.a2;
import d.a.m0.r.q.f0;
import d.a.m0.r.q.l0;
import d.a.m0.r.q.z1;
import d.a.n0.r0.a0;
import d.a.n0.r0.t;
import d.a.n0.r0.u;
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
    public FrsGoodFragment f58367a;

    /* renamed from: d  reason: collision with root package name */
    public FrameLayout f58370d;

    /* renamed from: e  reason: collision with root package name */
    public TabLayout f58371e;

    /* renamed from: f  reason: collision with root package name */
    public TabLayout f58372f;

    /* renamed from: g  reason: collision with root package name */
    public PbListView f58373g;

    /* renamed from: h  reason: collision with root package name */
    public d.a.n0.r0.a2.b f58374h;
    public f0 j;
    public ThemeColorInfo k;
    public String l;
    public final int p;
    public int q;

    /* renamed from: b  reason: collision with root package name */
    public RelativeLayout f58368b = null;

    /* renamed from: c  reason: collision with root package name */
    public BdTypeRecyclerView f58369c = null;

    /* renamed from: i  reason: collision with root package name */
    public BannerView f58375i = null;
    public boolean m = false;
    public boolean n = false;
    public int o = 0;
    public View.OnClickListener r = new View$OnClickListenerC1487a();
    public BannerView.b s = new d();
    public CustomMessageListener t = new g(2016331);

    /* renamed from: d.a.n0.r0.a2.a$a  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public class View$OnClickListenerC1487a implements View.OnClickListener {
        public View$OnClickListenerC1487a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (a.this.f58367a != null) {
                a.this.f58367a.onScrollToBottom();
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
            if (!z || !a.this.f58375i.i() || a.this.m || a.this.f58369c == null) {
                return;
            }
            a.this.m = true;
            a.this.f58369c.t(a.this.f58375i, 1);
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
                    aVar.G(intValue, aVar.f58371e, true);
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
            a.this.f58374h.t();
        }
    }

    /* loaded from: classes4.dex */
    public static /* synthetic */ class h {

        /* renamed from: a  reason: collision with root package name */
        public static final /* synthetic */ int[] f58382a;

        static {
            int[] iArr = new int[UtilHelper.NativePageType.values().length];
            f58382a = iArr;
            try {
                iArr[UtilHelper.NativePageType.FRS.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f58382a[UtilHelper.NativePageType.PB.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
        }
    }

    public a(FrsGoodFragment frsGoodFragment, View view, boolean z) {
        this.f58367a = null;
        this.f58367a = frsGoodFragment;
        u(view, z);
        this.p = l.g(this.f58367a.getPageContext().getPageActivity(), R.dimen.tbds75);
        this.q = l.g(this.f58367a.getPageContext().getPageActivity(), R.dimen.M_W_X006);
    }

    public void A() {
        d.a.n0.r0.a2.b bVar = this.f58374h;
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
        BannerView bannerView = this.f58375i;
        if (bannerView != null) {
            this.m = false;
            this.f58369c.removeHeaderView(bannerView);
        }
    }

    public void D(String str) {
        if (this.f58367a.h1() != null) {
            this.f58367a.h1().E(str);
        }
    }

    public void E(String str) {
        if (StringUtils.isNull(str) || ListUtils.isEmpty(this.f58374h.l())) {
            return;
        }
        Iterator<n> it = this.f58374h.m().iterator();
        while (it.hasNext()) {
            n next = it.next();
            if (next instanceof d.a.n0.e.c) {
                d.a.n0.e.c cVar = (d.a.n0.e.c) next;
                if ((cVar.c() instanceof AdvertAppInfo) && str.equals(((AdvertAppInfo) cVar.c()).G3)) {
                    it.remove();
                }
            }
        }
    }

    public void F() {
        u uVar = new u();
        uVar.f59661a = 301;
        uVar.f59662b = false;
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
        this.f58374h.q();
    }

    public void I(boolean z) {
        if (z) {
            return;
        }
        u uVar = new u();
        uVar.f59661a = 301;
        uVar.f59662b = false;
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921449, uVar));
    }

    public void J(boolean z) {
        this.f58370d.setVisibility(z ? 0 : 8);
        V(z);
    }

    public void K(int i2) {
        this.f58369c.setSelection(i2);
    }

    public void L(w wVar) {
        this.f58374h.B(wVar);
    }

    public void M(RecyclerView.OnScrollListener onScrollListener) {
        this.f58369c.setOnScrollListener(onScrollListener);
    }

    public void N(boolean z) {
        a0 a0Var = new a0();
        a0Var.f58363a = 301;
        a0Var.f58365c = z;
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(9205410, a0Var));
    }

    public void O(FrsViewData frsViewData) {
        if (frsViewData == null || frsViewData.getForum() == null || frsViewData.getForum().getGood_classify() == null) {
            return;
        }
        ArrayList<l0> good_classify = frsViewData.getForum().getGood_classify();
        TabData tabData = new TabData();
        d.a.n0.r0.k2.d dVar = new d.a.n0.r0.k2.d();
        dVar.f58810b = 0;
        dVar.f58809a = this.f58367a.getPageContext().getResources().getString(R.string.all);
        tabData.add(dVar);
        for (l0 l0Var : good_classify) {
            if (l0Var != null && l0Var.a() > 0 && !TextUtils.isEmpty(l0Var.b()) && !TextUtils.isEmpty(l0Var.b().trim())) {
                d.a.n0.r0.k2.d dVar2 = new d.a.n0.r0.k2.d();
                dVar2.f58810b = l0Var.a();
                dVar2.f58809a = l0Var.b();
                tabData.add(dVar2);
            }
        }
        if (ListUtils.getCount(tabData) <= 1) {
            return;
        }
        t();
        this.n = true;
        R(tabData, this.f58371e);
        R(tabData, this.f58372f);
    }

    public final void P(TabLayout.Tab tab) {
        if (tab.getCustomView() != null) {
            d.a.m0.r.f0.m.c cVar = (d.a.m0.r.f0.m.c) ((TBSpecificationBtn) tab.getCustomView()).getStyleConfig();
            if (k.isEmpty(this.l)) {
                cVar.q(R.color.CAM_X0105);
            } else {
                cVar.p(d.a.n0.k1.o.k.b.b(this.l));
            }
        }
    }

    public final void Q(TabLayout.Tab tab) {
        if (tab == null || tab.getCustomView() == null) {
            return;
        }
        ((d.a.m0.r.f0.m.c) ((TBSpecificationBtn) tab.getCustomView()).getStyleConfig()).q(R.color.CAM_X0108);
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
                TBSpecificationBtn tBSpecificationBtn = new TBSpecificationBtn(this.f58367a.getContext());
                d.a.m0.r.f0.m.c cVar = new d.a.m0.r.f0.m.c();
                cVar.q(R.color.CAM_X0108);
                tBSpecificationBtn.setConfig(cVar);
                LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, this.p);
                int i4 = this.q;
                layoutParams.setMargins(i4 / 2, 0, i4 / 2, 0);
                tBSpecificationBtn.setLayoutParams(layoutParams);
                tabAt.setCustomView(tBSpecificationBtn);
            }
            ((TBSpecificationBtn) tabAt.getCustomView()).setText(StringHelper.cutForumNameWithSuffix(tabData.get(i3).f58809a, 10, StringHelper.STRING_MORE));
            tabAt.setTag(Integer.valueOf(tabData.get(i3).f58810b));
            if (tabData.get(i3).f58810b == this.o) {
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
        this.f58374h.w(arrayList, frsViewData);
        this.n = false;
    }

    public void U() {
        this.f58369c.setNextPage(this.f58373g);
        this.f58373g.J(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
        this.f58373g.z(this.r);
        this.f58373g.f();
        this.f58373g.A(this.f58367a.getResources().getString(R.string.list_click_load_more));
    }

    public final void V(boolean z) {
        if (z) {
            this.f58372f.setVisibility(8);
        } else if (this.f58372f.getTabCount() > 1) {
            this.f58372f.setVisibility(0);
        }
    }

    public void W() {
        this.f58369c.setVisibility(0);
    }

    public void X() {
        this.f58369c.setNextPage(this.f58373g);
        this.f58373g.J(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
        this.f58373g.z(null);
        this.f58373g.O();
    }

    public void Y() {
        this.f58369c.setNextPage(this.f58373g);
        this.f58373g.J(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
        this.f58373g.z(null);
        this.f58373g.f();
        this.f58373g.A(this.f58367a.getResources().getString(R.string.list_has_no_more));
    }

    public void Z() {
        u uVar = new u();
        uVar.f59661a = 301;
        uVar.f59662b = true;
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921449, uVar));
    }

    public void a0() {
        u uVar = new u();
        uVar.f59661a = 301;
        uVar.f59662b = false;
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921449, uVar));
    }

    public final void l() {
        f0 f0Var = this.j;
        if (f0Var == null) {
            return;
        }
        String e2 = f0Var.e();
        if (this.j.a() == 1) {
            MessageManager.getInstance().sendMessage(new CustomMessage(2902014, new FacePackageDetailActivityConfig(this.f58367a.getPageContext().getPageActivity(), e2, false, "frs_banner")));
        } else if (this.j.a() == 2) {
            if (e2.contains(TbPatternsCompat.TB_DOMAIN_NAME)) {
                Matcher matcher = u.matcher(e2);
                if (matcher.find()) {
                    try {
                        String group = matcher.group(2);
                        PbActivityConfig createNormalCfg = new PbActivityConfig(this.f58367a.getPageContext().getPageActivity()).createNormalCfg(group, null, "frs_banner");
                        createNormalCfg.setForumId(group);
                        createNormalCfg.setStartFrom(3);
                        this.f58367a.sendMessage(new CustomMessage(2004001, createNormalCfg));
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
                int i2 = h.f58382a[nativePageType.ordinal()];
                if (i2 == 1) {
                    this.f58367a.sendMessage(new CustomMessage(2003000, new FrsActivityConfig(this.f58367a.getPageContext().getPageActivity()).createNormalCfg(isNativeAddress.id, "frs_banner")));
                    return;
                } else if (i2 != 2) {
                    return;
                } else {
                    PbActivityConfig createNormalCfg2 = new PbActivityConfig(this.f58367a.getPageContext().getPageActivity()).createNormalCfg(isNativeAddress.id, null, "frs_banner");
                    createNormalCfg2.setForumId(isNativeAddress.id);
                    createNormalCfg2.setStartFrom(3);
                    this.f58367a.sendMessage(new CustomMessage(2004001, createNormalCfg2));
                    return;
                }
            }
            UrlManager.getInstance().dealOneLink(this.f58367a.getPageContext(), new String[]{e2});
            if (StringUtils.isNull(e2) || !e2.startsWith(UrlSchemaHelper.SCHEMA_TYPE_GAME_DETAIL)) {
                return;
            }
            TiebaStatic.eventStat(this.f58367a.getPageContext().getPageActivity(), "frs_banner", PrefetchEvent.STATE_CLICK, 1, "ref_id", "4000601", "ref_type", "603");
        } else if (this.j.a() == 4) {
            this.f58367a.sendMessage(new CustomMessage(2003000, new FrsActivityConfig(this.f58367a.getPageContext().getPageActivity()).createNormalCfg(e2, "frs_banner")));
        }
    }

    public d.a.n0.r0.a2.b m() {
        return this.f58374h;
    }

    public BdTypeRecyclerView n() {
        return this.f58369c;
    }

    public RelativeLayout o() {
        return this.f58368b;
    }

    @Override // com.google.android.material.tabs.TabLayout.BaseOnTabSelectedListener
    public void onTabReselected(TabLayout.Tab tab) {
        if (tab == null || tab.getCustomView() == null) {
            return;
        }
        if (!this.n && (tab.getTag() instanceof Integer)) {
            int intValue = ((Integer) tab.getTag()).intValue();
            this.o = intValue;
            this.f58367a.n1(intValue);
        }
        P(tab);
    }

    @Override // com.google.android.material.tabs.TabLayout.BaseOnTabSelectedListener
    public void onTabSelected(TabLayout.Tab tab) {
        if (tab != null) {
            if (tab.getTag() instanceof Integer) {
                int intValue = ((Integer) tab.getTag()).intValue();
                d.a.n0.r0.j2.d.J0.f58778e = intValue;
                if (!this.n) {
                    this.o = intValue;
                    G(intValue, this.f58372f, false);
                    this.f58367a.n1(this.o);
                    d.a.n0.z.t.b().e(false);
                    d.a.n0.d3.c.g().h(this.f58367a.getUniqueId(), false);
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
        this.f58369c.setNextPage(null);
    }

    public final void q(f0 f0Var) {
        if (this.f58375i != null) {
            return;
        }
        this.f58375i = new BannerView(this.f58367a.getPageContext().getPageActivity());
        this.f58375i.setLayoutParams(new AbsListView.LayoutParams(-1, this.f58367a.getResources().getDimensionPixelSize(R.dimen.ds100)));
        this.f58375i.setVisibility(8);
        this.f58375i.setBannerViewClickListener(this.s);
        this.f58375i.setBannerData(f0Var);
        this.f58375i.setBannerViewEvent(new c());
    }

    public final void r(View view) {
        TabLayout tabLayout = (TabLayout) view.findViewById(R.id.frs_good_fake_tabview);
        this.f58372f = tabLayout;
        tabLayout.setPadding(UtilHelper.getDimenPixelSize(R.dimen.M_W_X004) - (this.q / 2), 0, UtilHelper.getDimenPixelSize(R.dimen.M_W_X004) - (this.q / 2), 0);
        this.f58372f.setOnTabSelectedListener((TabLayout.OnTabSelectedListener) new e());
    }

    public final void s(TabLayout tabLayout) {
        if (tabLayout != null) {
            for (int i2 = 0; i2 < tabLayout.getTabCount(); i2++) {
                TabLayout.Tab tabAt = tabLayout.getTabAt(i2);
                if (tabAt != null && (tabAt.getCustomView() instanceof TBSpecificationBtn)) {
                    d.a.m0.r.f0.m.c cVar = (d.a.m0.r.f0.m.c) ((TBSpecificationBtn) tabAt.getCustomView()).getStyleConfig();
                    if (!tabAt.isSelected()) {
                        cVar.q(R.color.CAM_X0108);
                    } else if (k.isEmpty(this.l)) {
                        cVar.q(R.color.CAM_X0105);
                    } else {
                        cVar.p(d.a.n0.k1.o.k.b.b(this.l));
                    }
                }
            }
        }
    }

    public final void t() {
        if (this.f58371e == null) {
            TabLayout tabLayout = (TabLayout) LayoutInflater.from(this.f58367a.getContext()).inflate(R.layout.frs_good_second_layout, (ViewGroup) null);
            this.f58371e = tabLayout;
            tabLayout.setPadding(UtilHelper.getDimenPixelSize(R.dimen.M_W_X004) - (this.q / 2), 0, UtilHelper.getDimenPixelSize(R.dimen.M_W_X004) - (this.q / 2), 0);
            this.f58371e.setLayoutParams(new RecyclerView.LayoutParams(-1, l.g(this.f58367a.getContext(), R.dimen.tbds126)));
            this.f58371e.setOnTabSelectedListener((TabLayout.OnTabSelectedListener) this);
            s(this.f58371e);
            this.f58369c.s(this.f58371e);
        }
    }

    public final void u(View view, boolean z) {
        this.f58368b = (RelativeLayout) view.findViewById(R.id.frs_good_container);
        r(view);
        BdTypeRecyclerView bdTypeRecyclerView = (BdTypeRecyclerView) view.findViewById(R.id.frs_good_lv_thread);
        this.f58369c = bdTypeRecyclerView;
        bdTypeRecyclerView.setLayoutManager(new LinearLayoutManager(bdTypeRecyclerView.getContext()));
        this.f58369c.setFadingEdgeLength(0);
        this.f58369c.setOverScrollMode(2);
        this.f58369c.setRecyclerListener(new b(this));
        int dimenPixelSize = UtilHelper.getDimenPixelSize(R.dimen.M_W_X004);
        BdTypeRecyclerView bdTypeRecyclerView2 = this.f58369c;
        bdTypeRecyclerView2.setPadding(dimenPixelSize, bdTypeRecyclerView2.getPaddingTop(), dimenPixelSize, this.f58369c.getPaddingBottom());
        PbListView pbListView = new PbListView(this.f58367a.getPageContext().getPageActivity());
        this.f58373g = pbListView;
        pbListView.a();
        this.f58373g.o(R.color.transparent);
        this.f58373g.r(l.g(this.f58367a.getActivity(), R.dimen.tbds182));
        this.f58373g.v();
        this.f58373g.E(R.dimen.tbfontsize33);
        this.f58373g.C(SkinManager.getColor(R.color.CAM_X0107));
        this.f58373g.y(R.color.CAM_X0110);
        this.f58369c.setOnSrollToBottomListener(this.f58367a);
        this.f58370d = (FrameLayout) view.findViewById(R.id.frs_list_content);
        this.f58374h = new d.a.n0.r0.a2.b(this.f58367a, this.f58369c);
        I(false);
        this.f58367a.registerListener(this.t);
    }

    public void v() {
        d.a.n0.r0.a2.b bVar = this.f58374h;
        if (bVar != null) {
            bVar.p();
        }
    }

    public void w(int i2) {
        d.a.n0.r0.a2.b bVar = this.f58374h;
        if (bVar != null) {
            bVar.D();
            this.f58374h.p();
            this.f58374h.r(i2);
        }
        FrsGoodFragment frsGoodFragment = this.f58367a;
        if (frsGoodFragment != null && frsGoodFragment.getBaseFragmentActivity() == null && this.f58367a.getBaseFragmentActivity().getLayoutMode() != null) {
            this.f58367a.getBaseFragmentActivity().getLayoutMode().k(i2 == 1);
            this.f58367a.getBaseFragmentActivity().getLayoutMode().j(this.f58368b);
        }
        BannerView bannerView = this.f58375i;
        if (bannerView != null) {
            bannerView.j();
        }
        PbListView pbListView = this.f58373g;
        if (pbListView != null) {
            pbListView.C(SkinManager.getColor(R.color.CAM_X0107));
            this.f58373g.d(i2);
        }
        s(this.f58371e);
        s(this.f58372f);
    }

    public void x() {
        this.f58374h.s();
        this.f58369c.setOnSrollToBottomListener(null);
        B(this.f58371e);
        B(this.f58372f);
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
        this.f58375i.k();
        this.f58369c.removeHeaderView(this.f58375i);
        if (this.j.d() != 1 || TextUtils.isEmpty(this.j.b())) {
            return;
        }
        this.f58375i.setData(this.f58367a.getPageContext(), this.j.b());
        if (this.j.e().startsWith(UrlSchemaHelper.SCHEMA_TYPE_GAME_DETAIL)) {
            TiebaStatic.eventStat(this.f58367a.getPageContext().getPageActivity(), "game_show", "show", 1, "ref_id", "4000601", "ref_type", "603");
        }
    }
}
