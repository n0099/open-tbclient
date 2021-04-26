package d.a.i0.a;

import com.baidu.adp.lib.util.BdLog;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class u {

    /* renamed from: a  reason: collision with root package name */
    public long f47923a;

    /* renamed from: b  reason: collision with root package name */
    public long f47924b;

    /* renamed from: c  reason: collision with root package name */
    public ArrayList<x> f47925c;

    /* renamed from: d  reason: collision with root package name */
    public String f47926d;

    public long a() {
        return this.f47924b;
    }

    public long b() {
        return this.f47923a;
    }

    public ArrayList<x> c() {
        return this.f47925c;
    }

    public String d() {
        return this.f47926d;
    }

    public void e(String str) {
        if (d.a.c.e.p.k.isEmpty(str)) {
            return;
        }
        try {
            JSONObject jSONObject = new JSONObject(str);
            this.f47923a = jSONObject.optLong("start_date", 0L) * 1000;
            this.f47924b = jSONObject.optLong("end_date", 0L) * 1000;
            this.f47926d = jSONObject.optString("ahead_url", "");
            this.f47925c = new ArrayList<>();
            JSONArray optJSONArray = jSONObject.optJSONArray("time");
            if (optJSONArray == null || optJSONArray.length() <= 0) {
                return;
            }
            for (int i2 = 0; i2 < optJSONArray.length(); i2++) {
                JSONArray optJSONArray2 = optJSONArray.optJSONArray(i2);
                x xVar = new x();
                xVar.c(optJSONArray2);
                this.f47925c.add(xVar);
            }
        } catch (Exception e2) {
            BdLog.e(e2);
        }
    }
}
