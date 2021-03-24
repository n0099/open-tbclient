package d.b.i0.q1.h.a;

import tbclient.SetTail.ResData;
/* loaded from: classes3.dex */
public class f {

    /* renamed from: a  reason: collision with root package name */
    public int f59488a;

    public int a() {
        return this.f59488a;
    }

    public void b(ResData resData) {
        Long l;
        if (resData == null || (l = resData.tailId) == null) {
            return;
        }
        this.f59488a = l.intValue();
    }
}
