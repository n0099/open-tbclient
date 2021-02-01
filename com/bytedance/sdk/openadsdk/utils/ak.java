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
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.webkit.WebView;
import android.widget.TextView;
import androidx.annotation.Nullable;
import com.baidu.ar.constants.HttpConstants;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import org.json.JSONObject;
/* loaded from: classes6.dex */
public class ak {

    /* renamed from: a  reason: collision with root package name */
    private static float f7556a = -1.0f;

    /* renamed from: b  reason: collision with root package name */
    private static int f7557b = -1;
    private static float c = -1.0f;
    private static int d = -1;
    private static int e = -1;
    private static WindowManager f;

    static {
        a(com.bytedance.sdk.openadsdk.core.p.a());
    }

    private static boolean b() {
        return f7556a < 0.0f || f7557b < 0 || c < 0.0f || d < 0 || e < 0;
    }

    public static void a(Context context) {
        Context a2 = context == null ? com.bytedance.sdk.openadsdk.core.p.a() : context;
        f = (WindowManager) com.bytedance.sdk.openadsdk.core.p.a().getSystemService("window");
        if (a2 != null) {
            if (b()) {
                DisplayMetrics displayMetrics = a2.getResources().getDisplayMetrics();
                f7556a = displayMetrics.density;
                f7557b = displayMetrics.densityDpi;
                c = displayMetrics.scaledDensity;
                d = displayMetrics.widthPixels;
                e = displayMetrics.heightPixels;
            }
            if (context != null && context.getResources() != null && context.getResources().getConfiguration() != null) {
                if (context.getResources().getConfiguration().orientation == 1) {
                    if (d > e) {
                        int i = d;
                        d = e;
                        e = i;
                    }
                } else if (d < e) {
                    int i2 = d;
                    d = e;
                    e = i2;
                }
            }
        }
    }

    public static float a(Context context, float f2) {
        a(context);
        return (e(context) * f2) + 0.5f;
    }

    public static int b(Context context, float f2) {
        a(context);
        float e2 = e(context);
        if (e2 <= 0.0f) {
            e2 = 1.0f;
        }
        return (int) ((f2 / e2) + 0.5f);
    }

    public static int[] b(Context context) {
        int i;
        if (context == null) {
            return null;
        }
        if (f == null) {
            f = (WindowManager) com.bytedance.sdk.openadsdk.core.p.a().getSystemService("window");
        }
        int[] iArr = new int[2];
        if (f != null) {
            Display defaultDisplay = f.getDefaultDisplay();
            DisplayMetrics displayMetrics = new DisplayMetrics();
            defaultDisplay.getMetrics(displayMetrics);
            int i2 = displayMetrics.widthPixels;
            int i3 = displayMetrics.heightPixels;
            if (Build.VERSION.SDK_INT < 14 || Build.VERSION.SDK_INT >= 17) {
                i = i3;
            } else {
                try {
                    i2 = ((Integer) Display.class.getMethod("getRawWidth", new Class[0]).invoke(defaultDisplay, new Object[0])).intValue();
                    i = ((Integer) Display.class.getMethod("getRawHeight", new Class[0]).invoke(defaultDisplay, new Object[0])).intValue();
                } catch (Exception e2) {
                    i = i3;
                }
            }
            if (Build.VERSION.SDK_INT >= 17) {
                try {
                    Point point = new Point();
                    Display.class.getMethod("getRealSize", Point.class).invoke(defaultDisplay, point);
                    i2 = point.x;
                    i = point.y;
                } catch (Exception e3) {
                }
            }
            iArr[0] = i2;
            iArr[1] = i;
        }
        if (iArr[0] <= 0 || iArr[1] <= 0) {
            DisplayMetrics displayMetrics2 = context.getResources().getDisplayMetrics();
            iArr[0] = displayMetrics2.widthPixels;
            iArr[1] = displayMetrics2.heightPixels;
        }
        return iArr;
    }

    public static int c(Context context) {
        a(context);
        return d;
    }

    public static int d(Context context) {
        a(context);
        return e;
    }

    public static float e(Context context) {
        a(context);
        return f7556a;
    }

    public static int f(Context context) {
        a(context);
        return f7557b;
    }

