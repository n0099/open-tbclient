package d.a.k0.u0.b;

import tbclient.GetGiftList.PresentNumInfo;
/* loaded from: classes4.dex */
public class e {

    /* renamed from: a  reason: collision with root package name */
    public int f62056a;

    /* renamed from: b  reason: collision with root package name */
    public String f62057b;

    public String a() {
        return this.f62057b;
    }

    public int b() {
        return this.f62056a;
    }

    public void c(PresentNumInfo presentNumInfo) {
        if (presentNumInfo == null) {
            return;
        }
        this.f62056a = presentNumInfo.num.intValue();
        this.f62057b = presentNumInfo.name;
    }
}
