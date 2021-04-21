package d.b.j0.t.j.g.c.c;

import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class c {

    /* renamed from: a  reason: collision with root package name */
    public String f62913a;

    /* renamed from: b  reason: collision with root package name */
    public int f62914b;

    /* renamed from: c  reason: collision with root package name */
    public List<b> f62915c = new ArrayList();

    public List<b> a() {
        if (this.f62915c == null) {
            this.f62915c = new ArrayList();
        }
        return this.f62915c;
    }

    public String b() {
        return this.f62913a;
    }

    public void c(JSONObject jSONObject) {
        this.f62913a = jSONObject.optString("mark_type_name");
        this.f62914b = jSONObject.optInt("mark_type_wear");
        JSONArray optJSONArray = jSONObject.optJSONArray("mark_list");
        if (optJSONArray != null) {
            for (int i = 0; i < optJSONArray.length(); i++) {
                b bVar = new b();
                bVar.n(optJSONArray.optJSONObject(i));
                bVar.o(this.f62913a);
                bVar.p(this.f62914b);
                this.f62915c.add(bVar);
            }
        }
    }
}
