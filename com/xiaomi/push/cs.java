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
import com.baidu.android.common.others.lang.StringUtil;
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
/* loaded from: classes7.dex */
public class cs {

    /* renamed from: a  reason: collision with root package name */
    public static Context f38236a;

    /* renamed from: a  reason: collision with other field name */
    public static a f194a;

    /* renamed from: a  reason: collision with other field name */
    public static cs f195a;

    /* renamed from: c  reason: collision with root package name */
    public static String f38238c;

    /* renamed from: d  reason: collision with root package name */
    public static String f38239d;

    /* renamed from: a  reason: collision with other field name */
    public long f197a;

    /* renamed from: a  reason: collision with other field name */
    public cr f198a;

    /* renamed from: a  reason: collision with other field name */
    public b f199a;

    /* renamed from: a  reason: collision with other field name */
    public String f200a;

    /* renamed from: a  reason: collision with other field name */
    public Map<String, cp> f201a;

    /* renamed from: b  reason: collision with other field name */
    public final long f202b;

    /* renamed from: b  reason: collision with other field name */
    public String f203b;

    /* renamed from: c  reason: collision with other field name */
    public long f204c;

    /* renamed from: b  reason: collision with root package name */
    public static Map<String, co> f38237b = new HashMap();

    /* renamed from: a  reason: collision with other field name */
    public static boolean f196a = false;

    /* loaded from: classes7.dex */
    public interface a {
        cs a(Context context, cr crVar, b bVar, String str);
    }

    /* loaded from: classes7.dex */
    public interface b {
        String a(String str);
    }

    public cs(Context context, cr crVar, b bVar, String str) {
        this(context, crVar, bVar, str, null, null);
    }

    public cs(Context context, cr crVar, b bVar, String str, String str2, String str3) {
        this.f201a = new HashMap();
        this.f200a = "0";
        this.f197a = 0L;
        this.f202b = 15L;
        this.f204c = 0L;
        this.f203b = "isp_prov_city_country_ip";
        this.f199a = bVar;
        this.f198a = crVar == null ? new ct(this) : crVar;
        this.f200a = str;
        f38238c = str2 == null ? context.getPackageName() : str2;
        f38239d = str3 == null ? f() : str3;
    }

    public static synchronized cs a() {
        cs csVar;
        synchronized (cs.class) {
            if (f195a == null) {
                throw new IllegalStateException("the host manager is not initialized yet.");
            }
            csVar = f195a;
        }
        return csVar;
    }

    /* renamed from: a  reason: collision with other method in class */
    public static String m216a() {
        ConnectivityManager connectivityManager;
        NetworkInfo activeNetworkInfo;
        Context context = f38236a;
        if (context == null) {
            return "unknown";
        }
        try {
            connectivityManager = (ConnectivityManager) context.getSystemService("connectivity");
        } catch (Throwable unused) {
        }
        if (connectivityManager == null || (activeNetworkInfo = connectivityManager.getActiveNetworkInfo()) == null) {
            return "unknown";
        }
        if (activeNetworkInfo.getType() != 1) {
            return activeNetworkInfo.getTypeName() + "-" + activeNetworkInfo.getSubtypeName();
        }
        WifiManager wifiManager = (WifiManager) f38236a.getSystemService("wifi");
        if (wifiManager != null && wifiManager.getConnectionInfo() != null) {
            return "WIFI-" + wifiManager.getConnectionInfo().getSSID();
        }
        return "unknown";
    }

    public static String a(String str) {
        try {
            int length = str.length();
            byte[] bytes = str.getBytes("UTF-8");
            for (int i2 = 0; i2 < bytes.length; i2++) {
                byte b2 = bytes[i2];
                int i3 = b2 & 240;
                if (i3 != 240) {
                    bytes[i2] = (byte) (((b2 & 15) ^ ((byte) (((b2 >> 4) + length) & 15))) | i3);
                }
            }
            return new String(bytes);
        } catch (UnsupportedEncodingException unused) {
            return str;
        }
    }

