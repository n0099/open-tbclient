package com.xiaomi.push;

import android.text.TextUtils;
import java.util.ArrayList;
import java.util.Iterator;
import org.json.JSONArray;
import org.json.JSONObject;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes3.dex */
public class cr {
    private String a;

    /* renamed from: a  reason: collision with other field name */
    private final ArrayList<cq> f199a = new ArrayList<>();

    public cr() {
    }

    public cr(String str) {
        if (TextUtils.isEmpty(str)) {
            throw new IllegalArgumentException("the host is empty");
        }
        this.a = str;
    }

    /* JADX WARN: Code restructure failed: missing block: B:7:0x001a, code lost:
        com.xiaomi.push.cu.a().m193a(r0.a());
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public synchronized cq a() {
        cq cqVar;
        int size = this.f199a.size() - 1;
        while (true) {
            if (size < 0) {
                cqVar = null;
                break;
            }
            cqVar = this.f199a.get(size);
            if (cqVar.m183a()) {
                break;
            }
            size--;
        }
        return cqVar;
    }

    public synchronized cr a(JSONObject jSONObject) {
        this.a = jSONObject.getString("host");
        JSONArray jSONArray = jSONObject.getJSONArray("fbs");
        for (int i = 0; i < jSONArray.length(); i++) {
            this.f199a.add(new cq(this.a).a(jSONArray.getJSONObject(i)));
        }
        return this;
    }

    /* renamed from: a  reason: collision with other method in class */
    public String m184a() {
        return this.a;
    }

    /* renamed from: a  reason: collision with other method in class */
    public ArrayList<cq> m185a() {
        return this.f199a;
    }

    /* renamed from: a  reason: collision with other method in class */
    public synchronized JSONObject m186a() {
        JSONObject jSONObject;
        jSONObject = new JSONObject();
        jSONObject.put("host", this.a);
        JSONArray jSONArray = new JSONArray();
        Iterator<cq> it = this.f199a.iterator();
        while (it.hasNext()) {
            jSONArray.put(it.next().m181a());
        }
        jSONObject.put("fbs", jSONArray);
        return jSONObject;
    }

    public synchronized void a(cq cqVar) {
        int i;
        int i2 = 0;
        while (true) {
            i = i2;
            if (i >= this.f199a.size()) {
                break;
            } else if (this.f199a.get(i).a(cqVar)) {
                this.f199a.set(i, cqVar);
                break;
            } else {
                i2 = i + 1;
            }
        }
        if (i >= this.f199a.size()) {
            this.f199a.add(cqVar);
        }
    }

    public synchronized void a(boolean z) {
        for (int size = this.f199a.size() - 1; size >= 0; size--) {
            cq cqVar = this.f199a.get(size);
            if (z) {
                if (cqVar.c()) {
                    this.f199a.remove(size);
                }
            } else if (!cqVar.b()) {
                this.f199a.remove(size);
            }
        }
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(this.a);
        sb.append("\n");
        Iterator<cq> it = this.f199a.iterator();
        while (it.hasNext()) {
            sb.append(it.next());
        }
        return sb.toString();
    }
}
