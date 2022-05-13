package com.repackage;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tieba.R;
import com.baidu.tieba.frs.game.strategy.data.LabelDataList;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes5.dex */
public class cj6 extends ej6 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public LabelDataList c;
    public Context d;
    public int e;
    public final int f;

    public cj6(Context context) {
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
        this.e = 0;
        this.d = context;
        this.f = context.getResources().getDimensionPixelSize(R.dimen.obfuscated_res_0x7f070258);
    }

    @Override // com.repackage.ej6
    public int b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? ListUtils.getCount(this.c) : invokeV.intValue;
    }

    @Override // com.repackage.ej6
    public Object c(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i)) == null) ? ListUtils.getItem(this.c, i) : invokeI.objValue;
    }

    @Override // com.repackage.ej6
    public int d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.f : invokeV.intValue;
    }

    @Override // com.repackage.ej6
    public long e(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(1048579, this, i)) == null) ? i : invokeI.longValue;
    }

    @Override // com.repackage.ej6
    public View g(int i, View view2, ViewGroup viewGroup) {
        InterceptResult invokeILL;
        TextView m;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeILL = interceptable.invokeILL(1048580, this, i, view2, viewGroup)) == null) {
            if (view2 instanceof TextView) {
                m = (TextView) view2;
            } else {
                m = m();
            }
            ti6 ti6Var = (ti6) ListUtils.getItem(this.c, i);
            if (ti6Var != null) {
                m.setText(ti6Var.b);
            }
            l(m, this.e == i);
            return m;
        }
        return (View) invokeILL.objValue;
    }

    @Override // com.repackage.ej6
    public void j(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048581, this, i) == null) {
            this.e = i;
            this.c.setSelectedIndex(i);
            notifyDataSetChanged();
        }
    }

    public void l(TextView textView, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLZ(1048582, this, textView, z) == null) {
            if (z) {
                SkinManager.setViewTextColor(textView, (int) R.color.CAM_X0302);
                SkinManager.setBackgroundResource(textView, R.drawable.shape_frs_game_label_item_bg_s);
                return;
            }
            SkinManager.setViewTextColor(textView, (int) R.color.CAM_X0106);
            SkinManager.setBackgroundResource(textView, R.drawable.shape_frs_game_label_item_bg_n);
        }
    }

    public final TextView m() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            TextView textView = new TextView(this.d);
            textView.setTextSize(0, this.d.getResources().getDimensionPixelSize(R.dimen.obfuscated_res_0x7f070330));
            textView.setGravity(17);
            textView.setHeight(d());
            return textView;
        }
        return (TextView) invokeV.objValue;
    }

    public void n(LabelDataList labelDataList) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, labelDataList) == null) {
            this.c = labelDataList;
            notifyDataSetChanged();
        }
    }
}
