package com.xiaomi.push;

import com.baidu.searchbox.datachannel.Contract;
import com.meizu.cloud.pushsdk.constants.PushConstants;
import java.util.Iterator;
import java.util.LinkedList;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes6.dex */
class cz implements Comparable<cz> {
    protected int a;

    /* renamed from: a  reason: collision with other field name */
    private long f216a;

    /* renamed from: a  reason: collision with other field name */
    String f217a;

    /* renamed from: a  reason: collision with other field name */
    private final LinkedList<cp> f218a;

    public cz() {
        this(null, 0);
    }

    public cz(String str) {
        this(str, 0);
    }

    public cz(String str, int i) {
        this.f218a = new LinkedList<>();
        this.f216a = 0L;
        this.f217a = str;
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
        this.f216a = jSONObject.getLong(PushConstants.PUSH_NOTIFICATION_CREATE_TIMES_TAMP);
        this.a = jSONObject.getInt("wt");
        this.f217a = jSONObject.getString(Contract.SCHEME_KEY_HOST);
        JSONArray jSONArray = jSONObject.getJSONArray("ah");
        for (int i = 0; i < jSONArray.length(); i++) {
            this.f218a.add(new cp().a(jSONArray.getJSONObject(i)));
        }
        return this;
    }

    public synchronized JSONObject a() {
        JSONObject jSONObject;
        jSONObject = new JSONObject();
        jSONObject.put(PushConstants.PUSH_NOTIFICATION_CREATE_TIMES_TAMP, this.f216a);
        jSONObject.put("wt", this.a);
        jSONObject.put(Contract.SCHEME_KEY_HOST, this.f217a);
        JSONArray jSONArray = new JSONArray();
        Iterator<cp> it = this.f218a.iterator();
        while (it.hasNext()) {
            jSONArray.put(it.next().m191a());
        }
        jSONObject.put("ah", jSONArray);
        return jSONObject;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public synchronized void a(cp cpVar) {
        if (cpVar != null) {
            this.f218a.add(cpVar);
            int a = cpVar.a();
            if (a > 0) {
                this.a += cpVar.a();
            } else {
                int i = 0;
                for (int size = this.f218a.size() - 1; size >= 0 && this.f218a.get(size).a() < 0; size--) {
                    i++;
                }
                this.a += a * i;
            }
            if (this.f218a.size() > 30) {
                this.a -= this.f218a.remove().a();
            }
        }
    }

    public String toString() {
        return this.f217a + ":" + this.a;
    }
}
