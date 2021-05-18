package d.a.k0.z2;

import com.baidu.adp.lib.util.BdLog;
import org.json.JSONObject;
/* loaded from: classes5.dex */
public class i {

    /* renamed from: a  reason: collision with root package name */
    public int f63745a;

    /* renamed from: b  reason: collision with root package name */
    public int f63746b;

    /* renamed from: c  reason: collision with root package name */
    public int f63747c;

    /* renamed from: d  reason: collision with root package name */
    public int f63748d;

    /* renamed from: e  reason: collision with root package name */
    public a f63749e = new a();

    public int a() {
        return this.f63748d;
    }

    public a b() {
        return this.f63749e;
    }

    public int c() {
        return this.f63745a;
    }

    public int d() {
        return this.f63747c;
    }

    public int e() {
        return this.f63746b;
    }

    public void f(JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        try {
            this.f63749e.c(jSONObject.optJSONObject("error"));
            this.f63745a = jSONObject.optInt("forum_id");
            jSONObject.optString("forum_name");
            this.f63746b = jSONObject.optInt("signed");
            jSONObject.optInt("is_on");
            jSONObject.optInt("is_filter");
            this.f63747c = jSONObject.optInt("sign_day_count");
            this.f63748d = jSONObject.optInt("cur_score");
        } catch (Exception e2) {
            BdLog.e(e2.getMessage());
        }
    }
}
