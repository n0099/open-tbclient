package d.b.f0.l;

import android.content.Context;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import android.os.Build;
import android.os.Process;
import android.provider.Settings;
import android.telephony.SubscriptionManager;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import android.util.Base64;
import com.baidu.mobstat.Config;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.LineNumberReader;
import java.io.Reader;
import java.net.InetAddress;
import java.net.NetworkInterface;
import java.util.Enumeration;
/* loaded from: classes3.dex */
public final class d {

    /* renamed from: a  reason: collision with root package name */
    public static String f43022a = "";

    /* renamed from: b  reason: collision with root package name */
    public static String f43023b = "";

    /* renamed from: c  reason: collision with root package name */
    public static String f43024c = "";

    /* renamed from: d  reason: collision with root package name */
    public static String f43025d = "";

    /* renamed from: e  reason: collision with root package name */
    public static String f43026e = "";

    public static String a(Context context) {
        try {
        } catch (Throwable th) {
            c.d(th);
        }
        if (!d.b.f0.b.a.g(context).d()) {
            return f43025d;
        }
        if (!TextUtils.isEmpty(f43025d)) {
            return f43025d;
        }
        if (c.o(context)) {
            String string = Settings.Secure.getString(context.getContentResolver(), "android_id");
            f43025d = string;
            if (TextUtils.isEmpty(string)) {
                f43025d = "";
            }
            return f43025d;
        }
        return "";
    }

    public static String b(Reader reader) {
        try {
            StringBuilder sb = new StringBuilder();
            char[] cArr = new char[4096];
            int read = reader.read(cArr);
            while (read >= 0) {
                sb.append(cArr, 0, read);
                read = reader.read(cArr);
            }
            return sb.toString();
        } catch (Throwable th) {
            c.d(th);
            return null;
        }
    }

    public static InetAddress c() {
        InetAddress inetAddress;
        Throwable th;
        InetAddress inetAddress2 = null;
        try {
            Enumeration<NetworkInterface> networkInterfaces = NetworkInterface.getNetworkInterfaces();
            inetAddress = null;
            do {
                try {
                    if (!networkInterfaces.hasMoreElements()) {
                        break;
                    }
                    Enumeration<InetAddress> inetAddresses = networkInterfaces.nextElement().getInetAddresses();
                    while (true) {
                        if (inetAddresses.hasMoreElements()) {
                            InetAddress nextElement = inetAddresses.nextElement();
                            try {
                                if (!nextElement.isLoopbackAddress() && nextElement.getHostAddress().indexOf(":") == -1) {
                                    inetAddress = nextElement;
                                    continue;
                                    break;
                                }
                                inetAddress = null;
                            } catch (Throwable th2) {
                                th = th2;
                                inetAddress = nextElement;
                                c.d(th);
                                return inetAddress;
                            }
                        }
                    }
                } catch (Throwable th3) {
                    th = th3;
                    inetAddress2 = inetAddress;
                    inetAddress = inetAddress2;
                    th = th;
                    c.d(th);
                    return inetAddress;
                }
            } while (inetAddress == null);
        } catch (Throwable th4) {
            th = th4;
        }
        return inetAddress;
    }

    public static String d() {
        try {
            InetAddress c2 = c();
            if (c2 != null) {
                byte[] hardwareAddress = NetworkInterface.getByInetAddress(c2).getHardwareAddress();
                StringBuffer stringBuffer = new StringBuffer();
                for (int i = 0; i < hardwareAddress.length; i++) {
                    if (i != 0) {
                        stringBuffer.append(':');
                    }
                    String hexString = Integer.toHexString(hardwareAddress[i] & 255);
                    if (hexString.length() == 1) {
                        hexString = 0 + hexString;
                    }
                    stringBuffer.append(hexString);
                }
                return stringBuffer.toString();
            }
        } catch (Throwable th) {
            c.d(th);
        }
        return null;
    }

    public static String e(Context context) {
        try {
        } catch (Throwable th) {
            c.d(th);
        }
        if (!TextUtils.isEmpty(f43022a)) {
            return f43022a;
        }
        f43022a = d.b.f0.b.a.g(context).H();
        return f43022a;
    }

    public static String f() {
        FileReader fileReader;
        try {
            fileReader = new FileReader("/sys/class/net/eth0/address");
            try {
                String b2 = b(fileReader);
                try {
                    fileReader.close();
                    return b2;
                } catch (Throwable th) {
                    c.d(th);
                    return b2;
                }
            } catch (Throwable th2) {
                th = th2;
                try {
                    c.d(th);
                    return "";
                } finally {
                    if (fileReader != null) {
                        try {
                            fileReader.close();
                        } catch (Throwable th3) {
                            c.d(th3);
                        }
                    }
                }
            }
        } catch (Throwable th4) {
            th = th4;
            fileReader = null;
        }
    }

    public static synchronized String g(Context context) {
        synchronized (d.class) {
            if (d.b.f0.b.a.g(context).d()) {
                if (!TextUtils.isEmpty(f43023b)) {
                    return f43023b;
                } else if (c.o(context)) {
                    if (context.checkPermission("android.permission.READ_PHONE_STATE", Process.myPid(), Process.myUid()) == -1) {
                        return f43023b;
                    }
                    TelephonyManager telephonyManager = (TelephonyManager) context.getSystemService("phone");
                    if (telephonyManager != null) {
                        String deviceId = telephonyManager.getDeviceId();
                        f43023b = deviceId;
                        if (TextUtils.isEmpty(deviceId)) {
                            f43023b = "";
                        }
                    }
                    return f43023b;
                } else {
                    return "";
                }
            }
            return "";
        }
    }

