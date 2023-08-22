package com.xiaomi.push;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.Uri;
import android.text.TextUtils;
import androidx.exifinterface.media.ExifInterface;
import com.baidu.android.common.others.lang.StringUtil;
import com.baidu.ar.gesture.GestureAR;
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
import java.util.Locale;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes10.dex */
public class cu {
    public static Context a;

    /* renamed from: a  reason: collision with other field name */
    public static a f190a;

    /* renamed from: a  reason: collision with other field name */
    public static cu f191a;
    public static String c;
    public static String d;

    /* renamed from: a  reason: collision with other field name */
    public long f193a;

    /* renamed from: a  reason: collision with other field name */
    public ct f194a;

    /* renamed from: a  reason: collision with other field name */
    public b f195a;

    /* renamed from: a  reason: collision with other field name */
    public String f196a;

    /* renamed from: a  reason: collision with other field name */
    public final Map<String, cr> f197a;

    /* renamed from: b  reason: collision with other field name */
    public final long f198b;

    /* renamed from: b  reason: collision with other field name */
    public String f199b;

    /* renamed from: c  reason: collision with other field name */
    public long f200c;
    public static final Map<String, cq> b = new HashMap();

    /* renamed from: a  reason: collision with other field name */
    public static boolean f192a = false;

    /* loaded from: classes10.dex */
    public interface a {
        cu a(Context context, ct ctVar, b bVar, String str);
    }

    /* loaded from: classes10.dex */
    public interface b {
        String a(String str);
    }

    public cu(Context context, ct ctVar, b bVar, String str) {
        this(context, ctVar, bVar, str, null, null);
    }

    public cu(Context context, ct ctVar, b bVar, String str, String str2, String str3) {
        this.f197a = new HashMap();
        this.f196a = "0";
        this.f193a = 0L;
        this.f198b = 15L;
        this.f200c = 0L;
        this.f199b = "isp_prov_city_country_ip";
        this.f195a = bVar;
        this.f194a = ctVar == null ? new cv(this) : ctVar;
        this.f196a = str;
        c = str2 == null ? context.getPackageName() : str2;
        d = str3 == null ? f() : str3;
    }

    public static synchronized cu a() {
        cu cuVar;
        synchronized (cu.class) {
            if (f191a == null) {
                throw new IllegalStateException("the host manager is not initialized yet.");
            }
            cuVar = f191a;
        }
        return cuVar;
    }

    /* renamed from: a  reason: collision with other method in class */
    public static String m344a() {
        NetworkInfo activeNetworkInfo;
        Context context = a;
        if (context == null) {
            return "unknown";
        }
        try {
            ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService("connectivity");
            if (connectivityManager == null || (activeNetworkInfo = connectivityManager.getActiveNetworkInfo()) == null) {
                return "unknown";
            }
            if (activeNetworkInfo.getType() == 1) {
                return "WIFI-UNKNOWN";
            }
            return activeNetworkInfo.getTypeName() + "-" + activeNetworkInfo.getSubtypeName();
        } catch (Throwable unused) {
            return "unknown";
        }
    }

    public static String a(String str) {
        try {
            int length = str.length();
            byte[] bytes = str.getBytes("UTF-8");
            for (int i = 0; i < bytes.length; i++) {
                byte b2 = bytes[i];
                int i2 = b2 & 240;
                if (i2 != 240) {
                    bytes[i] = (byte) (((b2 & 15) ^ ((byte) (((b2 >> 4) + length) & 15))) | i2);
                }
            }
            return new String(bytes);
        } catch (UnsupportedEncodingException unused) {
            return str;
        }
    }

