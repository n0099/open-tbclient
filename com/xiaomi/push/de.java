package com.xiaomi.push;

import com.meizu.cloud.pushsdk.constants.PushConstants;
import java.util.Iterator;
import java.util.LinkedList;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes9.dex */
class de implements Comparable<de> {
    protected int a;

    /* renamed from: a  reason: collision with other field name */
    private long f204a;

    /* renamed from: a  reason: collision with other field name */
    String f205a;

    /* renamed from: a  reason: collision with other field name */
    private final LinkedList<cu> f206a;

    public de() {
        this(null, 0);
    }

    public de(String str) {
        this(str, 0);
    }

    public de(String str, int i) {
        this.f206a = new LinkedList<>();
        this.f204a = 0L;
        this.f205a = str;
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
        this.f204a = jSONObject.getLong(PushConstants.PUSH_NOTIFICATION_CREATE_TIMES_TAMP);
        this.a = jSONObject.getInt("wt");
        this.f205a = jSONObject.getString("host");
        JSONArray jSONArray = jSONObject.getJSONArray("ah");
        for (int i = 0; i < jSONArray.length(); i++) {
            this.f206a.add(new cu().a(jSONArray.getJSONObject(i)));
        }
        return this;
    }

    public synchronized JSONObject a() {
        JSONObject jSONObject;
        jSONObject = new JSONObject();
        jSONObject.put(PushConstants.PUSH_NOTIFICATION_CREATE_TIMES_TAMP, this.f204a);
        jSONObject.put("wt", this.a);
        jSONObject.put("host", this.f205a);
        JSONArray jSONArray = new JSONArray();
        Iterator<cu> it = this.f206a.iterator();
        while (it.hasNext()) {
            jSONArray.put(it.next().m200a());
        }
        jSONObject.put("ah", jSONArray);
        return jSONObject;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public synchronized void a(cu cuVar) {
        if (cuVar != null) {
            this.f206a.add(cuVar);
            int a = cuVar.a();
            if (a > 0) {
                this.a += cuVar.a();
            } else {
                int i = 0;
                for (int size = this.f206a.size() - 1; size >= 0 && this.f206a.get(size).a() < 0; size--) {
                    i++;
                }
                this.a += a * i;
            }
            if (this.f206a.size() > 30) {
                this.a -= this.f206a.remove().a();
            }
        }
    }

    public String toString() {
        return this.f205a + ":" + this.a;
    }
}
