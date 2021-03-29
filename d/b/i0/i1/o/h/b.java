package d.b.i0.i1.o.h;

import android.text.TextUtils;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public interface b {

    /* loaded from: classes3.dex */
    public static class a {

        /* renamed from: a  reason: collision with root package name */
        public String f55924a;

        /* renamed from: b  reason: collision with root package name */
        public String f55925b;

        /* renamed from: c  reason: collision with root package name */
        public ArrayList<String> f55926c = new ArrayList<>();

        /* renamed from: d  reason: collision with root package name */
        public ArrayList<String> f55927d = new ArrayList<>();

        public void a(JSONObject jSONObject) {
            if (jSONObject == null) {
                return;
            }
            this.f55924a = jSONObject.optString("charge_click_url");
            this.f55925b = jSONObject.optString("charge_show_url");
            JSONArray optJSONArray = jSONObject.optJSONArray("monitor_show_url");
            if (optJSONArray != null) {
                int length = optJSONArray.length();
                for (int i = 0; i < length; i++) {
                    String optString = optJSONArray.optString(i);
                    if (!TextUtils.isEmpty(optString)) {
                        this.f55926c.add(optString);
                    }
                }
            }
            JSONArray optJSONArray2 = jSONObject.optJSONArray("monitor_click_url");
            if (optJSONArray2 != null) {
                int length2 = optJSONArray2.length();
                for (int i2 = 0; i2 < length2; i2++) {
                    String optString2 = optJSONArray2.optString(i2);
                    if (!TextUtils.isEmpty(optString2)) {
                        this.f55927d.add(optString2);
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
                            this.f55926c.add(optString3);
                        }
                        String optString4 = optJSONObject.optString("click_url");
                        if (!TextUtils.isEmpty(optString4)) {
                            this.f55927d.add(optString4);
                        }
                    }
                }
            }
        }
    }

    a getParallelCharge();
}
