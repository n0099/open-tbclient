package d.b.g0.a.i2;

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
import d.b.g0.a.u0.d;
import d.b.g0.a.y0.e.b;
import java.io.File;
/* loaded from: classes3.dex */
public class h0 {

    /* renamed from: a  reason: collision with root package name */
    public static final boolean f44686a = d.b.g0.a.k.f45050a;

    /* renamed from: b  reason: collision with root package name */
    public static DisplayMetrics f44687b;

    /* renamed from: c  reason: collision with root package name */
    public static final DisplayMetrics f44688c;

    /* renamed from: d  reason: collision with root package name */
    public static final float f44689d;

    static {
        DisplayMetrics displayMetrics = d.b.g0.a.w0.a.c().getResources().getDisplayMetrics();
        f44688c = displayMetrics;
        f44689d = displayMetrics.density;
    }

    public static boolean A(Context context) {
        return Build.VERSION.SDK_INT >= 24 && (context instanceof Activity) && ((Activity) context).isInMultiWindowMode();
    }

    public static boolean B(@NonNull d.b.g0.a.r1.n.c cVar, Context context) {
        return d.b.g0.a.j2.c.b.i && (TextUtils.equals(cVar.j, "custom") || !c0.e(context));
    }

    public static boolean C() {
        return d.b.g0.a.w0.a.c().getResources().getConfiguration().orientation == 2;
    }

    public static boolean D(Activity activity) {
        if (activity == null) {
            return false;
        }
        Display defaultDisplay = activity.getWindowManager().getDefaultDisplay();
        return defaultDisplay.getRotation() == 1 || defaultDisplay.getRotation() == 3;
    }

    public static boolean E() {
        return d.b.g0.a.w0.a.c().getResources().getConfiguration().orientation == 1;
    }

    public static void F(BdBaseImageView bdBaseImageView, TextView textView, String str) {
        if ("0".equals(str)) {
            bdBaseImageView.setVisibility(8);
            textView.setVisibility(8);
        } else if ("1".equals(String.valueOf(str))) {
            bdBaseImageView.setVisibility(0);
            textView.setVisibility(0);
            textView.setText(d.b.g0.a.h.aiapps_history_aiapp_tag);
        } else if ("2".equals(String.valueOf(str))) {
            bdBaseImageView.setVisibility(0);
            textView.setVisibility(0);
            textView.setText(d.b.g0.a.h.aiapps_history_aiapp_tag_trial);
        } else if ("3".equals(String.valueOf(str))) {
            bdBaseImageView.setVisibility(0);
            textView.setVisibility(0);
            textView.setText(d.b.g0.a.h.aiapps_history_aiapp_tag_experience);
        }
    }

    public static int G(Context context, float f2) {
        return (int) (f2 / j(context));
    }

    public static int H(float f2) {
        return G(d.b.g0.a.w0.a.c(), f2);
    }

    public static float I(float f2) {
        return f2 / j(d.b.g0.a.w0.a.c());
    }

    public static void a(Activity activity) {
        if (activity == null || !d.b.g0.a.j2.c.b.i) {
            return;
        }
        new d.b.g0.a.j2.c.b(activity).n(-1, false, true, true);
    }

