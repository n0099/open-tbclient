package com.xiaomi.push;

import java.util.Iterator;
import java.util.LinkedList;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes10.dex */
public class cz implements Comparable<cz> {
    public int a;

    /* renamed from: a  reason: collision with other field name */
    public long f197a;

    /* renamed from: a  reason: collision with other field name */
    public String f198a;

    /* renamed from: a  reason: collision with other field name */
    public final LinkedList<cp> f199a;

    public cz() {
        this(null, 0);
    }

    public cz(String str) {
        this(str, 0);
    }

    public cz(String str, int i) {
        this.f199a = new LinkedList<>();
        this.f197a = 0L;
        this.f198a = str;
        this.a = i;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // java.lang.Comparable
    /* renamed from: a */
    public int compareTo(cz czVar) {
        if (czVar == null) {
            return 1;
        }
        return czVar.a - this.a;
    }

    public synchronized cz a(JSONObject jSONObject) {
        this.f197a = jSONObject.getLong("tt");
        this.a = jSONObject.getInt("wt");
        this.f198a = jSONObject.getString("host");
        JSONArray jSONArray = jSONObject.getJSONArray("ah");
        for (int i = 0; i < jSONArray.length(); i++) {
            this.f199a.add(new cp().a(jSONArray.getJSONObject(i)));
        }
        return this;
    }

    public synchronized JSONObject a() {
        JSONObject jSONObject;
        jSONObject = new JSONObject();
        jSONObject.put("tt", this.f197a);
        jSONObject.put("wt", this.a);
        jSONObject.put("host", this.f198a);
        JSONArray jSONArray = new JSONArray();
        Iterator<cp> it = this.f199a.iterator();
        while (it.hasNext()) {
            jSONArray.put(it.next().m344a());
        }
        jSONObject.put("ah", jSONArray);
        return jSONObject;
    }

    public synchronized void a(cp cpVar) {
        if (cpVar != null) {
            this.f199a.add(cpVar);
            int a = cpVar.a();
            if (a > 0) {
                this.a += cpVar.a();
            } else {
                int i = 0;
                for (int size = this.f199a.size() - 1; size >= 0 && this.f199a.get(size).a() < 0; size--) {
                    i++;
                }
                this.a += a * i;
            }
            if (this.f199a.size() > 30) {
                this.a -= this.f199a.remove().a();
            }
        }
    }

    public String toString() {
        return this.f198a + ":" + this.a;
    }
}
