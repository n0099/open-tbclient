package d.a.s0.z2.c;

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
/* loaded from: classes9.dex */
public class b extends d.a.c.a.d<AdSettingActivity> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public AdSettingActivity f69794a;

    /* renamed from: b  reason: collision with root package name */
    public View f69795b;

    /* renamed from: c  reason: collision with root package name */
    public NavigationBar f69796c;

    /* renamed from: d  reason: collision with root package name */
    public MsgSettingItemView f69797d;

    /* renamed from: e  reason: collision with root package name */
    public TextView f69798e;

    /* renamed from: f  reason: collision with root package name */
    public View f69799f;

    /* renamed from: g  reason: collision with root package name */
    public View f69800g;

    /* renamed from: h  reason: collision with root package name */
    public TextView f69801h;

    /* renamed from: i  reason: collision with root package name */
    public TextView f69802i;
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
                super((d.a.c.a.f) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f69794a = adSettingActivity;
        f();
    }

    public View d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.f69800g : (View) invokeV.objValue;
    }

    public final void e() {
        int i2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            this.f69797d.setText(R.string.member_ad_setting_text);
            this.f69797d.setOnSwitchStateChangeListener(this.f69794a);
            AccountData currentAccountObj = TbadkCoreApplication.getCurrentAccountObj();
            int i3 = 0;
            if (currentAccountObj != null) {
                i3 = currentAccountObj.getMemberCloseAdIsOpen();
                i2 = currentAccountObj.getMemberCloseAdVipClose();
            } else {
                i2 = 0;
            }
            if (i3 == 0) {
                this.f69797d.setVisibility(8);
                this.f69798e.setVisibility(8);
            } else if (i2 == 0) {
                this.f69797d.e();
            } else {
                this.f69797d.g();
            }
            if (TextUtils.isEmpty(d.a.r0.r.d0.b.j().p("sync_ad_privacy_url", ""))) {
                this.f69799f.setVisibility(8);
            }
        }
    }

    public final void f() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            this.f69794a.setContentView(R.layout.ad_setting_activity);
            NavigationBar navigationBar = (NavigationBar) this.f69794a.findViewById(R.id.view_navigation_bar);
            this.f69796c = navigationBar;
            navigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
            this.f69796c.setTitleText(this.f69794a.getPageContext().getString(R.string.ad_control_setting));
            MsgSettingItemView msgSettingItemView = (MsgSettingItemView) this.f69794a.findViewById(R.id.memberAdSetting);
            this.f69797d = msgSettingItemView;
            msgSettingItemView.setLineVisibility(false);
            this.f69798e = (TextView) this.f69794a.findViewById(R.id.memberAdTips);
            this.f69799f = this.f69794a.findViewById(R.id.privacyContainer);
            this.f69800g = this.f69794a.findViewById(R.id.privacyItem);
            this.k = (TextView) this.f69794a.findViewById(R.id.privacyControlText);
            this.f69801h = (TextView) this.f69794a.findViewById(R.id.privacyControlTipsSmall);
            this.f69801h = (TextView) this.f69794a.findViewById(R.id.privacyControlTipsSmall);
            this.f69802i = (TextView) this.f69794a.findViewById(R.id.privacyControlTips);
            this.j = (ImageView) this.f69794a.findViewById(R.id.arrow);
            this.f69795b = this.f69794a.findViewById(R.id.parent);
            this.f69800g.setOnClickListener(this.f69794a);
            e();
        }
    }

    public void h() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            this.f69797d.e();
        }
    }

    public void i() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            this.f69797d.g();
        }
    }

    public void onChangeSkinType(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048581, this, i2) == null) {
            this.f69794a.getLayoutMode().k(i2 == 1);
            this.f69794a.getLayoutMode().j(this.f69795b);
            this.f69796c.onChangeSkinType(getPageContext(), i2);
            SkinManager.setViewTextColor(this.f69798e, R.color.CAM_X0105);
            SkinManager.setViewTextColor(this.f69802i, R.color.CAM_X0105);
            SkinManager.setViewTextColor(this.k, R.color.CAM_X0105);
            SkinManager.setViewTextColor(this.f69801h, R.color.CAM_X0108);
            SkinManager.setBackgroundColor(this.f69798e, R.color.CAM_X0201);
            SvgManager.getInstance().setPureDrawableWithDayNightModeAutoChange(this.j, R.drawable.icon_pure_list_arrow16_right_svg, R.color.CAM_X0109, SvgManager.SvgResourceStateType.NORMAL);
            SkinManager.setBackgroundColor(this.f69799f, R.color.CAM_X0201);
            SkinManager.setBackgroundResource(this.f69800g, R.drawable.setting_item_selector);
        }
    }
}