    private ArrayList<cq> a(ArrayList<String> arrayList) {
        JSONObject jSONObject;
        JSONObject jSONObject2;
        m353d();
        synchronized (this.f197a) {
            m349a();
            for (String str : this.f197a.keySet()) {
                if (!arrayList.contains(str)) {
                    arrayList.add(str);
                }
            }
        }
        synchronized (b) {
            for (Object obj : b.values().toArray()) {
                cq cqVar = (cq) obj;
                if (!cqVar.b()) {
                    b.remove(cqVar.f187b);
                }
            }
        }
        if (!arrayList.contains(b())) {
            arrayList.add(b());
        }
        ArrayList<cq> arrayList2 = new ArrayList<>(arrayList.size());
        for (int i = 0; i < arrayList.size(); i++) {
            arrayList2.add(null);
        }
        try {
            String str2 = bi.e(a) ? "wifi" : "wap";
            String a2 = a(arrayList, str2, this.f196a, true);
            if (!TextUtils.isEmpty(a2)) {
                JSONObject jSONObject3 = new JSONObject(a2);
                com.xiaomi.channel.commonutils.logger.b.b(a2);
                if ("OK".equalsIgnoreCase(jSONObject3.getString(ExifInterface.LATITUDE_SOUTH))) {
                    JSONObject jSONObject4 = jSONObject3.getJSONObject("R");
                    String string = jSONObject4.getString("province");
                    String string2 = jSONObject4.getString("city");
                    String string3 = jSONObject4.getString("isp");
                    String string4 = jSONObject4.getString("ip");
                    String string5 = jSONObject4.getString("country");
                    JSONObject jSONObject5 = jSONObject4.getJSONObject(str2);
                    com.xiaomi.channel.commonutils.logger.b.c("get bucket: net=" + string3 + ", hosts=" + jSONObject5.toString());
                    int i2 = 0;
                    while (i2 < arrayList.size()) {
                        String str3 = arrayList.get(i2);
                        JSONArray optJSONArray = jSONObject5.optJSONArray(str3);
                        if (optJSONArray == null) {
                            com.xiaomi.channel.commonutils.logger.b.m180a("no bucket found for " + str3);
                            jSONObject = jSONObject5;
                        } else {
                            cq cqVar2 = new cq(str3);
                            int i3 = 0;
                            while (i3 < optJSONArray.length()) {
                                String string6 = optJSONArray.getString(i3);
                                if (TextUtils.isEmpty(string6)) {
                                    jSONObject2 = jSONObject5;
                                } else {
                                    jSONObject2 = jSONObject5;
                                    cqVar2.a(new cz(string6, optJSONArray.length() - i3));
                                }
                                i3++;
                                jSONObject5 = jSONObject2;
                            }
                            jSONObject = jSONObject5;
                            arrayList2.set(i2, cqVar2);
                            cqVar2.g = string5;
                            cqVar2.c = string;
                            cqVar2.e = string3;
                            cqVar2.f = string4;
                            cqVar2.d = string2;
                            if (jSONObject4.has("stat-percent")) {
                                cqVar2.a(jSONObject4.getDouble("stat-percent"));
                            }
                            if (jSONObject4.has("stat-domain")) {
                                cqVar2.b(jSONObject4.getString("stat-domain"));
                            }
                            if (jSONObject4.has("ttl")) {
                                cqVar2.a(jSONObject4.getInt("ttl") * 1000);
                            }
                            m348a(cqVar2.a());
                        }
                        i2++;
                        jSONObject5 = jSONObject;
                    }
                    JSONObject optJSONObject = jSONObject4.optJSONObject(GestureAR.SDK_TO_LUA_GESTURE_RESULT_RESERVED);
                    if (optJSONObject != null) {
                        long j = jSONObject4.has("reserved-ttl") ? jSONObject4.getInt("reserved-ttl") * 1000 : 604800000L;
                        Iterator<String> keys = optJSONObject.keys();
                        while (keys.hasNext()) {
                            String next = keys.next();
                            JSONArray optJSONArray2 = optJSONObject.optJSONArray(next);
                            if (optJSONArray2 == null) {
                                com.xiaomi.channel.commonutils.logger.b.m180a("no bucket found for " + next);
                            } else {
                                cq cqVar3 = new cq(next);
                                cqVar3.a(j);
                                for (int i4 = 0; i4 < optJSONArray2.length(); i4++) {
                                    String string7 = optJSONArray2.getString(i4);
                                    if (!TextUtils.isEmpty(string7)) {
                                        cqVar3.a(new cz(string7, optJSONArray2.length() - i4));
                                    }
                                }
                                synchronized (b) {
                                    if (this.f194a.a(next)) {
                                        b.put(next, cqVar3);
                                    }
                                }
                            }
                        }
                    }
                }
            }
        } catch (Exception e) {
            com.xiaomi.channel.commonutils.logger.b.m180a("failed to get bucket " + e.getMessage());
        }
        for (int i5 = 0; i5 < arrayList.size(); i5++) {
            cq cqVar4 = arrayList2.get(i5);
            if (cqVar4 != null) {
                a(arrayList.get(i5), cqVar4);
            }
        }
        m352c();
        return arrayList2;
    }

