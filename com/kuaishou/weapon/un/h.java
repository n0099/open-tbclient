package com.kuaishou.weapon.un;

import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.pm.ApplicationInfo;
import android.content.pm.ResolveInfo;
import android.media.AudioManager;
import android.net.Uri;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import android.os.Build;
import android.os.Environment;
import android.os.Process;
import android.provider.Settings;
import android.telephony.CellInfo;
import android.telephony.CellLocation;
import android.telephony.CellSignalStrength;
import android.telephony.SubscriptionManager;
import android.telephony.TelephonyManager;
import android.telephony.cdma.CdmaCellLocation;
import android.telephony.gsm.GsmCellLocation;
import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import com.baidu.searchbox.aideviceperformance.utils.HardwareInfoUtils;
import com.baidu.tbadk.core.util.httpNet.HttpRequest;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.InputStreamReader;
import java.io.LineNumberReader;
import java.lang.reflect.Method;
import java.net.Inet4Address;
import java.net.InetAddress;
import java.net.NetworkInterface;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Enumeration;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import org.webrtc.MediaStreamTrack;
/* loaded from: classes3.dex */
public class h {
    public static /* synthetic */ Interceptable $ic = null;
    public static String a = "";

    /* renamed from: b  reason: collision with root package name */
    public static String f55108b = "";

    /* renamed from: c  reason: collision with root package name */
    public static String f55109c = "";

    /* renamed from: d  reason: collision with root package name */
    public static String f55110d = "";

    /* renamed from: e  reason: collision with root package name */
    public static String f55111e = "";

    /* renamed from: f  reason: collision with root package name */
    public static String f55112f = "";

    /* renamed from: g  reason: collision with root package name */
    public static String[] f55113g;

    /* renamed from: h  reason: collision with root package name */
    public static boolean f55114h;

    /* renamed from: i  reason: collision with root package name */
    public static boolean f55115i;

