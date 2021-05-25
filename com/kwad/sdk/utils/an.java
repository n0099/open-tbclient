package com.kwad.sdk.utils;

import android.app.Activity;
import android.content.Context;
import android.content.ContextWrapper;
import android.graphics.Matrix;
import android.graphics.Rect;
import android.os.SystemClock;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.kwad.sdk.api.core.ResContext;
import com.kwad.sdk.core.response.model.PhotoInfo;
import java.lang.reflect.Field;
import java.util.HashSet;
/* loaded from: classes6.dex */
public class an {

    /* renamed from: a  reason: collision with root package name */
    public static int f34048a;

    /* renamed from: b  reason: collision with root package name */
    public static long f34049b;

    public static int a(@Nullable Context context) {
        int i2 = f34048a;
        if (i2 <= 0 && context != null) {
            int identifier = context.getResources().getIdentifier("status_bar_height", "dimen", "android");
            if (identifier > 0) {
                f34048a = context.getResources().getDimensionPixelSize(identifier);
            } else {
                try {
                    Class<?> cls = Class.forName("com.android.internal.R$dimen");
                    Object newInstance = cls.newInstance();
                    Field field = cls.getField("status_bar_height");
                    field.setAccessible(true);
                    f34048a = context.getResources().getDimensionPixelSize(Integer.parseInt(field.get(newInstance).toString()));
                } catch (Throwable th) {
                    th.printStackTrace();
                }
            }
            if (f34048a <= 0) {
                f34048a = a(context, 25.0f);
            }
            return f34048a;
        }
        return i2;
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

    public static View a(@NonNull Activity activity) {
        return a(activity.getWindow());
    }

    public static View a(ViewGroup viewGroup, int i2, boolean z) {
        return f(viewGroup.getContext()).inflate(i2, viewGroup, z);
    }

    public static View a(@NonNull Window window) {
        return window.getDecorView().findViewById(16908290);
    }

    public static void a(View view, int i2, int i3) {
        View view2;
        if (view == null || i2 == 0 || i3 == 0 || (view2 = (View) view.getParent()) == null) {
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

    public static boolean a() {
        long uptimeMillis = SystemClock.uptimeMillis();
        int i2 = (Math.abs(uptimeMillis - f34049b) > 500L ? 1 : (Math.abs(uptimeMillis - f34049b) == 500L ? 0 : -1));
        f34049b = uptimeMillis;
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
        return view != null && b(view, i2, z) && view.hasWindowFocus() && e(view.getContext());
    }

    public static int b(@NonNull Activity activity) {
        return a(activity).getWidth();
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

    public static void b(View view, int i2, int i3) {
        View view2;
        if (view == null || i2 == 0 || i3 == 0 || (view2 = (View) view.getParent()) == null) {
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

    public static int c(@NonNull Activity activity) {
        return a(activity).getHeight();
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
        return z.a().a(context);
    }

    public static LayoutInflater f(Context context) {
        return LayoutInflater.from(context);
    }
}