    public static synchronized void a(Context context, ct ctVar, b bVar, String str, String str2, String str3) {
        synchronized (cu.class) {
            Context applicationContext = context.getApplicationContext();
            a = applicationContext;
            if (applicationContext == null) {
                a = context;
            }
            if (f191a == null) {
                if (f190a == null) {
                    f191a = new cu(context, ctVar, bVar, str, str2, str3);
                } else {
                    f191a = f190a.a(context, ctVar, bVar, str);
                }
            }
        }
    }

    public static synchronized void a(a aVar) {
        synchronized (cu.class) {
            f190a = aVar;
            f191a = null;
        }
    }

    public static void a(String str, String str2) {
        cq cqVar = b.get(str);
        synchronized (b) {
            if (cqVar == null) {
                cq cqVar2 = new cq(str);
                cqVar2.a(604800000L);
                cqVar2.m337a(str2);
                b.put(str, cqVar2);
            } else {
                cqVar.m337a(str2);
            }
        }
    }

    private String f() {
        try {
            PackageInfo packageInfo = a.getPackageManager().getPackageInfo(a.getPackageName(), 16384);
            return packageInfo != null ? packageInfo.versionName : "0";
        } catch (Exception unused) {
            return "0";
        }
    }

    /* renamed from: a  reason: collision with other method in class */
    public cq m345a(String str) {
        if (TextUtils.isEmpty(str)) {
            throw new IllegalArgumentException("the url is empty");
        }
        return a(new URL(str).getHost(), true);
    }

    public cq a(String str, boolean z) {
        cq e;
        if (TextUtils.isEmpty(str)) {
            throw new IllegalArgumentException("the host is empty");
        }
        if (this.f194a.a(str)) {
            cq c2 = c(str);
            return (c2 == null || !c2.b()) ? (z && bi.b(a) && (e = e(str)) != null) ? e : new cw(this, str, c2) : c2;
        }
        return null;
    }

    public String a(ArrayList<String> arrayList, String str, String str2, boolean z) {
        ArrayList<String> arrayList2 = new ArrayList<>();
        ArrayList<bh> arrayList3 = new ArrayList();
        arrayList3.add(new bf("type", str));
        if (str.equals("wap")) {
            arrayList3.add(new bf("conpt", a(bi.m288a(a))));
        }
        if (z) {
            arrayList3.add(new bf(GestureAR.SDK_TO_LUA_GESTURE_RESULT_RESERVED, "1"));
        }
        arrayList3.add(new bf("uuid", str2));
        arrayList3.add(new bf("list", bo.a(arrayList, ",")));
        arrayList3.add(new bf("countrycode", com.xiaomi.push.service.a.a(a).b()));
        arrayList3.add(new bf("push_sdk_vc", String.valueOf(50005)));
        String b2 = b();
        cq c2 = c(b2);
        String format = String.format(Locale.US, "https://%1$s/gslb/?ver=5.0", b2);
        if (c2 == null) {
            arrayList2.add(format);
            synchronized (b) {
                cq cqVar = b.get(b2);
                if (cqVar != null) {
                    Iterator<String> it = cqVar.a(true).iterator();
                    while (it.hasNext()) {
                        arrayList2.add(String.format(Locale.US, "https://%1$s/gslb/?ver=5.0", it.next()));
                    }
                }
            }
        } else {
            arrayList2 = c2.a(format);
        }
        Iterator<String> it2 = arrayList2.iterator();
        IOException e = null;
        while (it2.hasNext()) {
            Uri.Builder buildUpon = Uri.parse(it2.next()).buildUpon();
            for (bh bhVar : arrayList3) {
                buildUpon.appendQueryParameter(bhVar.a(), bhVar.b());
            }
            try {
                return this.f195a == null ? bi.a(a, new URL(buildUpon.toString())) : this.f195a.a(buildUpon.toString());
            } catch (IOException e2) {
                e = e2;
            }
        }
        if (e == null) {
            return null;
        }
        com.xiaomi.channel.commonutils.logger.b.m180a("network exception: " + e.getMessage());
        throw e;
    }

