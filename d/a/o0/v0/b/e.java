package d.a.o0.v0.b;

import tbclient.GetGiftList.PresentNumInfo;
/* loaded from: classes4.dex */
public class e {

    /* renamed from: a  reason: collision with root package name */
    public int f66053a;

    /* renamed from: b  reason: collision with root package name */
    public String f66054b;

    public String a() {
        return this.f66054b;
    }

    public int b() {
        return this.f66053a;
    }

    public void c(PresentNumInfo presentNumInfo) {
        if (presentNumInfo == null) {
            return;
        }
        this.f66053a = presentNumInfo.num.intValue();
        this.f66054b = presentNumInfo.name;
    }
}
