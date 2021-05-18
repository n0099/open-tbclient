package d.a.j0.a;

import com.baidu.adp.lib.util.BdLog;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class v {

    /* renamed from: a  reason: collision with root package name */
    public long f48762a;

    /* renamed from: b  reason: collision with root package name */
    public long f48763b;

    /* renamed from: c  reason: collision with root package name */
    public ArrayList<z> f48764c;

    /* renamed from: d  reason: collision with root package name */
    public String f48765d;

    public long a() {
        return this.f48763b;
    }

    public long b() {
        return this.f48762a;
    }

    public ArrayList<z> c() {
        return this.f48764c;
    }

    public String d() {
        return this.f48765d;
    }

    public void e(String str) {
        if (d.a.c.e.p.k.isEmpty(str)) {
            return;
        }
        try {
            JSONObject jSONObject = new JSONObject(str);
            this.f48762a = jSONObject.optLong("start_date", 0L) * 1000;
            this.f48763b = jSONObject.optLong("end_date", 0L) * 1000;
            this.f48765d = jSONObject.optString("ahead_url", "");
            this.f48764c = new ArrayList<>();
            JSONArray optJSONArray = jSONObject.optJSONArray("time");
            if (optJSONArray == null || optJSONArray.length() <= 0) {
                return;
            }
            for (int i2 = 0; i2 < optJSONArray.length(); i2++) {
                JSONArray optJSONArray2 = optJSONArray.optJSONArray(i2);
                z zVar = new z();
                zVar.c(optJSONArray2);
                this.f48764c.add(zVar);
            }
        } catch (Exception e2) {
            BdLog.e(e2);
        }
    }
}
