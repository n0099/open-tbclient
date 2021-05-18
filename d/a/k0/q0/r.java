package d.a.k0.q0;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewStub;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.core.content.ContextCompat;
import androidx.core.view.ViewCompat;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.plugin.PluginCenter;
import com.baidu.adp.widget.ListView.BdTypeRecyclerView;
import com.baidu.adp.widget.design.behavior.AppBarLayoutStickyBehavior;
import com.baidu.tbadk.TbSingleton;
import com.baidu.tbadk.core.BaseFragment;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.core.util.SelectImageHelper;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.SvgManager;
import com.baidu.tbadk.core.util.TbImageHelper;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.WebPManager;
import com.baidu.tbadk.core.view.MessageRedDotView;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.core.view.NoNetworkView;
import com.baidu.tbadk.core.view.NoPressedRelativeLayout;
import com.baidu.tbadk.core.view.PbListView;
import com.baidu.tbadk.core.view.UserPhotoLayout;
import com.baidu.tbadk.gif.GifView;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tbadk.widget.layout.ObservedChangeLinearLayout;
import com.baidu.tieba.R;
import com.baidu.tieba.frs.FrsAllThreadFragment;
import com.baidu.tieba.frs.FrsFragment;
import com.baidu.tieba.frs.mc.FrsNewAreaFragment;
import com.baidu.tieba.frs.vc.FrsTabViewController;
import com.baidu.tieba.frs.view.FrsHeaderViewContainer;
import com.baidu.tieba.frs.view.FrsMoveAreaBottomMenuView;
import com.baidu.tieba.frs.view.FrsMultiDelBottomMenuView;
import com.baidu.tieba.tbadkCore.FrsCommonImageLayout;
import com.baidu.tieba.tbadkCore.FrsViewData;
import com.baidu.tieba.tbadkCore.voice.PlayVoiceBnt;
import com.baidu.tieba.tbadkCore.writeModel.PostWriteCallBackData;
import com.baidu.tieba.view.CommonTipView;
import com.baidu.tieba.view.NavigationBarCoverTip;
import com.google.android.material.appbar.AppBarLayout;
import com.google.android.material.appbar.CollapsingToolbarLayout;
import d.a.c.e.g.d;
import d.a.j0.r.q.k2;
import d.a.j0.r.q.z1;
import d.a.j0.r.s.b;
import d.a.k0.h.e;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
/* loaded from: classes4.dex */
public class r {
    public View A;
    public int D;
    public CommonTipView F;
    public d.a.k0.q0.o2.d G;
    public d.a.k0.q0.n1.e.c H;
    public d.a.k0.q0.o2.m I;
    public GifView J;
    public TbImageView K;
    public HashSet<String> L;
    public d.a.k0.j2.i M;
    public ObservedChangeLinearLayout R;
    public d.a.k0.q0.n1.e.a T;
    public d.a.k0.q3.e V;
    public AppBarLayout W;
    public AppBarLayoutStickyBehavior X;
    public FrsHeaderViewContainer Y;
    public CollapsingToolbarLayout Z;

    /* renamed from: a  reason: collision with root package name */
    public FrsFragment f59339a;
    public int d0;

    /* renamed from: e  reason: collision with root package name */
    public View f59343e;
    public d.a.k0.q0.o2.h e0;

    /* renamed from: f  reason: collision with root package name */
    public ImageView f59344f;
    public FrsMultiDelBottomMenuView f0;

    /* renamed from: g  reason: collision with root package name */
    public ImageView f59345g;
    public FrsMoveAreaBottomMenuView g0;

    /* renamed from: h  reason: collision with root package name */
    public MessageRedDotView f59346h;
    public NavigationBarCoverTip h0;

    /* renamed from: i  reason: collision with root package name */
    public d.a.k0.b0.d f59347i;
    public TextView i0;
    public ImageView j;
    public TextView j0;
    public ImageView k;
    public TextView l;
    public ViewStub m;
    public d.a.c.j.e.l n0;
    public PbListView q;
    public BdTypeRecyclerView r;
    public boolean r0;
    public d.a.k0.q0.n1.d.e0 s;
    public d.a.k0.q0.o2.k t;
    public View.OnClickListener v;
    public NoNetworkView x;
    public NavigationBar y;
    public View z;

    /* renamed from: b  reason: collision with root package name */
    public NoPressedRelativeLayout f59340b = null;

    /* renamed from: c  reason: collision with root package name */
    public CoordinatorLayout f59341c = null;

    /* renamed from: d  reason: collision with root package name */
    public View f59342d = null;
    public FrameLayout n = null;
    public TbImageView o = null;
    public TbImageView p = null;
    public d.a.j0.r.s.b u = null;
    public NoNetworkView.b w = null;
    public boolean B = true;
    public boolean C = true;
    public boolean E = false;
    public int N = 0;
    public int O = 0;
    public View P = null;
    public View Q = null;
    public boolean S = false;
    public boolean U = true;
    public boolean a0 = true;
    public int b0 = -1;
    public int c0 = -1;
    public int k0 = 0;
    public int l0 = 0;
    public boolean m0 = false;
    public CustomMessageListener o0 = new e(2156674);
    public AppBarLayout.OnOffsetChangedListener p0 = new f();
    public Runnable q0 = new m();

    /* loaded from: classes4.dex */
    public class a implements d.a.c.e.g.b {
        public a() {
        }

        @Override // d.a.c.e.g.b
        public int a() {
            return 4;
        }

        @Override // d.a.c.e.g.b
        public int b() {
            return 16;
        }

        @Override // d.a.c.e.g.b
        public View c(LayoutInflater layoutInflater) {
            View inflate = layoutInflater.inflate(R.layout.tips_blue_left_up, (ViewGroup) null);
            ((TextView) inflate.findViewById(R.id.tips)).setText(R.string.frs_video_activity_guide_tip);
            r.this.f59339a.getPageContext().getLayoutMode().j(inflate);
            return inflate;
        }

        @Override // d.a.c.e.g.b
        public int getXOffset() {
            return d.a.c.e.p.l.g(r.this.f59339a.getActivity(), R.dimen.ds10);
        }

        @Override // d.a.c.e.g.b
        public int getYOffset() {
            return -d.a.c.e.p.l.g(r.this.f59339a.getActivity(), R.dimen.ds6);
        }
    }

    /* loaded from: classes4.dex */
    public class b implements d.a {
        public b(r rVar) {
        }

        @Override // d.a.c.e.g.d.a
        public void onDismiss() {
            d.a.j0.r.d0.b.j().w("frs_video_activity_guide", 1L);
        }

        @Override // d.a.c.e.g.d.a
        public void onShown() {
        }
    }

    /* loaded from: classes4.dex */
    public class c implements Runnable {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ d.a.c.e.g.c f59349e;

        public c(r rVar, d.a.c.e.g.c cVar) {
            this.f59349e = cVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            d.a.c.e.g.c cVar = this.f59349e;
            if (cVar != null) {
                cVar.d();
            }
        }
    }

    /* loaded from: classes4.dex */
    public class d implements Runnable {
        public d() {
        }

        @Override // java.lang.Runnable
        public void run() {
            r.this.U().notifyDataSetChanged();
            if (r.this.m0) {
                return;
            }
            r.this.M.n(r.this.N, r.this.O, r.this.E, true);
        }
    }

