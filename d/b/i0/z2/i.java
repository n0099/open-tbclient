package d.b.i0.z2;

import com.baidu.adp.lib.util.BdLog;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class i {

    /* renamed from: a  reason: collision with root package name */
    public int f64311a;

    /* renamed from: b  reason: collision with root package name */
    public int f64312b;

    /* renamed from: c  reason: collision with root package name */
    public int f64313c;

    /* renamed from: d  reason: collision with root package name */
    public int f64314d;

    /* renamed from: e  reason: collision with root package name */
    public a f64315e = new a();

    public int a() {
        return this.f64314d;
    }

    public a b() {
        return this.f64315e;
    }

    public int c() {
        return this.f64311a;
    }

    public int d() {
        return this.f64313c;
    }

    public int e() {
        return this.f64312b;
    }

    public void f(JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        try {
            this.f64315e.c(jSONObject.optJSONObject("error"));
            this.f64311a = jSONObject.optInt("forum_id");
            jSONObject.optString("forum_name");
            this.f64312b = jSONObject.optInt("signed");
            jSONObject.optInt("is_on");
            jSONObject.optInt("is_filter");
            this.f64313c = jSONObject.optInt("sign_day_count");
            this.f64314d = jSONObject.optInt("cur_score");
        } catch (Exception e2) {
            BdLog.e(e2.getMessage());
        }
    }
}
