package com.xiaomi.push;

import android.text.TextUtils;
import com.baidu.android.imsdk.db.TableDefine;
import com.baidu.live.tbadk.pagestayduration.PageStayDurationHelper;
import com.baidu.searchbox.datachannel.Contract;
import com.meizu.cloud.pushsdk.notification.model.TimeDisplaySetting;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes6.dex */
public class cq {

    /* renamed from: a  reason: collision with other field name */
    private long f198a;

    /* renamed from: a  reason: collision with other field name */
    public String f199a;

    /* renamed from: b  reason: collision with other field name */
    public String f201b;
    public String c;
    public String d;
    public String e;
    public String f;
    public String g;
    protected String h;
    private String i;

    /* renamed from: a  reason: collision with other field name */
    private ArrayList<cz> f200a = new ArrayList<>();
    private double a = 0.1d;
    private String j = "s.mi1.cc";
    private long b = 86400000;

    public cq(String str) {
        this.f199a = "";
        if (TextUtils.isEmpty(str)) {
            throw new IllegalArgumentException("the host is empty");
        }
        this.f198a = System.currentTimeMillis();
        this.f200a.add(new cz(str, -1));
        this.f199a = cu.m201a();
        this.f201b = str;
    }

    private synchronized void c(String str) {
        Iterator<cz> it = this.f200a.iterator();
        while (it.hasNext()) {
            if (TextUtils.equals(it.next().f217a, str)) {
                it.remove();
            }
        }
    }

    public synchronized cq a(JSONObject jSONObject) {
        this.f199a = jSONObject.optString("net");
        this.b = jSONObject.getLong("ttl");
        this.a = jSONObject.getDouble("pct");
        this.f198a = jSONObject.getLong(TimeDisplaySetting.TIME_DISPLAY_SETTING);
        this.d = jSONObject.optString("city");
        this.c = jSONObject.optString("prv");
        this.g = jSONObject.optString("cty");
        this.e = jSONObject.optString("isp");
        this.f = jSONObject.optString(TableDefine.UserInfoColumns.COLUMN_IP);
        this.f201b = jSONObject.optString(Contract.SCHEME_KEY_HOST);
        this.h = jSONObject.optString("xf");
        JSONArray jSONArray = jSONObject.getJSONArray("fbs");
        for (int i = 0; i < jSONArray.length(); i++) {
            a(new cz().a(jSONArray.getJSONObject(i)));
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
            this.i = ay.a(new String[]{this.e, this.c, this.d, this.g, this.f}, PageStayDurationHelper.STAT_SOURCE_TRACE_CONNECTORS);
            str = this.i;
        }
        return str;
    }

    /* renamed from: a  reason: collision with other method in class */
    public synchronized ArrayList<String> m192a() {
        return a(false);
    }

    public ArrayList<String> a(String str) {
        if (TextUtils.isEmpty(str)) {
            throw new IllegalArgumentException("the url is empty.");
        }
        URL url = new URL(str);
        if (TextUtils.equals(url.getHost(), this.f201b)) {
            ArrayList<String> arrayList = new ArrayList<>();
            Iterator<String> it = a(true).iterator();
            while (it.hasNext()) {
                cs a = cs.a(it.next(), url.getPort());
                arrayList.add(new URL(url.getProtocol(), a.m200a(), a.a(), url.getFile()).toString());
            }
            return arrayList;
        }
        throw new IllegalArgumentException("the url is not supported by the fallback");
    }

    public synchronized ArrayList<String> a(boolean z) {
        ArrayList<String> arrayList;
        synchronized (this) {
            cz[] czVarArr = new cz[this.f200a.size()];
            this.f200a.toArray(czVarArr);
            Arrays.sort(czVarArr);
            arrayList = new ArrayList<>();
            for (cz czVar : czVarArr) {
                if (z) {
                    arrayList.add(czVar.f217a);
                } else {
                    int indexOf = czVar.f217a.indexOf(":");
                    if (indexOf != -1) {
                        arrayList.add(czVar.f217a.substring(0, indexOf));
                    } else {
                        arrayList.add(czVar.f217a);
                    }
                }
            }
        }
        return arrayList;
    }

    /* renamed from: a  reason: collision with other method in class */
    public synchronized JSONObject m193a() {
        JSONObject jSONObject;
        jSONObject = new JSONObject();
        jSONObject.put("net", this.f199a);
        jSONObject.put("ttl", this.b);
        jSONObject.put("pct", this.a);
        jSONObject.put(TimeDisplaySetting.TIME_DISPLAY_SETTING, this.f198a);
        jSONObject.put("city", this.d);
        jSONObject.put("prv", this.c);
        jSONObject.put("cty", this.g);
        jSONObject.put("isp", this.e);
        jSONObject.put(TableDefine.UserInfoColumns.COLUMN_IP, this.f);
        jSONObject.put(Contract.SCHEME_KEY_HOST, this.f201b);
        jSONObject.put("xf", this.h);
        JSONArray jSONArray = new JSONArray();
        Iterator<cz> it = this.f200a.iterator();
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
        if (j <= 0) {
            throw new IllegalArgumentException("the duration is invalid " + j);
        }
        this.b = j;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public synchronized void a(cz czVar) {
        c(czVar.f217a);
        this.f200a.add(czVar);
    }

    /* renamed from: a  reason: collision with other method in class */
    public synchronized void m194a(String str) {
        a(new cz(str));
    }

    public void a(String str, int i, long j, long j2, Exception exc) {
        a(str, new cp(i, j, j2, exc));
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
    public synchronized void a(String str, cp cpVar) {
        Iterator<cz> it = this.f200a.iterator();
        while (true) {
            if (!it.hasNext()) {
                break;
            }
            cz next = it.next();
            if (TextUtils.equals(str, next.f217a)) {
                break;
            }
        }
    }

    public synchronized void a(String[] strArr) {
        for (int size = this.f200a.size() - 1; size >= 0; size--) {
            int length = strArr.length;
            int i = 0;
            while (true) {
                if (i < length) {
                    if (TextUtils.equals(this.f200a.get(size).f217a, strArr[i])) {
                        this.f200a.remove(size);
                        break;
                    }
                    i++;
                }
            }
        }
        Iterator<cz> it = this.f200a.iterator();
        int i2 = 0;
        while (it.hasNext()) {
            cz next = it.next();
            i2 = next.a > i2 ? next.a : i2;
        }
        for (int i3 = 0; i3 < strArr.length; i3++) {
            a(new cz(strArr[i3], (strArr.length + i2) - i3));
        }
    }

    /* renamed from: a  reason: collision with other method in class */
    public boolean m195a() {
        return TextUtils.equals(this.f199a, cu.m201a());
    }

    public boolean a(cq cqVar) {
        return TextUtils.equals(this.f199a, cqVar.f199a);
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
        return System.currentTimeMillis() - this.f198a < this.b;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean c() {
        long j = 864000000 < this.b ? this.b : 864000000L;
        long currentTimeMillis = System.currentTimeMillis();
        return currentTimeMillis - this.f198a > j || (currentTimeMillis - this.f198a > this.b && this.f199a.startsWith("WIFI-"));
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(this.f199a);
        sb.append("\n");
        sb.append(a());
        Iterator<cz> it = this.f200a.iterator();
        while (it.hasNext()) {
            sb.append("\n");
            sb.append(it.next().toString());
        }
        sb.append("\n");
        return sb.toString();
    }
}
