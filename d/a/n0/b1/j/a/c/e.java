package d.a.n0.b1.j.a.c;

import d.a.c.e.p.k;
import tbclient.NewHottopic.TimeLineInfo;
/* loaded from: classes4.dex */
public class e {

    /* renamed from: a  reason: collision with root package name */
    public long f51956a;

    /* renamed from: b  reason: collision with root package name */
    public long f51957b;

    /* renamed from: c  reason: collision with root package name */
    public String f51958c;

    /* renamed from: d  reason: collision with root package name */
    public String f51959d;

    /* renamed from: e  reason: collision with root package name */
    public String f51960e;

    /* renamed from: f  reason: collision with root package name */
    public int f51961f;

    public void a(TimeLineInfo timeLineInfo) {
        if (timeLineInfo == null) {
            return;
        }
        this.f51957b = timeLineInfo.tid.longValue();
        this.f51958c = timeLineInfo.title;
        this.f51959d = k.isEmpty(timeLineInfo.small_title) ? timeLineInfo.show_time : timeLineInfo.small_title;
        this.f51960e = timeLineInfo.bg_color;
    }
}
