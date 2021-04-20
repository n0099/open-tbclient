package d.b.i0.c1.c;

import com.baidu.adp.BdUniqueId;
import tbclient.TopicList.MediaTopic;
import tbclient.VideoInfo;
/* loaded from: classes4.dex */
public class o implements d.b.c.j.e.n {
    public static final BdUniqueId k = BdUniqueId.gen();

    /* renamed from: e  reason: collision with root package name */
    public long f53542e;

    /* renamed from: f  reason: collision with root package name */
    public String f53543f;

    /* renamed from: g  reason: collision with root package name */
    public String f53544g;

    /* renamed from: h  reason: collision with root package name */
    public String f53545h;
    public int i;
    public String j;

    public void a(MediaTopic mediaTopic) {
        if (mediaTopic == null) {
            return;
        }
        this.f53542e = mediaTopic.topic_id.longValue();
        this.f53543f = mediaTopic.topic_name;
        this.f53544g = mediaTopic.pic_url;
        VideoInfo videoInfo = mediaTopic.video_info;
        if (videoInfo == null || videoInfo.video_duration.intValue() <= 0) {
            return;
        }
        e(mediaTopic.video_info);
    }

    public void e(VideoInfo videoInfo) {
        String str = videoInfo.video_md5;
        this.f53545h = videoInfo.video_url;
        this.i = videoInfo.video_duration.intValue();
        videoInfo.video_width.intValue();
        videoInfo.video_height.intValue();
        this.j = videoInfo.thumbnail_url;
        videoInfo.thumbnail_width.intValue();
        videoInfo.thumbnail_height.intValue();
        videoInfo.video_length.intValue();
        videoInfo.play_count.intValue();
    }

    @Override // d.b.c.j.e.n
    public BdUniqueId getType() {
        return k;
    }
}
