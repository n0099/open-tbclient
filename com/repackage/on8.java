package com.repackage;

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
import tbclient.GetIconList.IconInfo;
import tbclient.GetIconList.Setting;
/* loaded from: classes6.dex */
public class on8 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public TbPageContext a;
    public int b;
    public RoundRelativeLayout c;
    public TextView d;
    public TextView e;
    public TextView f;
    public TextView g;
    public LinearLayout h;
    public TextView i;
    public TextView j;

    public on8(TbPageContext tbPageContext, int i) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {tbPageContext, Integer.valueOf(i)};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = tbPageContext;
        this.b = i;
        c();
    }

    public final void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            RoundRelativeLayout roundRelativeLayout = (RoundRelativeLayout) LayoutInflater.from(this.a.getPageActivity()).inflate(this.b == 3 ? R.layout.obfuscated_res_0x7f0d038c : R.layout.obfuscated_res_0x7f0d038b, (ViewGroup) null);
            this.c = roundRelativeLayout;
            roundRelativeLayout.setRadius(this.a.getResources().getDimensionPixelSize(R.dimen.obfuscated_res_0x7f0702e9));
        }
    }

    public View b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.c : (View) invokeV.objValue;
    }

    public final void c() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            a();
            this.d = (TextView) this.c.findViewById(R.id.obfuscated_res_0x7f090481);
            this.e = (TextView) this.c.findViewById(R.id.obfuscated_res_0x7f090484);
            this.f = (TextView) this.c.findViewById(R.id.obfuscated_res_0x7f09047d);
            this.h = (LinearLayout) this.c.findViewById(R.id.obfuscated_res_0x7f09047a);
            this.i = (TextView) this.c.findViewById(R.id.obfuscated_res_0x7f090479);
            this.j = (TextView) this.c.findViewById(R.id.obfuscated_res_0x7f090478);
            this.g = (TextView) this.c.findViewById(R.id.obfuscated_res_0x7f09047e);
        }
    }

    public void d(ln8 ln8Var) {
        IconInfo iconInfo;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048579, this, ln8Var) == null) || ln8Var == null || (iconInfo = ln8Var.b) == null) {
            return;
        }
        this.d.setText(StringHelper.formatTosepara(iconInfo.non_member_t.intValue()));
        Drawable normalSkinMoneyIcon = CurrencySwitchUtil.getNormalSkinMoneyIcon();
        int dimensionPixelSize = this.a.getResources().getDimensionPixelSize(R.dimen.tbds46);
        normalSkinMoneyIcon.setBounds(0, 0, dimensionPixelSize, dimensionPixelSize);
        this.d.setCompoundDrawablePadding(this.a.getResources().getDimensionPixelSize(R.dimen.tbds12));
        this.d.setCompoundDrawables(normalSkinMoneyIcon, null, null, null);
        this.f.setText(String.valueOf(iconInfo.dubi.intValue() / 100));
        Integer num = iconInfo.duration;
        this.e.setText(this.a.getPageActivity().getString(R.string.obfuscated_res_0x7f0f0896, new Object[]{iconInfo.name, Integer.valueOf(num == null ? 0 : num.intValue())}));
        Setting setting = ln8Var.a;
        if (setting != null) {
            if (setting.vip_extra_switch.intValue() == 1 && ln8Var.a.vip_extra_percent.intValue() > 0) {
                this.i.setText(hn8.a((ln8Var.b.non_member_t.intValue() * ln8Var.a.vip_extra_percent.intValue()) / 100));
                Drawable normalSkinMoneyIcon2 = CurrencySwitchUtil.getNormalSkinMoneyIcon();
                int dimensionPixelSize2 = this.a.getResources().getDimensionPixelSize(R.dimen.tbds28);
                normalSkinMoneyIcon2.setBounds(0, 0, dimensionPixelSize2, dimensionPixelSize2);
                this.i.setCompoundDrawablePadding(this.a.getResources().getDimensionPixelSize(R.dimen.obfuscated_res_0x7f0702e9));
                this.i.setCompoundDrawables(normalSkinMoneyIcon2, null, null, null);
                this.h.setVisibility(0);
            } else {
                this.h.setVisibility(8);
            }
        } else {
            this.h.setVisibility(8);
        }
        e(TbadkCoreApplication.getInst().getSkinType());
    }

    public void e(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048580, this, i) == null) {
            if (i != 1 && i != 4) {
                this.c.setBgColorRes(R.color.CAM_X0201);
            } else {
                this.c.setBgColorRes(R.color.CAM_X0201_1);
            }
            SkinManager.setViewTextColor(this.d, R.color.CAM_X0105, 1, i);
            SkinManager.setViewTextColor(this.f, R.color.CAM_X0105, 1, i);
            SkinManager.setViewTextColor(this.e, R.color.CAM_X0107, 1, i);
            SkinManager.setViewTextColor(this.i, R.color.CAM_X0107, 1, i);
            SkinManager.setViewTextColor(this.j, R.color.CAM_X0107, 1, i);
            SkinManager.setViewTextColor(this.g, R.color.CAM_X0105, 1, i);
        }
    }
}
