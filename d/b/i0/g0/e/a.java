package d.b.i0.g0.e;

import com.heytap.mcssdk.mode.Message;
import d.b.b.e.p.k;
import java.util.HashMap;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    public String f54901a = "";

    /* renamed from: b  reason: collision with root package name */
    public HashMap<String, String> f54902b;

    /* renamed from: c  reason: collision with root package name */
    public boolean f54903c;

    public String a() {
        return this.f54901a;
    }

    public HashMap<String, String> b() {
        return this.f54902b;
    }

    public boolean c() {
        return this.f54903c;
    }

    public void d(JSONObject jSONObject) {
        JSONObject optJSONObject;
        JSONObject optJSONObject2 = jSONObject.optJSONObject("data");
        if (optJSONObject2 == null || (optJSONObject = optJSONObject2.optJSONObject("hotmonitor")) == null) {
            return;
        }
        this.f54901a = optJSONObject.optString("link");
        this.f54903c = optJSONObject.optInt("open", 0) == 1;
        JSONArray optJSONArray = optJSONObject.optJSONArray("config");
        if (optJSONArray == null || optJSONArray.length() == 0) {
            return;
        }
        this.f54902b = new HashMap<>();
        for (int i = 0; i < optJSONArray.length(); i++) {
            JSONObject optJSONObject3 = optJSONArray.optJSONObject(i);
            if (optJSONObject3 != null) {
                String optString = optJSONObject3.optString("event");
                String optString2 = optJSONObject3.optString(Message.RULE);
                if (!k.isEmpty(optString) && !k.isEmpty(optString2)) {
                    this.f54902b.put(optString, optString2);
                }
            }
        }
    }
}
