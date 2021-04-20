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
    public List<C0768a> f45853a;

    /* renamed from: b  reason: collision with root package name */
    public String f45854b;

    /* renamed from: d.b.g0.a.p1.a$a  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public static class C0768a {

        /* renamed from: a  reason: collision with root package name */
        public String f45855a;

        /* renamed from: b  reason: collision with root package name */
        public String f45856b;

        /* renamed from: c  reason: collision with root package name */
        public String f45857c;
    }

    @Nullable
    public static a a(JSONObject jSONObject) {
        int length;
        if (jSONObject == null) {
            return null;
        }
        a aVar = new a();
        aVar.f45854b = jSONObject.optString("more");
        JSONArray optJSONArray = jSONObject.optJSONArray("bind_app_list");
        if (optJSONArray != null && (length = optJSONArray.length()) > 0) {
            ArrayList arrayList = new ArrayList();
            for (int i = 0; i < length; i++) {
                JSONObject optJSONObject = optJSONArray.optJSONObject(i);
                if (optJSONObject != null) {
                    C0768a c0768a = new C0768a();
                    optJSONObject.optString(com.alipay.sdk.cons.b.f1883h);
                    c0768a.f45856b = optJSONObject.optString(DpStatConstants.KEY_APP_NAME);
                    c0768a.f45855a = optJSONObject.optString("photo_addr");
                    c0768a.f45857c = optJSONObject.optString("scheme");
                    arrayList.add(c0768a);
                }
            }
            aVar.f45853a = arrayList;
            return aVar;
        }
        return null;
    }
}
