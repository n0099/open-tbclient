package d.a.m0.a.y1;

import androidx.annotation.Nullable;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    public List<C0980a> f49681a;

    /* renamed from: b  reason: collision with root package name */
    public String f49682b;

    /* renamed from: d.a.m0.a.y1.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public static class C0980a {

        /* renamed from: a  reason: collision with root package name */
        public String f49683a;

        /* renamed from: b  reason: collision with root package name */
        public String f49684b;

        /* renamed from: c  reason: collision with root package name */
        public String f49685c;
    }

    @Nullable
    public static a a(JSONObject jSONObject) {
        int length;
        if (jSONObject == null) {
            return null;
        }
        a aVar = new a();
        aVar.f49682b = jSONObject.optString("more");
        JSONArray optJSONArray = jSONObject.optJSONArray("bind_app_list");
        if (optJSONArray != null && (length = optJSONArray.length()) > 0) {
            ArrayList arrayList = new ArrayList();
            for (int i2 = 0; i2 < length; i2++) {
                JSONObject optJSONObject = optJSONArray.optJSONObject(i2);
                if (optJSONObject != null) {
                    C0980a c0980a = new C0980a();
                    optJSONObject.optString("app_key");
                    c0980a.f49684b = optJSONObject.optString("app_name");
                    c0980a.f49683a = optJSONObject.optString("photo_addr");
                    c0980a.f49685c = optJSONObject.optString("scheme");
                    arrayList.add(c0980a);
                }
            }
            aVar.f49681a = arrayList;
            return aVar;
        }
        return null;
    }
}
