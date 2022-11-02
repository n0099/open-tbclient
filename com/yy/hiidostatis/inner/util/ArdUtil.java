package com.yy.hiidostatis.inner.util;

import android.annotation.SuppressLint;
import android.app.ActivityManager;
import android.bluetooth.BluetoothAdapter;
import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.graphics.Point;
import android.media.AudioManager;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.TrafficStats;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import android.os.Build;
import android.os.Bundle;
import android.os.Environment;
import android.os.LocaleList;
import android.os.StatFs;
import android.provider.Settings;
import android.telephony.CellLocation;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.WindowManager;
import androidx.core.app.NotificationCompat;
import androidx.core.view.InputDeviceCompat;
import com.baidu.mobstat.Config;
import com.baidu.searchbox.aideviceperformance.utils.HardwareInfoUtils;
import com.baidu.tbadk.core.util.ApiReplaceUtil;
import com.baidu.tbadk.core.util.httpNet.HttpRequest;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.kuaishou.weapon.p0.h;
import com.kuaishou.weapon.p0.k1;
import com.yy.hiidostatis.inner.util.log.L;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileFilter;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.NetworkInterface;
import java.net.Socket;
import java.util.Enumeration;
import java.util.Locale;
import java.util.TimeZone;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.aspectj.runtime.reflect.SignatureImpl;
/* loaded from: classes8.dex */
public class ArdUtil {
    public static /* synthetic */ Interceptable $ic = null;
    public static final int NET_2G = 1;
    public static final int NET_3G = 2;
    public static final int NET_4G = 4;
    public static final int NET_UNKNOWN = 0;
    public static final int NET_WIFI = 3;
    public static String mAndroidId = null;
    public static String mCpuAbi = null;
    public static String mCpuName = null;
    public static int mCpuNum = 0;
    public static String mImei = null;
    public static String mImsi = null;
    public static String mLang = null;
    public static String mMacAddress = null;
    public static String mMacAddressV23 = null;
    public static String mMaxpuFreq = null;
    public static String mNtm = null;
    public static String mOS = null;
    public static String mScreenResolution = null;
    public static long mTotal = 0;
    public static long mTotalInternalStorgeSize = 0;
    public static long mTotalMem = 0;
    public static int mVer = -1;
    public static String mVersionName;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(-723770265, "Lcom/yy/hiidostatis/inner/util/ArdUtil;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(-723770265, "Lcom/yy/hiidostatis/inner/util/ArdUtil;");
        }
    }

    public ArdUtil() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
            }
        }
    }

    public static int getAvailableProcessors() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65542, null)) == null) {
            try {
                return Runtime.getRuntime().availableProcessors();
            } catch (Throwable th) {
                L.debug("ArdUtil", "getAvailableProcessors exception . %s", th);
                return -1;
            }
        }
        return invokeV.intValue;
    }

    public static String getOS() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65563, null)) == null) {
            String str = mOS;
            if (str != null) {
                return str;
            }
            String format = String.format("Android%s", Build.VERSION.RELEASE);
            mOS = format;
            return format;
        }
        return (String) invokeV.objValue;
    }

    @SuppressLint({"NewApi"})
    public static long getTotalRxBytes() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65576, null)) == null) {
            if (Build.VERSION.SDK_INT >= 8) {
                return TrafficStats.getTotalRxBytes();
            }
            return 0L;
        }
        return invokeV.longValue;
    }

    @SuppressLint({"NewApi"})
    public static long getTotalTxBytes() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65577, null)) == null) {
            if (Build.VERSION.SDK_INT >= 8) {
                return TrafficStats.getTotalTxBytes();
            }
            return 0L;
        }
        return invokeV.longValue;
    }

    public static boolean isRoot() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65589, null)) == null) {
            if (!new File("/system/bin/su").exists() && !new File("/system/xbin/su").exists()) {
                return false;
            }
            return true;
        }
        return invokeV.booleanValue;
    }

    /* JADX WARN: Code restructure failed: missing block: B:11:0x001f, code lost:
        if (r4.getPackageManager().checkPermission(r5, r4.getPackageName()) == 0) goto L10;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static boolean checkPermissions(Context context, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65538, null, context, str)) == null) {
            boolean z = true;
            try {
                if (Build.VERSION.SDK_INT >= 23) {
                    if (context.checkSelfPermission(str) == 0) {
                    }
                    z = false;
                }
                return z;
            } catch (Throwable th) {
                L.debug("ArdUtil", "checkPermissions Throwable: %s", th);
                return false;
            }
        }
        return invokeLL.booleanValue;
    }

    public static String getAndroidId(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65539, null, context)) == null) {
            try {
            } catch (Throwable th) {
                L.debug("ArdUtil", "Exception when getAndroidId %s", th);
            }
            if (mAndroidId != null) {
                return mAndroidId;
            }
            mAndroidId = ApiReplaceUtil.Overload.getString(context.getContentResolver(), HttpRequest.ANDROID_ID);
            return mAndroidId;
        }
        return (String) invokeL.objValue;
    }

    public static long getAvailMemory(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65541, null, context)) == null) {
            try {
                ActivityManager.MemoryInfo memoryInfo = new ActivityManager.MemoryInfo();
                ((ActivityManager) context.getSystemService("activity")).getMemoryInfo(memoryInfo);
                return memoryInfo.availMem / 1024;
            } catch (Throwable th) {
                L.debug("ArdUtil", "getAvailMemory exception . %s", th);
                return 0L;
            }
        }
        return invokeL.longValue;
    }

    public static String getBluetoothMac(Context context) {
        InterceptResult invokeL;
        BluetoothAdapter defaultAdapter;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65543, null, context)) == null) {
            try {
                if (!checkPermissions(context, "android.permission.BLUETOOTH") || (defaultAdapter = BluetoothAdapter.getDefaultAdapter()) == null) {
                    return "";
                }
                return defaultAdapter.getAddress();
            } catch (Throwable th) {
                L.debug("ArdUtil", "getBluetoothMac exception . %s", th);
            }
        } else {
            return (String) invokeL.objValue;
        }
        return "";
    }

    public static int getDeviceOrientation(Context context) {
        InterceptResult invokeL;
        int i;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65551, null, context)) == null) {
            try {
                i = context.getResources().getConfiguration().orientation;
            } catch (Throwable th) {
                L.debug("ArdUtil", "getDeviceOrientation exception . %s", th);
            }
            if (i == 2) {
                return 1;
            }
            return i == 1 ? 0 : 0;
        }
        return invokeL.intValue;
    }

    public static String getMacAddrV23(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65557, null, context)) == null) {
            if (isValidMac(mMacAddressV23)) {
                return mMacAddressV23;
            }
            String macAddr = getMacAddr(context);
            mMacAddressV23 = macAddr;
            if (!isValidMac(macAddr)) {
                String macAddr2 = getMacAddr2();
                if (isValidMac(macAddr2)) {
                    mMacAddressV23 = macAddr2;
                }
            }
            return mMacAddressV23;
        }
        return (String) invokeL.objValue;
    }

    public static String getVersionName(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65580, null, context)) == null) {
            try {
                if (mVersionName != null) {
                    return mVersionName;
                }
                String str = context.getPackageManager().getPackageInfo(context.getPackageName(), 0).versionName;
                mVersionName = str;
                return str;
            } catch (Throwable unused) {
                L.debug("ArdUtil", "Failed to read version Name.", new Object[0]);
                mVersionName = "";
                return "";
            }
        }
        return (String) invokeL.objValue;
    }

    public static int getVersionNo(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65581, null, context)) == null) {
            try {
                if (mVer != -1) {
                    return mVer;
                }
                int i = context.getPackageManager().getPackageInfo(context.getPackageName(), 0).versionCode;
                mVer = i;
                return i;
            } catch (Throwable unused) {
                L.debug("ArdUtil", "Failed to read version No.", new Object[0]);
                mVer = -1;
                return -1;
            }
        }
        return invokeL.intValue;
    }

    public static WifiInfo getWifiInfo(Context context) {
        InterceptResult invokeL;
        WifiManager wifiManager;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65583, null, context)) == null) {
            try {
                if (!checkPermissions(context, h.d) || (wifiManager = (WifiManager) context.getSystemService("wifi")) == null) {
                    return null;
                }
                return wifiManager.getConnectionInfo();
            } catch (Throwable th) {
                L.debug("ArdUtil", "getWifiInfo exception . %s", th);
                return null;
            }
        }
        return (WifiInfo) invokeL.objValue;
    }

    public static String getWifiName(Context context) {
        InterceptResult invokeL;
        WifiInfo connectionInfo;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65584, null, context)) == null) {
            try {
                if (!checkPermissions(context, h.d) || (connectionInfo = ((WifiManager) context.getSystemService("wifi")).getConnectionInfo()) == null) {
                    return null;
                }
                return connectionInfo.getSSID();
            } catch (Throwable th) {
                L.debug("ArdUtil", th.getMessage(), new Object[0]);
            }
        } else {
            return (String) invokeL.objValue;
        }
        return null;
    }

    public static boolean isHeadphone(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65586, null, context)) == null) {
            try {
                if (checkPermissions(context, "android.permission.MODIFY_AUDIO_SETTINGS")) {
                    return ((AudioManager) context.getSystemService("audio")).isWiredHeadsetOn();
                }
            } catch (Throwable th) {
                L.debug("ArdUtil", "isHeadphone exception . %s", th);
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    public static boolean isNetworkAvailable(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65587, null, context)) == null) {
            try {
                ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService("connectivity");
                NetworkInfo networkInfo = null;
                if (connectivityManager != null) {
                    networkInfo = connectivityManager.getActiveNetworkInfo();
                }
                if (networkInfo == null || !networkInfo.isConnected()) {
                    return false;
                }
                if (!networkInfo.isAvailable()) {
                    return false;
                }
                return true;
            } catch (Throwable th) {
                L.debug("ArdUtil", "isNetworkAvailable Exception: %s", th);
                return true;
            }
        }
        return invokeL.booleanValue;
    }

    public static boolean isWifiActive(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65591, null, context)) == null) {
            if (context == null) {
                L.debug("ArdUtil", "the Input context is null!", new Object[0]);
                return false;
            }
            try {
                ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService("connectivity");
                NetworkInfo networkInfo = null;
                if (connectivityManager != null) {
                    networkInfo = connectivityManager.getActiveNetworkInfo();
                }
                if (networkInfo == null) {
                    return false;
                }
                if (networkInfo.getType() != 1) {
                    return false;
                }
                return true;
            } catch (Throwable th) {
                L.debug("ArdUtil", "isWifiActive Exception: %s", th);
                return true;
            }
        }
        return invokeL.booleanValue;
    }

    public static long getAvailInternalStorgeSize() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, null)) == null) {
            try {
                StatFs statFs = new StatFs(Environment.getDataDirectory().getPath());
                return (statFs.getAvailableBlocks() * statFs.getBlockSize()) / 1024;
            } catch (Throwable th) {
                L.debug("ArdUtil", "getAvailInternalStorgeSize exception . %s", th);
                return 0L;
            }
        }
        return invokeV.longValue;
    }

    public static int getCpuNum() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65548, null)) == null) {
            int i = mCpuNum;
            if (i != 0) {
                return i;
            }
            try {
                int length = new File("/sys/devices/system/cpu/").listFiles(new FileFilter() { // from class: com.yy.hiidostatis.inner.util.ArdUtil.1CpuFilter
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;

                    {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 != null) {
                            InitContext newInitContext = TitanRuntime.newInitContext();
                            interceptable2.invokeUnInit(65536, newInitContext);
                            int i2 = newInitContext.flag;
                            if ((i2 & 1) != 0) {
                                int i3 = i2 & 2;
                                newInitContext.thisArg = this;
                                interceptable2.invokeInitBody(65536, newInitContext);
                            }
                        }
                    }

                    @Override // java.io.FileFilter
                    public boolean accept(File file) {
                        InterceptResult invokeL;
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || (invokeL = interceptable2.invokeL(1048576, this, file)) == null) {
                            return Pattern.matches("cpu[0-9]", file.getName());
                        }
                        return invokeL.booleanValue;
                    }
                }).length;
                mCpuNum = length;
                return length;
            } catch (Throwable th) {
                L.debug("ArdUtil", "getCpuNum exception: %s", th);
                mCpuNum = 1;
                return 1;
            }
        }
        return invokeV.intValue;
    }

    public static String getTimeZone() {
        InterceptResult invokeV;
        char c;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65571, null)) == null) {
            int rawOffset = TimeZone.getDefault().getRawOffset() / 60000;
            if (rawOffset < 0) {
                c = SignatureImpl.SEP;
                rawOffset = -rawOffset;
            } else {
                c = '+';
            }
            return "GMT" + c + (rawOffset / 60);
        }
        return (String) invokeV.objValue;
    }

    public static CellLocation getCellId(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65544, null, context)) == null) {
            try {
                return ((TelephonyManager) context.getSystemService("phone")).getCellLocation();
            } catch (Throwable th) {
                L.debug("ArdUtil", "getCellId exception . %s", th);
                return null;
            }
        }
        return (CellLocation) invokeL.objValue;
    }

    public static int getCurrAppUid(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65549, null, context)) == null) {
            try {
                return context.getApplicationInfo().uid;
            } catch (Throwable th) {
                L.debug("ArdUtil", "getCurrAppUid exception: %s", th);
                return -1;
            }
        }
        return invokeL.intValue;
    }

    public static String getImei(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65552, null, context)) == null) {
            String str = mImei;
            if (str != null) {
                return str;
            }
            return null;
        }
        return (String) invokeL.objValue;
    }

    public static String getImsi(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65553, null, context)) == null) {
            String str = mImsi;
            if (str != null) {
            }
            return str;
        }
        return (String) invokeL.objValue;
    }

    public static String getPackageName(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65564, null, context)) == null) {
            try {
                return context.getPackageName();
            } catch (Throwable unused) {
                L.debug("ArdUtil", "Failed to read package Name.", new Object[0]);
                return "";
            }
        }
        return (String) invokeL.objValue;
    }

    public static String getSafeMacAddr(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65565, null, context)) == null) {
            String macAddrV23 = getMacAddrV23(context);
            if (isValidMac(macAddrV23)) {
                return InsideMode.safeMac(macAddrV23);
            }
            return null;
        }
        return (String) invokeL.objValue;
    }

    public static int getScreenBrightness(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65567, null, context)) == null) {
            try {
                return Settings.System.getInt(context.getContentResolver(), "screen_brightness");
            } catch (Throwable th) {
                L.debug("ArdUtil", "getScreenBrightness exception . %s", th);
                return 0;
            }
        }
        return invokeL.intValue;
    }

    public static String getSjm(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65569, null, context)) == null) {
            return Build.MODEL;
        }
        return (String) invokeL.objValue;
    }

    public static String getSjp(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65570, null, context)) == null) {
            return Build.MANUFACTURER;
        }
        return (String) invokeL.objValue;
    }

    @SuppressLint({"NewApi"})
    public static long getUidRxBytes(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(65578, null, i)) == null) {
            if (Build.VERSION.SDK_INT >= 8) {
                return TrafficStats.getUidRxBytes(i);
            }
            return 0L;
        }
        return invokeI.longValue;
    }

    @SuppressLint({"NewApi"})
    public static long getUidTxBytes(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(65579, null, i)) == null) {
            if (Build.VERSION.SDK_INT >= 8) {
                return TrafficStats.getUidTxBytes(i);
            }
            return 0L;
        }
        return invokeI.longValue;
    }

    public static boolean isDebugEnable(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65585, null, context)) == null) {
            if (Settings.Secure.getInt(context.getContentResolver(), "adb_enabled", 0) <= 0) {
                return false;
            }
            return true;
        }
        return invokeL.booleanValue;
    }

    public static boolean isValidMac(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65590, null, str)) == null) {
            if (!TextUtils.isEmpty(str) && !str.equalsIgnoreCase(Config.DEF_MAC_ID)) {
                return true;
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    public static String getCellIp() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65545, null)) == null) {
            try {
                Enumeration<NetworkInterface> networkInterfaces = NetworkInterface.getNetworkInterfaces();
                while (networkInterfaces.hasMoreElements()) {
                    Enumeration<InetAddress> inetAddresses = networkInterfaces.nextElement().getInetAddresses();
                    while (inetAddresses.hasMoreElements()) {
                        InetAddress nextElement = inetAddresses.nextElement();
                        if (!nextElement.isLoopbackAddress()) {
                            return nextElement.getHostAddress();
                        }
                    }
                }
                return null;
            } catch (Throwable th) {
                L.debug("ArdUtil", "getCellIp exception . %s", th);
                return null;
            }
        }
        return (String) invokeV.objValue;
    }

    public static String getLang() {
        InterceptResult invokeV;
        Locale locale;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65554, null)) == null) {
            String str = mLang;
            if (str != null) {
                return str;
            }
            if (Build.VERSION.SDK_INT >= 24) {
                try {
                    locale = LocaleList.getDefault().get(0);
                } catch (Throwable unused) {
                    locale = Locale.getDefault();
                }
            } else {
                locale = Locale.getDefault();
            }
            String format = String.format("%s-%s", locale.getLanguage(), locale.getCountry());
            mLang = format;
            return format;
        }
        return (String) invokeV.objValue;
    }

    public static long getTotalInternalStorgeSize() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65572, null)) == null) {
            long j = mTotalInternalStorgeSize;
            if (j != 0) {
                return j;
            }
            try {
                StatFs statFs = new StatFs(Environment.getDataDirectory().getPath());
                mTotalInternalStorgeSize = (statFs.getBlockCount() * statFs.getBlockSize()) / 1024;
            } catch (Throwable th) {
                L.debug("ArdUtil", "getTotalInternalStorgeSize exception . %s", th);
            }
            return mTotalInternalStorgeSize;
        }
        return invokeV.longValue;
    }

    public static String getCpuAbi() {
        InterceptResult invokeV;
        BufferedReader bufferedReader;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65546, null)) == null) {
            if (!TextUtils.isEmpty(mCpuAbi)) {
                return mCpuAbi;
            }
            if (Build.VERSION.SDK_INT < 21) {
                String str = Build.CPU_ABI;
                mCpuAbi = str;
                return str;
            }
            try {
                bufferedReader = new BufferedReader(new FileReader(k1.a));
                try {
                    String str2 = bufferedReader.readLine().split(":\\s+", 2)[1];
                    mCpuAbi = str2;
                    try {
                        bufferedReader.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    return str2;
                } catch (Throwable th) {
                    th = th;
                    try {
                        L.debug("ArdUtil", "getCpuAbi exception . %s", th);
                        return null;
                    } finally {
                        if (bufferedReader != null) {
                            try {
                                bufferedReader.close();
                            } catch (IOException e2) {
                                e2.printStackTrace();
                            }
                        }
                    }
                }
            } catch (Throwable th2) {
                th = th2;
                bufferedReader = null;
            }
        } else {
            return (String) invokeV.objValue;
        }
    }

    public static String getCpuName() {
        InterceptResult invokeV;
        BufferedReader bufferedReader;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65547, null)) == null) {
            if (!TextUtils.isEmpty(mCpuName)) {
                return mCpuName;
            }
            try {
                bufferedReader = new BufferedReader(new FileReader(k1.a));
                try {
                    String str = bufferedReader.readLine().split(":\\s+", 2)[1];
                    mCpuName = str;
                    try {
                        bufferedReader.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    return str;
                } catch (Throwable th) {
                    th = th;
                    try {
                        L.debug("ArdUtil", "getCpuName exception: %s", th);
                        return null;
                    } finally {
                        if (bufferedReader != null) {
                            try {
                                bufferedReader.close();
                            } catch (IOException e2) {
                                e2.printStackTrace();
                            }
                        }
                    }
                }
            } catch (Throwable th2) {
                th = th2;
                bufferedReader = null;
            }
        } else {
            return (String) invokeV.objValue;
        }
    }

    @SuppressLint({"NewApi"})
    public static String getMacAddr2() {
        InterceptResult invokeV;
        byte[] hardwareAddress;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65556, null)) == null) {
            String str = null;
            try {
                if (Build.VERSION.SDK_INT >= 9) {
                    Enumeration<NetworkInterface> networkInterfaces = NetworkInterface.getNetworkInterfaces();
                    while (networkInterfaces.hasMoreElements()) {
                        NetworkInterface nextElement = networkInterfaces.nextElement();
                        if (nextElement.getName().equalsIgnoreCase("wlan0") && (hardwareAddress = ApiReplaceUtil.getHardwareAddress(nextElement)) != null && hardwareAddress.length != 0) {
                            StringBuilder sb = new StringBuilder();
                            int length = hardwareAddress.length;
                            for (int i = 0; i < length; i++) {
                                sb.append(String.format("%02X:", Byte.valueOf(hardwareAddress[i])));
                            }
                            if (sb.length() > 0) {
                                sb.deleteCharAt(sb.length() - 1);
                            }
                            str = sb.toString();
                        }
                    }
                }
            } catch (Throwable th) {
                L.debug("ArdUtil", "exception on getMacAddr2 : %s", th);
            }
            return str;
        }
        return (String) invokeV.objValue;
    }

    public static String getMaxCpuFreq() {
        InterceptResult invokeV;
        FileInputStream fileInputStream;
        Object th;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65558, null)) == null) {
            if (!TextUtils.isEmpty(mMaxpuFreq)) {
                return mMaxpuFreq;
            }
            StringBuilder sb = new StringBuilder();
            try {
                try {
                    fileInputStream = new FileInputStream("/sys/devices/system/cpu/cpu0/cpufreq/cpuinfo_max_freq");
                    try {
                        byte[] bArr = new byte[24];
                        while (fileInputStream.read(bArr) != -1) {
                            sb.append(new String(bArr));
                        }
                        fileInputStream.close();
                    } catch (Throwable th2) {
                        th = th2;
                        try {
                            L.debug("ArdUtil", "getMaxCpuFreq exception: %s", th);
                            if (fileInputStream != null) {
                                fileInputStream.close();
                            }
                            String trim = sb.toString().trim();
                            mMaxpuFreq = trim;
                            return trim;
                        } catch (Throwable th3) {
                            if (fileInputStream != null) {
                                try {
                                    fileInputStream.close();
                                } catch (IOException e) {
                                    e.printStackTrace();
                                }
                            }
                            throw th3;
                        }
                    }
                } catch (Throwable th4) {
                    fileInputStream = null;
                    th = th4;
                }
            } catch (IOException e2) {
                e2.printStackTrace();
            }
            String trim2 = sb.toString().trim();
            mMaxpuFreq = trim2;
            return trim2;
        }
        return (String) invokeV.objValue;
    }

    public static long getTotalMemory() {
        InterceptResult invokeV;
        BufferedReader bufferedReader;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65573, null)) == null) {
            long j = mTotal;
            if (j != 0) {
                return j;
            }
            BufferedReader bufferedReader2 = null;
            String str = null;
            try {
                try {
                    bufferedReader = new BufferedReader(new FileReader(HardwareInfoUtils.MEM_INFO_FILE), 8);
                } catch (Throwable th) {
                    th = th;
                }
            } catch (IOException unused) {
            }
            try {
                String readLine = bufferedReader.readLine();
                if (readLine != null) {
                    str = readLine;
                }
                if (!Util.empty(str)) {
                    mTotal = Long.parseLong(str.substring(str.indexOf(58) + 1, str.indexOf(107)).trim().trim());
                }
                bufferedReader.close();
            } catch (Throwable th2) {
                th = th2;
                bufferedReader2 = bufferedReader;
                try {
                    L.debug("ArdUtil", "getTotalMemory exception: %s", th);
                    if (bufferedReader2 != null) {
                        bufferedReader2.close();
                    }
                    return mTotal;
                } catch (Throwable th3) {
                    if (bufferedReader2 != null) {
                        try {
                            bufferedReader2.close();
                        } catch (IOException unused2) {
                        }
                    }
                    throw th3;
                }
            }
        }
        return invokeV.longValue;
    }

    public static long getTotalMemoryFromFile() {
        InterceptResult invokeV;
        RandomAccessFile randomAccessFile;
        Object th;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65575, null)) == null) {
            try {
                randomAccessFile = new RandomAccessFile(HardwareInfoUtils.MEM_INFO_FILE, "r");
                try {
                    Matcher matcher = Pattern.compile("(\\d+)").matcher(randomAccessFile.readLine());
                    String str = "";
                    while (matcher.find()) {
                        str = matcher.group(1);
                    }
                    long parseLong = Long.parseLong(str);
                    try {
                        randomAccessFile.close();
                        return parseLong;
                    } catch (Throwable th2) {
                        L.debug("ArdUtil", th2.getMessage(), new Object[0]);
                        return parseLong;
                    }
                } catch (Throwable th3) {
                    th = th3;
                    try {
                        L.debug("ArdUtil", "getTotalMemoryFromFile exception . %s", th);
                        if (randomAccessFile != null) {
                            try {
                                randomAccessFile.close();
                            } catch (Throwable th4) {
                                L.debug("ArdUtil", th4.getMessage(), new Object[0]);
                            }
                        }
                        return 0L;
                    } catch (Throwable th5) {
                        if (randomAccessFile != null) {
                            try {
                                randomAccessFile.close();
                            } catch (Throwable th6) {
                                L.debug("ArdUtil", th6.getMessage(), new Object[0]);
                            }
                        }
                        throw th5;
                    }
                }
            } catch (Throwable th7) {
                randomAccessFile = null;
                th = th7;
            }
        } else {
            return invokeV.longValue;
        }
    }

    public static boolean isNetworkReach() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65588, null)) == null) {
            Socket socket = new Socket();
            try {
                socket.connect(new InetSocketAddress("www.baidu.com", 80), 5000);
                boolean isConnected = socket.isConnected();
                try {
                    socket.close();
                } catch (Throwable th) {
                    L.debug("ArdUtil", th.getMessage(), new Object[0]);
                }
                return isConnected;
            } catch (Throwable th2) {
                try {
                    L.debug("ArdUtil", "isNetworkReach Exception: %s", th2);
                    try {
                        socket.close();
                    } catch (Throwable th3) {
                        L.debug("ArdUtil", th3.getMessage(), new Object[0]);
                    }
                    return false;
                } catch (Throwable th4) {
                    try {
                        socket.close();
                    } catch (Throwable th5) {
                        L.debug("ArdUtil", th5.getMessage(), new Object[0]);
                    }
                    throw th4;
                }
            }
        }
        return invokeV.booleanValue;
    }

    public static String getDeviceName(Context context) {
        InterceptResult invokeL;
        String string;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65550, null, context)) == null) {
            try {
                if (Build.VERSION.SDK_INT >= 17 && (string = Settings.Global.getString(context.getContentResolver(), "device_name")) != null) {
                    return string;
                }
                return Build.MODEL;
            } catch (Throwable th) {
                L.debug("ArdUtil", "error" + th, new Object[0]);
                return "";
            }
        }
        return (String) invokeL.objValue;
    }

    public static String getMacAddr(Context context) {
        InterceptResult invokeL;
        WifiManager wifiManager;
        String macAddress;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65555, null, context)) == null) {
            String str = mMacAddress;
            if (str != null) {
                return str;
            }
            try {
                if (checkPermissions(context, h.d) && (wifiManager = (WifiManager) context.getSystemService("wifi")) != null) {
                    WifiInfo connectionInfo = wifiManager.getConnectionInfo();
                    if (connectionInfo == null) {
                        macAddress = null;
                    } else {
                        macAddress = ApiReplaceUtil.getMacAddress(connectionInfo);
                    }
                    mMacAddress = macAddress;
                }
            } catch (Throwable th) {
                L.debug("ArdUtil", "exception on getMacAddr : %s", th);
            }
            return mMacAddress;
        }
        return (String) invokeL.objValue;
    }

    public static int getNetworkType(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65560, null, context)) == null) {
            try {
                NetworkInfo activeNetworkInfo = ((ConnectivityManager) context.getSystemService("connectivity")).getActiveNetworkInfo();
                if (activeNetworkInfo == null) {
                    return 0;
                }
                int type = activeNetworkInfo.getType();
                if (type == 1) {
                    return 3;
                }
                if (type != 0) {
                    return 0;
                }
                int subtype = activeNetworkInfo.getSubtype();
                if (subtype != 7 && subtype != 3 && subtype != 5 && subtype != 6 && subtype != 8 && subtype != 10 && subtype != 9) {
                    if (subtype < 12 || subtype > 15) {
                        return 1;
                    }
                    return 4;
                }
                return 2;
            } catch (Throwable th) {
                L.debug("ArdUtil", "exception on get network info: %s", th);
                return 0;
            }
        }
        return invokeL.intValue;
    }

    public static String getSceneMode(Context context) {
        InterceptResult invokeL;
        String str;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65566, null, context)) == null) {
            try {
                AudioManager audioManager = (AudioManager) context.getSystemService("audio");
                int i = -1;
                if (audioManager != null) {
                    i = audioManager.getRingerMode();
                }
                if (i != 0) {
                    if (i != 1) {
                        if (i != 2) {
                            return "";
                        }
                        str = "normal";
                    } else {
                        str = "vibrate";
                    }
                } else {
                    str = NotificationCompat.GROUP_KEY_SILENT;
                }
                return str;
            } catch (Throwable th) {
                L.debug("ArdUtil", "getSceneMode exception . %s", th);
                return "";
            }
        }
        return (String) invokeL.objValue;
    }

    @SuppressLint({"NewApi"})
    public static long getTotalMemory(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65574, null, context)) == null) {
            long j = mTotalMem;
            if (j != 0) {
                return j;
            }
            if (Build.VERSION.SDK_INT >= 16 && context != null) {
                try {
                    ActivityManager.MemoryInfo memoryInfo = new ActivityManager.MemoryInfo();
                    ((ActivityManager) context.getSystemService("activity")).getMemoryInfo(memoryInfo);
                    mTotalMem = memoryInfo.totalMem / 1024;
                } catch (Throwable th) {
                    L.debug("ArdUtil", "getTotalMemory exception . %s", th);
                    mTotalMem = getTotalMemory();
                }
            } else {
                mTotalMem = getTotalMemory();
            }
            return mTotalMem;
        }
        return invokeL.longValue;
    }

    public static String getMetaDataParam(Context context, String str) {
        InterceptResult invokeLL;
        Bundle bundle;
        Object obj;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65559, null, context, str)) == null) {
            if (context != null && !Util.empty(str)) {
                try {
                    ApplicationInfo applicationInfo = context.getPackageManager().getApplicationInfo(context.getPackageName(), 128);
                    if (applicationInfo != null && (bundle = applicationInfo.metaData) != null && (obj = bundle.get(str)) != null) {
                        L.debug("ArdUtil", "meta data key[%s] value is %s", str, obj);
                        return obj + "";
                    }
                } catch (Throwable th) {
                    L.debug("ArdUtil", "read meta-data key[%s] from AndroidManifest.xml Exception.%s", str, th);
                }
            }
            return "";
        }
        return (String) invokeLL.objValue;
    }

    public static int getNetworkTypeNew(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65561, null, context)) == null) {
            try {
                NetworkInfo activeNetworkInfo = ((ConnectivityManager) context.getSystemService("connectivity")).getActiveNetworkInfo();
                if (activeNetworkInfo == null) {
                    return 0;
                }
                int type = activeNetworkInfo.getType();
                if (type == 1) {
                    return 3;
                }
                if (type == 0) {
                    switch (activeNetworkInfo.getSubtype()) {
                        case 1:
                        case 2:
                        case 4:
                        case 7:
                        case 11:
                        case 16:
                            return 1;
                        case 3:
                        case 5:
                        case 6:
                        case 8:
                        case 9:
                        case 10:
                        case 12:
                        case 14:
                        case 15:
                        case 17:
                        case 18:
                            return 2;
                        case 13:
                            return 4;
                        default:
                            return 0;
                    }
                }
                return 0;
            } catch (Throwable th) {
                L.debug("ArdUtil", "exception on get network info: %s", th);
                return 0;
            }
        }
        return invokeL.intValue;
    }

    public static String getNtm(Context context) {
        InterceptResult invokeL;
        String str;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65562, null, context)) == null) {
            String str2 = mNtm;
            if (str2 != null) {
                return str2;
            }
            String str3 = null;
            try {
                TelephonyManager telephonyManager = (TelephonyManager) context.getSystemService("phone");
                if (telephonyManager != null) {
                    str3 = telephonyManager.getSimOperator();
                    if (!Util.empty(str3)) {
                        String[] split = str3.split(",");
                        if (split.length > 0 && !Util.empty(split[0])) {
                            str = split[0];
                        } else {
                            if (split.length == 2 && !Util.empty(split[1])) {
                                str = split[1];
                            }
                            if (str3.length() != 5 || str3.length() == 6) {
                                str3 = String.format("%s:%s", str3.substring(0, 3), str3.substring(3));
                            }
                        }
                        str3 = str;
                        if (str3.length() != 5) {
                        }
                        str3 = String.format("%s:%s", str3.substring(0, 3), str3.substring(3));
                    }
                }
            } catch (Throwable th) {
                L.debug("ArdUtil", "Exception when getNtm %s", th);
            }
            mNtm = str3;
            return str3;
        }
        return (String) invokeL.objValue;
    }

    public static String getScreenResolution(Context context) {
        InterceptResult invokeL;
        WindowManager windowManager;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65568, null, context)) == null) {
            String str = mScreenResolution;
            if (str != null) {
                return str;
            }
            try {
                windowManager = (WindowManager) context.getSystemService("window");
            } catch (Throwable th) {
                L.debug("ArdUtil", "exception on getScreenResolution info: %s", th);
            }
            if (windowManager == null) {
                mScreenResolution = "";
                return "";
            }
            new Point();
            Display defaultDisplay = windowManager.getDefaultDisplay();
            if (Build.VERSION.SDK_INT >= 17) {
                DisplayMetrics displayMetrics = new DisplayMetrics();
                defaultDisplay.getRealMetrics(displayMetrics);
                mScreenResolution = displayMetrics.widthPixels + "x" + displayMetrics.heightPixels;
            } else {
                mScreenResolution = defaultDisplay.getWidth() + "x" + defaultDisplay.getHeight();
            }
            return mScreenResolution;
        }
        return (String) invokeL.objValue;
    }

    public static int getVolume(Context context, int i) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(65582, null, context, i)) == null) {
            try {
                return ((AudioManager) context.getSystemService("audio")).getStreamVolume(i);
            } catch (Throwable th) {
                L.debug("ArdUtil", "getVolume exception . %s", th);
                return -1;
            }
        }
        return invokeLI.intValue;
    }
}
