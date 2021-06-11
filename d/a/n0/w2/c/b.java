package d.a.n0.w2.c;

import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.AccountData;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.SvgManager;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tieba.R;
import com.baidu.tieba.setting.more.AdSettingActivity;
import com.baidu.tieba.setting.more.MsgSettingItemView;
/* loaded from: classes5.dex */
public class b extends d.a.c.a.d<AdSettingActivity> {

    /* renamed from: a  reason: collision with root package name */
    public AdSettingActivity f66273a;

    /* renamed from: b  reason: collision with root package name */
    public View f66274b;

    /* renamed from: c  reason: collision with root package name */
    public NavigationBar f66275c;

    /* renamed from: d  reason: collision with root package name */
    public MsgSettingItemView f66276d;

    /* renamed from: e  reason: collision with root package name */
    public TextView f66277e;

    /* renamed from: f  reason: collision with root package name */
    public View f66278f;

    /* renamed from: g  reason: collision with root package name */
    public View f66279g;

    /* renamed from: h  reason: collision with root package name */
    public TextView f66280h;

    /* renamed from: i  reason: collision with root package name */
    public TextView f66281i;
    public ImageView j;
    public TextView k;

    public b(AdSettingActivity adSettingActivity) {
        super(adSettingActivity.getPageContext());
        this.f66273a = adSettingActivity;
        f();
    }

    public View d() {
        return this.f66279g;
    }

    public final void e() {
        int i2;
        this.f66276d.setText(R.string.member_ad_setting_text);
        this.f66276d.setOnSwitchStateChangeListener(this.f66273a);
        AccountData currentAccountObj = TbadkCoreApplication.getCurrentAccountObj();
        int i3 = 0;
        if (currentAccountObj != null) {
            i3 = currentAccountObj.getMemberCloseAdIsOpen();
            i2 = currentAccountObj.getMemberCloseAdVipClose();
        } else {
            i2 = 0;
        }
        if (i3 == 0) {
            this.f66276d.setVisibility(8);
            this.f66277e.setVisibility(8);
        } else if (i2 == 0) {
            this.f66276d.e();
        } else {
            this.f66276d.g();
        }
        if (TextUtils.isEmpty(d.a.m0.r.d0.b.j().p("sync_ad_privacy_url", ""))) {
            this.f66278f.setVisibility(8);
        }
    }

    public final void f() {
        this.f66273a.setContentView(R.layout.ad_setting_activity);
        NavigationBar navigationBar = (NavigationBar) this.f66273a.findViewById(R.id.view_navigation_bar);
        this.f66275c = navigationBar;
        navigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.f66275c.setTitleText(this.f66273a.getPageContext().getString(R.string.ad_control_setting));
        MsgSettingItemView msgSettingItemView = (MsgSettingItemView) this.f66273a.findViewById(R.id.memberAdSetting);
        this.f66276d = msgSettingItemView;
        msgSettingItemView.setLineVisibility(false);
        this.f66277e = (TextView) this.f66273a.findViewById(R.id.memberAdTips);
        this.f66278f = this.f66273a.findViewById(R.id.privacyContainer);
        this.f66279g = this.f66273a.findViewById(R.id.privacyItem);
        this.k = (TextView) this.f66273a.findViewById(R.id.privacyControlText);
        this.f66280h = (TextView) this.f66273a.findViewById(R.id.privacyControlTipsSmall);
        this.f66280h = (TextView) this.f66273a.findViewById(R.id.privacyControlTipsSmall);
        this.f66281i = (TextView) this.f66273a.findViewById(R.id.privacyControlTips);
        this.j = (ImageView) this.f66273a.findViewById(R.id.arrow);
        this.f66274b = this.f66273a.findViewById(R.id.parent);
        this.f66279g.setOnClickListener(this.f66273a);
        e();
    }

    public void h() {
        this.f66276d.e();
    }

    public void i() {
        this.f66276d.g();
    }

    public void onChangeSkinType(int i2) {
        this.f66273a.getLayoutMode().k(i2 == 1);
        this.f66273a.getLayoutMode().j(this.f66274b);
        this.f66275c.onChangeSkinType(getPageContext(), i2);
        SkinManager.setViewTextColor(this.f66277e, R.color.CAM_X0105);
        SkinManager.setViewTextColor(this.f66281i, R.color.CAM_X0105);
        SkinManager.setViewTextColor(this.k, R.color.CAM_X0105);
        SkinManager.setViewTextColor(this.f66280h, R.color.CAM_X0108);
        SkinManager.setBackgroundColor(this.f66277e, R.color.CAM_X0201);
        SvgManager.getInstance().setPureDrawableWithDayNightModeAutoChange(this.j, R.drawable.icon_pure_list_arrow16_right_svg, R.color.CAM_X0109, SvgManager.SvgResourceStateType.NORMAL);
        SkinManager.setBackgroundColor(this.f66278f, R.color.CAM_X0201);
        SkinManager.setBackgroundResource(this.f66279g, R.drawable.setting_item_selector);
    }
}