    public static void b(Activity activity) {
        if (activity == null || !d.b.g0.a.j2.c.b.i) {
            return;
        }
        new d.b.g0.a.j2.c.b(activity).n(-1, true, false, true);
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
    public static int c(int i, String str) {
        int i2;
        int i3;
        int i4;
        boolean z;
        boolean z2;
        boolean z3;
        boolean z4;
        Context appContext = AppRuntime.getAppContext();
        try {
            i2 = s();
            try {
                i3 = appContext.getResources().getDimensionPixelSize(d.b.g0.a.d.aiapps_normal_base_action_bar_height);
                try {
                    i4 = appContext.getResources().getDimensionPixelSize(d.b.g0.a.d.aiapps_bottom_tab_height);
                    try {
                        i4 += appContext.getResources().getDimensionPixelSize(d.b.g0.a.d.aiapps_bottom_tab_shadow_height);
                    } catch (Resources.NotFoundException e2) {
                        e = e2;
                        if (f44686a) {
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
                        if (f44686a) {
                        }
                        return Math.max(r9, 0);
                    }
                } catch (Resources.NotFoundException e3) {
                    e = e3;
                    i4 = 0;
                    if (f44686a) {
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
                    if (f44686a) {
                    }
                    return Math.max(r9, 0);
                }
            } catch (Resources.NotFoundException e4) {
                e = e4;
                i3 = 0;
                i4 = 0;
                if (f44686a) {
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
                if (f44686a) {
                }
                return Math.max(r9, 0);
            }
        } catch (Resources.NotFoundException e5) {
            e = e5;
            i2 = 0;
        }
        if (TextUtils.isEmpty(str)) {
            String b2 = d.b.g0.a.t1.k.p0.j.b(i0.d(str));
            SwanAppConfigData I = d.b.g0.a.z0.f.V().I();
            b.a L = d.b.g0.a.r1.e.y().L();
            d.b.g0.a.r1.n.c i5 = d.b.g0.a.z0.f.V().i(b2, I, d.e.h(L.G(), L.n1()).getPath() + File.separator);
            if (d.b.g0.a.r1.n.c.f(i5)) {
                z3 = true;
                z4 = B(i5, appContext);
            } else {
                z3 = false;
                z4 = false;
            }
            z = k0.B(b2);
            z2 = i5.f45775f;
        } else {
            z = false;
            z2 = false;
            z3 = false;
            z4 = false;
        }
        int i6 = !z ? i - i4 : i;
        if (!z3) {
            i6 -= i3;
        }
        if (!z4) {
            i6 -= i2;
        }
        if (z2) {
            i6 -= f(50.0f);
        }
        if (f44686a) {
            int b3 = c0.b(appContext);
            int c2 = d0.c();
            Log.d("SwanAppUIUtils", "screenHeight:" + i + ",notchHeight:" + b3 + ",navHeight:" + c2 + ",preGuessWebViewHeight:" + i6 + ",pageUrl:" + str + ",hasTab:" + z + ",bottomBarHeight:" + i4 + ",isTransparentBar:" + z3 + ",actionBarHeight:" + i3 + ",isOccupyStatusBar:" + z4 + ",statusBarHeight:" + i2 + ",canPullToRefresh:" + z2);
        }
        return Math.max(i6, 0);
    }

    public static Pair<Integer, Integer> d(String str) {
        Pair<Integer, Integer> c2;
        long currentTimeMillis = f44686a ? System.currentTimeMillis() : 0L;
        if (d.b.g0.a.r1.d.e().n() == null) {
            c2 = d0.b();
        } else {
            c2 = d.b.g0.a.z0.f.V().c();
        }
        int intValue = ((Integer) c2.first).intValue();
        int c3 = c(((Integer) c2.second).intValue(), str);
        if (f44686a) {
            Log.d("SwanAppUIUtils", "preGuessWebViewSize cost - " + (System.currentTimeMillis() - currentTimeMillis) + "ms");
        }
        return new Pair<>(Integer.valueOf(intValue), Integer.valueOf(c3));
    }

    public static int e(Context context, float f2) {
        return (int) (f2 * j(context));
    }

    public static int f(float f2) {
        return e(d.b.g0.a.w0.a.c(), f2);
    }

    public static float g(float f2) {
        return f2 * j(d.b.g0.a.w0.a.c());
    }

    public static int h() {
        return d.b.g0.a.w0.a.c().getResources().getDimensionPixelSize(d.b.g0.a.d.aiapps_normal_base_action_bar_height);
    }

    public static int i(Context context) {
        d.b.g0.a.e0.l.c m;
        d.b.g0.a.e0.l.f W = d.b.g0.a.z0.f.V().W();
        int i = 0;
        if (context == null || W == null || (m = W.m()) == null || !(m instanceof d.b.g0.a.e0.l.e) || !((d.b.g0.a.e0.l.e) m).V1()) {
            return 0;
        }
        try {
            i = context.getResources().getDimensionPixelSize(d.b.g0.a.d.aiapps_bottom_tab_height);
            int dimensionPixelSize = context.getResources().getDimensionPixelSize(d.b.g0.a.d.aiapps_bottom_tab_shadow_height);
            return dimensionPixelSize > 0 ? i + dimensionPixelSize : i;
        } catch (Resources.NotFoundException e2) {
            if (f44686a) {
                e2.printStackTrace();
                return i;
            }
            return i;
        }
    }

    public static float j(Context context) {
        z(d.b.g0.a.w0.a.c());
        DisplayMetrics displayMetrics = f44687b;
        if (displayMetrics != null) {
            return displayMetrics.density;
        }
        return 0.0f;
    }

    public static int k(Context context) {
        z(d.b.g0.a.w0.a.c());
        DisplayMetrics displayMetrics = f44687b;
        if (displayMetrics != null) {
            return displayMetrics.densityDpi;
        }
        return 0;
    }

    public static int l(Context context) {
        z(d.b.g0.a.w0.a.c());
        DisplayMetrics displayMetrics = f44687b;
        if (displayMetrics != null) {
            return displayMetrics.heightPixels;
        }
        return 0;
    }

    public static int m(@Nullable Context context) {
        z(d.b.g0.a.w0.a.c());
        DisplayMetrics displayMetrics = f44687b;
        if (displayMetrics != null) {
            return displayMetrics.widthPixels;
        }
        return 0;
    }

    public static Bitmap n() {
        return o(d.b.g0.a.z0.f.V().getActivity());
    }

    public static Bitmap o(Activity activity) {
        if (activity == null) {
            return null;
        }
        View findViewById = activity.findViewById(16908290);
        Bitmap bitmap = null;
        for (int i = 1; i < 3; i++) {
            try {
                findViewById.setDrawingCacheEnabled(true);
                Bitmap drawingCache = findViewById.getDrawingCache();
                if (drawingCache != null) {
                    bitmap = Bitmap.createScaledBitmap(drawingCache, drawingCache.getWidth() / i, drawingCache.getHeight() / i, false);
                }
                findViewById.setDrawingCacheEnabled(false);
            } catch (NullPointerException | OutOfMemoryError e2) {
                if (f44686a) {
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
        boolean hasPermanentMenuKey = ViewConfiguration.get(d.b.g0.a.w0.a.c()).hasPermanentMenuKey();
        boolean deviceHasKey = KeyCharacterMap.deviceHasKey(4);
        if (hasPermanentMenuKey || deviceHasKey) {
            return 0;
        }
        Resources resources = d.b.g0.a.w0.a.c().getResources();
        return resources.getDimensionPixelSize(resources.getIdentifier("navigation_bar_height", "dimen", "android"));
    }

    public static int r(Context context) {
        return !A(context) ? D((Activity) context) ? l(context) : m(context) : C() ? l(context) : m(context);
    }

    public static int s() {
        int identifier = d.b.g0.a.w0.a.c().getResources().getIdentifier("status_bar_height", "dimen", "android");
        int i = 0;
        if (identifier > 0) {
            try {
                i = d.b.g0.a.w0.a.c().getResources().getDimensionPixelSize(identifier);
            } catch (Exception unused) {
            }
        }
        return i == 0 ? (int) (f44689d * 25.0f) : i;
    }

    public static int t(Context context) {
        int i;
        boolean z;
        if (context == null) {
            return 0;
        }
        int l = l(context);
        int s = s();
        int i2 = i(context);
        try {
            i = context.getResources().getDimensionPixelSize(d.b.g0.a.d.aiapps_normal_base_action_bar_height);
        } catch (Resources.NotFoundException e2) {
            if (f44686a) {
                e2.printStackTrace();
            }
            i = 0;
        }
        d.b.g0.a.e0.l.f W = d.b.g0.a.z0.f.V().W();
        d.b.g0.a.e0.l.e eVar = null;
        if (W != null) {
            d.b.g0.a.e0.l.c m = W.m();
            if (m instanceof d.b.g0.a.e0.l.e) {
                eVar = (d.b.g0.a.e0.l.e) m;
            }
        }
        boolean z2 = true;
        if (eVar == null || !d.b.g0.a.r1.n.c.f(eVar.y1())) {
            z2 = false;
            z = false;
        } else {
            d.b.g0.a.j2.c.b B1 = eVar.B1();
            z2 = (B1 == null || !B1.i()) ? false : false;
            z = true;
        }
        int i3 = l - i2;
        if (!z2) {
            i3 -= s;
        }
        if (!z) {
            i3 -= i;
        }
        if (i3 > 0) {
            return i3;
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
    public static Bitmap w(View view, int i, int i2) {
        if (view == null) {
            return null;
        }
        Bitmap createBitmap = Bitmap.createBitmap(i, i2, Bitmap.Config.ARGB_4444);
        view.draw(new Canvas(createBitmap));
        return createBitmap;
    }

    @UiThread
    public static Bitmap x() {
        return y(1.0f, 1.0f);
    }

    @UiThread
    public static Bitmap y(float f2, float f3) {
        d.b.g0.a.z0.f V = d.b.g0.a.z0.f.V();
        AbsoluteLayout m = V.m(V.p());
        if (m == null || m.getWidth() <= 0 || m.getHeight() <= 0) {
            return null;
        }
        Bitmap createBitmap = Bitmap.createBitmap((int) (m.getWidth() * f2), (int) (m.getHeight() * f3), Bitmap.Config.ARGB_4444);
        createBitmap.eraseColor(-1);
        m.draw(new Canvas(createBitmap));
        return createBitmap;
    }

    public static void z(Context context) {
        if (f44687b == null) {
            Application c2 = d.b.g0.a.w0.a.c();
            if (c2 != null) {
                context = c2;
            }
            if (context == null) {
                return;
            }
            f44687b = context.getResources().getDisplayMetrics();
        }
    }
}
