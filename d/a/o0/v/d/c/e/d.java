package d.a.o0.v.d.c.e;

import com.baidu.ala.data.SdkLiveInfoData;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class d {

    /* renamed from: a  reason: collision with root package name */
    public ArrayList<SdkLiveInfoData> f65339a;

    public void a(JSONObject jSONObject) {
        JSONArray optJSONArray;
        if (jSONObject == null || (optJSONArray = jSONObject.optJSONArray("live_list")) == null || optJSONArray.length() <= 0) {
            return;
        }
        this.f65339a = new ArrayList<>(optJSONArray.length());
        for (int i2 = 0; i2 < optJSONArray.length(); i2++) {
            JSONObject optJSONObject = optJSONArray.optJSONObject(i2);
            if (optJSONObject != null) {
                SdkLiveInfoData sdkLiveInfoData = new SdkLiveInfoData();
                sdkLiveInfoData.fromJson(optJSONObject);
                this.f65339a.add(sdkLiveInfoData);
            }
        }
    }
}
