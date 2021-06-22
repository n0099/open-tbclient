package com.xiaomi.push;

import com.meizu.cloud.pushsdk.constants.PushConstants;
import java.util.Iterator;
import java.util.LinkedList;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes7.dex */
public class cx implements Comparable<cx> {

    /* renamed from: a  reason: collision with root package name */
    public int f41200a;

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

    public cx(String str, int i2) {
        this.f208a = new LinkedList<>();
        this.f206a = 0L;
        this.f207a = str;
        this.f41200a = i2;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // java.lang.Comparable
    /* renamed from: a */
    public int compareTo(cx cxVar) {
        if (cxVar == null) {
            return 1;
        }
        return cxVar.f41200a - this.f41200a;
    }

    public synchronized cx a(JSONObject jSONObject) {
        this.f206a = jSONObject.getLong(PushConstants.PUSH_NOTIFICATION_CREATE_TIMES_TAMP);
        this.f41200a = jSONObject.getInt("wt");
        this.f207a = jSONObject.getString("host");
        JSONArray jSONArray = jSONObject.getJSONArray("ah");
        for (int i2 = 0; i2 < jSONArray.length(); i2++) {
            this.f208a.add(new cn().a(jSONArray.getJSONObject(i2)));
        }
        return this;
    }

    public synchronized JSONObject a() {
        JSONObject jSONObject;
        jSONObject = new JSONObject();
        jSONObject.put(PushConstants.PUSH_NOTIFICATION_CREATE_TIMES_TAMP, this.f206a);
        jSONObject.put("wt", this.f41200a);
        jSONObject.put("host", this.f207a);
        JSONArray jSONArray = new JSONArray();
        Iterator<cn> it = this.f208a.iterator();
        while (it.hasNext()) {
            jSONArray.put(it.next().m204a());
        }
        jSONObject.put("ah", jSONArray);
        return jSONObject;
    }

    public synchronized void a(cn cnVar) {
        if (cnVar != null) {
            this.f208a.add(cnVar);
            int a2 = cnVar.a();
            if (a2 > 0) {
                this.f41200a += cnVar.a();
            } else {
                int i2 = 0;
                for (int size = this.f208a.size() - 1; size >= 0 && this.f208a.get(size).a() < 0; size--) {
                    i2++;
                }
                this.f41200a += a2 * i2;
            }
            if (this.f208a.size() > 30) {
                this.f41200a -= this.f208a.remove().a();
            }
        }
    }

    public String toString() {
        return this.f207a + ":" + this.f41200a;
    }
}
