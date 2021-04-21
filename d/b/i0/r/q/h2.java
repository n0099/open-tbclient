package d.b.i0.r.q;

import org.json.JSONObject;
import tbclient.VideoChannelInfo;
/* loaded from: classes3.dex */
public class h2 {

    /* renamed from: a  reason: collision with root package name */
    public long f51551a;

    public void a(JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        try {
            this.f51551a = jSONObject.optLong("channel_id", 0L);
            jSONObject.optString("channel_name");
            jSONObject.optString("channel_avatar");
        } catch (Exception unused) {
        }
    }

    public void b(VideoChannelInfo videoChannelInfo) {
        if (videoChannelInfo == null || videoChannelInfo.channel_id.longValue() <= 0) {
            return;
        }
        this.f51551a = videoChannelInfo.channel_id.longValue();
        String str = videoChannelInfo.channel_name;
        String str2 = videoChannelInfo.channel_avatar;
    }
}
