package d.b.i0.w1.e;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.data.MediaData;
import com.baidu.tbadk.core.util.ListUtils;
import d.b.b.j.e.n;
import d.b.h0.r.q.a2;
import java.util.Iterator;
import tbclient.ThreadInfo;
import tbclient.VideoInfo;
/* loaded from: classes3.dex */
public class b implements n {

    /* renamed from: e  reason: collision with root package name */
    public String f62144e;

    /* renamed from: f  reason: collision with root package name */
    public int f62145f;

    /* renamed from: g  reason: collision with root package name */
    public int f62146g;

    /* renamed from: h  reason: collision with root package name */
    public String f62147h;
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
        a2Var.Q2(threadInfo);
        this.f62144e = threadInfo.title;
        this.f62145f = threadInfo.reply_num.intValue();
        this.f62146g = threadInfo.agree_num.intValue();
        if (!ListUtils.isEmpty(this.k.K0())) {
            Iterator<MediaData> it = this.k.K0().iterator();
            while (it.hasNext()) {
                MediaData next = it.next();
                if (next != null && next.getType() == 3) {
                    String picUrl = next.getPicUrl();
                    this.f62147h = picUrl;
                    if (StringUtils.isNull(picUrl)) {
                        this.f62147h = next.getSmallUrl();
                    }
                    if (StringUtils.isNull(this.f62147h)) {
                        this.f62147h = next.getThumbnails_url();
                    }
                    if (StringUtils.isNull(this.f62147h)) {
                        this.f62147h = next.getSrc_pic();
                    }
                    if (!StringUtils.isNull(this.f62147h)) {
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

    @Override // d.b.b.j.e.n
    public BdUniqueId getType() {
        return a.f62142a;
    }
}
