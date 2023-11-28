package com.kwad.sdk.d.a;

import android.app.Activity;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Paint;
import android.graphics.drawable.BitmapDrawable;
import android.os.Build;
import android.os.SystemClock;
import android.text.SpannableString;
import android.text.TextPaint;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.FrameLayout;
import android.widget.TextView;
import androidx.annotation.ColorInt;
import androidx.annotation.ColorRes;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.baidu.searchbox.download.apkcheck.ApkCheckUBCManagerKt;
import com.baidu.tbadk.core.elementsMaven.EMABTest;
import com.kwad.sdk.utils.s;
/* loaded from: classes10.dex */
public final class a {
    public static int amU;
    public static long amV;

    public static boolean C(View view2) {
        if ((view2.getSystemUiVisibility() & 1024) == 1024) {
            return true;
        }
        return false;
    }

    public static void D(View view2) {
        if (view2 == null || ((View) view2.getParent()) == null) {
            return;
        }
        ViewGroup.LayoutParams layoutParams = view2.getLayoutParams();
        layoutParams.width = -1;
        layoutParams.height = -1;
        view2.setLayoutParams(layoutParams);
    }

    @Nullable
    public static int[] E(View view2) {
        if (view2 == null) {
            return null;
        }
        view2.getLocationInWindow(r1);
        int[] iArr = {iArr[0] + (view2.getWidth() / 2), iArr[1] + (view2.getHeight() / 2)};
        return iArr;
    }

    public static int F(View view2) {
        if (view2 == null) {
            return 0;
        }
        ViewGroup.LayoutParams layoutParams = view2.getLayoutParams();
        if (!(layoutParams instanceof FrameLayout.LayoutParams)) {
            return 0;
        }
        return ((FrameLayout.LayoutParams) layoutParams).gravity;
    }

    @Deprecated
    public static int aH(@Nullable Context context) {
        if (context == null) {
            return 0;
        }
        WindowManager windowManager = (WindowManager) context.getSystemService(ApkCheckUBCManagerKt.VALUE_WINDOW);
        DisplayMetrics displayMetrics = new DisplayMetrics();
        if (Build.VERSION.SDK_INT >= 17) {
            windowManager.getDefaultDisplay().getRealMetrics(displayMetrics);
        } else {
            windowManager.getDefaultDisplay().getMetrics(displayMetrics);
        }
        return displayMetrics.heightPixels;
    }

    public static float aI(@NonNull Context context) {
        return context.getResources().getDisplayMetrics().density;
    }

    public static boolean b(Activity activity) {
        return b(activity.getWindow());
    }

    public static View c(@NonNull Activity activity) {
        return c(activity.getWindow());
    }

    public static int d(@NonNull Activity activity) {
        return c(activity).getWidth();
    }

    public static int e(@NonNull Activity activity) {
        return c(activity).getHeight();
    }

    @Deprecated
    public static int getScreenHeight(@Nullable Context context) {
        if (context == null) {
            return 0;
        }
        DisplayMetrics displayMetrics = new DisplayMetrics();
        ((WindowManager) context.getSystemService(ApkCheckUBCManagerKt.VALUE_WINDOW)).getDefaultDisplay().getMetrics(displayMetrics);
        return displayMetrics.heightPixels;
    }

    @Deprecated
    public static int getScreenWidth(@Nullable Context context) {
        if (context == null) {
            return 0;
        }
        DisplayMetrics displayMetrics = new DisplayMetrics();
        ((WindowManager) context.getSystemService(ApkCheckUBCManagerKt.VALUE_WINDOW)).getDefaultDisplay().getMetrics(displayMetrics);
        return displayMetrics.widthPixels;
    }

    public static int a(Context context, float f) {
        return (int) ((f * context.getResources().getDisplayMetrics().density) + 0.5f);
    }

    public static int b(Context context, float f) {
        return (int) ((f / context.getResources().getDisplayMetrics().density) + 0.5f);
    }

    public static int g(Context context, int i) {
        return context.getResources().getDimensionPixelSize(i);
    }

    @ColorInt
    public static int getColor(Context context, @ColorRes int i) {
        return context.getResources().getColor(i);
    }

    public static void m(View view2, int i) {
        if (view2 == null || i == 0) {
            return;
        }
        ViewGroup.LayoutParams layoutParams = view2.getLayoutParams();
        layoutParams.height = i;
        view2.setLayoutParams(layoutParams);
    }

