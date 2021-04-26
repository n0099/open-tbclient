package d.a.j0.q0.w1.d;

import d.a.c.j.e.n;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class c {

    /* renamed from: a  reason: collision with root package name */
    public int f58886a;

    /* renamed from: b  reason: collision with root package name */
    public boolean f58887b;

    /* renamed from: c  reason: collision with root package name */
    public b f58888c;

    /* renamed from: d  reason: collision with root package name */
    public List<n> f58889d;

    public c(JSONObject jSONObject) {
        int length;
        if (jSONObject == null) {
            return;
        }
        this.f58886a = jSONObject.optInt("current_pn");
        this.f58887b = jSONObject.optInt("has_more", 0) == 1;
        JSONObject optJSONObject = jSONObject.optJSONObject("main_comment");
        if (optJSONObject != null) {
            this.f58888c = new b(optJSONObject);
        }
        JSONArray optJSONArray = jSONObject.optJSONArray("sub_comment");
        if (optJSONArray == null || (length = optJSONArray.length()) <= 0) {
            return;
        }
        this.f58889d = new ArrayList(length);
        for (int i2 = 0; i2 < length; i2++) {
            this.f58889d.add(new d(optJSONArray.optJSONObject(i2)));
        }
    }
}
