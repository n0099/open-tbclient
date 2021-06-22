package d.a.o0.d1.c;

import com.baidu.adp.BdUniqueId;
import tbclient.TopicList.MediaTopic;
import tbclient.VideoInfo;
/* loaded from: classes4.dex */
public class o implements d.a.c.k.e.n {
    public static final BdUniqueId k = BdUniqueId.gen();

    /* renamed from: e  reason: collision with root package name */
    public long f56420e;

    /* renamed from: f  reason: collision with root package name */
    public String f56421f;

    /* renamed from: g  reason: collision with root package name */
    public String f56422g;

    /* renamed from: h  reason: collision with root package name */
    public String f56423h;

    /* renamed from: i  reason: collision with root package name */
    public int f56424i;
    public String j;

    public void b(MediaTopic mediaTopic) {
        if (mediaTopic == null) {
            return;
        }
        this.f56420e = mediaTopic.topic_id.longValue();
        this.f56421f = mediaTopic.topic_name;
        this.f56422g = mediaTopic.pic_url;
        VideoInfo videoInfo = mediaTopic.video_info;
        if (videoInfo == null || videoInfo.video_duration.intValue() <= 0) {
            return;
        }
        c(mediaTopic.video_info);
    }

    public void c(VideoInfo videoInfo) {
        String str = videoInfo.video_md5;
        this.f56423h = videoInfo.video_url;
        this.f56424i = videoInfo.video_duration.intValue();
        videoInfo.video_width.intValue();
        videoInfo.video_height.intValue();
        this.j = videoInfo.thumbnail_url;
        videoInfo.thumbnail_width.intValue();
        videoInfo.thumbnail_height.intValue();
        videoInfo.video_length.intValue();
        videoInfo.play_count.intValue();
    }

    @Override // d.a.c.k.e.n
    public BdUniqueId getType() {
        return k;
    }
}
