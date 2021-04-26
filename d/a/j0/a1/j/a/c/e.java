package d.a.j0.a1.j.a.c;

import d.a.c.e.p.k;
import tbclient.NewHottopic.TimeLineInfo;
/* loaded from: classes4.dex */
public class e {

    /* renamed from: a  reason: collision with root package name */
    public long f51090a;

    /* renamed from: b  reason: collision with root package name */
    public long f51091b;

    /* renamed from: c  reason: collision with root package name */
    public String f51092c;

    /* renamed from: d  reason: collision with root package name */
    public String f51093d;

    /* renamed from: e  reason: collision with root package name */
    public String f51094e;

    /* renamed from: f  reason: collision with root package name */
    public int f51095f;

    public void a(TimeLineInfo timeLineInfo) {
        if (timeLineInfo == null) {
            return;
        }
        this.f51091b = timeLineInfo.tid.longValue();
        this.f51092c = timeLineInfo.title;
        this.f51093d = k.isEmpty(timeLineInfo.small_title) ? timeLineInfo.show_time : timeLineInfo.small_title;
        this.f51094e = timeLineInfo.bg_color;
    }
}
