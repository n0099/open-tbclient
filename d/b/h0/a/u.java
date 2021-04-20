package d.b.h0.a;

import com.baidu.adp.lib.util.BdLog;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class u {

    /* renamed from: a  reason: collision with root package name */
    public long f50034a;

    /* renamed from: b  reason: collision with root package name */
    public long f50035b;

    /* renamed from: c  reason: collision with root package name */
    public ArrayList<x> f50036c;

    /* renamed from: d  reason: collision with root package name */
    public String f50037d;

    public long a() {
        return this.f50035b;
    }

    public long b() {
        return this.f50034a;
    }

    public ArrayList<x> c() {
        return this.f50036c;
    }

    public String d() {
        return this.f50037d;
    }

    public void e(String str) {
        if (d.b.c.e.p.k.isEmpty(str)) {
            return;
        }
        try {
            JSONObject jSONObject = new JSONObject(str);
            this.f50034a = jSONObject.optLong("start_date", 0L) * 1000;
            this.f50035b = jSONObject.optLong("end_date", 0L) * 1000;
            this.f50037d = jSONObject.optString("ahead_url", "");
            this.f50036c = new ArrayList<>();
            JSONArray optJSONArray = jSONObject.optJSONArray("time");
            if (optJSONArray == null || optJSONArray.length() <= 0) {
                return;
            }
            for (int i = 0; i < optJSONArray.length(); i++) {
                JSONArray optJSONArray2 = optJSONArray.optJSONArray(i);
                x xVar = new x();
                xVar.c(optJSONArray2);
                this.f50036c.add(xVar);
            }
        } catch (Exception e2) {
            BdLog.e(e2);
        }
    }
}
