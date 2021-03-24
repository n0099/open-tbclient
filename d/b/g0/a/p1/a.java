package d.b.g0.a.p1;

import androidx.annotation.Nullable;
import com.baidu.cyberplayer.sdk.statistics.DpStatConstants;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    public List<C0755a> f45460a;

    /* renamed from: b  reason: collision with root package name */
    public String f45461b;

    /* renamed from: d.b.g0.a.p1.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public static class C0755a {

        /* renamed from: a  reason: collision with root package name */
        public String f45462a;

        /* renamed from: b  reason: collision with root package name */
        public String f45463b;

        /* renamed from: c  reason: collision with root package name */
        public String f45464c;
    }

    @Nullable
    public static a a(JSONObject jSONObject) {
        int length;
        if (jSONObject == null) {
            return null;
        }
        a aVar = new a();
        aVar.f45461b = jSONObject.optString("more");
        JSONArray optJSONArray = jSONObject.optJSONArray("bind_app_list");
        if (optJSONArray != null && (length = optJSONArray.length()) > 0) {
            ArrayList arrayList = new ArrayList();
            for (int i = 0; i < length; i++) {
                JSONObject optJSONObject = optJSONArray.optJSONObject(i);
                if (optJSONObject != null) {
                    C0755a c0755a = new C0755a();
                    optJSONObject.optString(com.alipay.sdk.cons.b.f1858h);
                    c0755a.f45463b = optJSONObject.optString(DpStatConstants.KEY_APP_NAME);
                    c0755a.f45462a = optJSONObject.optString("photo_addr");
                    c0755a.f45464c = optJSONObject.optString("scheme");
                    arrayList.add(c0755a);
                }
            }
            aVar.f45460a = arrayList;
            return aVar;
        }
        return null;
    }
}
