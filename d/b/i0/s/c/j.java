package d.b.i0.s.c;

import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class j {

    /* renamed from: a  reason: collision with root package name */
    public List<k> f51935a = new ArrayList();

    public void a(JSONObject jSONObject) throws JSONException {
        JSONArray optJSONArray;
        if (jSONObject == null || (optJSONArray = jSONObject.optJSONArray("applist")) == null || optJSONArray.length() == 0) {
            return;
        }
        for (int i = 0; i < optJSONArray.length(); i++) {
            JSONObject jSONObject2 = optJSONArray.getJSONObject(i);
            if (jSONObject2 != null) {
                k kVar = new k();
                kVar.a(jSONObject2);
                this.f51935a.add(kVar);
            }
        }
    }
}
