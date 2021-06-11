package d.a.l0.a.v2;

import android.app.Activity;
import android.app.ActivityManager;
import android.app.Application;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.os.Build;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.util.Log;
import android.util.Pair;
import android.view.Display;
import android.view.KeyCharacterMap;
import android.view.View;
import android.view.ViewConfiguration;
import android.widget.AbsoluteLayout;
import android.widget.FrameLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.UiThread;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.swan.apps.res.ui.BdBaseImageView;
import com.baidu.swan.apps.runtime.config.SwanAppConfigData;
import d.a.l0.a.a1.e;
import d.a.l0.a.f1.e.b;
import io.reactivex.annotations.SchedulerSupport;
import java.io.File;
import java.util.List;
/* loaded from: classes3.dex */
public class n0 {

    /* renamed from: a  reason: collision with root package name */
    public static final boolean f49106a = d.a.l0.a.k.f46875a;

    /* renamed from: b  reason: collision with root package name */
    public static DisplayMetrics f49107b;

    /* renamed from: c  reason: collision with root package name */
    public static final DisplayMetrics f49108c;

    /* renamed from: d  reason: collision with root package name */
    public static final float f49109d;

    static {
        DisplayMetrics displayMetrics = d.a.l0.a.c1.a.b().getResources().getDisplayMetrics();
        f49108c = displayMetrics;
        f49109d = displayMetrics.density;
    }

    @UiThread
    public static Bitmap A(float f2, float f3) {
        d.a.l0.a.g1.f V = d.a.l0.a.g1.f.V();
        AbsoluteLayout C = V.C(V.D());
        if (C == null || C.getWidth() <= 0 || C.getHeight() <= 0) {
            return null;
        }
        Bitmap createBitmap = Bitmap.createBitmap((int) (C.getWidth() * f2), (int) (C.getHeight() * f3), Bitmap.Config.ARGB_4444);
        createBitmap.eraseColor(-1);
        C.draw(new Canvas(createBitmap));
        return createBitmap;
    }

    public static void B(Context context) {
        if (f49107b == null) {
            Application b2 = d.a.l0.a.c1.a.b();
            if (b2 != null) {
                context = b2;
            }
            if (context == null) {
                return;
            }
            f49107b = context.getResources().getDisplayMetrics();
        }
    }

    public static boolean C() {
        ActivityManager activityManager = (ActivityManager) d.a.l0.a.c1.a.b().getSystemService("activity");
        if (activityManager == null) {
            return false;
        }
        try {
            List<ActivityManager.RunningAppProcessInfo> runningAppProcesses = activityManager.getRunningAppProcesses();
            if (runningAppProcesses != null && !runningAppProcesses.isEmpty()) {
                for (ActivityManager.RunningAppProcessInfo runningAppProcessInfo : runningAppProcesses) {
                    if (runningAppProcessInfo != null && runningAppProcessInfo.importance == 100) {
                        return false;
                    }
                }
            }
            return true;
        } catch (Throwable unused) {
            return false;
        }
    }

    public static boolean D(Context context) {
        return Build.VERSION.SDK_INT >= 24 && (context instanceof Activity) && ((Activity) context).isInMultiWindowMode();
    }

    public static boolean E(@NonNull d.a.l0.a.a2.n.g gVar, Context context) {
        return d.a.l0.a.w2.d.b.f49332i && (TextUtils.equals(gVar.j, SchedulerSupport.CUSTOM) || !f0.h(context));
    }

    public static boolean F() {
        return d.a.l0.a.c1.a.b().getResources().getConfiguration().orientation == 2;
    }

    public static boolean G(Activity activity) {
        if (activity == null) {
            return false;
        }
        Display defaultDisplay = activity.getWindowManager().getDefaultDisplay();
        return defaultDisplay.getRotation() == 1 || defaultDisplay.getRotation() == 3;
    }

    public static boolean H() {
        return d.a.l0.a.c1.a.b().getResources().getConfiguration().orientation == 1;
    }

    public static void I(BdBaseImageView bdBaseImageView, TextView textView, String str) {
        if ("0".equals(str)) {
            bdBaseImageView.setVisibility(8);
            textView.setVisibility(8);
        } else if ("1".equals(String.valueOf(str))) {
            bdBaseImageView.setVisibility(0);
            textView.setVisibility(0);
            textView.setText(d.a.l0.a.h.aiapps_history_aiapp_tag);
        } else if ("2".equals(String.valueOf(str))) {
            bdBaseImageView.setVisibility(0);
            textView.setVisibility(0);
            textView.setText(d.a.l0.a.h.aiapps_history_aiapp_tag_trial);
        } else if ("3".equals(String.valueOf(str))) {
            bdBaseImageView.setVisibility(0);
            textView.setVisibility(0);
            textView.setText(d.a.l0.a.h.aiapps_history_aiapp_tag_experience);
        }
    }

