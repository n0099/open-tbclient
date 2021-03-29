package d.b.i0.i0.h;

import android.content.Intent;
import android.graphics.drawable.GradientDrawable;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.viewpager.widget.ViewPager;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.framework.message.ResponsedMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.TbSingleton;
import com.baidu.tbadk.core.BaseFragment;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.QRCodeScanActivityConfig;
import com.baidu.tbadk.core.atomData.SignAllForumActivityConfig;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tbadk.core.util.FileHelper;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.core.util.PermissionUtil;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.StatusbarColorUtils;
import com.baidu.tbadk.core.util.SvgManager;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.ViewHelper;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.core.view.NoNetworkView;
import com.baidu.tbadk.widget.horizontalpullview.PullLeftViewPager;
import com.baidu.tbadk.widget.tab.NewPagerSlidingTabBaseStrip;
import com.baidu.tieba.R;
import com.baidu.tieba.enterForum.home.EnterForumFragment;
import com.baidu.tieba.enterForum.home.EnterForumTabFragment;
import com.baidu.tieba.enterForum.home.EnterForumTabPagerAdapter;
import com.baidu.tieba.enterForum.home.forumRecommendHttpResponseMessage;
import com.baidu.tieba.enterForum.home.forumRecommendSocketResponseMessage;
import com.baidu.tieba.enterForum.tabfeed.EnterForumTabFeedFragment;
import com.baidu.tieba.enterForum.view.ForumHeaderView;
import d.b.b.e.p.l;
import d.b.i0.x.t;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes4.dex */
public class c extends d.b.b.a.d implements NoNetworkView.b {
    public d.b.b.c.g.a A;
    public CustomMessageListener B;
    public ViewPager.OnPageChangeListener C;

    /* renamed from: e  reason: collision with root package name */
    public EnterForumTabFragment f55550e;

    /* renamed from: f  reason: collision with root package name */
    public LinearLayout f55551f;

    /* renamed from: g  reason: collision with root package name */
    public ForumHeaderView f55552g;

    /* renamed from: h  reason: collision with root package name */
    public NewPagerSlidingTabBaseStrip f55553h;
    public PullLeftViewPager i;
    public EnterForumTabPagerAdapter j;
    public List<EnterForumTabPagerAdapter.a> k;
    public View l;
    public AlphaAnimation m;
    public AlphaAnimation n;
    public d.b.i0.i0.d.c o;
    public d.b.i0.i0.d.c p;
    public ImageView q;
    public View r;
    public View s;
    public NavigationBar t;
    public View u;
    public NoNetworkView v;
    public d.b.i0.i0.m.b w;
    public int x;
    public int y;
    public boolean z;

    /* loaded from: classes4.dex */
    public class a extends d.b.b.c.g.a {
        public a(int i, int i2) {
            super(i, i2);
        }

