package com.xiaomi.push;

import com.meizu.cloud.pushsdk.constants.PushConstants;
import java.util.Iterator;
import java.util.LinkedList;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes12.dex */
class de implements Comparable<de> {

    /* renamed from: a  reason: collision with root package name */
    protected int f4850a;

    /* renamed from: a  reason: collision with other field name */
    private long f197a;

    /* renamed from: a  reason: collision with other field name */
    String f198a;

    /* renamed from: a  reason: collision with other field name */
    private final LinkedList<cu> f199a;

    public de() {
        this(null, 0);
    }

    public de(String str) {
        this(str, 0);
    }

    public de(String str, int i) {
        this.f199a = new LinkedList<>();
        this.f197a = 0L;
        this.f198a = str;
        this.f4850a = i;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // java.lang.Comparable
    /* renamed from: a */
    public int compareTo(de deVar) {
        if (deVar == null) {
            return 1;
        }
        return deVar.f4850a - this.f4850a;
    }

    public synchronized de a(JSONObject jSONObject) {
        this.f197a = jSONObject.getLong(PushConstants.PUSH_NOTIFICATION_CREATE_TIMES_TAMP);
        this.f4850a = jSONObject.getInt("wt");
        this.f198a = jSONObject.getString("host");
        JSONArray jSONArray = jSONObject.getJSONArray("ah");
        for (int i = 0; i < jSONArray.length(); i++) {
            this.f199a.add(new cu().a(jSONArray.getJSONObject(i)));
        }
        return this;
    }

    public synchronized JSONObject a() {
        JSONObject jSONObject;
        jSONObject = new JSONObject();
        jSONObject.put(PushConstants.PUSH_NOTIFICATION_CREATE_TIMES_TAMP, this.f197a);
        jSONObject.put("wt", this.f4850a);
        jSONObject.put("host", this.f198a);
        JSONArray jSONArray = new JSONArray();
        Iterator<cu> it = this.f199a.iterator();
        while (it.hasNext()) {
            jSONArray.put(it.next().m205a());
        }
        jSONObject.put("ah", jSONArray);
        return jSONObject;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public synchronized void a(cu cuVar) {
        if (cuVar != null) {
            this.f199a.add(cuVar);
            int a2 = cuVar.a();
            if (a2 > 0) {
                this.f4850a += cuVar.a();
            } else {
                int i = 0;
                for (int size = this.f199a.size() - 1; size >= 0 && this.f199a.get(size).a() < 0; size--) {
                    i++;
                }
                this.f4850a += a2 * i;
            }
            if (this.f199a.size() > 30) {
                this.f4850a -= this.f199a.remove().a();
            }
        }
    }

    public String toString() {
        return this.f198a + ":" + this.f4850a;
    }
}
