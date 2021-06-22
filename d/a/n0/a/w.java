package d.a.n0.a;

import com.baidu.adp.lib.util.BdLog;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class w {

    /* renamed from: a  reason: collision with root package name */
    public long f52567a;

    /* renamed from: b  reason: collision with root package name */
    public long f52568b;

    /* renamed from: c  reason: collision with root package name */
    public ArrayList<a0> f52569c;

    /* renamed from: d  reason: collision with root package name */
    public String f52570d;

    public long a() {
        return this.f52568b;
    }

    public long b() {
        return this.f52567a;
    }

    public ArrayList<a0> c() {
        return this.f52569c;
    }

    public String d() {
        return this.f52570d;
    }

    public void e(String str) {
        if (d.a.c.e.p.k.isEmpty(str)) {
            return;
        }
        try {
            JSONObject jSONObject = new JSONObject(str);
            this.f52567a = jSONObject.optLong("start_date", 0L) * 1000;
            this.f52568b = jSONObject.optLong("end_date", 0L) * 1000;
            this.f52570d = jSONObject.optString("ahead_url", "");
            this.f52569c = new ArrayList<>();
            JSONArray optJSONArray = jSONObject.optJSONArray("time");
            if (optJSONArray == null || optJSONArray.length() <= 0) {
                return;
            }
            for (int i2 = 0; i2 < optJSONArray.length(); i2++) {
                JSONArray optJSONArray2 = optJSONArray.optJSONArray(i2);
                a0 a0Var = new a0();
                a0Var.c(optJSONArray2);
                this.f52569c.add(a0Var);
            }
        } catch (Exception e2) {
            BdLog.e(e2);
        }
    }
}
