package d.a.o0.v;

import android.app.Activity;
import android.view.View;
import android.view.ViewGroup;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes7.dex */
public class g {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static boolean a(Activity activity, View view) {
        InterceptResult invokeLL;
        ViewGroup viewGroup;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65536, null, activity, view)) == null) {
            if (activity == null || view == null || (viewGroup = (ViewGroup) activity.getWindow().getDecorView()) == null) {
                return false;
            }
            b(view);
            viewGroup.removeView(view);
            viewGroup.addView(view);
            return true;
        }
        return invokeLL.booleanValue;
    }

    public static boolean b(View view) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, view)) == null) {
            if (view == null || view.getParent() == null || !(view.getParent() instanceof ViewGroup)) {
                return false;
            }
            ViewGroup viewGroup = (ViewGroup) view.getParent();
            if (viewGroup.indexOfChild(view) != -1) {
                try {
                    viewGroup.removeView(view);
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
