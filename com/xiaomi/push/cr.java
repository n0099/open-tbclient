package com.xiaomi.push;

import android.text.TextUtils;
import java.util.ArrayList;
import java.util.Iterator;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes10.dex */
public class cr {
    public String a;

    /* renamed from: a  reason: collision with other field name */
    public final ArrayList<cq> f183a = new ArrayList<>();

    public cr() {
    }

    public cr(String str) {
        if (TextUtils.isEmpty(str)) {
            throw new IllegalArgumentException("the host is empty");
        }
        this.a = str;
    }

    public synchronized cq a() {
        for (int size = this.f183a.size() - 1; size >= 0; size--) {
            cq cqVar = this.f183a.get(size);
            if (cqVar.m348a()) {
                cu.a().m358a(cqVar.a());
                return cqVar;
            }
        }
        return null;
    }

    public synchronized cr a(JSONObject jSONObject) {
        this.a = jSONObject.getString("host");
        JSONArray jSONArray = jSONObject.getJSONArray("fbs");
        for (int i = 0; i < jSONArray.length(); i++) {
            this.f183a.add(new cq(this.a).a(jSONArray.getJSONObject(i)));
        }
        return this;
    }

    /* renamed from: a  reason: collision with other method in class */
    public String m349a() {
        return this.a;
    }

    /* renamed from: a  reason: collision with other method in class */
    public ArrayList<cq> m350a() {
        return this.f183a;
    }

    /* renamed from: a  reason: collision with other method in class */
    public synchronized JSONObject m351a() {
        JSONObject jSONObject;
        jSONObject = new JSONObject();
        jSONObject.put("host", this.a);
        JSONArray jSONArray = new JSONArray();
        Iterator<cq> it = this.f183a.iterator();
        while (it.hasNext()) {
            jSONArray.put(it.next().m346a());
        }
        jSONObject.put("fbs", jSONArray);
        return jSONObject;
    }

    public synchronized void a(cq cqVar) {
        int i = 0;
        while (true) {
            if (i >= this.f183a.size()) {
                break;
            } else if (this.f183a.get(i).a(cqVar)) {
                this.f183a.set(i, cqVar);
                break;
            } else {
                i++;
            }
        }
        if (i >= this.f183a.size()) {
            this.f183a.add(cqVar);
        }
    }

    public synchronized void a(boolean z) {
        ArrayList<cq> arrayList;
        for (int size = this.f183a.size() - 1; size >= 0; size--) {
            cq cqVar = this.f183a.get(size);
            if (z) {
                if (cqVar.c()) {
                    arrayList = this.f183a;
                    arrayList.remove(size);
                }
            } else if (!cqVar.b()) {
                arrayList = this.f183a;
                arrayList.remove(size);
            }
        }
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(this.a);
        sb.append("\n");
        Iterator<cq> it = this.f183a.iterator();
        while (it.hasNext()) {
            sb.append(it.next());
        }
        return sb.toString();
    }
}
