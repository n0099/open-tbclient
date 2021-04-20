package d.b.c.e.j.a.j;

import android.text.TextUtils;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    public List<String> f42305a;

    /* renamed from: b  reason: collision with root package name */
    public String f42306b;

    /* renamed from: c  reason: collision with root package name */
    public long f42307c;

    /* renamed from: d  reason: collision with root package name */
    public long f42308d = System.currentTimeMillis();

    public List<String> a() {
        return this.f42305a;
    }

    public a b(String str) {
        JSONArray optJSONArray;
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        try {
            JSONObject jSONObject = new JSONObject(str);
            this.f42307c = jSONObject.optLong("ttl");
            JSONObject optJSONObject = jSONObject.optJSONObject("data");
            if (optJSONObject == null) {
                return null;
            }
            String next = optJSONObject.keys().next();
            this.f42306b = next;
            JSONObject optJSONObject2 = optJSONObject.optJSONObject(next);
            if (optJSONObject2 != null && (optJSONArray = optJSONObject2.optJSONArray("ip")) != null && optJSONArray.length() > 0) {
                this.f42305a = new ArrayList();
                for (int i = 0; i < optJSONArray.length(); i++) {
                    this.f42305a.add((String) optJSONArray.get(i));
                }
            }
            return this;
        } catch (Exception e2) {
            e2.printStackTrace();
            return null;
        }
    }

    public boolean c(long j) {
        return j - this.f42308d > this.f42307c * 1000;
    }

    public void d(long j) {
        this.f42307c = j;
    }

    public void e(long j) {
        this.f42308d = j;
    }
}
