package d.b.h0.a;

import com.baidu.adp.lib.util.BdLog;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class u {

    /* renamed from: a  reason: collision with root package name */
    public long f49642a;

    /* renamed from: b  reason: collision with root package name */
    public long f49643b;

    /* renamed from: c  reason: collision with root package name */
    public ArrayList<x> f49644c;

    /* renamed from: d  reason: collision with root package name */
    public String f49645d;

    public long a() {
        return this.f49643b;
    }

    public long b() {
        return this.f49642a;
    }

    public ArrayList<x> c() {
        return this.f49644c;
    }

    public String d() {
        return this.f49645d;
    }

    public void e(String str) {
        if (d.b.b.e.p.k.isEmpty(str)) {
            return;
        }
        try {
            JSONObject jSONObject = new JSONObject(str);
            this.f49642a = jSONObject.optLong("start_date", 0L) * 1000;
            this.f49643b = jSONObject.optLong("end_date", 0L) * 1000;
            this.f49645d = jSONObject.optString("ahead_url", "");
            this.f49644c = new ArrayList<>();
            JSONArray optJSONArray = jSONObject.optJSONArray("time");
            if (optJSONArray == null || optJSONArray.length() <= 0) {
                return;
            }
            for (int i = 0; i < optJSONArray.length(); i++) {
                JSONArray optJSONArray2 = optJSONArray.optJSONArray(i);
                x xVar = new x();
                xVar.c(optJSONArray2);
                this.f49644c.add(xVar);
            }
        } catch (Exception e2) {
            BdLog.e(e2);
        }
    }
}
