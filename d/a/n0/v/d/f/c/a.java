package d.a.n0.v.d.f.c;

import d.a.m0.r.q.a2;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    public String f61711a;

    /* renamed from: b  reason: collision with root package name */
    public String f61712b;

    /* renamed from: c  reason: collision with root package name */
    public List<a2> f61713c;

    /* renamed from: d  reason: collision with root package name */
    public int f61714d;

    /* renamed from: e  reason: collision with root package name */
    public int f61715e;

    public void a(JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        this.f61711a = jSONObject.optString("head_pic");
        jSONObject.optString("url_type");
        this.f61712b = jSONObject.optString("url");
        this.f61714d = jSONObject.optInt("head_type", 0);
        this.f61715e = jSONObject.optInt("is_set", -1);
        JSONArray optJSONArray = jSONObject.optJSONArray("head_thread");
        if (optJSONArray == null || optJSONArray.length() <= 0) {
            return;
        }
        this.f61713c = new ArrayList(optJSONArray.length());
        for (int i2 = 0; i2 < optJSONArray.length(); i2++) {
            JSONObject jSONObject2 = (JSONObject) optJSONArray.opt(i2);
            if (jSONObject2 != null) {
                a2 a2Var = new a2();
                a2Var.T2(jSONObject2);
                this.f61713c.add(a2Var);
            }
        }
    }
}
