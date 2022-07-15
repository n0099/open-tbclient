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
import com.kwad.sdk.utils.ai;
import com.kwad.sdk.utils.q;
import java.util.HashSet;
/* loaded from: classes5.dex */
public final class a {
    public static int a;
    public static long b;

    public static int a(@Nullable Context context) {
        int i = a;
        if (i <= 0 && context != null) {
            int identifier = context.getResources().getIdentifier(SapiSystemBarTintManager.SystemBarConfig.g, EMABTest.TYPE_DIMEN, "android");
            if (identifier > 0) {
                a = context.getResources().getDimensionPixelSize(identifier);
            } else {
                try {
                    a = context.getResources().getDimensionPixelSize(((Integer) q.a((Object) "com.android.internal.R$dimen", SapiSystemBarTintManager.SystemBarConfig.g)).intValue());
                } catch (Throwable th) {
                    th.printStackTrace();
                }
            }
            if (a <= 0) {
                a = a(context, 25.0f);
            }
            return a;
        }
        return i;
    }

    public static int a(Context context, float f) {
        return (int) (context == null ? f * 2.0f : (f * context.getResources().getDisplayMetrics().density) + 0.5f);
    }

    @ColorInt
    public static int a(Context context, @ColorRes int i) {
        return context.getResources().getColor(i);
    }

    @NonNull
    public static Context a(@NonNull View view2) {
        Activity d = d(view2);
        if (d == null && (view2.getParent() instanceof View)) {
            d = d((View) view2.getParent());
        }
        return d == null ? view2.getContext() : d;
    }

    public static View a(ViewGroup viewGroup, int i, boolean z) {
        return f(viewGroup.getContext()).inflate(i, viewGroup, true);
    }

    public static void a(View.OnClickListener onClickListener, View... viewArr) {
        for (View view2 : viewArr) {
            view2.setOnClickListener(onClickListener);
        }
    }

    public static void a(View view2, int i, int i2) {
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

    public static void a(View view2, int i, int i2, int i3, int i4) {
        if (view2.getLayoutParams() instanceof ViewGroup.MarginLayoutParams) {
            ((ViewGroup.MarginLayoutParams) view2.getLayoutParams()).setMargins(i, i2, i3, 0);
            view2.requestLayout();
        }
    }

    public static boolean a() {
        long uptimeMillis = SystemClock.uptimeMillis();
        int i = (Math.abs(uptimeMillis - b) > 500L ? 1 : (Math.abs(uptimeMillis - b) == 500L ? 0 : -1));
        b = uptimeMillis;
        return i < 0;
    }

    public static boolean a(Activity activity) {
        return a(activity.getWindow());
    }

    public static boolean a(View view2, int i) {
        return view2 != null && b(view2, i, true) && view2.hasWindowFocus() && e(view2.getContext());
    }

    public static boolean a(View view2, int i, boolean z) {
        return view2 != null && b(view2, i, z) && e(view2.getContext());
    }

    public static boolean a(Window window) {
        return (window.getAttributes().flags & 1024) == 1024;
    }

    public static int b(@NonNull Activity activity) {
        return d(activity).getWidth();
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

    public static int b(Context context, float f) {
        return (int) (context == null ? f / 2.0f : (f / context.getResources().getDisplayMetrics().density) + 0.5f);
    }

    public static View b(@NonNull Window window) {
        return window.getDecorView().findViewById(16908290);
    }

    public static void b(View view2, int i) {
        if (view2 == null || i == 0) {
            return;
        }
        ViewGroup.LayoutParams layoutParams = view2.getLayoutParams();
        layoutParams.height = i;
        view2.setLayoutParams(layoutParams);
    }

    public static void b(View view2, int i, int i2) {
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

    public static boolean b(View view2, int i, boolean z) {
        if (view2 == null || view2.getParent() == null) {
            return false;
        }
        Context a2 = a(view2);
        if (!((a2 instanceof Activity) && ((Activity) a2).isFinishing()) && view2.isShown() && view2.getVisibility() == 0 && (!z || view2.hasWindowFocus())) {
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

    @Nullable
    public static int[] b(View view2) {
        if (view2 == null) {
            return null;
        }
        view2.getLocationInWindow(r1);
        int[] iArr = {iArr[0] + (view2.getWidth() / 2), iArr[1] + (view2.getHeight() / 2)};
        return iArr;
    }

    public static int c(@NonNull Activity activity) {
        return d(activity).getHeight();
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

    public static int c(View view2) {
        if (view2 == null) {
            return 0;
        }
        ViewGroup.LayoutParams layoutParams = view2.getLayoutParams();
        if (layoutParams instanceof FrameLayout.LayoutParams) {
            return ((FrameLayout.LayoutParams) layoutParams).gravity;
        }
        return 0;
    }

    public static void c(View view2, int i) {
        if (view2 == null) {
            return;
        }
        ViewGroup.LayoutParams layoutParams = view2.getLayoutParams();
        if (layoutParams instanceof FrameLayout.LayoutParams) {
            ((FrameLayout.LayoutParams) layoutParams).gravity = i;
        }
    }

    public static void c(View view2, int i, int i2) {
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

    public static float d(@NonNull Context context) {
        return context.getResources().getDisplayMetrics().density;
    }

    @Nullable
    public static Activity d(View view2) {
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

    public static View d(@NonNull Activity activity) {
        return b(activity.getWindow());
    }

    public static boolean e(Context context) {
        return ai.a().a(context);
    }

    public static LayoutInflater f(Context context) {
        return LayoutInflater.from(context);
    }
}
