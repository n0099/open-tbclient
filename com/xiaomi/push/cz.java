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
    private long f217a;

    /* renamed from: a  reason: collision with other field name */
    String f218a;

    /* renamed from: a  reason: collision with other field name */
    private final LinkedList<cp> f219a;

    public cz() {
        this(null, 0);
    }

    public cz(String str) {
        this(str, 0);
    }

    public cz(String str, int i) {
        this.f219a = new LinkedList<>();
        this.f217a = 0L;
        this.f218a = str;
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
        this.f217a = jSONObject.getLong(PushConstants.PUSH_NOTIFICATION_CREATE_TIMES_TAMP);
        this.a = jSONObject.getInt("wt");
        this.f218a = jSONObject.getString(Contract.SCHEME_KEY_HOST);
        JSONArray jSONArray = jSONObject.getJSONArray("ah");
        for (int i = 0; i < jSONArray.length(); i++) {
            this.f219a.add(new cp().a(jSONArray.getJSONObject(i)));
        }
        return this;
    }

    public synchronized JSONObject a() {
        JSONObject jSONObject;
        jSONObject = new JSONObject();
        jSONObject.put(PushConstants.PUSH_NOTIFICATION_CREATE_TIMES_TAMP, this.f217a);
        jSONObject.put("wt", this.a);
        jSONObject.put(Contract.SCHEME_KEY_HOST, this.f218a);
        JSONArray jSONArray = new JSONArray();
        Iterator<cp> it = this.f219a.iterator();
        while (it.hasNext()) {
            jSONArray.put(it.next().m191a());
        }
        jSONObject.put("ah", jSONArray);
        return jSONObject;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public synchronized void a(cp cpVar) {
        if (cpVar != null) {
            this.f219a.add(cpVar);
            int a = cpVar.a();
            if (a > 0) {
                this.a += cpVar.a();
            } else {
                int i = 0;
                for (int size = this.f219a.size() - 1; size >= 0 && this.f219a.get(size).a() < 0; size--) {
                    i++;
                }
                this.a += a * i;
            }
            if (this.f219a.size() > 30) {
                this.a -= this.f219a.remove().a();
            }
        }
    }

    public String toString() {
        return this.f218a + ":" + this.a;
    }
}
