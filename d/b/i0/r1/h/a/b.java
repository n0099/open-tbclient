package d.b.i0.r1.h.a;

import tbclient.AddTail.ResData;
/* loaded from: classes3.dex */
public class b {

    /* renamed from: a  reason: collision with root package name */
    public int f61177a;

    public int a() {
        return this.f61177a;
    }

    public void b(ResData resData) {
        Long l;
        if (resData == null || (l = resData.tailId) == null) {
            return;
        }
        this.f61177a = l.intValue();
    }
}
