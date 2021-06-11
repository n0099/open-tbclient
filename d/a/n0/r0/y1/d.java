package d.a.n0.r0.y1;

import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.ForumDetailActivityConfig;
import com.baidu.tbadk.core.atomData.MessageCenterActivityConfig;
import com.baidu.tbadk.core.util.CommonStatisticKey;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.SvgManager;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.ViewHelper;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.coreExtra.messageCenter.NewsRemindMessage;
import com.baidu.tbadk.coreExtra.share.ShareItem;
import com.baidu.tieba.R;
import com.baidu.tieba.frs.gametabs.SpecialFrsWebFragment;
import d.a.c.a.f;
import d.a.c.e.p.l;
/* loaded from: classes4.dex */
public class d {

    /* renamed from: a  reason: collision with root package name */
    public f f63534a;

    /* renamed from: b  reason: collision with root package name */
    public NavigationBar f63535b;

    /* renamed from: c  reason: collision with root package name */
    public SpecialFrsWebFragment f63536c;

    /* renamed from: d  reason: collision with root package name */
    public d.a.n0.d0.d f63537d;

    /* renamed from: e  reason: collision with root package name */
    public ImageView f63538e;

    /* renamed from: f  reason: collision with root package name */
    public ImageView f63539f;

    /* renamed from: g  reason: collision with root package name */
    public ImageView f63540g;

    /* renamed from: h  reason: collision with root package name */
    public View.OnClickListener f63541h = new a();

    /* renamed from: i  reason: collision with root package name */
    public CustomMessageListener f63542i = new b(2001626);

