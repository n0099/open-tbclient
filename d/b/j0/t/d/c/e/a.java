package d.b.j0.t.d.c.e;

import com.baidu.ala.data.SdkLiveInfoData;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    public ArrayList<SdkLiveInfoData> f62306a;

    public void a(JSONObject jSONObject) {
        JSONArray optJSONArray;
        if (jSONObject == null || (optJSONArray = jSONObject.optJSONArray("live_list")) == null || optJSONArray.length() <= 0) {
            return;
        }
        this.f62306a = new ArrayList<>(optJSONArray.length());
        for (int i = 0; i < optJSONArray.length(); i++) {
            JSONObject optJSONObject = optJSONArray.optJSONObject(i);
            if (optJSONObject != null) {
                SdkLiveInfoData sdkLiveInfoData = new SdkLiveInfoData();
                sdkLiveInfoData.fromJson(optJSONObject);
                this.f62306a.add(sdkLiveInfoData);
            }
        }
    }
}
