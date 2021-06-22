package d.b.b;

import android.app.ActivityManager;
import android.content.Context;
import android.os.Process;
import android.text.TextUtils;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Iterator;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes6.dex */
public class s0 {

    /* renamed from: a  reason: collision with root package name */
    public static String f68931a = null;

    /* renamed from: b  reason: collision with root package name */
    public static String f68932b = ":push";

    public static String a() {
        BufferedReader bufferedReader;
        try {
            bufferedReader = new BufferedReader(new InputStreamReader(new FileInputStream("/proc/" + Process.myPid() + "/cmdline"), "iso-8859-1"));
            try {
                StringBuilder sb = new StringBuilder();
                while (true) {
                    int read = bufferedReader.read();
                    if (read <= 0) {
                        break;
                    }
                    sb.append((char) read);
                }
                String sb2 = sb.toString();
                try {
                    bufferedReader.close();
                } catch (Exception unused) {
                }
                return sb2;
            } catch (Throwable unused2) {
                if (bufferedReader != null) {
                    try {
                        bufferedReader.close();
                    } catch (Exception unused3) {
                    }
                }
                return null;
            }
        } catch (Throwable unused4) {
            bufferedReader = null;
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:10:0x002d, code lost:
        d.b.b.s0.f68931a = r1.processName;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static String b(Context context) {
        String str = f68931a;
        if (TextUtils.isEmpty(str)) {
            try {
                int myPid = Process.myPid();
                Iterator<ActivityManager.RunningAppProcessInfo> it = ((ActivityManager) context.getSystemService("activity")).getRunningAppProcesses().iterator();
                while (true) {
                    if (!it.hasNext()) {
                        break;
                    }
                    ActivityManager.RunningAppProcessInfo next = it.next();
                    if (next.pid == myPid) {
                        break;
                    }
                }
            } catch (Exception e2) {
                e2.printStackTrace();
            }
            f68931a = a();
            if (r0.f68927b) {
                r0.a("getProcessName, " + f68931a, null);
            }
            return f68931a;
        }
        return str;
    }

    public static String c(String str, String str2) {
        if (str2 == null) {
            str2 = "ISO-8859-1";
        }
        try {
            return URLEncoder.encode(str, str2);
        } catch (UnsupportedEncodingException unused) {
            return "";
        }
    }

    public static String d(String str, HashMap<String, String> hashMap, String str2) {
        StringBuilder sb = new StringBuilder(str);
        for (String str3 : hashMap.keySet()) {
            String c2 = c(str3, str2);
            String str4 = hashMap.get(str3);
            String c3 = str4 != null ? c(str4, str2) : "";
            if (sb.length() > 0) {
                sb.append("&");
            }
            sb.append(c2);
            sb.append("=");
            sb.append(c3);
        }
        return sb.toString();
    }

    public static boolean e(Object obj, Object obj2) {
        return obj == obj2 || (obj != null && obj.equals(obj2));
    }

    public static boolean f(JSONObject jSONObject, JSONObject jSONObject2) {
        if (jSONObject != null && jSONObject2 != null) {
            return jSONObject.toString().equals(jSONObject2.toString());
        }
        return e(jSONObject, jSONObject2);
    }

    public static JSONObject g(JSONObject jSONObject, JSONObject jSONObject2) {
        try {
            Iterator<String> keys = jSONObject2.keys();
            while (keys.hasNext()) {
                String next = keys.next();
                jSONObject.put(next, jSONObject2.opt(next));
            }
        } catch (JSONException e2) {
            r0.b(e2);
        }
        return jSONObject;
    }

    public static boolean h(Context context) {
        String b2 = b(context);
        return b2 != null && b2.endsWith(f68932b);
    }
}
