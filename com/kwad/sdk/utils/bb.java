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
/* loaded from: classes5.dex */
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

    public static int a(Context context, float f) {
        return (int) (context == null ? f * 2.0f : (f * context.getResources().getDisplayMetrics().density) + 0.5f);
    }

    @NonNull
    public static Context a(@NonNull View view2) {
        Activity b = b(view2);
        if (b == null && (view2.getParent() instanceof View)) {
            b = b((View) view2.getParent());
        }
        return b == null ? view2.getContext() : b;
    }

    public static void a(View view2, int i, int i2, int i3, int i4) {
        if (view2.getLayoutParams() instanceof ViewGroup.MarginLayoutParams) {
            ((ViewGroup.MarginLayoutParams) view2.getLayoutParams()).setMargins(i, i2, i3, i4);
            view2.requestLayout();
        }
    }

    public static boolean a() {
        long uptimeMillis = SystemClock.uptimeMillis();
        int i = (Math.abs(uptimeMillis - a) > 500L ? 1 : (Math.abs(uptimeMillis - a) == 500L ? 0 : -1));
        a = uptimeMillis;
        return i < 0;
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
        float f7 = i;
        float f8 = f7 / f;
        float f9 = i2;
        float f10 = f9 / f2;
        float f11 = f8 / f10;
        if (Math.abs(f11 - 1.0f) < 0.01d) {
            return false;
        }
        if (f8 > f10) {
            float f12 = f10 / f8;
            float f13 = (f12 + 1.0f) / 2.0f;
            if (f4 < (1.0f - f12) / 2.0f || f4 + f6 > f13) {
                return false;
            }
        } else {
            float f14 = (f11 + 1.0f) / 2.0f;
            if (f3 < (1.0f - f11) / 2.0f || f3 + f5 > f14) {
                return false;
            }
            f8 = f10;
        }
        if (matrix == null) {
            return true;
        }
        matrix.preTranslate((f7 - f) / 2.0f, (f9 - f2) / 2.0f);
        matrix.preScale(f / f7, f2 / f9);
        matrix.postScale(f8, f8, f7 / 2.0f, f9 / 2.0f);
        return true;
    }

    public static boolean a(View view2, int i) {
        return view2 != null && b(view2, i, true) && view2.hasWindowFocus() && e(view2.getContext());
    }

    public static boolean a(View view2, int i, boolean z) {
        return view2 != null && b(view2, i, z) && e(view2.getContext());
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
    public static Activity b(View view2) {
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

    public static boolean b(View view2, int i, boolean z) {
        if (view2 == null || view2.getParent() == null) {
            return false;
        }
        if (com.kwad.sdk.core.config.b.ay()) {
            if (!view2.isShown() && view2.getVisibility() != 0) {
                return false;
            }
        } else if (!view2.isShown() || view2.getVisibility() != 0) {
            return false;
        }
        if (!z || view2.hasWindowFocus()) {
            Rect rect = new Rect();
            if (view2.getGlobalVisibleRect(rect)) {
                long height = rect.height() * rect.width();
                long height2 = view2.getHeight() * view2.getWidth();
                return height2 > 0 && height * 100 >= ((long) i) * height2;
            }
            return false;
        }
        return false;
    }

    public static float c(@NonNull Context context) {
        return context.getResources().getDisplayMetrics().density;
    }

    @Nullable
    public static int[] c(View view2) {
        if (view2 == null) {
            return null;
        }
        view2.getLocationInWindow(r1);
        int[] iArr = {iArr[0] + (view2.getWidth() / 2), iArr[1] + (view2.getHeight() / 2)};
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
