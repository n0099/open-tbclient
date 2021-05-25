package d.a.n0.a3;

import com.baidu.adp.lib.util.BdLog;
import org.json.JSONObject;
/* loaded from: classes5.dex */
public class i {

    /* renamed from: a  reason: collision with root package name */
    public int f51236a;

    /* renamed from: b  reason: collision with root package name */
    public int f51237b;

    /* renamed from: c  reason: collision with root package name */
    public int f51238c;

    /* renamed from: d  reason: collision with root package name */
    public int f51239d;

    /* renamed from: e  reason: collision with root package name */
    public a f51240e = new a();

    public int a() {
        return this.f51239d;
    }

    public a b() {
        return this.f51240e;
    }

    public int c() {
        return this.f51236a;
    }

    public int d() {
        return this.f51238c;
    }

    public int e() {
        return this.f51237b;
    }

    public void f(JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        try {
            this.f51240e.c(jSONObject.optJSONObject("error"));
            this.f51236a = jSONObject.optInt("forum_id");
            jSONObject.optString("forum_name");
            this.f51237b = jSONObject.optInt("signed");
            jSONObject.optInt("is_on");
            jSONObject.optInt("is_filter");
            this.f51238c = jSONObject.optInt("sign_day_count");
            this.f51239d = jSONObject.optInt("cur_score");
        } catch (Exception e2) {
            BdLog.e(e2.getMessage());
        }
    }
}
