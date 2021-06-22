package d.a.o0.h0.e;

import com.heytap.mcssdk.mode.Message;
import d.a.c.e.p.k;
import java.util.HashMap;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    public String f59181a = "";

    /* renamed from: b  reason: collision with root package name */
    public HashMap<String, String> f59182b;

    /* renamed from: c  reason: collision with root package name */
    public boolean f59183c;

    public String a() {
        return this.f59181a;
    }

    public HashMap<String, String> b() {
        return this.f59182b;
    }

    public boolean c() {
        return this.f59183c;
    }

    public void d(JSONObject jSONObject) {
        JSONObject optJSONObject;
        JSONObject optJSONObject2 = jSONObject.optJSONObject("data");
        if (optJSONObject2 == null || (optJSONObject = optJSONObject2.optJSONObject("hotmonitor")) == null) {
            return;
        }
        this.f59181a = optJSONObject.optString("link");
        this.f59183c = optJSONObject.optInt("open", 0) == 1;
        JSONArray optJSONArray = optJSONObject.optJSONArray("config");
        if (optJSONArray == null || optJSONArray.length() == 0) {
            return;
        }
        this.f59182b = new HashMap<>();
        for (int i2 = 0; i2 < optJSONArray.length(); i2++) {
            JSONObject optJSONObject3 = optJSONArray.optJSONObject(i2);
            if (optJSONObject3 != null) {
                String optString = optJSONObject3.optString("event");
                String optString2 = optJSONObject3.optString(Message.RULE);
                if (!k.isEmpty(optString) && !k.isEmpty(optString2)) {
                    this.f59182b.put(optString, optString2);
                }
            }
        }
    }
}
