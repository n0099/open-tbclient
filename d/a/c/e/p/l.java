package d.a.c.e.p;

import android.app.Activity;
import android.app.ActivityManager;
import android.content.Context;
import android.content.pm.PackageInfo;
import android.graphics.Paint;
import android.graphics.Rect;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import android.text.TextPaint;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.TouchDelegate;
import android.view.View;
import android.view.WindowManager;
import android.view.inputmethod.InputMethodManager;
import android.widget.Toast;
import com.baidu.adp.base.BdBaseApplication;
import com.baidu.adp.lib.util.BdLog;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.lang.reflect.Field;
import java.util.List;
import java.util.regex.Pattern;
/* loaded from: classes.dex */
public class l {

    /* renamed from: a  reason: collision with root package name */
    public static boolean f39967a = false;

    /* renamed from: b  reason: collision with root package name */
    public static float f39968b;

    /* renamed from: c  reason: collision with root package name */
    public static int f39969c;

    /* renamed from: d  reason: collision with root package name */
    public static int f39970d;

    /* renamed from: e  reason: collision with root package name */
    public static Toast f39971e;

    /* renamed from: f  reason: collision with root package name */
    public static c f39972f;

    /* renamed from: g  reason: collision with root package name */
    public static String f39973g;

    /* renamed from: h  reason: collision with root package name */
    public static Handler f39974h = new Handler(Looper.getMainLooper());

    /* renamed from: i  reason: collision with root package name */
    public static Runnable f39975i = new a();

    /* loaded from: classes.dex */
    public static class a implements Runnable {
        @Override // java.lang.Runnable
        public void run() {
            if (l.f39971e != null) {
                l.f39971e.cancel();
            }
        }
    }

    /* loaded from: classes.dex */
    public static class b implements Runnable {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ View f39976e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ int f39977f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ int f39978g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ int f39979h;

        /* renamed from: i  reason: collision with root package name */
        public final /* synthetic */ int f39980i;
        public final /* synthetic */ View j;

        public b(View view, int i2, int i3, int i4, int i5, View view2) {
            this.f39976e = view;
            this.f39977f = i2;
            this.f39978g = i3;
            this.f39979h = i4;
            this.f39980i = i5;
            this.j = view2;
        }

        @Override // java.lang.Runnable
        public void run() {
            Rect rect = new Rect();
            this.f39976e.getHitRect(rect);
            rect.right += this.f39977f;
            rect.left -= this.f39978g;
            rect.bottom += this.f39979h;
            rect.top -= this.f39980i;
            this.j.setTouchDelegate(new TouchDelegate(rect, this.f39976e));
        }
    }

    /* loaded from: classes.dex */
    public interface c {
        void a();

        void b(String str);

        View c();
    }

    public static boolean A() {
        String o;
        String str = Build.DISPLAY;
        if (str != null && str.contains("Flyme") && (o = o(str)) != null && o.length() >= 3) {
            int d2 = d.a.c.e.m.b.d(o(o.substring(0, 1)), 0);
            int d3 = d.a.c.e.m.b.d(o(o.substring(1, 2)), 0);
            if (d2 > 3 || (d2 == 3 && d3 >= 5)) {
                return true;
            }
        }
        return false;
    }

    public static boolean B(byte[] bArr) {
        return bArr != null && bArr.length >= 3 && bArr[0] == 71 && bArr[1] == 73 && bArr[2] == 70;
    }

    public static boolean C() {
        return Looper.getMainLooper() == Looper.myLooper() && Looper.getMainLooper().getThread() == Thread.currentThread();
    }

    public static boolean D() {
        return j.z();
    }

    public static Rect E(Paint paint, String str) {
        Rect rect = new Rect();
        paint.getTextBounds(str, 0, str.length(), rect);
        return rect;
    }

    public static float F(Paint paint, String str) {
        if (paint == null || str == null) {
            return 0.0f;
        }
        return paint.measureText(str);
    }

    public static double G(double d2) {
        return (d2 * 3.141592653589793d) / 180.0d;
    }

    public static void H(c cVar) {
        f39972f = cVar;
    }

    public static void I(Context context, int i2) {
        J(context, context.getResources().getString(i2));
    }

    public static void J(Context context, String str) {
        N(context, str, 3500);
    }

