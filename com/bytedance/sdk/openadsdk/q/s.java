package com.bytedance.sdk.openadsdk.q;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ObjectAnimator;
import android.app.Activity;
import android.app.ActivityOptions;
import android.app.KeyguardManager;
import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Picture;
import android.graphics.Point;
import android.graphics.Rect;
import android.os.Build;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.DisplayCutout;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.view.WindowInsets;
import android.view.WindowManager;
import android.webkit.WebView;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.annotation.Nullable;
import androidx.core.view.InputDeviceCompat;
import com.baidu.mobads.container.util.AdIconUtil;
import com.baidu.tbadk.core.util.RomTypeUtil;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.bytedance.sdk.component.utils.t;
import com.google.android.material.internal.ManufacturerUtils;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import org.json.JSONObject;
/* loaded from: classes9.dex */
public class s {
    public static /* synthetic */ Interceptable $ic = null;

    /* renamed from: a  reason: collision with root package name */
    public static float f69199a = -1.0f;

    /* renamed from: b  reason: collision with root package name */
    public static int f69200b = -1;

    /* renamed from: c  reason: collision with root package name */
    public static float f69201c = -1.0f;

    /* renamed from: d  reason: collision with root package name */
    public static int f69202d = -1;

    /* renamed from: e  reason: collision with root package name */
    public static int f69203e = -1;

    /* renamed from: f  reason: collision with root package name */
    public static WindowManager f69204f;

    /* renamed from: g  reason: collision with root package name */
    public static float f69205g;

