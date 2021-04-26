package com.xiaomi.push;

import android.text.TextUtils;
import com.baidu.apollon.imagemanager.ImageLoader;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes7.dex */
public class co {

    /* renamed from: a  reason: collision with other field name */
    public long f188a;

    /* renamed from: a  reason: collision with other field name */
    public String f189a;

    /* renamed from: b  reason: collision with other field name */
    public String f191b;

    /* renamed from: c  reason: collision with root package name */
    public String f38227c;

    /* renamed from: d  reason: collision with root package name */
    public String f38228d;

    /* renamed from: e  reason: collision with root package name */
    public String f38229e;

    /* renamed from: f  reason: collision with root package name */
    public String f38230f;

    /* renamed from: g  reason: collision with root package name */
    public String f38231g;

    /* renamed from: h  reason: collision with root package name */
    public String f38232h;

    /* renamed from: i  reason: collision with root package name */
    public String f38233i;

    /* renamed from: a  reason: collision with other field name */
    public ArrayList<cx> f190a = new ArrayList<>();

    /* renamed from: a  reason: collision with root package name */
    public double f38225a = 0.1d;
    public String j = "s.mi1.cc";

    /* renamed from: b  reason: collision with root package name */
    public long f38226b = 86400000;

    public co(String str) {
        this.f189a = "";
        if (TextUtils.isEmpty(str)) {
            throw new IllegalArgumentException("the host is empty");
        }
        this.f188a = System.currentTimeMillis();
        this.f190a.add(new cx(str, -1));
        this.f189a = cs.m216a();
        this.f191b = str;
    }

    private synchronized void c(String str) {
        Iterator<cx> it = this.f190a.iterator();
        while (it.hasNext()) {
            if (TextUtils.equals(it.next().f207a, str)) {
                it.remove();
            }
        }
    }

    public synchronized co a(JSONObject jSONObject) {
        this.f189a = jSONObject.optString("net");
        this.f38226b = jSONObject.getLong("ttl");
        this.f38225a = jSONObject.getDouble("pct");
        this.f188a = jSONObject.getLong("ts");
        this.f38228d = jSONObject.optString("city");
        this.f38227c = jSONObject.optString("prv");
        this.f38231g = jSONObject.optString("cty");
        this.f38229e = jSONObject.optString("isp");
        this.f38230f = jSONObject.optString("ip");
        this.f191b = jSONObject.optString("host");
        this.f38232h = jSONObject.optString("xf");
        JSONArray jSONArray = jSONObject.getJSONArray("fbs");
        for (int i2 = 0; i2 < jSONArray.length(); i2++) {
            a(new cx().a(jSONArray.getJSONObject(i2)));
        }
        return this;
    }

    public synchronized String a() {
        if (!TextUtils.isEmpty(this.f38233i)) {
            return this.f38233i;
        } else if (TextUtils.isEmpty(this.f38229e)) {
            return "hardcode_isp";
        } else {
            String a2 = bm.a(new String[]{this.f38229e, this.f38227c, this.f38228d, this.f38231g, this.f38230f}, "_");
            this.f38233i = a2;
            return a2;
        }
    }

    /* renamed from: a  reason: collision with other method in class */
    public synchronized ArrayList<String> m207a() {
        return a(false);
    }

    public ArrayList<String> a(String str) {
        if (TextUtils.isEmpty(str)) {
            throw new IllegalArgumentException("the url is empty.");
        }
        URL url = new URL(str);
        if (TextUtils.equals(url.getHost(), this.f191b)) {
            ArrayList<String> arrayList = new ArrayList<>();
            Iterator<String> it = a(true).iterator();
            while (it.hasNext()) {
                cq a2 = cq.a(it.next(), url.getPort());
                arrayList.add(new URL(url.getProtocol(), a2.m215a(), a2.a(), url.getFile()).toString());
            }
            return arrayList;
        }
        throw new IllegalArgumentException("the url is not supported by the fallback");
    }

