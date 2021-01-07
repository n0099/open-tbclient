package com.xiaomi.push;

import com.meizu.cloud.pushsdk.constants.PushConstants;
import java.util.Iterator;
import java.util.LinkedList;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes6.dex */
class de implements Comparable<de> {

    /* renamed from: a  reason: collision with root package name */
    protected int f14233a;

    /* renamed from: a  reason: collision with other field name */
    private long f279a;

    /* renamed from: a  reason: collision with other field name */
    String f280a;

    /* renamed from: a  reason: collision with other field name */
    private final LinkedList<cu> f281a;

    public de() {
        this(null, 0);
    }

    public de(String str) {
        this(str, 0);
    }

    public de(String str, int i) {
        this.f281a = new LinkedList<>();
        this.f279a = 0L;
        this.f280a = str;
        this.f14233a = i;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // java.lang.Comparable
    /* renamed from: a */
    public int compareTo(de deVar) {
        if (deVar == null) {
            return 1;
        }
        return deVar.f14233a - this.f14233a;
    }

    public synchronized de a(JSONObject jSONObject) {
        this.f279a = jSONObject.getLong(PushConstants.PUSH_NOTIFICATION_CREATE_TIMES_TAMP);
        this.f14233a = jSONObject.getInt("wt");
        this.f280a = jSONObject.getString("host");
        JSONArray jSONArray = jSONObject.getJSONArray("ah");
        for (int i = 0; i < jSONArray.length(); i++) {
            this.f281a.add(new cu().a(jSONArray.getJSONObject(i)));
        }
        return this;
    }

    public synchronized JSONObject a() {
        JSONObject jSONObject;
        jSONObject = new JSONObject();
        jSONObject.put(PushConstants.PUSH_NOTIFICATION_CREATE_TIMES_TAMP, this.f279a);
        jSONObject.put("wt", this.f14233a);
        jSONObject.put("host", this.f280a);
        JSONArray jSONArray = new JSONArray();
        Iterator<cu> it = this.f281a.iterator();
        while (it.hasNext()) {
            jSONArray.put(it.next().m235a());
        }
        jSONObject.put("ah", jSONArray);
        return jSONObject;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public synchronized void a(cu cuVar) {
        if (cuVar != null) {
            this.f281a.add(cuVar);
            int a2 = cuVar.a();
            if (a2 > 0) {
                this.f14233a += cuVar.a();
            } else {
                int i = 0;
                for (int size = this.f281a.size() - 1; size >= 0 && this.f281a.get(size).a() < 0; size--) {
                    i++;
                }
                this.f14233a += a2 * i;
            }
            if (this.f281a.size() > 30) {
                this.f14233a -= this.f281a.remove().a();
            }
        }
    }

    public String toString() {
        return this.f280a + ":" + this.f14233a;
    }
}
