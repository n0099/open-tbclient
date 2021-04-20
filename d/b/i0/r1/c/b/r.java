package d.b.i0.r1.c.b;

import tbclient.GetMemberTaskList.PointTaskInfo;
import tbclient.GetVipInfo.VipTaskItem;
/* loaded from: classes3.dex */
public class r {

    /* renamed from: a  reason: collision with root package name */
    public long f61020a;

    /* renamed from: b  reason: collision with root package name */
    public String f61021b;

    /* renamed from: c  reason: collision with root package name */
    public String f61022c;

    /* renamed from: d  reason: collision with root package name */
    public int f61023d;

    /* renamed from: e  reason: collision with root package name */
    public int f61024e;

    /* renamed from: f  reason: collision with root package name */
    public int f61025f;

    public r() {
    }

    public int a() {
        return this.f61024e;
    }

    public String b() {
        return this.f61022c;
    }

    public long c() {
        return this.f61020a;
    }

    public boolean d() {
        return this.f61023d == 1;
    }

    public int e() {
        return this.f61023d;
    }

    public String f() {
        return this.f61021b;
    }

    public int g() {
        return this.f61025f;
    }

    public void h(int i) {
        this.f61023d = i;
    }

    public void i(long j) {
        this.f61020a = j;
    }

    public r(VipTaskItem vipTaskItem) {
        this.f61020a = vipTaskItem.task_id.intValue();
        this.f61021b = vipTaskItem.title;
        this.f61022c = vipTaskItem.desc;
        String str = vipTaskItem.img_url;
        String str2 = vipTaskItem.link;
        this.f61023d = vipTaskItem.is_finish.intValue();
    }

    public r(PointTaskInfo pointTaskInfo) {
        if (pointTaskInfo == null) {
            return;
        }
        this.f61020a = pointTaskInfo.task_id.longValue();
        this.f61021b = pointTaskInfo.task_name;
        this.f61022c = pointTaskInfo.task_intro;
        this.f61023d = pointTaskInfo.is_finish.intValue();
        this.f61024e = pointTaskInfo.points_add.intValue();
        this.f61025f = pointTaskInfo.type.intValue();
    }
}
