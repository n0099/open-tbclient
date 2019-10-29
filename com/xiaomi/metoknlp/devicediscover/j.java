package com.xiaomi.metoknlp.devicediscover;

import android.content.Context;
import android.content.SharedPreferences;
import android.net.DhcpInfo;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import com.baidu.mobstat.Config;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.net.InetAddress;
import java.net.UnknownHostException;
/* loaded from: classes3.dex */
class j {
    public static DhcpInfo a(Context context) {
        WifiManager wifiManager;
        DhcpInfo dhcpInfo;
        if (context == null || (wifiManager = (WifiManager) context.getSystemService("wifi")) == null || !wifiManager.isWifiEnabled()) {
            return null;
        }
        try {
            dhcpInfo = context.getPackageManager().checkPermission("android.permission.ACCESS_WIFI_STATE", context.getPackageName()) == 0 ? wifiManager.getDhcpInfo() : null;
        } catch (Exception e) {
            dhcpInfo = null;
        }
        return dhcpInfo;
    }

    public static String a(Context context, int i) {
        WifiInfo wifiInfo;
        String str = null;
        try {
            WifiManager wifiManager = (WifiManager) context.getSystemService("wifi");
            if (wifiManager != null && wifiManager.isWifiEnabled()) {
                try {
                    wifiInfo = context.getPackageManager().checkPermission("android.permission.ACCESS_WIFI_STATE", context.getPackageName()) == 0 ? wifiManager.getConnectionInfo() : null;
                } catch (Exception e) {
                    wifiInfo = null;
                }
                if (wifiInfo != null) {
                    if (i == 0) {
                        str = wifiInfo.getMacAddress();
                    } else if (i == 1) {
                        str = wifiInfo.getBSSID();
                    } else if (i == 2) {
                        str = a(wifiInfo.getSSID());
                    }
                }
            }
        } catch (Exception e2) {
        }
        return str;
    }

    private static String a(String str) {
        return (str.startsWith("\"") && str.endsWith("\"")) ? str.substring(1, str.length() - 1) : str;
    }

    public static InetAddress a(int i) {
        try {
            return InetAddress.getByAddress(new byte[]{(byte) (i & 255), (byte) ((i >> 8) & 255), (byte) ((i >> 16) & 255), (byte) ((i >> 24) & 255)});
        } catch (UnknownHostException e) {
            throw new AssertionError();
        }
    }

    public static void a(Context context, String str, String str2) {
        SharedPreferences.Editor edit = context.getSharedPreferences("devicediscover", 0).edit();
        edit.putString(str, str2);
        edit.commit();
    }

    public static String b(Context context) {
        try {
            DhcpInfo a = a(context);
            if (a == null) {
                return null;
            }
            return a(a.gateway).getHostAddress();
        } catch (Exception e) {
            return null;
        }
    }

    public static String b(Context context, String str, String str2) {
        return context.getSharedPreferences("devicediscover", 0).getString(str, str2);
    }

    public static String c(Context context) {
        try {
            DhcpInfo a = a(context);
            if (a == null) {
                return null;
            }
            return a(a.serverAddress).getHostAddress();
        } catch (Exception e) {
            return null;
        }
    }

    public static String d(Context context) {
        FileReader fileReader;
        String a = a(context, 0);
        if (a == null || a.isEmpty() || Config.DEF_MAC_ID.equals(a)) {
            try {
                char[] cArr = new char[1024];
                fileReader = new FileReader("/sys/class/net/wlan0/address");
                try {
                    a = new String(cArr, 0, fileReader.read(cArr, 0, 1024)).trim();
                    if (fileReader != null) {
                        try {
                            fileReader.close();
                        } catch (Exception e) {
                        }
                    }
                } catch (FileNotFoundException e2) {
                    if (fileReader != null) {
                        try {
                            fileReader.close();
                        } catch (Exception e3) {
                        }
                    }
                    return a;
                } catch (Exception e4) {
                    if (fileReader != null) {
                        try {
                            fileReader.close();
                        } catch (Exception e5) {
                        }
                    }
                    return a;
                } catch (Throwable th) {
                    th = th;
                    if (fileReader != null) {
                        try {
                            fileReader.close();
                        } catch (Exception e6) {
                        }
                    }
                    throw th;
                }
            } catch (FileNotFoundException e7) {
                fileReader = null;
            } catch (Exception e8) {
                fileReader = null;
            } catch (Throwable th2) {
                th = th2;
                fileReader = null;
            }
        }
        return a;
    }
}
