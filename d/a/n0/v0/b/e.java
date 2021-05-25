package d.a.n0.v0.b;

import tbclient.GetGiftList.PresentNumInfo;
/* loaded from: classes4.dex */
public class e {

    /* renamed from: a  reason: collision with root package name */
    public int f62213a;

    /* renamed from: b  reason: collision with root package name */
    public String f62214b;

    public String a() {
        return this.f62214b;
    }

    public int b() {
        return this.f62213a;
    }

    public void c(PresentNumInfo presentNumInfo) {
        if (presentNumInfo == null) {
            return;
        }
        this.f62213a = presentNumInfo.num.intValue();
        this.f62214b = presentNumInfo.name;
    }
}
