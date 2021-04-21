package d.b.i0.r.q;

import com.baidu.tieba.tbadkCore.videoupload.VideoFinishResult;
import org.json.JSONObject;
import tbclient.VideoDesc;
/* loaded from: classes3.dex */
public class i2 {
    public static VideoDesc a(JSONObject jSONObject) {
        VideoDesc.Builder builder = new VideoDesc.Builder();
        if (jSONObject != null) {
            builder.video_id = Integer.valueOf(jSONObject.optInt("video_id"));
            builder.video_md5 = jSONObject.optString(VideoFinishResult.KEY_VIDEO_MD5);
            builder.video_url = jSONObject.optString("video_url");
            builder.video_width = jSONObject.optString("video_width");
            builder.video_height = jSONObject.optString("video_height");
        }
        return builder.build(true);
    }
}
