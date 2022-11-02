package com.yy.hiidostatis.provider;

import android.app.Application;
import android.content.Context;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.yy.hiidostatis.api.OnStatisListener;
import com.yy.hiidostatis.defs.listener.ActAdditionListenerController;
import com.yy.hiidostatis.defs.listener.ActListener;
import com.yy.hiidostatis.defs.listener.HiidoSdkAdditionDelegate;
import com.yy.hiidostatis.pref.HdStatisConfig;
import java.util.Set;
/* loaded from: classes8.dex */
public class MessageConfig {
    public static /* synthetic */ Interceptable $ic = null;
    public static final int MIN_INTERVAL = 5;
    public static final String SDK_VER = "4.0.23";
    public transient /* synthetic */ FieldHolder $fh;
    public Application ApplicationContext;
    public float accelerometerThreshold;
    public String appId;
    public String appkey;
    public String appsflyer;
    public int batchThreshold;
    public String bdCuid;
    public String cacheFileName;
    public int defaultMetricsExpire;
    public int defaultMetricsInterval;
    public String from;
    public boolean gaidEnable;
    public float gyroscopeThreshold;
    public Set<String> ignoreActivity;
    public int interval;
    public boolean isLogOn;
    public final boolean isMainConfig;
    public boolean isOpenCrashMonitor;
    public boolean lifecycleMonitor;
    public float lightThreshold;
    public ActAdditionListenerController mActListenerController;
    public boolean openAutoTrack;
    public boolean openSDKMetrics;
    public boolean openSensorMonitor;
    public boolean reportApplist;
    public String sessionId;
    public OnStatisListener uidProvider;
    public String ver;

