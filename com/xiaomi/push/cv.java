package com.xiaomi.push;

import android.text.TextUtils;
import com.baidu.android.imsdk.db.TableDefine;
import com.baidu.live.tbadk.pagestayduration.PageStayDurationHelper;
import com.meizu.cloud.pushsdk.notification.model.TimeDisplaySetting;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes6.dex */
public class cv {

    /* renamed from: a  reason: collision with other field name */
    private long f260a;

    /* renamed from: a  reason: collision with other field name */
    public String f261a;

    /* renamed from: b  reason: collision with other field name */
    public String f263b;
    public String c;
    public String d;
    public String e;
    public String f;
    public String g;
    protected String h;
    private String i;

    /* renamed from: a  reason: collision with other field name */
    private ArrayList<de> f262a = new ArrayList<>();

    /* renamed from: a  reason: collision with root package name */
    private double f13925a = 0.1d;
    private String j = "s.mi1.cc";

    /* renamed from: b  reason: collision with root package name */
    private long f13926b = 86400000;

    public cv(String str) {
        this.f261a = "";
        if (TextUtils.isEmpty(str)) {
            throw new IllegalArgumentException("the host is empty");
        }
        this.f260a = System.currentTimeMillis();
        this.f262a.add(new de(str, -1));
        this.f261a = cz.m240a();
        this.f263b = str;
    }

    private synchronized void c(String str) {
        Iterator<de> it = this.f262a.iterator();
        while (it.hasNext()) {
            if (TextUtils.equals(it.next().f279a, str)) {
                it.remove();
            }
        }
    }

    public synchronized cv a(JSONObject jSONObject) {
        this.f261a = jSONObject.optString("net");
        this.f13926b = jSONObject.getLong("ttl");
        this.f13925a = jSONObject.getDouble("pct");
        this.f260a = jSONObject.getLong(TimeDisplaySetting.TIME_DISPLAY_SETTING);
        this.d = jSONObject.optString("city");
        this.c = jSONObject.optString("prv");
        this.g = jSONObject.optString("cty");
        this.e = jSONObject.optString("isp");
        this.f = jSONObject.optString(TableDefine.UserInfoColumns.COLUMN_IP);
        this.f263b = jSONObject.optString("host");
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
    public synchronized ArrayList<String> m231a() {
        return a(false);
    }

    public ArrayList<String> a(String str) {
        if (TextUtils.isEmpty(str)) {
            throw new IllegalArgumentException("the url is empty.");
        }
        URL url = new URL(str);
        if (TextUtils.equals(url.getHost(), this.f263b)) {
            ArrayList<String> arrayList = new ArrayList<>();
            Iterator<String> it = a(true).iterator();
            while (it.hasNext()) {
                cx a2 = cx.a(it.next(), url.getPort());
                arrayList.add(new URL(url.getProtocol(), a2.m239a(), a2.a(), url.getFile()).toString());
            }
            return arrayList;
        }
        throw new IllegalArgumentException("the url is not supported by the fallback");
    }

    public synchronized ArrayList<String> a(boolean z) {
        ArrayList<String> arrayList;
        synchronized (this) {
            de[] deVarArr = new de[this.f262a.size()];
            this.f262a.toArray(deVarArr);
            Arrays.sort(deVarArr);
            arrayList = new ArrayList<>();
            for (de deVar : deVarArr) {
                if (z) {
                    arrayList.add(deVar.f279a);
                } else {
                    int indexOf = deVar.f279a.indexOf(":");
                    if (indexOf != -1) {
                        arrayList.add(deVar.f279a.substring(0, indexOf));
                    } else {
                        arrayList.add(deVar.f279a);
                    }
                }
            }
        }
        return arrayList;
    }

    /* renamed from: a  reason: collision with other method in class */
    public synchronized JSONObject m232a() {
        JSONObject jSONObject;
        jSONObject = new JSONObject();
        jSONObject.put("net", this.f261a);
        jSONObject.put("ttl", this.f13926b);
        jSONObject.put("pct", this.f13925a);
        jSONObject.put(TimeDisplaySetting.TIME_DISPLAY_SETTING, this.f260a);
        jSONObject.put("city", this.d);
        jSONObject.put("prv", this.c);
        jSONObject.put("cty", this.g);
        jSONObject.put("isp", this.e);
        jSONObject.put(TableDefine.UserInfoColumns.COLUMN_IP, this.f);
        jSONObject.put("host", this.f263b);
        jSONObject.put("xf", this.h);
        JSONArray jSONArray = new JSONArray();
        Iterator<de> it = this.f262a.iterator();
        while (it.hasNext()) {
            jSONArray.put(it.next().a());
        }
        jSONObject.put("fbs", jSONArray);
        return jSONObject;
    }

    public void a(double d) {
        this.f13925a = d;
    }

    public void a(long j) {
        if (j <= 0) {
            throw new IllegalArgumentException("the duration is invalid " + j);
        }
        this.f13926b = j;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public synchronized void a(de deVar) {
        c(deVar.f279a);
        this.f262a.add(deVar);
    }

    /* renamed from: a  reason: collision with other method in class */
    public synchronized void m233a(String str) {
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
        Iterator<de> it = this.f262a.iterator();
        while (true) {
            if (!it.hasNext()) {
                break;
            }
            de next = it.next();
            if (TextUtils.equals(str, next.f279a)) {
                break;
            }
        }
    }

    public synchronized void a(String[] strArr) {
        for (int size = this.f262a.size() - 1; size >= 0; size--) {
            int length = strArr.length;
            int i = 0;
            while (true) {
                if (i < length) {
                    if (TextUtils.equals(this.f262a.get(size).f279a, strArr[i])) {
                        this.f262a.remove(size);
                        break;
                    }
                    i++;
                }
            }
        }
        Iterator<de> it = this.f262a.iterator();
        int i2 = 0;
        while (it.hasNext()) {
            de next = it.next();
            i2 = next.f13935a > i2 ? next.f13935a : i2;
        }
        for (int i3 = 0; i3 < strArr.length; i3++) {
            a(new de(strArr[i3], (strArr.length + i2) - i3));
        }
    }

    /* renamed from: a  reason: collision with other method in class */
    public boolean m234a() {
        return TextUtils.equals(this.f261a, cz.m240a());
    }

    public boolean a(cv cvVar) {
        return TextUtils.equals(this.f261a, cvVar.f261a);
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
        return System.currentTimeMillis() - this.f260a < this.f13926b;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean c() {
        long j = 864000000 < this.f13926b ? this.f13926b : 864000000L;
        long currentTimeMillis = System.currentTimeMillis();
        return currentTimeMillis - this.f260a > j || (currentTimeMillis - this.f260a > this.f13926b && this.f261a.startsWith("WIFI-"));
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(this.f261a);
        sb.append("\n");
        sb.append(a());
        Iterator<de> it = this.f262a.iterator();
        while (it.hasNext()) {
            sb.append("\n");
            sb.append(it.next().toString());
        }
        sb.append("\n");
        return sb.toString();
    }
}
