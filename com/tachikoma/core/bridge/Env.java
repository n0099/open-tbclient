package com.tachikoma.core.bridge;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.res.Resources;
import android.os.Build;
import androidx.core.view.InputDeviceCompat;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.baidu.webkit.internal.CfgFileUtils;
import com.tachikoma.core.component.anim.AnimationProperty;
import com.tachikoma.core.utility.TKConverter;
import com.tencent.connect.common.Constants;
import java.util.HashMap;
/* loaded from: classes4.dex */
public class Env {
    public static /* synthetic */ Interceptable $ic;
    public static TKEnvListener mEnvListener;
    public static HashMap<String, Object> sContextInfo;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes4.dex */
    public interface TKEnvListener {
        void onUpdate(HashMap<String, Object> hashMap);
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(528398974, "Lcom/tachikoma/core/bridge/Env;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(528398974, "Lcom/tachikoma/core/bridge/Env;");
                return;
            }
        }
        sContextInfo = new HashMap<>();
    }

    public Env(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
            }
        }
    }

    public static String getApplicationName(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, context)) == null) {
            ApplicationInfo applicationInfo = context.getApplicationInfo();
            int i2 = applicationInfo.labelRes;
            try {
                return i2 == 0 ? applicationInfo.nonLocalizedLabel.toString() : context.getString(i2);
            } catch (Exception e2) {
                e2.printStackTrace();
                return applicationInfo.name;
            }
        }
        return (String) invokeL.objValue;
    }

    public static String getApplicationVersion(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65539, null, context)) == null) ? context.getPackageManager().getPackageInfo(context.getPackageName(), 0).versionName : (String) invokeL.objValue;
    }

    public static void initEnvironment(Context context) {
        String str;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, context) == null) {
            String applicationName = getApplicationName(context);
            try {
                str = getApplicationVersion(context);
            } catch (Throwable unused) {
                str = "unknown";
            }
            String str2 = Build.VERSION.RELEASE;
            int i2 = Resources.getSystem().getDisplayMetrics().widthPixels;
            int i3 = Resources.getSystem().getDisplayMetrics().heightPixels;
            float f2 = context.getResources().getDisplayMetrics().density;
            int px2dp = (int) TKConverter.px2dp(context, i2);
            int px2dp2 = (int) TKConverter.px2dp(context, i3);
            sContextInfo.put(Constants.PARAM_PLATFORM, "Android");
            sContextInfo.put("appName", applicationName);
            sContextInfo.put("appVersion", str);
            sContextInfo.put("sysVersion", str2);
            sContextInfo.put("deviceWidth", Integer.valueOf(px2dp));
            sContextInfo.put("deviceHeight", Integer.valueOf(px2dp2));
            sContextInfo.put("availableWidth", Integer.valueOf(px2dp));
            sContextInfo.put("availableHeight", Integer.valueOf(px2dp2));
            sContextInfo.put(CfgFileUtils.KEY_ENGINE_VERSION, "0.0.14-SNAPSHOT-adapt-commercial_alliance-0dea39ff");
            sContextInfo.put(AnimationProperty.SCALE, Float.valueOf(f2));
        }
    }

    public static void put(String str, Object obj) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65541, null, str, obj) == null) {
            sContextInfo.put(str, obj);
            TKEnvListener tKEnvListener = mEnvListener;
            if (tKEnvListener != null) {
                tKEnvListener.onUpdate(sContextInfo);
            }
        }
    }
}
