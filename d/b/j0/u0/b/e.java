package d.b.j0.u0.b;

import tbclient.GetGiftList.PresentNumInfo;
/* loaded from: classes4.dex */
public class e {

    /* renamed from: a  reason: collision with root package name */
    public int f63122a;

    /* renamed from: b  reason: collision with root package name */
    public String f63123b;

    public String a() {
        return this.f63123b;
    }

    public int b() {
        return this.f63122a;
    }

    public void c(PresentNumInfo presentNumInfo) {
        if (presentNumInfo == null) {
            return;
        }
        this.f63122a = presentNumInfo.num.intValue();
        this.f63123b = presentNumInfo.name;
    }
}
