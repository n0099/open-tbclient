package d.b.j0.t.d.c.e;

import com.baidu.ala.data.SdkLiveInfoData;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class g {

    /* renamed from: a  reason: collision with root package name */
    public SdkLiveInfoData f62318a;

    public boolean a() {
        return this.f62318a != null && ((long) d.b.c.e.m.b.d(this.f62318a.liveId, 0)) > 0;
    }

    public void b(JSONObject jSONObject) {
        JSONObject optJSONObject;
        if (jSONObject == null || (optJSONObject = jSONObject.optJSONObject("live_info")) == null) {
            return;
        }
        SdkLiveInfoData sdkLiveInfoData = new SdkLiveInfoData();
        this.f62318a = sdkLiveInfoData;
        sdkLiveInfoData.fromJson(optJSONObject);
    }
}
