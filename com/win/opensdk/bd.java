package com.win.opensdk;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Build;
import android.provider.Settings;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import com.baidu.live.tbadk.pagestayduration.PageStayDurationHelper;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.InetAddress;
import java.net.NetworkInterface;
import java.net.SocketException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Enumeration;
import java.util.List;
/* loaded from: classes4.dex */
public final class bd {
    public static int iS(Context context) {
        return context.getResources().getDisplayMetrics().widthPixels;
    }

    public static int iT(Context context) {
        return context.getResources().getDisplayMetrics().heightPixels;
    }

    public static String iR(Context context) {
        try {
            return Settings.Secure.getString(context.getContentResolver(), "android_id");
        } catch (Exception e) {
            return "NO";
        }
    }

    public static int a(Context context) {
        try {
            return context.getPackageManager().getPackageInfo(context.getPackageName(), 0).versionCode;
        } catch (Exception e) {
            return -1;
        }
    }

    public static String iQ(Context context) {
        String str = "";
        try {
            str = context.getPackageManager().getPackageInfo(context.getPackageName(), 0).versionName;
            if (str != null) {
                if (str.length() > 0) {
                    return str;
                }
            }
            return "";
        } catch (Exception e) {
            return str;
        }
    }

    /* renamed from: a  reason: collision with other method in class */
    public static String m74a(Context context) {
        try {
            return ((TelephonyManager) context.getSystemService("phone")).getNetworkOperator();
        } catch (Exception e) {
            return "";
        }
    }

    public static String b(Context context) {
        try {
            NetworkInfo activeNetworkInfo = ((ConnectivityManager) context.getSystemService("connectivity")).getActiveNetworkInfo();
            if (activeNetworkInfo != null && activeNetworkInfo.isConnected()) {
                if (activeNetworkInfo.getType() == 1) {
                    return "WIFI";
                }
                if (activeNetworkInfo.getType() == 0) {
                    String subtypeName = activeNetworkInfo.getSubtypeName();
                    switch (activeNetworkInfo.getSubtype()) {
                        case 1:
                        case 2:
                        case 4:
                        case 7:
                        case 11:
                            return "2G";
                        case 3:
                        case 5:
                        case 6:
                        case 8:
                        case 9:
                        case 10:
                        case 12:
                        case 14:
                        case 15:
                            return "3G";
                        case 13:
                            return "4G";
                        default:
                            if (!subtypeName.equalsIgnoreCase("TD-SCDMA") && !subtypeName.equalsIgnoreCase("WCDMA")) {
                                if (!subtypeName.equalsIgnoreCase("CDMA2000")) {
                                    return subtypeName;
                                }
                            }
                            return "3G";
                    }
                }
            }
        } catch (Exception e) {
        }
        return "";
    }

    public static String c(Context context) {
        String deviceId;
        String m73e = az.m73e(context);
        try {
            if (TextUtils.isEmpty(m73e)) {
                String str = "";
                TelephonyManager telephonyManager = (TelephonyManager) context.getSystemService("phone");
                if (Build.VERSION.SDK_INT >= 23) {
                    if (context.checkSelfPermission("android.permission.READ_PHONE_STATE") != 0) {
                        deviceId = "";
                    } else {
                        String deviceId2 = telephonyManager.getDeviceId(1);
                        str = telephonyManager.getDeviceId(2);
                        deviceId = deviceId2;
                    }
                } else {
                    deviceId = telephonyManager.getDeviceId();
                }
                try {
                    if (TextUtils.isEmpty(str)) {
                        az.e(context, deviceId);
                    } else {
                        deviceId = deviceId + PageStayDurationHelper.STAT_SOURCE_TRACE_CONNECTORS + str;
                        az.e(context, deviceId);
                    }
                    return deviceId;
                } catch (Exception e) {
                    return deviceId;
                }
            }
            return m73e;
        } catch (Exception e2) {
            return m73e;
        }
    }

