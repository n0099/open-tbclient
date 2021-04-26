package d.a.j0.u0.b;

import tbclient.GetGiftList.PresentNumInfo;
/* loaded from: classes4.dex */
public class e {

    /* renamed from: a  reason: collision with root package name */
    public int f61332a;

    /* renamed from: b  reason: collision with root package name */
    public String f61333b;

    public String a() {
        return this.f61333b;
    }

    public int b() {
        return this.f61332a;
    }

    public void c(PresentNumInfo presentNumInfo) {
        if (presentNumInfo == null) {
            return;
        }
        this.f61332a = presentNumInfo.num.intValue();
        this.f61333b = presentNumInfo.name;
    }
}
