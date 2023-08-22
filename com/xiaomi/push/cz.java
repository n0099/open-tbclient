package com.xiaomi.push;

import java.util.Iterator;
import java.util.LinkedList;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes10.dex */
public class cz implements Comparable<cz> {
    public int a;

    /* renamed from: a  reason: collision with other field name */
    public long f202a;

    /* renamed from: a  reason: collision with other field name */
    public String f203a;

    /* renamed from: a  reason: collision with other field name */
    public final LinkedList<cp> f204a;

    public cz() {
        this(null, 0);
    }

    public cz(String str) {
        this(str, 0);
    }

    public cz(String str, int i) {
        this.f204a = new LinkedList<>();
        this.f202a = 0L;
        this.f203a = str;
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
        this.f202a = jSONObject.getLong("tt");
        this.a = jSONObject.getInt("wt");
        this.f203a = jSONObject.getString("host");
        JSONArray jSONArray = jSONObject.getJSONArray("ah");
        for (int i = 0; i < jSONArray.length(); i++) {
            this.f204a.add(new cp().a(jSONArray.getJSONObject(i)));
        }
        return this;
    }

    public synchronized JSONObject a() {
        JSONObject jSONObject;
        jSONObject = new JSONObject();
        jSONObject.put("tt", this.f202a);
        jSONObject.put("wt", this.a);
        jSONObject.put("host", this.f203a);
        JSONArray jSONArray = new JSONArray();
        Iterator<cp> it = this.f204a.iterator();
        while (it.hasNext()) {
            jSONArray.put(it.next().m334a());
        }
        jSONObject.put("ah", jSONArray);
        return jSONObject;
    }

    public synchronized void a(cp cpVar) {
        if (cpVar != null) {
            this.f204a.add(cpVar);
            int a = cpVar.a();
            if (a > 0) {
                this.a += cpVar.a();
            } else {
                int i = 0;
                for (int size = this.f204a.size() - 1; size >= 0 && this.f204a.get(size).a() < 0; size--) {
                    i++;
                }
                this.a += a * i;
            }
            if (this.f204a.size() > 30) {
                this.a -= this.f204a.remove().a();
            }
        }
    }

    public String toString() {
        return this.f203a + ":" + this.a;
    }
}
