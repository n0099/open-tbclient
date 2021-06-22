package d.o.a.e.a.h;

import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.pm.PackageManager;
import android.os.Process;
import android.telephony.TelephonyManager;
import androidx.annotation.NonNull;
import androidx.annotation.WorkerThread;
import d.o.a.e.b.l.e;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.net.InetAddress;
import java.net.Socket;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
/* loaded from: classes7.dex */
public class d {

    /* renamed from: a  reason: collision with root package name */
    public static Boolean f71007a;

    public static String a(@NonNull String str) {
        return e.i(str);
    }

    @WorkerThread
    public static synchronized void b(@NonNull Context context) {
        synchronized (d.class) {
            if (f71007a == null) {
                f71007a = Boolean.valueOf((d() || e(context) || g(context) || !i(context) || f() || k(context)) ? false : true);
            }
        }
    }

    public static boolean c() {
        Boolean bool = f71007a;
        if (bool == null) {
            return true;
        }
        return bool.booleanValue();
    }

    public static boolean d() {
        if (h() == 0) {
            return true;
        }
        return j();
    }

    public static boolean e(Context context) {
        try {
            return (context.getApplicationInfo().flags & 2) != 0;
        } catch (Exception unused) {
            return false;
        }
    }

    @WorkerThread
    public static boolean f() {
        try {
            InetAddress.getByName("127.0.0.1");
            new Socket("127.0.0.1", Integer.parseInt(a("3237303432")));
            return true;
        } catch (IOException unused) {
            return false;
        }
    }

    public static boolean g(Context context) {
        Intent registerReceiver = context.registerReceiver(null, new IntentFilter("android.intent.action.BATTERY_CHANGED"));
        return registerReceiver != null && registerReceiver.getIntExtra("plugged", -1) == 2;
    }

    public static int h() {
        String str = null;
        try {
            Object invoke = Class.forName("android.os.SystemProperties").getMethod("get", String.class).invoke(null, a("726f2e736563757265"));
            if (invoke != null) {
                str = (String) invoke;
            }
        } catch (Exception unused) {
        }
        return (str != null && "0".equals(str)) ? 0 : 1;
    }

    public static boolean i(Context context) {
        int simState = ((TelephonyManager) context.getSystemService("phone")).getSimState();
        return (simState == 1 || simState == 0) ? false : true;
    }

    public static boolean j() {
        String[] strArr = {a("2f7362696e2f7375"), a("2f73797374656d2f62696e2f7375"), a("2f73797374656d2f7862696e2f7375"), a("2f646174612f6c6f63616c2f7862696e2f7375"), a("2f646174612f6c6f63616c2f62696e2f7375"), a("2f73797374656d2f73642f7862696e2f7375"), a("2f73797374656d2f62696e2f6661696c736166652f7375"), a("2f646174612f6c6f63616c2f7375")};
        for (int i2 = 0; i2 < 8; i2++) {
            if (new File(strArr[i2]).exists()) {
                return true;
            }
        }
        return false;
    }

    @WorkerThread
    public static boolean k(Context context) {
        return l() || m(context);
    }

    /* JADX WARN: Removed duplicated region for block: B:13:0x005c A[Catch: Exception -> 0x0089, TryCatch #0 {Exception -> 0x0089, blocks: (B:2:0x0000, B:3:0x0029, B:5:0x0030, B:7:0x0038, B:9:0x0040, B:10:0x004f, B:11:0x0056, B:13:0x005c, B:16:0x006f, B:19:0x007c), top: B:25:0x0000 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static boolean l() {
        try {
            HashSet<String> hashSet = new HashSet();
            BufferedReader bufferedReader = new BufferedReader(new FileReader("/proc/" + Process.myPid() + "/maps"));
            while (true) {
                String readLine = bufferedReader.readLine();
                if (readLine == null) {
                    break;
                } else if (readLine.endsWith(".so") || readLine.endsWith(".jar")) {
                    hashSet.add(readLine.substring(readLine.lastIndexOf(" ") + 1));
                }
            }
            bufferedReader.close();
            for (String str : hashSet) {
                if (str.contains(a("636f6d2e73617572696b2e737562737472617465")) || str.contains(a("58706f7365644272696467652e6a6172")) || str.contains(a("6c696273616e64686f6f6b2e656478702e736f"))) {
                    return true;
                }
                while (r0.hasNext()) {
                }
            }
            return false;
        } catch (Exception unused) {
            return false;
        }
    }

    public static boolean m(Context context) {
        List<String> asList = Arrays.asList(a("64652e726f62762e616e64726f69642e78706f736564"), a("636f6d2e746f706a6f686e77752e6d616769736b"), a("696f2e76612e6578706f736564"), a("636f6d2e77696e642e636f74746572"), a("6f72672e6d656f776361742e656478706f7365642e6d616e61676572"), a("6d652e7765697368752e657870"), a("636f6d2e73617572696b2e737562737472617465"));
        PackageManager packageManager = context.getPackageManager();
        for (String str : asList) {
            try {
            } catch (PackageManager.NameNotFoundException e2) {
                e2.printStackTrace();
            }
            if (packageManager.getPackageInfo(str, 0) != null) {
                return true;
            }
        }
        return false;
    }
}
