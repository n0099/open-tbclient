package d.a.o0.y3;

import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes5.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    public List<C1813a> f67280a = new ArrayList();

    /* renamed from: d.a.o0.y3.a$a  reason: collision with other inner class name */
    /* loaded from: classes5.dex */
    public static class C1813a {

        /* renamed from: a  reason: collision with root package name */
        public int f67281a;

        /* renamed from: b  reason: collision with root package name */
        public String f67282b;
    }

    public List<C1813a> a() {
        return this.f67280a;
    }

    public final void b(JSONArray jSONArray) {
        if (jSONArray != null) {
            try {
                if (jSONArray.length() > 0) {
                    if (this.f67280a == null) {
                        this.f67280a = new ArrayList();
                    }
                    int length = jSONArray.length();
                    for (int i2 = 0; i2 < length; i2++) {
                        C1813a c1813a = new C1813a();
                        JSONObject optJSONObject = jSONArray.optJSONObject(i2);
                        c1813a.f67281a = optJSONObject.optInt("tab_id");
                        c1813a.f67282b = optJSONObject.optString("tab_name");
                        optJSONObject.optInt("obj_type");
                        this.f67280a.add(c1813a);
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
