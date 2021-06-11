package d.a.n0.s1.c.b;

import tbclient.GetMemberTaskList.PointTaskInfo;
import tbclient.GetVipInfo.VipTaskItem;
/* loaded from: classes3.dex */
public class r {

    /* renamed from: a  reason: collision with root package name */
    public long f64145a;

    /* renamed from: b  reason: collision with root package name */
    public String f64146b;

    /* renamed from: c  reason: collision with root package name */
    public String f64147c;

    /* renamed from: d  reason: collision with root package name */
    public int f64148d;

    /* renamed from: e  reason: collision with root package name */
    public int f64149e;

    /* renamed from: f  reason: collision with root package name */
    public int f64150f;

    public r() {
    }

    public int a() {
        return this.f64149e;
    }

    public String b() {
        return this.f64147c;
    }

    public long c() {
        return this.f64145a;
    }

    public boolean d() {
        return this.f64148d == 1;
    }

    public int e() {
        return this.f64148d;
    }

    public String f() {
        return this.f64146b;
    }

    public int g() {
        return this.f64150f;
    }

    public void h(int i2) {
        this.f64148d = i2;
    }

    public void i(long j) {
        this.f64145a = j;
    }

    public r(VipTaskItem vipTaskItem) {
        this.f64145a = vipTaskItem.task_id.intValue();
        this.f64146b = vipTaskItem.title;
        this.f64147c = vipTaskItem.desc;
        String str = vipTaskItem.img_url;
        String str2 = vipTaskItem.link;
        this.f64148d = vipTaskItem.is_finish.intValue();
    }

    public r(PointTaskInfo pointTaskInfo) {
        if (pointTaskInfo == null) {
            return;
        }
        this.f64145a = pointTaskInfo.task_id.longValue();
        this.f64146b = pointTaskInfo.task_name;
        this.f64147c = pointTaskInfo.task_intro;
        this.f64148d = pointTaskInfo.is_finish.intValue();
        this.f64149e = pointTaskInfo.points_add.intValue();
        this.f64150f = pointTaskInfo.type.intValue();
    }
}
