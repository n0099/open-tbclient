package d.b.i0.t0.b;

import tbclient.GetGiftList.PresentNumInfo;
/* loaded from: classes4.dex */
public class e {

    /* renamed from: a  reason: collision with root package name */
    public int f61011a;

    /* renamed from: b  reason: collision with root package name */
    public String f61012b;

    public String a() {
        return this.f61012b;
    }

    public int b() {
        return this.f61011a;
    }

    public void c(PresentNumInfo presentNumInfo) {
        if (presentNumInfo == null) {
            return;
        }
        this.f61011a = presentNumInfo.num.intValue();
        this.f61012b = presentNumInfo.name;
    }
}