    /* renamed from: j  reason: collision with root package name */
    public static boolean f55116j;
    public static boolean k;
    public static boolean l;
    public static boolean m;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1645310146, "Lcom/kuaishou/weapon/un/h;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-1645310146, "Lcom/kuaishou/weapon/un/h;");
                return;
            }
        }
        f55113g = new String[]{"", ""};
    }

    public h() {
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

    public static int a(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(65538, null, i2)) == null) {
            if (i2 != 0) {
                if (i2 == 1) {
                    return 1;
                }
                if (i2 == 2) {
                    return 2;
                }
                if (i2 == 3) {
                    return 3;
                }
                if (i2 == 4) {
                    return 4;
                }
                if (i2 == 5) {
                    return 5;
                }
            }
            return 0;
        }
        return invokeI.intValue;
    }

    public static int a(CellInfo cellInfo) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65539, null, cellInfo)) == null) {
            if (cellInfo == null) {
                return -1;
            }
            try {
                Method declaredMethod = cellInfo.getClass().getDeclaredMethod("getCellSignalStrength", new Class[0]);
                declaredMethod.setAccessible(true);
                return ((CellSignalStrength) declaredMethod.invoke(cellInfo, new Object[0])).getLevel();
            } catch (Throwable unused) {
                return -1;
            }
        }
        return invokeL.intValue;
    }

    public static String a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, null)) == null) {
            try {
                if (v.a().a(8)) {
                    Enumeration<NetworkInterface> networkInterfaces = NetworkInterface.getNetworkInterfaces();
                    while (networkInterfaces.hasMoreElements()) {
                        Enumeration<InetAddress> inetAddresses = networkInterfaces.nextElement().getInetAddresses();
                        while (inetAddresses.hasMoreElements()) {
                            InetAddress nextElement = inetAddresses.nextElement();
                            if ((nextElement instanceof Inet4Address) && !nextElement.isLoopbackAddress()) {
                                return nextElement.getHostAddress();
                            }
                        }
                    }
                    return "";
                }
                return "";
            } catch (Throwable unused) {
                return "";
            }
        }
        return (String) invokeV.objValue;
    }

    public static boolean a(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65541, null, context)) == null) ? context.checkCallingOrSelfPermission("android.permission.WRITE_EXTERNAL_STORAGE") == 0 : invokeL.booleanValue;
    }

    public static int[] a(Context context, int i2) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(65542, null, context, i2)) == null) {
            int[] iArr = {-1, -1, -1};
            if (context == null) {
                return iArr;
            }
            if (v.a(context).a(256)) {
                int a2 = a(i2);
                AudioManager audioManager = (AudioManager) context.getSystemService(MediaStreamTrack.AUDIO_TRACK_KIND);
                iArr[0] = audioManager.getStreamVolume(a2);
                iArr[1] = audioManager.getStreamMaxVolume(a2);
                if (Build.VERSION.SDK_INT >= 28) {
                    iArr[2] = audioManager.getStreamMinVolume(a2);
                }
                return iArr;
            }
            return iArr;
        }
        return (int[]) invokeLI.objValue;
    }

    public static int b(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65543, null, context)) == null) {
            try {
                if (v.a(context).a(128) && context.checkPermission(s.f55287c, Process.myPid(), Process.myUid()) == 0 && Build.VERSION.SDK_INT >= 22) {
                    return ((SubscriptionManager) context.getSystemService("telephony_subscription_service")).getActiveSubscriptionInfoCount();
                }
                return -1;
            } catch (Exception unused) {
                return -1;
            }
        }
        return invokeL.intValue;
    }

    public static long b() {
        InterceptResult invokeV;
        BufferedReader bufferedReader;
        String readLine;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65544, null)) == null) {
            BufferedReader bufferedReader2 = null;
            try {
                bufferedReader = new BufferedReader(new FileReader(HardwareInfoUtils.MEM_INFO_FILE), 8192);
            } catch (Exception unused) {
            } catch (Throwable th) {
                th = th;
            }
            do {
                try {
                    try {
                        readLine = bufferedReader.readLine();
                        if (readLine != null) {
                        }
                    } catch (Exception unused2) {
                        bufferedReader2 = bufferedReader;
                        if (bufferedReader2 != null) {
                            bufferedReader = bufferedReader2;
                            bufferedReader.close();
                            return 0L;
                        }
                        return 0L;
                    } catch (Throwable th2) {
                        th = th2;
                        bufferedReader2 = bufferedReader;
                        if (bufferedReader2 != null) {
                            try {
                                bufferedReader2.close();
                            } catch (Exception unused3) {
                            }
                        }
                        throw th;
                    }
                    bufferedReader.close();
                    return 0L;
                } catch (Exception unused4) {
                    return 0L;
                }
            } while (!readLine.contains("MemTotal"));
            long longValue = Long.valueOf(readLine.split("\\s+")[1]).longValue() << 10;
            try {
                bufferedReader.close();
            } catch (Exception unused5) {
            }
            return longValue;
        }
        return invokeV.longValue;
    }

    public static String c(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65545, null, context)) == null) {
            if (l) {
                return f55108b;
            }
            if (TextUtils.isEmpty(f55108b) && context != null) {
                if (v.a(context).a(2)) {
                    f55108b = Settings.Secure.getString(context.getContentResolver(), HttpRequest.ANDROID_ID);
                    if (TextUtils.isEmpty(f55108b)) {
                        l = true;
                    }
                    return f55108b;
                }
                return f55108b;
            }
            return f55108b;
        }
        return (String) invokeL.objValue;
    }

    public static int[] d(Context context) {
        InterceptResult invokeL;
        int i2;
        int i3;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65546, null, context)) == null) {
            int[] iArr = {-1, -1, -1};
            if (context == null) {
                return iArr;
            }
            if (v.a(context).a(64)) {
                int i4 = -1;
                if ((Build.VERSION.SDK_INT < 23 || context.checkPermission(s.f55291g, Process.myPid(), Process.myUid()) != -1) && context.checkPermission(s.f55291g, Process.myPid(), Process.myUid()) == 0) {
                    TelephonyManager telephonyManager = (TelephonyManager) context.getSystemService("phone");
                    CellLocation cellLocation = telephonyManager.getCellLocation();
                    if (cellLocation instanceof CdmaCellLocation) {
                        CdmaCellLocation cdmaCellLocation = (CdmaCellLocation) cellLocation;
                        i3 = cdmaCellLocation.getBaseStationId();
                        i2 = cdmaCellLocation.getNetworkId();
                    } else if (cellLocation instanceof GsmCellLocation) {
                        GsmCellLocation gsmCellLocation = (GsmCellLocation) cellLocation;
                        i3 = gsmCellLocation.getCid();
                        i2 = gsmCellLocation.getLac();
                    } else {
                        i2 = -1;
                        i3 = -1;
                    }
                    if (Build.VERSION.SDK_INT >= 17) {
                        CellInfo cellInfo = null;
                        Iterator<CellInfo> it = telephonyManager.getAllCellInfo().iterator();
                        while (true) {
                            if (!it.hasNext()) {
                                break;
                            }
                            CellInfo next = it.next();
                            if (next != null && next.isRegistered()) {
                                cellInfo = next;
                                break;
                            }
                        }
                        if (cellInfo != null) {
                            i4 = a(cellInfo);
                        }
                    }
                    iArr[0] = i3;
                    iArr[1] = i2;
                    iArr[2] = i4;
                }
                return iArr;
            }
            return iArr;
        }
        return (int[]) invokeL.objValue;
    }

    public static Intent e(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65547, null, context)) == null) {
            IntentFilter intentFilter = new IntentFilter();
            intentFilter.addAction("android.intent.action.ACTION_POWER_CONNECTED");
            intentFilter.addAction("android.intent.action.ACTION_POWER_DISCONNECTED");
            intentFilter.addAction("android.intent.action.BATTERY_CHANGED");
            return context.registerReceiver(null, intentFilter);
        }
        return (Intent) invokeL.objValue;
    }

    public static int f(Context context) {
        InterceptResult invokeL;
        Intent e2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65548, null, context)) == null) {
            if (context == null) {
                return -1;
            }
            try {
                if (v.a(context).a(512) && (e2 = e(context)) != null) {
                    int intExtra = e2.getIntExtra("plugged", -1);
                    if (intExtra == 2) {
                        return 1;
                    }
                    if (intExtra == 1) {
                        return 2;
                    }
                    if (intExtra == 4) {
                        return 3;
                    }
                    return intExtra == 0 ? 0 : -1;
                }
                return -1;
            } catch (Throwable unused) {
                return -1;
            }
        }
        return invokeL.intValue;
    }

    /* JADX WARN: Removed duplicated region for block: B:30:0x005a  */
    /* JADX WARN: Removed duplicated region for block: B:31:0x005d  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static String g(Context context) {
        boolean z;
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65549, null, context)) == null) {
            try {
            } catch (Exception unused) {
                z = false;
            }
            if (k) {
                return f55112f;
            }
            if (TextUtils.isEmpty(f55112f) && context != null) {
                if (v.a().a(128)) {
                    z = q(context);
                    if (z) {
                        try {
                            f55112f = ((TelephonyManager) context.getApplicationContext().getSystemService("phone")).getSimSerialNumber();
                        } catch (Exception unused2) {
                            f55112f = null;
                            if (z) {
                                k = true;
                            }
                            if (!TextUtils.isEmpty(f55112f)) {
                            }
                            f55112f = r4;
                            return r4;
                        }
                    }
                    if (z && TextUtils.isEmpty(f55112f)) {
                        k = true;
                    }
                    String str = !TextUtils.isEmpty(f55112f) ? "" : f55112f;
                    f55112f = str;
                    return str;
                }
                return f55112f;
            }
            return f55112f;
        }
        return (String) invokeL.objValue;
    }

    public static String[] h(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65550, null, context)) == null) {
            boolean z = false;
            if (!f55115i && Build.VERSION.SDK_INT < 29) {
                if (TextUtils.isEmpty(f55113g[0]) && TextUtils.isEmpty(f55113g[1]) && context != null) {
                    if (v.a(context).a(1)) {
                        boolean q = q(context);
                        if (q) {
                            try {
                                TelephonyManager telephonyManager = (TelephonyManager) context.getSystemService("phone");
                                if (telephonyManager != null) {
                                    if (Build.VERSION.SDK_INT >= 26) {
                                        int min = Math.min(m(context), 2);
                                        for (int i2 = 0; i2 < min; i2++) {
                                            f55113g[i2] = telephonyManager.getImei(i2);
                                        }
                                        if (TextUtils.isEmpty(f55113g[0]) && TextUtils.isEmpty(f55113g[1])) {
                                            f55115i = true;
                                        }
                                    } else {
                                        if (telephonyManager.getPhoneType() == 1) {
                                            if (Build.VERSION.SDK_INT >= 23) {
                                                int min2 = Math.min(m(context), 2);
                                                for (int i3 = 0; i3 < min2; i3++) {
                                                    f55113g[i3] = telephonyManager.getDeviceId(i3);
                                                }
                                            } else {
                                                f55113g[0] = telephonyManager.getDeviceId();
                                                f55113g[1] = null;
                                            }
                                            if (TextUtils.isEmpty(f55113g[0]) && TextUtils.isEmpty(f55113g[1])) {
                                            }
                                        } else {
                                            f55113g[0] = null;
                                            f55113g[1] = null;
                                        }
                                        f55115i = true;
                                    }
                                }
                            } catch (Exception unused) {
                                z = q;
                                if (z) {
                                    f55115i = true;
                                }
                                return f55113g;
                            }
                        }
                        return f55113g;
                    }
                    return f55113g;
                }
                return f55113g;
            }
            return f55113g;
        }
        return (String[]) invokeL.objValue;
    }

    public static String i(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65551, null, context)) == null) {
            try {
            } catch (Exception unused) {
                f55111e = null;
            }
            if (TextUtils.isEmpty(f55111e) && context != null) {
                if (Build.VERSION.SDK_INT < 29 && !f55116j && v.a().a(128)) {
                    boolean q = q(context);
                    if (q) {
                        f55111e = ((TelephonyManager) context.getApplicationContext().getSystemService("phone")).getSubscriberId();
                    }
                    if (q && TextUtils.isEmpty(f55111e)) {
                        f55116j = true;
                    }
                    f55111e = TextUtils.isEmpty(f55111e) ? "" : f55111e;
                    return f55111e;
                }
                return f55111e;
            }
            return f55111e;
        }
        return (String) invokeL.objValue;
    }

    public static String j(Context context) {
        InterceptResult invokeL;
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65552, null, context)) == null) {
            try {
            } catch (Exception unused) {
                z = false;
            }
            if (f55114h) {
                return a;
            }
            if (TextUtils.isEmpty(a) && context != null) {
                if (Build.VERSION.SDK_INT < 29 && v.a(context).a(1)) {
                    z = q(context);
                    if (z) {
                        try {
                            String deviceId = ((TelephonyManager) context.getSystemService("phone")).getDeviceId();
                            a = deviceId;
                            if (TextUtils.isEmpty(deviceId)) {
                                f55114h = true;
                            }
                        } catch (Exception unused2) {
                            if (z) {
                                f55114h = true;
                            }
                            return a;
                        }
                    }
                    return a;
                }
                return a;
            }
            return a;
        }
        return (String) invokeL.objValue;
    }

    public static String k(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65553, null, context)) == null) {
            if (TextUtils.isEmpty(f55109c) && context != null) {
                if (v.a(context).a(4)) {
                    WifiInfo connectionInfo = ((WifiManager) context.getSystemService("wifi")).getConnectionInfo();
                    if (connectionInfo != null) {
                        f55109c = connectionInfo.getMacAddress();
                    }
                    if (TextUtils.isEmpty(f55109c) || f55109c.equals("02:00:00:00:00:00")) {
                        Iterator it = Collections.list(NetworkInterface.getNetworkInterfaces()).iterator();
                        while (true) {
                            if (!it.hasNext()) {
                                break;
                            }
                            NetworkInterface networkInterface = (NetworkInterface) it.next();
                            if (networkInterface.getName().equalsIgnoreCase("wlan0")) {
                                byte[] hardwareAddress = networkInterface.getHardwareAddress();
                                if (hardwareAddress != null && hardwareAddress.length != 0) {
                                    StringBuilder sb = new StringBuilder();
                                    int length = hardwareAddress.length;
                                    for (int i2 = 0; i2 < length; i2++) {
                                        sb.append(String.format("%02X:", Byte.valueOf(hardwareAddress[i2])));
                                    }
                                    if (sb.length() > 0) {
                                        sb.deleteCharAt(sb.length() - 1);
                                    }
                                    f55109c = sb.toString();
                                }
                            }
                        }
                    }
                    if (TextUtils.isEmpty(f55109c) || f55109c.equals("02:00:00:00:00:00")) {
                        f55109c = new LineNumberReader(new InputStreamReader(Runtime.getRuntime().exec("cat /sys/class/net/wlan0/address ").getInputStream())).readLine();
                    }
                    if (!TextUtils.isEmpty(f55109c)) {
                        f55109c = f55109c.toUpperCase(Locale.US);
                    }
                    return f55109c;
                }
                return f55109c;
            }
            return f55109c;
        }
        return (String) invokeL.objValue;
    }

    public static String l(Context context) {
        InterceptResult invokeL;
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65554, null, context)) == null) {
            try {
            } catch (Exception unused) {
                z = false;
            }
            if (m) {
                return f55110d;
            }
            if (TextUtils.isEmpty(f55110d) && context != null) {
                if (v.a().a(4096)) {
                    z = q(context);
                    if (z) {
                        try {
                            TelephonyManager telephonyManager = (TelephonyManager) context.getSystemService("phone");
                            if (telephonyManager != null) {
                                if (Build.VERSION.SDK_INT >= 26) {
                                    String meid = telephonyManager.getMeid();
                                    f55110d = meid;
                                    if (TextUtils.isEmpty(meid)) {
                                        m = true;
                                    }
                                } else {
                                    if (telephonyManager.getPhoneType() == 2) {
                                        String deviceId = telephonyManager.getDeviceId();
                                        f55110d = deviceId;
                                        if (TextUtils.isEmpty(deviceId)) {
                                        }
                                    } else {
                                        f55110d = null;
                                    }
                                    m = true;
                                }
                            }
                        } catch (Exception unused2) {
                            if (z) {
                                m = true;
                            }
                            return f55110d;
                        }
                    }
                    return f55110d;
                }
                return "";
            }
            return f55110d;
        }
        return (String) invokeL.objValue;
    }

    public static int m(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65555, null, context)) == null) {
            try {
                if (v.a(context).a(128) && context.checkPermission(s.f55287c, Process.myPid(), Process.myUid()) == 0 && Build.VERSION.SDK_INT >= 23) {
                    return ((TelephonyManager) context.getSystemService("phone")).getPhoneCount();
                }
                return -1;
            } catch (Exception unused) {
                return -1;
            }
        }
        return invokeL.intValue;
    }

    public static List<String> n(Context context) {
        InterceptResult invokeL;
        String[] list;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65556, null, context)) == null) {
            ArrayList arrayList = new ArrayList();
            if (v.a(context).a(8192) && !s(context) && a(context)) {
                File file = new File(Environment.getExternalStorageDirectory().getAbsolutePath() + "/Android/data");
                if (file.exists() && file.isDirectory() && (list = file.list()) != null) {
                    for (String str : list) {
                        if (!TextUtils.isEmpty(str) && !str.startsWith(".")) {
                            arrayList.add(str);
                        }
                    }
                    return arrayList;
                }
                return arrayList;
            }
            return arrayList;
        }
        return (List) invokeL.objValue;
    }

    public static int o(Context context) {
        InterceptResult invokeL;
        ApplicationInfo applicationInfo;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65557, null, context)) == null) {
            if (context == null) {
                return 0;
            }
            try {
                applicationInfo = context.getApplicationInfo();
            } catch (Exception unused) {
            }
            if (applicationInfo != null) {
                return applicationInfo.targetSdkVersion;
            }
            ApplicationInfo applicationInfo2 = context.getPackageManager().getApplicationInfo(context.getPackageName(), 0);
            if (applicationInfo2 != null) {
                return applicationInfo2.targetSdkVersion;
            }
            return 0;
        }
        return invokeL.intValue;
    }

    public static String p(Context context) {
        InterceptResult invokeL;
        WifiManager wifiManager;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65558, null, context)) == null) {
            try {
                if (v.a().a(8) && (wifiManager = (WifiManager) context.getApplicationContext().getSystemService("wifi")) != null) {
                    int ipAddress = wifiManager.getConnectionInfo().getIpAddress();
                    return (ipAddress & 255) + "." + ((ipAddress >> 8) & 255) + "." + ((ipAddress >> 16) & 255) + "." + ((ipAddress >> 24) & 255);
                }
            } catch (Exception unused) {
            }
            return "";
        }
        return (String) invokeL.objValue;
    }

    public static boolean q(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65559, null, context)) == null) {
            boolean z = false;
            try {
                int o = o(context);
                if (Build.VERSION.SDK_INT >= 22 && o > 28) {
                    TelephonyManager telephonyManager = (TelephonyManager) context.getSystemService("phone");
                    if (telephonyManager != null) {
                        z = telephonyManager.hasCarrierPrivileges();
                    }
                } else if (context.checkPermission(s.f55287c, Process.myPid(), Process.myUid()) == 0) {
                    z = true;
                }
            } catch (Throwable unused) {
            }
            return z;
        }
        return invokeL.booleanValue;
    }

    public static boolean r(Context context) {
        InterceptResult invokeL;
        Intent e2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65560, null, context)) == null) {
            if (context == null) {
                return false;
            }
            try {
                if (v.a(context).a(512) && (e2 = e(context)) != null) {
                    int intExtra = e2.getIntExtra("status", -1);
                    return intExtra == 2 || intExtra == 5;
                }
                return false;
            } catch (Throwable unused) {
                return false;
            }
        }
        return invokeL.booleanValue;
    }

    public static boolean s(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65561, null, context)) == null) ? context.getApplicationInfo().targetSdkVersion >= 29 && Build.VERSION.SDK_INT >= 29 && !Environment.isExternalStorageLegacy() : invokeL.booleanValue;
    }

    public static boolean t(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65562, null, context)) == null) ? (context.getApplicationInfo().targetSdkVersion < 29 || Build.VERSION.SDK_INT < 29) ? Build.VERSION.SDK_INT >= 23 && context.checkPermission(s.f55291g, Process.myPid(), Process.myUid()) == -1 && context.checkPermission(s.f55292h, Process.myPid(), Process.myUid()) == -1 : context.checkPermission(s.f55291g, Process.myPid(), Process.myUid()) == -1 : invokeL.booleanValue;
    }

    public static List<String> u(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65563, null, context)) == null) {
            ArrayList arrayList = new ArrayList();
            if (v.a(context).a(16)) {
                Intent intent = new Intent("android.intent.action.MAIN", (Uri) null);
                intent.addCategory("android.intent.category.LAUNCHER");
                List<ResolveInfo> queryIntentActivities = context.getPackageManager().queryIntentActivities(intent, 32);
                List<String> n = n(context);
                for (ResolveInfo resolveInfo : queryIntentActivities) {
                    if (resolveInfo != null && resolveInfo.activityInfo != null && !TextUtils.isEmpty(resolveInfo.activityInfo.packageName)) {
                        String str = resolveInfo.activityInfo.packageName;
                        if (n != null && !n.isEmpty()) {
                            n.remove(str);
                        }
                        arrayList.add(str);
                    }
                }
                if (n != null && !n.isEmpty()) {
                    for (String str2 : n) {
                        arrayList.add(str2);
                    }
                }
                return arrayList;
            }
            return arrayList;
        }
        return (List) invokeL.objValue;
    }
}
