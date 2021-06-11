package d.a.n0.v.j.g.c.c;

import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class c {

    /* renamed from: a  reason: collision with root package name */
    public String f65842a;

    /* renamed from: b  reason: collision with root package name */
    public int f65843b;

    /* renamed from: c  reason: collision with root package name */
    public List<b> f65844c = new ArrayList();

    public List<b> a() {
        if (this.f65844c == null) {
            this.f65844c = new ArrayList();
        }
        return this.f65844c;
    }

    public String b() {
        return this.f65842a;
    }

    public void c(JSONObject jSONObject) {
        this.f65842a = jSONObject.optString("mark_type_name");
        this.f65843b = jSONObject.optInt("mark_type_wear");
        JSONArray optJSONArray = jSONObject.optJSONArray("mark_list");
        if (optJSONArray != null) {
            for (int i2 = 0; i2 < optJSONArray.length(); i2++) {
                b bVar = new b();
                bVar.n(optJSONArray.optJSONObject(i2));
                bVar.o(this.f65842a);
                bVar.p(this.f65843b);
                this.f65844c.add(bVar);
            }
        }
    }
}
