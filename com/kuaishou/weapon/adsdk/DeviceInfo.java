package com.kuaishou.weapon.adsdk;

import android.app.ActivityManager;
import android.content.Context;
import android.location.Location;
import android.media.AudioManager;
import android.net.wifi.ScanResult;
import android.net.wifi.WifiManager;
import android.os.BatteryManager;
import android.os.Build;
import android.os.Environment;
import android.os.StatFs;
import android.os.SystemClock;
import android.provider.Settings;
import androidx.core.view.InputDeviceCompat;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.kuaishou.weapon.un.f;
import com.kuaishou.weapon.un.g;
import com.kuaishou.weapon.un.h;
import com.kuaishou.weapon.un.v;
import java.io.File;
import java.math.BigDecimal;
import java.util.List;
import org.webrtc.MediaStreamTrack;
/* loaded from: classes3.dex */
public class DeviceInfo {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public DeviceInfo() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
            }
        }
    }

    public static int getActivePhoneCount(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65537, null, context)) == null) ? h.b(context) : invokeL.intValue;
    }

    public static String getAndroidId(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65538, null, context)) == null) ? h.c(context) : (String) invokeL.objValue;
    }

    public static int[] getAudioVolumes(Context context, int i2) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLI = interceptable.invokeLI(65539, null, context, i2)) == null) ? h.a(context, i2) : (int[]) invokeLI.objValue;
    }

    public static String getBaseBandVersion() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, null)) == null) {
            if (Build.VERSION.SDK_INT >= 14) {
                return Build.getRadioVersion();
            }
            return null;
        }
        return (String) invokeV.objValue;
    }

    public static int[] getBaseStationInfo(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65541, null, context)) == null) ? h.d(context) : (int[]) invokeL.objValue;
    }

    public static int getBatteryPercent(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65542, null, context)) == null) {
            if (v.a(context).a(512)) {
                try {
                    if (Build.VERSION.SDK_INT >= 21) {
                        return ((BatteryManager) context.getApplicationContext().getSystemService("batterymanager")).getIntProperty(4);
                    }
                } catch (Exception unused) {
                }
                return 0;
            }
            return 0;
        }
        return invokeL.intValue;
    }

    public static long getBootTime() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65543, null)) == null) ? SystemClock.elapsedRealtime() / 1000 : invokeV.longValue;
    }

    public static int getChargeType(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65544, null, context)) == null) ? h.f(context) : invokeL.intValue;
    }

    public static double getDataAvailableGB() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65545, null)) == null) {
            try {
                if (v.a().a(1024)) {
                    return BigDecimal.valueOf(((float) (new StatFs(Environment.getDataDirectory().getPath()).getAvailableBytes() >> 20)) / 1024.0f).setScale(2, 4).floatValue();
                }
                return 0.0d;
            } catch (Exception unused) {
                return 0.0d;
            }
        }
        return invokeV.doubleValue;
    }

    public static double getDataTotalGB() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65546, null)) == null) {
            try {
                return BigDecimal.valueOf(((float) (new StatFs(Environment.getDataDirectory().getPath()).getTotalBytes() >> 20)) / 1024.0f).setScale(2, 4).floatValue();
            } catch (Exception unused) {
                return 0.0d;
            }
        }
        return invokeV.doubleValue;
    }

    public static double getExternalStorageAvailableGB() {
        InterceptResult invokeV;
        File externalStorageDirectory;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65547, null)) == null) {
            try {
                if (v.a().a(1024) && "mounted".equals(Environment.getExternalStorageState()) && (externalStorageDirectory = Environment.getExternalStorageDirectory()) != null) {
                    return BigDecimal.valueOf(((float) (new StatFs(externalStorageDirectory.getPath()).getAvailableBytes() >> 20)) / 1024.0f).setScale(2, 4).floatValue();
                }
                return 0.0d;
            } catch (Exception unused) {
                return 0.0d;
            }
        }
        return invokeV.doubleValue;
    }

    public static double getExternalStorageTotalGB() {
        InterceptResult invokeV;
        File externalStorageDirectory;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65548, null)) == null) {
            try {
                if (!"mounted".equals(Environment.getExternalStorageState()) || (externalStorageDirectory = Environment.getExternalStorageDirectory()) == null) {
                    return 0.0d;
                }
                return BigDecimal.valueOf(((float) (new StatFs(externalStorageDirectory.getPath()).getTotalBytes() >> 20)) / 1024.0f).setScale(2, 4).floatValue();
            } catch (Exception unused) {
                return 0.0d;
            }
        }
        return invokeV.doubleValue;
    }

    public static String getFingerPrint() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65549, null)) == null) ? Build.FINGERPRINT : (String) invokeV.objValue;
    }

    public static String getICCID(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65550, null, context)) == null) ? h.g(context) : (String) invokeL.objValue;
    }

    public static String[] getIMEIs(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65551, null, context)) == null) ? h.h(context) : (String[]) invokeL.objValue;
    }

    public static String getIMSI(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65552, null, context)) == null) ? h.i(context) : (String) invokeL.objValue;
    }

    public static String getImei(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65553, null, context)) == null) ? h.j(context) : (String) invokeL.objValue;
    }

    public static String getIpAddressString() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65554, null)) == null) ? h.a() : (String) invokeV.objValue;
    }

    public static Location getLocation(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65555, null, context)) == null) ? f.a(context) : (Location) invokeL.objValue;
    }

    public static String getMacAddress(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65556, null, context)) == null) ? h.k(context) : (String) invokeL.objValue;
    }

    public static String getMeid(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65557, null, context)) == null) ? h.l(context) : (String) invokeL.objValue;
    }

    public static int getPhoneCount(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65558, null, context)) == null) ? h.m(context) : invokeL.intValue;
    }

    public static long getRamAvailableSize(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65559, null, context)) == null) {
            if (context != null && v.a(context).a(1024)) {
                try {
                    ActivityManager.MemoryInfo memoryInfo = new ActivityManager.MemoryInfo();
                    ((ActivityManager) context.getSystemService("activity")).getMemoryInfo(memoryInfo);
                    return memoryInfo.availMem;
                } catch (Exception unused) {
                    return 0L;
                }
            }
            return 0L;
        }
        return invokeL.longValue;
    }

    public static long getRamTotalSize(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65560, null, context)) == null) {
            if (context == null) {
                return 0L;
            }
            try {
                ActivityManager.MemoryInfo memoryInfo = new ActivityManager.MemoryInfo();
                ((ActivityManager) context.getApplicationContext().getSystemService("activity")).getMemoryInfo(memoryInfo);
                long j2 = memoryInfo.totalMem;
                return j2 <= 0 ? h.b() : j2;
            } catch (Exception unused) {
                return 0L;
            }
        }
        return invokeL.longValue;
    }

    public static int getRingerMode(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65561, null, context)) == null) {
            if (v.a(context).a(256)) {
                try {
                    AudioManager audioManager = (AudioManager) context.getSystemService(MediaStreamTrack.AUDIO_TRACK_KIND);
                    if (audioManager != null) {
                        return audioManager.getRingerMode();
                    }
                } catch (Exception unused) {
                }
                return -1;
            }
            return -1;
        }
        return invokeL.intValue;
    }

    public static long getRomAvailableSpace() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65562, null)) == null) {
            try {
                if (v.a().a(1024)) {
                    StatFs statFs = new StatFs(Environment.getDataDirectory().getPath());
                    return Build.VERSION.SDK_INT < 18 ? statFs.getBlockSize() * statFs.getAvailableBlocks() : statFs.getBlockSizeLong() * statFs.getAvailableBlocksLong();
                }
                return 0L;
            } catch (Exception unused) {
                return 0L;
            }
        }
        return invokeV.longValue;
    }

    public static long getRomBuildTimestamp() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65563, null)) == null) ? Build.TIME : invokeV.longValue;
    }

    public static String getRomName() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65564, null)) == null) ? g.a() : (String) invokeV.objValue;
    }

    public static long getRomTotalSpace() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65565, null)) == null) {
            try {
                if (v.a().a(1024)) {
                    StatFs statFs = new StatFs(Environment.getDataDirectory().getPath());
                    return Build.VERSION.SDK_INT < 18 ? statFs.getBlockSize() * statFs.getBlockCount() : statFs.getBlockSizeLong() * statFs.getBlockCountLong();
                }
                return 0L;
            } catch (Exception unused) {
                return 0L;
            }
        }
        return invokeV.longValue;
    }

    public static String getRomVersion() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65566, null)) == null) ? g.b() : (String) invokeV.objValue;
    }

    public static float getScreenBrightness(Context context) {
        int i2;
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65567, null, context)) == null) {
            try {
                i2 = Settings.System.getInt(context.getContentResolver(), "screen_brightness");
            } catch (Exception unused) {
                i2 = -1;
            }
            return i2;
        }
        return invokeL.floatValue;
    }

    public static String getWifiIpAddress(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65568, null, context)) == null) ? h.p(context) : (String) invokeL.objValue;
    }

    public static List<ScanResult> getWifiScanResults(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65569, null, context)) == null) {
            if (context != null && v.a(context).a(32)) {
                try {
                    if (!h.t(context)) {
                        return ((WifiManager) context.getSystemService("wifi")).getScanResults();
                    }
                } catch (Exception unused) {
                }
                return null;
            }
            return null;
        }
        return (List) invokeL.objValue;
    }

    public static boolean isCharging(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65570, null, context)) == null) ? h.r(context) : invokeL.booleanValue;
    }

    public static List<String> queryInstalledAppList(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65571, null, context)) == null) ? h.u(context) : (List) invokeL.objValue;
    }
}
