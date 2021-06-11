package d.a.n0.v0.b;

import tbclient.GetGiftList.PresentNumInfo;
/* loaded from: classes4.dex */
public class e {

    /* renamed from: a  reason: collision with root package name */
    public int f65928a;

    /* renamed from: b  reason: collision with root package name */
    public String f65929b;

    public String a() {
        return this.f65929b;
    }

    public int b() {
        return this.f65928a;
    }

    public void c(PresentNumInfo presentNumInfo) {
        if (presentNumInfo == null) {
            return;
        }
        this.f65928a = presentNumInfo.num.intValue();
        this.f65929b = presentNumInfo.name;
    }
}