    private ArrayList<co> a(ArrayList<String> arrayList) {
        JSONObject jSONObject;
        JSONObject jSONObject2;
        m225d();
        synchronized (this.f201a) {
            m221a();
            for (String str : this.f201a.keySet()) {
                if (!arrayList.contains(str)) {
                    arrayList.add(str);
                }
            }
        }
        boolean isEmpty = f38237b.isEmpty();
        synchronized (f38237b) {
            for (Object obj : f38237b.values().toArray()) {
                co coVar = (co) obj;
                if (!coVar.b()) {
                    f38237b.remove(coVar.f191b);
                    isEmpty = true;
                }
            }
        }
        if (!arrayList.contains(b())) {
            arrayList.add(b());
        }
        ArrayList<co> arrayList2 = new ArrayList<>(arrayList.size());
        for (int i2 = 0; i2 < arrayList.size(); i2++) {
            arrayList2.add(null);
        }
        try {
            String str2 = bg.e(f38236a) ? "wifi" : "wap";
            String a2 = a(arrayList, str2, this.f200a, isEmpty);
            if (!TextUtils.isEmpty(a2)) {
                JSONObject jSONObject3 = new JSONObject(a2);
                com.xiaomi.channel.commonutils.logger.b.b(a2);
                if ("OK".equalsIgnoreCase(jSONObject3.getString("S"))) {
                    JSONObject jSONObject4 = jSONObject3.getJSONObject("R");
                    String string = jSONObject4.getString("province");
                    String string2 = jSONObject4.getString("city");
                    String string3 = jSONObject4.getString("isp");
                    String string4 = jSONObject4.getString("ip");
                    String string5 = jSONObject4.getString("country");
                    JSONObject jSONObject5 = jSONObject4.getJSONObject(str2);
                    com.xiaomi.channel.commonutils.logger.b.c("get bucket: net=" + string3 + ", hosts=" + jSONObject5.toString());
                    int i3 = 0;
                    while (i3 < arrayList.size()) {
                        String str3 = arrayList.get(i3);
                        JSONArray optJSONArray = jSONObject5.optJSONArray(str3);
                        if (optJSONArray == null) {
                            com.xiaomi.channel.commonutils.logger.b.m58a("no bucket found for " + str3);
                            jSONObject = jSONObject5;
                        } else {
                            co coVar2 = new co(str3);
                            int i4 = 0;
                            while (i4 < optJSONArray.length()) {
                                String string6 = optJSONArray.getString(i4);
                                if (TextUtils.isEmpty(string6)) {
                                    jSONObject2 = jSONObject5;
                                } else {
                                    jSONObject2 = jSONObject5;
                                    coVar2.a(new cx(string6, optJSONArray.length() - i4));
                                }
                                i4++;
                                jSONObject5 = jSONObject2;
                            }
                            jSONObject = jSONObject5;
                            arrayList2.set(i3, coVar2);
                            coVar2.f38231g = string5;
                            coVar2.f38227c = string;
                            coVar2.f38229e = string3;
                            coVar2.f38230f = string4;
                            coVar2.f38228d = string2;
                            if (jSONObject4.has("stat-percent")) {
                                coVar2.a(jSONObject4.getDouble("stat-percent"));
                            }
                            if (jSONObject4.has("stat-domain")) {
                                coVar2.b(jSONObject4.getString("stat-domain"));
                            }
                            if (jSONObject4.has("ttl")) {
                                coVar2.a(jSONObject4.getInt("ttl") * 1000);
                            }
                            m220a(coVar2.a());
                        }
                        i3++;
                        jSONObject5 = jSONObject;
                    }
                    JSONObject optJSONObject = jSONObject4.optJSONObject("reserved");
                    if (optJSONObject != null) {
                        long j = jSONObject4.has("reserved-ttl") ? jSONObject4.getInt("reserved-ttl") * 1000 : 604800000L;
                        Iterator<String> keys = optJSONObject.keys();
                        while (keys.hasNext()) {
                            String next = keys.next();
                            JSONArray optJSONArray2 = optJSONObject.optJSONArray(next);
                            if (optJSONArray2 == null) {
                                com.xiaomi.channel.commonutils.logger.b.m58a("no bucket found for " + next);
                            } else {
                                co coVar3 = new co(next);
                                coVar3.a(j);
                                for (int i5 = 0; i5 < optJSONArray2.length(); i5++) {
                                    String string7 = optJSONArray2.getString(i5);
                                    if (!TextUtils.isEmpty(string7)) {
                                        coVar3.a(new cx(string7, optJSONArray2.length() - i5));
                                    }
                                }
                                synchronized (f38237b) {
                                    if (this.f198a.a(next)) {
                                        f38237b.put(next, coVar3);
                                    }
                                }
                            }
                        }
                    }
                }
            }
        } catch (Exception e2) {
            com.xiaomi.channel.commonutils.logger.b.m58a("failed to get bucket " + e2.getMessage());
        }
        for (int i6 = 0; i6 < arrayList.size(); i6++) {
            co coVar4 = arrayList2.get(i6);
            if (coVar4 != null) {
                a(arrayList.get(i6), coVar4);
            }
        }
        m224c();
        return arrayList2;
    }

