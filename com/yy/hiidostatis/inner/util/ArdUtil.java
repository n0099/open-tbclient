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
import com.baidu.mapsdkplatform.comapi.map.r;
import com.baidu.mobads.container.adrequest.IAdRequestParam;
import com.baidu.mobads.container.util.network.NetworkInfoUtils;
import com.baidu.mobstat.Config;
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
/* loaded from: classes7.dex */
public class ArdUtil {
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

    /* JADX WARN: Code restructure failed: missing block: B:9:0x001b, code lost:
        if (r4.getPackageManager().checkPermission(r5, r4.getPackageName()) == 0) goto L8;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static boolean checkPermissions(Context context, String str) {
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

    public static String getAndroidId(Context context) {
        try {
        } catch (Throwable th) {
            L.debug("ArdUtil", "Exception when getAndroidId %s", th);
        }
        if (mAndroidId != null) {
            return mAndroidId;
        }
        mAndroidId = Settings.Secure.getString(context.getContentResolver(), IAdRequestParam.ANDROID_ID);
        return mAndroidId;
    }

    public static long getAvailInternalStorgeSize() {
        try {
            StatFs statFs = new StatFs(Environment.getDataDirectory().getPath());
            return (statFs.getAvailableBlocks() * statFs.getBlockSize()) / 1024;
        } catch (Throwable th) {
            L.debug("ArdUtil", "getAvailInternalStorgeSize exception . %s", th);
            return 0L;
        }
    }

    public static long getAvailMemory(Context context) {
        try {
            ActivityManager.MemoryInfo memoryInfo = new ActivityManager.MemoryInfo();
            ((ActivityManager) context.getSystemService("activity")).getMemoryInfo(memoryInfo);
            return memoryInfo.availMem / 1024;
        } catch (Throwable th) {
            L.debug("ArdUtil", "getAvailMemory exception . %s", th);
            return 0L;
        }
    }

    public static int getAvailableProcessors() {
        try {
            return Runtime.getRuntime().availableProcessors();
        } catch (Throwable th) {
            L.debug("ArdUtil", "getAvailableProcessors exception . %s", th);
            return -1;
        }
    }

    public static String getBluetoothMac(Context context) {
        BluetoothAdapter defaultAdapter;
        try {
            return (!checkPermissions(context, "android.permission.BLUETOOTH") || (defaultAdapter = BluetoothAdapter.getDefaultAdapter()) == null) ? "" : defaultAdapter.getAddress();
        } catch (Throwable th) {
            L.debug("ArdUtil", "getBluetoothMac exception . %s", th);
        }
        return "";
    }

    public static CellLocation getCellId(Context context) {
        try {
            return ((TelephonyManager) context.getSystemService("phone")).getCellLocation();
        } catch (Throwable th) {
            L.debug("ArdUtil", "getCellId exception . %s", th);
            return null;
        }
    }

    public static String getCellIp() {
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

    public static String getCpuAbi() {
        BufferedReader bufferedReader;
        if (!TextUtils.isEmpty(mCpuAbi)) {
            return mCpuAbi;
        }
        if (Build.VERSION.SDK_INT < 21) {
            String str = Build.CPU_ABI;
            mCpuAbi = str;
            return str;
        }
        try {
            bufferedReader = new BufferedReader(new FileReader("/proc/cpuinfo"));
            try {
                String str2 = bufferedReader.readLine().split(":\\s+", 2)[1];
                mCpuAbi = str2;
                try {
                    bufferedReader.close();
                } catch (IOException e2) {
                    e2.printStackTrace();
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
                        } catch (IOException e3) {
                            e3.printStackTrace();
                        }
                    }
                }
            }
        } catch (Throwable th2) {
            th = th2;
            bufferedReader = null;
        }
    }

    public static String getCpuName() {
        BufferedReader bufferedReader;
        if (!TextUtils.isEmpty(mCpuName)) {
            return mCpuName;
        }
        try {
            bufferedReader = new BufferedReader(new FileReader("/proc/cpuinfo"));
            try {
                String str = bufferedReader.readLine().split(":\\s+", 2)[1];
                mCpuName = str;
                try {
                    bufferedReader.close();
                } catch (IOException e2) {
                    e2.printStackTrace();
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
                        } catch (IOException e3) {
                            e3.printStackTrace();
                        }
                    }
                }
            }
        } catch (Throwable th2) {
            th = th2;
            bufferedReader = null;
        }
    }

    public static int getCpuNum() {
        int i2 = mCpuNum;
        if (i2 != 0) {
            return i2;
        }
        try {
            int length = new File("/sys/devices/system/cpu/").listFiles(new FileFilter() { // from class: com.yy.hiidostatis.inner.util.ArdUtil.1CpuFilter
                @Override // java.io.FileFilter
                public boolean accept(File file) {
                    return Pattern.matches("cpu[0-9]", file.getName());
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

    public static int getCurrAppUid(Context context) {
        try {
            return context.getApplicationInfo().uid;
        } catch (Throwable th) {
            L.debug("ArdUtil", "getCurrAppUid exception: %s", th);
            return -1;
        }
    }

    public static String getDeviceName(Context context) {
        String string;
        try {
            return (Build.VERSION.SDK_INT < 17 || (string = Settings.Global.getString(context.getContentResolver(), "device_name")) == null) ? Build.MODEL : string;
        } catch (Throwable th) {
            L.debug("ArdUtil", "error" + th, new Object[0]);
            return "";
        }
    }

    public static int getDeviceOrientation(Context context) {
        int i2;
        try {
            i2 = context.getResources().getConfiguration().orientation;
        } catch (Throwable th) {
            L.debug("ArdUtil", "getDeviceOrientation exception . %s", th);
        }
        if (i2 == 2) {
            return 1;
        }
        return i2 == 1 ? 0 : 0;
    }

    public static String getImei(Context context) {
        String str = mImei;
        if (str != null) {
            return str;
        }
        return null;
    }

    public static String getImsi(Context context) {
        String str = mImsi;
        if (str != null) {
        }
        return str;
    }

    public static String getLang() {
        Locale locale;
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

    public static String getMacAddr(Context context) {
        WifiManager wifiManager;
        String str = mMacAddress;
        if (str != null) {
            return str;
        }
        try {
            if (checkPermissions(context, "android.permission.ACCESS_WIFI_STATE") && (wifiManager = (WifiManager) context.getSystemService("wifi")) != null) {
                WifiInfo connectionInfo = wifiManager.getConnectionInfo();
                mMacAddress = connectionInfo == null ? null : connectionInfo.getMacAddress();
            }
        } catch (Throwable th) {
            L.debug("ArdUtil", "exception on getMacAddr : %s", th);
        }
        return mMacAddress;
    }

    @SuppressLint({"NewApi"})
    public static String getMacAddr2() {
        byte[] hardwareAddress;
        String str = null;
        try {
            if (Build.VERSION.SDK_INT >= 9) {
                Enumeration<NetworkInterface> networkInterfaces = NetworkInterface.getNetworkInterfaces();
                while (networkInterfaces.hasMoreElements()) {
                    NetworkInterface nextElement = networkInterfaces.nextElement();
                    if (nextElement.getName().equalsIgnoreCase(NetworkInfoUtils.NETWORK_NAME) && (hardwareAddress = nextElement.getHardwareAddress()) != null && hardwareAddress.length != 0) {
                        StringBuilder sb = new StringBuilder();
                        int length = hardwareAddress.length;
                        for (int i2 = 0; i2 < length; i2++) {
                            sb.append(String.format("%02X:", Byte.valueOf(hardwareAddress[i2])));
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

    public static String getMacAddrV23(Context context) {
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

    public static String getMaxCpuFreq() {
        FileInputStream fileInputStream;
        Object th;
        if (!TextUtils.isEmpty(mMaxpuFreq)) {
            return mMaxpuFreq;
        }
        StringBuilder sb = new StringBuilder();
        try {
            try {
                fileInputStream = new FileInputStream("/sys/devices/system/cpu/cpu0/cpufreq/cpuinfo_max_freq");
            } catch (IOException e2) {
                e2.printStackTrace();
            }
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
                        } catch (IOException e3) {
                            e3.printStackTrace();
                        }
                    }
                    throw th3;
                }
            }
        } catch (Throwable th4) {
            fileInputStream = null;
            th = th4;
        }
        String trim2 = sb.toString().trim();
        mMaxpuFreq = trim2;
        return trim2;
    }

    public static String getMetaDataParam(Context context, String str) {
        Bundle bundle;
        Object obj;
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

    public static int getNetworkType(Context context) {
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
                int subtype = activeNetworkInfo.getSubtype();
                if (subtype == 7 || subtype == 3 || subtype == 5 || subtype == 6 || subtype == 8 || subtype == 10 || subtype == 9) {
                    return 2;
                }
                return (subtype < 12 || subtype > 15) ? 1 : 4;
            }
            return 0;
        } catch (Throwable th) {
            L.debug("ArdUtil", "exception on get network info: %s", th);
            return 0;
        }
    }

    public static int getNetworkTypeNew(Context context) {
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

    public static String getNtm(Context context) {
        String str;
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

    public static String getOS() {
        String str = mOS;
        if (str != null) {
            return str;
        }
        String format = String.format("Android%s", Build.VERSION.RELEASE);
        mOS = format;
        return format;
    }

    public static String getPackageName(Context context) {
        try {
            return context.getPackageName();
        } catch (Throwable unused) {
            L.debug("ArdUtil", "Failed to read package Name.", new Object[0]);
            return "";
        }
    }

    public static String getSafeMacAddr(Context context) {
        String macAddrV23 = getMacAddrV23(context);
        if (isValidMac(macAddrV23)) {
            return InsideMode.safeMac(macAddrV23);
        }
        return null;
    }

    public static String getSceneMode(Context context) {
        String str;
        try {
            AudioManager audioManager = (AudioManager) context.getSystemService("audio");
            int ringerMode = audioManager != null ? audioManager.getRingerMode() : -1;
            if (ringerMode == 0) {
                str = NotificationCompat.GROUP_KEY_SILENT;
            } else if (ringerMode == 1) {
                str = "vibrate";
            } else if (ringerMode != 2) {
                return "";
            } else {
                str = "normal";
            }
            return str;
        } catch (Throwable th) {
            L.debug("ArdUtil", "getSceneMode exception . %s", th);
            return "";
        }
    }

    public static int getScreenBrightness(Context context) {
        try {
            return Settings.System.getInt(context.getContentResolver(), "screen_brightness");
        } catch (Throwable th) {
            L.debug("ArdUtil", "getScreenBrightness exception . %s", th);
            return 0;
        }
    }

    public static String getScreenResolution(Context context) {
        WindowManager windowManager;
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

    public static String getSjm(Context context) {
        return Build.MODEL;
    }

    public static String getSjp(Context context) {
        return Build.MANUFACTURER;
    }

    public static String getTimeZone() {
        char c2;
        int rawOffset = TimeZone.getDefault().getRawOffset() / 60000;
        if (rawOffset < 0) {
            c2 = '-';
            rawOffset = -rawOffset;
        } else {
            c2 = '+';
        }
        return "GMT" + c2 + (rawOffset / 60);
    }

    public static long getTotalInternalStorgeSize() {
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

    public static long getTotalMemory() {
        long j = mTotal;
        if (j != 0) {
            return j;
        }
        BufferedReader bufferedReader = null;
        try {
            try {
                BufferedReader bufferedReader2 = new BufferedReader(new FileReader("/proc/meminfo"), 8);
                try {
                    String readLine = bufferedReader2.readLine();
                    String str = readLine != null ? readLine : null;
                    if (!Util.empty(str)) {
                        mTotal = Long.parseLong(str.substring(str.indexOf(58) + 1, str.indexOf(107)).trim().trim());
                    }
                    bufferedReader2.close();
                } catch (Throwable th) {
                    th = th;
                    bufferedReader = bufferedReader2;
                    try {
                        L.debug("ArdUtil", "getTotalMemory exception: %s", th);
                        if (bufferedReader != null) {
                            bufferedReader.close();
                        }
                        return mTotal;
                    } catch (Throwable th2) {
                        if (bufferedReader != null) {
                            try {
                                bufferedReader.close();
                            } catch (IOException unused) {
                            }
                        }
                        throw th2;
                    }
                }
            } catch (Throwable th3) {
                th = th3;
            }
        } catch (IOException unused2) {
        }
    }

    public static long getTotalMemoryFromFile() {
        RandomAccessFile randomAccessFile;
        Object th;
        try {
            randomAccessFile = new RandomAccessFile("/proc/meminfo", r.f7715a);
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
    }

    @SuppressLint({"NewApi"})
    public static long getTotalRxBytes() {
        if (Build.VERSION.SDK_INT >= 8) {
            return TrafficStats.getTotalRxBytes();
        }
        return 0L;
    }

    @SuppressLint({"NewApi"})
    public static long getTotalTxBytes() {
        if (Build.VERSION.SDK_INT >= 8) {
            return TrafficStats.getTotalTxBytes();
        }
        return 0L;
    }

    @SuppressLint({"NewApi"})
    public static long getUidRxBytes(int i2) {
        if (Build.VERSION.SDK_INT >= 8) {
            return TrafficStats.getUidRxBytes(i2);
        }
        return 0L;
    }

    @SuppressLint({"NewApi"})
    public static long getUidTxBytes(int i2) {
        if (Build.VERSION.SDK_INT >= 8) {
            return TrafficStats.getUidTxBytes(i2);
        }
        return 0L;
    }

    public static String getVersionName(Context context) {
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

    public static int getVersionNo(Context context) {
        try {
            if (mVer != -1) {
                return mVer;
            }
            int i2 = context.getPackageManager().getPackageInfo(context.getPackageName(), 0).versionCode;
            mVer = i2;
            return i2;
        } catch (Throwable unused) {
            L.debug("ArdUtil", "Failed to read version No.", new Object[0]);
            mVer = -1;
            return -1;
        }
    }

    public static int getVolume(Context context, int i2) {
        try {
            return ((AudioManager) context.getSystemService("audio")).getStreamVolume(i2);
        } catch (Throwable th) {
            L.debug("ArdUtil", "getVolume exception . %s", th);
            return -1;
        }
    }

    public static WifiInfo getWifiInfo(Context context) {
        WifiManager wifiManager;
        try {
            if (!checkPermissions(context, "android.permission.ACCESS_WIFI_STATE") || (wifiManager = (WifiManager) context.getSystemService("wifi")) == null) {
                return null;
            }
            return wifiManager.getConnectionInfo();
        } catch (Throwable th) {
            L.debug("ArdUtil", "getWifiInfo exception . %s", th);
            return null;
        }
    }

    public static String getWifiName(Context context) {
        WifiInfo connectionInfo;
        try {
            if (!checkPermissions(context, "android.permission.ACCESS_WIFI_STATE") || (connectionInfo = ((WifiManager) context.getSystemService("wifi")).getConnectionInfo()) == null) {
                return null;
            }
            return connectionInfo.getSSID();
        } catch (Throwable th) {
            L.debug("ArdUtil", th.getMessage(), new Object[0]);
        }
        return null;
    }

    public static boolean isDebugEnable(Context context) {
        return Settings.Secure.getInt(context.getContentResolver(), "adb_enabled", 0) > 0;
    }

    public static boolean isHeadphone(Context context) {
        try {
            if (checkPermissions(context, "android.permission.MODIFY_AUDIO_SETTINGS")) {
                return ((AudioManager) context.getSystemService("audio")).isWiredHeadsetOn();
            }
        } catch (Throwable th) {
            L.debug("ArdUtil", "isHeadphone exception . %s", th);
        }
        return false;
    }

    public static boolean isNetworkAvailable(Context context) {
        try {
            ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService("connectivity");
            NetworkInfo activeNetworkInfo = connectivityManager != null ? connectivityManager.getActiveNetworkInfo() : null;
            if (activeNetworkInfo == null || !activeNetworkInfo.isConnected()) {
                return false;
            }
            return activeNetworkInfo.isAvailable();
        } catch (Throwable th) {
            L.debug("ArdUtil", "isNetworkAvailable Exception: %s", th);
            return true;
        }
    }

    public static boolean isNetworkReach() {
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

    public static boolean isRoot() {
        return new File("/system/bin/su").exists() || new File("/system/xbin/su").exists();
    }

    public static boolean isValidMac(String str) {
        return (TextUtils.isEmpty(str) || str.equalsIgnoreCase(Config.DEF_MAC_ID)) ? false : true;
    }

    public static boolean isWifiActive(Context context) {
        if (context == null) {
            L.debug("ArdUtil", "the Input context is null!", new Object[0]);
            return false;
        }
        try {
            ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService("connectivity");
            NetworkInfo activeNetworkInfo = connectivityManager != null ? connectivityManager.getActiveNetworkInfo() : null;
            if (activeNetworkInfo != null) {
                return activeNetworkInfo.getType() == 1;
            }
            return false;
        } catch (Throwable th) {
            L.debug("ArdUtil", "isWifiActive Exception: %s", th);
            return true;
        }
    }

    @SuppressLint({"NewApi"})
    public static long getTotalMemory(Context context) {
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
}
