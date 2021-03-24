package d.b.i0.p0.w1.d;

import d.b.b.j.e.n;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class c {

    /* renamed from: a  reason: collision with root package name */
    public int f58684a;

    /* renamed from: b  reason: collision with root package name */
    public boolean f58685b;

    /* renamed from: c  reason: collision with root package name */
    public b f58686c;

    /* renamed from: d  reason: collision with root package name */
    public List<n> f58687d;

    public c(JSONObject jSONObject) {
        int length;
        if (jSONObject == null) {
            return;
        }
        this.f58684a = jSONObject.optInt("current_pn");
        this.f58685b = jSONObject.optInt("has_more", 0) == 1;
        JSONObject optJSONObject = jSONObject.optJSONObject("main_comment");
        if (optJSONObject != null) {
            this.f58686c = new b(optJSONObject);
        }
        JSONArray optJSONArray = jSONObject.optJSONArray("sub_comment");
        if (optJSONArray == null || (length = optJSONArray.length()) <= 0) {
            return;
        }
        this.f58687d = new ArrayList(length);
        for (int i = 0; i < length; i++) {
            this.f58687d.add(new d(optJSONArray.optJSONObject(i)));
        }
    }
}
