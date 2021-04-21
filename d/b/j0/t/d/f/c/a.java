package d.b.j0.t.d.f.c;

import d.b.i0.r.q.a2;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    public String f62511a;

    /* renamed from: b  reason: collision with root package name */
    public String f62512b;

    /* renamed from: c  reason: collision with root package name */
    public List<a2> f62513c;

    /* renamed from: d  reason: collision with root package name */
    public int f62514d;

    /* renamed from: e  reason: collision with root package name */
    public int f62515e;

    public void a(JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        this.f62511a = jSONObject.optString("head_pic");
        jSONObject.optString("url_type");
        this.f62512b = jSONObject.optString("url");
        this.f62514d = jSONObject.optInt("head_type", 0);
        this.f62515e = jSONObject.optInt("is_set", -1);
        JSONArray optJSONArray = jSONObject.optJSONArray("head_thread");
        if (optJSONArray == null || optJSONArray.length() <= 0) {
            return;
        }
        this.f62513c = new ArrayList(optJSONArray.length());
        for (int i = 0; i < optJSONArray.length(); i++) {
            JSONObject jSONObject2 = (JSONObject) optJSONArray.opt(i);
            if (jSONObject2 != null) {
                a2 a2Var = new a2();
                a2Var.Q2(jSONObject2);
                this.f62513c.add(a2Var);
            }
        }
    }
}
