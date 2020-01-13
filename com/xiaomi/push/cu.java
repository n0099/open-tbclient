package com.xiaomi.push;

import android.app.ActivityManager;
import android.content.Context;
import android.content.pm.PackageInfo;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.Uri;
import android.net.wifi.WifiManager;
import android.os.Process;
import android.support.media.ExifInterface;
import android.text.TextUtils;
import com.baidu.android.imsdk.db.TableDefine;
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
public class cu {
    protected static Context a;

    /* renamed from: a  reason: collision with other field name */
    private static a f204a;

    /* renamed from: a  reason: collision with other field name */
    private static cu f205a;
    private static String c;
    private static String d;

    /* renamed from: a  reason: collision with other field name */
    private long f207a;

    /* renamed from: a  reason: collision with other field name */
    private ct f208a;

    /* renamed from: a  reason: collision with other field name */
    protected b f209a;

    /* renamed from: a  reason: collision with other field name */
    private String f210a;

    /* renamed from: a  reason: collision with other field name */
    protected Map<String, cr> f211a;

    /* renamed from: b  reason: collision with other field name */
    private final long f212b;

    /* renamed from: b  reason: collision with other field name */
    private String f213b;

    /* renamed from: c  reason: collision with other field name */
    private long f214c;
    protected static Map<String, cq> b = new HashMap();

    /* renamed from: a  reason: collision with other field name */
    protected static boolean f206a = false;

    /* loaded from: classes6.dex */
    public interface a {
        cu a(Context context, ct ctVar, b bVar, String str);
    }

    /* loaded from: classes6.dex */
    public interface b {
        String a(String str);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public cu(Context context, ct ctVar, b bVar, String str) {
        this(context, ctVar, bVar, str, null, null);
    }

    protected cu(Context context, ct ctVar, b bVar, String str, String str2, String str3) {
        this.f211a = new HashMap();
        this.f210a = "0";
        this.f207a = 0L;
        this.f212b = 15L;
        this.f214c = 0L;
        this.f213b = "isp_prov_city_country_ip";
        this.f209a = bVar;
        if (ctVar == null) {
            this.f208a = new cv(this);
        } else {
            this.f208a = ctVar;
        }
        this.f210a = str;
        c = str2 == null ? context.getPackageName() : str2;
        d = str3 == null ? f() : str3;
    }

