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
import com.baidu.ar.constants.HttpConstants;
import com.baidu.live.tbadk.core.util.StringHelper;
import com.kwad.sdk.api.core.ResContext;
import com.kwad.sdk.core.response.model.PhotoInfo;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.HashSet;
/* loaded from: classes5.dex */
public class ao {

    /* renamed from: a  reason: collision with root package name */
    private static int f11106a;

    /* renamed from: b  reason: collision with root package name */
    private static long f11107b;

    public static int a(@Nullable Context context) {
        if (f11106a <= 0 && context != null) {
            int identifier = context.getResources().getIdentifier("status_bar_height", "dimen", HttpConstants.OS_TYPE_VALUE);
            if (identifier > 0) {
                f11106a = context.getResources().getDimensionPixelSize(identifier);
            } else {
                try {
                    Class<?> cls = Class.forName("com.android.internal.R$dimen");
                    Object newInstance = cls.newInstance();
                    Field field = cls.getField("status_bar_height");
                    field.setAccessible(true);
                    f11106a = context.getResources().getDimensionPixelSize(Integer.parseInt(field.get(newInstance).toString()));
                } catch (Throwable th) {
                    th.printStackTrace();
                }
            }
            if (f11106a <= 0) {
                f11106a = a(context, 25.0f);
            }
            return f11106a;
        }
        return f11106a;
    }

    public static int a(Context context, float f) {
        return context == null ? (int) (2.0f * f) : (int) ((context.getResources().getDisplayMetrics().density * f) + 0.5f);
    }

    public static int a(Context context, int i) {
        if (context == null || i == 0) {
            return 0;
        }
        return context.getResources().getDimensionPixelSize(i);
    }

    @NonNull
    public static Context a(@NonNull View view) {
        Activity b2 = b(view);
        if (b2 == null && (view.getParent() instanceof View)) {
            b2 = b((View) view.getParent());
        }
        return b2 == null ? view.getContext() : b2;
    }

