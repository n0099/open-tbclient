package d.a.k0.r1.c.b;

import tbclient.GetMemberTaskList.PointTaskInfo;
import tbclient.GetVipInfo.VipTaskItem;
/* loaded from: classes3.dex */
public class r {

    /* renamed from: a  reason: collision with root package name */
    public long f60331a;

    /* renamed from: b  reason: collision with root package name */
    public String f60332b;

    /* renamed from: c  reason: collision with root package name */
    public String f60333c;

    /* renamed from: d  reason: collision with root package name */
    public int f60334d;

    /* renamed from: e  reason: collision with root package name */
    public int f60335e;

    /* renamed from: f  reason: collision with root package name */
    public int f60336f;

    public r() {
    }

    public int a() {
        return this.f60335e;
    }

    public String b() {
        return this.f60333c;
    }

    public long c() {
        return this.f60331a;
    }

    public boolean d() {
        return this.f60334d == 1;
    }

    public int e() {
        return this.f60334d;
    }

    public String f() {
        return this.f60332b;
    }

    public int g() {
        return this.f60336f;
    }

    public void h(int i2) {
        this.f60334d = i2;
    }

    public void i(long j) {
        this.f60331a = j;
    }

    public r(VipTaskItem vipTaskItem) {
        this.f60331a = vipTaskItem.task_id.intValue();
        this.f60332b = vipTaskItem.title;
        this.f60333c = vipTaskItem.desc;
        String str = vipTaskItem.img_url;
        String str2 = vipTaskItem.link;
        this.f60334d = vipTaskItem.is_finish.intValue();
    }

    public r(PointTaskInfo pointTaskInfo) {
        if (pointTaskInfo == null) {
            return;
        }
        this.f60331a = pointTaskInfo.task_id.longValue();
        this.f60332b = pointTaskInfo.task_name;
        this.f60333c = pointTaskInfo.task_intro;
        this.f60334d = pointTaskInfo.is_finish.intValue();
        this.f60335e = pointTaskInfo.points_add.intValue();
        this.f60336f = pointTaskInfo.type.intValue();
    }
}
