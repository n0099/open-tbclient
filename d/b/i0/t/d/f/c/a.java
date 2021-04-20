package d.b.i0.t.d.f.c;

import d.b.h0.r.q.a2;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    public String f62090a;

    /* renamed from: b  reason: collision with root package name */
    public String f62091b;

    /* renamed from: c  reason: collision with root package name */
    public List<a2> f62092c;

    /* renamed from: d  reason: collision with root package name */
    public int f62093d;

    /* renamed from: e  reason: collision with root package name */
    public int f62094e;

    public void a(JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        this.f62090a = jSONObject.optString("head_pic");
        jSONObject.optString("url_type");
        this.f62091b = jSONObject.optString("url");
        this.f62093d = jSONObject.optInt("head_type", 0);
        this.f62094e = jSONObject.optInt("is_set", -1);
        JSONArray optJSONArray = jSONObject.optJSONArray("head_thread");
        if (optJSONArray == null || optJSONArray.length() <= 0) {
            return;
        }
        this.f62092c = new ArrayList(optJSONArray.length());
        for (int i = 0; i < optJSONArray.length(); i++) {
            JSONObject jSONObject2 = (JSONObject) optJSONArray.opt(i);
            if (jSONObject2 != null) {
                a2 a2Var = new a2();
                a2Var.Q2(jSONObject2);
                this.f62092c.add(a2Var);
            }
        }
    }
}
