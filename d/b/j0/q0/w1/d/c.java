package d.b.j0.q0.w1.d;

import d.b.c.j.e.n;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class c {

    /* renamed from: a  reason: collision with root package name */
    public int f60774a;

    /* renamed from: b  reason: collision with root package name */
    public boolean f60775b;

    /* renamed from: c  reason: collision with root package name */
    public b f60776c;

    /* renamed from: d  reason: collision with root package name */
    public List<n> f60777d;

    public c(JSONObject jSONObject) {
        int length;
        if (jSONObject == null) {
            return;
        }
        this.f60774a = jSONObject.optInt("current_pn");
        this.f60775b = jSONObject.optInt("has_more", 0) == 1;
        JSONObject optJSONObject = jSONObject.optJSONObject("main_comment");
        if (optJSONObject != null) {
            this.f60776c = new b(optJSONObject);
        }
        JSONArray optJSONArray = jSONObject.optJSONArray("sub_comment");
        if (optJSONArray == null || (length = optJSONArray.length()) <= 0) {
            return;
        }
        this.f60777d = new ArrayList(length);
        for (int i = 0; i < length; i++) {
            this.f60777d.add(new d(optJSONArray.optJSONObject(i)));
        }
    }
}
