package d.a.h0.a.i2;

import android.app.Activity;
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
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.UiThread;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.swan.apps.res.ui.BdBaseImageView;
import com.baidu.swan.apps.runtime.config.SwanAppConfigData;
import d.a.h0.a.u0.d;
import d.a.h0.a.y0.e.b;
import io.reactivex.annotations.SchedulerSupport;
import java.io.File;
/* loaded from: classes3.dex */
public class h0 {

    /* renamed from: a  reason: collision with root package name */
    public static final boolean f42726a = d.a.h0.a.k.f43101a;

    /* renamed from: b  reason: collision with root package name */
    public static DisplayMetrics f42727b;

    /* renamed from: c  reason: collision with root package name */
    public static final DisplayMetrics f42728c;

    /* renamed from: d  reason: collision with root package name */
    public static final float f42729d;

    static {
        DisplayMetrics displayMetrics = d.a.h0.a.w0.a.c().getResources().getDisplayMetrics();
        f42728c = displayMetrics;
        f42729d = displayMetrics.density;
    }

    public static boolean A(Context context) {
        return Build.VERSION.SDK_INT >= 24 && (context instanceof Activity) && ((Activity) context).isInMultiWindowMode();
    }

    public static boolean B(@NonNull d.a.h0.a.r1.n.c cVar, Context context) {
        return d.a.h0.a.j2.c.b.f43026i && (TextUtils.equals(cVar.j, SchedulerSupport.CUSTOM) || !c0.e(context));
    }

    public static boolean C() {
        return d.a.h0.a.w0.a.c().getResources().getConfiguration().orientation == 2;
    }

    public static boolean D(Activity activity) {
        if (activity == null) {
            return false;
        }
        Display defaultDisplay = activity.getWindowManager().getDefaultDisplay();
        return defaultDisplay.getRotation() == 1 || defaultDisplay.getRotation() == 3;
    }

    public static boolean E() {
        return d.a.h0.a.w0.a.c().getResources().getConfiguration().orientation == 1;
    }

    public static void F(BdBaseImageView bdBaseImageView, TextView textView, String str) {
        if ("0".equals(str)) {
            bdBaseImageView.setVisibility(8);
            textView.setVisibility(8);
        } else if ("1".equals(String.valueOf(str))) {
            bdBaseImageView.setVisibility(0);
            textView.setVisibility(0);
            textView.setText(d.a.h0.a.h.aiapps_history_aiapp_tag);
        } else if ("2".equals(String.valueOf(str))) {
            bdBaseImageView.setVisibility(0);
            textView.setVisibility(0);
            textView.setText(d.a.h0.a.h.aiapps_history_aiapp_tag_trial);
        } else if ("3".equals(String.valueOf(str))) {
            bdBaseImageView.setVisibility(0);
            textView.setVisibility(0);
            textView.setText(d.a.h0.a.h.aiapps_history_aiapp_tag_experience);
        }
    }

    public static int G(Context context, float f2) {
        return (int) (f2 / j(context));
    }

    public static int H(float f2) {
        return G(d.a.h0.a.w0.a.c(), f2);
    }

    public static float I(float f2) {
        return f2 / j(d.a.h0.a.w0.a.c());
    }

    public static void a(Activity activity) {
        if (activity == null || !d.a.h0.a.j2.c.b.f43026i) {
            return;
        }
        new d.a.h0.a.j2.c.b(activity).n(-1, false, true, true);
    }

    public static void b(Activity activity) {
        if (activity == null || !d.a.h0.a.j2.c.b.f43026i) {
            return;
        }
        new d.a.h0.a.j2.c.b(activity).n(-1, true, false, true);
    }