    /* renamed from: a  reason: collision with other method in class */
    public JSONObject m346a() {
        JSONObject jSONObject;
        synchronized (this.f197a) {
            jSONObject = new JSONObject();
            jSONObject.put("ver", 2);
            JSONArray jSONArray = new JSONArray();
            for (cr crVar : this.f197a.values()) {
                jSONArray.put(crVar.m341a());
            }
            jSONObject.put("data", jSONArray);
            JSONArray jSONArray2 = new JSONArray();
            for (cq cqVar : b.values()) {
                jSONArray2.put(cqVar.m336a());
            }
            jSONObject.put(GestureAR.SDK_TO_LUA_GESTURE_RESULT_RESERVED, jSONArray2);
        }
        return jSONObject;
    }

    /* renamed from: a  reason: collision with other method in class */
    public void m347a() {
        synchronized (this.f197a) {
            this.f197a.clear();
        }
    }

    /* renamed from: a  reason: collision with other method in class */
    public void m348a(String str) {
        this.f199b = str;
    }

    public void a(String str, cq cqVar) {
        if (TextUtils.isEmpty(str) || cqVar == null) {
            throw new IllegalArgumentException("the argument is invalid " + str + StringUtil.ARRAY_ELEMENT_SEPARATOR + cqVar);
        } else if (this.f194a.a(str)) {
            synchronized (this.f197a) {
                m349a();
                if (this.f197a.containsKey(str)) {
                    this.f197a.get(str).a(cqVar);
                } else {
                    cr crVar = new cr(str);
                    crVar.a(cqVar);
                    this.f197a.put(str, crVar);
                }
            }
        }
    }

    /* renamed from: a  reason: collision with other method in class */
    public boolean m349a() {
        synchronized (this.f197a) {
            if (f192a) {
                return true;
            }
            f192a = true;
            this.f197a.clear();
            String d2 = d();
            if (TextUtils.isEmpty(d2)) {
                return false;
            }
            m351b(d2);
            com.xiaomi.channel.commonutils.logger.b.b("loading the new hosts succeed");
            return true;
        }
    }

    public cq b(String str) {
        return a(str, true);
    }

    public String b() {
        return "resolver.msg.xiaomi.net";
    }

    /* renamed from: b  reason: collision with other method in class */
    public void m350b() {
        ArrayList<String> arrayList;
        synchronized (this.f197a) {
            m349a();
            arrayList = new ArrayList<>(this.f197a.keySet());
            for (int size = arrayList.size() - 1; size >= 0; size--) {
                cr crVar = this.f197a.get(arrayList.get(size));
                if (crVar != null && crVar.a() != null) {
                    arrayList.remove(size);
                }
            }
        }
        ArrayList<cq> a2 = a(arrayList);
        for (int i = 0; i < arrayList.size(); i++) {
            if (a2.get(i) != null) {
                a(arrayList.get(i), a2.get(i));
            }
        }
    }