        @Override // d.b.b.c.g.a
        public void onMessage(ResponsedMessage<?> responsedMessage) {
            String str = "";
            if (responsedMessage instanceof forumRecommendSocketResponseMessage) {
                forumRecommendSocketResponseMessage forumrecommendsocketresponsemessage = (forumRecommendSocketResponseMessage) responsedMessage;
                if (forumrecommendsocketresponsemessage.getHotSearchInfoData() != null) {
                    str = forumrecommendsocketresponsemessage.getHotSearchInfoData().s();
                }
            } else if (responsedMessage instanceof forumRecommendHttpResponseMessage) {
                forumRecommendHttpResponseMessage forumrecommendhttpresponsemessage = (forumRecommendHttpResponseMessage) responsedMessage;
                if (forumrecommendhttpresponsemessage.getHotSearchInfoData() != null) {
                    str = forumrecommendhttpresponsemessage.getHotSearchInfoData().s();
                }
            }
            if (TextUtils.isEmpty(str)) {
                str = c.this.mContext.getResources().getString(R.string.enter_forum_search_tip);
            }
            TbSingleton.getInstance().setHotSearch(str);
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921396));
        }
    }

    /* loaded from: classes4.dex */
    public class b extends CustomMessageListener {
        public b(int i) {
            super(i);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage == null || !(customResponsedMessage.getData() instanceof Boolean)) {
                return;
            }
            if (((Boolean) customResponsedMessage.getData()).booleanValue()) {
                c.this.X();
            } else {
                c.this.q();
            }
        }
    }

    /* renamed from: d.b.i0.i0.h.c$c  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public class C1286c implements ViewPager.OnPageChangeListener {
        public C1286c() {
        }

        @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
        public void onPageScrollStateChanged(int i) {
        }

        @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
        public void onPageScrolled(int i, float f2, int i2) {
            c.this.P(i, f2, i2);
        }

        @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
        public void onPageSelected(int i) {
            Fragment fragment;
            boolean z;
            c.this.O(i);
            if (c.this.k == null || c.this.k.size() <= i) {
                return;
            }
            if (c.this.w != null) {
                c.this.w.N();
            }
            EnterForumTabPagerAdapter.a aVar = (EnterForumTabPagerAdapter.a) c.this.k.get(i);
            if (aVar == null || (fragment = aVar.f15417a) == null) {
                return;
            }
            if (fragment instanceof EnterForumFragment) {
                z = ((EnterForumFragment) fragment).K0();
            } else if (fragment instanceof EnterForumTabFeedFragment) {
                t.b().e(false);
                boolean H0 = ((EnterForumTabFeedFragment) aVar.f15417a).H0();
                TiebaStatic.log(new StatisticItem("c13366").param("obj_locate", 3).param(TiebaStatic.Params.RESOURCE_ID, ((EnterForumTabFeedFragment) aVar.f15417a).G0()));
                z = H0;
            } else {
                z = true;
            }
            if (!z) {
                c.this.X();
            } else {
                c.this.q();
            }
            if (i == 0) {
                TiebaStatic.log(new StatisticItem("c13366").param("obj_locate", 1));
            }
            if (i == 0) {
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921386));
            }
        }
    }

    /* loaded from: classes4.dex */
    public class d implements View.OnClickListener {
        public d() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (FileHelper.CheckFile("scan_flag") && PermissionUtil.checkCamera(c.this.mContext.getPageActivity())) {
                MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new QRCodeScanActivityConfig(c.this.mContext.getPageActivity())));
            } else if (!TbadkCoreApplication.isLogin()) {
                ViewHelper.skipToLoginActivity(c.this.getPageContext().getPageActivity());
            } else {
                c.this.f55550e.sendMessage(new CustomMessage(2002001, new SignAllForumActivityConfig(c.this.getPageContext().getPageActivity())));
            }
        }
    }

    /* loaded from: classes4.dex */
    public class e implements Animation.AnimationListener {
        public e() {
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationEnd(Animation animation) {
            c.this.u.setVisibility(8);
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationRepeat(Animation animation) {
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationStart(Animation animation) {
        }
    }

    public c(EnterForumTabFragment enterForumTabFragment) {
        super(enterForumTabFragment.getPageContext());
        this.z = false;
        this.A = new a(CmdConfigHttp.FORUM_RECOMMEND_HTTP_CMD, 303011);
        this.B = new b(2001630);
        this.C = new C1286c();
        this.f55550e = enterForumTabFragment;
        enterForumTabFragment.registerListener(this.A);
        this.f55550e.registerListener(this.B);
        this.x = l.g(this.mContext.getPageActivity(), R.dimen.tbds228);
        this.y = UtilHelper.getStatusBarHeight() + l.g(this.mContext.getPageActivity(), R.dimen.tbds229);
    }

    public static String G(int i, long j) {
        return "android:switcher:" + i + ":" + j;
    }

    public final void A(Bundle bundle) {
        LinearLayout linearLayout = (LinearLayout) LayoutInflater.from(this.f55550e.getContext()).inflate(R.layout.enter_forum_tab_layout, (ViewGroup) null);
        this.f55551f = linearLayout;
        ForumHeaderView forumHeaderView = (ForumHeaderView) linearLayout.findViewById(R.id.recommend_forum_header_serch_view);
        this.f55552g = forumHeaderView;
        forumHeaderView.setFrom(0);
        this.f55552g.b();
        NewPagerSlidingTabBaseStrip newPagerSlidingTabBaseStrip = (NewPagerSlidingTabBaseStrip) this.f55551f.findViewById(R.id.tab_layout);
        this.f55553h = newPagerSlidingTabBaseStrip;
        newPagerSlidingTabBaseStrip.setDefaultSelectorColorResourceId(R.color.CAM_X0105);
        this.f55553h.setRectPaintColor(R.color.CAM_X0302);
        this.f55553h.B(l.g(this.f55550e.getContext(), R.dimen.tbds46), l.g(this.f55550e.getContext(), R.dimen.tbds46), l.g(this.f55550e.getContext(), R.dimen.tbds10), l.g(this.f55550e.getContext(), R.dimen.tbds46), true);
        this.f55553h.setmIndicatorWidth(l.g(this.mContext.getPageActivity(), R.dimen.tbds42));
        this.f55553h.setIndicatorOvershot(l.g(this.mContext.getPageActivity(), R.dimen.tbds8));
        this.f55553h.setIndicatorRadius(l.g(this.mContext.getPageActivity(), R.dimen.tbds8));
        this.f55553h.setIndicatorMarginBottom(l.g(this.f55550e.getContext(), R.dimen.tbds0));
        this.f55553h.setExpandedTabLayoutParams(new LinearLayout.LayoutParams(-2, -1));
        this.f55553h.setTabPadding(l.g(this.f55550e.getContext(), R.dimen.tbds36), 0, l.g(this.f55550e.getContext(), R.dimen.tbds36), 0);
        this.f55553h.setViewPager(this.i);
        this.f55553h.setOnPageChangeListener(this.C);
        this.s = this.f55551f.findViewById(R.id.enter_forum_tab_left_grandient);
        this.r = this.f55551f.findViewById(R.id.enter_forum_tab_right_grandient);
    }

    public void B(View view, Bundle bundle) {
        if (view == null) {
            return;
        }
        this.l = view;
        E(bundle);
        A(bundle);
        z(bundle);
        NoNetworkView noNetworkView = (NoNetworkView) this.l.findViewById(R.id.view_no_network);
        this.v = noNetworkView;
        noNetworkView.a(this);
    }

    public final void E(Bundle bundle) {
        this.i = (PullLeftViewPager) this.l.findViewById(R.id.enter_forum_viewpager);
        EnterForumTabPagerAdapter.a aVar = new EnterForumTabPagerAdapter.a();
        aVar.f15417a = new EnterForumFragment();
        aVar.f15418b = this.f55550e.getResources().getString(R.string.my_forum);
        ((EnterForumFragment) aVar.f15417a).N0(this);
        ArrayList arrayList = new ArrayList();
        this.k = arrayList;
        arrayList.add(aVar);
        EnterForumTabPagerAdapter enterForumTabPagerAdapter = new EnterForumTabPagerAdapter(this.f55550e.getActivity().getSupportFragmentManager(), this.k);
        this.j = enterForumTabPagerAdapter;
        this.i.setAdapter(enterForumTabPagerAdapter);
        this.i.setOffscreenPageLimit(this.k.size());
    }

    public boolean F() {
        return this.z;
    }

    public void I() {
    }

    public void J(int i, int i2, Intent intent) {
        PullLeftViewPager pullLeftViewPager;
        Fragment fragment;
        List<EnterForumTabPagerAdapter.a> list = this.k;
        if (list == null || list.size() <= 0 || (pullLeftViewPager = this.i) == null) {
            return;
        }
        EnterForumTabPagerAdapter.a aVar = this.k.get(pullLeftViewPager.getCurrentItem());
        if (aVar == null || (fragment = aVar.f15417a) == null) {
            return;
        }
        fragment.onActivityResult(i, i2, intent);
    }

    public void K() {
        EnterForumTabFragment enterForumTabFragment = this.f55550e;
        if (enterForumTabFragment != null && this.k != null && this.i != null && this.j != null) {
            FragmentManager supportFragmentManager = enterForumTabFragment.getActivity().getSupportFragmentManager();
            if (supportFragmentManager.isDestroyed()) {
                return;
            }
            FragmentTransaction beginTransaction = supportFragmentManager.beginTransaction();
            for (int i = 0; i < this.k.size(); i++) {
                Fragment findFragmentByTag = supportFragmentManager.findFragmentByTag(G(this.i.getId(), this.j.getItemId(i)));
                if (findFragmentByTag != null) {
                    beginTransaction.remove(findFragmentByTag);
                }
            }
            beginTransaction.commitAllowingStateLoss();
        }
        NoNetworkView noNetworkView = this.v;
        if (noNetworkView != null) {
            noNetworkView.d(this);
        }
    }

    public void L(int i) {
        if (i == 0) {
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2001631, getPageContext().getUniqueId()));
        } else if (ListUtils.getItem(this.k, i) == null || !(this.k.get(i).f15417a instanceof EnterForumTabFeedFragment)) {
        } else {
            ((EnterForumTabFeedFragment) this.k.get(i).f15417a).E0(true);
        }
    }

    public void M() {
        O(this.i.getCurrentItem());
    }

    public final void O(int i) {
        d.b.i0.i0.d.c cVar;
        int i2;
        int i3;
        if (this.q != null) {
            if (i == 0) {
                d.b.i0.i0.d.c cVar2 = this.o;
                if (cVar2 != null && cVar2.f55477a && cVar2.f55479c > 0) {
                    d.b.i0.i0.m.b bVar = this.w;
                    if (bVar != null && bVar.M() != null && this.w.M().isViewAttached()) {
                        SvgManager.getInstance().setPureDrawableWithDayNightModeAutoChange(this.q, R.drawable.icon_pure_topbar_sign44_svg, R.color.CAM_X0101, SvgManager.SvgResourceStateType.NORMAL_PRESS);
                    } else {
                        d.b.i0.i0.d.c cVar3 = this.o;
                        int i4 = cVar3.f55480d;
                        if (i4 > 0 && cVar3.f55479c > i4 / 2) {
                            SvgManager.getInstance().setPureDrawableWithDayNightModeAutoChange(this.q, R.drawable.icon_pure_topbar_sign44_svg, R.color.CAM_X0101, SvgManager.SvgResourceStateType.NORMAL_PRESS);
                        } else {
                            SvgManager.getInstance().setPureDrawableWithDayNightModeAutoChange(this.q, R.drawable.icon_pure_topbar_sign44_svg, R.color.CAM_X0105, SvgManager.SvgResourceStateType.NORMAL_PRESS);
                        }
                    }
                } else {
                    SvgManager.getInstance().setPureDrawableWithDayNightModeAutoChange(this.q, R.drawable.icon_pure_topbar_sign44_svg, R.color.CAM_X0105, SvgManager.SvgResourceStateType.NORMAL_PRESS);
                }
            } else {
                SvgManager.getInstance().setPureDrawableWithDayNightModeAutoChange(this.q, R.drawable.icon_pure_topbar_sign44_svg, R.color.CAM_X0105, SvgManager.SvgResourceStateType.NORMAL_PRESS);
            }
        }
        NavigationBar navigationBar = this.t;
        if (navigationBar != null) {
            navigationBar.onChangeSkinType(getPageContext(), TbadkCoreApplication.getInst().getSkinType());
            if (i == 0) {
                d.b.i0.i0.d.c cVar4 = this.o;
                if (cVar4 != null && cVar4.f55477a && cVar4.f55479c > 0) {
                    d.b.i0.i0.m.b bVar2 = this.w;
                    if (bVar2 != null && bVar2.M() != null && this.w.M().isViewAttached()) {
                        SkinManager.setBackgroundColor(this.t.getBarBgView(), R.color.CAM_X0207, TbadkCoreApplication.getInst().getSkinType());
                    } else {
                        d.b.i0.i0.d.c cVar5 = this.o;
                        int i5 = cVar5.f55480d;
                        if (i5 > 0) {
                            int i6 = (cVar5.f55479c * 255) / i5;
                            if (i6 > 255) {
                                i6 = 255;
                            }
                            i3 = 255 - i6;
                        } else {
                            i3 = 0;
                        }
                        this.t.setBackgroundColor(0);
                        SkinManager.setBackgroundColorWithAlpha(this.t.getBarBgView(), R.color.CAM_X0201, i3 / 255.0f, TbadkCoreApplication.getInst().getSkinType());
                    }
                } else {
                    SkinManager.setBackgroundColor(this.t.getBarBgView(), R.color.CAM_X0207, TbadkCoreApplication.getInst().getSkinType());
                }
            } else {
                SkinManager.setBackgroundColor(this.t.getBarBgView(), R.color.CAM_X0207, TbadkCoreApplication.getInst().getSkinType());
            }
        }
        if (i == 0) {
            d.b.i0.i0.d.c cVar6 = this.o;
            if (cVar6 != null && cVar6.f55477a && (i2 = cVar6.f55479c) > 0) {
                int i7 = cVar6.f55480d;
                if (i7 > 0 && i2 > i7 / 2) {
                    d.b.i0.i0.m.b bVar3 = this.w;
                    if (bVar3 != null && bVar3.M() != null && this.w.M().isViewAttached()) {
                        this.f55553h.setWhiteStyle(false);
                    } else {
                        this.f55553h.setWhiteStyle(true);
                    }
                } else {
                    this.f55553h.setWhiteStyle(false);
                }
            } else {
                this.f55553h.setWhiteStyle(false);
            }
        } else {
            this.f55553h.setWhiteStyle(false);
        }
        if (i == 0) {
            this.f55552g.setAdState(this.o);
        } else {
            this.f55552g.setAdState(null);
        }
        if (i == 0 && TbadkCoreApplication.getInst().getSkinType() != 1 && this.f55550e.isPrimary() && (cVar = this.o) != null && cVar.f55477a && i == 0) {
            int i8 = cVar.f55479c;
            int i9 = cVar.f55480d;
            if (i8 > i9 / 2) {
                d.b.i0.i0.d.c cVar7 = this.p;
                if (cVar7 == null || cVar7.f55479c > i9 / 2) {
                    return;
                }
                StatusbarColorUtils.setStatusBarDarkIcon(getPageContext().getPageActivity().getWindow(), false);
                return;
            }
            d.b.i0.i0.d.c cVar8 = this.p;
            if (cVar8 == null || cVar8.f55479c < i9 / 2) {
                return;
            }
            StatusbarColorUtils.setStatusBarDarkIcon(getPageContext().getPageActivity().getWindow(), true);
        }
    }

    public final void P(int i, float f2, int i2) {
        if (this.t != null) {
            if (i == 0) {
                if (i2 == 0) {
                    O(i);
                    return;
                }
                d.b.i0.i0.d.c cVar = this.o;
                if (cVar == null || !cVar.f55477a || cVar.f55479c <= 0) {
                    return;
                }
                d.b.i0.i0.m.b bVar = this.w;
                if (bVar != null && bVar.M() != null && this.w.M().isViewAttached()) {
                    SkinManager.setBackgroundColor(this.t.getBarBgView(), R.color.CAM_X0207, TbadkCoreApplication.getInst().getSkinType());
                    return;
                }
                this.t.setBackgroundColor(0);
                SkinManager.setBackgroundColorWithAlpha(this.t.getBarBgView(), R.color.CAM_X0207, f2, TbadkCoreApplication.getInst().getSkinType());
            } else if (i2 == 0) {
                O(i);
            } else {
                d.b.i0.i0.d.c cVar2 = this.o;
                if (cVar2 == null || !cVar2.f55477a || cVar2.f55479c <= 0) {
                    return;
                }
                d.b.i0.i0.m.b bVar2 = this.w;
                if (bVar2 != null && bVar2.M() != null && this.w.M().isViewAttached()) {
                    SkinManager.setBackgroundColor(this.t.getBarBgView(), R.color.CAM_X0201, TbadkCoreApplication.getInst().getSkinType());
                    return;
                }
                this.t.setBackgroundColor(0);
                SkinManager.setBackgroundColorWithAlpha(this.t.getBarBgView(), R.color.CAM_X0201, 1.0f - f2, TbadkCoreApplication.getInst().getSkinType());
            }
        }
    }

    public void Q() {
        if (TbadkCoreApplication.getInst().getSkinType() != 1 && TbadkCoreApplication.getInst().getSkinType() != 4) {
            if (this.i.getCurrentItem() == 0 && this.f55550e.isPrimary()) {
                d.b.i0.i0.m.b bVar = this.w;
                if (bVar != null && bVar.M() != null && this.w.M().isViewAttached()) {
                    StatusbarColorUtils.setStatusBarDarkIcon(getPageContext().getPageActivity().getWindow(), true);
                    return;
                }
                d.b.i0.i0.d.c cVar = this.o;
                if (cVar != null && cVar.f55477a) {
                    int i = cVar.f55479c;
                    if (i <= cVar.f55480d / 2 && i != 0) {
                        StatusbarColorUtils.setStatusBarDarkIcon(getPageContext().getPageActivity().getWindow(), true);
                        return;
                    } else {
                        StatusbarColorUtils.setStatusBarDarkIcon(getPageContext().getPageActivity().getWindow(), false);
                        return;
                    }
                }
                StatusbarColorUtils.setStatusBarDarkIcon(getPageContext().getPageActivity().getWindow(), true);
                return;
            }
            StatusbarColorUtils.setStatusBarDarkIcon(getPageContext().getPageActivity().getWindow(), true);
            return;
        }
        StatusbarColorUtils.setStatusBarDarkIcon(getPageContext().getPageActivity().getWindow(), false);
    }

    public boolean R(int i) {
        if (i < 0 || i > this.k.size()) {
            return false;
        }
        this.i.setCurrentItem(i, true);
        return true;
    }

    public void S(d.b.i0.i0.d.c cVar) {
        this.p = this.o;
        this.o = cVar;
        this.f55552g.setAdState(cVar);
        O(this.i.getCurrentItem());
    }

    public void T(d.b.i0.i0.m.b bVar) {
        this.w = bVar;
    }

    public void U(boolean z) {
        PullLeftViewPager pullLeftViewPager;
        Fragment fragment;
        EnterForumTabPagerAdapter enterForumTabPagerAdapter = this.j;
        if (enterForumTabPagerAdapter != null) {
            enterForumTabPagerAdapter.f(z);
        }
        List<EnterForumTabPagerAdapter.a> list = this.k;
        if (list == null || list.size() <= 0 || (pullLeftViewPager = this.i) == null) {
            return;
        }
        EnterForumTabPagerAdapter.a aVar = this.k.get(pullLeftViewPager.getCurrentItem());
        if (aVar == null || (fragment = aVar.f15417a) == null || !(fragment instanceof BaseFragment)) {
            return;
        }
        ((BaseFragment) fragment).setPrimary(z);
    }

    public void V(String str) {
    }

    public void W(String str) {
        this.f55552g.setSearchHint(str);
    }

    public final void X() {
        LinearLayout linearLayout = this.f55551f;
        if (linearLayout != null && linearLayout.getPaddingTop() < 0) {
            r();
            return;
        }
        View view = this.u;
        if (view == null) {
            return;
        }
        view.clearAnimation();
        if (this.u.getVisibility() == 0) {
            return;
        }
        this.u.setVisibility(0);
        if (this.m == null) {
            AlphaAnimation alphaAnimation = new AlphaAnimation(0.0f, 1.0f);
            this.m = alphaAnimation;
            alphaAnimation.setFillAfter(true);
            this.m.setDuration(300L);
        }
        this.u.startAnimation(this.m);
    }

    public final void Y(int i) {
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.u.getLayoutParams();
        layoutParams.topMargin = this.y + i;
        this.u.setLayoutParams(layoutParams);
    }

    @Override // com.baidu.tbadk.core.view.NoNetworkView.b
    public void b(boolean z) {
        Fragment fragment;
        List<EnterForumTabPagerAdapter.a> list = this.k;
        if (list != null && list.size() > 0) {
            for (int i = 0; i < this.k.size(); i++) {
                EnterForumTabPagerAdapter.a aVar = this.k.get(i);
                if (aVar != null && (fragment = aVar.f15417a) != null && (fragment instanceof NoNetworkView.b)) {
                    ((NoNetworkView.b) fragment).b(z);
                }
            }
        }
        O(this.i.getCurrentItem());
    }

    public void o(NewPagerSlidingTabBaseStrip.c cVar) {
        NewPagerSlidingTabBaseStrip newPagerSlidingTabBaseStrip = this.f55553h;
        if (newPagerSlidingTabBaseStrip == null || cVar == null) {
            return;
        }
        newPagerSlidingTabBaseStrip.setOnTabItemClickListener(cVar);
    }

    public void onChangeSkinType(int i) {
        Fragment fragment;
        O(this.i.getCurrentItem());
        NoNetworkView noNetworkView = this.v;
        if (noNetworkView != null) {
            noNetworkView.c(getPageContext(), i);
        }
        List<EnterForumTabPagerAdapter.a> list = this.k;
        if (list != null && list.size() > 0) {
            for (int i2 = 0; i2 < this.k.size(); i2++) {
                EnterForumTabPagerAdapter.a aVar = this.k.get(i2);
                if (aVar != null && (fragment = aVar.f15417a) != null && (fragment instanceof BaseFragment)) {
                    ((BaseFragment) fragment).onChangeSkinType(i);
                }
            }
        }
        SkinManager.setBackgroundResource(this.u, R.drawable.personalize_tab_shadow);
        this.f55553h.G();
        this.f55552g.b();
        SkinManager.setBackgroundColorToTransparent(this.s, R.color.CAM_X0207, GradientDrawable.Orientation.LEFT_RIGHT);
        SkinManager.setBackgroundColorToTransparent(this.r, R.color.CAM_X0207, GradientDrawable.Orientation.RIGHT_LEFT);
    }

    public void q() {
        View view = this.u;
        if (view == null || view.getVisibility() == 8) {
            return;
        }
        if (this.n == null) {
            AlphaAnimation alphaAnimation = new AlphaAnimation(1.0f, 0.0f);
            this.n = alphaAnimation;
            alphaAnimation.setFillAfter(true);
            this.n.setDuration(300L);
            this.n.setAnimationListener(new e());
        }
        this.u.startAnimation(this.n);
    }

    public final void r() {
        View view = this.u;
        if (view == null || view.getVisibility() == 8) {
            return;
        }
        this.u.clearAnimation();
        this.u.setVisibility(8);
    }

    public int s(String str) {
        List<EnterForumTabPagerAdapter.a> list;
        if (StringUtils.isNull(str) || (list = this.k) == null || list.size() <= 0) {
            return -1;
        }
        int i = -1;
        for (int i2 = 0; i2 < this.k.size(); i2++) {
            if (str.equals(this.k.get(i2).f15420d)) {
                i = i2;
            }
        }
        if (i == -1 && this.f55550e.getResources().getString(R.string.my_forum).equals(str)) {
            return 0;
        }
        return i;
    }

    public String u() {
        EnterForumTabPagerAdapter enterForumTabPagerAdapter = this.j;
        if (enterForumTabPagerAdapter != null) {
            return enterForumTabPagerAdapter.e();
        }
        return null;
    }

    public int v() {
        return this.i.getCurrentItem();
    }

    public View w() {
        return getPageContext().getPageActivity().getWindow().getDecorView();
    }

    public String x(int i) {
        EnterForumTabPagerAdapter.a aVar = (EnterForumTabPagerAdapter.a) ListUtils.getItem(this.k, i);
        if (aVar != null) {
            Fragment fragment = aVar.f15417a;
            return fragment instanceof EnterForumTabFeedFragment ? ((EnterForumTabFeedFragment) fragment).G0() : "";
        }
        return "";
    }

    public View y() {
        return this.f55551f;
    }

    public final void z(Bundle bundle) {
        NavigationBar navigationBar = (NavigationBar) this.l.findViewById(R.id.navigation_bar);
        this.t = navigationBar;
        navigationBar.setNavHeight(this.x);
        this.t.hideBottomLine();
        this.u = this.l.findViewById(R.id.divider_shadow);
        Y(0);
        ImageView imageView = (ImageView) this.f55551f.findViewById(R.id.navigationBarGoSignall);
        this.q = imageView;
        imageView.setOnClickListener(new d());
        if (this.f55553h != null) {
            this.t.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_ABSOLUTE_CENTER, this.f55551f, (View.OnClickListener) null);
            ViewGroup viewGroup = (ViewGroup) this.f55551f.getParent();
            if (viewGroup instanceof LinearLayout) {
                ((LinearLayout) viewGroup).setGravity(3);
            } else if (viewGroup instanceof RelativeLayout) {
                ((RelativeLayout) viewGroup).setGravity(3);
            } else if (viewGroup instanceof FrameLayout) {
                FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) viewGroup.getLayoutParams();
                layoutParams.gravity = 3;
                viewGroup.setLayoutParams(layoutParams);
            }
            NewPagerSlidingTabBaseStrip newPagerSlidingTabBaseStrip = this.f55553h;
            newPagerSlidingTabBaseStrip.setPadding(newPagerSlidingTabBaseStrip.getPaddingLeft(), this.f55553h.getPaddingTop(), this.f55553h.getPaddingRight(), this.f55553h.getPaddingBottom());
        }
    }
}