    public static Bitmap a(TextView textView) {
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

    public static View a(ViewGroup viewGroup, int i, boolean z) {
        return f(viewGroup.getContext()).inflate(i, viewGroup, z);
    }

    public static View a(@NonNull Window window) {
        return window.getDecorView().findViewById(16908290);
    }

    public static void a(View view, int i, int i2) {
        View view2;
        if (view == null || i == 0 || i2 == 0 || (view2 = (View) view.getParent()) == null) {
            return;
        }
        int width = view2.getWidth();
        int height = view2.getHeight();
        if (width == 0 || height == 0) {
            return;
        }
        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        if (width > height) {
            if (i > i2) {
                layoutParams.width = -1;
                layoutParams.height = -1;
            } else {
                layoutParams.width = (int) ((i / (i2 * 1.0f)) * height);
                layoutParams.height = height;
            }
        } else if (i2 > i) {
            layoutParams.width = -1;
            layoutParams.height = -1;
        } else {
            layoutParams.width = width;
            layoutParams.height = (int) ((i2 / (i * 1.0f)) * width);
        }
        view.setLayoutParams(layoutParams);
    }

    public static void a(TextView textView, String str, Bitmap bitmap) {
        String str2;
        String str3 = str + "   ";
        TextPaint paint = textView.getPaint();
        Paint.FontMetrics fontMetrics = paint.getFontMetrics();
        int ceil = ((int) Math.ceil(fontMetrics.descent - fontMetrics.top)) + 2;
        BitmapDrawable bitmapDrawable = new BitmapDrawable(textView.getContext().getResources(), bitmap);
        int intrinsicWidth = (bitmapDrawable.getIntrinsicWidth() * ceil) / bitmapDrawable.getIntrinsicHeight();
        bitmapDrawable.setBounds(0, a(textView.getContext(), 1.0f), intrinsicWidth, ceil);
        int width = textView.getWidth();
        if (paint.measureText(str3) > width) {
            int i = 0;
            int i2 = 1;
            int i3 = 1;
            boolean z = false;
            do {
                float measureText = paint.measureText(str3.substring(i, i2));
                if (measureText >= width) {
                    i = i2 - 1;
                    i3++;
                } else if (i3 != textView.getMaxLines()) {
                    i2++;
                } else if (intrinsicWidth + measureText + paint.measureText("   ") >= width) {
                    i2--;
                    z = true;
                } else if (measureText + intrinsicWidth + paint.measureText(StringHelper.STRING_MORE) + paint.measureText("   ") >= width) {
                    i2--;
                    z = true;
                } else if (z) {
                    str2 = str3.substring(0, i2) + StringHelper.STRING_MORE + "   ";
                    break;
                } else {
                    i2++;
                }
                if (i2 > str3.length()) {
                    break;
                }
            } while (i3 <= textView.getMaxLines());
        }
        str2 = str3;
        String str4 = str2 + "*";
        SpannableString spannableString = new SpannableString(str4);
        spannableString.setSpan(new com.kwad.sdk.core.view.f(textView.getContext(), bitmap), str4.length() - 1, str4.length(), 33);
        textView.setText(spannableString);
    }

    public static boolean a() {
        long uptimeMillis = SystemClock.uptimeMillis();
        if (Math.abs(uptimeMillis - f11107b) < 500) {
            f11107b = uptimeMillis;
            return true;
        }
        f11107b = uptimeMillis;
        return false;
    }

    public static boolean a(Activity activity) {
        return b(activity.getWindow());
    }

    public static boolean a(@Nullable Matrix matrix, int i, int i2, PhotoInfo.VideoInfo videoInfo) {
        if (matrix != null) {
            matrix.reset();
        }
        if (videoInfo == null) {
            return false;
        }
        float f = videoInfo.width;
        float f2 = videoInfo.height;
        if (f >= f2) {
            return false;
        }
        float f3 = (float) videoInfo.leftRatio;
        float f4 = (float) videoInfo.topRatio;
        float f5 = (float) videoInfo.widthRatio;
        float f6 = (float) videoInfo.heightRatio;
        float f7 = i / f;
        float f8 = i2 / f2;
        if (Math.abs((f7 / f8) - 1.0f) < 0.01d) {
            return false;
        }
        if (f7 > f8) {
            float f9 = ((f8 / f7) + 1.0f) / 2.0f;
            if (f4 < (1.0f - (f8 / f7)) / 2.0f || f4 + f6 > f9) {
                return false;
            }
        } else {
            float f10 = ((f7 / f8) + 1.0f) / 2.0f;
            if (f3 < (1.0f - (f7 / f8)) / 2.0f || f3 + f5 > f10) {
                return false;
            }
            f7 = f8;
        }
        if (matrix == null) {
            return true;
        }
        matrix.preTranslate((i - f) / 2.0f, (i2 - f2) / 2.0f);
        matrix.preScale(f / i, f2 / i2);
        matrix.postScale(f7, f7, i / 2.0f, i2 / 2.0f);
        return true;
    }

    public static boolean a(View view, int i) {
        boolean z = true;
        if (view == null) {
            return false;
        }
        if (!e(view.getContext()) || !b(view, i, true)) {
            z = false;
        }
        return z;
    }

    public static boolean a(View view, int i, boolean z) {
        return view != null && e(view.getContext()) && b(view, i, z);
    }

    @Deprecated
    public static int b(@Nullable Context context) {
        if (context == null) {
            return 0;
        }
        DisplayMetrics displayMetrics = new DisplayMetrics();
        ((WindowManager) context.getSystemService("window")).getDefaultDisplay().getMetrics(displayMetrics);
        return displayMetrics.heightPixels;
    }

    @Nullable
    private static Activity b(View view) {
        Context context = view.getContext();
        HashSet hashSet = new HashSet();
        hashSet.add(context);
        while (context instanceof ContextWrapper) {
            if (context instanceof Activity) {
                return (Activity) context;
            }
            context = context instanceof ResContext ? ((ResContext) context).getDelegatedContext() : ((ContextWrapper) context).getBaseContext();
            if (hashSet.contains(context)) {
                return null;
            }
            hashSet.add(context);
        }
        return null;
    }

    public static View b(@NonNull Activity activity) {
        return a(activity.getWindow());
    }

    public static void b(View view, int i, int i2) {
        View view2;
        if (view == null || i == 0 || i2 == 0 || (view2 = (View) view.getParent()) == null) {
            return;
        }
        int width = view2.getWidth();
        int height = view2.getHeight();
        if (width == 0 || height == 0) {
            return;
        }
        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        if (width > height) {
            if (i > i2) {
                layoutParams.width = width;
                layoutParams.height = (int) ((i2 / (i * 1.0f)) * width);
            } else {
                layoutParams.width = (int) ((i / (i2 * 1.0f)) * height);
                layoutParams.height = height;
            }
        } else if (i2 > i) {
            layoutParams.width = width;
            layoutParams.height = (int) ((i2 / (i * 1.0f)) * width);
        } else {
            layoutParams.width = width;
            layoutParams.height = (int) ((i2 / (i * 1.0f)) * width);
        }
        view.setLayoutParams(layoutParams);
    }

    private static boolean b(View view, int i, boolean z) {
        if (view == null || view.getParent() == null) {
            return false;
        }
        if (view.isShown() || view.getVisibility() == 0) {
            if (!z || view.hasWindowFocus()) {
                Rect rect = new Rect();
                if (view.getGlobalVisibleRect(rect)) {
                    long height = rect.height() * rect.width();
                    long height2 = view.getHeight() * view.getWidth();
                    return height2 > 0 && height * 100 >= height2 * ((long) i);
                }
                return false;
            }
            return false;
        }
        return false;
    }

    private static boolean b(Window window) {
        return (window.getAttributes().flags & 1024) == 1024;
    }

    public static int c(@NonNull Activity activity) {
        return b(activity).getWidth();
    }

    @Deprecated
    public static int c(@Nullable Context context) {
        if (context == null) {
            return 0;
        }
        DisplayMetrics displayMetrics = new DisplayMetrics();
        ((WindowManager) context.getSystemService("window")).getDefaultDisplay().getMetrics(displayMetrics);
        return displayMetrics.widthPixels;
    }

    public static int d(@NonNull Activity activity) {
        return b(activity).getHeight();
    }

    @Nullable
    public static Context d(Context context) {
        Context baseContext;
        ResContext resContext = context instanceof ResContext ? (ResContext) context : null;
        HashSet hashSet = new HashSet();
        hashSet.add(context);
        for (Context context2 = context; context2 instanceof ContextWrapper; context2 = baseContext) {
            if (context2 instanceof Activity) {
                return context2;
            }
            if (context2 instanceof ResContext) {
                ResContext resContext2 = (ResContext) context2;
                baseContext = resContext2.getDelegatedContext();
                resContext = resContext2;
            } else {
                baseContext = ((ContextWrapper) context2).getBaseContext();
            }
            if (hashSet.contains(baseContext)) {
                break;
            }
            hashSet.add(baseContext);
        }
        return resContext != null ? resContext.getDelegatedContext() : context;
    }

    private static boolean e(Context context) {
        try {
            PowerManager powerManager = (PowerManager) context.getSystemService("power");
            Method method = powerManager != null ? powerManager.getClass().getMethod("isScreenOn", new Class[0]) : null;
            if (method != null) {
                if (((Boolean) method.invoke(powerManager, new Object[0])).booleanValue()) {
                    return true;
                }
            }
            return false;
        } catch (Exception e) {
            com.kwad.sdk.core.d.a.a(e);
            return false;
        }
    }

    private static LayoutInflater f(Context context) {
        return LayoutInflater.from(context);
    }
}
