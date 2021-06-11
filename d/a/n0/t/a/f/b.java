package d.a.n0.t.a.f;

import android.text.TextUtils;
import com.baidu.tieba.advert.sdk.data.AdInfo;
import com.tencent.connect.share.QzonePublish;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class b {

    /* renamed from: g  reason: collision with root package name */
    public int f64499g;

    /* renamed from: h  reason: collision with root package name */
    public int f64500h;

    /* renamed from: i  reason: collision with root package name */
    public int f64501i;
    public long j;
    public long k;

    /* renamed from: d  reason: collision with root package name */
    public String f64496d = "";

    /* renamed from: c  reason: collision with root package name */
    public String f64495c = "";

    /* renamed from: e  reason: collision with root package name */
    public String f64497e = "";

    /* renamed from: f  reason: collision with root package name */
    public String f64498f = "";

    /* renamed from: b  reason: collision with root package name */
    public String f64494b = "";

    /* renamed from: a  reason: collision with root package name */
    public String f64493a = "";

    public static b a(AdInfo adInfo) {
        b bVar = new b();
        if (adInfo == null) {
            return bVar;
        }
        bVar.f64493a = adInfo.adImgUrl;
        bVar.f64494b = adInfo.redirectUrl;
        bVar.j = adInfo.startShowTime;
        bVar.k = adInfo.endShowTime;
        bVar.f64496d = adInfo.videoLocalPath;
        bVar.f64497e = adInfo.videoJumpUrl;
        bVar.f64498f = adInfo.videoMd5;
        bVar.f64499g = adInfo.videoDuration;
        bVar.f64500h = adInfo.videoWidth;
        bVar.f64501i = adInfo.videoHight;
        bVar.f64495c = adInfo.adVideoUrl;
        return bVar;
    }

    public static b b(String str) {
        b bVar = new b();
        try {
            JSONObject jSONObject = new JSONObject(str);
            bVar.f64493a = jSONObject.optString("adImgUrl");
            bVar.f64494b = jSONObject.optString("redirectUrl");
            bVar.f64496d = jSONObject.optString("videoLocalPath");
            bVar.j = jSONObject.optLong("startShowTime");
            bVar.k = jSONObject.optLong("endShowTime");
            bVar.f64497e = jSONObject.optString("videoJumpUrl");
            bVar.f64498f = jSONObject.optString("videoMd5");
            bVar.f64499g = jSONObject.optInt(QzonePublish.PUBLISH_TO_QZONE_VIDEO_DURATION);
            bVar.f64500h = jSONObject.optInt("videoWidth");
            bVar.f64501i = jSONObject.optInt("videoHeight");
            bVar.f64495c = jSONObject.optString("adVideoUrl");
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
        return bVar;
    }

    public boolean c() {
        return (System.currentTimeMillis() / 1000 >= this.j && System.currentTimeMillis() / 1000 <= this.k) || (this.j == 0 && this.k == 0);
    }

    public boolean d() {
        return !TextUtils.isEmpty(this.f64496d);
    }

    public String toString() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("adImgUrl", this.f64493a);
            jSONObject.put("redirectUrl", this.f64494b);
            jSONObject.put("videoLocalPath", this.f64496d);
            jSONObject.put("startShowTime", this.j);
            jSONObject.put("endShowTime", this.k);
            jSONObject.put("videoMd5", this.f64498f);
            jSONObject.put("videoJumpUrl", this.f64497e);
            jSONObject.put(QzonePublish.PUBLISH_TO_QZONE_VIDEO_DURATION, this.f64499g);
            jSONObject.put("videoWidth", this.f64500h);
            jSONObject.put("videoHeight", this.f64501i);
            jSONObject.put("adVideoUrl", this.f64495c);
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
        return jSONObject.toString();
    }
}
