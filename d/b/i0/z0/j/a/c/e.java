package d.b.i0.z0.j.a.c;

import d.b.b.e.p.k;
import tbclient.NewHottopic.TimeLineInfo;
/* loaded from: classes4.dex */
public class e {

    /* renamed from: a  reason: collision with root package name */
    public long f63325a;

    /* renamed from: b  reason: collision with root package name */
    public long f63326b;

    /* renamed from: c  reason: collision with root package name */
    public String f63327c;

    /* renamed from: d  reason: collision with root package name */
    public String f63328d;

    /* renamed from: e  reason: collision with root package name */
    public String f63329e;

    /* renamed from: f  reason: collision with root package name */
    public int f63330f;

    public void a(TimeLineInfo timeLineInfo) {
        if (timeLineInfo == null) {
            return;
        }
        this.f63326b = timeLineInfo.tid.longValue();
        this.f63327c = timeLineInfo.title;
        this.f63328d = k.isEmpty(timeLineInfo.small_title) ? timeLineInfo.show_time : timeLineInfo.small_title;
        this.f63329e = timeLineInfo.bg_color;
    }
}
