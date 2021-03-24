package d.b.i0.t.d.f.c;

import d.b.h0.r.q.a2;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    public String f60525a;

    /* renamed from: b  reason: collision with root package name */
    public String f60526b;

    /* renamed from: c  reason: collision with root package name */
    public List<a2> f60527c;

    /* renamed from: d  reason: collision with root package name */
    public int f60528d;

    /* renamed from: e  reason: collision with root package name */
    public int f60529e;

    public void a(JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        this.f60525a = jSONObject.optString("head_pic");
        jSONObject.optString("url_type");
        this.f60526b = jSONObject.optString("url");
        this.f60528d = jSONObject.optInt("head_type", 0);
        this.f60529e = jSONObject.optInt("is_set", -1);
        JSONArray optJSONArray = jSONObject.optJSONArray("head_thread");
        if (optJSONArray == null || optJSONArray.length() <= 0) {
            return;
        }
        this.f60527c = new ArrayList(optJSONArray.length());
        for (int i = 0; i < optJSONArray.length(); i++) {
            JSONObject jSONObject2 = (JSONObject) optJSONArray.opt(i);
            if (jSONObject2 != null) {
                a2 a2Var = new a2();
                a2Var.P2(jSONObject2);
                this.f60527c.add(a2Var);
            }
        }
    }
}
