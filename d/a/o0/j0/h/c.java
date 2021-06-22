package d.a.o0.j0.h;

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
import d.a.c.e.p.l;
import d.a.o0.z.t;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes4.dex */
public class c extends d.a.c.a.d implements NoNetworkView.b {
    public d.a.c.c.g.a A;
    public CustomMessageListener B;
    public ViewPager.OnPageChangeListener C;

    /* renamed from: e  reason: collision with root package name */
    public EnterForumTabFragment f59727e;

    /* renamed from: f  reason: collision with root package name */
    public LinearLayout f59728f;

    /* renamed from: g  reason: collision with root package name */
    public ForumHeaderView f59729g;

    /* renamed from: h  reason: collision with root package name */
    public NewPagerSlidingTabBaseStrip f59730h;

    /* renamed from: i  reason: collision with root package name */
    public PullLeftViewPager f59731i;
    public EnterForumTabPagerAdapter j;
    public List<EnterForumTabPagerAdapter.a> k;
    public View l;
    public AlphaAnimation m;
    public AlphaAnimation n;
    public d.a.o0.j0.d.c o;
    public d.a.o0.j0.d.c p;
    public ImageView q;
    public View r;
    public View s;
    public NavigationBar t;
    public View u;
    public NoNetworkView v;
    public d.a.o0.j0.m.b w;
    public int x;
    public int y;
    public boolean z;

    /* loaded from: classes4.dex */
    public class a extends d.a.c.c.g.a {
        public a(int i2, int i3) {
            super(i2, i3);
        }

