package com.bytedance.sdk.openadsdk.utils;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ObjectAnimator;
import android.app.Activity;
import android.app.KeyguardManager;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Picture;
import android.graphics.Point;
import android.graphics.Rect;
import android.os.Build;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.DisplayCutout;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowInsets;
import android.view.WindowManager;
import android.webkit.WebView;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.annotation.Nullable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import org.json.JSONObject;
/* loaded from: classes6.dex */
public class al {

    /* renamed from: a  reason: collision with root package name */
    public static float f30165a = -1.0f;

    /* renamed from: b  reason: collision with root package name */
    public static int f30166b = -1;

    /* renamed from: c  reason: collision with root package name */
    public static float f30167c = -1.0f;

    /* renamed from: d  reason: collision with root package name */
    public static int f30168d = -1;

    /* renamed from: e  reason: collision with root package name */
    public static int f30169e = -1;

    /* renamed from: f  reason: collision with root package name */
    public static WindowManager f30170f;

    /* renamed from: g  reason: collision with root package name */
    public static float f30171g;

    static {
        a(com.bytedance.sdk.openadsdk.core.p.a());
    }

    public static void a(Context context) {
        Context a2 = context == null ? com.bytedance.sdk.openadsdk.core.p.a() : context;
        f30170f = (WindowManager) com.bytedance.sdk.openadsdk.core.p.a().getSystemService("window");
        if (a2 == null) {
            return;
        }
        if (b()) {
            DisplayMetrics displayMetrics = a2.getResources().getDisplayMetrics();
            f30165a = displayMetrics.density;
            f30166b = displayMetrics.densityDpi;
            f30167c = displayMetrics.scaledDensity;
            f30168d = displayMetrics.widthPixels;
            f30169e = displayMetrics.heightPixels;
        }
        if (context == null || context.getResources() == null || context.getResources().getConfiguration() == null) {
            return;
        }
        if (context.getResources().getConfiguration().orientation == 1) {
            int i2 = f30168d;
            int i3 = f30169e;
            if (i2 > i3) {
                f30168d = i3;
                f30169e = i2;
                return;
            }
            return;
        }
        int i4 = f30168d;
        int i5 = f30169e;
        if (i4 < i5) {
            f30168d = i5;
            f30169e = i4;
        }
    }

    public static boolean a(int i2) {
        return i2 == 0 || i2 == 8 || i2 == 4;
    }

    public static int c(Context context) {
        a(context);
        return f30168d;
    }

    public static int d(Context context) {
        a(context);
        return f30169e;
    }

    public static float e(Context context) {
        a(context);
        return f30165a;
    }

    public static int f(Context context) {
        a(context);
        return f30166b;
    }

