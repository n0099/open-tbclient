package com.xiaomi.push;

import com.baidu.searchbox.datachannel.Contract;
import com.meizu.cloud.pushsdk.constants.PushConstants;
import java.util.Iterator;
import java.util.LinkedList;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes8.dex */
class cz implements Comparable<cz> {
    protected int a;

    /* renamed from: a  reason: collision with other field name */
    private long f214a;

    /* renamed from: a  reason: collision with other field name */
    String f215a;

    /* renamed from: a  reason: collision with other field name */
    private final LinkedList<cp> f216a;

    public cz() {
        this(null, 0);
    }

    public cz(String str) {
        this(str, 0);
    }

    public cz(String str, int i) {
        this.f216a = new LinkedList<>();
        this.f214a = 0L;
        this.f215a = str;
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
        this.f214a = jSONObject.getLong(PushConstants.PUSH_NOTIFICATION_CREATE_TIMES_TAMP);
        this.a = jSONObject.getInt("wt");
        this.f215a = jSONObject.getString(Contract.SCHEME_KEY_HOST);
        JSONArray jSONArray = jSONObject.getJSONArray("ah");
        for (int i = 0; i < jSONArray.length(); i++) {
            this.f216a.add(new cp().a(jSONArray.getJSONObject(i)));
        }
        return this;
    }

    public synchronized JSONObject a() {
        JSONObject jSONObject;
        jSONObject = new JSONObject();
        jSONObject.put(PushConstants.PUSH_NOTIFICATION_CREATE_TIMES_TAMP, this.f214a);
        jSONObject.put("wt", this.a);
        jSONObject.put(Contract.SCHEME_KEY_HOST, this.f215a);
        JSONArray jSONArray = new JSONArray();
        Iterator<cp> it = this.f216a.iterator();
        while (it.hasNext()) {
            jSONArray.put(it.next().m196a());
        }
        jSONObject.put("ah", jSONArray);
        return jSONObject;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public synchronized void a(cp cpVar) {
        if (cpVar != null) {
            this.f216a.add(cpVar);
            int a = cpVar.a();
            if (a > 0) {
                this.a += cpVar.a();
            } else {
                int i = 0;
                for (int size = this.f216a.size() - 1; size >= 0 && this.f216a.get(size).a() < 0; size--) {
                    i++;
                }
                this.a += a * i;
            }
            if (this.f216a.size() > 30) {
                this.a -= this.f216a.remove().a();
            }
        }
    }

    public String toString() {
        return this.f215a + ":" + this.a;
    }
}
