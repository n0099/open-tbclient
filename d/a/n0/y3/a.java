package d.a.n0.y3;

import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes5.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    public List<C1809a> f67155a = new ArrayList();

    /* renamed from: d.a.n0.y3.a$a  reason: collision with other inner class name */
    /* loaded from: classes5.dex */
    public static class C1809a {

        /* renamed from: a  reason: collision with root package name */
        public int f67156a;

        /* renamed from: b  reason: collision with root package name */
        public String f67157b;
    }

    public List<C1809a> a() {
        return this.f67155a;
    }

    public final void b(JSONArray jSONArray) {
        if (jSONArray != null) {
            try {
                if (jSONArray.length() > 0) {
                    if (this.f67155a == null) {
                        this.f67155a = new ArrayList();
                    }
                    int length = jSONArray.length();
                    for (int i2 = 0; i2 < length; i2++) {
                        C1809a c1809a = new C1809a();
                        JSONObject optJSONObject = jSONArray.optJSONObject(i2);
                        c1809a.f67156a = optJSONObject.optInt("tab_id");
                        c1809a.f67157b = optJSONObject.optString("tab_name");
                        optJSONObject.optInt("obj_type");
                        this.f67155a.add(c1809a);
                    }
                }
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
    }

    public void c(JSONArray jSONArray) {
        if (jSONArray != null) {
            b(jSONArray);
        }
    }
}
