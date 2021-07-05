package d.a.y0.t;

import android.util.DisplayMetrics;
import android.view.WindowManager;
import com.baidu.mobads.container.util.AdIconUtil;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes9.dex */
public class v {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: a  reason: collision with root package name */
    public static boolean f71461a;

    /* renamed from: b  reason: collision with root package name */
    public static float f71462b;

    /* renamed from: c  reason: collision with root package name */
    public static int f71463c;

    /* renamed from: d  reason: collision with root package name */
    public static int f71464d;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(-514169133, "Ld/a/y0/t/v;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(-514169133, "Ld/a/y0/t/v;");
        }
    }

    public static int a(float f2) {
        InterceptResult invokeF;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeF = interceptable.invokeF(65537, null, f2)) == null) {
            if (!f71461a) {
                f();
            }
            return (int) ((f2 * f71462b) + 0.5f);
        }
        return invokeF.intValue;
    }

    public static int b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) {
            if (!f71461a) {
                f();
            }
            return f71464d;
        }
        return invokeV.intValue;
    }

    public static int c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) {
            if (!f71461a) {
                f();
            }
            return f71463c;
        }
        return invokeV.intValue;
    }

    public static int d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65540, null)) == null) ? b() : invokeV.intValue;
    }

    public static int e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(AdIconUtil.AD_TEXT_ID, null)) == null) ? c() : invokeV.intValue;
    }

    public static void f() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(AdIconUtil.BAIDU_LOGO_ID, null) == null) {
            DisplayMetrics displayMetrics = new DisplayMetrics();
            WindowManager windowManager = (WindowManager) d.a.y0.b.d().b().getSystemService("window");
            windowManager.getDefaultDisplay().getMetrics(displayMetrics);
            int orientation = windowManager.getDefaultDisplay().getOrientation();
            if (orientation != 1 && orientation != 3) {
                f71463c = displayMetrics.widthPixels;
                f71464d = displayMetrics.heightPixels;
            } else {
                f71463c = displayMetrics.heightPixels;
                f71464d = displayMetrics.widthPixels;
            }
            f71462b = displayMetrics.density;
            f71461a = true;
        }
    }
}
