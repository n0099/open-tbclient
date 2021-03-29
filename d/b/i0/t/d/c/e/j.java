package d.b.i0.t.d.c.e;

import com.baidu.ala.data.SdkLiveInfoData;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class j {

    /* renamed from: a  reason: collision with root package name */
    public boolean f60340a = false;

    /* renamed from: b  reason: collision with root package name */
    public ArrayList<SdkLiveInfoData> f60341b;

    public void a(JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        this.f60340a = jSONObject.optInt("has_more") == 1;
        JSONArray optJSONArray = jSONObject.optJSONArray("live_list");
        if (optJSONArray == null || optJSONArray.length() <= 0) {
            return;
        }
        this.f60341b = new ArrayList<>(optJSONArray.length());
        for (int i = 0; i < optJSONArray.length(); i++) {
            JSONObject optJSONObject = optJSONArray.optJSONObject(i);
            if (optJSONObject != null) {
                SdkLiveInfoData sdkLiveInfoData = new SdkLiveInfoData();
                sdkLiveInfoData.fromJson(optJSONObject);
                this.f60341b.add(sdkLiveInfoData);
            }
        }
    }
}
