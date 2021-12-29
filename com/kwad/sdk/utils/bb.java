package com.kwad.sdk.utils;

import android.app.Activity;
import android.content.Context;
import android.content.ContextWrapper;
import android.graphics.Matrix;
import android.graphics.Rect;
import android.os.SystemClock;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.kwad.sdk.api.core.ResContext;
import com.kwad.sdk.core.response.model.PhotoInfo;
import java.util.HashSet;
/* loaded from: classes3.dex */
public class bb {
    public static long a;

    @Deprecated
    public static int a(@Nullable Context context) {
        if (context == null) {
            return 0;
        }
        DisplayMetrics displayMetrics = new DisplayMetrics();
        ((WindowManager) context.getSystemService("window")).getDefaultDisplay().getMetrics(displayMetrics);
        return displayMetrics.heightPixels;
    }

    public static int a(Context context, float f2) {
        return (int) (context == null ? f2 * 2.0f : (f2 * context.getResources().getDisplayMetrics().density) + 0.5f);
    }

    @NonNull
    public static Context a(@NonNull View view) {
        Activity b2 = b(view);
        if (b2 == null && (view.getParent() instanceof View)) {
            b2 = b((View) view.getParent());
        }
        return b2 == null ? view.getContext() : b2;
    }

    public static void a(View view, int i2, int i3, int i4, int i5) {
        if (view.getLayoutParams() instanceof ViewGroup.MarginLayoutParams) {
            ((ViewGroup.MarginLayoutParams) view.getLayoutParams()).setMargins(i2, i3, i4, i5);
            view.requestLayout();
        }
    }

    public static boolean a() {
        long uptimeMillis = SystemClock.uptimeMillis();
        int i2 = (Math.abs(uptimeMillis - a) > 500L ? 1 : (Math.abs(uptimeMillis - a) == 500L ? 0 : -1));
        a = uptimeMillis;
        return i2 < 0;
    }

    public static boolean a(@Nullable Matrix matrix, int i2, int i3, PhotoInfo.VideoInfo videoInfo) {
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

    public static boolean a(View view, int i2) {
        return view != null && b(view, i2, true) && view.hasWindowFocus() && e(view.getContext());
    }

    public static boolean a(View view, int i2, boolean z) {
        return view != null && b(view, i2, z) && e(view.getContext());
    }

    @Deprecated
    public static int b(@Nullable Context context) {
        if (context == null) {
            return 0;
        }
        DisplayMetrics displayMetrics = new DisplayMetrics();
        ((WindowManager) context.getSystemService("window")).getDefaultDisplay().getMetrics(displayMetrics);
        return displayMetrics.widthPixels;
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

    public static boolean b(View view, int i2, boolean z) {
        if (view == null || view.getParent() == null) {
            return false;
        }
        if (com.kwad.sdk.core.config.b.ay()) {
            if (!view.isShown() && view.getVisibility() != 0) {
                return false;
            }
        } else if (!view.isShown() || view.getVisibility() != 0) {
            return false;
        }
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

    public static float c(@NonNull Context context) {
        return context.getResources().getDisplayMetrics().density;
    }

    @Nullable
    public static int[] c(View view) {
        if (view == null) {
            return null;
        }
        view.getLocationInWindow(r1);
        int[] iArr = {iArr[0] + (view.getWidth() / 2), iArr[1] + (view.getHeight() / 2)};
        return iArr;
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
        return ak.a().a(context);
    }
}
