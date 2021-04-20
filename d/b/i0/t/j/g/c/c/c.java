package d.b.i0.t.j.g.c.c;

import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class c {

    /* renamed from: a  reason: collision with root package name */
    public String f62492a;

    /* renamed from: b  reason: collision with root package name */
    public int f62493b;

    /* renamed from: c  reason: collision with root package name */
    public List<b> f62494c = new ArrayList();

    public List<b> a() {
        if (this.f62494c == null) {
            this.f62494c = new ArrayList();
        }
        return this.f62494c;
    }

    public String b() {
        return this.f62492a;
    }

    public void c(JSONObject jSONObject) {
        this.f62492a = jSONObject.optString("mark_type_name");
        this.f62493b = jSONObject.optInt("mark_type_wear");
        JSONArray optJSONArray = jSONObject.optJSONArray("mark_list");
        if (optJSONArray != null) {
            for (int i = 0; i < optJSONArray.length(); i++) {
                b bVar = new b();
                bVar.n(optJSONArray.optJSONObject(i));
                bVar.o(this.f62492a);
                bVar.p(this.f62493b);
                this.f62494c.add(bVar);
            }
        }
    }
}
