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
    public AdSettingActivity f62558a;

    /* renamed from: b  reason: collision with root package name */
    public View f62559b;

    /* renamed from: c  reason: collision with root package name */
    public NavigationBar f62560c;

    /* renamed from: d  reason: collision with root package name */
    public MsgSettingItemView f62561d;

    /* renamed from: e  reason: collision with root package name */
    public TextView f62562e;

    /* renamed from: f  reason: collision with root package name */
    public View f62563f;

    /* renamed from: g  reason: collision with root package name */
    public View f62564g;

    /* renamed from: h  reason: collision with root package name */
    public TextView f62565h;

    /* renamed from: i  reason: collision with root package name */
    public TextView f62566i;
    public ImageView j;
    public TextView k;

    public b(AdSettingActivity adSettingActivity) {
        super(adSettingActivity.getPageContext());
        this.f62558a = adSettingActivity;
        f();
    }

    public View d() {
        return this.f62564g;
    }

    public final void e() {
        int i2;
        this.f62561d.setText(R.string.member_ad_setting_text);
        this.f62561d.setOnSwitchStateChangeListener(this.f62558a);
        AccountData currentAccountObj = TbadkCoreApplication.getCurrentAccountObj();
        int i3 = 0;
        if (currentAccountObj != null) {
            i3 = currentAccountObj.getMemberCloseAdIsOpen();
            i2 = currentAccountObj.getMemberCloseAdVipClose();
        } else {
            i2 = 0;
        }
        if (i3 == 0) {
            this.f62561d.setVisibility(8);
            this.f62562e.setVisibility(8);
        } else if (i2 == 0) {
            this.f62561d.e();
        } else {
            this.f62561d.g();
        }
        if (TextUtils.isEmpty(d.a.m0.r.d0.b.j().p("sync_ad_privacy_url", ""))) {
            this.f62563f.setVisibility(8);
        }
    }

    public final void f() {
        this.f62558a.setContentView(R.layout.ad_setting_activity);
        NavigationBar navigationBar = (NavigationBar) this.f62558a.findViewById(R.id.view_navigation_bar);
        this.f62560c = navigationBar;
        navigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.f62560c.setTitleText(this.f62558a.getPageContext().getString(R.string.ad_control_setting));
        MsgSettingItemView msgSettingItemView = (MsgSettingItemView) this.f62558a.findViewById(R.id.memberAdSetting);
        this.f62561d = msgSettingItemView;
        msgSettingItemView.setLineVisibility(false);
        this.f62562e = (TextView) this.f62558a.findViewById(R.id.memberAdTips);
        this.f62563f = this.f62558a.findViewById(R.id.privacyContainer);
        this.f62564g = this.f62558a.findViewById(R.id.privacyItem);
        this.k = (TextView) this.f62558a.findViewById(R.id.privacyControlText);
        this.f62565h = (TextView) this.f62558a.findViewById(R.id.privacyControlTipsSmall);
        this.f62565h = (TextView) this.f62558a.findViewById(R.id.privacyControlTipsSmall);
        this.f62566i = (TextView) this.f62558a.findViewById(R.id.privacyControlTips);
        this.j = (ImageView) this.f62558a.findViewById(R.id.arrow);
        this.f62559b = this.f62558a.findViewById(R.id.parent);
        this.f62564g.setOnClickListener(this.f62558a);
        e();
    }

    public void g() {
        this.f62561d.e();
    }

    public void h() {
        this.f62561d.g();
    }

    public void onChangeSkinType(int i2) {
        this.f62558a.getLayoutMode().k(i2 == 1);
        this.f62558a.getLayoutMode().j(this.f62559b);
        this.f62560c.onChangeSkinType(getPageContext(), i2);
        SkinManager.setViewTextColor(this.f62562e, R.color.CAM_X0105);
        SkinManager.setViewTextColor(this.f62566i, R.color.CAM_X0105);
        SkinManager.setViewTextColor(this.k, R.color.CAM_X0105);
        SkinManager.setViewTextColor(this.f62565h, R.color.CAM_X0108);
        SkinManager.setBackgroundColor(this.f62562e, R.color.CAM_X0201);
        SvgManager.getInstance().setPureDrawableWithDayNightModeAutoChange(this.j, R.drawable.icon_pure_list_arrow16_right_svg, R.color.CAM_X0109, SvgManager.SvgResourceStateType.NORMAL);
        SkinManager.setBackgroundColor(this.f62563f, R.color.CAM_X0201);
        SkinManager.setBackgroundResource(this.f62564g, R.drawable.setting_item_selector);
    }
}
