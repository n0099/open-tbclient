package com.xiaomi.network;

import com.meizu.cloud.pushsdk.constants.PushConstants;
import java.util.Iterator;
import java.util.LinkedList;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes2.dex */
class c implements Comparable<c> {
    String a;
    protected int b;
    private final LinkedList<AccessHistory> c;
    private long d;

    public c() {
        this(null, 0);
    }

    public c(String str, int i) {
        this.c = new LinkedList<>();
        this.d = 0L;
        this.a = str;
        this.b = i;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // java.lang.Comparable
    /* renamed from: a */
    public int compareTo(c cVar) {
        if (cVar == null) {
            return 1;
        }
        return cVar.b - this.b;
    }

    public synchronized c a(JSONObject jSONObject) {
        this.d = jSONObject.getLong(PushConstants.PUSH_NOTIFICATION_CREATE_TIMES_TAMP);
        this.b = jSONObject.getInt("wt");
        this.a = jSONObject.getString("host");
        JSONArray jSONArray = jSONObject.getJSONArray("ah");
        for (int i = 0; i < jSONArray.length(); i++) {
            this.c.add(new AccessHistory().a(jSONArray.getJSONObject(i)));
        }
        return this;
    }

    public synchronized JSONObject a() {
        JSONObject jSONObject;
        jSONObject = new JSONObject();
        jSONObject.put(PushConstants.PUSH_NOTIFICATION_CREATE_TIMES_TAMP, this.d);
        jSONObject.put("wt", this.b);
        jSONObject.put("host", this.a);
        JSONArray jSONArray = new JSONArray();
        Iterator<AccessHistory> it = this.c.iterator();
        while (it.hasNext()) {
            jSONArray.put(it.next().b());
        }
        jSONObject.put("ah", jSONArray);
        return jSONObject;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public synchronized void a(AccessHistory accessHistory) {
        if (accessHistory != null) {
            this.c.add(accessHistory);
            int a = accessHistory.a();
            if (a > 0) {
                this.b += accessHistory.a();
            } else {
                int i = 0;
                for (int size = this.c.size() - 1; size >= 0 && this.c.get(size).a() < 0; size--) {
                    i++;
                }
                this.b += a * i;
            }
            if (this.c.size() > 30) {
                this.b -= this.c.remove().a();
            }
        }
    }

    public String toString() {
        return this.a + ":" + this.b;
    }
}
