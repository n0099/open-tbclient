package d.a.n0.r0.e2;

import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.FrameLayout;
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
import com.baidu.tbadk.core.util.TbPatternsCompat;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.UrlManager;
import com.baidu.tbadk.core.util.UrlSchemaHelper;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.view.PbListView;
import com.baidu.tbadk.core.view.UserPhotoLayout;
import com.baidu.tbadk.coreExtra.view.BannerView;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
import com.baidu.tieba.frs.mc.FrsNewAreaFragment;
import com.baidu.tieba.tbadkCore.FrsCommonImageLayout;
import com.baidu.tieba.tbadkCore.FrsViewData;
import com.baidu.tieba.tbadkCore.voice.PlayVoiceBnt;
import d.a.c.j.e.w;
import d.a.m0.r.q.a2;
import d.a.m0.r.q.f0;
import d.a.m0.r.q.z1;
import d.a.n0.r0.a0;
import d.a.n0.r0.t;
import d.a.n0.r0.u;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import tbclient.FrsTabInfo;
/* loaded from: classes4.dex */
public class g {
    public static final Pattern p = Pattern.compile("(/p/){1}(\\d+)");

    /* renamed from: a  reason: collision with root package name */
    public FrsNewAreaFragment f58517a;

    /* renamed from: d  reason: collision with root package name */
    public FrameLayout f58520d;

    /* renamed from: e  reason: collision with root package name */
    public PbListView f58521e;

    /* renamed from: f  reason: collision with root package name */
    public d.a.n0.r0.e2.f f58522f;

    /* renamed from: h  reason: collision with root package name */
    public f0 f58524h;
    public RelativeLayout j;
    public d.a.n0.r0.n1.f.a.a k;

    /* renamed from: b  reason: collision with root package name */
    public RelativeLayout f58518b = null;

    /* renamed from: c  reason: collision with root package name */
    public BdTypeRecyclerView f58519c = null;

    /* renamed from: g  reason: collision with root package name */
    public BannerView f58523g = null;

    /* renamed from: i  reason: collision with root package name */
    public boolean f58525i = false;
    public boolean l = true;
    public BannerView.b m = new c();
    public CustomMessageListener n = new e(2921414);
    public CustomMessageListener o = new f(2016331);

    /* loaded from: classes4.dex */
    public class a implements RecyclerView.RecyclerListener {
        public a(g gVar) {
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
    public class b implements TbImageView.f {
        public b() {
        }

        @Override // com.baidu.tbadk.widget.TbImageView.f
        public void a(String str, boolean z) {
            if (!z || !g.this.f58523g.i() || g.this.f58525i || g.this.f58519c == null) {
                return;
            }
            g.this.f58525i = true;
            g.this.f58519c.t(g.this.f58523g, 1);
        }

        @Override // com.baidu.tbadk.widget.TbImageView.f
        public void onCancel() {
        }
    }

    /* loaded from: classes4.dex */
    public class c implements BannerView.b {
        public c() {
        }

        @Override // com.baidu.tbadk.coreExtra.view.BannerView.b
        public void a() {
            g.this.u();
        }

        @Override // com.baidu.tbadk.coreExtra.view.BannerView.b
        public void b() {
            g.this.h();
        }
    }

    /* loaded from: classes4.dex */
    public class d implements Runnable {
        public d() {
        }

        @Override // java.lang.Runnable
        public void run() {
            g.this.f58519c.removeHeaderView(g.this.j);
            g.this.f58519c.t(g.this.j, 0);
        }
    }

    /* loaded from: classes4.dex */
    public class e extends CustomMessageListener {

        /* loaded from: classes4.dex */
        public class a implements Runnable {
            public a() {
            }

            @Override // java.lang.Runnable
            public void run() {
                g.this.f58522f.l();
            }
        }

        public e(int i2) {
            super(i2);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            a2 a2Var;
            List<d.a.c.j.e.n> j = g.this.f58522f.j();
            if (ListUtils.isEmpty(j)) {
                return;
            }
            if (!ListUtils.isEmpty(j)) {
                for (d.a.c.j.e.n nVar : j) {
                    if (nVar instanceof z1) {
                        z1 z1Var = (z1) nVar;
                        if (z1Var.x != 0 && (a2Var = z1Var.w) != null) {
                            int[] p0 = a2Var.p0();
                            z1Var.x = p0[0];
                            z1Var.y = p0[1];
                        }
                    }
                }
            }
            d.a.c.e.m.e.a().postDelayed(new a(), 500L);
        }
    }

    /* loaded from: classes4.dex */
    public class f extends CustomMessageListener {
        public f(int i2) {
            super(i2);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage == null || !(customResponsedMessage.getData() instanceof String)) {
                return;
            }
            String str = (String) customResponsedMessage.getData();
            g.this.w(str);
            g.this.v(str);
            g.this.f58522f.p();
        }
    }

