package d.a.j0.a3.j;

import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes5.dex */
public class b extends d.a.j0.a3.f.a {

    /* renamed from: c  reason: collision with root package name */
    public ArrayList<d> f51316c = new ArrayList<>();

    @Override // d.a.j0.a3.f.a
    public void d(JSONObject jSONObject) throws Exception {
        ArrayList<d> arrayList = new ArrayList<>();
        JSONArray optJSONArray = jSONObject.optJSONArray("forum_dir");
        if (optJSONArray != null) {
            for (int i2 = 0; i2 < optJSONArray.length(); i2++) {
                d dVar = new d();
                dVar.a(optJSONArray.getJSONObject(i2));
                arrayList.add(dVar);
            }
        }
        i(arrayList);
    }

    public ArrayList<d> h() {
        return this.f51316c;
    }

    public void i(ArrayList<d> arrayList) {
        this.f51316c = arrayList;
        g(null);
    }
}
