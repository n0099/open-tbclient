package d.a.n0.s1.c.b;

import tbclient.GetMemberTaskList.PointTaskInfo;
import tbclient.GetVipInfo.VipTaskItem;
/* loaded from: classes3.dex */
public class r {

    /* renamed from: a  reason: collision with root package name */
    public long f60454a;

    /* renamed from: b  reason: collision with root package name */
    public String f60455b;

    /* renamed from: c  reason: collision with root package name */
    public String f60456c;

    /* renamed from: d  reason: collision with root package name */
    public int f60457d;

    /* renamed from: e  reason: collision with root package name */
    public int f60458e;

    /* renamed from: f  reason: collision with root package name */
    public int f60459f;

    public r() {
    }

    public int a() {
        return this.f60458e;
    }

    public String b() {
        return this.f60456c;
    }

    public long c() {
        return this.f60454a;
    }

    public boolean d() {
        return this.f60457d == 1;
    }

    public int e() {
        return this.f60457d;
    }

    public String f() {
        return this.f60455b;
    }

    public int g() {
        return this.f60459f;
    }

    public void h(int i2) {
        this.f60457d = i2;
    }

    public void i(long j) {
        this.f60454a = j;
    }

    public r(VipTaskItem vipTaskItem) {
        this.f60454a = vipTaskItem.task_id.intValue();
        this.f60455b = vipTaskItem.title;
        this.f60456c = vipTaskItem.desc;
        String str = vipTaskItem.img_url;
        String str2 = vipTaskItem.link;
        this.f60457d = vipTaskItem.is_finish.intValue();
    }

    public r(PointTaskInfo pointTaskInfo) {
        if (pointTaskInfo == null) {
            return;
        }
        this.f60454a = pointTaskInfo.task_id.longValue();
        this.f60455b = pointTaskInfo.task_name;
        this.f60456c = pointTaskInfo.task_intro;
        this.f60457d = pointTaskInfo.is_finish.intValue();
        this.f60458e = pointTaskInfo.points_add.intValue();
        this.f60459f = pointTaskInfo.type.intValue();
    }
}
