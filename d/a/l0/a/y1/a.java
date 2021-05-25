package d.a.l0.a.y1;

import androidx.annotation.Nullable;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    public List<C0921a> f45899a;

    /* renamed from: b  reason: collision with root package name */
    public String f45900b;

    /* renamed from: d.a.l0.a.y1.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public static class C0921a {

        /* renamed from: a  reason: collision with root package name */
        public String f45901a;

        /* renamed from: b  reason: collision with root package name */
        public String f45902b;

        /* renamed from: c  reason: collision with root package name */
        public String f45903c;
    }

    @Nullable
    public static a a(JSONObject jSONObject) {
        int length;
        if (jSONObject == null) {
            return null;
        }
        a aVar = new a();
        aVar.f45900b = jSONObject.optString("more");
        JSONArray optJSONArray = jSONObject.optJSONArray("bind_app_list");
        if (optJSONArray != null && (length = optJSONArray.length()) > 0) {
            ArrayList arrayList = new ArrayList();
            for (int i2 = 0; i2 < length; i2++) {
                JSONObject optJSONObject = optJSONArray.optJSONObject(i2);
                if (optJSONObject != null) {
                    C0921a c0921a = new C0921a();
                    optJSONObject.optString("app_key");
                    c0921a.f45902b = optJSONObject.optString("app_name");
                    c0921a.f45901a = optJSONObject.optString("photo_addr");
                    c0921a.f45903c = optJSONObject.optString("scheme");
                    arrayList.add(c0921a);
                }
            }
            aVar.f45899a = arrayList;
            return aVar;
        }
        return null;
    }
}
