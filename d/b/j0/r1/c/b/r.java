package d.b.j0.r1.c.b;

import tbclient.GetMemberTaskList.PointTaskInfo;
import tbclient.GetVipInfo.VipTaskItem;
/* loaded from: classes3.dex */
public class r {

    /* renamed from: a  reason: collision with root package name */
    public long f61441a;

    /* renamed from: b  reason: collision with root package name */
    public String f61442b;

    /* renamed from: c  reason: collision with root package name */
    public String f61443c;

    /* renamed from: d  reason: collision with root package name */
    public int f61444d;

    /* renamed from: e  reason: collision with root package name */
    public int f61445e;

    /* renamed from: f  reason: collision with root package name */
    public int f61446f;

    public r() {
    }

    public int a() {
        return this.f61445e;
    }

    public String b() {
        return this.f61443c;
    }

    public long c() {
        return this.f61441a;
    }

    public boolean d() {
        return this.f61444d == 1;
    }

    public int e() {
        return this.f61444d;
    }

    public String f() {
        return this.f61442b;
    }

    public int g() {
        return this.f61446f;
    }

    public void h(int i) {
        this.f61444d = i;
    }

    public void i(long j) {
        this.f61441a = j;
    }

    public r(VipTaskItem vipTaskItem) {
        this.f61441a = vipTaskItem.task_id.intValue();
        this.f61442b = vipTaskItem.title;
        this.f61443c = vipTaskItem.desc;
        String str = vipTaskItem.img_url;
        String str2 = vipTaskItem.link;
        this.f61444d = vipTaskItem.is_finish.intValue();
    }

    public r(PointTaskInfo pointTaskInfo) {
        if (pointTaskInfo == null) {
            return;
        }
        this.f61441a = pointTaskInfo.task_id.longValue();
        this.f61442b = pointTaskInfo.task_name;
        this.f61443c = pointTaskInfo.task_intro;
        this.f61444d = pointTaskInfo.is_finish.intValue();
        this.f61445e = pointTaskInfo.points_add.intValue();
        this.f61446f = pointTaskInfo.type.intValue();
    }
}