    public static void g(View view) {
        if (view == null) {
            return;
        }
        a(view, 0);
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(view, "alpha", 0.0f, 1.0f);
        ofFloat.addListener(new AnimatorListenerAdapter() { // from class: com.bytedance.sdk.openadsdk.utils.al.2
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
                super.onAnimationEnd(animator);
            }
        });
        ofFloat.setDuration(300L);
        ofFloat.start();
    }

    public static int h(Context context) {
        if (context == null) {
            context = com.bytedance.sdk.openadsdk.core.p.a();
        }
        Display defaultDisplay = ((WindowManager) context.getSystemService("window")).getDefaultDisplay();
        DisplayMetrics displayMetrics = new DisplayMetrics();
        if (Build.VERSION.SDK_INT >= 17) {
            defaultDisplay.getRealMetrics(displayMetrics);
        } else {
            defaultDisplay.getMetrics(displayMetrics);
        }
        return displayMetrics.widthPixels;
    }

    public static float i(Context context) {
        if (context == null) {
            context = com.bytedance.sdk.openadsdk.core.p.a();
        }
        int identifier = context.getApplicationContext().getResources().getIdentifier("status_bar_height", "dimen", "android");
        if (identifier > 0) {
            return context.getApplicationContext().getResources().getDimensionPixelSize(identifier);
        }
        return 0.0f;
    }

    public static boolean b() {
        return f30165a < 0.0f || f30166b < 0 || f30167c < 0.0f || f30168d < 0 || f30169e < 0;
    }

    public static int b(Context context, float f2) {
        a(context);
        float e2 = e(context);
        if (e2 <= 0.0f) {
            e2 = 1.0f;
        }
        return (int) ((f2 / e2) + 0.5f);
    }

    @Nullable
    public static int[] c(View view) {
        if (view != null) {
            return new int[]{view.getWidth(), view.getHeight()};
        }
        return null;
    }

    public static boolean d(View view) {
        return view != null && view.getVisibility() == 0;
    }

    public static boolean e(View view) {
        return view != null && view.getVisibility() == 0 && view.getAlpha() == 1.0f;
    }

    public static void f(final View view) {
        if (view == null) {
            return;
        }
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(view, "alpha", 1.0f, 0.0f);
        ofFloat.addListener(new AnimatorListenerAdapter() { // from class: com.bytedance.sdk.openadsdk.utils.al.1
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                super.onAnimationEnd(animator);
                al.a(view, 8);
                ObjectAnimator.ofFloat(view, "alpha", 0.0f, 1.0f).setDuration(0L).start();
            }
        });
        ofFloat.setDuration(800L);
        ofFloat.start();
    }

    public static Bitmap d(WebView webView) {
        if (webView == null) {
            return null;
        }
        try {
            webView.measure(View.MeasureSpec.makeMeasureSpec(0, 0), View.MeasureSpec.makeMeasureSpec(0, 0));
            webView.layout(0, 0, webView.getMeasuredWidth(), webView.getMeasuredHeight());
            webView.setDrawingCacheEnabled(true);
            webView.buildDrawingCache();
            if (webView.getMeasuredWidth() > 0 && webView.getMeasuredHeight() > 0) {
                Bitmap createBitmap = Bitmap.createBitmap(webView.getMeasuredWidth(), webView.getMeasuredHeight(), Bitmap.Config.RGB_565);
                Canvas canvas = new Canvas(createBitmap);
                canvas.drawBitmap(createBitmap, 0.0f, createBitmap.getHeight(), new Paint());
                webView.draw(canvas);
                return createBitmap;
            }
        } catch (Throwable unused) {
        }
        return null;
    }

    public static int[] b(Context context) {
        if (context == null) {
            return null;
        }
        if (f30170f == null) {
            f30170f = (WindowManager) com.bytedance.sdk.openadsdk.core.p.a().getSystemService("window");
        }
        int[] iArr = new int[2];
        WindowManager windowManager = f30170f;
        if (windowManager != null) {
            Display defaultDisplay = windowManager.getDefaultDisplay();
            DisplayMetrics displayMetrics = new DisplayMetrics();
            defaultDisplay.getMetrics(displayMetrics);
            int i2 = displayMetrics.widthPixels;
            int i3 = displayMetrics.heightPixels;
            int i4 = Build.VERSION.SDK_INT;
            if (i4 >= 14 && i4 < 17) {
                try {
                    i2 = ((Integer) Display.class.getMethod("getRawWidth", new Class[0]).invoke(defaultDisplay, new Object[0])).intValue();
                    i3 = ((Integer) Display.class.getMethod("getRawHeight", new Class[0]).invoke(defaultDisplay, new Object[0])).intValue();
                } catch (Exception unused) {
                }
            }
            if (Build.VERSION.SDK_INT >= 17) {
                try {
                    Point point = new Point();
                    Display.class.getMethod("getRealSize", Point.class).invoke(defaultDisplay, point);
                    i2 = point.x;
                    i3 = point.y;
                } catch (Exception unused2) {
                }
            }
            iArr[0] = i2;
            iArr[1] = i3;
        }
        if (iArr[0] <= 0 || iArr[1] <= 0) {
            DisplayMetrics displayMetrics2 = context.getResources().getDisplayMetrics();
            iArr[0] = displayMetrics2.widthPixels;
            iArr[1] = displayMetrics2.heightPixels;
        }
        return iArr;
    }

    public static Bitmap c(WebView webView) {
        Bitmap bitmap = null;
        try {
            Picture capturePicture = webView.capturePicture();
            if (capturePicture != null && capturePicture.getWidth() > 0 && capturePicture.getHeight() > 0) {
                bitmap = Bitmap.createBitmap(capturePicture.getWidth(), capturePicture.getHeight(), Bitmap.Config.ARGB_8888);
                capturePicture.draw(new Canvas(bitmap));
                return bitmap;
            }
            return null;
        } catch (Throwable unused) {
            return bitmap;
        }
    }

    public static int g(Context context) {
        if (context == null) {
            context = com.bytedance.sdk.openadsdk.core.p.a();
        }
        Display defaultDisplay = ((WindowManager) context.getSystemService("window")).getDefaultDisplay();
        DisplayMetrics displayMetrics = new DisplayMetrics();
        if (Build.VERSION.SDK_INT >= 17) {
            defaultDisplay.getRealMetrics(displayMetrics);
        } else {
            defaultDisplay.getMetrics(displayMetrics);
        }
        return displayMetrics.heightPixels;
    }

    public static void h(View view) {
        if (view == null) {
            return;
        }
        try {
            if (Build.VERSION.SDK_INT >= 28 && f30171g == 0.0f) {
                WindowInsets rootWindowInsets = view.getRootWindowInsets();
                DisplayCutout displayCutout = rootWindowInsets != null ? rootWindowInsets.getDisplayCutout() : null;
                if (displayCutout != null) {
                    f30171g = displayCutout.getSafeInsetTop();
                }
            }
            if (f30171g == 0.0f) {
                return;
            }
            float max = Math.max(i(view.getContext()), f30171g);
            ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
            if (layoutParams instanceof FrameLayout.LayoutParams) {
                FrameLayout.LayoutParams layoutParams2 = (FrameLayout.LayoutParams) layoutParams;
                layoutParams2.topMargin = (int) (layoutParams2.topMargin + max);
            }
            if (layoutParams instanceof RelativeLayout.LayoutParams) {
                RelativeLayout.LayoutParams layoutParams3 = (RelativeLayout.LayoutParams) layoutParams;
                layoutParams3.topMargin = (int) (layoutParams3.topMargin + max);
            }
            if (layoutParams instanceof LinearLayout.LayoutParams) {
                LinearLayout.LayoutParams layoutParams4 = (LinearLayout.LayoutParams) layoutParams;
                layoutParams4.topMargin = (int) (layoutParams4.topMargin + max);
            }
            view.setLayoutParams(layoutParams);
        } catch (Throwable unused) {
        }
    }

    public static int c(Context context, float f2) {
        return (int) ((f2 * context.getResources().getDisplayMetrics().density) + 0.5f);
    }

    public static void c(Context context, com.bytedance.sdk.openadsdk.core.d.l lVar, String str, String str2, Bitmap bitmap, boolean z, int i2) {
        if (bitmap != null) {
            try {
                if (bitmap.getWidth() > 0 && bitmap.getHeight() > 0 && !bitmap.isRecycled()) {
                    int a2 = a(bitmap);
                    if (a2 >= 50 || z) {
                        com.bytedance.sdk.openadsdk.c.d.a(context, lVar, str, str2, a2, i2);
                    }
                }
            } catch (Throwable th) {
                u.f("UIUtils", "(开发者可忽略此检测异常)checkWebViewIsTransparent->throwable ex>>>" + th.toString());
            }
        }
    }

    public static float a(Context context, float f2) {
        a(context);
        return (f2 * e(context)) + 0.5f;
    }

    public static void a(View view, int i2, int i3, int i4, int i5) {
        Rect rect = new Rect();
        view.getHitRect(rect);
        rect.top -= i2;
        rect.bottom += i3;
        rect.left -= i4;
        rect.right += i5;
        ((View) view.getParent()).setTouchDelegate(new n(rect, view));
    }

    public static int[] b(View view) {
        if (view != null) {
            int[] iArr = new int[2];
            view.getLocationOnScreen(iArr);
            return iArr;
        }
        return null;
    }

    public static void b(View view, int i2, int i3, int i4, int i5) {
        ViewGroup.LayoutParams layoutParams;
        if (view == null || (layoutParams = view.getLayoutParams()) == null || !(layoutParams instanceof ViewGroup.MarginLayoutParams)) {
            return;
        }
        a(view, (ViewGroup.MarginLayoutParams) layoutParams, i2, i3, i4, i5);
    }

    @Nullable
    public static int[] a(View view) {
        if (view == null || view.getVisibility() != 0) {
            return null;
        }
        int[] iArr = new int[2];
        view.getLocationOnScreen(iArr);
        return iArr;
    }

    public static Bitmap b(WebView webView) {
        int layerType = webView.getLayerType();
        webView.setLayerType(1, null);
        Bitmap d2 = d(webView);
        if (d2 == null) {
            d2 = c(webView);
        }
        webView.setLayerType(layerType, null);
        if (d2 == null) {
            return null;
        }
        return f.a(d2, d2.getWidth() / 6, d2.getHeight() / 6);
    }

    public static void a(View view, int i2) {
        if (view == null || view.getVisibility() == i2 || !a(i2)) {
            return;
        }
        view.setVisibility(i2);
    }

    public static void a(View view, float f2) {
        if (view == null) {
            return;
        }
        view.setAlpha(f2);
    }

    public static boolean a(WebView webView) {
        if (webView == null || !webView.canGoBack()) {
            return false;
        }
        webView.goBack();
        return true;
    }

    public static void a(TextView textView, CharSequence charSequence) {
        if (textView == null || TextUtils.isEmpty(charSequence)) {
            return;
        }
        textView.setText(charSequence);
    }

    public static ArrayList<Integer> b(Bitmap bitmap) {
        if (bitmap == null) {
            return null;
        }
        try {
            int width = bitmap.getWidth();
            int height = bitmap.getHeight();
            int i2 = width * height;
            int[] iArr = new int[i2];
            bitmap.getPixels(iArr, 0, width, 0, 0, width, height);
            ArrayList<Integer> arrayList = new ArrayList<>();
            for (int i3 = 0; i3 < i2; i3++) {
                int i4 = iArr[i3];
                arrayList.add(Integer.valueOf(Color.rgb((16711680 & i4) >> 16, (65280 & i4) >> 8, i4 & 255)));
            }
            return arrayList;
        } catch (Throwable unused) {
            return null;
        }
    }

    public static void a(View view, ViewGroup.MarginLayoutParams marginLayoutParams, int i2, int i3, int i4, int i5) {
        if (view == null || marginLayoutParams == null) {
            return;
        }
        if (marginLayoutParams.leftMargin == i2 && marginLayoutParams.topMargin == i3 && marginLayoutParams.rightMargin == i4 && marginLayoutParams.bottomMargin == i5) {
            return;
        }
        if (i2 != -3) {
            marginLayoutParams.leftMargin = i2;
        }
        if (i3 != -3) {
            marginLayoutParams.topMargin = i3;
        }
        if (i4 != -3) {
            marginLayoutParams.rightMargin = i4;
        }
        if (i5 != -3) {
            marginLayoutParams.bottomMargin = i5;
        }
        view.setLayoutParams(marginLayoutParams);
    }

    public static boolean a() {
        try {
            return !((KeyguardManager) com.bytedance.sdk.openadsdk.core.p.a().getSystemService("keyguard")).inKeyguardRestrictedInputMode();
        } catch (Throwable unused) {
            return false;
        }
    }

    public static JSONObject a(JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        try {
            int i2 = 1;
            if (!jSONObject.has("app_scene")) {
                jSONObject.put("app_scene", com.bytedance.sdk.openadsdk.core.i.d().a() ? 1 : 0);
            }
            if (!jSONObject.has("lock_scene")) {
                if (!(!a())) {
                    i2 = 0;
                }
                jSONObject.put("lock_scene", i2);
            }
        } catch (Throwable th) {
            u.b("addShowScene error " + th.toString());
        }
        return jSONObject;
    }

    public static void a(Activity activity) {
        if (activity == null) {
            return;
        }
        try {
            if (Build.VERSION.SDK_INT > 11 && Build.VERSION.SDK_INT < 19) {
                activity.getWindow().getDecorView().setSystemUiVisibility(8);
            } else if (Build.VERSION.SDK_INT >= 19) {
                activity.getWindow().getDecorView().setSystemUiVisibility(3846);
                activity.getWindow().addFlags(134217728);
            }
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    public static void a(View view, View.OnClickListener onClickListener, String str) {
        if (view == null) {
            u.f("OnclickListener ", str + " is null , can not set OnClickListener !!!");
            return;
        }
        view.setOnClickListener(onClickListener);
    }

    public static void a(View view, View.OnTouchListener onTouchListener, String str) {
        if (view == null) {
            u.f("OnTouchListener ", str + " is null , can not set OnTouchListener !!!");
            return;
        }
        view.setOnTouchListener(onTouchListener);
    }

    public static void a(final Context context, final com.bytedance.sdk.openadsdk.core.d.l lVar, final String str, final String str2, final Bitmap bitmap, final boolean z, final int i2) {
        com.bytedance.sdk.openadsdk.l.e.a(new com.bytedance.sdk.openadsdk.l.g("startCheckPlayableStatusPercentage") { // from class: com.bytedance.sdk.openadsdk.utils.al.3
            @Override // java.lang.Runnable
            public void run() {
                al.c(context, lVar, str, str2, bitmap, z, i2);
            }
        }, 5);
    }

    public static int a(Bitmap bitmap) {
        try {
            ArrayList<Integer> b2 = b(bitmap);
            if (b2 == null) {
                return -1;
            }
            HashMap hashMap = new HashMap();
            Iterator<Integer> it = b2.iterator();
            while (it.hasNext()) {
                Integer next = it.next();
                if (hashMap.containsKey(next)) {
                    Integer valueOf = Integer.valueOf(((Integer) hashMap.get(next)).intValue() + 1);
                    hashMap.remove(next);
                    hashMap.put(next, valueOf);
                } else {
                    hashMap.put(next, 1);
                }
            }
            int i2 = 0;
            int i3 = 0;
            for (Map.Entry entry : hashMap.entrySet()) {
                int intValue = ((Integer) entry.getValue()).intValue();
                if (i3 < intValue) {
                    i2 = ((Integer) entry.getKey()).intValue();
                    i3 = intValue;
                }
            }
            if (i2 == 0) {
                return -1;
            }
            return (int) ((i3 / ((bitmap.getWidth() * bitmap.getHeight()) * 1.0f)) * 100.0f);
        } catch (Throwable unused) {
            return -1;
        }
    }
}
