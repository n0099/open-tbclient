package d.b.j0.r.a.f;

import android.text.TextUtils;
import com.baidu.tieba.advert.sdk.data.AdInfo;
import com.tencent.connect.share.QzonePublish;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class b {

    /* renamed from: g  reason: collision with root package name */
    public int f61341g;

    /* renamed from: h  reason: collision with root package name */
    public int f61342h;
    public int i;
    public long j;
    public long k;

    /* renamed from: d  reason: collision with root package name */
    public String f61338d = "";

    /* renamed from: c  reason: collision with root package name */
    public String f61337c = "";

    /* renamed from: e  reason: collision with root package name */
    public String f61339e = "";

    /* renamed from: f  reason: collision with root package name */
    public String f61340f = "";

    /* renamed from: b  reason: collision with root package name */
    public String f61336b = "";

    /* renamed from: a  reason: collision with root package name */
    public String f61335a = "";

    public static b a(AdInfo adInfo) {
        b bVar = new b();
        if (adInfo == null) {
            return bVar;
        }
        bVar.f61335a = adInfo.adImgUrl;
        bVar.f61336b = adInfo.redirectUrl;
        bVar.j = adInfo.startShowTime;
        bVar.k = adInfo.endShowTime;
        bVar.f61338d = adInfo.videoLocalPath;
        bVar.f61339e = adInfo.videoJumpUrl;
        bVar.f61340f = adInfo.videoMd5;
        bVar.f61341g = adInfo.videoDuration;
        bVar.f61342h = adInfo.videoWidth;
        bVar.i = adInfo.videoHight;
        bVar.f61337c = adInfo.adVideoUrl;
        return bVar;
    }

    public static b b(String str) {
        b bVar = new b();
        try {
            JSONObject jSONObject = new JSONObject(str);
            bVar.f61335a = jSONObject.optString("adImgUrl");
            bVar.f61336b = jSONObject.optString("redirectUrl");
            bVar.f61338d = jSONObject.optString("videoLocalPath");
            bVar.j = jSONObject.optLong("startShowTime");
            bVar.k = jSONObject.optLong("endShowTime");
            bVar.f61339e = jSONObject.optString("videoJumpUrl");
            bVar.f61340f = jSONObject.optString("videoMd5");
            bVar.f61341g = jSONObject.optInt(QzonePublish.PUBLISH_TO_QZONE_VIDEO_DURATION);
            bVar.f61342h = jSONObject.optInt("videoWidth");
            bVar.i = jSONObject.optInt("videoHeight");
            bVar.f61337c = jSONObject.optString("adVideoUrl");
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
        return bVar;
    }

    public boolean c() {
        return (System.currentTimeMillis() / 1000 >= this.j && System.currentTimeMillis() / 1000 <= this.k) || (this.j == 0 && this.k == 0);
    }

    public boolean d() {
        return !TextUtils.isEmpty(this.f61338d);
    }

    public String toString() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("adImgUrl", this.f61335a);
            jSONObject.put("redirectUrl", this.f61336b);
            jSONObject.put("videoLocalPath", this.f61338d);
            jSONObject.put("startShowTime", this.j);
            jSONObject.put("endShowTime", this.k);
            jSONObject.put("videoMd5", this.f61340f);
            jSONObject.put("videoJumpUrl", this.f61339e);
            jSONObject.put(QzonePublish.PUBLISH_TO_QZONE_VIDEO_DURATION, this.f61341g);
            jSONObject.put("videoWidth", this.f61342h);
            jSONObject.put("videoHeight", this.i);
            jSONObject.put("adVideoUrl", this.f61337c);
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
        return jSONObject.toString();
    }
}
