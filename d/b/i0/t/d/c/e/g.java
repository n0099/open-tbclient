package d.b.i0.t.d.c.e;

import com.baidu.ala.data.SdkLiveInfoData;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class g {

    /* renamed from: a  reason: collision with root package name */
    public SdkLiveInfoData f61897a;

    public boolean a() {
        return this.f61897a != null && ((long) d.b.c.e.m.b.d(this.f61897a.liveId, 0)) > 0;
    }

    public void b(JSONObject jSONObject) {
        JSONObject optJSONObject;
        if (jSONObject == null || (optJSONObject = jSONObject.optJSONObject("live_info")) == null) {
            return;
        }
        SdkLiveInfoData sdkLiveInfoData = new SdkLiveInfoData();
        this.f61897a = sdkLiveInfoData;
        sdkLiveInfoData.fromJson(optJSONObject);
    }
}
