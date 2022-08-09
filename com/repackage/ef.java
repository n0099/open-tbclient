package com.repackage;

import android.graphics.Rect;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.lib.guide.MaskView;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes6.dex */
public class ef {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static View a(LayoutInflater layoutInflater, ff ffVar) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65536, null, layoutInflater, ffVar)) == null) {
            View c = ffVar.c(layoutInflater);
            MaskView.LayoutParams layoutParams = new MaskView.LayoutParams(-2, -2);
            layoutParams.c = ffVar.getXOffset();
            layoutParams.d = ffVar.getYOffset();
            layoutParams.a = ffVar.a();
            layoutParams.b = ffVar.b();
            ViewGroup.LayoutParams layoutParams2 = c.getLayoutParams();
            if (layoutParams2 != null) {
                ((ViewGroup.LayoutParams) layoutParams).width = layoutParams2.width;
                ((ViewGroup.LayoutParams) layoutParams).height = layoutParams2.height;
            }
            c.setLayoutParams(layoutParams);
            return c;
        }
        return (View) invokeLL.objValue;
    }

    public static Rect b(View view2, int i, int i2) {
        InterceptResult invokeLII;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLII = interceptable.invokeLII(65537, null, view2, i, i2)) == null) {
            int[] iArr = new int[2];
            view2.getLocationInWindow(iArr);
            Rect rect = new Rect();
            rect.set(iArr[0], iArr[1], iArr[0] + view2.getMeasuredWidth(), iArr[1] + view2.getMeasuredHeight());
            rect.offset(-i, -i2);
            return rect;
        }
        return (Rect) invokeLII.objValue;
    }
}
