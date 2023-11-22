package com.fun.ad.sdk.channel;

import android.app.ActivityManager;
import android.content.Context;
import android.os.Build;
import android.os.Process;
import android.webkit.WebView;
import com.baidu.mobads.sdk.api.BDAdConfig;
import com.baidu.mobads.sdk.api.MobadsPermissionSettings;
import com.baidu.tieba.oxb;
import com.baidu.tieba.rxb;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.fun.ad.sdk.FunAdConfig;
import com.fun.ad.sdk.ModuleAdConfig;
import com.fun.ad.sdk.channel.ModuleConfigBaidu;
import com.fun.ad.sdk.internal.api.Module;
import com.fun.ad.sdk.internal.api.PidLoaderCreator;
import com.fun.ad.sdk.internal.api.utils.LogPrinter;
/* loaded from: classes9.dex */
public class BaiduModule implements Module {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public BaiduModule() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
            }
        }
    }

    @Override // com.fun.ad.sdk.internal.api.Module
    public PidLoaderCreator init(FunAdConfig funAdConfig, String str) {
        InterceptResult invokeLL;
        ActivityManager activityManager;
        String str2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, funAdConfig, str)) == null) {
            Object obj = (ModuleAdConfig) funAdConfig.moduleConfigMap.get("baidu");
            if (obj == null) {
                obj = new ModuleConfigBaidu.Builder().build();
            }
            if (obj instanceof ModuleConfigBaidu) {
                ModuleConfigBaidu moduleConfigBaidu = (ModuleConfigBaidu) obj;
                new BDAdConfig.Builder().setAppName(funAdConfig.appName).setAppsid(str).build(funAdConfig.appContext).init();
                try {
                    MobadsPermissionSettings.setPermissionReadDeviceID(moduleConfigBaidu.bdCanReadDeviceId);
                    MobadsPermissionSettings.setPermissionAppList(moduleConfigBaidu.bdCanReadAppList);
                    MobadsPermissionSettings.setPermissionLocation(moduleConfigBaidu.bdCanUseLocation);
                    MobadsPermissionSettings.setPermissionStorage(moduleConfigBaidu.bdCanUseStorage);
                } catch (Exception unused) {
                }
                MobadsPermissionSettings.setLimitPersonalAds(!funAdConfig.runtimeAdConfig.personalRecommendStatus);
                try {
                    if (Build.VERSION.SDK_INT >= 28) {
                        Context context = funAdConfig.appContext;
                        if (context != null && (activityManager = (ActivityManager) context.getSystemService("activity")) != null) {
                            for (ActivityManager.RunningAppProcessInfo runningAppProcessInfo : activityManager.getRunningAppProcesses()) {
                                if (runningAppProcessInfo.pid == Process.myPid()) {
                                    str2 = runningAppProcessInfo.processName;
                                    break;
                                }
                            }
                        }
                        str2 = null;
                        if (!funAdConfig.appContext.getPackageName().equals(str2)) {
                            WebView.setDataDirectorySuffix(str2);
                        }
                    }
                } catch (Exception unused2) {
                    LogPrinter.e("baidu init webview error", new Object[0]);
                }
                funAdConfig.runtimeAdConfig.registerPersonalRecommendObserver(new oxb.a());
                return new rxb();
            }
            throw new RuntimeException("The baidu config need ModuleConfigBaidu!");
        }
        return (PidLoaderCreator) invokeLL.objValue;
    }
}