    public synchronized ArrayList<String> a(boolean z) {
        ArrayList<String> arrayList;
        String substring;
        int size = this.f190a.size();
        cx[] cxVarArr = new cx[size];
        this.f190a.toArray(cxVarArr);
        Arrays.sort(cxVarArr);
        arrayList = new ArrayList<>();
        for (int i2 = 0; i2 < size; i2++) {
            cx cxVar = cxVarArr[i2];
            if (z) {
                substring = cxVar.f207a;
            } else {
                int indexOf = cxVar.f207a.indexOf(":");
                substring = indexOf != -1 ? cxVar.f207a.substring(0, indexOf) : cxVar.f207a;
            }
            arrayList.add(substring);
        }
        return arrayList;
    }

    /* renamed from: a  reason: collision with other method in class */
    public synchronized JSONObject m208a() {
        JSONObject jSONObject;
        jSONObject = new JSONObject();
        jSONObject.put("net", this.f189a);
        jSONObject.put("ttl", this.f38226b);
        jSONObject.put("pct", this.f38225a);
        jSONObject.put("ts", this.f188a);
        jSONObject.put("city", this.f38228d);
        jSONObject.put("prv", this.f38227c);
        jSONObject.put("cty", this.f38231g);
        jSONObject.put("isp", this.f38229e);
        jSONObject.put("ip", this.f38230f);
        jSONObject.put("host", this.f191b);
        jSONObject.put("xf", this.f38232h);
        JSONArray jSONArray = new JSONArray();
        Iterator<cx> it = this.f190a.iterator();
        while (it.hasNext()) {
            jSONArray.put(it.next().a());
        }
        jSONObject.put("fbs", jSONArray);
        return jSONObject;
    }

    public void a(double d2) {
        this.f38225a = d2;
    }

    public void a(long j) {
        if (j > 0) {
            this.f38226b = j;
            return;
        }
        throw new IllegalArgumentException("the duration is invalid " + j);
    }

    public synchronized void a(cx cxVar) {
        c(cxVar.f207a);
        this.f190a.add(cxVar);
    }

    /* renamed from: a  reason: collision with other method in class */
    public synchronized void m209a(String str) {
        a(new cx(str));
    }

    public void a(String str, int i2, long j, long j2, Exception exc) {
        a(str, new cn(i2, j, j2, exc));
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
    public synchronized void a(String str, cn cnVar) {
        Iterator<cx> it = this.f190a.iterator();
        while (true) {
            if (!it.hasNext()) {
                break;
            }
            cx next = it.next();
            if (TextUtils.equals(str, next.f207a)) {
                break;
            }
        }
    }

    public synchronized void a(String[] strArr) {
        int i2;
        int size = this.f190a.size() - 1;
        while (true) {
            i2 = 0;
            if (size < 0) {
                break;
            }
            int length = strArr.length;
            while (true) {
                if (i2 < length) {
                    if (TextUtils.equals(this.f190a.get(size).f207a, strArr[i2])) {
                        this.f190a.remove(size);
                        break;
                    }
                    i2++;
                }
            }
            size--;
        }
        Iterator<cx> it = this.f190a.iterator();
        int i3 = 0;
        while (it.hasNext()) {
            cx next = it.next();
            if (next.f38244a > i3) {
                i3 = next.f38244a;
            }
        }
        while (i2 < strArr.length) {
            a(new cx(strArr[i2], (strArr.length + i3) - i2));
            i2++;
        }
    }

    /* renamed from: a  reason: collision with other method in class */
    public boolean m210a() {
        return TextUtils.equals(this.f189a, cs.m216a());
    }

    public boolean a(co coVar) {
        return TextUtils.equals(this.f189a, coVar.f189a);
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
        return System.currentTimeMillis() - this.f188a < this.f38226b;
    }

    public boolean c() {
        long j = this.f38226b;
        if (ImageLoader.f3754d >= j) {
            j = 864000000;
        }
        long currentTimeMillis = System.currentTimeMillis();
        long j2 = this.f188a;
        return currentTimeMillis - j2 > j || (currentTimeMillis - j2 > this.f38226b && this.f189a.startsWith("WIFI-"));
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(this.f189a);
        sb.append("\n");
        sb.append(a());
        Iterator<cx> it = this.f190a.iterator();
        while (it.hasNext()) {
            sb.append("\n");
            sb.append(it.next().toString());
        }
        sb.append("\n");
        return sb.toString();
    }
}
