package d.b.i0.x1.e;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.data.MediaData;
import com.baidu.tbadk.core.util.ListUtils;
import d.b.c.j.e.n;
import d.b.h0.r.q.a2;
import java.util.Iterator;
import tbclient.ThreadInfo;
import tbclient.VideoInfo;
/* loaded from: classes3.dex */
public class b implements n {

    /* renamed from: e  reason: collision with root package name */
    public String f63940e;

    /* renamed from: f  reason: collision with root package name */
    public int f63941f;

    /* renamed from: g  reason: collision with root package name */
    public int f63942g;

    /* renamed from: h  reason: collision with root package name */
    public String f63943h;
    public int i;
    public boolean j;
    public a2 k;

    public b(ThreadInfo threadInfo, boolean z) {
        a(threadInfo);
        this.j = z;
    }

    public final void a(ThreadInfo threadInfo) {
        if (threadInfo == null) {
            return;
        }
        a2 a2Var = new a2();
        this.k = a2Var;
        a2Var.R2(threadInfo);
        this.f63940e = threadInfo.title;
        this.f63941f = threadInfo.reply_num.intValue();
        this.f63942g = threadInfo.agree_num.intValue();
        if (!ListUtils.isEmpty(this.k.K0())) {
            Iterator<MediaData> it = this.k.K0().iterator();
            while (it.hasNext()) {
                MediaData next = it.next();
                if (next != null && next.getType() == 3) {
                    String picUrl = next.getPicUrl();
                    this.f63943h = picUrl;
                    if (StringUtils.isNull(picUrl)) {
                        this.f63943h = next.getSmallUrl();
                    }
                    if (StringUtils.isNull(this.f63943h)) {
                        this.f63943h = next.getThumbnails_url();
                    }
                    if (StringUtils.isNull(this.f63943h)) {
                        this.f63943h = next.getSrc_pic();
                    }
                    if (!StringUtils.isNull(this.f63943h)) {
                        break;
                    }
                }
            }
        }
        VideoInfo videoInfo = threadInfo.video_info;
        if (videoInfo != null) {
            this.i = videoInfo.video_duration.intValue();
        }
    }

    @Override // d.b.c.j.e.n
    public BdUniqueId getType() {
        return a.f63938a;
    }
}
