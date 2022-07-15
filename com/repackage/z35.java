package com.repackage;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.CommonStatisticKey;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.SvgManager;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.tbselector.TBSelector;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes7.dex */
public class z35 implements b45 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public View a;
    public ImageView b;
    public ImageView c;
    public TextView d;
    public LinearLayout e;

    public z35(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        View inflate = LayoutInflater.from(TbadkCoreApplication.getInst()).inflate(R.layout.obfuscated_res_0x7f0d028e, (ViewGroup) null);
        this.a = inflate;
        this.b = (ImageView) inflate.findViewById(R.id.obfuscated_res_0x7f0909b9);
        this.d = (TextView) this.a.findViewById(R.id.obfuscated_res_0x7f0909bb);
        this.c = (ImageView) this.a.findViewById(R.id.obfuscated_res_0x7f0909b7);
        this.e = (LinearLayout) this.a.findViewById(R.id.obfuscated_res_0x7f0909ba);
        this.d.setText(R.string.obfuscated_res_0x7f0f06d5);
        b();
    }

    @Override // com.repackage.b45
    public void b() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || this.a == null) {
            return;
        }
        SkinManager.setViewTextColor(this.d, (int) R.color.CAM_X0101);
        SkinManager.setImageResource(this.b, R.drawable.obfuscated_res_0x7f080ea1);
        SvgManager.getInstance().setPureDrawableWithDayNightModeAutoChange(this.c, R.drawable.obfuscated_res_0x7f0805e4, R.color.CAM_X0101, SvgManager.SvgResourceStateType.NORMAL);
        TBSelector.makeDrawableSelector().defaultColor(R.color.CAM_X0305).setShape(0).setAlpha(211).tlRadius(pi.f(TbadkCoreApplication.getInst(), R.dimen.tbds52)).blRadius(pi.f(TbadkCoreApplication.getInst(), R.dimen.tbds52)).into(this.e);
    }

    @Override // com.repackage.b45
    public View getView() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            View view2 = this.a;
            return view2 != null ? view2 : LayoutInflater.from(TbadkCoreApplication.getInst()).inflate(R.layout.obfuscated_res_0x7f0d028e, (ViewGroup) null);
        }
        return (View) invokeV.objValue;
    }

    @Override // com.repackage.b45
    public void onClick() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            TiebaStatic.log(new StatisticItem(CommonStatisticKey.KEY_FRS_FORUM_FLOAT_CLICK).param("uid", TbadkCoreApplication.getCurrentAccountId()));
        }
    }
}
