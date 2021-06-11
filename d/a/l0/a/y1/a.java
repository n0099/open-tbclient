package d.a.l0.a.y1;

import androidx.annotation.Nullable;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    public List<C0977a> f49573a;

    /* renamed from: b  reason: collision with root package name */
    public String f49574b;

    /* renamed from: d.a.l0.a.y1.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public static class C0977a {

        /* renamed from: a  reason: collision with root package name */
        public String f49575a;

        /* renamed from: b  reason: collision with root package name */
        public String f49576b;

        /* renamed from: c  reason: collision with root package name */
        public String f49577c;
    }

    @Nullable
    public static a a(JSONObject jSONObject) {
        int length;
        if (jSONObject == null) {
            return null;
        }
        a aVar = new a();
        aVar.f49574b = jSONObject.optString("more");
        JSONArray optJSONArray = jSONObject.optJSONArray("bind_app_list");
        if (optJSONArray != null && (length = optJSONArray.length()) > 0) {
            ArrayList arrayList = new ArrayList();
            for (int i2 = 0; i2 < length; i2++) {
                JSONObject optJSONObject = optJSONArray.optJSONObject(i2);
                if (optJSONObject != null) {
                    C0977a c0977a = new C0977a();
                    optJSONObject.optString("app_key");
                    c0977a.f49576b = optJSONObject.optString("app_name");
                    c0977a.f49575a = optJSONObject.optString("photo_addr");
                    c0977a.f49577c = optJSONObject.optString("scheme");
                    arrayList.add(c0977a);
                }
            }
            aVar.f49573a = arrayList;
            return aVar;
        }
        return null;
    }
}
