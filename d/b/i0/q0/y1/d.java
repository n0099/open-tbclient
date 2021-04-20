package d.b.i0.q0.y1;

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
import d.b.c.a.f;
import d.b.c.e.p.l;
/* loaded from: classes4.dex */
public class d {

    /* renamed from: a  reason: collision with root package name */
    public f f60423a;

    /* renamed from: b  reason: collision with root package name */
    public NavigationBar f60424b;

    /* renamed from: c  reason: collision with root package name */
    public SpecialFrsWebFragment f60425c;

    /* renamed from: d  reason: collision with root package name */
    public d.b.i0.b0.d f60426d;

    /* renamed from: e  reason: collision with root package name */
    public ImageView f60427e;

    /* renamed from: f  reason: collision with root package name */
    public ImageView f60428f;

    /* renamed from: g  reason: collision with root package name */
    public ImageView f60429g;

    /* renamed from: h  reason: collision with root package name */
    public View.OnClickListener f60430h = new a();
    public CustomMessageListener i = new b(2001626);

    /* loaded from: classes4.dex */
    public class a implements View.OnClickListener {
        public a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (view == d.this.f60427e) {
                d.this.r();
            } else if (d.this.f60426d == null || view != d.this.f60426d.c()) {
                if (view != d.this.f60429g) {
                    if (view == d.this.f60428f) {
                        d dVar = d.this;
                        dVar.q(dVar.f60425c.n1(null, null, null, null));
                    }
                } else if (StringUtils.isNull(d.this.h())) {
                } else {
                    d.this.f60423a.sendMessage(new CustomMessage(2002001, new ForumDetailActivityConfig(d.this.f60423a.getPageActivity(), d.this.h(), ForumDetailActivityConfig.FromType.FRS_GAME_LIVE)));
                }
            } else if (ViewHelper.checkUpIsLogin(d.this.f60423a.getPageActivity())) {
                TiebaStatic.log(new StatisticItem(CommonStatisticKey.MESSAGE_ENTER_ICON_CLICK).param("obj_locate", 2));
                d.this.f60423a.sendMessage(new CustomMessage(2002001, new MessageCenterActivityConfig(d.this.f60423a.getPageActivity())));
            }
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
            NewsRemindMessage newsRemindMessage;
            if (customResponsedMessage == null || !(customResponsedMessage instanceof NewsRemindMessage) || customResponsedMessage.getCmd() != 2001626 || (newsRemindMessage = (NewsRemindMessage) customResponsedMessage) == null) {
                return;
            }
            int msgCount = newsRemindMessage.getMsgCount() + newsRemindMessage.getChatCount() + newsRemindMessage.getNotificationCount();
            boolean z = newsRemindMessage.hasMsgRemind() || newsRemindMessage.hasChatRemind() || newsRemindMessage.hasNotificationRemind();
            if (d.this.f60426d != null) {
                d.this.f60426d.e(z, msgCount);
            }
        }
    }

    public d(f fVar) {
        this.f60423a = fVar;
        d.b.i0.b0.d dVar = new d.b.i0.b0.d(fVar.getPageActivity());
        this.f60426d = dVar;
        dVar.c().setOnClickListener(this.f60430h);
        this.f60423a.registerListener(this.i);
    }

    public String h() {
        SpecialFrsWebFragment specialFrsWebFragment = this.f60425c;
        return specialFrsWebFragment != null ? specialFrsWebFragment.h() : "";
    }

    public String i() {
        SpecialFrsWebFragment specialFrsWebFragment = this.f60425c;
        return specialFrsWebFragment != null ? specialFrsWebFragment.i() : "";
    }

    public NavigationBar j() {
        return this.f60424b;
    }

    public void k(NavigationBar navigationBar, SpecialFrsWebFragment specialFrsWebFragment) {
        this.f60424b = navigationBar;
        this.f60425c = specialFrsWebFragment;
        navigationBar.showBottomLine();
        this.f60424b.getBarBgView().setAlpha(1.0f);
        this.f60424b.setCenterTextTitle(i());
        ImageView imageView = (ImageView) this.f60424b.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON).findViewById(R.id.widget_navi_back_button);
        this.f60427e = imageView;
        imageView.setOnClickListener(this.f60430h);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
        layoutParams.setMargins(0, 0, l.g(this.f60423a.getPageActivity(), R.dimen.ds24), 0);
        ImageView imageView2 = (ImageView) this.f60424b.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, R.layout.special_frs_web_navigation_share, (View.OnClickListener) null);
        this.f60428f = imageView2;
        imageView2.setLayoutParams(layoutParams);
        this.f60428f.setOnClickListener(this.f60430h);
        ImageView imageView3 = (ImageView) this.f60424b.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, R.layout.widget_frs_forum_info_item, (View.OnClickListener) null);
        this.f60429g = imageView3;
        imageView3.setLayoutParams(layoutParams);
        this.f60429g.setOnClickListener(this.f60430h);
        o(specialFrsWebFragment.I0());
        p(specialFrsWebFragment.J0());
        n(specialFrsWebFragment.H0());
        l(TbadkCoreApplication.getInst().getSkinType());
    }

    public void l(int i) {
        NavigationBar navigationBar;
        if (this.f60425c == null || (navigationBar = this.f60424b) == null) {
            return;
        }
        navigationBar.onChangeSkinType(this.f60423a, i);
        SkinManager.setViewTextColor(this.f60424b.mTextTitle, R.color.CAM_X0105, 1);
        SkinManager.setViewTextColor(this.f60424b.mCenterText, R.color.CAM_X0105, 1);
        SkinManager.setBackgroundColor(this.f60424b.getBottomLine(), R.color.CAM_X0204);
        SvgManager.getInstance().setPureDrawableWithDayNightModeAutoChange(this.f60427e, R.drawable.ic_icon_pure_topbar_return40_svg, R.color.CAM_X0106, SvgManager.SvgResourceStateType.NORMAL_PRESS);
        d.b.i0.b0.d dVar = this.f60426d;
        if (dVar != null) {
            dVar.d(i);
        }
        SkinManager.setNavbarIconSrc(this.f60429g, R.drawable.selector_web_topbar_other_black, R.drawable.selector_web_topbar_other_white);
        SvgManager.getInstance().setPureDrawableWithDayNightModeAutoChange(this.f60428f, R.drawable.icon_pure_topbar_share44_svg, R.color.CAM_X0106, SvgManager.SvgResourceStateType.NORMAL_PRESS);
    }

    public void m() {
        NavigationBar navigationBar = this.f60424b;
        if (navigationBar != null) {
            navigationBar.release();
        }
        MessageManager.getInstance().unRegisterListener(this.i);
    }

    public void n(boolean z) {
        ImageView imageView = this.f60429g;
        if (imageView != null) {
            imageView.setVisibility(z ? 0 : 8);
        }
    }

    public void o(boolean z) {
        NavigationBar navigationBar = this.f60424b;
        if (navigationBar != null) {
            navigationBar.setVisibility(z ? 0 : 8);
        }
    }

    public void p(boolean z) {
        ImageView imageView = this.f60428f;
        if (imageView != null) {
            imageView.setVisibility(z ? 0 : 8);
        }
    }

    public void q(ShareItem shareItem) {
        SpecialFrsWebFragment specialFrsWebFragment = this.f60425c;
        if (specialFrsWebFragment != null) {
            specialFrsWebFragment.y1(shareItem);
        }
    }

    public final void r() {
        CustomResponsedMessage customResponsedMessage = new CustomResponsedMessage(2921342);
        customResponsedMessage.setmOrginalMessage(new CustomMessage(2001627, this.f60423a.getUniqueId()));
        MessageManager.getInstance().dispatchResponsedMessage(customResponsedMessage);
    }
}
