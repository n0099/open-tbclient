package d.a.n0.t.a.f;

import android.text.TextUtils;
import com.baidu.tieba.advert.sdk.data.AdInfo;
import com.tencent.connect.share.QzonePublish;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class b {

    /* renamed from: g  reason: collision with root package name */
    public int f60808g;

    /* renamed from: h  reason: collision with root package name */
    public int f60809h;

    /* renamed from: i  reason: collision with root package name */
    public int f60810i;
    public long j;
    public long k;

    /* renamed from: d  reason: collision with root package name */
    public String f60805d = "";

    /* renamed from: c  reason: collision with root package name */
    public String f60804c = "";

    /* renamed from: e  reason: collision with root package name */
    public String f60806e = "";

    /* renamed from: f  reason: collision with root package name */
    public String f60807f = "";

    /* renamed from: b  reason: collision with root package name */
    public String f60803b = "";

    /* renamed from: a  reason: collision with root package name */
    public String f60802a = "";

    public static b a(AdInfo adInfo) {
        b bVar = new b();
        if (adInfo == null) {
            return bVar;
        }
        bVar.f60802a = adInfo.adImgUrl;
        bVar.f60803b = adInfo.redirectUrl;
        bVar.j = adInfo.startShowTime;
        bVar.k = adInfo.endShowTime;
        bVar.f60805d = adInfo.videoLocalPath;
        bVar.f60806e = adInfo.videoJumpUrl;
        bVar.f60807f = adInfo.videoMd5;
        bVar.f60808g = adInfo.videoDuration;
        bVar.f60809h = adInfo.videoWidth;
        bVar.f60810i = adInfo.videoHight;
        bVar.f60804c = adInfo.adVideoUrl;
        return bVar;
    }

    public static b b(String str) {
        b bVar = new b();
        try {
            JSONObject jSONObject = new JSONObject(str);
            bVar.f60802a = jSONObject.optString("adImgUrl");
            bVar.f60803b = jSONObject.optString("redirectUrl");
            bVar.f60805d = jSONObject.optString("videoLocalPath");
            bVar.j = jSONObject.optLong("startShowTime");
            bVar.k = jSONObject.optLong("endShowTime");
            bVar.f60806e = jSONObject.optString("videoJumpUrl");
            bVar.f60807f = jSONObject.optString("videoMd5");
            bVar.f60808g = jSONObject.optInt(QzonePublish.PUBLISH_TO_QZONE_VIDEO_DURATION);
            bVar.f60809h = jSONObject.optInt("videoWidth");
            bVar.f60810i = jSONObject.optInt("videoHeight");
            bVar.f60804c = jSONObject.optString("adVideoUrl");
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
        return bVar;
    }

    public boolean c() {
        return (System.currentTimeMillis() / 1000 >= this.j && System.currentTimeMillis() / 1000 <= this.k) || (this.j == 0 && this.k == 0);
    }

    public boolean d() {
        return !TextUtils.isEmpty(this.f60805d);
    }

    public String toString() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("adImgUrl", this.f60802a);
            jSONObject.put("redirectUrl", this.f60803b);
            jSONObject.put("videoLocalPath", this.f60805d);
            jSONObject.put("startShowTime", this.j);
            jSONObject.put("endShowTime", this.k);
            jSONObject.put("videoMd5", this.f60807f);
            jSONObject.put("videoJumpUrl", this.f60806e);
            jSONObject.put(QzonePublish.PUBLISH_TO_QZONE_VIDEO_DURATION, this.f60808g);
            jSONObject.put("videoWidth", this.f60809h);
            jSONObject.put("videoHeight", this.f60810i);
            jSONObject.put("adVideoUrl", this.f60804c);
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
        return jSONObject.toString();
    }
}