    /* loaded from: classes4.dex */
    public class a implements View.OnClickListener {
        public a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (view == d.this.f63538e) {
                d.this.r();
            } else if (d.this.f63537d == null || view != d.this.f63537d.c()) {
                if (view != d.this.f63540g) {
                    if (view == d.this.f63539f) {
                        d dVar = d.this;
                        dVar.q(dVar.f63536c.p1(null, null, null, null));
                    }
                } else if (StringUtils.isNull(d.this.h())) {
                } else {
                    d.this.f63534a.sendMessage(new CustomMessage(2002001, new ForumDetailActivityConfig(d.this.f63534a.getPageActivity(), d.this.h(), ForumDetailActivityConfig.FromType.FRS_GAME_LIVE)));
                }
            } else if (ViewHelper.checkUpIsLogin(d.this.f63534a.getPageActivity())) {
                TiebaStatic.log(new StatisticItem(CommonStatisticKey.MESSAGE_ENTER_ICON_CLICK).param("obj_locate", 2));
                d.this.f63534a.sendMessage(new CustomMessage(2002001, new MessageCenterActivityConfig(d.this.f63534a.getPageActivity())));
            }
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
            NewsRemindMessage newsRemindMessage;
            if (customResponsedMessage == null || !(customResponsedMessage instanceof NewsRemindMessage) || customResponsedMessage.getCmd() != 2001626 || (newsRemindMessage = (NewsRemindMessage) customResponsedMessage) == null) {
                return;
            }
            int msgCount = newsRemindMessage.getMsgCount() + newsRemindMessage.getChatCount() + newsRemindMessage.getNotificationCount();
            boolean z = newsRemindMessage.hasMsgRemind() || newsRemindMessage.hasChatRemind() || newsRemindMessage.hasNotificationRemind();
            if (d.this.f63537d != null) {
                d.this.f63537d.e(z, msgCount);
            }
        }
    }

    public d(f fVar) {
        this.f63534a = fVar;
        d.a.n0.d0.d dVar = new d.a.n0.d0.d(fVar.getPageActivity());
        this.f63537d = dVar;
        dVar.c().setOnClickListener(this.f63541h);
        this.f63534a.registerListener(this.f63542i);
    }

    public String h() {
        SpecialFrsWebFragment specialFrsWebFragment = this.f63536c;
        return specialFrsWebFragment != null ? specialFrsWebFragment.i() : "";
    }

    public String i() {
        SpecialFrsWebFragment specialFrsWebFragment = this.f63536c;
        return specialFrsWebFragment != null ? specialFrsWebFragment.h() : "";
    }

    public NavigationBar j() {
        return this.f63535b;
    }

    public void k(NavigationBar navigationBar, SpecialFrsWebFragment specialFrsWebFragment) {
        this.f63535b = navigationBar;
        this.f63536c = specialFrsWebFragment;
        navigationBar.showBottomLine();
        this.f63535b.getBarBgView().setAlpha(1.0f);
        this.f63535b.setCenterTextTitle(i());
        ImageView imageView = (ImageView) this.f63535b.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON).findViewById(R.id.widget_navi_back_button);
        this.f63538e = imageView;
        imageView.setOnClickListener(this.f63541h);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
        layoutParams.setMargins(0, 0, l.g(this.f63534a.getPageActivity(), R.dimen.ds24), 0);
        ImageView imageView2 = (ImageView) this.f63535b.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, R.layout.special_frs_web_navigation_share, (View.OnClickListener) null);
        this.f63539f = imageView2;
        imageView2.setLayoutParams(layoutParams);
        this.f63539f.setOnClickListener(this.f63541h);
        ImageView imageView3 = (ImageView) this.f63535b.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, R.layout.widget_frs_forum_info_item, (View.OnClickListener) null);
        this.f63540g = imageView3;
        imageView3.setLayoutParams(layoutParams);
        this.f63540g.setOnClickListener(this.f63541h);
        o(specialFrsWebFragment.K0());
        p(specialFrsWebFragment.L0());
        n(specialFrsWebFragment.J0());
        l(TbadkCoreApplication.getInst().getSkinType());
    }

    public void l(int i2) {
        NavigationBar navigationBar;
        if (this.f63536c == null || (navigationBar = this.f63535b) == null) {
            return;
        }
        navigationBar.onChangeSkinType(this.f63534a, i2);
        SkinManager.setViewTextColor(this.f63535b.mTextTitle, R.color.CAM_X0105, 1);
        SkinManager.setViewTextColor(this.f63535b.mCenterText, R.color.CAM_X0105, 1);
        SkinManager.setBackgroundColor(this.f63535b.getBottomLine(), R.color.CAM_X0204);
        SvgManager.getInstance().setPureDrawableWithDayNightModeAutoChange(this.f63538e, R.drawable.ic_icon_pure_topbar_return40_svg, R.color.CAM_X0106, SvgManager.SvgResourceStateType.NORMAL_PRESS);
        d.a.n0.d0.d dVar = this.f63537d;
        if (dVar != null) {
            dVar.d(i2);
        }
        SkinManager.setNavbarIconSrc(this.f63540g, R.drawable.selector_web_topbar_other_black, R.drawable.selector_web_topbar_other_white);
        SvgManager.getInstance().setPureDrawableWithDayNightModeAutoChange(this.f63539f, R.drawable.icon_pure_topbar_share44_svg, R.color.CAM_X0106, SvgManager.SvgResourceStateType.NORMAL_PRESS);
    }

    public void m() {
        NavigationBar navigationBar = this.f63535b;
        if (navigationBar != null) {
            navigationBar.release();
        }
        MessageManager.getInstance().unRegisterListener(this.f63542i);
    }

    public void n(boolean z) {
        ImageView imageView = this.f63540g;
        if (imageView != null) {
            imageView.setVisibility(z ? 0 : 8);
        }
    }

    public void o(boolean z) {
        NavigationBar navigationBar = this.f63535b;
        if (navigationBar != null) {
            navigationBar.setVisibility(z ? 0 : 8);
        }
    }

    public void p(boolean z) {
        ImageView imageView = this.f63539f;
        if (imageView != null) {
            imageView.setVisibility(z ? 0 : 8);
        }
    }

    public void q(ShareItem shareItem) {
        SpecialFrsWebFragment specialFrsWebFragment = this.f63536c;
        if (specialFrsWebFragment != null) {
            specialFrsWebFragment.A1(shareItem);
        }
    }

    public final void r() {
        CustomResponsedMessage customResponsedMessage = new CustomResponsedMessage(2921342);
        customResponsedMessage.setmOrginalMessage(new CustomMessage(2001627, this.f63534a.getUniqueId()));
        MessageManager.getInstance().dispatchResponsedMessage(customResponsedMessage);
    }
}
