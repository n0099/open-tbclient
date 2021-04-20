package d.b.i0.q0.w1.d;

import d.b.c.j.e.n;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class c {

    /* renamed from: a  reason: collision with root package name */
    public int f60353a;

    /* renamed from: b  reason: collision with root package name */
    public boolean f60354b;

    /* renamed from: c  reason: collision with root package name */
    public b f60355c;

    /* renamed from: d  reason: collision with root package name */
    public List<n> f60356d;

    public c(JSONObject jSONObject) {
        int length;
        if (jSONObject == null) {
            return;
        }
        this.f60353a = jSONObject.optInt("current_pn");
        this.f60354b = jSONObject.optInt("has_more", 0) == 1;
        JSONObject optJSONObject = jSONObject.optJSONObject("main_comment");
        if (optJSONObject != null) {
            this.f60355c = new b(optJSONObject);
        }
        JSONArray optJSONArray = jSONObject.optJSONArray("sub_comment");
        if (optJSONArray == null || (length = optJSONArray.length()) <= 0) {
            return;
        }
        this.f60356d = new ArrayList(length);
        for (int i = 0; i < length; i++) {
            this.f60356d.add(new d(optJSONArray.optJSONObject(i)));
        }
    }
}
