package d.b.i0.b1.c;

import com.baidu.adp.BdUniqueId;
import tbclient.TopicList.MediaTopic;
import tbclient.VideoInfo;
/* loaded from: classes4.dex */
public class o implements d.b.b.j.e.n {
    public static final BdUniqueId k = BdUniqueId.gen();

    /* renamed from: e  reason: collision with root package name */
    public long f52140e;

    /* renamed from: f  reason: collision with root package name */
    public String f52141f;

    /* renamed from: g  reason: collision with root package name */
    public String f52142g;

    /* renamed from: h  reason: collision with root package name */
    public String f52143h;
    public int i;
    public String j;

    public void a(MediaTopic mediaTopic) {
        if (mediaTopic == null) {
            return;
        }
        this.f52140e = mediaTopic.topic_id.longValue();
        this.f52141f = mediaTopic.topic_name;
        this.f52142g = mediaTopic.pic_url;
        VideoInfo videoInfo = mediaTopic.video_info;
        if (videoInfo == null || videoInfo.video_duration.intValue() <= 0) {
            return;
        }
        e(mediaTopic.video_info);
    }

    public void e(VideoInfo videoInfo) {
        String str = videoInfo.video_md5;
        this.f52143h = videoInfo.video_url;
        this.i = videoInfo.video_duration.intValue();
        videoInfo.video_width.intValue();
        videoInfo.video_height.intValue();
        this.j = videoInfo.thumbnail_url;
        videoInfo.thumbnail_width.intValue();
        videoInfo.thumbnail_height.intValue();
        videoInfo.video_length.intValue();
        videoInfo.play_count.intValue();
    }

    @Override // d.b.b.j.e.n
    public BdUniqueId getType() {
        return k;
    }
}
