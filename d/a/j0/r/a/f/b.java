package d.a.j0.r.a.f;

import android.text.TextUtils;
import com.baidu.tieba.advert.sdk.data.AdInfo;
import com.tencent.connect.share.QzonePublish;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class b {

    /* renamed from: g  reason: collision with root package name */
    public int f59482g;

    /* renamed from: h  reason: collision with root package name */
    public int f59483h;

    /* renamed from: i  reason: collision with root package name */
    public int f59484i;
    public long j;
    public long k;

    /* renamed from: d  reason: collision with root package name */
    public String f59479d = "";

    /* renamed from: c  reason: collision with root package name */
    public String f59478c = "";

    /* renamed from: e  reason: collision with root package name */
    public String f59480e = "";

    /* renamed from: f  reason: collision with root package name */
    public String f59481f = "";

    /* renamed from: b  reason: collision with root package name */
    public String f59477b = "";

    /* renamed from: a  reason: collision with root package name */
    public String f59476a = "";

    public static b a(AdInfo adInfo) {
        b bVar = new b();
        if (adInfo == null) {
            return bVar;
        }
        bVar.f59476a = adInfo.adImgUrl;
        bVar.f59477b = adInfo.redirectUrl;
        bVar.j = adInfo.startShowTime;
        bVar.k = adInfo.endShowTime;
        bVar.f59479d = adInfo.videoLocalPath;
        bVar.f59480e = adInfo.videoJumpUrl;
        bVar.f59481f = adInfo.videoMd5;
        bVar.f59482g = adInfo.videoDuration;
        bVar.f59483h = adInfo.videoWidth;
        bVar.f59484i = adInfo.videoHight;
        bVar.f59478c = adInfo.adVideoUrl;
        return bVar;
    }

    public static b b(String str) {
        b bVar = new b();
        try {
            JSONObject jSONObject = new JSONObject(str);
            bVar.f59476a = jSONObject.optString("adImgUrl");
            bVar.f59477b = jSONObject.optString("redirectUrl");
            bVar.f59479d = jSONObject.optString("videoLocalPath");
            bVar.j = jSONObject.optLong("startShowTime");
            bVar.k = jSONObject.optLong("endShowTime");
            bVar.f59480e = jSONObject.optString("videoJumpUrl");
            bVar.f59481f = jSONObject.optString("videoMd5");
            bVar.f59482g = jSONObject.optInt(QzonePublish.PUBLISH_TO_QZONE_VIDEO_DURATION);
            bVar.f59483h = jSONObject.optInt("videoWidth");
            bVar.f59484i = jSONObject.optInt("videoHeight");
            bVar.f59478c = jSONObject.optString("adVideoUrl");
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
        return bVar;
    }

    public boolean c() {
        return (System.currentTimeMillis() / 1000 >= this.j && System.currentTimeMillis() / 1000 <= this.k) || (this.j == 0 && this.k == 0);
    }

    public boolean d() {
        return !TextUtils.isEmpty(this.f59479d);
    }

    public String toString() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("adImgUrl", this.f59476a);
            jSONObject.put("redirectUrl", this.f59477b);
            jSONObject.put("videoLocalPath", this.f59479d);
            jSONObject.put("startShowTime", this.j);
            jSONObject.put("endShowTime", this.k);
            jSONObject.put("videoMd5", this.f59481f);
            jSONObject.put("videoJumpUrl", this.f59480e);
            jSONObject.put(QzonePublish.PUBLISH_TO_QZONE_VIDEO_DURATION, this.f59482g);
            jSONObject.put("videoWidth", this.f59483h);
            jSONObject.put("videoHeight", this.f59484i);
            jSONObject.put("adVideoUrl", this.f59478c);
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
        return jSONObject.toString();
    }
}
