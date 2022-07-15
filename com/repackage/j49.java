package com.repackage;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import android.provider.Settings;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.WindowManager;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.common.others.lang.StringUtil;
import com.baidu.mobstat.Config;
import com.baidu.tbadk.core.util.httpNet.HttpRequest;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.StringWriter;
import java.net.NetworkInterface;
import java.util.Collections;
/* loaded from: classes6.dex */
public final class j49 {
    public static /* synthetic */ Interceptable $ic;
    public static String a;
    public static String b;
    public static String c;
    public transient /* synthetic */ FieldHolder $fh;

    public static String a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) {
            if (TextUtils.isEmpty(c)) {
                k(n39.h().getContext());
            }
            return c;
        }
        return (String) invokeV.objValue;
    }

    public static String b(WifiManager wifiManager) throws Exception {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, wifiManager)) == null) {
            String str = "";
            boolean z = 3 == wifiManager.getWifiState();
            try {
                wifiManager.setWifiEnabled(true);
                FileInputStream fileInputStream = new FileInputStream(new File("/sys/class/net/wlan0/address"));
                str = c(fileInputStream);
                fileInputStream.close();
            } catch (Exception e) {
                w49.d(e);
            }
            wifiManager.setWifiEnabled(z);
            return str;
        }
        return (String) invokeL.objValue;
    }

    public static String c(InputStream inputStream) throws IOException {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable != null && (invokeL = interceptable.invokeL(65538, null, inputStream)) != null) {
            return (String) invokeL.objValue;
        }
        StringWriter stringWriter = new StringWriter();
        char[] cArr = new char[2048];
        try {
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream, "UTF-8"));
            while (true) {
                int read = bufferedReader.read(cArr);
                if (read != -1) {
                    stringWriter.write(cArr, 0, read);
                } else {
                    inputStream.close();
                    return stringWriter.toString();
                }
            }
        } catch (Throwable th) {
            inputStream.close();
            throw th;
        }
    }

    public static String d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) {
            try {
                for (NetworkInterface networkInterface : Collections.list(NetworkInterface.getNetworkInterfaces())) {
                    if (networkInterface.getName().equalsIgnoreCase("wlan0")) {
                        byte[] hardwareAddress = networkInterface.getHardwareAddress();
                        if (hardwareAddress == null) {
                            return "";
                        }
                        StringBuilder sb = new StringBuilder();
                        int length = hardwareAddress.length;
                        for (int i = 0; i < length; i++) {
                            sb.append(String.format("%02X:", Byte.valueOf(hardwareAddress[i])));
                        }
                        if (sb.length() > 0) {
                            sb.deleteCharAt(sb.length() - 1);
                        }
                        return sb.toString();
                    }
                }
                return null;
            } catch (Exception e) {
                w49.d(e);
                return null;
            }
        }
        return (String) invokeV.objValue;
    }

    public static String e(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, context)) == null) {
            try {
                return Settings.System.getString(context.getContentResolver(), HttpRequest.ANDROID_ID);
            } catch (Exception e) {
                w49.d(e);
                return "NA";
            }
        }
        return (String) invokeL.objValue;
    }

    public static int f(Context context) {
        InterceptResult invokeL;
        NetworkInfo activeNetworkInfo;
        NetworkInfo.State state;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65541, null, context)) == null) {
            ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService("connectivity");
            if (connectivityManager != null && (activeNetworkInfo = connectivityManager.getActiveNetworkInfo()) != null && activeNetworkInfo.isAvailable()) {
                NetworkInfo networkInfo = connectivityManager.getNetworkInfo(1);
                if (networkInfo != null && (state = networkInfo.getState()) != null && (state == NetworkInfo.State.CONNECTED || state == NetworkInfo.State.CONNECTING)) {
                    return 1;
                }
                NetworkInfo networkInfo2 = connectivityManager.getNetworkInfo(0);
                if (networkInfo2 != null) {
                    NetworkInfo.State state2 = networkInfo2.getState();
                    String subtypeName = networkInfo2.getSubtypeName();
                    if (state2 != null && (state2 == NetworkInfo.State.CONNECTED || state2 == NetworkInfo.State.CONNECTING)) {
                        switch (activeNetworkInfo.getSubtype()) {
                            case 1:
                            case 2:
                            case 4:
                            case 7:
                            case 11:
                                return 2;
                            case 3:
                            case 5:
                            case 6:
                            case 8:
                            case 9:
                            case 10:
                            case 12:
                            case 14:
                            case 15:
                                return 3;
                            case 13:
                                return 4;
                            default:
                                return (subtypeName.equalsIgnoreCase("TD-SCDMA") || subtypeName.equalsIgnoreCase("WCDMA") || subtypeName.equalsIgnoreCase("CDMA2000")) ? 3 : 5;
                        }
                    }
                }
            }
            return 0;
        }
        return invokeL.intValue;
    }

    public static String g(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65542, null, context)) == null) {
            try {
                String deviceId = ((TelephonyManager) context.getSystemService("phone")).getDeviceId();
                return deviceId == null ? "" : s49.a(deviceId);
            } catch (Exception unused) {
                return "";
            }
        }
        return (String) invokeL.objValue;
    }

    public static String h(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65543, null, context)) == null) {
            WifiManager wifiManager = (WifiManager) context.getSystemService("wifi");
            WifiInfo connectionInfo = wifiManager.getConnectionInfo();
            if (connectionInfo == null || !Config.DEF_MAC_ID.equals(connectionInfo.getMacAddress())) {
                return (connectionInfo == null || connectionInfo.getMacAddress() == null) ? "" : s49.a(connectionInfo.getMacAddress());
            }
            try {
                String d = d();
                if (d != null) {
                    return s49.a(d);
                }
                return s49.a(b(wifiManager));
            } catch (Exception e) {
                w49.d(e);
                return s49.a(Config.DEF_MAC_ID);
            }
        }
        return (String) invokeL.objValue;
    }

    public static String i(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65544, null, context)) == null) {
            int i = 0;
            try {
                i = context.getPackageManager().getPackageInfo(context.getPackageName(), 0).versionCode;
            } catch (PackageManager.NameNotFoundException e) {
                w49.d(e);
            }
            return String.valueOf(i);
        }
        return (String) invokeL.objValue;
    }

    public static String j(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65545, null, context)) == null) {
            try {
                PackageInfo packageInfo = context.getPackageManager().getPackageInfo(context.getPackageName(), 1);
                return packageInfo != null ? packageInfo.versionName == null ? StringUtil.NULL_STRING : packageInfo.versionName : "";
            } catch (PackageManager.NameNotFoundException e) {
                w49.d(e);
                return "";
            }
        }
        return (String) invokeL.objValue;
    }

    public static void k(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65546, null, context) == null) {
            DisplayMetrics displayMetrics = new DisplayMetrics();
            ((WindowManager) context.getSystemService("window")).getDefaultDisplay().getMetrics(displayMetrics);
            a = String.valueOf(displayMetrics.widthPixels);
            b = String.valueOf(displayMetrics.heightPixels);
            c = String.valueOf(displayMetrics.density);
        }
    }

    public static String l(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65547, null, context)) == null) {
            try {
                return context.getResources().getString(context.getPackageManager().getPackageInfo(context.getPackageName(), 0).applicationInfo.labelRes);
            } catch (PackageManager.NameNotFoundException e) {
                w49.d(e);
                return null;
            }
        }
        return (String) invokeL.objValue;
    }

    public static String m() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65548, null)) == null) {
            if (TextUtils.isEmpty(a)) {
                k(n39.h().getContext());
            }
            return a;
        }
        return (String) invokeV.objValue;
    }

    public static String n() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65549, null)) == null) {
            if (TextUtils.isEmpty(b)) {
                k(n39.h().getContext());
            }
            return b;
        }
        return (String) invokeV.objValue;
    }
}
