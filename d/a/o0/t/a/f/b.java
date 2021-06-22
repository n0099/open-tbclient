package d.a.o0.t.a.f;

import android.text.TextUtils;
import com.baidu.tieba.advert.sdk.data.AdInfo;
import com.tencent.connect.share.QzonePublish;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class b {

    /* renamed from: g  reason: collision with root package name */
    public int f64624g;

    /* renamed from: h  reason: collision with root package name */
    public int f64625h;

    /* renamed from: i  reason: collision with root package name */
    public int f64626i;
    public long j;
    public long k;

    /* renamed from: d  reason: collision with root package name */
    public String f64621d = "";

    /* renamed from: c  reason: collision with root package name */
    public String f64620c = "";

    /* renamed from: e  reason: collision with root package name */
    public String f64622e = "";

    /* renamed from: f  reason: collision with root package name */
    public String f64623f = "";

    /* renamed from: b  reason: collision with root package name */
    public String f64619b = "";

    /* renamed from: a  reason: collision with root package name */
    public String f64618a = "";

    public static b a(AdInfo adInfo) {
        b bVar = new b();
        if (adInfo == null) {
            return bVar;
        }
        bVar.f64618a = adInfo.adImgUrl;
        bVar.f64619b = adInfo.redirectUrl;
        bVar.j = adInfo.startShowTime;
        bVar.k = adInfo.endShowTime;
        bVar.f64621d = adInfo.videoLocalPath;
        bVar.f64622e = adInfo.videoJumpUrl;
        bVar.f64623f = adInfo.videoMd5;
        bVar.f64624g = adInfo.videoDuration;
        bVar.f64625h = adInfo.videoWidth;
        bVar.f64626i = adInfo.videoHight;
        bVar.f64620c = adInfo.adVideoUrl;
        return bVar;
    }

    public static b b(String str) {
        b bVar = new b();
        try {
            JSONObject jSONObject = new JSONObject(str);
            bVar.f64618a = jSONObject.optString("adImgUrl");
            bVar.f64619b = jSONObject.optString("redirectUrl");
            bVar.f64621d = jSONObject.optString("videoLocalPath");
            bVar.j = jSONObject.optLong("startShowTime");
            bVar.k = jSONObject.optLong("endShowTime");
            bVar.f64622e = jSONObject.optString("videoJumpUrl");
            bVar.f64623f = jSONObject.optString("videoMd5");
            bVar.f64624g = jSONObject.optInt(QzonePublish.PUBLISH_TO_QZONE_VIDEO_DURATION);
            bVar.f64625h = jSONObject.optInt("videoWidth");
            bVar.f64626i = jSONObject.optInt("videoHeight");
            bVar.f64620c = jSONObject.optString("adVideoUrl");
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
        return bVar;
    }

    public boolean c() {
        return (System.currentTimeMillis() / 1000 >= this.j && System.currentTimeMillis() / 1000 <= this.k) || (this.j == 0 && this.k == 0);
    }

    public boolean d() {
        return !TextUtils.isEmpty(this.f64621d);
    }

    public String toString() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("adImgUrl", this.f64618a);
            jSONObject.put("redirectUrl", this.f64619b);
            jSONObject.put("videoLocalPath", this.f64621d);
            jSONObject.put("startShowTime", this.j);
            jSONObject.put("endShowTime", this.k);
            jSONObject.put("videoMd5", this.f64623f);
            jSONObject.put("videoJumpUrl", this.f64622e);
            jSONObject.put(QzonePublish.PUBLISH_TO_QZONE_VIDEO_DURATION, this.f64624g);
            jSONObject.put("videoWidth", this.f64625h);
            jSONObject.put("videoHeight", this.f64626i);
            jSONObject.put("adVideoUrl", this.f64620c);
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
        return jSONObject.toString();
    }
}
