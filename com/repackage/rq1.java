package com.repackage;

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
import androidx.core.view.InputDeviceCompat;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.xiaomi.mipush.sdk.Constants;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes7.dex */
public class rq1 {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean a;
    public static JSONObject b;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-755341793, "Lcom/repackage/rq1;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-755341793, "Lcom/repackage/rq1;");
                return;
            }
        }
        a = rf1.a;
    }

    public static JSONObject a(@NonNull Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, context)) == null) {
            if (a) {
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
                jSONObject.put(Constants.PHONE_BRAND, Build.BRAND);
                jSONObject.put("model", Build.MODEL);
                jSONObject.put("pixelRatio", displayMetrics.density);
                jSONObject.put("devicePixelRatio", displayMetrics.density);
                jSONObject.put("language", c(configuration));
                jSONObject.put("version", bd3.D());
                jSONObject.put("system", "Android " + Build.VERSION.RELEASE);
                jSONObject.put(com.tencent.connect.common.Constants.PARAM_PLATFORM, "android");
                jSONObject.put("fontSizeSetting", oi2.o().r());
                jSONObject.put("swanNativeVersion", sf1.a());
                jSONObject.put("host", oi2.n().a());
                jSONObject.put("statusBarHeight", yc3.O(yc3.t()));
                jSONObject.put("navigationBarHeight", yc3.O(yc3.j()));
                if (a) {
                    Log.d("SystemInfoCacheHelper", "end create System Info");
                }
                return jSONObject;
            } catch (JSONException e) {
                if (a) {
                    Log.d("SystemInfoCacheHelper", "crate system info error : ");
                    e.printStackTrace();
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
            synchronized (rq1.class) {
                if (b == null && context != null) {
                    if (a) {
                        Log.d("SystemInfoCacheHelper", "need create system info");
                    }
                    b = a(context);
                }
                if (a) {
                    Log.d("SystemInfoCacheHelper", "return cache system info");
                }
                jSONObject = b;
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
            int i = Build.VERSION.SDK_INT;
            if (i < 21) {
                return configuration.locale.toString();
            }
            if (i < 24) {
                return configuration.locale.toLanguageTag();
            }
            return configuration.getLocales().toLanguageTags();
        }
        return (String) invokeL.objValue;
    }

    public static void d(int i) {
        JSONObject jSONObject;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(InputDeviceCompat.SOURCE_TRACKBALL, null, i) == null) || (jSONObject = b) == null) {
            return;
        }
        try {
            jSONObject.put("fontSizeSetting", i);
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    @Nullable
    public static synchronized void e(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65541, null, context) == null) {
            synchronized (rq1.class) {
                if (a) {
                    Log.d("SystemInfoCacheHelper", "start pre cache system info");
                }
                if (oi2.g0().t()) {
                    if (b == null && context != null) {
                        if (a) {
                            Log.d("SystemInfoCacheHelper", "need create system info");
                        }
                        b = a(context);
                    }
                    if (a) {
                        Log.d("SystemInfoCacheHelper", "end pre cache system info");
                    }
                }
            }
        }
    }

    public static synchronized void f() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65542, null) == null) {
            synchronized (rq1.class) {
                if (a) {
                    Log.d("SystemInfoCacheHelper", "release cache system info");
                }
                b = null;
            }
        }
    }
}