    public static synchronized cu a() {
        cu cuVar;
        synchronized (cu.class) {
            if (f205a == null) {
                throw new IllegalStateException("the host manager is not initialized yet.");
            }
            cuVar = f205a;
        }
        return cuVar;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:22:0x007c -> B:23:0x0007). Please submit an issue!!! */
    /* renamed from: a  reason: collision with other method in class */
    public static String m201a() {
        String str;
        ConnectivityManager connectivityManager;
        if (a == null) {
            return "unknown";
        }
        try {
            connectivityManager = (ConnectivityManager) a.getSystemService("connectivity");
        } catch (Throwable th) {
        }
        if (connectivityManager == null) {
            str = "unknown";
        } else {
            NetworkInfo activeNetworkInfo = connectivityManager.getActiveNetworkInfo();
            if (activeNetworkInfo == null) {
                str = "unknown";
            } else if (activeNetworkInfo.getType() == 1) {
                WifiManager wifiManager = (WifiManager) a.getSystemService("wifi");
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

    private ArrayList<cq> a(ArrayList<String> arrayList) {
        m210d();
        synchronized (this.f211a) {
            m206a();
            for (String str : this.f211a.keySet()) {
                if (!arrayList.contains(str)) {
                    arrayList.add(str);
                }
            }
        }
        boolean isEmpty = b.isEmpty();
        synchronized (b) {
            Object[] array = b.values().toArray();
            int length = array.length;
            int i = 0;
            while (i < length) {
                cq cqVar = (cq) array[i];
                if (!cqVar.b()) {
                    isEmpty = true;
                    b.remove(cqVar.f201b);
                }
                i++;
                isEmpty = isEmpty;
            }
        }
        if (!arrayList.contains(b())) {
            arrayList.add(b());
        }
        ArrayList<cq> arrayList2 = new ArrayList<>(arrayList.size());
        for (int i2 = 0; i2 < arrayList.size(); i2++) {
            arrayList2.add(null);
        }
        try {
            String str2 = as.d(a) ? "wifi" : "wap";
            String a2 = a(arrayList, str2, this.f210a, isEmpty);
            if (!TextUtils.isEmpty(a2)) {
                JSONObject jSONObject = new JSONObject(a2);
                com.xiaomi.channel.commonutils.logger.b.b(a2);
                if ("OK".equalsIgnoreCase(jSONObject.getString(ExifInterface.LATITUDE_SOUTH))) {
                    JSONObject jSONObject2 = jSONObject.getJSONObject("R");
                    String string = jSONObject2.getString("province");
                    String string2 = jSONObject2.getString("city");
                    String string3 = jSONObject2.getString("isp");
                    String string4 = jSONObject2.getString(TableDefine.UserInfoColumns.COLUMN_IP);
                    String string5 = jSONObject2.getString("country");
                    JSONObject jSONObject3 = jSONObject2.getJSONObject(str2);
                    com.xiaomi.channel.commonutils.logger.b.c("get bucket: ip = " + string4 + " net = " + string3 + " hosts = " + jSONObject3.toString());
                    for (int i3 = 0; i3 < arrayList.size(); i3++) {
                        String str3 = arrayList.get(i3);
                        JSONArray optJSONArray = jSONObject3.optJSONArray(str3);
                        if (optJSONArray == null) {
                            com.xiaomi.channel.commonutils.logger.b.m42a("no bucket found for " + str3);
                        } else {
                            cq cqVar2 = new cq(str3);
                            for (int i4 = 0; i4 < optJSONArray.length(); i4++) {
                                String string6 = optJSONArray.getString(i4);
                                if (!TextUtils.isEmpty(string6)) {
                                    cqVar2.a(new cz(string6, optJSONArray.length() - i4));
                                }
                            }
                            arrayList2.set(i3, cqVar2);
                            cqVar2.g = string5;
                            cqVar2.c = string;
                            cqVar2.e = string3;
                            cqVar2.f = string4;
                            cqVar2.d = string2;
                            if (jSONObject2.has("stat-percent")) {
                                cqVar2.a(jSONObject2.getDouble("stat-percent"));
                            }
                            if (jSONObject2.has("stat-domain")) {
                                cqVar2.b(jSONObject2.getString("stat-domain"));
                            }
                            if (jSONObject2.has("ttl")) {
                                cqVar2.a(jSONObject2.getInt("ttl") * 1000);
                            }
                            m205a(cqVar2.a());
                        }
                    }
                    JSONObject optJSONObject = jSONObject2.optJSONObject("reserved");
                    if (optJSONObject != null) {
                        long j = jSONObject2.has("reserved-ttl") ? jSONObject2.getInt("reserved-ttl") * 1000 : 604800000L;
                        Iterator<String> keys = optJSONObject.keys();
                        while (keys.hasNext()) {
                            String next = keys.next();
                            JSONArray optJSONArray2 = optJSONObject.optJSONArray(next);
                            if (optJSONArray2 == null) {
                                com.xiaomi.channel.commonutils.logger.b.m42a("no bucket found for " + next);
                            } else {
                                cq cqVar3 = new cq(next);
                                cqVar3.a(j);
                                for (int i5 = 0; i5 < optJSONArray2.length(); i5++) {
                                    String string7 = optJSONArray2.getString(i5);
                                    if (!TextUtils.isEmpty(string7)) {
                                        cqVar3.a(new cz(string7, optJSONArray2.length() - i5));
                                    }
                                }
                                synchronized (b) {
                                    if (this.f208a.a(next)) {
                                        b.put(next, cqVar3);
                                    }
                                }
                            }
                        }
                    }
                }
            }
        } catch (Exception e) {
            com.xiaomi.channel.commonutils.logger.b.m42a("failed to get bucket " + e.getMessage());
        }
        int i6 = 0;
        while (true) {
            int i7 = i6;
            if (i7 >= arrayList.size()) {
                m209c();
                return arrayList2;
            }
            cq cqVar4 = arrayList2.get(i7);
            if (cqVar4 != null) {
                a(arrayList.get(i7), cqVar4);
            }
            i6 = i7 + 1;
        }
    }

    public static synchronized void a(Context context, ct ctVar, b bVar, String str, String str2, String str3) {
        synchronized (cu.class) {
            a = context.getApplicationContext();
            if (a == null) {
                a = context;
            }
            if (f205a == null) {
                if (f204a == null) {
                    f205a = new cu(context, ctVar, bVar, str, str2, str3);
                } else {
                    f205a = f204a.a(context, ctVar, bVar, str);
                }
            }
        }
    }

    public static synchronized void a(a aVar) {
        synchronized (cu.class) {
            f204a = aVar;
            f205a = null;
        }
    }

    public static void a(String str, String str2) {
        cq cqVar = b.get(str);
        synchronized (b) {
            if (cqVar == null) {
                cq cqVar2 = new cq(str);
                cqVar2.a(604800000L);
                cqVar2.m194a(str2);
                b.put(str, cqVar2);
            } else {
                cqVar.m194a(str2);
            }
        }
    }

    private String f() {
        try {
            PackageInfo packageInfo = a.getPackageManager().getPackageInfo(a.getPackageName(), 16384);
            if (packageInfo != null) {
                return packageInfo.versionName;
            }
        } catch (Exception e) {
        }
        return "0";
    }

    /* renamed from: a  reason: collision with other method in class */
    public cq m202a(String str) {
        if (TextUtils.isEmpty(str)) {
            throw new IllegalArgumentException("the url is empty");
        }
        return a(new URL(str).getHost(), true);
    }

    public cq a(String str, boolean z) {
        cq d2;
        if (TextUtils.isEmpty(str)) {
            throw new IllegalArgumentException("the host is empty");
        }
        if (this.f208a.a(str)) {
            cq c2 = c(str);
            return (c2 == null || !c2.b()) ? (z && as.b(a) && (d2 = d(str)) != null) ? d2 : new cw(this, str, c2) : c2;
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public String a(ArrayList<String> arrayList, String str, String str2, boolean z) {
        ArrayList<String> a2;
        String str3 = null;
        ArrayList<String> arrayList2 = new ArrayList<>();
        ArrayList<ar> arrayList3 = new ArrayList();
        arrayList3.add(new ap("type", str));
        if (str.equals("wap")) {
            arrayList3.add(new ap("conpt", a(as.m127a(a))));
        }
        if (z) {
            arrayList3.add(new ap("reserved", "1"));
        }
        arrayList3.add(new ap("uuid", str2));
        arrayList3.add(new ap("list", ay.a(arrayList, Constants.ACCEPT_TIME_SEPARATOR_SP)));
        arrayList3.add(new ap("countrycode", com.xiaomi.push.service.a.a(a).b()));
        cq c2 = c(b());
        String format = String.format(Locale.US, "http://%1$s/gslb/?ver=4.0", b());
        if (c2 == null) {
            arrayList2.add(format);
            synchronized (b) {
                cq cqVar = b.get("resolver.msg.xiaomi.net");
                if (cqVar != null) {
                    Iterator<String> it = cqVar.a(true).iterator();
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
            for (ar arVar : arrayList3) {
                buildUpon.appendQueryParameter(arVar.a(), arVar.b());
            }
            try {
                str3 = this.f209a == null ? as.a(a, new URL(buildUpon.toString())) : this.f209a.a(buildUpon.toString());
                return str3;
            } catch (IOException e2) {
                e = e2;
            }
        }
        if (e != null) {
            com.xiaomi.channel.commonutils.logger.b.m42a("network exception: " + e.getMessage());
            throw e;
        }
        return str3;
    }

    /* renamed from: a  reason: collision with other method in class */
    protected JSONObject m203a() {
        JSONObject jSONObject;
        synchronized (this.f211a) {
            jSONObject = new JSONObject();
            jSONObject.put("ver", 2);
            JSONArray jSONArray = new JSONArray();
            for (cr crVar : this.f211a.values()) {
                jSONArray.put(crVar.m198a());
            }
            jSONObject.put("data", jSONArray);
            JSONArray jSONArray2 = new JSONArray();
            for (cq cqVar : b.values()) {
                jSONArray2.put(cqVar.m193a());
            }
            jSONObject.put("reserved", jSONArray2);
        }
        return jSONObject;
    }

    /* renamed from: a  reason: collision with other method in class */
    public void m204a() {
        synchronized (this.f211a) {
            this.f211a.clear();
        }
    }

    /* renamed from: a  reason: collision with other method in class */
    public void m205a(String str) {
        this.f213b = str;
    }

    public void a(String str, cq cqVar) {
        if (TextUtils.isEmpty(str) || cqVar == null) {
            throw new IllegalArgumentException("the argument is invalid " + str + ", " + cqVar);
        }
        if (this.f208a.a(str)) {
            synchronized (this.f211a) {
                m206a();
                if (this.f211a.containsKey(str)) {
                    this.f211a.get(str).a(cqVar);
                } else {
                    cr crVar = new cr(str);
                    crVar.a(cqVar);
                    this.f211a.put(str, crVar);
                }
            }
        }
    }

    /* renamed from: a  reason: collision with other method in class */
    protected boolean m206a() {
        synchronized (this.f211a) {
            if (f206a) {
                return true;
            }
            f206a = true;
            this.f211a.clear();
            String d2 = d();
            if (TextUtils.isEmpty(d2)) {
                return false;
            }
            m208b(d2);
            com.xiaomi.channel.commonutils.logger.b.b("loading the new hosts succeed");
            return true;
        }
    }

    public cq b(String str) {
        return a(str, true);
    }

    protected String b() {
        String a2 = com.xiaomi.push.service.a.a(a).a();
        return (TextUtils.isEmpty(a2) || PushChannelRegion.China.name().equals(a2)) ? "resolver.msg.xiaomi.net" : "resolver.msg.global.xiaomi.net";
    }

    /* renamed from: b  reason: collision with other method in class */
    public void m207b() {
        ArrayList<String> arrayList;
        synchronized (this.f211a) {
            m206a();
            arrayList = new ArrayList<>(this.f211a.keySet());
            for (int size = arrayList.size() - 1; size >= 0; size--) {
                cr crVar = this.f211a.get(arrayList.get(size));
                if (crVar != null && crVar.a() != null) {
                    arrayList.remove(size);
                }
            }
        }
        ArrayList<cq> a2 = a(arrayList);
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
    protected void m208b(String str) {
        synchronized (this.f211a) {
            this.f211a.clear();
            JSONObject jSONObject = new JSONObject(str);
            if (jSONObject.optInt("ver") != 2) {
                throw new JSONException("Bad version");
            }
            JSONArray optJSONArray = jSONObject.optJSONArray("data");
            for (int i = 0; i < optJSONArray.length(); i++) {
                cr a2 = new cr().a(optJSONArray.getJSONObject(i));
                this.f211a.put(a2.m196a(), a2);
            }
            JSONArray optJSONArray2 = jSONObject.optJSONArray("reserved");
            for (int i2 = 0; i2 < optJSONArray2.length(); i2++) {
                cq a3 = new cq("").a(optJSONArray2.getJSONObject(i2));
                b.put(a3.f201b, a3);
            }
        }
    }

    protected cq c(String str) {
        cr crVar;
        cq a2;
        synchronized (this.f211a) {
            m206a();
            crVar = this.f211a.get(str);
        }
        if (crVar == null || (a2 = crVar.a()) == null) {
            return null;
        }
        return a2;
    }

    public String c() {
        StringBuilder sb = new StringBuilder();
        synchronized (this.f211a) {
            for (Map.Entry<String, cr> entry : this.f211a.entrySet()) {
                sb.append(entry.getKey());
                sb.append(":\n");
                sb.append(entry.getValue().toString());
                sb.append("\n");
            }
        }
        return sb.toString();
    }

    /* renamed from: c  reason: collision with other method in class */
    public void m209c() {
        synchronized (this.f211a) {
            try {
                BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(a.openFileOutput(e(), 0)));
                String jSONObject = m203a().toString();
                if (!TextUtils.isEmpty(jSONObject)) {
                    bufferedWriter.write(jSONObject);
                }
                bufferedWriter.close();
            } catch (Exception e) {
                com.xiaomi.channel.commonutils.logger.b.m42a("persist bucket failure: " + e.getMessage());
            }
        }
    }

    protected cq d(String str) {
        if (System.currentTimeMillis() - this.f214c > this.f207a * 60 * 1000) {
            this.f214c = System.currentTimeMillis();
            ArrayList<String> arrayList = new ArrayList<>();
            arrayList.add(str);
            cq cqVar = a(arrayList).get(0);
            if (cqVar != null) {
                this.f207a = 0L;
                return cqVar;
            } else if (this.f207a < 15) {
                this.f207a++;
            }
        }
        return null;
    }

    protected String d() {
        BufferedReader bufferedReader;
        String str = null;
        try {
            File file = new File(a.getFilesDir(), e());
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
                } catch (Throwable th) {
                    th = th;
                    try {
                        com.xiaomi.channel.commonutils.logger.b.m42a("load host exception " + th.getMessage());
                        return str;
                    } finally {
                        y.a(bufferedReader);
                    }
                }
            } else {
                y.a((Closeable) null);
            }
        } catch (Throwable th2) {
            th = th2;
            bufferedReader = null;
        }
        return str;
    }

    /* renamed from: d  reason: collision with other method in class */
    public void m210d() {
        synchronized (this.f211a) {
            for (cr crVar : this.f211a.values()) {
                crVar.a(true);
            }
            boolean z = false;
            while (!z) {
                Iterator<String> it = this.f211a.keySet().iterator();
                while (true) {
                    if (!it.hasNext()) {
                        z = true;
                        break;
                    }
                    String next = it.next();
                    if (this.f211a.get(next).m197a().isEmpty()) {
                        this.f211a.remove(next);
                        z = false;
                        break;
                    }
                }
            }
        }
    }

    protected String e() {
        List<ActivityManager.RunningAppProcessInfo> runningAppProcesses = ((ActivityManager) a.getSystemService(PushConstants.INTENT_ACTIVITY_NAME)).getRunningAppProcesses();
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
