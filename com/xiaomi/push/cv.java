package com.xiaomi.push;

import android.text.TextUtils;
import com.baidu.android.imsdk.db.TableDefine;
import com.baidu.live.tbadk.pagestayduration.PageStayDurationHelper;
import com.baidu.platform.comapi.map.MapBundleKey;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes18.dex */
public class cv {

    /* renamed from: a  reason: collision with other field name */
    private long f184a;

    /* renamed from: a  reason: collision with other field name */
    public String f185a;

    /* renamed from: b  reason: collision with other field name */
    public String f187b;
    public String c;
    public String d;
    public String e;
    public String f;
    public String g;
    protected String h;
    private String i;

    /* renamed from: a  reason: collision with other field name */
    private ArrayList<de> f186a = new ArrayList<>();

    /* renamed from: a  reason: collision with root package name */
    private double f4845a = 0.1d;
    private String j = "s.mi1.cc";
    private long b = 86400000;

    public cv(String str) {
        this.f185a = "";
        if (TextUtils.isEmpty(str)) {
            throw new IllegalArgumentException("the host is empty");
        }
        this.f184a = System.currentTimeMillis();
        this.f186a.add(new de(str, -1));
        this.f185a = cz.m218a();
        this.f187b = str;
    }

    private synchronized void c(String str) {
        Iterator<de> it = this.f186a.iterator();
        while (it.hasNext()) {
            if (TextUtils.equals(it.next().f203a, str)) {
                it.remove();
            }
        }
    }

    public synchronized cv a(JSONObject jSONObject) {
        this.f185a = jSONObject.optString("net");
        this.b = jSONObject.getLong("ttl");
        this.f4845a = jSONObject.getDouble("pct");
        this.f184a = jSONObject.getLong("ts");
        this.d = jSONObject.optString("city");
        this.c = jSONObject.optString("prv");
        this.g = jSONObject.optString(MapBundleKey.OfflineMapKey.OFFLINE_CITY_TYPE);
        this.e = jSONObject.optString("isp");
        this.f = jSONObject.optString(TableDefine.UserInfoColumns.COLUMN_IP);
        this.f187b = jSONObject.optString("host");
        this.h = jSONObject.optString("xf");
        JSONArray jSONArray = jSONObject.getJSONArray("fbs");
        for (int i = 0; i < jSONArray.length(); i++) {
            a(new de().a(jSONArray.getJSONObject(i)));
        }
        return this;
    }

    public synchronized String a() {
        String str;
        if (!TextUtils.isEmpty(this.i)) {
            str = this.i;
        } else if (TextUtils.isEmpty(this.e)) {
            str = "hardcode_isp";
        } else {
            this.i = bf.a(new String[]{this.e, this.c, this.d, this.g, this.f}, PageStayDurationHelper.STAT_SOURCE_TRACE_CONNECTORS);
            str = this.i;
        }
        return str;
    }

