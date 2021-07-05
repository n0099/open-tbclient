package d.a.s0.u3;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import com.baidu.mobads.container.util.AdIconUtil;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes9.dex */
public class g {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static Bundle a(View view) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65536, null, view)) == null) {
            Bundle bundle = new Bundle();
            int[] iArr = new int[2];
            view.getLocationOnScreen(iArr);
            bundle.putInt("enter_anim_values_top", iArr[1]);
            bundle.putInt("enter_anim_values_width", view.getWidth());
            bundle.putInt("enter_anim_values_height", view.getHeight());
            return bundle;
        }
        return (Bundle) invokeL.objValue;
    }

    public static float b(int i2, int i3) {
        InterceptResult invokeII;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeII = interceptable.invokeII(65537, null, i2, i3)) == null) {
            if (i3 == 0) {
                return 1.0f;
            }
            return (i2 * 1.0f) / i3;
        }
        return invokeII.floatValue;
    }

    public static float c(Bundle bundle, Bundle bundle2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLL = interceptable.invokeLL(65538, null, bundle, bundle2)) == null) ? f(bundle) - f(bundle2) : invokeLL.floatValue;
    }

    public static void d(Intent intent, View view) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65539, null, intent, view) == null) {
            Bundle e2 = e(intent);
            Bundle a2 = a(view);
            float b2 = b(h(e2), h(a2));
            float b3 = b(f(e2), f(a2));
            int statusBarHeight = UtilHelper.getStatusBarHeight();
            float g2 = g(e2);
            if ((f(a2) * 1.0f) / h(a2) > 1.5d) {
                view.setScaleX(b2);
                view.setScaleY(b3);
                g2 = (g(e2) - g(a2)) - statusBarHeight;
            }
            view.setTranslationY(g2);
            view.animate().setDuration(300L).scaleX(1.0f).scaleY(1.0f).translationY(g(a2)).start();
        }
    }

    public static Bundle e(Intent intent) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65540, null, intent)) == null) {
            if (intent == null) {
                return null;
            }
            return intent.getBundleExtra("enter_anim_values");
        }
        return (Bundle) invokeL.objValue;
    }

    public static int f(Bundle bundle) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(AdIconUtil.AD_TEXT_ID, null, bundle)) == null) {
            if (bundle == null) {
                return 0;
            }
            return bundle.getInt("enter_anim_values_height");
        }
        return invokeL.intValue;
    }

    public static int g(Bundle bundle) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(AdIconUtil.BAIDU_LOGO_ID, null, bundle)) == null) {
            if (bundle == null) {
                return 0;
            }
            return bundle.getInt("enter_anim_values_top");
        }
        return invokeL.intValue;
    }

    public static int h(Bundle bundle) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65543, null, bundle)) == null) {
            if (bundle == null) {
                return 0;
            }
            return bundle.getInt("enter_anim_values_width");
        }
        return invokeL.intValue;
    }

    public static void i(Intent intent, View view) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65544, null, intent, view) == null) {
            view.setVisibility(4);
            Bundle e2 = e(intent);
            Bundle a2 = a(view);
            float b2 = b(h(e2), h(a2));
            float b3 = b(f(e2), f(a2));
            int statusBarHeight = UtilHelper.getStatusBarHeight();
            float g2 = g(e2);
            if ((f(a2) * 1.0f) / h(a2) > 1.5d) {
                view.setScaleX(b2);
                view.setScaleY(b3);
                g2 = c(e2, a2) - statusBarHeight;
            }
            view.setTranslationY(g2);
            view.setVisibility(0);
            view.animate().setDuration(350L).scaleX(1.0f).scaleY(1.0f).translationY(g(a2)).start();
        }
    }
}
