package d.a.o0.y1.e;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.data.MediaData;
import com.baidu.tbadk.core.util.ListUtils;
import d.a.c.k.e.n;
import d.a.n0.r.q.a2;
import java.util.Iterator;
import tbclient.ThreadInfo;
import tbclient.VideoInfo;
/* loaded from: classes5.dex */
public class b implements n {

    /* renamed from: e  reason: collision with root package name */
    public String f67241e;

    /* renamed from: f  reason: collision with root package name */
    public int f67242f;

    /* renamed from: g  reason: collision with root package name */
    public int f67243g;

    /* renamed from: h  reason: collision with root package name */
    public String f67244h;

    /* renamed from: i  reason: collision with root package name */
    public int f67245i;
    public boolean j;
    public a2 k;

    public b(ThreadInfo threadInfo, boolean z) {
        b(threadInfo);
        this.j = z;
    }

    public final void b(ThreadInfo threadInfo) {
        if (threadInfo == null) {
            return;
        }
        a2 a2Var = new a2();
        this.k = a2Var;
        a2Var.V2(threadInfo);
        this.f67241e = threadInfo.title;
        this.f67242f = threadInfo.reply_num.intValue();
        this.f67243g = threadInfo.agree_num.intValue();
        if (!ListUtils.isEmpty(this.k.L0())) {
            Iterator<MediaData> it = this.k.L0().iterator();
            while (it.hasNext()) {
                MediaData next = it.next();
                if (next != null && next.getType() == 3) {
                    String picUrl = next.getPicUrl();
                    this.f67244h = picUrl;
                    if (StringUtils.isNull(picUrl)) {
                        this.f67244h = next.getSmallUrl();
                    }
                    if (StringUtils.isNull(this.f67244h)) {
                        this.f67244h = next.getThumbnails_url();
                    }
                    if (StringUtils.isNull(this.f67244h)) {
                        this.f67244h = next.getSrc_pic();
                    }
                    if (!StringUtils.isNull(this.f67244h)) {
                        break;
                    }
                }
            }
        }
        VideoInfo videoInfo = threadInfo.video_info;
        if (videoInfo != null) {
            this.f67245i = videoInfo.video_duration.intValue();
        }
    }

    @Override // d.a.c.k.e.n
    public BdUniqueId getType() {
        return a.f67239a;
    }
}
