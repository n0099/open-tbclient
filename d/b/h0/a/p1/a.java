package d.b.h0.a.p1;

import androidx.annotation.Nullable;
import com.baidu.cyberplayer.sdk.statistics.DpStatConstants;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    public List<C0788a> f46182a;

    /* renamed from: b  reason: collision with root package name */
    public String f46183b;

    /* renamed from: d.b.h0.a.p1.a$a  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public static class C0788a {

        /* renamed from: a  reason: collision with root package name */
        public String f46184a;

        /* renamed from: b  reason: collision with root package name */
        public String f46185b;

        /* renamed from: c  reason: collision with root package name */
        public String f46186c;
    }

    @Nullable
    public static a a(JSONObject jSONObject) {
        int length;
        if (jSONObject == null) {
            return null;
        }
        a aVar = new a();
        aVar.f46183b = jSONObject.optString("more");
        JSONArray optJSONArray = jSONObject.optJSONArray("bind_app_list");
        if (optJSONArray != null && (length = optJSONArray.length()) > 0) {
            ArrayList arrayList = new ArrayList();
            for (int i = 0; i < length; i++) {
                JSONObject optJSONObject = optJSONArray.optJSONObject(i);
                if (optJSONObject != null) {
                    C0788a c0788a = new C0788a();
                    optJSONObject.optString(com.alipay.sdk.cons.b.f1883h);
                    c0788a.f46185b = optJSONObject.optString(DpStatConstants.KEY_APP_NAME);
                    c0788a.f46184a = optJSONObject.optString("photo_addr");
                    c0788a.f46186c = optJSONObject.optString("scheme");
                    arrayList.add(c0788a);
                }
            }
            aVar.f46182a = arrayList;
            return aVar;
        }
        return null;
    }
}
