package d.a.j0.q0.y1;

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
    public f f58960a;

    /* renamed from: b  reason: collision with root package name */
    public NavigationBar f58961b;

    /* renamed from: c  reason: collision with root package name */
    public SpecialFrsWebFragment f58962c;

    /* renamed from: d  reason: collision with root package name */
    public d.a.j0.b0.d f58963d;

    /* renamed from: e  reason: collision with root package name */
    public ImageView f58964e;

    /* renamed from: f  reason: collision with root package name */
    public ImageView f58965f;

    /* renamed from: g  reason: collision with root package name */
    public ImageView f58966g;

    /* renamed from: h  reason: collision with root package name */
    public View.OnClickListener f58967h = new a();

    /* renamed from: i  reason: collision with root package name */
    public CustomMessageListener f58968i = new b(2001626);

    /* loaded from: classes4.dex */
    public class a implements View.OnClickListener {
        public a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (view == d.this.f58964e) {
                d.this.r();
            } else if (d.this.f58963d == null || view != d.this.f58963d.c()) {
                if (view != d.this.f58966g) {
                    if (view == d.this.f58965f) {
                        d dVar = d.this;
                        dVar.q(dVar.f58962c.n1(null, null, null, null));
                    }
                } else if (StringUtils.isNull(d.this.h())) {
                } else {
                    d.this.f58960a.sendMessage(new CustomMessage(2002001, new ForumDetailActivityConfig(d.this.f58960a.getPageActivity(), d.this.h(), ForumDetailActivityConfig.FromType.FRS_GAME_LIVE)));
                }
            } else if (ViewHelper.checkUpIsLogin(d.this.f58960a.getPageActivity())) {
                TiebaStatic.log(new StatisticItem(CommonStatisticKey.MESSAGE_ENTER_ICON_CLICK).param("obj_locate", 2));
                d.this.f58960a.sendMessage(new CustomMessage(2002001, new MessageCenterActivityConfig(d.this.f58960a.getPageActivity())));
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
            if (d.this.f58963d != null) {
                d.this.f58963d.e(z, msgCount);
            }
        }
    }

    public d(f fVar) {
        this.f58960a = fVar;
        d.a.j0.b0.d dVar = new d.a.j0.b0.d(fVar.getPageActivity());
        this.f58963d = dVar;
        dVar.c().setOnClickListener(this.f58967h);
        this.f58960a.registerListener(this.f58968i);
    }

    public String h() {
        SpecialFrsWebFragment specialFrsWebFragment = this.f58962c;
        return specialFrsWebFragment != null ? specialFrsWebFragment.h() : "";
    }

    public String i() {
        SpecialFrsWebFragment specialFrsWebFragment = this.f58962c;
        return specialFrsWebFragment != null ? specialFrsWebFragment.g() : "";
    }

    public NavigationBar j() {
        return this.f58961b;
    }

    public void k(NavigationBar navigationBar, SpecialFrsWebFragment specialFrsWebFragment) {
        this.f58961b = navigationBar;
        this.f58962c = specialFrsWebFragment;
        navigationBar.showBottomLine();
        this.f58961b.getBarBgView().setAlpha(1.0f);
        this.f58961b.setCenterTextTitle(i());
        ImageView imageView = (ImageView) this.f58961b.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON).findViewById(R.id.widget_navi_back_button);
        this.f58964e = imageView;
        imageView.setOnClickListener(this.f58967h);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
        layoutParams.setMargins(0, 0, l.g(this.f58960a.getPageActivity(), R.dimen.ds24), 0);
        ImageView imageView2 = (ImageView) this.f58961b.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, R.layout.special_frs_web_navigation_share, (View.OnClickListener) null);
        this.f58965f = imageView2;
        imageView2.setLayoutParams(layoutParams);
        this.f58965f.setOnClickListener(this.f58967h);
        ImageView imageView3 = (ImageView) this.f58961b.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, R.layout.widget_frs_forum_info_item, (View.OnClickListener) null);
        this.f58966g = imageView3;
        imageView3.setLayoutParams(layoutParams);
        this.f58966g.setOnClickListener(this.f58967h);
        o(specialFrsWebFragment.I0());
        p(specialFrsWebFragment.J0());
        n(specialFrsWebFragment.H0());
        l(TbadkCoreApplication.getInst().getSkinType());
    }

    public void l(int i2) {
        NavigationBar navigationBar;
        if (this.f58962c == null || (navigationBar = this.f58961b) == null) {
            return;
        }
        navigationBar.onChangeSkinType(this.f58960a, i2);
        SkinManager.setViewTextColor(this.f58961b.mTextTitle, R.color.CAM_X0105, 1);
        SkinManager.setViewTextColor(this.f58961b.mCenterText, R.color.CAM_X0105, 1);
        SkinManager.setBackgroundColor(this.f58961b.getBottomLine(), R.color.CAM_X0204);
        SvgManager.getInstance().setPureDrawableWithDayNightModeAutoChange(this.f58964e, R.drawable.ic_icon_pure_topbar_return40_svg, R.color.CAM_X0106, SvgManager.SvgResourceStateType.NORMAL_PRESS);
        d.a.j0.b0.d dVar = this.f58963d;
        if (dVar != null) {
            dVar.d(i2);
        }
        SkinManager.setNavbarIconSrc(this.f58966g, R.drawable.selector_web_topbar_other_black, R.drawable.selector_web_topbar_other_white);
        SvgManager.getInstance().setPureDrawableWithDayNightModeAutoChange(this.f58965f, R.drawable.icon_pure_topbar_share44_svg, R.color.CAM_X0106, SvgManager.SvgResourceStateType.NORMAL_PRESS);
    }

    public void m() {
        NavigationBar navigationBar = this.f58961b;
        if (navigationBar != null) {
            navigationBar.release();
        }
        MessageManager.getInstance().unRegisterListener(this.f58968i);
    }

    public void n(boolean z) {
        ImageView imageView = this.f58966g;
        if (imageView != null) {
            imageView.setVisibility(z ? 0 : 8);
        }
    }

    public void o(boolean z) {
        NavigationBar navigationBar = this.f58961b;
        if (navigationBar != null) {
            navigationBar.setVisibility(z ? 0 : 8);
        }
    }

    public void p(boolean z) {
        ImageView imageView = this.f58965f;
        if (imageView != null) {
            imageView.setVisibility(z ? 0 : 8);
        }
    }

    public void q(ShareItem shareItem) {
        SpecialFrsWebFragment specialFrsWebFragment = this.f58962c;
        if (specialFrsWebFragment != null) {
            specialFrsWebFragment.y1(shareItem);
        }
    }

    public final void r() {
        CustomResponsedMessage customResponsedMessage = new CustomResponsedMessage(2921342);
        customResponsedMessage.setmOrginalMessage(new CustomMessage(2001627, this.f58960a.getUniqueId()));
        MessageManager.getInstance().dispatchResponsedMessage(customResponsedMessage);
    }
}
