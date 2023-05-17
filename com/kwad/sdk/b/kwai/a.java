package com.kwad.sdk.b.kwai;

import android.app.Activity;
import android.content.Context;
import android.content.ContextWrapper;
import android.graphics.Rect;
import android.os.SystemClock;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.FrameLayout;
import androidx.annotation.ColorInt;
import androidx.annotation.ColorRes;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.baidu.pass.biometrics.base.utils.SapiSystemBarTintManager;
import com.baidu.tbadk.core.elementsMaven.EMABTest;
import com.kwad.sdk.api.core.ResContext;
import com.kwad.sdk.utils.al;
import com.kwad.sdk.utils.q;
import java.util.HashSet;
/* loaded from: classes9.dex */
public final class a {
    public static int SK;
    public static long SL;

    public static int A(View view2) {
        if (view2 == null) {
            return 0;
        }
        ViewGroup.LayoutParams layoutParams = view2.getLayoutParams();
        if (layoutParams instanceof FrameLayout.LayoutParams) {
            return ((FrameLayout.LayoutParams) layoutParams).gravity;
        }
        return 0;
    }

    public static int a(Context context, float f) {
        return (int) (context == null ? f * 2.0f : (f * context.getResources().getDisplayMetrics().density) + 0.5f);
    }

    public static View a(ViewGroup viewGroup, int i, boolean z) {
        return aK(viewGroup.getContext()).inflate(i, viewGroup, true);
    }

    public static void a(View.OnClickListener onClickListener, View... viewArr) {
        for (View view2 : viewArr) {
            view2.setOnClickListener(onClickListener);
        }
    }

    public static boolean a(Activity activity) {
        return a(activity.getWindow());
    }

    public static boolean a(View view2, int i, boolean z) {
        return view2 != null && b(view2, i, z) && aJ(view2.getContext());
    }

    public static boolean a(Window window) {
        return (window.getAttributes().flags & 1024) == 1024;
    }

    public static int aH(@Nullable Context context) {
        int i = SK;
        if (i <= 0 && context != null) {
            int identifier = context.getResources().getIdentifier(SapiSystemBarTintManager.SystemBarConfig.g, EMABTest.TYPE_DIMEN, "android");
            if (identifier > 0) {
                SK = context.getResources().getDimensionPixelSize(identifier);
            } else {
                try {
                    SK = context.getResources().getDimensionPixelSize(((Integer) q.c("com.android.internal.R$dimen", SapiSystemBarTintManager.SystemBarConfig.g)).intValue());
                } catch (Throwable th) {
                    th.printStackTrace();
                }
            }
            if (SK <= 0) {
                SK = a(context, 25.0f);
            }
            return SK;
        }
        return i;
    }

    public static float aI(@NonNull Context context) {
        return context.getResources().getDisplayMetrics().density;
    }

    public static boolean aJ(Context context) {
        return al.zM().aJ(context);
    }

    public static LayoutInflater aK(Context context) {
        return LayoutInflater.from(context);
    }

    public static int b(Context context, float f) {
        return (int) (context == null ? f / 2.0f : (f / context.getResources().getDisplayMetrics().density) + 0.5f);
    }

    public static View b(@NonNull Activity activity) {
        return b(activity.getWindow());
    }

    public static View b(@NonNull Window window) {
        return window.getDecorView().findViewById(16908290);
    }

    public static void b(View view2, int i, int i2, int i3, int i4) {
        if (view2.getLayoutParams() instanceof ViewGroup.MarginLayoutParams) {
            ((ViewGroup.MarginLayoutParams) view2.getLayoutParams()).setMargins(i, i2, i3, 0);
            view2.requestLayout();
        }
    }

    public static boolean b(View view2, int i, boolean z) {
        if (view2 == null || view2.getParent() == null) {
            return false;
        }
        Context x = x(view2);
        if (!((x instanceof Activity) && ((Activity) x).isFinishing()) && view2.isShown() && view2.getVisibility() == 0 && (!z || view2.hasWindowFocus())) {
            Rect rect = new Rect();
            if (view2.getGlobalVisibleRect(rect)) {
                long height = rect.height() * rect.width();
                long height2 = view2.getHeight() * view2.getWidth();
                if (height2 > 0 && height * 100 >= i * height2) {
                    return true;
                }
            }
            return false;
        }
        return false;
    }

