package d.a.i0.a.y1;

import androidx.annotation.Nullable;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    public List<C0910a> f45723a;

    /* renamed from: b  reason: collision with root package name */
    public String f45724b;

    /* renamed from: d.a.i0.a.y1.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public static class C0910a {

        /* renamed from: a  reason: collision with root package name */
        public String f45725a;

        /* renamed from: b  reason: collision with root package name */
        public String f45726b;

        /* renamed from: c  reason: collision with root package name */
        public String f45727c;
    }

    @Nullable
    public static a a(JSONObject jSONObject) {
        int length;
        if (jSONObject == null) {
            return null;
        }
        a aVar = new a();
        aVar.f45724b = jSONObject.optString("more");
        JSONArray optJSONArray = jSONObject.optJSONArray("bind_app_list");
        if (optJSONArray != null && (length = optJSONArray.length()) > 0) {
            ArrayList arrayList = new ArrayList();
            for (int i2 = 0; i2 < length; i2++) {
                JSONObject optJSONObject = optJSONArray.optJSONObject(i2);
                if (optJSONObject != null) {
                    C0910a c0910a = new C0910a();
                    optJSONObject.optString("app_key");
                    c0910a.f45726b = optJSONObject.optString("app_name");
                    c0910a.f45725a = optJSONObject.optString("photo_addr");
                    c0910a.f45727c = optJSONObject.optString("scheme");
                    arrayList.add(c0910a);
                }
            }
            aVar.f45723a = arrayList;
            return aVar;
        }
        return null;
    }
}
