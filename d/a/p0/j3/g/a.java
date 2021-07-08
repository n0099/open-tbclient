package d.a.p0.j3.g;

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
import d.a.p0.j3.e.b;
import tbclient.GetIconList.IconInfo;
import tbclient.GetIconList.Setting;
/* loaded from: classes8.dex */
public class a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public TbPageContext f59194a;

    /* renamed from: b  reason: collision with root package name */
    public int f59195b;

    /* renamed from: c  reason: collision with root package name */
    public RoundRelativeLayout f59196c;

    /* renamed from: d  reason: collision with root package name */
    public TextView f59197d;

    /* renamed from: e  reason: collision with root package name */
    public TextView f59198e;

    /* renamed from: f  reason: collision with root package name */
    public TextView f59199f;

    /* renamed from: g  reason: collision with root package name */
    public TextView f59200g;

    /* renamed from: h  reason: collision with root package name */
    public LinearLayout f59201h;

    /* renamed from: i  reason: collision with root package name */
    public TextView f59202i;
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
        this.f59194a = tbPageContext;
        this.f59195b = i2;
        c();
    }

    public final void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            int i2 = R.layout.grid_view_2_column_item_layout;
            if (this.f59195b == 3) {
                i2 = R.layout.grid_view_3_column_item_layout;
            }
            RoundRelativeLayout roundRelativeLayout = (RoundRelativeLayout) LayoutInflater.from(this.f59194a.getPageActivity()).inflate(i2, (ViewGroup) null);
            this.f59196c = roundRelativeLayout;
            roundRelativeLayout.setRadius(this.f59194a.getResources().getDimensionPixelSize(R.dimen.ds6));
        }
    }

    public View b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.f59196c : (View) invokeV.objValue;
    }

    public final void c() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            a();
            this.f59197d = (TextView) this.f59196c.findViewById(R.id.buy_tbean_t_dou_num);
            this.f59198e = (TextView) this.f59196c.findViewById(R.id.buy_tbean_yinji_time);
            this.f59199f = (TextView) this.f59196c.findViewById(R.id.buy_tbean_price);
            this.f59201h = (LinearLayout) this.f59196c.findViewById(R.id.buy_tbean_member_privilege_layout);
            this.f59202i = (TextView) this.f59196c.findViewById(R.id.buy_tbean_member_privilege);
            this.j = (TextView) this.f59196c.findViewById(R.id.buy_tbean_member_prefix);
            this.f59200g = (TextView) this.f59196c.findViewById(R.id.buy_tbean_price_prefix);
        }
    }

    public void d(b bVar) {
        IconInfo iconInfo;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048579, this, bVar) == null) || bVar == null || (iconInfo = bVar.f59189f) == null) {
            return;
        }
        this.f59197d.setText(StringHelper.formatTosepara(iconInfo.non_member_t.intValue()));
        Drawable normalSkinMoneyIcon = CurrencySwitchUtil.getNormalSkinMoneyIcon();
        int dimensionPixelSize = this.f59194a.getResources().getDimensionPixelSize(R.dimen.tbds46);
        normalSkinMoneyIcon.setBounds(0, 0, dimensionPixelSize, dimensionPixelSize);
        this.f59197d.setCompoundDrawablePadding(this.f59194a.getResources().getDimensionPixelSize(R.dimen.tbds12));
        this.f59197d.setCompoundDrawables(normalSkinMoneyIcon, null, null, null);
        this.f59199f.setText(String.valueOf(iconInfo.dubi.intValue() / 100));
        Integer num = iconInfo.duration;
        this.f59198e.setText(this.f59194a.getPageActivity().getString(R.string.icon_name_valid_day, new Object[]{iconInfo.name, Integer.valueOf(num == null ? 0 : num.intValue())}));
        Setting setting = bVar.f59188e;
        if (setting != null) {
            if (setting.vip_extra_switch.intValue() == 1 && bVar.f59188e.vip_extra_percent.intValue() > 0) {
                this.f59202i.setText(d.a.p0.j3.b.a((bVar.f59189f.non_member_t.intValue() * bVar.f59188e.vip_extra_percent.intValue()) / 100));
                Drawable normalSkinMoneyIcon2 = CurrencySwitchUtil.getNormalSkinMoneyIcon();
                int dimensionPixelSize2 = this.f59194a.getResources().getDimensionPixelSize(R.dimen.tbds28);
                normalSkinMoneyIcon2.setBounds(0, 0, dimensionPixelSize2, dimensionPixelSize2);
                this.f59202i.setCompoundDrawablePadding(this.f59194a.getResources().getDimensionPixelSize(R.dimen.ds6));
                this.f59202i.setCompoundDrawables(normalSkinMoneyIcon2, null, null, null);
                this.f59201h.setVisibility(0);
            } else {
                this.f59201h.setVisibility(8);
            }
        } else {
            this.f59201h.setVisibility(8);
        }
        e(TbadkCoreApplication.getInst().getSkinType());
    }

    public void e(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048580, this, i2) == null) {
            if (i2 != 1 && i2 != 4) {
                this.f59196c.setBgColorRes(R.color.CAM_X0201);
            } else {
                this.f59196c.setBgColorRes(R.color.CAM_X0201_1);
            }
            SkinManager.setViewTextColor(this.f59197d, R.color.CAM_X0105, 1, i2);
            SkinManager.setViewTextColor(this.f59199f, R.color.CAM_X0105, 1, i2);
            SkinManager.setViewTextColor(this.f59198e, R.color.CAM_X0107, 1, i2);
            SkinManager.setViewTextColor(this.f59202i, R.color.CAM_X0107, 1, i2);
            SkinManager.setViewTextColor(this.j, R.color.CAM_X0107, 1, i2);
            SkinManager.setViewTextColor(this.f59200g, R.color.CAM_X0105, 1, i2);
        }
    }
}
