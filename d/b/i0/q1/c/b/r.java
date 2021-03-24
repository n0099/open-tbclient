package d.b.i0.q1.c.b;

import tbclient.GetMemberTaskList.PointTaskInfo;
import tbclient.GetVipInfo.VipTaskItem;
/* loaded from: classes3.dex */
public class r {

    /* renamed from: a  reason: collision with root package name */
    public long f59325a;

    /* renamed from: b  reason: collision with root package name */
    public String f59326b;

    /* renamed from: c  reason: collision with root package name */
    public String f59327c;

    /* renamed from: d  reason: collision with root package name */
    public int f59328d;

    /* renamed from: e  reason: collision with root package name */
    public int f59329e;

    /* renamed from: f  reason: collision with root package name */
    public int f59330f;

    public r() {
    }

    public int a() {
        return this.f59329e;
    }

    public String b() {
        return this.f59327c;
    }

    public long c() {
        return this.f59325a;
    }

    public boolean d() {
        return this.f59328d == 1;
    }

    public int e() {
        return this.f59328d;
    }

    public String f() {
        return this.f59326b;
    }

    public int g() {
        return this.f59330f;
    }

    public void h(int i) {
        this.f59328d = i;
    }

    public void i(long j) {
        this.f59325a = j;
    }

    public r(VipTaskItem vipTaskItem) {
        this.f59325a = vipTaskItem.task_id.intValue();
        this.f59326b = vipTaskItem.title;
        this.f59327c = vipTaskItem.desc;
        String str = vipTaskItem.img_url;
        String str2 = vipTaskItem.link;
        this.f59328d = vipTaskItem.is_finish.intValue();
    }

    public r(PointTaskInfo pointTaskInfo) {
        if (pointTaskInfo == null) {
            return;
        }
        this.f59325a = pointTaskInfo.task_id.longValue();
        this.f59326b = pointTaskInfo.task_name;
        this.f59327c = pointTaskInfo.task_intro;
        this.f59328d = pointTaskInfo.is_finish.intValue();
        this.f59329e = pointTaskInfo.points_add.intValue();
        this.f59330f = pointTaskInfo.type.intValue();
    }
}
