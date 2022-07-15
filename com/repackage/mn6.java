package com.repackage;

import android.view.View;
import android.widget.TextView;
import androidx.annotation.NonNull;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* compiled from: HeaderViewLogic.java */
/* loaded from: classes6.dex */
public final /* synthetic */ class mn6 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    @NonNull
    public static nn6 a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) ? new on6() : (nn6) invokeV.objValue;
    }

    public static View b(View view2) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65537, null, view2)) == null) ? view2.findViewById(R.id.obfuscated_res_0x7f090b16) : (View) invokeL.objValue;
    }

    @NonNull
    public static TextView c(@NonNull View view2, boolean z) {
        InterceptResult invokeLZ;
        TextView textView;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLZ = interceptable.invokeLZ(65538, null, view2, z)) == null) {
            if (z) {
                textView = (TextView) view2.findViewById(R.id.obfuscated_res_0x7f090ccd);
            } else {
                textView = (TextView) view2.findViewById(R.id.obfuscated_res_0x7f090cce);
            }
            textView.bringToFront();
            ur4.d(textView).v(R.color.CAM_X0619);
            return textView;
        }
        return (TextView) invokeLZ.objValue;
    }

    public static void d(@NonNull View view2, @NonNull View view3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65539, null, view2, view3) == null) {
            ur4 d = ur4.d(view2);
            d.n(R.string.J_X11);
            d.s(R.array.Mask_X005);
        }
    }
}
