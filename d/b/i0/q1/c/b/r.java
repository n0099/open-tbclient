package d.b.i0.q1.c.b;

import tbclient.GetMemberTaskList.PointTaskInfo;
import tbclient.GetVipInfo.VipTaskItem;
/* loaded from: classes3.dex */
public class r {

    /* renamed from: a  reason: collision with root package name */
    public long f59326a;

    /* renamed from: b  reason: collision with root package name */
    public String f59327b;

    /* renamed from: c  reason: collision with root package name */
    public String f59328c;

    /* renamed from: d  reason: collision with root package name */
    public int f59329d;

    /* renamed from: e  reason: collision with root package name */
    public int f59330e;

    /* renamed from: f  reason: collision with root package name */
    public int f59331f;

    public r() {
    }

    public int a() {
        return this.f59330e;
    }

    public String b() {
        return this.f59328c;
    }

    public long c() {
        return this.f59326a;
    }

    public boolean d() {
        return this.f59329d == 1;
    }

    public int e() {
        return this.f59329d;
    }

    public String f() {
        return this.f59327b;
    }

    public int g() {
        return this.f59331f;
    }

    public void h(int i) {
        this.f59329d = i;
    }

    public void i(long j) {
        this.f59326a = j;
    }

    public r(VipTaskItem vipTaskItem) {
        this.f59326a = vipTaskItem.task_id.intValue();
        this.f59327b = vipTaskItem.title;
        this.f59328c = vipTaskItem.desc;
        String str = vipTaskItem.img_url;
        String str2 = vipTaskItem.link;
        this.f59329d = vipTaskItem.is_finish.intValue();
    }

    public r(PointTaskInfo pointTaskInfo) {
        if (pointTaskInfo == null) {
            return;
        }
        this.f59326a = pointTaskInfo.task_id.longValue();
        this.f59327b = pointTaskInfo.task_name;
        this.f59328c = pointTaskInfo.task_intro;
        this.f59329d = pointTaskInfo.is_finish.intValue();
        this.f59330e = pointTaskInfo.points_add.intValue();
        this.f59331f = pointTaskInfo.type.intValue();
    }
}