    /* renamed from: h  reason: collision with root package name */
    public static boolean f69206h;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes9.dex */
    public interface a {
        void a(View view);
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(98109851, "Lcom/bytedance/sdk/openadsdk/q/s;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(98109851, "Lcom/bytedance/sdk/openadsdk/q/s;");
                return;
            }
        }
        a(com.bytedance.sdk.openadsdk.core.o.a());
    }

    public static boolean a(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(65560, null, i2)) == null) ? i2 == 0 || i2 == 8 || i2 == 4 : invokeI.booleanValue;
    }

    public static boolean c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65577, null)) == null) ? f69199a < 0.0f || f69200b < 0 || f69201c < 0.0f || f69202d < 0 || f69203e < 0 : invokeV.booleanValue;
    }

    public static int d(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65580, null, context)) == null) {
            a(context);
            return f69203e;
        }
        return invokeL.intValue;
    }

    public static float e(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65585, null, context)) == null) {
            a(context);
            return f69201c;
        }
        return invokeL.floatValue;
    }

    public static int f(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65588, null, context)) == null) {
            a(context);
            return f69200b;
        }
        return invokeL.intValue;
    }

    public static int g(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65591, null, context)) == null) {
            if (context == null) {
                context = com.bytedance.sdk.openadsdk.core.o.a();
            }
            Display defaultDisplay = ((WindowManager) context.getSystemService("window")).getDefaultDisplay();
            DisplayMetrics displayMetrics = new DisplayMetrics();
            if (Build.VERSION.SDK_INT >= 17) {
                defaultDisplay.getRealMetrics(displayMetrics);
            } else {
                defaultDisplay.getMetrics(displayMetrics);
            }
            return displayMetrics.heightPixels;
        }
        return invokeL.intValue;
    }

    public static int h(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65593, null, context)) == null) {
            if (context == null) {
                context = com.bytedance.sdk.openadsdk.core.o.a();
            }
            Display defaultDisplay = ((WindowManager) context.getSystemService("window")).getDefaultDisplay();
            DisplayMetrics displayMetrics = new DisplayMetrics();
            if (Build.VERSION.SDK_INT >= 17) {
                defaultDisplay.getRealMetrics(displayMetrics);
            } else {
                defaultDisplay.getMetrics(displayMetrics);
            }
            return displayMetrics.widthPixels;
        }
        return invokeL.intValue;
    }

    public static float i(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65594, null, context)) == null) {
            if (context == null) {
                context = com.bytedance.sdk.openadsdk.core.o.a();
            }
            int identifier = context.getApplicationContext().getResources().getIdentifier("status_bar_height", "dimen", "android");
            if (identifier > 0) {
                return context.getApplicationContext().getResources().getDimensionPixelSize(identifier);
            }
            return 0.0f;
        }
        return invokeL.floatValue;
    }

    /* JADX DEBUG: Throwable added to exception handler: 'ClassNotFoundException | NoSuchMethodException | Exception', keep only Throwable */
    public static boolean j(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65595, null, context)) == null) {
            try {
                Class<?> loadClass = context.getClassLoader().loadClass("com.huawei.android.util.HwNotchSizeUtil");
                return ((Boolean) loadClass.getMethod("hasNotchInScreen", new Class[0]).invoke(loadClass, new Object[0])).booleanValue();
            } catch (Throwable unused) {
                return false;
            }
        }
        return invokeL.booleanValue;
    }

    /* JADX DEBUG: Throwable added to exception handler: 'ClassNotFoundException | NoSuchMethodException | Exception', keep only Throwable */
    public static boolean k(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65596, null, context)) == null) {
            try {
                Class<?> loadClass = context.getClassLoader().loadClass("android.util.FtFeature");
                return ((Boolean) loadClass.getMethod("isFeatureSupport", Integer.TYPE).invoke(loadClass, 32)).booleanValue();
            } catch (Throwable unused) {
                return false;
            }
        }
        return invokeL.booleanValue;
    }

    public static boolean l(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65597, null, context)) == null) ? context.getPackageManager().hasSystemFeature(q.m("com.kllk.feature.screen.heteromorphism")) : invokeL.booleanValue;
    }

    public static boolean m(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65598, null, context)) == null) ? Build.MODEL.equals("IN2010") || Build.MODEL.equals("IN2020") || Build.MODEL.equals("KB2000") || Build.MODEL.startsWith(RomTypeUtil.ROM_ONEPLUS) : invokeL.booleanValue;
    }

    public static boolean n(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65599, null, context)) == null) ? Build.MANUFACTURER.equals(ManufacturerUtils.SAMSUNG) : invokeL.booleanValue;
    }

    public static float o(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65600, null, context)) == null) {
            try {
                if (f69206h) {
                    Class<?> loadClass = context.getClassLoader().loadClass("android.util.DisplayMetrics");
                    Method declaredMethod = loadClass.getDeclaredMethod("getDeviceDensity", new Class[0]);
                    declaredMethod.setAccessible(true);
                    return ((Integer) declaredMethod.invoke(loadClass, new Object[0])).intValue() / 160.0f;
                }
            } catch (Exception unused) {
            }
            if (context == null) {
                context = com.bytedance.sdk.openadsdk.core.o.a();
            }
            return context.getResources().getDisplayMetrics().density;
        }
        return invokeL.floatValue;
    }

    public static void a(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(AdIconUtil.BAIDU_LOGO_ID, null, context) == null) {
            Context a2 = context == null ? com.bytedance.sdk.openadsdk.core.o.a() : context;
            f69204f = (WindowManager) com.bytedance.sdk.openadsdk.core.o.a().getSystemService("window");
            if (a2 == null) {
                return;
            }
            if (c()) {
                DisplayMetrics displayMetrics = a2.getResources().getDisplayMetrics();
                f69199a = o(a2);
                f69200b = displayMetrics.densityDpi;
                f69201c = displayMetrics.scaledDensity;
                f69202d = displayMetrics.widthPixels;
                f69203e = displayMetrics.heightPixels;
            }
            if (context == null || context.getResources() == null || context.getResources().getConfiguration() == null) {
                return;
            }
            if (context.getResources().getConfiguration().orientation == 1) {
                int i2 = f69202d;
                int i3 = f69203e;
                if (i2 > i3) {
                    f69202d = i3;
                    f69203e = i2;
                    return;
                }
                return;
            }
            int i4 = f69202d;
            int i5 = f69203e;
            if (i4 < i5) {
                f69202d = i5;
                f69203e = i4;
            }
        }
    }

    public static float b(Context context, float f2) {
        InterceptResult invokeLF;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLF = interceptable.invokeLF(65564, null, context, f2)) == null) {
            a(context);
            return (f2 * o(context)) + 0.5f;
        }
        return invokeLF.floatValue;
    }

    public static int c(Context context, float f2) {
        InterceptResult invokeLF;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLF = interceptable.invokeLF(65574, null, context, f2)) == null) {
            a(context);
            float o = o(context);
            if (o <= 0.0f) {
                o = 1.0f;
            }
            return (int) ((f2 / o) + 0.5f);
        }
        return invokeLF.intValue;
    }

    public static boolean d(View view) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65584, null, view)) == null) ? view != null && view.getVisibility() == 0 : invokeL.booleanValue;
    }

    public static void e(View view) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(65587, null, view) == null) || view == null) {
            return;
        }
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(view, "alpha", 1.0f, 0.0f);
        ofFloat.addListener(new AnimatorListenerAdapter(view) { // from class: com.bytedance.sdk.openadsdk.q.s.1
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ View f69207a;

            {
                Interceptable interceptable2 = $ic;
                if (interceptable2 != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {view};
                    interceptable2.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable2.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.f69207a = view;
            }

            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeL(1048576, this, animator) == null) {
                    super.onAnimationEnd(animator);
                    s.a(this.f69207a, 8);
                    ObjectAnimator.ofFloat(this.f69207a, "alpha", 0.0f, 1.0f).setDuration(0L).start();
                }
            }
        });
        ofFloat.setDuration(800L);
        ofFloat.start();
    }

    public static void f(View view) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(65590, null, view) == null) || view == null) {
            return;
        }
        a(view, 0);
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(view, "alpha", 0.0f, 1.0f);
        ofFloat.addListener(new AnimatorListenerAdapter() { // from class: com.bytedance.sdk.openadsdk.q.s.2
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            {
                Interceptable interceptable2 = $ic;
                if (interceptable2 != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    interceptable2.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable2.invokeInitBody(65536, newInitContext);
                    }
                }
            }

            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeL(1048576, this, animator) == null) {
                    super.onAnimationEnd(animator);
                }
            }
        });
        ofFloat.setDuration(300L);
        ofFloat.start();
    }

    public static int[] b(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65571, null, context)) == null) {
            if (context == null) {
                return null;
            }
            if (f69204f == null) {
                f69204f = (WindowManager) com.bytedance.sdk.openadsdk.core.o.a().getSystemService("window");
            }
            int[] iArr = new int[2];
            WindowManager windowManager = f69204f;
            if (windowManager != null) {
                Display defaultDisplay = windowManager.getDefaultDisplay();
                DisplayMetrics displayMetrics = new DisplayMetrics();
                defaultDisplay.getMetrics(displayMetrics);
                int i2 = displayMetrics.widthPixels;
                int i3 = displayMetrics.heightPixels;
                int i4 = Build.VERSION.SDK_INT;
                if (i4 >= 14 && i4 < 17) {
                    try {
                        i2 = ((Integer) Display.class.getMethod("getRawWidth", new Class[0]).invoke(defaultDisplay, new Object[0])).intValue();
                        i3 = ((Integer) Display.class.getMethod("getRawHeight", new Class[0]).invoke(defaultDisplay, new Object[0])).intValue();
                    } catch (Exception unused) {
                    }
                }
                if (Build.VERSION.SDK_INT >= 17) {
                    try {
                        Point point = new Point();
                        Display.class.getMethod("getRealSize", Point.class).invoke(defaultDisplay, point);
                        i2 = point.x;
                        i3 = point.y;
                    } catch (Exception unused2) {
                    }
                }
                iArr[0] = i2;
                iArr[1] = i3;
            }
            if (iArr[0] <= 0 || iArr[1] <= 0) {
                DisplayMetrics displayMetrics2 = context.getResources().getDisplayMetrics();
                iArr[0] = displayMetrics2.widthPixels;
                iArr[1] = displayMetrics2.heightPixels;
            }
            return iArr;
        }
        return (int[]) invokeL.objValue;
    }

    public static int c(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65573, null, context)) == null) {
            a(context);
            return f69202d;
        }
        return invokeL.intValue;
    }

    public static int d(Context context, float f2) {
        InterceptResult invokeLF;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLF = interceptable.invokeLF(65581, null, context, f2)) == null) ? (int) ((f2 * o(context)) + 0.5f) : invokeLF.intValue;
    }

    public static Bitmap d(WebView webView) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65582, null, webView)) == null) {
            if (webView == null) {
                return null;
            }
            try {
                webView.measure(View.MeasureSpec.makeMeasureSpec(0, 0), View.MeasureSpec.makeMeasureSpec(0, 0));
                webView.layout(0, 0, webView.getMeasuredWidth(), webView.getMeasuredHeight());
                webView.setDrawingCacheEnabled(true);
                webView.buildDrawingCache();
                if (webView.getMeasuredWidth() > 0 && webView.getMeasuredHeight() > 0) {
                    Bitmap createBitmap = Bitmap.createBitmap(webView.getMeasuredWidth(), webView.getMeasuredHeight(), Bitmap.Config.RGB_565);
                    Canvas canvas = new Canvas(createBitmap);
                    canvas.drawBitmap(createBitmap, 0.0f, createBitmap.getHeight(), new Paint());
                    webView.draw(canvas);
                    return createBitmap;
                }
            } catch (Throwable unused) {
            }
            return null;
        }
        return (Bitmap) invokeL.objValue;
    }

    @Nullable
    public static int[] c(View view) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65579, null, view)) == null) {
            if (view != null) {
                return new int[]{view.getWidth(), view.getHeight()};
            }
            return null;
        }
        return (int[]) invokeL.objValue;
    }

    public static void e(Activity activity) {
        Class<?>[] declaredClasses;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65586, null, activity) == null) {
            try {
                Class<?> cls = null;
                for (Class<?> cls2 : Activity.class.getDeclaredClasses()) {
                    if (cls2.getSimpleName().contains("TranslucentConversionListener")) {
                        cls = cls2;
                    }
                }
                Method declaredMethod = Activity.class.getDeclaredMethod("convertToTranslucent", cls);
                declaredMethod.setAccessible(true);
                declaredMethod.invoke(activity, null);
            } catch (Throwable unused) {
            }
        }
    }

    public static Bitmap c(WebView webView) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65575, null, webView)) == null) {
            Bitmap bitmap = null;
            try {
                Picture capturePicture = webView.capturePicture();
                if (capturePicture != null && capturePicture.getWidth() > 0 && capturePicture.getHeight() > 0) {
                    bitmap = Bitmap.createBitmap(capturePicture.getWidth(), capturePicture.getHeight(), Bitmap.Config.ARGB_8888);
                    capturePicture.draw(new Canvas(bitmap));
                    return bitmap;
                }
                return null;
            } catch (Throwable unused) {
                return bitmap;
            }
        }
        return (Bitmap) invokeL.objValue;
    }

    public static void f(Activity activity) {
        Class<?>[] declaredClasses;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65589, null, activity) == null) {
            try {
                Method declaredMethod = Activity.class.getDeclaredMethod("getActivityOptions", new Class[0]);
                declaredMethod.setAccessible(true);
                Object invoke = declaredMethod.invoke(activity, new Object[0]);
                Class<?> cls = null;
                for (Class<?> cls2 : Activity.class.getDeclaredClasses()) {
                    if (cls2.getSimpleName().contains("TranslucentConversionListener")) {
                        cls = cls2;
                    }
                }
                Method declaredMethod2 = Activity.class.getDeclaredMethod("convertToTranslucent", cls, ActivityOptions.class);
                declaredMethod2.setAccessible(true);
                declaredMethod2.invoke(activity, null, invoke);
            } catch (Throwable unused) {
            }
        }
    }

    public static Bitmap g(View view) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65592, null, view)) == null) {
            if (view == null) {
                return null;
            }
            view.measure(View.MeasureSpec.makeMeasureSpec(0, 0), View.MeasureSpec.makeMeasureSpec(0, 0));
            int measuredWidth = view.getMeasuredWidth();
            int measuredHeight = view.getMeasuredHeight();
            view.layout(0, 0, view.getMeasuredWidth(), view.getMeasuredHeight());
            Bitmap createBitmap = Bitmap.createBitmap(measuredWidth, measuredHeight, Bitmap.Config.ARGB_8888);
            Canvas canvas = new Canvas(createBitmap);
            view.draw(canvas);
            canvas.save();
            return createBitmap;
        }
        return (Bitmap) invokeL.objValue;
    }

    public static boolean c(Activity activity) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65578, null, activity)) == null) {
            if (Build.VERSION.SDK_INT >= 28) {
                try {
                    WindowInsets rootWindowInsets = activity.getWindow().getDecorView().getRootWindowInsets();
                    return (rootWindowInsets != null ? rootWindowInsets.getDisplayCutout() : null) != null;
                } catch (Exception e2) {
                    e2.printStackTrace();
                    return false;
                }
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    public static void c(Context context, com.bytedance.sdk.openadsdk.core.e.m mVar, String str, String str2, Bitmap bitmap, boolean z, int i2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(65576, null, new Object[]{context, mVar, str, str2, bitmap, Boolean.valueOf(z), Integer.valueOf(i2)}) == null) || bitmap == null) {
            return;
        }
        try {
            if (bitmap.getWidth() > 0 && bitmap.getHeight() > 0 && !bitmap.isRecycled()) {
                int a2 = a(bitmap);
                if (a2 >= 50 || z) {
                    com.bytedance.sdk.openadsdk.e.d.a(context, mVar, str, str2, a2, i2);
                }
            }
        } catch (Throwable th) {
            com.bytedance.sdk.component.utils.k.f("UIUtils", "(开发者可忽略此检测异常)checkWebViewIsTransparent->throwable ex>>>" + th.toString());
        }
    }

    public static int a(Context context, float f2) {
        InterceptResult invokeLF;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLF = interceptable.invokeLF(65537, null, context, f2)) == null) {
            a(context);
            float e2 = e(context);
            if (e2 <= 0.0f) {
                e2 = 1.0f;
            }
            return (int) ((f2 / e2) + 0.5f);
        }
        return invokeLF.intValue;
    }

    public static void a(View view, int i2, int i3, int i4, int i5) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65546, null, new Object[]{view, Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), Integer.valueOf(i5)}) == null) {
            Rect rect = new Rect();
            view.getHitRect(rect);
            rect.top -= i2;
            rect.bottom += i3;
            rect.left -= i4;
            rect.right += i5;
            ((View) view.getParent()).setTouchDelegate(new com.bytedance.sdk.component.utils.g(rect, view));
        }
    }

    public static void d(Activity activity) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65583, null, activity) == null) {
            try {
                if (Build.VERSION.SDK_INT >= 21) {
                    f(activity);
                } else {
                    e(activity);
                }
            } catch (Throwable unused) {
            }
        }
    }

    public static int[] b(View view) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65572, null, view)) == null) {
            if (view != null) {
                int[] iArr = new int[2];
                view.getLocationOnScreen(iArr);
                return iArr;
            }
            return null;
        }
        return (int[]) invokeL.objValue;
    }

    public static void b(View view, int i2, int i3, int i4, int i5) {
        ViewGroup.LayoutParams layoutParams;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(65569, null, new Object[]{view, Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), Integer.valueOf(i5)}) == null) || view == null || (layoutParams = view.getLayoutParams()) == null || !(layoutParams instanceof ViewGroup.MarginLayoutParams)) {
            return;
        }
        a(view, (ViewGroup.MarginLayoutParams) layoutParams, i2, i3, i4, i5);
    }

    public static void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65567, null) == null) {
            com.bytedance.sdk.component.d.e.a(new com.bytedance.sdk.component.d.g("checkUiSetting") { // from class: com.bytedance.sdk.openadsdk.q.s.3
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(r7);
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {r7};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i2 = newInitContext.flag;
                        if ((i2 & 1) != 0) {
                            int i3 = i2 & 2;
                            super((String) newInitContext.callArgs[0]);
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                }

                @Override // java.lang.Runnable
                public void run() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                        try {
                            ApplicationInfo applicationInfo = com.bytedance.sdk.openadsdk.core.o.a().getPackageManager().getApplicationInfo(com.bytedance.sdk.openadsdk.core.o.a().getPackageName(), 128);
                            if (applicationInfo == null || applicationInfo.metaData == null || !applicationInfo.metaData.containsKey("design_width_in_dp")) {
                                return;
                            }
                            boolean unused = s.f69206h = true;
                        } catch (Exception unused2) {
                        }
                    }
                }
            });
        }
    }

    @Nullable
    public static int[] a(View view) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65563, null, view)) == null) {
            if (view == null || view.getVisibility() != 0) {
                return null;
            }
            int[] iArr = new int[2];
            view.getLocationOnScreen(iArr);
            return iArr;
        }
        return (int[]) invokeL.objValue;
    }

    public static boolean b(Activity activity) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65570, null, activity)) == null) ? c(activity) || a("ro.miui.notch", activity) == 1 || j(activity) || l(activity) || k(activity) || m(activity) || n(activity) : invokeL.booleanValue;
    }

    public static void a(View view, int i2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLI(65545, null, view, i2) == null) || view == null || view.getVisibility() == i2 || !a(i2)) {
            return;
        }
        view.setVisibility(i2);
    }

    public static void a(View view, float f2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLF(65544, null, view, f2) == null) || view == null) {
            return;
        }
        view.setAlpha(f2);
    }

    public static boolean a(WebView webView) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65561, null, webView)) == null) {
            if (webView == null || !webView.canGoBack()) {
                return false;
            }
            webView.goBack();
            return true;
        }
        return invokeL.booleanValue;
    }

    public static void a(TextView textView, CharSequence charSequence) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(65556, null, textView, charSequence) == null) || textView == null || TextUtils.isEmpty(charSequence)) {
            return;
        }
        textView.setText(charSequence);
    }

    public static Bitmap b(WebView webView) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65565, null, webView)) == null) {
            if (Build.VERSION.SDK_INT < 24) {
                return null;
            }
            int layerType = webView.getLayerType();
            webView.setLayerType(1, null);
            Bitmap d2 = d(webView);
            if (d2 == null) {
                d2 = c(webView);
            }
            webView.setLayerType(layerType, null);
            if (d2 == null) {
                return null;
            }
            return com.bytedance.sdk.component.utils.d.a(d2, d2.getWidth() / 6, d2.getHeight() / 6);
        }
        return (Bitmap) invokeL.objValue;
    }

    public static void a(View view, ViewGroup.MarginLayoutParams marginLayoutParams, int i2, int i3, int i4, int i5) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(65550, null, new Object[]{view, marginLayoutParams, Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), Integer.valueOf(i5)}) == null) || view == null || marginLayoutParams == null) {
            return;
        }
        if (marginLayoutParams.leftMargin == i2 && marginLayoutParams.topMargin == i3 && marginLayoutParams.rightMargin == i4 && marginLayoutParams.bottomMargin == i5) {
            return;
        }
        if (i2 != -3) {
            marginLayoutParams.leftMargin = i2;
        }
        if (i3 != -3) {
            marginLayoutParams.topMargin = i3;
        }
        if (i4 != -3) {
            marginLayoutParams.rightMargin = i4;
        }
        if (i5 != -3) {
            marginLayoutParams.bottomMargin = i5;
        }
        view.setLayoutParams(marginLayoutParams);
    }

    public static ArrayList<Integer> b(Bitmap bitmap) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65566, null, bitmap)) == null) {
            if (bitmap == null) {
                return null;
            }
            try {
                int width = bitmap.getWidth();
                int height = bitmap.getHeight();
                int i2 = width * height;
                int[] iArr = new int[i2];
                bitmap.getPixels(iArr, 0, width, 0, 0, width, height);
                ArrayList<Integer> arrayList = new ArrayList<>();
                for (int i3 = 0; i3 < i2; i3++) {
                    int i4 = iArr[i3];
                    arrayList.add(Integer.valueOf(Color.rgb((16711680 & i4) >> 16, (65280 & i4) >> 8, i4 & 255)));
                }
                return arrayList;
            } catch (Throwable unused) {
                return null;
            }
        }
        return (ArrayList) invokeL.objValue;
    }

    public static boolean a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65559, null)) == null) {
            try {
                return !((KeyguardManager) com.bytedance.sdk.openadsdk.core.o.a().getSystemService("keyguard")).inKeyguardRestrictedInputMode();
            } catch (Throwable unused) {
                return false;
            }
        }
        return invokeV.booleanValue;
    }

    public static JSONObject a(JSONObject jSONObject) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, jSONObject)) == null) {
            if (jSONObject == null) {
                jSONObject = new JSONObject();
            }
            try {
                int i2 = 1;
                if (!jSONObject.has("app_scene")) {
                    jSONObject.put("app_scene", com.bytedance.sdk.openadsdk.core.h.d().a() ? 1 : 0);
                }
                if (!jSONObject.has("lock_scene")) {
                    if (!(!a())) {
                        i2 = 0;
                    }
                    jSONObject.put("lock_scene", i2);
                }
            } catch (Throwable th) {
                com.bytedance.sdk.component.utils.k.c("addShowScene error " + th.toString());
            }
            return jSONObject;
        }
        return (JSONObject) invokeL.objValue;
    }

    public static void a(Activity activity) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(AdIconUtil.AD_TEXT_ID, null, activity) == null) || activity == null) {
            return;
        }
        try {
            if (Build.VERSION.SDK_INT > 11 && Build.VERSION.SDK_INT < 19) {
                activity.getWindow().getDecorView().setSystemUiVisibility(8);
            } else if (Build.VERSION.SDK_INT >= 19) {
                activity.getWindow().getDecorView().setSystemUiVisibility(3846);
                activity.getWindow().addFlags(134217728);
            }
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    public static void a(View view, View view2) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(65549, null, view, view2) == null) && view != null && view2 != null) {
            try {
                if (Build.VERSION.SDK_INT >= 28 && f69205g == 0.0f) {
                    WindowInsets rootWindowInsets = view.getRootWindowInsets();
                    DisplayCutout displayCutout = rootWindowInsets != null ? rootWindowInsets.getDisplayCutout() : null;
                    if (displayCutout != null) {
                        f69205g = displayCutout.getSafeInsetTop();
                    }
                }
                if (f69205g == 0.0f) {
                    return;
                }
                float max = Math.max(i(view2.getContext()), f69205g);
                ViewGroup.LayoutParams layoutParams = view2.getLayoutParams();
                if (layoutParams instanceof FrameLayout.LayoutParams) {
                    FrameLayout.LayoutParams layoutParams2 = (FrameLayout.LayoutParams) layoutParams;
                    layoutParams2.topMargin = (int) (layoutParams2.topMargin + max);
                }
                if (layoutParams instanceof RelativeLayout.LayoutParams) {
                    RelativeLayout.LayoutParams layoutParams3 = (RelativeLayout.LayoutParams) layoutParams;
                    layoutParams3.topMargin = (int) (layoutParams3.topMargin + max);
                }
                if (layoutParams instanceof LinearLayout.LayoutParams) {
                    LinearLayout.LayoutParams layoutParams4 = (LinearLayout.LayoutParams) layoutParams;
                    layoutParams4.topMargin = (int) (layoutParams4.topMargin + max);
                }
                view2.setLayoutParams(layoutParams);
            } catch (Throwable unused) {
            }
        }
    }

    public static int a(String str, Activity activity) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65539, null, str, activity)) == null) {
            if (l.e()) {
                try {
                    Class<?> loadClass = activity.getClassLoader().loadClass("android.os.SystemProperties");
                    return ((Integer) loadClass.getMethod("getInt", String.class, Integer.TYPE).invoke(loadClass, new String(str), new Integer(0))).intValue();
                } catch (ClassNotFoundException e2) {
                    e2.printStackTrace();
                    return 0;
                } catch (IllegalAccessException e3) {
                    e3.printStackTrace();
                    return 0;
                } catch (IllegalArgumentException e4) {
                    e4.printStackTrace();
                    return 0;
                } catch (NoSuchMethodException e5) {
                    e5.printStackTrace();
                    return 0;
                } catch (InvocationTargetException e6) {
                    e6.printStackTrace();
                    return 0;
                }
            }
            return 0;
        }
        return invokeLL.intValue;
    }

    public static void a(View view, View.OnClickListener onClickListener, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(65547, null, view, onClickListener, str) == null) {
            if (view == null) {
                com.bytedance.sdk.component.utils.k.f("OnclickListener ", str + " is null , can not set OnClickListener !!!");
                return;
            }
            view.setOnClickListener(onClickListener);
        }
    }

    public static void a(View view, View.OnTouchListener onTouchListener, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(65548, null, view, onTouchListener, str) == null) {
            if (view == null) {
                com.bytedance.sdk.component.utils.k.f("OnTouchListener ", str + " is null , can not set OnTouchListener !!!");
                return;
            }
            view.setOnTouchListener(onTouchListener);
        }
    }

    public static void a(Context context, com.bytedance.sdk.openadsdk.core.e.m mVar, String str, String str2, Bitmap bitmap, boolean z, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65543, null, new Object[]{context, mVar, str, str2, bitmap, Boolean.valueOf(z), Integer.valueOf(i2)}) == null) {
            com.bytedance.sdk.component.d.e.a(new com.bytedance.sdk.component.d.g("startCheckPlayableStatusPercentage", context, mVar, str, str2, bitmap, z, i2) { // from class: com.bytedance.sdk.openadsdk.q.s.4
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                /* renamed from: a  reason: collision with root package name */
                public final /* synthetic */ Context f69208a;

                /* renamed from: b  reason: collision with root package name */
                public final /* synthetic */ com.bytedance.sdk.openadsdk.core.e.m f69209b;

                /* renamed from: c  reason: collision with root package name */
                public final /* synthetic */ String f69210c;

                /* renamed from: d  reason: collision with root package name */
                public final /* synthetic */ String f69211d;

                /* renamed from: e  reason: collision with root package name */
                public final /* synthetic */ Bitmap f69212e;

                /* renamed from: f  reason: collision with root package name */
                public final /* synthetic */ boolean f69213f;

                /* renamed from: g  reason: collision with root package name */
                public final /* synthetic */ int f69214g;

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(r7);
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {r7, context, mVar, str, str2, bitmap, Boolean.valueOf(z), Integer.valueOf(i2)};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i3 = newInitContext.flag;
                        if ((i3 & 1) != 0) {
                            int i4 = i3 & 2;
                            super((String) newInitContext.callArgs[0]);
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.f69208a = context;
                    this.f69209b = mVar;
                    this.f69210c = str;
                    this.f69211d = str2;
                    this.f69212e = bitmap;
                    this.f69213f = z;
                    this.f69214g = i2;
                }

                @Override // java.lang.Runnable
                public void run() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                        s.c(this.f69208a, this.f69209b, this.f69210c, this.f69211d, this.f69212e, this.f69213f, this.f69214g);
                    }
                }
            }, 5);
        }
    }

    public static int a(Bitmap bitmap) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, bitmap)) == null) {
            try {
                ArrayList<Integer> b2 = b(bitmap);
                if (b2 == null) {
                    return -1;
                }
                HashMap hashMap = new HashMap();
                Iterator<Integer> it = b2.iterator();
                while (it.hasNext()) {
                    Integer next = it.next();
                    if (hashMap.containsKey(next)) {
                        Integer valueOf = Integer.valueOf(((Integer) hashMap.get(next)).intValue() + 1);
                        hashMap.remove(next);
                        hashMap.put(next, valueOf);
                    } else {
                        hashMap.put(next, 1);
                    }
                }
                int i2 = 0;
                int i3 = 0;
                for (Map.Entry entry : hashMap.entrySet()) {
                    int intValue = ((Integer) entry.getValue()).intValue();
                    if (i3 < intValue) {
                        i2 = ((Integer) entry.getKey()).intValue();
                        i3 = intValue;
                    }
                }
                if (i2 == 0) {
                    return -1;
                }
                return (int) ((i3 / ((bitmap.getWidth() * bitmap.getHeight()) * 1.0f)) * 100.0f);
            } catch (Throwable unused) {
                return -1;
            }
        }
        return invokeL.intValue;
    }

    public static void a(View view, a aVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(65551, null, view, aVar) == null) || view == null) {
            return;
        }
        view.getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener(view, aVar) { // from class: com.bytedance.sdk.openadsdk.q.s.5
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ View f69215a;

            /* renamed from: b  reason: collision with root package name */
            public final /* synthetic */ a f69216b;

            {
                Interceptable interceptable2 = $ic;
                if (interceptable2 != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {view, aVar};
                    interceptable2.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable2.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.f69215a = view;
                this.f69216b = aVar;
            }

            @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
            public void onGlobalLayout() {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                    this.f69215a.getViewTreeObserver().removeGlobalOnLayoutListener(this);
                    a aVar2 = this.f69216b;
                    if (aVar2 != null) {
                        aVar2.a(this.f69215a);
                    }
                }
            }
        });
    }

    public static void a(TextView textView, String str, Context context) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLLL(65558, null, textView, str, context) == null) || textView == null || TextUtils.isEmpty(str) || context == null) {
            return;
        }
        textView.setText(str);
        textView.setTextSize(2, 8.0f);
        textView.setBackgroundDrawable(t.c(context, "tt_adx_logo_bg"));
        textView.setTextColor(t.i(context, "tt_adx_logo_desc"));
        textView.setGravity(17);
        textView.setPadding(d(context, 2.0f), d(context, 3.0f), d(context, 2.0f), d(context, 3.0f));
    }

    public static void a(TextView textView, com.bytedance.sdk.openadsdk.core.e.m mVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65554, null, textView, mVar) == null) {
            if (textView != null && mVar != null) {
                String aO = mVar.aO();
                if (TextUtils.isEmpty(aO)) {
                    a(textView);
                    return;
                } else {
                    a(textView, aO, com.bytedance.sdk.openadsdk.core.o.a());
                    return;
                }
            }
            a(textView);
        }
    }

    public static void a(TextView textView, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65557, null, textView, str) == null) {
            if (textView != null && !TextUtils.isEmpty(str)) {
                a(textView, str, com.bytedance.sdk.openadsdk.core.o.a());
            } else {
                a(textView);
            }
        }
    }

    public static void a(TextView textView, com.bytedance.sdk.openadsdk.core.e.m mVar, int i2, int i3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLII(65555, null, textView, mVar, i2, i3) == null) {
            if (textView != null && mVar != null) {
                String aO = mVar.aO();
                if (TextUtils.isEmpty(aO)) {
                    a(textView, i2, i3);
                    return;
                } else {
                    a(textView, aO, com.bytedance.sdk.openadsdk.core.o.a());
                    return;
                }
            }
            a(textView, i2, i3);
        }
    }

    public static void a(TextView textView) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(65552, null, textView) == null) || textView == null) {
            return;
        }
        ViewGroup.LayoutParams layoutParams = textView.getLayoutParams();
        layoutParams.width = d(com.bytedance.sdk.openadsdk.core.o.a(), 32.0f);
        layoutParams.height = d(com.bytedance.sdk.openadsdk.core.o.a(), 14.0f);
        textView.setLayoutParams(layoutParams);
    }

    public static void a(TextView textView, int i2, int i3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLII(65553, null, textView, i2, i3) == null) {
            if (i2 <= 0) {
                i2 = 32;
            }
            if (i3 <= 0) {
                i3 = 14;
            }
            ViewGroup.LayoutParams layoutParams = textView.getLayoutParams();
            layoutParams.width = d(com.bytedance.sdk.openadsdk.core.o.a(), i2);
            layoutParams.height = d(com.bytedance.sdk.openadsdk.core.o.a(), i3);
            textView.setLayoutParams(layoutParams);
        }
    }
}
