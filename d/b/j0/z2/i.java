package d.b.j0.z2;

import com.baidu.adp.lib.util.BdLog;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class i {

    /* renamed from: a  reason: collision with root package name */
    public int f64732a;

    /* renamed from: b  reason: collision with root package name */
    public int f64733b;

    /* renamed from: c  reason: collision with root package name */
    public int f64734c;

    /* renamed from: d  reason: collision with root package name */
    public int f64735d;

    /* renamed from: e  reason: collision with root package name */
    public a f64736e = new a();

    public int a() {
        return this.f64735d;
    }

    public a b() {
        return this.f64736e;
    }

    public int c() {
        return this.f64732a;
    }

    public int d() {
        return this.f64734c;
    }

    public int e() {
        return this.f64733b;
    }

    public void f(JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        try {
            this.f64736e.c(jSONObject.optJSONObject("error"));
            this.f64732a = jSONObject.optInt("forum_id");
            jSONObject.optString("forum_name");
            this.f64733b = jSONObject.optInt("signed");
            jSONObject.optInt("is_on");
            jSONObject.optInt("is_filter");
            this.f64734c = jSONObject.optInt("sign_day_count");
            this.f64735d = jSONObject.optInt("cur_score");
        } catch (Exception e2) {
            BdLog.e(e2.getMessage());
        }
    }
}
