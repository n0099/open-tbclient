package d.a.n0.v.d.c.e;

import com.baidu.ala.data.SdkLiveInfoData;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class j {

    /* renamed from: a  reason: collision with root package name */
    public boolean f65228a = false;

    /* renamed from: b  reason: collision with root package name */
    public ArrayList<SdkLiveInfoData> f65229b;

    public void a(JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        this.f65228a = jSONObject.optInt("has_more") == 1;
        JSONArray optJSONArray = jSONObject.optJSONArray("live_list");
        if (optJSONArray == null || optJSONArray.length() <= 0) {
            return;
        }
        this.f65229b = new ArrayList<>(optJSONArray.length());
        for (int i2 = 0; i2 < optJSONArray.length(); i2++) {
            JSONObject optJSONObject = optJSONArray.optJSONObject(i2);
            if (optJSONObject != null) {
                SdkLiveInfoData sdkLiveInfoData = new SdkLiveInfoData();
                sdkLiveInfoData.fromJson(optJSONObject);
                this.f65229b.add(sdkLiveInfoData);
            }
        }
    }
}
