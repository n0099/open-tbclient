package d.a.d.a;

import android.app.Activity;
import android.content.pm.ActivityInfo;
import android.content.res.TypedArray;
import android.os.Build;
import androidx.annotation.NonNull;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
/* loaded from: classes7.dex */
public class a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static boolean a(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(65536, null, i2)) == null) {
            if (i2 != 0 && i2 != 1 && i2 != 11 && i2 != 12) {
                switch (i2) {
                    case 6:
                    case 7:
                    case 8:
                    case 9:
                        break;
                    default:
                        return false;
                }
            }
            return true;
        }
        return invokeI.booleanValue;
    }

    public static void b(@NonNull Activity activity) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(65537, null, activity) == null) && d(activity)) {
            try {
                Field declaredField = Activity.class.getDeclaredField("mActivityInfo");
                declaredField.setAccessible(true);
                ActivityInfo activityInfo = (ActivityInfo) declaredField.get(activity);
                if (a(activityInfo.screenOrientation)) {
                    activityInfo.screenOrientation = -1;
                }
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
    }

    public static boolean c(Activity activity) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, activity)) == null) {
            try {
                Field declaredField = Class.forName("com.android.internal.R$styleable").getDeclaredField("Window");
                declaredField.setAccessible(true);
                TypedArray obtainStyledAttributes = activity.obtainStyledAttributes((int[]) declaredField.get(null));
                Method declaredMethod = ActivityInfo.class.getDeclaredMethod("isTranslucentOrFloating", TypedArray.class);
                declaredMethod.setAccessible(true);
                return ((Boolean) declaredMethod.invoke(null, obtainStyledAttributes)).booleanValue();
            } catch (Exception e2) {
                e2.printStackTrace();
                return false;
            }
        }
        return invokeL.booleanValue;
    }

    public static boolean d(Activity activity) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65539, null, activity)) == null) ? Build.VERSION.SDK_INT == 26 && c(activity) : invokeL.booleanValue;
    }
}
