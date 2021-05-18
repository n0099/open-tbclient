package d.a.k0.q0.y1;

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
    public f f59702a;

    /* renamed from: b  reason: collision with root package name */
    public NavigationBar f59703b;

    /* renamed from: c  reason: collision with root package name */
    public SpecialFrsWebFragment f59704c;

    /* renamed from: d  reason: collision with root package name */
    public d.a.k0.b0.d f59705d;

    /* renamed from: e  reason: collision with root package name */
    public ImageView f59706e;

    /* renamed from: f  reason: collision with root package name */
    public ImageView f59707f;

    /* renamed from: g  reason: collision with root package name */
    public ImageView f59708g;

    /* renamed from: h  reason: collision with root package name */
    public View.OnClickListener f59709h = new a();

    /* renamed from: i  reason: collision with root package name */
    public CustomMessageListener f59710i = new b(2001626);

    /* loaded from: classes4.dex */
    public class a implements View.OnClickListener {
        public a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (view == d.this.f59706e) {
                d.this.r();
            } else if (d.this.f59705d == null || view != d.this.f59705d.c()) {
                if (view != d.this.f59708g) {
                    if (view == d.this.f59707f) {
                        d dVar = d.this;
                        dVar.q(dVar.f59704c.m1(null, null, null, null));
                    }
                } else if (StringUtils.isNull(d.this.h())) {
                } else {
                    d.this.f59702a.sendMessage(new CustomMessage(2002001, new ForumDetailActivityConfig(d.this.f59702a.getPageActivity(), d.this.h(), ForumDetailActivityConfig.FromType.FRS_GAME_LIVE)));
                }
            } else if (ViewHelper.checkUpIsLogin(d.this.f59702a.getPageActivity())) {
                TiebaStatic.log(new StatisticItem(CommonStatisticKey.MESSAGE_ENTER_ICON_CLICK).param("obj_locate", 2));
                d.this.f59702a.sendMessage(new CustomMessage(2002001, new MessageCenterActivityConfig(d.this.f59702a.getPageActivity())));
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
            if (d.this.f59705d != null) {
                d.this.f59705d.e(z, msgCount);
            }
        }
    }

    public d(f fVar) {
        this.f59702a = fVar;
        d.a.k0.b0.d dVar = new d.a.k0.b0.d(fVar.getPageActivity());
        this.f59705d = dVar;
        dVar.c().setOnClickListener(this.f59709h);
        this.f59702a.registerListener(this.f59710i);
    }

    public String h() {
        SpecialFrsWebFragment specialFrsWebFragment = this.f59704c;
        return specialFrsWebFragment != null ? specialFrsWebFragment.h() : "";
    }

    public String i() {
        SpecialFrsWebFragment specialFrsWebFragment = this.f59704c;
        return specialFrsWebFragment != null ? specialFrsWebFragment.g() : "";
    }

    public NavigationBar j() {
        return this.f59703b;
    }

    public void k(NavigationBar navigationBar, SpecialFrsWebFragment specialFrsWebFragment) {
        this.f59703b = navigationBar;
        this.f59704c = specialFrsWebFragment;
        navigationBar.showBottomLine();
        this.f59703b.getBarBgView().setAlpha(1.0f);
        this.f59703b.setCenterTextTitle(i());
        ImageView imageView = (ImageView) this.f59703b.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON).findViewById(R.id.widget_navi_back_button);
        this.f59706e = imageView;
        imageView.setOnClickListener(this.f59709h);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
        layoutParams.setMargins(0, 0, l.g(this.f59702a.getPageActivity(), R.dimen.ds24), 0);
        ImageView imageView2 = (ImageView) this.f59703b.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, R.layout.special_frs_web_navigation_share, (View.OnClickListener) null);
        this.f59707f = imageView2;
        imageView2.setLayoutParams(layoutParams);
        this.f59707f.setOnClickListener(this.f59709h);
        ImageView imageView3 = (ImageView) this.f59703b.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, R.layout.widget_frs_forum_info_item, (View.OnClickListener) null);
        this.f59708g = imageView3;
        imageView3.setLayoutParams(layoutParams);
        this.f59708g.setOnClickListener(this.f59709h);
        o(specialFrsWebFragment.H0());
        p(specialFrsWebFragment.I0());
        n(specialFrsWebFragment.G0());
        l(TbadkCoreApplication.getInst().getSkinType());
    }

    public void l(int i2) {
        NavigationBar navigationBar;
        if (this.f59704c == null || (navigationBar = this.f59703b) == null) {
            return;
        }
        navigationBar.onChangeSkinType(this.f59702a, i2);
        SkinManager.setViewTextColor(this.f59703b.mTextTitle, R.color.CAM_X0105, 1);
        SkinManager.setViewTextColor(this.f59703b.mCenterText, R.color.CAM_X0105, 1);
        SkinManager.setBackgroundColor(this.f59703b.getBottomLine(), R.color.CAM_X0204);
        SvgManager.getInstance().setPureDrawableWithDayNightModeAutoChange(this.f59706e, R.drawable.ic_icon_pure_topbar_return40_svg, R.color.CAM_X0106, SvgManager.SvgResourceStateType.NORMAL_PRESS);
        d.a.k0.b0.d dVar = this.f59705d;
        if (dVar != null) {
            dVar.d(i2);
        }
        SkinManager.setNavbarIconSrc(this.f59708g, R.drawable.selector_web_topbar_other_black, R.drawable.selector_web_topbar_other_white);
        SvgManager.getInstance().setPureDrawableWithDayNightModeAutoChange(this.f59707f, R.drawable.icon_pure_topbar_share44_svg, R.color.CAM_X0106, SvgManager.SvgResourceStateType.NORMAL_PRESS);
    }

    public void m() {
        NavigationBar navigationBar = this.f59703b;
        if (navigationBar != null) {
            navigationBar.release();
        }
        MessageManager.getInstance().unRegisterListener(this.f59710i);
    }

    public void n(boolean z) {
        ImageView imageView = this.f59708g;
        if (imageView != null) {
            imageView.setVisibility(z ? 0 : 8);
        }
    }

    public void o(boolean z) {
        NavigationBar navigationBar = this.f59703b;
        if (navigationBar != null) {
            navigationBar.setVisibility(z ? 0 : 8);
        }
    }

    public void p(boolean z) {
        ImageView imageView = this.f59707f;
        if (imageView != null) {
            imageView.setVisibility(z ? 0 : 8);
        }
    }

    public void q(ShareItem shareItem) {
        SpecialFrsWebFragment specialFrsWebFragment = this.f59704c;
        if (specialFrsWebFragment != null) {
            specialFrsWebFragment.x1(shareItem);
        }
    }

    public final void r() {
        CustomResponsedMessage customResponsedMessage = new CustomResponsedMessage(2921342);
        customResponsedMessage.setmOrginalMessage(new CustomMessage(2001627, this.f59702a.getUniqueId()));
        MessageManager.getInstance().dispatchResponsedMessage(customResponsedMessage);
    }
}