    public static synchronized void a(Context context, cr crVar, b bVar, String str, String str2, String str3) {
        synchronized (cs.class) {
            Context applicationContext = context.getApplicationContext();
            f38236a = applicationContext;
            if (applicationContext == null) {
                f38236a = context;
            }
            if (f195a == null) {
                if (f194a == null) {
                    f195a = new cs(context, crVar, bVar, str, str2, str3);
                } else {
                    f195a = f194a.a(context, crVar, bVar, str);
                }
            }
        }
    }

    public static synchronized void a(a aVar) {
        synchronized (cs.class) {
            f194a = aVar;
            f195a = null;
        }
    }

    public static void a(String str, String str2) {
        co coVar = f38237b.get(str);
        synchronized (f38237b) {
            if (coVar == null) {
                co coVar2 = new co(str);
                coVar2.a(604800000L);
                coVar2.m209a(str2);
                f38237b.put(str, coVar2);
            } else {
                coVar.m209a(str2);
            }
        }
    }

    private String f() {
        try {
            PackageInfo packageInfo = f38236a.getPackageManager().getPackageInfo(f38236a.getPackageName(), 16384);
            return packageInfo != null ? packageInfo.versionName : "0";
        } catch (Exception unused) {
            return "0";
        }
    }

    /* renamed from: a  reason: collision with other method in class */
    public co m217a(String str) {
        if (TextUtils.isEmpty(str)) {
            throw new IllegalArgumentException("the url is empty");
        }
        return a(new URL(str).getHost(), true);
    }

    public co a(String str, boolean z) {
        co d2;
        if (TextUtils.isEmpty(str)) {
            throw new IllegalArgumentException("the host is empty");
        }
        if (this.f198a.a(str)) {
            co c2 = c(str);
            return (c2 == null || !c2.b()) ? (z && bg.b(f38236a) && (d2 = d(str)) != null) ? d2 : new cu(this, str, c2) : c2;
        }
        return null;
    }

    public String a(ArrayList<String> arrayList, String str, String str2, boolean z) {
        ArrayList<String> arrayList2 = new ArrayList<>();
        ArrayList<bf> arrayList3 = new ArrayList();
        arrayList3.add(new bd("type", str));
        if (str.equals("wap")) {
            arrayList3.add(new bd("conpt", a(bg.m160a(f38236a))));
        }
        if (z) {
            arrayList3.add(new bd("reserved", "1"));
        }
        arrayList3.add(new bd("uuid", str2));
        arrayList3.add(new bd("list", bm.a(arrayList, ",")));
        arrayList3.add(new bd("countrycode", com.xiaomi.push.service.a.a(f38236a).b()));
        co c2 = c(b());
        String format = String.format(Locale.US, "https://%1$s/gslb/?ver=4.0", b());
        if (c2 == null) {
            arrayList2.add(format);
            synchronized (f38237b) {
                co coVar = f38237b.get("resolver.msg.xiaomi.net");
                if (coVar != null) {
                    Iterator<String> it = coVar.a(true).iterator();
                    while (it.hasNext()) {
                        arrayList2.add(String.format(Locale.US, "https://%1$s/gslb/?ver=4.0", it.next()));
                    }
                }
            }
        } else {
            arrayList2 = c2.a(format);
        }
        Iterator<String> it2 = arrayList2.iterator();
        IOException e2 = null;
        while (it2.hasNext()) {
            Uri.Builder buildUpon = Uri.parse(it2.next()).buildUpon();
            for (bf bfVar : arrayList3) {
                buildUpon.appendQueryParameter(bfVar.a(), bfVar.b());
            }
            try {
                return this.f199a == null ? bg.a(f38236a, new URL(buildUpon.toString())) : this.f199a.a(buildUpon.toString());
            } catch (IOException e3) {
                e2 = e3;
            }
        }
        if (e2 == null) {
            return null;
        }
        com.xiaomi.channel.commonutils.logger.b.m58a("network exception: " + e2.getMessage());
        throw e2;
    }

