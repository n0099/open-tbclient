package com.kwad.sdk.utils;

import android.app.Activity;
import android.content.Context;
import android.content.ContextWrapper;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.drawable.BitmapDrawable;
import android.os.PowerManager;
import android.os.SystemClock;
import android.text.SpannableString;
import android.text.TextPaint;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.baidu.mobads.container.util.AdIconUtil;
import com.baidu.tbadk.core.util.StringHelper;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.kwad.sdk.api.core.ResContext;
import com.kwad.sdk.core.response.model.PhotoInfo;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.HashSet;
/* loaded from: classes7.dex */
public class ao {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: a  reason: collision with root package name */
    public static int f39373a;

    /* renamed from: b  reason: collision with root package name */
    public static long f39374b;
    public transient /* synthetic */ FieldHolder $fh;

    public static int a(@Nullable Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65536, null, context)) == null) {
            int i2 = f39373a;
            if (i2 <= 0 && context != null) {
                int identifier = context.getResources().getIdentifier("status_bar_height", "dimen", "android");
                if (identifier > 0) {
                    f39373a = context.getResources().getDimensionPixelSize(identifier);
                } else {
                    try {
                        Class<?> cls = Class.forName("com.android.internal.R$dimen");
                        Object newInstance = cls.newInstance();
                        Field field = cls.getField("status_bar_height");
                        field.setAccessible(true);
                        f39373a = context.getResources().getDimensionPixelSize(Integer.parseInt(field.get(newInstance).toString()));
                    } catch (Throwable th) {
                        th.printStackTrace();
                    }
                }
                if (f39373a <= 0) {
                    f39373a = a(context, 25.0f);
                }
                return f39373a;
            }
            return i2;
        }
        return invokeL.intValue;
    }

    public static int a(Context context, float f2) {
        InterceptResult invokeLF;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLF = interceptable.invokeLF(65537, null, context, f2)) == null) {
            return (int) (context == null ? f2 * 2.0f : (f2 * context.getResources().getDisplayMetrics().density) + 0.5f);
        }
        return invokeLF.intValue;
    }

    public static int a(Context context, int i2) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(65538, null, context, i2)) == null) {
            if (context == null || i2 == 0) {
                return 0;
            }
            return context.getResources().getDimensionPixelSize(i2);
        }
        return invokeLI.intValue;
    }

    @NonNull
    public static Context a(@NonNull View view) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65539, null, view)) == null) {
            Activity b2 = b(view);
            if (b2 == null && (view.getParent() instanceof View)) {
                b2 = b((View) view.getParent());
            }
            return b2 == null ? view.getContext() : b2;
        }
        return (Context) invokeL.objValue;
    }

    public static Bitmap a(TextView textView) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65540, null, textView)) == null) {
            TextPaint paint = textView.getPaint();
            int ceil = ((int) Math.ceil(paint.measureText(textView.getText().toString()))) + textView.getPaddingLeft() + textView.getPaddingRight();
            Paint.FontMetrics fontMetrics = paint.getFontMetrics();
            int ceil2 = (int) Math.ceil((fontMetrics.bottom - fontMetrics.top) + textView.getPaddingTop() + textView.getPaddingBottom());
            Bitmap createBitmap = Bitmap.createBitmap(ceil, ceil2, Bitmap.Config.ARGB_8888);
            Canvas canvas = new Canvas(createBitmap);
            canvas.drawColor(0);
            textView.layout(0, 0, ceil, ceil2);
            textView.draw(canvas);
            return createBitmap;
        }
        return (Bitmap) invokeL.objValue;
    }

    public static View a(ViewGroup viewGroup, int i2, boolean z) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeCommon = interceptable.invokeCommon(AdIconUtil.AD_TEXT_ID, null, new Object[]{viewGroup, Integer.valueOf(i2), Boolean.valueOf(z)})) == null) ? f(viewGroup.getContext()).inflate(i2, viewGroup, z) : (View) invokeCommon.objValue;
    }

    public static View a(@NonNull Window window) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(AdIconUtil.BAIDU_LOGO_ID, null, window)) == null) ? window.getDecorView().findViewById(16908290) : (View) invokeL.objValue;
    }

    public static void a(View view, int i2, int i3) {
        View view2;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLII(65543, null, view, i2, i3) == null) || view == null || i2 == 0 || i3 == 0 || (view2 = (View) view.getParent()) == null) {
            return;
        }
        int width = view2.getWidth();
        int height = view2.getHeight();
        if (width == 0 || height == 0) {
            return;
        }
        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        if (width > height) {
            if (i2 <= i3) {
                layoutParams.width = (int) ((i2 / (i3 * 1.0f)) * height);
                layoutParams.height = height;
            }
            layoutParams.width = -1;
            layoutParams.height = -1;
        } else {
            if (i3 <= i2) {
                layoutParams.width = width;
                layoutParams.height = (int) ((i3 / (i2 * 1.0f)) * width);
            }
            layoutParams.width = -1;
            layoutParams.height = -1;
        }
        view.setLayoutParams(layoutParams);
    }

    public static void a(TextView textView, String str, Bitmap bitmap) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(65544, null, textView, str, bitmap) == null) {
            String str2 = str + "   ";
            TextPaint paint = textView.getPaint();
            Paint.FontMetrics fontMetrics = paint.getFontMetrics();
            int ceil = ((int) Math.ceil(fontMetrics.descent - fontMetrics.top)) + 2;
            BitmapDrawable bitmapDrawable = new BitmapDrawable(textView.getContext().getResources(), bitmap);
            int intrinsicWidth = (bitmapDrawable.getIntrinsicWidth() * ceil) / bitmapDrawable.getIntrinsicHeight();
            bitmapDrawable.setBounds(0, a(textView.getContext(), 1.0f), intrinsicWidth, ceil);
            float width = textView.getWidth();
            if (paint.measureText(str2) > width) {
                int i2 = 0;
                int i3 = 1;
                int i4 = 1;
                boolean z = false;
                while (true) {
                    float measureText = paint.measureText(str2.substring(i2, i3));
                    if (measureText < width) {
                        if (i4 == textView.getMaxLines()) {
                            float f2 = measureText + intrinsicWidth;
                            if (paint.measureText("   ") + f2 < width && f2 + paint.measureText(StringHelper.STRING_MORE) + paint.measureText("   ") < width) {
                                if (z) {
                                    str2 = str2.substring(0, i3) + StringHelper.STRING_MORE + "   ";
                                    break;
                                }
                            } else {
                                i3--;
                                z = true;
                            }
                        }
                        i3++;
                    } else {
                        i2 = i3 - 1;
                        i4++;
                    }
                    if (i3 <= str2.length()) {
                        if (i4 > textView.getMaxLines()) {
                            break;
                        }
                    } else {
                        break;
                    }
                }
            }
            String str3 = str2 + "*";
            SpannableString spannableString = new SpannableString(str3);
            spannableString.setSpan(new com.kwad.sdk.core.view.f(textView.getContext(), bitmap), str3.length() - 1, str3.length(), 33);
            textView.setText(spannableString);
        }
    }

    public static boolean a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65545, null)) == null) {
            long uptimeMillis = SystemClock.uptimeMillis();
            int i2 = (Math.abs(uptimeMillis - f39374b) > 500L ? 1 : (Math.abs(uptimeMillis - f39374b) == 500L ? 0 : -1));
            f39374b = uptimeMillis;
            return i2 < 0;
        }
        return invokeV.booleanValue;
    }

    public static boolean a(Activity activity) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65546, null, activity)) == null) ? b(activity.getWindow()) : invokeL.booleanValue;
    }

    public static boolean a(@Nullable Matrix matrix, int i2, int i3, PhotoInfo.VideoInfo videoInfo) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65547, null, new Object[]{matrix, Integer.valueOf(i2), Integer.valueOf(i3), videoInfo})) == null) {
            if (matrix != null) {
                matrix.reset();
            }
            if (videoInfo == null) {
                return false;
            }
            float f2 = videoInfo.width;
            float f3 = videoInfo.height;
            if (f2 >= f3) {
                return false;
            }
            float f4 = (float) videoInfo.leftRatio;
            float f5 = (float) videoInfo.topRatio;
            float f6 = (float) videoInfo.widthRatio;
            float f7 = (float) videoInfo.heightRatio;
            float f8 = i2;
            float f9 = f8 / f2;
            float f10 = i3;
            float f11 = f10 / f3;
            float f12 = f9 / f11;
            if (Math.abs(f12 - 1.0f) < 0.01d) {
                return false;
            }
            if (f9 > f11) {
                float f13 = f11 / f9;
                float f14 = (f13 + 1.0f) / 2.0f;
                if (f5 < (1.0f - f13) / 2.0f || f5 + f7 > f14) {
                    return false;
                }
            } else {
                float f15 = (f12 + 1.0f) / 2.0f;
                if (f4 < (1.0f - f12) / 2.0f || f4 + f6 > f15) {
                    return false;
                }
                f9 = f11;
            }
            if (matrix == null) {
                return true;
            }
            matrix.preTranslate((f8 - f2) / 2.0f, (f10 - f3) / 2.0f);
            matrix.preScale(f2 / f8, f3 / f10);
            matrix.postScale(f9, f9, f8 / 2.0f, f10 / 2.0f);
            return true;
        }
        return invokeCommon.booleanValue;
    }

    public static boolean a(View view, int i2) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLI = interceptable.invokeLI(65548, null, view, i2)) == null) ? view != null && e(view.getContext()) && b(view, i2, true) : invokeLI.booleanValue;
    }

    public static boolean a(View view, int i2, boolean z) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeCommon = interceptable.invokeCommon(65549, null, new Object[]{view, Integer.valueOf(i2), Boolean.valueOf(z)})) == null) ? view != null && e(view.getContext()) && b(view, i2, z) : invokeCommon.booleanValue;
    }

    @Deprecated
    public static int b(@Nullable Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65550, null, context)) == null) {
            if (context == null) {
                return 0;
            }
            DisplayMetrics displayMetrics = new DisplayMetrics();
            ((WindowManager) context.getSystemService("window")).getDefaultDisplay().getMetrics(displayMetrics);
            return displayMetrics.heightPixels;
        }
        return invokeL.intValue;
    }

    @Nullable
    public static Activity b(View view) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65551, null, view)) == null) {
            Context context = view.getContext();
            HashSet hashSet = new HashSet();
            do {
                hashSet.add(context);
                if (!(context instanceof ContextWrapper)) {
                    break;
                } else if (context instanceof Activity) {
                    return (Activity) context;
                } else {
                    context = context instanceof ResContext ? ((ResContext) context).getDelegatedContext() : ((ContextWrapper) context).getBaseContext();
                }
            } while (!hashSet.contains(context));
            return null;
        }
        return (Activity) invokeL.objValue;
    }

    public static View b(@NonNull Activity activity) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65552, null, activity)) == null) ? a(activity.getWindow()) : (View) invokeL.objValue;
    }

    public static void b(View view, int i2, int i3) {
        View view2;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLII(65553, null, view, i2, i3) == null) || view == null || i2 == 0 || i3 == 0 || (view2 = (View) view.getParent()) == null) {
            return;
        }
        int width = view2.getWidth();
        int height = view2.getHeight();
        if (width == 0 || height == 0) {
            return;
        }
        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        if (width <= height || i2 > i3) {
            layoutParams.width = width;
            layoutParams.height = (int) ((i3 / (i2 * 1.0f)) * width);
        } else {
            layoutParams.width = (int) ((i2 / (i3 * 1.0f)) * height);
            layoutParams.height = height;
        }
        view.setLayoutParams(layoutParams);
    }

    public static boolean b(View view, int i2, boolean z) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65554, null, new Object[]{view, Integer.valueOf(i2), Boolean.valueOf(z)})) == null) {
            if (view == null || view.getParent() == null) {
                return false;
            }
            if (view.isShown() || view.getVisibility() == 0) {
                if (!z || view.hasWindowFocus()) {
                    Rect rect = new Rect();
                    if (view.getGlobalVisibleRect(rect)) {
                        long height = rect.height() * rect.width();
                        long height2 = view.getHeight() * view.getWidth();
                        return height2 > 0 && height * 100 >= ((long) i2) * height2;
                    }
                    return false;
                }
                return false;
            }
            return false;
        }
        return invokeCommon.booleanValue;
    }

    public static boolean b(Window window) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65555, null, window)) == null) ? (window.getAttributes().flags & 1024) == 1024 : invokeL.booleanValue;
    }

    public static int c(@NonNull Activity activity) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65556, null, activity)) == null) ? b(activity).getWidth() : invokeL.intValue;
    }

    @Deprecated
    public static int c(@Nullable Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65557, null, context)) == null) {
            if (context == null) {
                return 0;
            }
            DisplayMetrics displayMetrics = new DisplayMetrics();
            ((WindowManager) context.getSystemService("window")).getDefaultDisplay().getMetrics(displayMetrics);
            return displayMetrics.widthPixels;
        }
        return invokeL.intValue;
    }

    public static int d(@NonNull Activity activity) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65558, null, activity)) == null) ? b(activity).getHeight() : invokeL.intValue;
    }

    @Nullable
    public static Context d(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65559, null, context)) == null) {
            ResContext resContext = context instanceof ResContext ? (ResContext) context : null;
            HashSet hashSet = new HashSet();
            hashSet.add(context);
            Context context2 = context;
            while (context2 instanceof ContextWrapper) {
                if (context2 instanceof Activity) {
                    return context2;
                }
                if (context2 instanceof ResContext) {
                    ResContext resContext2 = (ResContext) context2;
                    context2 = resContext2.getDelegatedContext();
                    resContext = resContext2;
                } else {
                    context2 = ((ContextWrapper) context2).getBaseContext();
                }
                if (hashSet.contains(context2)) {
                    break;
                }
                hashSet.add(context2);
            }
            return resContext != null ? resContext.getDelegatedContext() : context;
        }
        return (Context) invokeL.objValue;
    }

    public static boolean e(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65560, null, context)) == null) {
            try {
                PowerManager powerManager = (PowerManager) context.getSystemService("power");
                Method method = powerManager != null ? powerManager.getClass().getMethod("isScreenOn", new Class[0]) : null;
                if (method != null) {
                    return ((Boolean) method.invoke(powerManager, new Object[0])).booleanValue();
                }
                return false;
            } catch (Exception e2) {
                com.kwad.sdk.core.d.a.a(e2);
                return false;
            }
        }
        return invokeL.booleanValue;
    }

    public static LayoutInflater f(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65561, null, context)) == null) ? LayoutInflater.from(context) : (LayoutInflater) invokeL.objValue;
    }
}
