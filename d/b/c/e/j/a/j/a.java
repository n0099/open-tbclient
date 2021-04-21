package d.b.c.e.j.a.j;

import android.text.TextUtils;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    public List<String> f42545a;

    /* renamed from: b  reason: collision with root package name */
    public String f42546b;

    /* renamed from: c  reason: collision with root package name */
    public long f42547c;

    /* renamed from: d  reason: collision with root package name */
    public long f42548d = System.currentTimeMillis();

    public List<String> a() {
        return this.f42545a;
    }

    public a b(String str) {
        JSONArray optJSONArray;
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        try {
            JSONObject jSONObject = new JSONObject(str);
            this.f42547c = jSONObject.optLong("ttl");
            JSONObject optJSONObject = jSONObject.optJSONObject("data");
            if (optJSONObject == null) {
                return null;
            }
            String next = optJSONObject.keys().next();
            this.f42546b = next;
            JSONObject optJSONObject2 = optJSONObject.optJSONObject(next);
            if (optJSONObject2 != null && (optJSONArray = optJSONObject2.optJSONArray("ip")) != null && optJSONArray.length() > 0) {
                this.f42545a = new ArrayList();
                for (int i = 0; i < optJSONArray.length(); i++) {
                    this.f42545a.add((String) optJSONArray.get(i));
                }
            }
            return this;
        } catch (Exception e2) {
            e2.printStackTrace();
            return null;
        }
    }

    public boolean c(long j) {
        return j - this.f42548d > this.f42547c * 1000;
    }

    public void d(long j) {
        this.f42547c = j;
    }

    public void e(long j) {
        this.f42548d = j;
    }
}