    /* renamed from: d.a.n0.r0.e2.g$g  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public static /* synthetic */ class C1495g {

        /* renamed from: a  reason: collision with root package name */
        public static final /* synthetic */ int[] f58532a;

        static {
            int[] iArr = new int[UtilHelper.NativePageType.values().length];
            f58532a = iArr;
            try {
                iArr[UtilHelper.NativePageType.FRS.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f58532a[UtilHelper.NativePageType.PB.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
        }
    }

    public g(FrsNewAreaFragment frsNewAreaFragment, View view) {
        this.f58517a = null;
        this.f58517a = frsNewAreaFragment;
        o(view);
    }

    public void A(boolean z) {
        if (z) {
            return;
        }
        u uVar = new u();
        uVar.f59661a = 503;
        uVar.f59662b = false;
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921449, uVar));
    }

    public void B(boolean z) {
        this.f58520d.setVisibility(z ? 0 : 8);
    }

    public void C(int i2) {
        this.f58519c.setSelection(i2);
    }

    public void D(boolean z) {
        this.l = z;
        if (z) {
            this.f58521e.A(this.f58517a.getResources().getString(R.string.load_more));
            BdTypeRecyclerView bdTypeRecyclerView = this.f58519c;
            if (bdTypeRecyclerView.getChildAt(bdTypeRecyclerView.getChildCount() - 1) == this.f58521e.b()) {
                this.f58521e.O();
                this.f58517a.loadMore();
                return;
            }
            this.f58521e.f();
            return;
        }
        this.f58521e.A(this.f58517a.getResources().getString(R.string.load_more_must_after_delete));
        this.f58521e.f();
    }

    public void E(w wVar) {
        this.f58522f.u(wVar);
    }

    public void F(RecyclerView.OnScrollListener onScrollListener) {
        this.f58519c.setOnScrollListener(onScrollListener);
    }

    public void G(boolean z) {
        a0 a0Var = new a0();
        a0Var.f58363a = 503;
        a0Var.f58365c = z;
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(9205410, a0Var));
    }

