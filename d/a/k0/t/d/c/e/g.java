package d.a.k0.t.d.c.e;

import com.baidu.ala.data.SdkLiveInfoData;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class g {

    /* renamed from: a  reason: collision with root package name */
    public SdkLiveInfoData f61220a;

    public boolean a() {
        return this.f61220a != null && d.a.c.e.m.b.f(this.f61220a.liveId, 0L) > 0;
    }

    public void b(JSONObject jSONObject) {
        JSONObject optJSONObject;
        if (jSONObject == null || (optJSONObject = jSONObject.optJSONObject("live_info")) == null) {
            return;
        }
        SdkLiveInfoData sdkLiveInfoData = new SdkLiveInfoData();
        this.f61220a = sdkLiveInfoData;
        sdkLiveInfoData.fromJson(optJSONObject);
    }
}
