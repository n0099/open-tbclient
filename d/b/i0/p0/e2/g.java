package d.b.i0.p0.e2;

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
import d.b.b.j.e.w;
import d.b.h0.r.q.a2;
import d.b.h0.r.q.f0;
import d.b.h0.r.q.z1;
import d.b.i0.p0.a0;
import d.b.i0.p0.t;
import d.b.i0.p0.u;
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
    public FrsNewAreaFragment f57458a;

    /* renamed from: d  reason: collision with root package name */
    public FrameLayout f57461d;

    /* renamed from: e  reason: collision with root package name */
    public PbListView f57462e;

    /* renamed from: f  reason: collision with root package name */
    public d.b.i0.p0.e2.f f57463f;

    /* renamed from: h  reason: collision with root package name */
    public f0 f57465h;
    public RelativeLayout j;
    public d.b.i0.p0.n1.f.a.a k;

    /* renamed from: b  reason: collision with root package name */
    public RelativeLayout f57459b = null;

    /* renamed from: c  reason: collision with root package name */
    public BdTypeRecyclerView f57460c = null;

    /* renamed from: g  reason: collision with root package name */
    public BannerView f57464g = null;
    public boolean i = false;
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
    public class b implements TbImageView.f {
        public b() {
        }

        @Override // com.baidu.tbadk.widget.TbImageView.f
        public void a(String str, boolean z) {
            if (!z || !g.this.f57464g.i() || g.this.i || g.this.f57460c == null) {
                return;
            }
            g.this.i = true;
            g.this.f57460c.t(g.this.f57464g, 1);
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
            g.this.f57460c.removeHeaderView(g.this.j);
            g.this.f57460c.t(g.this.j, 0);
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
                g.this.f57463f.l();
            }
        }

        public e(int i) {
            super(i);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            a2 a2Var;
            List<d.b.b.j.e.n> j = g.this.f57463f.j();
            if (ListUtils.isEmpty(j)) {
                return;
            }
            if (!ListUtils.isEmpty(j)) {
                for (d.b.b.j.e.n nVar : j) {
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
            d.b.b.e.m.e.a().postDelayed(new a(), 500L);
        }
    }

    /* loaded from: classes4.dex */
    public class f extends CustomMessageListener {
        public f(int i) {
            super(i);
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
            g.this.f57463f.p();
        }
    }

    /* renamed from: d.b.i0.p0.e2.g$g  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public static /* synthetic */ class C1383g {

        /* renamed from: a  reason: collision with root package name */
        public static final /* synthetic */ int[] f57472a;

        static {
            int[] iArr = new int[UtilHelper.NativePageType.values().length];
            f57472a = iArr;
            try {
                iArr[UtilHelper.NativePageType.FRS.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f57472a[UtilHelper.NativePageType.PB.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
        }
    }

    public g(FrsNewAreaFragment frsNewAreaFragment, View view) {
        this.f57458a = null;
        this.f57458a = frsNewAreaFragment;
        o(view);
    }

    public void A(boolean z) {
        if (z) {
            return;
        }
        u uVar = new u();
        uVar.f58581a = 503;
        uVar.f58582b = false;
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921449, uVar));
    }

    public void B(boolean z) {
        this.f57461d.setVisibility(z ? 0 : 8);
    }

    public void C(int i) {
        this.f57460c.setSelection(i);
    }

    public void D(boolean z) {
        this.l = z;
        if (z) {
            this.f57462e.A(this.f57458a.getResources().getString(R.string.load_more));
            BdTypeRecyclerView bdTypeRecyclerView = this.f57460c;
            if (bdTypeRecyclerView.getChildAt(bdTypeRecyclerView.getChildCount() - 1) == this.f57462e.b()) {
                this.f57462e.O();
                this.f57458a.loadMore();
                return;
            }
            this.f57462e.f();
            return;
        }
        this.f57462e.A(this.f57458a.getResources().getString(R.string.load_more_must_after_delete));
        this.f57462e.f();
    }

    public void E(w wVar) {
        this.f57463f.u(wVar);
    }

    public void F(RecyclerView.OnScrollListener onScrollListener) {
        this.f57460c.setOnScrollListener(onScrollListener);
    }

    public void G(boolean z) {
        a0 a0Var = new a0();
        a0Var.f57320a = 503;
        a0Var.f57322c = z;
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(9205410, a0Var));
    }

    public void H(ArrayList<d.b.b.j.e.n> arrayList, int i, FrsViewData frsViewData, int i2) {
        ArrayList<d.b.b.j.e.n> switchThreadDataToThreadCardInfo = frsViewData.switchThreadDataToThreadCardInfo();
        if (switchThreadDataToThreadCardInfo == null || switchThreadDataToThreadCardInfo.size() <= 0) {
            t tVar = new t();
            ArrayList<d.b.b.j.e.n> arrayList2 = new ArrayList<>();
            arrayList2.add(tVar);
            switchThreadDataToThreadCardInfo = arrayList2;
        }
        if (frsViewData != null && frsViewData.getEntelechyTabInfo() != null) {
            List<FrsTabInfo> i3 = i(frsViewData);
            if (ListUtils.isEmpty(i3)) {
                RelativeLayout relativeLayout = this.j;
                if (relativeLayout != null) {
                    this.f57460c.removeHeaderView(relativeLayout);
                }
            } else if (this.j != null) {
                this.f57460c.post(new d());
            }
            if (frsViewData != null && frsViewData.getIsBrandForum()) {
                FrsTabInfo frsTabInfo = (FrsTabInfo) ListUtils.getItem(i3, 0);
                if (frsViewData != null && this.f57458a.n1() != null && frsTabInfo != null) {
                    this.f57458a.n1().I(frsTabInfo.tab_id.intValue());
                }
            } else if (this.k != null && frsViewData.getForum() != null) {
                this.k.i(i3);
                this.k.j(frsViewData.getForum().getId());
                if (d.b.h0.b.d.m() && d.b.h0.b.g.a.f49751c != d.b.h0.b.g.a.d()) {
                    this.k.g(d.b.i0.p0.m2.k.d(d.b.h0.b.g.a.d()));
                }
            }
        }
        this.f57463f.q(switchThreadDataToThreadCardInfo, frsViewData);
    }

    public void I() {
        this.f57460c.setVisibility(0);
    }

    public void J() {
        this.f57460c.setNextPage(this.f57462e);
        this.f57462e.J(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
        this.f57462e.O();
    }

    public void K() {
        this.f57460c.setNextPage(this.f57462e);
        this.f57462e.J(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
        this.f57462e.f();
        this.f57462e.A(this.f57458a.getResources().getString(R.string.list_has_no_more));
    }

    public void L() {
        u uVar = new u();
        uVar.f58581a = 503;
        uVar.f58582b = true;
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921449, uVar));
    }

    public final void h() {
        f0 f0Var = this.f57465h;
        if (f0Var == null) {
            return;
        }
        String e2 = f0Var.e();
        if (this.f57465h.a() == 1) {
            MessageManager.getInstance().sendMessage(new CustomMessage(2902014, new FacePackageDetailActivityConfig(this.f57458a.getPageContext().getPageActivity(), e2, false, "frs_banner")));
        } else if (this.f57465h.a() == 2) {
            if (e2.contains(TbPatternsCompat.TB_DOMAIN_NAME)) {
                Matcher matcher = p.matcher(e2);
                if (matcher.find()) {
                    try {
                        String group = matcher.group(2);
                        PbActivityConfig createNormalCfg = new PbActivityConfig(this.f57458a.getPageContext().getPageActivity()).createNormalCfg(group, null, "frs_banner");
                        createNormalCfg.setForumId(group);
                        createNormalCfg.setStartFrom(3);
                        this.f57458a.sendMessage(new CustomMessage(2004001, createNormalCfg));
                    } catch (Exception e3) {
                        BdLog.e(e3.toString());
                    }
                }
            }
        } else if (this.f57465h.a() == 3) {
            new UtilHelper.NativePage();
            UtilHelper.NativePage isNativeAddress = UtilHelper.isNativeAddress(e2);
            UtilHelper.NativePageType nativePageType = isNativeAddress.type;
            if (nativePageType != UtilHelper.NativePageType.NONE) {
                int i = C1383g.f57472a[nativePageType.ordinal()];
                if (i == 1) {
                    this.f57458a.sendMessage(new CustomMessage(2003000, new FrsActivityConfig(this.f57458a.getPageContext().getPageActivity()).createNormalCfg(isNativeAddress.id, "frs_banner")));
                    return;
                } else if (i != 2) {
                    return;
                } else {
                    PbActivityConfig createNormalCfg2 = new PbActivityConfig(this.f57458a.getPageContext().getPageActivity()).createNormalCfg(isNativeAddress.id, null, "frs_banner");
                    createNormalCfg2.setForumId(isNativeAddress.id);
                    createNormalCfg2.setStartFrom(3);
                    this.f57458a.sendMessage(new CustomMessage(2004001, createNormalCfg2));
                    return;
                }
            }
            UrlManager.getInstance().dealOneLink(this.f57458a.getPageContext(), new String[]{e2});
            if (StringUtils.isNull(e2) || !e2.startsWith(UrlSchemaHelper.SCHEMA_TYPE_GAME_DETAIL)) {
                return;
            }
            TiebaStatic.eventStat(this.f57458a.getPageContext().getPageActivity(), "frs_banner", PrefetchEvent.STATE_CLICK, 1, "ref_id", "4000601", "ref_type", "603");
        } else if (this.f57465h.a() == 4) {
            this.f57458a.sendMessage(new CustomMessage(2003000, new FrsActivityConfig(this.f57458a.getPageContext().getPageActivity()).createNormalCfg(e2, "frs_banner")));
        }
    }

    public final List<FrsTabInfo> i(FrsViewData frsViewData) {
        int i;
        Iterator<FrsTabInfo> it = frsViewData.getEntelechyTabInfo().tab.iterator();
        while (true) {
            if (!it.hasNext()) {
                i = -1;
                break;
            }
            FrsTabInfo next = it.next();
            if (next.tab_id.intValue() == 503) {
                i = next.tab_type.intValue();
                break;
            }
        }
        if (i == -1) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        for (FrsTabInfo frsTabInfo : frsViewData.getEntelechyTabInfo().menu) {
            if (frsTabInfo.tab_type.intValue() == i) {
                arrayList.add(frsTabInfo);
            }
        }
        return arrayList;
    }

    public d.b.i0.p0.e2.f j() {
        return this.f57463f;
    }

    public BdTypeRecyclerView k() {
        return this.f57460c;
    }

    public RelativeLayout l() {
        return this.f57459b;
    }

    public void m() {
        this.f57460c.setNextPage(null);
    }

    public final void n(f0 f0Var) {
        if (this.f57464g != null) {
            return;
        }
        this.f57464g = new BannerView(this.f57458a.getPageContext().getPageActivity());
        this.f57464g.setLayoutParams(new AbsListView.LayoutParams(-1, this.f57458a.getResources().getDimensionPixelSize(R.dimen.ds100)));
        this.f57464g.setVisibility(8);
        this.f57464g.setBannerViewClickListener(this.m);
        this.f57464g.setBannerData(f0Var);
        this.f57464g.setBannerViewEvent(new b());
    }

    public final void o(View view) {
        this.f57459b = (RelativeLayout) view.findViewById(R.id.frs_good_container);
        BdTypeRecyclerView bdTypeRecyclerView = (BdTypeRecyclerView) view.findViewById(R.id.frs_good_lv_thread);
        this.f57460c = bdTypeRecyclerView;
        bdTypeRecyclerView.setLayoutManager(new LinearLayoutManager(bdTypeRecyclerView.getContext()));
        this.f57460c.setFadingEdgeLength(0);
        this.f57460c.setOverScrollMode(2);
        this.f57460c.setRecyclerListener(new a(this));
        int dimenPixelSize = UtilHelper.getDimenPixelSize(R.dimen.M_W_X004);
        BdTypeRecyclerView bdTypeRecyclerView2 = this.f57460c;
        bdTypeRecyclerView2.setPadding(dimenPixelSize, bdTypeRecyclerView2.getPaddingTop(), dimenPixelSize, this.f57460c.getPaddingBottom());
        PbListView pbListView = new PbListView(this.f57458a.getPageContext().getPageActivity());
        this.f57462e = pbListView;
        pbListView.a();
        this.f57462e.o(R.color.transparent);
        this.f57462e.r(d.b.b.e.p.l.g(this.f57458a.getActivity(), R.dimen.tbds182));
        this.f57462e.v();
        this.f57462e.E(R.dimen.tbfontsize33);
        this.f57462e.C(SkinManager.getColor(R.color.CAM_X0107));
        this.f57462e.y(R.color.CAM_X0110);
        this.f57460c.setOnSrollToBottomListener(this.f57458a);
        this.f57461d = (FrameLayout) view.findViewById(R.id.frs_list_content);
        this.f57463f = new d.b.i0.p0.e2.f(this.f57458a, this.f57460c);
        A(false);
        this.j = new RelativeLayout(this.f57458a.getContext());
        this.j.setLayoutParams(new ViewGroup.LayoutParams(-1, -2));
        this.k = new d.b.i0.p0.n1.f.a.a(this.f57458a, this.j);
        this.f57458a.registerListener(this.n);
        this.f57458a.registerListener(this.o);
    }

    public void p() {
        d.b.i0.p0.e2.f fVar = this.f57463f;
        if (fVar != null) {
            fVar.l();
        }
    }

    public void q(int i) {
        d.b.i0.p0.e2.f fVar = this.f57463f;
        if (fVar != null) {
            fVar.w();
            this.f57463f.l();
            this.f57463f.n(i);
        }
        this.f57458a.getBaseFragmentActivity().getLayoutMode().k(i == 1);
        this.f57458a.getBaseFragmentActivity().getLayoutMode().j(this.f57459b);
        BannerView bannerView = this.f57464g;
        if (bannerView != null) {
            bannerView.j();
        }
        PbListView pbListView = this.f57462e;
        if (pbListView != null) {
            pbListView.C(SkinManager.getColor(R.color.CAM_X0107));
            this.f57462e.d(i);
        }
        this.k.h();
    }

    public void r() {
        this.f57463f.o();
        this.f57460c.setOnSrollToBottomListener(null);
    }

    public void s(ForumData forumData, UserData userData) {
        if (this.i || forumData == null || forumData.getFrsBannerData() == null || !forumData.getFrsBannerData().f()) {
            return;
        }
        f0 frsBannerData = forumData.getFrsBannerData();
        this.f57465h = frsBannerData;
        n(frsBannerData);
        this.f57464g.k();
        this.f57460c.removeHeaderView(this.f57464g);
        if (this.f57465h.d() != 1 || TextUtils.isEmpty(this.f57465h.b())) {
            return;
        }
        this.f57464g.setData(this.f57458a.getPageContext(), this.f57465h.b());
        if (this.f57465h.e().startsWith(UrlSchemaHelper.SCHEMA_TYPE_GAME_DETAIL)) {
            TiebaStatic.eventStat(this.f57458a.getPageContext().getPageActivity(), "game_show", "show", 1, "ref_id", "4000601", "ref_type", "603");
        }
    }

    public void t() {
        this.f57463f.l();
    }

    public void u() {
        BannerView bannerView = this.f57464g;
        if (bannerView != null) {
            this.i = false;
            this.f57460c.removeHeaderView(bannerView);
        }
    }

    public void v(String str) {
        if (this.f57458a.m1() != null) {
            this.f57458a.m1().E(str);
        }
    }

    public void w(String str) {
        if (StringUtils.isNull(str) || ListUtils.isEmpty(this.f57463f.j())) {
            return;
        }
        Iterator<d.b.b.j.e.n> it = this.f57463f.j().iterator();
        while (it.hasNext()) {
            d.b.b.j.e.n next = it.next();
            if (next instanceof d.b.i0.e.c) {
                d.b.i0.e.c cVar = (d.b.i0.e.c) next;
                if ((cVar.a() instanceof AdvertAppInfo) && str.equals(((AdvertAppInfo) cVar.a()).E3)) {
                    it.remove();
                }
            }
        }
    }

    public boolean x() {
        if (this.l) {
            return false;
        }
        this.f57462e.A(this.f57458a.getResources().getString(R.string.load_more_must_after_delete));
        this.f57462e.f();
        return true;
    }

    public void y() {
        u uVar = new u();
        uVar.f58581a = 503;
        uVar.f58582b = false;
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921449, uVar));
    }

    public void z() {
        this.f57463f.m();
    }
}
