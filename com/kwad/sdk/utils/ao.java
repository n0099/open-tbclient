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
import com.baidu.tbadk.core.util.StringHelper;
import com.kwad.sdk.api.core.ResContext;
import com.kwad.sdk.core.response.model.PhotoInfo;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.HashSet;
/* loaded from: classes6.dex */
public class ao {

    /* renamed from: a  reason: collision with root package name */
    public static int f37139a;

    /* renamed from: b  reason: collision with root package name */
    public static long f37140b;

    public static int a(@Nullable Context context) {
        int i = f37139a;
        if (i <= 0 && context != null) {
            int identifier = context.getResources().getIdentifier("status_bar_height", "dimen", "android");
            if (identifier > 0) {
                f37139a = context.getResources().getDimensionPixelSize(identifier);
            } else {
                try {
                    Class<?> cls = Class.forName("com.android.internal.R$dimen");
                    Object newInstance = cls.newInstance();
                    Field field = cls.getField("status_bar_height");
                    field.setAccessible(true);
                    f37139a = context.getResources().getDimensionPixelSize(Integer.parseInt(field.get(newInstance).toString()));
                } catch (Throwable th) {
                    th.printStackTrace();
                }
            }
            if (f37139a <= 0) {
                f37139a = a(context, 25.0f);
            }
            return f37139a;
        }
        return i;
    }

    public static int a(Context context, float f2) {
        return (int) (context == null ? f2 * 2.0f : (f2 * context.getResources().getDisplayMetrics().density) + 0.5f);
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
            if (i <= i2) {
                layoutParams.width = (int) ((i / (i2 * 1.0f)) * height);
                layoutParams.height = height;
            }
            layoutParams.width = -1;
            layoutParams.height = -1;
        } else {
            if (i2 <= i) {
                layoutParams.width = width;
                layoutParams.height = (int) ((i2 / (i * 1.0f)) * width);
            }
            layoutParams.width = -1;
            layoutParams.height = -1;
        }
        view.setLayoutParams(layoutParams);
    }

    public static void a(TextView textView, String str, Bitmap bitmap) {
        String str2 = str + "   ";
        TextPaint paint = textView.getPaint();
        Paint.FontMetrics fontMetrics = paint.getFontMetrics();
        int ceil = ((int) Math.ceil(fontMetrics.descent - fontMetrics.top)) + 2;
        BitmapDrawable bitmapDrawable = new BitmapDrawable(textView.getContext().getResources(), bitmap);
        int intrinsicWidth = (bitmapDrawable.getIntrinsicWidth() * ceil) / bitmapDrawable.getIntrinsicHeight();
        bitmapDrawable.setBounds(0, a(textView.getContext(), 1.0f), intrinsicWidth, ceil);
        float width = textView.getWidth();
        if (paint.measureText(str2) > width) {
            int i = 0;
            int i2 = 1;
            int i3 = 1;
            boolean z = false;
            while (true) {
                float measureText = paint.measureText(str2.substring(i, i2));
                if (measureText < width) {
                    if (i3 == textView.getMaxLines()) {
                        float f2 = measureText + intrinsicWidth;
                        if (paint.measureText("   ") + f2 < width && f2 + paint.measureText(StringHelper.STRING_MORE) + paint.measureText("   ") < width) {
                            if (z) {
                                str2 = str2.substring(0, i2) + StringHelper.STRING_MORE + "   ";
                                break;
                            }
                        } else {
                            i2--;
                            z = true;
                        }
                    }
                    i2++;
                } else {
                    i = i2 - 1;
                    i3++;
                }
                if (i2 <= str2.length()) {
                    if (i3 > textView.getMaxLines()) {
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

    public static boolean a() {
        long uptimeMillis = SystemClock.uptimeMillis();
        int i = (Math.abs(uptimeMillis - f37140b) > 500L ? 1 : (Math.abs(uptimeMillis - f37140b) == 500L ? 0 : -1));
        f37140b = uptimeMillis;
        return i < 0;
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
        float f2 = videoInfo.width;
        float f3 = videoInfo.height;
        if (f2 >= f3) {
            return false;
        }
        float f4 = (float) videoInfo.leftRatio;
        float f5 = (float) videoInfo.topRatio;
        float f6 = (float) videoInfo.widthRatio;
        float f7 = (float) videoInfo.heightRatio;
        float f8 = i;
        float f9 = f8 / f2;
        float f10 = i2;
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

    public static boolean a(View view, int i) {
        return view != null && e(view.getContext()) && b(view, i, true);
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
    public static Activity b(View view) {
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
        if (width <= height || i > i2) {
            layoutParams.width = width;
            layoutParams.height = (int) ((i2 / (i * 1.0f)) * width);
        } else {
            layoutParams.width = (int) ((i / (i2 * 1.0f)) * height);
            layoutParams.height = height;
        }
        view.setLayoutParams(layoutParams);
    }

    public static boolean b(View view, int i, boolean z) {
        if (view == null || view.getParent() == null) {
            return false;
        }
        if (view.isShown() || view.getVisibility() == 0) {
            if (!z || view.hasWindowFocus()) {
                Rect rect = new Rect();
                if (view.getGlobalVisibleRect(rect)) {
                    long height = rect.height() * rect.width();
                    long height2 = view.getHeight() * view.getWidth();
                    return height2 > 0 && height * 100 >= ((long) i) * height2;
                }
                return false;
            }
            return false;
        }
        return false;
    }

    public static boolean b(Window window) {
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

    public static boolean e(Context context) {
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

    public static LayoutInflater f(Context context) {
        return LayoutInflater.from(context);
    }
}
