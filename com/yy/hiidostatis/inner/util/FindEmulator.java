package com.yy.hiidostatis.inner.util;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Build;
import android.telephony.TelephonyManager;
import androidx.core.view.InputDeviceCompat;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.kuaishou.weapon.un.s;
import com.yy.hiidostatis.api.HiidoSDK;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Iterator;
/* loaded from: classes3.dex */
public class FindEmulator {
    public static /* synthetic */ Interceptable $ic;
    public static int emurs;
    public static boolean isCheck;
    public static boolean isEmulator;
    public static final String[] known_device_ids;
    public static final String[] known_files;
    public static final String[] known_geny_files;
    public static final String[] known_imsi_ids;
    public static final String[] known_numbers;
    public static final String[] known_pipes;
    public static final String[] known_qemu_drivers;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes3.dex */
    public static class Property {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public String name;
        public String seek_value;

        public Property(String str, String str2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {str, str2};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.name = str;
            this.seek_value = str2;
        }
    }

    /* loaded from: classes3.dex */
    public static class tcp {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public int id;
        public long localIp;
        public int localPort;
        public int remoteIp;
        public int remotePort;

        public tcp(String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, String str9, String str10, String str11, String str12, String str13, String str14) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {str, str2, str3, str4, str5, str6, str7, str8, str9, str10, str11, str12, str13, str14};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.id = Integer.parseInt(str, 16);
            this.localIp = Long.parseLong(str2, 16);
            this.localPort = Integer.parseInt(str3, 16);
        }

