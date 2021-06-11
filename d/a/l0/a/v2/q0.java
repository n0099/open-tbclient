package d.a.l0.a.v2;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.location.LocationManager;
import android.net.Uri;
import android.net.wifi.WifiManager;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import android.util.Log;
import android.webkit.MimeTypeMap;
import android.widget.AbsoluteLayout;
import android.widget.ImageView;
import androidx.annotation.AnyThread;
import androidx.annotation.DrawableRes;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.app.NotificationManagerCompat;
import androidx.core.content.ContextCompat;
import com.alibaba.fastjson.asm.Label;
import com.baidu.down.request.db.DownloadDataConstants;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.searchbox.unitedscheme.SchemeConfig;
import com.baidu.swan.apps.SwanAppActivity;
import com.baidu.swan.apps.runtime.config.SwanAppConfigData;
import com.baidu.swan.pms.PMSConstants;
import com.baidu.swan.pms.model.PMSAppInfo;
import com.facebook.common.executors.UiThreadImmediateExecutorService;
import com.facebook.common.references.CloseableReference;
import com.facebook.datasource.DataSource;
import com.facebook.drawee.backends.pipeline.Fresco;
import com.facebook.imagepipeline.datasource.BaseBitmapDataSubscriber;
import com.facebook.imagepipeline.image.CloseableImage;
import com.facebook.imagepipeline.request.ImageRequestBuilder;
import d.a.l0.a.h0.g.k;
import d.a.l0.a.v2.t;
import d.a.l0.a.z1.b.b.h;
import java.io.File;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.net.URISyntaxException;
import java.net.URLEncoder;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public final class q0 {

    /* renamed from: a  reason: collision with root package name */
    public static final boolean f49121a = d.a.l0.a.k.f46875a;

    /* renamed from: b  reason: collision with root package name */
    public static Handler f49122b = new Handler(Looper.getMainLooper());

    /* renamed from: c  reason: collision with root package name */
    public static String f49123c;

    /* loaded from: classes3.dex */
    public static class a implements Runnable {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ ImageView f49124e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ int f49125f;

        public a(ImageView imageView, int i2) {
            this.f49124e = imageView;
            this.f49125f = i2;
        }

        @Override // java.lang.Runnable
        public void run() {
            this.f49124e.setImageResource(this.f49125f);
        }
    }

    /* loaded from: classes3.dex */
    public static class b implements d.a.l0.d.i.a<Bitmap> {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ ImageView f49126a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ int f49127b;

        /* loaded from: classes3.dex */
        public class a implements Runnable {

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ Bitmap f49128e;

            public a(Bitmap bitmap) {
                this.f49128e = bitmap;
            }

            @Override // java.lang.Runnable
            public void run() {
                b.this.f49126a.setImageBitmap(this.f49128e);
            }
        }

        /* renamed from: d.a.l0.a.v2.q0$b$b  reason: collision with other inner class name */
        /* loaded from: classes3.dex */
        public class RunnableC0943b implements Runnable {
            public RunnableC0943b() {
            }

            @Override // java.lang.Runnable
            public void run() {
                b bVar = b.this;
                bVar.f49126a.setImageResource(bVar.f49127b);
            }
        }

        public b(ImageView imageView, int i2) {
            this.f49126a = imageView;
            this.f49127b = i2;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.a.l0.d.i.a
        /* renamed from: b */
        public void a(Bitmap bitmap) {
            if (bitmap != null) {
                if (Looper.getMainLooper() == Looper.myLooper()) {
                    this.f49126a.setImageBitmap(bitmap);
                    return;
                } else {
                    q0.b0(new a(bitmap));
                    return;
                }
            }
            q0.b0(new RunnableC0943b());
        }
    }

    /* loaded from: classes3.dex */
    public static class c implements t.b {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ d.a.l0.d.i.a f49131a;

        public c(d.a.l0.d.i.a aVar) {
            this.f49131a = aVar;
        }

        @Override // d.a.l0.a.v2.t.b
        public void a(String str, Bitmap bitmap) {
            this.f49131a.a(bitmap);
        }
    }

    /* loaded from: classes3.dex */
    public static class d extends BaseBitmapDataSubscriber {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ t.b f49132a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ String f49133b;

        public d(t.b bVar, String str) {
            this.f49132a = bVar;
            this.f49133b = str;
        }

        @Override // com.facebook.datasource.BaseDataSubscriber, com.facebook.datasource.DataSubscriber
        public void onCancellation(DataSource<CloseableReference<CloseableImage>> dataSource) {
            super.onCancellation(dataSource);
            this.f49132a.a(this.f49133b, null);
        }

        @Override // com.facebook.datasource.BaseDataSubscriber
        public void onFailureImpl(DataSource<CloseableReference<CloseableImage>> dataSource) {
            this.f49132a.a(this.f49133b, null);
        }

        @Override // com.facebook.imagepipeline.datasource.BaseBitmapDataSubscriber
        public void onNewResultImpl(Bitmap bitmap) {
            Bitmap copy;
            if (bitmap != null && !bitmap.isRecycled()) {
                try {
                    if (bitmap.getConfig() == null) {
                        copy = bitmap.copy(Bitmap.Config.ARGB_8888, true);
                    } else {
                        copy = bitmap.copy(bitmap.getConfig(), true);
                    }
                    this.f49132a.a(this.f49133b, copy);
                    return;
                } catch (Exception unused) {
                    this.f49132a.a(this.f49133b, null);
                    return;
                }
            }
            this.f49132a.a(this.f49133b, null);
        }
    }

    /* loaded from: classes3.dex */
    public static class e implements DialogInterface.OnClickListener {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ Context f49134e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ Intent f49135f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ g f49136g;

        public e(Context context, Intent intent, g gVar) {
            this.f49134e = context;
            this.f49135f = intent;
            this.f49136g = gVar;
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i2) {
            boolean g2 = d.a.l0.a.v2.f.g(this.f49134e, this.f49135f);
            g gVar = this.f49136g;
            if (gVar != null) {
                gVar.a(g2);
            }
        }
    }

    /* loaded from: classes3.dex */
    public static class f implements DialogInterface.OnClickListener {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ g f49137e;

        public f(g gVar) {
            this.f49137e = gVar;
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i2) {
            g gVar = this.f49137e;
            if (gVar != null) {
                gVar.onCancel();
            }
        }
    }

    /* loaded from: classes3.dex */
    public interface g {
        void a(boolean z);

        void onCancel();
    }

    public static Uri A(String str) {
        if (TextUtils.isEmpty(str) || !str.startsWith("tel:")) {
            return null;
        }
        return Uri.parse(str);
    }

    public static String B() {
        d.a.l0.a.h0.g.f J = d.a.l0.a.g1.f.V().J();
        if (J != null) {
            return J.g3();
        }
        return null;
    }

    public static Uri C(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        if (!str.startsWith("http://") && !str.startsWith("https://") && !str.startsWith("file://") && !str.startsWith("res:/")) {
            if (str.startsWith("/")) {
                return Uri.fromFile(new File(str));
            }
            return null;
        }
        return Uri.parse(str);
    }

    public static String D() {
        try {
            Application b2 = d.a.l0.a.c1.a.b();
            return b2.getPackageManager().getPackageInfo(b2.getPackageName(), 0).versionName;
        } catch (PackageManager.NameNotFoundException e2) {
            e2.printStackTrace();
            return "";
        }
    }

    public static boolean E(String str) {
        SwanAppConfigData F;
        d.a.l0.a.a2.d g2 = d.a.l0.a.a2.d.g();
        if (g2.C() && (F = g2.r().F()) != null && F.m() && !TextUtils.isEmpty(str)) {
            return F.q(str);
        }
        return false;
    }

    public static boolean F(Context context, String str) {
        if (context != null && !TextUtils.isEmpty(str)) {
            try {
                if (context.getPackageManager().getPackageInfo(str, 0) != null) {
                    return true;
                }
            } catch (PackageManager.NameNotFoundException unused) {
                if (f49121a) {
                    Log.e("SwanAppUtils", str + " is not found");
                }
            }
        }
        return false;
    }

    public static boolean G() {
        d.a.l0.a.p.d.x0 m = d.a.l0.a.c1.a.m();
        return TextUtils.equals(m.getAppName(), m.getSchemeHeader());
    }

    public static boolean H() {
        return I(d.a.l0.a.g1.f.V().U());
    }

    public static boolean I(String str) {
        return !TextUtils.isEmpty(str) && TextUtils.equals(str, p());
    }

    public static boolean J(Activity activity) {
        try {
            Field declaredField = Activity.class.getDeclaredField("mActivityInfo");
            declaredField.setAccessible(true);
            Object obj = declaredField.get(activity);
            Method declaredMethod = ActivityInfo.class.getDeclaredMethod("isFixedOrientation", new Class[0]);
            declaredMethod.setAccessible(true);
            return ((Boolean) declaredMethod.invoke(obj, new Object[0])).booleanValue();
        } catch (IllegalAccessException | NoSuchFieldException | NoSuchMethodException | InvocationTargetException e2) {
            if (f49121a) {
                Log.e("SwanAppUtils", "isFixedOrientation reflect fail", e2);
                return false;
            }
            return false;
        }
    }

    public static boolean K(@NonNull Context context) {
        if (a0.j(context, "android.permission.ACCESS_FINE_LOCATION")) {
            try {
                LocationManager locationManager = (LocationManager) context.getApplicationContext().getSystemService("location");
                if (locationManager != null) {
                    return locationManager.isProviderEnabled("gps");
                }
            } catch (Exception e2) {
                if (f49121a) {
                    e2.printStackTrace();
                }
            }
            return false;
        }
        return false;
    }

    public static boolean L() {
        return Build.VERSION.SDK_INT < 23 || AppRuntime.getAppContext().checkSelfPermission("android.permission.ACCESS_FINE_LOCATION") == 0;
    }

    public static boolean M(@NonNull Context context) {
        return NotificationManagerCompat.from(context).areNotificationsEnabled();
    }

    public static boolean N() {
        return Looper.getMainLooper().getThread() == Thread.currentThread();
    }

    public static boolean O() {
        if (d.a.l0.a.a2.e.Q() == null) {
            return false;
        }
        PMSAppInfo f0 = d.a.l0.a.a2.e.Q().L().f0();
        return (f0 == null ? PMSConstants.PayProtected.NO_PAY_PROTECTED.type : f0.payProtected) == PMSConstants.PayProtected.PAY_PROTECTED.type;
    }

    public static boolean P() {
        if (d.a.l0.a.a2.e.Q() == null) {
            return false;
        }
        PMSAppInfo f0 = d.a.l0.a.a2.e.Q().L().f0();
        return (f0 == null ? PMSConstants.CustomerService.NO_CUSTOMER_SERVICE.type : f0.customerService) == PMSConstants.CustomerService.CUSTOMER_SERVICE.type;
    }

    public static boolean Q() {
        return j.e();
    }

    @SuppressLint({"PrivateApi"})
    public static boolean R(Activity activity) {
        try {
            Class<?> cls = Class.forName("com.android.internal.R$styleable");
            Field declaredField = cls.getDeclaredField("Window");
            declaredField.setAccessible(true);
            TypedArray obtainStyledAttributes = activity.obtainStyledAttributes((int[]) declaredField.get(null));
            Field declaredField2 = cls.getDeclaredField("Window_windowIsTranslucent");
            declaredField2.setAccessible(true);
            Field declaredField3 = cls.getDeclaredField("Window_windowSwipeToDismiss");
            declaredField3.setAccessible(true);
            Field declaredField4 = cls.getDeclaredField("Window_windowIsFloating");
            declaredField4.setAccessible(true);
            boolean z = obtainStyledAttributes.getBoolean(((Integer) declaredField2.get(null)).intValue(), false);
            boolean z2 = !obtainStyledAttributes.hasValue(((Integer) declaredField2.get(null)).intValue()) && obtainStyledAttributes.getBoolean(((Integer) declaredField3.get(null)).intValue(), false);
            boolean z3 = obtainStyledAttributes.getBoolean(((Integer) declaredField4.get(null)).intValue(), false);
            obtainStyledAttributes.recycle();
            return z3 || z || z2;
        } catch (ClassNotFoundException | IllegalAccessException | NoSuchFieldException e2) {
            if (f49121a) {
                Log.e("SwanAppUtils", "isTranslucentOrFloating reflect fail", e2);
            }
            return false;
        }
    }

    public static boolean S(@NonNull Context context) {
        WifiManager wifiManager = (WifiManager) context.getApplicationContext().getSystemService("wifi");
        if (wifiManager != null) {
            return wifiManager.isWifiEnabled();
        }
        return false;
    }

    public static boolean T(Context context, String str) {
        if (context == null || TextUtils.isEmpty(str)) {
            return false;
        }
        try {
            Intent parseUri = Intent.parseUri(Uri.decode(str), 1);
            parseUri.setFlags(Label.FORWARD_REFERENCE_TYPE_SHORT);
            if (parseUri.resolveActivityInfo(context.getPackageManager(), 65536) != null) {
                d.a.l0.a.v2.f.g(context, parseUri);
                return true;
            }
            return false;
        } catch (URISyntaxException e2) {
            if (f49121a) {
                Log.w("SwanAppUtils", Log.getStackTraceString(e2));
                return false;
            }
            return false;
        }
    }

    @AnyThread
    public static void U(@NonNull ImageView imageView, @Nullable String str, @DrawableRes int i2) {
        if (TextUtils.isEmpty(str)) {
            b0(new a(imageView, i2));
            return;
        }
        b bVar = new b(imageView, i2);
        bVar.a(k(str, str, false, new c(bVar)));
    }

    public static void V() {
        if (f49121a) {
            Log.d("SwanAppSlavePool", "onPreloadNextEnv()");
        }
        SwanAppActivity activity = d.a.l0.a.g1.f.V().getActivity();
        if (activity != null) {
            Bundle bundle = new Bundle();
            bundle.putString("bundle_key_preload_preload_scene", "2");
            activity.preloadNextSwanAppProcess(bundle);
            d.a.l0.a.h0.t.a.l(activity);
        }
    }

    public static boolean W(Context context, String str, g gVar) {
        String str2;
        if (context != null && !TextUtils.isEmpty(str)) {
            try {
                Intent parseUri = Intent.parseUri(str, 1);
                parseUri.setFlags(Label.FORWARD_REFERENCE_TYPE_SHORT);
                PackageManager packageManager = context.getPackageManager();
                ResolveInfo resolveActivity = packageManager.resolveActivity(parseUri, 65536);
                if (resolveActivity != null && resolveActivity.activityInfo != null) {
                    String charSequence = resolveActivity.match != 0 ? resolveActivity.activityInfo.applicationInfo.loadLabel(packageManager).toString() : "其他应用";
                    if (TextUtils.isEmpty(charSequence)) {
                        str2 = "";
                    } else {
                        str2 = context.getResources().getString(d.a.l0.a.h.swanapp_open_app_dialog_tips1) + charSequence;
                    }
                    String str3 = context.getResources().getString(d.a.l0.a.h.swanapp_open_app_dialog_tips) + packageManager.getPackageInfo(context.getPackageName(), 0).applicationInfo.loadLabel(packageManager).toString() + str2;
                    String string = context.getString(d.a.l0.a.h.aiapps_confirm);
                    String string2 = context.getString(d.a.l0.a.h.aiapps_cancel);
                    h.a aVar = new h.a(context);
                    aVar.f(true);
                    aVar.x(str3);
                    aVar.n(new d.a.l0.a.w2.h.a());
                    aVar.m(false);
                    aVar.P(string, new e(context, parseUri, gVar));
                    aVar.C(string2, new f(gVar));
                    aVar.X();
                    return true;
                }
                return false;
            } catch (PackageManager.NameNotFoundException | URISyntaxException e2) {
                if (f49121a) {
                    e2.printStackTrace();
                }
            }
        }
        return false;
    }

    public static void X(Runnable runnable) {
        Y(runnable, 0L);
    }

    public static void Y(Runnable runnable, long j) {
        f49122b.postDelayed(runnable, j);
    }

    public static int Z(Activity activity) {
        if (f49121a) {
            Log.d("ScreenOrientationCompat", "releaseFixedOrientation() called with: activity = [" + activity + "]");
        }
        int i2 = -1;
        if (Build.VERSION.SDK_INT != 26 || activity.getApplicationInfo().targetSdkVersion <= 26 || !R(activity) || !J(activity)) {
            return -1;
        }
        try {
            Field declaredField = Activity.class.getDeclaredField("mActivityInfo");
            declaredField.setAccessible(true);
            Object obj = declaredField.get(activity);
            Field declaredField2 = ActivityInfo.class.getDeclaredField("screenOrientation");
            declaredField2.setAccessible(true);
            int i3 = declaredField2.getInt(obj);
            if (i3 != -1) {
                try {
                    declaredField2.setInt(obj, -1);
                    if (f49121a) {
                        Log.d("ScreenOrientationCompat", "set " + activity.getComponentName() + " screenOrientation to UNSPECIFIED");
                    }
                } catch (IllegalAccessException | NoSuchFieldException e2) {
                    e = e2;
                    i2 = i3;
                    if (f49121a) {
                        Log.e("SwanAppUtils", "releaseFixedOrientation reflect fail", e);
                        return i2;
                    }
                    return i2;
                }
            }
            return i3;
        } catch (IllegalAccessException e3) {
            e = e3;
        } catch (NoSuchFieldException e4) {
            e = e4;
        }
    }

    @NonNull
    public static String a(String str, String str2, String str3) {
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            return "";
        }
        if (!str.endsWith(File.separator)) {
            str = str + File.separator;
        }
        String str4 = str + str2 + DownloadDataConstants.DEFAULT_DL_HTML_EXTENSION;
        if (f49121a) {
            Log.d("SwanAppUtils", "buildPageUrl pageUrl: " + str4);
        }
        if (TextUtils.isEmpty(str3)) {
            return o0.w(str4);
        }
        Uri v = o0.v(str4);
        if (v == null) {
            return o0.w(str4);
        }
        if (f49121a) {
            Log.d("SwanAppUtils", "buildPageUrl pageUrl: " + str4 + str3);
        }
        return v.buildUpon().query(str3).build().toString();
    }

    public static void a0(Runnable runnable) {
        f49122b.removeCallbacks(runnable);
    }

    public static boolean b(SwanAppConfigData swanAppConfigData, d.a.l0.a.l1.b bVar, boolean z) {
        if (swanAppConfigData == null || bVar == null) {
            return false;
        }
        if (d.a.l0.a.t1.b.a.e(bVar.f())) {
            return true;
        }
        if (f49121a) {
            Log.d("SwanAppUtils", "checkPageParam pageParam : " + bVar.f47033e);
            Log.d("SwanAppUtils", "checkPageParam pageRouteParam : " + bVar.f47036h);
            Log.d("SwanAppUtils", "checkPageParam allowTab : " + z);
        }
        return z ? swanAppConfigData.o(bVar.f47036h) || swanAppConfigData.q(bVar.f47036h) : swanAppConfigData.o(bVar.f47036h) && !swanAppConfigData.q(bVar.f47036h);
    }

    public static void b0(Runnable runnable) {
        c0(runnable, 0L);
    }

    public static boolean c(SwanAppConfigData swanAppConfigData, d.a.l0.a.l1.b bVar) {
        return swanAppConfigData != null && swanAppConfigData.m() && swanAppConfigData.q(bVar.f47036h);
    }

    public static void c0(Runnable runnable, long j) {
        if (Thread.currentThread() != Looper.getMainLooper().getThread()) {
            f49122b.postDelayed(runnable, j);
        } else {
            runnable.run();
        }
    }

    public static void d() {
        k.d O2 = d.a.l0.a.h0.g.k.O2("https://baozhang.baidu.com/guarantee/m/#/swan-guarantee");
        O2.a(false);
        O2.b();
    }

    public static void d0(Runnable runnable) {
        if (Thread.currentThread() != Looper.getMainLooper().getThread()) {
            f49122b.postAtFrontOfQueue(runnable);
        } else {
            runnable.run();
        }
    }

    public static boolean e(Context context, String str) {
        if (context == null || TextUtils.isEmpty(str)) {
            return false;
        }
        if (f49121a) {
            Log.i("SwanAppUtils", "downloadParams is " + str);
        }
        try {
            JSONObject jSONObject = new JSONObject(str);
            if (TextUtils.isEmpty(jSONObject.optString("url"))) {
                return false;
            }
            return d.a.l0.a.c1.a.c().d(context, jSONObject);
        } catch (JSONException e2) {
            if (f49121a) {
                e2.printStackTrace();
                return false;
            }
            return false;
        }
    }

    @Nullable
    public static String f(@Nullable String str) {
        if (TextUtils.isEmpty(str)) {
            return str;
        }
        StringBuffer stringBuffer = new StringBuffer();
        int length = str.length();
        for (int i2 = 0; i2 < length; i2++) {
            char charAt = str.charAt(i2);
            if (charAt <= 31 || charAt >= 127) {
                stringBuffer.append(String.format("\\u%04x", Integer.valueOf(charAt)));
            } else {
                stringBuffer.append(charAt);
            }
        }
        return stringBuffer.toString();
    }

    public static void g(Activity activity, int i2) {
        if (f49121a) {
            Log.d("ScreenOrientationCompat", "fixedOrientation() called with: activity = [" + activity + "], orientation = [" + i2 + "]");
        }
        if (i2 == -1 || Build.VERSION.SDK_INT != 26 || activity.getApplicationInfo().targetSdkVersion <= 26 || !R(activity) || J(activity)) {
            return;
        }
        try {
            Field declaredField = Activity.class.getDeclaredField("mActivityInfo");
            declaredField.setAccessible(true);
            Object obj = declaredField.get(activity);
            Field declaredField2 = ActivityInfo.class.getDeclaredField("screenOrientation");
            declaredField2.setAccessible(true);
            if (declaredField2.getInt(obj) == -1) {
                declaredField2.setInt(obj, i2);
                if (f49121a) {
                    Log.d("ScreenOrientationCompat", "set " + activity.getComponentName() + " screenOrientation to " + i2);
                }
            }
        } catch (IllegalAccessException | NoSuchFieldException e2) {
            if (f49121a) {
                Log.e("SwanAppUtils", "isTranslucentOrFloating reflect fail", e2);
            }
        }
    }

    public static String h(String str, String str2) {
        if (TextUtils.isEmpty(str) && TextUtils.isEmpty(str2)) {
            if (f49121a) {
                Log.w("SwanAppUtils", "openUrl && downloadUrl is empty");
                return null;
            }
            return null;
        }
        StringBuilder sb = new StringBuilder(SchemeConfig.getSchemeHead());
        sb.append("://v26/swan/openApp?upgrade=0");
        try {
            JSONObject jSONObject = new JSONObject();
            if (TextUtils.isEmpty(str)) {
                str = "";
            }
            jSONObject.put("open", str);
            if (TextUtils.isEmpty(str2)) {
                str2 = "";
            }
            jSONObject.put("download", str2);
            sb.append("&params=");
            sb.append(URLEncoder.encode(jSONObject.toString(), "utf-8"));
        } catch (UnsupportedEncodingException | JSONException e2) {
            if (f49121a) {
                Log.w("SwanAppUtils", Log.getStackTraceString(e2));
            }
        }
        return sb.toString();
    }

    public static Bitmap i(d.a.l0.a.f1.e.b bVar, String str, boolean z) {
        return j((bVar == null || TextUtils.isEmpty(bVar.Q())) ? "" : bVar.Q(), str, z);
    }

    public static Bitmap j(String str, String str2, boolean z) {
        return k(str, str2, z, null);
    }

    public static Bitmap k(String str, String str2, boolean z, t.b bVar) {
        Uri C = C(str);
        if (t.d(C)) {
            return t.c(C, AppRuntime.getAppContext());
        }
        if (C != null) {
            if (bVar != null) {
                Fresco.getImagePipeline().fetchDecodedImage(ImageRequestBuilder.newBuilderWithSource(C).build(), AppRuntime.getAppContext()).subscribe(new d(bVar, str), UiThreadImmediateExecutorService.getInstance());
            } else {
                t.f(C, str2);
            }
        }
        return BitmapFactory.decodeResource(AppRuntime.getAppContext().getResources(), z ? d.a.l0.a.e.aiapps_default_icon : d.a.l0.a.e.aiapps_default_grey_icon);
    }

    public static synchronized String l(Context context) {
        String string;
        synchronized (q0.class) {
            try {
                string = context.getResources().getString(context.getPackageManager().getPackageInfo(context.getPackageName(), 0).applicationInfo.labelRes);
            } catch (Exception e2) {
                if (f49121a) {
                    Log.e("SwanAppUtils", e2.toString());
                    return "";
                }
                return "";
            }
        }
        return string;
    }

    public static AbsoluteLayout m(String str) {
        d.a.l0.a.p.e.c u;
        d.a.l0.a.p.e.d B = d.a.l0.a.g1.f.V().B(str);
        if (B == null || (u = B.u()) == null) {
            return null;
        }
        return u.getCurrentWebView();
    }

    public static d.a.l0.a.l1.b n() {
        d.a.l0.a.l1.b bVar = new d.a.l0.a.l1.b();
        bVar.f47034f = "";
        bVar.f47033e = "";
        d.a.l0.a.h0.g.g W = d.a.l0.a.g1.f.V().W();
        return (W == null || W.o() == null) ? bVar : W.o().Z2();
    }

    public static int o(String str) {
        try {
            return Integer.parseInt(str);
        } catch (NumberFormatException e2) {
            if (f49121a) {
                e2.printStackTrace();
            }
            return -1;
        }
    }

    @Nullable
    public static String p() {
        d.a.l0.a.a2.e Q = d.a.l0.a.a2.e.Q();
        if (Q == null) {
            return null;
        }
        String e0 = Q.L().e0();
        if (TextUtils.isEmpty(e0)) {
            return d.a.l0.a.g1.f.V().f();
        }
        int lastIndexOf = e0.lastIndexOf("?");
        if (lastIndexOf > 0) {
            e0 = e0.substring(0, lastIndexOf);
        }
        return e0.startsWith(File.separator) ? e0.substring(1) : e0;
    }

    public static Handler q() {
        return f49122b;
    }

    @SuppressLint({"MissingPermission", "HardwareIds"})
    public static String r() {
        TelephonyManager telephonyManager;
        if (Build.VERSION.SDK_INT >= 29) {
            if (f49121a) {
                Log.d("SwanAppUtils", "android 29 can not get imei");
            }
            return "";
        } else if (!TextUtils.isEmpty(f49123c)) {
            if (f49121a) {
                Log.d("SwanAppUtils", "imei hit cache");
            }
            return f49123c;
        } else {
            Application b2 = d.a.l0.a.c1.a.b();
            if (ContextCompat.checkSelfPermission(b2, "android.permission.READ_PHONE_STATE") != 0) {
                return "";
            }
            String str = null;
            try {
                telephonyManager = (TelephonyManager) b2.getSystemService("phone");
            } catch (Exception unused) {
            }
            if (telephonyManager == null) {
                return "";
            }
            str = telephonyManager.getDeviceId();
            if (!TextUtils.isEmpty(str)) {
                f49123c = str;
                return str;
            }
            if (Build.VERSION.SDK_INT >= 26) {
                String imei = telephonyManager.getImei();
                if (!TextUtils.isEmpty(imei)) {
                    f49123c = imei;
                    return imei;
                }
                str = telephonyManager.getMeid();
                f49123c = str;
            }
            return TextUtils.isEmpty(str) ? "" : str;
        }
    }

    public static String s(@NonNull File file) {
        String s = d.a.l0.t.d.s(file.getPath());
        if (TextUtils.isEmpty(s)) {
            return "*/*";
        }
        String mimeTypeFromExtension = MimeTypeMap.getSingleton().getMimeTypeFromExtension(s);
        return !TextUtils.isEmpty(mimeTypeFromExtension) ? mimeTypeFromExtension : "*/*";
    }

    @SuppressLint({"PackageManagerGetSignatures"})
    public static PackageInfo t(Context context, String str) {
        if (context != null) {
            try {
                return context.getPackageManager().getPackageInfo(str, 64);
            } catch (PackageManager.NameNotFoundException e2) {
                if (f49121a) {
                    Log.w("SwanAppUtils", e2.getMessage());
                    return null;
                }
                return null;
            }
        }
        return null;
    }

    public static String u(Context context, String str) {
        PackageInfo t = t(context, str);
        if (t != null) {
            return t.versionName;
        }
        return null;
    }

    public static d.a.l0.a.l1.b v() {
        d.a.l0.a.l1.b e3;
        d.a.l0.a.l1.b bVar = new d.a.l0.a.l1.b();
        bVar.f47034f = "";
        bVar.f47033e = "";
        d.a.l0.a.h0.g.g W = d.a.l0.a.g1.f.V().W();
        return (W == null || W.o() == null || (e3 = W.o().e3()) == null) ? bVar : e3;
    }

    public static String w(d.a.l0.a.a2.e eVar, String str) {
        File x;
        if (eVar == null || TextUtils.isEmpty(str) || (x = x(eVar)) == null) {
            return null;
        }
        if (str.startsWith(File.separator)) {
            return new File(x, str).getPath();
        }
        String U = d.a.l0.a.g1.f.V().U();
        if (TextUtils.isEmpty(U)) {
            return null;
        }
        File parentFile = new File(U).getParentFile();
        if (parentFile == null || TextUtils.isEmpty(parentFile.getPath())) {
            parentFile = new File(File.separator);
        }
        try {
            return new File(x, new File(parentFile, str).getCanonicalPath()).getPath();
        } catch (IOException e2) {
            if (f49121a) {
                Log.d("SwanAppUtils", Log.getStackTraceString(e2));
            }
            return null;
        }
    }

    public static File x(d.a.l0.a.a2.e eVar) {
        if (eVar == null) {
            return null;
        }
        String appId = eVar.getAppId();
        String u1 = eVar.L().u1();
        File g2 = d.a.l0.a.a1.e.g();
        return new File(g2, appId + File.separator + u1);
    }

    public static String y() {
        return z(Integer.MAX_VALUE);
    }

    @Nullable
    public static String z(int i2) {
        StackTraceElement[] stackTrace = Thread.currentThread().getStackTrace();
        if (stackTrace == null || stackTrace.length <= 0) {
            return null;
        }
        StringBuilder sb = new StringBuilder();
        int i3 = 0;
        for (StackTraceElement stackTraceElement : stackTrace) {
            if (i3 >= i2) {
                break;
            }
            if (stackTraceElement != null) {
                sb.append(stackTraceElement.toString());
                sb.append("\n");
                i3++;
            }
        }
        return sb.toString();
    }
}
