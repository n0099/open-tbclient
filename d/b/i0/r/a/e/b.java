package d.b.i0.r.a.e;

import android.text.TextUtils;
import com.baidu.tieba.advert.sdk.data.AdInfo;
import com.tencent.connect.share.QzonePublish;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class b {

    /* renamed from: g  reason: collision with root package name */
    public int f59670g;

    /* renamed from: h  reason: collision with root package name */
    public int f59671h;
    public int i;
    public long j;
    public long k;

    /* renamed from: d  reason: collision with root package name */
    public String f59667d = "";

    /* renamed from: c  reason: collision with root package name */
    public String f59666c = "";

    /* renamed from: e  reason: collision with root package name */
    public String f59668e = "";

    /* renamed from: f  reason: collision with root package name */
    public String f59669f = "";

    /* renamed from: b  reason: collision with root package name */
    public String f59665b = "";

    /* renamed from: a  reason: collision with root package name */
    public String f59664a = "";

    public static b a(AdInfo adInfo) {
        b bVar = new b();
        if (adInfo == null) {
            return bVar;
        }
        bVar.f59664a = adInfo.adImgUrl;
        bVar.f59665b = adInfo.redirectUrl;
        bVar.j = adInfo.startShowTime;
        bVar.k = adInfo.endShowTime;
        bVar.f59667d = adInfo.videoLocalPath;
        bVar.f59668e = adInfo.videoJumpUrl;
        bVar.f59669f = adInfo.videoMd5;
        bVar.f59670g = adInfo.videoDuration;
        bVar.f59671h = adInfo.videoWidth;
        bVar.i = adInfo.videoHight;
        bVar.f59666c = adInfo.adVideoUrl;
        return bVar;
    }

    public static b b(String str) {
        b bVar = new b();
        try {
            JSONObject jSONObject = new JSONObject(str);
            bVar.f59664a = jSONObject.optString("adImgUrl");
            bVar.f59665b = jSONObject.optString("redirectUrl");
            bVar.f59667d = jSONObject.optString("videoLocalPath");
            bVar.j = jSONObject.optLong("startShowTime");
            bVar.k = jSONObject.optLong("endShowTime");
            bVar.f59668e = jSONObject.optString("videoJumpUrl");
            bVar.f59669f = jSONObject.optString("videoMd5");
            bVar.f59670g = jSONObject.optInt(QzonePublish.PUBLISH_TO_QZONE_VIDEO_DURATION);
            bVar.f59671h = jSONObject.optInt("videoWidth");
            bVar.i = jSONObject.optInt("videoHeight");
            bVar.f59666c = jSONObject.optString("adVideoUrl");
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
        return bVar;
    }

    public boolean c() {
        return (System.currentTimeMillis() / 1000 >= this.j && System.currentTimeMillis() / 1000 <= this.k) || (this.j == 0 && this.k == 0);
    }

    public boolean d() {
        return !TextUtils.isEmpty(this.f59667d);
    }

    public String toString() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("adImgUrl", this.f59664a);
            jSONObject.put("redirectUrl", this.f59665b);
            jSONObject.put("videoLocalPath", this.f59667d);
            jSONObject.put("startShowTime", this.j);
            jSONObject.put("endShowTime", this.k);
            jSONObject.put("videoMd5", this.f59669f);
            jSONObject.put("videoJumpUrl", this.f59668e);
            jSONObject.put(QzonePublish.PUBLISH_TO_QZONE_VIDEO_DURATION, this.f59670g);
            jSONObject.put("videoWidth", this.f59671h);
            jSONObject.put("videoHeight", this.i);
            jSONObject.put("adVideoUrl", this.f59666c);
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
        return jSONObject.toString();
    }
}