    /* renamed from: b  reason: collision with other method in class */
    public void m351b(String str) {
        synchronized (this.f197a) {
            this.f197a.clear();
            JSONObject jSONObject = new JSONObject(str);
            if (jSONObject.optInt("ver") != 2) {
                throw new JSONException("Bad version");
            }
            JSONArray optJSONArray = jSONObject.optJSONArray("data");
            if (optJSONArray != null) {
                for (int i = 0; i < optJSONArray.length(); i++) {
                    cr a2 = new cr().a(optJSONArray.getJSONObject(i));
                    this.f197a.put(a2.m339a(), a2);
                }
            }
            JSONArray optJSONArray2 = jSONObject.optJSONArray(GestureAR.SDK_TO_LUA_GESTURE_RESULT_RESERVED);
            if (optJSONArray2 != null) {
                for (int i2 = 0; i2 < optJSONArray2.length(); i2++) {
                    JSONObject jSONObject2 = optJSONArray2.getJSONObject(i2);
                    String optString = jSONObject2.optString("host");
                    if (!TextUtils.isEmpty(optString)) {
                        try {
                            cq a3 = new cq(optString).a(jSONObject2);
                            b.put(a3.f187b, a3);
                            com.xiaomi.channel.commonutils.logger.b.m180a("load local reserved host for " + a3.f187b);
                        } catch (JSONException unused) {
                            com.xiaomi.channel.commonutils.logger.b.m180a("parse reserved host fail.");
                        }
                    }
                }
            }
        }
    }

    public cq c(String str) {
        cr crVar;
        cq a2;
        synchronized (this.f197a) {
            m349a();
            crVar = this.f197a.get(str);
        }
        if (crVar == null || (a2 = crVar.a()) == null) {
            return null;
        }
        return a2;
    }

    public String c() {
        StringBuilder sb = new StringBuilder();
        synchronized (this.f197a) {
            for (Map.Entry<String, cr> entry : this.f197a.entrySet()) {
                sb.append(entry.getKey());
                sb.append(":\n");
                sb.append(entry.getValue().toString());
                sb.append("\n");
            }
        }
        return sb.toString();
    }

    /* renamed from: c  reason: collision with other method in class */
    public void m352c() {
        synchronized (this.f197a) {
            try {
                BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(a.openFileOutput(e(), 0)));
                String jSONObject = m346a().toString();
                if (!TextUtils.isEmpty(jSONObject)) {
                    bufferedWriter.write(jSONObject);
                }
                bufferedWriter.close();
            } catch (Exception e) {
                com.xiaomi.channel.commonutils.logger.b.m180a("persist bucket failure: " + e.getMessage());
            }
        }
    }

    public cq d(String str) {
        cq cqVar;
        synchronized (b) {
            cqVar = b.get(str);
        }
        return cqVar;
    }

    public String d() {
        BufferedReader bufferedReader;
        File file;
        try {
            file = new File(a.getFilesDir(), e());
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
                com.xiaomi.channel.commonutils.logger.b.m180a("load host exception " + th.getMessage());
                return null;
            } finally {
                y.a(bufferedReader);
            }
        }
    }

    /* renamed from: d  reason: collision with other method in class */
    public void m353d() {
        String next;
        synchronized (this.f197a) {
            for (cr crVar : this.f197a.values()) {
                crVar.a(true);
            }
            while (true) {
                for (boolean z = false; !z; z = true) {
                    Iterator<String> it = this.f197a.keySet().iterator();
                    while (it.hasNext()) {
                        next = it.next();
                        if (this.f197a.get(next).m340a().isEmpty()) {
                            break;
                        }
                    }
                }
                this.f197a.remove(next);
            }
        }
    }

    public cq e(String str) {
        if (System.currentTimeMillis() - this.f200c > this.f193a * 60 * 1000) {
            this.f200c = System.currentTimeMillis();
            ArrayList<String> arrayList = new ArrayList<>();
            arrayList.add(str);
            cq cqVar = a(arrayList).get(0);
            if (cqVar != null) {
                this.f193a = 0L;
                return cqVar;
            }
            long j = this.f193a;
            if (j < 15) {
                this.f193a = j + 1;
                return null;
            }
            return null;
        }
        return null;
    }

    public String e() {
        if ("com.xiaomi.xmsf".equals(c)) {
            return c;
        }
        return c + ":pushservice";
    }
}
