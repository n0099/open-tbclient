package d.a.k0.r.a.f;

import android.text.TextUtils;
import com.baidu.tieba.advert.sdk.data.AdInfo;
import com.tencent.connect.share.QzonePublish;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class b {

    /* renamed from: g  reason: collision with root package name */
    public int f60227g;

    /* renamed from: h  reason: collision with root package name */
    public int f60228h;

    /* renamed from: i  reason: collision with root package name */
    public int f60229i;
    public long j;
    public long k;

    /* renamed from: d  reason: collision with root package name */
    public String f60224d = "";

    /* renamed from: c  reason: collision with root package name */
    public String f60223c = "";

    /* renamed from: e  reason: collision with root package name */
    public String f60225e = "";

    /* renamed from: f  reason: collision with root package name */
    public String f60226f = "";

    /* renamed from: b  reason: collision with root package name */
    public String f60222b = "";

    /* renamed from: a  reason: collision with root package name */
    public String f60221a = "";

    public static b a(AdInfo adInfo) {
        b bVar = new b();
        if (adInfo == null) {
            return bVar;
        }
        bVar.f60221a = adInfo.adImgUrl;
        bVar.f60222b = adInfo.redirectUrl;
        bVar.j = adInfo.startShowTime;
        bVar.k = adInfo.endShowTime;
        bVar.f60224d = adInfo.videoLocalPath;
        bVar.f60225e = adInfo.videoJumpUrl;
        bVar.f60226f = adInfo.videoMd5;
        bVar.f60227g = adInfo.videoDuration;
        bVar.f60228h = adInfo.videoWidth;
        bVar.f60229i = adInfo.videoHight;
        bVar.f60223c = adInfo.adVideoUrl;
        return bVar;
    }

    public static b b(String str) {
        b bVar = new b();
        try {
            JSONObject jSONObject = new JSONObject(str);
            bVar.f60221a = jSONObject.optString("adImgUrl");
            bVar.f60222b = jSONObject.optString("redirectUrl");
            bVar.f60224d = jSONObject.optString("videoLocalPath");
            bVar.j = jSONObject.optLong("startShowTime");
            bVar.k = jSONObject.optLong("endShowTime");
            bVar.f60225e = jSONObject.optString("videoJumpUrl");
            bVar.f60226f = jSONObject.optString("videoMd5");
            bVar.f60227g = jSONObject.optInt(QzonePublish.PUBLISH_TO_QZONE_VIDEO_DURATION);
            bVar.f60228h = jSONObject.optInt("videoWidth");
            bVar.f60229i = jSONObject.optInt("videoHeight");
            bVar.f60223c = jSONObject.optString("adVideoUrl");
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
        return bVar;
    }

    public boolean c() {
        return (System.currentTimeMillis() / 1000 >= this.j && System.currentTimeMillis() / 1000 <= this.k) || (this.j == 0 && this.k == 0);
    }

    public boolean d() {
        return !TextUtils.isEmpty(this.f60224d);
    }

    public String toString() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("adImgUrl", this.f60221a);
            jSONObject.put("redirectUrl", this.f60222b);
            jSONObject.put("videoLocalPath", this.f60224d);
            jSONObject.put("startShowTime", this.j);
            jSONObject.put("endShowTime", this.k);
            jSONObject.put("videoMd5", this.f60226f);
            jSONObject.put("videoJumpUrl", this.f60225e);
            jSONObject.put(QzonePublish.PUBLISH_TO_QZONE_VIDEO_DURATION, this.f60227g);
            jSONObject.put("videoWidth", this.f60228h);
            jSONObject.put("videoHeight", this.f60229i);
            jSONObject.put("adVideoUrl", this.f60223c);
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
        return jSONObject.toString();
    }
}