    public MessageConfig(Context context, String str, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, str, Boolean.valueOf(z)};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.cacheFileName = "hdcommon_module_used_file";
        this.isOpenCrashMonitor = true;
        this.isLogOn = false;
        this.reportApplist = false;
        this.defaultMetricsExpire = 1800;
        this.defaultMetricsInterval = 60;
        this.openSDKMetrics = true;
        this.openAutoTrack = false;
        this.gyroscopeThreshold = 0.5f;
        this.accelerometerThreshold = 0.6f;
        this.lightThreshold = 15.0f;
        this.openSensorMonitor = false;
        this.gaidEnable = false;
        this.interval = 30;
        this.batchThreshold = 20;
        this.mActListenerController = new ActAdditionListenerController();
        this.ApplicationContext = (Application) (context instanceof Application ? context : context.getApplicationContext());
        this.appkey = str;
        this.isMainConfig = z;
        this.cacheFileName = HdStatisConfig.getConfig(str).getCacheFileName();
    }

    public void addActAdditionListener(ActListener actListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, actListener) == null) {
            this.mActListenerController.add(actListener);
        }
    }

    public void removeActAdditionListerner(ActListener actListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048605, this, actListener) == null) {
            this.mActListenerController.remove(actListener);
        }
    }

    public void setAccelerometerThreshold(float f) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeF(1048606, this, f) == null) {
            this.accelerometerThreshold = f;
        }
    }

    public void setAdditionParamsDelegate(HiidoSdkAdditionDelegate hiidoSdkAdditionDelegate) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048607, this, hiidoSdkAdditionDelegate) == null) {
            this.mActListenerController.setHiidoSdkAdditionDelegate(hiidoSdkAdditionDelegate);
        }
    }

    public void setAppId(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048608, this, str) == null) {
            this.appId = str;
        }
    }

    public void setAppkey(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048609, this, str) == null) {
            this.appkey = str;
        }
    }

    public void setAppsflyer(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048610, this, str) == null) {
            this.appsflyer = str;
        }
    }

    public void setBatchThreshold(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048611, this, i) == null) {
            this.batchThreshold = i;
        }
    }

    public void setBdCuid(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048612, this, str) == null) {
            this.bdCuid = str;
        }
    }

    public void setDefaultMetricsExpire(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048613, this, i) == null) {
            this.defaultMetricsExpire = i;
        }
    }

    public void setDefaultMetricsInterval(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048614, this, i) == null) {
            this.defaultMetricsInterval = i;
        }
    }

    public void setFrom(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048615, this, str) == null) {
            this.from = str;
        }
    }

    public void setGaidEnable(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048616, this, z) == null) {
            this.gaidEnable = z;
        }
    }

    public void setGyroscopeThreshold(float f) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeF(1048617, this, f) == null) {
            this.gyroscopeThreshold = f;
        }
    }

    public void setIgnoreActivity(Set<String> set) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048618, this, set) == null) {
            this.ignoreActivity = set;
        }
    }

    public void setInterval(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048619, this, i) == null) {
            this.interval = i;
        }
    }

    public void setLifecycleMonitor(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048620, this, z) == null) {
            this.lifecycleMonitor = z;
        }
    }

    public void setLightThreshold(float f) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeF(1048621, this, f) == null) {
            this.lightThreshold = f;
        }
    }

    public void setLogOn(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048622, this, z) == null) {
            this.isLogOn = z;
        }
    }

    public void setOpenAutoTrack(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048623, this, z) == null) {
            this.openAutoTrack = z;
        }
    }

    public void setOpenCrashMonitor(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048624, this, z) == null) {
            this.isOpenCrashMonitor = z;
        }
    }

    public void setOpenSDKMetrics(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048625, this, z) == null) {
            this.openSDKMetrics = z;
        }
    }

    public void setOpenSensorMonitor(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048626, this, z) == null) {
            this.openSensorMonitor = z;
        }
    }

    public void setReportApplist(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048627, this, z) == null) {
            this.reportApplist = z;
        }
    }

    public void setSessionId(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048628, this, str) == null) {
            this.sessionId = str;
        }
    }

    public void setUidProvider(OnStatisListener onStatisListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048629, this, onStatisListener) == null) {
            this.uidProvider = onStatisListener;
        }
    }

    public void setVer(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048630, this, str) == null) {
            this.ver = str;
        }
    }

    public float getAccelerometerThreshold() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            return this.accelerometerThreshold;
        }
        return invokeV.floatValue;
    }

    public ActAdditionListenerController getActListenerController() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            return this.mActListenerController;
        }
        return (ActAdditionListenerController) invokeV.objValue;
    }

    public String getAppId() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            return this.appId;
        }
        return (String) invokeV.objValue;
    }

    public String getAppkey() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            return this.appkey;
        }
        return (String) invokeV.objValue;
    }

    public Context getApplicationContext() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            return this.ApplicationContext;
        }
        return (Context) invokeV.objValue;
    }

    public String getAppsflyer() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            return this.appsflyer;
        }
        return (String) invokeV.objValue;
    }

    public int getBatchThreshold() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            return this.batchThreshold;
        }
        return invokeV.intValue;
    }

    public String getBdCuid() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            return this.bdCuid;
        }
        return (String) invokeV.objValue;
    }

    public String getCacheFileName() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) {
            return this.cacheFileName;
        }
        return (String) invokeV.objValue;
    }

    public int getDefaultMetricsExpire() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) {
            return this.defaultMetricsExpire;
        }
        return invokeV.intValue;
    }

    public int getDefaultMetricsInterval() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) {
            return this.defaultMetricsInterval;
        }
        return invokeV.intValue;
    }

    public String getFrom() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) {
            return this.from;
        }
        return (String) invokeV.objValue;
    }

    public float getGyroscopeThreshold() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) {
            return this.gyroscopeThreshold;
        }
        return invokeV.floatValue;
    }

    public Set<String> getIgnoreActivity() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048590, this)) == null) {
            return this.ignoreActivity;
        }
        return (Set) invokeV.objValue;
    }

    public int getInterval() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048591, this)) == null) {
            return this.interval;
        }
        return invokeV.intValue;
    }

    public float getLightThreshold() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048592, this)) == null) {
            return this.lightThreshold;
        }
        return invokeV.floatValue;
    }

    public String getSessionId() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048593, this)) == null) {
            return this.sessionId;
        }
        return (String) invokeV.objValue;
    }

    public OnStatisListener getUidProvider() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048594, this)) == null) {
            return this.uidProvider;
        }
        return (OnStatisListener) invokeV.objValue;
    }

    public String getVer() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048595, this)) == null) {
            return this.ver;
        }
        return (String) invokeV.objValue;
    }

    public boolean isGaidEnable() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048596, this)) == null) {
            return this.gaidEnable;
        }
        return invokeV.booleanValue;
    }

    public boolean isLifecycleMonitor() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048597, this)) == null) {
            return this.lifecycleMonitor;
        }
        return invokeV.booleanValue;
    }

    public boolean isLogOn() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048598, this)) == null) {
            return this.isLogOn;
        }
        return invokeV.booleanValue;
    }

    public boolean isMainConfig() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048599, this)) == null) {
            return this.isMainConfig;
        }
        return invokeV.booleanValue;
    }

    public boolean isOpenAutoTrack() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048600, this)) == null) {
            return this.openAutoTrack;
        }
        return invokeV.booleanValue;
    }

    public boolean isOpenCrashMonitor() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048601, this)) == null) {
            return this.isOpenCrashMonitor;
        }
        return invokeV.booleanValue;
    }

    public boolean isOpenSDKMetrics() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048602, this)) == null) {
            return this.openSDKMetrics;
        }
        return invokeV.booleanValue;
    }

    public boolean isOpenSensorMonitor() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048603, this)) == null) {
            return this.openSensorMonitor;
        }
        return invokeV.booleanValue;
    }

    public boolean isReportApplist() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048604, this)) == null) {
            return this.reportApplist;
        }
        return invokeV.booleanValue;
    }
}
