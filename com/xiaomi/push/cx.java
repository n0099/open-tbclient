package com.xiaomi.push;

import com.meizu.cloud.pushsdk.constants.PushConstants;
import java.util.Iterator;
import java.util.LinkedList;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes7.dex */
public class cx implements Comparable<cx> {

    /* renamed from: a  reason: collision with root package name */
    public int f40632a;

    /* renamed from: a  reason: collision with other field name */
    public long f206a;

    /* renamed from: a  reason: collision with other field name */
    public String f207a;

    /* renamed from: a  reason: collision with other field name */
    public final LinkedList<cn> f208a;

    public cx() {
        this(null, 0);
    }

    public cx(String str) {
        this(str, 0);
    }

    public cx(String str, int i) {
        this.f208a = new LinkedList<>();
        this.f206a = 0L;
        this.f207a = str;
        this.f40632a = i;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // java.lang.Comparable
    /* renamed from: a */
    public int compareTo(cx cxVar) {
        if (cxVar == null) {
            return 1;
        }
        return cxVar.f40632a - this.f40632a;
    }

    public synchronized cx a(JSONObject jSONObject) {
        this.f206a = jSONObject.getLong(PushConstants.PUSH_NOTIFICATION_CREATE_TIMES_TAMP);
        this.f40632a = jSONObject.getInt("wt");
        this.f207a = jSONObject.getString("host");
        JSONArray jSONArray = jSONObject.getJSONArray("ah");
        for (int i = 0; i < jSONArray.length(); i++) {
            this.f208a.add(new cn().a(jSONArray.getJSONObject(i)));
        }
        return this;
    }

    public synchronized JSONObject a() {
        JSONObject jSONObject;
        jSONObject = new JSONObject();
        jSONObject.put(PushConstants.PUSH_NOTIFICATION_CREATE_TIMES_TAMP, this.f206a);
        jSONObject.put("wt", this.f40632a);
        jSONObject.put("host", this.f207a);
        JSONArray jSONArray = new JSONArray();
        Iterator<cn> it = this.f208a.iterator();
        while (it.hasNext()) {
            jSONArray.put(it.next().m203a());
        }
        jSONObject.put("ah", jSONArray);
        return jSONObject;
    }

    public synchronized void a(cn cnVar) {
        if (cnVar != null) {
            this.f208a.add(cnVar);
            int a2 = cnVar.a();
            if (a2 > 0) {
                this.f40632a += cnVar.a();
            } else {
                int i = 0;
                for (int size = this.f208a.size() - 1; size >= 0 && this.f208a.get(size).a() < 0; size--) {
                    i++;
                }
                this.f40632a += a2 * i;
            }
            if (this.f208a.size() > 30) {
                this.f40632a -= this.f208a.remove().a();
            }
        }
    }

    public String toString() {
        return this.f207a + ":" + this.f40632a;
    }
}
