package d.a.k0.a1.j.a.c;

import d.a.c.e.p.k;
import tbclient.NewHottopic.TimeLineInfo;
/* loaded from: classes4.dex */
public class e {

    /* renamed from: a  reason: collision with root package name */
    public long f51789a;

    /* renamed from: b  reason: collision with root package name */
    public long f51790b;

    /* renamed from: c  reason: collision with root package name */
    public String f51791c;

    /* renamed from: d  reason: collision with root package name */
    public String f51792d;

    /* renamed from: e  reason: collision with root package name */
    public String f51793e;

    /* renamed from: f  reason: collision with root package name */
    public int f51794f;

    public void a(TimeLineInfo timeLineInfo) {
        if (timeLineInfo == null) {
            return;
        }
        this.f51790b = timeLineInfo.tid.longValue();
        this.f51791c = timeLineInfo.title;
        this.f51792d = k.isEmpty(timeLineInfo.small_title) ? timeLineInfo.show_time : timeLineInfo.small_title;
        this.f51793e = timeLineInfo.bg_color;
    }
}