    public static void K(Context context, View view) {
        try {
            ((InputMethodManager) context.getSystemService("input_method")).showSoftInput(view, 0);
        } catch (Throwable th) {
            BdLog.e(th.getMessage());
        }
    }

    public static void L(Context context, int i2) {
        M(context, context.getResources().getString(i2));
    }

    public static void M(Context context, String str) {
        N(context, str, 2000);
    }

    public static void N(Context context, String str, int i2) {
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str)) {
            return;
        }
        f39974h.removeCallbacks(f39975i);
        if (f39971e != null && Build.VERSION.SDK_INT < 28) {
            c cVar = f39972f;
            if (cVar != null) {
                cVar.a();
            }
            if (!str.equals(f39973g)) {
                c cVar2 = f39972f;
                if (cVar2 != null && cVar2.c() != null) {
                    f39972f.b(str);
                    f39971e.setView(f39972f.c());
                } else {
                    f39971e.setText(str);
                }
            }
            int e2 = e(BdBaseApplication.getInst().getApp(), 100.0f);
            if (BdBaseApplication.getInst().getApp().getResources().getConfiguration().orientation == 2) {
                e2 = 0;
            }
            if (i2 == 3500) {
                f39971e.setDuration(1);
            } else {
                f39971e.setDuration(0);
            }
            f39971e.setGravity(17, 0, e2);
        } else {
            Toast toast = f39971e;
            if (toast != null) {
                toast.cancel();
            }
            c cVar3 = f39972f;
            if (cVar3 != null) {
                cVar3.a();
            }
            c cVar4 = f39972f;
            if (cVar4 != null && cVar4.c() != null) {
                Toast toast2 = new Toast(BdBaseApplication.getInst().getApp());
                f39971e = toast2;
                u.a(toast2);
                if (i2 == 3500) {
                    f39971e.setDuration(1);
                } else {
                    f39971e.setDuration(0);
                }
                f39972f.b(str);
                f39971e.setView(f39972f.c());
            } else {
                if (i2 == 3500) {
                    Toast makeText = Toast.makeText(BdBaseApplication.getInst().getApp(), str, 1);
                    f39971e = makeText;
                    u.a(makeText);
                } else {
                    Toast makeText2 = Toast.makeText(BdBaseApplication.getInst().getApp(), str, 0);
                    f39971e = makeText2;
                    u.a(makeText2);
                }
                f39971e.setText(str);
            }
            f39971e.setGravity(17, 0, e(BdBaseApplication.getInst().getApp(), 100.0f));
        }
        f39973g = str;
        f39974h.postDelayed(f39975i, i2);
        f39971e.show();
    }

    public static double a(double d2, double d3, double d4, double d5) {
        double G = G(d2);
        double G2 = G(d4);
        return Math.round(((Math.asin(Math.sqrt(Math.pow(Math.sin((G - G2) / 2.0d), 2.0d) + ((Math.cos(G) * Math.cos(G2)) * Math.pow(Math.sin((G(d3) - G(d5)) / 2.0d), 2.0d)))) * 2.0d) * 6378.137d) * 10000.0d) / 10000.0d;
    }

    public static void c(Context context, View view, int i2, int i3, int i4, int i5) {
        int e2 = e(context, i2);
        int e3 = e(context, i3);
        int e4 = e(context, i4);
        int e5 = e(context, i5);
        View view2 = (View) view.getParent();
        view2.post(new b(view, e4, e2, e5, e3, view2));
    }

    public static void d() {
        if (BdBaseApplication.getInst().isDebugMode()) {
            if (!C()) {
                StringBuilder sb = new StringBuilder(100);
                StackTraceElement[] stackTrace = Thread.currentThread().getStackTrace();
                for (int i2 = 1; i2 < stackTrace.length; i2++) {
                    sb.append(stackTrace[i2].getClassName());
                    sb.append(".");
                    sb.append(stackTrace[i2].getMethodName());
                    sb.append("  lines = ");
                    sb.append(stackTrace[i2].getLineNumber());
                    sb.append("\n");
                }
                BdLog.e("can not be call not thread! trace = \n" + sb.toString());
                throw new Error("can not be call not thread! trace = " + sb.toString());
            }
        }
    }

    public static int e(Context context, float f2) {
        if (!f39967a) {
            y(context);
        }
        return (int) ((f2 * f39968b) + 0.5f);
    }

    public static Field f(Object obj, String str) {
        for (Class<?> cls = obj.getClass(); cls != Object.class; cls = cls.getSuperclass()) {
            try {
                Field declaredField = cls.getDeclaredField(str);
                declaredField.setAccessible(true);
                return declaredField;
            } catch (Exception unused) {
            }
        }
        return null;
    }

    public static int g(Context context, int i2) {
        return context.getResources().getDimensionPixelSize(i2);
    }

    public static float h(Context context) {
        if (!f39967a) {
            y(context);
        }
        return f39968b;
    }

    public static int i(Context context) {
        if (!f39967a) {
            y(context);
        }
        return f39970d;
    }

    public static int j(Context context, boolean z) {
        if (!f39967a || z) {
            y(context);
        }
        return f39970d;
    }

    public static int k(Context context) {
        if (!f39967a) {
            y(context);
        }
        return f39969c;
    }

    public static int[] l(int i2, int i3, int i4, int i5) {
        if (i2 <= 0 || i3 <= 0 || i4 <= 0 || i5 <= 0) {
            return null;
        }
        int[] iArr = new int[2];
        if (i3 > i5) {
            i2 = (i2 * i5) / i3;
            i3 = i5;
        }
        if (i2 > i4) {
            i3 = (i3 * i4) / i2;
        } else {
            i4 = i2;
        }
        iArr[0] = i4;
        iArr[1] = i3;
        return iArr;
    }

    public static String m() {
        Throwable th;
        BufferedReader bufferedReader;
        try {
            try {
                bufferedReader = new BufferedReader(new InputStreamReader(Runtime.getRuntime().exec("getprop net.dns1").getInputStream()));
                try {
                    String readLine = bufferedReader.readLine();
                    m.g(bufferedReader);
                    return readLine;
                } catch (Exception e2) {
                    e = e2;
                    BdLog.e(e.getMessage());
                    m.g(bufferedReader);
                    return null;
                }
            } catch (Throwable th2) {
                th = th2;
                m.g(null);
                throw th;
            }
        } catch (Exception e3) {
            e = e3;
            bufferedReader = null;
        } catch (Throwable th3) {
            th = th3;
            m.g(null);
            throw th;
        }
    }

    public static String n() {
        Throwable th;
        BufferedReader bufferedReader;
        try {
            try {
                bufferedReader = new BufferedReader(new InputStreamReader(Runtime.getRuntime().exec("getprop net.dns2").getInputStream()));
                try {
                    String readLine = bufferedReader.readLine();
                    m.g(bufferedReader);
                    return readLine;
                } catch (Exception e2) {
                    e = e2;
                    BdLog.e(e.getMessage());
                    m.g(bufferedReader);
                    return null;
                }
            } catch (Throwable th2) {
                th = th2;
                m.g(null);
                throw th;
            }
        } catch (Exception e3) {
            e = e3;
            bufferedReader = null;
        } catch (Throwable th3) {
            th = th3;
            m.g(null);
            throw th;
        }
    }

    public static String o(String str) {
        if (str == null) {
            return null;
        }
        return Pattern.compile("[^0-9]").matcher(str).replaceAll("").trim();
    }

    public static int[] p(Context context) {
        int[] iArr = new int[2];
        if (context == null) {
            return iArr;
        }
        Display defaultDisplay = ((WindowManager) context.getSystemService("window")).getDefaultDisplay();
        iArr[0] = defaultDisplay.getWidth();
        iArr[1] = defaultDisplay.getHeight();
        return iArr;
    }

    public static DisplayMetrics q(Activity activity) {
        DisplayMetrics displayMetrics;
        DisplayMetrics displayMetrics2 = null;
        try {
            displayMetrics = new DisplayMetrics();
        } catch (Exception e2) {
            e = e2;
        }
        try {
            activity.getWindowManager().getDefaultDisplay().getMetrics(displayMetrics);
            return displayMetrics;
        } catch (Exception e3) {
            e = e3;
            displayMetrics2 = displayMetrics;
            BdLog.e(e.toString());
            return displayMetrics2;
        }
    }

    public static int r(Activity activity) {
        Rect rect = new Rect();
        activity.getWindow().getDecorView().getWindowVisibleDisplayFrame(rect);
        int i2 = rect.top;
        if (i2 == 0) {
            try {
                Class<?> cls = Class.forName("com.android.internal.R$dimen");
                return activity.getResources().getDimensionPixelSize(Integer.parseInt(cls.getField("status_bar_height").get(cls.newInstance()).toString()));
            } catch (ClassNotFoundException e2) {
                e2.printStackTrace();
                return i2;
            } catch (IllegalAccessException e3) {
                e3.printStackTrace();
                return i2;
            } catch (IllegalArgumentException e4) {
                e4.printStackTrace();
                return i2;
            } catch (InstantiationException e5) {
                e5.printStackTrace();
                return i2;
            } catch (NoSuchFieldException e6) {
                e6.printStackTrace();
                return i2;
            } catch (NumberFormatException e7) {
                e7.printStackTrace();
                return i2;
            } catch (SecurityException e8) {
                e8.printStackTrace();
                return i2;
            }
        }
        return i2;
    }

    public static String s(TextPaint textPaint, String str, int i2) {
        CharSequence ellipsize = TextUtils.ellipsize(str, textPaint, i2, TextUtils.TruncateAt.END);
        if (ellipsize != null) {
            return ellipsize.toString();
        }
        return null;
    }

    public static int t(Paint paint, String str) {
        if (str == null || str.length() <= 0) {
            return 0;
        }
        int length = str.length();
        float[] fArr = new float[length];
        paint.getTextWidths(str, fArr);
        int i2 = 0;
        for (int i3 = 0; i3 < length; i3++) {
            i2 += (int) Math.ceil(fArr[i3]);
        }
        return i2;
    }

    public static c u() {
        return f39972f;
    }

    public static String v() {
        ActivityManager activityManager;
        List<ActivityManager.RunningTaskInfo> runningTasks;
        try {
            if (BdBaseApplication.getInst() == null || (activityManager = (ActivityManager) BdBaseApplication.getInst().getSystemService("activity")) == null || (runningTasks = activityManager.getRunningTasks(1)) == null || runningTasks.size() <= 0) {
                return null;
            }
            for (ActivityManager.RunningTaskInfo runningTaskInfo : runningTasks) {
                if (runningTaskInfo != null && runningTaskInfo.topActivity != null) {
                    return runningTaskInfo.topActivity.getClassName();
                }
            }
            return null;
        } catch (Exception unused) {
            return null;
        }
    }

    public static boolean w(Context context, String str) {
        List<PackageInfo> installedPackages;
        if (str != null && str.length() != 0 && (installedPackages = context.getPackageManager().getInstalledPackages(0)) != null) {
            for (int i2 = 0; i2 < installedPackages.size(); i2++) {
                if (installedPackages.get(i2).packageName.equals(str)) {
                    return true;
                }
            }
        }
        return false;
    }

    public static void x(Context context, View view) {
        if (view == null) {
            return;
        }
        try {
            if (view.getWindowToken() == null) {
                return;
            }
            ((InputMethodManager) context.getSystemService("input_method")).hideSoftInputFromWindow(view.getWindowToken(), 2);
        } catch (Throwable th) {
            BdLog.e(th.getMessage());
        }
    }

    public static void y(Context context) {
        DisplayMetrics displayMetrics = new DisplayMetrics();
        WindowManager windowManager = (WindowManager) context.getSystemService("window");
        windowManager.getDefaultDisplay().getMetrics(displayMetrics);
        int orientation = windowManager.getDefaultDisplay().getOrientation();
        if (orientation != 1 && orientation != 3) {
            f39969c = displayMetrics.widthPixels;
            f39970d = displayMetrics.heightPixels;
        } else {
            f39969c = displayMetrics.heightPixels;
            f39970d = displayMetrics.widthPixels;
        }
        f39968b = displayMetrics.density;
        f39967a = true;
    }

    public static boolean z(byte[] bArr) {
        if (bArr == null) {
            return false;
        }
        try {
            String str = new String(bArr, 0, 16, "UTF-8");
            if (str.indexOf(com.baidu.wallet.base.audio.b.f23938e) == 0) {
                return 8 == str.indexOf("WEBPVP8 ");
            }
            return false;
        } catch (Exception unused) {
            return false;
        }
    }
}
