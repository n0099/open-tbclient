package i.a.a.e.i.a;

import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.os.Build;
import android.util.DisplayMetrics;
import android.util.TypedValue;
import android.view.Display;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes3.dex */
public class a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public final int f72196a;

    /* renamed from: b  reason: collision with root package name */
    public final int f72197b;

    /* renamed from: c  reason: collision with root package name */
    public final boolean f72198c;

    /* renamed from: d  reason: collision with root package name */
    public final int f72199d;

    /* renamed from: e  reason: collision with root package name */
    public final int f72200e;

    /* renamed from: f  reason: collision with root package name */
    public final boolean f72201f;

    /* renamed from: g  reason: collision with root package name */
    public final float f72202g;

    public a(Activity activity) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {activity};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        Resources resources = activity.getResources();
        this.f72201f = resources.getConfiguration().orientation == 1;
        this.f72202g = h(activity);
        this.f72196a = c(resources, "status_bar_height");
        this.f72197b = b(activity);
        this.f72199d = e(activity);
        this.f72200e = g(activity);
        this.f72198c = this.f72199d > 0;
    }

    @TargetApi(14)
    public static boolean j(Activity activity) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, activity)) == null) {
            Display defaultDisplay = activity.getWindowManager().getDefaultDisplay();
            DisplayMetrics displayMetrics = new DisplayMetrics();
            if (Build.VERSION.SDK_INT >= 17) {
                defaultDisplay.getRealMetrics(displayMetrics);
            }
            int i2 = displayMetrics.heightPixels;
            int i3 = displayMetrics.widthPixels;
            DisplayMetrics displayMetrics2 = new DisplayMetrics();
            defaultDisplay.getMetrics(displayMetrics2);
            return i3 - displayMetrics2.widthPixels > 0 || i2 - displayMetrics2.heightPixels > 0;
        }
        return invokeL.booleanValue;
    }

    public int a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.f72197b : invokeV.intValue;
    }

    @TargetApi(14)
    public final int b(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, context)) == null) {
            if (Build.VERSION.SDK_INT >= 14) {
                TypedValue typedValue = new TypedValue();
                context.getTheme().resolveAttribute(16843499, typedValue, true);
                return TypedValue.complexToDimensionPixelSize(typedValue.data, context.getResources().getDisplayMetrics());
            }
            return 0;
        }
        return invokeL.intValue;
    }

    public final int c(Resources resources, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, resources, str)) == null) {
            try {
                Class<?> cls = Class.forName("com.android.internal.R$dimen");
                int parseInt = Integer.parseInt(cls.getField(str).get(cls.newInstance()).toString());
                if (parseInt > 0) {
                    return resources.getDimensionPixelSize(parseInt);
                }
                return 0;
            } catch (Exception e2) {
                e2.printStackTrace();
                return 0;
            }
        }
        return invokeLL.intValue;
    }

    public int d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.f72199d : invokeV.intValue;
    }

    @TargetApi(14)
    public final int e(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, context)) == null) {
            Resources resources = context.getResources();
            if (Build.VERSION.SDK_INT < 14 || !j((Activity) context)) {
                return 0;
            }
            return c(resources, this.f72201f ? "navigation_bar_height" : "navigation_bar_height_landscape");
        }
        return invokeL.intValue;
    }

    public int f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.f72200e : invokeV.intValue;
    }

    @TargetApi(14)
    public final int g(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048582, this, context)) == null) {
            Resources resources = context.getResources();
            if (Build.VERSION.SDK_INT < 14 || !j((Activity) context)) {
                return 0;
            }
            return c(resources, "navigation_bar_width");
        }
        return invokeL.intValue;
    }

    @SuppressLint({"NewApi"})
    public final float h(Activity activity) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048583, this, activity)) == null) {
            DisplayMetrics displayMetrics = new DisplayMetrics();
            if (Build.VERSION.SDK_INT >= 16) {
                activity.getWindowManager().getDefaultDisplay().getRealMetrics(displayMetrics);
            } else {
                activity.getWindowManager().getDefaultDisplay().getMetrics(displayMetrics);
            }
            float f2 = displayMetrics.density;
            return Math.min(displayMetrics.widthPixels / f2, displayMetrics.heightPixels / f2);
        }
        return invokeL.floatValue;
    }

    public int i() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) ? this.f72196a : invokeV.intValue;
    }

    public boolean k() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) ? this.f72198c : invokeV.booleanValue;
    }

    public boolean l() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) ? this.f72202g >= 600.0f || this.f72201f : invokeV.booleanValue;
    }
}