    public static void a(View view, int i, int i2, int i3, int i4) {
        Rect rect = new Rect();
        view.getHitRect(rect);
        rect.top -= i;
        rect.bottom += i2;
        rect.left -= i3;
        rect.right += i4;
        ((View) view.getParent()).setTouchDelegate(new n(rect, view));
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

    public static int[] b(View view) {
        if (view == null) {
            return null;
        }
        int[] iArr = new int[2];
        view.getLocationOnScreen(iArr);
        return iArr;
    }

    @Nullable
    public static int[] c(View view) {
        if (view != null) {
            return new int[]{view.getWidth(), view.getHeight()};
        }
        return null;
    }

    private static boolean a(int i) {
        return i == 0 || i == 8 || i == 4;
    }

    public static void a(View view, int i) {
        if (view != null && view.getVisibility() != i && a(i)) {
            view.setVisibility(i);
        }
    }

    public static void a(View view, float f2) {
        if (view != null) {
            view.setAlpha(f2);
        }
    }

    public static boolean d(View view) {
        return view != null && view.getVisibility() == 0;
    }

    public static boolean e(View view) {
        return view != null && view.getVisibility() == 0 && view.getAlpha() == 1.0f;
    }

    public static boolean a(WebView webView) {
        if (webView == null || !webView.canGoBack()) {
            return false;
        }
        webView.goBack();
        return true;
    }

    public static void a(TextView textView, CharSequence charSequence) {
        if (textView != null && !TextUtils.isEmpty(charSequence)) {
            textView.setText(charSequence);
        }
    }

    public static void b(View view, int i, int i2, int i3, int i4) {
        ViewGroup.LayoutParams layoutParams;
        if (view != null && (layoutParams = view.getLayoutParams()) != null && (layoutParams instanceof ViewGroup.MarginLayoutParams)) {
            a(view, (ViewGroup.MarginLayoutParams) layoutParams, i, i2, i3, i4);
        }
    }

    private static void a(View view, ViewGroup.MarginLayoutParams marginLayoutParams, int i, int i2, int i3, int i4) {
        if (view == null || marginLayoutParams == null) {
            return;
        }
        if (marginLayoutParams.leftMargin != i || marginLayoutParams.topMargin != i2 || marginLayoutParams.rightMargin != i3 || marginLayoutParams.bottomMargin != i4) {
            if (i != -3) {
                marginLayoutParams.leftMargin = i;
            }
            if (i2 != -3) {
                marginLayoutParams.topMargin = i2;
            }
            if (i3 != -3) {
                marginLayoutParams.rightMargin = i3;
            }
            if (i4 != -3) {
                marginLayoutParams.bottomMargin = i4;
            }
            view.setLayoutParams(marginLayoutParams);
        }
    }

    public static boolean a() {
        try {
            return !((KeyguardManager) com.bytedance.sdk.openadsdk.core.p.a().getSystemService("keyguard")).inKeyguardRestrictedInputMode();
        } catch (Throwable th) {
            return false;
        }
    }

    public static Bitmap b(View view, int i) {
        Bitmap bitmap = null;
        if (view != null) {
            try {
                view.destroyDrawingCache();
                view.setDrawingCacheEnabled(true);
                view.buildDrawingCache();
                bitmap = view.getDrawingCache();
                if (i > 0 && bitmap != null) {
                    if (bitmap.getRowBytes() * bitmap.getHeight() >= i) {
                        bitmap = f.a(bitmap, 720, 0);
                    }
                    if (bitmap.getRowBytes() * bitmap.getHeight() >= i) {
                        bitmap = f.a(bitmap, i);
                    }
                    if (bitmap != null && u.c()) {
                        u.a("size: " + (bitmap.getRowBytes() * bitmap.getHeight()));
                    }
                }
            } catch (Exception e2) {
            }
        }
        return bitmap;
    }

    public static JSONObject a(JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        try {
            if (!jSONObject.has("app_scene")) {
                jSONObject.put("app_scene", com.bytedance.sdk.openadsdk.core.i.c().a() ? 1 : 0);
            }
            if (!jSONObject.has("lock_scene")) {
                jSONObject.put("lock_scene", !a() ? 1 : 0);
            }
        } catch (Throwable th) {
            u.b("addShowScene error " + th.toString());
        }
        return jSONObject;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static Bitmap d(WebView webView) {
        Bitmap bitmap = null;
        try {
            Picture capturePicture = webView.capturePicture();
            if (capturePicture != null && capturePicture.getWidth() > 0 && capturePicture.getHeight() > 0) {
                bitmap = Bitmap.createBitmap(capturePicture.getWidth(), capturePicture.getHeight(), Bitmap.Config.ARGB_8888);
                capturePicture.draw(new Canvas(bitmap));
                return bitmap;
            }
            return null;
        } catch (Throwable th) {
            return bitmap;
        }
    }

    public static void f(final View view) {
        if (view != null) {
            ObjectAnimator ofFloat = ObjectAnimator.ofFloat(view, "alpha", 1.0f, 0.0f);
            ofFloat.addListener(new AnimatorListenerAdapter() { // from class: com.bytedance.sdk.openadsdk.utils.ak.1
                @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                public void onAnimationEnd(Animator animator) {
                    super.onAnimationEnd(animator);
                    ak.a(view, 8);
                    ObjectAnimator.ofFloat(view, "alpha", 0.0f, 1.0f).setDuration(0L).start();
                }
            });
            ofFloat.setDuration(800L);
            ofFloat.start();
        }
    }

    public static void g(View view) {
        if (view != null) {
            a(view, 0);
            ObjectAnimator ofFloat = ObjectAnimator.ofFloat(view, "alpha", 0.0f, 1.0f);
            ofFloat.addListener(new AnimatorListenerAdapter() { // from class: com.bytedance.sdk.openadsdk.utils.ak.2
                @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                public void onAnimationStart(Animator animator) {
                    super.onAnimationEnd(animator);
                }
            });
            ofFloat.setDuration(300L);
            ofFloat.start();
        }
    }

    public static int c(Context context, float f2) {
        return (int) ((context.getResources().getDisplayMetrics().density * f2) + 0.5f);
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
        int identifier = context.getApplicationContext().getResources().getIdentifier("status_bar_height", "dimen", HttpConstants.OS_TYPE_VALUE);
        if (identifier <= 0) {
            return 0.0f;
        }
        return context.getApplicationContext().getResources().getDimensionPixelSize(identifier);
    }

    public static void a(Activity activity) {
        if (activity != null) {
            try {
                if (Build.VERSION.SDK_INT > 11 && Build.VERSION.SDK_INT < 19) {
                    activity.getWindow().getDecorView().setSystemUiVisibility(8);
                } else if (Build.VERSION.SDK_INT >= 19) {
                    activity.getWindow().getDecorView().setSystemUiVisibility(3842);
                    activity.getWindow().addFlags(134217728);
                }
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
    }

    public static void a(final Context context, final com.bytedance.sdk.openadsdk.core.d.l lVar, final String str, final WebView webView) {
        if (webView != null && lVar != null && lVar.F() == null) {
            webView.postDelayed(new Runnable() { // from class: com.bytedance.sdk.openadsdk.utils.ak.3
                @Override // java.lang.Runnable
                public void run() {
                    final Bitmap b2 = ak.b(webView, 0);
                    if (b2 == null) {
                        b2 = ak.d(webView);
                    }
                    com.bytedance.sdk.openadsdk.k.a.a().c(new Runnable() { // from class: com.bytedance.sdk.openadsdk.utils.ak.3.1
                        @Override // java.lang.Runnable
                        public void run() {
                            ak.b(context, lVar, str, b2);
                        }
                    }, 5);
                }
            }, 500L);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void b(Context context, com.bytedance.sdk.openadsdk.core.d.l lVar, String str, Bitmap bitmap) {
        Bitmap a2;
        u.b("checkWebViewIsTransparent", "checkWebViewIsTransparent start .....bitmap=" + bitmap + ",materialMeta=" + lVar);
        if (bitmap != null) {
            try {
                if (bitmap.getWidth() > 0 && bitmap.getHeight() > 0 && !bitmap.isRecycled() && (a2 = f.a(bitmap, bitmap.getWidth() / 6, bitmap.getHeight() / 6)) != null && !a2.isRecycled()) {
                    int width = a2.getWidth();
                    int height = a2.getHeight();
                    int i = 0;
                    int i2 = 0;
                    long j = (long) (width * height * 0.05d);
                    long j2 = (long) (width * height * 0.5d);
                    for (int i3 = 0; i3 < height; i3++) {
                        for (int i4 = 0; i4 < width; i4++) {
                            int pixel = a2.getPixel(i4, i3);
                            int red = Color.red(pixel);
                            int green = Color.green(pixel);
                            int blue = Color.blue(pixel);
                            int alpha = Color.alpha(pixel);
                            if (0 != red || 0 != green || 0 != blue) {
                                i2++;
                            }
                            if (red == 0 && green == 0 && blue == 0 && alpha == 0) {
                                i++;
                            }
                            if (i2 > j && i != i2) {
                                u.b("checkWebViewIsTransparent", "wwww-TAG=" + str + ",checkWebViewIsTransparent....不满足透明不上报");
                                return;
                            } else if (i >= j2) {
                                u.b("checkWebViewIsTransparent", "TAG=" + str + ",checkWebViewIsTransparent....满足透明上报..");
                                com.bytedance.sdk.openadsdk.c.d.b(context, lVar, str, (Map<String, Object>) null);
                                return;
                            }
                        }
                    }
                }
            } catch (Throwable th) {
                u.f("UIUtils", "(开发者可忽略此检测异常)checkWebViewIsTransparent->throwable ex>>>" + th.toString());
            }
        }
    }

    public static void a(View view, View.OnClickListener onClickListener, String str) {
        if (view == null) {
            u.f("OnclickListener ", str + " is null , can not set OnClickListener !!!");
        } else {
            view.setOnClickListener(onClickListener);
        }
    }

    public static void a(View view, View.OnTouchListener onTouchListener, String str) {
        if (view == null) {
            u.f("OnTouchListener ", str + " is null , can not set OnTouchListener !!!");
        } else {
            view.setOnTouchListener(onTouchListener);
        }
    }

    public static Bitmap b(WebView webView) {
        webView.setLayerType(1, null);
        Bitmap e2 = e(webView);
        if (e2 == null) {
            e2 = d(webView);
        }
        webView.setLayerType(2, null);
        if (e2 == null) {
            return null;
        }
        return f.b(e2, e2.getWidth() / 6, e2.getHeight() / 6);
    }

    public static void a(final Context context, final com.bytedance.sdk.openadsdk.core.d.l lVar, final String str, final String str2, final Bitmap bitmap, final boolean z, final int i) {
        com.bytedance.sdk.openadsdk.k.a.a().c(new Runnable() { // from class: com.bytedance.sdk.openadsdk.utils.ak.4
            @Override // java.lang.Runnable
            public void run() {
                ak.c(context, lVar, str, str2, bitmap, z, i);
            }
        }, 5);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void c(Context context, com.bytedance.sdk.openadsdk.core.d.l lVar, String str, String str2, Bitmap bitmap, boolean z, int i) {
        if (bitmap != null) {
            try {
                if (bitmap.getWidth() > 0 && bitmap.getHeight() > 0 && !bitmap.isRecycled()) {
                    int a2 = a(bitmap);
                    if (a2 >= 50 || z) {
                        com.bytedance.sdk.openadsdk.c.d.a(context, lVar, str, str2, a2, i);
                    }
                }
            } catch (Throwable th) {
                u.f("UIUtils", "(开发者可忽略此检测异常)checkWebViewIsTransparent->throwable ex>>>" + th.toString());
            }
        }
    }

    private static ArrayList<Integer> b(Bitmap bitmap) {
        if (bitmap == null) {
            return null;
        }
        try {
            int width = bitmap.getWidth();
            int height = bitmap.getHeight();
            int[] iArr = new int[width * height];
            bitmap.getPixels(iArr, 0, width, 0, 0, width, height);
            ArrayList<Integer> arrayList = new ArrayList<>();
            for (int i : iArr) {
                arrayList.add(Integer.valueOf(Color.rgb((16711680 & i) >> 16, (65280 & i) >> 8, i & 255)));
            }
            return arrayList;
        } catch (Throwable th) {
            return null;
        }
    }

    public static int a(Bitmap bitmap) {
        int i;
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
                    i = ((Integer) entry.getKey()).intValue();
                } else {
                    i = i2;
                    intValue = i3;
                }
                i2 = i;
                i3 = intValue;
            }
            if (i2 == 0) {
                return -1;
            }
            return (int) ((i3 / ((bitmap.getWidth() * bitmap.getHeight()) * 1.0f)) * 100.0f);
        } catch (Throwable th) {
            return -1;
        }
    }

    private static Bitmap e(WebView webView) {
        if (webView == null) {
            return null;
        }
        try {
            webView.measure(View.MeasureSpec.makeMeasureSpec(0, 0), View.MeasureSpec.makeMeasureSpec(0, 0));
            webView.layout(0, 0, webView.getMeasuredWidth(), webView.getMeasuredHeight());
            webView.setDrawingCacheEnabled(true);
            webView.buildDrawingCache();
            if (webView.getMeasuredWidth() <= 0 || webView.getMeasuredHeight() <= 0) {
                return null;
            }
            Bitmap createBitmap = Bitmap.createBitmap(webView.getMeasuredWidth(), webView.getMeasuredHeight(), Bitmap.Config.RGB_565);
            Canvas canvas = new Canvas(createBitmap);
            canvas.drawBitmap(createBitmap, 0.0f, createBitmap.getHeight(), new Paint());
            webView.draw(canvas);
            return createBitmap;
        } catch (Throwable th) {
            return null;
        }
    }
}
