package com.xiaomi.push;

import android.text.TextUtils;
import com.baidu.platform.comapi.map.MapBundleKey;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes10.dex */
public class cq {

    /* renamed from: a  reason: collision with other field name */
    public long f184a;

    /* renamed from: a  reason: collision with other field name */
    public String f185a;

    /* renamed from: b  reason: collision with other field name */
    public String f187b;
    public String c;
    public String d;
    public String e;
    public String f;
    public String g;
    public String h;
    public String i;

    /* renamed from: a  reason: collision with other field name */
    public ArrayList<cz> f186a = new ArrayList<>();
    public double a = 0.1d;
    public String j = "s.mi1.cc";
    public long b = 86400000;

    public cq(String str) {
        this.f185a = "";
        if (TextUtils.isEmpty(str)) {
            throw new IllegalArgumentException("the host is empty");
        }
        this.f184a = System.currentTimeMillis();
        this.f186a.add(new cz(str, -1));
        this.f185a = cu.m344a();
        this.f187b = str;
    }

    private synchronized void c(String str) {
        Iterator<cz> it = this.f186a.iterator();
        while (it.hasNext()) {
            if (TextUtils.equals(it.next().f203a, str)) {
                it.remove();
            }
        }
    }

    public synchronized cq a(JSONObject jSONObject) {
        this.f185a = jSONObject.optString("net");
        this.b = jSONObject.getLong("ttl");
        this.a = jSONObject.getDouble("pct");
        this.f184a = jSONObject.getLong("ts");
        this.d = jSONObject.optString("city");
        this.c = jSONObject.optString("prv");
        this.g = jSONObject.optString(MapBundleKey.OfflineMapKey.OFFLINE_CITY_TYPE);
        this.e = jSONObject.optString("isp");
        this.f = jSONObject.optString("ip");
        this.f187b = jSONObject.optString("host");
        this.h = jSONObject.optString("xf");
        JSONArray jSONArray = jSONObject.getJSONArray("fbs");
        for (int i = 0; i < jSONArray.length(); i++) {
            a(new cz().a(jSONArray.getJSONObject(i)));
        }
        return this;
    }

    public synchronized String a() {
        if (!TextUtils.isEmpty(this.i)) {
            return this.i;
        } else if (TextUtils.isEmpty(this.e)) {
            return "hardcode_isp";
        } else {
            String a = bo.a(new String[]{this.e, this.c, this.d, this.g, this.f}, "_");
            this.i = a;
            return a;
        }
    }

    /* renamed from: a  reason: collision with other method in class */
    public synchronized ArrayList<String> m335a() {
        return a(false);
    }

    public ArrayList<String> a(String str) {
        if (TextUtils.isEmpty(str)) {
            throw new IllegalArgumentException("the url is empty.");
        }
        URL url = new URL(str);
        if (TextUtils.equals(url.getHost(), this.f187b)) {
            ArrayList<String> arrayList = new ArrayList<>();
            Iterator<String> it = a(true).iterator();
            while (it.hasNext()) {
                cs a = cs.a(it.next(), url.getPort());
                arrayList.add(new URL(url.getProtocol(), a.m343a(), a.a(), url.getFile()).toString());
            }
            return arrayList;
        }
        throw new IllegalArgumentException("the url is not supported by the fallback");
    }

    public synchronized ArrayList<String> a(boolean z) {
        ArrayList<String> arrayList;
        String substring;
        int size = this.f186a.size();
        cz[] czVarArr = new cz[size];
        this.f186a.toArray(czVarArr);
        Arrays.sort(czVarArr);
        arrayList = new ArrayList<>();
        for (int i = 0; i < size; i++) {
            cz czVar = czVarArr[i];
            if (z) {
                substring = czVar.f203a;
            } else {
                int indexOf = czVar.f203a.indexOf(":");
                substring = indexOf != -1 ? czVar.f203a.substring(0, indexOf) : czVar.f203a;
            }
            arrayList.add(substring);
        }
        return arrayList;
    }

