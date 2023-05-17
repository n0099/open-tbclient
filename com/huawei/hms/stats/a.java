package com.huawei.hms.stats;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.provider.Settings;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.huawei.hms.framework.network.grs.GrsApp;
import com.huawei.hms.support.log.HMSLog;
/* loaded from: classes9.dex */
public class a {
    public static /* synthetic */ Interceptable $ic;
    public static int a;
    public static final Object b;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(869193753, "Lcom/huawei/hms/stats/a;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(869193753, "Lcom/huawei/hms/stats/a;");
                return;
            }
        }
        b = new Object();
    }

    public static boolean a(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, context)) == null) {
            if (context == null) {
                HMSLog.e("AnalyticsSwitchHolder", "In getBiIsReportSetting, context is null.");
                return false;
            }
            PackageManager packageManager = context.getPackageManager();
            if (packageManager != null) {
                try {
                    ApplicationInfo applicationInfo = packageManager.getPackageInfo(context.getPackageName(), 128).applicationInfo;
                    if (applicationInfo != null && applicationInfo.metaData != null) {
                        return applicationInfo.metaData.getBoolean("com.huawei.hms.client.bireport.setting");
                    }
                } catch (PackageManager.NameNotFoundException unused) {
                    HMSLog.e("AnalyticsSwitchHolder", "In getBiIsReportSetting, Failed to read meta data bi report setting.");
                } catch (RuntimeException e) {
                    HMSLog.e("AnalyticsSwitchHolder", "In getBiIsReportSetting, Failed to read meta data bi report setting.", e);
                }
            }
            HMSLog.i("AnalyticsSwitchHolder", "In getBiIsReportSetting, configuration not found for bi report setting.");
            return false;
        }
        return invokeL.booleanValue;
    }

    public static boolean b(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, context)) == null) {
            if (context == null) {
                HMSLog.e("AnalyticsSwitchHolder", "In getBiSetting, context is null.");
                return false;
            }
            PackageManager packageManager = context.getPackageManager();
            if (packageManager != null) {
                try {
                    ApplicationInfo applicationInfo = packageManager.getPackageInfo(context.getPackageName(), 128).applicationInfo;
                    if (applicationInfo != null && applicationInfo.metaData != null) {
                        return applicationInfo.metaData.getBoolean("com.huawei.hms.client.bi.setting");
                    }
                } catch (PackageManager.NameNotFoundException unused) {
                    HMSLog.e("AnalyticsSwitchHolder", "In getBiSetting, Failed to read meta data bisetting.");
                } catch (RuntimeException e) {
                    HMSLog.e("AnalyticsSwitchHolder", "In getBiSetting, Failed to read meta data bisetting.", e);
                }
            }
            HMSLog.i("AnalyticsSwitchHolder", "In getBiSetting, configuration not found for bisetting.");
            return false;
        }
        return invokeL.booleanValue;
    }

    public static boolean c(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65539, null, context)) == null) {
            synchronized (b) {
                boolean z = true;
                if (a == 0) {
                    if (context == null) {
                        return true;
                    }
                    if (a(context)) {
                        HMSLog.i("AnalyticsSwitchHolder", "Builder->biReportSetting :true");
                        a = 1;
                    } else if (b(context)) {
                        HMSLog.i("AnalyticsSwitchHolder", "Builder->biSetting :true");
                        a = 2;
                    } else if ("CN".equalsIgnoreCase(GrsApp.getInstance().getIssueCountryCode(context))) {
                        a = 1;
                    } else {
                        HMSLog.i("AnalyticsSwitchHolder", "not ChinaROM");
                        try {
                            int i = Settings.Secure.getInt(context.getContentResolver(), "hw_app_analytics_state");
                            HMSLog.i("AnalyticsSwitchHolder", "hw_app_analytics_state value is " + i);
                            if (i == 1) {
                                a = 1;
                            } else {
                                a = 2;
                            }
                        } catch (Settings.SettingNotFoundException unused) {
                            HMSLog.i("AnalyticsSwitchHolder", "Get OOBE failed");
                            a = 2;
                        }
                    }
                }
                if (a == 1) {
                    z = false;
                }
                return z;
            }
        }
        return invokeL.booleanValue;
    }
}
