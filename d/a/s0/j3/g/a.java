package d.a.s0.j3.g;

import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.StringHelper;
import com.baidu.tieba.R;
import com.baidu.tieba.tbean.view.RoundRelativeLayout;
import com.baidu.tieba.wallet.CurrencySwitchUtil;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import d.a.s0.j3.e.b;
import tbclient.GetIconList.IconInfo;
import tbclient.GetIconList.Setting;
/* loaded from: classes9.dex */
public class a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public TbPageContext f62429a;

    /* renamed from: b  reason: collision with root package name */
    public int f62430b;

    /* renamed from: c  reason: collision with root package name */
    public RoundRelativeLayout f62431c;

    /* renamed from: d  reason: collision with root package name */
    public TextView f62432d;

    /* renamed from: e  reason: collision with root package name */
    public TextView f62433e;

    /* renamed from: f  reason: collision with root package name */
    public TextView f62434f;

    /* renamed from: g  reason: collision with root package name */
    public TextView f62435g;

    /* renamed from: h  reason: collision with root package name */
    public LinearLayout f62436h;

    /* renamed from: i  reason: collision with root package name */
    public TextView f62437i;
    public TextView j;

    public a(TbPageContext tbPageContext, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {tbPageContext, Integer.valueOf(i2)};
            interceptable.invokeUnInit(65536, newInitContext);
            int i3 = newInitContext.flag;
            if ((i3 & 1) != 0) {
                int i4 = i3 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f62429a = tbPageContext;
        this.f62430b = i2;
        c();
    }

    public final void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            int i2 = R.layout.grid_view_2_column_item_layout;
            if (this.f62430b == 3) {
                i2 = R.layout.grid_view_3_column_item_layout;
            }
            RoundRelativeLayout roundRelativeLayout = (RoundRelativeLayout) LayoutInflater.from(this.f62429a.getPageActivity()).inflate(i2, (ViewGroup) null);
            this.f62431c = roundRelativeLayout;
            roundRelativeLayout.setRadius(this.f62429a.getResources().getDimensionPixelSize(R.dimen.ds6));
        }
    }

    public View b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.f62431c : (View) invokeV.objValue;
    }

    public final void c() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            a();
            this.f62432d = (TextView) this.f62431c.findViewById(R.id.buy_tbean_t_dou_num);
            this.f62433e = (TextView) this.f62431c.findViewById(R.id.buy_tbean_yinji_time);
            this.f62434f = (TextView) this.f62431c.findViewById(R.id.buy_tbean_price);
            this.f62436h = (LinearLayout) this.f62431c.findViewById(R.id.buy_tbean_member_privilege_layout);
            this.f62437i = (TextView) this.f62431c.findViewById(R.id.buy_tbean_member_privilege);
            this.j = (TextView) this.f62431c.findViewById(R.id.buy_tbean_member_prefix);
            this.f62435g = (TextView) this.f62431c.findViewById(R.id.buy_tbean_price_prefix);
        }
    }

    public void d(b bVar) {
        IconInfo iconInfo;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048579, this, bVar) == null) || bVar == null || (iconInfo = bVar.f62424f) == null) {
            return;
        }
        this.f62432d.setText(StringHelper.formatTosepara(iconInfo.non_member_t.intValue()));
        Drawable normalSkinMoneyIcon = CurrencySwitchUtil.getNormalSkinMoneyIcon();
        int dimensionPixelSize = this.f62429a.getResources().getDimensionPixelSize(R.dimen.tbds46);
        normalSkinMoneyIcon.setBounds(0, 0, dimensionPixelSize, dimensionPixelSize);
        this.f62432d.setCompoundDrawablePadding(this.f62429a.getResources().getDimensionPixelSize(R.dimen.tbds12));
        this.f62432d.setCompoundDrawables(normalSkinMoneyIcon, null, null, null);
        this.f62434f.setText(String.valueOf(iconInfo.dubi.intValue() / 100));
        Integer num = iconInfo.duration;
        this.f62433e.setText(this.f62429a.getPageActivity().getString(R.string.icon_name_valid_day, new Object[]{iconInfo.name, Integer.valueOf(num == null ? 0 : num.intValue())}));
        Setting setting = bVar.f62423e;
        if (setting != null) {
            if (setting.vip_extra_switch.intValue() == 1 && bVar.f62423e.vip_extra_percent.intValue() > 0) {
                this.f62437i.setText(d.a.s0.j3.b.a((bVar.f62424f.non_member_t.intValue() * bVar.f62423e.vip_extra_percent.intValue()) / 100));
                Drawable normalSkinMoneyIcon2 = CurrencySwitchUtil.getNormalSkinMoneyIcon();
                int dimensionPixelSize2 = this.f62429a.getResources().getDimensionPixelSize(R.dimen.tbds28);
                normalSkinMoneyIcon2.setBounds(0, 0, dimensionPixelSize2, dimensionPixelSize2);
                this.f62437i.setCompoundDrawablePadding(this.f62429a.getResources().getDimensionPixelSize(R.dimen.ds6));
                this.f62437i.setCompoundDrawables(normalSkinMoneyIcon2, null, null, null);
                this.f62436h.setVisibility(0);
            } else {
                this.f62436h.setVisibility(8);
            }
        } else {
            this.f62436h.setVisibility(8);
        }
        e(TbadkCoreApplication.getInst().getSkinType());
    }

    public void e(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048580, this, i2) == null) {
            if (i2 != 1 && i2 != 4) {
                this.f62431c.setBgColorRes(R.color.CAM_X0201);
            } else {
                this.f62431c.setBgColorRes(R.color.CAM_X0201_1);
            }
            SkinManager.setViewTextColor(this.f62432d, R.color.CAM_X0105, 1, i2);
            SkinManager.setViewTextColor(this.f62434f, R.color.CAM_X0105, 1, i2);
            SkinManager.setViewTextColor(this.f62433e, R.color.CAM_X0107, 1, i2);
            SkinManager.setViewTextColor(this.f62437i, R.color.CAM_X0107, 1, i2);
            SkinManager.setViewTextColor(this.j, R.color.CAM_X0107, 1, i2);
            SkinManager.setViewTextColor(this.f62435g, R.color.CAM_X0105, 1, i2);
        }
    }
}
