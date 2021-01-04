package com.xiaomi.push;

import android.text.TextUtils;
import java.util.ArrayList;
import java.util.Iterator;
import org.json.JSONArray;
import org.json.JSONObject;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes6.dex */
public class cw {

    /* renamed from: a  reason: collision with root package name */
    private String f14224a;

    /* renamed from: a  reason: collision with other field name */
    private final ArrayList<cv> f264a = new ArrayList<>();

    public cw() {
    }

    public cw(String str) {
        if (TextUtils.isEmpty(str)) {
            throw new IllegalArgumentException("the host is empty");
        }
        this.f14224a = str;
    }

    /* JADX WARN: Code restructure failed: missing block: B:7:0x001a, code lost:
        com.xiaomi.push.cz.a().m238a(r0.a());
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public synchronized cv a() {
        cv cvVar;
        int size = this.f264a.size() - 1;
        while (true) {
            if (size < 0) {
                cvVar = null;
                break;
            }
            cvVar = this.f264a.get(size);
            if (cvVar.m228a()) {
                break;
            }
            size--;
        }
        return cvVar;
    }

    public synchronized cw a(JSONObject jSONObject) {
        this.f14224a = jSONObject.getString("host");
        JSONArray jSONArray = jSONObject.getJSONArray("fbs");
        for (int i = 0; i < jSONArray.length(); i++) {
            this.f264a.add(new cv(this.f14224a).a(jSONArray.getJSONObject(i)));
        }
        return this;
    }

    /* renamed from: a  reason: collision with other method in class */
    public String m229a() {
        return this.f14224a;
    }

    /* renamed from: a  reason: collision with other method in class */
    public ArrayList<cv> m230a() {
        return this.f264a;
    }

    /* renamed from: a  reason: collision with other method in class */
    public synchronized JSONObject m231a() {
        JSONObject jSONObject;
        jSONObject = new JSONObject();
        jSONObject.put("host", this.f14224a);
        JSONArray jSONArray = new JSONArray();
        Iterator<cv> it = this.f264a.iterator();
        while (it.hasNext()) {
            jSONArray.put(it.next().m226a());
        }
        jSONObject.put("fbs", jSONArray);
        return jSONObject;
    }

    public synchronized void a(cv cvVar) {
        int i;
        int i2 = 0;
        while (true) {
            i = i2;
            if (i >= this.f264a.size()) {
                break;
            } else if (this.f264a.get(i).a(cvVar)) {
                this.f264a.set(i, cvVar);
                break;
            } else {
                i2 = i + 1;
            }
        }
        if (i >= this.f264a.size()) {
            this.f264a.add(cvVar);
        }
    }

    public synchronized void a(boolean z) {
        for (int size = this.f264a.size() - 1; size >= 0; size--) {
            cv cvVar = this.f264a.get(size);
            if (z) {
                if (cvVar.c()) {
                    this.f264a.remove(size);
                }
            } else if (!cvVar.b()) {
                this.f264a.remove(size);
            }
        }
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(this.f14224a);
        sb.append("\n");
        Iterator<cv> it = this.f264a.iterator();
        while (it.hasNext()) {
            sb.append(it.next());
        }
        return sb.toString();
    }
}
