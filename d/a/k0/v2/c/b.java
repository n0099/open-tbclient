package d.a.k0.v2.c;

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
    public AdSettingActivity f62451a;

    /* renamed from: b  reason: collision with root package name */
    public View f62452b;

    /* renamed from: c  reason: collision with root package name */
    public NavigationBar f62453c;

    /* renamed from: d  reason: collision with root package name */
    public MsgSettingItemView f62454d;

    /* renamed from: e  reason: collision with root package name */
    public TextView f62455e;

    /* renamed from: f  reason: collision with root package name */
    public View f62456f;

    /* renamed from: g  reason: collision with root package name */
    public View f62457g;

    /* renamed from: h  reason: collision with root package name */
    public TextView f62458h;

    /* renamed from: i  reason: collision with root package name */
    public TextView f62459i;
    public ImageView j;
    public TextView k;

    public b(AdSettingActivity adSettingActivity) {
        super(adSettingActivity.getPageContext());
        this.f62451a = adSettingActivity;
        f();
    }

    public View d() {
        return this.f62457g;
    }

    public final void e() {
        int i2;
        this.f62454d.setText(R.string.member_ad_setting_text);
        this.f62454d.setOnSwitchStateChangeListener(this.f62451a);
        AccountData currentAccountObj = TbadkCoreApplication.getCurrentAccountObj();
        int i3 = 0;
        if (currentAccountObj != null) {
            i3 = currentAccountObj.getMemberCloseAdIsOpen();
            i2 = currentAccountObj.getMemberCloseAdVipClose();
        } else {
            i2 = 0;
        }
        if (i3 == 0) {
            this.f62454d.setVisibility(8);
            this.f62455e.setVisibility(8);
        } else if (i2 == 0) {
            this.f62454d.e();
        } else {
            this.f62454d.g();
        }
        if (TextUtils.isEmpty(d.a.j0.r.d0.b.j().p("sync_ad_privacy_url", ""))) {
            this.f62456f.setVisibility(8);
        }
    }

    public final void f() {
        this.f62451a.setContentView(R.layout.ad_setting_activity);
        NavigationBar navigationBar = (NavigationBar) this.f62451a.findViewById(R.id.view_navigation_bar);
        this.f62453c = navigationBar;
        navigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.f62453c.setTitleText(this.f62451a.getPageContext().getString(R.string.ad_control_setting));
        MsgSettingItemView msgSettingItemView = (MsgSettingItemView) this.f62451a.findViewById(R.id.memberAdSetting);
        this.f62454d = msgSettingItemView;
        msgSettingItemView.setLineVisibility(false);
        this.f62455e = (TextView) this.f62451a.findViewById(R.id.memberAdTips);
        this.f62456f = this.f62451a.findViewById(R.id.privacyContainer);
        this.f62457g = this.f62451a.findViewById(R.id.privacyItem);
        this.k = (TextView) this.f62451a.findViewById(R.id.privacyControlText);
        this.f62458h = (TextView) this.f62451a.findViewById(R.id.privacyControlTipsSmall);
        this.f62458h = (TextView) this.f62451a.findViewById(R.id.privacyControlTipsSmall);
        this.f62459i = (TextView) this.f62451a.findViewById(R.id.privacyControlTips);
        this.j = (ImageView) this.f62451a.findViewById(R.id.arrow);
        this.f62452b = this.f62451a.findViewById(R.id.parent);
        this.f62457g.setOnClickListener(this.f62451a);
        e();
    }

    public void g() {
        this.f62454d.e();
    }

    public void h() {
        this.f62454d.g();
    }

    public void onChangeSkinType(int i2) {
        this.f62451a.getLayoutMode().k(i2 == 1);
        this.f62451a.getLayoutMode().j(this.f62452b);
        this.f62453c.onChangeSkinType(getPageContext(), i2);
        SkinManager.setViewTextColor(this.f62455e, R.color.CAM_X0105);
        SkinManager.setViewTextColor(this.f62459i, R.color.CAM_X0105);
        SkinManager.setViewTextColor(this.k, R.color.CAM_X0105);
        SkinManager.setViewTextColor(this.f62458h, R.color.CAM_X0108);
        SkinManager.setBackgroundColor(this.f62455e, R.color.CAM_X0201);
        SvgManager.getInstance().setPureDrawableWithDayNightModeAutoChange(this.j, R.drawable.icon_pure_list_arrow16_right_svg, R.color.CAM_X0109, SvgManager.SvgResourceStateType.NORMAL);
        SkinManager.setBackgroundColor(this.f62456f, R.color.CAM_X0201);
        SkinManager.setBackgroundResource(this.f62457g, R.drawable.setting_item_selector);
    }
}
