package d.b.g0.l.l;

import java.util.Map;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public interface f {

    /* loaded from: classes3.dex */
    public interface a {
        void a(String str, String str2, JSONObject jSONObject);

        void b(String str, int i);

        void onFail(Exception exc);
    }

    void a(String str, Map<String, String> map, Map<String, String> map2, JSONObject jSONObject, a aVar);

    void b(String str, Map<String, String> map, Map<String, String> map2, a aVar);
}
