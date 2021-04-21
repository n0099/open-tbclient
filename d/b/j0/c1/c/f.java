package d.b.j0.c1.c;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.util.StringUtils;
import tbclient.Hottopic.TopicInfo;
import tbclient.VideoInfo;
/* loaded from: classes4.dex */
public class f implements d.b.c.j.e.n {
    public static final BdUniqueId s = BdUniqueId.gen();

    /* renamed from: e  reason: collision with root package name */
    public String f53933e;

    /* renamed from: f  reason: collision with root package name */
    public String f53934f;

    /* renamed from: g  reason: collision with root package name */
    public String f53935g;

    /* renamed from: h  reason: collision with root package name */
    public long f53936h;
    public String i;
    public String j;
    public String k;
    public long l;
    public String m;
    public String n;
    public Long o;
    public Integer p;
    public h q;
    public String r;

    public void a(TopicInfo topicInfo) {
        if (topicInfo == null) {
            return;
        }
        this.f53933e = String.valueOf(topicInfo.topic_id);
        this.f53934f = topicInfo.topic_name;
        this.f53935g = topicInfo.desc;
        this.f53936h = topicInfo.total_post_num.longValue();
        this.i = topicInfo.head_photo_url;
        this.j = StringUtils.isNull(topicInfo.share_title) ? "" : topicInfo.share_title;
        this.k = topicInfo.share_pic;
        this.l = topicInfo.idx_num.longValue();
        this.o = topicInfo.pmy_topic_id;
        this.r = topicInfo.head_photo_jump_url;
        this.p = topicInfo.pmy_source;
        VideoInfo videoInfo = topicInfo.video_info;
        if (videoInfo != null && !StringUtils.isNull(videoInfo.video_url) && topicInfo.video_info.video_duration.intValue() > 0) {
            VideoInfo videoInfo2 = topicInfo.video_info;
            String str = videoInfo2.video_md5;
            this.m = videoInfo2.video_url;
            videoInfo2.video_duration.intValue();
            topicInfo.video_info.video_width.intValue();
            topicInfo.video_info.video_height.intValue();
            VideoInfo videoInfo3 = topicInfo.video_info;
            String str2 = videoInfo3.thumbnail_url;
            videoInfo3.thumbnail_width.intValue();
            topicInfo.video_info.thumbnail_height.intValue();
            topicInfo.video_info.video_length.intValue();
            topicInfo.video_info.play_count.intValue();
        }
        this.n = topicInfo.tag_list_type;
        if (topicInfo.join_info != null) {
            h hVar = new h();
            this.q = hVar;
            hVar.a(topicInfo.join_info);
        }
    }

    @Override // d.b.c.j.e.n
    public BdUniqueId getType() {
        return s;
    }
}