    public static int J(Context context, float f2) {
        return (int) (f2 / l(context));
    }

    public static int K(float f2) {
        return J(d.a.l0.a.c1.a.b(), f2);
    }

    public static float L(float f2) {
        return f2 / l(d.a.l0.a.c1.a.b());
    }

    public static void a(Activity activity) {
        if (activity == null || !d.a.l0.a.w2.d.b.f49332i) {
            return;
        }
        new d.a.l0.a.w2.d.b(activity).n(-1, false, true, true);
    }

    public static void b(Activity activity) {
        if (activity == null || !d.a.l0.a.w2.d.b.f49332i) {
            return;
        }
        new d.a.l0.a.w2.d.b(activity).n(-1, true, false, true);
    }

    public static void c(Activity activity) {
        if (f.d(activity) && d.a.l0.t.e.d() && d.a.l0.t.e.e(activity)) {
            i(activity);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:20:0x0037  */
    /* JADX WARN: Removed duplicated region for block: B:23:0x0040  */
    /* JADX WARN: Removed duplicated region for block: B:31:0x0099  */
    /* JADX WARN: Removed duplicated region for block: B:33:0x009f  */
    /* JADX WARN: Removed duplicated region for block: B:34:0x00a2  */
    /* JADX WARN: Removed duplicated region for block: B:36:0x00a5  */
    /* JADX WARN: Removed duplicated region for block: B:38:0x00a8  */
    /* JADX WARN: Removed duplicated region for block: B:40:0x00ab  */
    /* JADX WARN: Removed duplicated region for block: B:43:0x00ba  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static int d(int i2, String str) {
        int i3;
        int i4;
        int i5;
        boolean z;
        boolean z2;
        boolean z3;
        boolean z4;
        Context appContext = AppRuntime.getAppContext();
        try {
            i3 = u();
            try {
                i4 = appContext.getResources().getDimensionPixelSize(d.a.l0.a.d.aiapps_normal_base_action_bar_height);
                try {
                    i5 = appContext.getResources().getDimensionPixelSize(d.a.l0.a.d.aiapps_bottom_tab_height);
                    try {
                        i5 += appContext.getResources().getDimensionPixelSize(d.a.l0.a.d.aiapps_bottom_tab_shadow_height);
                    } catch (Resources.NotFoundException e2) {
                        e = e2;
                        if (f49106a) {
                            e.printStackTrace();
                        }
                        if (TextUtils.isEmpty(str)) {
                        }
                        if (!z) {
                        }
                        if (!z3) {
                        }
                        if (!z4) {
                        }
                        if (z2) {
                        }
                        if (f49106a) {
                        }
                        return Math.max(r9, 0);
                    }
                } catch (Resources.NotFoundException e3) {
                    e = e3;
                    i5 = 0;
                    if (f49106a) {
                    }
                    if (TextUtils.isEmpty(str)) {
                    }
                    if (!z) {
                    }
                    if (!z3) {
                    }
                    if (!z4) {
                    }
                    if (z2) {
                    }
                    if (f49106a) {
                    }
                    return Math.max(r9, 0);
                }
            } catch (Resources.NotFoundException e4) {
                e = e4;
                i4 = 0;
                i5 = 0;
                if (f49106a) {
                }
                if (TextUtils.isEmpty(str)) {
                }
                if (!z) {
                }
                if (!z3) {
                }
                if (!z4) {
                }
                if (z2) {
                }
                if (f49106a) {
                }
                return Math.max(r9, 0);
            }
        } catch (Resources.NotFoundException e5) {
            e = e5;
            i3 = 0;
        }
        if (TextUtils.isEmpty(str)) {
            String b2 = d.a.l0.a.c2.f.p0.j.b(o0.f(str));
            SwanAppConfigData s = d.a.l0.a.g1.f.V().s();
            d.a.l0.a.a2.e Q = d.a.l0.a.a2.e.Q();
            if (Q == null) {
                return i2;
            }
            b.a L = Q.L();
            d.a.l0.a.a2.n.g d2 = d.a.l0.a.g1.f.V().d(b2, s, e.C0617e.i(L.H(), L.u1()).getPath() + File.separator);
            if (d.a.l0.a.a2.n.g.f(d2)) {
                z3 = true;
                z4 = E(d2, appContext);
            } else {
                z3 = false;
                z4 = false;
            }
            z = q0.E(b2);
            z2 = d2.f44473f;
        } else {
            z = false;
            z2 = false;
            z3 = false;
            z4 = false;
        }
        int i6 = !z ? i2 - i5 : i2;
        if (!z3) {
            i6 -= i4;
        }
        if (!z4) {
            i6 -= i3;
        }
        if (z2) {
            i6 -= (int) (h(50.0f) + 0.5f);
        }
        if (f49106a) {
            int e6 = f0.e(appContext);
            int c2 = g0.c();
            Log.d("SwanAppUIUtils", "screenHeight:" + i2 + ",notchHeight:" + e6 + ",navHeight:" + c2 + ",preGuessWebViewHeight:" + i6 + ",pageUrl:" + str + ",hasTab:" + z + ",bottomBarHeight:" + i5 + ",isTransparentBar:" + z3 + ",actionBarHeight:" + i4 + ",isOccupyStatusBar:" + z4 + ",statusBarHeight:" + i3 + ",canPullToRefresh:" + z2);
        }
        return Math.max(i6, 0);
    }

    public static Pair<Integer, Integer> e(String str) {
        Pair<Integer, Integer> y;
        long currentTimeMillis = f49106a ? System.currentTimeMillis() : 0L;
        if (d.a.l0.a.a2.d.g().x() == null) {
            y = (Pair) d.a.l0.a.f1.c.b.c().b("screenSize");
            if (y == null) {
                y = g0.b();
            }
        } else {
            y = d.a.l0.a.g1.f.V().y();
        }
        int intValue = ((Integer) y.first).intValue();
        int d2 = d(((Integer) y.second).intValue(), str);
        if (f49106a) {
            Log.d("SwanAppUIUtils", "preGuessWebViewSize cost - " + (System.currentTimeMillis() - currentTimeMillis) + "ms");
        }
        return new Pair<>(Integer.valueOf(intValue), Integer.valueOf(d2));
    }

    public static int f(Context context, float f2) {
        return (int) (f2 * l(context));
    }

    public static int g(float f2) {
        return f(d.a.l0.a.c1.a.b(), f2);
    }

    public static float h(float f2) {
        return f2 * l(d.a.l0.a.c1.a.b());
    }

    public static void i(Activity activity) {
        FrameLayout frameLayout;
        if (f.d(activity) && (frameLayout = (FrameLayout) activity.getWindow().getDecorView().getRootView().findViewById(d.a.l0.a.f.ai_apps_activity_root)) != null) {
            frameLayout.setBackgroundColor(activity.getResources().getColor(d.a.l0.a.c.aiapps_keyboard_divider_color));
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(d.a.l0.t.e.a(activity), -1);
            layoutParams.gravity = 17;
            ((FrameLayout) frameLayout.findViewById(d.a.l0.a.f.ai_apps_container)).setLayoutParams(new FrameLayout.LayoutParams(layoutParams));
        }
    }

    public static int j() {
        return d.a.l0.a.c1.a.b().getResources().getDimensionPixelSize(d.a.l0.a.d.aiapps_normal_base_action_bar_height);
    }

    public static int k(Context context) {
        d.a.l0.a.h0.g.d m;
        d.a.l0.a.h0.g.g W = d.a.l0.a.g1.f.V().W();
        int i2 = 0;
        if (context == null || W == null || (m = W.m()) == null || !(m instanceof d.a.l0.a.h0.g.f) || !((d.a.l0.a.h0.g.f) m).Z1()) {
            return 0;
        }
        try {
            i2 = context.getResources().getDimensionPixelSize(d.a.l0.a.d.aiapps_bottom_tab_height);
            int dimensionPixelSize = context.getResources().getDimensionPixelSize(d.a.l0.a.d.aiapps_bottom_tab_shadow_height);
            return dimensionPixelSize > 0 ? i2 + dimensionPixelSize : i2;
        } catch (Resources.NotFoundException e2) {
            if (f49106a) {
                e2.printStackTrace();
                return i2;
            }
            return i2;
        }
    }

    public static float l(Context context) {
        B(d.a.l0.a.c1.a.b());
        DisplayMetrics displayMetrics = f49107b;
        if (displayMetrics != null) {
            return displayMetrics.density;
        }
        return 0.0f;
    }

    public static int m(Context context) {
        B(d.a.l0.a.c1.a.b());
        DisplayMetrics displayMetrics = f49107b;
        if (displayMetrics != null) {
            return displayMetrics.densityDpi;
        }
        return 0;
    }

    public static int n(Context context) {
        B(d.a.l0.a.c1.a.b());
        DisplayMetrics displayMetrics = f49107b;
        if (displayMetrics != null) {
            return displayMetrics.heightPixels;
        }
        return 0;
    }

    public static int o(@Nullable Context context) {
        B(d.a.l0.a.c1.a.b());
        DisplayMetrics displayMetrics = f49107b;
        if (displayMetrics != null) {
            return displayMetrics.widthPixels;
        }
        return 0;
    }

    public static Bitmap p() {
        return q(d.a.l0.a.g1.f.V().getActivity());
    }

    public static Bitmap q(Activity activity) {
        if (activity == null) {
            return null;
        }
        View findViewById = activity.findViewById(16908290);
        Bitmap bitmap = null;
        for (int i2 = 1; i2 < 3; i2++) {
            try {
                findViewById.setDrawingCacheEnabled(true);
                Bitmap drawingCache = findViewById.getDrawingCache();
                if (drawingCache != null) {
                    bitmap = Bitmap.createScaledBitmap(drawingCache, drawingCache.getWidth() / i2, drawingCache.getHeight() / i2, false);
                }
                findViewById.setDrawingCacheEnabled(false);
            } catch (NullPointerException | OutOfMemoryError e2) {
                if (f49106a) {
                    e2.printStackTrace();
                }
            }
            if (bitmap != null) {
                return bitmap;
            }
        }
        return null;
    }

    public static int r(Resources resources, String str) {
        int identifier = resources.getIdentifier(str, "dimen", "android");
        if (identifier > 0) {
            return resources.getDimensionPixelSize(identifier);
        }
        return 0;
    }

    public static int s() {
        boolean hasPermanentMenuKey = ViewConfiguration.get(d.a.l0.a.c1.a.b()).hasPermanentMenuKey();
        boolean deviceHasKey = KeyCharacterMap.deviceHasKey(4);
        if (hasPermanentMenuKey || deviceHasKey) {
            return 0;
        }
        Resources resources = d.a.l0.a.c1.a.b().getResources();
        return resources.getDimensionPixelSize(resources.getIdentifier("navigation_bar_height", "dimen", "android"));
    }

    public static int t(Context context) {
        return !D(context) ? G((Activity) context) ? n(context) : o(context) : F() ? n(context) : o(context);
    }

    public static int u() {
        int identifier = d.a.l0.a.c1.a.b().getResources().getIdentifier("status_bar_height", "dimen", "android");
        int i2 = 0;
        if (identifier > 0) {
            try {
                i2 = d.a.l0.a.c1.a.b().getResources().getDimensionPixelSize(identifier);
            } catch (Exception unused) {
            }
        }
        return i2 == 0 ? (int) (f49109d * 25.0f) : i2;
    }

    public static int v(Context context) {
        int i2;
        boolean z;
        if (context == null) {
            return 0;
        }
        int n = n(context);
        int u = u();
        int k = k(context);
        try {
            i2 = context.getResources().getDimensionPixelSize(d.a.l0.a.d.aiapps_normal_base_action_bar_height);
        } catch (Resources.NotFoundException e2) {
            if (f49106a) {
                e2.printStackTrace();
            }
            i2 = 0;
        }
        d.a.l0.a.h0.g.g W = d.a.l0.a.g1.f.V().W();
        d.a.l0.a.h0.g.f fVar = null;
        if (W != null) {
            d.a.l0.a.h0.g.d m = W.m();
            if (m instanceof d.a.l0.a.h0.g.f) {
                fVar = (d.a.l0.a.h0.g.f) m;
            }
        }
        boolean z2 = true;
        if (fVar == null || !d.a.l0.a.a2.n.g.f(fVar.D1())) {
            z2 = false;
            z = false;
        } else {
            d.a.l0.a.w2.d.b F1 = fVar.F1();
            z2 = (F1 == null || !F1.i()) ? false : false;
            z = true;
        }
        int i3 = n - k;
        if (!z2) {
            i3 -= u;
        }
        if (!z) {
            i3 -= i2;
        }
        if (i3 > 0) {
            return i3;
        }
        return 0;
    }

    public static int w(TextView textView) {
        if (textView == null) {
            return 0;
        }
        Paint paint = new Paint();
        paint.setTextSize(textView.getTextSize());
        Paint.FontMetrics fontMetrics = paint.getFontMetrics();
        if (TextUtils.isEmpty(textView.getText())) {
            return 0;
        }
        return (int) (Math.ceil(fontMetrics.descent - fontMetrics.ascent) + 2.0d);
    }

    public static int x(TextView textView) {
        if (textView == null) {
            return 0;
        }
        Paint paint = new Paint();
        paint.setTextSize(textView.getTextSize());
        if (TextUtils.isEmpty(textView.getText())) {
            return 0;
        }
        return (int) paint.measureText(textView.getText().toString());
    }

    @UiThread
    public static Bitmap y(View view, int i2, int i3) {
        if (view == null) {
            return null;
        }
        Bitmap createBitmap = Bitmap.createBitmap(i2, i3, Bitmap.Config.ARGB_4444);
        view.draw(new Canvas(createBitmap));
        return createBitmap;
    }

    @UiThread
    public static Bitmap z() {
        return A(1.0f, 1.0f);
    }
}
