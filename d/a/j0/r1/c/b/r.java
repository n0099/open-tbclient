package d.a.j0.r1.c.b;

import tbclient.GetMemberTaskList.PointTaskInfo;
import tbclient.GetVipInfo.VipTaskItem;
/* loaded from: classes3.dex */
public class r {

    /* renamed from: a  reason: collision with root package name */
    public long f59586a;

    /* renamed from: b  reason: collision with root package name */
    public String f59587b;

    /* renamed from: c  reason: collision with root package name */
    public String f59588c;

    /* renamed from: d  reason: collision with root package name */
    public int f59589d;

    /* renamed from: e  reason: collision with root package name */
    public int f59590e;

    /* renamed from: f  reason: collision with root package name */
    public int f59591f;

    public r() {
    }

    public int a() {
        return this.f59590e;
    }

    public String b() {
        return this.f59588c;
    }

    public long c() {
        return this.f59586a;
    }

    public boolean d() {
        return this.f59589d == 1;
    }

    public int e() {
        return this.f59589d;
    }

    public String f() {
        return this.f59587b;
    }

    public int g() {
        return this.f59591f;
    }

    public void h(int i2) {
        this.f59589d = i2;
    }

    public void i(long j) {
        this.f59586a = j;
    }

    public r(VipTaskItem vipTaskItem) {
        this.f59586a = vipTaskItem.task_id.intValue();
        this.f59587b = vipTaskItem.title;
        this.f59588c = vipTaskItem.desc;
        String str = vipTaskItem.img_url;
        String str2 = vipTaskItem.link;
        this.f59589d = vipTaskItem.is_finish.intValue();
    }

    public r(PointTaskInfo pointTaskInfo) {
        if (pointTaskInfo == null) {
            return;
        }
        this.f59586a = pointTaskInfo.task_id.longValue();
        this.f59587b = pointTaskInfo.task_name;
        this.f59588c = pointTaskInfo.task_intro;
        this.f59589d = pointTaskInfo.is_finish.intValue();
        this.f59590e = pointTaskInfo.points_add.intValue();
        this.f59591f = pointTaskInfo.type.intValue();
    }
}
