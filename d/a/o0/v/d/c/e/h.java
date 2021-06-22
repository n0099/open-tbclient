package d.a.o0.v.d.c.e;

import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class h {

    /* renamed from: a  reason: collision with root package name */
    public boolean f65347a = false;

    /* renamed from: b  reason: collision with root package name */
    public ArrayList<a> f65348b;

    /* renamed from: c  reason: collision with root package name */
    public String f65349c;

    /* loaded from: classes4.dex */
    public class a {

        /* renamed from: a  reason: collision with root package name */
        public String f65350a;

        public a(h hVar) {
        }

        public void a(JSONObject jSONObject) {
            if (jSONObject == null) {
                return;
            }
            jSONObject.optString("user_id");
            this.f65350a = jSONObject.optString("portrait");
        }
    }

    public void a(JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        JSONObject optJSONObject = jSONObject.optJSONObject("user_follow");
        if (optJSONObject != null) {
            this.f65347a = optJSONObject.optInt("has_follow_live") == 1;
            JSONArray optJSONArray = optJSONObject.optJSONArray("follow_live_list");
            if (optJSONArray != null && optJSONArray.length() > 0) {
                this.f65348b = new ArrayList<>(optJSONArray.length());
                for (int i2 = 0; i2 < optJSONArray.length(); i2++) {
                    JSONObject optJSONObject2 = optJSONArray.optJSONObject(i2);
                    if (optJSONObject2 != null) {
                        a aVar = new a(this);
                        aVar.a(optJSONObject2);
                        this.f65348b.add(aVar);
                    }
                }
            }
        }
        JSONObject optJSONObject3 = jSONObject.optJSONObject("live_rank");
        if (optJSONObject3 != null) {
            this.f65349c = optJSONObject3.optString("url");
        }
    }
}
