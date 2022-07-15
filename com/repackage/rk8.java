package com.repackage;

import android.content.Context;
import android.location.Address;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.pass.ecommerce.bean.SuggestAddrField;
import com.baidu.tbadk.core.util.NetWork;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.SvgManager;
import com.baidu.tbadk.coreExtra.data.WriteData;
import com.baidu.tieba.R;
import com.baidu.tieba.tbadkCore.location.LocationData;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes7.dex */
public class rk8 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static void a(NetWork netWork, WriteData writeData) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(65536, null, netWork, writeData) == null) && writeData != null && writeData.isHasLocationData()) {
            netWork.addPostData("is_location", "2");
            Address j = jf.n().j(false);
            if (j != null) {
                netWork.addPostData(SuggestAddrField.KEY_LAT, String.valueOf(j.getLatitude()));
                netWork.addPostData(SuggestAddrField.KEY_LNG, String.valueOf(j.getLongitude()));
            }
            LocationData b = nj8.a().b();
            if (b != null) {
                netWork.addPostData("name", b.getFormatted_address());
                netWork.addPostData("sn", b.getSn());
            }
        }
    }

    public static void b(Context context, String str, String str2, String str3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(65537, null, context, str, str2, str3) == null) {
            View inflate = LayoutInflater.from(context).inflate(R.layout.obfuscated_res_0x7f0d0701, (ViewGroup) null);
            inflate.setBackgroundDrawable(SkinManager.createShapeDrawableFromColor(pi.f(context, R.dimen.tbds32), SkinManager.getColor(R.color.CAM_X0701)));
            View findViewById = inflate.findViewById(R.id.obfuscated_res_0x7f090918);
            TextView textView = (TextView) inflate.findViewById(R.id.obfuscated_res_0x7f091e61);
            SkinManager.setViewTextColor(textView, (int) R.color.CAM_X0101);
            TextView textView2 = (TextView) inflate.findViewById(R.id.obfuscated_res_0x7f091972);
            SkinManager.setViewTextColor(textView2, (int) R.color.CAM_X0101);
            TextView textView3 = (TextView) inflate.findViewById(R.id.obfuscated_res_0x7f090646);
            SkinManager.setViewTextColor(textView3, (int) R.color.CAM_X0305);
            ImageView imageView = (ImageView) inflate.findViewById(R.id.obfuscated_res_0x7f091e60);
            if (imageView != null) {
                imageView.setBackgroundDrawable(SvgManager.getInstance().getPureDrawable(R.drawable.obfuscated_res_0x7f0809c0, R.color.CAM_X0101, null));
            }
            if (StringUtils.isNull(str)) {
                str = context.getString(R.string.obfuscated_res_0x7f0f1119);
            }
            textView.setText(str);
            if (str2 != null || str3 != null) {
                findViewById.setVisibility(0);
                textView2.setText(str2);
                textView3.setText(str3);
            }
            c(context, inflate);
        }
    }

    public static void c(Context context, View view2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65538, null, context, view2) == null) {
            Toast toast = new Toast(context);
            toast.setView(view2);
            toast.setGravity(17, 0, 0);
            toast.setDuration(3000);
            toast.show();
        }
    }
}
