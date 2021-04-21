package d.b.j0.v2.c;

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
/* loaded from: classes4.dex */
public class b extends d.b.c.a.d<AdSettingActivity> {

    /* renamed from: a  reason: collision with root package name */
    public AdSettingActivity f63489a;

    /* renamed from: b  reason: collision with root package name */
    public View f63490b;

    /* renamed from: c  reason: collision with root package name */
    public NavigationBar f63491c;

    /* renamed from: d  reason: collision with root package name */
    public MsgSettingItemView f63492d;

    /* renamed from: e  reason: collision with root package name */
    public TextView f63493e;

    /* renamed from: f  reason: collision with root package name */
    public View f63494f;

    /* renamed from: g  reason: collision with root package name */
    public View f63495g;

    /* renamed from: h  reason: collision with root package name */
    public TextView f63496h;
    public TextView i;
    public ImageView j;
    public TextView k;

    public b(AdSettingActivity adSettingActivity) {
        super(adSettingActivity.getPageContext());
        this.f63489a = adSettingActivity;
        f();
    }

    public View d() {
        return this.f63495g;
    }

    public final void e() {
        int i;
        this.f63492d.setText(R.string.member_ad_setting_text);
        this.f63492d.setOnSwitchStateChangeListener(this.f63489a);
        AccountData currentAccountObj = TbadkCoreApplication.getCurrentAccountObj();
        int i2 = 0;
        if (currentAccountObj != null) {
            i2 = currentAccountObj.getMemberCloseAdIsOpen();
            i = currentAccountObj.getMemberCloseAdVipClose();
        } else {
            i = 0;
        }
        if (i2 == 0) {
            this.f63492d.setVisibility(8);
            this.f63493e.setVisibility(8);
        } else if (i == 0) {
            this.f63492d.e();
        } else {
            this.f63492d.g();
        }
        if (TextUtils.isEmpty(d.b.i0.r.d0.b.j().p("sync_ad_privacy_url", ""))) {
            this.f63494f.setVisibility(8);
        }
    }

    public final void f() {
        this.f63489a.setContentView(R.layout.ad_setting_activity);
        NavigationBar navigationBar = (NavigationBar) this.f63489a.findViewById(R.id.view_navigation_bar);
        this.f63491c = navigationBar;
        navigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.f63491c.setTitleText(this.f63489a.getPageContext().getString(R.string.ad_control_setting));
        MsgSettingItemView msgSettingItemView = (MsgSettingItemView) this.f63489a.findViewById(R.id.memberAdSetting);
        this.f63492d = msgSettingItemView;
        msgSettingItemView.setLineVisibility(false);
        this.f63493e = (TextView) this.f63489a.findViewById(R.id.memberAdTips);
        this.f63494f = this.f63489a.findViewById(R.id.privacyContainer);
        this.f63495g = this.f63489a.findViewById(R.id.privacyItem);
        this.k = (TextView) this.f63489a.findViewById(R.id.privacyControlText);
        this.f63496h = (TextView) this.f63489a.findViewById(R.id.privacyControlTipsSmall);
        this.f63496h = (TextView) this.f63489a.findViewById(R.id.privacyControlTipsSmall);
        this.i = (TextView) this.f63489a.findViewById(R.id.privacyControlTips);
        this.j = (ImageView) this.f63489a.findViewById(R.id.arrow);
        this.f63490b = this.f63489a.findViewById(R.id.parent);
        this.f63495g.setOnClickListener(this.f63489a);
        e();
    }

    public void h() {
        this.f63492d.e();
    }

    public void i() {
        this.f63492d.g();
    }

    public void onChangeSkinType(int i) {
        this.f63489a.getLayoutMode().k(i == 1);
        this.f63489a.getLayoutMode().j(this.f63490b);
        this.f63491c.onChangeSkinType(getPageContext(), i);
        SkinManager.setViewTextColor(this.f63493e, R.color.CAM_X0105);
        SkinManager.setViewTextColor(this.i, R.color.CAM_X0105);
        SkinManager.setViewTextColor(this.k, R.color.CAM_X0105);
        SkinManager.setViewTextColor(this.f63496h, R.color.CAM_X0108);
        SkinManager.setBackgroundColor(this.f63493e, R.color.CAM_X0201);
        SvgManager.getInstance().setPureDrawableWithDayNightModeAutoChange(this.j, R.drawable.icon_pure_list_arrow16_right_svg, R.color.CAM_X0109, SvgManager.SvgResourceStateType.NORMAL);
        SkinManager.setBackgroundColor(this.f63494f, R.color.CAM_X0201);
        SkinManager.setBackgroundResource(this.f63495g, R.drawable.setting_item_selector);
    }
}
