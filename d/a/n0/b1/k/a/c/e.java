package d.a.n0.b1.k.a.c;

import d.a.c.e.p.k;
import tbclient.NewHottopic.TimeLineInfo;
/* loaded from: classes4.dex */
public class e {

    /* renamed from: a  reason: collision with root package name */
    public long f55645a;

    /* renamed from: b  reason: collision with root package name */
    public long f55646b;

    /* renamed from: c  reason: collision with root package name */
    public String f55647c;

    /* renamed from: d  reason: collision with root package name */
    public String f55648d;

    /* renamed from: e  reason: collision with root package name */
    public String f55649e;

    /* renamed from: f  reason: collision with root package name */
    public int f55650f;

    public void a(TimeLineInfo timeLineInfo) {
        if (timeLineInfo == null) {
            return;
        }
        this.f55646b = timeLineInfo.tid.longValue();
        this.f55647c = timeLineInfo.title;
        this.f55648d = k.isEmpty(timeLineInfo.small_title) ? timeLineInfo.show_time : timeLineInfo.small_title;
        this.f55649e = timeLineInfo.bg_color;
    }
}
