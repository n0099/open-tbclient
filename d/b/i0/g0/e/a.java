package d.b.i0.g0.e;

import com.heytap.mcssdk.mode.Message;
import d.b.c.e.p.k;
import java.util.HashMap;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    public String f56075a = "";

    /* renamed from: b  reason: collision with root package name */
    public HashMap<String, String> f56076b;

    /* renamed from: c  reason: collision with root package name */
    public boolean f56077c;

    public String a() {
        return this.f56075a;
    }

    public HashMap<String, String> b() {
        return this.f56076b;
    }

    public boolean c() {
        return this.f56077c;
    }

    public void d(JSONObject jSONObject) {
        JSONObject optJSONObject;
        JSONObject optJSONObject2 = jSONObject.optJSONObject("data");
        if (optJSONObject2 == null || (optJSONObject = optJSONObject2.optJSONObject("hotmonitor")) == null) {
            return;
        }
        this.f56075a = optJSONObject.optString("link");
        this.f56077c = optJSONObject.optInt("open", 0) == 1;
        JSONArray optJSONArray = optJSONObject.optJSONArray("config");
        if (optJSONArray == null || optJSONArray.length() == 0) {
            return;
        }
        this.f56076b = new HashMap<>();
        for (int i = 0; i < optJSONArray.length(); i++) {
            JSONObject optJSONObject3 = optJSONArray.optJSONObject(i);
            if (optJSONObject3 != null) {
                String optString = optJSONObject3.optString("event");
                String optString2 = optJSONObject3.optString(Message.RULE);
                if (!k.isEmpty(optString) && !k.isEmpty(optString2)) {
                    this.f56076b.put(optString, optString2);
                }
            }
        }
    }
}
