package d.a.n0.r0.w1.d;

import d.a.c.k.e.n;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class c {

    /* renamed from: a  reason: collision with root package name */
    public int f63460a;

    /* renamed from: b  reason: collision with root package name */
    public boolean f63461b;

    /* renamed from: c  reason: collision with root package name */
    public b f63462c;

    /* renamed from: d  reason: collision with root package name */
    public List<n> f63463d;

    public c(JSONObject jSONObject) {
        int length;
        if (jSONObject == null) {
            return;
        }
        this.f63460a = jSONObject.optInt("current_pn");
        this.f63461b = jSONObject.optInt("has_more", 0) == 1;
        JSONObject optJSONObject = jSONObject.optJSONObject("main_comment");
        if (optJSONObject != null) {
            this.f63462c = new b(optJSONObject);
        }
        JSONArray optJSONArray = jSONObject.optJSONArray("sub_comment");
        if (optJSONArray == null || (length = optJSONArray.length()) <= 0) {
            return;
        }
        this.f63463d = new ArrayList(length);
        for (int i2 = 0; i2 < length; i2++) {
            this.f63463d.add(new d(optJSONArray.optJSONObject(i2)));
        }
    }
}
