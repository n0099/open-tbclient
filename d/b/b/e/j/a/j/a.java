package d.b.b.e.j.a.j;

import android.text.TextUtils;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    public List<String> f41808a;

    /* renamed from: b  reason: collision with root package name */
    public String f41809b;

    /* renamed from: c  reason: collision with root package name */
    public long f41810c;

    /* renamed from: d  reason: collision with root package name */
    public long f41811d = System.currentTimeMillis();

    public List<String> a() {
        return this.f41808a;
    }

    public a b(String str) {
        JSONArray optJSONArray;
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        try {
            JSONObject jSONObject = new JSONObject(str);
            this.f41810c = jSONObject.optLong("ttl");
            JSONObject optJSONObject = jSONObject.optJSONObject("data");
            if (optJSONObject == null) {
                return null;
            }
            String next = optJSONObject.keys().next();
            this.f41809b = next;
            JSONObject optJSONObject2 = optJSONObject.optJSONObject(next);
            if (optJSONObject2 != null && (optJSONArray = optJSONObject2.optJSONArray("ip")) != null && optJSONArray.length() > 0) {
                this.f41808a = new ArrayList();
                for (int i = 0; i < optJSONArray.length(); i++) {
                    this.f41808a.add((String) optJSONArray.get(i));
                }
            }
            return this;
        } catch (Exception e2) {
            e2.printStackTrace();
            return null;
        }
    }

    public boolean c(long j) {
        return j - this.f41811d > this.f41810c * 1000;
    }

    public void d(long j) {
        this.f41810c = j;
    }

    public void e(long j) {
        this.f41811d = j;
    }
}