        public static tcp create(String[] strArr) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(65537, null, strArr)) == null) ? new tcp(strArr[1], strArr[2], strArr[3], strArr[4], strArr[5], strArr[6], strArr[7], strArr[8], strArr[9], strArr[10], strArr[11], strArr[12], strArr[13], strArr[14]) : (tcp) invokeL.objValue;
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(329359404, "Lcom/yy/hiidostatis/inner/util/FindEmulator;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(329359404, "Lcom/yy/hiidostatis/inner/util/FindEmulator;");
                return;
            }
        }
        known_numbers = new String[]{"15555215554", "15555215556", "15555215558", "15555215560", "15555215562", "15555215564", "15555215566", "15555215568", "15555215570", "15555215572", "15555215574", "15555215576", "15555215578", "15555215580", "15555215582", "15555215584"};
        known_device_ids = new String[]{"000000000000000", "e21833235b6eef10", "012345678912345"};
        known_imsi_ids = new String[]{"310260000000000"};
        known_pipes = new String[]{"/dev/socket/qemud", "/dev/qemu_pipe"};
        known_files = new String[]{"/system/lib/libc_malloc_debug_qemu.so", "/sys/qemu_trace", "/init.nox.rc", "/ueventd.nox.rc", "/etc/init.nox.sh"};
        known_geny_files = new String[]{"/dev/socket/genyd", "/dev/socket/baseband_genyd"};
        known_qemu_drivers = new String[]{"goldfish"};
    }

    public FindEmulator() {
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

    public static int checkEmu(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, context)) == null) {
            init(context);
            return emurs;
        }
        return invokeL.intValue;
    }

    public static int checkEmulator(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65539, null, context)) == null) {
            try {
                return (hasEmulatorBuild(context) ? 8 : 0) | (hasKnownDeviceId(context) ? 1 : 0) | (hasKnownImsi(context) ? 4 : 0) | (hasGenyFiles() ? 16 : 0) | (hasPipes() ? 32 : 0) | (hasQEmuFiles() ? 64 : 0) | (hasQEmuDrivers() ? 128 : 0) | (hasAdbInEmulator() ? 256 : 0);
            } catch (Throwable unused) {
                return 0;
            }
        }
        return invokeL.intValue;
    }

    public static String getProp(Context context, String str) {
        InterceptResult invokeLL;
        ClassLoader classLoader;
        Class<?> loadClass;
        Method method;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(InputDeviceCompat.SOURCE_TRACKBALL, null, context, str)) == null) {
            try {
                if (Build.VERSION.SDK_INT > 27 || (classLoader = context.getClassLoader()) == null || (loadClass = classLoader.loadClass("android.os.SystemProperties")) == null || (method = loadClass.getMethod("get", String.class)) == null) {
                    return null;
                }
                return (String) method.invoke(loadClass, str);
            } catch (Throwable th) {
                th.printStackTrace();
                return null;
            }
        }
        return (String) invokeLL.objValue;
    }

    /* JADX WARN: Code restructure failed: missing block: B:32:0x007d, code lost:
        if (r2 == null) goto L37;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static boolean hasAdbInEmulator() throws IOException {
        InterceptResult invokeV;
        BufferedReader bufferedReader;
        Throwable th;
        int i2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65541, null)) == null) {
            boolean z = false;
            try {
                bufferedReader = new BufferedReader(new InputStreamReader(new FileInputStream("/proc/net/tcp")), 1000);
                try {
                    bufferedReader.readLine();
                    ArrayList arrayList = new ArrayList();
                    while (true) {
                        String readLine = bufferedReader.readLine();
                        if (readLine == null) {
                            break;
                        }
                        arrayList.add(tcp.create(readLine.split("\\W+")));
                    }
                    Iterator it = arrayList.iterator();
                    while (true) {
                        if (!it.hasNext()) {
                            i2 = -1;
                            break;
                        }
                        tcp tcpVar = (tcp) it.next();
                        if (tcpVar.localIp == 0) {
                            i2 = tcpVar.localPort;
                            break;
                        }
                    }
                    if (i2 != -1) {
                        Iterator it2 = arrayList.iterator();
                        while (it2.hasNext()) {
                            tcp tcpVar2 = (tcp) it2.next();
                            if (tcpVar2.localIp != 0 && tcpVar2.localPort == i2) {
                                z = true;
                            }
                        }
                    }
                } catch (Throwable th2) {
                    th = th2;
                    try {
                        th.printStackTrace();
                    } catch (Throwable th3) {
                        if (bufferedReader != null) {
                            bufferedReader.close();
                        }
                        throw th3;
                    }
                }
            } catch (Throwable th4) {
                bufferedReader = null;
                th = th4;
            }
            bufferedReader.close();
            return z;
        }
        return invokeV.booleanValue;
    }

    @SuppressLint({"NewApi"})
    public static boolean hasEmulatorBuild(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65542, null, context)) == null) {
            String str = Build.BRAND;
            String str2 = Build.DEVICE;
            String str3 = Build.MODEL;
            String str4 = Build.PRODUCT;
            if (str.compareTo("generic") == 0 || str2.compareTo("generic") == 0 || str3.compareTo("sdk") == 0 || str4.compareTo("sdk") == 0) {
                return true;
            }
            return Build.VERSION.SDK_INT >= 8 && Build.HARDWARE.compareTo("goldfish") == 0;
        }
        return invokeL.booleanValue;
    }

    public static boolean hasGenyFiles() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65543, null)) == null) {
            for (String str : known_geny_files) {
                if (new File(str).exists()) {
                    return true;
                }
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public static boolean hasKnownDeviceId(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65544, null, context)) == null) {
            if (HiidoSDK.instance().isUserAgreed() && ArdUtil.checkPermissions(context, s.f56838c)) {
                String deviceId = ((TelephonyManager) context.getSystemService("phone")).getDeviceId();
                for (String str : known_device_ids) {
                    if (str.equalsIgnoreCase(deviceId)) {
                        return true;
                    }
                }
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    public static boolean hasKnownImsi(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65545, null, context)) == null) {
            if (HiidoSDK.instance().isUserAgreed() && ArdUtil.checkPermissions(context, s.f56838c)) {
                String subscriberId = ((TelephonyManager) context.getSystemService("phone")).getSubscriberId();
                for (String str : known_imsi_ids) {
                    if (str.equalsIgnoreCase(subscriberId)) {
                        return true;
                    }
                }
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    public static boolean hasPipes() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65546, null)) == null) {
            for (String str : known_pipes) {
                if (new File(str).exists()) {
                    return true;
                }
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    /* JADX WARN: Removed duplicated region for block: B:26:0x0059  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static boolean hasQEmuDrivers() {
        InterceptResult invokeV;
        FileInputStream fileInputStream;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65547, null)) == null) {
            File[] fileArr = {new File("/proc/tty/drivers"), new File("/proc/cpuinfo")};
            for (int i2 = 0; i2 < 2; i2++) {
                File file = fileArr[i2];
                if (file.exists() && file.canRead()) {
                    byte[] bArr = new byte[1024];
                    FileInputStream fileInputStream2 = null;
                    try {
                        fileInputStream = new FileInputStream(file);
                    } catch (Throwable th) {
                        th = th;
                    }
                    try {
                        fileInputStream.read(bArr);
                        try {
                            fileInputStream.close();
                        } catch (IOException e2) {
                            e2.printStackTrace();
                        }
                    } catch (Throwable th2) {
                        th = th2;
                        fileInputStream2 = fileInputStream;
                        try {
                            th.printStackTrace();
                            if (fileInputStream2 != null) {
                                fileInputStream2.close();
                            }
                            String str = new String(bArr);
                            while (r8 < r7) {
                            }
                            continue;
                        } catch (Throwable th3) {
                            if (fileInputStream2 != null) {
                                try {
                                    fileInputStream2.close();
                                } catch (IOException e3) {
                                    e3.printStackTrace();
                                }
                            }
                            throw th3;
                        }
                    }
                    String str2 = new String(bArr);
                    for (String str3 : known_qemu_drivers) {
                        if (str2.contains(str3)) {
                            return true;
                        }
                    }
                    continue;
                }
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public static boolean hasQEmuFiles() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65548, null)) == null) {
            for (String str : known_files) {
                if (new File(str).exists()) {
                    return true;
                }
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public static void init(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65549, null, context) == null) {
            try {
                if (isCheck) {
                    return;
                }
                int checkEmulator = checkEmulator(context);
                emurs = checkEmulator;
                isEmulator = checkEmulator > 0;
                isCheck = true;
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
    }

    public static boolean isEmulator(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65550, null, context)) == null) {
            init(context);
            return isEmulator;
        }
        return invokeL.booleanValue;
    }

    public static boolean isOperatorNameAndroid(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65551, null, context)) == null) ? ((TelephonyManager) context.getSystemService("phone")).getNetworkOperatorName().equalsIgnoreCase("android") : invokeL.booleanValue;
    }
}
