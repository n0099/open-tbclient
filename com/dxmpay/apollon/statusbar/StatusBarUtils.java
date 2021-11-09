package com.dxmpay.apollon.statusbar;

import android.content.Context;
import android.graphics.Color;
import android.os.Build;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.view.Window;
import androidx.core.view.InputDeviceCompat;
import com.baidu.mobads.container.util.AdIconUtil;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.lang.reflect.Method;
/* loaded from: classes11.dex */
public class StatusBarUtils {
    public static /* synthetic */ Interceptable $ic = null;
    public static final int STATUS_BAR_DEFAULT_HEIGHT = 25;
    public static final String STATUS_BAR_HEIGHT_RES_NAME = "status_bar_height";
    public static int mStatusBarHeight = 0;
    public static float sBarAlpha = 0.3f;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes11.dex */
    public static class a implements ViewTreeObserver.OnGlobalLayoutListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ View f62182e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ ViewGroup.LayoutParams f62183f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ Context f62184g;

        public a(View view, ViewGroup.LayoutParams layoutParams, Context context) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {view, layoutParams, context};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f62182e = view;
            this.f62183f = layoutParams;
            this.f62184g = context;
        }

        @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
        public void onGlobalLayout() {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || Build.VERSION.SDK_INT < 19) {
                return;
            }
            this.f62182e.getViewTreeObserver().removeOnGlobalLayoutListener(this);
            this.f62183f.height = this.f62182e.getHeight() + StatusBarUtils.getStatusBarHeight(this.f62184g);
            View view = this.f62182e;
            view.setPadding(view.getPaddingLeft(), this.f62182e.getPaddingTop() + StatusBarUtils.getStatusBarHeight(this.f62184g), this.f62182e.getPaddingRight(), this.f62182e.getPaddingBottom());
            this.f62182e.setLayoutParams(this.f62183f);
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(477005991, "Lcom/dxmpay/apollon/statusbar/StatusBarUtils;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(477005991, "Lcom/dxmpay/apollon/statusbar/StatusBarUtils;");
        }
    }

    public StatusBarUtils() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
            }
        }
    }

    public static int blendARGB(int i2, int i3, float f2) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65538, null, new Object[]{Integer.valueOf(i2), Integer.valueOf(i3), Float.valueOf(f2)})) == null) {
            float f3 = 1.0f - f2;
            return Color.argb((int) ((Color.alpha(i2) * f3) + (Color.alpha(i3) * f2)), (int) ((Color.red(i2) * f3) + (Color.red(i3) * f2)), (int) ((Color.green(i2) * f3) + (Color.green(i3) * f2)), (int) ((Color.blue(i2) * f3) + (Color.blue(i3) * f2)));
        }
        return invokeCommon.intValue;
    }

    public static int dip2px(Context context, float f2) {
        InterceptResult invokeLF;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLF = interceptable.invokeLF(65539, null, context, f2)) == null) ? (int) ((f2 * context.getResources().getDisplayMetrics().density) + 0.5f) : invokeLF.intValue;
    }

    public static int getInternalDimensionSize(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, context)) == null) {
            int identifier = context.getResources().getIdentifier("status_bar_height", "dimen", "android");
            int dimensionPixelSize = identifier > 0 ? context.getResources().getDimensionPixelSize(identifier) : 0;
            return dimensionPixelSize > 0 ? dimensionPixelSize : dip2px(context, 25.0f);
        }
        return invokeL.intValue;
    }

    public static int getStatusBarHeight(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(AdIconUtil.AD_TEXT_ID, null, context)) == null) {
            if (mStatusBarHeight == 0) {
                mStatusBarHeight = getInternalDimensionSize(context);
            }
            return mStatusBarHeight;
        }
        return invokeL.intValue;
    }

    public static void setMIUIStatusBarDarkFont(Window window, boolean z) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLZ(AdIconUtil.BAIDU_LOGO_ID, null, window, z) == null) || window == null) {
            return;
        }
        Class<?> cls = window.getClass();
        try {
            Class<?> cls2 = Class.forName("android.view.MiuiWindowManager$LayoutParams");
            int i2 = cls2.getField("EXTRA_FLAG_STATUS_BAR_DARK_MODE").getInt(cls2);
            Method method = cls.getMethod("setExtraFlags", Integer.TYPE, Integer.TYPE);
            if (z) {
                method.invoke(window, Integer.valueOf(i2), Integer.valueOf(i2));
            } else {
                method.invoke(window, 0, Integer.valueOf(i2));
            }
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    public static void setTitleBar(Context context, View view) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(65543, null, context, view) == null) || view == null || Build.VERSION.SDK_INT < 19) {
            return;
        }
        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        int i2 = layoutParams.height;
        if (i2 != -2 && i2 != -1) {
            layoutParams.height = i2 + getStatusBarHeight(context);
            view.setPadding(view.getPaddingLeft(), view.getPaddingTop() + getStatusBarHeight(context), view.getPaddingRight(), view.getPaddingBottom());
            view.setLayoutParams(layoutParams);
            return;
        }
        view.getViewTreeObserver().addOnGlobalLayoutListener(new a(view, layoutParams, context));
    }
}