    public static String h() {
        InputStreamReader inputStreamReader;
        Throwable th;
        LineNumberReader lineNumberReader;
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
                            c.d(th);
                            return str;
                        } finally {
                            if (inputStreamReader != null) {
                                try {
                                    inputStreamReader.close();
                                } catch (Throwable th3) {
                                    c.d(th3);
                                }
                            }
                            if (lineNumberReader != null) {
                                try {
                                    lineNumberReader.close();
                                } catch (IOException e2) {
                                    c.d(e2);
                                }
                            }
                        }
                    }
                }
                try {
                    inputStreamReader.close();
                } catch (Throwable th4) {
                    c.d(th4);
                }
                try {
                    lineNumberReader.close();
                } catch (IOException e3) {
                    c.d(e3);
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

    public static String i(Context context) {
        try {
        } catch (Throwable th) {
            c.d(th);
        }
        if (d.b.f0.b.a.g(context).d()) {
            if (!TextUtils.isEmpty(f43026e)) {
                return f43026e;
            }
            if (context.checkPermission("android.permission.READ_PHONE_STATE", Process.myPid(), Process.myUid()) != -1 && c.o(context)) {
                if (Build.VERSION.SDK_INT > 25) {
                    if (n(context) > 1) {
                        f43026e = m(context)[0];
                    } else {
                        f43026e = o(context);
                    }
                }
                if (f43026e == null) {
                    return "";
                }
                return f43026e;
            }
            return "";
        }
        return "";
    }

    public static String j(Context context) {
        WifiInfo connectionInfo;
        try {
        } catch (Throwable th) {
            c.d(th);
        }
        if (d.b.f0.b.a.g(context).d()) {
            if (!TextUtils.isEmpty(f43024c)) {
                return f43024c;
            }
            if (context.checkPermission("android.permission.ACCESS_WIFI_STATE", Process.myPid(), Process.myUid()) == -1) {
                return f43024c;
            }
            if (c.o(context)) {
                WifiManager wifiManager = (WifiManager) context.getApplicationContext().getSystemService("wifi");
                if (wifiManager != null && (connectionInfo = wifiManager.getConnectionInfo()) != null) {
                    f43024c = connectionInfo.getMacAddress();
                }
                if (!TextUtils.isEmpty(f43024c) && !f43024c.equals(Config.DEF_MAC_ID)) {
                    return f43024c;
                }
                if (k()) {
                    f43024c = d();
                }
                if (TextUtils.isEmpty(f43024c)) {
                    f43024c = h();
                }
                if (TextUtils.isEmpty(f43024c)) {
                    f43024c = f().toUpperCase().substring(0, 17);
                }
                if (TextUtils.isEmpty(f43024c)) {
                    f43024c = d();
                }
                return f43024c;
            }
            return "";
        }
        return "";
    }

    public static boolean k() {
        try {
            return Build.VERSION.SDK_INT >= 26;
        } catch (Throwable th) {
            c.d(th);
            return false;
        }
    }

    public static String l(Context context) {
        try {
            d.b.f0.b.d dVar = new d.b.f0.b.d(context);
            String c2 = dVar.c();
            if (!TextUtils.isEmpty(c2)) {
                return new String(a.b("30212102dicudiab".getBytes(), Base64.decode(c2, 10), true), "UTF-8");
            }
            String a2 = dVar.a();
            if (TextUtils.isEmpty(a2)) {
                return "";
            }
            dVar.b(new String(Base64.encode(a.a("30212102dicudiab".getBytes(), a2.getBytes("UTF-8")), 10), "UTF-8"));
            return a2;
        } catch (Throwable th) {
            c.d(th);
            return "";
        }
    }

    public static String[] m(Context context) {
        String[] strArr = new String[2];
        try {
            TelephonyManager telephonyManager = (TelephonyManager) context.getSystemService("phone");
            if (context.checkPermission("android.permission.READ_PHONE_STATE", Process.myPid(), Process.myUid()) == -1) {
                return strArr;
            }
            strArr[0] = telephonyManager.getMeid(0);
            strArr[1] = telephonyManager.getMeid(1);
            return strArr;
        } catch (Throwable th) {
            c.d(th);
            return strArr;
        }
    }

    public static int n(Context context) {
        int activeSubscriptionInfoCount;
        try {
            if (Build.VERSION.SDK_INT >= 23) {
                activeSubscriptionInfoCount = ((TelephonyManager) context.getSystemService("phone")).getPhoneCount();
            } else {
                activeSubscriptionInfoCount = Build.VERSION.SDK_INT >= 22 ? SubscriptionManager.from(context).getActiveSubscriptionInfoCount() : 1;
            }
            if (activeSubscriptionInfoCount == 0) {
                return 1;
            }
            return activeSubscriptionInfoCount;
        } catch (Throwable th) {
            c.d(th);
            return 1;
        }
    }

    public static String o(Context context) {
        try {
            return ((TelephonyManager) context.getSystemService("phone")).getMeid();
        } catch (Throwable th) {
            c.d(th);
            return "";
        }
    }
}
