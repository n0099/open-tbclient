package d.a.n0.s1.h.a;

import tbclient.UpdateTail.ResData;
/* loaded from: classes3.dex */
public class g {

    /* renamed from: a  reason: collision with root package name */
    public int f64317a;

    public int a() {
        return this.f64317a;
    }

    public void b(ResData resData) {
        Long l;
        if (resData == null || (l = resData.tailId) == null) {
            return;
        }
        this.f64317a = l.intValue();
    }
}
