package d.b.i0.a1.j.a.c;

import d.b.c.e.p.k;
import tbclient.NewHottopic.TimeLineInfo;
/* loaded from: classes4.dex */
public class e {

    /* renamed from: a  reason: collision with root package name */
    public long f52945a;

    /* renamed from: b  reason: collision with root package name */
    public long f52946b;

    /* renamed from: c  reason: collision with root package name */
    public String f52947c;

    /* renamed from: d  reason: collision with root package name */
    public String f52948d;

    /* renamed from: e  reason: collision with root package name */
    public String f52949e;

    /* renamed from: f  reason: collision with root package name */
    public int f52950f;

    public void a(TimeLineInfo timeLineInfo) {
        if (timeLineInfo == null) {
            return;
        }
        this.f52946b = timeLineInfo.tid.longValue();
        this.f52947c = timeLineInfo.title;
        this.f52948d = k.isEmpty(timeLineInfo.small_title) ? timeLineInfo.show_time : timeLineInfo.small_title;
        this.f52949e = timeLineInfo.bg_color;
    }
}
