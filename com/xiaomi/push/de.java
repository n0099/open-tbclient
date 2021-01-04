package com.xiaomi.push;

import com.meizu.cloud.pushsdk.constants.PushConstants;
import java.util.Iterator;
import java.util.LinkedList;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes6.dex */
class de implements Comparable<de> {

    /* renamed from: a  reason: collision with root package name */
    protected int f14232a;

    /* renamed from: a  reason: collision with other field name */
    private long f278a;

    /* renamed from: a  reason: collision with other field name */
    String f279a;

    /* renamed from: a  reason: collision with other field name */
    private final LinkedList<cu> f280a;

    public de() {
        this(null, 0);
    }

    public de(String str) {
        this(str, 0);
    }

    public de(String str, int i) {
        this.f280a = new LinkedList<>();
        this.f278a = 0L;
        this.f279a = str;
        this.f14232a = i;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // java.lang.Comparable
    /* renamed from: a */
    public int compareTo(de deVar) {
        if (deVar == null) {
            return 1;
        }
        return deVar.f14232a - this.f14232a;
    }

    public synchronized de a(JSONObject jSONObject) {
        this.f278a = jSONObject.getLong(PushConstants.PUSH_NOTIFICATION_CREATE_TIMES_TAMP);
        this.f14232a = jSONObject.getInt("wt");
        this.f279a = jSONObject.getString("host");
        JSONArray jSONArray = jSONObject.getJSONArray("ah");
        for (int i = 0; i < jSONArray.length(); i++) {
            this.f280a.add(new cu().a(jSONArray.getJSONObject(i)));
        }
        return this;
    }

    public synchronized JSONObject a() {
        JSONObject jSONObject;
        jSONObject = new JSONObject();
        jSONObject.put(PushConstants.PUSH_NOTIFICATION_CREATE_TIMES_TAMP, this.f278a);
        jSONObject.put("wt", this.f14232a);
        jSONObject.put("host", this.f279a);
        JSONArray jSONArray = new JSONArray();
        Iterator<cu> it = this.f280a.iterator();
        while (it.hasNext()) {
            jSONArray.put(it.next().m224a());
        }
        jSONObject.put("ah", jSONArray);
        return jSONObject;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public synchronized void a(cu cuVar) {
        if (cuVar != null) {
            this.f280a.add(cuVar);
            int a2 = cuVar.a();
            if (a2 > 0) {
                this.f14232a += cuVar.a();
            } else {
                int i = 0;
                for (int size = this.f280a.size() - 1; size >= 0 && this.f280a.get(size).a() < 0; size--) {
                    i++;
                }
                this.f14232a += a2 * i;
            }
            if (this.f280a.size() > 30) {
                this.f14232a -= this.f280a.remove().a();
            }
        }
    }

    public String toString() {
        return this.f279a + ":" + this.f14232a;
    }
}
