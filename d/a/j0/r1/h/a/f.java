package d.a.j0.r1.h.a;

import tbclient.SetTail.ResData;
/* loaded from: classes3.dex */
public class f {

    /* renamed from: a  reason: collision with root package name */
    public int f59757a;

    public int a() {
        return this.f59757a;
    }

    public void b(ResData resData) {
        Long l;
        if (resData == null || (l = resData.tailId) == null) {
            return;
        }
        this.f59757a = l.intValue();
    }
}
