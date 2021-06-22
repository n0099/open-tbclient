package d.a.o0.v.d.c.e;

import com.baidu.ala.data.SdkLiveInfoData;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class g {

    /* renamed from: a  reason: collision with root package name */
    public SdkLiveInfoData f65346a;

    public boolean a() {
        return this.f65346a != null && d.a.c.e.m.b.f(this.f65346a.liveId, 0L) > 0;
    }

    public void b(JSONObject jSONObject) {
        JSONObject optJSONObject;
        if (jSONObject == null || (optJSONObject = jSONObject.optJSONObject("live_info")) == null) {
            return;
        }
        SdkLiveInfoData sdkLiveInfoData = new SdkLiveInfoData();
        this.f65346a = sdkLiveInfoData;
        sdkLiveInfoData.fromJson(optJSONObject);
    }
}
