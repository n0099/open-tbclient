package d.b.i0.y2;

import com.baidu.adp.lib.util.BdLog;
import org.json.JSONObject;
/* loaded from: classes5.dex */
public class i {

    /* renamed from: a  reason: collision with root package name */
    public int f62649a;

    /* renamed from: b  reason: collision with root package name */
    public int f62650b;

    /* renamed from: c  reason: collision with root package name */
    public int f62651c;

    /* renamed from: d  reason: collision with root package name */
    public int f62652d;

    /* renamed from: e  reason: collision with root package name */
    public a f62653e = new a();

    public int a() {
        return this.f62652d;
    }

    public a b() {
        return this.f62653e;
    }

    public int c() {
        return this.f62649a;
    }

    public int d() {
        return this.f62651c;
    }

    public int e() {
        return this.f62650b;
    }

    public void f(JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        try {
            this.f62653e.c(jSONObject.optJSONObject("error"));
            this.f62649a = jSONObject.optInt("forum_id");
            jSONObject.optString("forum_name");
            this.f62650b = jSONObject.optInt("signed");
            jSONObject.optInt("is_on");
            jSONObject.optInt("is_filter");
            this.f62651c = jSONObject.optInt("sign_day_count");
            this.f62652d = jSONObject.optInt("cur_score");
        } catch (Exception e2) {
            BdLog.e(e2.getMessage());
        }
    }
}
