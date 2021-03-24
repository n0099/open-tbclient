package com.xiaomi.push;

import android.text.TextUtils;
import com.baidu.apollon.imagemanager.ImageLoader;
import com.meizu.cloud.pushsdk.notification.model.TimeDisplaySetting;
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
    public String f40326c;

    /* renamed from: d  reason: collision with root package name */
    public String f40327d;

    /* renamed from: e  reason: collision with root package name */
    public String f40328e;

    /* renamed from: f  reason: collision with root package name */
    public String f40329f;

    /* renamed from: g  reason: collision with root package name */
    public String f40330g;

    /* renamed from: h  reason: collision with root package name */
    public String f40331h;
    public String i;

    /* renamed from: a  reason: collision with other field name */
    public ArrayList<cx> f190a = new ArrayList<>();

    /* renamed from: a  reason: collision with root package name */
    public double f40324a = 0.1d;
    public String j = "s.mi1.cc";

    /* renamed from: b  reason: collision with root package name */
    public long f40325b = 86400000;

    public co(String str) {
        this.f189a = "";
        if (TextUtils.isEmpty(str)) {
            throw new IllegalArgumentException("the host is empty");
        }
        this.f188a = System.currentTimeMillis();
        this.f190a.add(new cx(str, -1));
        this.f189a = cs.m209a();
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
        this.f40325b = jSONObject.getLong("ttl");
        this.f40324a = jSONObject.getDouble("pct");
        this.f188a = jSONObject.getLong(TimeDisplaySetting.TIME_DISPLAY_SETTING);
        this.f40327d = jSONObject.optString("city");
        this.f40326c = jSONObject.optString("prv");
        this.f40330g = jSONObject.optString("cty");
        this.f40328e = jSONObject.optString("isp");
        this.f40329f = jSONObject.optString("ip");
        this.f191b = jSONObject.optString("host");
        this.f40331h = jSONObject.optString("xf");
        JSONArray jSONArray = jSONObject.getJSONArray("fbs");
        for (int i = 0; i < jSONArray.length(); i++) {
            a(new cx().a(jSONArray.getJSONObject(i)));
        }
        return this;
    }

    public synchronized String a() {
        if (!TextUtils.isEmpty(this.i)) {
            return this.i;
        } else if (TextUtils.isEmpty(this.f40328e)) {
            return "hardcode_isp";
        } else {
            String a2 = bm.a(new String[]{this.f40328e, this.f40326c, this.f40327d, this.f40330g, this.f40329f}, "_");
            this.i = a2;
            return a2;
        }
    }

    /* renamed from: a  reason: collision with other method in class */
    public synchronized ArrayList<String> m200a() {
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
                arrayList.add(new URL(url.getProtocol(), a2.m208a(), a2.a(), url.getFile()).toString());
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
        for (int i = 0; i < size; i++) {
            cx cxVar = cxVarArr[i];
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
    public synchronized JSONObject m201a() {
        JSONObject jSONObject;
        jSONObject = new JSONObject();
        jSONObject.put("net", this.f189a);
        jSONObject.put("ttl", this.f40325b);
        jSONObject.put("pct", this.f40324a);
        jSONObject.put(TimeDisplaySetting.TIME_DISPLAY_SETTING, this.f188a);
        jSONObject.put("city", this.f40327d);
        jSONObject.put("prv", this.f40326c);
        jSONObject.put("cty", this.f40330g);
        jSONObject.put("isp", this.f40328e);
        jSONObject.put("ip", this.f40329f);
        jSONObject.put("host", this.f191b);
        jSONObject.put("xf", this.f40331h);
        JSONArray jSONArray = new JSONArray();
        Iterator<cx> it = this.f190a.iterator();
        while (it.hasNext()) {
            jSONArray.put(it.next().a());
        }
        jSONObject.put("fbs", jSONArray);
        return jSONObject;
    }

    public void a(double d2) {
        this.f40324a = d2;
    }

    public void a(long j) {
        if (j > 0) {
            this.f40325b = j;
            return;
        }
        throw new IllegalArgumentException("the duration is invalid " + j);
    }

    public synchronized void a(cx cxVar) {
        c(cxVar.f207a);
        this.f190a.add(cxVar);
    }

    /* renamed from: a  reason: collision with other method in class */
    public synchronized void m202a(String str) {
        a(new cx(str));
    }

    public void a(String str, int i, long j, long j2, Exception exc) {
        a(str, new cn(i, j, j2, exc));
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
        int i;
        int size = this.f190a.size() - 1;
        while (true) {
            i = 0;
            if (size < 0) {
                break;
            }
            int length = strArr.length;
            while (true) {
                if (i < length) {
                    if (TextUtils.equals(this.f190a.get(size).f207a, strArr[i])) {
                        this.f190a.remove(size);
                        break;
                    }
                    i++;
                }
            }
            size--;
        }
        Iterator<cx> it = this.f190a.iterator();
        int i2 = 0;
        while (it.hasNext()) {
            cx next = it.next();
            if (next.f40342a > i2) {
                i2 = next.f40342a;
            }
        }
        while (i < strArr.length) {
            a(new cx(strArr[i], (strArr.length + i2) - i));
            i++;
        }
    }

    /* renamed from: a  reason: collision with other method in class */
    public boolean m203a() {
        return TextUtils.equals(this.f189a, cs.m209a());
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
        return System.currentTimeMillis() - this.f188a < this.f40325b;
    }

    public boolean c() {
        long j = this.f40325b;
        if (ImageLoader.f3672d >= j) {
            j = 864000000;
        }
        long currentTimeMillis = System.currentTimeMillis();
        long j2 = this.f188a;
        return currentTimeMillis - j2 > j || (currentTimeMillis - j2 > this.f40325b && this.f189a.startsWith("WIFI-"));
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
