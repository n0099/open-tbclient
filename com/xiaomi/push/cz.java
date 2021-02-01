package com.xiaomi.push;

import android.app.ActivityManager;
import android.content.Context;
import android.content.pm.PackageInfo;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.Uri;
import android.net.wifi.WifiManager;
import android.os.Process;
import android.text.TextUtils;
import com.baidu.android.imsdk.db.TableDefine;
import com.baidu.ar.gesture.GestureAR;
import com.meizu.cloud.pushsdk.constants.PushConstants;
import com.xiaomi.mipush.sdk.Constants;
import com.xiaomi.push.service.module.PushChannelRegion;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.Closeable;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.UnsupportedEncodingException;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes6.dex */
public class cz {

    /* renamed from: a  reason: collision with root package name */
    protected static Context f13929a;

    /* renamed from: a  reason: collision with other field name */
    private static a f266a;

    /* renamed from: a  reason: collision with other field name */
    private static cz f267a;
    private static String c;
    private static String d;

    /* renamed from: a  reason: collision with other field name */
    private long f269a;

    /* renamed from: a  reason: collision with other field name */
    private cy f270a;

    /* renamed from: a  reason: collision with other field name */
    protected b f271a;

    /* renamed from: a  reason: collision with other field name */
    private String f272a;

    /* renamed from: a  reason: collision with other field name */
    protected Map<String, cw> f273a;

    /* renamed from: b  reason: collision with other field name */
    private final long f274b;

    /* renamed from: b  reason: collision with other field name */
    private String f275b;

    /* renamed from: c  reason: collision with other field name */
    private long f276c;

    /* renamed from: b  reason: collision with root package name */
    protected static Map<String, cv> f13930b = new HashMap();

    /* renamed from: a  reason: collision with other field name */
    protected static boolean f268a = false;

    /* loaded from: classes6.dex */
    public interface a {
        cz a(Context context, cy cyVar, b bVar, String str);
    }

    /* loaded from: classes6.dex */
    public interface b {
        String a(String str);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public cz(Context context, cy cyVar, b bVar, String str) {
        this(context, cyVar, bVar, str, null, null);
    }

    protected cz(Context context, cy cyVar, b bVar, String str, String str2, String str3) {
        this.f273a = new HashMap();
        this.f272a = "0";
        this.f269a = 0L;
        this.f274b = 15L;
        this.f276c = 0L;
        this.f275b = "isp_prov_city_country_ip";
        this.f271a = bVar;
        if (cyVar == null) {
            this.f270a = new da(this);
        } else {
            this.f270a = cyVar;
        }
        this.f272a = str;
        c = str2 == null ? context.getPackageName() : str2;
        d = str3 == null ? f() : str3;
    }

    public static synchronized cz a() {
        cz czVar;
        synchronized (cz.class) {
            if (f267a == null) {
                throw new IllegalStateException("the host manager is not initialized yet.");
            }
            czVar = f267a;
        }
        return czVar;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:22:0x007c -> B:23:0x0007). Please submit an issue!!! */
    /* renamed from: a  reason: collision with other method in class */
    public static String m241a() {
        String str;
        ConnectivityManager connectivityManager;
        if (f13929a == null) {
            return "unknown";
        }
        try {
            connectivityManager = (ConnectivityManager) f13929a.getSystemService("connectivity");
        } catch (Throwable th) {
        }
        if (connectivityManager == null) {
            str = "unknown";
        } else {
            NetworkInfo activeNetworkInfo = connectivityManager.getActiveNetworkInfo();
            if (activeNetworkInfo == null) {
                str = "unknown";
            } else if (activeNetworkInfo.getType() == 1) {
                WifiManager wifiManager = (WifiManager) f13929a.getSystemService("wifi");
                if (wifiManager != null && wifiManager.getConnectionInfo() != null) {
                    str = "WIFI-" + wifiManager.getConnectionInfo().getSSID();
                }
                str = "unknown";
            } else {
                str = activeNetworkInfo.getTypeName() + Constants.ACCEPT_TIME_SEPARATOR_SERVER + activeNetworkInfo.getSubtypeName();
            }
        }
        return str;
    }

