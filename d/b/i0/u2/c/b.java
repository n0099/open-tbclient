package d.b.i0.u2.c;

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
public class b extends d.b.b.a.d<AdSettingActivity> {

    /* renamed from: a  reason: collision with root package name */
    public AdSettingActivity f61329a;

    /* renamed from: b  reason: collision with root package name */
    public View f61330b;

    /* renamed from: c  reason: collision with root package name */
    public NavigationBar f61331c;

    /* renamed from: d  reason: collision with root package name */
    public MsgSettingItemView f61332d;

    /* renamed from: e  reason: collision with root package name */
    public TextView f61333e;

    /* renamed from: f  reason: collision with root package name */
    public View f61334f;

    /* renamed from: g  reason: collision with root package name */
    public View f61335g;

    /* renamed from: h  reason: collision with root package name */
    public TextView f61336h;
    public TextView i;
    public ImageView j;
    public TextView k;

    public b(AdSettingActivity adSettingActivity) {
        super(adSettingActivity.getPageContext());
        this.f61329a = adSettingActivity;
        f();
    }

    public View d() {
        return this.f61335g;
    }

    public final void e() {
        int i;
        this.f61332d.setText(R.string.member_ad_setting_text);
        this.f61332d.setOnSwitchStateChangeListener(this.f61329a);
        AccountData currentAccountObj = TbadkCoreApplication.getCurrentAccountObj();
        int i2 = 0;
        if (currentAccountObj != null) {
            i2 = currentAccountObj.getMemberCloseAdIsOpen();
            i = currentAccountObj.getMemberCloseAdVipClose();
        } else {
            i = 0;
        }
        if (i2 == 0) {
            this.f61332d.setVisibility(8);
            this.f61333e.setVisibility(8);
        } else if (i == 0) {
            this.f61332d.e();
        } else {
            this.f61332d.g();
        }
        if (TextUtils.isEmpty(d.b.h0.r.d0.b.i().o("sync_ad_privacy_url", ""))) {
            this.f61334f.setVisibility(8);
        }
    }

    public final void f() {
        this.f61329a.setContentView(R.layout.ad_setting_activity);
        NavigationBar navigationBar = (NavigationBar) this.f61329a.findViewById(R.id.view_navigation_bar);
        this.f61331c = navigationBar;
        navigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.f61331c.setTitleText(this.f61329a.getPageContext().getString(R.string.ad_control_setting));
        MsgSettingItemView msgSettingItemView = (MsgSettingItemView) this.f61329a.findViewById(R.id.memberAdSetting);
        this.f61332d = msgSettingItemView;
        msgSettingItemView.setLineVisibility(false);
        this.f61333e = (TextView) this.f61329a.findViewById(R.id.memberAdTips);
        this.f61334f = this.f61329a.findViewById(R.id.privacyContainer);
        this.f61335g = this.f61329a.findViewById(R.id.privacyItem);
        this.k = (TextView) this.f61329a.findViewById(R.id.privacyControlText);
        this.f61336h = (TextView) this.f61329a.findViewById(R.id.privacyControlTipsSmall);
        this.f61336h = (TextView) this.f61329a.findViewById(R.id.privacyControlTipsSmall);
        this.i = (TextView) this.f61329a.findViewById(R.id.privacyControlTips);
        this.j = (ImageView) this.f61329a.findViewById(R.id.arrow);
        this.f61330b = this.f61329a.findViewById(R.id.parent);
        this.f61335g.setOnClickListener(this.f61329a);
        e();
    }

    public void h() {
        this.f61332d.e();
    }

    public void i() {
        this.f61332d.g();
    }

    public void onChangeSkinType(int i) {
        this.f61329a.getLayoutMode().k(i == 1);
        this.f61329a.getLayoutMode().j(this.f61330b);
        this.f61331c.onChangeSkinType(getPageContext(), i);
        SkinManager.setViewTextColor(this.f61333e, R.color.CAM_X0105);
        SkinManager.setViewTextColor(this.i, R.color.CAM_X0105);
        SkinManager.setViewTextColor(this.k, R.color.CAM_X0105);
        SkinManager.setViewTextColor(this.f61336h, R.color.CAM_X0108);
        SkinManager.setBackgroundColor(this.f61333e, R.color.CAM_X0201);
        SvgManager.getInstance().setPureDrawableWithDayNightModeAutoChange(this.j, R.drawable.icon_pure_list_arrow16_right_svg, R.color.CAM_X0109, SvgManager.SvgResourceStateType.NORMAL);
        SkinManager.setBackgroundColor(this.f61334f, R.color.CAM_X0201);
        SkinManager.setBackgroundResource(this.f61335g, R.drawable.setting_item_selector);
    }
}
