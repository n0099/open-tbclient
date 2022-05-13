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
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.WebPManager;
import com.baidu.tbadk.core.util.tbselector.TBSelector;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes6.dex */
public class n35 implements o35 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public View a;
    public ImageView b;
    public ImageView c;
    public TextView d;
    public LinearLayout e;

    public n35(Context context) {
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
        View inflate = LayoutInflater.from(TbadkCoreApplication.getInst()).inflate(R.layout.obfuscated_res_0x7f0d0296, (ViewGroup) null);
        this.a = inflate;
        this.b = (ImageView) inflate.findViewById(R.id.obfuscated_res_0x7f0909da);
        this.d = (TextView) this.a.findViewById(R.id.obfuscated_res_0x7f0909dc);
        this.c = (ImageView) this.a.findViewById(R.id.obfuscated_res_0x7f0909d8);
        this.e = (LinearLayout) this.a.findViewById(R.id.obfuscated_res_0x7f0909db);
        this.d.setText(R.string.obfuscated_res_0x7f0f06d2);
        b();
    }

    @Override // com.repackage.o35
    public void b() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || this.a == null) {
            return;
        }
        SkinManager.setViewTextColor(this.d, (int) R.color.CAM_X0101);
        this.c.setImageDrawable(WebPManager.getPureDrawable(R.drawable.icon_pure_arrow12_right_n, SkinManager.getColor(R.color.CAM_X0101), WebPManager.ResourceStateType.NORMAL_PRESS));
        TBSelector.makeDrawableSelector().defaultColor(R.color.CAM_X0302).setShape(0).setAlpha(com.kuaishou.weapon.un.w0.A).tlRadius(mi.f(TbadkCoreApplication.getInst(), R.dimen.tbds52)).blRadius(mi.f(TbadkCoreApplication.getInst(), R.dimen.tbds52)).into(this.e);
        this.b.setImageDrawable(WebPManager.getMaskDrawable((int) R.drawable.obfuscated_res_0x7f0807f1, WebPManager.ResourceStateType.NORMAL));
    }

    @Override // com.repackage.o35
    public View getView() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            View view2 = this.a;
            return view2 != null ? view2 : LayoutInflater.from(TbadkCoreApplication.getInst()).inflate(R.layout.obfuscated_res_0x7f0d0294, (ViewGroup) null);
        }
        return (View) invokeV.objValue;
    }

    @Override // com.repackage.o35
    public void onClick() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
        }
    }
}
