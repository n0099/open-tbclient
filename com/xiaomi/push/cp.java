package com.xiaomi.push;

import android.text.TextUtils;
import java.util.ArrayList;
import java.util.Iterator;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes7.dex */
public class cp {

    /* renamed from: a  reason: collision with root package name */
    public String f40622a;

    /* renamed from: a  reason: collision with other field name */
    public final ArrayList<co> f192a = new ArrayList<>();

    public cp() {
    }

    public cp(String str) {
        if (TextUtils.isEmpty(str)) {
            throw new IllegalArgumentException("the host is empty");
        }
        this.f40622a = str;
    }

    public synchronized co a() {
        for (int size = this.f192a.size() - 1; size >= 0; size--) {
            co coVar = this.f192a.get(size);
            if (coVar.m207a()) {
                cs.a().m217a(coVar.a());
                return coVar;
            }
        }
        return null;
    }

    public synchronized cp a(JSONObject jSONObject) {
        this.f40622a = jSONObject.getString("host");
        JSONArray jSONArray = jSONObject.getJSONArray("fbs");
        for (int i = 0; i < jSONArray.length(); i++) {
            this.f192a.add(new co(this.f40622a).a(jSONArray.getJSONObject(i)));
        }
        return this;
    }

    /* renamed from: a  reason: collision with other method in class */
    public String m208a() {
        return this.f40622a;
    }

    /* renamed from: a  reason: collision with other method in class */
    public ArrayList<co> m209a() {
        return this.f192a;
    }

    /* renamed from: a  reason: collision with other method in class */
    public synchronized JSONObject m210a() {
        JSONObject jSONObject;
        jSONObject = new JSONObject();
        jSONObject.put("host", this.f40622a);
        JSONArray jSONArray = new JSONArray();
        Iterator<co> it = this.f192a.iterator();
        while (it.hasNext()) {
            jSONArray.put(it.next().m205a());
        }
        jSONObject.put("fbs", jSONArray);
        return jSONObject;
    }

    public synchronized void a(co coVar) {
        int i = 0;
        while (true) {
            if (i >= this.f192a.size()) {
                break;
            } else if (this.f192a.get(i).a(coVar)) {
                this.f192a.set(i, coVar);
                break;
            } else {
                i++;
            }
        }
        if (i >= this.f192a.size()) {
            this.f192a.add(coVar);
        }
    }

    public synchronized void a(boolean z) {
        ArrayList<co> arrayList;
        for (int size = this.f192a.size() - 1; size >= 0; size--) {
            co coVar = this.f192a.get(size);
            if (z) {
                if (coVar.c()) {
                    arrayList = this.f192a;
                    arrayList.remove(size);
                }
            } else if (!coVar.b()) {
                arrayList = this.f192a;
                arrayList.remove(size);
            }
        }
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(this.f40622a);
        sb.append("\n");
        Iterator<co> it = this.f192a.iterator();
        while (it.hasNext()) {
            sb.append(it.next());
        }
        return sb.toString();
    }
}
