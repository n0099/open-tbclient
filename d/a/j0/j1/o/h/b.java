package d.a.j0.j1.o.h;

import android.text.TextUtils;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public interface b {

    /* loaded from: classes4.dex */
    public static class a {

        /* renamed from: a  reason: collision with root package name */
        public String f55757a;

        /* renamed from: b  reason: collision with root package name */
        public String f55758b;

        /* renamed from: c  reason: collision with root package name */
        public ArrayList<String> f55759c = new ArrayList<>();

        /* renamed from: d  reason: collision with root package name */
        public ArrayList<String> f55760d = new ArrayList<>();

        public void a(JSONObject jSONObject) {
            if (jSONObject == null) {
                return;
            }
            this.f55757a = jSONObject.optString("charge_click_url");
            this.f55758b = jSONObject.optString("charge_show_url");
            JSONArray optJSONArray = jSONObject.optJSONArray("monitor_show_url");
            if (optJSONArray != null) {
                int length = optJSONArray.length();
                for (int i2 = 0; i2 < length; i2++) {
                    String optString = optJSONArray.optString(i2);
                    if (!TextUtils.isEmpty(optString)) {
                        this.f55759c.add(optString);
                    }
                }
            }
            JSONArray optJSONArray2 = jSONObject.optJSONArray("monitor_click_url");
            if (optJSONArray2 != null) {
                int length2 = optJSONArray2.length();
                for (int i3 = 0; i3 < length2; i3++) {
                    String optString2 = optJSONArray2.optString(i3);
                    if (!TextUtils.isEmpty(optString2)) {
                        this.f55760d.add(optString2);
                    }
                }
            }
            JSONArray optJSONArray3 = jSONObject.optJSONArray("ad_monitor_url");
            if (optJSONArray3 != null) {
                for (int i4 = 0; i4 < optJSONArray3.length(); i4++) {
                    JSONObject optJSONObject = optJSONArray3.optJSONObject(i4);
                    if (optJSONObject != null) {
                        String optString3 = optJSONObject.optString("show_url");
                        if (!TextUtils.isEmpty(optString3)) {
                            this.f55759c.add(optString3);
                        }
                        String optString4 = optJSONObject.optString("click_url");
                        if (!TextUtils.isEmpty(optString4)) {
                            this.f55760d.add(optString4);
                        }
                    }
                }
            }
        }
    }

    a getParallelCharge();
}