    /* renamed from: a  reason: collision with other method in class */
    public JSONObject m218a() {
        JSONObject jSONObject;
        synchronized (this.f201a) {
            jSONObject = new JSONObject();
            jSONObject.put("ver", 2);
            JSONArray jSONArray = new JSONArray();
            for (cp cpVar : this.f201a.values()) {
                jSONArray.put(cpVar.m213a());
            }
            jSONObject.put("data", jSONArray);
            JSONArray jSONArray2 = new JSONArray();
            for (co coVar : f38237b.values()) {
                jSONArray2.put(coVar.m208a());
            }
            jSONObject.put("reserved", jSONArray2);
        }
        return jSONObject;
    }

    /* renamed from: a  reason: collision with other method in class */
    public void m219a() {
        synchronized (this.f201a) {
            this.f201a.clear();
        }
    }

    /* renamed from: a  reason: collision with other method in class */
    public void m220a(String str) {
        this.f203b = str;
    }

    public void a(String str, co coVar) {
        if (TextUtils.isEmpty(str) || coVar == null) {
            throw new IllegalArgumentException("the argument is invalid " + str + StringUtil.ARRAY_ELEMENT_SEPARATOR + coVar);
        } else if (this.f198a.a(str)) {
            synchronized (this.f201a) {
                m221a();
                if (this.f201a.containsKey(str)) {
                    this.f201a.get(str).a(coVar);
                } else {
                    cp cpVar = new cp(str);
                    cpVar.a(coVar);
                    this.f201a.put(str, cpVar);
                }
            }
        }
    }

    /* renamed from: a  reason: collision with other method in class */
    public boolean m221a() {
        synchronized (this.f201a) {
            if (f196a) {
                return true;
            }
            f196a = true;
            this.f201a.clear();
            String d2 = d();
            if (TextUtils.isEmpty(d2)) {
                return false;
            }
            m223b(d2);
            com.xiaomi.channel.commonutils.logger.b.b("loading the new hosts succeed");
            return true;
        }
    }

    public co b(String str) {
        return a(str, true);
    }

    public String b() {
        String a2 = com.xiaomi.push.service.a.a(f38236a).a();
        return (TextUtils.isEmpty(a2) || PushChannelRegion.China.name().equals(a2)) ? "resolver.msg.xiaomi.net" : "resolver.msg.global.xiaomi.net";
    }

    /* renamed from: b  reason: collision with other method in class */
    public void m222b() {
        ArrayList<String> arrayList;
        synchronized (this.f201a) {
            m221a();
            arrayList = new ArrayList<>(this.f201a.keySet());
            for (int size = arrayList.size() - 1; size >= 0; size--) {
                cp cpVar = this.f201a.get(arrayList.get(size));
                if (cpVar != null && cpVar.a() != null) {
                    arrayList.remove(size);
                }
            }
        }
        ArrayList<co> a2 = a(arrayList);
        for (int i2 = 0; i2 < arrayList.size(); i2++) {
            if (a2.get(i2) != null) {
                a(arrayList.get(i2), a2.get(i2));
            }
        }
    }