    public static int c(@NonNull Activity activity) {
        return b(activity).getWidth();
    }

    public static int d(@NonNull Activity activity) {
        return b(activity).getHeight();
    }

    public static void d(View view2, int i, int i2) {
        View view3;
        if (view2 == null || i == 0 || i2 == 0 || (view3 = (View) view2.getParent()) == null) {
            return;
        }
        int width = view3.getWidth();
        int height = view3.getHeight();
        if (width == 0 || height == 0) {
            return;
        }
        ViewGroup.LayoutParams layoutParams = view2.getLayoutParams();
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
        view2.setLayoutParams(layoutParams);
    }

    public static void e(View view2, int i, int i2) {
        View view3;
        if (view2 == null || i == 0 || i2 == 0 || (view3 = (View) view2.getParent()) == null) {
            return;
        }
        int width = view3.getWidth();
        int height = view3.getHeight();
        if (width == 0 || height == 0) {
            return;
        }
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

    public static void f(View view2, int i, int i2) {
        View view3;
        if (view2 == null || i == 0 || i2 == 0 || (view3 = (View) view2.getParent()) == null) {
            return;
        }
        int width = view3.getWidth();
        int height = view3.getHeight();
        if (width == 0 || height == 0) {
            return;
        }
        ViewGroup.LayoutParams layoutParams = view2.getLayoutParams();
        if (width <= height || i > i2) {
            layoutParams.width = width;
            layoutParams.height = (int) ((i2 / (i * 1.0f)) * width);
        } else {
            layoutParams.width = (int) ((i / (i2 * 1.0f)) * height);
            layoutParams.height = height;
        }
        view2.setLayoutParams(layoutParams);
    }

    public static boolean g(View view2, int i) {
        return view2 != null && b(view2, i, true) && view2.hasWindowFocus() && aJ(view2.getContext());
    }

    @ColorInt
    public static int getColor(Context context, @ColorRes int i) {
        return context.getResources().getColor(i);
    }

    @Deprecated
    public static int getScreenHeight(@Nullable Context context) {
        if (context == null) {
            return 0;
        }
        DisplayMetrics displayMetrics = new DisplayMetrics();
        ((WindowManager) context.getSystemService("window")).getDefaultDisplay().getMetrics(displayMetrics);
        return displayMetrics.heightPixels;
    }

    @Deprecated
    public static int getScreenWidth(@Nullable Context context) {
        if (context == null) {
            return 0;
        }
        DisplayMetrics displayMetrics = new DisplayMetrics();
        ((WindowManager) context.getSystemService("window")).getDefaultDisplay().getMetrics(displayMetrics);
        return displayMetrics.widthPixels;
    }

    public static void h(View view2, int i) {
        if (view2 == null || i == 0) {
            return;
        }
        ViewGroup.LayoutParams layoutParams = view2.getLayoutParams();
        layoutParams.height = i;
        view2.setLayoutParams(layoutParams);
    }

    public static void i(View view2, int i) {
        if (view2 == null) {
            return;
        }
        ViewGroup.LayoutParams layoutParams = view2.getLayoutParams();
        if (layoutParams instanceof FrameLayout.LayoutParams) {
            ((FrameLayout.LayoutParams) layoutParams).gravity = i;
        }
    }

    public static boolean ro() {
        long uptimeMillis = SystemClock.uptimeMillis();
        int i = (Math.abs(uptimeMillis - SL) > 500L ? 1 : (Math.abs(uptimeMillis - SL) == 500L ? 0 : -1));
        SL = uptimeMillis;
        return i < 0;
    }

    @NonNull
    public static Context x(@NonNull View view2) {
        Activity y = y(view2);
        if (y == null && (view2.getParent() instanceof View)) {
            y = y((View) view2.getParent());
        }
        return y == null ? view2.getContext() : y;
    }

    @Nullable
    public static Activity y(View view2) {
        Context context = view2.getContext();
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

    @Nullable
    public static int[] z(View view2) {
        if (view2 == null) {
            return null;
        }
        view2.getLocationInWindow(r1);
        int[] iArr = {iArr[0] + (view2.getWidth() / 2), iArr[1] + (view2.getHeight() / 2)};
        return iArr;
    }
}
