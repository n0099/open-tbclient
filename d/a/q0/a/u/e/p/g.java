package d.a.q0.a.u.e.p;

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
import com.baidu.mobads.container.util.AdIconUtil;
import com.baidu.pass.face.platform.common.ConstantHelper;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.kwai.video.player.KsMediaMeta;
import com.tencent.connect.common.Constants;
import d.a.q0.a.k;
import d.a.q0.a.l;
import d.a.q0.a.v2.n0;
import d.a.q0.a.v2.q0;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes8.dex */
public class g {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: a  reason: collision with root package name */
    public static final boolean f51133a;

    /* renamed from: b  reason: collision with root package name */
    public static JSONObject f51134b;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-2111529616, "Ld/a/q0/a/u/e/p/g;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-2111529616, "Ld/a/q0/a/u/e/p/g;");
                return;
            }
        }
        f51133a = k.f49133a;
    }

    public static JSONObject a(@NonNull Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, context)) == null) {
            if (f51133a) {
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
                jSONObject.put("version", q0.D());
                jSONObject.put(ConstantHelper.LOG_OS, "Android " + Build.VERSION.RELEASE);
                jSONObject.put(Constants.PARAM_PLATFORM, "android");
                jSONObject.put("fontSizeSetting", d.a.q0.a.c1.a.n().q());
                jSONObject.put("swanNativeVersion", l.a());
                jSONObject.put("host", d.a.q0.a.c1.a.m().a());
                jSONObject.put("statusBarHeight", n0.K(n0.u()));
                jSONObject.put("navigationBarHeight", n0.K(n0.j()));
                if (f51133a) {
                    Log.d("SystemInfoCacheHelper", "end create System Info");
                }
                return jSONObject;
            } catch (JSONException e2) {
                if (f51133a) {
                    Log.d("SystemInfoCacheHelper", "crate system info error : ");
                    e2.printStackTrace();
                    return null;
                }
                return null;
            }
        }
        return (JSONObject) invokeL.objValue;
    }

    @Nullable
    public static synchronized JSONObject b(Context context) {
        InterceptResult invokeL;
        JSONObject jSONObject;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, context)) == null) {
            synchronized (g.class) {
                if (f51134b == null && context != null) {
                    if (f51133a) {
                        Log.d("SystemInfoCacheHelper", "need create system info");
                    }
                    f51134b = a(context);
                }
                if (f51133a) {
                    Log.d("SystemInfoCacheHelper", "return cache system info");
                }
                jSONObject = f51134b;
            }
            return jSONObject;
        }
        return (JSONObject) invokeL.objValue;
    }

    @SuppressLint({"ObsoleteSdkInt"})
    public static String c(Configuration configuration) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65539, null, configuration)) == null) {
            int i2 = Build.VERSION.SDK_INT;
            if (i2 < 21) {
                return configuration.locale.toString();
            }
            if (i2 < 24) {
                return configuration.locale.toLanguageTag();
            }
            return configuration.getLocales().toLanguageTags();
        }
        return (String) invokeL.objValue;
    }

    @Nullable
    public static synchronized void d(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65540, null, context) == null) {
            synchronized (g.class) {
                if (f51133a) {
                    Log.d("SystemInfoCacheHelper", "start pre cache system info");
                }
                if (d.a.q0.a.c1.a.Z().v()) {
                    if (f51134b == null && context != null) {
                        if (f51133a) {
                            Log.d("SystemInfoCacheHelper", "need create system info");
                        }
                        f51134b = a(context);
                    }
                    if (f51133a) {
                        Log.d("SystemInfoCacheHelper", "end pre cache system info");
                    }
                }
            }
        }
    }

    public static synchronized void e() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(AdIconUtil.AD_TEXT_ID, null) == null) {
            synchronized (g.class) {
                if (f51133a) {
                    Log.d("SystemInfoCacheHelper", "release cache system info");
                }
                f51134b = null;
            }
        }
    }
}
