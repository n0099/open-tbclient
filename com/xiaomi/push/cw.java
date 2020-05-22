package com.xiaomi.push;

import android.text.TextUtils;
import java.util.ArrayList;
import java.util.Iterator;
import org.json.JSONArray;
import org.json.JSONObject;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes8.dex */
public class cw {
    private String a;

    /* renamed from: a  reason: collision with other field name */
    private final ArrayList<cv> f184a = new ArrayList<>();

    public cw() {
    }

    public cw(String str) {
        if (TextUtils.isEmpty(str)) {
            throw new IllegalArgumentException("the host is empty");
        }
        this.a = str;
    }

    /* JADX WARN: Code restructure failed: missing block: B:7:0x001a, code lost:
        com.xiaomi.push.cz.a().m217a(r0.a());
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public synchronized cv a() {
        cv cvVar;
        int size = this.f184a.size() - 1;
        while (true) {
            if (size < 0) {
                cvVar = null;
                break;
            }
            cvVar = this.f184a.get(size);
            if (cvVar.m207a()) {
                break;
            }
            size--;
        }
        return cvVar;
    }

    public synchronized cw a(JSONObject jSONObject) {
        this.a = jSONObject.getString("host");
        JSONArray jSONArray = jSONObject.getJSONArray("fbs");
        for (int i = 0; i < jSONArray.length(); i++) {
            this.f184a.add(new cv(this.a).a(jSONArray.getJSONObject(i)));
        }
        return this;
    }

    /* renamed from: a  reason: collision with other method in class */
    public String m208a() {
        return this.a;
    }

    /* renamed from: a  reason: collision with other method in class */
    public ArrayList<cv> m209a() {
        return this.f184a;
    }

    /* renamed from: a  reason: collision with other method in class */
    public synchronized JSONObject m210a() {
        JSONObject jSONObject;
        jSONObject = new JSONObject();
        jSONObject.put("host", this.a);
        JSONArray jSONArray = new JSONArray();
        Iterator<cv> it = this.f184a.iterator();
        while (it.hasNext()) {
            jSONArray.put(it.next().m205a());
        }
        jSONObject.put("fbs", jSONArray);
        return jSONObject;
    }

    public synchronized void a(cv cvVar) {
        int i;
        int i2 = 0;
        while (true) {
            i = i2;
            if (i >= this.f184a.size()) {
                break;
            } else if (this.f184a.get(i).a(cvVar)) {
                this.f184a.set(i, cvVar);
                break;
            } else {
                i2 = i + 1;
            }
        }
        if (i >= this.f184a.size()) {
            this.f184a.add(cvVar);
        }
    }

    public synchronized void a(boolean z) {
        for (int size = this.f184a.size() - 1; size >= 0; size--) {
            cv cvVar = this.f184a.get(size);
            if (z) {
                if (cvVar.c()) {
                    this.f184a.remove(size);
                }
            } else if (!cvVar.b()) {
                this.f184a.remove(size);
            }
        }
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(this.a);
        sb.append("\n");
        Iterator<cv> it = this.f184a.iterator();
        while (it.hasNext()) {
            sb.append(it.next());
        }
        return sb.toString();
    }
}