    /* renamed from: a  reason: collision with other method in class */
    public synchronized ArrayList<String> m209a() {
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
                cx a2 = cx.a(it.next(), url.getPort());
                arrayList.add(new URL(url.getProtocol(), a2.m217a(), a2.a(), url.getFile()).toString());
            }
            return arrayList;
        }
        throw new IllegalArgumentException("the url is not supported by the fallback");
    }

    public synchronized ArrayList<String> a(boolean z) {
        ArrayList<String> arrayList;
        synchronized (this) {
            de[] deVarArr = new de[this.f186a.size()];
            this.f186a.toArray(deVarArr);
            Arrays.sort(deVarArr);
            arrayList = new ArrayList<>();
            for (de deVar : deVarArr) {
                if (z) {
                    arrayList.add(deVar.f203a);
                } else {
                    int indexOf = deVar.f203a.indexOf(":");
                    if (indexOf != -1) {
                        arrayList.add(deVar.f203a.substring(0, indexOf));
                    } else {
                        arrayList.add(deVar.f203a);
                    }
                }
            }
        }
        return arrayList;
    }

    /* renamed from: a  reason: collision with other method in class */
    public synchronized JSONObject m210a() {
        JSONObject jSONObject;
        jSONObject = new JSONObject();
        jSONObject.put("net", this.f185a);
        jSONObject.put("ttl", this.b);
        jSONObject.put("pct", this.f4845a);
        jSONObject.put("ts", this.f184a);
        jSONObject.put("city", this.d);
        jSONObject.put("prv", this.c);
        jSONObject.put(MapBundleKey.OfflineMapKey.OFFLINE_CITY_TYPE, this.g);
        jSONObject.put("isp", this.e);
        jSONObject.put(TableDefine.UserInfoColumns.COLUMN_IP, this.f);
        jSONObject.put("host", this.f187b);
        jSONObject.put("xf", this.h);
        JSONArray jSONArray = new JSONArray();
        Iterator<de> it = this.f186a.iterator();
        while (it.hasNext()) {
            jSONArray.put(it.next().a());
        }
        jSONObject.put("fbs", jSONArray);
        return jSONObject;
    }

    public void a(double d) {
        this.f4845a = d;
    }

    public void a(long j) {
        if (j <= 0) {
            throw new IllegalArgumentException("the duration is invalid " + j);
        }
        this.b = j;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public synchronized void a(de deVar) {
        c(deVar.f203a);
        this.f186a.add(deVar);
    }

    /* renamed from: a  reason: collision with other method in class */
    public synchronized void m211a(String str) {
        a(new de(str));
    }

    public void a(String str, int i, long j, long j2, Exception exc) {
        a(str, new cu(i, j, j2, exc));
    }

    public void a(String str, long j, long j2) {
        try {
            b(new URL(str).getHost(), j, j2);
        } catch (MalformedURLException e) {
        }
    }

    public void a(String str, long j, long j2, Exception exc) {
        try {
            b(new URL(str).getHost(), j, j2, exc);
        } catch (MalformedURLException e) {
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:8:0x001b, code lost:
        r0.a(r5);
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public synchronized void a(String str, cu cuVar) {
        Iterator<de> it = this.f186a.iterator();
        while (true) {
            if (!it.hasNext()) {
                break;
            }
            de next = it.next();
            if (TextUtils.equals(str, next.f203a)) {
                break;
            }
        }
    }

    public synchronized void a(String[] strArr) {
        for (int size = this.f186a.size() - 1; size >= 0; size--) {
            int length = strArr.length;
            int i = 0;
            while (true) {
                if (i < length) {
                    if (TextUtils.equals(this.f186a.get(size).f203a, strArr[i])) {
                        this.f186a.remove(size);
                        break;
                    }
                    i++;
                }
            }
        }
        Iterator<de> it = this.f186a.iterator();
        int i2 = 0;
        while (it.hasNext()) {
            de next = it.next();
            i2 = next.f4852a > i2 ? next.f4852a : i2;
        }
        for (int i3 = 0; i3 < strArr.length; i3++) {
            a(new de(strArr[i3], (strArr.length + i2) - i3));
        }
    }

    /* renamed from: a  reason: collision with other method in class */
    public boolean m212a() {
        return TextUtils.equals(this.f185a, cz.m218a());
    }

    public boolean a(cv cvVar) {
        return TextUtils.equals(this.f185a, cvVar.f185a);
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

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean c() {
        long j = 864000000 < this.b ? this.b : 864000000L;
        long currentTimeMillis = System.currentTimeMillis();
        return currentTimeMillis - this.f184a > j || (currentTimeMillis - this.f184a > this.b && this.f185a.startsWith("WIFI-"));
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(this.f185a);
        sb.append("\n");
        sb.append(a());
        Iterator<de> it = this.f186a.iterator();
        while (it.hasNext()) {
            sb.append("\n");
            sb.append(it.next().toString());
        }
        sb.append("\n");
        return sb.toString();
    }
}