    /* renamed from: b  reason: collision with other method in class */
    public void m223b(String str) {
        synchronized (this.f201a) {
            this.f201a.clear();
            JSONObject jSONObject = new JSONObject(str);
            if (jSONObject.optInt("ver") != 2) {
                throw new JSONException("Bad version");
            }
            JSONArray optJSONArray = jSONObject.optJSONArray("data");
            for (int i2 = 0; i2 < optJSONArray.length(); i2++) {
                cp a2 = new cp().a(optJSONArray.getJSONObject(i2));
                this.f201a.put(a2.m211a(), a2);
            }
            JSONArray optJSONArray2 = jSONObject.optJSONArray("reserved");
            for (int i3 = 0; i3 < optJSONArray2.length(); i3++) {
                co a3 = new co("").a(optJSONArray2.getJSONObject(i3));
                f38237b.put(a3.f191b, a3);
            }
        }
    }

    public co c(String str) {
        cp cpVar;
        co a2;
        synchronized (this.f201a) {
            m221a();
            cpVar = this.f201a.get(str);
        }
        if (cpVar == null || (a2 = cpVar.a()) == null) {
            return null;
        }
        return a2;
    }

    public String c() {
        StringBuilder sb = new StringBuilder();
        synchronized (this.f201a) {
            for (Map.Entry<String, cp> entry : this.f201a.entrySet()) {
                sb.append(entry.getKey());
                sb.append(":\n");
                sb.append(entry.getValue().toString());
                sb.append("\n");
            }
        }
        return sb.toString();
    }

    /* renamed from: c  reason: collision with other method in class */
    public void m224c() {
        synchronized (this.f201a) {
            try {
                BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(f38236a.openFileOutput(e(), 0)));
                String jSONObject = m218a().toString();
                if (!TextUtils.isEmpty(jSONObject)) {
                    bufferedWriter.write(jSONObject);
                }
                bufferedWriter.close();
            } catch (Exception e2) {
                com.xiaomi.channel.commonutils.logger.b.m58a("persist bucket failure: " + e2.getMessage());
            }
        }
    }

    public co d(String str) {
        if (System.currentTimeMillis() - this.f204c > this.f197a * 60 * 1000) {
            this.f204c = System.currentTimeMillis();
            ArrayList<String> arrayList = new ArrayList<>();
            arrayList.add(str);
            co coVar = a(arrayList).get(0);
            if (coVar != null) {
                this.f197a = 0L;
                return coVar;
            }
            long j = this.f197a;
            if (j < 15) {
                this.f197a = j + 1;
                return null;
            }
            return null;
        }
        return null;
    }

    public String d() {
        BufferedReader bufferedReader;
        File file;
        try {
            file = new File(f38236a.getFilesDir(), e());
        } catch (Throwable th) {
            th = th;
            bufferedReader = null;
        }
        if (!file.isFile()) {
            y.a((Closeable) null);
            return null;
        }
        bufferedReader = new BufferedReader(new InputStreamReader(new FileInputStream(file)));
        try {
            StringBuilder sb = new StringBuilder();
            while (true) {
                String readLine = bufferedReader.readLine();
                if (readLine == null) {
                    return sb.toString();
                }
                sb.append(readLine);
            }
        } catch (Throwable th2) {
            th = th2;
            try {
                com.xiaomi.channel.commonutils.logger.b.m58a("load host exception " + th.getMessage());
                return null;
            } finally {
                y.a(bufferedReader);
            }
        }
    }

    /* renamed from: d  reason: collision with other method in class */
    public void m225d() {
        String next;
        synchronized (this.f201a) {
            for (cp cpVar : this.f201a.values()) {
                cpVar.a(true);
            }
            while (true) {
                for (boolean z = false; !z; z = true) {
                    Iterator<String> it = this.f201a.keySet().iterator();
                    while (it.hasNext()) {
                        next = it.next();
                        if (this.f201a.get(next).m212a().isEmpty()) {
                            break;
                        }
                    }
                }
                this.f201a.remove(next);
            }
        }
    }

    public String e() {
        List<ActivityManager.RunningAppProcessInfo> runningAppProcesses = ((ActivityManager) f38236a.getSystemService("activity")).getRunningAppProcesses();
        if (runningAppProcesses != null) {
            for (ActivityManager.RunningAppProcessInfo runningAppProcessInfo : runningAppProcesses) {
                if (runningAppProcessInfo.pid == Process.myPid()) {
                    return runningAppProcessInfo.processName;
                }
            }
            return "com.xiaomi";
        }
        return "com.xiaomi";
    }
}
