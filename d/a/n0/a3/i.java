package d.a.n0.a3;

import com.baidu.adp.lib.util.BdLog;
import org.json.JSONObject;
/* loaded from: classes5.dex */
public class i {

    /* renamed from: a  reason: collision with root package name */
    public int f54913a;

    /* renamed from: b  reason: collision with root package name */
    public int f54914b;

    /* renamed from: c  reason: collision with root package name */
    public int f54915c;

    /* renamed from: d  reason: collision with root package name */
    public int f54916d;

    /* renamed from: e  reason: collision with root package name */
    public a f54917e = new a();

    public int a() {
        return this.f54916d;
    }

    public a b() {
        return this.f54917e;
    }

    public int c() {
        return this.f54913a;
    }

    public int d() {
        return this.f54915c;
    }

    public int e() {
        return this.f54914b;
    }

    public void f(JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        try {
            this.f54917e.c(jSONObject.optJSONObject("error"));
            this.f54913a = jSONObject.optInt("forum_id");
            jSONObject.optString("forum_name");
            this.f54914b = jSONObject.optInt("signed");
            jSONObject.optInt("is_on");
            jSONObject.optInt("is_filter");
            this.f54915c = jSONObject.optInt("sign_day_count");
            this.f54916d = jSONObject.optInt("cur_score");
        } catch (Exception e2) {
            BdLog.e(e2.getMessage());
        }
    }
}