    static String a(String str) {
        try {
            int length = str.length();
            byte[] bytes = str.getBytes("UTF-8");
            for (int i = 0; i < bytes.length; i++) {
                byte b2 = bytes[i];
                if ((b2 & 240) != 240) {
                    bytes[i] = (byte) (((b2 & 15) ^ ((byte) (((b2 >> 4) + length) & 15))) | (b2 & 240));
                }
            }
            return new String(bytes);
        } catch (UnsupportedEncodingException e) {
            return str;
        }
    }

    private ArrayList<cv> a(ArrayList<String> arrayList) {
        m250d();
        synchronized (this.f273a) {
            m246a();
            for (String str : this.f273a.keySet()) {
                if (!arrayList.contains(str)) {
                    arrayList.add(str);
                }
            }
        }
        boolean isEmpty = f13930b.isEmpty();
        synchronized (f13930b) {
            Object[] array = f13930b.values().toArray();
            int length = array.length;
            int i = 0;
            while (i < length) {
                cv cvVar = (cv) array[i];
                if (!cvVar.b()) {
                    isEmpty = true;
                    f13930b.remove(cvVar.f263b);
                }
                i++;
                isEmpty = isEmpty;
            }
        }
        if (!arrayList.contains(b())) {
            arrayList.add(b());
        }
        ArrayList<cv> arrayList2 = new ArrayList<>(arrayList.size());
        for (int i2 = 0; i2 < arrayList.size(); i2++) {
            arrayList2.add(null);
        }
        try {
            String str2 = az.d(f13929a) ? "wifi" : "wap";
            String a2 = a(arrayList, str2, this.f272a, isEmpty);
            if (!TextUtils.isEmpty(a2)) {
                JSONObject jSONObject = new JSONObject(a2);
                com.xiaomi.channel.commonutils.logger.b.b(a2);
                if ("OK".equalsIgnoreCase(jSONObject.getString("S"))) {
                    JSONObject jSONObject2 = jSONObject.getJSONObject("R");
                    String string = jSONObject2.getString("province");
                    String string2 = jSONObject2.getString("city");
                    String string3 = jSONObject2.getString("isp");
                    String string4 = jSONObject2.getString(TableDefine.UserInfoColumns.COLUMN_IP);
                    String string5 = jSONObject2.getString("country");
                    JSONObject jSONObject3 = jSONObject2.getJSONObject(str2);
                    com.xiaomi.channel.commonutils.logger.b.c("get bucket: net=" + string3 + ", hosts=" + jSONObject3.toString());
                    for (int i3 = 0; i3 < arrayList.size(); i3++) {
                        String str3 = arrayList.get(i3);
                        JSONArray optJSONArray = jSONObject3.optJSONArray(str3);
                        if (optJSONArray == null) {
                            com.xiaomi.channel.commonutils.logger.b.m80a("no bucket found for " + str3);
                        } else {
                            cv cvVar2 = new cv(str3);
                            for (int i4 = 0; i4 < optJSONArray.length(); i4++) {
                                String string6 = optJSONArray.getString(i4);
                                if (!TextUtils.isEmpty(string6)) {
                                    cvVar2.a(new de(string6, optJSONArray.length() - i4));
                                }
                            }
                            arrayList2.set(i3, cvVar2);
                            cvVar2.g = string5;
                            cvVar2.c = string;
                            cvVar2.e = string3;
                            cvVar2.f = string4;
                            cvVar2.d = string2;
                            if (jSONObject2.has("stat-percent")) {
                                cvVar2.a(jSONObject2.getDouble("stat-percent"));
                            }
                            if (jSONObject2.has("stat-domain")) {
                                cvVar2.b(jSONObject2.getString("stat-domain"));
                            }
                            if (jSONObject2.has("ttl")) {
                                cvVar2.a(jSONObject2.getInt("ttl") * 1000);
                            }
                            m245a(cvVar2.a());
                        }
                    }
                    JSONObject optJSONObject = jSONObject2.optJSONObject(GestureAR.SDK_TO_LUA_GESTURE_RESULT_RESERVED);
                    if (optJSONObject != null) {
                        long j = jSONObject2.has("reserved-ttl") ? jSONObject2.getInt("reserved-ttl") * 1000 : 604800000L;
                        Iterator<String> keys = optJSONObject.keys();
                        while (keys.hasNext()) {
                            String next = keys.next();
                            JSONArray optJSONArray2 = optJSONObject.optJSONArray(next);
                            if (optJSONArray2 == null) {
                                com.xiaomi.channel.commonutils.logger.b.m80a("no bucket found for " + next);
                            } else {
                                cv cvVar3 = new cv(next);
                                cvVar3.a(j);
                                for (int i5 = 0; i5 < optJSONArray2.length(); i5++) {
                                    String string7 = optJSONArray2.getString(i5);
                                    if (!TextUtils.isEmpty(string7)) {
                                        cvVar3.a(new de(string7, optJSONArray2.length() - i5));
                                    }
                                }
                                synchronized (f13930b) {
                                    if (this.f270a.a(next)) {
                                        f13930b.put(next, cvVar3);
                                    }
                                }
                            }
                        }
                    }
                }
            }
        } catch (Exception e) {
            com.xiaomi.channel.commonutils.logger.b.m80a("failed to get bucket " + e.getMessage());
        }
        int i6 = 0;
        while (true) {
            int i7 = i6;
            if (i7 >= arrayList.size()) {
                m249c();
                return arrayList2;
            }
            cv cvVar4 = arrayList2.get(i7);
            if (cvVar4 != null) {
                a(arrayList.get(i7), cvVar4);
            }
            i6 = i7 + 1;
        }
    }

