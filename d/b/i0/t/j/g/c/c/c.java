package d.b.i0.t.j.g.c.c;

import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class c {

    /* renamed from: a  reason: collision with root package name */
    public String f60927a;

    /* renamed from: b  reason: collision with root package name */
    public int f60928b;

    /* renamed from: c  reason: collision with root package name */
    public List<b> f60929c = new ArrayList();

    public List<b> a() {
        if (this.f60929c == null) {
            this.f60929c = new ArrayList();
        }
        return this.f60929c;
    }

    public String b() {
        return this.f60927a;
    }

    public void c(JSONObject jSONObject) {
        this.f60927a = jSONObject.optString("mark_type_name");
        this.f60928b = jSONObject.optInt("mark_type_wear");
        JSONArray optJSONArray = jSONObject.optJSONArray("mark_list");
        if (optJSONArray != null) {
            for (int i = 0; i < optJSONArray.length(); i++) {
                b bVar = new b();
                bVar.n(optJSONArray.optJSONObject(i));
                bVar.o(this.f60927a);
                bVar.p(this.f60928b);
                this.f60929c.add(bVar);
            }
        }
    }
}
