package d.a.m0.s.c;

import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class j {

    /* renamed from: a  reason: collision with root package name */
    public List<k> f54144a = new ArrayList();

    public void a(JSONObject jSONObject) throws JSONException {
        JSONArray optJSONArray;
        if (jSONObject == null || (optJSONArray = jSONObject.optJSONArray("applist")) == null || optJSONArray.length() == 0) {
            return;
        }
        for (int i2 = 0; i2 < optJSONArray.length(); i2++) {
            JSONObject jSONObject2 = optJSONArray.getJSONObject(i2);
            if (jSONObject2 != null) {
                k kVar = new k();
                kVar.a(jSONObject2);
                this.f54144a.add(kVar);
            }
        }
    }
}
