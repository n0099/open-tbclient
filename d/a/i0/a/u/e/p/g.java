package d.a.i0.a.u.e.p;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.Configuration;
import android.graphics.Point;
import android.graphics.Rect;
import android.os.Build;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.WindowManager;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.tencent.connect.common.Constants;
import d.a.i0.a.k;
import d.a.i0.a.l;
import d.a.i0.a.v2.n0;
import d.a.i0.a.v2.q0;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class g {

    /* renamed from: a  reason: collision with root package name */
    public static final boolean f45029a = k.f43025a;

    /* renamed from: b  reason: collision with root package name */
    public static JSONObject f45030b;

    public static JSONObject a(@NonNull Context context) {
        if (f45029a) {
            Log.d("SystemInfoCacheHelper", "start create System Info");
        }
        WindowManager windowManager = (WindowManager) context.getSystemService("window");
        DisplayMetrics displayMetrics = new DisplayMetrics();
        windowManager.getDefaultDisplay().getMetrics(displayMetrics);
        windowManager.getDefaultDisplay().getSize(new Point());
        windowManager.getDefaultDisplay().getRectSize(new Rect());
        Configuration configuration = context.getResources().getConfiguration();
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("brand", Build.BRAND);
            jSONObject.put("model", Build.MODEL);
            jSONObject.put("pixelRatio", displayMetrics.density);
            jSONObject.put("devicePixelRatio", displayMetrics.density);
            jSONObject.put("language", c(configuration));
            jSONObject.put("version", q0.D());
            jSONObject.put("system", "Android " + Build.VERSION.RELEASE);
            jSONObject.put(Constants.PARAM_PLATFORM, "android");
            jSONObject.put("fontSizeSetting", d.a.i0.a.c1.a.n().q());
            jSONObject.put("swanNativeVersion", l.a());
            jSONObject.put("host", d.a.i0.a.c1.a.m().a());
            jSONObject.put("statusBarHeight", n0.K(n0.u()));
            jSONObject.put("navigationBarHeight", n0.K(n0.j()));
            if (f45029a) {
                Log.d("SystemInfoCacheHelper", "end create System Info");
            }
            return jSONObject;
        } catch (JSONException e2) {
            if (f45029a) {
                Log.d("SystemInfoCacheHelper", "crate system info error : ");
                e2.printStackTrace();
                return null;
            }
            return null;
        }
    }

    @Nullable
    public static synchronized JSONObject b(Context context) {
        JSONObject jSONObject;
        synchronized (g.class) {
            if (f45030b == null && context != null) {
                if (f45029a) {
                    Log.d("SystemInfoCacheHelper", "need create system info");
                }
                f45030b = a(context);
            }
            if (f45029a) {
                Log.d("SystemInfoCacheHelper", "return cache system info");
            }
            jSONObject = f45030b;
        }
        return jSONObject;
    }

    @SuppressLint({"ObsoleteSdkInt"})
    public static String c(Configuration configuration) {
        int i2 = Build.VERSION.SDK_INT;
        if (i2 < 21) {
            return configuration.locale.toString();
        }
        if (i2 < 24) {
            return configuration.locale.toLanguageTag();
        }
        return configuration.getLocales().toLanguageTags();
    }

    @Nullable
    public static synchronized void d(Context context) {
        synchronized (g.class) {
            if (f45029a) {
                Log.d("SystemInfoCacheHelper", "start pre cache system info");
            }
            if (d.a.i0.a.c1.a.Z().v()) {
                if (f45030b == null && context != null) {
                    if (f45029a) {
                        Log.d("SystemInfoCacheHelper", "need create system info");
                    }
                    f45030b = a(context);
                }
                if (f45029a) {
                    Log.d("SystemInfoCacheHelper", "end pre cache system info");
                }
            }
        }
    }

    public static synchronized void e() {
        synchronized (g.class) {
            if (f45029a) {
                Log.d("SystemInfoCacheHelper", "release cache system info");
            }
            f45030b = null;
        }
    }
}
