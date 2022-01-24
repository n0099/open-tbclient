package com.dxmpay.apollon.utils;

import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.app.ActivityManager;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.Uri;
import android.net.wifi.ScanResult;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import android.os.Build;
import android.os.Bundle;
import android.os.Environment;
import android.os.Process;
import android.os.StatFs;
import android.telephony.CellLocation;
import android.telephony.TelephonyManager;
import android.telephony.gsm.GsmCellLocation;
import android.text.TextUtils;
import android.text.format.Formatter;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.common.util.DeviceId;
import com.baidu.android.util.devices.IDevices;
import com.baidu.pass.main.facesdk.utils.PreferencesUtil;
import com.baidu.searchbox.aideviceperformance.utils.HardwareInfoUtils;
import com.baidu.tieba.imageProblem.httpNet.CDNIPDirectConnect;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.dxmpay.apollon.ApollonConstants;
import com.dxmpay.apollon.armor.SecurePay;
import com.dxmpay.apollon.permission.PermissionManager;
import com.kuaishou.weapon.un.s;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileFilter;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Inet4Address;
import java.net.InetAddress;
import java.net.NetworkInterface;
import java.net.SocketException;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.Locale;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public final class PhoneUtils {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String CPU_API_ARM_V7A = "armeabi-v7a";
    public static final String CPU_API_ARM_V8A = "arm64-v8a";
    public static CPUInfo a;

    /* renamed from: b  reason: collision with root package name */
    public static ArrayList<String> f53696b;

    /* renamed from: c  reason: collision with root package name */
    public static final Pattern f53697c;

    /* renamed from: d  reason: collision with root package name */
    public static final Pattern f53698d;

    /* renamed from: e  reason: collision with root package name */
    public static final Pattern f53699e;

    /* renamed from: f  reason: collision with root package name */
    public static final Pattern f53700f;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes3.dex */
    public static class CPUInfo {
        public static /* synthetic */ Interceptable $ic = null;
        public static final String FEATURE_COMMON = "common";
        public static final String FEATURE_NEON = "neon";
        public static final String FEATURE_VFP = "vfp";
        public static final String PROCESSOR_ARMV5 = "armv5";
        public static final String PROCESSOR_ARMV6 = "armv6";
        public static final String PROCESSOR_ARMV7 = "armv7";
        public static final String PROCESSOR_ARM_PREFIX = "armv";
        public transient /* synthetic */ FieldHolder $fh;
        public String features;
        public String processor;

        public CPUInfo() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.processor = "";
            this.features = "";
        }

        public String getCpuPath() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.processor.startsWith("armv7") ? "armeabi-v7a" : this.processor.startsWith("armv") ? "armeabi" : this.processor.equals("intel") ? "x86" : this.processor.equals(IDevices.ABI_MIPS) ? IDevices.ABI_MIPS : "" : (String) invokeV.objValue;
        }
    }

    /* loaded from: classes3.dex */
    public class a implements FileFilter {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public a() {
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

        @Override // java.io.FileFilter
        public boolean accept(File file) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, file)) == null) ? Pattern.matches("cpu[0-9]", file.getName()) : invokeL.booleanValue;
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-187959708, "Lcom/dxmpay/apollon/utils/PhoneUtils;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-187959708, "Lcom/dxmpay/apollon/utils/PhoneUtils;");
                return;
            }
        }
        f53696b = new ArrayList<>();
        f53697c = Pattern.compile("((\\d|[A-F]){32}).*");
        f53698d = Pattern.compile("((\\d|[a-f]){32}).*");
        f53699e = Pattern.compile("((\\d|[A-F]){32}).*(\\|.*)");
        f53700f = Pattern.compile("((\\d|[a-f]){32}).*(\\|.*)");
        f53696b.add("card_no");
        f53696b.add("valid_date");
        f53696b.add("cvv2");
        f53696b.add("identity_code");
        f53696b.add("phone_number");
    }

    public PhoneUtils() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
            }
        }
    }

    public static String a(byte b2) {
        InterceptResult invokeB;
        String str;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeB = interceptable.invokeB(65538, null, b2)) == null) {
            return ("00" + Integer.toHexString(b2) + ":").substring(str.length() - 3);
        }
        return (String) invokeB.objValue;
    }

    public static String b(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65539, null, context)) == null) {
            String deviceID = DeviceId.getDeviceID(context);
            if (deviceID == null) {
                return null;
            }
            Matcher matcher = f53697c.matcher(deviceID);
            String group = matcher.matches() ? matcher.group(1) : null;
            if (group == null) {
                Matcher matcher2 = f53698d.matcher(deviceID);
                return matcher2.matches() ? matcher2.group(1) : "";
            }
            return group;
        }
        return (String) invokeL.objValue;
    }

    public static void checkPermission(Context context, String str) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(InputDeviceCompat.SOURCE_TRACKBALL, null, context, str) == null) || hasPermission(context, str)) {
            return;
        }
        sdkError("You need the " + str + " permission. Open AndroidManifest.xml and just before the final </manifest> tag add:  <uses-permission android:name=\"" + str + "\" />");
    }

    public static String encrypt(String str, String str2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65541, null, str, str2)) == null) {
            LogUtil.d(str + "加密=" + str2);
            if (f53696b.contains(str)) {
                if (TextUtils.isEmpty(str2)) {
                    return "";
                }
                String encryptProxy = SecurePay.getInstance().encryptProxy(str2);
                LogUtil.d(str + "加密=" + encryptProxy);
                return encryptProxy;
            }
            return str2;
        }
        return (String) invokeLL.objValue;
    }

    public static int getAppVersionCode(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65542, null, context)) == null) {
            if (context == null) {
                return 0;
            }
            try {
                return context.getPackageManager().getPackageInfo(context.getPackageName(), 0).versionCode;
            } catch (Throwable unused) {
                LogUtil.w("PhoneUtils", "get app version code exception");
                return 1;
            }
        }
        return invokeL.intValue;
    }

    public static String getAppVersionName(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65543, null, context)) == null) {
            if (context == null) {
                return "";
            }
            try {
                return context.getPackageManager().getPackageInfo(context.getPackageName(), 0).versionName;
            } catch (Throwable unused) {
                LogUtil.w("PhoneUtils", "get app version name exception");
                return "";
            }
        }
        return (String) invokeL.objValue;
    }

    public static ApplicationInfo getApplicationInfo(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65544, null, context)) == null) {
            if (context == null) {
                return null;
            }
            try {
                return context.getPackageManager().getApplicationInfo(context.getPackageName(), 0);
            } catch (Throwable unused) {
                return null;
            }
        }
        return (ApplicationInfo) invokeL.objValue;
    }

    public static String getApplicationName(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65545, null, context)) == null) {
            if (context == null) {
                return "";
            }
            try {
                PackageManager packageManager = context.getPackageManager();
                return (String) packageManager.getApplicationLabel(packageManager.getApplicationInfo(context.getPackageName(), 0));
            } catch (Throwable unused) {
                return "";
            }
        }
        return (String) invokeL.objValue;
    }

    public static String getAvailMemory(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65546, null, context)) == null) {
            ActivityManager.MemoryInfo memoryInfo = new ActivityManager.MemoryInfo();
            ((ActivityManager) context.getSystemService("activity")).getMemoryInfo(memoryInfo);
            return Formatter.formatFileSize(context, memoryInfo.availMem) + "_" + memoryInfo.lowMemory + "_" + Formatter.formatFileSize(context, memoryInfo.threshold);
        }
        return (String) invokeL.objValue;
    }

    public static String getCUID(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65547, null, context)) == null) ? b(context) : (String) invokeL.objValue;
    }

    public static String getCUID2(Context context) {
        InterceptResult invokeL;
        Matcher matcher;
        Matcher matcher2;
        String str;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65548, null, context)) == null) {
            String cuid = DeviceId.getCUID(context);
            String str2 = null;
            if (cuid == null) {
                return null;
            }
            if (f53699e.matcher(cuid).matches()) {
                str2 = matcher.group(1) + matcher.group(3);
            }
            if (str2 == null) {
                if (f53700f.matcher(cuid).matches()) {
                    str = matcher2.group(1) + matcher2.group(3);
                } else {
                    str = "";
                }
                return str;
            }
            return str2;
        }
        return (String) invokeL.objValue;
    }

    public static String getCellLocation(Context context) {
        InterceptResult invokeL;
        String format;
        CellLocation cellLocation;
        Interceptable interceptable = $ic;
        if (interceptable != null && (invokeL = interceptable.invokeL(65549, null, context)) != null) {
            return (String) invokeL.objValue;
        }
        if (Build.VERSION.SDK_INT >= 29 || !PermissionManager.checkCallingPermission(context, s.f55287c)) {
            return "";
        }
        format = String.format("%s_%s_%s", 0, 0, 0);
        try {
            if ((hasPermission(context, s.f55291g) || hasPermission(context, s.f55292h)) && (cellLocation = ((TelephonyManager) context.getSystemService("phone")).getCellLocation()) != null) {
                if (cellLocation instanceof GsmCellLocation) {
                    GsmCellLocation gsmCellLocation = (GsmCellLocation) cellLocation;
                    return String.format("%s_%s_%s", String.format("%d", Integer.valueOf(gsmCellLocation.getCid())), String.format("%d", Integer.valueOf(gsmCellLocation.getLac())), 0);
                }
                String[] split = cellLocation.toString().replace(PreferencesUtil.LEFT_MOUNT, "").replace(PreferencesUtil.RIGHT_MOUNT, "").split(",");
                return split.length > 5 ? String.format("%s_%s_%s", split[0], split[3], split[4]) : format;
            }
            return format;
        } catch (Exception e2) {
            String str = "exception is " + e2;
        }
        return format;
    }

    public static String getCpuAbi() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65550, null)) == null) ? (Build.VERSION.SDK_INT < 23 || !Process.is64Bit()) ? "armeabi-v7a" : "arm64-v8a" : (String) invokeV.objValue;
    }

    public static String getGPSLocation(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65551, null, context)) == null) ? "" : (String) invokeL.objValue;
    }

    public static String getIpInfo() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65552, null)) == null) {
            String str = null;
            try {
                Enumeration<NetworkInterface> networkInterfaces = NetworkInterface.getNetworkInterfaces();
                while (networkInterfaces.hasMoreElements()) {
                    Enumeration<InetAddress> inetAddresses = networkInterfaces.nextElement().getInetAddresses();
                    while (true) {
                        if (inetAddresses.hasMoreElements()) {
                            InetAddress nextElement = inetAddresses.nextElement();
                            if (!nextElement.isLoopbackAddress()) {
                                byte[] address = nextElement.getAddress();
                                if (address.length == 4) {
                                    int i2 = ((address[3] & 255) << 24) | ((address[2] & 255) << 16) | ((address[1] & 255) << 8) | (address[0] & 255);
                                    str = (i2 & 255) + "." + ((i2 >> 8) & 255) + "." + ((i2 >> 16) & 255) + "." + ((i2 >> 24) & 255);
                                    break;
                                }
                            }
                        }
                    }
                }
            } catch (Exception e2) {
                if (ApollonConstants.DEBUG) {
                    String str2 = "getIpInfo fail!" + e2.toString();
                }
            }
            return TextUtils.isEmpty(str) ? "" : str;
        }
        return (String) invokeV.objValue;
    }

    public static String getLinkedWay(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65553, null, context)) == null) {
            try {
                NetworkInfo activeNetworkInfo = ((ConnectivityManager) context.getSystemService("connectivity")).getActiveNetworkInfo();
                if (activeNetworkInfo != null) {
                    String typeName = activeNetworkInfo.getTypeName();
                    return (typeName.equals(CDNIPDirectConnect.CDNNetworkChangeReceiver.WIFI_STRING) || activeNetworkInfo.getSubtypeName() == null) ? typeName : activeNetworkInfo.getSubtypeName();
                }
                return "";
            } catch (Exception unused) {
                return "";
            }
        }
        return (String) invokeL.objValue;
    }

    public static String getLocalMacAddress() {
        InterceptResult invokeV;
        InputStreamReader inputStreamReader;
        Interceptable interceptable = $ic;
        if (interceptable != null && (invokeV = interceptable.invokeV(65554, null)) != null) {
            return (String) invokeV.objValue;
        }
        StringBuffer stringBuffer = new StringBuffer();
        InputStreamReader inputStreamReader2 = null;
        try {
            char[] cArr = new char[20];
            inputStreamReader = new InputStreamReader(new FileInputStream("/sys/class/net/eth0/address"));
            while (true) {
                try {
                    int read = inputStreamReader.read(cArr);
                    if (read != -1) {
                        if (read != 20 || cArr[19] == '\r') {
                            for (int i2 = 0; i2 < read; i2++) {
                                if (cArr[i2] != '\r') {
                                    stringBuffer.append(cArr[i2]);
                                }
                            }
                        }
                    } else {
                        try {
                            break;
                        } catch (IOException e2) {
                            e2.printStackTrace();
                        }
                    }
                } catch (Exception unused) {
                    if (inputStreamReader != null) {
                        try {
                            inputStreamReader.close();
                        } catch (IOException e3) {
                            e3.printStackTrace();
                        }
                    }
                    return null;
                } catch (Throwable th) {
                    th = th;
                    inputStreamReader2 = inputStreamReader;
                    if (inputStreamReader2 != null) {
                        try {
                            inputStreamReader2.close();
                        } catch (IOException e4) {
                            e4.printStackTrace();
                        }
                    }
                    throw th;
                }
            }
            inputStreamReader.close();
            return stringBuffer.toString().trim().replaceAll(":", "");
        } catch (Exception unused2) {
            inputStreamReader = null;
        } catch (Throwable th2) {
            th = th2;
        }
    }

    public static String getMetaData(Context context, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65555, null, context, str)) == null) {
            try {
                ApplicationInfo applicationInfo = context.getPackageManager().getApplicationInfo(context.getPackageName(), 128);
                if (applicationInfo != null) {
                    Bundle bundle = applicationInfo.metaData;
                    Object obj = bundle != null ? bundle.get(str) : null;
                    if (obj == null) {
                        LogUtil.d("StatSDK", "null,can't find information for key:" + str);
                        return "";
                    }
                    String obj2 = obj.toString();
                    if (obj2.trim().equals("")) {
                        LogUtil.w("PhoneUtils", "APP Key值为空||The value of APP Key is empty.");
                    }
                    return obj2;
                }
                return "";
            } catch (PackageManager.NameNotFoundException e2) {
                String str2 = "exception is " + e2;
                return "";
            }
        }
        return (String) invokeLL.objValue;
    }

    public static int getNumCores() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65556, null)) == null) {
            try {
                File[] listFiles = new File("/sys/devices/system/cpu/").listFiles(new a());
                LogUtil.d("PhoneUtils", "CPU Count: " + listFiles.length);
                return listFiles.length;
            } catch (Exception e2) {
                LogUtil.d("PhoneUtils", "CPU Count: Failed.");
                e2.printStackTrace();
                return 1;
            }
        }
        return invokeV.intValue;
    }

    @SuppressLint({"NewApi"})
    public static String getPhisicalMac(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65557, null, context)) == null) {
            StringBuffer stringBuffer = new StringBuffer();
            byte[] bArr = null;
            try {
                Enumeration<NetworkInterface> networkInterfaces = NetworkInterface.getNetworkInterfaces();
                while (networkInterfaces.hasMoreElements()) {
                    NetworkInterface nextElement = networkInterfaces.nextElement();
                    Enumeration<InetAddress> inetAddresses = nextElement.getInetAddresses();
                    while (true) {
                        if (inetAddresses.hasMoreElements()) {
                            InetAddress nextElement2 = inetAddresses.nextElement();
                            if (!nextElement2.isAnyLocalAddress() && (nextElement2 instanceof Inet4Address) && !nextElement2.isLoopbackAddress()) {
                                if (nextElement2.isSiteLocalAddress()) {
                                    bArr = nextElement.getHardwareAddress();
                                } else if (!nextElement2.isLinkLocalAddress()) {
                                    bArr = nextElement.getHardwareAddress();
                                    break;
                                }
                            }
                        }
                    }
                }
            } catch (SocketException e2) {
                e2.printStackTrace();
            }
            if (bArr != null) {
                for (byte b2 : bArr) {
                    stringBuffer.append(a(b2));
                }
                return stringBuffer.substring(0, stringBuffer.length() - 1).replaceAll(":", "");
            }
            String wifiMacAddress = getWifiMacAddress(context);
            return wifiMacAddress != null ? wifiMacAddress.replaceAll(":", "") : wifiMacAddress;
        }
        return (String) invokeL.objValue;
    }

    public static CPUInfo getSystemCPUInfo() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65558, null)) == null) {
            CPUInfo cPUInfo = a;
            if (cPUInfo != null) {
                return cPUInfo;
            }
            CPUInfo cPUInfo2 = new CPUInfo();
            try {
                FileReader fileReader = new FileReader("/proc/cpuinfo");
                BufferedReader bufferedReader = new BufferedReader(fileReader);
                for (String readLine = bufferedReader.readLine(); readLine != null; readLine = bufferedReader.readLine()) {
                    String lowerCase = readLine.trim().toLowerCase(Locale.ENGLISH);
                    if (lowerCase.startsWith("processor") && lowerCase.indexOf(":", 9) != -1) {
                        if (cPUInfo2.processor.length() > 0) {
                            cPUInfo2.processor += "__";
                        }
                        cPUInfo2.processor += lowerCase.split(":")[1].trim();
                    } else if (lowerCase.startsWith("features") && lowerCase.indexOf(":", 8) != -1) {
                        if (cPUInfo2.features.length() > 0) {
                            cPUInfo2.features += "__";
                        }
                        cPUInfo2.features += lowerCase.split(":")[1].trim();
                    }
                }
                bufferedReader.close();
                fileReader.close();
            } catch (FileNotFoundException e2) {
                e2.printStackTrace();
            } catch (IOException e3) {
                e3.printStackTrace();
            }
            a = cPUInfo2;
            return cPUInfo2;
        }
        return (CPUInfo) invokeV.objValue;
    }

    public static long getTotalInternalMemorySize() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65559, null)) == null) {
            StatFs statFs = new StatFs(Environment.getDataDirectory().getPath());
            return statFs.getBlockCount() * statFs.getBlockSize();
        }
        return invokeV.longValue;
    }

    public static String getTotalMemory(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65560, null, context)) == null) {
            long j2 = 0;
            try {
                BufferedReader bufferedReader = new BufferedReader(new FileReader(HardwareInfoUtils.MEM_INFO_FILE), 8192);
                String[] split = bufferedReader.readLine().split("\\s+");
                for (String str : split) {
                    String str2 = str + "\t";
                }
                j2 = Long.valueOf(split[1]).longValue() * 1024;
                bufferedReader.close();
            } catch (IOException unused) {
            }
            return Formatter.formatFileSize(context, j2);
        }
        return (String) invokeL.objValue;
    }

    public static String getWCPParams(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65561, null, context)) == null) {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("wime", "");
                jSONObject.put("cuid_1", encrypt("phone_number", getCUID(context)));
                jSONObject.put("cuid_2", encrypt("phone_number", getCUID2(context)));
                LogUtil.d("NetworkType", "NetworkType:" + NetworkUtils.getNetworkType(context));
                jSONObject.put("nettype", NetworkUtils.getNetworkType(context));
                jSONObject.put("wloc", encrypt("phone_number", getGPSLocation(context)));
                return new String(Base64Utils.encode(jSONObject.toString().getBytes()));
            } catch (JSONException e2) {
                e2.printStackTrace();
                return "";
            }
        }
        return (String) invokeL.objValue;
    }

    public static String getWifiLocation(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65562, null, context)) == null) {
            String str = "";
            try {
                if (hasPermission(context, s.f55288d)) {
                    WifiManager wifiManager = (WifiManager) context.getSystemService("wifi");
                    if (wifiManager.isWifiEnabled()) {
                        int i2 = Integer.MAX_VALUE;
                        int i3 = -1;
                        for (int i4 = 0; i4 < wifiManager.getScanResults().size(); i4++) {
                            ScanResult scanResult = wifiManager.getScanResults().get(i4);
                            int abs = Math.abs(scanResult.level);
                            LogUtil.d("PhoneUtils", String.format("%s %s_%s", scanResult.SSID, scanResult.BSSID, Integer.valueOf(abs)));
                            if (i2 > abs) {
                                i3 = i4;
                                i2 = abs;
                            }
                        }
                        if (i3 >= 0) {
                            ScanResult scanResult2 = wifiManager.getScanResults().get(i3);
                            str = String.format("%s_%s", scanResult2.BSSID.replace(":", "").toLowerCase(Locale.ENGLISH), Integer.valueOf(Math.abs(scanResult2.level)));
                        }
                        WifiInfo connectionInfo = wifiManager.getConnectionInfo();
                        String.format("[active]%s %s_%s", connectionInfo.getSSID(), connectionInfo.getMacAddress(), Integer.valueOf(Math.abs(connectionInfo.getRssi())));
                    }
                }
            } catch (Exception e2) {
                String str2 = "getWifiLocation " + e2;
            }
            return str;
        }
        return (String) invokeL.objValue;
    }

    public static String getWifiMacAddress(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65563, null, context)) == null) {
            try {
                WifiManager wifiManager = (WifiManager) context.getSystemService("wifi");
                if (wifiManager != null) {
                    WifiInfo connectionInfo = wifiManager.getConnectionInfo();
                    LogUtil.d("PhoneUtils", String.format("ssid=%s mac=%s", connectionInfo.getSSID(), connectionInfo.getMacAddress()));
                    return connectionInfo.getMacAddress();
                }
                return "";
            } catch (Exception e2) {
                if (ApollonConstants.DEBUG) {
                    e2.toString();
                    return "";
                }
                return "";
            }
        }
        return (String) invokeL.objValue;
    }

    public static boolean hasPermission(Context context, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65564, null, context, str)) == null) {
            if (context == null) {
                return false;
            }
            return PermissionManager.checkCallingPermission(context, str);
        }
        return invokeLL.booleanValue;
    }

    public static boolean isIntentAvailable(Context context, Intent intent) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLL = interceptable.invokeLL(65565, null, context, intent)) == null) ? context.getPackageManager().queryIntentActivities(intent, 1).size() > 0 : invokeLL.booleanValue;
    }

    public static void sdkError(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65566, null, str) == null) {
            LogUtil.w("PhoneUtils", str);
            LogUtil.w("PhoneUtils", "SDK install error:" + str);
        }
    }

    @TargetApi(9)
    public static void showInstalledAppOrDetails(Context context, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65567, null, context, str) == null) {
            Intent intent = new Intent();
            int i2 = Build.VERSION.SDK_INT;
            if (i2 >= 9) {
                if (!TextUtils.isEmpty(str)) {
                    intent.setAction("android.settings.APPLICATION_DETAILS_SETTINGS");
                    intent.setData(Uri.fromParts("package", str, null));
                } else {
                    intent.setAction("android.settings.MANAGE_APPLICATIONS_SETTINGS");
                }
            } else {
                String str2 = i2 == 8 ? "pkg" : "com.android.settings.ApplicationPkgName";
                intent.setAction("android.intent.action.VIEW");
                if (!TextUtils.isEmpty(str)) {
                    intent.setClassName("com.android.settings", "com.android.settings.InstalledAppDetails");
                    intent.putExtra(str2, str);
                } else {
                    intent.setClassName("com.android.settings", "com.android.settings.ManageApplications");
                }
            }
            if (isIntentAvailable(context, intent)) {
                context.startActivity(intent);
            }
        }
    }
}