        @Override // d.a.c.c.g.a
        public void onMessage(ResponsedMessage<?> responsedMessage) {
            String str = "";
            if (responsedMessage instanceof forumRecommendSocketResponseMessage) {
                forumRecommendSocketResponseMessage forumrecommendsocketresponsemessage = (forumRecommendSocketResponseMessage) responsedMessage;
                if (forumrecommendsocketresponsemessage.getHotSearchInfoData() != null) {
                    str = forumrecommendsocketresponsemessage.getHotSearchInfoData().w();
                }
            } else if (responsedMessage instanceof forumRecommendHttpResponseMessage) {
                forumRecommendHttpResponseMessage forumrecommendhttpresponsemessage = (forumRecommendHttpResponseMessage) responsedMessage;
                if (forumrecommendhttpresponsemessage.getHotSearchInfoData() != null) {
                    str = forumrecommendhttpresponsemessage.getHotSearchInfoData().w();
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
        public b(int i2) {
            super(i2);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage == null || !(customResponsedMessage.getData() instanceof Boolean)) {
                return;
            }
            if (((Boolean) customResponsedMessage.getData()).booleanValue()) {
                c.this.V();
            } else {
                c.this.p();
            }
        }
    }

    /* renamed from: d.a.o0.j0.h.c$c  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public class C1436c implements ViewPager.OnPageChangeListener {
        public C1436c() {
        }

        @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
        public void onPageScrollStateChanged(int i2) {
        }

        @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
        public void onPageScrolled(int i2, float f2, int i3) {
            c.this.M(i2, f2, i3);
        }

        @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
        public void onPageSelected(int i2) {
            Fragment fragment;
            boolean z;
            c.this.L(i2);
            if (c.this.k == null || c.this.k.size() <= i2) {
                return;
            }
            if (c.this.w != null) {
                c.this.w.N();
            }
            EnterForumTabPagerAdapter.a aVar = (EnterForumTabPagerAdapter.a) c.this.k.get(i2);
            if (aVar == null || (fragment = aVar.f14569a) == null) {
                return;
            }
            if (fragment instanceof EnterForumFragment) {
                z = ((EnterForumFragment) fragment).M0();
            } else if (fragment instanceof EnterForumTabFeedFragment) {
                t.b().e(false);
                boolean J0 = ((EnterForumTabFeedFragment) aVar.f14569a).J0();
                TiebaStatic.log(new StatisticItem("c13366").param("obj_locate", 3).param(TiebaStatic.Params.RESOURCE_ID, ((EnterForumTabFeedFragment) aVar.f14569a).I0()));
                z = J0;
            } else {
                z = true;
            }
            if (!z) {
                c.this.V();
            } else {
                c.this.p();
            }
            if (i2 == 0) {
                TiebaStatic.log(new StatisticItem("c13366").param("obj_locate", 1));
            }
            if (i2 == 0) {
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
                c.this.f59727e.sendMessage(new CustomMessage(2002001, new SignAllForumActivityConfig(c.this.getPageContext().getPageActivity())));
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
        this.C = new C1436c();
        this.f59727e = enterForumTabFragment;
        enterForumTabFragment.registerListener(this.A);
        this.f59727e.registerListener(this.B);
        this.x = l.g(this.mContext.getPageActivity(), R.dimen.tbds228);
        this.y = UtilHelper.getStatusBarHeight() + l.g(this.mContext.getPageActivity(), R.dimen.tbds229);
    }

    public static String F(int i2, long j) {
        return "android:switcher:" + i2 + ":" + j;
    }

    public final void A(Bundle bundle) {
        this.f59731i = (PullLeftViewPager) this.l.findViewById(R.id.enter_forum_viewpager);
        EnterForumTabPagerAdapter.a aVar = new EnterForumTabPagerAdapter.a();
        aVar.f14569a = new EnterForumFragment();
        aVar.f14570b = this.f59727e.getResources().getString(R.string.my_forum);
        ((EnterForumFragment) aVar.f14569a).P0(this);
        ArrayList arrayList = new ArrayList();
        this.k = arrayList;
        arrayList.add(aVar);
        EnterForumTabPagerAdapter enterForumTabPagerAdapter = new EnterForumTabPagerAdapter(this.f59727e.getActivity().getSupportFragmentManager(), this.k);
        this.j = enterForumTabPagerAdapter;
        this.f59731i.setAdapter(enterForumTabPagerAdapter);
        this.f59731i.setOffscreenPageLimit(this.k.size());
    }

    public boolean B() {
        return this.z;
    }

    public void G() {
    }

    public void H(int i2, int i3, Intent intent) {
        PullLeftViewPager pullLeftViewPager;
        Fragment fragment;
        List<EnterForumTabPagerAdapter.a> list = this.k;
        if (list == null || list.size() <= 0 || (pullLeftViewPager = this.f59731i) == null) {
            return;
        }
        EnterForumTabPagerAdapter.a aVar = this.k.get(pullLeftViewPager.getCurrentItem());
        if (aVar == null || (fragment = aVar.f14569a) == null) {
            return;
        }
        fragment.onActivityResult(i2, i3, intent);
    }

    public void I() {
        EnterForumTabFragment enterForumTabFragment = this.f59727e;
        if (enterForumTabFragment != null && this.k != null && this.f59731i != null && this.j != null) {
            FragmentManager supportFragmentManager = enterForumTabFragment.getActivity().getSupportFragmentManager();
            if (supportFragmentManager.isDestroyed()) {
                return;
            }
            FragmentTransaction beginTransaction = supportFragmentManager.beginTransaction();
            for (int i2 = 0; i2 < this.k.size(); i2++) {
                Fragment findFragmentByTag = supportFragmentManager.findFragmentByTag(F(this.f59731i.getId(), this.j.getItemId(i2)));
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

    public void J(int i2) {
        if (i2 == 0) {
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2001631, getPageContext().getUniqueId()));
        } else if (ListUtils.getItem(this.k, i2) == null || !(this.k.get(i2).f14569a instanceof EnterForumTabFeedFragment)) {
        } else {
            ((EnterForumTabFeedFragment) this.k.get(i2).f14569a).G0(true);
        }
    }

    public void K() {
        L(this.f59731i.getCurrentItem());
    }

    public final void L(int i2) {
        d.a.o0.j0.d.c cVar;
        int i3;
        int i4;
        if (this.q != null) {
            if (i2 == 0) {
                d.a.o0.j0.d.c cVar2 = this.o;
                if (cVar2 != null && cVar2.f59649a && cVar2.f59651c > 0) {
                    d.a.o0.j0.m.b bVar = this.w;
                    if (bVar != null && bVar.M() != null && this.w.M().isViewAttached()) {
                        SvgManager.getInstance().setPureDrawableWithDayNightModeAutoChange(this.q, R.drawable.icon_pure_topbar_sign44_svg, R.color.CAM_X0101, SvgManager.SvgResourceStateType.NORMAL_PRESS);
                    } else {
                        d.a.o0.j0.d.c cVar3 = this.o;
                        int i5 = cVar3.f59652d;
                        if (i5 > 0 && cVar3.f59651c > i5 / 2) {
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
            if (i2 == 0) {
                d.a.o0.j0.d.c cVar4 = this.o;
                if (cVar4 != null && cVar4.f59649a && cVar4.f59651c > 0) {
                    d.a.o0.j0.m.b bVar2 = this.w;
                    if (bVar2 != null && bVar2.M() != null && this.w.M().isViewAttached()) {
                        SkinManager.setBackgroundColor(this.t.getBarBgView(), R.color.CAM_X0207, TbadkCoreApplication.getInst().getSkinType());
                    } else {
                        d.a.o0.j0.d.c cVar5 = this.o;
                        int i6 = cVar5.f59652d;
                        if (i6 > 0) {
                            int i7 = (cVar5.f59651c * 255) / i6;
                            if (i7 > 255) {
                                i7 = 255;
                            }
                            i4 = 255 - i7;
                        } else {
                            i4 = 0;
                        }
                        this.t.setBackgroundColor(0);
                        SkinManager.setBackgroundColorWithAlpha(this.t.getBarBgView(), R.color.CAM_X0201, i4 / 255.0f, TbadkCoreApplication.getInst().getSkinType());
                    }
                } else {
                    SkinManager.setBackgroundColor(this.t.getBarBgView(), R.color.CAM_X0207, TbadkCoreApplication.getInst().getSkinType());
                }
            } else {
                SkinManager.setBackgroundColor(this.t.getBarBgView(), R.color.CAM_X0207, TbadkCoreApplication.getInst().getSkinType());
            }
        }
        if (i2 == 0) {
            d.a.o0.j0.d.c cVar6 = this.o;
            if (cVar6 != null && cVar6.f59649a && (i3 = cVar6.f59651c) > 0) {
                int i8 = cVar6.f59652d;
                if (i8 > 0 && i3 > i8 / 2) {
                    d.a.o0.j0.m.b bVar3 = this.w;
                    if (bVar3 != null && bVar3.M() != null && this.w.M().isViewAttached()) {
                        this.f59730h.setWhiteStyle(false);
                    } else {
                        this.f59730h.setWhiteStyle(true);
                    }
                } else {
                    this.f59730h.setWhiteStyle(false);
                }
            } else {
                this.f59730h.setWhiteStyle(false);
            }
        } else {
            this.f59730h.setWhiteStyle(false);
        }
        if (i2 == 0) {
            this.f59729g.setAdState(this.o);
        } else {
            this.f59729g.setAdState(null);
        }
        if (i2 == 0 && TbadkCoreApplication.getInst().getSkinType() != 1 && this.f59727e.isPrimary() && (cVar = this.o) != null && cVar.f59649a && i2 == 0) {
            int i9 = cVar.f59651c;
            int i10 = cVar.f59652d;
            if (i9 > i10 / 2) {
                d.a.o0.j0.d.c cVar7 = this.p;
                if (cVar7 == null || cVar7.f59651c > i10 / 2) {
                    return;
                }
                StatusbarColorUtils.setStatusBarDarkIcon(getPageContext().getPageActivity().getWindow(), false);
                return;
            }
            d.a.o0.j0.d.c cVar8 = this.p;
            if (cVar8 == null || cVar8.f59651c < i10 / 2) {
                return;
            }
            StatusbarColorUtils.setStatusBarDarkIcon(getPageContext().getPageActivity().getWindow(), true);
        }
    }

    public final void M(int i2, float f2, int i3) {
        if (this.t != null) {
            if (i2 == 0) {
                if (i3 == 0) {
                    L(i2);
                    return;
                }
                d.a.o0.j0.d.c cVar = this.o;
                if (cVar == null || !cVar.f59649a || cVar.f59651c <= 0) {
                    return;
                }
                d.a.o0.j0.m.b bVar = this.w;
                if (bVar != null && bVar.M() != null && this.w.M().isViewAttached()) {
                    SkinManager.setBackgroundColor(this.t.getBarBgView(), R.color.CAM_X0207, TbadkCoreApplication.getInst().getSkinType());
                    return;
                }
                this.t.setBackgroundColor(0);
                SkinManager.setBackgroundColorWithAlpha(this.t.getBarBgView(), R.color.CAM_X0207, f2, TbadkCoreApplication.getInst().getSkinType());
            } else if (i3 == 0) {
                L(i2);
            } else {
                d.a.o0.j0.d.c cVar2 = this.o;
                if (cVar2 == null || !cVar2.f59649a || cVar2.f59651c <= 0) {
                    return;
                }
                d.a.o0.j0.m.b bVar2 = this.w;
                if (bVar2 != null && bVar2.M() != null && this.w.M().isViewAttached()) {
                    SkinManager.setBackgroundColor(this.t.getBarBgView(), R.color.CAM_X0201, TbadkCoreApplication.getInst().getSkinType());
                    return;
                }
                this.t.setBackgroundColor(0);
                SkinManager.setBackgroundColorWithAlpha(this.t.getBarBgView(), R.color.CAM_X0201, 1.0f - f2, TbadkCoreApplication.getInst().getSkinType());
            }
        }
    }

    public void O() {
        if (TbadkCoreApplication.getInst().getSkinType() != 1 && TbadkCoreApplication.getInst().getSkinType() != 4) {
            if (this.f59731i.getCurrentItem() == 0 && this.f59727e.isPrimary()) {
                d.a.o0.j0.m.b bVar = this.w;
                if (bVar != null && bVar.M() != null && this.w.M().isViewAttached()) {
                    StatusbarColorUtils.setStatusBarDarkIcon(getPageContext().getPageActivity().getWindow(), true);
                    return;
                }
                d.a.o0.j0.d.c cVar = this.o;
                if (cVar != null && cVar.f59649a) {
                    int i2 = cVar.f59651c;
                    if (i2 <= cVar.f59652d / 2 && i2 != 0) {
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

    public boolean P(int i2) {
        if (i2 < 0 || i2 > this.k.size()) {
            return false;
        }
        this.f59731i.setCurrentItem(i2, true);
        return true;
    }

    public void Q(d.a.o0.j0.d.c cVar) {
        this.p = this.o;
        this.o = cVar;
        this.f59729g.setAdState(cVar);
        L(this.f59731i.getCurrentItem());
    }

    public void R(d.a.o0.j0.m.b bVar) {
        this.w = bVar;
    }

    public void S(boolean z) {
        PullLeftViewPager pullLeftViewPager;
        Fragment fragment;
        EnterForumTabPagerAdapter enterForumTabPagerAdapter = this.j;
        if (enterForumTabPagerAdapter != null) {
            enterForumTabPagerAdapter.f(z);
        }
        List<EnterForumTabPagerAdapter.a> list = this.k;
        if (list == null || list.size() <= 0 || (pullLeftViewPager = this.f59731i) == null) {
            return;
        }
        EnterForumTabPagerAdapter.a aVar = this.k.get(pullLeftViewPager.getCurrentItem());
        if (aVar == null || (fragment = aVar.f14569a) == null || !(fragment instanceof BaseFragment)) {
            return;
        }
        ((BaseFragment) fragment).setPrimary(z);
    }

    public void T(String str) {
    }

    public void U(String str) {
        this.f59729g.setSearchHint(str);
    }

    public final void V() {
        LinearLayout linearLayout = this.f59728f;
        if (linearLayout != null && linearLayout.getPaddingTop() < 0) {
            q();
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

    public final void Y(int i2) {
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.u.getLayoutParams();
        layoutParams.topMargin = this.y + i2;
        this.u.setLayoutParams(layoutParams);
    }

    @Override // com.baidu.tbadk.core.view.NoNetworkView.b
    public void b(boolean z) {
        Fragment fragment;
        List<EnterForumTabPagerAdapter.a> list = this.k;
        if (list != null && list.size() > 0) {
            for (int i2 = 0; i2 < this.k.size(); i2++) {
                EnterForumTabPagerAdapter.a aVar = this.k.get(i2);
                if (aVar != null && (fragment = aVar.f14569a) != null && (fragment instanceof NoNetworkView.b)) {
                    ((NoNetworkView.b) fragment).b(z);
                }
            }
        }
        L(this.f59731i.getCurrentItem());
    }

    public void o(NewPagerSlidingTabBaseStrip.c cVar) {
        NewPagerSlidingTabBaseStrip newPagerSlidingTabBaseStrip = this.f59730h;
        if (newPagerSlidingTabBaseStrip == null || cVar == null) {
            return;
        }
        newPagerSlidingTabBaseStrip.setOnTabItemClickListener(cVar);
    }

    public void onChangeSkinType(int i2) {
        Fragment fragment;
        L(this.f59731i.getCurrentItem());
        NoNetworkView noNetworkView = this.v;
        if (noNetworkView != null) {
            noNetworkView.c(getPageContext(), i2);
        }
        List<EnterForumTabPagerAdapter.a> list = this.k;
        if (list != null && list.size() > 0) {
            for (int i3 = 0; i3 < this.k.size(); i3++) {
                EnterForumTabPagerAdapter.a aVar = this.k.get(i3);
                if (aVar != null && (fragment = aVar.f14569a) != null && (fragment instanceof BaseFragment)) {
                    ((BaseFragment) fragment).onChangeSkinType(i2);
                }
            }
        }
        SkinManager.setBackgroundResource(this.u, R.drawable.personalize_tab_shadow);
        this.f59730h.G();
        this.f59729g.b();
        SkinManager.setBackgroundColorToTransparent(this.s, R.color.CAM_X0207, GradientDrawable.Orientation.LEFT_RIGHT);
        SkinManager.setBackgroundColorToTransparent(this.r, R.color.CAM_X0207, GradientDrawable.Orientation.RIGHT_LEFT);
    }

    public void p() {
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

    public final void q() {
        View view = this.u;
        if (view == null || view.getVisibility() == 8) {
            return;
        }
        this.u.clearAnimation();
        this.u.setVisibility(8);
    }

    public int r(String str) {
        List<EnterForumTabPagerAdapter.a> list;
        if (StringUtils.isNull(str) || (list = this.k) == null || list.size() <= 0) {
            return -1;
        }
        int i2 = -1;
        for (int i3 = 0; i3 < this.k.size(); i3++) {
            if (str.equals(this.k.get(i3).f14572d)) {
                i2 = i3;
            }
        }
        if (i2 == -1 && this.f59727e.getResources().getString(R.string.my_forum).equals(str)) {
            return 0;
        }
        return i2;
    }

    public String s() {
        EnterForumTabPagerAdapter enterForumTabPagerAdapter = this.j;
        if (enterForumTabPagerAdapter != null) {
            return enterForumTabPagerAdapter.e();
        }
        return null;
    }

    public int t() {
        return this.f59731i.getCurrentItem();
    }

    public View u() {
        return getPageContext().getPageActivity().getWindow().getDecorView();
    }

    public String v(int i2) {
        EnterForumTabPagerAdapter.a aVar = (EnterForumTabPagerAdapter.a) ListUtils.getItem(this.k, i2);
        if (aVar != null) {
            Fragment fragment = aVar.f14569a;
            return fragment instanceof EnterForumTabFeedFragment ? ((EnterForumTabFeedFragment) fragment).I0() : "";
        }
        return "";
    }

    public View w() {
        return this.f59728f;
    }

    public final void x(Bundle bundle) {
        NavigationBar navigationBar = (NavigationBar) this.l.findViewById(R.id.navigation_bar);
        this.t = navigationBar;
        navigationBar.setNavHeight(this.x);
        this.t.hideBottomLine();
        this.u = this.l.findViewById(R.id.divider_shadow);
        Y(0);
        ImageView imageView = (ImageView) this.f59728f.findViewById(R.id.navigationBarGoSignall);
        this.q = imageView;
        imageView.setOnClickListener(new d());
        if (this.f59730h != null) {
            this.t.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_ABSOLUTE_CENTER, this.f59728f, (View.OnClickListener) null);
            ViewGroup viewGroup = (ViewGroup) this.f59728f.getParent();
            if (viewGroup instanceof LinearLayout) {
                ((LinearLayout) viewGroup).setGravity(3);
            } else if (viewGroup instanceof RelativeLayout) {
                ((RelativeLayout) viewGroup).setGravity(3);
            } else if (viewGroup instanceof FrameLayout) {
                FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) viewGroup.getLayoutParams();
                layoutParams.gravity = 3;
                viewGroup.setLayoutParams(layoutParams);
            }
            NewPagerSlidingTabBaseStrip newPagerSlidingTabBaseStrip = this.f59730h;
            newPagerSlidingTabBaseStrip.setPadding(newPagerSlidingTabBaseStrip.getPaddingLeft(), this.f59730h.getPaddingTop(), this.f59730h.getPaddingRight(), this.f59730h.getPaddingBottom());
        }
    }

    public final void y(Bundle bundle) {
        LinearLayout linearLayout = (LinearLayout) LayoutInflater.from(this.f59727e.getContext()).inflate(R.layout.enter_forum_tab_layout, (ViewGroup) null);
        this.f59728f = linearLayout;
        ForumHeaderView forumHeaderView = (ForumHeaderView) linearLayout.findViewById(R.id.recommend_forum_header_serch_view);
        this.f59729g = forumHeaderView;
        forumHeaderView.setFrom(0);
        this.f59729g.b();
        NewPagerSlidingTabBaseStrip newPagerSlidingTabBaseStrip = (NewPagerSlidingTabBaseStrip) this.f59728f.findViewById(R.id.tab_layout);
        this.f59730h = newPagerSlidingTabBaseStrip;
        newPagerSlidingTabBaseStrip.setDefaultSelectorColorResourceId(R.color.CAM_X0105);
        this.f59730h.setRectPaintColor(R.color.CAM_X0302);
        this.f59730h.B(l.g(this.f59727e.getContext(), R.dimen.tbds46), l.g(this.f59727e.getContext(), R.dimen.tbds46), l.g(this.f59727e.getContext(), R.dimen.tbds10), l.g(this.f59727e.getContext(), R.dimen.tbds46), true);
        this.f59730h.setmIndicatorWidth(l.g(this.mContext.getPageActivity(), R.dimen.tbds42));
        this.f59730h.setIndicatorOvershot(l.g(this.mContext.getPageActivity(), R.dimen.tbds8));
        this.f59730h.setIndicatorRadius(l.g(this.mContext.getPageActivity(), R.dimen.tbds8));
        this.f59730h.setIndicatorMarginBottom(l.g(this.f59727e.getContext(), R.dimen.tbds0));
        this.f59730h.setExpandedTabLayoutParams(new LinearLayout.LayoutParams(-2, -1));
        this.f59730h.setTabPadding(l.g(this.f59727e.getContext(), R.dimen.tbds36), 0, l.g(this.f59727e.getContext(), R.dimen.tbds36), 0);
        this.f59730h.setViewPager(this.f59731i);
        this.f59730h.setOnPageChangeListener(this.C);
        this.s = this.f59728f.findViewById(R.id.enter_forum_tab_left_grandient);
        this.r = this.f59728f.findViewById(R.id.enter_forum_tab_right_grandient);
    }

    public void z(View view, Bundle bundle) {
        if (view == null) {
            return;
        }
        this.l = view;
        A(bundle);
        y(bundle);
        x(bundle);
        NoNetworkView noNetworkView = (NoNetworkView) this.l.findViewById(R.id.view_no_network);
        this.v = noNetworkView;
        noNetworkView.a(this);
    }
}
