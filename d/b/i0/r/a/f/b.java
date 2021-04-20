package d.b.i0.r.a.f;

import android.text.TextUtils;
import com.baidu.tieba.advert.sdk.data.AdInfo;
import com.tencent.connect.share.QzonePublish;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class b {

    /* renamed from: g  reason: collision with root package name */
    public int f60920g;

    /* renamed from: h  reason: collision with root package name */
    public int f60921h;
    public int i;
    public long j;
    public long k;

    /* renamed from: d  reason: collision with root package name */
    public String f60917d = "";

    /* renamed from: c  reason: collision with root package name */
    public String f60916c = "";

    /* renamed from: e  reason: collision with root package name */
    public String f60918e = "";

    /* renamed from: f  reason: collision with root package name */
    public String f60919f = "";

    /* renamed from: b  reason: collision with root package name */
    public String f60915b = "";

    /* renamed from: a  reason: collision with root package name */
    public String f60914a = "";

    public static b a(AdInfo adInfo) {
        b bVar = new b();
        if (adInfo == null) {
            return bVar;
        }
        bVar.f60914a = adInfo.adImgUrl;
        bVar.f60915b = adInfo.redirectUrl;
        bVar.j = adInfo.startShowTime;
        bVar.k = adInfo.endShowTime;
        bVar.f60917d = adInfo.videoLocalPath;
        bVar.f60918e = adInfo.videoJumpUrl;
        bVar.f60919f = adInfo.videoMd5;
        bVar.f60920g = adInfo.videoDuration;
        bVar.f60921h = adInfo.videoWidth;
        bVar.i = adInfo.videoHight;
        bVar.f60916c = adInfo.adVideoUrl;
        return bVar;
    }

    public static b b(String str) {
        b bVar = new b();
        try {
            JSONObject jSONObject = new JSONObject(str);
            bVar.f60914a = jSONObject.optString("adImgUrl");
            bVar.f60915b = jSONObject.optString("redirectUrl");
            bVar.f60917d = jSONObject.optString("videoLocalPath");
            bVar.j = jSONObject.optLong("startShowTime");
            bVar.k = jSONObject.optLong("endShowTime");
            bVar.f60918e = jSONObject.optString("videoJumpUrl");
            bVar.f60919f = jSONObject.optString("videoMd5");
            bVar.f60920g = jSONObject.optInt(QzonePublish.PUBLISH_TO_QZONE_VIDEO_DURATION);
            bVar.f60921h = jSONObject.optInt("videoWidth");
            bVar.i = jSONObject.optInt("videoHeight");
            bVar.f60916c = jSONObject.optString("adVideoUrl");
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
        return bVar;
    }

    public boolean c() {
        return (System.currentTimeMillis() / 1000 >= this.j && System.currentTimeMillis() / 1000 <= this.k) || (this.j == 0 && this.k == 0);
    }

    public boolean d() {
        return !TextUtils.isEmpty(this.f60917d);
    }

    public String toString() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("adImgUrl", this.f60914a);
            jSONObject.put("redirectUrl", this.f60915b);
            jSONObject.put("videoLocalPath", this.f60917d);
            jSONObject.put("startShowTime", this.j);
            jSONObject.put("endShowTime", this.k);
            jSONObject.put("videoMd5", this.f60919f);
            jSONObject.put("videoJumpUrl", this.f60918e);
            jSONObject.put(QzonePublish.PUBLISH_TO_QZONE_VIDEO_DURATION, this.f60920g);
            jSONObject.put("videoWidth", this.f60921h);
            jSONObject.put("videoHeight", this.i);
            jSONObject.put("adVideoUrl", this.f60916c);
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
        return jSONObject.toString();
    }
}
