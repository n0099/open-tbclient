package com.xiaomi.network;

import android.text.TextUtils;
import com.baidu.ar.util.SystemInfoUtil;
import com.meizu.cloud.pushsdk.notification.model.TimeDisplaySetting;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class Fallback {
    public String a;
    public String b;
    public String c;
    public String d;
    public String e;
    public String f;
    public String g;
    protected String h;
    private long i;
    private String k;
    private ArrayList<c> j = new ArrayList<>();
    private double l = 0.1d;
    private String m = "s.mi1.cc";
    private long n = 86400000;

    public Fallback(String str) {
        if (TextUtils.isEmpty(str)) {
            throw new IllegalArgumentException("the host is empty");
        }
        this.i = System.currentTimeMillis();
        this.j.add(new c(str, -1));
        this.a = HostManager.getInstance().getActiveNetworkLabel();
        this.b = str;
    }

    private synchronized void c(String str) {
        Iterator<c> it = this.j.iterator();
        while (it.hasNext()) {
            if (TextUtils.equals(it.next().a, str)) {
                it.remove();
            }
        }
    }

    public synchronized Fallback a(JSONObject jSONObject) {
        this.a = jSONObject.optString("net");
        this.n = jSONObject.getLong("ttl");
        this.l = jSONObject.getDouble("pct");
        this.i = jSONObject.getLong(TimeDisplaySetting.TIME_DISPLAY_SETTING);
        this.d = jSONObject.optString("city");
        this.c = jSONObject.optString("prv");
        this.g = jSONObject.optString("cty");
        this.e = jSONObject.optString("isp");
        this.f = jSONObject.optString("ip");
        this.b = jSONObject.optString("host");
        this.h = jSONObject.optString("xf");
        JSONArray jSONArray = jSONObject.getJSONArray("fbs");
        for (int i = 0; i < jSONArray.length(); i++) {
            a(new c().a(jSONArray.getJSONObject(i)));
        }
        return this;
    }

    public ArrayList<String> a(String str) {
        if (TextUtils.isEmpty(str)) {
            throw new IllegalArgumentException("the url is empty.");
        }
        URL url = new URL(str);
        if (TextUtils.equals(url.getHost(), this.b)) {
            ArrayList<String> arrayList = new ArrayList<>();
            Iterator<String> it = a(true).iterator();
            while (it.hasNext()) {
                Host a = Host.a(it.next(), url.getPort());
                arrayList.add(new URL(url.getProtocol(), a.b(), a.a(), url.getFile()).toString());
            }
            return arrayList;
        }
        throw new IllegalArgumentException("the url is not supported by the fallback");
    }

    public synchronized ArrayList<String> a(boolean z) {
        ArrayList<String> arrayList;
        synchronized (this) {
            c[] cVarArr = new c[this.j.size()];
            this.j.toArray(cVarArr);
            Arrays.sort(cVarArr);
            arrayList = new ArrayList<>();
            for (c cVar : cVarArr) {
                if (z) {
                    arrayList.add(cVar.a);
                } else {
                    int indexOf = cVar.a.indexOf(SystemInfoUtil.COLON);
                    if (indexOf != -1) {
                        arrayList.add(cVar.a.substring(0, indexOf));
                    } else {
                        arrayList.add(cVar.a);
                    }
                }
            }
        }
        return arrayList;
    }

    public void a(double d) {
        this.l = d;
    }

    public void a(long j) {
        if (j <= 0) {
            throw new IllegalArgumentException("the duration is invalid " + j);
        }
        this.n = j;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public synchronized void a(c cVar) {
        c(cVar.a);
        this.j.add(cVar);
    }

    public void a(String str, int i, long j, long j2, Exception exc) {
        a(str, new AccessHistory(i, j, j2, exc));
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
    public synchronized void a(String str, AccessHistory accessHistory) {
        Iterator<c> it = this.j.iterator();
        while (true) {
            if (!it.hasNext()) {
                break;
            }
            c next = it.next();
            if (TextUtils.equals(str, next.a)) {
                break;
            }
        }
    }

    public synchronized void a(String[] strArr) {
        for (int size = this.j.size() - 1; size >= 0; size--) {
            int length = strArr.length;
            int i = 0;
            while (true) {
                if (i < length) {
                    if (TextUtils.equals(this.j.get(size).a, strArr[i])) {
                        this.j.remove(size);
                        break;
                    }
                    i++;
                }
            }
        }
        Iterator<c> it = this.j.iterator();
        int i2 = 0;
        while (it.hasNext()) {
            c next = it.next();
            i2 = next.b > i2 ? next.b : i2;
        }
        for (int i3 = 0; i3 < strArr.length; i3++) {
            a(new c(strArr[i3], (strArr.length + i2) - i3));
        }
    }

    public boolean a() {
        return TextUtils.equals(this.a, HostManager.getInstance().getActiveNetworkLabel());
    }

    public boolean a(Fallback fallback) {
        return TextUtils.equals(this.a, fallback.a);
    }

    public void b(String str) {
        this.m = str;
    }

    public void b(String str, long j, long j2) {
        a(str, 0, j, j2, null);
    }

    public void b(String str, long j, long j2, Exception exc) {
        a(str, -1, j, j2, exc);
    }

    public boolean b() {
        return System.currentTimeMillis() - this.i < this.n;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean c() {
        long j = 864000000 < this.n ? this.n : 864000000L;
        long currentTimeMillis = System.currentTimeMillis();
        return currentTimeMillis - this.i > j || (currentTimeMillis - this.i > this.n && this.a.startsWith("WIFI-"));
    }

    public synchronized ArrayList<String> d() {
        return a(false);
    }

    public synchronized String e() {
        String str;
        if (!TextUtils.isEmpty(this.k)) {
            str = this.k;
        } else if (TextUtils.isEmpty(this.e)) {
            str = "hardcode_isp";
        } else {
            this.k = HostManager.join(new String[]{this.e, this.c, this.d, this.g, this.f}, "_");
            str = this.k;
        }
        return str;
    }

    public synchronized JSONObject f() {
        JSONObject jSONObject;
        jSONObject = new JSONObject();
        jSONObject.put("net", this.a);
        jSONObject.put("ttl", this.n);
        jSONObject.put("pct", this.l);
        jSONObject.put(TimeDisplaySetting.TIME_DISPLAY_SETTING, this.i);
        jSONObject.put("city", this.d);
        jSONObject.put("prv", this.c);
        jSONObject.put("cty", this.g);
        jSONObject.put("isp", this.e);
        jSONObject.put("ip", this.f);
        jSONObject.put("host", this.b);
        jSONObject.put("xf", this.h);
        JSONArray jSONArray = new JSONArray();
        Iterator<c> it = this.j.iterator();
        while (it.hasNext()) {
            jSONArray.put(it.next().a());
        }
        jSONObject.put("fbs", jSONArray);
        return jSONObject;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(this.a);
        sb.append("\n");
        sb.append(e());
        Iterator<c> it = this.j.iterator();
        while (it.hasNext()) {
            sb.append("\n");
            sb.append(it.next().toString());
        }
        sb.append("\n");
        return sb.toString();
    }
}
