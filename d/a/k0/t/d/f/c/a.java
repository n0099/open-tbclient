package d.a.k0.t.d.f.c;

import d.a.j0.r.q.a2;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    public String f61423a;

    /* renamed from: b  reason: collision with root package name */
    public String f61424b;

    /* renamed from: c  reason: collision with root package name */
    public List<a2> f61425c;

    /* renamed from: d  reason: collision with root package name */
    public int f61426d;

    /* renamed from: e  reason: collision with root package name */
    public int f61427e;

    public void a(JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        this.f61423a = jSONObject.optString("head_pic");
        jSONObject.optString("url_type");
        this.f61424b = jSONObject.optString("url");
        this.f61426d = jSONObject.optInt("head_type", 0);
        this.f61427e = jSONObject.optInt("is_set", -1);
        JSONArray optJSONArray = jSONObject.optJSONArray("head_thread");
        if (optJSONArray == null || optJSONArray.length() <= 0) {
            return;
        }
        this.f61425c = new ArrayList(optJSONArray.length());
        for (int i2 = 0; i2 < optJSONArray.length(); i2++) {
            JSONObject jSONObject2 = (JSONObject) optJSONArray.opt(i2);
            if (jSONObject2 != null) {
                a2 a2Var = new a2();
                a2Var.S2(jSONObject2);
                this.f61425c.add(a2Var);
            }
        }
    }
}
