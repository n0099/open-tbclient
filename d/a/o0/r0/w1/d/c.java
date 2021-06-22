package d.a.o0.r0.w1.d;

import d.a.c.k.e.n;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class c {

    /* renamed from: a  reason: collision with root package name */
    public int f63585a;

    /* renamed from: b  reason: collision with root package name */
    public boolean f63586b;

    /* renamed from: c  reason: collision with root package name */
    public b f63587c;

    /* renamed from: d  reason: collision with root package name */
    public List<n> f63588d;

    public c(JSONObject jSONObject) {
        int length;
        if (jSONObject == null) {
            return;
        }
        this.f63585a = jSONObject.optInt("current_pn");
        this.f63586b = jSONObject.optInt("has_more", 0) == 1;
        JSONObject optJSONObject = jSONObject.optJSONObject("main_comment");
        if (optJSONObject != null) {
            this.f63587c = new b(optJSONObject);
        }
        JSONArray optJSONArray = jSONObject.optJSONArray("sub_comment");
        if (optJSONArray == null || (length = optJSONArray.length()) <= 0) {
            return;
        }
        this.f63588d = new ArrayList(length);
        for (int i2 = 0; i2 < length; i2++) {
            this.f63588d.add(new d(optJSONArray.optJSONObject(i2)));
        }
    }
}
