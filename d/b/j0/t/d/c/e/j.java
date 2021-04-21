package d.b.j0.t.d.c.e;

import com.baidu.ala.data.SdkLiveInfoData;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class j {

    /* renamed from: a  reason: collision with root package name */
    public boolean f62325a = false;

    /* renamed from: b  reason: collision with root package name */
    public ArrayList<SdkLiveInfoData> f62326b;

    public void a(JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        this.f62325a = jSONObject.optInt("has_more") == 1;
        JSONArray optJSONArray = jSONObject.optJSONArray("live_list");
        if (optJSONArray == null || optJSONArray.length() <= 0) {
            return;
        }
        this.f62326b = new ArrayList<>(optJSONArray.length());
        for (int i = 0; i < optJSONArray.length(); i++) {
            JSONObject optJSONObject = optJSONArray.optJSONObject(i);
            if (optJSONObject != null) {
                SdkLiveInfoData sdkLiveInfoData = new SdkLiveInfoData();
                sdkLiveInfoData.fromJson(optJSONObject);
                this.f62326b.add(sdkLiveInfoData);
            }
        }
    }
}