    public void H(ArrayList<d.a.c.j.e.n> arrayList, int i2, FrsViewData frsViewData, int i3) {
        ArrayList<d.a.c.j.e.n> switchThreadDataToThreadCardInfo = frsViewData.switchThreadDataToThreadCardInfo();
        if (switchThreadDataToThreadCardInfo == null || switchThreadDataToThreadCardInfo.size() <= 0) {
            t tVar = new t();
            ArrayList<d.a.c.j.e.n> arrayList2 = new ArrayList<>();
            arrayList2.add(tVar);
            switchThreadDataToThreadCardInfo = arrayList2;
        }
        if (frsViewData != null && frsViewData.getEntelechyTabInfo() != null) {
            List<FrsTabInfo> i4 = i(frsViewData);
            if (ListUtils.isEmpty(i4)) {
                RelativeLayout relativeLayout = this.j;
                if (relativeLayout != null) {
                    this.f58519c.removeHeaderView(relativeLayout);
                }
            } else if (this.j != null) {
                this.f58519c.post(new d());
            }
            if (frsViewData != null && frsViewData.getIsBrandForum()) {
                FrsTabInfo frsTabInfo = (FrsTabInfo) ListUtils.getItem(i4, 0);
                if (frsViewData != null && this.f58517a.m1() != null && frsTabInfo != null) {
                    this.f58517a.m1().I(frsTabInfo.tab_id.intValue());
                }
            } else if (this.k != null && frsViewData.getForum() != null) {
                this.k.i(i4);
                this.k.j(frsViewData.getForum().getId());
                if (d.a.m0.b.d.n() && d.a.m0.b.g.a.f48888c != d.a.m0.b.g.a.d()) {
                    this.k.g(d.a.n0.r0.n2.k.d(d.a.m0.b.g.a.d()));
                }
            }
        }
        this.f58522f.q(switchThreadDataToThreadCardInfo, frsViewData);
    }

    public void I() {
        this.f58519c.setVisibility(0);
    }

    public void J() {
        this.f58519c.setNextPage(this.f58521e);
        this.f58521e.J(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
        this.f58521e.O();
    }

    public void K() {
        this.f58519c.setNextPage(this.f58521e);
        this.f58521e.J(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
        this.f58521e.f();
        this.f58521e.A(this.f58517a.getResources().getString(R.string.list_has_no_more));
    }

    public void L() {
        u uVar = new u();
        uVar.f59661a = 503;
        uVar.f59662b = true;
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921449, uVar));
    }

    public final void h() {
        f0 f0Var = this.f58524h;
        if (f0Var == null) {
            return;
        }
        String e2 = f0Var.e();
        if (this.f58524h.a() == 1) {
            MessageManager.getInstance().sendMessage(new CustomMessage(2902014, new FacePackageDetailActivityConfig(this.f58517a.getPageContext().getPageActivity(), e2, false, "frs_banner")));
        } else if (this.f58524h.a() == 2) {
            if (e2.contains(TbPatternsCompat.TB_DOMAIN_NAME)) {
                Matcher matcher = p.matcher(e2);
                if (matcher.find()) {
                    try {
                        String group = matcher.group(2);
                        PbActivityConfig createNormalCfg = new PbActivityConfig(this.f58517a.getPageContext().getPageActivity()).createNormalCfg(group, null, "frs_banner");
                        createNormalCfg.setForumId(group);
                        createNormalCfg.setStartFrom(3);
                        this.f58517a.sendMessage(new CustomMessage(2004001, createNormalCfg));
                    } catch (Exception e3) {
                        BdLog.e(e3.toString());
                    }
                }
            }
        } else if (this.f58524h.a() == 3) {
            new UtilHelper.NativePage();
            UtilHelper.NativePage isNativeAddress = UtilHelper.isNativeAddress(e2);
            UtilHelper.NativePageType nativePageType = isNativeAddress.type;
            if (nativePageType != UtilHelper.NativePageType.NONE) {
                int i2 = C1495g.f58532a[nativePageType.ordinal()];
                if (i2 == 1) {
                    this.f58517a.sendMessage(new CustomMessage(2003000, new FrsActivityConfig(this.f58517a.getPageContext().getPageActivity()).createNormalCfg(isNativeAddress.id, "frs_banner")));
                    return;
                } else if (i2 != 2) {
                    return;
                } else {
                    PbActivityConfig createNormalCfg2 = new PbActivityConfig(this.f58517a.getPageContext().getPageActivity()).createNormalCfg(isNativeAddress.id, null, "frs_banner");
                    createNormalCfg2.setForumId(isNativeAddress.id);
                    createNormalCfg2.setStartFrom(3);
                    this.f58517a.sendMessage(new CustomMessage(2004001, createNormalCfg2));
                    return;
                }
            }
            UrlManager.getInstance().dealOneLink(this.f58517a.getPageContext(), new String[]{e2});
            if (StringUtils.isNull(e2) || !e2.startsWith(UrlSchemaHelper.SCHEMA_TYPE_GAME_DETAIL)) {
                return;
            }
            TiebaStatic.eventStat(this.f58517a.getPageContext().getPageActivity(), "frs_banner", PrefetchEvent.STATE_CLICK, 1, "ref_id", "4000601", "ref_type", "603");
        } else if (this.f58524h.a() == 4) {
            this.f58517a.sendMessage(new CustomMessage(2003000, new FrsActivityConfig(this.f58517a.getPageContext().getPageActivity()).createNormalCfg(e2, "frs_banner")));
        }
    }

