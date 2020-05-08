package com.xiaomi.push;

import com.meizu.cloud.pushsdk.constants.PushConstants;
import java.util.Iterator;
import java.util.LinkedList;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes8.dex */
class de implements Comparable<de> {
    protected int a;

    /* renamed from: a  reason: collision with other field name */
    private long f198a;

    /* renamed from: a  reason: collision with other field name */
    String f199a;

    /* renamed from: a  reason: collision with other field name */
    private final LinkedList<cu> f200a;

    public de() {
        this(null, 0);
    }

    public de(String str) {
        this(str, 0);
    }

    public de(String str, int i) {
        this.f200a = new LinkedList<>();
        this.f198a = 0L;
        this.f199a = str;
        this.a = i;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // java.lang.Comparable
    /* renamed from: a */
    public int compareTo(de deVar) {
        if (deVar == null) {
            return 1;
        }
        return deVar.a - this.a;
    }

    public synchronized de a(JSONObject jSONObject) {
        this.f198a = jSONObject.getLong(PushConstants.PUSH_NOTIFICATION_CREATE_TIMES_TAMP);
        this.a = jSONObject.getInt("wt");
        this.f199a = jSONObject.getString("host");
        JSONArray jSONArray = jSONObject.getJSONArray("ah");
        for (int i = 0; i < jSONArray.length(); i++) {
            this.f200a.add(new cu().a(jSONArray.getJSONObject(i)));
        }
        return this;
    }

    public synchronized JSONObject a() {
        JSONObject jSONObject;
        jSONObject = new JSONObject();
        jSONObject.put(PushConstants.PUSH_NOTIFICATION_CREATE_TIMES_TAMP, this.f198a);
        jSONObject.put("wt", this.a);
        jSONObject.put("host", this.f199a);
        JSONArray jSONArray = new JSONArray();
        Iterator<cu> it = this.f200a.iterator();
        while (it.hasNext()) {
            jSONArray.put(it.next().m201a());
        }
        jSONObject.put("ah", jSONArray);
        return jSONObject;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public synchronized void a(cu cuVar) {
        if (cuVar != null) {
            this.f200a.add(cuVar);
            int a = cuVar.a();
            if (a > 0) {
                this.a += cuVar.a();
            } else {
                int i = 0;
                for (int size = this.f200a.size() - 1; size >= 0 && this.f200a.get(size).a() < 0; size--) {
                    i++;
                }
                this.a += a * i;
            }
            if (this.f200a.size() > 30) {
                this.a -= this.f200a.remove().a();
            }
        }
    }

    public String toString() {
        return this.f199a + ":" + this.a;
    }
}
