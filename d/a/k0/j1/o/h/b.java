package d.a.k0.j1.o.h;

import android.text.TextUtils;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public interface b {

    /* loaded from: classes4.dex */
    public static class a {

        /* renamed from: a  reason: collision with root package name */
        public String f56464a;

        /* renamed from: b  reason: collision with root package name */
        public String f56465b;

        /* renamed from: c  reason: collision with root package name */
        public ArrayList<String> f56466c = new ArrayList<>();

        /* renamed from: d  reason: collision with root package name */
        public ArrayList<String> f56467d = new ArrayList<>();

        public void a(JSONObject jSONObject) {
            JSONArray optJSONArray;
            if (jSONObject == null || (optJSONArray = jSONObject.optJSONArray("ad_monitor_url")) == null) {
                return;
            }
            for (int i2 = 0; i2 < optJSONArray.length(); i2++) {
                JSONObject optJSONObject = optJSONArray.optJSONObject(i2);
                if (optJSONObject != null) {
                    String optString = optJSONObject.optString("show_url");
                    if (!TextUtils.isEmpty(optString)) {
                        this.f56466c.add(optString);
                    }
                    String optString2 = optJSONObject.optString("click_url");
                    if (!TextUtils.isEmpty(optString2)) {
                        this.f56467d.add(optString2);
                    }
                }
            }
        }
    }

    a getParallelCharge();
}
