package com.xiaomi.push;

import com.meizu.cloud.pushsdk.constants.PushConstants;
import java.util.Iterator;
import java.util.LinkedList;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes12.dex */
class de implements Comparable<de> {

    /* renamed from: a  reason: collision with root package name */
    protected int f4852a;

    /* renamed from: a  reason: collision with other field name */
    private long f199a;

    /* renamed from: a  reason: collision with other field name */
    String f200a;

    /* renamed from: a  reason: collision with other field name */
    private final LinkedList<cu> f201a;

    public de() {
        this(null, 0);
    }

    public de(String str) {
        this(str, 0);
    }

    public de(String str, int i) {
        this.f201a = new LinkedList<>();
        this.f199a = 0L;
        this.f200a = str;
        this.f4852a = i;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // java.lang.Comparable
    /* renamed from: a */
    public int compareTo(de deVar) {
        if (deVar == null) {
            return 1;
        }
        return deVar.f4852a - this.f4852a;
    }

    public synchronized de a(JSONObject jSONObject) {
        this.f199a = jSONObject.getLong(PushConstants.PUSH_NOTIFICATION_CREATE_TIMES_TAMP);
        this.f4852a = jSONObject.getInt("wt");
        this.f200a = jSONObject.getString("host");
        JSONArray jSONArray = jSONObject.getJSONArray("ah");
        for (int i = 0; i < jSONArray.length(); i++) {
            this.f201a.add(new cu().a(jSONArray.getJSONObject(i)));
        }
        return this;
    }

    public synchronized JSONObject a() {
        JSONObject jSONObject;
        jSONObject = new JSONObject();
        jSONObject.put(PushConstants.PUSH_NOTIFICATION_CREATE_TIMES_TAMP, this.f199a);
        jSONObject.put("wt", this.f4852a);
        jSONObject.put("host", this.f200a);
        JSONArray jSONArray = new JSONArray();
        Iterator<cu> it = this.f201a.iterator();
        while (it.hasNext()) {
            jSONArray.put(it.next().m205a());
        }
        jSONObject.put("ah", jSONArray);
        return jSONObject;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public synchronized void a(cu cuVar) {
        if (cuVar != null) {
            this.f201a.add(cuVar);
            int a2 = cuVar.a();
            if (a2 > 0) {
                this.f4852a += cuVar.a();
            } else {
                int i = 0;
                for (int size = this.f201a.size() - 1; size >= 0 && this.f201a.get(size).a() < 0; size--) {
                    i++;
                }
                this.f4852a += a2 * i;
            }
            if (this.f201a.size() > 30) {
                this.f4852a -= this.f201a.remove().a();
            }
        }
    }

    public String toString() {
        return this.f200a + ":" + this.f4852a;
    }
}
