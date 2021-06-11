package com.yy.hiidostatis.inner.util;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Build;
import android.telephony.TelephonyManager;
import com.yy.hiidostatis.api.HiidoSDK;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Iterator;
/* loaded from: classes7.dex */
public class FindEmulator {
    public static int emurs = 0;
    public static boolean isCheck = false;
    public static boolean isEmulator = false;
    public static final String[] known_numbers = {"15555215554", "15555215556", "15555215558", "15555215560", "15555215562", "15555215564", "15555215566", "15555215568", "15555215570", "15555215572", "15555215574", "15555215576", "15555215578", "15555215580", "15555215582", "15555215584"};
    public static final String[] known_device_ids = {"000000000000000", "e21833235b6eef10", "012345678912345"};
    public static final String[] known_imsi_ids = {"310260000000000"};
    public static final String[] known_pipes = {"/dev/socket/qemud", "/dev/qemu_pipe"};
    public static final String[] known_files = {"/system/lib/libc_malloc_debug_qemu.so", "/sys/qemu_trace", "/init.nox.rc", "/ueventd.nox.rc", "/etc/init.nox.sh"};
    public static final String[] known_geny_files = {"/dev/socket/genyd", "/dev/socket/baseband_genyd"};
    public static final String[] known_qemu_drivers = {"goldfish"};

    /* loaded from: classes7.dex */
    public static class Property {
        public String name;
        public String seek_value;

        public Property(String str, String str2) {
            this.name = str;
            this.seek_value = str2;
        }
    }

    /* loaded from: classes7.dex */
    public static class tcp {
        public int id;
        public long localIp;
        public int localPort;
        public int remoteIp;
        public int remotePort;

        public tcp(String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, String str9, String str10, String str11, String str12, String str13, String str14) {
            this.id = Integer.parseInt(str, 16);
            this.localIp = Long.parseLong(str2, 16);
            this.localPort = Integer.parseInt(str3, 16);
        }

        public static tcp create(String[] strArr) {
            return new tcp(strArr[1], strArr[2], strArr[3], strArr[4], strArr[5], strArr[6], strArr[7], strArr[8], strArr[9], strArr[10], strArr[11], strArr[12], strArr[13], strArr[14]);
        }
    }

    public static int checkEmu(Context context) {
        init(context);
        return emurs;
    }

    public static int checkEmulator(Context context) {
        try {
            return (hasEmulatorBuild(context) ? 8 : 0) | (hasKnownDeviceId(context) ? 1 : 0) | (hasKnownImsi(context) ? 4 : 0) | (hasGenyFiles() ? 16 : 0) | (hasPipes() ? 32 : 0) | (hasQEmuFiles() ? 64 : 0) | (hasQEmuDrivers() ? 128 : 0) | (hasAdbInEmulator() ? 256 : 0);
        } catch (Throwable unused) {
            return 0;
        }
    }

    public static String getProp(Context context, String str) {
        ClassLoader classLoader;
        Class<?> loadClass;
        Method method;
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

    /* JADX WARN: Code restructure failed: missing block: B:30:0x0079, code lost:
        if (r2 == null) goto L35;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static boolean hasAdbInEmulator() throws IOException {
        BufferedReader bufferedReader;
        Throwable th;
        int i2;
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

    @SuppressLint({"NewApi"})
    public static boolean hasEmulatorBuild(Context context) {
        String str = Build.BRAND;
        String str2 = Build.DEVICE;
        String str3 = Build.MODEL;
        String str4 = Build.PRODUCT;
        if (str.compareTo("generic") == 0 || str2.compareTo("generic") == 0 || str3.compareTo("sdk") == 0 || str4.compareTo("sdk") == 0) {
            return true;
        }
        return Build.VERSION.SDK_INT >= 8 && Build.HARDWARE.compareTo("goldfish") == 0;
    }

    public static boolean hasGenyFiles() {
        for (String str : known_geny_files) {
            if (new File(str).exists()) {
                return true;
            }
        }
        return false;
    }

    public static boolean hasKnownDeviceId(Context context) {
        if (HiidoSDK.instance().isUserAgreed() && ArdUtil.checkPermissions(context, "android.permission.READ_PHONE_STATE")) {
            String deviceId = ((TelephonyManager) context.getSystemService("phone")).getDeviceId();
            for (String str : known_device_ids) {
                if (str.equalsIgnoreCase(deviceId)) {
                    return true;
                }
            }
        }
        return false;
    }

    public static boolean hasKnownImsi(Context context) {
        if (HiidoSDK.instance().isUserAgreed() && ArdUtil.checkPermissions(context, "android.permission.READ_PHONE_STATE")) {
            String subscriberId = ((TelephonyManager) context.getSystemService("phone")).getSubscriberId();
            for (String str : known_imsi_ids) {
                if (str.equalsIgnoreCase(subscriberId)) {
                    return true;
                }
            }
        }
        return false;
    }

    public static boolean hasPipes() {
        for (String str : known_pipes) {
            if (new File(str).exists()) {
                return true;
            }
        }
        return false;
    }

    /* JADX WARN: Removed duplicated region for block: B:24:0x0055  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static boolean hasQEmuDrivers() {
        File[] fileArr = {new File("/proc/tty/drivers"), new File("/proc/cpuinfo")};
        for (int i2 = 0; i2 < 2; i2++) {
            File file = fileArr[i2];
            if (file.exists() && file.canRead()) {
                byte[] bArr = new byte[1024];
                FileInputStream fileInputStream = null;
                try {
                    FileInputStream fileInputStream2 = new FileInputStream(file);
                    try {
                        fileInputStream2.read(bArr);
                        try {
                            fileInputStream2.close();
                        } catch (IOException e2) {
                            e2.printStackTrace();
                        }
                    } catch (Throwable th) {
                        th = th;
                        fileInputStream = fileInputStream2;
                        try {
                            th.printStackTrace();
                            if (fileInputStream != null) {
                                fileInputStream.close();
                            }
                            String str = new String(bArr);
                            while (r8 < r7) {
                            }
                            continue;
                        } catch (Throwable th2) {
                            if (fileInputStream != null) {
                                try {
                                    fileInputStream.close();
                                } catch (IOException e3) {
                                    e3.printStackTrace();
                                }
                            }
                            throw th2;
                        }
                    }
                } catch (Throwable th3) {
                    th = th3;
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

    public static boolean hasQEmuFiles() {
        for (String str : known_files) {
            if (new File(str).exists()) {
                return true;
            }
        }
        return false;
    }

    public static void init(Context context) {
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

    public static boolean isEmulator(Context context) {
        init(context);
        return isEmulator;
    }

    public static boolean isOperatorNameAndroid(Context context) {
        return ((TelephonyManager) context.getSystemService("phone")).getNetworkOperatorName().equalsIgnoreCase("android");
    }
}
