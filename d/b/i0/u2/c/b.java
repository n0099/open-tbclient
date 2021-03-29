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
    public AdSettingActivity f61330a;

    /* renamed from: b  reason: collision with root package name */
    public View f61331b;

    /* renamed from: c  reason: collision with root package name */
    public NavigationBar f61332c;

    /* renamed from: d  reason: collision with root package name */
    public MsgSettingItemView f61333d;

    /* renamed from: e  reason: collision with root package name */
    public TextView f61334e;

    /* renamed from: f  reason: collision with root package name */
    public View f61335f;

    /* renamed from: g  reason: collision with root package name */
    public View f61336g;

    /* renamed from: h  reason: collision with root package name */
    public TextView f61337h;
    public TextView i;
    public ImageView j;
    public TextView k;

    public b(AdSettingActivity adSettingActivity) {
        super(adSettingActivity.getPageContext());
        this.f61330a = adSettingActivity;
        f();
    }

    public View d() {
        return this.f61336g;
    }

    public final void e() {
        int i;
        this.f61333d.setText(R.string.member_ad_setting_text);
        this.f61333d.setOnSwitchStateChangeListener(this.f61330a);
        AccountData currentAccountObj = TbadkCoreApplication.getCurrentAccountObj();
        int i2 = 0;
        if (currentAccountObj != null) {
            i2 = currentAccountObj.getMemberCloseAdIsOpen();
            i = currentAccountObj.getMemberCloseAdVipClose();
        } else {
            i = 0;
        }
        if (i2 == 0) {
            this.f61333d.setVisibility(8);
            this.f61334e.setVisibility(8);
        } else if (i == 0) {
            this.f61333d.e();
        } else {
            this.f61333d.g();
        }
        if (TextUtils.isEmpty(d.b.h0.r.d0.b.i().o("sync_ad_privacy_url", ""))) {
            this.f61335f.setVisibility(8);
        }
    }

    public final void f() {
        this.f61330a.setContentView(R.layout.ad_setting_activity);
        NavigationBar navigationBar = (NavigationBar) this.f61330a.findViewById(R.id.view_navigation_bar);
        this.f61332c = navigationBar;
        navigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.f61332c.setTitleText(this.f61330a.getPageContext().getString(R.string.ad_control_setting));
        MsgSettingItemView msgSettingItemView = (MsgSettingItemView) this.f61330a.findViewById(R.id.memberAdSetting);
        this.f61333d = msgSettingItemView;
        msgSettingItemView.setLineVisibility(false);
        this.f61334e = (TextView) this.f61330a.findViewById(R.id.memberAdTips);
        this.f61335f = this.f61330a.findViewById(R.id.privacyContainer);
        this.f61336g = this.f61330a.findViewById(R.id.privacyItem);
        this.k = (TextView) this.f61330a.findViewById(R.id.privacyControlText);
        this.f61337h = (TextView) this.f61330a.findViewById(R.id.privacyControlTipsSmall);
        this.f61337h = (TextView) this.f61330a.findViewById(R.id.privacyControlTipsSmall);
        this.i = (TextView) this.f61330a.findViewById(R.id.privacyControlTips);
        this.j = (ImageView) this.f61330a.findViewById(R.id.arrow);
        this.f61331b = this.f61330a.findViewById(R.id.parent);
        this.f61336g.setOnClickListener(this.f61330a);
        e();
    }

    public void h() {
        this.f61333d.e();
    }

    public void i() {
        this.f61333d.g();
    }

    public void onChangeSkinType(int i) {
        this.f61330a.getLayoutMode().k(i == 1);
        this.f61330a.getLayoutMode().j(this.f61331b);
        this.f61332c.onChangeSkinType(getPageContext(), i);
        SkinManager.setViewTextColor(this.f61334e, R.color.CAM_X0105);
        SkinManager.setViewTextColor(this.i, R.color.CAM_X0105);
        SkinManager.setViewTextColor(this.k, R.color.CAM_X0105);
        SkinManager.setViewTextColor(this.f61337h, R.color.CAM_X0108);
        SkinManager.setBackgroundColor(this.f61334e, R.color.CAM_X0201);
        SvgManager.getInstance().setPureDrawableWithDayNightModeAutoChange(this.j, R.drawable.icon_pure_list_arrow16_right_svg, R.color.CAM_X0109, SvgManager.SvgResourceStateType.NORMAL);
        SkinManager.setBackgroundColor(this.f61335f, R.color.CAM_X0201);
        SkinManager.setBackgroundResource(this.f61336g, R.drawable.setting_item_selector);
    }
}
