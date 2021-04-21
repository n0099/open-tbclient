package d.b.j0.g0.e;

import com.heytap.mcssdk.mode.Message;
import d.b.c.e.p.k;
import java.util.HashMap;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    public String f56496a = "";

    /* renamed from: b  reason: collision with root package name */
    public HashMap<String, String> f56497b;

    /* renamed from: c  reason: collision with root package name */
    public boolean f56498c;

    public String a() {
        return this.f56496a;
    }

    public HashMap<String, String> b() {
        return this.f56497b;
    }

    public boolean c() {
        return this.f56498c;
    }

    public void d(JSONObject jSONObject) {
        JSONObject optJSONObject;
        JSONObject optJSONObject2 = jSONObject.optJSONObject("data");
        if (optJSONObject2 == null || (optJSONObject = optJSONObject2.optJSONObject("hotmonitor")) == null) {
            return;
        }
        this.f56496a = optJSONObject.optString("link");
        this.f56498c = optJSONObject.optInt("open", 0) == 1;
        JSONArray optJSONArray = optJSONObject.optJSONArray("config");
        if (optJSONArray == null || optJSONArray.length() == 0) {
            return;
        }
        this.f56497b = new HashMap<>();
        for (int i = 0; i < optJSONArray.length(); i++) {
            JSONObject optJSONObject3 = optJSONArray.optJSONObject(i);
            if (optJSONObject3 != null) {
                String optString = optJSONObject3.optString("event");
                String optString2 = optJSONObject3.optString(Message.RULE);
                if (!k.isEmpty(optString) && !k.isEmpty(optString2)) {
                    this.f56497b.put(optString, optString2);
                }
            }
        }
    }
}
