package d.b.i0.z2.j;

import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes5.dex */
public class b extends d.b.i0.z2.f.a {

    /* renamed from: c  reason: collision with root package name */
    public ArrayList<d> f63540c = new ArrayList<>();

    @Override // d.b.i0.z2.f.a
    public void d(JSONObject jSONObject) throws Exception {
        ArrayList<d> arrayList = new ArrayList<>();
        JSONArray optJSONArray = jSONObject.optJSONArray("forum_dir");
        if (optJSONArray != null) {
            for (int i = 0; i < optJSONArray.length(); i++) {
                d dVar = new d();
                dVar.a(optJSONArray.getJSONObject(i));
                arrayList.add(dVar);
            }
        }
        i(arrayList);
    }

    public ArrayList<d> h() {
        return this.f63540c;
    }

    public void i(ArrayList<d> arrayList) {
        this.f63540c = arrayList;
        g(null);
    }
}
