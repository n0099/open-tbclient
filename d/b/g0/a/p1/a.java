package d.b.g0.a.p1;

import androidx.annotation.Nullable;
import com.baidu.cyberplayer.sdk.statistics.DpStatConstants;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    public List<C0756a> f45461a;

    /* renamed from: b  reason: collision with root package name */
    public String f45462b;

    /* renamed from: d.b.g0.a.p1.a$a  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public static class C0756a {

        /* renamed from: a  reason: collision with root package name */
        public String f45463a;

        /* renamed from: b  reason: collision with root package name */
        public String f45464b;

        /* renamed from: c  reason: collision with root package name */
        public String f45465c;
    }

    @Nullable
    public static a a(JSONObject jSONObject) {
        int length;
        if (jSONObject == null) {
            return null;
        }
        a aVar = new a();
        aVar.f45462b = jSONObject.optString("more");
        JSONArray optJSONArray = jSONObject.optJSONArray("bind_app_list");
        if (optJSONArray != null && (length = optJSONArray.length()) > 0) {
            ArrayList arrayList = new ArrayList();
            for (int i = 0; i < length; i++) {
                JSONObject optJSONObject = optJSONArray.optJSONObject(i);
                if (optJSONObject != null) {
                    C0756a c0756a = new C0756a();
                    optJSONObject.optString(com.alipay.sdk.cons.b.f1858h);
                    c0756a.f45464b = optJSONObject.optString(DpStatConstants.KEY_APP_NAME);
                    c0756a.f45463a = optJSONObject.optString("photo_addr");
                    c0756a.f45465c = optJSONObject.optString("scheme");
                    arrayList.add(c0756a);
                }
            }
            aVar.f45461a = arrayList;
            return aVar;
        }
        return null;
    }
}
