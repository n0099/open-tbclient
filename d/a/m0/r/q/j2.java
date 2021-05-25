package d.a.m0.r.q;

import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tieba.recapp.activity.AdWebVideoActivityConfig;
import com.baidu.tieba.tbadkCore.videoupload.VideoFinishResult;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONObject;
import tbclient.VideoInfo;
/* loaded from: classes3.dex */
public class j2 {
    public static VideoInfo a(JSONObject jSONObject) {
        if (jSONObject != null) {
            VideoInfo.Builder builder = new VideoInfo.Builder();
            builder.video_md5 = jSONObject.optString(VideoFinishResult.KEY_VIDEO_MD5);
            builder.video_url = jSONObject.optString("video_url");
            builder.video_duration = Integer.valueOf(jSONObject.optInt(AdWebVideoActivityConfig.KEY_VIDEO_DURATION));
            builder.video_width = Integer.valueOf(jSONObject.optInt("video_width"));
            builder.video_height = Integer.valueOf(jSONObject.optInt("video_height"));
            builder.thumbnail_url = jSONObject.optString("thumbnail_url");
            builder.thumbnail_width = Integer.valueOf(jSONObject.optInt("thumbnail_width"));
            builder.thumbnail_height = Integer.valueOf(jSONObject.optInt("thumbnail_height"));
            builder.video_length = Integer.valueOf(jSONObject.optInt("video_length"));
            builder.play_count = Integer.valueOf(jSONObject.optInt("play_count"));
            builder.media_subtitle = jSONObject.optString("media_subtitle");
            builder.video_desc = new ArrayList();
            JSONArray optJSONArray = jSONObject.optJSONArray("video_desc");
            if (optJSONArray != null) {
                for (int i2 = 0; i2 < optJSONArray.length(); i2++) {
                    builder.video_desc.add(i2.a(optJSONArray.optJSONObject(i2)));
                }
            }
            builder.video_select_flag = Integer.valueOf(jSONObject.optInt("video_select_flag"));
            builder.video_type = Integer.valueOf(jSONObject.optInt("video_type"));
            builder.is_vertical = Integer.valueOf(jSONObject.optInt(TiebaStatic.Params.IS_VERTICAL));
            builder.video_h265 = i2.a(jSONObject.optJSONObject("video_h265"));
            builder.mcn_lead_page = jSONObject.optString("mcn_lead_page");
            builder.mcn_ad_card = u0.a(jSONObject.optJSONObject("mcn_ad_card"));
            builder.wth_mid_loc = Double.valueOf(jSONObject.optDouble("wth_mid_loc"));
            builder.hth_mid_loc = Double.valueOf(jSONObject.optDouble("hth_mid_loc"));
            return builder.build(true);
        }
        return null;
    }
}