    /* JADX WARN: Removed duplicated region for block: B:20:0x0037  */
    /* JADX WARN: Removed duplicated region for block: B:23:0x0040  */
    /* JADX WARN: Removed duplicated region for block: B:28:0x0096  */
    /* JADX WARN: Removed duplicated region for block: B:30:0x009c  */
    /* JADX WARN: Removed duplicated region for block: B:31:0x009f  */
    /* JADX WARN: Removed duplicated region for block: B:33:0x00a2  */
    /* JADX WARN: Removed duplicated region for block: B:35:0x00a5  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x00a8  */
    /* JADX WARN: Removed duplicated region for block: B:40:0x00b3  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static int c(int i2, String str) {
        int i3;
        int i4;
        int i5;
        boolean z;
        boolean z2;
        boolean z3;
        boolean z4;
        Context appContext = AppRuntime.getAppContext();
        try {
            i3 = s();
            try {
                i4 = appContext.getResources().getDimensionPixelSize(d.a.h0.a.d.aiapps_normal_base_action_bar_height);
                try {
                    i5 = appContext.getResources().getDimensionPixelSize(d.a.h0.a.d.aiapps_bottom_tab_height);
                    try {
                        i5 += appContext.getResources().getDimensionPixelSize(d.a.h0.a.d.aiapps_bottom_tab_shadow_height);
                    } catch (Resources.NotFoundException e2) {
                        e = e2;
                        if (f42726a) {
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
                        if (f42726a) {
                        }
                        return Math.max(r9, 0);
                    }
                } catch (Resources.NotFoundException e3) {
                    e = e3;
                    i5 = 0;
                    if (f42726a) {
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
                    if (f42726a) {
                    }
                    return Math.max(r9, 0);
                }
            } catch (Resources.NotFoundException e4) {
                e = e4;
                i4 = 0;
                i5 = 0;
                if (f42726a) {
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
                if (f42726a) {
                }
                return Math.max(r9, 0);
            }
        } catch (Resources.NotFoundException e5) {
            e = e5;
            i3 = 0;
        }
        if (TextUtils.isEmpty(str)) {
            String b2 = d.a.h0.a.t1.k.p0.j.b(i0.d(str));
            SwanAppConfigData u = d.a.h0.a.z0.f.V().u();
            b.a L = d.a.h0.a.r1.e.h().L();
            d.a.h0.a.r1.n.c f2 = d.a.h0.a.z0.f.V().f(b2, u, d.e.h(L.G(), L.n1()).getPath() + File.separator);
            if (d.a.h0.a.r1.n.c.f(f2)) {
                z3 = true;
                z4 = B(f2, appContext);
            } else {
                z3 = false;
                z4 = false;
            }
            z = k0.B(b2);
            z2 = f2.f43861f;
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
            i6 -= f(50.0f);
        }
        if (f42726a) {
            int b3 = c0.b(appContext);
            int c2 = d0.c();
            Log.d("SwanAppUIUtils", "screenHeight:" + i2 + ",notchHeight:" + b3 + ",navHeight:" + c2 + ",preGuessWebViewHeight:" + i6 + ",pageUrl:" + str + ",hasTab:" + z + ",bottomBarHeight:" + i5 + ",isTransparentBar:" + z3 + ",actionBarHeight:" + i4 + ",isOccupyStatusBar:" + z4 + ",statusBarHeight:" + i3 + ",canPullToRefresh:" + z2);
        }
        return Math.max(i6, 0);
    }

    public static Pair<Integer, Integer> d(String str) {
        Pair<Integer, Integer> y;
        long currentTimeMillis = f42726a ? System.currentTimeMillis() : 0L;
        if (d.a.h0.a.r1.d.e().v() == null) {
            y = d0.b();
        } else {
            y = d.a.h0.a.z0.f.V().y();
        }
        int intValue = ((Integer) y.first).intValue();
        int c2 = c(((Integer) y.second).intValue(), str);
        if (f42726a) {
            Log.d("SwanAppUIUtils", "preGuessWebViewSize cost - " + (System.currentTimeMillis() - currentTimeMillis) + "ms");
        }
        return new Pair<>(Integer.valueOf(intValue), Integer.valueOf(c2));
    }

    public static int e(Context context, float f2) {
        return (int) (f2 * j(context));
    }

    public static int f(float f2) {
        return e(d.a.h0.a.w0.a.c(), f2);
    }

    public static float g(float f2) {
        return f2 * j(d.a.h0.a.w0.a.c());
    }

    public static int h() {
        return d.a.h0.a.w0.a.c().getResources().getDimensionPixelSize(d.a.h0.a.d.aiapps_normal_base_action_bar_height);
    }

    public static int i(Context context) {
        d.a.h0.a.e0.l.c m;
        d.a.h0.a.e0.l.f W = d.a.h0.a.z0.f.V().W();
        int i2 = 0;
        if (context == null || W == null || (m = W.m()) == null || !(m instanceof d.a.h0.a.e0.l.e) || !((d.a.h0.a.e0.l.e) m).U1()) {
            return 0;
        }
        try {
            i2 = context.getResources().getDimensionPixelSize(d.a.h0.a.d.aiapps_bottom_tab_height);
            int dimensionPixelSize = context.getResources().getDimensionPixelSize(d.a.h0.a.d.aiapps_bottom_tab_shadow_height);
            return dimensionPixelSize > 0 ? i2 + dimensionPixelSize : i2;
        } catch (Resources.NotFoundException e2) {
            if (f42726a) {
                e2.printStackTrace();
                return i2;
            }
            return i2;
        }
    }

    public static float j(Context context) {
        z(d.a.h0.a.w0.a.c());
        DisplayMetrics displayMetrics = f42727b;
        if (displayMetrics != null) {
            return displayMetrics.density;
        }
        return 0.0f;
    }

    public static int k(Context context) {
        z(d.a.h0.a.w0.a.c());
        DisplayMetrics displayMetrics = f42727b;
        if (displayMetrics != null) {
            return displayMetrics.densityDpi;
        }
        return 0;
    }

    public static int l(Context context) {
        z(d.a.h0.a.w0.a.c());
        DisplayMetrics displayMetrics = f42727b;
        if (displayMetrics != null) {
            return displayMetrics.heightPixels;
        }
        return 0;
    }

    public static int m(@Nullable Context context) {
        z(d.a.h0.a.w0.a.c());
        DisplayMetrics displayMetrics = f42727b;
        if (displayMetrics != null) {
            return displayMetrics.widthPixels;
        }
        return 0;
    }

    public static Bitmap n() {
        return o(d.a.h0.a.z0.f.V().getActivity());
    }

    public static Bitmap o(Activity activity) {
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
                if (f42726a) {
                    e2.printStackTrace();
                }
            }
            if (bitmap != null) {
                return bitmap;
            }
        }
        return null;
    }

    public static int p(Resources resources, String str) {
        int identifier = resources.getIdentifier(str, "dimen", "android");
        if (identifier > 0) {
            return resources.getDimensionPixelSize(identifier);
        }
        return 0;
    }

    public static int q() {
        boolean hasPermanentMenuKey = ViewConfiguration.get(d.a.h0.a.w0.a.c()).hasPermanentMenuKey();
        boolean deviceHasKey = KeyCharacterMap.deviceHasKey(4);
        if (hasPermanentMenuKey || deviceHasKey) {
            return 0;
        }
        Resources resources = d.a.h0.a.w0.a.c().getResources();
        return resources.getDimensionPixelSize(resources.getIdentifier("navigation_bar_height", "dimen", "android"));
    }

    public static int r(Context context) {
        return !A(context) ? D((Activity) context) ? l(context) : m(context) : C() ? l(context) : m(context);
    }

    public static int s() {
        int identifier = d.a.h0.a.w0.a.c().getResources().getIdentifier("status_bar_height", "dimen", "android");
        int i2 = 0;
        if (identifier > 0) {
            try {
                i2 = d.a.h0.a.w0.a.c().getResources().getDimensionPixelSize(identifier);
            } catch (Exception unused) {
            }
        }
        return i2 == 0 ? (int) (f42729d * 25.0f) : i2;
    }

    public static int t(Context context) {
        int i2;
        boolean z;
        if (context == null) {
            return 0;
        }
        int l = l(context);
        int s = s();
        int i3 = i(context);
        try {
            i2 = context.getResources().getDimensionPixelSize(d.a.h0.a.d.aiapps_normal_base_action_bar_height);
        } catch (Resources.NotFoundException e2) {
            if (f42726a) {
                e2.printStackTrace();
            }
            i2 = 0;
        }
        d.a.h0.a.e0.l.f W = d.a.h0.a.z0.f.V().W();
        d.a.h0.a.e0.l.e eVar = null;
        if (W != null) {
            d.a.h0.a.e0.l.c m = W.m();
            if (m instanceof d.a.h0.a.e0.l.e) {
                eVar = (d.a.h0.a.e0.l.e) m;
            }
        }
        boolean z2 = true;
        if (eVar == null || !d.a.h0.a.r1.n.c.f(eVar.x1())) {
            z2 = false;
            z = false;
        } else {
            d.a.h0.a.j2.c.b A1 = eVar.A1();
            z2 = (A1 == null || !A1.i()) ? false : false;
            z = true;
        }
        int i4 = l - i3;
        if (!z2) {
            i4 -= s;
        }
        if (!z) {
            i4 -= i2;
        }
        if (i4 > 0) {
            return i4;
        }
        return 0;
    }

    public static int u(TextView textView) {
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

    public static int v(TextView textView) {
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
    public static Bitmap w(View view, int i2, int i3) {
        if (view == null) {
            return null;
        }
        Bitmap createBitmap = Bitmap.createBitmap(i2, i3, Bitmap.Config.ARGB_4444);
        view.draw(new Canvas(createBitmap));
        return createBitmap;
    }

    @UiThread
    public static Bitmap x() {
        return y(1.0f, 1.0f);
    }

    @UiThread
    public static Bitmap y(float f2, float f3) {
        d.a.h0.a.z0.f V = d.a.h0.a.z0.f.V();
        AbsoluteLayout C = V.C(V.D());
        if (C == null || C.getWidth() <= 0 || C.getHeight() <= 0) {
            return null;
        }
        Bitmap createBitmap = Bitmap.createBitmap((int) (C.getWidth() * f2), (int) (C.getHeight() * f3), Bitmap.Config.ARGB_4444);
        createBitmap.eraseColor(-1);
        C.draw(new Canvas(createBitmap));
        return createBitmap;
    }

    public static void z(Context context) {
        if (f42727b == null) {
            Application c2 = d.a.h0.a.w0.a.c();
            if (c2 != null) {
                context = c2;
            }
            if (context == null) {
                return;
            }
            f42727b = context.getResources().getDisplayMetrics();
        }
    }
}
