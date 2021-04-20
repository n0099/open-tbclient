package d.b.i0.d3.h0;

import com.baidu.adp.lib.util.BdLog;
import com.baidu.android.imsdk.db.TableDefine;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tieba.recapp.activity.AdWebVideoActivityConfig;
import com.baidu.tieba.tbadkCore.videoupload.VideoFinishResult;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;
import tbclient.ActBtn;
import tbclient.TPointPost;
import tbclient.Timgs;
import tbclient.VideoInfo;
/* loaded from: classes5.dex */
public class i {

    /* renamed from: a  reason: collision with root package name */
    public boolean f54827a;

    /* renamed from: b  reason: collision with root package name */
    public int f54828b;

    /* renamed from: c  reason: collision with root package name */
    public ArrayList<h> f54829c;

    /* renamed from: d  reason: collision with root package name */
    public ArrayList<k> f54830d;

    public i(TPointPost tPointPost) {
        if (tPointPost != null) {
            try {
                String str = tPointPost.position;
                tPointPost.template_id.longValue();
                this.f54827a = tPointPost.is_tuiguang.intValue() != 0;
                this.f54828b = tPointPost.template_type.intValue();
                List<ActBtn> list = tPointPost.act_btn;
                if (list != null && list.size() > 0) {
                    this.f54829c = new ArrayList<>();
                    for (int i = 0; i != list.size(); i++) {
                        this.f54829c.add(new h(list.get(i)));
                    }
                }
                List<Timgs> list2 = tPointPost.t_imgs;
                if (list2 != null && list2.size() > 0) {
                    this.f54830d = new ArrayList<>();
                    for (int i2 = 0; i2 != list2.size(); i2++) {
                        this.f54830d.add(new k(list2.get(i2)));
                    }
                }
                if (tPointPost.detail_info != null) {
                    new j(tPointPost.detail_info);
                }
                String str2 = tPointPost.monitor_id;
                tPointPost.hidden_day.intValue();
                VideoInfo videoInfo = tPointPost.t_video;
                String str3 = tPointPost.tag_name;
            } catch (Exception e2) {
                BdLog.detailException(e2);
            }
        }
    }

    public k a() {
        return (k) ListUtils.getItem(this.f54830d, 0);
    }

    public i(JSONObject jSONObject) {
        JSONObject jSONObject2;
        if (jSONObject == null) {
            return;
        }
        try {
            jSONObject.optString("position");
            jSONObject.optLong("template_id");
            this.f54827a = jSONObject.optInt("is_tuiguang") != 0;
            this.f54828b = jSONObject.optInt(TableDefine.MessageColumns.COLUME_TEMPLATE);
            JSONArray optJSONArray = jSONObject.optJSONArray("act_btn");
            if (optJSONArray != null && optJSONArray.length() > 0) {
                this.f54829c = new ArrayList<>();
                for (int i = 0; i != optJSONArray.length(); i++) {
                    this.f54829c.add(new h(optJSONArray.getJSONObject(i)));
                }
            }
            JSONArray optJSONArray2 = jSONObject.optJSONArray("t_imgs");
            if (optJSONArray2 != null && optJSONArray2.length() > 0) {
                this.f54830d = new ArrayList<>();
                for (int i2 = 0; i2 != optJSONArray2.length(); i2++) {
                    this.f54830d.add(new k(optJSONArray2.getJSONObject(i2)));
                }
            }
            new j(jSONObject.getJSONObject("detail_info"));
            jSONObject.optString("monitor_id");
            jSONObject.optInt("hidden_day");
            jSONObject.optString("tag_name");
            if (this.f54828b != 3 || (jSONObject2 = jSONObject.getJSONObject("t_video")) == null) {
                return;
            }
            VideoInfo.Builder builder = new VideoInfo.Builder();
            builder.video_md5 = jSONObject2.optString(VideoFinishResult.KEY_VIDEO_MD5);
            builder.video_url = jSONObject2.optString("video_url");
            builder.video_duration = Integer.valueOf(jSONObject2.optInt(AdWebVideoActivityConfig.KEY_VIDEO_DURATION));
            builder.video_width = Integer.valueOf(jSONObject2.optInt("video_width"));
            builder.video_height = Integer.valueOf(jSONObject2.optInt("video_height"));
            builder.thumbnail_url = jSONObject2.optString("thumbnail_url");
            builder.thumbnail_width = Integer.valueOf(jSONObject2.optInt("thumbnail_width"));
            builder.thumbnail_height = Integer.valueOf(jSONObject2.optInt("thumbnail_height"));
            builder.video_length = Integer.valueOf(jSONObject2.optInt("video_length"));
            builder.play_count = Integer.valueOf(jSONObject2.optInt("play_count"));
            builder.build(false);
        } catch (Exception e2) {
            BdLog.detailException(e2);
        }
    }
}
