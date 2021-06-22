package d.a.o0.v.d.f.c;

import d.a.n0.r.q.a2;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    public String f65550a;

    /* renamed from: b  reason: collision with root package name */
    public String f65551b;

    /* renamed from: c  reason: collision with root package name */
    public List<a2> f65552c;

    /* renamed from: d  reason: collision with root package name */
    public int f65553d;

    /* renamed from: e  reason: collision with root package name */
    public int f65554e;

    public void a(JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        this.f65550a = jSONObject.optString("head_pic");
        jSONObject.optString("url_type");
        this.f65551b = jSONObject.optString("url");
        this.f65553d = jSONObject.optInt("head_type", 0);
        this.f65554e = jSONObject.optInt("is_set", -1);
        JSONArray optJSONArray = jSONObject.optJSONArray("head_thread");
        if (optJSONArray == null || optJSONArray.length() <= 0) {
            return;
        }
        this.f65552c = new ArrayList(optJSONArray.length());
        for (int i2 = 0; i2 < optJSONArray.length(); i2++) {
            JSONObject jSONObject2 = (JSONObject) optJSONArray.opt(i2);
            if (jSONObject2 != null) {
                a2 a2Var = new a2();
                a2Var.U2(jSONObject2);
                this.f65552c.add(a2Var);
            }
        }
    }
}
