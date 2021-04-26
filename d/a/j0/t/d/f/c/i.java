package d.a.j0.t.d.f.c;

import org.json.JSONObject;
/* loaded from: classes4.dex */
public class i {

    /* renamed from: a  reason: collision with root package name */
    public boolean f60725a;

    public void a(JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        jSONObject.optLong("user_id");
        jSONObject.optInt("sign_time");
        jSONObject.optInt("cont_sign_num");
        jSONObject.optInt("cout_total_sign_num");
        jSONObject.optInt("total_resign_num");
        jSONObject.optInt("miss_sign_num");
        this.f60725a = jSONObject.optInt("is_sign_in") == 1;
        jSONObject.optInt("user_sign_rank");
    }
}