    /*  JADX ERROR: JadxRuntimeException in pass: BlockProcessor
        jadx.core.utils.exceptions.JadxRuntimeException: Unreachable block: B:10:0x001c
        	at jadx.core.dex.visitors.blocks.BlockProcessor.checkForUnreachableBlocks(BlockProcessor.java:81)
        	at jadx.core.dex.visitors.blocks.BlockProcessor.processBlocksTree(BlockProcessor.java:47)
        	at jadx.core.dex.visitors.blocks.BlockProcessor.visit(BlockProcessor.java:39)
        */
    public static java.lang.String d(android.content.Context r3) {
        /*
            java.lang.String r2 = ""
            java.lang.String r0 = "phone"
            java.lang.Object r0 = r3.getSystemService(r0)     // Catch: java.lang.Exception -> L16
            android.telephony.TelephonyManager r0 = (android.telephony.TelephonyManager) r0     // Catch: java.lang.Exception -> L16
            java.lang.String r0 = r0.getSubscriberId()     // Catch: java.lang.Exception -> L16
            if (r0 != 0) goto L15
            java.lang.String r0 = ""
        L15:
            return r0
        L16:
            r1 = move-exception
            r0 = r2
        L18:
            r1.printStackTrace()
            goto L15
        L1c:
            r1 = move-exception
            goto L18
        */
        throw new UnsupportedOperationException("Method not decompiled: com.win.opensdk.bd.d(android.content.Context):java.lang.String");
    }

    public static String java() {
        try {
            String str = Build.SERIAL;
            if (TextUtils.equals(str, "unknown") && Build.VERSION.SDK_INT >= 26) {
                return Build.getSerial();
            }
            return str;
        } catch (Exception e) {
            e.printStackTrace();
            return "";
        }
    }

    public static String eKw() {
        try {
            byte[] hardwareAddress = NetworkInterface.getByInetAddress(eKK()).getHardwareAddress();
            StringBuffer stringBuffer = new StringBuffer();
            for (int i = 0; i < hardwareAddress.length; i++) {
                if (i != 0) {
                    stringBuffer.append(':');
                }
                String hexString = Integer.toHexString(hardwareAddress[i] & 255);
                if (hexString.length() == 1) {
                    hexString = "0".concat(String.valueOf(hexString));
                }
                stringBuffer.append(hexString);
            }
            return stringBuffer.toString().toUpperCase();
        } catch (Exception e) {
            return null;
        }
    }

    private static InetAddress eKK() {
        SocketException e;
        InetAddress inetAddress;
        try {
            Enumeration<NetworkInterface> networkInterfaces = NetworkInterface.getNetworkInterfaces();
            InetAddress inetAddress2 = null;
            while (networkInterfaces.hasMoreElements()) {
                try {
                    Enumeration<InetAddress> inetAddresses = networkInterfaces.nextElement().getInetAddresses();
                    InetAddress inetAddress3 = inetAddress2;
                    while (true) {
                        try {
                            if (!inetAddresses.hasMoreElements()) {
                                inetAddress = inetAddress3;
                                break;
                            }
                            inetAddress = inetAddresses.nextElement();
                            try {
                                if (!inetAddress.isLoopbackAddress() && !inetAddress.getHostAddress().contains(":")) {
                                    break;
                                }
                                inetAddress3 = null;
                            } catch (SocketException e2) {
                                e = e2;
                                e.printStackTrace();
                                return inetAddress;
                            }
                        } catch (SocketException e3) {
                            e = e3;
                            inetAddress = inetAddress3;
                        }
                    }
                    if (inetAddress != null) {
                        return inetAddress;
                    }
                    inetAddress2 = inetAddress;
                } catch (SocketException e4) {
                    e = e4;
                    inetAddress = inetAddress2;
                }
            }
            return inetAddress2;
        } catch (SocketException e5) {
            e = e5;
            inetAddress = null;
        }
    }

    public static String[] iX(Context context) {
        String str = "";
        String str2 = "";
        String str3 = "";
        try {
            PackageInfo packageInfo = context.getPackageManager().getPackageInfo(context.getPackageName(), 0);
            ApplicationInfo applicationInfo = packageInfo.applicationInfo;
            str3 = applicationInfo.publicSourceDir != null ? applicationInfo.publicSourceDir : applicationInfo.sourceDir;
            str = String.valueOf(packageInfo.firstInstallTime);
            str2 = String.valueOf(packageInfo.lastUpdateTime);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return new String[]{str, str2, str3};
    }

    public static String a() {
        String[] strArr = new String[0];
        try {
            if (Build.VERSION.SDK_INT >= 21) {
                strArr = Build.SUPPORTED_ABIS;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return Arrays.toString(strArr);
    }

    public static List<String> eKL() {
        ArrayList arrayList = new ArrayList();
        try {
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(Runtime.getRuntime().exec("pm list package -3").getInputStream()));
            while (true) {
                String readLine = bufferedReader.readLine();
                if (readLine == null) {
                    break;
                }
                arrayList.add(readLine.replace("package:", ""));
            }
        } catch (IOException e) {
        }
        return arrayList;
    }
}
