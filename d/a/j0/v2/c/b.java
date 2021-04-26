package d.a.j0.v2.c;

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
    public AdSettingActivity f61727a;

    /* renamed from: b  reason: collision with root package name */
    public View f61728b;

    /* renamed from: c  reason: collision with root package name */
    public NavigationBar f61729c;

    /* renamed from: d  reason: collision with root package name */
    public MsgSettingItemView f61730d;

    /* renamed from: e  reason: collision with root package name */
    public TextView f61731e;

    /* renamed from: f  reason: collision with root package name */
    public View f61732f;

    /* renamed from: g  reason: collision with root package name */
    public View f61733g;

    /* renamed from: h  reason: collision with root package name */
    public TextView f61734h;

    /* renamed from: i  reason: collision with root package name */
    public TextView f61735i;
    public ImageView j;
    public TextView k;

    public b(AdSettingActivity adSettingActivity) {
        super(adSettingActivity.getPageContext());
        this.f61727a = adSettingActivity;
        f();
    }

    public View d() {
        return this.f61733g;
    }

    public final void e() {
        int i2;
        this.f61730d.setText(R.string.member_ad_setting_text);
        this.f61730d.setOnSwitchStateChangeListener(this.f61727a);
        AccountData currentAccountObj = TbadkCoreApplication.getCurrentAccountObj();
        int i3 = 0;
        if (currentAccountObj != null) {
            i3 = currentAccountObj.getMemberCloseAdIsOpen();
            i2 = currentAccountObj.getMemberCloseAdVipClose();
        } else {
            i2 = 0;
        }
        if (i3 == 0) {
            this.f61730d.setVisibility(8);
            this.f61731e.setVisibility(8);
        } else if (i2 == 0) {
            this.f61730d.e();
        } else {
            this.f61730d.g();
        }
        if (TextUtils.isEmpty(d.a.i0.r.d0.b.j().p("sync_ad_privacy_url", ""))) {
            this.f61732f.setVisibility(8);
        }
    }

    public final void f() {
        this.f61727a.setContentView(R.layout.ad_setting_activity);
        NavigationBar navigationBar = (NavigationBar) this.f61727a.findViewById(R.id.view_navigation_bar);
        this.f61729c = navigationBar;
        navigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.f61729c.setTitleText(this.f61727a.getPageContext().getString(R.string.ad_control_setting));
        MsgSettingItemView msgSettingItemView = (MsgSettingItemView) this.f61727a.findViewById(R.id.memberAdSetting);
        this.f61730d = msgSettingItemView;
        msgSettingItemView.setLineVisibility(false);
        this.f61731e = (TextView) this.f61727a.findViewById(R.id.memberAdTips);
        this.f61732f = this.f61727a.findViewById(R.id.privacyContainer);
        this.f61733g = this.f61727a.findViewById(R.id.privacyItem);
        this.k = (TextView) this.f61727a.findViewById(R.id.privacyControlText);
        this.f61734h = (TextView) this.f61727a.findViewById(R.id.privacyControlTipsSmall);
        this.f61734h = (TextView) this.f61727a.findViewById(R.id.privacyControlTipsSmall);
        this.f61735i = (TextView) this.f61727a.findViewById(R.id.privacyControlTips);
        this.j = (ImageView) this.f61727a.findViewById(R.id.arrow);
        this.f61728b = this.f61727a.findViewById(R.id.parent);
        this.f61733g.setOnClickListener(this.f61727a);
        e();
    }

    public void g() {
        this.f61730d.e();
    }

    public void h() {
        this.f61730d.g();
    }

    public void onChangeSkinType(int i2) {
        this.f61727a.getLayoutMode().k(i2 == 1);
        this.f61727a.getLayoutMode().j(this.f61728b);
        this.f61729c.onChangeSkinType(getPageContext(), i2);
        SkinManager.setViewTextColor(this.f61731e, R.color.CAM_X0105);
        SkinManager.setViewTextColor(this.f61735i, R.color.CAM_X0105);
        SkinManager.setViewTextColor(this.k, R.color.CAM_X0105);
        SkinManager.setViewTextColor(this.f61734h, R.color.CAM_X0108);
        SkinManager.setBackgroundColor(this.f61731e, R.color.CAM_X0201);
        SvgManager.getInstance().setPureDrawableWithDayNightModeAutoChange(this.j, R.drawable.icon_pure_list_arrow16_right_svg, R.color.CAM_X0109, SvgManager.SvgResourceStateType.NORMAL);
        SkinManager.setBackgroundColor(this.f61732f, R.color.CAM_X0201);
        SkinManager.setBackgroundResource(this.f61733g, R.drawable.setting_item_selector);
    }
}