    public final List<FrsTabInfo> i(FrsViewData frsViewData) {
        int i2;
        Iterator<FrsTabInfo> it = frsViewData.getEntelechyTabInfo().tab.iterator();
        while (true) {
            if (!it.hasNext()) {
                i2 = -1;
                break;
            }
            FrsTabInfo next = it.next();
            if (next.tab_id.intValue() == 503) {
                i2 = next.tab_type.intValue();
                break;
            }
        }
        if (i2 == -1) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        for (FrsTabInfo frsTabInfo : frsViewData.getEntelechyTabInfo().menu) {
            if (frsTabInfo.tab_type.intValue() == i2) {
                arrayList.add(frsTabInfo);
            }
        }
        return arrayList;
    }

    public d.a.n0.r0.e2.f j() {
        return this.f58522f;
    }

    public BdTypeRecyclerView k() {
        return this.f58519c;
    }

    public RelativeLayout l() {
        return this.f58518b;
    }

    public void m() {
        this.f58519c.setNextPage(null);
    }

    public final void n(f0 f0Var) {
        if (this.f58523g != null) {
            return;
        }
        this.f58523g = new BannerView(this.f58517a.getPageContext().getPageActivity());
        this.f58523g.setLayoutParams(new AbsListView.LayoutParams(-1, this.f58517a.getResources().getDimensionPixelSize(R.dimen.ds100)));
        this.f58523g.setVisibility(8);
        this.f58523g.setBannerViewClickListener(this.m);
        this.f58523g.setBannerData(f0Var);
        this.f58523g.setBannerViewEvent(new b());
    }

    public final void o(View view) {
        this.f58518b = (RelativeLayout) view.findViewById(R.id.frs_good_container);
        BdTypeRecyclerView bdTypeRecyclerView = (BdTypeRecyclerView) view.findViewById(R.id.frs_good_lv_thread);
        this.f58519c = bdTypeRecyclerView;
        bdTypeRecyclerView.setLayoutManager(new LinearLayoutManager(bdTypeRecyclerView.getContext()));
        this.f58519c.setFadingEdgeLength(0);
        this.f58519c.setOverScrollMode(2);
        this.f58519c.setRecyclerListener(new a(this));
        int dimenPixelSize = UtilHelper.getDimenPixelSize(R.dimen.M_W_X004);
        BdTypeRecyclerView bdTypeRecyclerView2 = this.f58519c;
        bdTypeRecyclerView2.setPadding(dimenPixelSize, bdTypeRecyclerView2.getPaddingTop(), dimenPixelSize, this.f58519c.getPaddingBottom());
        PbListView pbListView = new PbListView(this.f58517a.getPageContext().getPageActivity());
        this.f58521e = pbListView;
        pbListView.a();
        this.f58521e.o(R.color.transparent);
        this.f58521e.r(d.a.c.e.p.l.g(this.f58517a.getActivity(), R.dimen.tbds182));
        this.f58521e.v();
        this.f58521e.E(R.dimen.tbfontsize33);
        this.f58521e.C(SkinManager.getColor(R.color.CAM_X0107));
        this.f58521e.y(R.color.CAM_X0110);
        this.f58519c.setOnSrollToBottomListener(this.f58517a);
        this.f58520d = (FrameLayout) view.findViewById(R.id.frs_list_content);
        this.f58522f = new d.a.n0.r0.e2.f(this.f58517a, this.f58519c);
        A(false);
        this.j = new RelativeLayout(this.f58517a.getContext());
        this.j.setLayoutParams(new ViewGroup.LayoutParams(-1, -2));
        this.k = new d.a.n0.r0.n1.f.a.a(this.f58517a, this.j);
        this.f58517a.registerListener(this.n);
        this.f58517a.registerListener(this.o);
    }