    public static void n(View view2, int i) {
        if (view2 == null) {
            return;
        }
        ViewGroup.LayoutParams layoutParams = view2.getLayoutParams();
        if (layoutParams instanceof FrameLayout.LayoutParams) {
            ((FrameLayout.LayoutParams) layoutParams).gravity = i;
        }
    }

    public static View a(ViewGroup viewGroup, int i, boolean z) {
        return LayoutInflater.from(viewGroup.getContext()).inflate(i, viewGroup, true);
    }

    public static void a(View.OnClickListener onClickListener, View... viewArr) {
        for (View view2 : viewArr) {
            view2.setOnClickListener(onClickListener);
        }
    }

    public static void a(TextView textView, String str, Bitmap bitmap) {
        String str2 = str + " ";
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
                        float f = measureText + intrinsicWidth;
                        if (paint.measureText(" ") + f < width && f + paint.measureText("...") + paint.measureText(" ") < width) {
                            if (z) {
                                str2 = str2.substring(0, i2) + "... ";
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
        spannableString.setSpan(new com.kwad.sdk.core.view.a(textView.getContext(), bitmap), str3.length() - 1, str3.length(), 33);
        textView.setText(spannableString);
    }

    public static void b(View view2, int i, int i2, int i3, int i4) {
        if (view2.getLayoutParams() instanceof ViewGroup.MarginLayoutParams) {
            ((ViewGroup.MarginLayoutParams) view2.getLayoutParams()).setMargins(i, i2, i3, 0);
            view2.requestLayout();
        }
    }

    public static boolean b(Window window) {
        if ((window.getAttributes().flags & 1024) == 1024) {
            return true;
        }
        return false;
    }

    public static View c(@NonNull Window window) {
        return window.getDecorView().findViewById(16908290);
    }

    public static void d(View view2, int i, int i2) {
        View view3;
        if (view2 == null || i == 0 || i2 == 0 || (view3 = (View) view2.getParent()) == null) {
            return;
        }
        int width = view3.getWidth();
        int height = view3.getHeight();
        if (width != 0 && height != 0) {
            ViewGroup.LayoutParams layoutParams = view2.getLayoutParams();
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
            view2.setLayoutParams(layoutParams);
        }
    }

    public static void f(View view2, int i, int i2) {
        View view3;
        if (view2 == null || i == 0 || i2 == 0 || (view3 = (View) view2.getParent()) == null) {
            return;
        }
        int width = view3.getWidth();
        int height = view3.getHeight();
        if (width != 0 && height != 0) {
            ViewGroup.LayoutParams layoutParams = view2.getLayoutParams();
            if (width > height && i <= i2) {
                layoutParams.width = (int) ((i / (i2 * 1.0f)) * height);
                layoutParams.height = height;
            } else {
                layoutParams.width = width;
                layoutParams.height = (int) ((i2 / (i * 1.0f)) * width);
            }
            view2.setLayoutParams(layoutParams);
        }
    }

    public static void e(View view2, int i, int i2) {
        View view3;
        if (view2 == null || i == 0 || i2 == 0 || (view3 = (View) view2.getParent()) == null) {
            return;
        }
        int width = view3.getWidth();
        int height = view3.getHeight();
        if (width != 0 && height != 0) {
            ViewGroup.LayoutParams layoutParams = view2.getLayoutParams();
            if (i > i2) {
                layoutParams.width = width;
                layoutParams.height = (int) ((i2 / (i * 1.0f)) * width);
            } else {
                layoutParams.width = (int) ((i / (i2 * 1.0f)) * height);
                layoutParams.height = height;
            }
            view2.setLayoutParams(layoutParams);
        }
    }

    public static int getStatusBarHeight(@Nullable Context context) {
        int i = amU;
        if (i > 0) {
            return i;
        }
        if (context == null) {
            return i;
        }
        int identifier = context.getResources().getIdentifier("status_bar_height", EMABTest.TYPE_DIMEN, "android");
        if (identifier > 0) {
            amU = context.getResources().getDimensionPixelSize(identifier);
        } else {
            try {
                amU = context.getResources().getDimensionPixelSize(((Integer) s.getField("com.android.internal.R$dimen", "status_bar_height")).intValue());
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
        if (amU <= 0) {
            amU = a(context, 25.0f);
        }
        return amU;
    }

    public static boolean zz() {
        long uptimeMillis = SystemClock.uptimeMillis();
        if (Math.abs(uptimeMillis - amV) < 500) {
            amV = uptimeMillis;
            return true;
        }
        amV = uptimeMillis;
        return false;
    }
}
