package d.a.n0.v.j.g.c.c;

import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class c {

    /* renamed from: a  reason: collision with root package name */
    public String f62127a;

    /* renamed from: b  reason: collision with root package name */
    public int f62128b;

    /* renamed from: c  reason: collision with root package name */
    public List<b> f62129c = new ArrayList();

    public List<b> a() {
        if (this.f62129c == null) {
            this.f62129c = new ArrayList();
        }
        return this.f62129c;
    }

    public String b() {
        return this.f62127a;
    }

    public void c(JSONObject jSONObject) {
        this.f62127a = jSONObject.optString("mark_type_name");
        this.f62128b = jSONObject.optInt("mark_type_wear");
        JSONArray optJSONArray = jSONObject.optJSONArray("mark_list");
        if (optJSONArray != null) {
            for (int i2 = 0; i2 < optJSONArray.length(); i2++) {
                b bVar = new b();
                bVar.n(optJSONArray.optJSONObject(i2));
                bVar.o(this.f62127a);
                bVar.p(this.f62128b);
                this.f62129c.add(bVar);
            }
        }
    }
}
