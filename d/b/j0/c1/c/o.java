package d.b.j0.c1.c;

import com.baidu.adp.BdUniqueId;
import tbclient.TopicList.MediaTopic;
import tbclient.VideoInfo;
/* loaded from: classes4.dex */
public class o implements d.b.c.j.e.n {
    public static final BdUniqueId k = BdUniqueId.gen();

    /* renamed from: e  reason: collision with root package name */
    public long f53963e;

    /* renamed from: f  reason: collision with root package name */
    public String f53964f;

    /* renamed from: g  reason: collision with root package name */
    public String f53965g;

    /* renamed from: h  reason: collision with root package name */
    public String f53966h;
    public int i;
    public String j;

    public void a(MediaTopic mediaTopic) {
        if (mediaTopic == null) {
            return;
        }
        this.f53963e = mediaTopic.topic_id.longValue();
        this.f53964f = mediaTopic.topic_name;
        this.f53965g = mediaTopic.pic_url;
        VideoInfo videoInfo = mediaTopic.video_info;
        if (videoInfo == null || videoInfo.video_duration.intValue() <= 0) {
            return;
        }
        e(mediaTopic.video_info);
    }

    public void e(VideoInfo videoInfo) {
        String str = videoInfo.video_md5;
        this.f53966h = videoInfo.video_url;
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
