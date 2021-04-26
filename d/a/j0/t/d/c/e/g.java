package d.a.j0.t.d.c.e;

import com.baidu.ala.data.SdkLiveInfoData;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class g {

    /* renamed from: a  reason: collision with root package name */
    public SdkLiveInfoData f60496a;

    public boolean a() {
        return this.f60496a != null && d.a.c.e.m.b.f(this.f60496a.liveId, 0L) > 0;
    }

    public void b(JSONObject jSONObject) {
        JSONObject optJSONObject;
        if (jSONObject == null || (optJSONObject = jSONObject.optJSONObject("live_info")) == null) {
            return;
        }
        SdkLiveInfoData sdkLiveInfoData = new SdkLiveInfoData();
        this.f60496a = sdkLiveInfoData;
        sdkLiveInfoData.fromJson(optJSONObject);
    }
}
