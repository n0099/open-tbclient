package d.b.j0.a1.j.a.c;

import d.b.c.e.p.k;
import tbclient.NewHottopic.TimeLineInfo;
/* loaded from: classes4.dex */
public class e {

    /* renamed from: a  reason: collision with root package name */
    public long f53366a;

    /* renamed from: b  reason: collision with root package name */
    public long f53367b;

    /* renamed from: c  reason: collision with root package name */
    public String f53368c;

    /* renamed from: d  reason: collision with root package name */
    public String f53369d;

    /* renamed from: e  reason: collision with root package name */
    public String f53370e;

    /* renamed from: f  reason: collision with root package name */
    public int f53371f;

    public void a(TimeLineInfo timeLineInfo) {
        if (timeLineInfo == null) {
            return;
        }
        this.f53367b = timeLineInfo.tid.longValue();
        this.f53368c = timeLineInfo.title;
        this.f53369d = k.isEmpty(timeLineInfo.small_title) ? timeLineInfo.show_time : timeLineInfo.small_title;
        this.f53370e = timeLineInfo.bg_color;
    }
}