    /* renamed from: a  reason: collision with other method in class */
    public synchronized JSONObject m336a() {
        JSONObject jSONObject;
        jSONObject = new JSONObject();
        jSONObject.put("net", this.f185a);
        jSONObject.put("ttl", this.b);
        jSONObject.put("pct", this.a);
        jSONObject.put("ts", this.f184a);
        jSONObject.put("city", this.d);
        jSONObject.put("prv", this.c);
        jSONObject.put(MapBundleKey.OfflineMapKey.OFFLINE_CITY_TYPE, this.g);
        jSONObject.put("isp", this.e);
        jSONObject.put("ip", this.f);
        jSONObject.put("host", this.f187b);
        jSONObject.put("xf", this.h);
        JSONArray jSONArray = new JSONArray();
        Iterator<cz> it = this.f186a.iterator();
        while (it.hasNext()) {
            jSONArray.put(it.next().a());
        }
        jSONObject.put("fbs", jSONArray);
        return jSONObject;
    }

    public void a(double d) {
        this.a = d;
    }

    public void a(long j) {
        if (j > 0) {
            this.b = j;
            return;
        }
        throw new IllegalArgumentException("the duration is invalid " + j);
    }

    public synchronized void a(cz czVar) {
        c(czVar.f203a);
        this.f186a.add(czVar);
    }

    /* renamed from: a  reason: collision with other method in class */
    public synchronized void m337a(String str) {
        a(new cz(str));
    }

    public void a(String str, int i, long j, long j2, Exception exc) {
        a(str, new cp(i, j, j2, exc));
    }

    public void a(String str, long j, long j2) {
        try {
            b(new URL(str).getHost(), j, j2);
        } catch (MalformedURLException unused) {
        }
    }

    public void a(String str, long j, long j2, Exception exc) {
        try {
            b(new URL(str).getHost(), j, j2, exc);
        } catch (MalformedURLException unused) {
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:8:0x001b, code lost:
        r1.a(r5);
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public synchronized void a(String str, cp cpVar) {
        Iterator<cz> it = this.f186a.iterator();
        while (true) {
            if (!it.hasNext()) {
                break;
            }
            cz next = it.next();
            if (TextUtils.equals(str, next.f203a)) {
                break;
            }
        }
    }

    public synchronized void a(String[] strArr) {
        int i;
        int size = this.f186a.size() - 1;
        while (true) {
            i = 0;
            if (size < 0) {
                break;
            }
            int length = strArr.length;
            while (true) {
                if (i < length) {
                    if (TextUtils.equals(this.f186a.get(size).f203a, strArr[i])) {
                        this.f186a.remove(size);
                        break;
                    }
                    i++;
                }
            }
            size--;
        }
        Iterator<cz> it = this.f186a.iterator();
        int i2 = 0;
        while (it.hasNext()) {
            cz next = it.next();
            if (next.a > i2) {
                i2 = next.a;
            }
        }
        while (i < strArr.length) {
            a(new cz(strArr[i], (strArr.length + i2) - i));
            i++;
        }
    }

    /* renamed from: a  reason: collision with other method in class */
    public boolean m338a() {
        return TextUtils.equals(this.f185a, cu.m344a());
    }

    public boolean a(cq cqVar) {
        return TextUtils.equals(this.f185a, cqVar.f185a);
    }

    public void b(String str) {
        this.j = str;
    }

    public void b(String str, long j, long j2) {
        a(str, 0, j, j2, null);
    }

    public void b(String str, long j, long j2, Exception exc) {
        a(str, -1, j, j2, exc);
    }

    public boolean b() {
        return System.currentTimeMillis() - this.f184a < this.b;
    }

    public boolean c() {
        long j = this.b;
        if (864000000 >= j) {
            j = 864000000;
        }
        long currentTimeMillis = System.currentTimeMillis();
        long j2 = this.f184a;
        return currentTimeMillis - j2 > j || (currentTimeMillis - j2 > this.b && this.f185a.startsWith("WIFI-"));
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(this.f185a);
        sb.append("\n");
        sb.append(a());
        Iterator<cz> it = this.f186a.iterator();
        while (it.hasNext()) {
            sb.append("\n");
            sb.append(it.next().toString());
        }
        sb.append("\n");
        return sb.toString();
    }
}
