package d.b.j0.t.d.c.e;

import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class h {

    /* renamed from: a  reason: collision with root package name */
    public boolean f62319a = false;

    /* renamed from: b  reason: collision with root package name */
    public ArrayList<a> f62320b;

    /* renamed from: c  reason: collision with root package name */
    public String f62321c;

    /* loaded from: classes4.dex */
    public class a {

        /* renamed from: a  reason: collision with root package name */
        public String f62322a;

        public a(h hVar) {
        }

        public void a(JSONObject jSONObject) {
            if (jSONObject == null) {
                return;
            }
            jSONObject.optString("user_id");
            this.f62322a = jSONObject.optString("portrait");
        }
    }

    public void a(JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        JSONObject optJSONObject = jSONObject.optJSONObject("user_follow");
        if (optJSONObject != null) {
            this.f62319a = optJSONObject.optInt("has_follow_live") == 1;
            JSONArray optJSONArray = optJSONObject.optJSONArray("follow_live_list");
            if (optJSONArray != null && optJSONArray.length() > 0) {
                this.f62320b = new ArrayList<>(optJSONArray.length());
                for (int i = 0; i < optJSONArray.length(); i++) {
                    JSONObject optJSONObject2 = optJSONArray.optJSONObject(i);
                    if (optJSONObject2 != null) {
                        a aVar = new a(this);
                        aVar.a(optJSONObject2);
                        this.f62320b.add(aVar);
                    }
                }
            }
        }
        JSONObject optJSONObject3 = jSONObject.optJSONObject("live_rank");
        if (optJSONObject3 != null) {
            this.f62321c = optJSONObject3.optString("url");
        }
    }
}
