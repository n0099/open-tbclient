package d.a.n0.s1.h.a;

import tbclient.AddTail.ResData;
/* loaded from: classes3.dex */
public class b {

    /* renamed from: a  reason: collision with root package name */
    public int f60619a;

    public int a() {
        return this.f60619a;
    }

    public void b(ResData resData) {
        Long l;
        if (resData == null || (l = resData.tailId) == null) {
            return;
        }
        this.f60619a = l.intValue();
    }
}
