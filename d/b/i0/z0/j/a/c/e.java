package d.b.i0.z0.j.a.c;

import d.b.b.e.p.k;
import tbclient.NewHottopic.TimeLineInfo;
/* loaded from: classes3.dex */
public class e {

    /* renamed from: a  reason: collision with root package name */
    public long f63326a;

    /* renamed from: b  reason: collision with root package name */
    public long f63327b;

    /* renamed from: c  reason: collision with root package name */
    public String f63328c;

    /* renamed from: d  reason: collision with root package name */
    public String f63329d;

    /* renamed from: e  reason: collision with root package name */
    public String f63330e;

    /* renamed from: f  reason: collision with root package name */
    public int f63331f;

    public void a(TimeLineInfo timeLineInfo) {
        if (timeLineInfo == null) {
            return;
        }
        this.f63327b = timeLineInfo.tid.longValue();
        this.f63328c = timeLineInfo.title;
        this.f63329d = k.isEmpty(timeLineInfo.small_title) ? timeLineInfo.show_time : timeLineInfo.small_title;
        this.f63330e = timeLineInfo.bg_color;
    }
}
