package d.a.q0.z2.c;

import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.AccountData;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.SvgManager;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tieba.R;
import com.baidu.tieba.setting.more.AdSettingActivity;
import com.baidu.tieba.setting.more.MsgSettingItemView;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes8.dex */
public class b extends d.a.d.a.d<AdSettingActivity> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public AdSettingActivity f67275a;

    /* renamed from: b  reason: collision with root package name */
    public View f67276b;

    /* renamed from: c  reason: collision with root package name */
    public NavigationBar f67277c;

    /* renamed from: d  reason: collision with root package name */
    public MsgSettingItemView f67278d;

    /* renamed from: e  reason: collision with root package name */
    public TextView f67279e;

    /* renamed from: f  reason: collision with root package name */
    public View f67280f;

    /* renamed from: g  reason: collision with root package name */
    public View f67281g;

    /* renamed from: h  reason: collision with root package name */
    public TextView f67282h;

    /* renamed from: i  reason: collision with root package name */
    public TextView f67283i;
    public ImageView j;
    public TextView k;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public b(AdSettingActivity adSettingActivity) {
        super(adSettingActivity.getPageContext());
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {adSettingActivity};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                super((d.a.d.a.f) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f67275a = adSettingActivity;
        f();
    }

    public View d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.f67281g : (View) invokeV.objValue;
    }

    public final void e() {
        int i2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            this.f67278d.setText(R.string.member_ad_setting_text);
            this.f67278d.setOnSwitchStateChangeListener(this.f67275a);
            AccountData currentAccountObj = TbadkCoreApplication.getCurrentAccountObj();
            int i3 = 0;
            if (currentAccountObj != null) {
                i3 = currentAccountObj.getMemberCloseAdIsOpen();
                i2 = currentAccountObj.getMemberCloseAdVipClose();
            } else {
                i2 = 0;
            }
            if (i3 == 0) {
                this.f67278d.setVisibility(8);
                this.f67279e.setVisibility(8);
            } else if (i2 == 0) {
                this.f67278d.e();
            } else {
                this.f67278d.g();
            }
            if (TextUtils.isEmpty(d.a.p0.s.d0.b.j().p("sync_ad_privacy_url", ""))) {
                this.f67280f.setVisibility(8);
            }
        }
    }

    public final void f() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            this.f67275a.setContentView(R.layout.ad_setting_activity);
            NavigationBar navigationBar = (NavigationBar) this.f67275a.findViewById(R.id.view_navigation_bar);
            this.f67277c = navigationBar;
            navigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
            this.f67277c.setTitleText(this.f67275a.getPageContext().getString(R.string.ad_control_setting));
            MsgSettingItemView msgSettingItemView = (MsgSettingItemView) this.f67275a.findViewById(R.id.memberAdSetting);
            this.f67278d = msgSettingItemView;
            msgSettingItemView.setLineVisibility(false);
            this.f67279e = (TextView) this.f67275a.findViewById(R.id.memberAdTips);
            this.f67280f = this.f67275a.findViewById(R.id.privacyContainer);
            this.f67281g = this.f67275a.findViewById(R.id.privacyItem);
            this.k = (TextView) this.f67275a.findViewById(R.id.privacyControlText);
            this.f67282h = (TextView) this.f67275a.findViewById(R.id.privacyControlTipsSmall);
            this.f67282h = (TextView) this.f67275a.findViewById(R.id.privacyControlTipsSmall);
            this.f67283i = (TextView) this.f67275a.findViewById(R.id.privacyControlTips);
            this.j = (ImageView) this.f67275a.findViewById(R.id.arrow);
            this.f67276b = this.f67275a.findViewById(R.id.parent);
            this.f67281g.setOnClickListener(this.f67275a);
            e();
        }
    }

    public void g() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            this.f67278d.e();
        }
    }

    public void h() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            this.f67278d.g();
        }
    }

    public void onChangeSkinType(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048581, this, i2) == null) {
            this.f67275a.getLayoutMode().k(i2 == 1);
            this.f67275a.getLayoutMode().j(this.f67276b);
            this.f67277c.onChangeSkinType(getPageContext(), i2);
            SkinManager.setViewTextColor(this.f67279e, R.color.CAM_X0105);
            SkinManager.setViewTextColor(this.f67283i, R.color.CAM_X0105);
            SkinManager.setViewTextColor(this.k, R.color.CAM_X0105);
            SkinManager.setViewTextColor(this.f67282h, R.color.CAM_X0108);
            SkinManager.setBackgroundColor(this.f67279e, R.color.CAM_X0201);
            SvgManager.getInstance().setPureDrawableWithDayNightModeAutoChange(this.j, R.drawable.icon_pure_list_arrow16_right_svg, R.color.CAM_X0109, SvgManager.SvgResourceStateType.NORMAL);
            SkinManager.setBackgroundColor(this.f67280f, R.color.CAM_X0201);
            SkinManager.setBackgroundResource(this.f67281g, R.drawable.setting_item_selector);
        }
    }
}
