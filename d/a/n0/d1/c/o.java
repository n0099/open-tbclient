package d.a.n0.d1.c;

import com.baidu.adp.BdUniqueId;
import tbclient.TopicList.MediaTopic;
import tbclient.VideoInfo;
/* loaded from: classes4.dex */
public class o implements d.a.c.j.e.n {
    public static final BdUniqueId k = BdUniqueId.gen();

    /* renamed from: e  reason: collision with root package name */
    public long f52606e;

    /* renamed from: f  reason: collision with root package name */
    public String f52607f;

    /* renamed from: g  reason: collision with root package name */
    public String f52608g;

    /* renamed from: h  reason: collision with root package name */
    public String f52609h;

    /* renamed from: i  reason: collision with root package name */
    public int f52610i;
    public String j;

    public void c(MediaTopic mediaTopic) {
        if (mediaTopic == null) {
            return;
        }
        this.f52606e = mediaTopic.topic_id.longValue();
        this.f52607f = mediaTopic.topic_name;
        this.f52608g = mediaTopic.pic_url;
        VideoInfo videoInfo = mediaTopic.video_info;
        if (videoInfo == null || videoInfo.video_duration.intValue() <= 0) {
            return;
        }
        e(mediaTopic.video_info);
    }

    public void e(VideoInfo videoInfo) {
        String str = videoInfo.video_md5;
        this.f52609h = videoInfo.video_url;
        this.f52610i = videoInfo.video_duration.intValue();
        videoInfo.video_width.intValue();
        videoInfo.video_height.intValue();
        this.j = videoInfo.thumbnail_url;
        videoInfo.thumbnail_width.intValue();
        videoInfo.thumbnail_height.intValue();
        videoInfo.video_length.intValue();
        videoInfo.play_count.intValue();
    }

    @Override // d.a.c.j.e.n
    public BdUniqueId getType() {
        return k;
    }
}
