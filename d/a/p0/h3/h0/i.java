package d.a.p0.h3.h0;

import com.baidu.adp.lib.util.BdLog;
import com.baidu.android.imsdk.db.TableDefine;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tieba.recapp.activity.AdWebVideoActivityConfig;
import com.baidu.tieba.tbadkCore.videoupload.VideoFinishResult;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;
import tbclient.ActBtn;
import tbclient.TPointPost;
import tbclient.Timgs;
import tbclient.VideoInfo;
/* loaded from: classes8.dex */
public class i {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public boolean f57980a;

    /* renamed from: b  reason: collision with root package name */
    public int f57981b;

    /* renamed from: c  reason: collision with root package name */
    public ArrayList<h> f57982c;

    /* renamed from: d  reason: collision with root package name */
    public ArrayList<k> f57983d;

    public i(TPointPost tPointPost) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {tPointPost};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        if (tPointPost != null) {
            try {
                String str = tPointPost.position;
                tPointPost.template_id.longValue();
                this.f57980a = tPointPost.is_tuiguang.intValue() != 0;
                this.f57981b = tPointPost.template_type.intValue();
                List<ActBtn> list = tPointPost.act_btn;
                if (list != null && list.size() > 0) {
                    this.f57982c = new ArrayList<>();
                    for (int i4 = 0; i4 != list.size(); i4++) {
                        this.f57982c.add(new h(list.get(i4)));
                    }
                }
                List<Timgs> list2 = tPointPost.t_imgs;
                if (list2 != null && list2.size() > 0) {
                    this.f57983d = new ArrayList<>();
                    for (int i5 = 0; i5 != list2.size(); i5++) {
                        this.f57983d.add(new k(list2.get(i5)));
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
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? (k) ListUtils.getItem(this.f57983d, 0) : (k) invokeV.objValue;
    }

    public i(JSONObject jSONObject) {
        JSONObject jSONObject2;
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {jSONObject};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        if (jSONObject == null) {
            return;
        }
        try {
            jSONObject.optString("position");
            jSONObject.optLong("template_id");
            this.f57980a = jSONObject.optInt("is_tuiguang") != 0;
            this.f57981b = jSONObject.optInt(TableDefine.MessageColumns.COLUME_TEMPLATE);
            JSONArray optJSONArray = jSONObject.optJSONArray("act_btn");
            if (optJSONArray != null && optJSONArray.length() > 0) {
                this.f57982c = new ArrayList<>();
                for (int i4 = 0; i4 != optJSONArray.length(); i4++) {
                    this.f57982c.add(new h(optJSONArray.getJSONObject(i4)));
                }
            }
            JSONArray optJSONArray2 = jSONObject.optJSONArray("t_imgs");
            if (optJSONArray2 != null && optJSONArray2.length() > 0) {
                this.f57983d = new ArrayList<>();
                for (int i5 = 0; i5 != optJSONArray2.length(); i5++) {
                    this.f57983d.add(new k(optJSONArray2.getJSONObject(i5)));
                }
            }
            new j(jSONObject.getJSONObject("detail_info"));
            jSONObject.optString("monitor_id");
            jSONObject.optInt("hidden_day");
            jSONObject.optString("tag_name");
            if (this.f57981b != 3 || (jSONObject2 = jSONObject.getJSONObject("t_video")) == null) {
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
