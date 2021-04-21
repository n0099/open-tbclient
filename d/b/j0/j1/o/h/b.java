package d.b.j0.j1.o.h;

import android.text.TextUtils;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public interface b {

    /* loaded from: classes4.dex */
    public static class a {

        /* renamed from: a  reason: collision with root package name */
        public String f57792a;

        /* renamed from: b  reason: collision with root package name */
        public String f57793b;

        /* renamed from: c  reason: collision with root package name */
        public ArrayList<String> f57794c = new ArrayList<>();

        /* renamed from: d  reason: collision with root package name */
        public ArrayList<String> f57795d = new ArrayList<>();

        public void a(JSONObject jSONObject) {
            if (jSONObject == null) {
                return;
            }
            this.f57792a = jSONObject.optString("charge_click_url");
            this.f57793b = jSONObject.optString("charge_show_url");
            JSONArray optJSONArray = jSONObject.optJSONArray("monitor_show_url");
            if (optJSONArray != null) {
                int length = optJSONArray.length();
                for (int i = 0; i < length; i++) {
                    String optString = optJSONArray.optString(i);
                    if (!TextUtils.isEmpty(optString)) {
                        this.f57794c.add(optString);
                    }
                }
            }
            JSONArray optJSONArray2 = jSONObject.optJSONArray("monitor_click_url");
            if (optJSONArray2 != null) {
                int length2 = optJSONArray2.length();
                for (int i2 = 0; i2 < length2; i2++) {
                    String optString2 = optJSONArray2.optString(i2);
                    if (!TextUtils.isEmpty(optString2)) {
                        this.f57795d.add(optString2);
                    }
                }
            }
            JSONArray optJSONArray3 = jSONObject.optJSONArray("ad_monitor_url");
            if (optJSONArray3 != null) {
                for (int i3 = 0; i3 < optJSONArray3.length(); i3++) {
                    JSONObject optJSONObject = optJSONArray3.optJSONObject(i3);
                    if (optJSONObject != null) {
                        String optString3 = optJSONObject.optString("show_url");
                        if (!TextUtils.isEmpty(optString3)) {
                            this.f57794c.add(optString3);
                        }
                        String optString4 = optJSONObject.optString("click_url");
                        if (!TextUtils.isEmpty(optString4)) {
                            this.f57795d.add(optString4);
                        }
                    }
                }
            }
        }
    }

    a getParallelCharge();
}
