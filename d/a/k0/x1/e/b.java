package d.a.k0.x1.e;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.data.MediaData;
import com.baidu.tbadk.core.util.ListUtils;
import d.a.c.j.e.n;
import d.a.j0.r.q.a2;
import java.util.Iterator;
import tbclient.ThreadInfo;
import tbclient.VideoInfo;
/* loaded from: classes3.dex */
public class b implements n {

    /* renamed from: e  reason: collision with root package name */
    public String f63354e;

    /* renamed from: f  reason: collision with root package name */
    public int f63355f;

    /* renamed from: g  reason: collision with root package name */
    public int f63356g;

    /* renamed from: h  reason: collision with root package name */
    public String f63357h;

    /* renamed from: i  reason: collision with root package name */
    public int f63358i;
    public boolean j;
    public a2 k;

    public b(ThreadInfo threadInfo, boolean z) {
        c(threadInfo);
        this.j = z;
    }

    public final void c(ThreadInfo threadInfo) {
        if (threadInfo == null) {
            return;
        }
        a2 a2Var = new a2();
        this.k = a2Var;
        a2Var.T2(threadInfo);
        this.f63354e = threadInfo.title;
        this.f63355f = threadInfo.reply_num.intValue();
        this.f63356g = threadInfo.agree_num.intValue();
        if (!ListUtils.isEmpty(this.k.K0())) {
            Iterator<MediaData> it = this.k.K0().iterator();
            while (it.hasNext()) {
                MediaData next = it.next();
                if (next != null && next.getType() == 3) {
                    String picUrl = next.getPicUrl();
                    this.f63357h = picUrl;
                    if (StringUtils.isNull(picUrl)) {
                        this.f63357h = next.getSmallUrl();
                    }
                    if (StringUtils.isNull(this.f63357h)) {
                        this.f63357h = next.getThumbnails_url();
                    }
                    if (StringUtils.isNull(this.f63357h)) {
                        this.f63357h = next.getSrc_pic();
                    }
                    if (!StringUtils.isNull(this.f63357h)) {
                        break;
                    }
                }
            }
        }
        VideoInfo videoInfo = threadInfo.video_info;
        if (videoInfo != null) {
            this.f63358i = videoInfo.video_duration.intValue();
        }
    }

    @Override // d.a.c.j.e.n
    public BdUniqueId getType() {
        return a.f63352a;
    }
}