    public static synchronized void a(Context context, cy cyVar, b bVar, String str, String str2, String str3) {
        synchronized (cz.class) {
            f13929a = context.getApplicationContext();
            if (f13929a == null) {
                f13929a = context;
            }
            if (f267a == null) {
                if (f266a == null) {
                    f267a = new cz(context, cyVar, bVar, str, str2, str3);
                } else {
                    f267a = f266a.a(context, cyVar, bVar, str);
                }
            }
        }
    }

    public static synchronized void a(a aVar) {
        synchronized (cz.class) {
            f266a = aVar;
            f267a = null;
        }
    }

    public static void a(String str, String str2) {
        cv cvVar = f13930b.get(str);
        synchronized (f13930b) {
            if (cvVar == null) {
                cv cvVar2 = new cv(str);
                cvVar2.a(604800000L);
                cvVar2.m234a(str2);
                f13930b.put(str, cvVar2);
            } else {
                cvVar.m234a(str2);
            }
        }
    }

    private String f() {
        try {
            PackageInfo packageInfo = f13929a.getPackageManager().getPackageInfo(f13929a.getPackageName(), 16384);
            if (packageInfo != null) {
                return packageInfo.versionName;
            }
        } catch (Exception e) {
        }
        return "0";
    }

    /* renamed from: a  reason: collision with other method in class */
    public cv m242a(String str) {
        if (TextUtils.isEmpty(str)) {
            throw new IllegalArgumentException("the url is empty");
        }
        return a(new URL(str).getHost(), true);
    }

