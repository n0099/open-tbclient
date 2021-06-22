package d.a.o0.a3;

import com.baidu.adp.lib.util.BdLog;
import org.json.JSONObject;
/* loaded from: classes5.dex */
public class i {

    /* renamed from: a  reason: collision with root package name */
    public int f55038a;

    /* renamed from: b  reason: collision with root package name */
    public int f55039b;

    /* renamed from: c  reason: collision with root package name */
    public int f55040c;

    /* renamed from: d  reason: collision with root package name */
    public int f55041d;

    /* renamed from: e  reason: collision with root package name */
    public a f55042e = new a();

    public int a() {
        return this.f55041d;
    }

    public a b() {
        return this.f55042e;
    }

    public int c() {
        return this.f55038a;
    }

    public int d() {
        return this.f55040c;
    }

    public int e() {
        return this.f55039b;
    }

    public void f(JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        try {
            this.f55042e.c(jSONObject.optJSONObject("error"));
            this.f55038a = jSONObject.optInt("forum_id");
            jSONObject.optString("forum_name");
            this.f55039b = jSONObject.optInt("signed");
            jSONObject.optInt("is_on");
            jSONObject.optInt("is_filter");
            this.f55040c = jSONObject.optInt("sign_day_count");
            this.f55041d = jSONObject.optInt("cur_score");
        } catch (Exception e2) {
            BdLog.e(e2.getMessage());
        }
    }
}
