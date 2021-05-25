package d.a.n0.v.d.c.e;

import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class h {

    /* renamed from: a  reason: collision with root package name */
    public boolean f61509a = false;

    /* renamed from: b  reason: collision with root package name */
    public ArrayList<a> f61510b;

    /* renamed from: c  reason: collision with root package name */
    public String f61511c;

    /* loaded from: classes4.dex */
    public class a {

        /* renamed from: a  reason: collision with root package name */
        public String f61512a;

        public a(h hVar) {
        }

        public void a(JSONObject jSONObject) {
            if (jSONObject == null) {
                return;
            }
            jSONObject.optString("user_id");
            this.f61512a = jSONObject.optString("portrait");
        }
    }

    public void a(JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        JSONObject optJSONObject = jSONObject.optJSONObject("user_follow");
        if (optJSONObject != null) {
            this.f61509a = optJSONObject.optInt("has_follow_live") == 1;
            JSONArray optJSONArray = optJSONObject.optJSONArray("follow_live_list");
            if (optJSONArray != null && optJSONArray.length() > 0) {
                this.f61510b = new ArrayList<>(optJSONArray.length());
                for (int i2 = 0; i2 < optJSONArray.length(); i2++) {
                    JSONObject optJSONObject2 = optJSONArray.optJSONObject(i2);
                    if (optJSONObject2 != null) {
                        a aVar = new a(this);
                        aVar.a(optJSONObject2);
                        this.f61510b.add(aVar);
                    }
                }
            }
        }
        JSONObject optJSONObject3 = jSONObject.optJSONObject("live_rank");
        if (optJSONObject3 != null) {
            this.f61511c = optJSONObject3.optString("url");
        }
    }
}