    /* loaded from: classes4.dex */
    public class e extends CustomMessageListener {
        public e(int i2) {
            super(i2);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage == null || !(customResponsedMessage.getData() instanceof Boolean)) {
                return;
            }
            if (((Boolean) customResponsedMessage.getData()).booleanValue()) {
                if (r.this.n0 == null) {
                    r.this.n0 = new d.a.c.j.e.l(new d.a.c.j.e.j());
                }
                r.this.n0.q(r.this.r, 2);
            } else if (r.this.n0 != null) {
                r.this.n0.w();
            }
        }
    }

    /* loaded from: classes4.dex */
    public class f implements AppBarLayout.OnOffsetChangedListener {
        public f() {
        }

        @Override // com.google.android.material.appbar.AppBarLayout.OnOffsetChangedListener, com.google.android.material.appbar.AppBarLayout.BaseOnOffsetChangedListener
        public void onOffsetChanged(AppBarLayout appBarLayout, int i2) {
            r.this.K(appBarLayout, i2);
            if (r.this.t != null) {
                r.this.t.y(i2 == 0);
            }
            if (r.this.c0 != i2 && Math.abs(i2) >= 0 && r.this.Q() != -1) {
                if (Math.abs(i2) >= r.this.Q()) {
                    if (r.this.a0) {
                        r.this.a0 = false;
                        r rVar = r.this;
                        rVar.G0(rVar.a0);
                    }
                } else if (!r.this.a0) {
                    r.this.a0 = true;
                    r rVar2 = r.this;
                    rVar2.G0(rVar2.a0);
                }
                int X = r.this.X() + r.this.d0() + r.this.f0();
                int totalScrollRange = appBarLayout.getTotalScrollRange() - X;
                int totalScrollRange2 = appBarLayout.getTotalScrollRange() - Math.abs(i2);
                if (totalScrollRange <= 0) {
                    return;
                }
                float abs = Math.abs(i2 * 1.0f) / totalScrollRange;
                if (Float.compare(abs, 1.0f) > 0) {
                    abs = 1.0f;
                }
                if (Float.compare(abs, 0.05f) <= 0 && r.this.c0 - i2 < 0) {
                    abs = 0.0f;
                }
                if (Float.compare(abs, 1.0f) == 0) {
                    r.this.L1(Math.abs(X - totalScrollRange2));
                    if (r.this.Q != null) {
                        r.this.Q.setVisibility(0);
                    }
                } else if (r.this.Q != null) {
                    if (r.this.l0() != UtilHelper.getStatusBarHeight()) {
                        r.this.L1(0);
                    }
                    r.this.Q.setVisibility(8);
                }
                if (r.this.y != null) {
                    if (r.this.S) {
                        r.this.y.getBarBgView().setAlpha(abs);
                        r.this.O1(false);
                    } else if (r.this.j0 != null) {
                        r.this.j0.setAlpha(abs);
                    }
                }
                r.this.c0 = i2;
                CustomResponsedMessage customResponsedMessage = new CustomResponsedMessage(2921397, Integer.valueOf(i2));
                CustomMessage customMessage = new CustomMessage(2921397);
                if (r.this.f59339a != null && r.this.f59339a.y2() != null && r.this.f59339a.y2().y() != null && (r.this.f59339a.y2().y().f15858b instanceof BaseFragment)) {
                    customMessage.setTag(((BaseFragment) r.this.f59339a.y2().y().f15858b).getUniqueId());
                    customResponsedMessage.setOrginalMessage(customMessage);
                }
                MessageManager.getInstance().dispatchResponsedMessage(customResponsedMessage);
            }
            if (r.this.t != null) {
                int q = r.this.t.q();
                int p = q - r.this.t.p();
                if (q <= 0 || Math.abs(i2) < p) {
                    return;
                }
                r.this.t.l();
            }
        }
    }

    /* loaded from: classes4.dex */
    public class g implements d.a.j0.b1.j.e {
        public g() {
        }

        @Override // d.a.j0.b1.j.e
        public void a(View view, int i2, int i3, int i4, int i5) {
            if (i3 == i5 || i5 <= 0) {
                return;
            }
            r.this.Z.setMinimumHeight(i3);
        }
    }

    /* loaded from: classes4.dex */
    public class h extends DefaultItemAnimator {

        /* renamed from: a  reason: collision with root package name */
        public int f59354a = 0;

        public h() {
        }

        @Override // androidx.recyclerview.widget.SimpleItemAnimator
        public void onRemoveFinished(RecyclerView.ViewHolder viewHolder) {
            super.onRemoveFinished(viewHolder);
            int i2 = this.f59354a - 1;
            this.f59354a = i2;
            if (i2 == 0) {
                r.this.r.getAdapter().notifyDataSetChanged();
            }
        }

        @Override // androidx.recyclerview.widget.SimpleItemAnimator
        public void onRemoveStarting(RecyclerView.ViewHolder viewHolder) {
            this.f59354a++;
            super.onRemoveStarting(viewHolder);
        }
    }

    /* loaded from: classes4.dex */
    public class i extends LinearLayoutManager {
        public i(r rVar, Context context) {
            super(context);
        }

        @Override // androidx.recyclerview.widget.LinearLayoutManager, androidx.recyclerview.widget.RecyclerView.LayoutManager
        public void onLayoutChildren(RecyclerView.Recycler recycler, RecyclerView.State state) {
            try {
                super.onLayoutChildren(recycler, state);
            } catch (Throwable unused) {
            }
        }
    }

    /* loaded from: classes4.dex */
    public class j implements RecyclerView.RecyclerListener {
        public j() {
        }

        @Override // androidx.recyclerview.widget.RecyclerView.RecyclerListener
        public void onViewRecycled(RecyclerView.ViewHolder viewHolder) {
            View view = viewHolder.itemView;
            if (r.this.M != null) {
                r.this.M.k(view);
            }
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

    /* loaded from: classes4.dex */
    public class k implements View.OnClickListener {
        public k() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            r.this.f59339a.E2();
            if (r.this.f59339a == null || r.this.W == null) {
                return;
            }
            r.this.f59339a.c3();
            r.this.W.setExpanded(true);
            if (r.this.M != null) {
                r.this.M.n(r.this.N, r.this.O, false, true);
            }
        }
    }

    /* loaded from: classes4.dex */
    public class l implements b.c {
        public l() {
        }

        @Override // d.a.j0.r.s.b.c
        public void a(d.a.j0.r.s.b bVar, int i2, View view) {
            bVar.e();
            if (i2 == 0) {
                r.this.f59339a.N3();
            } else if (i2 != 1 || r.this.f59339a.getPageContext() == null) {
            } else {
                SelectImageHelper.getAlbumImage(r.this.f59339a.getPageContext().getPageActivity());
            }
        }
    }

    /* loaded from: classes4.dex */
    public class m implements Runnable {
        public m() {
        }

        @Override // java.lang.Runnable
        public void run() {
            if (r.this.m == null) {
                return;
            }
            r.this.n.setVisibility(0);
            r.this.p.setVisibility(0);
            r.this.o.setVisibility(8);
        }
    }

    public r(FrsFragment frsFragment, View.OnClickListener onClickListener, d.a.k0.q0.n1.e.a aVar, boolean z, d.a.k0.q0.o2.h hVar) {
        this.f59339a = null;
        this.v = null;
        this.D = 0;
        this.f59339a = frsFragment;
        this.v = onClickListener;
        MessageManager.getInstance().registerListener(this.o0);
        w0(aVar, z);
        this.L = new HashSet<>();
        this.D = TbadkCoreApplication.getInst().getMainTabBottomBarHeight();
        this.d0 = TbadkCoreApplication.getInst().getSkinType();
        this.e0 = hVar;
    }

    public boolean A0() {
        d.a.k0.q0.o2.k kVar = this.t;
        if (kVar != null) {
            return kVar.o() instanceof FrsNewAreaFragment;
        }
        return false;
    }

    public void A1(k2 k2Var) {
        if (this.m == null) {
            View x2 = this.f59339a.x2();
            ViewStub viewStub = (ViewStub) x2.findViewById(R.id.yule_game_egg_view_stub);
            this.m = viewStub;
            viewStub.setVisibility(0);
            this.n = (FrameLayout) x2.findViewById(R.id.game_activity_egg_layout);
            this.o = (TbImageView) x2.findViewById(R.id.game_activity_egg);
            this.p = (TbImageView) x2.findViewById(R.id.game_activity_egg_s);
            this.o.setPageId(this.f59339a.getUniqueId());
            this.p.setPageId(this.f59339a.getUniqueId());
            this.o.setDefaultBgResource(R.color.common_color_10022);
            this.o.setDefaultResource(0);
            this.p.setDefaultBgResource(R.color.common_color_10022);
            this.p.setDefaultResource(0);
            this.n.setOnClickListener(this.v);
        }
        this.n.setVisibility(0);
        String a2 = k2Var.a();
        String b2 = k2Var.b();
        this.o.V(a2, 10, false);
        this.p.V(b2, 10, false);
        TbadkCoreApplication.getInst().handler.postDelayed(this.q0, 5000L);
    }

    public boolean B0() {
        d.a.k0.q0.o2.d dVar = this.G;
        if (dVar == null) {
            return false;
        }
        return dVar.p();
    }

    public void B1() {
        this.r.setVisibility(0);
    }

    public void C0() {
        d.a.k0.q0.n1.d.e0 e0Var = this.s;
        if (e0Var instanceof d.a.k0.q0.n1.d.q) {
            ((d.a.k0.q0.n1.d.q) e0Var).r();
        }
    }

    public void C1() {
        this.C = true;
        this.r.setNextPage(this.q);
        int i2 = this.D;
        if (i2 > 0) {
            this.q.J(i2);
        }
        this.q.z(null);
        this.q.O();
    }

    public void D0() {
        d.a.k0.q0.n1.d.e0 e0Var = this.s;
        if (e0Var != null) {
            e0Var.notifyDataSetChanged();
        }
    }

    public final void D1(int i2) {
        d.a.k0.b0.d dVar = this.f59347i;
        if (dVar != null) {
            dVar.g(i2);
        }
    }

    public void E0(boolean z) {
        this.m0 = z;
        if (this.M == null) {
            return;
        }
        FrsFragment frsFragment = this.f59339a;
        boolean z2 = (frsFragment == null || frsFragment.y2() == null || this.f59339a.y2().y() == null) ? true : this.f59339a.y2().y().f15858b instanceof FrsAllThreadFragment;
        if (!z && z2) {
            this.M.q(true);
            this.M.n(this.N, this.O, this.E, true);
            return;
        }
        this.M.q(false);
        this.M.x();
    }

    public void E1(String str, int i2) {
        if (this.i0 == null) {
            TextView textView = new TextView(this.f59339a.getActivity());
            this.i0 = textView;
            textView.setGravity(19);
            this.i0.setPadding(d.a.c.e.p.l.g(this.f59339a.getActivity(), R.dimen.ds34), 0, d.a.c.e.p.l.g(this.f59339a.getActivity(), R.dimen.ds34), 0);
            this.i0.setLayoutParams(new ViewGroup.LayoutParams(-1, d.a.c.e.p.l.g(this.f59339a.getActivity(), R.dimen.tbds112)));
            this.i0.setTextSize(0, d.a.c.e.p.l.g(this.f59339a.getActivity(), R.dimen.fontsize30));
            this.i0.setMaxLines(2);
            this.i0.setEllipsize(TextUtils.TruncateAt.valueOf("END"));
            this.i0.setTextColor(ContextCompat.getColor(this.f59339a.getActivity(), R.color.CAM_X0101));
        }
        this.h0.setBackgroundColor(i2);
        this.i0.setText(str);
        this.h0.m(this.f59339a.getActivity(), this.i0, 5000);
    }

    public void F0(int i2, int i3) {
        d.a.k0.j2.i iVar = this.M;
        if (iVar == null) {
            return;
        }
        iVar.m(i2, i3, this.E, 1);
    }

    public void F1() {
        this.C = false;
        this.r.setNextPage(this.q);
        int i2 = this.D;
        if (i2 > 0) {
            this.q.J(i2);
        }
        this.q.z(null);
        this.q.f();
        this.q.A(this.f59339a.getResources().getString(R.string.list_has_no_more));
    }

    public final void G0(boolean z) {
        FrsFragment frsFragment;
        if (!z || (frsFragment = this.f59339a) == null || frsFragment.P() == null) {
            return;
        }
        this.f59339a.P().W();
    }

    public void G1() {
        N();
        d.a.j0.r.s.b bVar = this.u;
        if (bVar != null) {
            bVar.m();
        }
    }

    public void H(RecyclerView.OnScrollListener onScrollListener) {
        this.r.addOnScrollListener(onScrollListener);
    }

    public void H0(int i2) {
        this.d0 = i2;
        d.a.k0.e.f.b bVar = new d.a.k0.e.f.b(this.f59339a, 4);
        bVar.D(i2);
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016515, bVar));
        d.a.k0.e.f.a aVar = new d.a.k0.e.f.a(this.f59339a.getPageContext(), 4);
        aVar.l(i2);
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016516, aVar));
        TbImageView tbImageView = this.K;
        if (tbImageView != null) {
            tbImageView.invalidate();
        }
        d.a.k0.q0.n1.d.e0 e0Var = this.s;
        if (e0Var != null) {
            e0Var.b();
            this.s.notifyDataSetChanged();
        }
        d.a.j0.s0.a.a(this.f59339a.getPageContext(), this.f59340b);
        NoNetworkView noNetworkView = this.x;
        if (noNetworkView != null) {
            noNetworkView.c(this.f59339a.getPageContext(), i2);
        }
        PbListView pbListView = this.q;
        if (pbListView != null) {
            pbListView.C(SkinManager.getColor(R.color.CAM_X0109));
            this.q.d(i2);
        }
        TextView textView = this.j0;
        if (textView != null) {
            textView.setTextColor(SkinManager.getColor(R.color.CAM_X0105));
        }
        I(i2);
        d.a.k0.q0.n1.e.c cVar = this.H;
        if (cVar != null) {
            cVar.onChangeSkinType(i2);
        }
        d.a.k0.q0.o2.d dVar = this.G;
        if (dVar != null) {
            dVar.u(i2);
        }
        FrsMultiDelBottomMenuView frsMultiDelBottomMenuView = this.f0;
        if (frsMultiDelBottomMenuView != null) {
            frsMultiDelBottomMenuView.d();
        }
        FrsMoveAreaBottomMenuView frsMoveAreaBottomMenuView = this.g0;
        if (frsMoveAreaBottomMenuView != null) {
            frsMoveAreaBottomMenuView.c();
        }
        SkinManager.setBackgroundColor(this.f59342d, R.color.CAM_X0202);
    }

    public void H1(PostWriteCallBackData postWriteCallBackData) {
        if (postWriteCallBackData == null || postWriteCallBackData.mFrom != 2) {
            return;
        }
        if (postWriteCallBackData.getIconStampData() != null) {
            d.a.j0.s.h.b.a(this.f59339a.o(), postWriteCallBackData);
            return;
        }
        if (this.V == null) {
            this.V = new d.a.k0.q3.e(this.f59339a.getActivity(), this.f59340b);
        }
        this.V.g(postWriteCallBackData);
    }

    public final void I(int i2) {
        if (this.f59339a == null) {
            return;
        }
        J(i2);
    }

    public void I0() {
        MessageManager.getInstance().unRegisterListener(this.o0);
        d.a.k0.j2.i iVar = this.M;
        if (iVar != null) {
            iVar.h();
        }
        d.a.k0.q0.o2.m mVar = this.I;
        if (mVar != null) {
            mVar.c();
        }
        FrsMultiDelBottomMenuView frsMultiDelBottomMenuView = this.f0;
        if (frsMultiDelBottomMenuView != null) {
            frsMultiDelBottomMenuView.setPageContext(null);
        }
        FrsMoveAreaBottomMenuView frsMoveAreaBottomMenuView = this.g0;
        if (frsMoveAreaBottomMenuView != null) {
            frsMoveAreaBottomMenuView.setPageContext(null);
        }
        this.s.m();
        this.r.setOnSrollToBottomListener(null);
        this.r.setScrollable(null);
        TbadkCoreApplication.getInst().handler.removeCallbacks(this.q0);
        CommonTipView commonTipView = this.F;
        if (commonTipView != null) {
            commonTipView.i();
        }
        this.L.clear();
        d.a.k0.q0.o2.d dVar = this.G;
        if (dVar != null) {
            dVar.r();
        }
        d.a.k0.q3.e eVar = this.V;
        if (eVar != null) {
            eVar.e();
        }
        NavigationBarCoverTip navigationBarCoverTip = this.h0;
        if (navigationBarCoverTip != null) {
            navigationBarCoverTip.i();
        }
        FrsMultiDelBottomMenuView frsMultiDelBottomMenuView2 = this.f0;
        if (frsMultiDelBottomMenuView2 != null) {
            frsMultiDelBottomMenuView2.e();
        }
        d.a.k0.q0.o2.k kVar = this.t;
        if (kVar != null) {
            kVar.u();
        }
    }

    public void I1() {
        int headerViewsCount;
        if (d.a.j0.r.d0.b.j().l("frs_video_activity_guide", 0L) != 0 || this.r0 || this.f59339a.getActivity() == null || this.f59339a.getPageContext() == null) {
            return;
        }
        View view = null;
        BdTypeRecyclerView bdTypeRecyclerView = this.r;
        if (bdTypeRecyclerView != null && (headerViewsCount = bdTypeRecyclerView.getHeaderViewsCount()) < this.r.getChildCount()) {
            view = this.r.getChildAt(headerViewsCount);
        }
        if (view != null) {
            d.a.c.e.g.d dVar = new d.a.c.e.g.d();
            dVar.j(view);
            dVar.c(0);
            dVar.i(true);
            dVar.h(false);
            dVar.d(true);
            dVar.a(new a());
            dVar.g(new b(this));
            d.a.c.e.g.c b2 = dVar.b();
            b2.k(false);
            b2.m(this.f59339a.getActivity());
            d.a.c.e.m.e.a().postDelayed(new c(this, b2), PluginCenter.PLUGIN_RETRY_MIN_TIME_INTERVAL);
            this.r0 = true;
        }
    }

    public final void J(int i2) {
        NavigationBar navigationBar = this.y;
        if (navigationBar != null) {
            navigationBar.onChangeSkinType(this.f59339a.getPageContext(), i2);
            if (this.y.getBackground() != null && this.y.getBackground().mutate() != null) {
                this.y.getBackground().mutate().setAlpha(0);
            }
            SkinManager.setBackgroundColor(this.y.getBarBgView(), R.color.CAM_X0207);
            SkinManager.setBackgroundColor(this.y.getBottomLine(), R.color.CAM_X0204);
            SkinManager.setBackgroundColor(this.z, R.color.CAM_X0204, i2);
            d.a.k0.b0.d dVar = this.f59347i;
            if (dVar != null) {
                dVar.d(i2);
            }
            if (this.k != null) {
                SvgManager.getInstance().setPureDrawableWithDayNightModeAutoChange(this.k, R.drawable.ic_icon_pure_topbar_search40_svg, R.color.CAM_X0106, SvgManager.SvgResourceStateType.NORMAL_PRESS);
            }
            if (this.j != null) {
                SvgManager.getInstance().setPureDrawableWithDayNightModeAutoChange(this.j, R.drawable.ic_icon_pure_topbar_share40_svg, R.color.CAM_X0106, SvgManager.SvgResourceStateType.NORMAL_PRESS);
            }
        }
        SkinManager.setBackgroundColor(this.P, R.color.CAM_X0207);
        SkinManager.setBackgroundColor(this.Q, R.color.CAM_X0207);
        O1(true);
    }

    public boolean J0() {
        AppBarLayoutStickyBehavior appBarLayoutStickyBehavior;
        if (this.W != null && (appBarLayoutStickyBehavior = this.X) != null && appBarLayoutStickyBehavior.isSticky()) {
            BdTypeRecyclerView bdTypeRecyclerView = this.r;
            if (bdTypeRecyclerView != null) {
                bdTypeRecyclerView.setSelection(0);
            }
            this.X.expandedAppBarLayout(this.W);
            return true;
        }
        d.a.k0.q0.o2.d dVar = this.G;
        return dVar != null && dVar.v();
    }

    public void J1(boolean z) {
        if (this.G != null) {
            if (d.a.j0.x.d.h().k()) {
                this.G.A(false);
            } else {
                this.G.A(z);
            }
        }
    }

    public final void K(AppBarLayout appBarLayout, int i2) {
        ViewGroup.MarginLayoutParams marginLayoutParams;
        FrsFragment frsFragment = this.f59339a;
        if (frsFragment == null || appBarLayout == null || frsFragment.y2() == null || this.f59339a.getPageContext() == null) {
            return;
        }
        int X = X() + d0() + f0();
        int totalScrollRange = appBarLayout.getTotalScrollRange() - Math.abs(i2);
        FrsTabViewController y2 = this.f59339a.y2();
        ViewGroup.LayoutParams layoutParams = this.f59342d.getLayoutParams();
        if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
            marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
        } else {
            marginLayoutParams = new ViewGroup.MarginLayoutParams(layoutParams);
        }
        FrsFragment frsFragment2 = this.f59339a;
        boolean z = frsFragment2 != null && frsFragment2.Q2();
        if (totalScrollRange <= 0) {
            if (this.l0 != 2) {
                y2.f(2);
            }
            this.l0 = 2;
            marginLayoutParams.topMargin = 0;
        } else if (totalScrollRange > 0 && totalScrollRange <= X) {
            if (this.l0 != 1) {
                y2.f(1);
            }
            this.l0 = 1;
            marginLayoutParams.topMargin = 0;
        } else {
            if (this.l0 != 0) {
                y2.f(0);
            }
            this.l0 = 0;
            if (z) {
                marginLayoutParams.topMargin = d.a.c.e.p.l.g(this.f59339a.getActivity(), R.dimen.tbds_30);
            } else {
                marginLayoutParams.topMargin = 0;
            }
        }
        if (z) {
            this.f59342d.setLayoutParams(marginLayoutParams);
        }
        Log.d("FrsMainView", "changeTabState() called with: leftSpace = [" + totalScrollRange + "], verticalOffset = [" + i2 + "]");
    }

    public void K0() {
        d.a.k0.q0.o2.d dVar = this.G;
        if (dVar != null) {
            dVar.s();
        }
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016524));
    }

    public void K1() {
        d.a.k0.q0.o2.k kVar = this.t;
        if (kVar != null) {
            kVar.B();
        }
    }

    public void L(String str) {
        d.a.k0.q0.o2.m mVar = this.I;
        if (mVar != null) {
            mVar.a(str);
        }
    }

    public void L0(boolean z) {
    }

    public final void L1(int i2) {
        View k0 = k0();
        View m0 = m0();
        if (!UtilHelper.canUseStyleImmersiveSticky() || k0 == null || m0 == null || k0.getLayoutParams() == null || m0.getLayoutParams() == null) {
            return;
        }
        ViewGroup.LayoutParams layoutParams = k0.getLayoutParams();
        int statusBarHeight = UtilHelper.getStatusBarHeight() - i2;
        layoutParams.height = statusBarHeight;
        if (statusBarHeight < 0) {
            layoutParams.height = 0;
        }
        k0.setLayoutParams(layoutParams);
        ViewGroup.LayoutParams layoutParams2 = m0.getLayoutParams();
        layoutParams2.height = i2;
        if (i2 > UtilHelper.getStatusBarHeight()) {
            layoutParams2.height = UtilHelper.getStatusBarHeight();
        }
        m0.setLayoutParams(layoutParams2);
    }

    public final void M() {
        this.k.setVisibility(0);
        this.j.setVisibility(0);
    }

    public void M0() {
        I(TbadkCoreApplication.getInst().getSkinType());
        d.a.k0.q0.o2.d dVar = this.G;
        if (dVar != null) {
            dVar.t();
        }
    }

    public void M1() {
        d.a.k0.q0.o2.k kVar = this.t;
        if (kVar != null) {
            kVar.C();
        }
    }

    public final void N() {
        if (this.u != null || this.f59339a.getPageContext() == null) {
            return;
        }
        String[] strArr = {this.f59339a.getPageContext().getPageActivity().getString(R.string.take_photo), this.f59339a.getPageContext().getPageActivity().getString(R.string.album)};
        d.a.j0.r.s.b bVar = new d.a.j0.r.s.b(this.f59339a.getPageContext().getPageActivity());
        this.u = bVar;
        bVar.l(this.f59339a.getPageContext().getPageActivity().getString(R.string.operation));
        this.u.j(strArr, new l());
        this.u.c(this.f59339a.getPageContext());
    }

    public void N0() {
        if (U() == null) {
            return;
        }
        List<d.a.c.j.e.n> f2 = U().f();
        if (ListUtils.isEmpty(f2)) {
            return;
        }
        for (d.a.c.j.e.n nVar : f2) {
            if (nVar instanceof z1) {
                z1 z1Var = (z1) nVar;
                if (z1Var.x != 0 && z1Var.w != null && this.f59339a.b0() != null && this.f59339a.b0().Z() != null) {
                    int[] p0 = z1Var.w.p0();
                    z1Var.x = p0[0];
                    z1Var.y = p0[1];
                }
            }
        }
        d.a.c.e.m.e.a().postDelayed(new d(), 500L);
    }

    public final void N1() {
        NavigationBar navigationBar = this.y;
        if (navigationBar == null) {
            return;
        }
        float alpha = navigationBar.getBarBgView() != null ? this.y.getBarBgView().getAlpha() : 0.0f;
        float f2 = alpha < 0.5f ? 1.0f - (alpha * 2.0f) : (alpha * 2.0f) - 1.0f;
        if (Float.compare(f2, 0.0f) < 0) {
            f2 = 0.0f;
        }
        if (Float.compare(f2, 1.0f) > 0) {
            f2 = 1.0f;
        }
        TextView textView = this.j0;
        if (textView != null) {
            textView.setAlpha(alpha);
        }
        if (f2 >= 0.0f && f2 <= 1.0f) {
            ImageView imageView = this.f59344f;
            if (imageView != null) {
                imageView.setAlpha(f2);
            }
            ImageView imageView2 = this.f59345g;
            if (imageView2 != null) {
                imageView2.setAlpha(f2);
            }
            FrsFragment frsFragment = this.f59339a;
            if (frsFragment != null && frsFragment.y2() != null && this.k0 == 1) {
                this.f59339a.y2().a0(f2);
            }
            MessageRedDotView messageRedDotView = this.f59346h;
            if (messageRedDotView != null) {
                messageRedDotView.setAlpha(f2);
            }
            ImageView imageView3 = this.k;
            if (imageView3 != null) {
                imageView3.setAlpha(f2);
            }
            ImageView imageView4 = this.j;
            if (imageView4 != null) {
                imageView4.setAlpha(f2);
            }
        }
        TextView textView2 = this.l;
        if (textView2 != null) {
            float f3 = 1.0f - (2.0f * alpha);
            textView2.setAlpha(f3);
            this.l.setClickable(f3 > 0.0f);
        }
        View view = this.P;
        if (view != null) {
            view.setAlpha(alpha);
        }
        View view2 = this.Q;
        if (view2 != null) {
            view2.setAlpha(alpha);
        }
        View view3 = this.z;
        if (view3 != null) {
            view3.setAlpha(alpha);
        }
    }

    public void O() {
        FrsMultiDelBottomMenuView frsMultiDelBottomMenuView = this.f0;
        if (frsMultiDelBottomMenuView != null) {
            frsMultiDelBottomMenuView.a();
        }
    }

    public void O0(int i2) {
        if (TbadkCoreApplication.getCurrentAccount() == null) {
            if ((i2 == 3 || i2 == 6) && d.a.j0.r.d0.b.j().g("frs_login_tip", true)) {
                if (this.F == null) {
                    this.F = new CommonTipView(this.f59339a.getActivity());
                }
                this.F.setText(R.string.frs_login_tip);
                this.F.j((FrameLayout) S(), TbadkCoreApplication.getInst().getSkinType());
                d.a.j0.r.d0.b.j().t("frs_login_tip", false);
            }
        }
    }

    public final void O1(boolean z) {
        NavigationBar navigationBar = this.y;
        if (navigationBar == null || navigationBar.getBarBgView() == null || !this.S) {
            return;
        }
        if (this.y.getBarBgView().getAlpha() < 0.5f) {
            if (z || this.k0 != 0) {
                SvgManager.getInstance().setPureDrawableWithDayNightModeAutoChange(this.f59344f, R.drawable.ic_icon_pure_topbar_return40_svg, R.color.white_alpha100, SvgManager.SvgResourceStateType.NORMAL_PRESS);
                SvgManager.getInstance().setPureDrawableWithDayNightModeAutoChange(this.k, R.drawable.ic_icon_pure_topbar_search40_svg, R.color.white_alpha100, SvgManager.SvgResourceStateType.NORMAL_PRESS);
                this.f59345g.setImageDrawable(WebPManager.getPureDrawable(R.drawable.icon_pure_topbar_information40, SkinManager.getColor(R.color.CAM_X0101), null));
                SvgManager.getInstance().setPureDrawableWithDayNightModeAutoChange(this.j, R.drawable.ic_icon_pure_topbar_share40_svg, R.color.white_alpha100, SvgManager.SvgResourceStateType.NORMAL_PRESS);
                this.k0 = 0;
            }
        } else if (z || this.k0 != 1) {
            SvgManager.getInstance().setPureDrawableWithDayNightModeAutoChange(this.f59344f, R.drawable.ic_icon_pure_topbar_return40_svg, R.color.CAM_X0106, SvgManager.SvgResourceStateType.NORMAL_PRESS);
            SvgManager.getInstance().setPureDrawableWithDayNightModeAutoChange(this.k, R.drawable.ic_icon_pure_topbar_search40_svg, R.color.CAM_X0106, SvgManager.SvgResourceStateType.NORMAL_PRESS);
            this.f59345g.setImageDrawable(WebPManager.getPureDrawable(R.drawable.icon_pure_topbar_information40, SkinManager.getColor(R.color.CAM_X0106), null));
            SvgManager.getInstance().setPureDrawableWithDayNightModeAutoChange(this.j, R.drawable.ic_icon_pure_topbar_share40_svg, R.color.CAM_X0106, SvgManager.SvgResourceStateType.NORMAL_PRESS);
            this.k0 = 1;
        }
        N1();
    }

    public void P() {
        FrsMultiDelBottomMenuView frsMultiDelBottomMenuView = this.f0;
        if (frsMultiDelBottomMenuView != null) {
            frsMultiDelBottomMenuView.b();
        }
    }

    public void P0() {
        d.a.k0.q0.n1.e.c cVar;
        if (this.U && (cVar = this.H) != null) {
            cVar.b(false, false);
        }
        D1(8);
        this.k.setVisibility(8);
        this.j.setVisibility(8);
        J1(false);
        this.r.setVisibility(8);
        this.Y.setVisibility(8);
    }

    public final int Q() {
        AppBarLayout appBarLayout = this.W;
        if (appBarLayout == null) {
            return this.b0;
        }
        int i2 = this.b0;
        if (i2 != -1) {
            return i2;
        }
        int i3 = 0;
        for (int childCount = appBarLayout.getChildCount() - 1; childCount >= 0; childCount--) {
            View childAt = this.W.getChildAt(childCount);
            if (childAt != null) {
                int scrollFlags = ((AppBarLayout.LayoutParams) childAt.getLayoutParams()).getScrollFlags();
                if ((scrollFlags & 5) == 5) {
                    if ((scrollFlags & 8) != 0) {
                        i3 += ViewCompat.getMinimumHeight(childAt);
                    }
                } else if (i3 > 0) {
                    break;
                }
            }
        }
        int max = Math.max(0, this.W.getTotalScrollRange() - Math.abs(i3));
        this.b0 = max;
        return max;
    }

    public void Q0() {
        d.a.k0.q0.o2.k kVar = this.t;
        if (kVar != null) {
            kVar.B();
        }
    }

    public View R() {
        return this.f59343e;
    }

    public void R0() {
        w0(this.T, this.f59339a.K2());
        d.a.k0.q0.n1.d.e0 e0Var = this.s;
        if (e0Var != null) {
            e0Var.e();
        }
    }

    public View S() {
        return this.A;
    }

    public void S0(d.a.j0.r.q.f0 f0Var) {
        d.a.k0.e.f.a aVar = new d.a.k0.e.f.a(this.f59339a.getPageContext(), 1);
        aVar.j(this.r);
        HashMap hashMap = new HashMap();
        hashMap.put("forum_name", this.f59339a.g());
        hashMap.put("forum_id", this.f59339a.h());
        aVar.k(hashMap);
        aVar.i(f0Var);
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016516, aVar));
    }

    public Context T() {
        FrsFragment frsFragment = this.f59339a;
        if (frsFragment == null) {
            return null;
        }
        return frsFragment.o().getPageActivity();
    }

    public void T0(int i2, boolean z) {
        d.a.k0.b0.d dVar = this.f59347i;
        if (dVar != null) {
            dVar.e(z, i2);
        }
    }

    public d.a.k0.q0.n1.d.e0 U() {
        return this.s;
    }

    public void U0() {
        NoNetworkView.b bVar;
        NoNetworkView noNetworkView = this.x;
        if (noNetworkView == null || (bVar = this.w) == null) {
            return;
        }
        noNetworkView.d(bVar);
    }

    public d.a.k0.q0.o2.k V() {
        return this.t;
    }

    public void V0() {
        FrsMoveAreaBottomMenuView frsMoveAreaBottomMenuView = this.g0;
        if (frsMoveAreaBottomMenuView != null) {
            frsMoveAreaBottomMenuView.d();
        }
    }

    public d.a.k0.q0.o2.d W() {
        return this.G;
    }

    public boolean W0() {
        if (this.B) {
            return false;
        }
        this.q.A(this.f59339a.getResources().getString(R.string.load_more_must_after_delete));
        this.q.f();
        return true;
    }

    public final int X() {
        if (UtilHelper.canUseStyleImmersiveSticky()) {
            return UtilHelper.getStatusBarHeight();
        }
        return 0;
    }

    public void X0() {
        d.a.k0.q0.n1.e.c cVar;
        if (this.U && (cVar = this.H) != null) {
            cVar.b(true, false);
        }
        D1(0);
        M();
        J1(this.f59339a.d2());
        this.r.setVisibility(0);
        this.Y.setVisibility(0);
    }

    public boolean Y() {
        d.a.k0.q0.o2.k kVar = this.t;
        if (kVar == null) {
            return false;
        }
        return kVar.r();
    }

    public void Y0() {
        this.s.notifyDataSetChanged();
    }

    public BdTypeRecyclerView Z() {
        return this.r;
    }

    public void Z0(int i2) {
        d.a.k0.q0.o2.k kVar = this.t;
        if (kVar != null) {
            kVar.w(i2);
        }
    }

    public View a0() {
        PbListView pbListView = this.q;
        if (pbListView == null) {
            return null;
        }
        return pbListView.b();
    }

    public void a1(boolean z) {
        AppBarLayout appBarLayout = this.W;
        if (appBarLayout != null) {
            appBarLayout.setExpanded(z);
        }
    }

    public View b0() {
        d.a.k0.b0.d dVar = this.f59347i;
        if (dVar != null) {
            return dVar.c();
        }
        return null;
    }

    public void b1(int i2, int i3) {
        this.N = i2;
        this.O = i3;
    }

    public NavigationBar c0() {
        return this.y;
    }

    public void c1(String str) {
        this.s.a(str);
    }

    public final int d0() {
        NavigationBar navigationBar = this.y;
        if (navigationBar == null) {
            return 0;
        }
        return navigationBar.getHeight();
    }

    public void d1(int i2) {
        View view = this.f59342d;
        if (view != null) {
            view.setVisibility(i2);
        }
    }

    public ObservedChangeLinearLayout e0() {
        return this.R;
    }

    public void e1(boolean z) {
        d.a.k0.q0.n1.e.c cVar = this.H;
        if (cVar != null) {
            cVar.a(z);
        }
    }

    public final int f0() {
        if (this.x == null || d.a.c.e.p.j.z()) {
            return 0;
        }
        return this.x.getHeight();
    }

    public void f1(boolean z, boolean z2) {
        d.a.k0.q0.n1.e.c cVar;
        if (!this.U || (cVar = this.H) == null) {
            return;
        }
        cVar.b(z, z2);
    }

    public d.a.k0.j2.i g0() {
        return this.M;
    }

    public void g1(s0 s0Var) {
        d.a.k0.q0.o2.k kVar = this.t;
        if (kVar != null) {
            kVar.x(s0Var);
        }
    }

    public TextView h0() {
        return this.l;
    }

    public final void h1() {
        ViewGroup.LayoutParams layoutParams;
        this.S = s0();
        FrsHeaderViewContainer frsHeaderViewContainer = this.Y;
        if (frsHeaderViewContainer == null || (layoutParams = frsHeaderViewContainer.getLayoutParams()) == null || !(layoutParams instanceof ViewGroup.MarginLayoutParams)) {
            return;
        }
        if (this.S) {
            ((ViewGroup.MarginLayoutParams) layoutParams).setMargins(0, 0, 0, 0);
        } else {
            ((ViewGroup.MarginLayoutParams) layoutParams).setMargins(0, d.a.c.e.p.l.g(TbadkCoreApplication.getInst().getContext(), R.dimen.ds88) + X(), 0, 0);
        }
        this.Y.requestLayout();
    }

    public d.a.k0.q0.n1.e.c i0() {
        return this.H;
    }

    public void i1(boolean z) {
        d.a.k0.q0.n1.e.c cVar;
        this.U = z;
        if (z || (cVar = this.H) == null) {
            return;
        }
        cVar.b(false, false);
    }

    public RelativeLayout j0() {
        return this.f59340b;
    }

    public void j1(boolean z) {
        this.E = z;
    }

    public View k0() {
        return this.P;
    }

    public void k1(int i2, boolean z) {
        d.a.k0.q0.o2.k kVar = this.t;
        if (kVar != null) {
            kVar.z(i2, z);
        }
    }

    public final int l0() {
        View view = this.P;
        if (view == null) {
            return 0;
        }
        return view.getHeight();
    }

    public void l1(boolean z) {
        this.B = z;
        if (z) {
            this.q.A(this.f59339a.getResources().getString(R.string.load_more));
            BdTypeRecyclerView bdTypeRecyclerView = this.r;
            if (bdTypeRecyclerView.getChildAt(bdTypeRecyclerView.getChildCount() - 1) == this.q.b()) {
                this.q.O();
                this.f59339a.loadMore();
                return;
            }
            this.q.f();
            return;
        }
        this.q.A(this.f59339a.getResources().getString(R.string.load_more_must_after_delete));
        this.q.f();
    }

    public View m0() {
        return this.Q;
    }

    public void m1(int i2) {
        FrsMoveAreaBottomMenuView frsMoveAreaBottomMenuView = this.g0;
        if (frsMoveAreaBottomMenuView != null) {
            frsMoveAreaBottomMenuView.setVisibility(i2);
        }
    }

    public ImageView n0() {
        return this.k;
    }

    public void n1(int i2) {
        FrsMoveAreaBottomMenuView frsMoveAreaBottomMenuView = this.g0;
        if (frsMoveAreaBottomMenuView != null) {
            frsMoveAreaBottomMenuView.setMoveNumber(i2);
        }
    }

    public ImageView o0() {
        return this.j;
    }

    public void o1(int i2) {
        FrsMultiDelBottomMenuView frsMultiDelBottomMenuView = this.f0;
        if (frsMultiDelBottomMenuView != null) {
            frsMultiDelBottomMenuView.setSelectNumber(i2);
        }
    }

    public void p0() {
        FrameLayout frameLayout;
        if (this.m == null || (frameLayout = this.n) == null) {
            return;
        }
        frameLayout.setVisibility(8);
    }

    public void p1(int i2) {
        FrsMultiDelBottomMenuView frsMultiDelBottomMenuView = this.f0;
        if (frsMultiDelBottomMenuView != null) {
            frsMultiDelBottomMenuView.setVisibility(i2);
        }
    }

    public void q0() {
        this.C = false;
        this.r.setNextPage(null);
    }

    public void q1(e.c cVar) {
        FrsMultiDelBottomMenuView frsMultiDelBottomMenuView = this.f0;
        if (frsMultiDelBottomMenuView != null) {
            frsMultiDelBottomMenuView.setDeleteCallback(cVar);
        }
    }

    public void r0(boolean z) {
        if (this.H != null) {
            if (z) {
                f1(false, true);
            } else {
                f1(false, false);
            }
        }
    }

    public void r1(int i2) {
        this.D = i2;
    }

    public final boolean s0() {
        d.a.k0.q0.o2.h hVar = this.e0;
        return hVar != null && hVar.A();
    }

    public void s1(d.a.c.j.e.w wVar) {
        this.s.d(wVar);
    }

    public void t0() {
        d.a.k0.q0.o2.k kVar = this.t;
        if (kVar != null) {
            kVar.s();
        }
    }

    public void t1(NoNetworkView.b bVar) {
        this.w = bVar;
        NoNetworkView noNetworkView = this.x;
        if (noNetworkView != null) {
            noNetworkView.a(bVar);
        }
    }

    public void u0() {
        d.a.k0.q0.o2.k kVar = this.t;
        if (kVar != null) {
            kVar.t();
        }
    }

    public void u1(boolean z) {
        d.a.k0.q0.o2.k kVar = this.t;
        if (kVar != null) {
            kVar.A(z);
        }
    }

    public final void v0() {
        if (this.J != null) {
            return;
        }
        View x2 = this.f59339a.x2();
        this.J = (GifView) x2.findViewById(R.id.gif_real_time);
        TbImageView tbImageView = (TbImageView) x2.findViewById(R.id.tbimg_real_time);
        this.K = tbImageView;
        tbImageView.setPageId(this.f59339a.getUniqueId());
        this.J.setLayerType(1, null);
        this.K.setLayerType(1, null);
    }

    public void v1(ArrayList<d.a.c.j.e.n> arrayList, FrsViewData frsViewData) {
        int i2;
        if (frsViewData == null) {
            return;
        }
        ArrayList<d.a.c.j.e.n> switchThreadDataToThreadCardInfo = frsViewData.switchThreadDataToThreadCardInfo();
        if (ListUtils.isEmpty(switchThreadDataToThreadCardInfo) || !frsViewData.mHasThreadExceptTop) {
            t tVar = new t();
            ArrayList<d.a.c.j.e.n> arrayList2 = new ArrayList<>();
            arrayList2.add(tVar);
            FrsFragment frsFragment = this.f59339a;
            if (frsFragment != null && frsFragment.b0() != null && this.f59339a.b0().R() == 0) {
                tVar.e(this.f59339a.b0().N());
            }
            switchThreadDataToThreadCardInfo = arrayList2;
        }
        if (ListUtils.getCount(switchThreadDataToThreadCardInfo) > 0) {
            for (int i3 = 0; i3 < switchThreadDataToThreadCardInfo.size(); i3++) {
                d.a.c.j.e.n nVar = switchThreadDataToThreadCardInfo.get(i3);
                if (nVar instanceof z1) {
                    ((z1) nVar).w.i4(i3);
                }
            }
        }
        this.s.g(switchThreadDataToThreadCardInfo, frsViewData);
        d.a.k0.j2.i iVar = this.M;
        if (iVar != null && (i2 = this.N) != 0) {
            iVar.n(i2, this.O, this.E, true);
        }
        FrsFragment frsFragment2 = this.f59339a;
        if (frsFragment2 != null) {
            frsFragment2.l3();
        }
    }

    public final void w0(d.a.k0.q0.n1.e.a aVar, boolean z) {
        boolean z2;
        this.T = aVar;
        View x2 = this.f59339a.x2();
        if (this.f59340b == null) {
            this.f59340b = (NoPressedRelativeLayout) x2.findViewById(R.id.frs);
        }
        if (this.f59342d == null) {
            this.f59342d = x2.findViewById(R.id.frs_content_container);
        }
        if (this.f59341c == null) {
            this.f59341c = (CoordinatorLayout) x2.findViewById(R.id.frs_nested_scroll_layout);
        }
        if (this.A == null) {
            this.A = x2.findViewById(R.id.frs_list_content);
        }
        if (this.Z == null) {
            this.Z = (CollapsingToolbarLayout) x2.findViewById(R.id.frs_collapse_layout);
        }
        if (this.Y == null) {
            this.Y = (FrsHeaderViewContainer) x2.findViewById(R.id.header_view_container);
        }
        if (this.t == null) {
            this.t = new d.a.k0.q0.o2.k(this.f59339a);
        }
        if (this.R == null) {
            ObservedChangeLinearLayout observedChangeLinearLayout = (ObservedChangeLinearLayout) x2.findViewById(R.id.navigation_bar_wrapperLayout);
            this.R = observedChangeLinearLayout;
            observedChangeLinearLayout.setOnSizeChangeListener(new g());
        }
        if (this.y == null) {
            NavigationBar navigationBar = (NavigationBar) x2.findViewById(R.id.view_navigation_bar);
            this.y = navigationBar;
            navigationBar.getBarBgView().setAlpha(1.0f);
            this.y.setContentPaddingTop(d.a.c.e.p.l.g(T(), R.dimen.tbds24));
            z2 = true;
        } else {
            z2 = false;
        }
        if (this.f59339a.K2()) {
            this.y.setVisibility(8);
        }
        if (this.z == null) {
            this.z = x2.findViewById(R.id.frs_navi_line);
            d.a.k0.q0.n1.e.b c2 = aVar.c();
            if (c2 != null) {
                c2.b(this.z);
            }
        }
        if (this.f59343e == null) {
            View addSystemImageButton = this.y.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
            this.f59343e = addSystemImageButton;
            addSystemImageButton.setOnClickListener(this.v);
            this.f59344f = (ImageView) this.f59343e.findViewById(R.id.widget_navi_back_button);
        }
        if (this.k == null) {
            this.k = (ImageView) this.y.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, R.layout.frs_topbar_search_layout, (View.OnClickListener) null);
            SvgManager.getInstance().setPureDrawableWithDayNightModeAutoChange(this.k, R.drawable.ic_icon_pure_topbar_search40_svg, R.color.white_alpha100, SvgManager.SvgResourceStateType.NORMAL_PRESS);
            this.k.setOnClickListener(this.v);
        }
        if (this.f59347i == null) {
            d.a.k0.b0.d dVar = new d.a.k0.b0.d(this.f59339a.getPageContext().getPageActivity());
            this.f59347i = dVar;
            this.y.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, dVar.c(), (View.OnClickListener) null);
            this.f59345g = this.f59347i.b();
            MessageRedDotView a2 = this.f59347i.a();
            this.f59346h = a2;
            a2.setShadowEnabled(false);
            this.f59347i.c().setOnClickListener(this.v);
            this.f59347i.f(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, true);
        }
        if (this.j == null) {
            this.j = (ImageView) this.y.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, R.layout.frs_topbar_share_layout, (View.OnClickListener) null);
            SvgManager.getInstance().setPureDrawableWithDayNightModeAutoChange(this.j, R.drawable.ic_icon_pure_topbar_share40_svg, R.color.white_alpha100, SvgManager.SvgResourceStateType.NORMAL_PRESS);
            this.j.setOnClickListener(this.v);
        }
        if (this.l == null) {
            TextView textView = (TextView) this.y.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_ABSOLUTE_CENTER, R.layout.frs_private_status, (View.OnClickListener) null);
            this.l = textView;
            textView.setVisibility(8);
            Drawable drawable = SkinManager.getDrawable(R.drawable.icon_arrow12_white);
            int g2 = d.a.c.e.p.l.g(this.f59339a.getActivity(), R.dimen.tbds31);
            drawable.setBounds(0, 0, g2, g2);
            this.l.setCompoundDrawables(null, null, drawable, null);
            SkinManager.setBackgroundResourceSelector(this.l, R.drawable.bg_frs_private_status_n, R.drawable.bg_frs_private_status_s);
            SkinManager.setViewTextColor(this.l, R.color.CAM_X0101);
        }
        if (z2) {
            this.y.onChangeSkinType(this.f59339a.getPageContext(), TbadkCoreApplication.getInst().getSkinType());
            SkinManager.setBackgroundColor(this.y.getBottomLine(), R.color.CAM_X0204);
        }
        if (this.r == null) {
            this.r = (BdTypeRecyclerView) x2.findViewById(R.id.frs_lv_thread);
        }
        h hVar = new h();
        hVar.setSupportsChangeAnimations(false);
        this.r.setItemAnimator(hVar);
        BdTypeRecyclerView bdTypeRecyclerView = this.r;
        bdTypeRecyclerView.setLayoutManager(new i(this, bdTypeRecyclerView.getContext()));
        if (TbSingleton.getInstance().isSlideAnimEnable()) {
            d.a.c.j.e.l lVar = new d.a.c.j.e.l(new d.a.c.j.e.j());
            this.n0 = lVar;
            lVar.q(this.r, 2);
        }
        this.r.setScrollable(this.f59339a);
        this.r.setFadingEdgeLength(0);
        this.r.setOverScrollMode(2);
        this.f59340b.setBottomOrderView(this.r);
        this.r.setOnTouchListener(this.f59339a.A1);
        this.r.setRecyclerListener(new j());
        int dimenPixelSize = UtilHelper.getDimenPixelSize(R.dimen.M_W_X004);
        BdTypeRecyclerView bdTypeRecyclerView2 = this.r;
        bdTypeRecyclerView2.setPadding(dimenPixelSize, bdTypeRecyclerView2.getPaddingTop(), dimenPixelSize, this.r.getPaddingBottom());
        if (this.q == null) {
            PbListView pbListView = new PbListView(this.f59339a.getPageContext().getPageActivity());
            this.q = pbListView;
            pbListView.b();
        }
        this.q.o(R.color.transparent);
        this.q.r(d.a.c.e.p.l.g(this.f59339a.getActivity(), R.dimen.tbds182));
        this.q.v();
        this.q.E(R.dimen.tbfontsize33);
        this.q.C(SkinManager.getColor(R.color.CAM_X0109));
        this.q.y(R.color.CAM_X0110);
        this.r.setOnSrollToBottomListener(this.f59339a);
        this.y.setOnClickListener(new k());
        boolean isShowBigImage = TbImageHelper.getInstance().isShowBigImage();
        if (this.s == null) {
            this.s = aVar.b(this.f59339a, this.r, isShowBigImage);
        }
        d.a.k0.q0.o2.k kVar = this.t;
        if (kVar != null) {
            kVar.z(1, false);
        }
        if (!z) {
            if (this.x == null) {
                this.x = new NoNetworkView(this.f59339a.getActivity());
                this.x.setLayoutParams(new LinearLayout.LayoutParams(-1, -2));
                this.R.addView(this.x);
            }
            if (d.a.c.e.p.j.A()) {
                this.x.setVisibility(8);
            } else {
                this.x.setVisibility(0);
            }
            this.x.c(this.f59339a.getPageContext(), TbadkCoreApplication.getInst().getSkinType());
        }
        v0();
        if (this.G == null) {
            d.a.k0.q0.o2.d a3 = aVar.a(this.f59339a, this.f59340b);
            this.G = a3;
            a3.x(this.f59339a.B2());
        }
        if (this.H == null) {
            this.H = aVar.d(this.f59339a, this.f59340b);
            e1(true);
        }
        if (this.P == null) {
            this.P = x2.findViewById(R.id.statebar_view);
        }
        if (this.Q == null) {
            this.Q = x2.findViewById(R.id.statebar_view_holder);
        }
        if (this.M == null) {
            this.M = new d.a.k0.j2.i(this.f59339a.getPageContext(), this.r);
        }
        this.M.p(1);
        this.M.t(this.f59339a.getUniqueId());
        NavigationBarCoverTip navigationBarCoverTip = (NavigationBarCoverTip) x2.findViewById(R.id.navigation_cover_tip);
        this.h0 = navigationBarCoverTip;
        if (this.I == null) {
            this.I = new d.a.k0.q0.o2.m(this.f59339a, navigationBarCoverTip);
        }
        if (this.W == null) {
            AppBarLayout appBarLayout = (AppBarLayout) x2.findViewById(R.id.frs_app_bar_layout);
            this.W = appBarLayout;
            appBarLayout.addOnOffsetChangedListener(this.p0);
            this.a0 = true;
            this.b0 = -1;
            CoordinatorLayout.LayoutParams layoutParams = (CoordinatorLayout.LayoutParams) this.W.getLayoutParams();
            if (layoutParams.getBehavior() instanceof AppBarLayoutStickyBehavior) {
                this.X = (AppBarLayoutStickyBehavior) layoutParams.getBehavior();
            }
        }
        FrsMultiDelBottomMenuView frsMultiDelBottomMenuView = (FrsMultiDelBottomMenuView) x2.findViewById(R.id.frs_multi_delete_menu_view);
        this.f0 = frsMultiDelBottomMenuView;
        frsMultiDelBottomMenuView.setPageContext(this.f59339a.getPageContext());
        FrsMoveAreaBottomMenuView frsMoveAreaBottomMenuView = (FrsMoveAreaBottomMenuView) x2.findViewById(R.id.frs_move_area_menu_view);
        this.g0 = frsMoveAreaBottomMenuView;
        frsMoveAreaBottomMenuView.setPageContext(this.f59339a.getPageContext());
        if (this.j0 == null) {
            this.j0 = this.y.addTextButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, "", null, false);
            LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-2, -1);
            int dimension = (int) this.f59339a.getResources().getDimension(R.dimen.ds20);
            layoutParams2.setMargins(0, dimension, dimension, dimension);
            this.j0.setLayoutParams(layoutParams2);
            this.j0.setPadding(0, 0, this.f59339a.getResources().getDimensionPixelSize(R.dimen.ds20), 0);
            this.j0.setTextColor(SkinManager.getColor(R.color.CAM_X0105));
        }
    }

    public void w1(String str) {
        String str2;
        if (TextUtils.isEmpty(this.j0.getText())) {
            if (TextUtils.isEmpty(str)) {
                this.j0.setText("");
                return;
            }
            String fixedBarText = UtilHelper.getFixedBarText(str, 7, true, false);
            if (fixedBarText.length() < 12) {
                str2 = fixedBarText + "吧";
            } else {
                str2 = UtilHelper.getFixedBarText(str, 6, true, false) + "吧";
            }
            this.j0.setText(str2);
            d.a.j0.r.k.c().h(str);
        }
    }

    public boolean x0() {
        return this.m != null && this.p.getVisibility() == 0;
    }

    public void x1() {
        NavigationBar navigationBar = this.y;
        if (navigationBar == null || navigationBar.getBarBgView() == null || this.R == null) {
            return;
        }
        h1();
        if (this.S) {
            this.y.getBarBgView().setAlpha(0.0f);
            this.y.hideBottomLine();
        } else {
            View view = this.P;
            if (view != null) {
                view.setAlpha(1.0f);
            }
            View view2 = this.Q;
            if (view2 != null) {
                view2.setAlpha(1.0f);
            }
            TextView textView = this.j0;
            if (textView != null) {
                textView.setAlpha(0.0f);
            }
            this.y.getBarBgView().setAlpha(1.0f);
            this.y.showBottomLine();
        }
        H0(this.d0);
    }

    public boolean y0() {
        return this.q.b().getParent() != null && this.C;
    }

    public void y1() {
        this.C = true;
        this.r.setNextPage(this.q);
        this.q.z(this.v);
        int i2 = this.D;
        if (i2 > 0) {
            this.q.J(i2);
        }
        this.q.f();
        this.q.A(this.f59339a.getResources().getString(R.string.list_click_load_more));
    }

    public boolean z0() {
        FrsMoveAreaBottomMenuView frsMoveAreaBottomMenuView = this.g0;
        return frsMoveAreaBottomMenuView != null && frsMoveAreaBottomMenuView.b();
    }

    public void z1() {
        if (this.m == null) {
            return;
        }
        this.n.setVisibility(0);
        this.p.setVisibility(8);
        this.o.setVisibility(0);
        TbadkCoreApplication.getInst().handler.postDelayed(this.q0, 5000L);
    }
}