    public cv a(String str, boolean z) {
        cv d2;
        if (TextUtils.isEmpty(str)) {
            throw new IllegalArgumentException("the host is empty");
        }
        if (this.f270a.a(str)) {
            cv c2 = c(str);
            return (c2 == null || !c2.b()) ? (z && az.b(f13929a) && (d2 = d(str)) != null) ? d2 : new db(this, str, c2) : c2;
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public String a(ArrayList<String> arrayList, String str, String str2, boolean z) {
        ArrayList<String> a2;
        String str3 = null;
        ArrayList<String> arrayList2 = new ArrayList<>();
        ArrayList<ay> arrayList3 = new ArrayList();
        arrayList3.add(new aw("type", str));
        if (str.equals("wap")) {
            arrayList3.add(new aw("conpt", a(az.m166a(f13929a))));
        }
        if (z) {
            arrayList3.add(new aw(GestureAR.SDK_TO_LUA_GESTURE_RESULT_RESERVED, "1"));
        }
        arrayList3.add(new aw("uuid", str2));
        arrayList3.add(new aw("list", bf.a(arrayList, ",")));
        arrayList3.add(new aw("countrycode", com.xiaomi.push.service.a.a(f13929a).b()));
        cv c2 = c(b());
        String format = String.format(Locale.US, "http://%1$s/gslb/?ver=4.0", b());
        if (c2 == null) {
            arrayList2.add(format);
            synchronized (f13930b) {
                cv cvVar = f13930b.get("resolver.msg.xiaomi.net");
                if (cvVar != null) {
                    Iterator<String> it = cvVar.a(true).iterator();
                    while (it.hasNext()) {
                        arrayList2.add(String.format(Locale.US, "http://%1$s/gslb/?ver=4.0", it.next()));
                    }
                }
            }
            a2 = arrayList2;
        } else {
            a2 = c2.a(format);
        }
        Iterator<String> it2 = a2.iterator();
        IOException e = null;
        while (it2.hasNext()) {
            Uri.Builder buildUpon = Uri.parse(it2.next()).buildUpon();
            for (ay ayVar : arrayList3) {
                buildUpon.appendQueryParameter(ayVar.a(), ayVar.b());
            }
            try {
                str3 = this.f271a == null ? az.a(f13929a, new URL(buildUpon.toString())) : this.f271a.a(buildUpon.toString());
                return str3;
            } catch (IOException e2) {
                e = e2;
            }
        }
        if (e != null) {
            com.xiaomi.channel.commonutils.logger.b.m80a("network exception: " + e.getMessage());
            throw e;
        }
        return str3;
    }

    /* renamed from: a  reason: collision with other method in class */
    protected JSONObject m243a() {
        JSONObject jSONObject;
        synchronized (this.f273a) {
            jSONObject = new JSONObject();
            jSONObject.put("ver", 2);
            JSONArray jSONArray = new JSONArray();
            for (cw cwVar : this.f273a.values()) {
                jSONArray.put(cwVar.m238a());
            }
            jSONObject.put("data", jSONArray);
            JSONArray jSONArray2 = new JSONArray();
            for (cv cvVar : f13930b.values()) {
                jSONArray2.put(cvVar.m233a());
            }
            jSONObject.put(GestureAR.SDK_TO_LUA_GESTURE_RESULT_RESERVED, jSONArray2);
        }
        return jSONObject;
    }

    /* renamed from: a  reason: collision with other method in class */
    public void m244a() {
        synchronized (this.f273a) {
            this.f273a.clear();
        }
    }

    /* renamed from: a  reason: collision with other method in class */
    public void m245a(String str) {
        this.f275b = str;
    }

    public void a(String str, cv cvVar) {
        if (TextUtils.isEmpty(str) || cvVar == null) {
            throw new IllegalArgumentException("the argument is invalid " + str + ", " + cvVar);
        }
        if (this.f270a.a(str)) {
            synchronized (this.f273a) {
                m246a();
                if (this.f273a.containsKey(str)) {
                    this.f273a.get(str).a(cvVar);
                } else {
                    cw cwVar = new cw(str);
                    cwVar.a(cvVar);
                    this.f273a.put(str, cwVar);
                }
            }
        }
    }

    /* renamed from: a  reason: collision with other method in class */
    protected boolean m246a() {
        synchronized (this.f273a) {
            if (f268a) {
                return true;
            }
            f268a = true;
            this.f273a.clear();
            String d2 = d();
            if (TextUtils.isEmpty(d2)) {
                return false;
            }
            m248b(d2);
            com.xiaomi.channel.commonutils.logger.b.b("loading the new hosts succeed");
            return true;
        }
    }

    public cv b(String str) {
        return a(str, true);
    }

    protected String b() {
        String a2 = com.xiaomi.push.service.a.a(f13929a).a();
        return (TextUtils.isEmpty(a2) || PushChannelRegion.China.name().equals(a2)) ? "resolver.msg.xiaomi.net" : "resolver.msg.global.xiaomi.net";
    }

    /* renamed from: b  reason: collision with other method in class */
    public void m247b() {
        ArrayList<String> arrayList;
        synchronized (this.f273a) {
            m246a();
            arrayList = new ArrayList<>(this.f273a.keySet());
            for (int size = arrayList.size() - 1; size >= 0; size--) {
                cw cwVar = this.f273a.get(arrayList.get(size));
                if (cwVar != null && cwVar.a() != null) {
                    arrayList.remove(size);
                }
            }
        }
        ArrayList<cv> a2 = a(arrayList);
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= arrayList.size()) {
                return;
            }
            if (a2.get(i2) != null) {
                a(arrayList.get(i2), a2.get(i2));
            }
            i = i2 + 1;
        }
    }

