package com.repackage;

import android.view.View;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.core.view.InputDeviceCompat;
import com.baidu.tbadk.abtest.UbsABTestHelper;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* compiled from: HeaderViewLogic.java */
/* loaded from: classes6.dex */
public final /* synthetic */ class hn6 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    @NonNull
    public static in6 a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) {
            if (UbsABTestHelper.isFrsModifyABTestA()) {
                return new kn6();
            }
            return new jn6();
        }
        return (in6) invokeV.objValue;
    }

    public static View b(View view2) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, view2)) == null) {
            if (c()) {
                return view2.findViewById(R.id.obfuscated_res_0x7f090b2c);
            }
            return view2.findViewById(R.id.obfuscated_res_0x7f090b35);
        }
        return (View) invokeL.objValue;
    }

    public static boolean c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) ? UbsABTestHelper.isFrsModifyABTestA() : invokeV.booleanValue;
    }

    @NonNull
    public static TextView d(@NonNull View view2, boolean z) {
        InterceptResult invokeLZ;
        TextView textView;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLZ = interceptable.invokeLZ(65539, null, view2, z)) == null) {
            if (c()) {
                textView = (TextView) view2.findViewById(R.id.obfuscated_res_0x7f090a15);
            } else {
                if (z) {
                    textView = (TextView) view2.findViewById(R.id.obfuscated_res_0x7f090d10);
                } else {
                    textView = (TextView) view2.findViewById(R.id.obfuscated_res_0x7f090d11);
                }
                textView.bringToFront();
            }
            gs4.d(textView).v(R.color.CAM_X0619);
            return textView;
        }
        return (TextView) invokeLZ.objValue;
    }

    public static void e(@NonNull View view2, @NonNull View view3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(InputDeviceCompat.SOURCE_TRACKBALL, null, view2, view3) == null) {
            if (c()) {
                gs4.d(view3).o(new int[]{R.color.black_alpha0, R.color.black_alpha30});
                return;
            }
            gs4 d = gs4.d(view2);
            d.n(R.string.J_X11);
            d.s(R.array.Mask_X005);
        }
    }
}
