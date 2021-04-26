package d.a.j0.z2;

import com.baidu.adp.lib.util.BdLog;
import org.json.JSONObject;
/* loaded from: classes5.dex */
public class i {

    /* renamed from: a  reason: collision with root package name */
    public int f63021a;

    /* renamed from: b  reason: collision with root package name */
    public int f63022b;

    /* renamed from: c  reason: collision with root package name */
    public int f63023c;

    /* renamed from: d  reason: collision with root package name */
    public int f63024d;

    /* renamed from: e  reason: collision with root package name */
    public a f63025e = new a();

    public int a() {
        return this.f63024d;
    }

    public a b() {
        return this.f63025e;
    }

    public int c() {
        return this.f63021a;
    }

    public int d() {
        return this.f63023c;
    }

    public int e() {
        return this.f63022b;
    }

    public void f(JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        try {
            this.f63025e.c(jSONObject.optJSONObject("error"));
            this.f63021a = jSONObject.optInt("forum_id");
            jSONObject.optString("forum_name");
            this.f63022b = jSONObject.optInt("signed");
            jSONObject.optInt("is_on");
            jSONObject.optInt("is_filter");
            this.f63023c = jSONObject.optInt("sign_day_count");
            this.f63024d = jSONObject.optInt("cur_score");
        } catch (Exception e2) {
            BdLog.e(e2.getMessage());
        }
    }
}
