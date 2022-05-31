package com.repackage;

import android.app.Activity;
import android.view.View;
import android.view.ViewGroup;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes5.dex */
public class fg4 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static boolean a(Activity activity, View view2) {
        InterceptResult invokeLL;
        ViewGroup viewGroup;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65536, null, activity, view2)) == null) {
            if (activity == null || view2 == null || (viewGroup = (ViewGroup) activity.getWindow().getDecorView()) == null) {
                return false;
            }
            b(view2);
            viewGroup.removeView(view2);
            viewGroup.addView(view2);
            return true;
        }
        return invokeLL.booleanValue;
    }

    public static boolean b(View view2) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, view2)) == null) {
            if (view2 == null || view2.getParent() == null || !(view2.getParent() instanceof ViewGroup)) {
                return false;
            }
            ViewGroup viewGroup = (ViewGroup) view2.getParent();
            if (viewGroup.indexOfChild(view2) != -1) {
                try {
                    viewGroup.removeView(view2);
                    return true;
                } catch (Exception unused) {
                    return true;
                }
            }
            return false;
        }
        return invokeL.booleanValue;
    }
}
