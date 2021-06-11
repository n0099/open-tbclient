package d.a.n0.s1.h.a;

import tbclient.SetTail.ResData;
/* loaded from: classes3.dex */
public class f {

    /* renamed from: a  reason: collision with root package name */
    public int f64316a;

    public int a() {
        return this.f64316a;
    }

    public void b(ResData resData) {
        Long l;
        if (resData == null || (l = resData.tailId) == null) {
            return;
        }
        this.f64316a = l.intValue();
    }
}
