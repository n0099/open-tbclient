package com.kwad.sdk.a.kwai;

import android.app.Activity;
import android.content.Context;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.baidu.pass.biometrics.base.utils.SapiSystemBarTintManager;
import com.baidu.tbadk.core.elementsMaven.EMABTest;
import java.lang.reflect.Field;
/* loaded from: classes7.dex */
public class a {
    public static int a;

    public static int a(@Nullable Context context) {
        int i = a;
        if (i <= 0 && context != null) {
            int identifier = context.getResources().getIdentifier(SapiSystemBarTintManager.SystemBarConfig.f27942g, EMABTest.TYPE_DIMEN, "android");
            if (identifier > 0) {
                a = context.getResources().getDimensionPixelSize(identifier);
            } else {
                try {
                    Class<?> cls = Class.forName("com.android.internal.R$dimen");
                    Object newInstance = cls.newInstance();
                    Field field = cls.getField(SapiSystemBarTintManager.SystemBarConfig.f27942g);
                    field.setAccessible(true);
                    a = context.getResources().getDimensionPixelSize(Integer.parseInt(field.get(newInstance).toString()));
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

    public static int a(Context context, float f2) {
        return (int) (context == null ? f2 * 2.0f : (f2 * context.getResources().getDisplayMetrics().density) + 0.5f);
    }

    public static View a(@NonNull Activity activity) {
        return a(activity.getWindow());
    }

    public static View a(ViewGroup viewGroup, int i, boolean z) {
        return d(viewGroup.getContext()).inflate(i, viewGroup, z);
    }

    public static View a(@NonNull Window window) {
        return window.getDecorView().findViewById(16908290);
    }

    public static void a(View view, int i) {
        if (view == null || i == 0) {
            return;
        }
        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        layoutParams.height = i;
        view.setLayoutParams(layoutParams);
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

    public static int b(@NonNull Activity activity) {
        return a(activity).getHeight();
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
        if (i > i2) {
            layoutParams.width = width;
            layoutParams.height = (int) ((i2 / (i * 1.0f)) * width);
        } else {
            layoutParams.width = (int) ((i / (i2 * 1.0f)) * height);
            layoutParams.height = height;
        }
        view.setLayoutParams(layoutParams);
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

    public static void c(View view, int i, int i2) {
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

    public static LayoutInflater d(Context context) {
        return LayoutInflater.from(context);
    }
}
