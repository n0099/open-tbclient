package d.b.g0.a.i2;

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
import android.widget.AbsoluteLayout;
import android.widget.ImageView;
import androidx.annotation.AnyThread;
import androidx.annotation.DrawableRes;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.core.app.NotificationManagerCompat;
import androidx.core.content.ContextCompat;
import com.baidu.down.request.db.DownloadDataConstants;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.searchbox.ubcprocessor.UBCCloudControlProcessor;
import com.baidu.searchbox.unitedscheme.CallbackHandler;
import com.baidu.searchbox.unitedscheme.SchemeConfig;
import com.baidu.searchbox.unitedscheme.SchemeRouter;
import com.baidu.searchbox.unitedscheme.utils.UnitedSchemeConstants;
import com.baidu.searchbox.unitedscheme.utils.UnitedSchemeUtility;
import com.baidu.swan.apps.SwanAppActivity;
import com.baidu.swan.apps.runtime.config.SwanAppConfigData;
import com.baidu.tbadk.browser.BaseWebViewActivity;
import com.facebook.common.executors.UiThreadImmediateExecutorService;
import com.facebook.common.references.CloseableReference;
import com.facebook.datasource.DataSource;
import com.facebook.drawee.backends.pipeline.Fresco;
import com.facebook.imagepipeline.datasource.BaseBitmapDataSubscriber;
import com.facebook.imagepipeline.image.CloseableImage;
import com.facebook.imagepipeline.request.ImageRequestBuilder;
import d.b.g0.a.i2.s;
import d.b.g0.a.q1.b.b.g;
import java.io.File;
import java.io.UnsupportedEncodingException;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.net.URISyntaxException;
import java.net.URLEncoder;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public final class k0 {

    /* renamed from: a  reason: collision with root package name */
    public static final boolean f44701a = d.b.g0.a.k.f45051a;

    /* renamed from: b  reason: collision with root package name */
    public static Handler f44702b = new Handler(Looper.getMainLooper());

    /* renamed from: c  reason: collision with root package name */
    public static String f44703c;

    /* loaded from: classes3.dex */
    public static class a implements Runnable {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ ImageView f44704e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ int f44705f;

        public a(ImageView imageView, int i) {
            this.f44704e = imageView;
            this.f44705f = i;
        }

        @Override // java.lang.Runnable
        public void run() {
            this.f44704e.setImageResource(this.f44705f);
        }
    }

    /* loaded from: classes3.dex */
    public static class b implements d.b.g0.c.i.a<Bitmap> {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ ImageView f44706a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ int f44707b;

        /* loaded from: classes3.dex */
        public class a implements Runnable {

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ Bitmap f44708e;

            public a(Bitmap bitmap) {
                this.f44708e = bitmap;
            }

            @Override // java.lang.Runnable
            public void run() {
                b.this.f44706a.setImageBitmap(this.f44708e);
            }
        }

        /* renamed from: d.b.g0.a.i2.k0$b$b  reason: collision with other inner class name */
        /* loaded from: classes3.dex */
        public class RunnableC0700b implements Runnable {
            public RunnableC0700b() {
            }

            @Override // java.lang.Runnable
            public void run() {
                b bVar = b.this;
                bVar.f44706a.setImageResource(bVar.f44707b);
            }
        }

        public b(ImageView imageView, int i) {
            this.f44706a = imageView;
            this.f44707b = i;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.b.g0.c.i.a
        /* renamed from: b */
        public void a(Bitmap bitmap) {
            if (bitmap != null) {
                if (Looper.getMainLooper() == Looper.myLooper()) {
                    this.f44706a.setImageBitmap(bitmap);
                    return;
                } else {
                    k0.X(new a(bitmap));
                    return;
                }
            }
            k0.X(new RunnableC0700b());
        }
    }

    /* loaded from: classes3.dex */
    public static class c implements s.b {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ d.b.g0.c.i.a f44711a;

        public c(d.b.g0.c.i.a aVar) {
            this.f44711a = aVar;
        }

        @Override // d.b.g0.a.i2.s.b
        public void a(String str, Bitmap bitmap) {
            this.f44711a.a(bitmap);
        }
    }

    /* loaded from: classes3.dex */
    public static class d extends BaseBitmapDataSubscriber {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ s.b f44712a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ String f44713b;

        public d(s.b bVar, String str) {
            this.f44712a = bVar;
            this.f44713b = str;
        }

        @Override // com.facebook.datasource.BaseDataSubscriber, com.facebook.datasource.DataSubscriber
        public void onCancellation(DataSource<CloseableReference<CloseableImage>> dataSource) {
            super.onCancellation(dataSource);
            this.f44712a.a(this.f44713b, null);
        }

        @Override // com.facebook.datasource.BaseDataSubscriber
        public void onFailureImpl(DataSource<CloseableReference<CloseableImage>> dataSource) {
            this.f44712a.a(this.f44713b, null);
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
                    this.f44712a.a(this.f44713b, copy);
                    return;
                } catch (Exception unused) {
                    this.f44712a.a(this.f44713b, null);
                    return;
                }
            }
            this.f44712a.a(this.f44713b, null);
        }
    }

    /* loaded from: classes3.dex */
    public static class e implements DialogInterface.OnClickListener {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ Context f44714e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ Intent f44715f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ CallbackHandler f44716g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ String f44717h;

        public e(Context context, Intent intent, CallbackHandler callbackHandler, String str) {
            this.f44714e = context;
            this.f44715f = intent;
            this.f44716g = callbackHandler;
            this.f44717h = str;
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i) {
            boolean f2 = d.b.g0.a.i2.e.f(this.f44714e, this.f44715f);
            this.f44716g.handleSchemeDispatchCallback(this.f44717h, UnitedSchemeUtility.wrapCallbackParams(f2 ? 0 : 1001, f2 ? "打开APP成功" : "打开APP失败，本地没有安装").toString());
        }
    }

    /* loaded from: classes3.dex */
    public static class f implements DialogInterface.OnClickListener {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ CallbackHandler f44718e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ String f44719f;

        public f(CallbackHandler callbackHandler, String str) {
            this.f44718e = callbackHandler;
            this.f44719f = str;
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i) {
            this.f44718e.handleSchemeDispatchCallback(this.f44719f, UnitedSchemeUtility.wrapCallbackParams(1004, "取消打开APP").toString());
        }
    }

    public static String A(Context context) {
        String str;
        try {
            str = ((WifiManager) context.getSystemService("wifi")).getConnectionInfo().getMacAddress();
        } catch (Exception e2) {
            if (f44701a) {
                Log.e("SwanAppUtils", "getWifiInfo fail!" + e2.toString());
            }
            str = null;
        }
        return TextUtils.isEmpty(str) ? "" : str;
    }

    public static boolean B(String str) {
        SwanAppConfigData D;
        d.b.g0.a.r1.d e2 = d.b.g0.a.r1.d.e();
        if (e2.x() && (D = e2.s().D()) != null && D.m() && !TextUtils.isEmpty(str)) {
            return D.q(str);
        }
        return false;
    }

    public static boolean C(Context context, String str) {
        if (context != null && !TextUtils.isEmpty(str)) {
            try {
                if (context.getPackageManager().getPackageInfo(str, 0) != null) {
                    return true;
                }
            } catch (PackageManager.NameNotFoundException unused) {
                if (f44701a) {
                    Log.e("SwanAppUtils", str + " is not found");
                }
            }
        }
        return false;
    }

    public static boolean D() {
        return TextUtils.equals(BaseWebViewActivity.SHOUBAI_SCHEME, d.b.g0.a.w0.a.k().getSchemeHeader());
    }

    public static boolean E() {
        return F(d.b.g0.a.z0.f.V().U());
    }

    public static boolean F(String str) {
        return !TextUtils.isEmpty(str) && TextUtils.equals(str, p());
    }

    public static boolean G(Activity activity) {
        try {
            Field declaredField = Activity.class.getDeclaredField("mActivityInfo");
            declaredField.setAccessible(true);
            Object obj = declaredField.get(activity);
            Method declaredMethod = ActivityInfo.class.getDeclaredMethod("isFixedOrientation", new Class[0]);
            declaredMethod.setAccessible(true);
            return ((Boolean) declaredMethod.invoke(obj, new Object[0])).booleanValue();
        } catch (IllegalAccessException | NoSuchFieldException | NoSuchMethodException | InvocationTargetException e2) {
            if (f44701a) {
                Log.e("SwanAppUtils", "isFixedOrientation reflect fail", e2);
                return false;
            }
            return false;
        }
    }

    public static boolean H(@NonNull Context context) {
        if (y.j(context, "android.permission.ACCESS_FINE_LOCATION")) {
            try {
                LocationManager locationManager = (LocationManager) context.getApplicationContext().getSystemService("location");
                if (locationManager != null) {
                    return locationManager.isProviderEnabled("gps");
                }
            } catch (Exception e2) {
                if (f44701a) {
                    e2.printStackTrace();
                }
            }
            return false;
        }
        return false;
    }

    @RequiresApi(api = 23)
    public static boolean I() {
        return !d.b.g0.a.i2.c.h() || AppRuntime.getAppContext().checkSelfPermission("android.permission.ACCESS_FINE_LOCATION") == 0;
    }

    public static boolean J(@NonNull Context context) {
        return NotificationManagerCompat.from(context).areNotificationsEnabled();
    }

    public static boolean K() {
        return Looper.getMainLooper().getThread() == Thread.currentThread();
    }

    public static boolean L() {
        return i.i();
    }

    public static boolean M(Activity activity) {
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
            return obtainStyledAttributes.getBoolean(((Integer) declaredField4.get(null)).intValue(), false) || obtainStyledAttributes.getBoolean(((Integer) declaredField2.get(null)).intValue(), false) || (!obtainStyledAttributes.hasValue(((Integer) declaredField2.get(null)).intValue()) && obtainStyledAttributes.getBoolean(((Integer) declaredField3.get(null)).intValue(), false));
        } catch (ClassNotFoundException | IllegalAccessException | NoSuchFieldException e2) {
            if (f44701a) {
                Log.e("SwanAppUtils", "isTranslucentOrFloating reflect fail", e2);
            }
            return false;
        }
    }

    public static boolean N(@NonNull Context context) {
        WifiManager wifiManager = (WifiManager) context.getApplicationContext().getSystemService("wifi");
        if (wifiManager != null) {
            return wifiManager.isWifiEnabled();
        }
        return false;
    }

    public static boolean O(Context context, String str) {
        if (context == null || TextUtils.isEmpty(str)) {
            return false;
        }
        try {
            Intent parseUri = Intent.parseUri(Uri.decode(str), 1);
            parseUri.setFlags(268435456);
            if (parseUri.resolveActivityInfo(context.getPackageManager(), 65536) != null) {
                d.b.g0.a.i2.e.f(context, parseUri);
                return true;
            }
            return false;
        } catch (URISyntaxException e2) {
            if (f44701a) {
                Log.w("SwanAppUtils", Log.getStackTraceString(e2));
                return false;
            }
            return false;
        }
    }

    public static void P(CallbackHandler callbackHandler) {
        SchemeRouter.invokeScheme(d.b.g0.a.r1.d.e().n(), b().build(), UnitedSchemeConstants.SCHEME_INVOKE_TYPE_INSIDE, callbackHandler);
    }

    @AnyThread
    public static void Q(@NonNull ImageView imageView, @Nullable String str, @DrawableRes int i) {
        if (TextUtils.isEmpty(str)) {
            X(new a(imageView, i));
            return;
        }
        b bVar = new b(imageView, i);
        bVar.a(l(str, str, false, new c(bVar)));
    }

    public static void R() {
        if (f44701a) {
            Log.d("SwanAppSlavePool", "onPreloadNextEnv()");
        }
        SwanAppActivity activity = d.b.g0.a.z0.f.V().getActivity();
        if (activity != null) {
            Bundle bundle = new Bundle();
            bundle.putString("bundle_key_preload_preload_scene", "2");
            activity.preloadNextSwanAppProcess(bundle);
            d.b.g0.a.e0.v.b.h(activity);
        }
    }

    public static boolean S(Context context, String str, CallbackHandler callbackHandler, String str2) {
        String str3;
        if (context != null && !TextUtils.isEmpty(str)) {
            try {
                Intent parseUri = Intent.parseUri(Uri.decode(str), 1);
                parseUri.setFlags(268435456);
                PackageManager packageManager = context.getPackageManager();
                ResolveInfo resolveActivity = packageManager.resolveActivity(parseUri, 65536);
                if (resolveActivity != null && resolveActivity.activityInfo != null) {
                    String charSequence = resolveActivity.match != 0 ? resolveActivity.activityInfo.applicationInfo.loadLabel(packageManager).toString() : "其他应用";
                    if (TextUtils.isEmpty(charSequence)) {
                        str3 = "";
                    } else {
                        str3 = context.getResources().getString(d.b.g0.a.h.swanapp_open_app_dialog_tips1) + charSequence;
                    }
                    String str4 = context.getResources().getString(d.b.g0.a.h.swanapp_open_app_dialog_tips) + packageManager.getPackageInfo(context.getPackageName(), 0).applicationInfo.loadLabel(packageManager).toString() + str3;
                    String string = context.getString(d.b.g0.a.h.aiapps_ok);
                    String string2 = context.getString(d.b.g0.a.h.aiapps_cancel);
                    g.a aVar = new g.a(context);
                    aVar.f(true);
                    aVar.y(str4);
                    aVar.n(new d.b.g0.a.j2.g.a());
                    aVar.m(false);
                    aVar.P(string, new e(context, parseUri, callbackHandler, str2));
                    aVar.D(string2, new f(callbackHandler, str2));
                    aVar.X();
                    return true;
                }
                return false;
            } catch (PackageManager.NameNotFoundException | URISyntaxException e2) {
                if (f44701a) {
                    e2.printStackTrace();
                }
            }
        }
        return false;
    }

    public static void T(Runnable runnable) {
        U(runnable, 0L);
    }

    public static void U(Runnable runnable, long j) {
        f44702b.postDelayed(runnable, j);
    }

    public static int V(Activity activity) {
        if (f44701a) {
            Log.d("ScreenOrientationCompat", "releaseFixedOrientation() called with: activity = [" + activity + "]");
        }
        int i = -1;
        if (Build.VERSION.SDK_INT != 26 || activity.getApplicationInfo().targetSdkVersion <= 26 || !M(activity) || !G(activity)) {
            return -1;
        }
        try {
            Field declaredField = Activity.class.getDeclaredField("mActivityInfo");
            declaredField.setAccessible(true);
            Object obj = declaredField.get(activity);
            Field declaredField2 = ActivityInfo.class.getDeclaredField("screenOrientation");
            declaredField2.setAccessible(true);
            int i2 = declaredField2.getInt(obj);
            if (i2 != -1) {
                try {
                    declaredField2.setInt(obj, -1);
                    if (f44701a) {
                        Log.d("ScreenOrientationCompat", "set " + activity.getComponentName() + " screenOrientation to UNSPECIFIED");
                    }
                } catch (IllegalAccessException | NoSuchFieldException e2) {
                    e = e2;
                    i = i2;
                    if (f44701a) {
                        Log.e("SwanAppUtils", "releaseFixedOrientation reflect fail", e);
                        return i;
                    }
                    return i;
                }
            }
            return i2;
        } catch (IllegalAccessException e3) {
            e = e3;
        } catch (NoSuchFieldException e4) {
            e = e4;
        }
    }

    public static void W(Runnable runnable) {
        f44702b.removeCallbacks(runnable);
    }

    public static void X(Runnable runnable) {
        Y(runnable, 0L);
    }

    public static void Y(Runnable runnable, long j) {
        if (Thread.currentThread() != Looper.getMainLooper().getThread()) {
            f44702b.postDelayed(runnable, j);
        } else {
            runnable.run();
        }
    }

    public static void Z(Runnable runnable) {
        if (Thread.currentThread() != Looper.getMainLooper().getThread()) {
            f44702b.postAtFrontOfQueue(runnable);
        } else {
            runnable.run();
        }
    }

    public static void a(Context context) {
        SchemeRouter.invoke(context, "baiduboxapp://v1/easybrowse/open?url=" + Uri.encode("https://baozhang.baidu.com/guarantee/m/#/swan-guarantee") + "&newbrowser=1");
    }

    public static Uri.Builder b() {
        JSONObject jSONObject = new JSONObject();
        JSONObject jSONObject2 = new JSONObject();
        try {
            jSONObject2.put("source", "swan");
            jSONObject.put(UBCCloudControlProcessor.UBC_KEY, jSONObject2);
        } catch (JSONException e2) {
            if (d.b.g0.a.t.b.d.f45929c) {
                e2.printStackTrace();
            }
        }
        return new Uri.Builder().scheme(d.b.g0.a.w0.a.k().getSchemeHeader()).authority("paywall").appendPath("openPayWallShelf").appendQueryParameter("params", jSONObject.toString()).appendQueryParameter("callback", "__jsna_3");
    }

    @NonNull
    public static String c(String str, String str2, String str3) {
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            return "";
        }
        if (!str.endsWith(File.separator)) {
            str = str + File.separator;
        }
        String str4 = str + str2 + DownloadDataConstants.DEFAULT_DL_HTML_EXTENSION;
        if (f44701a) {
            Log.d("SwanAppUtils", "buildPageUrl pageUrl: " + str4);
        }
        if (TextUtils.isEmpty(str3)) {
            return i0.u(str4);
        }
        Uri t = i0.t(str4);
        if (t == null) {
            return i0.u(str4);
        }
        if (f44701a) {
            Log.d("SwanAppUtils", "buildPageUrl pageUrl: " + str4 + str3);
        }
        return t.buildUpon().query(str3).build().toString();
    }

    public static boolean d(SwanAppConfigData swanAppConfigData, d.b.g0.a.e1.b bVar, boolean z) {
        if (swanAppConfigData == null || bVar == null) {
            return false;
        }
        if (d.b.g0.a.l1.b.a.d(bVar.d())) {
            return true;
        }
        if (f44701a) {
            Log.d("SwanAppUtils", "checkPageParam pageParam : " + bVar.f44362a);
            Log.d("SwanAppUtils", "checkPageParam pageRouteParam : " + bVar.f44365d);
            Log.d("SwanAppUtils", "checkPageParam allowTab : " + z);
        }
        return z ? swanAppConfigData.o(bVar.f44365d) || swanAppConfigData.q(bVar.f44365d) : swanAppConfigData.o(bVar.f44365d) && !swanAppConfigData.q(bVar.f44365d);
    }

    public static boolean e(SwanAppConfigData swanAppConfigData, d.b.g0.a.e1.b bVar) {
        return swanAppConfigData != null && swanAppConfigData.m() && swanAppConfigData.q(bVar.f44365d);
    }

    public static boolean f(Context context, String str) {
        if (context == null || TextUtils.isEmpty(str)) {
            return false;
        }
        if (f44701a) {
            Log.i("SwanAppUtils", "downloadParams is " + str);
        }
        try {
            JSONObject jSONObject = new JSONObject(str);
            if (TextUtils.isEmpty(jSONObject.optString("url"))) {
                return false;
            }
            return d.b.g0.a.w0.a.d().c(context, jSONObject);
        } catch (JSONException e2) {
            if (f44701a) {
                e2.printStackTrace();
                return false;
            }
            return false;
        }
    }

    @Nullable
    public static String g(@Nullable String str) {
        if (TextUtils.isEmpty(str)) {
            return str;
        }
        StringBuffer stringBuffer = new StringBuffer();
        int length = str.length();
        for (int i = 0; i < length; i++) {
            char charAt = str.charAt(i);
            if (charAt <= 31 || charAt >= 127) {
                stringBuffer.append(String.format("\\u%04x", Integer.valueOf(charAt)));
            } else {
                stringBuffer.append(charAt);
            }
        }
        return stringBuffer.toString();
    }

    public static void h(Activity activity, int i) {
        if (f44701a) {
            Log.d("ScreenOrientationCompat", "fixedOrientation() called with: activity = [" + activity + "], orientation = [" + i + "]");
        }
        if (i == -1 || Build.VERSION.SDK_INT != 26 || activity.getApplicationInfo().targetSdkVersion <= 26 || !M(activity) || G(activity)) {
            return;
        }
        try {
            Field declaredField = Activity.class.getDeclaredField("mActivityInfo");
            declaredField.setAccessible(true);
            Object obj = declaredField.get(activity);
            Field declaredField2 = ActivityInfo.class.getDeclaredField("screenOrientation");
            declaredField2.setAccessible(true);
            if (declaredField2.getInt(obj) == -1) {
                declaredField2.setInt(obj, i);
                if (f44701a) {
                    Log.d("ScreenOrientationCompat", "set " + activity.getComponentName() + " screenOrientation to " + i);
                }
            }
        } catch (IllegalAccessException | NoSuchFieldException e2) {
            if (f44701a) {
                Log.e("SwanAppUtils", "isTranslucentOrFloating reflect fail", e2);
            }
        }
    }

    public static String i(String str, String str2) {
        if (TextUtils.isEmpty(str) && TextUtils.isEmpty(str2)) {
            if (f44701a) {
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
            if (f44701a) {
                Log.w("SwanAppUtils", Log.getStackTraceString(e2));
            }
        }
        return sb.toString();
    }

    public static Bitmap j(d.b.g0.a.y0.e.b bVar, String str, boolean z) {
        return k((bVar == null || TextUtils.isEmpty(bVar.P())) ? "" : bVar.P(), str, z);
    }

    public static Bitmap k(String str, String str2, boolean z) {
        return l(str, str2, z, null);
    }

    public static Bitmap l(String str, String str2, boolean z, s.b bVar) {
        Uri y = y(str);
        if (s.d(y)) {
            return s.c(y, AppRuntime.getAppContext());
        }
        if (y != null) {
            if (bVar != null) {
                Fresco.getImagePipeline().fetchDecodedImage(ImageRequestBuilder.newBuilderWithSource(y).build(), AppRuntime.getAppContext()).subscribe(new d(bVar, str), UiThreadImmediateExecutorService.getInstance());
            } else {
                s.f(y, str2);
            }
        }
        return BitmapFactory.decodeResource(AppRuntime.getAppContext().getResources(), z ? d.b.g0.a.e.aiapps_default_icon : d.b.g0.a.e.aiapps_default_grey_icon);
    }

    public static AbsoluteLayout m(String str) {
        d.b.g0.a.p.d.c webView;
        d.b.g0.a.p.d.d j = d.b.g0.a.z0.f.V().j(str);
        if (j == null || (webView = j.getWebView()) == null) {
            return null;
        }
        return webView.getCurrentWebView();
    }

    public static d.b.g0.a.e1.b n() {
        d.b.g0.a.e1.b bVar = new d.b.g0.a.e1.b();
        bVar.f44363b = "";
        bVar.f44362a = "";
        d.b.g0.a.e0.l.f W = d.b.g0.a.z0.f.V().W();
        return (W == null || W.o() == null) ? bVar : W.o().R2();
    }

    public static int o(String str) {
        try {
            return Integer.parseInt(str);
        } catch (NumberFormatException e2) {
            if (f44701a) {
                e2.printStackTrace();
            }
            return -1;
        }
    }

    @Nullable
    public static String p() {
        d.b.g0.a.r1.e O = d.b.g0.a.r1.e.O();
        if (O == null) {
            return null;
        }
        String b0 = O.J().b0();
        if (TextUtils.isEmpty(b0)) {
            return d.b.g0.a.z0.f.V().l();
        }
        int lastIndexOf = b0.lastIndexOf("?");
        if (lastIndexOf > 0) {
            b0 = b0.substring(0, lastIndexOf);
        }
        return b0.startsWith(File.separator) ? b0.substring(1) : b0;
    }

    public static Handler q() {
        return f44702b;
    }

    @SuppressLint({"MissingPermission"})
    public static String r() {
        TelephonyManager telephonyManager;
        if (Build.VERSION.SDK_INT >= 29) {
            if (f44701a) {
                Log.d("SwanAppUtils", "android 29 can not get imei");
            }
            return "";
        } else if (!TextUtils.isEmpty(f44703c)) {
            if (f44701a) {
                Log.d("SwanAppUtils", "imei hit cache");
            }
            return f44703c;
        } else {
            Application c2 = d.b.g0.a.w0.a.c();
            if (ContextCompat.checkSelfPermission(c2, "android.permission.READ_PHONE_STATE") != 0) {
                return "";
            }
            String str = null;
            try {
                telephonyManager = (TelephonyManager) c2.getSystemService("phone");
            } catch (Exception unused) {
            }
            if (telephonyManager == null) {
                return "";
            }
            str = telephonyManager.getDeviceId();
            if (!TextUtils.isEmpty(str)) {
                f44703c = str;
                return str;
            }
            if (Build.VERSION.SDK_INT >= 26) {
                String imei = telephonyManager.getImei();
                if (!TextUtils.isEmpty(imei)) {
                    f44703c = imei;
                    return imei;
                }
                str = telephonyManager.getMeid();
                f44703c = str;
            }
            return TextUtils.isEmpty(str) ? "" : str;
        }
    }

    public static PackageInfo s(Context context, String str) {
        try {
            return context.getPackageManager().getPackageInfo(str, 64);
        } catch (PackageManager.NameNotFoundException e2) {
            if (f44701a) {
                Log.w("SwanAppUtils", e2.getMessage());
                return null;
            }
            return null;
        }
    }

    public static String t(Context context, String str) {
        PackageInfo s = s(context, str);
        if (s != null) {
            return s.versionName;
        }
        return null;
    }

    public static String u() {
        return v(Integer.MAX_VALUE);
    }

    @Nullable
    public static String v(int i) {
        StackTraceElement[] stackTrace = Thread.currentThread().getStackTrace();
        if (stackTrace == null || stackTrace.length <= 0) {
            return null;
        }
        StringBuilder sb = new StringBuilder();
        int i2 = 0;
        for (StackTraceElement stackTraceElement : stackTrace) {
            if (i2 >= i) {
                break;
            }
            if (stackTraceElement != null) {
                sb.append(stackTraceElement.toString());
                sb.append("\n");
                i2++;
            }
        }
        return sb.toString();
    }

    public static Uri w(String str) {
        if (TextUtils.isEmpty(str) || !str.startsWith("tel:")) {
            return null;
        }
        return Uri.parse(str);
    }

    public static String x() {
        d.b.g0.a.e0.l.e A = d.b.g0.a.z0.f.V().A();
        if (A != null) {
            return A.X2();
        }
        return null;
    }

    public static Uri y(String str) {
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

    public static String z() {
        try {
            Application c2 = d.b.g0.a.w0.a.c();
            return c2.getPackageManager().getPackageInfo(c2.getPackageName(), 0).versionName;
        } catch (PackageManager.NameNotFoundException e2) {
            e2.printStackTrace();
            return "";
        }
    }
}
