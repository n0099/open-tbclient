package d.a.c.e.j.a.j;

import android.text.TextUtils;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    public List<String> f38653a;

    /* renamed from: b  reason: collision with root package name */
    public String f38654b;

    /* renamed from: c  reason: collision with root package name */
    public long f38655c;

    /* renamed from: d  reason: collision with root package name */
    public long f38656d = System.currentTimeMillis();

    public List<String> a() {
        return this.f38653a;
    }

    public a b(String str) {
        JSONArray optJSONArray;
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        try {
            JSONObject jSONObject = new JSONObject(str);
            this.f38655c = jSONObject.optLong("ttl");
            JSONObject optJSONObject = jSONObject.optJSONObject("data");
            if (optJSONObject == null) {
                return null;
            }
            String next = optJSONObject.keys().next();
            this.f38654b = next;
            JSONObject optJSONObject2 = optJSONObject.optJSONObject(next);
            if (optJSONObject2 != null && (optJSONArray = optJSONObject2.optJSONArray("ip")) != null && optJSONArray.length() > 0) {
                this.f38653a = new ArrayList();
                for (int i2 = 0; i2 < optJSONArray.length(); i2++) {
                    this.f38653a.add((String) optJSONArray.get(i2));
                }
            }
            return this;
        } catch (Exception e2) {
            e2.printStackTrace();
            return null;
        }
    }

    public boolean c(long j) {
        return j - this.f38656d > this.f38655c * 1000;
    }

    public void d(long j) {
        this.f38655c = j;
    }

    public void e(long j) {
        this.f38656d = j;
    }
}