    /* renamed from: b  reason: collision with other method in class */
    protected void m248b(String str) {
        synchronized (this.f273a) {
            this.f273a.clear();
            JSONObject jSONObject = new JSONObject(str);
            if (jSONObject.optInt("ver") != 2) {
                throw new JSONException("Bad version");
            }
            JSONArray optJSONArray = jSONObject.optJSONArray("data");
            for (int i = 0; i < optJSONArray.length(); i++) {
                cw a2 = new cw().a(optJSONArray.getJSONObject(i));
                this.f273a.put(a2.m236a(), a2);
            }
            JSONArray optJSONArray2 = jSONObject.optJSONArray(GestureAR.SDK_TO_LUA_GESTURE_RESULT_RESERVED);
            for (int i2 = 0; i2 < optJSONArray2.length(); i2++) {
                cv a3 = new cv("").a(optJSONArray2.getJSONObject(i2));
                f13930b.put(a3.f263b, a3);
            }
        }
    }

    protected cv c(String str) {
        cw cwVar;
        cv a2;
        synchronized (this.f273a) {
            m246a();
            cwVar = this.f273a.get(str);
        }
        if (cwVar == null || (a2 = cwVar.a()) == null) {
            return null;
        }
        return a2;
    }

    public String c() {
        StringBuilder sb = new StringBuilder();
        synchronized (this.f273a) {
            for (Map.Entry<String, cw> entry : this.f273a.entrySet()) {
                sb.append(entry.getKey());
                sb.append(":\n");
                sb.append(entry.getValue().toString());
                sb.append("\n");
            }
        }
        return sb.toString();
    }

    /* renamed from: c  reason: collision with other method in class */
    public void m249c() {
        synchronized (this.f273a) {
            try {
                BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(f13929a.openFileOutput(e(), 0)));
                String jSONObject = m243a().toString();
                if (!TextUtils.isEmpty(jSONObject)) {
                    bufferedWriter.write(jSONObject);
                }
                bufferedWriter.close();
            } catch (Exception e) {
                com.xiaomi.channel.commonutils.logger.b.m80a("persist bucket failure: " + e.getMessage());
            }
        }
    }

    protected cv d(String str) {
        if (System.currentTimeMillis() - this.f276c > this.f269a * 60 * 1000) {
            this.f276c = System.currentTimeMillis();
            ArrayList<String> arrayList = new ArrayList<>();
            arrayList.add(str);
            cv cvVar = a(arrayList).get(0);
            if (cvVar != null) {
                this.f269a = 0L;
                return cvVar;
            } else if (this.f269a < 15) {
                this.f269a++;
            }
        }
        return null;
    }

    protected String d() {
        BufferedReader bufferedReader;
        String str = null;
        try {
            File file = new File(f13929a.getFilesDir(), e());
            if (file.isFile()) {
                bufferedReader = new BufferedReader(new InputStreamReader(new FileInputStream(file)));
                try {
                    StringBuilder sb = new StringBuilder();
                    while (true) {
                        String readLine = bufferedReader.readLine();
                        if (readLine == null) {
                            break;
                        }
                        sb.append(readLine);
                    }
                    str = sb.toString();
                    y.a(bufferedReader);
                } catch (Throwable th) {
                    th = th;
                    try {
                        com.xiaomi.channel.commonutils.logger.b.m80a("load host exception " + th.getMessage());
                        y.a(bufferedReader);
                        return str;
                    } catch (Throwable th2) {
                        y.a(bufferedReader);
                        throw th2;
                    }
                }
            } else {
                y.a((Closeable) null);
            }
        } catch (Throwable th3) {
            th = th3;
            bufferedReader = null;
        }
        return str;
    }

    /* renamed from: d  reason: collision with other method in class */
    public void m250d() {
        synchronized (this.f273a) {
            for (cw cwVar : this.f273a.values()) {
                cwVar.a(true);
            }
            boolean z = false;
            while (!z) {
                Iterator<String> it = this.f273a.keySet().iterator();
                while (true) {
                    if (!it.hasNext()) {
                        z = true;
                        break;
                    }
                    String next = it.next();
                    if (this.f273a.get(next).m237a().isEmpty()) {
                        this.f273a.remove(next);
                        z = false;
                        break;
                    }
                }
            }
        }
    }

    protected String e() {
        List<ActivityManager.RunningAppProcessInfo> runningAppProcesses = ((ActivityManager) f13929a.getSystemService(PushConstants.INTENT_ACTIVITY_NAME)).getRunningAppProcesses();
        if (runningAppProcesses != null) {
            for (ActivityManager.RunningAppProcessInfo runningAppProcessInfo : runningAppProcesses) {
                if (runningAppProcessInfo.pid == Process.myPid()) {
                    return runningAppProcessInfo.processName;
                }
            }
        }
        return "com.xiaomi";
    }
}
