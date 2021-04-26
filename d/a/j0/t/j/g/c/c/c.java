package d.a.j0.t.j.g.c.c;

import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class c {

    /* renamed from: a  reason: collision with root package name */
    public String f61115a;

    /* renamed from: b  reason: collision with root package name */
    public int f61116b;

    /* renamed from: c  reason: collision with root package name */
    public List<b> f61117c = new ArrayList();

    public List<b> a() {
        if (this.f61117c == null) {
            this.f61117c = new ArrayList();
        }
        return this.f61117c;
    }

    public String b() {
        return this.f61115a;
    }

    public void c(JSONObject jSONObject) {
        this.f61115a = jSONObject.optString("mark_type_name");
        this.f61116b = jSONObject.optInt("mark_type_wear");
        JSONArray optJSONArray = jSONObject.optJSONArray("mark_list");
        if (optJSONArray != null) {
            for (int i2 = 0; i2 < optJSONArray.length(); i2++) {
                b bVar = new b();
                bVar.n(optJSONArray.optJSONObject(i2));
                bVar.o(this.f61115a);
                bVar.p(this.f61116b);
                this.f61117c.add(bVar);
            }
        }
    }
}
