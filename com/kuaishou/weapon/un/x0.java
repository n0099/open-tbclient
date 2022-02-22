package com.kuaishou.weapon.un;

import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.app.ActivityManager;
import android.bluetooth.BluetoothAdapter;
import android.content.ContentResolver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.database.Cursor;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.Uri;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import android.os.Build;
import android.os.LocaleList;
import android.provider.Settings;
import android.telephony.SubscriptionInfo;
import android.telephony.SubscriptionManager;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import android.view.inputmethod.InputMethodInfo;
import android.view.inputmethod.InputMethodManager;
import androidx.core.view.InputDeviceCompat;
import com.baidu.tbadk.core.util.httpNet.HttpRequest;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.LineNumberReader;
import java.io.Reader;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.net.InetAddress;
import java.net.NetworkInterface;
import java.util.Enumeration;
import java.util.List;
import java.util.Locale;
import org.json.JSONArray;
/* loaded from: classes4.dex */
public class x0 {
    public static /* synthetic */ Interceptable $ic;
    public static String a;
    public transient /* synthetic */ FieldHolder $fh;

    public x0() {
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

    @TargetApi(22)
    public static int a(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, context)) == null) {
            try {
                SubscriptionManager subscriptionManager = (SubscriptionManager) context.getSystemService("telephony_subscription_service");
                if (subscriptionManager == null) {
                    return -1;
                }
                if (s.a(context, s.f55454c) == -1) {
                    return -3;
                }
                return subscriptionManager.getActiveSubscriptionInfoCount();
            } catch (Throwable th) {
                a(th);
                return -2;
            }
        }
        return invokeL.intValue;
    }

    public static String a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) {
            try {
                Locale locale = Locale.getDefault();
                return locale.getLanguage() + "-" + locale.getCountry();
            } catch (Throwable th) {
                a(th);
                return "";
            }
        }
        return (String) invokeV.objValue;
    }

    @SuppressLint({"LocalSuppress", "NewApi"})
    public static String a(Context context, int i2) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(65539, null, context, i2)) == null) {
            try {
                if (s.a(context, s.f55454c) == -1) {
                    return y0.a;
                }
                TelephonyManager telephonyManager = (TelephonyManager) context.getSystemService("phone");
                if (telephonyManager == null) {
                    return y0.f55521b;
                }
                String deviceId = telephonyManager.getDeviceId(i2);
                return TextUtils.isEmpty(deviceId) ? y0.f55522c : deviceId;
            } catch (Throwable th) {
                a(th);
                return y0.f55523d;
            }
        }
        return (String) invokeLI.objValue;
    }

    public static String a(BufferedInputStream bufferedInputStream) {
        InterceptResult invokeL;
        int read;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, bufferedInputStream)) == null) {
            if (bufferedInputStream == null) {
                return "";
            }
            byte[] bArr = new byte[512];
            StringBuilder sb = new StringBuilder();
            do {
                try {
                    read = bufferedInputStream.read(bArr);
                    if (read > 0) {
                        sb.append(new String(bArr, 0, read));
                        continue;
                    }
                } catch (Exception e2) {
                    e2.printStackTrace();
                }
            } while (read >= 512);
            return sb.toString();
        }
        return (String) invokeL.objValue;
    }

    public static String a(Reader reader) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable != null && (invokeL = interceptable.invokeL(65541, null, reader)) != null) {
            return (String) invokeL.objValue;
        }
        try {
            StringBuilder sb = new StringBuilder();
            char[] cArr = new char[4096];
            while (true) {
                int read = reader.read(cArr);
                if (read < 0) {
                    return sb.toString();
                }
                sb.append(cArr, 0, read);
            }
        } catch (Throwable th) {
            a(th);
            return null;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:43:0x0075  */
    /* JADX WARN: Removed duplicated region for block: B:58:0x0092  */
    /* JADX WARN: Removed duplicated region for block: B:65:0x006b A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:67:0x0088 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:69:0x0061 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:73:0x007e A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static String a(String str) {
        InterceptResult invokeL;
        Process process;
        BufferedInputStream bufferedInputStream;
        BufferedOutputStream bufferedOutputStream;
        Interceptable interceptable = $ic;
        if (interceptable != null && (invokeL = interceptable.invokeL(65542, null, str)) != null) {
            return (String) invokeL.objValue;
        }
        BufferedOutputStream bufferedOutputStream2 = null;
        try {
            process = Runtime.getRuntime().exec("sh");
            try {
                bufferedOutputStream = new BufferedOutputStream(process.getOutputStream());
                try {
                    bufferedInputStream = new BufferedInputStream(process.getInputStream());
                } catch (Exception unused) {
                    bufferedInputStream = null;
                } catch (Throwable th) {
                    th = th;
                    bufferedInputStream = null;
                }
                try {
                    bufferedOutputStream.write(str.getBytes());
                    bufferedOutputStream.write(10);
                    bufferedOutputStream.flush();
                    bufferedOutputStream.close();
                    process.waitFor();
                    String a2 = a(bufferedInputStream);
                    try {
                        bufferedOutputStream.close();
                    } catch (IOException e2) {
                        e2.printStackTrace();
                    }
                    try {
                        bufferedInputStream.close();
                    } catch (IOException e3) {
                        e3.printStackTrace();
                    }
                    if (process != null) {
                        process.destroy();
                    }
                    return a2;
                } catch (Exception unused2) {
                    if (bufferedOutputStream != null) {
                        try {
                            bufferedOutputStream.close();
                        } catch (IOException e4) {
                            e4.printStackTrace();
                        }
                    }
                    if (bufferedInputStream != null) {
                        try {
                            bufferedInputStream.close();
                        } catch (IOException e5) {
                            e5.printStackTrace();
                        }
                    }
                    if (process != null) {
                        process.destroy();
                    }
                    return null;
                } catch (Throwable th2) {
                    th = th2;
                    bufferedOutputStream2 = bufferedOutputStream;
                    if (bufferedOutputStream2 != null) {
                        try {
                            bufferedOutputStream2.close();
                        } catch (IOException e6) {
                            e6.printStackTrace();
                        }
                    }
                    if (bufferedInputStream != null) {
                        try {
                            bufferedInputStream.close();
                        } catch (IOException e7) {
                            e7.printStackTrace();
                        }
                    }
                    if (process != null) {
                        process.destroy();
                    }
                    throw th;
                }
            } catch (Exception unused3) {
                bufferedOutputStream = null;
                bufferedInputStream = null;
                if (bufferedOutputStream != null) {
                }
                if (bufferedInputStream != null) {
                }
                if (process != null) {
                }
                return null;
            } catch (Throwable th3) {
                th = th3;
                bufferedInputStream = null;
                if (bufferedOutputStream2 != null) {
                }
                if (bufferedInputStream != null) {
                }
                if (process != null) {
                }
                throw th;
            }
        } catch (Exception unused4) {
            process = null;
        } catch (Throwable th4) {
            th = th4;
            process = null;
        }
    }

    public static Method a(Class<?> cls, String str, Class<?>... clsArr) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(65543, null, cls, str, clsArr)) == null) {
            try {
                Method method = cls.getMethod(str, clsArr);
                if (method != null) {
                    return method;
                }
            } catch (Throwable th) {
                a(th);
            }
            while (cls != null) {
                try {
                    Method declaredMethod = cls.getDeclaredMethod(str, clsArr);
                    declaredMethod.setAccessible(true);
                    return declaredMethod;
                } catch (NoSuchMethodException e2) {
                    a(e2);
                    cls = cls.getSuperclass();
                }
            }
            throw new NoSuchMethodException();
        }
        return (Method) invokeLLL.objValue;
    }

    public static void a(Throwable th) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(65544, null, th) == null) && r0.b()) {
            l1.a(th);
        }
    }

    public static String b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65545, null)) == null) {
            Locale locale = Build.VERSION.SDK_INT >= 24 ? LocaleList.getDefault().get(0) : Locale.getDefault();
            return locale.getLanguage() + "-" + locale.getCountry();
        }
        return (String) invokeV.objValue;
    }

    public static String b(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65546, null, context)) == null) {
            try {
                List<InputMethodInfo> inputMethodList = ((InputMethodManager) context.getSystemService("input_method")).getInputMethodList();
                StringBuilder sb = new StringBuilder();
                for (InputMethodInfo inputMethodInfo : inputMethodList) {
                    sb.append(inputMethodInfo.getId());
                    sb.append(";");
                }
                if (TextUtils.isEmpty(sb)) {
                    return y0.f55522c;
                }
                String sb2 = sb.toString();
                return sb2.endsWith(";") ? sb2.substring(0, sb2.length() - 1) : sb2;
            } catch (Exception unused) {
                return y0.f55523d;
            }
        }
        return (String) invokeL.objValue;
    }

    public static String b(Context context, int i2) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(65547, null, context, i2)) == null) {
            try {
                if (Build.VERSION.SDK_INT > 22) {
                    SubscriptionManager subscriptionManager = (SubscriptionManager) context.getSystemService("telephony_subscription_service");
                    if (subscriptionManager == null) {
                        return y0.f55521b;
                    }
                    if (s.a(context, s.f55454c) == -1) {
                        return y0.a;
                    }
                    List<SubscriptionInfo> activeSubscriptionInfoList = subscriptionManager.getActiveSubscriptionInfoList();
                    if (activeSubscriptionInfoList == null) {
                        return y0.f55521b;
                    }
                    for (SubscriptionInfo subscriptionInfo : activeSubscriptionInfoList) {
                        if (subscriptionInfo != null && subscriptionInfo.getSubscriptionId() == i2) {
                            String iccId = subscriptionInfo.getIccId();
                            return TextUtils.isEmpty(iccId) ? y0.f55522c : iccId;
                        }
                    }
                }
                return y0.f55522c;
            } catch (Throwable th) {
                a(th);
                return y0.f55523d;
            }
        }
        return (String) invokeLI.objValue;
    }

    public static String b(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65548, null, str)) == null) {
            try {
                Class<?> cls = Class.forName("android.os.SystemProperties");
                return (String) cls.getMethod("get", String.class).invoke(cls, str);
            } catch (Throwable th) {
                a(th);
                return null;
            }
        }
        return (String) invokeL.objValue;
    }

    public static Method b(Class<?> cls, String str, Class<?>... clsArr) {
        Method method;
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(65549, null, cls, str, clsArr)) == null) {
            try {
                method = a(cls, str, clsArr);
                try {
                    method.setAccessible(true);
                } catch (Throwable th) {
                    th = th;
                    a(th);
                    return method;
                }
            } catch (Throwable th2) {
                th = th2;
                method = null;
            }
            return method;
        }
        return (Method) invokeLLL.objValue;
    }

    public static String c(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65550, null, context)) == null) {
            try {
                String string = Settings.Secure.getString(context.getContentResolver(), HttpRequest.ANDROID_ID);
                return TextUtils.isEmpty(string) ? y0.f55522c : string;
            } catch (Throwable th) {
                a(th);
                return y0.f55523d;
            }
        }
        return (String) invokeL.objValue;
    }

    public static String c(Context context, int i2) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(65551, null, context, i2)) == null) {
            try {
                String i3 = i(context, i2);
                if (TextUtils.isEmpty(i3) || i3.contains("RISK_")) {
                    String d2 = d(context, i2 - 1);
                    return (TextUtils.isEmpty(d2) || d2.contains("RISK_")) ? b(context, i2) : d2;
                }
                return i3;
            } catch (Throwable th) {
                a(th);
                return y0.f55523d;
            }
        }
        return (String) invokeLI.objValue;
    }

    public static InetAddress c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable != null && (invokeV = interceptable.invokeV(65552, null)) != null) {
            return (InetAddress) invokeV.objValue;
        }
        InetAddress inetAddress = null;
        try {
            Enumeration<NetworkInterface> networkInterfaces = NetworkInterface.getNetworkInterfaces();
            InetAddress inetAddress2 = null;
            do {
                try {
                    if (!networkInterfaces.hasMoreElements()) {
                        return inetAddress2;
                    }
                    Enumeration<InetAddress> inetAddresses = networkInterfaces.nextElement().getInetAddresses();
                    while (true) {
                        if (inetAddresses.hasMoreElements()) {
                            InetAddress nextElement = inetAddresses.nextElement();
                            try {
                                if (!nextElement.isLoopbackAddress() && nextElement.getHostAddress().indexOf(":") == -1) {
                                    inetAddress2 = nextElement;
                                    continue;
                                    break;
                                }
                                inetAddress2 = null;
                            } catch (Throwable unused) {
                                inetAddress = nextElement;
                                return inetAddress;
                            }
                        }
                    }
                } catch (Throwable unused2) {
                    inetAddress = inetAddress2;
                }
            } while (inetAddress2 == null);
            return inetAddress2;
        } catch (Throwable unused3) {
        }
    }

    @SuppressLint({"DefaultLocale"})
    public static String d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65553, null)) == null) {
            try {
            } catch (Throwable th) {
                a(th);
            }
            if (TextUtils.isEmpty(a)) {
                if (Build.VERSION.SDK_INT >= 26) {
                    a = e();
                }
                if (TextUtils.isEmpty(a)) {
                    a = g();
                }
                if (TextUtils.isEmpty(a)) {
                    String f2 = f();
                    if (!TextUtils.isEmpty(f2)) {
                        a = f2.toUpperCase().substring(0, 17);
                    }
                }
                if (TextUtils.isEmpty(a)) {
                    a = e();
                }
                return a;
            }
            return a;
        }
        return (String) invokeV.objValue;
    }

    public static String d(Context context) {
        InterceptResult invokeL;
        Method method;
        Object invoke;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65554, null, context)) == null) {
            try {
                BluetoothAdapter defaultAdapter = BluetoothAdapter.getDefaultAdapter();
                Field declaredField = defaultAdapter.getClass().getDeclaredField("mService");
                declaredField.setAccessible(true);
                Object obj = declaredField.get(defaultAdapter);
                if (obj == null || (method = obj.getClass().getMethod("getAddress", new Class[0])) == null || (invoke = method.invoke(obj, new Object[0])) == null) {
                    return y0.f55521b;
                }
                String obj2 = invoke.toString();
                return TextUtils.isEmpty(obj2) ? y0.f55522c : obj2;
            } catch (Throwable th) {
                a(th);
                return y0.f55522c;
            }
        }
        return (String) invokeL.objValue;
    }

    public static String d(Context context, int i2) {
        InterceptResult invokeLI;
        ContentResolver contentResolver;
        Cursor query;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(65555, null, context, i2)) == null) {
            try {
                if (s.a(context, s.f55454c) == -1) {
                    return y0.a;
                }
                Uri parse = Uri.parse("content://telephony/siminfo");
                if (parse == null || (contentResolver = context.getContentResolver()) == null || (query = contentResolver.query(parse, new String[]{"_id", "sim_id", "icc_id", "display_name"}, "0=0", new String[0], null)) == null) {
                    return y0.f55521b;
                }
                while (query.moveToNext()) {
                    if (query.getInt(query.getColumnIndex("sim_id")) == i2) {
                        String string = query.getString(query.getColumnIndex("icc_id"));
                        return TextUtils.isEmpty(string) ? y0.f55522c : string;
                    }
                }
                return y0.f55523d;
            } catch (Throwable th) {
                a(th);
                return y0.f55523d;
            }
        }
        return (String) invokeLI.objValue;
    }

    @TargetApi(9)
    public static String e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65556, null)) == null) {
            try {
                InetAddress a2 = w1.a();
                if (a2 != null) {
                    byte[] hardwareAddress = NetworkInterface.getByInetAddress(a2).getHardwareAddress();
                    StringBuffer stringBuffer = new StringBuffer();
                    for (int i2 = 0; i2 < hardwareAddress.length; i2++) {
                        if (i2 != 0) {
                            stringBuffer.append(':');
                        }
                        String hexString = Integer.toHexString(hardwareAddress[i2] & 255);
                        if (hexString.length() == 1) {
                            hexString = 0 + hexString;
                        }
                        stringBuffer.append(hexString);
                    }
                    return stringBuffer.toString();
                }
            } catch (Throwable th) {
                a(th);
            }
            return null;
        }
        return (String) invokeV.objValue;
    }

    public static String e(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65557, null, context)) == null) {
            try {
                BluetoothAdapter defaultAdapter = BluetoothAdapter.getDefaultAdapter();
                if (defaultAdapter == null) {
                    return y0.f55521b;
                }
                String address = defaultAdapter.getAddress();
                return TextUtils.isEmpty(address) ? y0.f55522c : address;
            } catch (Throwable th) {
                a(th);
                return y0.f55523d;
            }
        }
        return (String) invokeL.objValue;
    }

    public static String e(Context context, int i2) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(65558, null, context, i2)) == null) {
            try {
                if (s.a(context, s.f55454c) == -1) {
                    return y0.a;
                }
                TelephonyManager telephonyManager = (TelephonyManager) context.getSystemService("phone");
                if (telephonyManager == null) {
                    return y0.f55521b;
                }
                Method method = telephonyManager.getClass().getMethod("getImei", Integer.TYPE);
                if (method == null) {
                    return y0.f55521b;
                }
                String str = (String) method.invoke(telephonyManager, Integer.valueOf(i2));
                return TextUtils.isEmpty(str) ? y0.f55522c : str;
            } catch (Throwable th) {
                a(th);
                return y0.f55523d;
            }
        }
        return (String) invokeLI.objValue;
    }

    /* JADX WARN: Code restructure failed: missing block: B:11:0x0018, code lost:
        if (r2 == null) goto L13;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static String f() {
        InterceptResult invokeV;
        FileReader fileReader;
        Interceptable interceptable = $ic;
        if (interceptable != null && (invokeV = interceptable.invokeV(65559, null)) != null) {
            return (String) invokeV.objValue;
        }
        String str = "";
        try {
            fileReader = new FileReader("/sys/class/net/eth0/address");
            try {
                str = a(fileReader);
            } catch (Throwable unused) {
            }
        } catch (Throwable unused2) {
            fileReader = null;
        }
        try {
            fileReader.close();
        } catch (Throwable unused3) {
            return str;
        }
    }

    public static String f(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65560, null, context)) == null) {
            try {
                boolean z = s.a(context, "android.permission.BLUETOOTH") == 0;
                if (Build.VERSION.SDK_INT < 23) {
                    return z ? e(context) : y0.a;
                }
                String string = Settings.Secure.getString(context.getContentResolver(), "bluetooth_address");
                return !TextUtils.isEmpty(string) ? string : z ? d(context) : y0.a;
            } catch (Throwable th) {
                a(th);
                return y0.f55523d;
            }
        }
        return (String) invokeL.objValue;
    }

    @SuppressLint({"LocalSuppress", "NewApi"})
    public static String f(Context context, int i2) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(65561, null, context, i2)) == null) {
            try {
                if (s.a(context, s.f55454c) == -1) {
                    return y0.a;
                }
                TelephonyManager telephonyManager = (TelephonyManager) context.getSystemService("phone");
                if (telephonyManager == null) {
                    return y0.f55521b;
                }
                String imei = telephonyManager.getImei(i2);
                return TextUtils.isEmpty(imei) ? y0.f55522c : imei;
            } catch (Throwable th) {
                a(th);
                return y0.f55523d;
            }
        }
        return (String) invokeLI.objValue;
    }

    public static String g() {
        InterceptResult invokeV;
        InputStreamReader inputStreamReader;
        Throwable th;
        LineNumberReader lineNumberReader;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65562, null)) == null) {
            String str = "";
            try {
                inputStreamReader = new InputStreamReader(Runtime.getRuntime().exec("cat /sys/class/net/wlan0/address").getInputStream());
                try {
                    lineNumberReader = new LineNumberReader(inputStreamReader);
                    String str2 = "";
                    while (str2 != null) {
                        try {
                            str2 = lineNumberReader.readLine();
                            if (str2 != null) {
                                str = str2.trim();
                                break;
                            }
                        } catch (Throwable th2) {
                            th = th2;
                            try {
                                a(th);
                            } finally {
                                if (inputStreamReader != null) {
                                    try {
                                        inputStreamReader.close();
                                    } catch (Throwable th3) {
                                        a(th3);
                                    }
                                }
                                if (lineNumberReader != null) {
                                    try {
                                        lineNumberReader.close();
                                    } catch (IOException e2) {
                                        a(e2);
                                    }
                                }
                            }
                        }
                    }
                    try {
                        inputStreamReader.close();
                    } catch (Throwable th4) {
                        a(th4);
                    }
                } catch (Throwable th5) {
                    lineNumberReader = null;
                    th = th5;
                }
            } catch (Throwable th6) {
                inputStreamReader = null;
                th = th6;
                lineNumberReader = null;
            }
            return str;
        }
        return (String) invokeV.objValue;
    }

    @SuppressLint({"NewApi", "LocalSuppress"})
    public static String g(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65563, null, context)) == null) {
            try {
                return s.a(context, s.f55454c) == -1 ? y0.a : Build.getSerial();
            } catch (Throwable th) {
                a(th);
                return y0.f55523d;
            }
        }
        return (String) invokeL.objValue;
    }

    public static String g(Context context, int i2) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(65564, null, context, i2)) == null) {
            try {
                String a2 = a(context, i2);
                if (TextUtils.isEmpty(a2) || a2.contains("RISK_")) {
                    String e2 = e(context, i2);
                    return (TextUtils.isEmpty(e2) || e2.contains("RISK_")) ? f(context, i2) : e2;
                }
                return a2;
            } catch (Throwable th) {
                a(th);
                return y0.f55523d;
            }
        }
        return (String) invokeLI.objValue;
    }

    public static String h(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65565, null, context)) == null) {
            try {
                String b2 = b("ro.serialno");
                String str = Build.SERIAL;
                return !TextUtils.isEmpty(b2) ? b2 : !TextUtils.isEmpty(str) ? str : y0.f55522c;
            } catch (Throwable th) {
                a(th);
                return y0.f55523d;
            }
        }
        return (String) invokeL.objValue;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r8v9 */
    public static String h(Context context, int i2) {
        InterceptResult invokeLI;
        Object invoke;
        Interceptable interceptable = $ic;
        if (interceptable != null && (invokeLI = interceptable.invokeLI(65566, null, context, i2)) != null) {
            return (String) invokeLI.objValue;
        }
        if (Build.VERSION.SDK_INT >= 23 && s.a(context, s.f55454c) == -1) {
            return y0.a;
        }
        TelephonyManager telephonyManager = (TelephonyManager) context.getSystemService("phone");
        if (telephonyManager == null) {
            return y0.f55521b;
        }
        String str = null;
        try {
            Class<?> cls = telephonyManager.getClass();
            if (Build.VERSION.SDK_INT <= 21) {
                if (Build.VERSION.SDK_INT == 21) {
                    Method method = cls.getMethod("getSubscriberId", Long.TYPE);
                    if (method == null) {
                        return y0.f55521b;
                    }
                    invoke = method.invoke(telephonyManager, Long.valueOf(i2));
                }
                return (TextUtils.isEmpty(str) || str == null) ? y0.f55522c : str;
            }
            Method method2 = cls.getMethod("getSubscriberId", Integer.TYPE);
            if (method2 == null) {
                return y0.f55521b;
            }
            invoke = method2.invoke(telephonyManager, Integer.valueOf(i2));
            str = invoke;
            if (TextUtils.isEmpty(str)) {
                return y0.f55522c;
            }
        } catch (Throwable th) {
            l1.a(th);
            return y0.f55523d;
        }
    }

    public static String i(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65567, null, context)) == null) {
            try {
                if (Settings.Secure.getInt(context.getContentResolver(), "accessibility_enabled", 0) != 1) {
                    return y0.f55524e;
                }
                String string = Settings.Secure.getString(context.getContentResolver(), "enabled_accessibility_services");
                return TextUtils.isEmpty(string) ? y0.f55522c : string;
            } catch (Throwable th) {
                a(th);
                return y0.f55523d;
            }
        }
        return (String) invokeL.objValue;
    }

    public static String i(Context context, int i2) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(65568, null, context, i2)) == null) {
            try {
                if (s.a(context, s.f55454c) == -1) {
                    return y0.a;
                }
                TelephonyManager telephonyManager = (TelephonyManager) context.getSystemService("phone");
                if (telephonyManager == null) {
                    return y0.f55521b;
                }
                Method method = telephonyManager.getClass().getMethod("getSimSerialNumber", Integer.TYPE);
                if (method == null) {
                    return y0.f55521b;
                }
                method.setAccessible(true);
                Object invoke = method.invoke(telephonyManager, Integer.valueOf(i2));
                return invoke == null ? y0.f55522c : invoke.toString();
            } catch (Throwable th) {
                a(th);
                return y0.f55523d;
            }
        }
        return (String) invokeLI.objValue;
    }

    public static String j(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65569, null, context)) == null) {
            try {
                String string = Settings.Secure.getString(context.getContentResolver(), "default_input_method");
                return TextUtils.isEmpty(string) ? y0.f55522c : string;
            } catch (Throwable th) {
                a(th);
                return y0.f55523d;
            }
        }
        return (String) invokeL.objValue;
    }

    public static String k(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65570, null, context)) == null) {
            try {
                if (s.a(context, s.f55454c) == -1) {
                    return y0.a;
                }
                TelephonyManager telephonyManager = (TelephonyManager) context.getSystemService("phone");
                if (telephonyManager == null) {
                    return y0.f55521b;
                }
                String deviceId = telephonyManager.getDeviceId();
                return TextUtils.isEmpty(deviceId) ? y0.f55522c : deviceId;
            } catch (Throwable th) {
                a(th);
                return y0.f55523d;
            }
        }
        return (String) invokeL.objValue;
    }

    @SuppressLint({"LocalSuppress", "NewApi"})
    public static String l(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65571, null, context)) == null) {
            try {
                if (s.a(context, s.f55454c) == -1) {
                    return y0.a;
                }
                TelephonyManager telephonyManager = (TelephonyManager) context.getSystemService("phone");
                if (telephonyManager == null) {
                    return y0.f55521b;
                }
                String imei = telephonyManager.getImei();
                return TextUtils.isEmpty(imei) ? y0.f55522c : imei;
            } catch (Throwable th) {
                a(th);
                return y0.f55523d;
            }
        }
        return (String) invokeL.objValue;
    }

    public static String m(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65572, null, context)) == null) {
            try {
                if (s.a(context, s.f55454c) == -1) {
                    return y0.a;
                }
                TelephonyManager telephonyManager = (TelephonyManager) context.getSystemService("phone");
                if (telephonyManager == null) {
                    return y0.f55521b;
                }
                String simSerialNumber = telephonyManager.getSimSerialNumber();
                return TextUtils.isEmpty(simSerialNumber) ? y0.f55522c : simSerialNumber;
            } catch (Throwable th) {
                a(th);
                return y0.f55523d;
            }
        }
        return (String) invokeL.objValue;
    }

    public static String n(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65573, null, context)) == null) {
            try {
                String k = k(context);
                d dVar = new d(context);
                if (!TextUtils.isEmpty(k) && !k.contains("RISK_")) {
                    dVar.b(d.M0, k, true);
                    return k;
                }
                String o = o(context);
                if (!TextUtils.isEmpty(o) && !o.contains("RISK_")) {
                    dVar.b(d.M0, o, true);
                    return o;
                }
                String l = l(context);
                if (!TextUtils.isEmpty(l) && !l.contains("RISK_")) {
                    dVar.b(d.M0, l, true);
                }
                return l;
            } catch (Throwable th) {
                a(th);
                return y0.f55523d;
            }
        }
        return (String) invokeL.objValue;
    }

    public static String o(Context context) {
        Method method;
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65574, null, context)) == null) {
            try {
                if (s.a(context, s.f55454c) == -1) {
                    return y0.a;
                }
                TelephonyManager telephonyManager = (TelephonyManager) context.getSystemService("phone");
                if (telephonyManager == null || (method = telephonyManager.getClass().getMethod("getImei", new Class[0])) == null) {
                    return y0.f55521b;
                }
                String str = (String) method.invoke(telephonyManager, new Object[0]);
                return TextUtils.isEmpty(str) ? y0.f55522c : str;
            } catch (Throwable th) {
                a(th);
                return y0.f55523d;
            }
        }
        return (String) invokeL.objValue;
    }

    public static String p(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65575, null, context)) == null) {
            try {
                if (s.a(context, s.f55454c) == -1) {
                    return y0.a;
                }
                TelephonyManager telephonyManager = (TelephonyManager) context.getSystemService("phone");
                if (telephonyManager == null) {
                    return y0.f55522c;
                }
                String subscriberId = telephonyManager.getSubscriberId();
                if (TextUtils.isEmpty(subscriberId)) {
                    return y0.f55522c;
                }
                new d(context).b(d.N0, subscriberId, true);
                return subscriberId;
            } catch (Throwable th) {
                a(th);
                return y0.f55523d;
            }
        }
        return (String) invokeL.objValue;
    }

    @TargetApi(22)
    public static int q(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65576, null, context)) == null) {
            try {
                SubscriptionManager subscriptionManager = (SubscriptionManager) context.getSystemService("telephony_subscription_service");
                if (subscriptionManager == null) {
                    return -1;
                }
                return subscriptionManager.getActiveSubscriptionInfoCountMax();
            } catch (Throwable th) {
                a(th);
                return -2;
            }
        }
        return invokeL.intValue;
    }

    @TargetApi(23)
    public static int r(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65577, null, context)) == null) {
            try {
                TelephonyManager telephonyManager = (TelephonyManager) context.getSystemService("phone");
                if (telephonyManager == null) {
                    return -1;
                }
                return telephonyManager.getPhoneCount();
            } catch (Throwable th) {
                a(th);
                return -2;
            }
        }
        return invokeL.intValue;
    }

    public static String s(Context context) {
        List<ActivityManager.RunningAppProcessInfo> runningAppProcesses;
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65578, null, context)) == null) {
            try {
                ActivityManager activityManager = (ActivityManager) context.getSystemService("activity");
                if (activityManager == null || (runningAppProcesses = activityManager.getRunningAppProcesses()) == null) {
                    return y0.f55521b;
                }
                JSONArray jSONArray = new JSONArray();
                for (ActivityManager.RunningAppProcessInfo runningAppProcessInfo : runningAppProcesses) {
                    if (runningAppProcessInfo != null) {
                        jSONArray.put(runningAppProcessInfo.processName);
                    }
                }
                String jSONArray2 = jSONArray.toString();
                return TextUtils.isEmpty(jSONArray2) ? y0.f55522c : jSONArray2;
            } catch (Throwable th) {
                a(th);
                return y0.f55523d;
            }
        }
        return (String) invokeL.objValue;
    }

    @SuppressLint({"NewApi", "LocalSuppress"})
    public static String t(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65579, null, context)) == null) {
            try {
                return Build.VERSION.SDK_INT >= 26 ? g(context) : h(context);
            } catch (Throwable th) {
                a(th);
                return y0.f55523d;
            }
        }
        return (String) invokeL.objValue;
    }

    public static int u(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65580, null, context)) == null) {
            try {
                return Settings.System.getInt(context.getContentResolver(), "screen_brightness", 255);
            } catch (Exception e2) {
                e2.printStackTrace();
                return 0;
            }
        }
        return invokeL.intValue;
    }

    public static String v(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65581, null, context)) == null) {
            try {
                WifiInfo connectionInfo = ((WifiManager) context.getSystemService("wifi")).getConnectionInfo();
                return connectionInfo != null ? connectionInfo.getMacAddress() : "";
            } catch (Throwable th) {
                a(th);
                return "";
            }
        }
        return (String) invokeL.objValue;
    }

    public static boolean w(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65582, null, context)) == null) {
            try {
                if (s.a(context, new String[]{"android.permission.ACCESS_NETWORK_STATE"})) {
                    NetworkInfo activeNetworkInfo = ((ConnectivityManager) context.getSystemService("connectivity")).getActiveNetworkInfo();
                    if (activeNetworkInfo == null) {
                        return false;
                    }
                    return activeNetworkInfo.isConnected();
                }
                return true;
            } catch (Throwable th) {
                a(th);
                return false;
            }
        }
        return invokeL.booleanValue;
    }

    public static int x(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65583, null, context)) == null) {
            try {
                IntentFilter intentFilter = new IntentFilter();
                intentFilter.addAction("android.intent.action.BATTERY_CHANGED");
                Intent registerReceiver = context.getApplicationContext().registerReceiver(null, intentFilter);
                if (registerReceiver.getAction().equals("android.intent.action.BATTERY_CHANGED")) {
                    return registerReceiver.getIntExtra("plugged", 0);
                }
                return 0;
            } catch (Throwable th) {
                a(th);
                return 0;
            }
        }
        return invokeL.intValue;
    }

    public static boolean y(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65584, null, context)) == null) {
            try {
                return Settings.Secure.getInt(context.getContentResolver(), "adb_enabled", 0) > 0;
            } catch (Throwable th) {
                a(th);
                return false;
            }
        }
        return invokeL.booleanValue;
    }

    public static boolean z(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65585, null, context)) == null) {
            try {
                NetworkInfo activeNetworkInfo = ((ConnectivityManager) context.getSystemService("connectivity")).getActiveNetworkInfo();
                if (activeNetworkInfo == null) {
                    return false;
                }
                return 1 == activeNetworkInfo.getType();
            } catch (Throwable th) {
                a(th);
                return false;
            }
        }
        return invokeL.booleanValue;
    }
}
