package d.b.i0.u0.b;

import tbclient.GetGiftList.PresentNumInfo;
/* loaded from: classes4.dex */
public class e {

    /* renamed from: a  reason: collision with root package name */
    public int f62701a;

    /* renamed from: b  reason: collision with root package name */
    public String f62702b;

    public String a() {
        return this.f62702b;
    }

    public int b() {
        return this.f62701a;
    }

    public void c(PresentNumInfo presentNumInfo) {
        if (presentNumInfo == null) {
            return;
        }
        this.f62701a = presentNumInfo.num.intValue();
        this.f62702b = presentNumInfo.name;
    }
}
