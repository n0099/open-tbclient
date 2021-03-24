package d.b.h0.a;

import com.baidu.adp.lib.util.BdLog;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class u {

    /* renamed from: a  reason: collision with root package name */
    public long f49641a;

    /* renamed from: b  reason: collision with root package name */
    public long f49642b;

    /* renamed from: c  reason: collision with root package name */
    public ArrayList<x> f49643c;

    /* renamed from: d  reason: collision with root package name */
    public String f49644d;

    public long a() {
        return this.f49642b;
    }

    public long b() {
        return this.f49641a;
    }

    public ArrayList<x> c() {
        return this.f49643c;
    }

    public String d() {
        return this.f49644d;
    }

    public void e(String str) {
        if (d.b.b.e.p.k.isEmpty(str)) {
            return;
        }
        try {
            JSONObject jSONObject = new JSONObject(str);
            this.f49641a = jSONObject.optLong("start_date", 0L) * 1000;
            this.f49642b = jSONObject.optLong("end_date", 0L) * 1000;
            this.f49644d = jSONObject.optString("ahead_url", "");
            this.f49643c = new ArrayList<>();
            JSONArray optJSONArray = jSONObject.optJSONArray("time");
            if (optJSONArray == null || optJSONArray.length() <= 0) {
                return;
            }
            for (int i = 0; i < optJSONArray.length(); i++) {
                JSONArray optJSONArray2 = optJSONArray.optJSONArray(i);
                x xVar = new x();
                xVar.c(optJSONArray2);
                this.f49643c.add(xVar);
            }
        } catch (Exception e2) {
            BdLog.e(e2);
        }
    }
}
