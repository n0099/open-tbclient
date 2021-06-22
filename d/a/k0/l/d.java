package d.a.k0.l;

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
import com.baidu.mobads.container.adrequest.IAdRequestParam;
import com.baidu.mobstat.Config;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.LineNumberReader;
import java.io.Reader;
import java.net.InetAddress;
import java.net.NetworkInterface;
import java.util.Enumeration;
/* loaded from: classes2.dex */
public final class d {

    /* renamed from: a  reason: collision with root package name */
    public static String f44294a = "";

    /* renamed from: b  reason: collision with root package name */
    public static String f44295b = "";

    /* renamed from: c  reason: collision with root package name */
    public static String f44296c = "";

    /* renamed from: d  reason: collision with root package name */
    public static String f44297d = "";

    public static String a(Context context) {
        try {
        } catch (Throwable th) {
            c.d(th);
        }
        if (!d.a.k0.b.a.h(context).e()) {
            return f44296c;
        }
        if (!TextUtils.isEmpty(f44296c)) {
            return f44296c;
        }
        if (c.o(context)) {
            String string = Settings.Secure.getString(context.getContentResolver(), IAdRequestParam.ANDROID_ID);
            f44296c = string;
            if (TextUtils.isEmpty(string)) {
                f44296c = "";
            }
            return f44296c;
        }
        return "";
    }

    public static String b(Context context, boolean z, boolean z2) {
        String str;
        try {
            if (!d.a.k0.b.a.h(context).e()) {
                return k.c(String.valueOf(-1000), z2);
            }
            if (z && !TextUtils.isEmpty(f44297d)) {
                return f44297d;
            }
            if (context.checkPermission("android.permission.READ_PHONE_STATE", Process.myPid(), Process.myUid()) == -1) {
                return k.c(String.valueOf(-1001), z2);
            }
            if (!c.o(context)) {
                return k.c(String.valueOf(-1002), z2);
            }
            int i2 = Build.VERSION.SDK_INT;
            TelephonyManager telephonyManager = (TelephonyManager) context.getSystemService("phone");
            if (i2 <= 25) {
                str = "";
            } else if (k(context) > 1) {
                str = telephonyManager.getMeid(0);
            } else {
                str = telephonyManager.getMeid();
            }
            if (TextUtils.isEmpty(str)) {
                return k.c(String.valueOf(-1003), z2);
            }
            f44297d = str;
            return str;
        } catch (Throwable th) {
            c.d(th);
            return k.c(String.valueOf(-1001), z2);
        }
    }

    public static String c(Reader reader) {
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

    public static InetAddress d() {
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

    public static String e() {
        try {
            InetAddress d2 = d();
            if (d2 != null) {
                byte[] hardwareAddress = NetworkInterface.getByInetAddress(d2).getHardwareAddress();
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
            c.d(th);
        }
        return null;
    }

    public static String f(Context context) {
        try {
        } catch (Throwable th) {
            c.d(th);
        }
        if (!TextUtils.isEmpty(f44294a)) {
            return f44294a;
        }
        f44294a = d.a.k0.b.a.h(context).J();
        return f44294a;
    }

    public static String g() {
        FileReader fileReader;
        try {
            fileReader = new FileReader("/sys/class/net/eth0/address");
            try {
                String c2 = c(fileReader);
                try {
                    fileReader.close();
                    return c2;
                } catch (Throwable th) {
                    c.d(th);
                    return c2;
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

    public static String h(Context context) {
        WifiInfo connectionInfo;
        try {
        } catch (Throwable th) {
            c.d(th);
        }
        if (d.a.k0.b.a.h(context).e()) {
            if (!TextUtils.isEmpty(f44295b)) {
                return f44295b;
            }
            if (context.checkPermission("android.permission.ACCESS_WIFI_STATE", Process.myPid(), Process.myUid()) == -1) {
                return f44295b;
            }
            if (c.o(context)) {
                WifiManager wifiManager = (WifiManager) context.getApplicationContext().getSystemService("wifi");
                if (wifiManager != null && (connectionInfo = wifiManager.getConnectionInfo()) != null) {
                    f44295b = connectionInfo.getMacAddress();
                }
                if (!TextUtils.isEmpty(f44295b) && !f44295b.equals(Config.DEF_MAC_ID)) {
                    return f44295b;
                }
                if (l()) {
                    f44295b = e();
                }
                if (TextUtils.isEmpty(f44295b)) {
                    f44295b = i();
                }
                if (TextUtils.isEmpty(f44295b)) {
                    f44295b = g().toUpperCase().substring(0, 17);
                }
                if (TextUtils.isEmpty(f44295b)) {
                    f44295b = e();
                }
                return f44295b;
            }
            return "";
        }
        return "";
    }

    public static String i() {
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

    public static String j(Context context) {
        try {
            d.a.k0.b.d dVar = new d.a.k0.b.d(context);
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

    public static int k(Context context) {
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

    public static boolean l() {
        try {
            return Build.VERSION.SDK_INT >= 26;
        } catch (Throwable th) {
            c.d(th);
            return false;
        }
    }
}
