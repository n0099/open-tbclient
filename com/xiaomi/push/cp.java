package com.xiaomi.push;

import android.text.TextUtils;
import java.util.ArrayList;
import java.util.Iterator;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes7.dex */
public class cp {

    /* renamed from: a  reason: collision with root package name */
    public String f41087a;

    /* renamed from: a  reason: collision with other field name */
    public final ArrayList<co> f192a = new ArrayList<>();

    public cp() {
    }

    public cp(String str) {
        if (TextUtils.isEmpty(str)) {
            throw new IllegalArgumentException("the host is empty");
        }
        this.f41087a = str;
    }

    public synchronized co a() {
        for (int size = this.f192a.size() - 1; size >= 0; size--) {
            co coVar = this.f192a.get(size);
            if (coVar.m208a()) {
                cs.a().m218a(coVar.a());
                return coVar;
            }
        }
        return null;
    }

    public synchronized cp a(JSONObject jSONObject) {
        this.f41087a = jSONObject.getString("host");
        JSONArray jSONArray = jSONObject.getJSONArray("fbs");
        for (int i2 = 0; i2 < jSONArray.length(); i2++) {
            this.f192a.add(new co(this.f41087a).a(jSONArray.getJSONObject(i2)));
        }
        return this;
    }

    /* renamed from: a  reason: collision with other method in class */
    public String m209a() {
        return this.f41087a;
    }

    /* renamed from: a  reason: collision with other method in class */
    public ArrayList<co> m210a() {
        return this.f192a;
    }

    /* renamed from: a  reason: collision with other method in class */
    public synchronized JSONObject m211a() {
        JSONObject jSONObject;
        jSONObject = new JSONObject();
        jSONObject.put("host", this.f41087a);
        JSONArray jSONArray = new JSONArray();
        Iterator<co> it = this.f192a.iterator();
        while (it.hasNext()) {
            jSONArray.put(it.next().m206a());
        }
        jSONObject.put("fbs", jSONArray);
        return jSONObject;
    }

    public synchronized void a(co coVar) {
        int i2 = 0;
        while (true) {
            if (i2 >= this.f192a.size()) {
                break;
            } else if (this.f192a.get(i2).a(coVar)) {
                this.f192a.set(i2, coVar);
                break;
            } else {
                i2++;
            }
        }
        if (i2 >= this.f192a.size()) {
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
        sb.append(this.f41087a);
        sb.append("\n");
        Iterator<co> it = this.f192a.iterator();
        while (it.hasNext()) {
            sb.append(it.next());
        }
        return sb.toString();
    }
}
