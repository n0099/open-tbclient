package d.a.m0.a;

import com.baidu.adp.lib.util.BdLog;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class v {

    /* renamed from: a  reason: collision with root package name */
    public long f48784a;

    /* renamed from: b  reason: collision with root package name */
    public long f48785b;

    /* renamed from: c  reason: collision with root package name */
    public ArrayList<z> f48786c;

    /* renamed from: d  reason: collision with root package name */
    public String f48787d;

    public long a() {
        return this.f48785b;
    }

    public long b() {
        return this.f48784a;
    }

    public ArrayList<z> c() {
        return this.f48786c;
    }

    public String d() {
        return this.f48787d;
    }

    public void e(String str) {
        if (d.a.c.e.p.k.isEmpty(str)) {
            return;
        }
        try {
            JSONObject jSONObject = new JSONObject(str);
            this.f48784a = jSONObject.optLong("start_date", 0L) * 1000;
            this.f48785b = jSONObject.optLong("end_date", 0L) * 1000;
            this.f48787d = jSONObject.optString("ahead_url", "");
            this.f48786c = new ArrayList<>();
            JSONArray optJSONArray = jSONObject.optJSONArray("time");
            if (optJSONArray == null || optJSONArray.length() <= 0) {
                return;
            }
            for (int i2 = 0; i2 < optJSONArray.length(); i2++) {
                JSONArray optJSONArray2 = optJSONArray.optJSONArray(i2);
                z zVar = new z();
                zVar.c(optJSONArray2);
                this.f48786c.add(zVar);
            }
        } catch (Exception e2) {
            BdLog.e(e2);
        }
    }
}
