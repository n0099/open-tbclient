package d.b.g0.a.t.c.n;

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
import com.kwai.video.player.KsMediaMeta;
import com.tencent.connect.common.Constants;
import d.b.g0.a.i2.h0;
import d.b.g0.a.i2.k0;
import d.b.g0.a.k;
import d.b.g0.a.l;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class e {

    /* renamed from: a  reason: collision with root package name */
    public static final boolean f46202a = k.f45050a;

    /* renamed from: b  reason: collision with root package name */
    public static JSONObject f46203b;

    public static JSONObject a(@NonNull Context context) {
        if (f46202a) {
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
            jSONObject.put(KsMediaMeta.KSM_KEY_LANGUAGE, c(configuration));
            jSONObject.put("version", k0.z());
            jSONObject.put("system", "Android " + Build.VERSION.RELEASE);
            jSONObject.put(Constants.PARAM_PLATFORM, "android");
            jSONObject.put("fontSizeSetting", d.b.g0.a.w0.a.l().J());
            jSONObject.put("swanNativeVersion", l.a());
            jSONObject.put("host", d.b.g0.a.w0.a.k().g());
            jSONObject.put("statusBarHeight", h0.H(h0.s()));
            jSONObject.put("navigationBarHeight", h0.H(h0.h()));
            if (f46202a) {
                Log.d("SystemInfoCacheHelper", "end create System Info");
            }
            return jSONObject;
        } catch (JSONException e2) {
            if (f46202a) {
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
        synchronized (e.class) {
            if (f46203b == null && context != null) {
                if (f46202a) {
                    Log.d("SystemInfoCacheHelper", "need create system info");
                }
                f46203b = a(context);
            }
            if (f46202a) {
                Log.d("SystemInfoCacheHelper", "return cache system info");
            }
            jSONObject = f46203b;
        }
        return jSONObject;
    }

    public static String c(Configuration configuration) {
        int i = Build.VERSION.SDK_INT;
        if (i < 21) {
            return configuration.locale.toString();
        }
        if (i < 24) {
            return configuration.locale.toLanguageTag();
        }
        return configuration.getLocales().toLanguageTags();
    }

    @Nullable
    public static synchronized void d(Context context) {
        synchronized (e.class) {
            if (f46202a) {
                Log.d("SystemInfoCacheHelper", "start pre cache");
            }
            if (d.b.g0.a.w0.a.N().f()) {
                if (f46203b == null && context != null) {
                    if (f46202a) {
                        Log.d("SystemInfoCacheHelper", "need create system info");
                    }
                    f46203b = a(context);
                }
                if (f46202a) {
                    Log.d("SystemInfoCacheHelper", "end pre cache system info");
                }
            }
        }
    }

    public static synchronized void e() {
        synchronized (e.class) {
            if (f46202a) {
                Log.d("SystemInfoCacheHelper", "release cache system info");
            }
            f46203b = null;
        }
    }
}
