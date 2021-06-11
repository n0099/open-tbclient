package d.a.c.e.j.a.j;

import android.text.TextUtils;
import com.yy.gslbsdk.db.ResultTB;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    public List<String> f42306a;

    /* renamed from: b  reason: collision with root package name */
    public String f42307b;

    /* renamed from: c  reason: collision with root package name */
    public long f42308c;

    /* renamed from: d  reason: collision with root package name */
    public long f42309d = System.currentTimeMillis();

    public List<String> a() {
        return this.f42306a;
    }

    public a b(String str) {
        JSONArray optJSONArray;
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        try {
            JSONObject jSONObject = new JSONObject(str);
            this.f42308c = jSONObject.optLong(ResultTB.TTL);
            JSONObject optJSONObject = jSONObject.optJSONObject("data");
            if (optJSONObject == null) {
                return null;
            }
            String next = optJSONObject.keys().next();
            this.f42307b = next;
            JSONObject optJSONObject2 = optJSONObject.optJSONObject(next);
            if (optJSONObject2 != null && (optJSONArray = optJSONObject2.optJSONArray("ip")) != null && optJSONArray.length() > 0) {
                this.f42306a = new ArrayList();
                for (int i2 = 0; i2 < optJSONArray.length(); i2++) {
                    this.f42306a.add((String) optJSONArray.get(i2));
                }
            }
            return this;
        } catch (Exception e2) {
            e2.printStackTrace();
            return null;
        }
    }

    public boolean c(long j) {
        return j - this.f42309d > this.f42308c * 1000;
    }

    public void d(long j) {
        this.f42308c = j;
    }

    public void e(long j) {
        this.f42309d = j;
    }
}
