package d.a.o0.s1.c.b;

import tbclient.GetMemberTaskList.PointTaskInfo;
import tbclient.GetVipInfo.VipTaskItem;
/* loaded from: classes4.dex */
public class r {

    /* renamed from: a  reason: collision with root package name */
    public long f64270a;

    /* renamed from: b  reason: collision with root package name */
    public String f64271b;

    /* renamed from: c  reason: collision with root package name */
    public String f64272c;

    /* renamed from: d  reason: collision with root package name */
    public int f64273d;

    /* renamed from: e  reason: collision with root package name */
    public int f64274e;

    /* renamed from: f  reason: collision with root package name */
    public int f64275f;

    public r() {
    }

    public int a() {
        return this.f64274e;
    }

    public String b() {
        return this.f64272c;
    }

    public long c() {
        return this.f64270a;
    }

    public boolean d() {
        return this.f64273d == 1;
    }

    public int e() {
        return this.f64273d;
    }

    public String f() {
        return this.f64271b;
    }

    public int g() {
        return this.f64275f;
    }

    public void h(int i2) {
        this.f64273d = i2;
    }

    public void i(long j) {
        this.f64270a = j;
    }

    public r(VipTaskItem vipTaskItem) {
        this.f64270a = vipTaskItem.task_id.intValue();
        this.f64271b = vipTaskItem.title;
        this.f64272c = vipTaskItem.desc;
        String str = vipTaskItem.img_url;
        String str2 = vipTaskItem.link;
        this.f64273d = vipTaskItem.is_finish.intValue();
    }

    public r(PointTaskInfo pointTaskInfo) {
        if (pointTaskInfo == null) {
            return;
        }
        this.f64270a = pointTaskInfo.task_id.longValue();
        this.f64271b = pointTaskInfo.task_name;
        this.f64272c = pointTaskInfo.task_intro;
        this.f64273d = pointTaskInfo.is_finish.intValue();
        this.f64274e = pointTaskInfo.points_add.intValue();
        this.f64275f = pointTaskInfo.type.intValue();
    }
}