    public void p() {
        d.a.n0.r0.e2.f fVar = this.f58522f;
        if (fVar != null) {
            fVar.l();
        }
    }

    public void q(int i2) {
        d.a.n0.r0.e2.f fVar = this.f58522f;
        if (fVar != null) {
            fVar.w();
            this.f58522f.l();
            this.f58522f.n(i2);
        }
        this.f58517a.getBaseFragmentActivity().getLayoutMode().k(i2 == 1);
        this.f58517a.getBaseFragmentActivity().getLayoutMode().j(this.f58518b);
        BannerView bannerView = this.f58523g;
        if (bannerView != null) {
            bannerView.j();
        }
        PbListView pbListView = this.f58521e;
        if (pbListView != null) {
            pbListView.C(SkinManager.getColor(R.color.CAM_X0107));
            this.f58521e.d(i2);
        }
        this.k.h();
    }

    public void r() {
        this.f58522f.o();
        this.f58519c.setOnSrollToBottomListener(null);
    }

    public void s(ForumData forumData, UserData userData) {
        if (this.f58525i || forumData == null || forumData.getFrsBannerData() == null || !forumData.getFrsBannerData().f()) {
            return;
        }
        f0 frsBannerData = forumData.getFrsBannerData();
        this.f58524h = frsBannerData;
        n(frsBannerData);
        this.f58523g.k();
        this.f58519c.removeHeaderView(this.f58523g);
        if (this.f58524h.d() != 1 || TextUtils.isEmpty(this.f58524h.b())) {
            return;
        }
        this.f58523g.setData(this.f58517a.getPageContext(), this.f58524h.b());
        if (this.f58524h.e().startsWith(UrlSchemaHelper.SCHEMA_TYPE_GAME_DETAIL)) {
            TiebaStatic.eventStat(this.f58517a.getPageContext().getPageActivity(), "game_show", "show", 1, "ref_id", "4000601", "ref_type", "603");
        }
    }

    public void t() {
        this.f58522f.l();
    }

    public void u() {
        BannerView bannerView = this.f58523g;
        if (bannerView != null) {
            this.f58525i = false;
            this.f58519c.removeHeaderView(bannerView);
        }
    }

    public void v(String str) {
        if (this.f58517a.l1() != null) {
            this.f58517a.l1().E(str);
        }
    }

    public void w(String str) {
        if (StringUtils.isNull(str) || ListUtils.isEmpty(this.f58522f.j())) {
            return;
        }
        Iterator<d.a.c.j.e.n> it = this.f58522f.j().iterator();
        while (it.hasNext()) {
            d.a.c.j.e.n next = it.next();
            if (next instanceof d.a.n0.e.c) {
                d.a.n0.e.c cVar = (d.a.n0.e.c) next;
                if ((cVar.c() instanceof AdvertAppInfo) && str.equals(((AdvertAppInfo) cVar.c()).G3)) {
                    it.remove();
                }
            }
        }
    }

    public boolean x() {
        if (this.l) {
            return false;
        }
        this.f58521e.A(this.f58517a.getResources().getString(R.string.load_more_must_after_delete));
        this.f58521e.f();
        return true;
    }

    public void y() {
        u uVar = new u();
        uVar.f59661a = 503;
        uVar.f59662b = false;
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921449, uVar));
    }

    public void z() {
        this.f58522f.m();
    }
}
