package d.a.h0.a.p1;

import androidx.annotation.Nullable;
import com.baidu.cyberplayer.sdk.statistics.DpStatConstants;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    public List<C0727a> f43529a;

    /* renamed from: b  reason: collision with root package name */
    public String f43530b;

    /* renamed from: d.a.h0.a.p1.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public static class C0727a {

        /* renamed from: a  reason: collision with root package name */
        public String f43531a;

        /* renamed from: b  reason: collision with root package name */
        public String f43532b;

        /* renamed from: c  reason: collision with root package name */
        public String f43533c;
    }

    @Nullable
    public static a a(JSONObject jSONObject) {
        int length;
        if (jSONObject == null) {
            return null;
        }
        a aVar = new a();
        aVar.f43530b = jSONObject.optString("more");
        JSONArray optJSONArray = jSONObject.optJSONArray("bind_app_list");
        if (optJSONArray != null && (length = optJSONArray.length()) > 0) {
            ArrayList arrayList = new ArrayList();
            for (int i2 = 0; i2 < length; i2++) {
                JSONObject optJSONObject = optJSONArray.optJSONObject(i2);
                if (optJSONObject != null) {
                    C0727a c0727a = new C0727a();
                    optJSONObject.optString(com.alipay.sdk.cons.b.f1831h);
                    c0727a.f43532b = optJSONObject.optString(DpStatConstants.KEY_APP_NAME);
                    c0727a.f43531a = optJSONObject.optString("photo_addr");
                    c0727a.f43533c = optJSONObject.optString("scheme");
                    arrayList.add(c0727a);
                }
            }
            aVar.f43529a = arrayList;
            return aVar;
        }
        return null;
    }
}
