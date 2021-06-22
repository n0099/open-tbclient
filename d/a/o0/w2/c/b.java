package d.a.o0.w2.c;

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
    public AdSettingActivity f66398a;

    /* renamed from: b  reason: collision with root package name */
    public View f66399b;

    /* renamed from: c  reason: collision with root package name */
    public NavigationBar f66400c;

    /* renamed from: d  reason: collision with root package name */
    public MsgSettingItemView f66401d;

    /* renamed from: e  reason: collision with root package name */
    public TextView f66402e;

    /* renamed from: f  reason: collision with root package name */
    public View f66403f;

    /* renamed from: g  reason: collision with root package name */
    public View f66404g;

    /* renamed from: h  reason: collision with root package name */
    public TextView f66405h;

    /* renamed from: i  reason: collision with root package name */
    public TextView f66406i;
    public ImageView j;
    public TextView k;

    public b(AdSettingActivity adSettingActivity) {
        super(adSettingActivity.getPageContext());
        this.f66398a = adSettingActivity;
        f();
    }

    public View d() {
        return this.f66404g;
    }

    public final void e() {
        int i2;
        this.f66401d.setText(R.string.member_ad_setting_text);
        this.f66401d.setOnSwitchStateChangeListener(this.f66398a);
        AccountData currentAccountObj = TbadkCoreApplication.getCurrentAccountObj();
        int i3 = 0;
        if (currentAccountObj != null) {
            i3 = currentAccountObj.getMemberCloseAdIsOpen();
            i2 = currentAccountObj.getMemberCloseAdVipClose();
        } else {
            i2 = 0;
        }
        if (i3 == 0) {
            this.f66401d.setVisibility(8);
            this.f66402e.setVisibility(8);
        } else if (i2 == 0) {
            this.f66401d.e();
        } else {
            this.f66401d.g();
        }
        if (TextUtils.isEmpty(d.a.n0.r.d0.b.j().p("sync_ad_privacy_url", ""))) {
            this.f66403f.setVisibility(8);
        }
    }

    public final void f() {
        this.f66398a.setContentView(R.layout.ad_setting_activity);
        NavigationBar navigationBar = (NavigationBar) this.f66398a.findViewById(R.id.view_navigation_bar);
        this.f66400c = navigationBar;
        navigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.f66400c.setTitleText(this.f66398a.getPageContext().getString(R.string.ad_control_setting));
        MsgSettingItemView msgSettingItemView = (MsgSettingItemView) this.f66398a.findViewById(R.id.memberAdSetting);
        this.f66401d = msgSettingItemView;
        msgSettingItemView.setLineVisibility(false);
        this.f66402e = (TextView) this.f66398a.findViewById(R.id.memberAdTips);
        this.f66403f = this.f66398a.findViewById(R.id.privacyContainer);
        this.f66404g = this.f66398a.findViewById(R.id.privacyItem);
        this.k = (TextView) this.f66398a.findViewById(R.id.privacyControlText);
        this.f66405h = (TextView) this.f66398a.findViewById(R.id.privacyControlTipsSmall);
        this.f66405h = (TextView) this.f66398a.findViewById(R.id.privacyControlTipsSmall);
        this.f66406i = (TextView) this.f66398a.findViewById(R.id.privacyControlTips);
        this.j = (ImageView) this.f66398a.findViewById(R.id.arrow);
        this.f66399b = this.f66398a.findViewById(R.id.parent);
        this.f66404g.setOnClickListener(this.f66398a);
        e();
    }

    public void h() {
        this.f66401d.e();
    }

    public void i() {
        this.f66401d.g();
    }

    public void onChangeSkinType(int i2) {
        this.f66398a.getLayoutMode().k(i2 == 1);
        this.f66398a.getLayoutMode().j(this.f66399b);
        this.f66400c.onChangeSkinType(getPageContext(), i2);
        SkinManager.setViewTextColor(this.f66402e, R.color.CAM_X0105);
        SkinManager.setViewTextColor(this.f66406i, R.color.CAM_X0105);
        SkinManager.setViewTextColor(this.k, R.color.CAM_X0105);
        SkinManager.setViewTextColor(this.f66405h, R.color.CAM_X0108);
        SkinManager.setBackgroundColor(this.f66402e, R.color.CAM_X0201);
        SvgManager.getInstance().setPureDrawableWithDayNightModeAutoChange(this.j, R.drawable.icon_pure_list_arrow16_right_svg, R.color.CAM_X0109, SvgManager.SvgResourceStateType.NORMAL);
        SkinManager.setBackgroundColor(this.f66403f, R.color.CAM_X0201);
        SkinManager.setBackgroundResource(this.f66404g, R.drawable.setting_item_selector);
    }
}
